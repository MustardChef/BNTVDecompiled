package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;

/* compiled from: StorageManager.kt */
/* loaded from: classes4.dex */
public interface StorageManager {
    <T> T compute(Functions<? extends T> functions);

    <K, V> storage<K, V> createCacheWithNotNullValues();

    <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues();

    <T> NotNullLazyValue<T> createLazyValue(Functions<? extends T> functions);

    <T> NotNullLazyValue<T> createLazyValueWithPostCompute(Functions<? extends T> functions, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function12);

    <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1);

    <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1);

    <T> NullableLazyValue<T> createNullableLazyValue(Functions<? extends T> functions);

    <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(Functions<? extends T> functions, T t);
}
