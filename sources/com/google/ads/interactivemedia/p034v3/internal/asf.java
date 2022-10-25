package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.asf */
/* loaded from: classes2.dex */
public final class asf {

    /* renamed from: a */
    private final Context f4977a;

    /* renamed from: b */
    private final Executor f4978b;

    /* renamed from: c */
    private final art f4979c;

    /* renamed from: d */
    private final arv f4980d;

    /* renamed from: e */
    private final ase f4981e;

    /* renamed from: f */
    private final ase f4982f;

    /* renamed from: g */
    private Task f4983g;

    /* renamed from: h */
    private Task f4984h;

    asf(Context context, Executor executor, art artVar, arv arvVar, asc ascVar, asd asdVar) {
        this.f4977a = context;
        this.f4978b = executor;
        this.f4979c = artVar;
        this.f4980d = arvVar;
        this.f4981e = ascVar;
        this.f4982f = asdVar;
    }

    /* renamed from: e */
    public static asf m4695e(Context context, Executor executor, art artVar, arv arvVar) {
        final asf asfVar = new asf(context, executor, artVar, arvVar, new asc(), new asd());
        if (asfVar.f4980d.m4714d()) {
            asfVar.f4983g = asfVar.m4692h(new Callable(asfVar) { // from class: com.google.ads.interactivemedia.v3.internal.asb

                /* renamed from: a */
                public final /* synthetic */ asf f4973a;

                {
                    this.f4973a = asfVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return r2 != 0 ? this.f4973a.m4697c() : this.f4973a.m4696d();
                }
            });
        } else {
            asfVar.f4983g = Tasks.forResult(asfVar.f4981e.mo4700a());
        }
        asfVar.f4984h = asfVar.m4692h(new Callable(asfVar) { // from class: com.google.ads.interactivemedia.v3.internal.asb

            /* renamed from: a */
            public final /* synthetic */ asf f4973a;

            {
                this.f4973a = asfVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return r2 != 0 ? this.f4973a.m4697c() : this.f4973a.m4696d();
            }
        });
        return asfVar;
    }

    /* renamed from: g */
    private static afr m4693g(Task task, afr afrVar) {
        return !task.isSuccessful() ? afrVar : (afr) task.getResult();
    }

    /* renamed from: h */
    private final Task m4692h(Callable callable) {
        return Tasks.call(this.f4978b, callable).addOnFailureListener(this.f4978b, new OnFailureListener() { // from class: com.google.ads.interactivemedia.v3.internal.asa
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                asf.this.m4694f(exc);
            }
        });
    }

    /* renamed from: a */
    public final afr m4699a() {
        return m4693g(this.f4983g, this.f4981e.mo4700a());
    }

    /* renamed from: b */
    public final afr m4698b() {
        return m4693g(this.f4984h, this.f4982f.mo4700a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ afr m4697c() throws Exception {
        Context context = this.f4977a;
        aga m5557an = afr.m5557an();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            m5557an.m5440Y(id);
            m5557an.m5441X(advertisingIdInfo.isLimitAdTrackingEnabled());
            m5557an.m5432aF(afk.f3718f);
        }
        return (afr) m5557an.mo3179aR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ afr m4696d() throws Exception {
        Context context = this.f4977a;
        return arz.m4702b(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final /* synthetic */ void m4694f(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.f4979c.m4727c(2025, -1L, exc);
    }
}
