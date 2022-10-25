package com.applovin.impl.adview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.AbstractC1252j;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.adview.m */
/* loaded from: classes.dex */
public class DialogC1259m extends Dialog implements InterfaceC1258l {

    /* renamed from: a */
    private final Activity f619a;

    /* renamed from: b */
    private final C1662k f620b;

    /* renamed from: c */
    private final C1710r f621c;

    /* renamed from: d */
    private final C1238d f622d;

    /* renamed from: e */
    private final C1527a f623e;

    /* renamed from: f */
    private RelativeLayout f624f;

    /* renamed from: g */
    private AbstractC1252j f625g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogC1259m(C1527a c1527a, C1238d c1238d, Activity activity, C1662k c1662k) {
        super(activity, 16973840);
        if (c1527a == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (c1238d == null) {
            throw new IllegalArgumentException("No main view specified");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f620b = c1662k;
        this.f621c = c1662k.m6588z();
        this.f619a = activity;
        this.f622d = c1238d;
        this.f623e = c1527a;
        requestWindowFeature(1);
        setCancelable(false);
    }

    /* renamed from: a */
    private int m8039a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f619a, i);
    }

    /* renamed from: a */
    private void m8038a(AbstractC1252j.EnumC1253a enumC1253a) {
        if (this.f625g != null) {
            this.f621c.m6315d("ExpandedAdDialog", "Attempting to create duplicate close button");
            return;
        }
        AbstractC1252j m8056a = AbstractC1252j.m8056a(enumC1253a, this.f619a);
        this.f625g = m8056a;
        m8056a.setVisibility(8);
        this.f625g.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.m.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1259m.this.m8034c();
            }
        });
        this.f625g.setClickable(false);
        int m8039a = m8039a(((Integer) this.f620b.m6656a(C1568b.f1721bN)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m8039a, m8039a);
        layoutParams.addRule(10);
        layoutParams.addRule(((Boolean) this.f620b.m6656a(C1568b.f1724bQ)).booleanValue() ? 9 : 11);
        this.f625g.mo7900a(m8039a);
        int m8039a2 = m8039a(((Integer) this.f620b.m6656a(C1568b.f1723bP)).intValue());
        int m8039a3 = m8039a(((Integer) this.f620b.m6656a(C1568b.f1722bO)).intValue());
        layoutParams.setMargins(m8039a3, m8039a2, m8039a3, 0);
        this.f624f.addView(this.f625g, layoutParams);
        this.f625g.bringToFront();
        int m8039a4 = m8039a(((Integer) this.f620b.m6656a(C1568b.f1725bR)).intValue());
        View view = new View(this.f619a);
        view.setBackgroundColor(0);
        int i = m8039a + m8039a4;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(10);
        layoutParams2.addRule(((Boolean) this.f620b.m6656a(C1568b.f1724bQ)).booleanValue() ? 9 : 11);
        layoutParams2.setMargins(m8039a3 - m8039a(5), m8039a2 - m8039a(5), m8039a3 - m8039a(5), 0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.m.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (DialogC1259m.this.f625g.isClickable()) {
                    DialogC1259m.this.f625g.performClick();
                }
            }
        });
        this.f624f.addView(view, layoutParams2);
        view.bringToFront();
    }

    /* renamed from: b */
    private void m8036b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f622d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f619a);
        this.f624f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f624f.setBackgroundColor(-1157627904);
        this.f624f.addView(this.f622d);
        if (!this.f623e.m7227n()) {
            m8038a(this.f623e.m7226o());
            m8032d();
        }
        setContentView(this.f624f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8034c() {
        this.f622d.m8085a("javascript:al_onCloseTapped();", new Runnable() { // from class: com.applovin.impl.adview.m.1
            @Override // java.lang.Runnable
            public void run() {
                DialogC1259m.this.dismiss();
            }
        });
    }

    /* renamed from: d */
    private void m8032d() {
        this.f619a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.m.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (DialogC1259m.this.f625g == null) {
                        DialogC1259m.this.m8034c();
                    }
                    DialogC1259m.this.f625g.setVisibility(0);
                    DialogC1259m.this.f625g.bringToFront();
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(300L);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.applovin.impl.adview.m.6.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            DialogC1259m.this.f625g.setClickable(true);
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    DialogC1259m.this.f625g.startAnimation(alphaAnimation);
                } catch (Throwable th) {
                    DialogC1259m.this.f621c.m6318b("ExpandedAdDialog", "Unable to fade in close button", th);
                    DialogC1259m.this.m8034c();
                }
            }
        });
    }

    /* renamed from: a */
    public C1527a m8040a() {
        return this.f623e;
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.applovin.impl.adview.InterfaceC1258l
    public void dismiss() {
        C1584d statsManagerHelper = this.f622d.getStatsManagerHelper();
        if (statsManagerHelper != null) {
            statsManagerHelper.m6915e();
        }
        this.f619a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.m.3
            @Override // java.lang.Runnable
            public void run() {
                DialogC1259m.this.f624f.removeView(DialogC1259m.this.f622d);
                DialogC1259m.super.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f622d.m8085a("javascript:al_onBackPressed();", new Runnable() { // from class: com.applovin.impl.adview.m.2
            @Override // java.lang.Runnable
            public void run() {
                DialogC1259m.this.dismiss();
            }
        });
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m8036b();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f619a.getWindow().getAttributes().flags, this.f619a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else {
                this.f621c.m6314e("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            this.f621c.m6318b("ExpandedAdDialog", "Setting window flags failed.", th);
        }
    }
}
