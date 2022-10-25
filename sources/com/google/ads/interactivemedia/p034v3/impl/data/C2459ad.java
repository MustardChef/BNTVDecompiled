package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ad */
/* loaded from: classes2.dex */
public final class C2459ad extends AbstractC2494bl {
    private final EnumC2492bj component;
    private final AbstractC2497bo loggableException;
    private final EnumC2493bk method;
    private final long timestamp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2459ad(long j, EnumC2492bj enumC2492bj, EnumC2493bk enumC2493bk, AbstractC2497bo abstractC2497bo) {
        this.timestamp = j;
        Objects.requireNonNull(enumC2492bj, "Null component");
        this.component = enumC2492bj;
        Objects.requireNonNull(enumC2493bk, "Null method");
        this.method = enumC2493bk;
        this.loggableException = abstractC2497bo;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2494bl
    public EnumC2492bj component() {
        return this.component;
    }

    public boolean equals(Object obj) {
        AbstractC2497bo abstractC2497bo;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2494bl) {
            AbstractC2494bl abstractC2494bl = (AbstractC2494bl) obj;
            if (this.timestamp == abstractC2494bl.timestamp() && this.component.equals(abstractC2494bl.component()) && this.method.equals(abstractC2494bl.method()) && ((abstractC2497bo = this.loggableException) != null ? abstractC2497bo.equals(abstractC2494bl.loggableException()) : abstractC2494bl.loggableException() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestamp;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.component.hashCode()) * 1000003) ^ this.method.hashCode()) * 1000003;
        AbstractC2497bo abstractC2497bo = this.loggableException;
        return (abstractC2497bo == null ? 0 : abstractC2497bo.hashCode()) ^ hashCode;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2494bl
    public AbstractC2497bo loggableException() {
        return this.loggableException;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2494bl
    public EnumC2493bk method() {
        return this.method;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2494bl
    public long timestamp() {
        return this.timestamp;
    }

    public String toString() {
        long j = this.timestamp;
        String valueOf = String.valueOf(this.component);
        String valueOf2 = String.valueOf(this.method);
        String valueOf3 = String.valueOf(this.loggableException);
        int length = String.valueOf(valueOf).length();
        StringBuilder sb = new StringBuilder(length + 92 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("InstrumentationData{timestamp=");
        sb.append(j);
        sb.append(", component=");
        sb.append(valueOf);
        sb.append(", method=");
        sb.append(valueOf2);
        sb.append(", loggableException=");
        sb.append(valueOf3);
        sb.append("}");
        return sb.toString();
    }
}
