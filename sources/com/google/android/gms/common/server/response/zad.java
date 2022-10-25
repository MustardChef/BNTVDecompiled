package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zad implements zai<Double> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* bridge */ /* synthetic */ Double zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        double zat;
        zat = fastParser.zat(bufferedReader);
        return Double.valueOf(zat);
    }
}
