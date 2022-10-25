package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zah implements zai<BigDecimal> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* bridge */ /* synthetic */ BigDecimal zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        BigDecimal zau;
        zau = fastParser.zau(bufferedReader);
        return zau;
    }
}
