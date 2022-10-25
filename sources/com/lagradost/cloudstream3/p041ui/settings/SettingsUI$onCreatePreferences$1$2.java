package com.lagradost.cloudstream3.p041ui.settings;

import android.content.SharedPreferences;
import androidx.preference.Preference;
import com.lagradost.cloudstream3.p041ui.search.SearchResultBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsUI.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "list", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsUI$onCreatePreferences$1$2 */
/* loaded from: classes4.dex */
public final class SettingsUI$onCreatePreferences$1$2 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ Preference $it;
    final /* synthetic */ String[] $keys;
    final /* synthetic */ SharedPreferences $settingsManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUI$onCreatePreferences$1$2(SharedPreferences sharedPreferences, String[] strArr, Preference preference) {
        super(1);
        this.$settingsManager = sharedPreferences;
        this.$keys = strArr;
        this.$it = preference;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        SharedPreferences.Editor edit = this.$settingsManager.edit();
        String[] strArr = this.$keys;
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            edit.putBoolean(strArr[i], list.contains(Integer.valueOf(i)));
        }
        edit.apply();
        SearchResultBuilder.INSTANCE.updateCache(this.$it.getContext());
    }
}
