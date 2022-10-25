package com.google.android.exoplayer2.extractor.p035ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.extractor.ts.-$$Lambda$Ac3Extractor$37aVf_b2LCldDJg5WXI_8RjtP3E  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$Ac3Extractor$37aVf_b2LCldDJg5WXI_8RjtP3E implements ExtractorsFactory {
    public static final /* synthetic */ $$Lambda$Ac3Extractor$37aVf_b2LCldDJg5WXI_8RjtP3E INSTANCE = new $$Lambda$Ac3Extractor$37aVf_b2LCldDJg5WXI_8RjtP3E();

    private /* synthetic */ $$Lambda$Ac3Extractor$37aVf_b2LCldDJg5WXI_8RjtP3E() {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public final Extractor[] createExtractors() {
        return Ac3Extractor.lambda$static$0();
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        Extractor[] createExtractors;
        createExtractors = createExtractors();
        return createExtractors;
    }
}
