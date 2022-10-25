package com.applovin.impl.mediation.debugger.p020ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.C1526a;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.C1799R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a */
/* loaded from: classes.dex */
public class ActivityC1414a extends Activity implements AppLovinCommunicatorSubscriber {
    protected List<String> communicatorTopics = new ArrayList();

    /* renamed from: com.applovin.impl.mediation.debugger.ui.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1416a<T extends Activity> {
        /* renamed from: a */
        void mo7430a(T t);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (!Utils.isPubInDebugMode(this)) {
            setTheme(C1799R.style.com_applovin_mediation_MaxDebuggerActivity_Theme_Live);
        }
        super.onCreate(bundle);
        List<String> list = this.communicatorTopics;
        if (list == null || list.size() <= 0) {
            return;
        }
        AppLovinCommunicator.getInstance(this).subscribe(this, this.communicatorTopics);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        List<String> list = this.communicatorTopics;
        if (list == null || list.size() <= 0) {
            return;
        }
        AppLovinCommunicator.getInstance(this).unsubscribe(this, this.communicatorTopics);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startActivity(final Class cls, final C1526a c1526a, final InterfaceC1416a interfaceC1416a) {
        c1526a.m7239a(new AbstractC1718a() { // from class: com.applovin.impl.mediation.debugger.ui.a.1
            @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (cls.isInstance(activity)) {
                    interfaceC1416a.mo7430a(activity);
                    c1526a.m7237b(this);
                }
            }
        });
        startActivity(new Intent(this, cls));
    }
}
