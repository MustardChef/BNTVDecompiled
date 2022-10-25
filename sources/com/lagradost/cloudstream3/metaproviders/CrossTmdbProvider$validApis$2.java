package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: CrossTmdbProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MainAPI;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class CrossTmdbProvider$validApis$2 extends Lambda implements Functions<List<? extends MainAPI>> {
    final /* synthetic */ CrossTmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossTmdbProvider$validApis$2(CrossTmdbProvider crossTmdbProvider) {
        super(0);
        this.this$0 = crossTmdbProvider;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends MainAPI> invoke() {
        CrossTmdbProvider crossTmdbProvider = this.this$0;
        ArrayList arrayList = new ArrayList();
        for (Object obj : APIHolder.INSTANCE.getApis()) {
            MainAPI mainAPI = (MainAPI) obj;
            if (Intrinsics.areEqual(mainAPI.getLang(), crossTmdbProvider.getLang()) && !Intrinsics.areEqual(mainAPI.getClass(), crossTmdbProvider.getClass())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
