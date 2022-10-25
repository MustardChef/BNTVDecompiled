package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";

    private static RemoteMediaClient zza(CastSession castSession) {
        if (castSession == null || !castSession.isConnected()) {
            return null;
        }
        return castSession.getRemoteMediaClient();
    }

    private static final void zzb(CastSession castSession, long j) {
        RemoteMediaClient zza;
        if (j == 0 || (zza = zza(castSession)) == null || zza.isLiveStream() || zza.isPlayingAd()) {
            return;
        }
        zza.seek(zza.getApproximateStreamPosition() + j);
    }

    private static final void zzc(CastSession castSession) {
        RemoteMediaClient zza = zza(castSession);
        if (zza == null) {
            return;
        }
        zza.togglePlayback();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SessionManager sessionManager;
        Session currentSession;
        char c;
        String action = intent.getAction();
        if (action == null || (currentSession = (sessionManager = CastContext.getSharedInstance(context).getSessionManager()).getCurrentSession()) == null) {
            return;
        }
        switch (action.hashCode()) {
            case -1699820260:
                if (action.equals(ACTION_REWIND)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -945151566:
                if (action.equals(ACTION_SKIP_NEXT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -945080078:
                if (action.equals(ACTION_SKIP_PREV)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -668151673:
                if (action.equals(ACTION_STOP_CASTING)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -124479363:
                if (action.equals(ACTION_DISCONNECT)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 235550565:
                if (action.equals(ACTION_TOGGLE_PLAYBACK)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1362116196:
                if (action.equals(ACTION_FORWARD)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1997055314:
                if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                onReceiveActionTogglePlayback(currentSession);
                return;
            case 1:
                onReceiveActionSkipNext(currentSession);
                return;
            case 2:
                onReceiveActionSkipPrev(currentSession);
                return;
            case 3:
                onReceiveActionForward(currentSession, intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0L));
                return;
            case 4:
                onReceiveActionRewind(currentSession, intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0L));
                return;
            case 5:
                sessionManager.endCurrentSession(true);
                return;
            case 6:
                sessionManager.endCurrentSession(false);
                return;
            case 7:
                onReceiveActionMediaButton(currentSession, intent);
                return;
            default:
                onReceiveOtherAction(context, action, intent);
                return;
        }
    }

    protected void onReceiveActionForward(Session session, long j) {
        if (session instanceof CastSession) {
            zzb((CastSession) session, j);
        }
    }

    protected void onReceiveActionMediaButton(Session session, Intent intent) {
        KeyEvent keyEvent;
        if ((session instanceof CastSession) && intent.hasExtra("android.intent.extra.KEY_EVENT") && (keyEvent = (KeyEvent) ((Bundle) Preconditions.checkNotNull(intent.getExtras())).get("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
            zzc((CastSession) session);
        }
    }

    protected void onReceiveActionRewind(Session session, long j) {
        if (session instanceof CastSession) {
            zzb((CastSession) session, -j);
        }
    }

    protected void onReceiveActionSkipNext(Session session) {
        RemoteMediaClient zza;
        if (!(session instanceof CastSession) || (zza = zza((CastSession) session)) == null || zza.isPlayingAd()) {
            return;
        }
        zza.queueNext(null);
    }

    protected void onReceiveActionSkipPrev(Session session) {
        RemoteMediaClient zza;
        if (!(session instanceof CastSession) || (zza = zza((CastSession) session)) == null || zza.isPlayingAd()) {
            return;
        }
        zza.queuePrev(null);
    }

    protected void onReceiveActionTogglePlayback(Session session) {
        if (session instanceof CastSession) {
            zzc((CastSession) session);
        }
    }

    protected void onReceiveOtherAction(Context context, String str, Intent intent) {
    }

    @Deprecated
    protected void onReceiveOtherAction(String str, Intent intent) {
        onReceiveOtherAction(null, str, intent);
    }
}
