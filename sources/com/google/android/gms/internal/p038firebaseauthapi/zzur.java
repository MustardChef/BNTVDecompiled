package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzur */
/* loaded from: classes3.dex */
public final class zzur {
    public static void zza(String str, zzty zztyVar, zzup zzupVar, Type type, zzuc zzucVar) {
        InputStream errorStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoOutput(true);
            byte[] bytes = zztyVar.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", AbstractSpiCall.ACCEPT_JSON_VALUE);
            zzucVar.zza(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            try {
                bufferedOutputStream.write(bytes, 0, length);
                bufferedOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (zzb(responseCode)) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            zzla.zza(th, th2);
                        }
                        throw th;
                    }
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (zzb(responseCode)) {
                    zzupVar.zzb((zztz) zztx.zza(sb2, type));
                } else {
                    zzupVar.zza((String) zztx.zza(sb2, String.class));
                }
            } catch (Throwable th3) {
                try {
                    bufferedOutputStream.close();
                } catch (Throwable th4) {
                    zzla.zza(th3, th4);
                }
                throw th3;
            }
        } catch (zzpp | IOException | JSONException e) {
            zzupVar.zza(e.getMessage());
        }
    }

    private static final boolean zzb(int i) {
        return i >= 200 && i < 300;
    }
}
