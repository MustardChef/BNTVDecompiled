package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bil */
/* loaded from: classes2.dex */
public final class bil implements bgz {

    /* renamed from: a */
    private final bhl f5797a;

    /* renamed from: b */
    private final /* synthetic */ int f5798b;

    public bil(bhl bhlVar, int i) {
        this.f5798b = i;
        this.f5797a = bhlVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static final bgy m3639b(bhl bhlVar, bgh bghVar, bkt bktVar, bha bhaVar) {
        bgs bgsVar;
        bgy bjaVar;
        Object mo3659a = bhlVar.m3681a(bkt.m3602a(bhaVar.m3698a())).mo3659a();
        if (mo3659a instanceof bgy) {
            bjaVar = (bgy) mo3659a;
        } else if (mo3659a instanceof bgz) {
            bjaVar = ((bgz) mo3659a).mo3604a(bghVar, bktVar);
        } else {
            if (mo3659a instanceof bgs) {
                bgsVar = (bgs) mo3659a;
            } else if (!(mo3659a instanceof bgl)) {
                String name = mo3659a.getClass().getName();
                String bktVar2 = bktVar.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 161 + String.valueOf(bktVar2).length());
                sb.append("Invalid attempt to bind an instance of ");
                sb.append(name);
                sb.append(" as a @JsonAdapter for ");
                sb.append(bktVar2);
                sb.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(sb.toString());
            } else {
                bgsVar = null;
            }
            bjaVar = new bja(bgsVar, mo3659a instanceof bgl ? (bgl) mo3659a : null, bghVar, bktVar, null);
        }
        return (bjaVar == null || !bhaVar.m3697b()) ? bjaVar : bjaVar.nullSafe();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        bgy bgyVar;
        int i = this.f5798b;
        if (i == 0) {
            bha bhaVar = (bha) bktVar.m3600c().getAnnotation(bha.class);
            if (bhaVar == null) {
                return null;
            }
            return m3639b(this.f5797a, bghVar, bktVar, bhaVar);
        } else if (i == 1) {
            Type m3599d = bktVar.m3599d();
            Class m3600c = bktVar.m3600c();
            if (Collection.class.isAssignableFrom(m3600c)) {
                Type m3690e = bhf.m3690e(m3599d, m3600c);
                return new big(bghVar, m3690e, bghVar.m3728a(bkt.m3601b(m3690e)), this.f5797a.m3681a(bktVar));
            }
            return null;
        } else {
            Type m3599d2 = bktVar.m3599d();
            if (Map.class.isAssignableFrom(bktVar.m3600c())) {
                Type[] m3683l = bhf.m3683l(m3599d2, bhf.m3694a(m3599d2));
                Type type = m3683l[0];
                if (type == Boolean.TYPE || type == Boolean.class) {
                    bgyVar = bkh.f5919f;
                } else {
                    bgyVar = bghVar.m3728a(bkt.m3601b(type));
                }
                return new biq(bghVar, m3683l[0], bgyVar, m3683l[1], bghVar.m3728a(bkt.m3601b(m3683l[1])), this.f5797a.m3681a(bktVar));
            }
            return null;
        }
    }
}
