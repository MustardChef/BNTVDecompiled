package khttp.structures.parameters;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;
import kotlin.text.StringsKt;

/* compiled from: Parameters.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\b\u0016\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004B1\u0012*\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00060\u0005\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0002H\u0096\u0001J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0003J\t\u0010\u001e\u001a\u00020\u0019H\u0096\u0001J\b\u0010\u001f\u001a\u00020\u0002H\u0016R$\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\n0\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR$\u0010\u0003\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, m107d2 = {"Lkhttp/structures/parameters/Parameters;", "", "", "parameters", "(Ljava/util/Map;)V", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "[Lkotlin/Pair;", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", SDKConstants.PARAM_KEY, "containsValue", "value", "get", "isEmpty", "toString", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class Parameters implements Map<String, String>, KMarkers {
    private final /* synthetic */ Map $$delegate_0;
    private final Tuples<String, String>[] parameters;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ String compute(String str, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: compute  reason: avoid collision after fix types in other method */
    public String compute2(String str, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ String computeIfAbsent(String str, Function<? super String, ? extends String> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfAbsent  reason: avoid collision after fix types in other method */
    public String computeIfAbsent2(String str, Function<? super String, ? extends String> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ String computeIfPresent(String str, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfPresent  reason: avoid collision after fix types in other method */
    public String computeIfPresent2(String str, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
        return this.$$delegate_0.entrySet();
    }

    public Set<String> getKeys() {
        return this.$$delegate_0.keySet();
    }

    public int getSize() {
        return this.$$delegate_0.size();
    }

    public Collection<String> getValues() {
        return this.$$delegate_0.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.Map
    public /* synthetic */ String merge(String str, String str2, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: merge  reason: avoid collision after fix types in other method */
    public String merge2(String str, String str2, BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ String put(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public String put2(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends String> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ String putIfAbsent(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: putIfAbsent  reason: avoid collision after fix types in other method */
    public String putIfAbsent2(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public String remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ String replace(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public String replace2(String str, String str2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ boolean replace(String str, String str2, String str3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public boolean replace2(String str, String str2, String str3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super String, ? extends String> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Parameters(Tuples<String, String>... parameters) {
        Intrinsics.checkParameterIsNotNull(parameters, "parameters");
        this.$$delegate_0 = MapsKt.mapOf((Tuples[]) Arrays.copyOf(parameters, parameters.length));
        this.parameters = parameters;
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

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<String> values() {
        return getValues();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Parameters(java.util.Map<java.lang.String, java.lang.String> r2) {
        /*
            r1 = this;
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.util.List r2 = kotlin.collections.MapsKt.toList(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L2b
            r0 = 0
            kotlin.Pair[] r0 = new kotlin.Tuples[r0]
            java.lang.Object[] r2 = r2.toArray(r0)
            if (r2 == 0) goto L23
            kotlin.Pair[] r2 = (kotlin.Tuples[]) r2
            int r0 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r0)
            kotlin.Pair[] r2 = (kotlin.Tuples[]) r2
            r1.<init>(r2)
            return
        L23:
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r2.<init>(r0)
            throw r2
        L2b:
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type java.util.Collection<T>"
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: khttp.structures.parameters.Parameters.<init>(java.util.Map):void");
    }

    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (sb.length() > 0) {
                sb.append("&");
            }
            StringsKt.append(sb, key, "=", URLEncoder.encode(value, "UTF-8"));
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
