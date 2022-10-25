package khttp.structures.maps;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.text.StringsKt;

/* compiled from: CaseInsensitiveMutableMap.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0018H\u0096\u0001J\u001f\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\u00162\u0014\u0010#\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000$H\u0016J\u0017\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u001eJ\b\u0010&\u001a\u00020\u0003H\u0016R$\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, m107d2 = {"Lkhttp/structures/maps/CaseInsensitiveMutableMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "map", "(Ljava/util/Map;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "containsKey", "", SDKConstants.PARAM_KEY, "containsValue", "value", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "isEmpty", "put", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "toString", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CaseInsensitiveMutableMap<V> implements Map<String, V>, KMutableMap {
    private final Map<String, V> map;

    @Override // java.util.Map
    public void clear() {
        this.map.clear();
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

    public CaseInsensitiveMutableMap(Map<String, V> map) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(String str, Object obj) {
        return put2(str, (String) obj);
    }

    @Override // java.util.Map
    public final /* bridge */ V remove(Object obj) {
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
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public boolean containsKey(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Set<String> keySet = this.map.keySet();
        if (!(keySet instanceof Collection) || !keySet.isEmpty()) {
            for (String str : keySet) {
                if (StringsKt.equals(str, key, true)) {
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
            if (StringsKt.equals(entry.getKey(), key, true)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add(entry2.getValue());
        }
        return (V) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
    }

    public V remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Map<String, V> map = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, V> entry : map.entrySet()) {
            if (StringsKt.equals(entry.getKey(), key, true)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add((String) entry2.getKey());
        }
        String str = (String) CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        if (str != null) {
            return this.map.remove(str);
        }
        return null;
    }

    /* renamed from: put  reason: avoid collision after fix types in other method */
    public V put2(String key, V v) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        V remove = remove((Object) key);
        this.map.put(key, v);
        return remove;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends V> from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        for (Map.Entry<? extends String, ? extends V> entry : from.entrySet()) {
            put((CaseInsensitiveMutableMap<V>) entry.getKey(), (String) entry.getValue());
        }
    }

    public String toString() {
        return this.map.toString();
    }
}
