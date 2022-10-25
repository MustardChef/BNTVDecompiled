package com.google.android.gms.cast.framework.media.internal;

import com.google.android.gms.cast.framework.C3616R;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class ResourceProvider {
    private static final Map<String, Integer> zza;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("smallIconDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_small_icon));
        hashMap.put("stopLiveStreamDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_stop_live_stream));
        hashMap.put("pauseDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_pause));
        hashMap.put("playDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_play));
        hashMap.put("skipNextDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_skip_next));
        hashMap.put("skipPrevDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_skip_prev));
        hashMap.put("forwardDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_forward));
        hashMap.put("forward10DrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_forward10));
        hashMap.put("forward30DrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_forward30));
        hashMap.put("rewindDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_rewind));
        hashMap.put("rewind10DrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_rewind10));
        hashMap.put("rewind30DrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_rewind30));
        hashMap.put("disconnectDrawableResId", Integer.valueOf(C3616R.C3618drawable.cast_ic_notification_disconnect));
        hashMap.put("notificationImageSizeDimenResId", Integer.valueOf(C3616R.dimen.cast_notification_image_size));
        hashMap.put("castingToDeviceStringResId", Integer.valueOf(C3616R.string.cast_casting_to_device));
        hashMap.put("stopLiveStreamStringResId", Integer.valueOf(C3616R.string.cast_stop_live_stream));
        hashMap.put("pauseStringResId", Integer.valueOf(C3616R.string.cast_pause));
        hashMap.put("playStringResId", Integer.valueOf(C3616R.string.cast_play));
        hashMap.put("skipNextStringResId", Integer.valueOf(C3616R.string.cast_skip_next));
        hashMap.put("skipPrevStringResId", Integer.valueOf(C3616R.string.cast_skip_prev));
        hashMap.put("forwardStringResId", Integer.valueOf(C3616R.string.cast_forward));
        hashMap.put("forward10StringResId", Integer.valueOf(C3616R.string.cast_forward_10));
        hashMap.put("forward30StringResId", Integer.valueOf(C3616R.string.cast_forward_30));
        hashMap.put("rewindStringResId", Integer.valueOf(C3616R.string.cast_rewind));
        hashMap.put("rewind10StringResId", Integer.valueOf(C3616R.string.cast_rewind_10));
        hashMap.put("rewind30StringResId", Integer.valueOf(C3616R.string.cast_rewind_30));
        hashMap.put("disconnectStringResId", Integer.valueOf(C3616R.string.cast_disconnect));
        zza = Collections.unmodifiableMap(hashMap);
    }

    public static Integer findResourceByName(String str) {
        if (str == null) {
            return null;
        }
        return zza.get(str);
    }
}
