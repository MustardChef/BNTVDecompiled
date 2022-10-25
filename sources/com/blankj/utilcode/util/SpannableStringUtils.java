package com.blankj.utilcode.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class SpannableStringUtils {
    public static final int ALIGN_BASELINE = 1;
    public static final int ALIGN_BOTTOM = 0;
    public static final int ALIGN_CENTER = 2;
    public static final int ALIGN_TOP = 3;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Align {
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Layout.Alignment alignment;
        private Bitmap bitmap;
        private float blurRadius;
        private int bulletColor;
        private int bulletGapWidth;
        private int bulletRadius;
        private ClickableSpan clickSpan;
        private Drawable drawable;
        private int first;
        private String fontFamily;
        private boolean fontSizeIsDp;
        private boolean imageIsBitmap;
        private boolean imageIsDrawable;
        private boolean imageIsResourceId;
        private boolean imageIsUri;
        private boolean isBlur;
        private boolean isBold;
        private boolean isBoldItalic;
        private boolean isBullet;
        private boolean isItalic;
        private boolean isLeadingMargin;
        private boolean isStrikethrough;
        private boolean isSubscript;
        private boolean isSuperscript;
        private boolean isUnderline;
        private int quoteGapWidth;
        private int resourceId;
        private int rest;
        private int stripeWidth;
        private BlurMaskFilter.Blur style;
        private CharSequence text;
        private Typeface typeface;
        private Uri uri;
        private String url;
        private int defaultValue = 301989888;
        private int flag = 33;
        private int foregroundColor = 301989888;
        private int backgroundColor = 301989888;
        private int quoteColor = 301989888;
        private int margin = -1;
        private int fontSize = -1;
        private float proportion = -1.0f;
        private float xProportion = -1.0f;
        int align = 0;
        private SpannableStringBuilder mBuilder = new SpannableStringBuilder();

        private void setSpan() {
            CharSequence charSequence = this.text;
            if (charSequence == null || charSequence.length() == 0) {
                return;
            }
            int length = this.mBuilder.length();
            this.mBuilder.append(this.text);
            int length2 = this.mBuilder.length();
            if (this.backgroundColor != this.defaultValue) {
                this.mBuilder.setSpan(new BackgroundColorSpan(this.backgroundColor), length, length2, this.flag);
                this.backgroundColor = this.defaultValue;
            }
            if (this.foregroundColor != this.defaultValue) {
                this.mBuilder.setSpan(new ForegroundColorSpan(this.foregroundColor), length, length2, this.flag);
                this.foregroundColor = this.defaultValue;
            }
            if (this.isLeadingMargin) {
                this.mBuilder.setSpan(new LeadingMarginSpan.Standard(this.first, this.rest), length, length2, this.flag);
                this.isLeadingMargin = false;
            }
            if (this.margin != -1) {
                this.mBuilder.setSpan(new MarginSpan(this.margin), length, length2, this.flag);
                this.margin = -1;
            }
            int i = this.quoteColor;
            if (i != this.defaultValue) {
                this.mBuilder.setSpan(new CustomQuoteSpan(i, this.stripeWidth, this.quoteGapWidth), length, length2, this.flag);
                this.quoteColor = this.defaultValue;
            }
            if (this.isBullet) {
                this.mBuilder.setSpan(new CustomBulletSpan(this.bulletColor, this.bulletRadius, this.bulletGapWidth), length, length2, this.flag);
                this.isBullet = false;
            }
            if (this.fontSize != -1) {
                this.mBuilder.setSpan(new AbsoluteSizeSpan(this.fontSize, this.fontSizeIsDp), length, length2, this.flag);
                this.fontSize = -1;
                this.fontSizeIsDp = false;
            }
            if (this.proportion != -1.0f) {
                this.mBuilder.setSpan(new RelativeSizeSpan(this.proportion), length, length2, this.flag);
                this.proportion = -1.0f;
            }
            if (this.xProportion != -1.0f) {
                this.mBuilder.setSpan(new ScaleXSpan(this.xProportion), length, length2, this.flag);
                this.xProportion = -1.0f;
            }
            if (this.isStrikethrough) {
                this.mBuilder.setSpan(new StrikethroughSpan(), length, length2, this.flag);
                this.isStrikethrough = false;
            }
            if (this.isUnderline) {
                this.mBuilder.setSpan(new UnderlineSpan(), length, length2, this.flag);
                this.isUnderline = false;
            }
            if (this.isSuperscript) {
                this.mBuilder.setSpan(new SuperscriptSpan(), length, length2, this.flag);
                this.isSuperscript = false;
            }
            if (this.isSubscript) {
                this.mBuilder.setSpan(new SubscriptSpan(), length, length2, this.flag);
                this.isSubscript = false;
            }
            if (this.isBold) {
                this.mBuilder.setSpan(new StyleSpan(1), length, length2, this.flag);
                this.isBold = false;
            }
            if (this.isItalic) {
                this.mBuilder.setSpan(new StyleSpan(2), length, length2, this.flag);
                this.isItalic = false;
            }
            if (this.isBoldItalic) {
                this.mBuilder.setSpan(new StyleSpan(3), length, length2, this.flag);
                this.isBoldItalic = false;
            }
            if (this.fontFamily != null) {
                this.mBuilder.setSpan(new TypefaceSpan(this.fontFamily), length, length2, this.flag);
                this.fontFamily = null;
            }
            if (this.typeface != null) {
                this.mBuilder.setSpan(new CustomTypefaceSpan(this.typeface), length, length2, this.flag);
                this.typeface = null;
            }
            if (this.alignment != null) {
                this.mBuilder.setSpan(new AlignmentSpan.Standard(this.alignment), length, length2, this.flag);
                this.alignment = null;
            }
            boolean z = this.imageIsBitmap;
            if (z || this.imageIsDrawable || this.imageIsUri || this.imageIsResourceId) {
                if (z) {
                    this.mBuilder.setSpan(new CustomImageSpan(Utils.getContext(), this.bitmap, this.align), length, length2, this.flag);
                    this.bitmap = null;
                    this.imageIsBitmap = false;
                } else if (this.imageIsDrawable) {
                    this.mBuilder.setSpan(new CustomImageSpan(this.drawable, this.align), length, length2, this.flag);
                    this.drawable = null;
                    this.imageIsDrawable = false;
                } else if (this.imageIsUri) {
                    this.mBuilder.setSpan(new CustomImageSpan(Utils.getContext(), this.uri, this.align), length, length2, this.flag);
                    this.uri = null;
                    this.imageIsUri = false;
                } else {
                    this.mBuilder.setSpan(new CustomImageSpan(Utils.getContext(), this.resourceId, this.align), length, length2, this.flag);
                    this.resourceId = 0;
                    this.imageIsResourceId = false;
                }
            }
            ClickableSpan clickableSpan = this.clickSpan;
            if (clickableSpan != null) {
                this.mBuilder.setSpan(clickableSpan, length, length2, this.flag);
                this.clickSpan = null;
            }
            if (this.url != null) {
                this.mBuilder.setSpan(new URLSpan(this.url), length, length2, this.flag);
                this.url = null;
            }
            if (this.isBlur) {
                this.mBuilder.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.blurRadius, this.style)), length, length2, this.flag);
                this.isBlur = false;
            }
            this.flag = 33;
        }

        public Builder append(CharSequence charSequence) {
            setSpan();
            this.text = charSequence;
            return this;
        }

        public Builder appendLine(CharSequence charSequence) {
            return append(((Object) charSequence) + SpannableStringUtils.LINE_SEPARATOR);
        }

        public SpannableStringBuilder create() {
            setSpan();
            return this.mBuilder;
        }

        public Builder setAlign(Layout.Alignment alignment) {
            this.alignment = alignment;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.backgroundColor = i;
            return this;
        }

        public Builder setBitmap(Bitmap bitmap) {
            return setBitmap(bitmap, this.align);
        }

        public Builder setBitmap(Bitmap bitmap, int i) {
            this.bitmap = bitmap;
            this.align = i;
            this.text = " " + ((Object) this.text);
            this.imageIsBitmap = true;
            return this;
        }

        public Builder setBlur(float f, BlurMaskFilter.Blur blur) {
            this.blurRadius = f;
            this.style = blur;
            this.isBlur = true;
            return this;
        }

        public Builder setBold() {
            this.isBold = true;
            return this;
        }

        public Builder setBoldItalic() {
            this.isBoldItalic = true;
            return this;
        }

        public Builder setBullet(int i) {
            this.bulletColor = 0;
            this.bulletRadius = 3;
            this.bulletGapWidth = i;
            this.isBullet = true;
            return this;
        }

        public Builder setBullet(int i, int i2, int i3) {
            this.bulletColor = i;
            this.bulletRadius = i2;
            this.bulletGapWidth = i3;
            this.isBullet = true;
            return this;
        }

        public Builder setClickSpan(ClickableSpan clickableSpan) {
            this.clickSpan = clickableSpan;
            return this;
        }

        public Builder setDrawable(Drawable drawable) {
            return setDrawable(drawable, this.align);
        }

        public Builder setDrawable(Drawable drawable, int i) {
            this.drawable = drawable;
            this.align = i;
            this.text = " " + ((Object) this.text);
            this.imageIsDrawable = true;
            return this;
        }

        public Builder setFlag(int i) {
            this.flag = i;
            return this;
        }

        public Builder setFontFamily(String str) {
            this.fontFamily = str;
            return this;
        }

        public Builder setFontProportion(float f) {
            this.proportion = f;
            return this;
        }

        public Builder setFontSize(int i) {
            this.fontSize = i;
            this.fontSizeIsDp = false;
            return this;
        }

        public Builder setFontSize(int i, boolean z) {
            this.fontSize = i;
            this.fontSizeIsDp = z;
            return this;
        }

        public Builder setFontXProportion(float f) {
            this.xProportion = f;
            return this;
        }

        public Builder setForegroundColor(int i) {
            this.foregroundColor = i;
            return this;
        }

        public Builder setItalic() {
            this.isItalic = true;
            return this;
        }

        public Builder setLeadingMargin(int i, int i2) {
            this.first = i;
            this.rest = i2;
            this.isLeadingMargin = true;
            return this;
        }

        public Builder setMargin(int i) {
            this.margin = i;
            this.text = " " + ((Object) this.text);
            return this;
        }

        public Builder setQuoteColor(int i) {
            this.quoteColor = i;
            this.stripeWidth = 2;
            this.quoteGapWidth = 2;
            return this;
        }

        public Builder setQuoteColor(int i, int i2, int i3) {
            this.quoteColor = i;
            this.stripeWidth = i2;
            this.quoteGapWidth = i3;
            return this;
        }

        public Builder setResourceId(int i) {
            return setResourceId(i, this.align);
        }

        public Builder setResourceId(int i, int i2) {
            this.resourceId = i;
            this.align = i2;
            this.text = " " + ((Object) this.text);
            this.imageIsResourceId = true;
            return this;
        }

        public Builder setStrikethrough() {
            this.isStrikethrough = true;
            return this;
        }

        public Builder setSubscript() {
            this.isSubscript = true;
            return this;
        }

        public Builder setSuperscript() {
            this.isSuperscript = true;
            return this;
        }

        public Builder setTypeface(Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public Builder setUnderline() {
            this.isUnderline = true;
            return this;
        }

        public Builder setUri(Uri uri) {
            setUri(uri, 0);
            return this;
        }

        public Builder setUri(Uri uri, int i) {
            this.uri = uri;
            this.align = i;
            this.text = " " + ((Object) this.text);
            this.imageIsUri = true;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CustomBulletSpan implements LeadingMarginSpan {
        private static Path sBulletPath;
        private final int color;
        private final int gapWidth;
        private final int radius;

        private CustomBulletSpan(int i, int i2, int i3) {
            this.color = i;
            this.radius = i2;
            this.gapWidth = i3;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i6) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.color);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (sBulletPath == null) {
                        Path path = new Path();
                        sBulletPath = path;
                        path.addCircle(0.0f, 0.0f, this.radius, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate(i + (i2 * this.radius), (i3 + i5) / 2.0f);
                    canvas.drawPath(sBulletPath, paint);
                    canvas.restore();
                } else {
                    int i8 = this.radius;
                    canvas.drawCircle(i + (i2 * i8), (i3 + i5) / 2.0f, i8, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return (this.radius * 2) + this.gapWidth;
        }
    }

    /* loaded from: classes.dex */
    static abstract class CustomDynamicDrawableSpan extends ReplacementSpan {
        static final int ALIGN_BASELINE = 1;
        static final int ALIGN_BOTTOM = 0;
        static final int ALIGN_CENTER = 2;
        static final int ALIGN_TOP = 3;
        private WeakReference<Drawable> mDrawableRef;
        final int mVerticalAlignment;

        CustomDynamicDrawableSpan() {
            this.mVerticalAlignment = 0;
        }

        CustomDynamicDrawableSpan(int i) {
            this.mVerticalAlignment = i;
        }

        private Drawable getCachedDrawable() {
            WeakReference<Drawable> weakReference = this.mDrawableRef;
            if ((weakReference != null ? weakReference.get() : null) == null) {
                this.mDrawableRef = new WeakReference<>(getDrawable());
            }
            return getDrawable();
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
            if (r0.mVerticalAlignment == 1) goto L15;
         */
        @Override // android.text.style.ReplacementSpan
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void draw(android.graphics.Canvas r1, java.lang.CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, android.graphics.Paint r9) {
            /*
                r0 = this;
                android.graphics.drawable.Drawable r2 = r0.getCachedDrawable()
                android.graphics.Rect r3 = r2.getBounds()
                r1.save()
                android.graphics.Paint$FontMetrics r4 = r9.getFontMetrics()
                float r4 = r4.descent
                android.graphics.Paint$FontMetrics r6 = r9.getFontMetrics()
                float r6 = r6.ascent
                float r4 = r4 - r6
                int r6 = r3.bottom
                int r8 = r8 - r6
                int r6 = r3.height()
                float r6 = (float) r6
                r7 = 1
                int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r6 >= 0) goto L45
                int r6 = r0.mVerticalAlignment
                if (r6 != r7) goto L2a
                goto L49
            L2a:
                r7 = 2
                if (r6 != r7) goto L3a
                float r6 = (float) r8
                int r3 = r3.height()
                float r3 = (float) r3
                float r4 = r4 - r3
                r3 = 1073741824(0x40000000, float:2.0)
                float r4 = r4 / r3
            L37:
                float r6 = r6 - r4
                int r8 = (int) r6
                goto L50
            L3a:
                r7 = 3
                if (r6 != r7) goto L50
                float r6 = (float) r8
                int r3 = r3.height()
                float r3 = (float) r3
                float r4 = r4 - r3
                goto L37
            L45:
                int r3 = r0.mVerticalAlignment
                if (r3 != r7) goto L50
            L49:
                android.graphics.Paint$FontMetricsInt r3 = r9.getFontMetricsInt()
                int r3 = r3.descent
                int r8 = r8 - r3
            L50:
                float r3 = (float) r8
                r1.translate(r5, r3)
                r2.draw(r1)
                r1.restore()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.SpannableStringUtils.CustomDynamicDrawableSpan.draw(android.graphics.Canvas, java.lang.CharSequence, int, int, float, int, int, int, android.graphics.Paint):void");
        }

        public abstract Drawable getDrawable();

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            int i3;
            int height;
            int height2;
            Rect bounds = getCachedDrawable().getBounds();
            int i4 = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
            if (fontMetricsInt != null && bounds.height() > i4) {
                int i5 = this.mVerticalAlignment;
                if (i5 == 3) {
                    height2 = fontMetricsInt.descent + (bounds.height() - i4);
                } else if (i5 == 2) {
                    fontMetricsInt.ascent -= (bounds.height() - i4) / 2;
                    height2 = fontMetricsInt.descent + ((bounds.height() - i4) / 2);
                } else {
                    if (i5 == 1) {
                        i3 = fontMetricsInt.ascent;
                        height = (bounds.height() - i4) + fontMetricsInt.descent;
                    } else {
                        i3 = fontMetricsInt.ascent;
                        height = bounds.height() - i4;
                    }
                    fontMetricsInt.ascent = i3 - height;
                }
                fontMetricsInt.descent = height2;
            }
            return bounds.right;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CustomImageSpan extends CustomDynamicDrawableSpan {
        private Uri mContentUri;
        private Context mContext;
        private Drawable mDrawable;
        private int mResourceId;

        CustomImageSpan(Context context, int i, int i2) {
            super(i2);
            this.mContext = context;
            this.mResourceId = i;
        }

        CustomImageSpan(Context context, Bitmap bitmap, int i) {
            super(i);
            this.mContext = context;
            BitmapDrawable bitmapDrawable = context != null ? new BitmapDrawable(context.getResources(), bitmap) : new BitmapDrawable(bitmap);
            this.mDrawable = bitmapDrawable;
            int intrinsicWidth = bitmapDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
            this.mDrawable.setBounds(0, 0, intrinsicWidth <= 0 ? 0 : intrinsicWidth, intrinsicHeight <= 0 ? 0 : intrinsicHeight);
        }

        CustomImageSpan(Context context, Uri uri, int i) {
            super(i);
            this.mContext = context;
            this.mContentUri = uri;
        }

        CustomImageSpan(Drawable drawable, int i) {
            super(i);
            this.mDrawable = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }

        @Override // com.blankj.utilcode.util.SpannableStringUtils.CustomDynamicDrawableSpan
        public Drawable getDrawable() {
            Drawable drawable;
            Drawable drawable2 = this.mDrawable;
            if (drawable2 != null) {
                return drawable2;
            }
            BitmapDrawable bitmapDrawable = null;
            if (this.mContentUri == null) {
                try {
                    drawable = ContextCompat.getDrawable(this.mContext, this.mResourceId);
                } catch (Exception unused) {
                    drawable = null;
                }
                try {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    return drawable;
                } catch (Exception unused2) {
                    Log.e("sms", "Unable to find resource: " + this.mResourceId);
                    return drawable;
                }
            }
            try {
                InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.mContentUri);
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                    return bitmapDrawable2;
                } catch (Exception e) {
                    e = e;
                    bitmapDrawable = bitmapDrawable2;
                    Log.e("sms", "Failed to loaded content " + this.mContentUri, e);
                    return bitmapDrawable;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CustomQuoteSpan implements LeadingMarginSpan {
        private final int color;
        private final int gapWidth;
        private final int stripeWidth;

        private CustomQuoteSpan(int i, int i2, int i3) {
            this.color = i;
            this.stripeWidth = i2;
            this.gapWidth = i3;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.color);
            canvas.drawRect(i, i3, i + (this.stripeWidth * i2), i5, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            return this.stripeWidth + this.gapWidth;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        private CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.newType = typeface;
        }

        private static void apply(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            apply(textPaint, this.newType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class MarginSpan extends ReplacementSpan {
        private final int margin;

        private MarginSpan(int i) {
            this.margin = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            return this.margin;
        }
    }

    private SpannableStringUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }
}
