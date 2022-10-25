package com.applovin.impl.mediation.debugger.p020ui.p025d;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.C1723e;
import com.applovin.sdk.C1799R;

/* renamed from: com.applovin.impl.mediation.debugger.ui.d.c */
/* loaded from: classes.dex */
public class C1452c {

    /* renamed from: b */
    protected EnumC1455b f1210b;

    /* renamed from: c */
    protected boolean f1211c;

    /* renamed from: d */
    protected SpannedString f1212d;

    /* renamed from: e */
    protected SpannedString f1213e;

    /* renamed from: f */
    protected String f1214f;

    /* renamed from: g */
    protected String f1215g;

    /* renamed from: h */
    protected int f1216h;

    /* renamed from: i */
    protected int f1217i;

    /* renamed from: j */
    protected int f1218j;

    /* renamed from: k */
    protected int f1219k;

    /* renamed from: l */
    protected int f1220l;

    /* renamed from: m */
    protected int f1221m;

    /* renamed from: n */
    protected boolean f1222n;

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.c$a */
    /* loaded from: classes.dex */
    public static class C1454a {

        /* renamed from: a */
        final EnumC1455b f1223a;

        /* renamed from: b */
        boolean f1224b;

        /* renamed from: c */
        SpannedString f1225c;

        /* renamed from: d */
        SpannedString f1226d;

        /* renamed from: e */
        String f1227e;

        /* renamed from: f */
        String f1228f;

        /* renamed from: g */
        int f1229g = 0;

        /* renamed from: h */
        int f1230h = 0;

        /* renamed from: i */
        int f1231i = ViewCompat.MEASURED_STATE_MASK;

        /* renamed from: j */
        int f1232j = ViewCompat.MEASURED_STATE_MASK;

        /* renamed from: k */
        int f1233k = 0;

        /* renamed from: l */
        int f1234l = 0;

        /* renamed from: m */
        boolean f1235m;

        public C1454a(EnumC1455b enumC1455b) {
            this.f1223a = enumC1455b;
        }

        /* renamed from: a */
        public C1454a m7392a(int i) {
            this.f1230h = i;
            return this;
        }

        /* renamed from: a */
        public C1454a m7391a(Context context) {
            this.f1230h = C1799R.C1801drawable.applovin_ic_disclosure_arrow;
            this.f1234l = C1723e.m6281a(C1799R.C1800color.applovin_sdk_disclosureButtonColor, context);
            return this;
        }

        /* renamed from: a */
        public C1454a m7390a(SpannedString spannedString) {
            this.f1225c = spannedString;
            return this;
        }

