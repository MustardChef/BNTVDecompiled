package com.applovin.impl.mediation.debugger.p016a.p018b;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.C1720c;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.b.c */
/* loaded from: classes.dex */
public class C1410c {

    /* renamed from: a */
    private final boolean f1068a;

    /* renamed from: b */
    private final boolean f1069b;

    /* renamed from: c */
    private final boolean f1070c;

    /* renamed from: d */
    private final String f1071d;

    public C1410c(JSONObject jSONObject, C1662k c1662k) {
        this.f1068a = C1720c.m6288a(c1662k.m6677J()).m6289a();
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "cleartext_traffic", (JSONObject) null);
        boolean z = false;
        if (jSONObject2 == null) {
            this.f1069b = false;
            this.f1071d = "";
            this.f1070c = C1725g.m6270a();
            return;
        }
        this.f1069b = true;
        this.f1071d = JsonUtils.getString(jSONObject2, "description", "");
        if (C1725g.m6270a()) {
            this.f1070c = true;
            return;
        }
        List list = JsonUtils.getList(jSONObject2, "domains", new ArrayList());
        if (list.size() > 0) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (!C1725g.m6265a((String) it.next())) {
                    break;
                }
            }
        }
        this.f1070c = z;
    }

    /* renamed from: a */
    public boolean m7502a() {
        return this.f1069b;
    }

    /* renamed from: b */
    public boolean m7501b() {
        return this.f1070c;
    }

    /* renamed from: c */
    public String m7500c() {
        return this.f1068a ? this.f1071d : "You must include an entry in your AndroidManifest.xml to point to your network_security_config.xml.\n\nFor more information, visit: https://developer.android.com/training/articles/security-config";
    }
}
