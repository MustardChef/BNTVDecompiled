package com.lagradost.cloudstream3.p041ui.player;

import android.app.Dialog;
import android.widget.ArrayAdapter;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.FragmentActivity;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.ParCollections;
import com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer;
import com.lagradost.cloudstream3.subtitles.AbstractSubtitleEntities;
import com.lagradost.cloudstream3.syncproviders.providers.OpenSubtitlesApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1", m98f = "GeneratorPlayer.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1 */
/* loaded from: classes3.dex */
final class GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayAdapter<String> $adapter;
    final /* synthetic */ Ref.ObjectRef<String> $currentLanguageTwoLetters;
    final /* synthetic */ Ref.ObjectRef<List<AbstractSubtitleEntities.SubtitleEntity>> $currentSubtitles;
    final /* synthetic */ GeneratorPlayer.TempMetaData $currentTempMeta;
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ Long $imdbId;
    final /* synthetic */ List<OpenSubtitlesApi> $providers;
    final /* synthetic */ String $query;
    int label;
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1(String str, GeneratorPlayer.TempMetaData tempMetaData, Ref.ObjectRef<String> objectRef, Long l, List<OpenSubtitlesApi> list, GeneratorPlayer generatorPlayer, Dialog dialog, Ref.ObjectRef<List<AbstractSubtitleEntities.SubtitleEntity>> objectRef2, ArrayAdapter<String> arrayAdapter, Continuation<? super GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1> continuation) {
        super(1, continuation);
        this.$query = str;
        this.$currentTempMeta = tempMetaData;
        this.$currentLanguageTwoLetters = objectRef;
        this.$imdbId = l;
        this.$providers = list;
        this.this$0 = generatorPlayer;
        this.$dialog = dialog;
        this.$currentSubtitles = objectRef2;
        this.$adapter = arrayAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1(this.$query, this.$currentTempMeta, this.$currentLanguageTwoLetters, this.$imdbId, this.$providers, this.this$0, this.$dialog, this.$currentSubtitles, this.$adapter, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$query;
            if (str == null) {
                return Unit.INSTANCE;
            }
            Integer episode = this.$currentTempMeta.getEpisode();
            Integer season = this.$currentTempMeta.getSeason();
            String str2 = this.$currentLanguageTwoLetters.element;
            if (StringsKt.isBlank(str2)) {
                str2 = null;
            }
            List filterNotNull = CollectionsKt.filterNotNull(ParCollections.apmap(this.$providers, new C4870x7c758d06(new AbstractSubtitleEntities.SubtitleSearch(str, this.$imdbId, str2, episode, season, null, 32, null), null)));
            List<List> list = filterNotNull;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (List list2 : list) {
                arrayList.add(boxing.boxInt(list2.size()));
            }
            Integer num = (Integer) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) arrayList);
            if (num != null) {
                int intValue = num.intValue();
                final ArrayList arrayList2 = new ArrayList();
                int size = filterNotNull.size();
                for (int i = 0; i < intValue; i++) {
                    for (int i2 = 0; i2 < size; i2++) {
                        AbstractSubtitleEntities.SubtitleEntity subtitleEntity = (AbstractSubtitleEntities.SubtitleEntity) CollectionsKt.getOrNull((List) filterNotNull.get(i2), i);
                        if (subtitleEntity != null) {
                            arrayList2.add(subtitleEntity);
                        }
                    }
                }
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    final Dialog dialog = this.$dialog;
                    final Ref.ObjectRef<List<AbstractSubtitleEntities.SubtitleEntity>> objectRef = this.$currentSubtitles;
                    final ArrayAdapter<String> arrayAdapter = this.$adapter;
                    activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1$Mhumnaby3fFLD3sn8eZdnMlv6nk
                        @Override // java.lang.Runnable
                        public final void run() {
                            GeneratorPlayer$openOnlineSubPicker$3$onQueryTextSubmit$1.m8736invokeSuspend$lambda2(arrayList2, dialog, objectRef, arrayAdapter);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-2  reason: not valid java name */
    public static final void m8736invokeSuspend$lambda2(ArrayList arrayList, Dialog dialog, Ref.ObjectRef objectRef, ArrayAdapter arrayAdapter) {
        GeneratorPlayer.openOnlineSubPicker$setSubtitlesList(objectRef, arrayAdapter, arrayList);
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) dialog.findViewById(C4761R.C4764id.search_loading_bar);
        if (contentLoadingProgressBar != null) {
            contentLoadingProgressBar.hide();
        }
    }
}
