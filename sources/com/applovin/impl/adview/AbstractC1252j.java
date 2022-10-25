package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.applovin.impl.adview.j */
/* loaded from: classes.dex */
public abstract class AbstractC1252j extends View {

    /* renamed from: a */
    protected float f602a;

    /* renamed from: b */
    protected final Context f603b;

    /* renamed from: com.applovin.impl.adview.j$a */
    /* loaded from: classes.dex */
    public enum EnumC1253a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2);
        

        /* renamed from: d */
        private final int f608d;

        EnumC1253a(int i) {
            this.f608d = i;
        }

        /* renamed from: a */
        public int m8055a() {
            return this.f608d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1252j(Context context) {
        super(context);
        this.f602a = 1.0f;
        this.f603b = context;
    }

    /* renamed from: a */
    public static AbstractC1252j m8056a(EnumC1253a enumC1253a, Context context) {
        return enumC1253a.equals(EnumC1253a.INVISIBLE) ? new C1312r(context) : enumC1253a.equals(EnumC1253a.WHITE_ON_TRANSPARENT) ? new C1313s(context) : new C1321y(context);
    }

    /* renamed from: a */
    public void mo7900a(int i) {
        setViewScale(i / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public float getSize() {
        return this.f602a * 30.0f;
    }

    public abstract EnumC1253a getStyle();

    public void setViewScale(float f) {
        this.f602a = f;
    }
}
