package com.applovin.impl.mediation.debugger.p020ui.p022b.p023a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c;
import com.applovin.impl.sdk.utils.C1723e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.b.a.a */
/* loaded from: classes.dex */
public class C1439a extends C1452c {

    /* renamed from: a */
    private final C1407b f1145a;

    /* renamed from: o */
    private final Context f1146o;

    public C1439a(C1407b c1407b, Context context) {
        super(C1452c.EnumC1455b.DETAIL);
        this.f1145a = c1407b;
        this.f1146o = context;
        this.f1212d = m7455q();
        this.f1213e = m7454r();
    }

    /* renamed from: q */
    private SpannedString m7455q() {
        return StringUtils.createSpannedString(this.f1145a.m7521h(), mo7406b() ? ViewCompat.MEASURED_STATE_MASK : -7829368, 18, 1);
    }

    /* renamed from: r */
    private SpannedString m7454r() {
        if (mo7406b()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) m7453s());
            spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
            spannableStringBuilder.append((CharSequence) m7452t());
            if (this.f1145a.m7533a() == C1407b.EnumC1408a.INVALID_INTEGRATION) {
                spannableStringBuilder.append((CharSequence) new SpannableString("\n"));
                spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString("Invalid Integration", SupportMenu.CATEGORY_MASK));
            }
            return new SpannedString(spannableStringBuilder);
        }
        return null;
    }

    /* renamed from: s */
    private SpannedString m7453s() {
        if (this.f1145a.m7525d()) {
            if (TextUtils.isEmpty(this.f1145a.m7520i())) {
                return StringUtils.createListItemDetailSpannedString(this.f1145a.m7524e() ? "Retrieving SDK Version..." : "SDK Found", ViewCompat.MEASURED_STATE_MASK);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("SDK\t\t\t\t\t  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f1145a.m7520i(), ViewCompat.MEASURED_STATE_MASK));
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString("SDK Missing", SupportMenu.CATEGORY_MASK);
    }

    /* renamed from: t */
    private SpannedString m7452t() {
        if (this.f1145a.m7524e()) {
            if (TextUtils.isEmpty(this.f1145a.m7519j())) {
                return StringUtils.createListItemDetailSpannedString("Adapter Found", ViewCompat.MEASURED_STATE_MASK);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringUtils.createListItemDetailSubSpannedString("ADAPTER  ", -7829368));
            spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f1145a.m7519j(), ViewCompat.MEASURED_STATE_MASK));
            if (this.f1145a.m7523f()) {
                spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSubSpannedString("  LATEST  ", Color.rgb(255, 127, 0)));
                spannableStringBuilder.append((CharSequence) StringUtils.createListItemDetailSpannedString(this.f1145a.m7518k(), ViewCompat.MEASURED_STATE_MASK));
            }
            return new SpannedString(spannableStringBuilder);
        }
        return StringUtils.createListItemDetailSpannedString("Adapter Missing", SupportMenu.CATEGORY_MASK);
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: b */
    public boolean mo7406b() {
        return this.f1145a.m7533a() != C1407b.EnumC1408a.MISSING;
    }

    /* renamed from: d */
    public C1407b m7456d() {
        return this.f1145a;
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: e */
    public int mo7402e() {
        int m7515n = this.f1145a.m7515n();
        return m7515n > 0 ? m7515n : C1799R.C1801drawable.applovin_ic_mediation_placeholder;
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: f */
    public int mo7364f() {
        return mo7406b() ? C1799R.C1801drawable.applovin_ic_disclosure_arrow : super.mo7402e();
    }

    @Override // com.applovin.impl.mediation.debugger.p020ui.p025d.C1452c
    /* renamed from: g */
    public int mo7363g() {
        return C1723e.m6281a(C1799R.C1800color.applovin_sdk_disclosureButtonColor, this.f1146o);
    }

    public String toString() {
        return "MediatedNetworkListItemViewModel{text=" + ((Object) this.f1212d) + ", detailText=" + ((Object) this.f1213e) + ", network=" + this.f1145a + "}";
    }
}
