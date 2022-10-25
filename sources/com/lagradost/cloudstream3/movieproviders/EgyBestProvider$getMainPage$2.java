package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.HomePageList;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jsoup.nodes.Element;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EgyBestProvider.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "kotlin.jvm.PlatformType"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$2", m98f = "EgyBestProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class EgyBestProvider$getMainPage$2 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<HomePageList> $pages;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EgyBestProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EgyBestProvider$getMainPage$2(ArrayList<HomePageList> arrayList, EgyBestProvider egyBestProvider, Continuation<? super EgyBestProvider$getMainPage$2> continuation) {
        super(2, continuation);
        this.$pages = arrayList;
        this.this$0 = egyBestProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EgyBestProvider$getMainPage$2 egyBestProvider$getMainPage$2 = new EgyBestProvider$getMainPage$2(this.$pages, this.this$0, continuation);
        egyBestProvider$getMainPage$2.L$0 = obj;
        return egyBestProvider$getMainPage$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Element element, Continuation<? super Unit> continuation) {
        return ((EgyBestProvider$getMainPage$2) create(element, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (new kotlin.text.Regex("season-(.....)|ep-(.....)").containsMatchIn(r1) == true) goto L9;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.label
            if (r0 != 0) goto La9
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            org.jsoup.nodes.Element r10 = (org.jsoup.nodes.Element) r10
            java.lang.String r0 = ".bdb.pda > strong"
            org.jsoup.select.Elements r0 = r10.select(r0)
            java.lang.String r2 = r0.text()
            java.lang.String r0 = ".movie"
            org.jsoup.select.Elements r1 = r10.select(r0)
            org.jsoup.nodes.Element r1 = r1.first()
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3e
            java.lang.String r5 = "href"
            java.lang.String r1 = r1.attr(r5)
            if (r1 == 0) goto L3e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "season-(.....)|ep-(.....)"
            r5.<init>(r6)
            boolean r1 = r5.containsMatchIn(r1)
            if (r1 != r3) goto L3e
            goto L3f
        L3e:
            r3 = 0
        L3f:
            if (r3 == 0) goto L44
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L44:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            org.jsoup.select.Elements r10 = r10.select(r0)
            java.lang.String r0 = "it.select(\".movie\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            com.lagradost.cloudstream3.movieproviders.EgyBestProvider r0 = r9.this$0
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r10 = r10.iterator()
        L67:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L8b
            java.lang.Object r4 = r10.next()
            org.jsoup.nodes.Element r4 = (org.jsoup.nodes.Element) r4
            java.lang.String r5 = "element"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.lagradost.cloudstream3.SearchResponse r4 = com.lagradost.cloudstream3.movieproviders.EgyBestProvider.access$toSearchResponse(r0, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            boolean r4 = r1.add(r4)
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.boxing.boxBoolean(r4)
            r3.add(r4)
            goto L67
        L8b:
            java.util.List r3 = (java.util.List) r3
            java.util.ArrayList<com.lagradost.cloudstream3.HomePageList> r10 = r9.$pages
            com.lagradost.cloudstream3.HomePageList r0 = new com.lagradost.cloudstream3.HomePageList
            java.lang.String r3 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r3 = r1
            java.util.List r3 = (java.util.List) r3
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 28
            r8 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r10.add(r0)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        La9:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.EgyBestProvider$getMainPage$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
