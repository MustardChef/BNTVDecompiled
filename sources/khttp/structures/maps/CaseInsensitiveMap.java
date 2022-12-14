package khttp.structures.maps;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;
import kotlin.text.StringsKt;

/* compiled from: CaseInsensitiveMap.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0016\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0016H\u0096\u0001J\b\u0010\u001e\u001a\u00020\u0003H\u0016R$\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, m107d2 = {"Lkhttp/structures/maps/CaseInsensitiveMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "map", "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", SDKConstants.PARAM_KEY, "containsValue", "value", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "toString", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CaseInsensitiveMap<V> implements Map<String, V>, KMarkers {
    private final Map<String, V> map;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object compute(String str, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: compute  reason: avoid collision after fix types in other method */
    public V compute2(String str, BiFunction<? super String, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfAbsent(String str, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfAbsent  reason: avoid collision after fix types in other method */
    public V computeIfAbsent2(String str, Function<? super String, ? extends V> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object computeIfPresent(String str, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: computeIfPresent  reason: avoid collision after fix types in other method */
    public V computeIfPresent2(String str, BiFunction<? super String, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set<Map.Entry<String, V>> getEntries() {
        return this.map.entrySet();
    }

    public Set<String> getKeys() {
        return this.map.keySet();
    }

    public int getSize() {
        return this.map.size();
    }

    public Collection<V> getValues() {
        return this.map.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Map
    public /* synthetic */ Object merge(String str, Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: merge  reason: avoid collision after fix types in other method */
    public V merge2(String str, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public V put2(String str, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object putIfAbsent(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: putIfAbsent  reason: avoid collision after fix types in other method */
    public V putIfAbsent2(String str, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object replace(String str, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public V replace2(String str, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ boolean replace(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: replace  reason: avoid collision after fix types in other method */
    public boolean replace2(String str, V v, V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CaseInsensitiveMap(Map<String, ? extends V> map) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        this.map = map;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ V get(Object obj) {
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
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public boolean containsKey(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Set<String> keySet = this.map.keySet();
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            for (String str : keySet) {
                String lowerCase = key.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (StringsKt.equals(str, lowerCase, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V get(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Map<String, V> map = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, V> entry : map.entrySet()) {
            String lowerCase = key.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (StringsKt.equals(entry.getKey(), lowerCase, true)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add(entry2.getValue());
        }
        return (V) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
    }

    public String toString() {
        return this.map.toString();
    }
}
