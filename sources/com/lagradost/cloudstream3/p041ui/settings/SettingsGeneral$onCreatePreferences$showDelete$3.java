package com.lagradost.cloudstream3.p041ui.settings;

import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.p041ui.settings.SettingsGeneral;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsGeneral.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "indexes", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsGeneral$onCreatePreferences$showDelete$3 */
/* loaded from: classes4.dex */
public final class SettingsGeneral$onCreatePreferences$showDelete$3 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ List<SettingsGeneral.CustomSite> $current;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGeneral$onCreatePreferences$showDelete$3(List<SettingsGeneral.CustomSite> list) {
        super(1);
        this.$current = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<Integer> indexes) {
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        List<SettingsGeneral.CustomSite> list = this.$current;
        List<Integer> list2 = indexes;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Number number : list2) {
            arrayList.add(list.get(number.intValue()));
        }
        list.removeAll(arrayList);
        AcraApplication.Companion companion = AcraApplication.Companion;
        Object[] array = this.$current.toArray(new SettingsGeneral.CustomSite[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        companion.setKey(DataStoreKt.USER_PROVIDER_API, array);
    }
}
