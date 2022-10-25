package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.exoplayer2.Bundleable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public final class BundleableUtil {
    public static Bundle toNullableBundle(Bundleable bundleable) {
        if (bundleable == null) {
            return null;
        }
        return bundleable.toBundle();
    }

    public static <T extends Bundleable> T fromNullableBundle(Bundleable.Creator<T> creator, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return creator.fromBundle(bundle);
    }

    public static <T extends Bundleable> T fromNullableBundle(Bundleable.Creator<T> creator, Bundle bundle, T t) {
        return bundle == null ? t : creator.fromBundle(bundle);
    }

    public static <T extends Bundleable> ImmutableList<Bundle> toBundleList(List<T> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add((ImmutableList.Builder) list.get(i).toBundle());
        }
        return builder.build();
    }

    public static <T extends Bundleable> ImmutableList<T> fromBundleList(Bundleable.Creator<T> creator, List<Bundle> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add((ImmutableList.Builder) creator.fromBundle((Bundle) Assertions.checkNotNull(list.get(i))));
        }
        return builder.build();
    }

    public static <T extends Bundleable> List<T> fromBundleNullableList(Bundleable.Creator<T> creator, List<Bundle> list, List<T> list2) {
        return list == null ? list2 : fromBundleList(creator, list);
    }

    public static <T extends Bundleable> SparseArray<T> fromBundleNullableSparseArray(Bundleable.Creator<T> creator, SparseArray<Bundle> sparseArray, SparseArray<T> sparseArray2) {
        if (sparseArray == null) {
            return sparseArray2;
        }
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray3.put(sparseArray.keyAt(i), creator.fromBundle(sparseArray.valueAt(i)));
        }
        return sparseArray3;
    }

    public static <T extends Bundleable> ArrayList<Bundle> toBundleArrayList(Collection<T> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (T t : collection) {
            arrayList.add(t.toBundle());
        }
        return arrayList;
    }

    public static <T extends Bundleable> SparseArray<Bundle> toBundleSparseArray(SparseArray<T> sparseArray) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i).toBundle());
        }
        return sparseArray2;
    }

    public static void ensureClassLoader(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Util.castNonNull(BundleableUtil.class.getClassLoader()));
        }
    }

    private BundleableUtil() {
    }
}
