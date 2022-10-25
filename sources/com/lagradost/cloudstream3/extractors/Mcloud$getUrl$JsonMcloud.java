package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Mcloud.kt */
@Metadata(m108d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0002\u0000\u0005\b\u008a\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, m107d2 = {"com/lagradost/cloudstream3/extractors/Mcloud$getUrl$JsonMcloud", "", "status", "", "data", "com/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud;)V", "getData", "()Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud;", "Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud;", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$DataMcloud;)Lcom/lagradost/cloudstream3/extractors/Mcloud$getUrl$JsonMcloud;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Mcloud$getUrl$JsonMcloud {
    private final Mcloud$getUrl$DataMcloud data;
    private final Integer status;

    public static /* synthetic */ Mcloud$getUrl$JsonMcloud copy$default(Mcloud$getUrl$JsonMcloud mcloud$getUrl$JsonMcloud, Integer num, Mcloud$getUrl$DataMcloud mcloud$getUrl$DataMcloud, int i, Object obj) {
        if ((i & 1) != 0) {
            num = mcloud$getUrl$JsonMcloud.status;
        }
        if ((i & 2) != 0) {
            mcloud$getUrl$DataMcloud = mcloud$getUrl$JsonMcloud.data;
        }
        return mcloud$getUrl$JsonMcloud.copy(num, mcloud$getUrl$DataMcloud);
    }

    public final Integer component1() {
        return this.status;
    }

    public final Mcloud$getUrl$DataMcloud component2() {
        return this.data;
    }

    public final Mcloud$getUrl$JsonMcloud copy(@JsonProperty("status") Integer num, @JsonProperty("data") Mcloud$getUrl$DataMcloud data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new Mcloud$getUrl$JsonMcloud(num, data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Mcloud$getUrl$JsonMcloud) {
            Mcloud$getUrl$JsonMcloud mcloud$getUrl$JsonMcloud = (Mcloud$getUrl$JsonMcloud) obj;
            return Intrinsics.areEqual(this.status, mcloud$getUrl$JsonMcloud.status) && Intrinsics.areEqual(this.data, mcloud$getUrl$JsonMcloud.data);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.status;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "JsonMcloud(status=" + this.status + ", data=" + this.data + ')';
    }

    public Mcloud$getUrl$JsonMcloud(@JsonProperty("status") Integer num, @JsonProperty("data") Mcloud$getUrl$DataMcloud data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.status = num;
        this.data = data;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public /* synthetic */ Mcloud$getUrl$JsonMcloud(Integer num, Mcloud$getUrl$DataMcloud mcloud$getUrl$DataMcloud, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? new Mcloud$getUrl$DataMcloud(null, 1, null) : mcloud$getUrl$DataMcloud);
    }

    public final Mcloud$getUrl$DataMcloud getData() {
        return this.data;
    }
}
