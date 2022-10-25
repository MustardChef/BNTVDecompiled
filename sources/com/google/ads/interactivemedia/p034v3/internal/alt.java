package com.google.ads.interactivemedia.p034v3.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.ads.interactivemedia.p034v3.impl.data.C2491bi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alt */
/* loaded from: classes2.dex */
public final class alt {

    /* renamed from: a */
    private final ayr f4405a;

    /* renamed from: b */
    private final float f4406b;

    public alt(ExecutorService executorService, float f) {
        this.f4406b = f;
        this.f4405a = ayu.m4319a(executorService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ Bitmap m5018a(String str, C2491bi c2491bi) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        if (decodeStream == null) {
            return null;
        }
        return (c2491bi.width == decodeStream.getWidth() && c2491bi.height == decodeStream.getHeight() && !axj.m4382a((double) this.f4406b)) ? Bitmap.createScaledBitmap(decodeStream, (int) (this.f4406b * decodeStream.getWidth()), (int) (this.f4406b * decodeStream.getHeight()), true) : decodeStream;
    }

    /* renamed from: b */
    public final Task m5017b(final String str, final C2491bi c2491bi) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        ayu.m4316d(this.f4405a.mo4320a(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.alr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return alt.this.m5018a(str, c2491bi);
            }
        }), new als(taskCompletionSource, str), this.f4405a);
        return taskCompletionSource.getTask();
    }
}
