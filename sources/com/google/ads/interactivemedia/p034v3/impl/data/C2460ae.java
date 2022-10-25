package com.google.ads.interactivemedia.p034v3.impl.data;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ae */
/* loaded from: classes2.dex */
public final class C2460ae extends AbstractC2497bo {
    private final String message;
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2460ae(String str, String str2) {
        this.name = str;
        this.message = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2497bo) {
            AbstractC2497bo abstractC2497bo = (AbstractC2497bo) obj;
            String str = this.name;
            if (str != null ? str.equals(abstractC2497bo.name()) : abstractC2497bo.name() == null) {
                String str2 = this.message;
                if (str2 != null ? str2.equals(abstractC2497bo.message()) : abstractC2497bo.message() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2497bo
    public String message() {
        return this.message;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2497bo
    public String name() {
        return this.name;
    }

    public String toString() {
        String str = this.name;
        String str2 = this.message;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
        sb.append("LoggableException{name=");
        sb.append(str);
        sb.append(", message=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.message;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }
}
