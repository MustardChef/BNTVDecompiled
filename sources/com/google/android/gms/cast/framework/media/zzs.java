package com.google.android.gms.cast.framework.media;

import android.util.LruCache;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzs extends LruCache<Integer, MediaQueueItem> {
    final /* synthetic */ MediaQueue zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(MediaQueue mediaQueue, int i) {
        super(i);
        this.zza = mediaQueue;
    }

    @Override // android.util.LruCache
    protected final /* bridge */ /* synthetic */ void entryRemoved(boolean z, Integer num, MediaQueueItem mediaQueueItem, MediaQueueItem mediaQueueItem2) {
        Integer num2 = num;
        if (z) {
            Preconditions.checkNotNull(this.zza.zze);
            this.zza.zze.add(num2);
        }
    }
}
