package com.google.android.gms.cast.framework.media.uicontroller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.TracksChooserDialogFragment;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzam;
import com.google.android.gms.internal.cast.zzan;
import com.google.android.gms.internal.cast.zzao;
import com.google.android.gms.internal.cast.zzaq;
import com.google.android.gms.internal.cast.zzas;
import com.google.android.gms.internal.cast.zzat;
import com.google.android.gms.internal.cast.zzau;
import com.google.android.gms.internal.cast.zzav;
import com.google.android.gms.internal.cast.zzaw;
import com.google.android.gms.internal.cast.zzay;
import com.google.android.gms.internal.cast.zzaz;
import com.google.android.gms.internal.cast.zzba;
import com.google.android.gms.internal.cast.zzbb;
import com.google.android.gms.internal.cast.zzbd;
import com.google.android.gms.internal.cast.zzbe;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzbg;
import com.google.android.gms.internal.cast.zzbh;
import com.google.android.gms.internal.cast.zzbi;
import com.google.android.gms.internal.cast.zzbj;
import com.google.android.gms.internal.cast.zzbk;
import com.google.android.gms.internal.cast.zzbl;
import com.google.android.gms.internal.cast.zzjt;
import com.google.android.gms.internal.cast.zzl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class UIMediaController implements RemoteMediaClient.Listener, SessionManagerListener<CastSession> {
    private static final Logger zzb = new Logger("UIMediaController");
    private final Activity zzc;
    private final SessionManager zzd;
    private RemoteMediaClient.Listener zzg;
    private RemoteMediaClient zzh;
    private final Map<View, List<UIController>> zze = new HashMap();
    private final Set<zzbj> zzf = new HashSet();
    zza zza = zza.zza();

    public UIMediaController(Activity activity) {
        this.zzc = activity;
        CastContext zza = CastContext.zza(activity);
        zzl.zzb(zzjt.UI_MEDIA_CONTROLLER);
        SessionManager sessionManager = zza != null ? zza.getSessionManager() : null;
        this.zzd = sessionManager;
        if (sessionManager != null) {
            sessionManager.addSessionManagerListener(this, CastSession.class);
            zzi(sessionManager.getCurrentCastSession());
        }
    }

    private final void zzf(int i) {
        Iterator<zzbj> it = this.zzf.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            it.next().zzb(true);
        }
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        long zzh = i + this.zza.zzh();
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(zzh);
        builder.setIsSeekToInfinite((remoteMediaClient.isLiveStream() && this.zza.zzd(zzh)) ? false : false);
        remoteMediaClient.seek(builder.build());
    }

    private final void zzg() {
        for (zzbj zzbjVar : this.zzf) {
            zzbjVar.zzb(false);
        }
    }

    private final void zzh(int i, boolean z) {
        if (z) {
            for (zzbj zzbjVar : this.zzf) {
                zzbjVar.zza(i + this.zza.zzh());
            }
        }
    }

    private final void zzi(Session session) {
        if (isActive() || session == null || !session.isConnected()) {
            return;
        }
        CastSession castSession = (CastSession) session;
        RemoteMediaClient remoteMediaClient = castSession.getRemoteMediaClient();
        this.zzh = remoteMediaClient;
        if (remoteMediaClient != null) {
            remoteMediaClient.addListener(this);
            Preconditions.checkNotNull(this.zza);
            this.zza.zza = castSession.getRemoteMediaClient();
            for (List<UIController> list : this.zze.values()) {
                for (UIController uIController : list) {
                    uIController.onSessionConnected(castSession);
                }
            }
            zzl();
        }
    }

    private final void zzj() {
        if (isActive()) {
            this.zza.zza = null;
            for (List<UIController> list : this.zze.values()) {
                for (UIController uIController : list) {
                    uIController.onSessionEnded();
                }
            }
            Preconditions.checkNotNull(this.zzh);
            this.zzh.removeListener(this);
            this.zzh = null;
        }
    }

    private final void zzk(View view, UIController uIController) {
        if (this.zzd == null) {
            return;
        }
        List<UIController> list = this.zze.get(view);
        if (list == null) {
            list = new ArrayList<>();
            this.zze.put(view, list);
        }
        list.add(uIController);
        if (isActive()) {
            uIController.onSessionConnected((CastSession) Preconditions.checkNotNull(this.zzd.getCurrentCastSession()));
            zzl();
        }
    }

    private final void zzl() {
        for (List<UIController> list : this.zze.values()) {
            for (UIController uIController : list) {
                uIController.onMediaStatusUpdated();
            }
        }
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView, int i, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzas(imageView, this.zzc, new ImageHints(i, 0, 0), i2, null));
    }

    @Deprecated
    public void bindImageViewToImageOfPreloadedItem(ImageView imageView, int i, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzaq(imageView, this.zzc, new ImageHints(i, 0, 0), i2));
    }

    public void bindImageViewToMuteToggle(ImageView imageView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        imageView.setOnClickListener(new zzb(this));
        zzk(imageView, new zzay(imageView, this.zzc));
    }

    public void bindImageViewToPlayPauseToggle(ImageView imageView, Drawable drawable, Drawable drawable2, Drawable drawable3, View view, boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl.zzb(zzjt.PAUSE_CONTROLLER);
        imageView.setOnClickListener(new zzc(this));
        zzk(imageView, new zzaz(imageView, this.zzc, drawable, drawable2, drawable3, view, z));
    }

    public void bindProgressBar(ProgressBar progressBar) {
        bindProgressBar(progressBar, 1000L);
    }

    public void bindSeekBar(SeekBar seekBar) {
        bindSeekBar(seekBar, 1000L);
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfCurrentItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView, String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfPreloadedItem(textView, Collections.singletonList(str));
    }

    public void bindTextViewToSmartSubtitle(TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbg(textView));
    }

    public void bindTextViewToStreamDuration(TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbh(textView, this.zzc.getString(C3616R.string.cast_invalid_stream_duration_text), null));
    }

    public void bindTextViewToStreamPosition(TextView textView, boolean z) {
        bindTextViewToStreamPosition(textView, z, 1000L);
    }

    public void bindViewToClosedCaption(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzk(this));
        zzk(view, new zzan(view, this.zzc));
    }

    public void bindViewToForward(View view, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzf(this, j));
        zzk(view, new zzao(view, this.zza));
    }

    public void bindViewToLaunchExpandedController(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzj(this));
        zzk(view, new zzat(view));
    }

    public void bindViewToLoadingIndicator(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, new zzau(view));
    }

    public void bindViewToRewind(View view, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzg(this, j));
        zzk(view, new zzbb(view, this.zza));
    }

    public void bindViewToSkipNext(View view, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzd(this));
        zzk(view, new zzbe(view, i));
    }

    public void bindViewToSkipPrev(View view, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zze(this));
        zzk(view, new zzbf(view, i));
    }

    public void bindViewToUIController(View view, UIController uIController) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, uIController);
    }

    public void bindViewVisibilityToMediaSession(View view, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, new zzbl(view, i));
    }

    public void bindViewVisibilityToPreloadingEvent(View view, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(view, new zzbk(view, i));
    }

    public void dispose() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzj();
        this.zze.clear();
        SessionManager sessionManager = this.zzd;
        if (sessionManager != null) {
            sessionManager.removeSessionManagerListener(this, CastSession.class);
        }
        this.zzg = null;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    @EnsuresNonNullIf(expression = {"remoteMediaClient"}, result = true)
    public boolean isActive() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh != null;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onAdBreakStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onAdBreakStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClosedCaptionClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (this.zzc instanceof FragmentActivity)) {
            TracksChooserDialogFragment newInstance = TracksChooserDialogFragment.newInstance();
            FragmentActivity fragmentActivity = (FragmentActivity) this.zzc;
            FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
            Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("TRACKS_CHOOSER_DIALOG_TAG");
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            newInstance.show(beginTransaction, "TRACKS_CHOOSER_DIALOG_TAG");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onForwardClicked(View view, long j) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        if (remoteMediaClient.zzh()) {
            long approximateStreamPosition = remoteMediaClient.getApproximateStreamPosition();
            zza zzaVar = this.zza;
            remoteMediaClient.seek(Math.min(approximateStreamPosition + j, zzaVar.zzg() + zzaVar.zzh()));
            return;
        }
        remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLaunchExpandedControllerClicked(View view) {
        CastMediaOptions castMediaOptions = CastContext.getSharedInstance(this.zzc).getCastOptions().getCastMediaOptions();
        if (castMediaOptions == null || TextUtils.isEmpty(castMediaOptions.getExpandedControllerActivityClassName())) {
            return;
        }
        ComponentName componentName = new ComponentName(this.zzc.getApplicationContext(), castMediaOptions.getExpandedControllerActivityClassName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        this.zzc.startActivity(intent);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onMetadataUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onMetadataUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMuteToggleClicked(ImageView imageView) {
        CastSession currentCastSession = CastContext.getSharedInstance(this.zzc.getApplicationContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return;
        }
        try {
            currentCastSession.setMute(!currentCastSession.isMute());
        } catch (IOException | IllegalArgumentException e) {
            zzb.m367e("Unable to call CastSession.setMute(boolean).", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPlayPauseToggleClicked(ImageView imageView) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.togglePlayback();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onPreloadStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onPreloadStatusUpdated();
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onQueueStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onQueueStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRewindClicked(View view, long j) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        if (remoteMediaClient.zzh()) {
            long approximateStreamPosition = remoteMediaClient.getApproximateStreamPosition();
            zza zzaVar = this.zza;
            remoteMediaClient.seek(Math.max(approximateStreamPosition - j, zzaVar.zzf() + zzaVar.zzh()));
            return;
        }
        remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() - j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSeekBarProgressChanged(SeekBar seekBar, int i, boolean z) {
        zzh(i, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSeekBarStartTrackingTouch(SeekBar seekBar) {
        if (this.zze.containsKey(seekBar)) {
            for (UIController uIController : this.zze.get(seekBar)) {
                if (uIController instanceof zzbd) {
                    ((zzbd) uIController).zzb(false);
                }
            }
        }
        zzg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSeekBarStopTrackingTouch(SeekBar seekBar) {
        if (this.zze.containsKey(seekBar)) {
            for (UIController uIController : this.zze.get(seekBar)) {
                if (uIController instanceof zzbd) {
                    ((zzbd) uIController).zzb(true);
                }
            }
        }
        zzf(seekBar.getProgress());
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onSendingRemoteMediaRequest() {
        for (List<UIController> list : this.zze.values()) {
            for (UIController uIController : list) {
                uIController.onSendingRemoteMediaRequest();
            }
        }
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onSendingRemoteMediaRequest();
        }
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnded(CastSession castSession, int i) {
        zzj();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionEnding(CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumeFailed(CastSession castSession, int i) {
        zzj();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResumed(CastSession castSession, boolean z) {
        zzi(castSession);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionResuming(CastSession castSession, String str) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStartFailed(CastSession castSession, int i) {
        zzj();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarted(CastSession castSession, String str) {
        zzi(castSession);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionStarting(CastSession castSession) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public void onSessionSuspended(CastSession castSession, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSkipNextClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.queueNext(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSkipPrevClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession()) {
            return;
        }
        remoteMediaClient.queuePrev(null);
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener
    public void onStatusUpdated() {
        zzl();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onStatusUpdated();
        }
    }

    public void setPostRemoteMediaClientListener(RemoteMediaClient.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzg = listener;
    }

    public final void zza(zzbj zzbjVar) {
        this.zzf.add(zzbjVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(CastSeekBar castSeekBar) {
        zzf(castSeekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzc(CastSeekBar castSeekBar) {
        zzg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzd(CastSeekBar castSeekBar, int i, boolean z) {
        zzh(i, z);
    }

    public final zza zze() {
        return this.zza;
    }

    public void bindProgressBar(ProgressBar progressBar, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(progressBar, new zzba(progressBar, j));
    }

    public void bindSeekBar(SeekBar seekBar, long j) {
        zzl.zzb(zzjt.SEEK_CONTROLLER);
        Preconditions.checkMainThread("Must be called from the main thread.");
        seekBar.setOnSeekBarChangeListener(new zzi(this, seekBar));
        zzk(seekBar, new zzbd(seekBar, j, this.zza));
    }

    public void bindTextViewToStreamPosition(TextView textView, boolean z, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzbi zzbiVar = new zzbi(textView, j, this.zzc.getString(C3616R.string.cast_invalid_stream_position_text));
        if (z) {
            this.zzf.add(zzbiVar);
        }
        zzk(textView, zzbiVar);
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView, int i, View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzas(imageView, this.zzc, new ImageHints(i, 0, 0), 0, view));
    }

    public void bindImageViewToImageOfPreloadedItem(ImageView imageView, ImageHints imageHints, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzaq(imageView, this.zzc, imageHints, i));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzaw(textView, list));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView, List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzav(textView, list));
    }

    public void bindTextViewToStreamDuration(TextView textView, View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(textView, new zzbh(textView, this.zzc.getString(C3616R.string.cast_invalid_stream_duration_text), view));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, ImageHints imageHints, int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzas(imageView, this.zzc, imageHints, i, null));
    }

    public void bindSeekBar(CastSeekBar castSeekBar) {
        bindSeekBar(castSeekBar, 1000L);
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, ImageHints imageHints, View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzk(imageView, new zzas(imageView, this.zzc, imageHints, 0, view));
    }

    public void bindSeekBar(CastSeekBar castSeekBar, long j) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl.zzb(zzjt.SEEK_CONTROLLER);
        castSeekBar.zzd = new zzh(this);
        zzk(castSeekBar, new zzam(castSeekBar, j, this.zza));
    }
}
