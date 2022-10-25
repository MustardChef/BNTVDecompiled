package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.sdk.AppLovinSdkUtils;

/* loaded from: classes.dex */
public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* renamed from: a */
    private final long f282a;

    /* renamed from: b */
    private final int f283b;

    /* renamed from: c */
    private final int f284c;

    /* renamed from: d */
    private final ClickRecognitionState f285d;

    /* renamed from: e */
    private long f286e;

    /* renamed from: f */
    private PointF f287f;

    /* renamed from: g */
    private boolean f288g;

    /* renamed from: h */
    private final Context f289h;

    /* renamed from: i */
    private final OnClickListener f290i;

    /* loaded from: classes.dex */
    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    /* loaded from: classes.dex */
    public interface OnClickListener {
        void onClick(View view, PointF pointF);
    }

    public AppLovinTouchToClickListener(C1662k c1662k, Context context, OnClickListener onClickListener) {
        this(c1662k, C1568b.f1663aI, context, onClickListener);
    }

    public AppLovinTouchToClickListener(C1662k c1662k, C1568b<Integer> c1568b, Context context, OnClickListener onClickListener) {
        this.f282a = ((Long) c1662k.m6656a(C1568b.f1661aG)).longValue();
        this.f283b = ((Integer) c1662k.m6656a(C1568b.f1662aH)).intValue();
        this.f284c = AppLovinSdkUtils.dpToPx(context, ((Integer) c1662k.m6656a(C1568b.f1665aK)).intValue());
        this.f285d = ClickRecognitionState.values()[((Integer) c1662k.m6656a(c1568b)).intValue()];
        this.f289h = context;
        this.f290i = onClickListener;
    }

    /* renamed from: a */
    private float m8321a(float f) {
        return f / this.f289h.getResources().getDisplayMetrics().density;
    }

    /* renamed from: a */
    private float m8320a(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return m8321a((float) Math.sqrt((f * f) + (f2 * f2)));
    }

    /* renamed from: a */
    private void m8318a(View view, MotionEvent motionEvent) {
        this.f290i.onClick(view, new PointF(motionEvent.getRawX(), motionEvent.getRawY()));
        this.f288g = true;
    }

    /* renamed from: a */
    private boolean m8319a(MotionEvent motionEvent) {
        if (this.f284c <= 0) {
            return true;
        }
        Point m6279a = C1724f.m6279a(this.f289h);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = this.f284c;
        return rawX >= ((float) i) && rawY >= ((float) i) && rawX <= ((float) (m6279a.x - this.f284c)) && rawY <= ((float) (m6279a.y - this.f284c));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r9.f285d != com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        if (r2 >= r4) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
        if (r0 >= r2) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
        if (m8319a(r11) != false) goto L10;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            int r0 = r11.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L5e
            if (r0 == r1) goto L19
            r2 = 6
            if (r0 == r2) goto Le
            goto L86
        Le:
            boolean r0 = r9.f288g
            if (r0 != 0) goto L86
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f285d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_POINTER_UP
            if (r0 != r2) goto L86
            goto L6a
        L19:
            boolean r0 = r9.f288g
            if (r0 != 0) goto L24
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f285d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_UP
            if (r0 != r2) goto L24
            goto L6a
        L24:
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f285d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.DISABLED
            if (r0 != r2) goto L86
            long r2 = android.os.SystemClock.elapsedRealtime()
            long r4 = r9.f286e
            long r2 = r2 - r4
            android.graphics.PointF r0 = r9.f287f
            android.graphics.PointF r4 = new android.graphics.PointF
            float r5 = r11.getX()
            float r6 = r11.getY()
            r4.<init>(r5, r6)
            float r0 = r9.m8320a(r0, r4)
            boolean r4 = r9.f288g
            if (r4 != 0) goto L86
            long r4 = r9.f282a
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L54
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L86
        L54:
            int r2 = r9.f283b
            if (r2 < 0) goto L6a
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L86
            goto L6a
        L5e:
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r0 = r9.f285d
            com.applovin.impl.adview.AppLovinTouchToClickListener$ClickRecognitionState r2 = com.applovin.impl.adview.AppLovinTouchToClickListener.ClickRecognitionState.ACTION_DOWN
            if (r0 != r2) goto L6e
            boolean r0 = r9.m8319a(r11)
            if (r0 == 0) goto L86
        L6a:
            r9.m8318a(r10, r11)
            goto L86
        L6e:
            long r2 = android.os.SystemClock.elapsedRealtime()
            r9.f286e = r2
            android.graphics.PointF r10 = new android.graphics.PointF
            float r0 = r11.getX()
            float r11 = r11.getY()
            r10.<init>(r0, r11)
            r9.f287f = r10
            r10 = 0
            r9.f288g = r10
        L86:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.AppLovinTouchToClickListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
