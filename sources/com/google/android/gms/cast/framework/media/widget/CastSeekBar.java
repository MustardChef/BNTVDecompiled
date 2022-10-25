package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class CastSeekBar extends View {
    public zzf zza;
    public zzd zzb;
    public List<zzc> zzc;
    public zze zzd;
    private boolean zze;
    private Integer zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;
    private final Paint zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private int[] zzq;
    private Point zzr;
    private Runnable zzs;

    public CastSeekBar(Context context) {
        this(context, null);
    }

    private final void zzf(Canvas canvas, int i, int i2, int i3, int i4, int i5) {
        this.zzl.setColor(i5);
        float f = i3;
        float f2 = i4;
        float f3 = this.zzi;
        canvas.drawRect((i / f) * f2, -f3, (i2 / f) * f2, f3, this.zzl);
    }

    public final void zzg(int i) {
        zzf zzfVar = this.zza;
        if (zzfVar.zzf) {
            this.zzf = Integer.valueOf(CastUtils.zzc(i, zzfVar.zzd, zzfVar.zze));
            zze zzeVar = this.zzd;
            if (zzeVar != null) {
                zzeVar.zzc(this, getProgress(), true);
            }
            Runnable runnable = this.zzs;
            if (runnable == null) {
                this.zzs = new Runnable(this) { // from class: com.google.android.gms.cast.framework.media.widget.zza
                    private final CastSeekBar zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.sendAccessibilityEvent(4);
                    }
                };
            } else {
                removeCallbacks(runnable);
            }
            postDelayed(this.zzs, 200L);
            postInvalidate();
        }
    }

    public final void zzh() {
        this.zze = true;
        zze zzeVar = this.zzd;
        if (zzeVar != null) {
            zzeVar.zzb(this);
        }
    }

    public final void zzi() {
        this.zze = false;
        zze zzeVar = this.zzd;
        if (zzeVar != null) {
            zzeVar.zza(this);
        }
    }

    private final int zzj(int i) {
        return (int) ((i / ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) * this.zza.zzb);
    }

    public int getMaxProgress() {
        return this.zza.zzb;
    }

    public int getProgress() {
        Integer num = this.zzf;
        if (num != null) {
            return num.intValue();
        }
        return this.zza.zza;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Runnable runnable = this.zzs;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int save = canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        zzd zzdVar = this.zzb;
        if (zzdVar != null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = getMeasuredHeight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int save2 = canvas.save();
            canvas.translate(0.0f, ((measuredHeight - paddingTop) - paddingBottom) / 2);
            zzf(canvas, 0, zzdVar.zza, zzdVar.zzb, measuredWidth, this.zzp);
            int i = zzdVar.zza;
            int i2 = zzdVar.zzb;
            zzf(canvas, i, i2, i2, measuredWidth, this.zzo);
            canvas.restoreToCount(save2);
        } else {
            int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight2 = getMeasuredHeight();
            int paddingTop2 = getPaddingTop();
            int paddingBottom2 = getPaddingBottom();
            int progress = getProgress();
            int save3 = canvas.save();
            canvas.translate(0.0f, ((measuredHeight2 - paddingTop2) - paddingBottom2) / 2);
            zzf zzfVar = this.zza;
            if (zzfVar.zzf) {
                int i3 = zzfVar.zzd;
                if (i3 > 0) {
                    zzf(canvas, 0, i3, zzfVar.zzb, measuredWidth2, this.zzo);
                }
                zzf zzfVar2 = this.zza;
                int i4 = zzfVar2.zzd;
                if (progress > i4) {
                    zzf(canvas, i4, progress, zzfVar2.zzb, measuredWidth2, this.zzm);
                }
                zzf zzfVar3 = this.zza;
                int i5 = zzfVar3.zze;
                if (i5 > progress) {
                    zzf(canvas, progress, i5, zzfVar3.zzb, measuredWidth2, this.zzn);
                }
                zzf zzfVar4 = this.zza;
                int i6 = zzfVar4.zzb;
                int i7 = zzfVar4.zze;
                if (i6 > i7) {
                    zzf(canvas, i7, i6, i6, measuredWidth2, this.zzo);
                }
            } else {
                int max = Math.max(zzfVar.zzc, 0);
                if (max > 0) {
                    zzf(canvas, 0, max, this.zza.zzb, measuredWidth2, this.zzo);
                }
                if (progress > max) {
                    zzf(canvas, max, progress, this.zza.zzb, measuredWidth2, this.zzm);
                }
                int i8 = this.zza.zzb;
                if (i8 > progress) {
                    zzf(canvas, progress, i8, i8, measuredWidth2, this.zzo);
                }
            }
            canvas.restoreToCount(save3);
            List<zzc> list = this.zzc;
            if (list != null && !list.isEmpty()) {
                this.zzl.setColor(this.zzp);
                int measuredWidth3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight3 = getMeasuredHeight();
                int paddingTop3 = getPaddingTop();
                int paddingBottom3 = getPaddingBottom();
                int save4 = canvas.save();
                canvas.translate(0.0f, ((measuredHeight3 - paddingTop3) - paddingBottom3) / 2);
                for (zzc zzcVar : list) {
                    if (zzcVar != null) {
                        int min = Math.min(zzcVar.zza, this.zza.zzb);
                        int i9 = zzcVar.zzc ? zzcVar.zzb : 1;
                        float f = measuredWidth3;
                        float f2 = this.zza.zzb;
                        float f3 = (min * f) / f2;
                        float f4 = ((min + i9) * f) / f2;
                        float f5 = this.zzk;
                        if (f4 - f3 < f5) {
                            f4 = f3 + f5;
                        }
                        float f6 = f4 > f ? f : f4;
                        float f7 = f6 - f3 < f5 ? f6 - f5 : f3;
                        float f8 = this.zzi;
                        canvas.drawRect(f7, -f8, f6, f8, this.zzl);
                    }
                }
                canvas.restoreToCount(save4);
            }
            if (isEnabled() && this.zza.zzf) {
                this.zzl.setColor(this.zzm);
                int measuredWidth4 = getMeasuredWidth();
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int measuredHeight4 = getMeasuredHeight();
                int paddingTop4 = getPaddingTop();
                int paddingBottom4 = getPaddingBottom();
                int progress2 = getProgress();
                int i10 = this.zza.zzb;
                int save5 = canvas.save();
                canvas.drawCircle((int) ((progress2 / i10) * ((measuredWidth4 - paddingLeft) - paddingRight)), ((measuredHeight4 - paddingTop4) - paddingBottom4) / 2.0f, this.zzj, this.zzl);
                canvas.restoreToCount(save5);
            }
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSizeAndState((int) (this.zzg + getPaddingLeft() + getPaddingRight()), i, 0), resolveSizeAndState((int) (this.zzh + getPaddingTop() + getPaddingBottom()), i2, 0));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.zza.zzf) {
            if (this.zzr == null) {
                this.zzr = new Point();
            }
            if (this.zzq == null) {
                this.zzq = new int[2];
            }
            getLocationOnScreen(this.zzq);
            this.zzr.set((((int) motionEvent.getRawX()) - this.zzq[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.zzq[1]);
            int action = motionEvent.getAction();
            if (action == 0) {
                zzh();
                zzg(zzj(this.zzr.x));
                return true;
            } else if (action == 1) {
                zzg(zzj(this.zzr.x));
                zzi();
                return true;
            } else if (action == 2) {
                zzg(zzj(this.zzr.x));
                return true;
            } else if (action != 3) {
                return false;
            } else {
                this.zze = false;
                this.zzf = null;
                zze zzeVar = this.zzd;
                if (zzeVar != null) {
                    zzeVar.zzc(this, getProgress(), true);
                    this.zzd.zza(this);
                }
                postInvalidate();
                return true;
            }
        }
        return false;
    }

    public final void zza(List<zzc> list) {
        if (Objects.equal(this.zzc, list)) {
            return;
        }
        this.zzc = list == null ? null : new ArrayList(list);
        postInvalidate();
    }

    public final void zzb(zzf zzfVar) {
        if (this.zze) {
            return;
        }
        zzf zzfVar2 = new zzf();
        zzfVar2.zza = zzfVar.zza;
        zzfVar2.zzb = zzfVar.zzb;
        zzfVar2.zzc = zzfVar.zzc;
        zzfVar2.zzd = zzfVar.zzd;
        zzfVar2.zze = zzfVar.zze;
        zzfVar2.zzf = zzfVar.zzf;
        this.zza = zzfVar2;
        this.zzf = null;
        zze zzeVar = this.zzd;
        if (zzeVar != null) {
            zzeVar.zzc(this, getProgress(), false);
        }
        postInvalidate();
    }

    public CastSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CastSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzc = new ArrayList();
        setAccessibilityDelegate(new zzg(this, null));
        Paint paint = new Paint(1);
        this.zzl = paint;
        paint.setStyle(Paint.Style.FILL);
        this.zzg = context.getResources().getDimension(C3616R.dimen.cast_seek_bar_minimum_width);
        this.zzh = context.getResources().getDimension(C3616R.dimen.cast_seek_bar_minimum_height);
        this.zzi = context.getResources().getDimension(C3616R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.zzj = context.getResources().getDimension(C3616R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.zzk = context.getResources().getDimension(C3616R.dimen.cast_seek_bar_ad_break_minimum_width);
        zzf zzfVar = new zzf();
        this.zza = zzfVar;
        zzfVar.zzb = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C3616R.styleable.CastExpandedController, C3616R.attr.castExpandedControllerStyle, C3616R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(C3616R.styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(C3616R.styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(C3616R.styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(C3616R.styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.zzm = context.getResources().getColor(resourceId);
        this.zzn = context.getResources().getColor(resourceId2);
        this.zzo = context.getResources().getColor(resourceId3);
        this.zzp = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }
}
