package com.lagradost.cloudstream3.p041ui.download;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.ContentLoadingProgressBar;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EasyDownloadButton.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "downloadData", "Lkotlin/Triple;", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpDownloadButton$1 */
/* loaded from: classes3.dex */
public final class EasyDownloadButton$setUpDownloadButton$1 extends Lambda implements Function1<Triple<? extends Integer, ? extends Long, ? extends Long>, Unit> {
    final /* synthetic */ Ref.LongRef $currentBytes;
    final /* synthetic */ EasyDownloadButton.IMinimumData $data;
    final /* synthetic */ Function1<Tuples<Integer, String>, Unit> $downloadImageChangeCallback;
    final /* synthetic */ View $downloadView;
    final /* synthetic */ boolean $isTextPercentage;
    final /* synthetic */ Ref.ObjectRef<VideoDownloadManager.DownloadType> $lastState;
    final /* synthetic */ Ref.BooleanRef $needImageUpdate;
    final /* synthetic */ ContentLoadingProgressBar $progressBar;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ Ref.LongRef $totalBytes;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EasyDownloadButton$setUpDownloadButton$1(EasyDownloadButton.IMinimumData iMinimumData, Ref.LongRef longRef, Ref.LongRef longRef2, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar, Ref.ObjectRef<VideoDownloadManager.DownloadType> objectRef, boolean z, Ref.BooleanRef booleanRef, Function1<? super Tuples<Integer, String>, Unit> function1, View view) {
        super(1);
        this.$data = iMinimumData;
        this.$currentBytes = longRef;
        this.$totalBytes = longRef2;
        this.$textView = textView;
        this.$progressBar = contentLoadingProgressBar;
        this.$lastState = objectRef;
        this.$isTextPercentage = z;
        this.$needImageUpdate = booleanRef;
        this.$downloadImageChangeCallback = function1;
        this.$downloadView = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends Integer, ? extends Long, ? extends Long> triple) {
        invoke2((Triple<Integer, Long, Long>) triple);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Triple<Integer, Long, Long> downloadData) {
        Intrinsics.checkNotNullParameter(downloadData, "downloadData");
        if (this.$data.getId() == downloadData.getFirst().intValue()) {
            if (downloadData.getSecond().longValue() == this.$currentBytes.element && downloadData.getThird().longValue() == this.$totalBytes.element) {
                return;
            }
            Coroutines.INSTANCE.runOnMainThread(new C48481(downloadData, this.$data, this.$currentBytes, this.$totalBytes, this.$textView, this.$progressBar, this.$lastState, this.$isTextPercentage, this.$needImageUpdate, this.$downloadImageChangeCallback, this.$downloadView));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EasyDownloadButton.kt */
    @Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$setUpDownloadButton$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48481 extends Lambda implements Functions<Unit> {
        final /* synthetic */ Ref.LongRef $currentBytes;
        final /* synthetic */ EasyDownloadButton.IMinimumData $data;
        final /* synthetic */ Triple<Integer, Long, Long> $downloadData;
        final /* synthetic */ Function1<Tuples<Integer, String>, Unit> $downloadImageChangeCallback;
        final /* synthetic */ View $downloadView;
        final /* synthetic */ boolean $isTextPercentage;
        final /* synthetic */ Ref.ObjectRef<VideoDownloadManager.DownloadType> $lastState;
        final /* synthetic */ Ref.BooleanRef $needImageUpdate;
        final /* synthetic */ ContentLoadingProgressBar $progressBar;
        final /* synthetic */ TextView $textView;
        final /* synthetic */ Ref.LongRef $totalBytes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48481(Triple<Integer, Long, Long> triple, EasyDownloadButton.IMinimumData iMinimumData, Ref.LongRef longRef, Ref.LongRef longRef2, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar, Ref.ObjectRef<VideoDownloadManager.DownloadType> objectRef, boolean z, Ref.BooleanRef booleanRef, Function1<? super Tuples<Integer, String>, Unit> function1, View view) {
            super(0);
            this.$downloadData = triple;
            this.$data = iMinimumData;
            this.$currentBytes = longRef;
            this.$totalBytes = longRef2;
            this.$textView = textView;
            this.$progressBar = contentLoadingProgressBar;
            this.$lastState = objectRef;
            this.$isTextPercentage = z;
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
            EasyDownloadButton.setUpDownloadButton$fixDownloadedBytes(this.$currentBytes, this.$totalBytes, this.$textView, this.$progressBar, this.$lastState, this.$data, this.$isTextPercentage, this.$needImageUpdate, this.$downloadImageChangeCallback, this.$downloadView, this.$downloadData.getSecond().longValue(), this.$downloadData.getThird().longValue(), true);
            EasyDownloadButton.setUpDownloadButton$changeDownloadImage(this.$lastState, this.$currentBytes, this.$needImageUpdate, this.$downloadImageChangeCallback, this.$downloadView, VideoDownloadManager.INSTANCE.getDownloadState(this.$data.getId()));
        }
    }
}
