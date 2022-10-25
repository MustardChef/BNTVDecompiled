package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: DownloadFileWorkManager.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class DownloadFileWorkManager$awaitDownload$listener$1 extends Lambda implements Function1<Tuples<? extends Integer, ? extends VideoDownloadManager.DownloadType>, Unit> {
    final /* synthetic */ int $id;
    final /* synthetic */ Ref.BooleanRef $isDone;

    /* compiled from: DownloadFileWorkManager.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoDownloadManager.DownloadType.values().length];
            iArr[VideoDownloadManager.DownloadType.IsDone.ordinal()] = 1;
            iArr[VideoDownloadManager.DownloadType.IsFailed.ordinal()] = 2;
            iArr[VideoDownloadManager.DownloadType.IsStopped.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFileWorkManager$awaitDownload$listener$1(int i, Ref.BooleanRef booleanRef) {
        super(1);
        this.$id = i;
        this.$isDone = booleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Integer, ? extends VideoDownloadManager.DownloadType> tuples) {
        invoke2((Tuples<Integer, ? extends VideoDownloadManager.DownloadType>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Integer, ? extends VideoDownloadManager.DownloadType> tuples) {
        Intrinsics.checkNotNullParameter(tuples, "<name for destructuring parameter 0>");
        int intValue = tuples.component1().intValue();
        VideoDownloadManager.DownloadType component2 = tuples.component2();
        if (this.$id == intValue) {
            int i = WhenMappings.$EnumSwitchMapping$0[component2.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                this.$isDone.element = true;
            }
        }
    }
}
