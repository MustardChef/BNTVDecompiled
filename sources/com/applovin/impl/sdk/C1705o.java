package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.sdk.o */
/* loaded from: classes.dex */
public class C1705o {

    /* renamed from: a */
    private final String f2438a = UUID.randomUUID().toString();

    /* renamed from: b */
    private final String f2439b;

    /* renamed from: c */
    private final Map<String, Object> f2440c;

    /* renamed from: d */
    private final long f2441d;

    public C1705o(String str, Map<String, String> map, Map<String, Object> map2) {
        this.f2439b = str;
        HashMap hashMap = new HashMap();
        this.f2440c = hashMap;
        hashMap.putAll(map);
        hashMap.put("applovin_sdk_super_properties", map2);
        this.f2441d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public String m6360a() {
        return this.f2439b;
    }

    /* renamed from: b */
    public Map<String, Object> m6359b() {
        return this.f2440c;
    }

    /* renamed from: c */
    public long m6358c() {
        return this.f2441d;
    }

    /* renamed from: d */
    public String m6357d() {
        return this.f2438a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1705o c1705o = (C1705o) obj;
        if (this.f2441d != c1705o.f2441d) {
            return false;
        }
        String str = this.f2439b;
        if (str == null ? c1705o.f2439b == null : str.equals(c1705o.f2439b)) {
            Map<String, Object> map = this.f2440c;
            if (map == null ? c1705o.f2440c == null : map.equals(c1705o.f2440c)) {
                String str2 = this.f2438a;
                String str3 = c1705o.f2438a;
                if (str2 != null) {
                    if (str2.equals(str3)) {
                        return true;
                    }
                } else if (str3 == null) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2439b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Object> map = this.f2440c;
        int hashCode2 = map != null ? map.hashCode() : 0;
        long j = this.f2441d;
        int i = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f2438a;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.f2439b + "', id='" + this.f2438a + "', creationTimestampMillis=" + this.f2441d + ", parameters=" + this.f2440c + '}';
    }
}
