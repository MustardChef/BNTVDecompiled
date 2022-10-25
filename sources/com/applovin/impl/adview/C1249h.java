package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.sdk.AppLovinMediationProvider;

/* renamed from: com.applovin.impl.adview.h */
/* loaded from: classes.dex */
public class C1249h extends View {

    /* renamed from: s */
    private static final int f576s = Color.rgb(66, 145, 241);

    /* renamed from: t */
    private static final int f577t = Color.rgb(66, 145, 241);

    /* renamed from: u */
    private static final int f578u = Color.rgb(66, 145, 241);

    /* renamed from: a */
    protected Paint f579a;

    /* renamed from: b */
    protected Paint f580b;

    /* renamed from: c */
    private Paint f581c;

    /* renamed from: d */
    private Paint f582d;

    /* renamed from: e */
    private RectF f583e;

    /* renamed from: f */
    private float f584f;

    /* renamed from: g */
    private int f585g;

    /* renamed from: h */
    private int f586h;

    /* renamed from: i */
    private int f587i;

    /* renamed from: j */
    private int f588j;

    /* renamed from: k */
    private int f589k;

    /* renamed from: l */
    private float f590l;

    /* renamed from: m */
    private int f591m;

    /* renamed from: n */
    private String f592n;

    /* renamed from: o */
    private String f593o;

    /* renamed from: p */
    private float f594p;

    /* renamed from: q */
    private String f595q;

    /* renamed from: r */
    private float f596r;

    /* renamed from: v */
    private final float f597v;

    /* renamed from: w */
    private final float f598w;

    /* renamed from: x */
    private final float f599x;

    /* renamed from: y */
    private final int f600y;

    /* renamed from: com.applovin.impl.adview.h$a */
    /* loaded from: classes.dex */
    private static class C1250a {
        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public static float m8058c(Resources resources, float f) {
            return (f * resources.getDisplayMetrics().density) + 0.5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public static float m8057d(Resources resources, float f) {
            return f * resources.getDisplayMetrics().scaledDensity;
        }
    }

    public C1249h(Context context) {
        this(context, null);
    }

    public C1249h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1249h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f583e = new RectF();
        this.f587i = 0;
        this.f592n = "";
        this.f593o = "";
        this.f595q = "";
        this.f598w = C1250a.m8057d(getResources(), 14.0f);
        this.f600y = (int) C1250a.m8058c(getResources(), 100.0f);
        this.f597v = C1250a.m8058c(getResources(), 4.0f);
        this.f599x = C1250a.m8057d(getResources(), 18.0f);
        m8061b();
        m8063a();
    }

    /* renamed from: a */
    private int m8062a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.f600y;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private float getProgressAngle() {
        return (getProgress() / this.f588j) * 360.0f;
    }

    /* renamed from: a */
    protected void m8063a() {
        TextPaint textPaint = new TextPaint();
        this.f579a = textPaint;
        textPaint.setColor(this.f585g);
        this.f579a.setTextSize(this.f584f);
        this.f579a.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f580b = textPaint2;
        textPaint2.setColor(this.f586h);
        this.f580b.setTextSize(this.f594p);
        this.f580b.setAntiAlias(true);
        Paint paint = new Paint();
        this.f581c = paint;
        paint.setColor(this.f589k);
        this.f581c.setStyle(Paint.Style.STROKE);
        this.f581c.setAntiAlias(true);
        this.f581c.setStrokeWidth(this.f590l);
        Paint paint2 = new Paint();
        this.f582d = paint2;
        paint2.setColor(this.f591m);
        this.f582d.setAntiAlias(true);
    }

    /* renamed from: b */
    protected void m8061b() {
        this.f589k = f576s;
        this.f585g = f577t;
        this.f584f = this.f598w;
        setMax(100);
        setProgress(0);
        this.f590l = this.f597v;
        this.f591m = 0;
        this.f594p = this.f599x;
        this.f586h = f578u;
    }

