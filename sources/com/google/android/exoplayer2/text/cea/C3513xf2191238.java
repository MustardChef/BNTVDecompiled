package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.text.cea.-$$Lambda$Cea708Decoder$Cea708CueInfo$Pxmft5kU-whF6SchrLmcyiHvOx8 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3513xf2191238 implements Comparator {
    public static final /* synthetic */ C3513xf2191238 INSTANCE = new C3513xf2191238();

    private /* synthetic */ C3513xf2191238() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compare;
        compare = Integer.compare(((Cea708Decoder.Cea708CueInfo) obj2).priority, ((Cea708Decoder.Cea708CueInfo) obj).priority);
        return compare;
    }
}
