package com.lagradost.cloudstream3.p041ui;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m107d2 = {"getItemIndex", "", "Lcom/google/android/gms/cast/framework/media/RemoteMediaClient;", "(Lcom/google/android/gms/cast/framework/media/RemoteMediaClient;)Ljava/lang/Integer;", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.ControllerActivityKt */
/* loaded from: classes.dex */
public final class ControllerActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getItemIndex(RemoteMediaClient remoteMediaClient) {
        try {
            int[] itemIds = remoteMediaClient.getMediaQueue().getItemIds();
            Intrinsics.checkNotNullExpressionValue(itemIds, "this.mediaQueue.itemIds");
            MediaQueueItem currentItem = remoteMediaClient.getCurrentItem();
            int indexOf = ArraysKt.indexOf(itemIds, currentItem != null ? currentItem.getItemId() : 0);
            if (indexOf < 0) {
                return null;
            }
            return Integer.valueOf(indexOf);
        } catch (Exception unused) {
            return null;
        }
    }
}
