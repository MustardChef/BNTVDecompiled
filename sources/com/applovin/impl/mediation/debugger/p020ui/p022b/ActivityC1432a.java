package com.applovin.impl.mediation.debugger.p020ui.p022b;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.applovin.impl.adview.C1157a;
import com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a;
import com.applovin.impl.mediation.debugger.p020ui.p022b.C1441b;
import com.applovin.impl.mediation.debugger.p020ui.p022b.p023a.C1439a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1450a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.sdk.AppLovinContentProviderUtils;
import com.applovin.impl.sdk.C1526a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxDebuggerAdUnitsListActivity;
import com.applovin.mediation.MaxDebuggerDetailActivity;
import com.applovin.mediation.MaxDebuggerTestLiveNetworkActivity;
import com.applovin.sdk.C1799R;
import com.google.android.exoplayer2.util.MimeTypes;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a */
/* loaded from: classes.dex */
public class ActivityC1432a extends ActivityC1414a {

    /* renamed from: a */
    private C1441b f1131a;

    /* renamed from: b */
    private DataSetObserver f1132b;

    /* renamed from: c */
    private FrameLayout f1133c;

    /* renamed from: d */
    private ListView f1134d;

    /* renamed from: e */
    private C1157a f1135e;

    /* renamed from: a */
    private void m7469a() {
        Uri cacheJPEGImageWithFileName;
        Bitmap a = this.f1131a.m7378a(this.f1134d);
        if (a == null || (cacheJPEGImageWithFileName = AppLovinContentProviderUtils.cacheJPEGImageWithFileName(a, "mediation_debugger_screenshot.jpeg")) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MimeTypes.IMAGE_JPEG);
        intent.putExtra("android.intent.extra.STREAM", cacheJPEGImageWithFileName);
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, "Share Mediation Debugger"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7468a(final Context context) {
        if (!StringUtils.isValidString(this.f1131a.m7439g()) || this.f1131a.m7443c()) {
            return;
        }
        this.f1131a.m7445a(true);
        runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                Utils.showAlert(ActivityC1432a.this.f1131a.m7440f(), ActivityC1432a.this.f1131a.m7439g(), context);
            }
        });
    }

    /* renamed from: b */
    private void m7464b() {
        m7461c();
        C1157a c1157a = new C1157a(this, 50, 16842874);
        this.f1135e = c1157a;
        c1157a.setColor(-3355444);
        this.f1133c.addView(this.f1135e, new FrameLayout.LayoutParams(-1, -1, 17));
        this.f1133c.bringChildToFront(this.f1135e);
        this.f1135e.m8289a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7461c() {
        C1157a c1157a = this.f1135e;
        if (c1157a != null) {
            c1157a.m8288b();
            this.f1133c.removeView(this.f1135e);
            this.f1135e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("MAX Mediation Debugger");
        setContentView(C1799R.C1803layout.list_view);
        this.f1133c = (FrameLayout) findViewById(16908290);
        this.f1134d = (ListView) findViewById(C1799R.C1802id.listView);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1799R.C1804menu.mediation_debugger_activity_menu, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1131a.unregisterDataSetObserver(this.f1132b);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (C1799R.C1802id.action_share == menuItem.getItemId()) {
            m7469a();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f1134d.setAdapter((ListAdapter) this.f1131a);
        if (this.f1131a.m7451a()) {
            return;
        }
        m7464b();
    }

    public void setListAdapter(C1441b c1441b, final C1526a c1526a) {
        DataSetObserver dataSetObserver;
        C1441b c1441b2 = this.f1131a;
        if (c1441b2 != null && (dataSetObserver = this.f1132b) != null) {
            c1441b2.unregisterDataSetObserver(dataSetObserver);
        }
        this.f1131a = c1441b;
        this.f1132b = new DataSetObserver() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                ActivityC1432a.this.m7461c();
                ActivityC1432a activityC1432a = ActivityC1432a.this;
                activityC1432a.m7468a((Context) activityC1432a);
            }
        };
        m7468a((Context) this);
        this.f1131a.registerDataSetObserver(this.f1132b);
        this.f1131a.m7377a(new AbstractView$OnClickListenerC1456d.InterfaceC1458a() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d.InterfaceC1458a
            /* renamed from: a */
            public void mo7365a(C1450a c1450a, final C1452c c1452c) {
                ActivityC1432a activityC1432a;
                String str;
                String str2;
                int m7413a = c1450a.m7413a();
                if (m7413a == C1441b.EnumC1444b.MAX.ordinal()) {
                    Utils.showAlert(c1452c.m7397l(), c1452c.mo7362m(), ActivityC1432a.this);
                } else if (m7413a != C1441b.EnumC1444b.ADS.ordinal()) {
                    if ((m7413a == C1441b.EnumC1444b.INCOMPLETE_NETWORKS.ordinal() || m7413a == C1441b.EnumC1444b.COMPLETED_NETWORKS.ordinal()) && (c1452c instanceof C1439a)) {
                        ActivityC1432a.this.startActivity(MaxDebuggerDetailActivity.class, c1526a, new ActivityC1414a.InterfaceC1416a<MaxDebuggerDetailActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.3
                            @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a.InterfaceC1416a
                            /* renamed from: a  reason: avoid collision after fix types in other method */
                            public void mo7430a(MaxDebuggerDetailActivity maxDebuggerDetailActivity) {
                                maxDebuggerDetailActivity.initialize(((C1439a) c1452c).m7456d());
                            }
                        });
                    }
                } else {
                    if (c1450a.m7412b() == C1441b.EnumC1443a.AD_UNITS.ordinal()) {
                        if (ActivityC1432a.this.f1131a.m7441e().size() > 0) {
                            ActivityC1432a.this.startActivity(MaxDebuggerAdUnitsListActivity.class, c1526a, new ActivityC1414a.InterfaceC1416a<MaxDebuggerAdUnitsListActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.1
                                @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a.InterfaceC1416a
                                /* renamed from: a  reason: avoid collision after fix types in other method */
                                public void mo7430a(MaxDebuggerAdUnitsListActivity maxDebuggerAdUnitsListActivity) {
                                    maxDebuggerAdUnitsListActivity.initialize(ActivityC1432a.this.f1131a.m7441e(), ActivityC1432a.this.f1131a.m7442d());
                                }
                            });
                            return;
                        }
                        activityC1432a = ActivityC1432a.this;
                        str = "No live ad units";
                        str2 = "Please setup or enable your MAX ad units on https://applovin.com.";
                    } else if (c1450a.m7412b() != C1441b.EnumC1443a.SELECT_LIVE_NETWORKS.ordinal()) {
                        return;
                    } else {
                        if (ActivityC1432a.this.f1131a.m7438h().size() > 0) {
                            if (ActivityC1432a.this.f1131a.m7442d().m6679H().m7351a()) {
                                Utils.showAlert("Restart Required", c1452c.mo7362m(), ActivityC1432a.this);
                                return;
                            } else {
                                ActivityC1432a.this.startActivity(MaxDebuggerTestLiveNetworkActivity.class, c1526a, new ActivityC1414a.InterfaceC1416a<MaxDebuggerTestLiveNetworkActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.b.a.2.2
                                    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a.InterfaceC1416a
                                    /* renamed from: a  reason: avoid collision after fix types in other method */
                                    public void mo7430a(MaxDebuggerTestLiveNetworkActivity maxDebuggerTestLiveNetworkActivity) {
                                        maxDebuggerTestLiveNetworkActivity.initialize(ActivityC1432a.this.f1131a.m7438h(), ActivityC1432a.this.f1131a.m7442d());
                                    }
                                });
                                return;
                            }
                        }
                        activityC1432a = ActivityC1432a.this;
                        str = "Complete Integrations";
                        str2 = "Please complete integrations in order to access this.";
                    }
                    Utils.showAlert(str, str2, activityC1432a);
                }
            }
        });
    }
}
