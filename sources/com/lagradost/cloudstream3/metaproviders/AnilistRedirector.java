package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncRepo;
import java.util.List;
import kotlin.Metadata;

@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/metaproviders/SyncRedirector;", "", "()V", "syncApis", "", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "getSyncApis", "()Ljava/util/List;", "redirect", "", "url", "preferredUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.metaproviders.SyncRedirector */
/* loaded from: classes3.dex */
public final class AnilistRedirector {
    public static final AnilistRedirector INSTANCE = new AnilistRedirector();
    private static final List<SyncRepo> syncApis = AccountManager.Companion.getSyncApis();

    private AnilistRedirector() {
    }

    public final List<SyncRepo> getSyncApis() {
        return syncApis;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be A[EDGE_INSN: B:41:0x00be->B:35:0x00be ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object redirect(java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super java.lang.String> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.lagradost.cloudstream3.metaproviders.SyncRedirector$redirect$1
            if (r0 == 0) goto L14
            r0 = r12
            com.lagradost.cloudstream3.metaproviders.SyncRedirector$redirect$1 r0 = (com.lagradost.cloudstream3.metaproviders.SyncRedirector$redirect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.lagradost.cloudstream3.metaproviders.SyncRedirector$redirect$1 r0 = new com.lagradost.cloudstream3.metaproviders.SyncRedirector$redirect$1
            r0.<init>(r9, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L3e
            if (r2 != r5) goto L36
            java.lang.Object r10 = r0.L$1
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r0.L$0
            com.lagradost.cloudstream3.metaproviders.SyncRedirector r10 = (com.lagradost.cloudstream3.metaproviders.AnilistRedirector) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L9f
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.util.List<com.lagradost.cloudstream3.syncproviders.SyncRepo> r12 = com.lagradost.cloudstream3.metaproviders.AnilistRedirector.syncApis
            java.util.Iterator r12 = r12.iterator()
        L47:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto Ldc
            java.lang.Object r2 = r12.next()
            com.lagradost.cloudstream3.syncproviders.SyncRepo r2 = (com.lagradost.cloudstream3.syncproviders.SyncRepo) r2
            r7 = r10
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r8 = r2.getMainUrl()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r7 = kotlin.text.StringsKt.contains$default(r7, r8, r4, r3, r6)
            if (r7 == 0) goto L47
            java.lang.String r12 = r2.getName()
            com.lagradost.cloudstream3.syncproviders.AccountManager$Companion r7 = com.lagradost.cloudstream3.syncproviders.AccountManager.Companion
            com.lagradost.cloudstream3.syncproviders.providers.AniListApi r7 = r7.getAniListApi()
            java.lang.String r7 = r7.getName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r7)
            if (r7 == 0) goto L79
            java.lang.String r12 = "anilist"
            goto L8b
        L79:
            com.lagradost.cloudstream3.syncproviders.AccountManager$Companion r7 = com.lagradost.cloudstream3.syncproviders.AccountManager.Companion
            com.lagradost.cloudstream3.syncproviders.providers.MALApi r7 = r7.getMalApi()
            java.lang.String r7 = r7.getName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r7)
            if (r12 == 0) goto Ldc
            java.lang.String r12 = "myanimelist"
        L8b:
            com.lagradost.cloudstream3.utils.SyncUtil r7 = com.lagradost.cloudstream3.utils.SyncUtil.INSTANCE
            java.lang.String r10 = r2.getIdFromUrl(r10)
            r0.L$0 = r9
            r0.L$1 = r11
            r0.label = r5
            java.lang.Object r12 = r7.getUrlsFromId(r10, r12, r0)
            if (r12 != r1) goto L9e
            return r1
        L9e:
            r10 = r9
        L9f:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        La5:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto Lbe
            java.lang.Object r0 = r12.next()
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = kotlin.text.StringsKt.contains$default(r1, r2, r4, r3, r6)
            if (r1 == 0) goto La5
            r6 = r0
        Lbe:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto Lc3
            return r6
        Lc3:
            com.lagradost.cloudstream3.metaproviders.SyncRedirector r10 = (com.lagradost.cloudstream3.metaproviders.AnilistRedirector) r10
            com.lagradost.cloudstream3.ErrorLoadingException r10 = new com.lagradost.cloudstream3.ErrorLoadingException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Page does not exist on "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        Ldc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.AnilistRedirector.redirect(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
