package com.applovin.mediation.adapter.parameters;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface MaxAdapterParameters {
    Bundle getServerParameters();

    Boolean hasUserConsent();

    Boolean isAgeRestrictedUser();

    Boolean isDoNotSell();

    boolean isTesting();
}
