package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class FrameworkMuxer implements Muxer {
    private final MediaCodec.BufferInfo bufferInfo;
    private boolean isStarted;
    private final MediaMuxer mediaMuxer;

    /* loaded from: classes2.dex */
    public static final class Factory implements Muxer.Factory {
        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public FrameworkMuxer create(String str, String str2) throws IOException {
            return new FrameworkMuxer(new MediaMuxer(str, FrameworkMuxer.mimeTypeToMuxerOutputFormat(str2)));
        }

        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public FrameworkMuxer create(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
            return new FrameworkMuxer(new MediaMuxer(parcelFileDescriptor.getFileDescriptor(), FrameworkMuxer.mimeTypeToMuxerOutputFormat(str)));
        }

        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public boolean supportsOutputMimeType(String str) {
            try {
                FrameworkMuxer.mimeTypeToMuxerOutputFormat(str);
                return true;
            } catch (IllegalStateException unused) {
                return false;
            }
        }

        @Override // com.google.android.exoplayer2.transformer.Muxer.Factory
        public boolean supportsSampleMimeType(String str, String str2) {
            boolean isAudio = MimeTypes.isAudio(str);
            boolean isVideo = MimeTypes.isVideo(str);
            if (str2.equals(MimeTypes.VIDEO_MP4)) {
                if (isVideo) {
                    if (MimeTypes.VIDEO_H263.equals(str) || MimeTypes.VIDEO_H264.equals(str) || MimeTypes.VIDEO_MP4V.equals(str)) {
                        return true;
                    }
                    return Util.SDK_INT >= 24 && MimeTypes.VIDEO_H265.equals(str);
                } else if (isAudio) {
                    return MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_AMR_NB.equals(str) || MimeTypes.AUDIO_AMR_WB.equals(str);
                }
            } else if (str2.equals(MimeTypes.VIDEO_WEBM) && Util.SDK_INT >= 21) {
                if (isVideo) {
                    if (MimeTypes.VIDEO_VP8.equals(str)) {
                        return true;
                    }
                    return Util.SDK_INT >= 24 && MimeTypes.VIDEO_VP9.equals(str);
                } else if (isAudio) {
                    return MimeTypes.AUDIO_VORBIS.equals(str);
                }
            }
            return false;
        }
    }

    private FrameworkMuxer(MediaMuxer mediaMuxer) {
        this.mediaMuxer = mediaMuxer;
        this.bufferInfo = new MediaCodec.BufferInfo();
    }

    @Override // com.google.android.exoplayer2.transformer.Muxer
    public int addTrack(Format format) {
        MediaFormat createVideoFormat;
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        if (MimeTypes.isAudio(str)) {
            createVideoFormat = MediaFormat.createAudioFormat((String) Util.castNonNull(str), format.sampleRate, format.channelCount);
        } else {
            createVideoFormat = MediaFormat.createVideoFormat((String) Util.castNonNull(str), format.width, format.height);
            this.mediaMuxer.setOrientationHint(format.rotationDegrees);
        }
        MediaFormatUtil.setCsdBuffers(createVideoFormat, format.initializationData);
        return this.mediaMuxer.addTrack(createVideoFormat);
    }

    @Override // com.google.android.exoplayer2.transformer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, boolean z, long j) {
        if (!this.isStarted) {
            this.isStarted = true;
            this.mediaMuxer.start();
        }
        int position = byteBuffer.position();
        this.bufferInfo.set(position, byteBuffer.limit() - position, j, z ? 1 : 0);
        this.mediaMuxer.writeSampleData(i, byteBuffer, this.bufferInfo);
    }

    @Override // com.google.android.exoplayer2.transformer.Muxer
    public void release(boolean z) {
        if (this.isStarted) {
            this.isStarted = false;
            try {
                try {
                    this.mediaMuxer.stop();
                } catch (IllegalStateException e) {
                    if (Util.SDK_INT < 30) {
                        try {
                            Field declaredField = MediaMuxer.class.getDeclaredField("MUXER_STATE_STOPPED");
                            declaredField.setAccessible(true);
                            int intValue = ((Integer) Util.castNonNull((Integer) declaredField.get(this.mediaMuxer))).intValue();
                            Field declaredField2 = MediaMuxer.class.getDeclaredField("mState");
                            declaredField2.setAccessible(true);
                            declaredField2.set(this.mediaMuxer, Integer.valueOf(intValue));
                        } catch (Exception unused) {
                        }
                    }
                    if (!z) {
                        throw e;
                    }
                }
            } finally {
                this.mediaMuxer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mimeTypeToMuxerOutputFormat(String str) {
        if (str.equals(MimeTypes.VIDEO_MP4)) {
            return 0;
        }
        if (Util.SDK_INT < 21 || !str.equals(MimeTypes.VIDEO_WEBM)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported output MIME type: ".concat(valueOf) : new String("Unsupported output MIME type: "));
        }
        return 1;
    }
}
