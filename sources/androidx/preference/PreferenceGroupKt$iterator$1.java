package androidx.preference;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

/* compiled from: PreferenceGroup.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"androidx/preference/PreferenceGroupKt$iterator$1", "", "Landroidx/preference/Preference;", FirebaseAnalytics.Param.INDEX, "", "hasNext", "", "next", "remove", "", "preference-ktx_release"}, m106k = 1, m105mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, KMutableIterator {
    final /* synthetic */ PreferenceGroup $this_iterator;
    private int index;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.$this_iterator = preferenceGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.getPreferenceCount();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Preference next() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        Preference preference = preferenceGroup.getPreference(i);
        if (preference != null) {
            return preference;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        PreferenceGroup preferenceGroup = this.$this_iterator;
        int i = this.index - 1;
        this.index = i;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i));
    }
}
