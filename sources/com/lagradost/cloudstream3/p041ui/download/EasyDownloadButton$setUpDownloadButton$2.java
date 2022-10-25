package com.lagradost.cloudstream3.p041ui.download;

import android.view.View;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EasyDownloadButton.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "downloadData", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpDownloadButton$2 */
/* loaded from: classes3.dex */
public final class EasyDownloadButton$setUpDownloadButton$2 extends Lambda implements Function1<Tuples<? extends Integer, ? extends VideoDownloadManager.DownloadType>, Unit> {
    final /* synthetic */ Ref.LongRef $currentBytes;
    final /* synthetic */ EasyDownloadButton.IMinimumData $data;
    final /* synthetic */ Function1<Tuples<Integer, String>, Unit> $downloadImageChangeCallback;
    final /* synthetic */ View $downloadView;
    final /* synthetic */ Ref.ObjectRef<VideoDownloadManager.DownloadType> $lastState;
    final /* synthetic */ Ref.BooleanRef $needImageUpdate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EasyDownloadButton$setUpDownloadButton$2(EasyDownloadButton.IMinimumData iMinimumData, Ref.ObjectRef<VideoDownloadManager.DownloadType> objectRef, Ref.BooleanRef booleanRef, Ref.LongRef longRef, Function1<? super Tuples<Integer, String>, Unit> function1, View view) {
        super(1);
        this.$data = iMinimumData;
        this.$lastState = objectRef;
        this.$needImageUpdate = booleanRef;
        this.$currentBytes = longRef;
        this.$downloadImageChangeCallback = function1;
        this.$downloadView = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Integer, ? extends VideoDownloadManager.DownloadType> tuples) {
        invoke2((Tuples<Integer, ? extends VideoDownloadManager.DownloadType>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Integer, ? extends VideoDownloadManager.DownloadType> downloadData) {
        Intrinsics.checkNotNullParameter(downloadData, "downloadData");
        if (this.$data.getId() == downloadData.getFirst().intValue()) {
            if (this.$lastState.element != downloadData.getSecond() || this.$needImageUpdate.element) {
                Coroutines.INSTANCE.runOnMainThread(new C48491(downloadData, this.$lastState, this.$currentBytes, this.$needImageUpdate, this.$downloadImageChangeCallback, this.$downloadView));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EasyDownloadButton.kt */
    @Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpDownloadButton$2$1 */
    /* loaded from: classes3.dex */
    public static final class C48491 extends Lambda implements Functions<Unit> {
        final /* synthetic */ Ref.LongRef $currentBytes;
        final /* synthetic */ Tuples<Integer, VideoDownloadManager.DownloadType> $downloadData;
        final /* synthetic */ Function1<Tuples<Integer, String>, Unit> $downloadImageChangeCallback;
        final /* synthetic */ View $downloadView;
        final /* synthetic */ Ref.ObjectRef<VideoDownloadManager.DownloadType> $lastState;
        final /* synthetic */ Ref.BooleanRef $needImageUpdate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48491(Tuples<Integer, ? extends VideoDownloadManager.DownloadType> tuples, Ref.ObjectRef<VideoDownloadManager.DownloadType> objectRef, Ref.LongRef longRef, Ref.BooleanRef booleanRef, Function1<? super Tuples<Integer, String>, Unit> function1, View view) {
            super(0);
            this.$downloadData = tuples;
            this.$lastState = objectRef;
            this.$currentBytes = longRef;
            this.$needImageUpdate = booleanRef;
            this.$downloadImageChangeCallback = function1;
            this.$downloadView = view;
        }

        @Override // kotlin.jvm.functions.Functions
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Functions
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EasyDownloadButton.setUpDownloadButton$changeDownloadImage(this.$lastState, this.$currentBytes, this.$needImageUpdate, this.$downloadImageChangeCallback, this.$downloadView, this.$downloadData.getSecond());
        }
    }
}
