package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1304q;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.utils.C1728i;
import com.applovin.impl.sdk.utils.Utils;

/* loaded from: classes.dex */
public class FullscreenAdService extends Service {
    public static final String DATA_KEY_AD_SOURCE = "ad_source";
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    /* renamed from: com.applovin.impl.adview.activity.FullscreenAdService$a */
    /* loaded from: classes.dex */
    private static class HandlerC1159a extends Handler {
        private HandlerC1159a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                C1304q c1304q = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (c1304q == null) {
                    if (!Utils.getBooleanForProbability(1)) {
                        super.handleMessage(message);
                        return;
                    }
                    throw new RuntimeException("parentWrapper is null for " + message.what);
                }
                AbstractC1537g m7908b = c1304q.m7908b();
                if (message.what == EnumC1160b.AD.m8287a()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, m7908b.getRawFullResponse());
                    bundle.putInt("ad_source", m7908b.getSource().m7225a());
                    Message obtain = Message.obtain((Handler) null, EnumC1160b.AD.m8287a());
                    obtain.setData(bundle);
                    try {
                        message.replyTo.send(obtain);
                    } catch (RemoteException e) {
                        C1710r.m6316c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e);
                    }
                } else if (message.what == EnumC1160b.AD_DISPLAYED.m8287a()) {
                    C1728i.m6228a(c1304q.m7905d(), m7908b);
                } else if (message.what == EnumC1160b.AD_CLICKED.m8287a()) {
                    C1728i.m6229a(c1304q.m7904e(), m7908b);
                } else if (message.what == EnumC1160b.AD_VIDEO_STARTED.m8287a()) {
                    C1728i.m6224a(c1304q.m7906c(), m7908b);
                } else if (message.what == EnumC1160b.AD_VIDEO_ENDED.m8287a()) {
                    Bundle data = message.getData();
                    C1728i.m6223a(c1304q.m7906c(), m7908b, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                } else if (message.what == EnumC1160b.AD_HIDDEN.m8287a()) {
                    C1728i.m6216b(c1304q.m7905d(), m7908b);
                } else {
                    super.handleMessage(message);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.FullscreenAdService$b */
    /* loaded from: classes.dex */
    public enum EnumC1160b {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);
        

        /* renamed from: g */
        private final int f341g;

        EnumC1160b(int i) {
            this.f341g = i;
        }

        /* renamed from: a */
        public int m8287a() {
            return this.f341g;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Messenger(new HandlerC1159a()).getBinder();
    }
}