        /* renamed from: a */
        public C1454a m7389a(String str) {
            return m7390a(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        /* renamed from: a */
        public C1454a m7388a(boolean z) {
            this.f1224b = z;
            return this;
        }

        /* renamed from: a */
        public C1452c m7393a() {
            return new C1452c(this);
        }

        /* renamed from: b */
        public C1454a m7387b(int i) {
            this.f1232j = i;
            return this;
        }

        /* renamed from: b */
        public C1454a m7386b(SpannedString spannedString) {
            this.f1226d = spannedString;
            return this;
        }

        /* renamed from: b */
        public C1454a m7385b(String str) {
            return m7386b(!TextUtils.isEmpty(str) ? new SpannedString(str) : null);
        }

        /* renamed from: b */
        public C1454a m7384b(boolean z) {
            this.f1235m = z;
            return this;
        }

        /* renamed from: c */
        public C1454a m7383c(int i) {
            this.f1234l = i;
            return this;
        }

        /* renamed from: c */
        public C1454a m7382c(String str) {
            this.f1227e = str;
            return this;
        }

        /* renamed from: d */
        public C1454a m7381d(String str) {
            this.f1228f = str;
            return this;
        }
    }

    /* renamed from: com.applovin.impl.mediation.debugger.ui.d.c$b */
    /* loaded from: classes.dex */
    public enum EnumC1455b {
        SECTION(0),
        SECTION_CENTERED(1),
        SIMPLE(2),
        DETAIL(3),
        RIGHT_DETAIL(4),
        COUNT(5);
        

        /* renamed from: g */
        private final int f1243g;

        EnumC1455b(int i) {
            this.f1243g = i;
        }

        /* renamed from: a */
        public int m7380a() {
            return this.f1243g;
        }

        /* renamed from: b */
        public int m7379b() {
            if (this == SECTION) {
                return C1799R.C1803layout.list_section;
            }
            if (this == SECTION_CENTERED) {
                return C1799R.C1803layout.list_section_centered;
            }
            if (this == SIMPLE) {
                return 17367043;
            }
            return this == DETAIL ? C1799R.C1803layout.list_item_detail : C1799R.C1803layout.list_item_right_detail;
        }
    }

    private C1452c(C1454a c1454a) {
        this.f1216h = 0;
        this.f1217i = 0;
        this.f1218j = ViewCompat.MEASURED_STATE_MASK;
        this.f1219k = ViewCompat.MEASURED_STATE_MASK;
        this.f1220l = 0;
        this.f1221m = 0;
        this.f1210b = c1454a.f1223a;
        this.f1211c = c1454a.f1224b;
        this.f1212d = c1454a.f1225c;
        this.f1213e = c1454a.f1226d;
        this.f1214f = c1454a.f1227e;
        this.f1215g = c1454a.f1228f;
        this.f1216h = c1454a.f1229g;
        this.f1217i = c1454a.f1230h;
        this.f1218j = c1454a.f1231i;
        this.f1219k = c1454a.f1232j;
        this.f1220l = c1454a.f1233k;
        this.f1221m = c1454a.f1234l;
        this.f1222n = c1454a.f1235m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1452c(EnumC1455b enumC1455b) {
        this.f1216h = 0;
        this.f1217i = 0;
        this.f1218j = ViewCompat.MEASURED_STATE_MASK;
        this.f1219k = ViewCompat.MEASURED_STATE_MASK;
        this.f1220l = 0;
        this.f1221m = 0;
        this.f1210b = enumC1455b;
    }

    /* renamed from: a */
    public static C1454a m7407a(EnumC1455b enumC1455b) {
        return new C1454a(enumC1455b);
    }

    /* renamed from: h */
    public static int m7401h() {
        return EnumC1455b.COUNT.m7380a();
    }

    /* renamed from: p */
    public static C1454a m7394p() {
        return m7407a(EnumC1455b.RIGHT_DETAIL);
    }

    /* renamed from: b */
    public boolean mo7406b() {
        return this.f1211c;
    }

    /* renamed from: c */
    public int mo7405c() {
        return this.f1219k;
    }

    /* renamed from: c_ */
    public SpannedString mo7404c_() {
        return this.f1213e;
    }

    /* renamed from: d_ */
    public boolean mo7403d_() {
        return this.f1222n;
    }

    /* renamed from: e */
    public int mo7402e() {
        return this.f1216h;
    }

    /* renamed from: f */
    public int mo7364f() {
        return this.f1217i;
    }

    /* renamed from: g */
    public int mo7363g() {
        return this.f1221m;
    }

    /* renamed from: i */
    public int m7400i() {
        return this.f1210b.m7380a();
    }

    /* renamed from: j */
    public int m7399j() {
        return this.f1210b.m7379b();
    }

    /* renamed from: k */
    public SpannedString m7398k() {
        return this.f1212d;
    }

    /* renamed from: l */
    public String m7397l() {
        return this.f1214f;
    }

    /* renamed from: m */
    public String mo7362m() {
        return this.f1215g;
    }

    /* renamed from: n */
    public int m7396n() {
        return this.f1218j;
    }

    /* renamed from: o */
    public int m7395o() {
        return this.f1220l;
    }
}
