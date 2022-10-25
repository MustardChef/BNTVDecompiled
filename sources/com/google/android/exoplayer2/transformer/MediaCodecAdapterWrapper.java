package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* loaded from: classes2.dex */
final class MediaCodecAdapterWrapper {
    private static final int MEDIA_CODEC_PCM_ENCODING = 2;
    private final MediaCodecAdapter codec;
    private boolean inputStreamEnded;
    private ByteBuffer outputBuffer;
    private Format outputFormat;
    private boolean outputStreamEnded;
    private final MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();
    private int inputBufferIndex = -1;
    private int outputBufferIndex = -1;

    /* loaded from: classes2.dex */
    private static class Factory extends SynchronousMediaCodecAdapter.Factory {
        private Factory() {
        }

        @Override // com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter.Factory
        protected MediaCodec createCodec(MediaCodecAdapter.Configuration configuration) throws IOException {
            String str = (String) Assertions.checkNotNull(configuration.mediaFormat.getString("mime"));
            if ((configuration.flags & 1) == 0) {
                return MediaCodec.createDecoderByType((String) Assertions.checkNotNull(str));
            }
            return MediaCodec.createEncoderByType((String) Assertions.checkNotNull(str));
        }
    }

    private static MediaCodecInfo createPlaceholderMediaCodecInfo() {
        return MediaCodecInfo.newInstance("name-placeholder", "mime-type-placeholder", "mime-type-placeholder", null, false, false, false, false, false);
    }

