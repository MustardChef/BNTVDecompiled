package com.lagradost.cloudstream3.p041ui.player;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* compiled from: IGenerator.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001Jc\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\"\u0010\u000f\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011\u0012\u0004\u0012\u00020\u00140\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0018H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0018H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0014H&J\b\u0010\"\u001a\u00020\u0014H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "", "hasCache", "", "getHasCache", "()Z", "loadResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "getLoadResponse", "()Lcom/lagradost/cloudstream3/LoadResponse;", "setLoadResponse", "(Lcom/lagradost/cloudstream3/LoadResponse;)V", "generateLinks", "clearCache", "isCasting", "callback", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "", "subtitleCallback", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", TypedValues.CycleType.S_WAVE_OFFSET, "", "(ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrent", "getCurrentId", "()Ljava/lang/Integer;", "goto", FirebaseAnalytics.Param.INDEX, "hasNext", "hasPrev", "next", "prev", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.IGenerator */
/* loaded from: classes3.dex */
public interface IGenerator {
    Object generateLinks(boolean z, boolean z2, Function1<? super Tuples<? extends ExtractorLink, ExtractorUri>, Unit> function1, Function1<? super SubtitleData, Unit> function12, int i, Continuation<? super Boolean> continuation);

    Object getCurrent(int i);

    Integer getCurrentId();

    boolean getHasCache();

    LoadResponse getLoadResponse();

    /* renamed from: goto */
    void mo8669goto(int i);

    boolean hasNext();

    boolean hasPrev();

    void next();

    void prev();

    void setLoadResponse(LoadResponse loadResponse);

    /* compiled from: IGenerator.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.IGenerator$DefaultImpls */
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCurrent$default(IGenerator iGenerator, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 0;
                }
                return iGenerator.getCurrent(i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrent");
        }

        public static /* synthetic */ Object generateLinks$default(IGenerator iGenerator, boolean z, boolean z2, Function1 function1, Function1 function12, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                return iGenerator.generateLinks(z, z2, function1, function12, (i2 & 16) != 0 ? 0 : i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: generateLinks");
        }
    }
}
