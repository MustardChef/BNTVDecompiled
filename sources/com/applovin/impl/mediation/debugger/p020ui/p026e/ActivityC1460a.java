package com.applovin.impl.mediation.debugger.p020ui.p026e;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a;
import com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1450a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.C1799R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.e.a */
/* loaded from: classes.dex */
public class ActivityC1460a extends ActivityC1414a {

    /* renamed from: a */
    private C1662k f1250a;

    /* renamed from: b */
    private List<C1407b> f1251b;

    /* renamed from: c */
    private AbstractView$OnClickListenerC1456d f1252c;

    /* renamed from: d */
    private List<C1452c> f1253d;

    /* renamed from: e */
    private ListView f1254e;

    public ActivityC1460a() {
        this.communicatorTopics.add("network_sdk_version_updated");
    }

    /* renamed from: a */
    private List<C1452c> m7372a(List<C1407b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (final C1407b c1407b : list) {
            arrayList.add(new C1439a(c1407b, this) { // from class: com.applovin.impl.mediation.debugger.ui.e.a.3
                @Override // com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a, com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
                /* renamed from: f */
                public int mo7364f() {
                    if (ActivityC1460a.this.f1250a.m6679H().m7345c() == null || !ActivityC1460a.this.f1250a.m6679H().m7345c().equals(c1407b.m7522g())) {
                        return 0;
                    }
                    return C1799R.C1801drawable.applovin_ic_check_mark_borderless;
                }

                @Override // com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a, com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
                /* renamed from: g */
                public int mo7363g() {
                    if (ActivityC1460a.this.f1250a.m6679H().m7345c() == null || !ActivityC1460a.this.f1250a.m6679H().m7345c().equals(c1407b.m7522g())) {
                        return super.mo7363g();
                    }
                    return -16776961;
                }

                @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
                /* renamed from: m */
                public String mo7362m() {
                    return "Please restart the app to show ads from the network: " + c1407b.m7521h() + ".";
                }
            });
        }
        return arrayList;
    }

    public void initialize(List<C1407b> list, final C1662k c1662k) {
        this.f1250a = c1662k;
        this.f1251b = list;
        this.f1253d = m7372a(list);
        AbstractView$OnClickListenerC1456d abstractView$OnClickListenerC1456d = new AbstractView$OnClickListenerC1456d(this) { // from class: com.applovin.impl.mediation.debugger.ui.e.a.1
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: a */
            protected int mo7369a(int i) {
                return ActivityC1460a.this.f1253d.size();
            }

            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: b */
            protected int mo7368b() {
                return 1;
            }

            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: b */
            protected C1452c mo7367b(int i) {
                return new C1452c.C1454a(C1452c.EnumC1455b.SECTION_CENTERED).m7389a("Select a network to load ads using your MAX ad unit configuration. Once enabled, this functionality will reset on the next app session.").m7393a();
            }

            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: c */
            protected List<C1452c> mo7366c(int i) {
                return ActivityC1460a.this.f1253d;
            }
        };
        this.f1252c = abstractView$OnClickListenerC1456d;
        abstractView$OnClickListenerC1456d.m7377a(new AbstractView$OnClickListenerC1456d.InterfaceC1458a() { // from class: com.applovin.impl.mediation.debugger.ui.e.a.2
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d.InterfaceC1458a
            /* renamed from: a */
            public void mo7365a(C1450a c1450a, C1452c c1452c) {
                if (StringUtils.isValidString(c1662k.m6679H().m7345c())) {
                    c1662k.m6679H().m7350a(((C1439a) c1452c).m7456d().m7522g());
                } else {
                    c1662k.m6679H().m7346b(((C1439a) c1452c).m7456d().m7522g());
                    Utils.showAlert("Restart Required", c1452c.mo7362m(), ActivityC1460a.this);
                }
                ActivityC1460a.this.f1252c.notifyDataSetChanged();
            }
        });
        this.f1252c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Select Live Network");
        setContentView(C1799R.C1803layout.list_view);
        ListView listView = (ListView) findViewById(C1799R.C1802id.listView);
        this.f1254e = listView;
        listView.setAdapter((ListAdapter) this.f1252c);
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        this.f1253d = m7372a(this.f1251b);
        this.f1252c.m7374i();
    }
}
