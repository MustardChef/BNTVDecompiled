package com.lagradost.cloudstream3.p041ui.settings;

import android.content.SharedPreferences;
import com.bongngotv2.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsLang.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "selectedList", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsLang$onCreatePreferences$4$1$3 */
/* loaded from: classes4.dex */
public final class SettingsLang$onCreatePreferences$4$1$3 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ List<Tuples<String, String>> $names;
    final /* synthetic */ SharedPreferences $settingsManager;
    final /* synthetic */ SettingsLang this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsLang$onCreatePreferences$4$1$3(SharedPreferences sharedPreferences, SettingsLang settingsLang, List<Tuples<String, String>> list) {
        super(1);
        this.$settingsManager = sharedPreferences;
        this.this$0 = settingsLang;
        this.$names = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Integer> selectedList) {
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        SharedPreferences.Editor edit = this.$settingsManager.edit();
        String string = this.this$0.getString(R.string.provider_lang_key);
        List<Integer> list = selectedList;
        List<Tuples<String, String>> list2 = this.$names;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number number : list) {
            arrayList.add(list2.get(number.intValue()).getFirst());
        }
        edit.putStringSet(string, CollectionsKt.toMutableSet(arrayList)).apply();
    }
}
