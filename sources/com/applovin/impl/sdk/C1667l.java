package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1726h;
import com.applovin.impl.sdk.utils.C1757j;
import com.applovin.impl.sdk.utils.C1760m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.l */
/* loaded from: classes.dex */
public class C1667l implements AppLovinCommunicatorSubscriber, C1726h.InterfaceC1727a {

    /* renamed from: a */
    private final C1662k f2302a;

    /* renamed from: b */
    private Object f2303b;

    /* renamed from: c */
    private WeakReference<View> f2304c = new WeakReference<>(null);

    /* renamed from: d */
    private String f2305d;

    /* renamed from: e */
    private C1726h f2306e;

    /* renamed from: f */
    private C1760m f2307f;

    /* renamed from: g */
    private int f2308g;

    public C1667l(C1662k c1662k) {
        this.f2302a = c1662k;
        AppLovinCommunicator.getInstance(c1662k.m6677J()).subscribe(this, "safedk_ad_info");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private View m6585a(final Activity activity) {
        Button button;
        int dpToPx = AppLovinSdkUtils.dpToPx(activity, 40);
        int i = dpToPx / 10;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, 8388629);
        layoutParams.setMargins(i, i, i, i);
        try {
            ImageButton imageButton = new ImageButton(activity);
            imageButton.setImageDrawable(activity.getResources().getDrawable(C1799R.C1801drawable.applovin_ic_white_small));
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageButton.setPadding(i, i, i, i * 2);
            button = imageButton;
        } catch (Resources.NotFoundException unused) {
            Button button2 = new Button(activity);
            button2.setText("ⓘ");
            button2.setTextColor(-1);
            button2.setAllCaps(false);
            button2.setTextSize(2, 20.0f);
            button2.setPadding(0, 0, 0, 0);
            button = button2;
        }
        button.setLayoutParams(layoutParams);
        button.setBackground(m6575e());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.sdk.l.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1667l.this.m6584a((Context) activity);
            }
        });
        if (C1724f.m6275d()) {
            button.setElevation(AppLovinSdkUtils.dpToPx(activity, 5));
        }
        return button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6584a(Context context) {
        final String m6574f = m6574f();
        final WeakReference weakReference = new WeakReference(context);
        new AlertDialog.Builder(context).setTitle("Ad Info").setMessage(m6574f).setNegativeButton("Close", (DialogInterface.OnClickListener) null).setPositiveButton("Report", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.l.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (weakReference.get() != null) {
                    C1667l.this.m6583a((Context) weakReference.get(), m6574f);
                }
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6583a(Context context, String str) {
        C1757j c1757j = new C1757j();
        c1757j.m6191b("Describe your issue below:\n\n\n").m6195a("Ad Info:").m6195a(str).m6195a("\nDebug Info:\n").m6194a("Platform", "Android").m6194a("AppLovin SDK Version", AppLovinSdk.VERSION).m6194a("Plugin Version", this.f2302a.m6656a(C1568b.f1863dz)).m6194a("Ad Review Version", Utils.getSafedkVersion()).m6194a("App Package Name", context.getPackageName()).m6194a("Device", Build.DEVICE).m6194a("OS Version", Build.VERSION.RELEASE).m6194a("AppLovin Random Token", this.f2302a.m6599o());
        if (this.f2305d != null) {
            c1757j.m6195a("\nSafeDK Ad Info:\n");
            c1757j.m6195a(this.f2305d);
        }
        Intent intent = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.SUBJECT", "MAX Ad Report").setPackage("com.google.android.gm");
        if (this.f2303b instanceof AbstractC1537g) {
            intent.putExtra("android.intent.extra.SUBJECT", "AppLovin Ad Report");
            JSONObject mo7099b = ((AbstractC1537g) this.f2303b).mo7099b();
            Uri cacheTextWithFileName = AppLovinContentProviderUtils.cacheTextWithFileName(mo7099b.toString(), "ad_response.json");
            if (cacheTextWithFileName != null) {
                intent.putExtra("android.intent.extra.STREAM", cacheTextWithFileName);
            } else {
                c1757j.m6195a("\nAd Response:\n");
                c1757j.m6195a(mo7099b.toString());
            }
        }
        intent.putExtra("android.intent.extra.TEXT", c1757j.toString());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setPackage(null);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6576d() {
        if (this.f2302a.m6637ac().m6332b() && this.f2304c.get() == null) {
            Activity m7240a = this.f2302a.m6636ad().m7240a();
            View findViewById = m7240a.findViewById(16908290);
            if (findViewById instanceof FrameLayout) {
                C1710r m6588z = this.f2302a.m6588z();
                m6588z.m6319b("AppLovinSdk", "Displaying creative debugger button for ad: " + this.f2303b);
                final FrameLayout frameLayout = (FrameLayout) findViewById;
                final View m6585a = m6585a(m7240a);
                frameLayout.addView(m6585a);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(150L);
                m6585a.startAnimation(alphaAnimation);
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.applovin.impl.sdk.l.3
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (m6585a.getParent() == null) {
                            frameLayout.addView(m6585a);
                        }
                    }
                });
                this.f2304c = new WeakReference<>(m6585a);
            }
        }
    }

    /* renamed from: e */
    private Drawable m6575e() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* renamed from: f */
    private String m6574f() {
        C1757j c1757j = new C1757j();
        Object obj = this.f2303b;
        if (obj instanceof AbstractC1537g) {
            AbstractC1537g abstractC1537g = (AbstractC1537g) obj;
            c1757j.m6194a("Network", "APPLOVIN").m6197a(abstractC1537g).m6192b(abstractC1537g);
        } else if (obj instanceof AbstractC1334a) {
            c1757j.m6198a((AbstractC1334a) obj);
        }
        c1757j.m6196a(this.f2302a);
        return c1757j.toString();
    }

    /* renamed from: a */
    public void m6586a() {
        C1726h c1726h = this.f2306e;
        if (c1726h != null) {
            c1726h.m6245b();
        }
        this.f2303b = null;
        this.f2304c = new WeakReference<>(null);
        this.f2305d = null;
    }

    /* renamed from: a */
    public void m6578a(Object obj) {
        if (C1391c.m7594b(obj)) {
            return;
        }
        this.f2303b = obj;
        if (((Boolean) this.f2302a.m6656a(C1568b.f1710bC)).booleanValue() && this.f2302a.m6598p().isCreativeDebuggerEnabled()) {
            if (this.f2306e == null) {
                this.f2306e = new C1726h(this.f2302a, this);
            }
            this.f2306e.m6246a();
        }
    }

    @Override // com.applovin.impl.sdk.utils.C1726h.InterfaceC1727a
    /* renamed from: b */
    public void mo6244b() {
        if (this.f2308g == 0) {
            this.f2307f = C1760m.m6176a(TimeUnit.SECONDS.toMillis(3L), this.f2302a, new Runnable() { // from class: com.applovin.impl.sdk.l.1
                @Override // java.lang.Runnable
                public void run() {
                    C1667l.this.f2308g = 0;
                }
            });
        }
        int i = this.f2308g;
        if (i % 2 == 0) {
            this.f2308g = i + 1;
        }
    }

    @Override // com.applovin.impl.sdk.utils.C1726h.InterfaceC1727a
    /* renamed from: c */
    public void mo6243c() {
        int i = this.f2308g;
        if (i % 2 == 1) {
            this.f2308g = i + 1;
        }
        if (this.f2308g / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.l.2
                @Override // java.lang.Runnable
                public void run() {
                    C1667l.this.f2302a.m6634af().m6731a(new Bundle(), "show_creative_debugger");
                    C1667l.this.m6576d();
                }
            });
            this.f2308g = 0;
            this.f2307f.m6169d();
            this.f2306e.m6245b();
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return C1667l.class.getSimpleName();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("safedk_ad_info".equals(appLovinCommunicatorMessage.getTopic())) {
            this.f2305d = appLovinCommunicatorMessage.getMessageData().toString();
        }
    }
}
