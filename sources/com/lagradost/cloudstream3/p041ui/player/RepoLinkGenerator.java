package com.lagradost.cloudstream3.p041ui.player;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.p041ui.result.ResultEpisode;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RepoLinkGenerator.kt */
@Metadata(m108d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001)B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJa\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\"\u0010\u0015\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017\u0012\u0004\u0012\u00020\u001a0\u00162\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001a0\u00162\u0006\u0010\u001d\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\r\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/RepoLinkGenerator;", "Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "episodes", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "currentIndex", "", "loadResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/util/List;ILcom/lagradost/cloudstream3/LoadResponse;)V", "hasCache", "", "getHasCache", "()Z", "getLoadResponse", "()Lcom/lagradost/cloudstream3/LoadResponse;", "setLoadResponse", "(Lcom/lagradost/cloudstream3/LoadResponse;)V", "generateLinks", "clearCache", "isCasting", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "", "subtitleCallback", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", TypedValues.CycleType.S_WAVE_OFFSET, "(ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrent", "", "getCurrentId", "()Ljava/lang/Integer;", "goto", FirebaseAnalytics.Param.INDEX, "hasNext", "hasPrev", "next", "prev", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.RepoLinkGenerator */
/* loaded from: classes3.dex */
public final class RepoLinkGenerator implements IGenerator {
    public static final String TAG = "RepoLink";
    private int currentIndex;
    private final List<ResultEpisode> episodes;
    private final boolean hasCache;
    private LoadResponse loadResponse;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<Tuples<String, Integer>, Tuples<Set<ExtractorLink>, Set<SubtitleData>>> cache = new HashMap<>();

    public RepoLinkGenerator(List<ResultEpisode> episodes, int i, LoadResponse loadResponse) {
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        this.episodes = episodes;
        this.currentIndex = i;
        this.loadResponse = loadResponse;
        this.hasCache = true;
    }

    public /* synthetic */ RepoLinkGenerator(List list, int i, LoadResponse loadResponse, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? null : loadResponse);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public LoadResponse getLoadResponse() {
        return this.loadResponse;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void setLoadResponse(LoadResponse loadResponse) {
        this.loadResponse = loadResponse;
    }

    /* compiled from: RepoLinkGenerator.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000Ru\u0010\u0005\u001af\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\u00070\u0006j2\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007\u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\u0007`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/RepoLinkGenerator$Companion;", "", "()V", "TAG", "", "cache", "Ljava/util/HashMap;", "Lkotlin/Pair;", "", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "Lkotlin/collections/HashMap;", "getCache", "()Ljava/util/HashMap;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.RepoLinkGenerator$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HashMap<Tuples<String, Integer>, Tuples<Set<ExtractorLink>, Set<SubtitleData>>> getCache() {
            return RepoLinkGenerator.cache;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public boolean getHasCache() {
        return this.hasCache;
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
        Log.i(TAG, "next");
        if (hasNext()) {
            this.currentIndex++;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void prev() {
        Log.i(TAG, "prev");
        if (hasPrev()) {
            this.currentIndex--;
        }
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    /* renamed from: goto */
    public void mo8669goto(int i) {
        Log.i(TAG, "goto " + i);
        this.currentIndex = Math.min(this.episodes.size() + (-1), Math.max(0, i));
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Integer getCurrentId() {
        return Integer.valueOf(this.episodes.get(this.currentIndex).getId());
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Object getCurrent(int i) {
        return CollectionsKt.getOrNull(this.episodes, this.currentIndex + i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01df  */
    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object generateLinks(boolean r17, boolean r18, kotlin.jvm.functions.Function1<? super kotlin.Tuples<? extends com.lagradost.cloudstream3.utils.ExtractorLink, com.lagradost.cloudstream3.utils.ExtractorUri>, kotlin.Unit> r19, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.p041ui.player.SubtitleData, kotlin.Unit> r20, int r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.RepoLinkGenerator.generateLinks(boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
