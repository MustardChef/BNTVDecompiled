package com.lagradost.cloudstream3.p041ui.home;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Landroid/view/MenuItem;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$6$2$2 */
/* loaded from: classes3.dex */
public final class HomeFragment$onViewCreated$6$2$2 extends Lambda implements Function1<MenuItem, Unit> {
    final /* synthetic */ List<MainAPI> $validAPIs;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeFragment$onViewCreated$6$2$2(List<? extends MainAPI> list, HomeFragment homeFragment) {
        super(1);
        this.$validAPIs = list;
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MenuItem menuItem) {
        invoke2(menuItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(MenuItem popupMenuNoIconsAndNoStringRes) {
        Intrinsics.checkNotNullParameter(popupMenuNoIconsAndNoStringRes, "$this$popupMenuNoIconsAndNoStringRes");
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.$validAPIs.get(popupMenuNoIconsAndNoStringRes.getItemId()).getMainUrl()));
            this.this$0.startActivity(intent);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }
}
