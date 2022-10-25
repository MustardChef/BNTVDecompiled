package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = $$Lambda$ExtractorsFactory$o_gIUR5jujw02TI2JTJnjPE9hgU.INSTANCE;

    Extractor[] createExtractors();

    Extractor[] createExtractors(Uri uri, Map<String, List<String>> map);

    /* renamed from: com.google.android.exoplayer2.extractor.ExtractorsFactory$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Extractor[] lambda$static$0() {
            return new Extractor[0];
        }
    }
}
