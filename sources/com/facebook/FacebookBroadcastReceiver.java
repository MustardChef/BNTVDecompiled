package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;

/* loaded from: classes.dex */
public class FacebookBroadcastReceiver extends BroadcastReceiver {
    protected void onFailedAppCall(String str, String str2, Bundle bundle) {
    }

    protected void onSuccessfulAppCall(String str, String str2, Bundle bundle) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_CALL_ID);
        String stringExtra2 = intent.getStringExtra(NativeProtocol.EXTRA_PROTOCOL_ACTION);
        if (stringExtra == null || stringExtra2 == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (NativeProtocol.isErrorResult(intent)) {
            onFailedAppCall(stringExtra, stringExtra2, extras);
        } else {
            onSuccessfulAppCall(stringExtra, stringExtra2, extras);
        }
    }
}
