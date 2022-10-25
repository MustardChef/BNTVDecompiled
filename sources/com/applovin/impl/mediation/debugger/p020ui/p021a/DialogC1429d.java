package com.applovin.impl.mediation.debugger.p020ui.p021a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.d */
/* loaded from: classes.dex */
public class DialogC1429d extends Dialog {

    /* renamed from: a */
    private MaxAdView f1125a;

    /* renamed from: b */
    private MaxAdFormat f1126b;

    /* renamed from: c */
    private Activity f1127c;

    /* renamed from: d */
    private RelativeLayout f1128d;

    public DialogC1429d(MaxAdView maxAdView, MaxAdFormat maxAdFormat, Activity activity) {
        super(activity, 16973840);
        this.f1125a = maxAdView;
        this.f1126b = maxAdFormat;
        this.f1127c = activity;
        requestWindowFeature(1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f1128d.removeView(this.f1125a);
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f1127c, this.f1126b.getSize().getWidth()), AppLovinSdkUtils.dpToPx(this.f1127c, this.f1126b.getSize().getHeight()));
        layoutParams.addRule(13);
        this.f1125a.setLayoutParams(layoutParams);
        int dpToPx = AppLovinSdkUtils.dpToPx(this.f1127c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f1127c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f1127c.getResources().getDrawable(C1799R.C1801drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground(null);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.a.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1429d.this.dismiss();
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f1127c);
        this.f1128d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f1128d.setBackgroundColor(Integer.MIN_VALUE);
        this.f1128d.addView(imageButton);
        this.f1128d.addView(this.f1125a);
        this.f1128d.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.ui.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1429d.this.dismiss();
            }
        });
        setContentView(this.f1128d);
    }
}
