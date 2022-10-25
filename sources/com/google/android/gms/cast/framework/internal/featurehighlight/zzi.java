package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.C3616R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzi {
    private final Rect zza = new Rect();
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;
    private final zzh zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(zzh zzhVar) {
        this.zzf = zzhVar;
        Resources resources = zzhVar.getResources();
        this.zzb = resources.getDimensionPixelSize(C3616R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.zzc = resources.getDimensionPixelOffset(C3616R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.zzd = resources.getDimensionPixelSize(C3616R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.zze = resources.getDimensionPixelSize(C3616R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    private final int zzb(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = i3 / 2;
        int i6 = i4 - i <= i2 - i4 ? (i4 - i5) + this.zze : (i4 - i5) - this.zze;
        if (i6 - marginLayoutParams.leftMargin < i) {
            return i + marginLayoutParams.leftMargin;
        }
        return (i6 + i3) + marginLayoutParams.rightMargin > i2 ? (i2 - i3) - marginLayoutParams.rightMargin : i6;
    }

    private final void zzc(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.zzd), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Rect rect, Rect rect2) {
        View zzg = this.zzf.zzg();
        if (rect.isEmpty() || rect2.isEmpty()) {
            zzg.layout(0, 0, 0, 0);
        } else {
            int centerY = rect.centerY();
            int centerX = rect.centerX();
            int centerY2 = rect2.centerY();
            int height = rect.height();
            int i = this.zzb;
            int max = Math.max(i + i, height) / 2;
            int i2 = this.zzc;
            int i3 = centerY + max + i2;
            if (centerY < centerY2) {
                zzc(zzg, rect2.width(), rect2.bottom - i3);
                int zzb = zzb(zzg, rect2.left, rect2.right, zzg.getMeasuredWidth(), centerX);
                zzg.layout(zzb, i3, zzg.getMeasuredWidth() + zzb, zzg.getMeasuredHeight() + i3);
            } else {
                int i4 = (centerY - max) - i2;
                zzc(zzg, rect2.width(), i4 - rect2.top);
                int zzb2 = zzb(zzg, rect2.left, rect2.right, zzg.getMeasuredWidth(), centerX);
                zzg.layout(zzb2, i4 - zzg.getMeasuredHeight(), zzg.getMeasuredWidth() + zzb2, i4);
            }
        }
        this.zza.set(zzg.getLeft(), zzg.getTop(), zzg.getRight(), zzg.getBottom());
        this.zzf.zzh().zzc(rect, this.zza);
        this.zzf.zzi().zza(rect);
    }
}
