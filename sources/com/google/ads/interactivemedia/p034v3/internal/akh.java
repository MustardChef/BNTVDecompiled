package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akh */
/* loaded from: classes2.dex */
final class akh implements aki {
    private akh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ akh(byte[] bArr) {
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00ca: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:51:0x00ca */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.aki
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br mo5109a(com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq r9) {
        /*
            r8 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La1
            java.lang.String r2 = r9.url()     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La1
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La1
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La1
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La1
            java.lang.String r0 = "User-Agent"
            java.lang.String r2 = r9.userAgent()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            r1.setRequestProperty(r0, r2)     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            int r0 = r9.connectionTimeoutMs()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            r1.setConnectTimeout(r0)     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            int r0 = r9.readTimeoutMs()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            r1.setReadTimeout(r0)     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            com.google.ads.interactivemedia.v3.impl.data.bp r0 = r9.requestType()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            com.google.ads.interactivemedia.v3.impl.data.bp r2 = com.google.ads.interactivemedia.p034v3.impl.data.EnumC2498bp.POST     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            if (r0 != r2) goto L57
            r0 = 1
            r1.setDoOutput(r0)     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            r0 = 0
            r1.setChunkedStreamingMode(r0)     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            java.lang.String r0 = r9.content()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            if (r0 == 0) goto L57
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L50
            byte[] r0 = r0.getBytes(r3)     // Catch: java.lang.Throwable -> L50
            r2.write(r0)     // Catch: java.lang.Throwable -> L50
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            goto L57
        L50:
            r0 = move-exception
            if (r2 == 0) goto L56
            r2.close()     // Catch: java.lang.Throwable -> L56
        L56:
            throw r0     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
        L57:
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L96
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L96
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r3.<init>()     // Catch: java.lang.Throwable -> L96
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L96
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L96
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Throwable -> L96
            r5.<init>(r2, r6)     // Catch: java.lang.Throwable -> L96
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L96
        L71:
            java.lang.String r2 = r4.readLine()     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L7b
            r3.append(r2)     // Catch: java.lang.Throwable -> L96
            goto L71
        L7b:
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L96
            if (r0 == 0) goto L84
            r0.close()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
        L84:
            java.lang.String r0 = r1.getContentType()     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
            if (r1 == 0) goto L8d
            r1.disconnect()
        L8d:
            java.lang.String r9 = r9.mo6002id()
            com.google.ads.interactivemedia.v3.impl.data.br r9 = com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br.forResponse(r9, r2, r0)
            return r9
        L96:
            r2 = move-exception
            if (r0 == 0) goto L9c
            r0.close()     // Catch: java.lang.Throwable -> L9c
        L9c:
            throw r2     // Catch: java.io.IOException -> L9d java.lang.Throwable -> Lc9
        L9d:
            r0 = move-exception
            goto La5
        L9f:
            r9 = move-exception
            goto Lcb
        La1:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        La5:
            boolean r0 = r0 instanceof java.net.SocketTimeoutException     // Catch: java.lang.Throwable -> Lc9
            if (r0 == 0) goto Lb9
            java.lang.String r9 = r9.mo6002id()     // Catch: java.lang.Throwable -> Lc9
            r0 = 101(0x65, float:1.42E-43)
            com.google.ads.interactivemedia.v3.impl.data.br r9 = com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br.forError(r9, r0)     // Catch: java.lang.Throwable -> Lc9
            if (r1 == 0) goto Lb8
            r1.disconnect()
        Lb8:
            return r9
        Lb9:
            java.lang.String r9 = r9.mo6002id()     // Catch: java.lang.Throwable -> Lc9
            r0 = 100
            com.google.ads.interactivemedia.v3.impl.data.br r9 = com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br.forError(r9, r0)     // Catch: java.lang.Throwable -> Lc9
            if (r1 == 0) goto Lc8
            r1.disconnect()
        Lc8:
            return r9
        Lc9:
            r9 = move-exception
            r0 = r1
        Lcb:
            if (r0 == 0) goto Ld0
            r0.disconnect()
        Ld0:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.akh.mo5109a(com.google.ads.interactivemedia.v3.impl.data.bq):com.google.ads.interactivemedia.v3.impl.data.br");
    }
}