    public int getFinishedStrokeColor() {
        return this.f589k;
    }

    public float getFinishedStrokeWidth() {
        return this.f590l;
    }

    public int getInnerBackgroundColor() {
        return this.f591m;
    }

    public String getInnerBottomText() {
        return this.f595q;
    }

    public int getInnerBottomTextColor() {
        return this.f586h;
    }

    public float getInnerBottomTextSize() {
        return this.f594p;
    }

    public int getMax() {
        return this.f588j;
    }

    public String getPrefixText() {
        return this.f592n;
    }

    public int getProgress() {
        return this.f587i;
    }

    public String getSuffixText() {
        return this.f593o;
    }

    public int getTextColor() {
        return this.f585g;
    }

    public float getTextSize() {
        return this.f584f;
    }

    @Override // android.view.View
    public void invalidate() {
        m8063a();
        super.invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f590l;
        this.f583e.set(f, f, getWidth() - f, getHeight() - f);
        float f2 = this.f590l;
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - f2) + f2) / 2.0f, this.f582d);
        canvas.drawArc(this.f583e, 270.0f, -getProgressAngle(), false, this.f581c);
        String str = this.f592n + this.f587i + this.f593o;
        if (!TextUtils.isEmpty(str)) {
            canvas.drawText(str, (getWidth() - this.f579a.measureText(str)) / 2.0f, (getWidth() - (this.f579a.descent() + this.f579a.ascent())) / 2.0f, this.f579a);
        }
        if (TextUtils.isEmpty(getInnerBottomText())) {
            return;
        }
        this.f580b.setTextSize(this.f594p);
        canvas.drawText(getInnerBottomText(), (getWidth() - this.f580b.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.f596r) - ((this.f579a.descent() + this.f579a.ascent()) / 2.0f), this.f580b);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m8062a(i), m8062a(i2));
        this.f596r = getHeight() - ((getHeight() * 3) / 4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.f585g = bundle.getInt("text_color");
        this.f584f = bundle.getFloat("text_size");
        this.f594p = bundle.getFloat("inner_bottom_text_size");
        this.f595q = bundle.getString("inner_bottom_text");
        this.f586h = bundle.getInt("inner_bottom_text_color");
        this.f589k = bundle.getInt("finished_stroke_color");
        this.f590l = bundle.getFloat("finished_stroke_width");
        this.f591m = bundle.getInt("inner_background_color");
        m8063a();
        setMax(bundle.getInt(AppLovinMediationProvider.MAX));
        setProgress(bundle.getInt("progress"));
        this.f592n = bundle.getString("prefix");
        this.f593o = bundle.getString("suffix");
        super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat("inner_bottom_text_size", getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", getFinishedStrokeColor());
        bundle.putInt(AppLovinMediationProvider.MAX, getMax());
        bundle.putInt("progress", getProgress());
        bundle.putString("suffix", getSuffixText());
        bundle.putString("prefix", getPrefixText());
        bundle.putFloat("finished_stroke_width", getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int i) {
        this.f589k = i;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f) {
        this.f590l = f;
        invalidate();
    }

    public void setInnerBackgroundColor(int i) {
        this.f591m = i;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.f595q = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i) {
        this.f586h = i;
        invalidate();
    }

    public void setInnerBottomTextSize(float f) {
        this.f594p = f;
        invalidate();
    }

    public void setMax(int i) {
        if (i > 0) {
            this.f588j = i;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.f592n = str;
        invalidate();
    }

    public void setProgress(int i) {
        this.f587i = i;
        if (i > getMax()) {
            this.f587i %= getMax();
        }
        invalidate();
    }

    public void setSuffixText(String str) {
        this.f593o = str;
        invalidate();
    }

    public void setTextColor(int i) {
        this.f585g = i;
        invalidate();
    }

    public void setTextSize(float f) {
        this.f584f = f;
        invalidate();
    }
}
