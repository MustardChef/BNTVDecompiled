package com.facebook.share.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.C2023R;

@Deprecated
/* loaded from: classes2.dex */
public class LikeBoxCountView extends FrameLayout {
    private int additionalTextPadding;
    private Paint borderPaint;
    private float borderRadius;
    private float caretHeight;
    private LikeBoxCountViewCaretPosition caretPosition;
    private float caretWidth;
    private TextView likeCountLabel;
    private int textPadding;

    /* loaded from: classes2.dex */
    public enum LikeBoxCountViewCaretPosition {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    @Deprecated
    public LikeBoxCountView(Context context) {
        super(context);
        this.caretPosition = LikeBoxCountViewCaretPosition.LEFT;
        initialize(context);
    }

    @Deprecated
    public void setText(String str) {
        this.likeCountLabel.setText(str);
    }

    @Deprecated
    public void setCaretPosition(LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition) {
        this.caretPosition = likeBoxCountViewCaretPosition;
        int i = C22011.f2767x5851190f[likeBoxCountViewCaretPosition.ordinal()];
        if (i == 1) {
            setAdditionalTextPadding(this.additionalTextPadding, 0, 0, 0);
        } else if (i == 2) {
            setAdditionalTextPadding(0, this.additionalTextPadding, 0, 0);
        } else if (i == 3) {
            setAdditionalTextPadding(0, 0, this.additionalTextPadding, 0);
        } else if (i != 4) {
        } else {
            setAdditionalTextPadding(0, 0, 0, this.additionalTextPadding);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.share.internal.LikeBoxCountView$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C22011 {

        /* renamed from: $SwitchMap$com$facebook$share$internal$LikeBoxCountView$LikeBoxCountViewCaretPosition */
        static final /* synthetic */ int[] f2767x5851190f;

        static {
            int[] iArr = new int[LikeBoxCountViewCaretPosition.values().length];
            f2767x5851190f = iArr;
            try {
                iArr[LikeBoxCountViewCaretPosition.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2767x5851190f[LikeBoxCountViewCaretPosition.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2767x5851190f[LikeBoxCountViewCaretPosition.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2767x5851190f[LikeBoxCountViewCaretPosition.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int i = C22011.f2767x5851190f[this.caretPosition.ordinal()];
        if (i == 1) {
            paddingLeft = (int) (paddingLeft + this.caretHeight);
        } else if (i == 2) {
            paddingTop = (int) (paddingTop + this.caretHeight);
        } else if (i == 3) {
            width = (int) (width - this.caretHeight);
        } else if (i == 4) {
            height = (int) (height - this.caretHeight);
        }
        drawBorder(canvas, paddingLeft, paddingTop, width, height);
    }

    private void initialize(Context context) {
        setWillNotDraw(false);
        this.caretHeight = getResources().getDimension(C2023R.dimen.com_facebook_likeboxcountview_caret_height);
        this.caretWidth = getResources().getDimension(C2023R.dimen.com_facebook_likeboxcountview_caret_width);
        this.borderRadius = getResources().getDimension(C2023R.dimen.com_facebook_likeboxcountview_border_radius);
        Paint paint = new Paint();
        this.borderPaint = paint;
        paint.setColor(getResources().getColor(C2023R.C2024color.com_facebook_likeboxcountview_border_color));
        this.borderPaint.setStrokeWidth(getResources().getDimension(C2023R.dimen.com_facebook_likeboxcountview_border_width));
        this.borderPaint.setStyle(Paint.Style.STROKE);
        initializeLikeCountLabel(context);
        addView(this.likeCountLabel);
        setCaretPosition(this.caretPosition);
    }

    private void initializeLikeCountLabel(Context context) {
        this.likeCountLabel = new TextView(context);
        this.likeCountLabel.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.likeCountLabel.setGravity(17);
        this.likeCountLabel.setTextSize(0, getResources().getDimension(C2023R.dimen.com_facebook_likeboxcountview_text_size));
        this.likeCountLabel.setTextColor(getResources().getColor(C2023R.C2024color.com_facebook_likeboxcountview_text_color));
        this.textPadding = getResources().getDimensionPixelSize(C2023R.dimen.com_facebook_likeboxcountview_text_padding);
        this.additionalTextPadding = getResources().getDimensionPixelSize(C2023R.dimen.com_facebook_likeboxcountview_caret_height);
    }

    private void setAdditionalTextPadding(int i, int i2, int i3, int i4) {
        TextView textView = this.likeCountLabel;
        int i5 = this.textPadding;
        textView.setPadding(i + i5, i2 + i5, i3 + i5, i5 + i4);
    }

    private void drawBorder(Canvas canvas, float f, float f2, float f3, float f4) {
        Path path = new Path();
        float f5 = this.borderRadius * 2.0f;
        float f6 = f + f5;
        float f7 = f2 + f5;
        path.addArc(new RectF(f, f2, f6, f7), -180.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.TOP) {
            float f8 = f3 - f;
            path.lineTo(((f8 - this.caretWidth) / 2.0f) + f, f2);
            path.lineTo((f8 / 2.0f) + f, f2 - this.caretHeight);
            path.lineTo(((f8 + this.caretWidth) / 2.0f) + f, f2);
        }
        path.lineTo(f3 - this.borderRadius, f2);
        float f9 = f3 - f5;
        path.addArc(new RectF(f9, f2, f3, f7), -90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.RIGHT) {
            float f10 = f4 - f2;
            path.lineTo(f3, ((f10 - this.caretWidth) / 2.0f) + f2);
            path.lineTo(this.caretHeight + f3, (f10 / 2.0f) + f2);
            path.lineTo(f3, ((f10 + this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f3, f4 - this.borderRadius);
        float f11 = f4 - f5;
        path.addArc(new RectF(f9, f11, f3, f4), 0.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.BOTTOM) {
            float f12 = f3 - f;
            path.lineTo(((this.caretWidth + f12) / 2.0f) + f, f4);
            path.lineTo((f12 / 2.0f) + f, this.caretHeight + f4);
            path.lineTo(((f12 - this.caretWidth) / 2.0f) + f, f4);
        }
        path.lineTo(this.borderRadius + f, f4);
        path.addArc(new RectF(f, f11, f6, f4), 90.0f, 90.0f);
        if (this.caretPosition == LikeBoxCountViewCaretPosition.LEFT) {
            float f13 = f4 - f2;
            path.lineTo(f, ((this.caretWidth + f13) / 2.0f) + f2);
            path.lineTo(f - this.caretHeight, (f13 / 2.0f) + f2);
            path.lineTo(f, ((f13 - this.caretWidth) / 2.0f) + f2);
        }
        path.lineTo(f, f2 + this.borderRadius);
        canvas.drawPath(path, this.borderPaint);
    }
}
