package com.lagradost.cloudstream3.utils;

import android.content.Context;
import com.bongngotv2.R;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.lagradost.cloudstream3.p041ui.ControllerActivity;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: CastOptionsProvider.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/CastOptionsProvider;", "Lcom/google/android/gms/cast/framework/OptionsProvider;", "()V", "getAdditionalSessionProviders", "", "Lcom/google/android/gms/cast/framework/SessionProvider;", "p0", "Landroid/content/Context;", "getCastOptions", "Lcom/google/android/gms/cast/framework/CastOptions;", "context", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CastOptionsProvider implements OptionsProvider {
    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public CastOptions getCastOptions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationOptions.Builder builder = new NotificationOptions.Builder();
        String qualifiedName = Reflection.getOrCreateKotlinClass(ControllerActivity.class).getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        CastMediaOptions.Builder notificationOptions = new CastMediaOptions.Builder().setNotificationOptions(builder.setTargetActivityClassName(qualifiedName).setActions(CollectionsKt.listOf((Object[]) new String[]{MediaIntentReceiver.ACTION_REWIND, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_FORWARD, MediaIntentReceiver.ACTION_STOP_CASTING}), new int[]{1, 3}).setForward30DrawableResId(R.drawable.go_forward_30).setRewind30DrawableResId(R.drawable.go_back_30).setSkipStepMs(30000L).build());
        String qualifiedName2 = Reflection.getOrCreateKotlinClass(ControllerActivity.class).getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName2);
        CastOptions build = new CastOptions.Builder().setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID).setStopReceiverApplicationWhenEndingSession(true).setCastMediaOptions(notificationOptions.setExpandedControllerActivityClassName(qualifiedName2).build()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ons)\n            .build()");
        return build;
    }

    @Override // com.google.android.gms.cast.framework.OptionsProvider
    public List<SessionProvider> getAdditionalSessionProviders(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return Collections.emptyList();
    }
}
