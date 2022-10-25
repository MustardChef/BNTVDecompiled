package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.C1760m;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.i */
/* loaded from: classes.dex */
public class C1650i implements AppLovinBroadcastManager.Receiver {

    /* renamed from: b */
    private static AlertDialog f2213b;

    /* renamed from: c */
    private static final AtomicBoolean f2214c = new AtomicBoolean();

    /* renamed from: a */
    private final C1656j f2215a;

    /* renamed from: d */
    private C1760m f2216d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.applovin.impl.sdk.i$1 */
    /* loaded from: classes.dex */
    public class RunnableC16511 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1662k f2217a;

        /* renamed from: b */
        final /* synthetic */ InterfaceC1655a f2218b;

        RunnableC16511(C1662k c1662k, InterfaceC1655a interfaceC1655a) {
            this.f2217a = c1662k;
            this.f2218b = interfaceC1655a;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1710r m6588z;
            String str;
            if (C1650i.this.f2215a.m6692c()) {
                this.f2217a.m6588z().m6314e("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                return;
            }
            Activity m7240a = this.f2217a.m6636ad().m7240a();
            if (m7240a != null && C1725g.m6267a(this.f2217a.m6677J())) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.i.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertDialog unused = C1650i.f2213b = new AlertDialog.Builder(RunnableC16511.this.f2217a.m6636ad().m7240a()).setTitle((CharSequence) RunnableC16511.this.f2217a.m6656a(C1568b.f1657aC)).setMessage((CharSequence) RunnableC16511.this.f2217a.m6656a(C1568b.f1658aD)).setCancelable(false).setPositiveButton((CharSequence) RunnableC16511.this.f2217a.m6656a(C1568b.f1659aE), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.i.1.1.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                RunnableC16511.this.f2218b.mo6705a();
                                dialogInterface.dismiss();
                                C1650i.f2214c.set(false);
                            }
                        }).setNegativeButton((CharSequence) RunnableC16511.this.f2217a.m6656a(C1568b.f1660aF), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.i.1.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                RunnableC16511.this.f2218b.mo6694b();
                                dialogInterface.dismiss();
                                C1650i.f2214c.set(false);
                                C1650i.this.m6709a(((Long) RunnableC16511.this.f2217a.m6656a(C1568b.f1655aA)).longValue(), RunnableC16511.this.f2217a, RunnableC16511.this.f2218b);
                            }
                        }).create();
                        C1650i.f2213b.show();
                    }
                });
                return;
            }
            if (m7240a == null) {
                m6588z = this.f2217a.m6588z();
                str = "No parent Activity found - rescheduling consent alert...";
            } else {
                m6588z = this.f2217a.m6588z();
                str = "No internet available - rescheduling consent alert...";
            }
            m6588z.m6314e("ConsentAlertManager", str);
            C1650i.f2214c.set(false);
            C1650i.this.m6709a(((Long) this.f2217a.m6656a(C1568b.f1656aB)).longValue(), this.f2217a, this.f2218b);
        }
    }

    /* renamed from: com.applovin.impl.sdk.i$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1655a {
        /* renamed from: a */
        void mo6705a();

        /* renamed from: b */
        void mo6694b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1650i(C1656j c1656j, C1662k c1662k) {
        this.f2215a = c1656j;
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        c1662k.m6631ai().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    /* renamed from: a */
    public void m6709a(long j, C1662k c1662k, InterfaceC1655a interfaceC1655a) {
        if (j <= 0) {
            return;
        }
        AlertDialog alertDialog = f2213b;
        if (alertDialog == null || !alertDialog.isShowing()) {
            if (f2214c.getAndSet(true)) {
                if (j >= this.f2216d.m6177a()) {
                    C1710r m6588z = c1662k.m6588z();
                    m6588z.m6315d("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.f2216d.m6177a() + " milliseconds");
                    return;
                }
                C1710r m6588z2 = c1662k.m6588z();
                m6588z2.m6319b("ConsentAlertManager", "Scheduling consent alert earlier (" + j + "ms) than remaining scheduled time (" + this.f2216d.m6177a() + "ms)");
                this.f2216d.m6169d();
            }
            C1710r m6588z3 = c1662k.m6588z();
            m6588z3.m6319b("ConsentAlertManager", "Scheduling consent alert for " + j + " milliseconds");
            this.f2216d = C1760m.m6176a(j, c1662k, new RunnableC16511(c1662k, interfaceC1655a));
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        if (this.f2216d == null) {
            return;
        }
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f2216d.m6173b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f2216d.m6171c();
        }
    }
}
