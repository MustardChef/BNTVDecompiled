package androidx.preference;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: PreferenceGroup.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010)\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a0\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\b\u001aE\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\b\u001a&\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\b\b\u0000\u0010\u0017*\u00020\u0002*\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0086\n¢\u0006\u0002\u0010\u001a\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\r\u0010\u001b\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u001c\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001f\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010 \u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006!"}, m107d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroidx/preference/Preference;", "Landroidx/preference/PreferenceGroup;", "getChildren", "(Landroidx/preference/PreferenceGroup;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroidx/preference/PreferenceGroup;)I", "contains", "", "preference", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", FirebaseAnalytics.Param.INDEX, "get", ExifInterface.GPS_DIRECTION_TRUE, SDKConstants.PARAM_KEY, "", "(Landroidx/preference/PreferenceGroup;Ljava/lang/CharSequence;)Landroidx/preference/Preference;", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "preference-ktx_release"}, m106k = 2, m105mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class PreferenceGroupKt {
    public static final <T extends Preference> T get(PreferenceGroup get, CharSequence key) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        Intrinsics.checkParameterIsNotNull(key, "key");
        return (T) get.findPreference(key);
    }

    public static final Preference get(PreferenceGroup get, int i) {
        Intrinsics.checkParameterIsNotNull(get, "$this$get");
        Preference preference = get.getPreference(i);
        if (preference != null) {
            return preference;
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + get.getPreferenceCount());
    }

    public static final boolean contains(PreferenceGroup contains, Preference preference) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(preference, "preference");
        int preferenceCount = contains.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            if (Intrinsics.areEqual(contains.getPreference(i), preference)) {
                return true;
            }
        }
        return false;
    }

    public static final void plusAssign(PreferenceGroup plusAssign, Preference preference) {
        Intrinsics.checkParameterIsNotNull(plusAssign, "$this$plusAssign");
        Intrinsics.checkParameterIsNotNull(preference, "preference");
        plusAssign.addPreference(preference);
    }

    public static final void minusAssign(PreferenceGroup minusAssign, Preference preference) {
        Intrinsics.checkParameterIsNotNull(minusAssign, "$this$minusAssign");
        Intrinsics.checkParameterIsNotNull(preference, "preference");
        minusAssign.removePreference(preference);
    }

    public static final int getSize(PreferenceGroup size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.getPreferenceCount();
    }

    public static final void forEach(PreferenceGroup forEach, Function1<? super Preference, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int preferenceCount = forEach.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            action.invoke(get(forEach, i));
        }
    }

    public static final void forEachIndexed(PreferenceGroup forEachIndexed, Function2<? super Integer, ? super Preference, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEachIndexed, "$this$forEachIndexed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int preferenceCount = forEachIndexed.getPreferenceCount();
        for (int i = 0; i < preferenceCount; i++) {
            action.invoke(Integer.valueOf(i), get(forEachIndexed, i));
        }
    }

    public static final Iterator<Preference> iterator(PreferenceGroup iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new PreferenceGroupKt$iterator$1(iterator);
    }

    public static final Sequence<Preference> getChildren(final PreferenceGroup children) {
        Intrinsics.checkParameterIsNotNull(children, "$this$children");
        return new Sequence<Preference>() { // from class: androidx.preference.PreferenceGroupKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<Preference> iterator() {
                return PreferenceGroupKt.iterator(PreferenceGroup.this);
            }
        };
    }

    public static final boolean isEmpty(PreferenceGroup isEmpty) {
        Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.getPreferenceCount() == 0;
    }

    public static final boolean isNotEmpty(PreferenceGroup isNotEmpty) {
        Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.getPreferenceCount() != 0;
    }
}
