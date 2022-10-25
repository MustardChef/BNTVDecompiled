package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zaa implements zai<Integer> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* bridge */ /* synthetic */ Integer zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        int zao;
        zao = fastParser.zao(bufferedReader);
        return Integer.valueOf(zao);
    }
}
