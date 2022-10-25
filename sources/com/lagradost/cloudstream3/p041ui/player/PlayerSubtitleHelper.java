package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.p036ui.SubtitleView;
import com.google.android.exoplayer2.util.MimeTypes;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.p041ui.subtitles.SaveCaptionStyle;
import com.lagradost.cloudstream3.p041ui.subtitles.SubtitlesFragment;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PlayerSubtitleHelper.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/PlayerSubtitleHelper;", "", "()V", "activeSubtitles", "", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "allSubtitles", "subStyle", "Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "subtitleView", "Lcom/google/android/exoplayer2/ui/SubtitleView;", "getAllSubtitles", "initSubtitles", "", "subView", "subHolder", "Landroid/widget/FrameLayout;", "style", "setActiveSubtitles", "list", "setAllSubtitles", "setSubStyle", "subtitleStatus", "Lcom/lagradost/cloudstream3/ui/player/SubtitleStatus;", "sub", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerSubtitleHelper */
/* loaded from: classes3.dex */
public final class PlayerSubtitleHelper {
    public static final Companion Companion = new Companion(null);
    private Set<SubtitleData> activeSubtitles = SetsKt.emptySet();
    private Set<SubtitleData> allSubtitles = SetsKt.emptySet();
    private SaveCaptionStyle subStyle;
    private SubtitleView subtitleView;

    public final Set<SubtitleData> getAllSubtitles() {
        return this.allSubtitles;
    }

    public final void setActiveSubtitles(Set<SubtitleData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.activeSubtitles = list;
    }

    public final void setAllSubtitles(Set<SubtitleData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.allSubtitles = list;
    }

    /* compiled from: PlayerSubtitleHelper.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\n\u0010\u0007\u001a\u00020\b*\u00020\b¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/PlayerSubtitleHelper$Companion;", "", "()V", "getSubtitleData", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "subtitleFile", "Lcom/lagradost/cloudstream3/SubtitleFile;", "toSubtitleMimeType", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerSubtitleHelper$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toSubtitleMimeType(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return StringsKt.endsWith(str, "vtt", true) ? MimeTypes.TEXT_VTT : StringsKt.endsWith(str, "srt", true) ? MimeTypes.APPLICATION_SUBRIP : (StringsKt.endsWith(str, "xml", true) || StringsKt.endsWith(str, "ttml", true)) ? MimeTypes.APPLICATION_TTML : MimeTypes.APPLICATION_SUBRIP;
        }

        public final SubtitleData getSubtitleData(SubtitleFile subtitleFile) {
            Intrinsics.checkNotNullParameter(subtitleFile, "subtitleFile");
            return new SubtitleData(subtitleFile.getLang(), subtitleFile.getUrl(), SubtitleOrigin.URL, toSubtitleMimeType(subtitleFile.getUrl()), subtitleFile.isZipUrl());
        }
    }

    public final SubtitleStatus subtitleStatus(SubtitleData subtitleData) {
        if (CollectionsKt.contains(this.activeSubtitles, subtitleData)) {
            return SubtitleStatus.IS_ACTIVE;
        }
        if (CollectionsKt.contains(this.allSubtitles, subtitleData)) {
            return SubtitleStatus.REQUIRES_RELOAD;
        }
        return SubtitleStatus.NOT_FOUND;
    }

    public final void setSubStyle(SaveCaptionStyle style) {
        Context context;
        Intrinsics.checkNotNullParameter(style, "style");
        CustomDecoder.Companion.setRegexSubtitlesToRemoveBloat(style.getRemoveBloat());
        CustomDecoder.Companion.setRegexSubtitlesToRemoveCaptions(style.getRemoveCaptions());
        SubtitleView subtitleView = this.subtitleView;
        if (subtitleView == null || (context = subtitleView.getContext()) == null) {
            return;
        }
        this.subStyle = style;
        SubtitleView subtitleView2 = this.subtitleView;
        if (subtitleView2 != null) {
            subtitleView2.setStyle(SubtitlesFragment.Companion.fromSaveToStyle(context, style));
        }
        SubtitleView subtitleView3 = this.subtitleView;
        if (subtitleView3 != null) {
            subtitleView3.setTranslationY(-UIHelper.INSTANCE.getToPx(style.getElevation()));
        }
        Float fixedTextSize = style.getFixedTextSize();
        if (fixedTextSize != null) {
            SubtitleView subtitleView4 = this.subtitleView;
            if (subtitleView4 != null) {
                subtitleView4.setFixedTextSize(2, fixedTextSize.floatValue());
                return;
            }
            return;
        }
        SubtitleView subtitleView5 = this.subtitleView;
        if (subtitleView5 != null) {
            subtitleView5.setUserDefaultTextSize();
        }
    }

    public final void initSubtitles(SubtitleView subtitleView, FrameLayout frameLayout, SaveCaptionStyle saveCaptionStyle) {
        this.subtitleView = subtitleView;
        if (subtitleView != null) {
            ViewGroup viewGroup = (ViewGroup) subtitleView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(subtitleView);
            }
            if (frameLayout != null) {
                frameLayout.addView(subtitleView);
            }
        }
        if (saveCaptionStyle != null) {
            setSubStyle(saveCaptionStyle);
        }
    }
}
