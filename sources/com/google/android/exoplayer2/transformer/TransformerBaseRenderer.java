package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.MediaClock;

/* loaded from: classes2.dex */
abstract class TransformerBaseRenderer extends BaseRenderer {
    protected boolean isRendererStarted;
    protected final TransformerMediaClock mediaClock;
    protected final MuxerWrapper muxerWrapper;
    protected long streamOffsetUs;
    protected final Transformation transformation;

    public TransformerBaseRenderer(int i, MuxerWrapper muxerWrapper, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(i);
        this.muxerWrapper = muxerWrapper;
        this.mediaClock = transformerMediaClock;
        this.transformation = transformation;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] formatArr, long j, long j2) {
        this.streamOffsetUs = j2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r2.muxerWrapper.supportsSampleMimeType(r2.transformation.audioMimeType == null ? r3 : r2.transformation.audioMimeType) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r0.supportsSampleMimeType(r3) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
        return com.google.android.exoplayer2.RendererCapabilities.CC.create(4);
     */
    @Override // com.google.android.exoplayer2.RendererCapabilities
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int supportsFormat(com.google.android.exoplayer2.Format r3) {
        /*
            r2 = this;
            java.lang.String r3 = r3.sampleMimeType
            int r0 = com.google.android.exoplayer2.util.MimeTypes.getTrackType(r3)
            int r1 = r2.getTrackType()
            if (r0 == r1) goto L12
            r3 = 0
            int r3 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r3)
            return r3
        L12:
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isAudio(r3)
            if (r0 == 0) goto L2c
            com.google.android.exoplayer2.transformer.MuxerWrapper r0 = r2.muxerWrapper
            com.google.android.exoplayer2.transformer.Transformation r1 = r2.transformation
            java.lang.String r1 = r1.audioMimeType
            if (r1 != 0) goto L22
            r1 = r3
            goto L26
        L22:
            com.google.android.exoplayer2.transformer.Transformation r1 = r2.transformation
            java.lang.String r1 = r1.audioMimeType
        L26:
            boolean r0 = r0.supportsSampleMimeType(r1)
            if (r0 != 0) goto L45
        L2c:
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isVideo(r3)
            if (r0 == 0) goto L4b
            com.google.android.exoplayer2.transformer.MuxerWrapper r0 = r2.muxerWrapper
            com.google.android.exoplayer2.transformer.Transformation r1 = r2.transformation
            java.lang.String r1 = r1.videoMimeType
            if (r1 != 0) goto L3b
            goto L3f
        L3b:
            com.google.android.exoplayer2.transformer.Transformation r3 = r2.transformation
            java.lang.String r3 = r3.videoMimeType
        L3f:
            boolean r3 = r0.supportsSampleMimeType(r3)
            if (r3 == 0) goto L4b
        L45:
            r3 = 4
            int r3 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r3)
            return r3
        L4b:
            r3 = 1
            int r3 = com.google.android.exoplayer2.RendererCapabilities.CC.create(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.transformer.TransformerBaseRenderer.supportsFormat(com.google.android.exoplayer2.Format):int");
    }

    @Override // com.google.android.exoplayer2.Renderer
    public final boolean isReady() {
        return isSourceReady();
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.Renderer
    public final MediaClock getMediaClock() {
        return this.mediaClock;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected final void onEnabled(boolean z, boolean z2) {
        this.muxerWrapper.registerTrack();
        this.mediaClock.updateTimeForTrackType(getTrackType(), 0L);
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() throws ExoPlaybackException {
        this.isRendererStarted = true;
    }

    @Override // com.google.android.exoplayer2.BaseRenderer
    protected final void onStopped() {
        this.isRendererStarted = false;
    }
}
