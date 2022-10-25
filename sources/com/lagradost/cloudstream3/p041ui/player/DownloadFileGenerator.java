package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bongngotv2.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DownloadFileGenerator.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007Ja\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\"\u0010\u0015\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0017\u0012\u0004\u0012\u00020\u00190\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u00162\u0006\u0010\u001c\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016J\u000f\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\tH\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/DownloadFileGenerator;", "Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "episodes", "", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "currentIndex", "", "(Ljava/util/List;I)V", "hasCache", "", "getHasCache", "()Z", "loadResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "getLoadResponse", "()Lcom/lagradost/cloudstream3/LoadResponse;", "setLoadResponse", "(Lcom/lagradost/cloudstream3/LoadResponse;)V", "generateLinks", "clearCache", "isCasting", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "", "subtitleCallback", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", TypedValues.CycleType.S_WAVE_OFFSET, "(ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrent", "", "getCurrentId", "()Ljava/lang/Integer;", "goto", FirebaseAnalytics.Param.INDEX, "hasNext", "hasPrev", "next", "prev", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.DownloadFileGenerator */
/* loaded from: classes3.dex */
public final class DownloadFileGenerator implements IGenerator {
    private int currentIndex;
    private final List<ExtractorUri> episodes;
    private final boolean hasCache;
    private LoadResponse loadResponse;

    public DownloadFileGenerator(List<ExtractorUri> episodes, int i) {
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        this.episodes = episodes;
        this.currentIndex = i;
    }

    public /* synthetic */ DownloadFileGenerator(List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 0 : i);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public boolean getHasCache() {
        return this.hasCache;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public LoadResponse getLoadResponse() {
        return this.loadResponse;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void setLoadResponse(LoadResponse loadResponse) {
        this.loadResponse = loadResponse;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public boolean hasNext() {
        return this.currentIndex < this.episodes.size() - 1;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public boolean hasPrev() {
        return this.currentIndex > 0;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void next() {
        if (hasNext()) {
            this.currentIndex++;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void prev() {
        if (hasPrev()) {
            this.currentIndex--;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    /* renamed from: goto  reason: not valid java name */
    public void mo8669goto(int i) {
        this.currentIndex = Math.min(this.episodes.size() - 1, Math.max(0, i));
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Integer getCurrentId() {
        return this.episodes.get(this.currentIndex).getId();
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Object getCurrent(int i) {
        return CollectionsKt.getOrNull(this.episodes, this.currentIndex + i);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Object generateLinks(boolean z, boolean z2, Function1<? super Tuples<? extends ExtractorLink, ExtractorUri>, Unit> function1, Function1<? super SubtitleData, Unit> function12, int i, Continuation<? super Boolean> continuation) {
        List<Tuples<String, Uri>> folder;
        ExtractorUri extractorUri = this.episodes.get(this.currentIndex + i);
        function1.invoke(new Tuples(null, extractorUri));
        Context context = AcraApplication.Companion.getContext();
        if (context != null) {
            String relativePath = extractorUri.getRelativePath();
            String displayName = extractorUri.getDisplayName();
            if (displayName != null && relativePath != null && (folder = VideoDownloadManager.INSTANCE.getFolder(context, relativePath, extractorUri.getBasePath())) != null) {
                Iterator<T> it = folder.iterator();
                while (it.hasNext()) {
                    Tuples tuples = (Tuples) it.next();
                    String removeSuffix = StringsKt.removeSuffix(displayName, (CharSequence) ".mp4");
                    if (!Intrinsics.areEqual(tuples.getFirst(), extractorUri.getDisplayName()) && StringsKt.startsWith$default((String) tuples.getFirst(), removeSuffix, false, 2, (Object) null)) {
                        String removeSuffix2 = StringsKt.removeSuffix(StringsKt.removePrefix(StringsKt.trim((CharSequence) StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removePrefix((String) tuples.getFirst(), (CharSequence) removeSuffix), (CharSequence) ".vtt"), (CharSequence) ".srt"), (CharSequence) ".txt")).toString(), (CharSequence) "("), (CharSequence) ")");
                        if (StringsKt.isBlank(removeSuffix2)) {
                            removeSuffix2 = context.getString(R.string.default_subtitles);
                            Intrinsics.checkNotNullExpressionValue(removeSuffix2, "ctx.getString(R.string.default_subtitles)");
                        }
                        String uri = ((Uri) tuples.getSecond()).toString();
                        Intrinsics.checkNotNullExpressionValue(uri, "file.second.toString()");
                        function12.invoke(new SubtitleData(removeSuffix2, uri, SubtitleOrigin.DOWNLOADED_FILE, PlayerSubtitleHelper.Companion.toSubtitleMimeType(removeSuffix), null, 16, null));
                    }
                }
            }
        }
        return boxing.boxBoolean(true);
    }
}
