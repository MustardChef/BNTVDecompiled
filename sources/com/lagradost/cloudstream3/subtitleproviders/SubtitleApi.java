package com.lagradost.cloudstream3.subtitleproviders;

import com.lagradost.cloudstream3.SubtitleFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SubtitleApi.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JS\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u00040\fH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleApi;", "", "()V", "getSubtitles", "", "title", "", "year", "lang", "isTvSeries", "", "callback", "Lkotlin/Function1;", "", "Lcom/lagradost/cloudstream3/SubtitleFile;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public abstract class SubtitleApi {
    public abstract void getSubtitles(String str, String str2, String str3, Boolean bool, Function1<? super List<SubtitleFile>, Unit> function1);

    public static /* synthetic */ void getSubtitles$default(SubtitleApi subtitleApi, String str, String str2, String str3, Boolean bool, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSubtitles");
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = "vie";
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            bool = false;
        }
        subtitleApi.getSubtitles(str, str4, str5, bool, function1);
    }
}
