package androidx.media;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: classes.dex */
public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    private static final String TAG = "AudioManCompat";

    public static int requestAudioFocus(AudioManager audioManager, AudioFocusRequestCompat focusRequest) {
        if (audioManager != null) {
            if (focusRequest == null) {
                throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.requestAudioFocus(audioManager, focusRequest.getAudioFocusRequest());
            }
            return audioManager.requestAudioFocus(focusRequest.getOnAudioFocusChangeListener(), focusRequest.getAudioAttributesCompat().getLegacyStreamType(), focusRequest.getFocusGain());
        }
        throw new IllegalArgumentException("AudioManager must not be null");
    }

    public static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequestCompat focusRequest) {
        if (audioManager != null) {
            if (focusRequest == null) {
                throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                return Api26Impl.abandonAudioFocusRequest(audioManager, focusRequest.getAudioFocusRequest());
            }
            return audioManager.abandonAudioFocus(focusRequest.getOnAudioFocusChangeListener());
        }
        throw new IllegalArgumentException("AudioManager must not be null");
    }

    public static int getStreamMaxVolume(AudioManager audioManager, int streamType) {
        return audioManager.getStreamMaxVolume(streamType);
    }

    public static int getStreamMinVolume(AudioManager audioManager, int streamType) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getStreamMinVolume(audioManager, streamType);
        }
        return 0;
    }

    private AudioManagerCompat() {
    }

    /* loaded from: classes.dex */
    private static class Api26Impl {
        private Api26Impl() {
        }

        static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequest focusRequest) {
            return audioManager.abandonAudioFocusRequest(focusRequest);
        }

        static int requestAudioFocus(AudioManager audioManager, AudioFocusRequest focusRequest) {
            return audioManager.requestAudioFocus(focusRequest);
        }
    }

    /* loaded from: classes.dex */
    private static class Api28Impl {
        private Api28Impl() {
        }

        static int getStreamMinVolume(AudioManager audioManager, int streamType) {
            return audioManager.getStreamMinVolume(streamType);
        }
    }
}
