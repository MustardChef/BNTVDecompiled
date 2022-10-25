package kotlin.reflect.jvm.internal.pcollections;

/* loaded from: classes4.dex */
final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = new IntTreePMap<>(IntTree.EMPTYNODE);
    private final IntTree<V> root;

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) EMPTY;
    }

    private IntTreePMap(IntTree<V> intTree) {
        this.root = intTree;
    }

    private IntTreePMap<V> withRoot(IntTree<V> intTree) {
        return intTree == this.root ? this : new IntTreePMap<>(intTree);
    }

    public V get(int i) {
        return this.root.get(i);
    }

    public IntTreePMap<V> plus(int i, V v) {
        return withRoot(this.root.plus(i, v));
    }

    public IntTreePMap<V> minus(int i) {
        return withRoot(this.root.minus(i));
    }
}
