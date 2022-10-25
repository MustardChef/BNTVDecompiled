package com.applovin.impl.mediation.debugger.p020ui.p025d;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.b */
/* loaded from: classes.dex */
public class C1451b {

    /* renamed from: a */
    public TextView f1204a;

    /* renamed from: b */
    public TextView f1205b;

    /* renamed from: c */
    public ImageView f1206c;

    /* renamed from: d */
    public ImageView f1207d;

    /* renamed from: e */
    private C1452c f1208e;

    /* renamed from: f */
    private int f1209f;

    /* renamed from: a */
    public int m7411a() {
        return this.f1209f;
    }

    /* renamed from: a */
    public void m7410a(int i) {
        this.f1209f = i;
    }

    /* renamed from: a */
    public void m7409a(C1452c c1452c) {
        this.f1208e = c1452c;
        this.f1204a.setText(c1452c.m7398k());
        this.f1204a.setTextColor(c1452c.m7396n());
        if (this.f1205b != null) {
            if (TextUtils.isEmpty(c1452c.mo7404c_())) {
                this.f1205b.setVisibility(8);
            } else {
                this.f1205b.setTypeface(null, 0);
                this.f1205b.setVisibility(0);
                this.f1205b.setText(c1452c.mo7404c_());
                this.f1205b.setTextColor(c1452c.mo7405c());
                if (c1452c.mo7403d_()) {
                    this.f1205b.setTypeface(null, 1);
                }
            }
        }
        if (this.f1206c != null) {
            if (c1452c.mo7402e() > 0) {
                this.f1206c.setImageResource(c1452c.mo7402e());
                this.f1206c.setColorFilter(c1452c.m7395o());
                this.f1206c.setVisibility(0);
            } else {
                this.f1206c.setVisibility(8);
            }
        }
        if (this.f1207d != null) {
            if (c1452c.mo7364f() <= 0) {
                this.f1207d.setVisibility(8);
                return;
            }
            this.f1207d.setImageResource(c1452c.mo7364f());
            this.f1207d.setColorFilter(c1452c.mo7363g());
            this.f1207d.setVisibility(0);
        }
    }

    /* renamed from: b */
    public C1452c m7408b() {
        return this.f1208e;
    }
}
