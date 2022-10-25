package com.google.android.gms.common.api.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class zabm {
    private final ApiKey<?> zaa;
    private final Feature zab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zabm(ApiKey apiKey, Feature feature, zabg zabgVar) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ApiKey zaa(zabm zabmVar) {
        return zabmVar.zaa;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabm)) {
            zabm zabmVar = (zabm) obj;
            if (Objects.equal(this.zaa, zabmVar.zaa) && Objects.equal(this.zab, zabmVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zaa, this.zab);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(SDKConstants.PARAM_KEY, this.zaa).add("feature", this.zab).toString();
    }
}
