package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzcu;
import com.google.android.gms.internal.cast.zzcv;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class OuterHighlightDrawable extends Drawable {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final Rect zzd = new Rect();
    private final Rect zze = new Rect();
    private final Paint zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    public OuterHighlightDrawable(Context context) {
        Paint paint = new Paint();
        this.zzf = paint;
        this.zzh = 1.0f;
        this.zzk = 0.0f;
        this.zzl = 0.0f;
        this.zzm = 244;
        if (PlatformVersion.isAtLeastLollipop()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843827, typedValue, true);
            zzb(ColorUtils.setAlphaComponent(typedValue.data, 244));
        } else {
            zzb(context.getResources().getColor(C3616R.C3617color.f9703xfbd34f47));
        }
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        this.zza = resources.getDimensionPixelSize(C3616R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.zzb = resources.getDimensionPixelSize(C3616R.dimen.f9705xd1678993);
        this.zzc = resources.getDimensionPixelSize(C3616R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    private static final float zzh(float f, float f2, Rect rect) {
        float f3 = rect.left;
        float f4 = rect.top;
        float f5 = rect.right;
        float f6 = rect.bottom;
        float zza = zzcv.zza(f, f2, f3, f4);
        float zza2 = zzcv.zza(f, f2, f5, f4);
        float zza3 = zzcv.zza(f, f2, f5, f6);
        float zza4 = zzcv.zza(f, f2, f3, f6);
        if (zza <= zza2 || zza <= zza3 || zza <= zza4) {
            zza = (zza2 <= zza3 || zza2 <= zza4) ? zza3 > zza4 ? zza3 : zza4 : zza2;
        }
        return (float) Math.ceil(zza);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.zzi + this.zzk, this.zzj + this.zzl, this.zzg * this.zzh, this.zzf);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.zzf.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.zzf.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzf.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setScale(float f) {
        this.zzh = f;
        invalidateSelf();
    }

    public void setTranslationX(float f) {
        this.zzk = f;
        invalidateSelf();
    }

    public void setTranslationY(float f) {
        this.zzl = f;
        invalidateSelf();
    }

    public final int zza() {
        return this.zzf.getColor();
    }

    public final void zzb(int i) {
        this.zzf.setColor(i);
        this.zzm = this.zzf.getAlpha();
        invalidateSelf();
    }

    public final void zzc(Rect rect, Rect rect2) {
        float exactCenterX;
        this.zzd.set(rect);
        this.zze.set(rect2);
        float exactCenterX2 = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(exactCenterY - bounds.top, bounds.bottom - exactCenterY) < this.zza) {
            this.zzi = exactCenterX2;
            this.zzj = exactCenterY;
        } else {
            if (exactCenterX2 <= bounds.exactCenterX()) {
                exactCenterX = rect2.exactCenterX() + this.zzb;
            } else {
                exactCenterX = rect2.exactCenterX() - this.zzb;
            }
            this.zzi = exactCenterX;
            exactCenterY = rect2.exactCenterY();
            this.zzj = exactCenterY;
        }
        this.zzg = this.zzc + Math.max(zzh(this.zzi, exactCenterY, rect), zzh(this.zzi, this.zzj, rect2));
        invalidateSelf();
    }

    public final float zzd() {
        return this.zzi;
    }

    public final float zze() {
        return this.zzj;
    }

    public final boolean zzf(float f, float f2) {
        return zzcv.zza(f, f2, this.zzi, this.zzj) < this.zzg;
    }

    public final Animator zzg(float f, float f2) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationX", f, 0.0f), PropertyValuesHolder.ofFloat("translationY", f2, 0.0f), PropertyValuesHolder.ofInt("alpha", 0, this.zzm));
        ofPropertyValuesHolder.setInterpolator(zzcu.zza());
        return ofPropertyValuesHolder.setDuration(350L);
    }
}
