package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.IntroductoryOverlay;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzac extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    private Activity zzb;
    private int zzc;
    private boolean zzd;
    private IntroductoryOverlay.OnOverlayDismissedListener zze;
    private final zzab zzf;

    public zzac(IntroductoryOverlay.Builder builder, AttributeSet attributeSet, int i) {
        super(builder.zza(), null, i);
        this.zzb = builder.zza();
        this.zza = builder.zze();
        this.zze = builder.zzc();
        TypedArray obtainStyledAttributes = this.zzb.getTheme().obtainStyledAttributes(null, C3616R.styleable.CastIntroOverlay, i, C3616R.style.CastIntroOverlay);
        if (builder.zzb() != null) {
            Rect rect = new Rect();
            builder.zzb().getGlobalVisibleRect(rect);
            zzab zzabVar = new zzab(null);
            this.zzf = zzabVar;
            zzabVar.zza = rect.centerX();
            zzabVar.zzb = rect.centerY();
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAlpha(0);
            paint.setXfermode(porterDuffXfermode);
            paint.setAntiAlias(true);
            zzabVar.zzc = paint;
            zzabVar.zzd = builder.zzh();
            if (zzabVar.zzd == 0.0f) {
                zzabVar.zzd = obtainStyledAttributes.getDimension(C3616R.styleable.CastIntroOverlay_castFocusRadius, 0.0f);
            }
        } else {
            this.zzf = null;
        }
        LayoutInflater.from(this.zzb).inflate(C3616R.C3620layout.cast_intro_overlay, this);
        int zzd = builder.zzd();
        this.zzc = zzd;
        if (zzd == 0) {
            this.zzc = obtainStyledAttributes.getColor(C3616R.styleable.CastIntroOverlay_castBackgroundColor, Color.argb(0, 0, 0, 0));
        }
        TextView textView = (TextView) findViewById(C3616R.C3619id.textTitle);
        if (!TextUtils.isEmpty(builder.zzf())) {
            textView.setText(builder.zzf());
            int resourceId = obtainStyledAttributes.getResourceId(C3616R.styleable.CastIntroOverlay_castTitleTextAppearance, 0);
            if (resourceId != 0) {
                textView.setTextAppearance(this.zzb, resourceId);
            }
        }
        String zzg = builder.zzg();
        zzg = TextUtils.isEmpty(zzg) ? obtainStyledAttributes.getString(C3616R.styleable.CastIntroOverlay_castButtonText) : zzg;
        int color = obtainStyledAttributes.getColor(C3616R.styleable.CastIntroOverlay_castButtonBackgroundColor, Color.argb(0, 0, 0, 0));
        Button button = (Button) findViewById(C3616R.C3619id.button);
        button.setText(zzg);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        int resourceId2 = obtainStyledAttributes.getResourceId(C3616R.styleable.CastIntroOverlay_castButtonTextAppearance, 0);
        if (resourceId2 != 0) {
            button.setTextAppearance(this.zzb, resourceId2);
        }
        button.setOnClickListener(new zzaa(this));
        obtainStyledAttributes.recycle();
        setFitsSystemWindows(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzac zzacVar) {
        com.google.android.gms.cast.framework.zzaq.zza(zzacVar.zzb);
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener = zzacVar.zze;
        if (onOverlayDismissedListener != null) {
            onOverlayDismissedListener.onOverlayDismissed();
            zzacVar.zze = null;
        }
        Activity activity = zzacVar.zzb;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(zzacVar);
            zzacVar.zzb = null;
        }
        zzacVar.zze = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        canvas2.drawColor(this.zzc);
        zzab zzabVar = this.zzf;
        if (zzabVar != null) {
            canvas2.drawCircle(zzabVar.zza, zzabVar.zzb, zzabVar.zzd, zzabVar.zzc);
        }
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        createBitmap.recycle();
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void remove() {
        Activity activity = this.zzb;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(this);
            this.zzb = null;
        }
        this.zze = null;
    }

    @Override // com.google.android.gms.cast.framework.IntroductoryOverlay
    public final void show() {
        Activity activity = this.zzb;
        if (activity == null || zzy.zza(activity)) {
            return;
        }
        if (!this.zza || !com.google.android.gms.cast.framework.zzaq.zzb(this.zzb)) {
            if (this.zzd) {
                return;
            }
            this.zzd = true;
            ((ViewGroup) this.zzb.getWindow().getDecorView()).addView(this);
            return;
        }
        this.zzb = null;
        this.zze = null;
    }
}
