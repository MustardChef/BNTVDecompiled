package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.MediaQueue;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzx extends MediaQueue.Callback {
    final /* synthetic */ MediaQueueRecyclerViewAdapter zza;

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsInsertedInRange(int i, int i2) {
        this.zza.notifyItemRangeInserted(i, i2);
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsRemovedAtIndexes(int[] iArr) {
        int length = iArr.length;
        if (length > 1) {
            this.zza.notifyDataSetChanged();
            return;
        }
        for (int i = 0; i < length; i = 1) {
            this.zza.notifyItemRemoved(iArr[0]);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsUpdatedAtIndexes(int[] iArr) {
        for (int i : iArr) {
            this.zza.notifyItemChanged(i);
        }
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void mediaQueueChanged() {
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void mediaQueueWillChange() {
    }
}
