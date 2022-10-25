package org.acra.util;

import android.os.Bundle;
import android.os.PersistableBundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0003\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\nH\u0007¨\u0006\u000b"}, m107d2 = {"isPersistableBundleType", "", "value", "", "put", "", "Landroid/os/PersistableBundle;", SDKConstants.PARAM_KEY, "", "toPersistableBundle", "Landroid/os/Bundle;", "acra-core_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: org.acra.util.BundleKt */
/* loaded from: classes4.dex */
public final class bundle {
    public static final PersistableBundle toPersistableBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        PersistableBundle persistableBundle = new PersistableBundle();
        for (String key : bundle.keySet()) {
            Object obj = bundle.get(key);
            if (isPersistableBundleType(obj)) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                put(persistableBundle, key, obj);
            }
        }
        return persistableBundle;
    }

    private static final boolean isPersistableBundleType(Object obj) {
        return (obj instanceof PersistableBundle) || (obj instanceof Integer) || (obj instanceof int[]) || (obj instanceof Long) || (obj instanceof long[]) || (obj instanceof Double) || (obj instanceof double[]) || (obj instanceof String) || ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) || (obj instanceof Boolean) || (obj instanceof boolean[]);
    }

    private static final void put(PersistableBundle persistableBundle, String str, Object obj) throws IllegalArgumentException {
        if (obj == null) {
            throw new IllegalArgumentException("Unable to determine type of null values".toString());
        }
        if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof String) {
            persistableBundle.putString(str, (String) obj);
        } else if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
            persistableBundle.putStringArray(str, (String[]) obj);
        } else if (obj instanceof Boolean) {
            persistableBundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            persistableBundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof PersistableBundle) {
            persistableBundle.putAll((PersistableBundle) obj);
        } else {
            throw new IllegalArgumentException("Objects of type " + ((Object) obj.getClass().getSimpleName()) + " can not be put into a PersistableBundle");
        }
    }
}
