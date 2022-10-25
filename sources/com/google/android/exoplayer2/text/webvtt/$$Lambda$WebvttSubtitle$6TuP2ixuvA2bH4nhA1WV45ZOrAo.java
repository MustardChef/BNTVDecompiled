package com.google.android.exoplayer2.text.webvtt;

import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.text.webvtt.-$$Lambda$WebvttSubtitle$6TuP2ixuvA2bH4nhA1WV45ZOrAo  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$WebvttSubtitle$6TuP2ixuvA2bH4nhA1WV45ZOrAo implements Comparator {
    public static final /* synthetic */ $$Lambda$WebvttSubtitle$6TuP2ixuvA2bH4nhA1WV45ZOrAo INSTANCE = new $$Lambda$WebvttSubtitle$6TuP2ixuvA2bH4nhA1WV45ZOrAo();

    private /* synthetic */ $$Lambda$WebvttSubtitle$6TuP2ixuvA2bH4nhA1WV45ZOrAo() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = Long.compare(((WebvttCueInfo) obj).startTimeUs, ((WebvttCueInfo) obj2).startTimeUs);
        return compare;
    }
}
