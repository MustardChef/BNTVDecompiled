package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.syncproviders.providers.AniListApi;
import com.lagradost.cloudstream3.syncproviders.providers.MALApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: MultiAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class MultiAnimeProvider$syncUtilType$2 extends Lambda implements Functions<String> {
    final /* synthetic */ MultiAnimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiAnimeProvider$syncUtilType$2(MultiAnimeProvider multiAnimeProvider) {
        super(0);
        this.this$0 = multiAnimeProvider;
    }

    @Override // kotlin.jvm.functions.Functions
    public final String invoke() {
        SyncAPI syncAPI;
        syncAPI = this.this$0.syncApi;
        if (syncAPI instanceof AniListApi) {
            return "anilist";
        }
        if (syncAPI instanceof MALApi) {
            return "myanimelist";
        }
        throw new ErrorLoadingException("Invalid Api");
    }
}
