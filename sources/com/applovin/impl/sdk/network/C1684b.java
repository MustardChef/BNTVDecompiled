package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.C1767q;
import com.applovin.impl.sdk.utils.StringUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.network.b */
/* loaded from: classes.dex */
public class C1684b {

    /* renamed from: a */
    private static final List<String> f2353a = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* renamed from: b */
    private final C1662k f2354b;

    /* renamed from: c */
    private final C1710r f2355c;

    /* renamed from: d */
    private C1686b f2356d;

    /* renamed from: com.applovin.impl.sdk.network.b$a */
    /* loaded from: classes.dex */
    public static class C1685a {

        /* renamed from: a */
        private long f2357a;

        /* renamed from: b */
        private long f2358b;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m6500a(long j) {
            this.f2357a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m6497b(long j) {
            this.f2358b = j;
        }

        /* renamed from: a */
        public long m6501a() {
            return this.f2357a;
        }

        /* renamed from: b */
        public long m6498b() {
            return this.f2358b;
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.b$b */
    /* loaded from: classes.dex */
    public static class C1686b {

        /* renamed from: a */
        private final long f2359a = System.currentTimeMillis();

        /* renamed from: b */
        private final String f2360b;

        /* renamed from: c */
        private final long f2361c;

        /* renamed from: d */
        private final long f2362d;

        C1686b(String str, long j, long j2) {
            this.f2360b = str;
            this.f2361c = j;
            this.f2362d = j2;
        }

        /* renamed from: a */
        public long m6495a() {
            return this.f2359a;
        }

        /* renamed from: b */
        public String m6494b() {
            return this.f2360b;
        }

        /* renamed from: c */
        public long m6493c() {
            return this.f2361c;
        }

        /* renamed from: d */
        public long m6492d() {
            return this.f2362d;
        }

        public String toString() {
            return "RequestMeasurement{timestampMillis=" + this.f2359a + ", urlHostAndPathString='" + this.f2360b + "', responseSize=" + this.f2361c + ", connectionTimeMillis=" + this.f2362d + '}';
        }
    }

    /* renamed from: com.applovin.impl.sdk.network.b$c */
    /* loaded from: classes.dex */
    public interface InterfaceC1687c<T> {
        /* renamed from: a */
        void mo6491a(int i, String str, T t);

        /* renamed from: a */
        void mo6490a(T t, int i);
    }

    public C1684b(C1662k c1662k) {
        this.f2354b = c1662k;
        this.f2355c = c1662k.m6588z();
    }

    /* renamed from: a */
    private int m6502a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private <T> T m6506a(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != 0 && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return (T) new JSONObject(str);
            }
            if (t instanceof C1766p) {
                return (T) C1767q.m6142a(str, this.f2354b);
            }
            if (t instanceof String) {
                return str;
            }
            C1710r c1710r = this.f2355c;
            c1710r.m6314e("ConnectionManager", "Failed to process response of type '" + t.getClass().getName() + "'");
        }
        return t;
    }

    /* renamed from: a */
    private String m6507a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }

    /* renamed from: a */
    private HttpURLConnection m6503a(String str, String str2, Map<String, String> map, int i) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f2354b.m6656a(C1568b.f1777cR)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f2354b.m6656a(C1568b.f1778cS)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private void m6509a(int i, String str) {
        if (((Boolean) this.f2354b.m6656a(C1568b.f1686af)).booleanValue()) {
            try {
                C1692e.m6461a(i, str, this.f2354b.m6677J());
            } catch (Throwable th) {
                C1710r m6588z = this.f2354b.m6588z();
                m6588z.m6318b("ConnectionManager", "Failed to track response code for " + m6507a(str), th);
            }
        }
    }

    /* renamed from: a */
    private void m6505a(String str, String str2, int i, long j) {
        C1710r c1710r = this.f2355c;
        c1710r.m6317c("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1725g.m6254f(this.f2354b) + " to " + m6507a(str2));
    }

    /* renamed from: a */
    private void m6504a(String str, String str2, int i, long j, Throwable th) {
        C1710r c1710r = this.f2355c;
        c1710r.m6318b("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s over " + C1725g.m6254f(this.f2354b) + " to " + m6507a(str2), th);
    }

    /* renamed from: a */
    public C1686b m6510a() {
        return this.f2356d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0412 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v23, types: [int] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.applovin.impl.sdk.network.b] */
    /* JADX WARN: Type inference failed for: r30v0, types: [com.applovin.impl.sdk.network.b$c<T>, com.applovin.impl.sdk.network.b$c] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> void m6508a(com.applovin.impl.sdk.network.C1688c<T> r28, com.applovin.impl.sdk.network.C1684b.C1685a r29, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c<T> r30) {
        /*
            Method dump skipped, instructions count: 1169
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.C1684b.m6508a(com.applovin.impl.sdk.network.c, com.applovin.impl.sdk.network.b$a, com.applovin.impl.sdk.network.b$c):void");
    }
}
