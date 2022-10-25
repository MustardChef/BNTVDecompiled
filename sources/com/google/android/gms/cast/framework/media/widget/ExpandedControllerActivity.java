package com.google.android.gms.cast.framework.media.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.C0067R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzq;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzbm;
import com.google.android.gms.internal.cast.zzbn;
import com.google.android.gms.internal.cast.zzbo;
import com.google.android.gms.internal.cast.zzbp;
import com.google.android.gms.internal.cast.zzjt;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public abstract class ExpandedControllerActivity extends AppCompatActivity implements ControlButtonsContainer {
    private View zzB;
    private View zzC;
    private ImageView zzD;
    private TextView zzE;
    private TextView zzF;
    private TextView zzG;
    private TextView zzH;
    private com.google.android.gms.cast.framework.media.internal.zzb zzI;
    private UIMediaController zzJ;
    private SessionManager zzK;
    private boolean zzL;
    private boolean zzM;
    private Timer zzN;
    private String zzO;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private TextView zzu;
    private SeekBar zzv;
    private CastSeekBar zzw;
    private ImageView zzx;
    private ImageView zzy;
    private int[] zzz;
    private final SessionManagerListener<CastSession> zza = new zzm(this, null);
    private final RemoteMediaClient.Listener zzb = new zzl(this, null);
    private ImageView[] zzA = new ImageView[4];

    private final void zzl(View view, int i, int i2, UIMediaController uIMediaController) {
        ImageView imageView = (ImageView) view.findViewById(i);
        if (i2 == C3616R.C3619id.cast_button_type_empty) {
            imageView.setVisibility(4);
        } else if (i2 == C3616R.C3619id.cast_button_type_play_pause_toggle) {
            imageView.setBackgroundResource(this.zzc);
            Drawable zzc = zzn.zzc(this, this.zzq, this.zze);
            Drawable zzc2 = zzn.zzc(this, this.zzq, this.zzd);
            Drawable zzc3 = zzn.zzc(this, this.zzq, this.zzf);
            imageView.setImageDrawable(zzc2);
            uIMediaController.bindImageViewToPlayPauseToggle(imageView, zzc2, zzc, zzc3, null, false);
        } else if (i2 == C3616R.C3619id.cast_button_type_skip_previous) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzn.zzc(this, this.zzq, this.zzg));
            imageView.setContentDescription(getResources().getString(C3616R.string.cast_skip_prev));
            uIMediaController.bindViewToSkipPrev(imageView, 0);
        } else if (i2 == C3616R.C3619id.cast_button_type_skip_next) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzn.zzc(this, this.zzq, this.zzh));
            imageView.setContentDescription(getResources().getString(C3616R.string.cast_skip_next));
            uIMediaController.bindViewToSkipNext(imageView, 0);
        } else if (i2 == C3616R.C3619id.cast_button_type_rewind_30_seconds) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzn.zzc(this, this.zzq, this.zzi));
            imageView.setContentDescription(getResources().getString(C3616R.string.cast_rewind_30));
            uIMediaController.bindViewToRewind(imageView, 30000L);
        } else if (i2 == C3616R.C3619id.cast_button_type_forward_30_seconds) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzn.zzc(this, this.zzq, this.zzj));
            imageView.setContentDescription(getResources().getString(C3616R.string.cast_forward_30));
            uIMediaController.bindViewToForward(imageView, 30000L);
        } else if (i2 == C3616R.C3619id.cast_button_type_mute_toggle) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzn.zzc(this, this.zzq, this.zzk));
            uIMediaController.bindImageViewToMuteToggle(imageView);
        } else if (i2 == C3616R.C3619id.cast_button_type_closed_caption) {
            imageView.setBackgroundResource(this.zzc);
            imageView.setImageDrawable(zzn.zzc(this, this.zzq, this.zzl));
            uIMediaController.bindViewToClosedCaption(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RemoteMediaClient zzm() {
        CastSession currentCastSession = this.zzK.getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return null;
        }
        return currentCastSession.getRemoteMediaClient();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        ActionBar supportActionBar;
        RemoteMediaClient zzm = zzm();
        if (zzm == null || !zzm.hasMediaSession() || (mediaInfo = zzm.getMediaInfo()) == null || (metadata = mediaInfo.getMetadata()) == null || (supportActionBar = getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.setTitle(metadata.getString(MediaMetadata.KEY_TITLE));
        supportActionBar.setSubtitle(zzq.zza(metadata));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzo() {
        CastDevice castDevice;
        CastSession currentCastSession = this.zzK.getCurrentCastSession();
        if (currentCastSession != null && (castDevice = currentCastSession.getCastDevice()) != null) {
            String friendlyName = castDevice.getFriendlyName();
            if (!TextUtils.isEmpty(friendlyName)) {
                this.zzu.setText(getResources().getString(C3616R.string.cast_casting_to_device, friendlyName));
                return;
            }
        }
        this.zzu.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzp() {
        MediaStatus mediaStatus;
        String str;
        Drawable drawable;
        Bitmap bitmap;
        Bitmap zza;
        RemoteMediaClient zzm = zzm();
        if (zzm == null || (mediaStatus = zzm.getMediaStatus()) == null) {
            return;
        }
        String str2 = null;
        if (mediaStatus.isPlayingAd()) {
            if (PlatformVersion.isAtLeastJellyBeanMR1() && this.zzy.getVisibility() == 8 && (drawable = this.zzx.getDrawable()) != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && (zza = zzn.zza(this, bitmap, 0.25f, 7.5f)) != null) {
                this.zzy.setImageBitmap(zza);
                this.zzy.setVisibility(0);
            }
            AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
            if (currentAdBreakClip != null) {
                String title = currentAdBreakClip.getTitle();
                str2 = currentAdBreakClip.getImageUrl();
                str = title;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                zzr(str2);
            } else if (!TextUtils.isEmpty(this.zzO)) {
                zzr(this.zzO);
            } else {
                this.zzE.setVisibility(0);
                this.zzC.setVisibility(0);
                this.zzD.setVisibility(8);
            }
            TextView textView = this.zzF;
            if (TextUtils.isEmpty(str)) {
                str = getResources().getString(C3616R.string.cast_ad_label);
            }
            textView.setText(str);
            if (PlatformVersion.isAtLeastM()) {
                this.zzF.setTextAppearance(this.zzr);
            } else {
                this.zzF.setTextAppearance(this, this.zzr);
            }
            this.zzB.setVisibility(0);
            zzq(zzm);
            return;
        }
        this.zzH.setVisibility(8);
        this.zzG.setVisibility(8);
        this.zzB.setVisibility(8);
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            this.zzy.setVisibility(8);
            this.zzy.setImageBitmap(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzq(RemoteMediaClient remoteMediaClient) {
        MediaStatus mediaStatus;
        if (this.zzL || (mediaStatus = remoteMediaClient.getMediaStatus()) == null || remoteMediaClient.isBuffering()) {
            return;
        }
        this.zzG.setVisibility(8);
        this.zzH.setVisibility(8);
        AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
        if (currentAdBreakClip == null || currentAdBreakClip.getWhenSkippableInMs() == -1) {
            return;
        }
        if (!this.zzM) {
            zzk zzkVar = new zzk(this, remoteMediaClient);
            Timer timer = new Timer();
            this.zzN = timer;
            timer.scheduleAtFixedRate(zzkVar, 0L, 500L);
            this.zzM = true;
        }
        float whenSkippableInMs = (float) (currentAdBreakClip.getWhenSkippableInMs() - remoteMediaClient.getApproximateAdBreakClipPositionMs());
        if (whenSkippableInMs <= 0.0f) {
            if (this.zzM) {
                this.zzN.cancel();
                this.zzM = false;
            }
            this.zzG.setVisibility(0);
            this.zzG.setClickable(true);
            return;
        }
        this.zzH.setVisibility(0);
        this.zzH.setText(getResources().getString(C3616R.string.cast_expanded_controller_skip_ad_text, Integer.valueOf((int) Math.ceil(whenSkippableInMs / 1000.0f))));
        this.zzG.setClickable(false);
    }

    private final void zzr(String str) {
        this.zzI.zzb(Uri.parse(str));
        this.zzC.setVisibility(8);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final ImageView getButtonImageViewAt(int i) throws IndexOutOfBoundsException {
        return this.zzA[i];
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonSlotCount() {
        return 4;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public final int getButtonTypeAt(int i) throws IndexOutOfBoundsException {
        return this.zzz[i];
    }

    @Deprecated
    public SeekBar getSeekBar() {
        return this.zzv;
    }

    public TextView getStatusTextView() {
        return this.zzu;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.ControlButtonsContainer
    public UIMediaController getUIMediaController() {
        return this.zzJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SessionManager sessionManager = CastContext.getSharedInstance(this).getSessionManager();
        this.zzK = sessionManager;
        if (sessionManager.getCurrentCastSession() == null) {
            finish();
        }
        UIMediaController uIMediaController = new UIMediaController(this);
        this.zzJ = uIMediaController;
        uIMediaController.setPostRemoteMediaClientListener(this.zzb);
        setContentView(C3616R.C3620layout.cast_expanded_controller_activity);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{C0067R.attr.selectableItemBackgroundBorderless});
        this.zzc = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = obtainStyledAttributes(null, C3616R.styleable.CastExpandedController, C3616R.attr.castExpandedControllerStyle, C3616R.style.CastExpandedController);
        this.zzq = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castButtonColor, 0);
        this.zzd = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castPlayButtonDrawable, 0);
        this.zze = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castPauseButtonDrawable, 0);
        this.zzf = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castStopButtonDrawable, 0);
        this.zzg = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castSkipPreviousButtonDrawable, 0);
        this.zzh = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castSkipNextButtonDrawable, 0);
        this.zzi = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castRewind30ButtonDrawable, 0);
        this.zzj = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castForward30ButtonDrawable, 0);
        this.zzk = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castMuteToggleButtonDrawable, 0);
        this.zzl = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castClosedCaptionsButtonDrawable, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castControlButtons, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            Preconditions.checkArgument(obtainTypedArray.length() == 4);
            this.zzz = new int[obtainTypedArray.length()];
            for (int i = 0; i < obtainTypedArray.length(); i++) {
                this.zzz[i] = obtainTypedArray.getResourceId(i, 0);
            }
            obtainTypedArray.recycle();
        } else {
            this.zzz = new int[]{C3616R.C3619id.cast_button_type_empty, C3616R.C3619id.cast_button_type_empty, C3616R.C3619id.cast_button_type_empty, C3616R.C3619id.cast_button_type_empty};
        }
        this.zzp = obtainStyledAttributes2.getColor(C3616R.styleable.f9706xcb1f8bb1, 0);
        this.zzm = getResources().getColor(obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castAdLabelColor, 0));
        this.zzn = getResources().getColor(obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castAdInProgressTextColor, 0));
        this.zzo = getResources().getColor(obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castAdLabelTextColor, 0));
        this.zzr = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castAdLabelTextAppearance, 0);
        this.zzs = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castAdInProgressLabelTextAppearance, 0);
        this.zzt = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castAdInProgressText, 0);
        int resourceId2 = obtainStyledAttributes2.getResourceId(C3616R.styleable.CastExpandedController_castDefaultAdPosterUrl, 0);
        if (resourceId2 != 0) {
            this.zzO = getApplicationContext().getResources().getString(resourceId2);
        }
        obtainStyledAttributes2.recycle();
        View findViewById = findViewById(C3616R.C3619id.expanded_controller_layout);
        UIMediaController uIMediaController2 = this.zzJ;
        this.zzx = (ImageView) findViewById.findViewById(C3616R.C3619id.background_image_view);
        this.zzy = (ImageView) findViewById.findViewById(C3616R.C3619id.blurred_background_image_view);
        View findViewById2 = findViewById.findViewById(C3616R.C3619id.background_place_holder_image_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        uIMediaController2.bindImageViewToImageOfCurrentItem(this.zzx, new ImageHints(4, displayMetrics.widthPixels, displayMetrics.heightPixels), findViewById2);
        this.zzu = (TextView) findViewById.findViewById(C3616R.C3619id.status_text);
        ProgressBar progressBar = (ProgressBar) findViewById.findViewById(C3616R.C3619id.loading_indicator);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        int i2 = this.zzp;
        if (i2 != 0) {
            indeterminateDrawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController2.bindViewToLoadingIndicator(progressBar);
        TextView textView = (TextView) findViewById.findViewById(C3616R.C3619id.start_text);
        TextView textView2 = (TextView) findViewById.findViewById(C3616R.C3619id.end_text);
        this.zzv = (SeekBar) findViewById.findViewById(C3616R.C3619id.seek_bar);
        CastSeekBar castSeekBar = (CastSeekBar) findViewById.findViewById(C3616R.C3619id.cast_seek_bar);
        this.zzw = castSeekBar;
        uIMediaController2.bindSeekBar(castSeekBar, 1000L);
        uIMediaController2.bindViewToUIController(textView, new zzbo(textView, uIMediaController2.zze()));
        uIMediaController2.bindViewToUIController(textView2, new zzbm(textView2, uIMediaController2.zze()));
        View findViewById3 = findViewById.findViewById(C3616R.C3619id.live_indicators);
        UIMediaController uIMediaController3 = this.zzJ;
        uIMediaController3.bindViewToUIController(findViewById3, new zzbn(findViewById3, uIMediaController3.zze()));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById.findViewById(C3616R.C3619id.tooltip_container);
        zzbp zzbpVar = new zzbp(relativeLayout, this.zzw, this.zzJ.zze());
        this.zzJ.bindViewToUIController(relativeLayout, zzbpVar);
        this.zzJ.zza(zzbpVar);
        this.zzA[0] = (ImageView) findViewById.findViewById(C3616R.C3619id.button_0);
        this.zzA[1] = (ImageView) findViewById.findViewById(C3616R.C3619id.button_1);
        this.zzA[2] = (ImageView) findViewById.findViewById(C3616R.C3619id.button_2);
        this.zzA[3] = (ImageView) findViewById.findViewById(C3616R.C3619id.button_3);
        zzl(findViewById, C3616R.C3619id.button_0, this.zzz[0], uIMediaController2);
        zzl(findViewById, C3616R.C3619id.button_1, this.zzz[1], uIMediaController2);
        zzl(findViewById, C3616R.C3619id.button_play_pause_toggle, C3616R.C3619id.cast_button_type_play_pause_toggle, uIMediaController2);
        zzl(findViewById, C3616R.C3619id.button_2, this.zzz[2], uIMediaController2);
        zzl(findViewById, C3616R.C3619id.button_3, this.zzz[3], uIMediaController2);
        View findViewById4 = findViewById(C3616R.C3619id.ad_container);
        this.zzB = findViewById4;
        this.zzD = (ImageView) findViewById4.findViewById(C3616R.C3619id.ad_image_view);
        this.zzC = this.zzB.findViewById(C3616R.C3619id.ad_background_image_view);
        TextView textView3 = (TextView) this.zzB.findViewById(C3616R.C3619id.ad_label);
        this.zzF = textView3;
        textView3.setTextColor(this.zzo);
        this.zzF.setBackgroundColor(this.zzm);
        this.zzE = (TextView) this.zzB.findViewById(C3616R.C3619id.ad_in_progress_label);
        this.zzH = (TextView) findViewById(C3616R.C3619id.ad_skip_text);
        TextView textView4 = (TextView) findViewById(C3616R.C3619id.ad_skip_button);
        this.zzG = textView4;
        textView4.setOnClickListener(new zzi(this));
        setSupportActionBar((Toolbar) findViewById(C3616R.C3619id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator(C3616R.C3618drawable.quantum_ic_keyboard_arrow_down_white_36);
        }
        zzo();
        zzn();
        if (this.zzE != null && this.zzt != 0) {
            if (PlatformVersion.isAtLeastM()) {
                this.zzE.setTextAppearance(this.zzs);
            } else {
                this.zzE.setTextAppearance(getApplicationContext(), this.zzs);
            }
            this.zzE.setTextColor(this.zzn);
            this.zzE.setText(this.zzt);
        }
        com.google.android.gms.cast.framework.media.internal.zzb zzbVar = new com.google.android.gms.cast.framework.media.internal.zzb(getApplicationContext(), new ImageHints(-1, this.zzD.getWidth(), this.zzD.getHeight()));
        this.zzI = zzbVar;
        zzbVar.zza(new zzh(this));
        com.google.android.gms.internal.cast.zzl.zzb(zzjt.CAF_EXPANDED_CONTROLLER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.zzI.zzc();
        UIMediaController uIMediaController = this.zzJ;
        if (uIMediaController != null) {
            uIMediaController.setPostRemoteMediaClientListener(null);
            this.zzJ.dispose();
        }
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        CastContext.getSharedInstance(this).getSessionManager().removeSessionManagerListener(this.zza, CastSession.class);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        CastContext.getSharedInstance(this).getSessionManager().addSessionManagerListener(this.zza, CastSession.class);
        CastSession currentCastSession = CastContext.getSharedInstance(this).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || (!currentCastSession.isConnected() && !currentCastSession.isConnecting())) {
            finish();
        }
        RemoteMediaClient zzm = zzm();
        boolean z = true;
        if (zzm != null && zzm.hasMediaSession()) {
            z = false;
        }
        this.zzL = z;
        zzo();
        zzp();
        super.onResume();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() ^ 2;
            if (PlatformVersion.isAtLeastJellyBean()) {
                systemUiVisibility ^= 4;
            }
            if (PlatformVersion.isAtLeastKitKat()) {
                systemUiVisibility ^= 4096;
            }
            getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
            if (PlatformVersion.isAtLeastJellyBeanMR2()) {
                setImmersive(true);
            }
        }
    }
}
