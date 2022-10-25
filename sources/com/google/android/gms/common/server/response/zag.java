package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
final class zag implements zai<BigInteger> {
    @Override // com.google.android.gms.common.server.response.zai
    public final /* bridge */ /* synthetic */ BigInteger zaa(FastParser fastParser, BufferedReader bufferedReader) throws FastParser.ParseException, IOException {
        BigInteger zaq;
        zaq = fastParser.zaq(bufferedReader);
        return zaq;
    }
}
