package com.applovin.impl.mediation;

import android.os.Bundle;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.mediation.p013a.C1341g;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;

/* loaded from: classes.dex */
public class MaxAdapterParametersImpl implements MaxAdapterInitializationParameters, MaxAdapterResponseParameters, MaxAdapterSignalCollectionParameters {

    /* renamed from: a */
    private Bundle f788a;

    /* renamed from: b */
    private Boolean f789b;

    /* renamed from: c */
    private Boolean f790c;

    /* renamed from: d */
    private Boolean f791d;

    /* renamed from: e */
    private boolean f792e;

    /* renamed from: f */
    private String f793f;

    /* renamed from: g */
    private String f794g;

    /* renamed from: h */
    private long f795h;

    /* renamed from: i */
    private MaxAdFormat f796i;

    private MaxAdapterParametersImpl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MaxAdapterParametersImpl m7847a(AbstractC1334a abstractC1334a) {
        MaxAdapterParametersImpl m7846a = m7846a((C1338e) abstractC1334a);
        m7846a.f793f = abstractC1334a.m7808j();
        m7846a.f794g = abstractC1334a.m7810h();
        m7846a.f795h = abstractC1334a.m7809i();
        return m7846a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MaxAdapterParametersImpl m7846a(C1338e c1338e) {
        MaxAdapterParametersImpl maxAdapterParametersImpl = new MaxAdapterParametersImpl();
        maxAdapterParametersImpl.f789b = c1338e.m7760N();
        maxAdapterParametersImpl.f790c = c1338e.m7759O();
        maxAdapterParametersImpl.f791d = c1338e.m7758P();
        maxAdapterParametersImpl.f788a = c1338e.m7756R();
        maxAdapterParametersImpl.f792e = c1338e.m7761M();
        return maxAdapterParametersImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static MaxAdapterParametersImpl m7845a(C1341g c1341g, MaxAdFormat maxAdFormat) {
        MaxAdapterParametersImpl m7846a = m7846a(c1341g);
        m7846a.f796i = maxAdFormat;
        return m7846a;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters
    public MaxAdFormat getAdFormat() {
        return this.f796i;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public long getBidExpirationMillis() {
        return this.f795h;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getBidResponse() {
        return this.f794g;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Bundle getServerParameters() {
        return this.f788a;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
    public String getThirdPartyAdPlacementId() {
        return this.f793f;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean hasUserConsent() {
        return this.f789b;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isAgeRestrictedUser() {
        return this.f790c;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public Boolean isDoNotSell() {
        return this.f791d;
    }

    @Override // com.applovin.mediation.adapter.parameters.MaxAdapterParameters
    public boolean isTesting() {
        return this.f792e;
    }
}
