package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.internal.bgy;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bz */
/* loaded from: classes2.dex */
public final class C2508bz implements UiElement {
    public static final bgy<C2508bz> GSON_TYPE_ADAPTER = new C2507by();
    private final String name;

    public C2508bz(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof C2508bz)) {
            return this.name.equals(((C2508bz) obj).name);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.UiElement
    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name});
    }

    public String toString() {
        String str = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20);
        sb.append("UiElementImpl[name=");
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}
