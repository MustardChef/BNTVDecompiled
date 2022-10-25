package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public class ColorPickerView extends View {
    private static final int ALPHA_PANEL_HEIGH_DP = 20;
    private static final int BORDER_WIDTH_PX = 1;
    private static final int CIRCLE_TRACKER_RADIUS_DP = 5;
    private static final int DEFAULT_BORDER_COLOR = -9539986;
    private static final int DEFAULT_SLIDER_COLOR = -4342339;
    private static final int HUE_PANEL_WDITH_DP = 30;
    private static final int PANEL_SPACING_DP = 10;
    private static final int SLIDER_TRACKER_OFFSET_DP = 2;
    private static final int SLIDER_TRACKER_SIZE_DP = 4;
    private int alpha;
    private Paint alphaPaint;
    private int alphaPanelHeightPx;
    private AlphaPatternDrawable alphaPatternDrawable;
    private Rect alphaRect;
    private Shader alphaShader;
    private String alphaSliderText;
    private Paint alphaTextPaint;
    private int borderColor;
    private Paint borderPaint;
    private int circleTrackerRadiusPx;
    private Rect drawingRect;
    private float hue;
    private Paint hueAlphaTrackerPaint;
    private BitmapCache hueBackgroundCache;
    private int huePanelWidthPx;
    private Rect hueRect;
    private int mRequiredPadding;
    private OnColorChangedListener onColorChangedListener;
    private int panelSpacingPx;
    private float sat;
    private Shader satShader;
    private BitmapCache satValBackgroundCache;
    private Paint satValPaint;
    private Rect satValRect;
    private Paint satValTrackerPaint;
    private boolean showAlphaPanel;
    private int sliderTrackerColor;
    private int sliderTrackerOffsetPx;
    private int sliderTrackerSizePx;
    private Point startTouchPoint;
    private float val;
    private Shader valShader;

    /* loaded from: classes3.dex */
    public interface OnColorChangedListener {
        void onColorChanged(int i);
    }

    public ColorPickerView(Context context) {
        this(context, null);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.alpha = 255;
        this.hue = 360.0f;
        this.sat = 0.0f;
        this.val = 0.0f;
        this.showAlphaPanel = false;
        this.alphaSliderText = null;
        this.sliderTrackerColor = DEFAULT_SLIDER_COLOR;
        this.borderColor = DEFAULT_BORDER_COLOR;
        this.startTouchPoint = null;
        init(context, attributeSet);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("alpha", this.alpha);
        bundle.putFloat("hue", this.hue);
        bundle.putFloat("sat", this.sat);
        bundle.putFloat("val", this.val);
        bundle.putBoolean("show_alpha", this.showAlphaPanel);
        bundle.putString("alpha_text", this.alphaSliderText);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.alpha = bundle.getInt("alpha");
            this.hue = bundle.getFloat("hue");
            this.sat = bundle.getFloat("sat");
            this.val = bundle.getFloat("val");
            this.showAlphaPanel = bundle.getBoolean("show_alpha");
            this.alphaSliderText = bundle.getString("alpha_text");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4694R.styleable.ColorPickerView);
        this.showAlphaPanel = obtainStyledAttributes.getBoolean(C4694R.styleable.ColorPickerView_cpv_alphaChannelVisible, false);
        this.alphaSliderText = obtainStyledAttributes.getString(C4694R.styleable.ColorPickerView_cpv_alphaChannelText);
        this.sliderTrackerColor = obtainStyledAttributes.getColor(C4694R.styleable.ColorPickerView_cpv_sliderColor, DEFAULT_SLIDER_COLOR);
        this.borderColor = obtainStyledAttributes.getColor(C4694R.styleable.ColorPickerView_cpv_borderColor, DEFAULT_BORDER_COLOR);
        obtainStyledAttributes.recycle();
        applyThemeColors(context);
        this.huePanelWidthPx = DrawingUtils.dpToPx(getContext(), 30.0f);
        this.alphaPanelHeightPx = DrawingUtils.dpToPx(getContext(), 20.0f);
        this.panelSpacingPx = DrawingUtils.dpToPx(getContext(), 10.0f);
        this.circleTrackerRadiusPx = DrawingUtils.dpToPx(getContext(), 5.0f);
        this.sliderTrackerSizePx = DrawingUtils.dpToPx(getContext(), 4.0f);
        this.sliderTrackerOffsetPx = DrawingUtils.dpToPx(getContext(), 2.0f);
        this.mRequiredPadding = getResources().getDimensionPixelSize(C4694R.dimen.cpv_required_padding);
        initPaintTools();
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void applyThemeColors(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
        if (this.borderColor == DEFAULT_BORDER_COLOR) {
            this.borderColor = obtainStyledAttributes.getColor(0, DEFAULT_BORDER_COLOR);
        }
        if (this.sliderTrackerColor == DEFAULT_SLIDER_COLOR) {
            this.sliderTrackerColor = obtainStyledAttributes.getColor(0, DEFAULT_SLIDER_COLOR);
        }
        obtainStyledAttributes.recycle();
    }

    private void initPaintTools() {
        this.satValPaint = new Paint();
        this.satValTrackerPaint = new Paint();
        this.hueAlphaTrackerPaint = new Paint();
        this.alphaPaint = new Paint();
        this.alphaTextPaint = new Paint();
        this.borderPaint = new Paint();
        this.satValTrackerPaint.setStyle(Paint.Style.STROKE);
        this.satValTrackerPaint.setStrokeWidth(DrawingUtils.dpToPx(getContext(), 2.0f));
        this.satValTrackerPaint.setAntiAlias(true);
        this.hueAlphaTrackerPaint.setColor(this.sliderTrackerColor);
        this.hueAlphaTrackerPaint.setStyle(Paint.Style.STROKE);
        this.hueAlphaTrackerPaint.setStrokeWidth(DrawingUtils.dpToPx(getContext(), 2.0f));
        this.hueAlphaTrackerPaint.setAntiAlias(true);
        this.alphaTextPaint.setColor(-14935012);
        this.alphaTextPaint.setTextSize(DrawingUtils.dpToPx(getContext(), 14.0f));
        this.alphaTextPaint.setAntiAlias(true);
        this.alphaTextPaint.setTextAlign(Paint.Align.CENTER);
        this.alphaTextPaint.setFakeBoldText(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.drawingRect.width() <= 0 || this.drawingRect.height() <= 0) {
            return;
        }
        drawSatValPanel(canvas);
        drawHuePanel(canvas);
        drawAlphaPanel(canvas);
    }

    private void drawSatValPanel(Canvas canvas) {
        Rect rect = this.satValRect;
        this.borderPaint.setColor(this.borderColor);
        canvas.drawRect(this.drawingRect.left, this.drawingRect.top, rect.right + 1, rect.bottom + 1, this.borderPaint);
        if (this.valShader == null) {
            this.valShader = new LinearGradient(rect.left, rect.top, rect.left, rect.bottom, -1, (int) ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
        }
        BitmapCache bitmapCache = this.satValBackgroundCache;
        if (bitmapCache == null || bitmapCache.value != this.hue) {
            if (this.satValBackgroundCache == null) {
                this.satValBackgroundCache = new BitmapCache();
            }
            if (this.satValBackgroundCache.bitmap == null) {
                this.satValBackgroundCache.bitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            }
            if (this.satValBackgroundCache.canvas == null) {
                this.satValBackgroundCache.canvas = new Canvas(this.satValBackgroundCache.bitmap);
            }
            this.satShader = new LinearGradient(rect.left, rect.top, rect.right, rect.top, -1, Color.HSVToColor(new float[]{this.hue, 1.0f, 1.0f}), Shader.TileMode.CLAMP);
            this.satValPaint.setShader(new ComposeShader(this.valShader, this.satShader, PorterDuff.Mode.MULTIPLY));
            this.satValBackgroundCache.canvas.drawRect(0.0f, 0.0f, this.satValBackgroundCache.bitmap.getWidth(), this.satValBackgroundCache.bitmap.getHeight(), this.satValPaint);
            this.satValBackgroundCache.value = this.hue;
        }
        canvas.drawBitmap(this.satValBackgroundCache.bitmap, (Rect) null, rect, (Paint) null);
        Point satValToPoint = satValToPoint(this.sat, this.val);
        this.satValTrackerPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(satValToPoint.x, satValToPoint.y, this.circleTrackerRadiusPx - DrawingUtils.dpToPx(getContext(), 1.0f), this.satValTrackerPaint);
        this.satValTrackerPaint.setColor(-2236963);
        canvas.drawCircle(satValToPoint.x, satValToPoint.y, this.circleTrackerRadiusPx, this.satValTrackerPaint);
    }

    private void drawHuePanel(Canvas canvas) {
        Rect rect = this.hueRect;
        this.borderPaint.setColor(this.borderColor);
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.borderPaint);
        if (this.hueBackgroundCache == null) {
            BitmapCache bitmapCache = new BitmapCache();
            this.hueBackgroundCache = bitmapCache;
            bitmapCache.bitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
            this.hueBackgroundCache.canvas = new Canvas(this.hueBackgroundCache.bitmap);
            int height = (int) (rect.height() + 0.5f);
            int[] iArr = new int[height];
            float f = 360.0f;
            for (int i = 0; i < height; i++) {
                iArr[i] = Color.HSVToColor(new float[]{f, 1.0f, 1.0f});
                f -= 360.0f / height;
            }
            Paint paint = new Paint();
            paint.setStrokeWidth(0.0f);
            for (int i2 = 0; i2 < height; i2++) {
                paint.setColor(iArr[i2]);
                float f2 = i2;
                this.hueBackgroundCache.canvas.drawLine(0.0f, f2, this.hueBackgroundCache.bitmap.getWidth(), f2, paint);
            }
        }
        canvas.drawBitmap(this.hueBackgroundCache.bitmap, (Rect) null, rect, (Paint) null);
        Point hueToPoint = hueToPoint(this.hue);
        RectF rectF = new RectF();
        rectF.left = rect.left - this.sliderTrackerOffsetPx;
        rectF.right = rect.right + this.sliderTrackerOffsetPx;
        rectF.top = hueToPoint.y - (this.sliderTrackerSizePx / 2);
        rectF.bottom = hueToPoint.y + (this.sliderTrackerSizePx / 2);
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.hueAlphaTrackerPaint);
    }

    private void drawAlphaPanel(Canvas canvas) {
        Rect rect;
        if (!this.showAlphaPanel || (rect = this.alphaRect) == null || this.alphaPatternDrawable == null) {
            return;
        }
        this.borderPaint.setColor(this.borderColor);
        canvas.drawRect(rect.left - 1, rect.top - 1, rect.right + 1, rect.bottom + 1, this.borderPaint);
        this.alphaPatternDrawable.draw(canvas);
        float[] fArr = {this.hue, this.sat, this.val};
        LinearGradient linearGradient = new LinearGradient(rect.left, rect.top, rect.right, rect.top, Color.HSVToColor(fArr), Color.HSVToColor(0, fArr), Shader.TileMode.CLAMP);
        this.alphaShader = linearGradient;
        this.alphaPaint.setShader(linearGradient);
        canvas.drawRect(rect, this.alphaPaint);
        String str = this.alphaSliderText;
        if (str != null && !str.equals("")) {
            canvas.drawText(this.alphaSliderText, rect.centerX(), rect.centerY() + DrawingUtils.dpToPx(getContext(), 4.0f), this.alphaTextPaint);
        }
        Point alphaToPoint = alphaToPoint(this.alpha);
        RectF rectF = new RectF();
        rectF.left = alphaToPoint.x - (this.sliderTrackerSizePx / 2);
        rectF.right = alphaToPoint.x + (this.sliderTrackerSizePx / 2);
        rectF.top = rect.top - this.sliderTrackerOffsetPx;
        rectF.bottom = rect.bottom + this.sliderTrackerOffsetPx;
        canvas.drawRoundRect(rectF, 2.0f, 2.0f, this.hueAlphaTrackerPaint);
    }

    private Point hueToPoint(float f) {
        Rect rect = this.hueRect;
        float height = rect.height();
        Point point = new Point();
        point.y = (int) ((height - ((f * height) / 360.0f)) + rect.top);
        point.x = rect.left;
        return point;
    }

    private Point satValToPoint(float f, float f2) {
        Rect rect = this.satValRect;
        Point point = new Point();
        point.x = (int) ((f * rect.width()) + rect.left);
        point.y = (int) (((1.0f - f2) * rect.height()) + rect.top);
        return point;
    }

    private Point alphaToPoint(int i) {
        Rect rect = this.alphaRect;
        float width = rect.width();
        Point point = new Point();
        point.x = (int) ((width - ((i * width) / 255.0f)) + rect.left);
        point.y = rect.top;
        return point;
    }

    private float[] pointToSatVal(float f, float f2) {
        float f3;
        Rect rect = this.satValRect;
        float[] fArr = new float[2];
        float width = rect.width();
        float height = rect.height();
        float f4 = 0.0f;
        if (f < rect.left) {
            f3 = 0.0f;
        } else {
            f3 = f > ((float) rect.right) ? width : f - rect.left;
        }
        if (f2 >= rect.top) {
            f4 = f2 > ((float) rect.bottom) ? height : f2 - rect.top;
        }
        fArr[0] = (1.0f / width) * f3;
        fArr[1] = 1.0f - ((1.0f / height) * f4);
        return fArr;
    }

    private float pointToHue(float f) {
        float f2;
        Rect rect = this.hueRect;
        float height = rect.height();
        if (f < rect.top) {
            f2 = 0.0f;
        } else {
            f2 = f > ((float) rect.bottom) ? height : f - rect.top;
        }
        return 360.0f - ((f2 * 360.0f) / height);
    }

    private int pointToAlpha(int i) {
        int i2;
        Rect rect = this.alphaRect;
        int width = rect.width();
        if (i < rect.left) {
            i2 = 0;
        } else {
            i2 = i > rect.right ? width : i - rect.left;
        }
        return 255 - ((i2 * 255) / width);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean moveTrackersIfNeeded;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTouchPoint = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
            moveTrackersIfNeeded = moveTrackersIfNeeded(motionEvent);
        } else if (action != 1) {
            moveTrackersIfNeeded = action != 2 ? false : moveTrackersIfNeeded(motionEvent);
        } else {
            this.startTouchPoint = null;
            moveTrackersIfNeeded = moveTrackersIfNeeded(motionEvent);
        }
        if (moveTrackersIfNeeded) {
            OnColorChangedListener onColorChangedListener = this.onColorChangedListener;
            if (onColorChangedListener != null) {
                onColorChangedListener.onColorChanged(Color.HSVToColor(this.alpha, new float[]{this.hue, this.sat, this.val}));
            }
            invalidate();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean moveTrackersIfNeeded(MotionEvent motionEvent) {
        Point point = this.startTouchPoint;
        if (point == null) {
            return false;
        }
        int i = point.x;
        int i2 = this.startTouchPoint.y;
        if (this.hueRect.contains(i, i2)) {
            this.hue = pointToHue(motionEvent.getY());
        } else if (this.satValRect.contains(i, i2)) {
            float[] pointToSatVal = pointToSatVal(motionEvent.getX(), motionEvent.getY());
            this.sat = pointToSatVal[0];
            this.val = pointToSatVal[1];
        } else {
            Rect rect = this.alphaRect;
            if (rect == null || !rect.contains(i, i2)) {
                return false;
            }
            this.alpha = pointToAlpha((int) motionEvent.getX());
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r0 != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (r1 > r6) goto L15;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r2 = r5.getPaddingLeft()
            int r6 = r6 - r2
            int r2 = r5.getPaddingRight()
            int r6 = r6 - r2
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r2 = r5.getPaddingBottom()
            int r7 = r7 - r2
            int r2 = r5.getPaddingTop()
            int r7 = r7 - r2
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r2) goto L5c
            if (r1 != r2) goto L2b
            goto L5c
        L2b:
            int r0 = r5.panelSpacingPx
            int r1 = r7 + r0
            int r2 = r5.huePanelWidthPx
            int r1 = r1 + r2
            int r3 = r6 - r0
            int r3 = r3 - r2
            boolean r2 = r5.showAlphaPanel
            if (r2 == 0) goto L40
            int r2 = r5.alphaPanelHeightPx
            int r4 = r0 + r2
            int r1 = r1 - r4
            int r0 = r0 + r2
            int r3 = r3 + r0
        L40:
            r0 = 1
            r2 = 0
            if (r1 > r6) goto L46
            r4 = 1
            goto L47
        L46:
            r4 = 0
        L47:
            if (r3 > r7) goto L4a
            goto L4b
        L4a:
            r0 = 0
        L4b:
            if (r4 == 0) goto L50
            if (r0 == 0) goto L50
            goto L5a
        L50:
            if (r0 != 0) goto L56
            if (r4 == 0) goto L56
        L54:
            r6 = r1
            goto L89
        L56:
            if (r4 != 0) goto L89
            if (r0 == 0) goto L89
        L5a:
            r7 = r3
            goto L89
        L5c:
            if (r0 != r2) goto L74
            if (r1 == r2) goto L74
            int r0 = r5.panelSpacingPx
            int r1 = r6 - r0
            int r2 = r5.huePanelWidthPx
            int r1 = r1 - r2
            boolean r2 = r5.showAlphaPanel
            if (r2 == 0) goto L6f
            int r2 = r5.alphaPanelHeightPx
            int r0 = r0 + r2
            int r1 = r1 + r0
        L6f:
            if (r1 <= r7) goto L72
            goto L89
        L72:
            r7 = r1
            goto L89
        L74:
            if (r1 != r2) goto L89
            if (r0 == r2) goto L89
            int r0 = r5.panelSpacingPx
            int r1 = r7 + r0
            int r2 = r5.huePanelWidthPx
            int r1 = r1 + r2
            boolean r2 = r5.showAlphaPanel
            if (r2 == 0) goto L87
            int r2 = r5.alphaPanelHeightPx
            int r0 = r0 + r2
            int r1 = r1 - r0
        L87:
            if (r1 <= r6) goto L54
        L89:
            int r0 = r5.getPaddingLeft()
            int r6 = r6 + r0
            int r0 = r5.getPaddingRight()
            int r6 = r6 + r0
            int r0 = r5.getPaddingTop()
            int r7 = r7 + r0
            int r0 = r5.getPaddingBottom()
            int r7 = r7 + r0
            r5.setMeasuredDimension(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jaredrummler.android.colorpicker.ColorPickerView.onMeasure(int, int):void");
    }

    private int getPreferredWidth() {
        return DrawingUtils.dpToPx(getContext(), 200.0f) + this.huePanelWidthPx + this.panelSpacingPx;
    }

    private int getPreferredHeight() {
        int dpToPx = DrawingUtils.dpToPx(getContext(), 200.0f);
        return this.showAlphaPanel ? dpToPx + this.panelSpacingPx + this.alphaPanelHeightPx : dpToPx;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return Math.max(super.getPaddingTop(), this.mRequiredPadding);
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return Math.max(super.getPaddingBottom(), this.mRequiredPadding);
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return Math.max(super.getPaddingLeft(), this.mRequiredPadding);
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return Math.max(super.getPaddingRight(), this.mRequiredPadding);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Rect rect = new Rect();
        this.drawingRect = rect;
        rect.left = getPaddingLeft();
        this.drawingRect.right = i - getPaddingRight();
        this.drawingRect.top = getPaddingTop();
        this.drawingRect.bottom = i2 - getPaddingBottom();
        this.valShader = null;
        this.satShader = null;
        this.alphaShader = null;
        this.satValBackgroundCache = null;
        this.hueBackgroundCache = null;
        setUpSatValRect();
        setUpHueRect();
        setUpAlphaRect();
    }

    private void setUpSatValRect() {
        Rect rect = this.drawingRect;
        int i = rect.left + 1;
        int i2 = rect.top + 1;
        int i3 = rect.bottom - 1;
        int i4 = this.panelSpacingPx;
        int i5 = ((rect.right - 1) - i4) - this.huePanelWidthPx;
        if (this.showAlphaPanel) {
            i3 -= this.alphaPanelHeightPx + i4;
        }
        this.satValRect = new Rect(i, i2, i5, i3);
    }

    private void setUpHueRect() {
        Rect rect = this.drawingRect;
        this.hueRect = new Rect((rect.right - this.huePanelWidthPx) + 1, rect.top + 1, rect.right - 1, (rect.bottom - 1) - (this.showAlphaPanel ? this.panelSpacingPx + this.alphaPanelHeightPx : 0));
    }

    private void setUpAlphaRect() {
        if (this.showAlphaPanel) {
            Rect rect = this.drawingRect;
            this.alphaRect = new Rect(rect.left + 1, (rect.bottom - this.alphaPanelHeightPx) + 1, rect.right - 1, rect.bottom - 1);
            AlphaPatternDrawable alphaPatternDrawable = new AlphaPatternDrawable(DrawingUtils.dpToPx(getContext(), 4.0f));
            this.alphaPatternDrawable = alphaPatternDrawable;
            alphaPatternDrawable.setBounds(Math.round(this.alphaRect.left), Math.round(this.alphaRect.top), Math.round(this.alphaRect.right), Math.round(this.alphaRect.bottom));
        }
    }

    public void setOnColorChangedListener(OnColorChangedListener onColorChangedListener) {
        this.onColorChangedListener = onColorChangedListener;
    }

    public int getColor() {
        return Color.HSVToColor(this.alpha, new float[]{this.hue, this.sat, this.val});
    }

    public void setColor(int i) {
        setColor(i, false);
    }

    public void setColor(int i, boolean z) {
        OnColorChangedListener onColorChangedListener;
        int alpha = Color.alpha(i);
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        this.alpha = alpha;
        float f = fArr[0];
        this.hue = f;
        float f2 = fArr[1];
        this.sat = f2;
        float f3 = fArr[2];
        this.val = f3;
        if (z && (onColorChangedListener = this.onColorChangedListener) != null) {
            onColorChangedListener.onColorChanged(Color.HSVToColor(alpha, new float[]{f, f2, f3}));
        }
        invalidate();
    }

    public void setAlphaSliderVisible(boolean z) {
        if (this.showAlphaPanel != z) {
            this.showAlphaPanel = z;
            this.valShader = null;
            this.satShader = null;
            this.alphaShader = null;
            this.hueBackgroundCache = null;
            this.satValBackgroundCache = null;
            requestLayout();
        }
    }

    public int getSliderTrackerColor() {
        return this.sliderTrackerColor;
    }

    public void setSliderTrackerColor(int i) {
        this.sliderTrackerColor = i;
        this.hueAlphaTrackerPaint.setColor(i);
        invalidate();
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setAlphaSliderText(int i) {
        setAlphaSliderText(getContext().getString(i));
    }

    public String getAlphaSliderText() {
        return this.alphaSliderText;
    }

    public void setAlphaSliderText(String str) {
        this.alphaSliderText = str;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BitmapCache {
        public Bitmap bitmap;
        public Canvas canvas;
        public float value;

        private BitmapCache() {
        }
    }
}
