package com.applovin.impl.sdk.p028b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.b.b */
/* loaded from: classes.dex */
public class C1554b {

    /* renamed from: a */
    private final C1662k f1580a;

    /* renamed from: b */
    private final Activity f1581b;

    /* renamed from: c */
    private AlertDialog f1582c;

    /* renamed from: d */
    private InterfaceC1564a f1583d;

    /* renamed from: com.applovin.impl.sdk.b.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1564a {
        /* renamed from: a */
        void mo7023a();

        /* renamed from: b */
        void mo7022b();
    }

    public C1554b(Activity activity, C1662k c1662k) {
        this.f1580a = c1662k;
        this.f1581b = activity;
    }

    /* renamed from: a */
    public void m7034a() {
        this.f1581b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (C1554b.this.f1582c != null) {
                    C1554b.this.f1582c.dismiss();
                }
            }
        });
    }

    /* renamed from: a */
    public void m7033a(final AbstractC1537g abstractC1537g, final Runnable runnable) {
        this.f1581b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.b.4
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(C1554b.this.f1581b);
                builder.setTitle(abstractC1537g.m7112an());
                String m7111ao = abstractC1537g.m7111ao();
                if (AppLovinSdkUtils.isValidString(m7111ao)) {
                    builder.setMessage(m7111ao);
                }
                builder.setPositiveButton(abstractC1537g.m7110ap(), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.b.4.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                builder.setCancelable(false);
                C1554b.this.f1582c = builder.show();
            }
        });
    }

    /* renamed from: a */
    public void m7032a(InterfaceC1564a interfaceC1564a) {
        this.f1583d = interfaceC1564a;
    }

    /* renamed from: b */
    public void m7029b() {
        this.f1581b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                C1554b.this.f1582c = new AlertDialog.Builder(C1554b.this.f1581b).setTitle((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1750bq)).setMessage((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1751br)).setCancelable(false).setPositiveButton((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1753bt), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.b.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1554b.this.f1583d.mo7023a();
                    }
                }).setNegativeButton((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1752bs), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.b.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1554b.this.f1583d.mo7022b();
                    }
                }).show();
            }
        });
    }

    /* renamed from: c */
    public void m7027c() {
        this.f1581b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(C1554b.this.f1581b);
                builder.setTitle((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1755bv));
                builder.setMessage((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1756bw));
                builder.setCancelable(false);
                builder.setPositiveButton((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1758by), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.b.3.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1554b.this.f1583d.mo7023a();
                    }
                });
                builder.setNegativeButton((CharSequence) C1554b.this.f1580a.m6656a(C1568b.f1757bx), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.b.b.3.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        C1554b.this.f1583d.mo7022b();
                    }
                });
                C1554b.this.f1582c = builder.show();
            }
        });
    }

    /* renamed from: d */
    public boolean m7025d() {
        AlertDialog alertDialog = this.f1582c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
