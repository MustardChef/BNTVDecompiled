package com.applovin.impl.mediation.debugger.p016a.p018b;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.a */
/* loaded from: classes.dex */
public class C1406a {

    /* renamed from: a */
    private final String f1029a;

    /* renamed from: b */
    private final String f1030b;

    /* renamed from: c */
    private final boolean f1031c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1406a(JSONObject jSONObject, C1662k c1662k) {
        this.f1029a = JsonUtils.getString(jSONObject, "name", "");
        this.f1030b = JsonUtils.getString(jSONObject, "description", "");
        List list = JsonUtils.getList(jSONObject, "existence_classes", null);
        this.f1031c = list != null ? Utils.checkClassesExistence(list) : Utils.checkClassExistence(JsonUtils.getString(jSONObject, "existence_class", ""));
    }

    /* renamed from: a */
    public String m7536a() {
        return this.f1029a;
    }

    /* renamed from: b */
    public String m7535b() {
        return this.f1030b;
    }

    /* renamed from: c */
    public boolean m7534c() {
        return this.f1031c;
    }
}
