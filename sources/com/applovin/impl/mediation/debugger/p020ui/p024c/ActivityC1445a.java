package com.applovin.impl.mediation.debugger.p020ui.p024c;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a;
import com.applovin.impl.mediation.debugger.p020ui.p024c.C1448b;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1450a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerMultiAdActivity;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.c.a */
/* loaded from: classes.dex */
public class ActivityC1445a extends ActivityC1414a {

    /* renamed from: a */
    private C1448b f1183a;

    /* renamed from: b */
    private ListView f1184b;

    public ActivityC1445a() {
        this.communicatorTopics.add("adapter_initialization_status");
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    public void initialize(final C1407b c1407b) {
        setTitle(c1407b.m7521h());
        C1448b c1448b = new C1448b(c1407b, this);
        this.f1183a = c1448b;
        c1448b.m7377a(new AbstractView$OnClickListenerC1456d.InterfaceC1458a() { // from class: com.applovin.impl.mediation.debugger.ui.c.a.1
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d.InterfaceC1458a
            /* renamed from: a */
            public void mo7365a(C1450a c1450a, C1452c c1452c) {
                if (c1450a.m7413a() == C1448b.EnumC1449a.TEST_ADS.ordinal()) {
                    C1662k m7510s = c1407b.m7510s();
                    C1407b.EnumC1409b m7526c = c1407b.m7526c();
                    if (C1407b.EnumC1409b.READY == m7526c) {
                        ActivityC1445a.this.startActivity(MaxDebuggerMultiAdActivity.class, m7510s.m6636ad(), new ActivityC1414a.InterfaceC1416a<MaxDebuggerMultiAdActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.c.a.1.1
                            @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a.InterfaceC1416a
                            /* renamed from: a  reason: avoid collision after fix types in other method */
                            public void mo7430a(MaxDebuggerMultiAdActivity maxDebuggerMultiAdActivity) {
                                maxDebuggerMultiAdActivity.initialize(c1407b);
                            }
                        });
                        return;
                    } else if (C1407b.EnumC1409b.DISABLED == m7526c) {
                        m7510s.m6679H().m7344d();
                        Utils.showAlert("Restart Required", c1452c.mo7362m(), ActivityC1445a.this);
                        return;
                    }
                }
                Utils.showAlert("Instructions", c1452c.mo7362m(), ActivityC1445a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C1799R.C1803layout.list_view);
        ListView listView = (ListView) findViewById(C1799R.C1802id.listView);
        this.f1184b = listView;
        listView.setAdapter((ListAdapter) this.f1183a);
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (this.f1183a.m7428a().m7517l().equals(appLovinCommunicatorMessage.getMessageData().getString("adapter_class", ""))) {
            this.f1183a.m7421c();
            this.f1183a.m7374i();
        }
    }
}
