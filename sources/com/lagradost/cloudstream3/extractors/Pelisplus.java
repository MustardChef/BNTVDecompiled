package com.lagradost.cloudstream3.extractors;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Pelisplus.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002JK\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Pelisplus;", "", "mainUrl", "", "(Ljava/lang/String;)V", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "normalApis", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/extractors/MultiQuality;", "Lkotlin/collections/ArrayList;", "getDownloadUrl", "id", "getExtractorUrl", "getUrl", "", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Pelisplus {
    private final String mainUrl;
    private final String name;
    private final ArrayList<MultiQuality> normalApis;

    public Pelisplus(String mainUrl) {
        Intrinsics.checkNotNullParameter(mainUrl, "mainUrl");
        this.mainUrl = mainUrl;
        this.name = "Vidstream";
        this.normalApis = CollectionsKt.arrayListOf(new MultiQuality());
    }

    public final String getMainUrl() {
        return this.mainUrl;
    }

    public final String getName() {
        return this.name;
    }

    private final String getExtractorUrl(String str) {
        return this.mainUrl + "/play?id=" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDownloadUrl(String str) {
        return this.mainUrl + "/download?id=" + str;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0117 A[Catch: Exception -> 0x0181, TRY_ENTER, TryCatch #0 {Exception -> 0x0181, blocks: (B:13:0x0042, B:29:0x00ea, B:30:0x010f, B:33:0x0117, B:35:0x0128, B:36:0x012c, B:37:0x0134, B:39:0x013a, B:41:0x0153, B:48:0x0163, B:49:0x0166, B:50:0x0169, B:51:0x017c, B:18:0x0062, B:25:0x00a7, B:21:0x006a), top: B:55:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013a A[Catch: Exception -> 0x0181, TryCatch #0 {Exception -> 0x0181, blocks: (B:13:0x0042, B:29:0x00ea, B:30:0x010f, B:33:0x0117, B:35:0x0128, B:36:0x012c, B:37:0x0134, B:39:0x013a, B:41:0x0153, B:48:0x0163, B:49:0x0166, B:50:0x0169, B:51:0x017c, B:18:0x0062, B:25:0x00a7, B:21:0x006a), top: B:55:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0163 A[Catch: Exception -> 0x0181, TryCatch #0 {Exception -> 0x0181, blocks: (B:13:0x0042, B:29:0x00ea, B:30:0x010f, B:33:0x0117, B:35:0x0128, B:36:0x012c, B:37:0x0134, B:39:0x013a, B:41:0x0153, B:48:0x0163, B:49:0x0166, B:50:0x0169, B:51:0x017c, B:18:0x0062, B:25:0x00a7, B:21:0x006a), top: B:55:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUrl(java.lang.String r26, boolean r27, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r28, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r29, kotlin.coroutines.Continuation<? super java.lang.Boolean> r30) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.Pelisplus.getUrl(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
