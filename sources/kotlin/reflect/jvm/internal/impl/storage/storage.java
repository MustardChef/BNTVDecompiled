package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Functions;

/* renamed from: kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues */
/* loaded from: classes4.dex */
public interface storage<K, V> {
    V computeIfAbsent(K k, Functions<? extends V> functions);
}
