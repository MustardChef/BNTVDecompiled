package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anu */
/* loaded from: classes2.dex */
public final class anu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f4737a;

    /* renamed from: b */
    final /* synthetic */ anw f4738b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anu(anw anwVar, int i) {
        this.f4738b = anwVar;
        this.f4737a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        afr afrVar;
        anw anwVar = this.f4738b;
        int i = this.f4737a;
        if (i > 0) {
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = anwVar.f4742a.getPackageManager().getPackageInfo(anwVar.f4742a.getPackageName(), 0);
            Context context = anwVar.f4742a;
            afrVar = arz.m4702b(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            afrVar = null;
        }
        this.f4738b.f4753m = afrVar;
        if (this.f4737a < 4) {
            if (afrVar != null && afrVar.m5566ae() && !afrVar.m5552f().equals("0000000000000000000000000000000000000000000000000000000000000000") && afrVar.m5565af() && afrVar.m5554d().m5505d() && afrVar.m5554d().m5508a() != -2) {
                return;
            }
            this.f4738b.m4891s(this.f4737a + 1);
        }
    }
}
