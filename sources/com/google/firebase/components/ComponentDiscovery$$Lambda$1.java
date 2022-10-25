package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes3.dex */
final /* synthetic */ class ComponentDiscovery$$Lambda$1 implements Provider {
    private final String arg$1;

    private ComponentDiscovery$$Lambda$1(String str) {
        this.arg$1 = str;
    }

    public static Provider lambdaFactory$(String str) {
        return new ComponentDiscovery$$Lambda$1(str);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return ComponentDiscovery.lambda$discoverLazy$0(this.arg$1);
    }
}
