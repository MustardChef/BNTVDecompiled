package com.applovin.impl.mediation.debugger.p020ui.testmode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.C1157a;
import com.applovin.impl.sdk.utils.C1723e;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton */
/* loaded from: classes.dex */
public class AdControlButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private final Button f1260a;

    /* renamed from: b */
    private final C1157a f1261b;

    /* renamed from: c */
    private EnumC1465b f1262c;

    /* renamed from: d */
    private MaxAdFormat f1263d;

    /* renamed from: e */
    private InterfaceC1464a f1264e;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1464a {
        void onClick(AdControlButton adControlButton);
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.AdControlButton$b */
    /* loaded from: classes.dex */
    public enum EnumC1465b {
        LOAD,
        LOADING,
        SHOW
    }

    public AdControlButton(Context context) {
        this(context, null, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdControlButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Button button = new Button(getContext());
        this.f1260a = button;
        C1157a c1157a = new C1157a(getContext(), 20, 16842873);
        this.f1261b = c1157a;
        this.f1262c = EnumC1465b.LOAD;
        setBackgroundColor(0);
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1, 17));
        button.setTextColor(-1);
        button.setOnClickListener(this);
        frameLayout.addView(button, new FrameLayout.LayoutParams(-1, -1, 17));
        c1157a.setColor(-1);
        addView(c1157a, new FrameLayout.LayoutParams(-1, -1, 17));
        m7361a(EnumC1465b.LOAD);
    }

    /* renamed from: a */
    private void m7361a(EnumC1465b enumC1465b) {
        if (EnumC1465b.LOADING == enumC1465b) {
            setEnabled(false);
            this.f1261b.m8289a();
        } else {
            setEnabled(true);
            this.f1261b.m8288b();
        }
        this.f1260a.setText(m7360b(enumC1465b));
        this.f1260a.setBackgroundColor(m7359c(enumC1465b));
    }

    /* renamed from: b */
    private String m7360b(EnumC1465b enumC1465b) {
        return EnumC1465b.LOAD == enumC1465b ? "Load" : EnumC1465b.LOADING == enumC1465b ? "" : "Show";
    }

    /* renamed from: c */
    private int m7359c(EnumC1465b enumC1465b) {
        return C1723e.m6281a((EnumC1465b.LOAD == enumC1465b || EnumC1465b.LOADING == enumC1465b) ? C1799R.C1800color.applovin_sdk_brand_color : C1799R.C1800color.applovin_sdk_adControlbutton_brightBlueColor, getContext());
    }

    public EnumC1465b getControlState() {
        return this.f1262c;
    }

    public MaxAdFormat getFormat() {
        return this.f1263d;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC1464a interfaceC1464a = this.f1264e;
        if (interfaceC1464a != null) {
            interfaceC1464a.onClick(this);
        }
    }

    public void setControlState(EnumC1465b enumC1465b) {
        if (this.f1262c != enumC1465b) {
            m7361a(enumC1465b);
        }
        this.f1262c = enumC1465b;
    }

    public void setFormat(MaxAdFormat maxAdFormat) {
        this.f1263d = maxAdFormat;
    }

    public void setOnClickListener(InterfaceC1464a interfaceC1464a) {
        this.f1264e = interfaceC1464a;
    }
}
