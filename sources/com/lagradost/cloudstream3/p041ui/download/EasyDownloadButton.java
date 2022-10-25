package com.lagradost.cloudstream3.p041ui.download;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.ContentLoadingProgressBar;
import com.bongngotv2.R;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.utils.IDisposable;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: EasyDownloadButton.kt */
@Metadata(m108d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\bH\u0016JU\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\u0010\u001aJ\u0081\u0001\u0010\u001b\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u001e\u0010\u001e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001f0\n\u0012\u0004\u0012\u00020\b0\u00042\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0002\u0010 \u001a\u00020!H\u0002¢\u0006\u0002\u0010\"JU\u0010#\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\u0010&Jo\u0010'\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\u0010*R.\u0010\u0003\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "Lcom/lagradost/cloudstream3/utils/IDisposable;", "()V", "downloadProgressEventListener", "Lkotlin/Function1;", "Lkotlin/Triple;", "", "", "", "downloadStatusEventListener", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/VideoDownloadManager$DownloadType;", "dispose", "setUpButton", "setupCurrentBytes", "setupTotalBytes", "progressBar", "Landroidx/core/widget/ContentLoadingProgressBar;", "downloadImage", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "data", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;", "clickCallback", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "(Ljava/lang/Long;Ljava/lang/Long;Landroidx/core/widget/ContentLoadingProgressBar;Landroid/widget/ImageView;Landroid/widget/TextView;Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;Lkotlin/jvm/functions/Function1;)V", "setUpDownloadButton", "downloadView", "Landroid/view/View;", "downloadImageChangeCallback", "", "isTextPercentage", "", "(Ljava/lang/Long;Ljava/lang/Long;Landroidx/core/widget/ContentLoadingProgressBar;Landroid/widget/TextView;Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "setUpMaterialButton", "downloadButton", "Lcom/google/android/material/button/MaterialButton;", "(Ljava/lang/Long;Ljava/lang/Long;Landroidx/core/widget/ContentLoadingProgressBar;Lcom/google/android/material/button/MaterialButton;Landroid/widget/TextView;Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;Lkotlin/jvm/functions/Function1;)V", "setUpMoreButton", "textViewProgress", "clickableView", "(Ljava/lang/Long;Ljava/lang/Long;Landroidx/core/widget/ContentLoadingProgressBar;Landroid/widget/ImageView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;ZLcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;Lkotlin/jvm/functions/Function1;)V", "IMinimumData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton */
/* loaded from: classes3.dex */
public final class EasyDownloadButton implements IDisposable {
    private Function1<? super Triple<Integer, Long, Long>, Unit> downloadProgressEventListener;
    private Function1<? super Tuples<Integer, ? extends VideoDownloadManager.DownloadType>, Unit> downloadStatusEventListener;

    /* compiled from: EasyDownloadButton.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton$IMinimumData;", "", "id", "", "getId", "()I", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$IMinimumData */
    /* loaded from: classes3.dex */
    public interface IMinimumData {
        int getId();
    }

    /* compiled from: EasyDownloadButton.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.EasyDownloadButton$WhenMappings */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[VideoDownloadManager.DownloadType.values().length];
            iArr[VideoDownloadManager.DownloadType.IsPaused.ordinal()] = 1;
            iArr[VideoDownloadManager.DownloadType.IsDownloading.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.lagradost.cloudstream3.utils.IDisposable
    public void dispose() {
        try {
            Function1<? super Triple<Integer, Long, Long>, Unit> function1 = this.downloadProgressEventListener;
            if (function1 != null) {
                VideoDownloadManager.INSTANCE.getDownloadProgressEvent().minusAssign(function1);
            }
            Function1<? super Tuples<Integer, ? extends VideoDownloadManager.DownloadType>, Unit> function12 = this.downloadStatusEventListener;
            if (function12 != null) {
                VideoDownloadManager.INSTANCE.getDownloadStatusEvent().minusAssign(function12);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setUpMaterialButton(Long l, Long l2, ContentLoadingProgressBar progressBar, MaterialButton downloadButton, TextView textView, IMinimumData data, Function1<? super DownloadClickEvent, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(downloadButton, "downloadButton");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        setUpDownloadButton$default(this, l, l2, progressBar, textView, data, downloadButton, new EasyDownloadButton$setUpMaterialButton$1(downloadButton), clickCallback, false, 256, null);
    }

    public final void setUpMoreButton(Long l, Long l2, ContentLoadingProgressBar progressBar, ImageView downloadImage, TextView textView, TextView textView2, View clickableView, boolean z, IMinimumData data, Function1<? super DownloadClickEvent, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(downloadImage, "downloadImage");
        Intrinsics.checkNotNullParameter(clickableView, "clickableView");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        setUpDownloadButton(l, l2, progressBar, textView2, data, clickableView, new EasyDownloadButton$setUpMoreButton$1(downloadImage, textView2, textView), clickCallback, z);
    }

    public final void setUpButton(Long l, Long l2, ContentLoadingProgressBar progressBar, ImageView downloadImage, TextView textView, IMinimumData data, Function1<? super DownloadClickEvent, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(downloadImage, "downloadImage");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        setUpDownloadButton$default(this, l, l2, progressBar, textView, data, downloadImage, new EasyDownloadButton$setUpButton$1(downloadImage), clickCallback, false, 256, null);
    }

    static /* synthetic */ void setUpDownloadButton$default(EasyDownloadButton easyDownloadButton, Long l, Long l2, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView, IMinimumData iMinimumData, View view, Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        easyDownloadButton.setUpDownloadButton(l, l2, contentLoadingProgressBar, textView, iMinimumData, view, function1, function12, (i & 256) != 0 ? false : z);
    }

    private final void setUpDownloadButton(Long l, Long l2, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView, final IMinimumData iMinimumData, View view, Function1<? super Tuples<Integer, String>, Unit> function1, final Function1<? super DownloadClickEvent, Unit> function12, boolean z) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = l != null ? l.longValue() : 0L;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = l2 != null ? l2.longValue() : 0L;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        setUpDownloadButton$fixDownloadedBytes(longRef, longRef2, textView, contentLoadingProgressBar, objectRef, iMinimumData, z, booleanRef, function1, view, longRef.element, longRef2.element, false);
        setUpDownloadButton$changeDownloadImage(objectRef, longRef, booleanRef, function1, view, VideoDownloadManager.INSTANCE.getDownloadState(iMinimumData.getId()));
        this.downloadProgressEventListener = new EasyDownloadButton$setUpDownloadButton$1(iMinimumData, longRef, longRef2, textView, contentLoadingProgressBar, objectRef, z, booleanRef, function1, view);
        this.downloadStatusEventListener = new EasyDownloadButton$setUpDownloadButton$2(iMinimumData, objectRef, booleanRef, longRef, function1, view);
        Function1<? super Triple<Integer, Long, Long>, Unit> function13 = this.downloadProgressEventListener;
        if (function13 != null) {
            VideoDownloadManager.INSTANCE.getDownloadProgressEvent().plusAssign(function13);
        }
        Function1<? super Tuples<Integer, ? extends VideoDownloadManager.DownloadType>, Unit> function14 = this.downloadStatusEventListener;
        if (function14 != null) {
            VideoDownloadManager.INSTANCE.getDownloadStatusEvent().plusAssign(function14);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$EasyDownloadButton$kAjeoHdwtOczFLX6ZmKGYq1kvM4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EasyDownloadButton.m8628setUpDownloadButton$lambda5(Ref.LongRef.this, function12, iMinimumData, longRef2, objectRef, view2);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$EasyDownloadButton$MhVdXPS05AYQBBbLiWS_pz4raR0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8629setUpDownloadButton$lambda6;
                m8629setUpDownloadButton$lambda6 = EasyDownloadButton.m8629setUpDownloadButton$lambda6(Function1.this, iMinimumData, view2);
                return m8629setUpDownloadButton$lambda6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void setUpDownloadButton$changeDownloadImage(Ref.ObjectRef<VideoDownloadManager.DownloadType> objectRef, Ref.LongRef longRef, Ref.BooleanRef booleanRef, Function1<? super Tuples<Integer, String>, Unit> function1, View view, VideoDownloadManager.DownloadType downloadType) {
        Tuples tuples;
        objectRef.element = downloadType;
        if (longRef.element <= 0) {
            booleanRef.element = true;
        }
        if (longRef.element > 0) {
            int i = WhenMappings.$EnumSwitchMapping$0[downloadType.ordinal()];
            if (i == 1) {
                tuples = new Tuples(Integer.valueOf((int) R.drawable.ic_baseline_play_arrow_24), Integer.valueOf((int) R.string.download_paused));
            } else if (i == 2) {
                tuples = new Tuples(Integer.valueOf((int) R.drawable.netflix_pause), Integer.valueOf((int) R.string.downloading));
            } else {
                tuples = new Tuples(Integer.valueOf((int) R.drawable.ic_baseline_delete_outline_24), Integer.valueOf((int) R.string.downloaded));
            }
        } else {
            tuples = new Tuples(Integer.valueOf((int) R.drawable.netflix_download), Integer.valueOf((int) R.string.download));
        }
        function1.invoke(new Tuples(tuples.getFirst(), view.getContext().getString(((Number) tuples.getSecond()).intValue())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUpDownloadButton$fixDownloadedBytes(Ref.LongRef longRef, Ref.LongRef longRef2, TextView textView, ContentLoadingProgressBar contentLoadingProgressBar, Ref.ObjectRef<VideoDownloadManager.DownloadType> objectRef, IMinimumData iMinimumData, boolean z, Ref.BooleanRef booleanRef, Function1<? super Tuples<Integer, String>, Unit> function1, View view, long j, long j2, boolean z2) {
        String str;
        String str2;
        String string;
        longRef.element = j;
        longRef2.element = j2;
        if (longRef.element == 0) {
            setUpDownloadButton$changeDownloadImage(objectRef, longRef, booleanRef, function1, view, VideoDownloadManager.DownloadType.IsStopped);
            if (textView != null) {
                textView.setVisibility(8);
            }
            contentLoadingProgressBar.setVisibility(8);
            return;
        }
        if (objectRef.element == VideoDownloadManager.DownloadType.IsStopped) {
            setUpDownloadButton$changeDownloadImage(objectRef, longRef, booleanRef, function1, view, VideoDownloadManager.INSTANCE.getDownloadState(iMinimumData.getId()));
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        contentLoadingProgressBar.setVisibility(0);
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1000000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) j2) / 1000000.0f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
        if (textView != null) {
            if (z) {
                String format3 = String.format("%d%%", Arrays.copyOf(new Object[]{Long.valueOf((100 * j) / j2)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
                str2 = format3;
            } else {
                Context context = textView.getContext();
                if (context == null || (string = context.getString(R.string.download_size_format)) == null) {
                    str = null;
                } else {
                    str = String.format(string, Arrays.copyOf(new Object[]{format, format2}, 2));
                    Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                }
                str2 = str;
            }
            textView.setText(str2);
        }
        long j3 = 1000;
        contentLoadingProgressBar.setMax((int) (j2 / j3));
        if (z2) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(contentLoadingProgressBar, "progress", contentLoadingProgressBar.getProgress(), (int) (j / j3));
            Intrinsics.checkNotNullExpressionValue(ofInt, "ofInt(\n                 …                        )");
            ofInt.setDuration(500L);
            ofInt.setAutoCancel(true);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.start();
            return;
        }
        contentLoadingProgressBar.setProgress((int) (j / j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpDownloadButton$lambda-5  reason: not valid java name */
    public static final void m8628setUpDownloadButton$lambda5(Ref.LongRef currentBytes, Function1 clickCallback, IMinimumData data, Ref.LongRef totalBytes, Ref.ObjectRef lastState, View it) {
        Tuples tuples;
        Intrinsics.checkNotNullParameter(currentBytes, "$currentBytes");
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(totalBytes, "$totalBytes");
        Intrinsics.checkNotNullParameter(lastState, "$lastState");
        if (currentBytes.element <= 0) {
            clickCallback.invoke(new DownloadClickEvent(4, data));
            return;
        }
        ArrayList arrayListOf = CollectionsKt.arrayListOf(new Tuples(0, Integer.valueOf((int) R.string.popup_play_file)), new Tuples(1, Integer.valueOf((int) R.string.popup_delete_file)));
        if ((currentBytes.element * 100) / totalBytes.element < 98) {
            if (lastState.element == VideoDownloadManager.DownloadType.IsDownloading) {
                tuples = new Tuples(3, Integer.valueOf((int) R.string.popup_pause_download));
            } else {
                tuples = new Tuples(2, Integer.valueOf((int) R.string.popup_resume_download));
            }
            arrayListOf.add(tuples);
        }
        UIHelper uIHelper = UIHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        uIHelper.popupMenuNoIcons(it, arrayListOf, new EasyDownloadButton$setUpDownloadButton$5$1(clickCallback, data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpDownloadButton$lambda-6  reason: not valid java name */
    public static final boolean m8629setUpDownloadButton$lambda6(Function1 clickCallback, IMinimumData data, View view) {
        Intrinsics.checkNotNullParameter(clickCallback, "$clickCallback");
        Intrinsics.checkNotNullParameter(data, "$data");
        clickCallback.invoke(new DownloadClickEvent(5, data));
        return true;
    }
}
