package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class Shimmer {
    private static final int COMPONENT_COUNT = 4;
    long repeatDelay;
    final float[] positions = new float[4];
    final int[] colors = new int[4];
    final RectF bounds = new RectF();
    int direction = 0;
    int highlightColor = -1;
    int baseColor = 1291845631;
    int shape = 0;
    int fixedWidth = 0;
    int fixedHeight = 0;
    float widthRatio = 1.0f;
    float heightRatio = 1.0f;
    float intensity = 0.0f;
    float dropoff = 0.5f;
    float tilt = 20.0f;
    boolean clipToChildren = true;
    boolean autoStart = true;
    boolean alphaShimmer = true;
    int repeatCount = -1;
    int repeatMode = 1;
    long animationDuration = 1000;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    Shimmer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int width(int i) {
        int i2 = this.fixedWidth;
        return i2 > 0 ? i2 : Math.round(this.widthRatio * i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int height(int i) {
        int i2 = this.fixedHeight;
        return i2 > 0 ? i2 : Math.round(this.heightRatio * i);
    }

    void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i = this.baseColor;
            iArr[0] = i;
            int i2 = this.highlightColor;
            iArr[1] = i2;
            iArr[2] = i2;
            iArr[3] = i;
            return;
        }
        int[] iArr2 = this.colors;
        int i3 = this.highlightColor;
        iArr2[0] = i3;
        iArr2[1] = i3;
        int i4 = this.baseColor;
        iArr2[2] = i4;
        iArr2[3] = i4;
    }

    void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f);
            this.positions[1] = Math.max(((1.0f - this.intensity) - 0.001f) / 2.0f, 0.0f);
            this.positions[2] = Math.min(((this.intensity + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    void updateBounds(int i, int i2) {
        int round;
        double max = Math.max(i, i2);
        float f = -(Math.round(((float) ((max / Math.sin(1.5707963267948966d - Math.toRadians(this.tilt % 90.0f))) - max)) / 2.0f) * 3);
        this.bounds.set(f, f, width(i) + round, height(i2) + round);
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<T extends Builder<T>> {
        final Shimmer mShimmer = new Shimmer();

        protected abstract T getThis();

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, C2268R.styleable.ShimmerFrameLayout, 0, 0));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public T consumeAttributes(TypedArray typedArray) {
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_clip_to_children)) {
                setClipToChildren(typedArray.getBoolean(C2268R.styleable.ShimmerFrameLayout_shimmer_clip_to_children, this.mShimmer.clipToChildren));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_auto_start)) {
                setAutoStart(typedArray.getBoolean(C2268R.styleable.ShimmerFrameLayout_shimmer_auto_start, this.mShimmer.autoStart));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_base_alpha)) {
                setBaseAlpha(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                setHighlightAlpha(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_duration)) {
                setDuration(typedArray.getInt(C2268R.styleable.ShimmerFrameLayout_shimmer_duration, (int) this.mShimmer.animationDuration));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_repeat_count)) {
                setRepeatCount(typedArray.getInt(C2268R.styleable.ShimmerFrameLayout_shimmer_repeat_count, this.mShimmer.repeatCount));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                setRepeatDelay(typedArray.getInt(C2268R.styleable.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.mShimmer.repeatDelay));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_repeat_mode)) {
                setRepeatMode(typedArray.getInt(C2268R.styleable.ShimmerFrameLayout_shimmer_repeat_mode, this.mShimmer.repeatMode));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_direction)) {
                int i = typedArray.getInt(C2268R.styleable.ShimmerFrameLayout_shimmer_direction, this.mShimmer.direction);
                if (i == 1) {
                    setDirection(1);
                } else if (i == 2) {
                    setDirection(2);
                } else if (i != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(C2268R.styleable.ShimmerFrameLayout_shimmer_shape, this.mShimmer.shape) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_dropoff)) {
                setDropoff(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_dropoff, this.mShimmer.dropoff));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_fixed_width)) {
                setFixedWidth(typedArray.getDimensionPixelSize(C2268R.styleable.ShimmerFrameLayout_shimmer_fixed_width, this.mShimmer.fixedWidth));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_fixed_height)) {
                setFixedHeight(typedArray.getDimensionPixelSize(C2268R.styleable.ShimmerFrameLayout_shimmer_fixed_height, this.mShimmer.fixedHeight));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_intensity)) {
                setIntensity(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_intensity, this.mShimmer.intensity));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_width_ratio)) {
                setWidthRatio(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_width_ratio, this.mShimmer.widthRatio));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_height_ratio)) {
                setHeightRatio(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_height_ratio, this.mShimmer.heightRatio));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_tilt)) {
                setTilt(typedArray.getFloat(C2268R.styleable.ShimmerFrameLayout_shimmer_tilt, this.mShimmer.tilt));
            }
            return getThis();
        }

        public T copyFrom(Shimmer shimmer) {
            setDirection(shimmer.direction);
            setShape(shimmer.shape);
            setFixedWidth(shimmer.fixedWidth);
            setFixedHeight(shimmer.fixedHeight);
            setWidthRatio(shimmer.widthRatio);
            setHeightRatio(shimmer.heightRatio);
            setIntensity(shimmer.intensity);
            setDropoff(shimmer.dropoff);
            setTilt(shimmer.tilt);
            setClipToChildren(shimmer.clipToChildren);
            setAutoStart(shimmer.autoStart);
            setRepeatCount(shimmer.repeatCount);
            setRepeatMode(shimmer.repeatMode);
            setRepeatDelay(shimmer.repeatDelay);
            setDuration(shimmer.animationDuration);
            this.mShimmer.baseColor = shimmer.baseColor;
            this.mShimmer.highlightColor = shimmer.highlightColor;
            return getThis();
        }

        public T setDirection(int i) {
            this.mShimmer.direction = i;
            return getThis();
        }

        public T setShape(int i) {
            this.mShimmer.shape = i;
            return getThis();
        }

        public T setFixedWidth(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Given invalid width: " + i);
            }
            this.mShimmer.fixedWidth = i;
            return getThis();
        }

        public T setFixedHeight(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Given invalid height: " + i);
            }
            this.mShimmer.fixedHeight = i;
            return getThis();
        }

        public T setWidthRatio(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid width ratio: " + f);
            }
            this.mShimmer.widthRatio = f;
            return getThis();
        }

        public T setHeightRatio(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid height ratio: " + f);
            }
            this.mShimmer.heightRatio = f;
            return getThis();
        }

        public T setIntensity(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid intensity value: " + f);
            }
            this.mShimmer.intensity = f;
            return getThis();
        }

        public T setDropoff(float f) {
            if (f < 0.0f) {
                throw new IllegalArgumentException("Given invalid dropoff value: " + f);
            }
            this.mShimmer.dropoff = f;
            return getThis();
        }

        public T setTilt(float f) {
            this.mShimmer.tilt = f;
            return getThis();
        }

        public T setBaseAlpha(float f) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (((int) (clamp(0.0f, 1.0f, f) * 255.0f)) << 24) | (shimmer.baseColor & ViewCompat.MEASURED_SIZE_MASK);
            return getThis();
        }

        public T setHighlightAlpha(float f) {
            Shimmer shimmer = this.mShimmer;
            shimmer.highlightColor = (((int) (clamp(0.0f, 1.0f, f) * 255.0f)) << 24) | (shimmer.highlightColor & ViewCompat.MEASURED_SIZE_MASK);
            return getThis();
        }

        public T setClipToChildren(boolean z) {
            this.mShimmer.clipToChildren = z;
            return getThis();
        }

        public T setAutoStart(boolean z) {
            this.mShimmer.autoStart = z;
            return getThis();
        }

        public T setRepeatCount(int i) {
            this.mShimmer.repeatCount = i;
            return getThis();
        }

        public T setRepeatMode(int i) {
            this.mShimmer.repeatMode = i;
            return getThis();
        }

        public T setRepeatDelay(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("Given a negative repeat delay: " + j);
            }
            this.mShimmer.repeatDelay = j;
            return getThis();
        }

        public T setDuration(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("Given a negative duration: " + j);
            }
            this.mShimmer.animationDuration = j;
            return getThis();
        }

        public Shimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        private static float clamp(float f, float f2, float f3) {
            return Math.min(f2, Math.max(f, f3));
        }
    }

    /* loaded from: classes2.dex */
    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public AlphaHighlightBuilder getThis() {
            return this;
        }

        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }
    }

    /* loaded from: classes2.dex */
    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        public ColorHighlightBuilder setHighlightColor(int i) {
            this.mShimmer.highlightColor = i;
            return getThis();
        }

        public ColorHighlightBuilder setBaseColor(int i) {
            this.mShimmer.baseColor = (i & ViewCompat.MEASURED_SIZE_MASK) | (this.mShimmer.baseColor & ViewCompat.MEASURED_STATE_MASK);
            return getThis();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.facebook.shimmer.Shimmer.Builder
        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_base_color)) {
                setBaseColor(typedArray.getColor(C2268R.styleable.ShimmerFrameLayout_shimmer_base_color, this.mShimmer.baseColor));
            }
            if (typedArray.hasValue(C2268R.styleable.ShimmerFrameLayout_shimmer_highlight_color)) {
                setHighlightColor(typedArray.getColor(C2268R.styleable.ShimmerFrameLayout_shimmer_highlight_color, this.mShimmer.highlightColor));
            }
            return getThis();
        }
    }
}
