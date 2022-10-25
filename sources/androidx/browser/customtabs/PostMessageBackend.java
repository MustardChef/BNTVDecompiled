package androidx.browser.customtabs;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface PostMessageBackend {
    void onDisconnectChannel(Context appContext);

    boolean onNotifyMessageChannelReady(Bundle extras);

    boolean onPostMessage(String message, Bundle extras);
}
