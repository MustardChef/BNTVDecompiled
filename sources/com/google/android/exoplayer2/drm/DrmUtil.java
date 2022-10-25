package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class DrmUtil {
    public static final int ERROR_SOURCE_EXO_MEDIA_DRM = 1;
    public static final int ERROR_SOURCE_LICENSE_ACQUISITION = 2;
    public static final int ERROR_SOURCE_PROVISIONING = 3;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ErrorSource {
    }

    public static int getErrorCodeForMediaDrmException(Exception exc, int i) {
        if (Util.SDK_INT >= 21 && Api21.isMediaDrmStateException(exc)) {
            return Api21.mediaDrmStateExceptionToErrorCode(exc);
        }
        if (Util.SDK_INT < 23 || !Api23.isMediaDrmResetException(exc)) {
            if (Util.SDK_INT < 18 || !Api18.isNotProvisionedException(exc)) {
                if (Util.SDK_INT < 18 || !Api18.isDeniedByServerException(exc)) {
                    if (exc instanceof UnsupportedDrmException) {
                        return PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED;
                    }
                    if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
                        return PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR;
                    }
                    if (exc instanceof KeysExpiredException) {
                        return PlaybackException.ERROR_CODE_DRM_LICENSE_EXPIRED;
                    }
                    if (i == 1) {
                        return PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR;
                    }
                    if (i == 2) {
                        return PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED;
                    }
                    if (i == 3) {
                        return PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED;
                    }
                    throw new IllegalArgumentException();
                }
                return PlaybackException.ERROR_CODE_DRM_DEVICE_REVOKED;
            }
            return PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED;
        }
        return PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Api18 {
        private Api18() {
        }

        public static boolean isNotProvisionedException(Throwable th) {
            return th instanceof NotProvisionedException;
        }

        public static boolean isDeniedByServerException(Throwable th) {
            return th instanceof DeniedByServerException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Api21 {
        private Api21() {
        }

        public static boolean isMediaDrmStateException(Throwable th) {
            return th instanceof MediaDrm.MediaDrmStateException;
        }

        public static int mediaDrmStateExceptionToErrorCode(Throwable th) {
            return Util.getErrorCodeForMediaDrmErrorCode(Util.getErrorCodeFromPlatformDiagnosticsInfo(((MediaDrm.MediaDrmStateException) th).getDiagnosticInfo()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class Api23 {
        private Api23() {
        }

        public static boolean isMediaDrmResetException(Throwable th) {
            return th instanceof MediaDrmResetException;
        }
    }

    private DrmUtil() {
    }
}
