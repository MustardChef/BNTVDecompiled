package com.lagradost.cloudstream3.p041ui.result;

import android.view.View;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "episodeList", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHD$onViewCreated$19 */
/* loaded from: classes4.dex */
final class ResultFragmentPhimHD$onViewCreated$19 extends Lambda implements Function1<List<? extends ResultEpisode>, Unit> {
    final /* synthetic */ MainAPI $api;
    final /* synthetic */ String $apiName;
    final /* synthetic */ Integer $resumeEpisode;
    final /* synthetic */ Integer $resumeSeason;
    final /* synthetic */ ResultFragmentPhimHD this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentPhimHD$onViewCreated$19(ResultFragmentPhimHD resultFragmentPhimHD, Integer num, Integer num2, String str, MainAPI mainAPI) {
        super(1);
        this.this$0 = resultFragmentPhimHD;
        this.$resumeEpisode = num;
        this.$resumeSeason = num2;
        this.$apiName = str;
        this.$api = mainAPI;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ResultEpisode> list) {
        invoke2((List<ResultEpisode>) list);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0151, code lost:
        if (r4 == null) goto L188;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0205  */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(final java.util.List<com.lagradost.cloudstream3.p041ui.result.ResultEpisode> r15) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentPhimHD$onViewCreated$19.invoke2(java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-6$lambda-2  reason: not valid java name */
    public static final void m8785invoke$lambda6$lambda2(List episodeList, VideoDownloadHelper.ResumeWatching resume, ResultFragmentPhimHD this$0, String apiName, MainAPI api, View view) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(episodeList, "$episodeList");
        Intrinsics.checkNotNullParameter(resume, "$resume");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(apiName, "$apiName");
        Intrinsics.checkNotNullParameter(api, "$api");
        Iterator it = episodeList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((ResultEpisode) obj).getId();
            Integer episodeId = resume.getEpisodeId();
            if (episodeId != null && id == episodeId.intValue()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        ResultEpisode resultEpisode = (ResultEpisode) obj;
        if (resultEpisode != null) {
            ResultFragmentPhimHD.onViewCreated$handleAction(this$0, apiName, api, new EpisodeClickEvent(1, resultEpisode));
        }
    }
}
