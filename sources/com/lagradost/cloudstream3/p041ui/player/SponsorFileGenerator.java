package com.lagradost.cloudstream3.p041ui.player;

import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import com.lagradost.cloudstream3.utils.Qualities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SponsorFileGenerator.kt */
@Metadata(m108d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007Ja\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\"\u0010\u0017\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019\u0012\u0004\u0012\u00020\u001c0\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001c0\u00182\u0006\u0010\u001f\u001a\u00020 H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001cH\u0016R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/SponsorFileGenerator;", "Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "links", "", "", "name", "apiName", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "hasCache", "", "getHasCache", "()Z", "loadResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "getLoadResponse", "()Lcom/lagradost/cloudstream3/LoadResponse;", "setLoadResponse", "(Lcom/lagradost/cloudstream3/LoadResponse;)V", "generateLinks", "clearCache", "isCasting", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "", "subtitleCallback", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", TypedValues.CycleType.S_WAVE_OFFSET, "", "(ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrent", "", "getCurrentId", "()Ljava/lang/Integer;", "goto", FirebaseAnalytics.Param.INDEX, "hasNext", "hasPrev", "next", "prev", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.SponsorFileGenerator */
/* loaded from: classes3.dex */
public final class SponsorFileGenerator implements IGenerator {
    private final String apiName;
    private final boolean hasCache;
    private final List<String> links;
    private LoadResponse loadResponse;
    private final String name;

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    /* renamed from: goto */
    public void mo8669goto(int i) {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public boolean hasNext() {
        return false;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public boolean hasPrev() {
        return false;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void next() {
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public void prev() {
    }

    public SponsorFileGenerator(List<String> links, String name, String apiName) {
        Intrinsics.checkNotNullParameter(links, "links");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        this.links = links;
        this.name = name;
        this.apiName = apiName;
    }

    public final String getApiName() {
        return this.apiName;
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
    public Integer getCurrentId() {
        return 0;
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Object getCurrent(int i) {
        Uri parse = Uri.parse((String) CollectionsKt.first((List<? extends Object>) this.links));
        Intrinsics.checkNotNullExpressionValue(parse, "parse(links.first())");
        return new ExtractorUri(parse, "LiveStream", null, null, null, null, null, null, null, null, null, 2044, null);
    }

    @Override // com.lagradost.cloudstream3.p041ui.player.IGenerator
    public Object generateLinks(boolean z, boolean z2, Function1<? super Tuples<? extends ExtractorLink, ExtractorUri>, Unit> function1, Function1<? super SubtitleData, Unit> function12, int i, Continuation<? super Boolean> continuation) {
        String str = (String) CollectionsKt.first((List<? extends Object>) this.links);
        function1.invoke(new Tuples(new ExtractorLink(str, this.name, str, str, Qualities.P720.getValue(), true, MapsKt.emptyMap(), this.apiName), null));
        return boxing.boxBoolean(true);
    }
}
