package com.lagradost.cloudstream3.syncproviders;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncRepo.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SyncRepo$hasAccount$1 extends Lambda implements Functions<Boolean> {
    final /* synthetic */ SyncRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncRepo$hasAccount$1(SyncRepo syncRepo) {
        super(0);
        this.this$0 = syncRepo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Boolean invoke() {
        SyncAPI syncAPI;
        syncAPI = this.this$0.repo;
        return Boolean.valueOf(syncAPI.loginInfo() != null);
    }
}
