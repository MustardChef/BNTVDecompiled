package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ColorPanelView extends View {
    private static final int DEFAULT_BORDER_COLOR = -9539986;
    private Paint alphaPaint;
    private Drawable alphaPattern;
    private int borderColor;
    private Paint borderPaint;
    private int borderWidthPx;
    private RectF centerRect;
    private int color;
    private Paint colorPaint;
    private Rect colorRect;
    private Rect drawingRect;
    private Paint originalPaint;
    private int shape;
    private boolean showOldColor;

    public ColorPanelView(Context context) {
        this(context, null);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPanelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.centerRect = new RectF();
        this.borderColor = DEFAULT_BORDER_COLOR;
        this.color = ViewCompat.MEASURED_STATE_MASK;
        init(context, attributeSet);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("color", this.color);
        return bundle;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.color = bundle.getInt("color");
            parcelable = bundle.getParcelable("instanceState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4694R.styleable.ColorPanelView);
        this.shape = obtainStyledAttributes.getInt(C4694R.styleable.ColorPanelView_cpv_colorShape, 1);
        boolean z = obtainStyledAttributes.getBoolean(C4694R.styleable.ColorPanelView_cpv_showOldColor, false);
        this.showOldColor = z;
        if (z && this.shape != 1) {
            throw new IllegalStateException("Color preview is only available in circle mode");
        }
        this.borderColor = obtainStyledAttributes.getColor(C4694R.styleable.ColorPanelView_cpv_borderColor, DEFAULT_BORDER_COLOR);
        obtainStyledAttributes.recycle();
        if (this.borderColor == DEFAULT_BORDER_COLOR) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(new TypedValue().data, new int[]{16842808});
            this.borderColor = obtainStyledAttributes2.getColor(0, this.borderColor);
            obtainStyledAttributes2.recycle();
        }
        this.borderWidthPx = DrawingUtils.dpToPx(context, 1.0f);
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.colorPaint = paint2;
        paint2.setAntiAlias(true);
        if (this.showOldColor) {
            this.originalPaint = new Paint();
        }
        if (this.shape == 1) {
            Bitmap bitmap = ((BitmapDrawable) context.getResources().getDrawable(C4694R.C4696drawable.cpv_alpha)).getBitmap();
            Paint paint3 = new Paint();
            this.alphaPaint = paint3;
            paint3.setAntiAlias(true);
            this.alphaPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.borderPaint.setColor(this.borderColor);
        this.colorPaint.setColor(this.color);
        int i = this.shape;
        if (i == 0) {
            if (this.borderWidthPx > 0) {
                canvas.drawRect(this.drawingRect, this.borderPaint);
            }
            Drawable drawable = this.alphaPattern;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            canvas.drawRect(this.colorRect, this.colorPaint);
        } else if (i == 1) {
            int measuredWidth = getMeasuredWidth() / 2;
            if (this.borderWidthPx > 0) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, this.borderPaint);
            }
            if (Color.alpha(this.color) < 255) {
                canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth - this.borderWidthPx, this.alphaPaint);
            }
            if (this.showOldColor) {
                canvas.drawArc(this.centerRect, 90.0f, 180.0f, true, this.originalPaint);
                canvas.drawArc(this.centerRect, 270.0f, 180.0f, true, this.colorPaint);
                return;
            }
            canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth - this.borderWidthPx, this.colorPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.shape;
        if (i3 == 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        } else if (i3 == 1) {
            super.onMeasure(i, i);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.shape == 0 || this.showOldColor) {
            Rect rect = new Rect();
            this.drawingRect = rect;
            rect.left = getPaddingLeft();
            this.drawingRect.right = i - getPaddingRight();
            this.drawingRect.top = getPaddingTop();
            this.drawingRect.bottom = i2 - getPaddingBottom();
            if (this.showOldColor) {
                setUpCenterRect();
            } else {
                setUpColorRect();
            }
        }
    }

    private void setUpCenterRect() {
        Rect rect = this.drawingRect;
        this.centerRect = new RectF(rect.left + this.borderWidthPx, rect.top + this.borderWidthPx, rect.right - this.borderWidthPx, rect.bottom - this.borderWidthPx);
    }

    private void setUpColorRect() {
        Rect rect = this.drawingRect;
        this.colorRect = new Rect(rect.left + this.borderWidthPx, rect.top + this.borderWidthPx, rect.right - this.borderWidthPx, rect.bottom - this.borderWidthPx);
        AlphaPatternDrawable alphaPatternDrawable = new AlphaPatternDrawable(DrawingUtils.dpToPx(getContext(), 4.0f));
        this.alphaPattern = alphaPatternDrawable;
        alphaPatternDrawable.setBounds(Math.round(this.colorRect.left), Math.round(this.colorRect.top), Math.round(this.colorRect.right), Math.round(this.colorRect.bottom));
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
        invalidate();
    }

    public void setOriginalColor(int i) {
        Paint paint = this.originalPaint;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public int getShape() {
        return this.shape;
    }

    public void setShape(int i) {
        this.shape = i;
        invalidate();
    }

    public void showHint() {
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        int i2 = iArr[0] + (width / 2);
        if (ViewCompat.getLayoutDirection(this) == 0) {
            i2 = context.getResources().getDisplayMetrics().widthPixels - i2;
        }
        StringBuilder sb = new StringBuilder("#");
        if (Color.alpha(this.color) != 255) {
            sb.append(Integer.toHexString(this.color).toUpperCase(Locale.ENGLISH));
        } else {
            sb.append(String.format("%06X", Integer.valueOf(16777215 & this.color)).toUpperCase(Locale.ENGLISH));
        }
        Toast makeText = Toast.makeText(context, sb.toString(), 0);
        if (i < rect.height()) {
            makeText.setGravity(BadgeDrawable.TOP_END, i2, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
    }
}
