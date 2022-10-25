package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhk */
/* loaded from: classes2.dex */
final class bhk implements bhz {

    /* renamed from: a */
    final /* synthetic */ Type f5726a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bhk(Type type) {
        this.f5726a = type;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bhz
    /* renamed from: a */
    public final Object mo3659a() {
        Type type = this.f5726a;
        if (!(type instanceof ParameterizedType)) {
            String valueOf = String.valueOf(type.toString());
            throw new bgn(valueOf.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf) : new String("Invalid EnumSet type: "));
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return EnumSet.noneOf((Class) type2);
        }
        String valueOf2 = String.valueOf(this.f5726a.toString());
        throw new bgn(valueOf2.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf2) : new String("Invalid EnumSet type: "));
    }
}
