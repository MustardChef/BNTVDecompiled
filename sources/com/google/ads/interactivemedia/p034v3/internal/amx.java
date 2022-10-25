package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.amx */
/* loaded from: classes2.dex */
public final class amx extends anb {

    /* renamed from: w */
    private AdvertisingIdClient.Info f4682w;

    protected amx(Context context) {
        super(context);
    }

    /* renamed from: j */
    public static amx m4979j(Context context) {
        m4934v(context, true);
        return new amx(context);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.anb, com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: c */
    protected final aga mo4942c(Context context, View view, Activity activity) {
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.anb, com.google.ads.interactivemedia.p034v3.internal.amw
    /* renamed from: i */
    protected final aga mo4940i(Context context, View view, Activity activity) {
        return null;
    }

    /* renamed from: m */
    public final String m4978m(String str, String str2) {
        byte[] m5003e = ama.m5003e(str, str2);
        if (m5003e != null) {
            return C2467al.m6016a(m5003e, true);
        }
        return Integer.toString(7);
    }

    /* renamed from: o */
    public final void m4977o(AdvertisingIdClient.Info info) {
        this.f4682w = info;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.anb
    /* renamed from: p */
    public final List mo4930p(anw anwVar, Context context, aga agaVar, afd afdVar) {
        ArrayList arrayList = new ArrayList();
        if (anwVar.m4900j() == null) {
            return arrayList;
        }
        arrayList.add(new aol(anwVar, agaVar, anwVar.m4909a(), null, null, null));
        return arrayList;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.anb
    /* renamed from: r */
    protected final void mo4937r(anw anwVar, Context context, aga agaVar, afd afdVar) {
        if (!anwVar.f4743b) {
            m4933w(mo4930p(anwVar, context, agaVar, afdVar));
            return;
        }
        AdvertisingIdClient.Info info = this.f4682w;
        if (info != null) {
            String id = info.getId();
            if (!TextUtils.isEmpty(id)) {
                agaVar.m5440Y(anz.m4872d(id));
                agaVar.m5432aF(afk.f3718f);
                agaVar.m5441X(this.f4682w.isLimitAdTrackingEnabled());
            }
            this.f4682w = null;
        }
    }
}
