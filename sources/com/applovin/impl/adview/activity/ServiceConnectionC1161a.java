package com.applovin.impl.adview.activity;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.p031e.C1626p;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.adview.activity.a */
/* loaded from: classes.dex */
public class ServiceConnectionC1161a implements ServiceConnection {

    /* renamed from: a */
    private final C1662k f342a;

    /* renamed from: b */
    private final C1710r f343b;

    /* renamed from: c */
    private final WeakReference<AppLovinFullscreenActivity> f344c;

    /* renamed from: d */
    private final AtomicBoolean f345d = new AtomicBoolean();

    /* renamed from: e */
    private Messenger f346e;

    /* renamed from: com.applovin.impl.adview.activity.a$a */
    /* loaded from: classes.dex */
    private class C1163a implements AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
        private C1163a() {
        }

        /* renamed from: a */
        private void m8279a(Bundle bundle, FullscreenAdService.EnumC1160b enumC1160b) {
            Message obtain = Message.obtain((Handler) null, enumC1160b.m8287a());
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                ServiceConnectionC1161a.this.f346e.send(obtain);
            } catch (RemoteException e) {
                C1710r c1710r = ServiceConnectionC1161a.this.f343b;
                c1710r.m6318b("InterActivityV2", "Failed to forward callback (" + enumC1160b.m8287a() + ")", e);
            }
        }

        /* renamed from: a */
        private void m8278a(FullscreenAdService.EnumC1160b enumC1160b) {
            m8279a(null, enumC1160b);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            m8278a(FullscreenAdService.EnumC1160b.AD_CLICKED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            m8278a(FullscreenAdService.EnumC1160b.AD_DISPLAYED);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            m8278a(FullscreenAdService.EnumC1160b.AD_HIDDEN);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            m8278a(FullscreenAdService.EnumC1160b.AD_VIDEO_STARTED);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
            Bundle bundle = new Bundle();
            bundle.putDouble("percent_viewed", d);
            bundle.putBoolean("fully_watched", z);
            m8279a(bundle, FullscreenAdService.EnumC1160b.AD_VIDEO_ENDED);
        }
    }

    /* renamed from: com.applovin.impl.adview.activity.a$b */
    /* loaded from: classes.dex */
    private static class HandlerC1164b extends Handler {

        /* renamed from: a */
        private final WeakReference<ServiceConnectionC1161a> f349a;

        private HandlerC1164b(ServiceConnectionC1161a serviceConnectionC1161a) {
            this.f349a = new WeakReference<>(serviceConnectionC1161a);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ServiceConnectionC1161a serviceConnectionC1161a;
            if (message.what != FullscreenAdService.EnumC1160b.AD.m8287a() || (serviceConnectionC1161a = this.f349a.get()) == null) {
                super.handleMessage(message);
            } else {
                serviceConnectionC1161a.m8283a(EnumC1528b.m7224a(message.getData().getInt("ad_source")), message.getData().getString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE));
            }
        }
    }

    public ServiceConnectionC1161a(AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k) {
        this.f342a = c1662k;
        this.f343b = c1662k.m6588z();
        this.f344c = new WeakReference<>(appLovinFullscreenActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8286a() {
        AppLovinFullscreenActivity appLovinFullscreenActivity = this.f344c.get();
        if (appLovinFullscreenActivity == null) {
            this.f343b.m6314e("InterActivityV2", "Unable to dismiss parent Activity");
            return;
        }
        this.f343b.m6319b("InterActivityV2", "Dismissing...");
        appLovinFullscreenActivity.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8283a(EnumC1528b enumC1528b, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f342a.m6670Q().m6794a(new C1626p(jSONObject, C1531d.m7215a(JsonUtils.getString(jSONObject, "zone_id", "")), enumC1528b, new AppLovinAdLoadListener() { // from class: com.applovin.impl.adview.activity.a.1
                @Override // com.applovin.sdk.AppLovinAdLoadListener
                public void adReceived(AppLovinAd appLovinAd) {
                    AppLovinFullscreenActivity appLovinFullscreenActivity = (AppLovinFullscreenActivity) ServiceConnectionC1161a.this.f344c.get();
                    if (appLovinFullscreenActivity != null) {
                        ServiceConnectionC1161a.this.f343b.m6319b("InterActivityV2", "Presenting ad...");
                        C1163a c1163a = new C1163a();
                        appLovinFullscreenActivity.present((AbstractC1537g) appLovinAd, c1163a, c1163a, c1163a);
                        return;
                    }
                    C1710r c1710r = ServiceConnectionC1161a.this.f343b;
                    c1710r.m6314e("InterActivityV2", "Unable to present ad, parent activity has been GC'd - " + appLovinAd);
                }

                @Override // com.applovin.sdk.AppLovinAdLoadListener
                public void failedToReceiveAd(int i) {
                    ServiceConnectionC1161a.this.m8286a();
                }
            }, this.f342a));
        } catch (JSONException e) {
            C1710r c1710r = this.f343b;
            c1710r.m6318b("InterActivityV2", "Unable to process ad: " + str, e);
            m8286a();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.f345d.compareAndSet(false, true)) {
            C1710r c1710r = this.f343b;
            c1710r.m6319b("InterActivityV2", "Fullscreen ad service connected to " + componentName);
            this.f346e = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, FullscreenAdService.EnumC1160b.AD.m8287a());
            obtain.replyTo = new Messenger(new HandlerC1164b());
            try {
                this.f343b.m6319b("InterActivityV2", "Requesting ad from FullscreenAdService...");
                this.f346e.send(obtain);
            } catch (RemoteException e) {
                this.f343b.m6318b("InterActivityV2", "Failed to send ad request message to FullscreenAdService", e);
                m8286a();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f345d.compareAndSet(true, false)) {
            C1710r c1710r = this.f343b;
            c1710r.m6319b("InterActivityV2", "FullscreenAdService disconnected from " + componentName);
        }
    }
}
