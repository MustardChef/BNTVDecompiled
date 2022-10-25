package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.SonicAudioProcessor;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
final class TransformerAudioRenderer extends TransformerBaseRenderer {
    private static final int DEFAULT_ENCODER_BITRATE = 131072;
    private static final float SPEED_UNSET = -1.0f;
    private static final String TAG = "TransformerAudioRenderer";
    private float currentSpeed;
    private MediaCodecAdapterWrapper decoder;
    private final DecoderInputBuffer decoderInputBuffer;
    private Format decoderInputFormat;
    private boolean drainingSonicForSpeedChange;
    private MediaCodecAdapterWrapper encoder;
    private AudioProcessor.AudioFormat encoderInputAudioFormat;
    private final DecoderInputBuffer encoderInputBuffer;
    private boolean hasEncoderOutputFormat;
    private boolean muxerWrapperTrackEnded;
    private long nextEncoderInputBufferTimeUs;
    private final SonicAudioProcessor sonicAudioProcessor;
    private ByteBuffer sonicOutputBuffer;
    private SpeedProvider speedProvider;

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return TAG;
    }

    public TransformerAudioRenderer(MuxerWrapper muxerWrapper, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(1, muxerWrapper, transformerMediaClock, transformation);
        this.decoderInputBuffer = new DecoderInputBuffer(0);
        this.encoderInputBuffer = new DecoderInputBuffer(0);
        this.sonicAudioProcessor = new SonicAudioProcessor();
        this.sonicOutputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.nextEncoderInputBufferTimeUs = 0L;
        this.currentSpeed = -1.0f;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.muxerWrapperTrackEnded;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        this.decoderInputBuffer.clear();
        this.decoderInputBuffer.data = null;
        this.encoderInputBuffer.clear();
        this.encoderInputBuffer.data = null;
        this.sonicAudioProcessor.reset();
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper = this.decoder;
        if (mediaCodecAdapterWrapper != null) {
            mediaCodecAdapterWrapper.release();
            this.decoder = null;
        }
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper2 = this.encoder;
        if (mediaCodecAdapterWrapper2 != null) {
            mediaCodecAdapterWrapper2.release();
            this.encoder = null;
        }
        this.speedProvider = null;
        this.sonicOutputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.nextEncoderInputBufferTimeUs = 0L;
        this.currentSpeed = -1.0f;
        this.muxerWrapperTrackEnded = false;
        this.hasEncoderOutputFormat = false;
        this.drainingSonicForSpeedChange = false;
    }

    @Override // com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        if (this.isRendererStarted && !isEnded() && ensureDecoderConfigured()) {
            MediaCodecAdapterWrapper mediaCodecAdapterWrapper = this.decoder;
            if (ensureEncoderAndAudioProcessingConfigured()) {
                MediaCodecAdapterWrapper mediaCodecAdapterWrapper2 = this.encoder;
                do {
                } while (feedMuxerFromEncoder(mediaCodecAdapterWrapper2));
                if (this.sonicAudioProcessor.isActive()) {
                    do {
                    } while (feedEncoderFromSonic(mediaCodecAdapterWrapper, mediaCodecAdapterWrapper2));
                    do {
                    } while (feedSonicFromDecoder(mediaCodecAdapterWrapper));
                } else {
                    do {
                    } while (feedEncoderFromDecoder(mediaCodecAdapterWrapper, mediaCodecAdapterWrapper2));
                }
                do {
                } while (feedDecoderFromInput(mediaCodecAdapterWrapper));
            }
            do {
            } while (feedDecoderFromInput(mediaCodecAdapterWrapper));
        }
    }

    private boolean feedMuxerFromEncoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper) {
        if (!this.hasEncoderOutputFormat) {
            Format outputFormat = mediaCodecAdapterWrapper.getOutputFormat();
            if (outputFormat == null) {
                return false;
            }
            this.hasEncoderOutputFormat = true;
            this.muxerWrapper.addTrackFormat(outputFormat);
        }
        if (mediaCodecAdapterWrapper.isEnded()) {
            this.muxerWrapper.endTrack(getTrackType());
            this.muxerWrapperTrackEnded = true;
            return false;
        }
        ByteBuffer outputBuffer = mediaCodecAdapterWrapper.getOutputBuffer();
        if (outputBuffer != null && this.muxerWrapper.writeSample(getTrackType(), outputBuffer, true, ((MediaCodec.BufferInfo) Assertions.checkNotNull(mediaCodecAdapterWrapper.getOutputBufferInfo())).presentationTimeUs)) {
            mediaCodecAdapterWrapper.releaseOutputBuffer();
            return true;
        }
        return false;
    }

    @RequiresNonNull({"encoderInputAudioFormat"})
    private boolean feedEncoderFromDecoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper, MediaCodecAdapterWrapper mediaCodecAdapterWrapper2) {
        if (mediaCodecAdapterWrapper2.maybeDequeueInputBuffer(this.encoderInputBuffer)) {
            if (mediaCodecAdapterWrapper.isEnded()) {
                queueEndOfStreamToEncoder(mediaCodecAdapterWrapper2);
                return false;
            }
            ByteBuffer outputBuffer = mediaCodecAdapterWrapper.getOutputBuffer();
            if (outputBuffer == null) {
                return false;
            }
            if (isSpeedChanging((MediaCodec.BufferInfo) Assertions.checkNotNull(mediaCodecAdapterWrapper.getOutputBufferInfo()))) {
                flushSonicAndSetSpeed(this.currentSpeed);
                return false;
            }
            feedEncoder(mediaCodecAdapterWrapper2, outputBuffer);
            if (outputBuffer.hasRemaining()) {
                return true;
            }
            mediaCodecAdapterWrapper.releaseOutputBuffer();
            return true;
        }
        return false;
    }

    @RequiresNonNull({"encoderInputAudioFormat"})
    private boolean feedEncoderFromSonic(MediaCodecAdapterWrapper mediaCodecAdapterWrapper, MediaCodecAdapterWrapper mediaCodecAdapterWrapper2) {
        if (mediaCodecAdapterWrapper2.maybeDequeueInputBuffer(this.encoderInputBuffer)) {
            if (!this.sonicOutputBuffer.hasRemaining()) {
                ByteBuffer output = this.sonicAudioProcessor.getOutput();
                this.sonicOutputBuffer = output;
                if (!output.hasRemaining()) {
                    if (mediaCodecAdapterWrapper.isEnded() && this.sonicAudioProcessor.isEnded()) {
                        queueEndOfStreamToEncoder(mediaCodecAdapterWrapper2);
                    }
                    return false;
                }
            }
            feedEncoder(mediaCodecAdapterWrapper2, this.sonicOutputBuffer);
            return true;
        }
        return false;
    }

    private boolean feedSonicFromDecoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper) {
        if (this.drainingSonicForSpeedChange) {
            if (this.sonicAudioProcessor.isEnded() && !this.sonicOutputBuffer.hasRemaining()) {
                flushSonicAndSetSpeed(this.currentSpeed);
                this.drainingSonicForSpeedChange = false;
            }
            return false;
        } else if (this.sonicOutputBuffer.hasRemaining()) {
            return false;
        } else {
            if (mediaCodecAdapterWrapper.isEnded()) {
                this.sonicAudioProcessor.queueEndOfStream();
                return false;
            }
            Assertions.checkState(!this.sonicAudioProcessor.isEnded());
            ByteBuffer outputBuffer = mediaCodecAdapterWrapper.getOutputBuffer();
            if (outputBuffer == null) {
                return false;
            }
            if (isSpeedChanging((MediaCodec.BufferInfo) Assertions.checkNotNull(mediaCodecAdapterWrapper.getOutputBufferInfo()))) {
                this.sonicAudioProcessor.queueEndOfStream();
                this.drainingSonicForSpeedChange = true;
                return false;
            }
            this.sonicAudioProcessor.queueInput(outputBuffer);
            if (!outputBuffer.hasRemaining()) {
                mediaCodecAdapterWrapper.releaseOutputBuffer();
            }
            return true;
        }
    }

    private boolean feedDecoderFromInput(MediaCodecAdapterWrapper mediaCodecAdapterWrapper) {
        if (mediaCodecAdapterWrapper.maybeDequeueInputBuffer(this.decoderInputBuffer)) {
            this.decoderInputBuffer.clear();
            int readSource = readSource(getFormatHolder(), this.decoderInputBuffer, 0);
            if (readSource != -5) {
                if (readSource != -4) {
                    return false;
                }
                this.mediaClock.updateTimeForTrackType(getTrackType(), this.decoderInputBuffer.timeUs);
                this.decoderInputBuffer.timeUs -= this.streamOffsetUs;
                this.decoderInputBuffer.flip();
                mediaCodecAdapterWrapper.queueInputBuffer(this.decoderInputBuffer);
                return !this.decoderInputBuffer.isEndOfStream();
            }
            throw new IllegalStateException("Format changes are not supported.");
        }
        return false;
    }

    @RequiresNonNull({"encoderInputAudioFormat"})
    private void feedEncoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper, ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = (ByteBuffer) Assertions.checkNotNull(this.encoderInputBuffer.data);
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + byteBuffer2.capacity()));
        byteBuffer2.put(byteBuffer);
        this.encoderInputBuffer.timeUs = this.nextEncoderInputBufferTimeUs;
        this.nextEncoderInputBufferTimeUs += getBufferDurationUs(byteBuffer2.position(), this.encoderInputAudioFormat.bytesPerFrame, this.encoderInputAudioFormat.sampleRate);
        this.encoderInputBuffer.setFlags(0);
        this.encoderInputBuffer.flip();
        byteBuffer.limit(limit);
        mediaCodecAdapterWrapper.queueInputBuffer(this.encoderInputBuffer);
    }

    private void queueEndOfStreamToEncoder(MediaCodecAdapterWrapper mediaCodecAdapterWrapper) {
        Assertions.checkState(((ByteBuffer) Assertions.checkNotNull(this.encoderInputBuffer.data)).position() == 0);
        this.encoderInputBuffer.timeUs = this.nextEncoderInputBufferTimeUs;
        this.encoderInputBuffer.addFlag(4);
        this.encoderInputBuffer.flip();
        mediaCodecAdapterWrapper.queueInputBuffer(this.encoderInputBuffer);
    }

    @EnsuresNonNullIf(expression = {"encoder", "encoderInputAudioFormat"}, result = true)
    @RequiresNonNull({"decoder", "decoderInputFormat"})
    private boolean ensureEncoderAndAudioProcessingConfigured() throws ExoPlaybackException {
        String str;
        if (this.encoder == null || this.encoderInputAudioFormat == null) {
            Format outputFormat = this.decoder.getOutputFormat();
            if (outputFormat == null) {
                return false;
            }
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(outputFormat.sampleRate, outputFormat.channelCount, outputFormat.pcmEncoding);
            if (this.transformation.flattenForSlowMotion) {
                try {
                    audioFormat = this.sonicAudioProcessor.configure(audioFormat);
                    flushSonicAndSetSpeed(this.currentSpeed);
                } catch (AudioProcessor.UnhandledAudioFormatException e) {
                    throw createRendererException(e, 1000);
                }
            }
            if (this.transformation.audioMimeType == null) {
                str = this.decoderInputFormat.sampleMimeType;
            } else {
                str = this.transformation.audioMimeType;
            }
            try {
                this.encoder = MediaCodecAdapterWrapper.createForAudioEncoding(new Format.Builder().setSampleMimeType(str).setSampleRate(audioFormat.sampleRate).setChannelCount(audioFormat.channelCount).setAverageBitrate(131072).build());
                this.encoderInputAudioFormat = audioFormat;
                return true;
            } catch (IOException e2) {
                throw createRendererException(e2, 1000);
            }
        }
        return true;
    }

    @EnsuresNonNullIf(expression = {"decoderInputFormat", "decoder"}, result = true)
    private boolean ensureDecoderConfigured() throws ExoPlaybackException {
        if (this.decoder == null || this.decoderInputFormat == null) {
            FormatHolder formatHolder = getFormatHolder();
            if (readSource(formatHolder, this.decoderInputBuffer, 2) != -5) {
                return false;
            }
            Format format = (Format) Assertions.checkNotNull(formatHolder.format);
            this.decoderInputFormat = format;
            try {
                MediaCodecAdapterWrapper createForAudioDecoding = MediaCodecAdapterWrapper.createForAudioDecoding(format);
                SegmentSpeedProvider segmentSpeedProvider = new SegmentSpeedProvider(this.decoderInputFormat);
                this.speedProvider = segmentSpeedProvider;
                this.currentSpeed = segmentSpeedProvider.getSpeed(0L);
                this.decoder = createForAudioDecoding;
                return true;
            } catch (IOException e) {
                throw createRendererException(e, 1000);
            }
        }
        return true;
    }

    private boolean isSpeedChanging(MediaCodec.BufferInfo bufferInfo) {
        if (this.transformation.flattenForSlowMotion) {
            float speed = ((SpeedProvider) Assertions.checkNotNull(this.speedProvider)).getSpeed(bufferInfo.presentationTimeUs);
            boolean z = speed != this.currentSpeed;
            this.currentSpeed = speed;
            return z;
        }
        return false;
    }

    private void flushSonicAndSetSpeed(float f) {
        this.sonicAudioProcessor.setSpeed(f);
        this.sonicAudioProcessor.setPitch(f);
        this.sonicAudioProcessor.flush();
    }

    private ExoPlaybackException createRendererException(Throwable th, int i) {
        return ExoPlaybackException.createForRenderer(th, TAG, getIndex(), this.decoderInputFormat, 4, false, i);
    }

    private static long getBufferDurationUs(long j, int i, int i2) {
        return ((j / i) * 1000000) / i2;
    }
}
