package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class DefaultMediaCodecAdapterFactory implements MediaCodecAdapter.Factory {
    private static final int MODE_DEFAULT = 0;
    private static final int MODE_DISABLED = 2;
    private static final int MODE_ENABLED = 1;
    private static final String TAG = "DefaultMediaCodecAdapterFactory";
    private int asynchronousMode = 0;
    private boolean enableImmediateCodecStartAfterFlush = true;
    private boolean enableSynchronizeCodecInteractionsWithQueueing;

    public DefaultMediaCodecAdapterFactory forceEnableAsynchronous() {
        this.asynchronousMode = 1;
        return this;
    }

    public DefaultMediaCodecAdapterFactory forceDisableAsynchronous() {
        this.asynchronousMode = 2;
        return this;
    }

    public void experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean z) {
        this.enableSynchronizeCodecInteractionsWithQueueing = z;
    }

    public void experimentalSetImmediateCodecStartAfterFlushEnabled(boolean z) {
        this.enableImmediateCodecStartAfterFlush = z;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.Factory
    public MediaCodecAdapter createAdapter(MediaCodecAdapter.Configuration configuration) throws IOException {
        if ((this.asynchronousMode == 1 && Util.SDK_INT >= 23) || (this.asynchronousMode == 0 && Util.SDK_INT >= 31)) {
            int trackType = MimeTypes.getTrackType(configuration.format.sampleMimeType);
            String valueOf = String.valueOf(Util.getTrackTypeString(trackType));
            Log.m381i(TAG, valueOf.length() != 0 ? "Creating an asynchronous MediaCodec adapter for track type ".concat(valueOf) : new String("Creating an asynchronous MediaCodec adapter for track type "));
            return new AsynchronousMediaCodecAdapter.Factory(trackType, this.enableSynchronizeCodecInteractionsWithQueueing, this.enableImmediateCodecStartAfterFlush).createAdapter(configuration);
        }
        return new SynchronousMediaCodecAdapter.Factory().createAdapter(configuration);
    }
}
