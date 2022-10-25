package com.lagradost.cloudstream3.p041ui;

import android.view.View;
import android.widget.ImageView;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/SkipTimeController;", "Lcom/google/android/gms/cast/framework/media/uicontroller/UIController;", ViewHierarchyConstants.VIEW_KEY, "Landroid/widget/ImageView;", "forwards", "", "(Landroid/widget/ImageView;Z)V", "getView", "()Landroid/widget/ImageView;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.SkipTimeController */
/* loaded from: classes.dex */
public final class SkipTimeController extends UIController {
    private final ImageView view;

    public SkipTimeController(ImageView view, final boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        view.setImageResource(z ? R.drawable.go_forward_30 : R.drawable.go_back_30);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.-$$Lambda$SkipTimeController$Jhvvvc5iy_dJvgzKAvUi0qDqmVA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SkipTimeController.m8614_init_$lambda1(SkipTimeController.this, r2, z, view2);
            }
        });
    }

    public final ImageView getView() {
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m8614_init_$lambda1(SkipTimeController this$0, int i, boolean z, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RemoteMediaClient remoteMediaClient = this$0.getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.seek(new MediaSeekOptions.Builder().setPosition(remoteMediaClient.getApproximateStreamPosition() + (i * 1000 * (z ? 1 : -1))).build());
        }
    }
}
