package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WcoStream.kt */
@Metadata(m108d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0002\u0000\u0005\b\u008a\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m107d2 = {"com/lagradost/cloudstream3/extractors/WcoStream$getUrl$WcoResponse", "", "status", "", "data", "com/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco;)V", "getData", "()Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco;", "Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$DataWco;)Lcom/lagradost/cloudstream3/extractors/WcoStream$getUrl$WcoResponse;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class WcoStream$getUrl$WcoResponse {
    private final WcoStream$getUrl$DataWco data;
    private final Integer status;

    public static /* synthetic */ WcoStream$getUrl$WcoResponse copy$default(WcoStream$getUrl$WcoResponse wcoStream$getUrl$WcoResponse, Integer num, WcoStream$getUrl$DataWco wcoStream$getUrl$DataWco, int i, Object obj) {
        if ((i & 1) != 0) {
            num = wcoStream$getUrl$WcoResponse.status;
        }
        if ((i & 2) != 0) {
            wcoStream$getUrl$DataWco = wcoStream$getUrl$WcoResponse.data;
        }
        return wcoStream$getUrl$WcoResponse.copy(num, wcoStream$getUrl$DataWco);
    }

    public final Integer component1() {
        return this.status;
    }

    public final WcoStream$getUrl$DataWco component2() {
        return this.data;
    }

    public final WcoStream$getUrl$WcoResponse copy(@JsonProperty("status") Integer num, @JsonProperty("data") WcoStream$getUrl$DataWco wcoStream$getUrl$DataWco) {
        return new WcoStream$getUrl$WcoResponse(num, wcoStream$getUrl$DataWco);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WcoStream$getUrl$WcoResponse) {
            WcoStream$getUrl$WcoResponse wcoStream$getUrl$WcoResponse = (WcoStream$getUrl$WcoResponse) obj;
            return Intrinsics.areEqual(this.status, wcoStream$getUrl$WcoResponse.status) && Intrinsics.areEqual(this.data, wcoStream$getUrl$WcoResponse.data);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.status;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        WcoStream$getUrl$DataWco wcoStream$getUrl$DataWco = this.data;
        return hashCode + (wcoStream$getUrl$DataWco != null ? wcoStream$getUrl$DataWco.hashCode() : 0);
    }

    public String toString() {
        return "WcoResponse(status=" + this.status + ", data=" + this.data + ')';
    }

    public WcoStream$getUrl$WcoResponse(@JsonProperty("status") Integer num, @JsonProperty("data") WcoStream$getUrl$DataWco wcoStream$getUrl$DataWco) {
        this.status = num;
        this.data = wcoStream$getUrl$DataWco;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public /* synthetic */ WcoStream$getUrl$WcoResponse(Integer num, WcoStream$getUrl$DataWco wcoStream$getUrl$DataWco, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? new WcoStream$getUrl$DataWco(null, 1, null) : wcoStream$getUrl$DataWco);
    }

    public final WcoStream$getUrl$DataWco getData() {
        return this.data;
    }
}
