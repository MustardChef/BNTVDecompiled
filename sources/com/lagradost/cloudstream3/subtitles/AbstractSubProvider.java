package com.lagradost.cloudstream3.subtitles;

import com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities;
import java.util.List;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.coroutines.Continuation;

/* compiled from: AbstractSubProvider.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitles/AbstractSubProvider;", "", "load", "", "data", "Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;", "(Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "query", "Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleSearch;", "(Lcom/lagradost/cloudstream3/subtitles/AbstractSubtitleEntities$SubtitleSearch;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public interface AbstractSubProvider {
    Object load(AbstractSubtitleEntities.SubtitleEntity subtitleEntity, Continuation<? super String> continuation);

    Object search(AbstractSubtitleEntities.SubtitleSearch subtitleSearch, Continuation<? super List<AbstractSubtitleEntities.SubtitleEntity>> continuation);

    /* compiled from: AbstractSubProvider.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Object search(AbstractSubProvider abstractSubProvider, AbstractSubtitleEntities.SubtitleSearch subtitleSearch, Continuation<? super List<AbstractSubtitleEntities.SubtitleEntity>> continuation) {
            throw new Standard(null, 1, null);
        }

        public static Object load(AbstractSubProvider abstractSubProvider, AbstractSubtitleEntities.SubtitleEntity subtitleEntity, Continuation<? super String> continuation) {
            throw new Standard(null, 1, null);
        }
    }
}
