package khttp.structures.cookie;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: CookieJar.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B\u001b\b\u0016\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006B\u001b\u0012\u0014\b\u0002\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u001c\u001a\u00020\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0001J\u0011\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010#\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0002H\u0096\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u0002J\t\u0010%\u001a\u00020\u001fH\u0096\u0001J\u001b\u0010&\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0096\u0001J\u001f\u0010'\u001a\u00020\u001d2\u0014\u0010(\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0096\u0001J\u0013\u0010)\u001a\u0004\u0018\u00010\u00022\u0006\u0010 \u001a\u00020\u0002H\u0096\u0001J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\bJ\b\u0010,\u001a\u00020\u0002H\u0016R\u001b\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f0\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0014\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006."}, m107d2 = {"Lkhttp/structures/cookie/CookieJar;", "", "", "cookies", "", "", "(Ljava/util/Map;)V", "", "Lkhttp/structures/cookie/Cookie;", "([Lkhttp/structures/cookie/Cookie;)V", "getCookies", "()[Lkhttp/structures/cookie/Cookie;", "[Lkhttp/structures/cookie/Cookie;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", SDKConstants.PARAM_KEY, "containsValue", "value", "get", "getCookie", "isEmpty", "put", "putAll", "from", "remove", "setCookie", "cookie", "toString", "Companion", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CookieJar implements Map<String, String>, KMutableMap {
    public static final Companion Companion = new Companion(null);
    private final /* synthetic */ HashMap $$delegate_0;
    private final Cookie[] cookies;

    public CookieJar() {
        this(null, 1, null);
    }

    @Override // java.util.Map
    public void clear() {
        this.$$delegate_0.clear();
    }

    public boolean containsKey(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.$$delegate_0.containsKey(key);
    }

    public boolean containsValue(String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        return this.$$delegate_0.containsValue(value);
    }

    public String get(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return (String) this.$$delegate_0.get(key);
    }

    public Set<Map.Entry<String, String>> getEntries() {
        Set<Map.Entry<String, String>> entrySet = this.$$delegate_0.entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "<get-entries>(...)");
        return entrySet;
    }

    public Set<String> getKeys() {
        Set<String> keySet = this.$$delegate_0.keySet();
        Intrinsics.checkExpressionValueIsNotNull(keySet, "<get-keys>(...)");
        return keySet;
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public Collection<String> getValues() {
        Collection<String> values = this.$$delegate_0.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "<get-values>(...)");
        return values;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.Map
    public String put(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        return (String) this.$$delegate_0.put(key, value);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends String> from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        this.$$delegate_0.putAll(from);
    }

    public String remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return (String) this.$$delegate_0.remove(key);
    }

    public CookieJar(Cookie... cookies) {
        Intrinsics.checkParameterIsNotNull(cookies, "cookies");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(cookies.length), 16));
        for (Cookie cookie : cookies) {
            Tuples m100to = TuplesKt.m100to(cookie.getKey(), cookie.getValueWithAttributes());
            linkedHashMap.put(m100to.getFirst(), m100to.getSecond());
        }
        this.$$delegate_0 = linkedHashMap;
        this.cookies = cookies;
    }

    public /* synthetic */ CookieJar(Cookie[] cookieArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Cookie[0] : cookieArr);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof String) {
            return containsValue((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, String>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ String get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public final Cookie[] getCookies() {
        return this.cookies;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ String remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    /* compiled from: CookieJar.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, m107d2 = {"Lkhttp/structures/cookie/CookieJar$Companion;", "", "()V", "toCookieArray", "", "Lkhttp/structures/cookie/Cookie;", "", "", "(Ljava/util/Map;)[Lkhttp/structures/cookie/Cookie;", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Cookie[] toCookieArray(Map<String, ? extends Object> map) {
            Map map2;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                List<String> split$default = StringsKt.split$default((CharSequence) entry.getValue().toString(), new String[]{";"}, false, 0, 6, (Object) null);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
                for (String str : split$default) {
                    if (str == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    arrayList2.add(StringsKt.trim((CharSequence) str).toString());
                }
                ArrayList arrayList3 = arrayList2;
                String str2 = (String) arrayList3.get(0);
                if (arrayList3.size() < 2) {
                    map2 = MapsKt.emptyMap();
                } else {
                    List<String> subList = arrayList3.subList(1, arrayList3.size());
                    LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(subList, 10)), 16));
                    for (String str3 : subList) {
                        String str4 = (String) StringsKt.split$default((CharSequence) str3, new String[]{"="}, false, 0, 6, (Object) null).get(0);
                        if (str4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        String obj = StringsKt.trim((CharSequence) str4).toString();
                        List split$default2 = StringsKt.split$default((CharSequence) str3, new String[]{"="}, false, 0, 6, (Object) null);
                        String str5 = null;
                        String str6 = split$default2.size() > 1 ? (String) split$default2.get(1) : null;
                        if (str6 != null) {
                            if (str6 == null) {
                                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                            }
                            str5 = StringsKt.trim((CharSequence) str6).toString();
                        }
                        Tuples m100to = TuplesKt.m100to(obj, str5);
                        linkedHashMap.put(m100to.getFirst(), m100to.getSecond());
                    }
                    map2 = linkedHashMap;
                }
                arrayList.add(new Cookie(entry.getKey(), str2, map2));
            }
            Object[] array = arrayList.toArray(new Cookie[0]);
            if (array != null) {
                return (Cookie[]) array;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CookieJar(java.util.Map<java.lang.String, ? extends java.lang.Object> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "cookies"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            khttp.structures.cookie.CookieJar$Companion r0 = khttp.structures.cookie.CookieJar.Companion
            khttp.structures.cookie.Cookie[] r2 = khttp.structures.cookie.CookieJar.Companion.access$toCookieArray(r0, r2)
            int r0 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r0)
            khttp.structures.cookie.Cookie[] r2 = (khttp.structures.cookie.Cookie[]) r2
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: khttp.structures.cookie.CookieJar.<init>(java.util.Map):void");
    }

    public final Cookie getCookie(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        String str = (String) get((Object) key);
        if (str != null) {
            return new Cookie(key + '=' + str);
        }
        return null;
    }

    public final void setCookie(Cookie cookie) {
        Intrinsics.checkParameterIsNotNull(cookie, "cookie");
        put((CookieJar) cookie.getKey(), cookie.getValueWithAttributes());
    }

    public String toString() {
        return ArraysKt.joinToString$default(this.cookies, "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, CookieJar$toString$1.INSTANCE, 30, (Object) null);
    }
}
