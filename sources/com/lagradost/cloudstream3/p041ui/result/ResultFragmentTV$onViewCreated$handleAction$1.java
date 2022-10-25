package com.lagradost.cloudstream3.p041ui.result;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.google.android.gms.cast.framework.CastSession;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.utils.CastHelper;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1", m98f = "ResultFragmentTV.kt", m97i = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, m96l = {845, 972, 974, 975, 976, 1133, 1195}, m95m = "invokeSuspend", m94n = {"currentLinks", "currentSubs", "showTitle", "currentLinks", "currentSubs", "showTitle", "currentLinks", "currentSubs", "showTitle", "currentLinks", "currentSubs", "showTitle", "act", "subs", "data"}, m93s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$1", "L$2", "L$3"})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$onViewCreated$handleAction$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ MainAPI $api;
    final /* synthetic */ String $apiName;
    final /* synthetic */ EpisodeClickEvent $episodeClick;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$handleAction$1(EpisodeClickEvent episodeClickEvent, ResultFragmentTV resultFragmentTV, String str, MainAPI mainAPI, Continuation<? super ResultFragmentTV$onViewCreated$handleAction$1> continuation) {
        super(1, continuation);
        this.$episodeClick = episodeClickEvent;
        this.this$0 = resultFragmentTV;
        this.$apiName = str;
        this.$api = mainAPI;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ResultFragmentTV$onViewCreated$handleAction$1(this.$episodeClick, this.this$0, this.$apiName, this.$api, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ResultFragmentTV$onViewCreated$handleAction$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0391, code lost:
        if (r0 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b5, code lost:
        r17 = r28.this$0.currentType;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
        r18 = r28.this$0.currentPoster;
     */
    /* JADX WARN: Removed duplicated region for block: B:189:0x055a A[Catch: Exception -> 0x0037, LOOP:0: B:187:0x0554->B:189:0x055a, LOOP_END, TryCatch #1 {Exception -> 0x0037, blocks: (B:8:0x0030, B:186:0x0548, B:187:0x0554, B:189:0x055a, B:190:0x0596, B:191:0x05a7, B:193:0x05ad, B:194:0x05d8, B:168:0x04f0, B:170:0x04fb, B:172:0x050e, B:174:0x0511, B:176:0x0517, B:178:0x051a, B:180:0x0520, B:182:0x0523), top: B:214:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05ad A[Catch: Exception -> 0x0037, LOOP:1: B:191:0x05a7->B:193:0x05ad, LOOP_END, TryCatch #1 {Exception -> 0x0037, blocks: (B:8:0x0030, B:186:0x0548, B:187:0x0554, B:189:0x055a, B:190:0x0596, B:191:0x05a7, B:193:0x05ad, B:194:0x05d8, B:168:0x04f0, B:170:0x04fb, B:172:0x050e, B:174:0x0511, B:176:0x0517, B:178:0x051a, B:180:0x0520, B:182:0x0523), top: B:214:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0271  */
    /* JADX WARN: Type inference failed for: r0v36, types: [androidx.appcompat.app.AlertDialog, T] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            Method dump skipped, instructions count: 1760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV$onViewCreated$handleAction$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    private static final void invokeSuspend$acquireSingleExtractorLink(ResultFragmentTV resultFragmentTV, final List<? extends ExtractorLink> list, String str, final Function1<? super ExtractorLink, Unit> function1) {
        AlertDialog.Builder builder = new AlertDialog.Builder(resultFragmentTV.requireContext(), R.style.AlertDialogCustom);
        builder.setTitle(str);
        List<? extends ExtractorLink> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ExtractorLink extractorLink : list2) {
            arrayList.add(extractorLink.getName() + ' ' + Qualities.Companion.getStringByInt(Integer.valueOf(extractorLink.getQuality())));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        builder.setItems((CharSequence[]) array, new DialogInterface.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentTV$onViewCreated$handleAction$1$vZYzAA3Egk3FJvD523-jOvWutME
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ResultFragmentTV$onViewCreated$handleAction$1.m8858invokeSuspend$acquireSingleExtractorLink$lambda1(Function1.this, list, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$acquireSingleExtractorLink$lambda-1  reason: not valid java name */
    public static final void m8858invokeSuspend$acquireSingleExtractorLink$lambda1(Function1 function1, List list, DialogInterface dialogInterface, int i) {
        function1.invoke(list.get(i));
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    private static final void invokeSuspend$acquireSingleSubtitleLink(ResultFragmentTV resultFragmentTV, final List<SubtitleData> list, String str, final Function1<? super SubtitleData, Unit> function1) {
        AlertDialog.Builder builder = new AlertDialog.Builder(resultFragmentTV.requireContext(), R.style.AlertDialogCustom);
        builder.setTitle(str);
        List<SubtitleData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (SubtitleData subtitleData : list2) {
            arrayList.add(subtitleData.getName());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        builder.setItems((CharSequence[]) array, new DialogInterface.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentTV$onViewCreated$handleAction$1$dfE43D-3WzDmawnH6O92Tt2F8Ao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ResultFragmentTV$onViewCreated$handleAction$1.m8859invokeSuspend$acquireSingleSubtitleLink$lambda3(Function1.this, list, dialogInterface, i);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$acquireSingleSubtitleLink$lambda-3  reason: not valid java name */
    public static final void m8859invokeSuspend$acquireSingleSubtitleLink$lambda3(Function1 function1, List list, DialogInterface dialogInterface, int i) {
        function1.invoke(list.get(i));
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    private static final void invokeSuspend$acquireSingeExtractorLink(Ref.ObjectRef<Set<ExtractorLink>> objectRef, ResultFragmentTV resultFragmentTV, String str, Function1<? super ExtractorLink, Unit> function1) {
        Set<ExtractorLink> set = objectRef.element;
        if (set == null) {
            return;
        }
        invokeSuspend$acquireSingleExtractorLink(resultFragmentTV, MainAPIKt.sortUrls(set), str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$startChromecast(ResultFragmentTV resultFragmentTV, EpisodeClickEvent episodeClickEvent, Ref.ObjectRef<Set<ExtractorLink>> objectRef, Ref.ObjectRef<Set<SubtitleData>> objectRef2, String str, int i) {
        List<ResultEpisode> list;
        FragmentActivity activity;
        CastSession castSession;
        Boolean bool;
        String str2;
        String str3;
        list = resultFragmentTV.currentEpisodes;
        if (list == null || (activity = resultFragmentTV.getActivity()) == null || (castSession = CommonActivity.INSTANCE.getCastSession(activity)) == null) {
            return;
        }
        CastHelper castHelper = CastHelper.INSTANCE;
        bool = resultFragmentTV.currentIsMovie;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            str2 = resultFragmentTV.currentHeaderName;
            str3 = resultFragmentTV.currentPoster;
            int index = episodeClickEvent.getData().getIndex();
            Set<ExtractorLink> set = objectRef.element;
            if (set == null) {
                return;
            }
            List<ExtractorLink> sortUrls = MainAPIKt.sortUrls(set);
            Set<SubtitleData> set2 = objectRef2.element;
            if (set2 == null) {
                return;
            }
            castHelper.startCast(castSession, str, booleanValue, str2, str3, index, list, sortUrls, MainAPIKt.sortSubs(set2), Integer.valueOf(i), Long.valueOf(ResultFragmentPhimHDKt.getRealPosition(episodeClickEvent.getData())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object invokeSuspend$requireLinks(java.lang.String r14, final com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV r15, com.lagradost.cloudstream3.p041ui.result.EpisodeClickEvent r16, kotlin.jvm.internal.Ref.ObjectRef<java.util.Set<com.lagradost.cloudstream3.utils.ExtractorLink>> r17, kotlin.jvm.internal.Ref.ObjectRef<java.util.Set<com.lagradost.cloudstream3.p041ui.player.SubtitleData>> r18, boolean r19, boolean r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV$onViewCreated$handleAction$1.invokeSuspend$requireLinks(java.lang.String, com.lagradost.cloudstream3.ui.result.ResultFragmentTV, com.lagradost.cloudstream3.ui.result.EpisodeClickEvent, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$ObjectRef, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object invokeSuspend$requireLinks$default(String str, ResultFragmentTV resultFragmentTV, EpisodeClickEvent episodeClickEvent, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        return invokeSuspend$requireLinks(str, resultFragmentTV, episodeClickEvent, objectRef, objectRef2, z, (i & 64) != 0 ? true : z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$requireLinks$lambda-4  reason: not valid java name */
    public static final void m8861invokeSuspend$requireLinks$lambda4(ResultFragmentTV resultFragmentTV, DialogInterface dialogInterface) {
        int i;
        i = resultFragmentTV.currentLoadingCount;
        resultFragmentTV.currentLoadingCount = i + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "link", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$2 */
    /* loaded from: classes4.dex */
    public static final class C49472 extends Lambda implements Function1<SubtitleData, Unit> {
        final /* synthetic */ String $apiName;
        final /* synthetic */ EpisodeClickEvent $episodeClick;
        final /* synthetic */ ResultFragmentTV this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49472(ResultFragmentTV resultFragmentTV, EpisodeClickEvent episodeClickEvent, String str) {
            super(1);
            this.this$0 = resultFragmentTV;
            this.$episodeClick = episodeClickEvent;
            this.$apiName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubtitleData subtitleData) {
            invoke2(subtitleData);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
            r7 = r9.this$0.currentIsMovie;
         */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void invoke2(com.lagradost.cloudstream3.p041ui.player.SubtitleData r10) {
            /*
                r9 = this;
                java.lang.String r0 = "link"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion r0 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.Companion
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r1 = r9.this$0
                android.content.Context r1 = r1.getContext()
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion r2 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.Companion
                com.lagradost.cloudstream3.ui.result.EpisodeClickEvent r3 = r9.$episodeClick
                com.lagradost.cloudstream3.ui.result.ResultEpisode r3 = r3.getData()
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r4 = r9.this$0
                java.lang.String r4 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentHeaderName$p(r4)
                if (r4 != 0) goto L1e
                return
            L1e:
                java.lang.String r5 = r9.$apiName
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r6 = r9.this$0
                java.lang.String r6 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentPoster$p(r6)
                if (r6 != 0) goto L29
                return
            L29:
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r7 = r9.this$0
                java.lang.Boolean r7 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentIsMovie$p(r7)
                if (r7 == 0) goto L56
                boolean r7 = r7.booleanValue()
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r8 = r9.this$0
                com.lagradost.cloudstream3.TvType r8 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentType$p(r8)
                if (r8 != 0) goto L3e
                return
            L3e:
                com.lagradost.cloudstream3.utils.VideoDownloadManager$DownloadEpisodeMetadata r2 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.Companion.access$getMeta(r2, r3, r4, r5, r6, r7, r8)
                com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.Companion.access$downloadSubtitle(r0, r1, r10, r2)
                com.lagradost.cloudstream3.CommonActivity r10 = com.lagradost.cloudstream3.CommonActivity.INSTANCE
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r9.this$0
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.app.Activity r0 = (android.app.Activity) r0
                r1 = 2131951871(0x7f1300ff, float:1.9540169E38)
                r2 = 0
                r10.showToast(r0, r1, r2)
            L56:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV$onViewCreated$handleAction$1.C49472.invoke2(com.lagradost.cloudstream3.ui.player.SubtitleData):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-7$lambda-6  reason: not valid java name */
    public static final void m8860invokeSuspend$lambda7$lambda6(ArrayList arrayList, EpisodeClickEvent episodeClickEvent, Ref.ObjectRef objectRef, ResultFragmentTV resultFragmentTV, String str, MainAPI mainAPI, DialogInterface dialogInterface, int i) {
        Object obj = arrayList.get(i);
        Intrinsics.checkNotNullExpressionValue(obj, "verifiedOptionsValues[which]");
        ResultFragmentTV.onViewCreated$handleAction(resultFragmentTV, str, mainAPI, new EpisodeClickEvent(((Number) obj).intValue(), episodeClickEvent.getData()));
        AlertDialog alertDialog = (AlertDialog) objectRef.element;
        if (alertDialog != null) {
            UIHelper.INSTANCE.dismissSafe(alertDialog, resultFragmentTV.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$5 */
    /* loaded from: classes4.dex */
    public static final class C49485 extends Lambda implements Function1<ExtractorLink, Unit> {
        final /* synthetic */ ResultFragmentTV this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49485(ResultFragmentTV resultFragmentTV) {
            super(1);
            this.this$0 = resultFragmentTV;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExtractorLink extractorLink) {
            invoke2(extractorLink);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ExtractorLink link) {
            Intrinsics.checkNotNullParameter(link, "link");
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(link.getUrl()));
                this.this$0.startActivity(intent);
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$6 */
    /* loaded from: classes4.dex */
    public static final class C49496 extends Lambda implements Function1<ExtractorLink, Unit> {
        final /* synthetic */ String $apiName;
        final /* synthetic */ Ref.ObjectRef<Set<ExtractorLink>> $currentLinks;
        final /* synthetic */ Ref.ObjectRef<Set<SubtitleData>> $currentSubs;
        final /* synthetic */ EpisodeClickEvent $episodeClick;
        final /* synthetic */ ResultFragmentTV this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49496(Ref.ObjectRef<Set<ExtractorLink>> objectRef, ResultFragmentTV resultFragmentTV, EpisodeClickEvent episodeClickEvent, Ref.ObjectRef<Set<SubtitleData>> objectRef2, String str) {
            super(1);
            this.$currentLinks = objectRef;
            this.this$0 = resultFragmentTV;
            this.$episodeClick = episodeClickEvent;
            this.$currentSubs = objectRef2;
            this.$apiName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExtractorLink extractorLink) {
            invoke2(extractorLink);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(ExtractorLink link) {
            Intrinsics.checkNotNullParameter(link, "link");
            Set<ExtractorLink> set = this.$currentLinks.element;
            int indexOf = set != null ? CollectionsKt.indexOf(set, link) : -1;
            ResultFragmentTV$onViewCreated$handleAction$1.invokeSuspend$startChromecast(this.this$0, this.$episodeClick, this.$currentLinks, this.$currentSubs, this.$apiName, indexOf == -1 ? 0 : indexOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "link", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$handleAction$1$9 */
    /* loaded from: classes4.dex */
    public static final class C49509 extends Lambda implements Function1<ExtractorLink, Unit> {
        final /* synthetic */ String $apiName;
        final /* synthetic */ Ref.ObjectRef<Set<SubtitleData>> $currentSubs;
        final /* synthetic */ EpisodeClickEvent $episodeClick;
        final /* synthetic */ ResultFragmentTV this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49509(ResultFragmentTV resultFragmentTV, EpisodeClickEvent episodeClickEvent, String str, Ref.ObjectRef<Set<SubtitleData>> objectRef) {
            super(1);
            this.this$0 = resultFragmentTV;
            this.$episodeClick = episodeClickEvent;
            this.$apiName = str;
            this.$currentSubs = objectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExtractorLink extractorLink) {
            invoke2(extractorLink);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
            r7 = r13.this$0.currentPoster;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
            r6 = r13.this$0.currentType;
         */
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void invoke2(com.lagradost.cloudstream3.utils.ExtractorLink r14) {
            /*
                r13 = this;
                java.lang.String r0 = "link"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV$Companion r1 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.Companion
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                android.content.Context r2 = r0.getContext()
                com.lagradost.cloudstream3.ui.result.EpisodeClickEvent r0 = r13.$episodeClick
                com.lagradost.cloudstream3.ui.result.ResultEpisode r3 = r0.getData()
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                java.lang.Boolean r0 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentIsMovie$p(r0)
                if (r0 == 0) goto L76
                boolean r4 = r0.booleanValue()
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                java.lang.String r5 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentHeaderName$p(r0)
                if (r5 != 0) goto L28
                return
            L28:
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                com.lagradost.cloudstream3.TvType r6 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentType$p(r0)
                if (r6 != 0) goto L31
                return
            L31:
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                java.lang.String r7 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentPoster$p(r0)
                if (r7 != 0) goto L3a
                return
            L3a:
                java.lang.String r8 = r13.$apiName
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                java.lang.Integer r0 = com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV.access$getCurrentId$p(r0)
                if (r0 == 0) goto L76
                int r9 = r0.intValue()
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                java.lang.String r10 = r0.getUrl()
                if (r10 != 0) goto L51
                return
            L51:
                java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r14)
                kotlin.jvm.internal.Ref$ObjectRef<java.util.Set<com.lagradost.cloudstream3.ui.player.SubtitleData>> r14 = r13.$currentSubs
                T r14 = r14.element
                java.util.Set r14 = (java.util.Set) r14
                if (r14 != 0) goto L5e
                return
            L5e:
                java.util.List r12 = com.lagradost.cloudstream3.MainAPIKt.sortSubs(r14)
                r1.startDownload(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                com.lagradost.cloudstream3.CommonActivity r14 = com.lagradost.cloudstream3.CommonActivity.INSTANCE
                com.lagradost.cloudstream3.ui.result.ResultFragmentTV r0 = r13.this$0
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                android.app.Activity r0 = (android.app.Activity) r0
                r1 = 2131951871(0x7f1300ff, float:1.9540169E38)
                r2 = 0
                r14.showToast(r0, r1, r2)
            L76:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultFragmentTV$onViewCreated$handleAction$1.C49509.invoke2(com.lagradost.cloudstream3.utils.ExtractorLink):void");
        }
    }
}
