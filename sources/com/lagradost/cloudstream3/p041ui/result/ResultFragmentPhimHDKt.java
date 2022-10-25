package com.lagradost.cloudstream3.p041ui.result;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultFragmentPhimHD.kt */
@Metadata(m108d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0093\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001¢\u0006\u0002\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\b\u001a\n\u0010\u001d\u001a\u00020\u001c*\u00020\b\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, m107d2 = {"MAX_SYNO_LENGH", "", "START_ACTION_ADD_BOOKMARK", "START_ACTION_LOAD_EP", "START_ACTION_NORMAL", "START_ACTION_RESUME_LATEST", "START_VALUE_NORMAL", "buildResultEpisode", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "headerName", "", "name", "poster", "episode", "season", "data", "apiName", "id", FirebaseAnalytics.Param.INDEX, "rating", "description", "isFiller", "", "tvType", "Lcom/lagradost/cloudstream3/TvType;", "parentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lcom/lagradost/cloudstream3/TvType;I)Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "getDisplayPosition", "", "getRealPosition", "getWatchProgress", "", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentPhimHDKt */
/* loaded from: classes4.dex */
public final class ResultFragmentPhimHDKt {
    public static final int MAX_SYNO_LENGH = 1000;
    public static final int START_ACTION_ADD_BOOKMARK = 9;
    public static final int START_ACTION_LOAD_EP = 2;
    public static final int START_ACTION_NORMAL = 0;
    public static final int START_ACTION_RESUME_LATEST = 1;
    public static final int START_VALUE_NORMAL = 0;

    public static final long getRealPosition(ResultEpisode resultEpisode) {
        Intrinsics.checkNotNullParameter(resultEpisode, "<this>");
        if (resultEpisode.getDuration() <= 0) {
            return 0L;
        }
        long position = (resultEpisode.getPosition() * 100) / resultEpisode.getDuration();
        if (position <= 5 || position >= 95) {
            return 0L;
        }
        return resultEpisode.getPosition();
    }

    public static final long getDisplayPosition(ResultEpisode resultEpisode) {
        Intrinsics.checkNotNullParameter(resultEpisode, "<this>");
        if (resultEpisode.getDuration() <= 0) {
            return 0L;
        }
        long j = 100;
        long position = (resultEpisode.getPosition() * j) / resultEpisode.getDuration();
        if (position <= 1) {
            return 0L;
        }
        if (position <= 5) {
            return (5 * resultEpisode.getDuration()) / j;
        }
        if (position >= 95) {
            return resultEpisode.getDuration();
        }
        return resultEpisode.getPosition();
    }

    public static final ResultEpisode buildResultEpisode(String headerName, String str, String str2, int i, Integer num, String data, String apiName, int i2, int i3, Integer num2, String str3, Boolean bool, TvType tvType, int i4) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(tvType, "tvType");
        DataStoreHelper.PosDur viewPos = DataStoreHelper.INSTANCE.getViewPos(Integer.valueOf(i2));
        return new ResultEpisode(headerName, str, str2, i, num, data, apiName, i2, i3, viewPos != null ? viewPos.getPosition() : 0L, viewPos != null ? viewPos.getDuration() : 0L, num2, str3, bool, tvType, i4);
    }

    public static final float getWatchProgress(ResultEpisode resultEpisode) {
        Intrinsics.checkNotNullParameter(resultEpisode, "<this>");
        long j = 1000;
        return ((float) (getDisplayPosition(resultEpisode) / j)) / ((float) (resultEpisode.getDuration() / j));
    }
}
