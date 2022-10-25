package com.lagradost.cloudstream3.movieproviders;

import com.facebook.share.internal.ShareConstants;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilmpertuttiProvider.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.FilmpertuttiProvider", m98f = "FilmpertuttiProvider.kt", m97i = {1}, m96l = {181, 199, bqk.f6550bJ}, m95m = "unshorten_linkup", m94n = {ShareConstants.MEDIA_URI}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class FilmpertuttiProvider$unshorten_linkup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FilmpertuttiProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilmpertuttiProvider$unshorten_linkup$1(FilmpertuttiProvider filmpertuttiProvider, Continuation<? super FilmpertuttiProvider$unshorten_linkup$1> continuation) {
        super(continuation);
        this.this$0 = filmpertuttiProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.unshorten_linkup(null, this);
    }
}
