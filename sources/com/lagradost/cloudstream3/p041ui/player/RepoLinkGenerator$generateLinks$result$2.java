package com.lagradost.cloudstream3.p041ui.player;

import android.util.Log;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RepoLinkGenerator.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.RepoLinkGenerator$generateLinks$result$2 */
/* loaded from: classes3.dex */
final class RepoLinkGenerator$generateLinks$result$2 extends Lambda implements Function1<ExtractorLink, Unit> {
    final /* synthetic */ Function1<Tuples<? extends ExtractorLink, ExtractorUri>, Unit> $callback;
    final /* synthetic */ Set<ExtractorLink> $currentLinkCache;
    final /* synthetic */ Set<String> $currentLinks;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepoLinkGenerator$generateLinks$result$2(Set<String> set, Set<ExtractorLink> set2, Function1<? super Tuples<? extends ExtractorLink, ExtractorUri>, Unit> function1) {
        super(1);
        this.$currentLinks = set;
        this.$currentLinkCache = set2;
        this.$callback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExtractorLink extractorLink) {
        invoke2(extractorLink);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(ExtractorLink link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Log.d(RepoLinkGenerator.TAG, "Loaded ExtractorLink: " + link);
        if (this.$currentLinks.contains(link.getUrl()) || this.$currentLinkCache.contains(link)) {
            return;
        }
        this.$currentLinks.add(link.getUrl());
        this.$callback.invoke(new Tuples<>(link, null));
        this.$currentLinkCache.add(link);
    }
}