    public static MediaCodecAdapterWrapper createForAudioDecoding(Format format) throws IOException {
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.sampleRate, format.channelCount);
            MediaFormatUtil.maybeSetInteger(createAudioFormat, "max-input-size", format.maxInputSize);
            MediaFormatUtil.setCsdBuffers(createAudioFormat, format.initializationData);
            mediaCodecAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForAudioDecoding(createPlaceholderMediaCodecInfo(), createAudioFormat, format, null));
            return new MediaCodecAdapterWrapper(mediaCodecAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForVideoDecoding(Format format, Surface surface) throws IOException {
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.width, format.height);
            MediaFormatUtil.maybeSetInteger(createVideoFormat, "max-input-size", format.maxInputSize);
            MediaFormatUtil.setCsdBuffers(createVideoFormat, format.initializationData);
            mediaCodecAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForVideoDecoding(createPlaceholderMediaCodecInfo(), createVideoFormat, format, surface, null));
            return new MediaCodecAdapterWrapper(mediaCodecAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForAudioEncoding(Format format) throws IOException {
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.sampleRate, format.channelCount);
            createAudioFormat.setInteger("bitrate", format.bitrate);
            mediaCodecAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForAudioEncoding(createPlaceholderMediaCodecInfo(), createAudioFormat, format));
            return new MediaCodecAdapterWrapper(mediaCodecAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
            }
            throw e;
        }
    }

    public static MediaCodecAdapterWrapper createForVideoEncoding(Format format, Map<String, Integer> map) throws IOException {
        Assertions.checkArgument(format.width != -1);
        Assertions.checkArgument(format.height != -1);
        MediaCodecAdapter mediaCodecAdapter = null;
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat((String) Assertions.checkNotNull(format.sampleMimeType), format.width, format.height);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("i-frame-interval", 1);
            createVideoFormat.setInteger("bitrate", 413000);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                createVideoFormat.setInteger(entry.getKey(), entry.getValue().intValue());
            }
            mediaCodecAdapter = new Factory().createAdapter(MediaCodecAdapter.Configuration.createForVideoEncoding(createPlaceholderMediaCodecInfo(), createVideoFormat, format));
            return new MediaCodecAdapterWrapper(mediaCodecAdapter);
        } catch (Exception e) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.release();
            }
            throw e;
        }
    }

    private MediaCodecAdapterWrapper(MediaCodecAdapter mediaCodecAdapter) {
        this.codec = mediaCodecAdapter;
    }

    public Surface getInputSurface() {
        return this.codec.getInputSurface();
    }

    @EnsuresNonNullIf(expression = {"#1.data"}, result = true)
    public boolean maybeDequeueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (this.inputStreamEnded) {
            return false;
        }
        if (this.inputBufferIndex < 0) {
            int dequeueInputBufferIndex = this.codec.dequeueInputBufferIndex();
            this.inputBufferIndex = dequeueInputBufferIndex;
            if (dequeueInputBufferIndex < 0) {
                return false;
            }
            decoderInputBuffer.data = this.codec.getInputBuffer(dequeueInputBufferIndex);
            decoderInputBuffer.clear();
        }
        Assertions.checkNotNull(decoderInputBuffer.data);
        return true;
    }

    public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        int i;
        int i2;
        int i3;
        Assertions.checkState(!this.inputStreamEnded, "Input buffer can not be queued after the input stream has ended.");
        if (decoderInputBuffer.data == null || !decoderInputBuffer.data.hasRemaining()) {
            i = 0;
            i2 = 0;
        } else {
            i = decoderInputBuffer.data.position();
            i2 = decoderInputBuffer.data.remaining();
        }
        if (decoderInputBuffer.isEndOfStream()) {
            this.inputStreamEnded = true;
            i3 = 4;
        } else {
            i3 = 0;
        }
        this.codec.queueInputBuffer(this.inputBufferIndex, i, i2, decoderInputBuffer.timeUs, i3);
        this.inputBufferIndex = -1;
        decoderInputBuffer.data = null;
    }

    public void signalEndOfInputStream() {
        this.codec.signalEndOfInputStream();
    }

    public Format getOutputFormat() {
        maybeDequeueOutputBuffer();
        return this.outputFormat;
    }

    public ByteBuffer getOutputBuffer() {
        if (maybeDequeueAndSetOutputBuffer()) {
            return this.outputBuffer;
        }
        return null;
    }

    public MediaCodec.BufferInfo getOutputBufferInfo() {
        if (maybeDequeueOutputBuffer()) {
            return this.outputBufferInfo;
        }
        return null;
    }

    public void releaseOutputBuffer() {
        releaseOutputBuffer(false);
    }

    public void releaseOutputBuffer(boolean z) {
        this.outputBuffer = null;
        this.codec.releaseOutputBuffer(this.outputBufferIndex, z);
        this.outputBufferIndex = -1;
    }

    public boolean isEnded() {
        return this.outputStreamEnded && this.outputBufferIndex == -1;
    }

    public void release() {
        this.outputBuffer = null;
        this.codec.release();
    }

    private boolean maybeDequeueAndSetOutputBuffer() {
        if (maybeDequeueOutputBuffer()) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(this.codec.getOutputBuffer(this.outputBufferIndex));
            this.outputBuffer = byteBuffer;
            byteBuffer.position(this.outputBufferInfo.offset);
            this.outputBuffer.limit(this.outputBufferInfo.offset + this.outputBufferInfo.size);
            return true;
        }
        return false;
    }

    private boolean maybeDequeueOutputBuffer() {
        if (this.outputBufferIndex >= 0) {
            return true;
        }
        if (this.outputStreamEnded) {
            return false;
        }
        int dequeueOutputBufferIndex = this.codec.dequeueOutputBufferIndex(this.outputBufferInfo);
        this.outputBufferIndex = dequeueOutputBufferIndex;
        if (dequeueOutputBufferIndex < 0) {
            if (dequeueOutputBufferIndex == -2) {
                this.outputFormat = getFormat(this.codec.getOutputFormat());
            }
            return false;
        }
        if ((this.outputBufferInfo.flags & 4) != 0) {
            this.outputStreamEnded = true;
            if (this.outputBufferInfo.size == 0) {
                releaseOutputBuffer();
                return false;
            }
        }
        if ((this.outputBufferInfo.flags & 2) != 0) {
            releaseOutputBuffer();
            return false;
        }
        return true;
    }

    private static Format getFormat(MediaFormat mediaFormat) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                break;
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            builder.add((ImmutableList.Builder) bArr);
            i++;
        }
        String string = mediaFormat.getString("mime");
        Format.Builder initializationData = new Format.Builder().setSampleMimeType(mediaFormat.getString("mime")).setInitializationData(builder.build());
        if (MimeTypes.isVideo(string)) {
            initializationData.setWidth(mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)).setHeight(mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
        } else if (MimeTypes.isAudio(string)) {
            initializationData.setChannelCount(mediaFormat.getInteger("channel-count")).setSampleRate(mediaFormat.getInteger("sample-rate")).setPcmEncoding(2);
        }
        return initializationData.build();
    }
}
