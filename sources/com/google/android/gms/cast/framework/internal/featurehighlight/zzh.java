package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GestureDetectorCompat;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.internal.cast.zzcl;
import com.google.android.gms.internal.cast.zzcu;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzh extends ViewGroup {
    private final int[] zza;
    private final Rect zzb;
    private final Rect zzc;
    private final OuterHighlightDrawable zzd;
    private final InnerZoneDrawable zze;
    private View zzf;
    private Animator zzg;
    private final zzi zzh;
    private final GestureDetectorCompat zzi;
    private GestureDetectorCompat zzj;
    private zzg zzk;
    private boolean zzl;
    private HelpTextView zzm;

    public zzh(Context context) {
        super(context);
        this.zza = new int[2];
        this.zzb = new Rect();
        this.zzc = new Rect();
        setId(C3616R.C3619id.cast_featurehighlight_view);
        setWillNotDraw(false);
        InnerZoneDrawable innerZoneDrawable = new InnerZoneDrawable(context);
        this.zze = innerZoneDrawable;
        innerZoneDrawable.setCallback(this);
        OuterHighlightDrawable outerHighlightDrawable = new OuterHighlightDrawable(context);
        this.zzd = outerHighlightDrawable;
        outerHighlightDrawable.setCallback(this);
        this.zzh = new zzi(this);
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(context, new zza(this));
        this.zzi = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(false);
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Animator zzn(zzh zzhVar) {
        InnerZoneDrawable innerZoneDrawable = zzhVar.zze;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.0f, 1.1f).setDuration(500L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(innerZoneDrawable, "scale", 1.1f, 1.0f).setDuration(500L);
        ObjectAnimator duration3 = ObjectAnimator.ofPropertyValuesHolder(innerZoneDrawable, PropertyValuesHolder.ofFloat("pulseScale", 1.1f, 2.0f), PropertyValuesHolder.ofFloat("pulseAlpha", 1.0f, 0.0f)).setDuration(500L);
        animatorSet.play(duration);
        animatorSet.play(duration2).with(duration3).after(duration);
        animatorSet.setInterpolator(zzcu.zzc());
        animatorSet.setStartDelay(500L);
        zzcl.zzb(animatorSet, -1, null);
        return animatorSet;
    }

    private final void zzq(Animator animator) {
        Animator animator2 = this.zzg;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.zzg = animator;
        animator.start();
    }

    @Override // android.view.ViewGroup
    protected final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        canvas.save();
        this.zzd.draw(canvas);
        this.zze.draw(canvas);
        View view = this.zzf;
        if (view != null) {
            if (view.getParent() != null) {
                Bitmap createBitmap = Bitmap.createBitmap(this.zzf.getWidth(), this.zzf.getHeight(), Bitmap.Config.ARGB_8888);
                this.zzf.draw(new Canvas(createBitmap));
                int zza = this.zzd.zza();
                int red = Color.red(zza);
                int green = Color.green(zza);
                int blue = Color.blue(zza);
                for (int i = 0; i < createBitmap.getHeight(); i++) {
                    for (int i2 = 0; i2 < createBitmap.getWidth(); i2++) {
                        int pixel = createBitmap.getPixel(i2, i);
                        if (Color.alpha(pixel) != 0) {
                            createBitmap.setPixel(i2, i, Color.argb(Color.alpha(pixel), red, green, blue));
                        }
                    }
                }
                canvas.drawBitmap(createBitmap, this.zzb.left, this.zzb.top, (Paint) null);
            }
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Neither target view nor drawable was set");
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(resolveSize(View.MeasureSpec.getSize(i), i), resolveSize(View.MeasureSpec.getSize(i2), i2));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.zzl = this.zzb.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            actionMasked = 0;
        }
        if (this.zzl) {
            GestureDetectorCompat gestureDetectorCompat = this.zzj;
            if (gestureDetectorCompat != null) {
                gestureDetectorCompat.onTouchEvent(motionEvent);
                if (actionMasked == 1) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                }
            }
            if (this.zzf.getParent() != null) {
                this.zzf.onTouchEvent(motionEvent);
            }
        } else {
            this.zzi.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    protected final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.zzd || drawable == this.zze || drawable == null;
    }

    public final void zzb(Runnable runnable) {
        addOnLayoutChangeListener(new zzc(this, null));
    }

    public final void zzd(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", 0.0f).setDuration(200L);
        duration.setInterpolator(zzcu.zzb());
        float exactCenterX = this.zzb.exactCenterX();
        float zzd = this.zzd.zzd();
        float exactCenterY = this.zzb.exactCenterY();
        float zze = this.zzd.zze();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zzd, PropertyValuesHolder.ofFloat("scale", 0.0f), PropertyValuesHolder.ofFloat("translationX", 0.0f, exactCenterX - zzd), PropertyValuesHolder.ofFloat("translationY", 0.0f, exactCenterY - zze), PropertyValuesHolder.ofInt("alpha", 0));
        ofPropertyValuesHolder.setInterpolator(zzcu.zzb());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200L);
        Animator zzb = this.zze.zzb();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, zzb);
        animatorSet.addListener(new zzf(this, runnable));
        zzq(animatorSet);
    }

    public final void zze(Runnable runnable) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", 0.0f).setDuration(200L);
        duration.setInterpolator(zzcu.zzb());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zzd, PropertyValuesHolder.ofFloat("scale", 1.125f), PropertyValuesHolder.ofInt("alpha", 0));
        ofPropertyValuesHolder.setInterpolator(zzcu.zzb());
        Animator duration2 = ofPropertyValuesHolder.setDuration(200L);
        Animator zzb = this.zze.zzb();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, zzb);
        animatorSet.addListener(new zze(this, runnable));
        zzq(animatorSet);
    }

    public final void zzf(int i) {
        this.zzd.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View zzg() {
        return this.zzm.asView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final OuterHighlightDrawable zzh() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final InnerZoneDrawable zzi() {
        return this.zze;
    }

    @Override // android.view.ViewGroup
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.zzf;
        if (view == null) {
            throw new IllegalStateException("Target view must be set before layout");
        }
        if (view.getParent() != null) {
            int[] iArr = this.zza;
            View view2 = this.zzf;
            getLocationInWindow(iArr);
            int i5 = iArr[0];
            int i6 = iArr[1];
            view2.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i5;
            iArr[1] = iArr[1] - i6;
        }
        Rect rect = this.zzb;
        int[] iArr2 = this.zza;
        int i7 = iArr2[0];
        rect.set(i7, iArr2[1], this.zzf.getWidth() + i7, this.zza[1] + this.zzf.getHeight());
        this.zzc.set(i, i2, i3, i4);
        this.zzd.setBounds(this.zzc);
        this.zze.setBounds(this.zzc);
        this.zzh.zza(this.zzb, this.zzc);
    }

    public final void zzc() {
        if (this.zzf == null) {
            throw new IllegalStateException("Target view must be set before animation");
        }
        setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.zzm.asView(), "alpha", 0.0f, 1.0f).setDuration(350L);
        duration.setInterpolator(zzcu.zza());
        Animator zzg = this.zzd.zzg(this.zzb.exactCenterX() - this.zzd.zzd(), this.zzb.exactCenterY() - this.zzd.zze());
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.zze, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofInt("alpha", 0, 255));
        ofPropertyValuesHolder.setInterpolator(zzcu.zza());
        Animator duration2 = ofPropertyValuesHolder.setDuration(350L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, zzg, duration2);
        animatorSet.addListener(new zzd(this));
        zzq(animatorSet);
    }

    public final void zzp(HelpTextView helpTextView) {
        Objects.requireNonNull(helpTextView);
        this.zzm = helpTextView;
        addView(helpTextView.asView(), 0);
    }

    public final void zza(View view, View view2, boolean z, zzg zzgVar) {
        Objects.requireNonNull(view);
        this.zzf = view;
        this.zzk = zzgVar;
        GestureDetectorCompat gestureDetectorCompat = new GestureDetectorCompat(getContext(), new zzb(this, view, true, zzgVar));
        this.zzj = gestureDetectorCompat;
        gestureDetectorCompat.setIsLongpressEnabled(false);
        setVisibility(4);
    }
}
