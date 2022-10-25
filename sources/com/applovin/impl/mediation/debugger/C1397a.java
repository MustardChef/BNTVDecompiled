package com.applovin.impl.mediation.debugger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1402a;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p019b.C1412a;
import com.applovin.impl.mediation.debugger.p020ui.p022b.C1441b;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.AbstractC1718a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a */
/* loaded from: classes.dex */
public class C1397a implements C1684b.InterfaceC1687c<JSONObject> {

    /* renamed from: a */
    private static WeakReference<MaxDebuggerActivity> f1000a;

    /* renamed from: b */
    private static final AtomicBoolean f1001b = new AtomicBoolean();

    /* renamed from: c */
    private final C1662k f1002c;

    /* renamed from: d */
    private final C1710r f1003d;

    /* renamed from: e */
    private final C1441b f1004e;

    /* renamed from: f */
    private final Map<String, C1407b> f1005f = new HashMap();

    /* renamed from: g */
    private final AtomicBoolean f1006g = new AtomicBoolean();

    /* renamed from: h */
    private boolean f1007h;

    /* renamed from: i */
    private final Context f1008i;

    public C1397a(C1662k c1662k) {
        this.f1002c = c1662k;
        this.f1003d = c1662k.m6588z();
        Context m6677J = c1662k.m6677J();
        this.f1008i = m6677J;
        this.f1004e = new C1441b(m6677J);
    }

    /* renamed from: a */
    private List<C1407b> m7566a(JSONObject jSONObject, C1662k c1662k) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                C1407b c1407b = new C1407b(jSONObject2, c1662k);
                arrayList.add(c1407b);
                this.f1005f.put(c1407b.m7517l(), c1407b);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private List<C1402a> m7565a(JSONObject jSONObject, List<C1407b> list, C1662k c1662k) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new C1402a(jSONObject2, this.f1005f, c1662k));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    private void m7568a(List<C1407b> list) {
        boolean z;
        Iterator<C1407b> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C1407b next = it.next();
            if (next.m7524e() && next.m7533a() == C1407b.EnumC1408a.INVALID_INTEGRATION) {
                z = true;
                break;
            }
        }
        if (z) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.debugger.a.2
                @Override // java.lang.Runnable
                public void run() {
                    new AlertDialog.Builder(C1397a.this.f1002c.m6636ad().m7240a()).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.mediation.debugger.a.2.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            C1397a.this.m7561c();
                        }
                    }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
                }
            }, TimeUnit.SECONDS.toMillis(2L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public boolean m7557f() {
        WeakReference<MaxDebuggerActivity> weakReference = f1000a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* renamed from: a */
    public void m7572a() {
        if (this.f1006g.compareAndSet(false, true)) {
            this.f1002c.m6670Q().m6793a(new C1412a(this, this.f1002c), C1620o.EnumC1622a.MEDIATION_MAIN);
        }
    }

    @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
    /* renamed from: a */
    public void mo6491a(int i, String str, JSONObject jSONObject) {
        C1710r c1710r = this.f1003d;
        c1710r.m6314e("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i);
        C1710r.m6310i("AppLovinSdk", "Unable to show mediation debugger.");
        this.f1004e.m7446a(null, null, null, null, null, this.f1002c);
        this.f1006g.set(false);
    }

    @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
    /* renamed from: a */
    public void mo6490a(JSONObject jSONObject, int i) {
        List<C1407b> m7566a = m7566a(jSONObject, this.f1002c);
        List<C1402a> m7565a = m7565a(jSONObject, m7566a, this.f1002c);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        this.f1004e.m7446a(m7566a, m7565a, JsonUtils.getString(jSONObject2, "title", null), JsonUtils.getString(jSONObject2, "message", null), JsonUtils.getString(jSONObject, "account_id", null), this.f1002c);
        if (m7563b()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.debugger.a.3
                @Override // java.lang.Runnable
                public void run() {
                    C1397a.this.m7561c();
                }
            }, TimeUnit.SECONDS.toMillis(2L));
        } else {
            m7568a(m7566a);
        }
    }

    /* renamed from: a */
    public void m7564a(boolean z) {
        this.f1007h = z;
    }

    /* renamed from: b */
    public boolean m7563b() {
        return this.f1007h;
    }

    /* renamed from: c */
    public void m7561c() {
        m7572a();
        if (m7557f() || !f1001b.compareAndSet(false, true)) {
            C1710r.m6310i("AppLovinSdk", "Mediation debugger is already showing");
            return;
        }
        this.f1002c.m6636ad().m7239a(new AbstractC1718a() { // from class: com.applovin.impl.mediation.debugger.a.1
            @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1710r.m6313f("AppLovinSdk", "Mediation debugger destroyed");
                    C1397a.this.f1002c.m6636ad().m7237b(this);
                    WeakReference unused = C1397a.f1000a = null;
                }
            }

            @Override // com.applovin.impl.sdk.utils.AbstractC1718a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity instanceof MaxDebuggerActivity) {
                    C1710r.m6313f("AppLovinSdk", "Started mediation debugger");
                    if (!C1397a.this.m7557f() || C1397a.f1000a.get() != activity) {
                        MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                        WeakReference unused = C1397a.f1000a = new WeakReference(maxDebuggerActivity);
                        maxDebuggerActivity.setListAdapter(C1397a.this.f1004e, C1397a.this.f1002c.m6636ad());
                    }
                    C1397a.f1001b.set(false);
                }
            }
        });
        Intent intent = new Intent(this.f1008i, MaxDebuggerActivity.class);
        intent.setFlags(268435456);
        C1710r.m6313f("AppLovinSdk", "Starting mediation debugger...");
        this.f1008i.startActivity(intent);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f1004e + "}";
    }
}
