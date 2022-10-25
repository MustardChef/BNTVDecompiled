package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Consumer;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.source.-$$Lambda$SampleQueue$h-Fs3IL9V0TIHwUdHiPGyNB2vwM  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$SampleQueue$hFs3IL9V0TIHwUdHiPGyNB2vwM implements Consumer {
    public static final /* synthetic */ $$Lambda$SampleQueue$hFs3IL9V0TIHwUdHiPGyNB2vwM INSTANCE = new $$Lambda$SampleQueue$hFs3IL9V0TIHwUdHiPGyNB2vwM();

    private /* synthetic */ $$Lambda$SampleQueue$hFs3IL9V0TIHwUdHiPGyNB2vwM() {
    }

    @Override // com.google.android.exoplayer2.util.Consumer
    public final void accept(Object obj) {
        ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
    }
}
