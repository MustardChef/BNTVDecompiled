package com.applovin.impl.mediation.debugger.p020ui.p021a;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.p016a.p017a.C1402a;
import com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1450a;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1459e;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxDebuggerAdUnitDetailActivity;
import com.applovin.sdk.C1799R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.mediation.debugger.ui.a.c */
/* loaded from: classes.dex */
public class ActivityC1425c extends ActivityC1414a {

    /* renamed from: a */
    private List<C1402a> f1113a;

    /* renamed from: b */
    private C1662k f1114b;

    /* renamed from: c */
    private AbstractView$OnClickListenerC1456d f1115c;

    /* renamed from: d */
    private List<C1452c> f1116d;

    /* renamed from: e */
    private ListView f1117e;

    /* renamed from: a */
    private List<C1452c> m7471a(List<C1402a> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (C1402a c1402a : list) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ID\t\t\t\t\t\t", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(c1402a.m7556a(), ViewCompat.MEASURED_STATE_MASK));
            spannableStringBuilder.append((CharSequence) new SpannedString("\n"));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("FORMAT  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(c1402a.m7553c(), ViewCompat.MEASURED_STATE_MASK));
            arrayList.add(C1452c.m7407a(C1452c.EnumC1455b.DETAIL).m7390a(StringUtils.createSpannedString(c1402a.m7554b(), ViewCompat.MEASURED_STATE_MASK, 18, 1)).m7386b(new SpannedString(spannableStringBuilder)).m7391a(this).m7388a(true).m7393a());
        }
        return arrayList;
    }

    public void initialize(final List<C1402a> list, final C1662k c1662k) {
        this.f1113a = list;
        this.f1114b = c1662k;
        this.f1116d = m7471a(list);
        AbstractView$OnClickListenerC1456d abstractView$OnClickListenerC1456d = new AbstractView$OnClickListenerC1456d(this) { // from class: com.applovin.impl.mediation.debugger.ui.a.c.1
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: a */
            protected int mo7369a(int i) {
                return list.size();
            }

            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: b */
            protected int mo7368b() {
                return 1;
            }

            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: b */
            protected C1452c mo7367b(int i) {
                return new C1459e("");
            }

            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d
            /* renamed from: c */
            protected List<C1452c> mo7366c(int i) {
                return ActivityC1425c.this.f1116d;
            }
        };
        this.f1115c = abstractView$OnClickListenerC1456d;
        abstractView$OnClickListenerC1456d.m7377a(new AbstractView$OnClickListenerC1456d.InterfaceC1458a() { // from class: com.applovin.impl.mediation.debugger.ui.a.c.2
            @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.AbstractView$OnClickListenerC1456d.InterfaceC1458a
            /* renamed from: a */
            public void mo7365a(final C1450a c1450a, C1452c c1452c) {
                ActivityC1425c.this.startActivity(MaxDebuggerAdUnitDetailActivity.class, c1662k.m6636ad(), new ActivityC1414a.InterfaceC1416a<MaxDebuggerAdUnitDetailActivity>() { // from class: com.applovin.impl.mediation.debugger.ui.a.c.2.1
                    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a.InterfaceC1416a
                    /* renamed from: a  reason: avoid collision after fix types in other method */
                    public void mo7430a(MaxDebuggerAdUnitDetailActivity maxDebuggerAdUnitDetailActivity) {
                        maxDebuggerAdUnitDetailActivity.initialize((C1402a) list.get(c1450a.m7412b()), null, c1662k);
                    }
                });
            }
        });
        this.f1115c.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.mediation.debugger.p020ui.ActivityC1414a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("Ad Units");
        setContentView(C1799R.C1803layout.list_view);
        ListView listView = (ListView) findViewById(C1799R.C1802id.listView);
        this.f1117e = listView;
        listView.setAdapter((ListAdapter) this.f1115c);
    }
}
