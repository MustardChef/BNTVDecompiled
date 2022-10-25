package com.phimhd;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/phimhd/ConfigHomeResponseData;", "", "data", "Lcom/phimhd/ConfigHome;", "(Lcom/phimhd/ConfigHome;)V", "getData", "()Lcom/phimhd/ConfigHome;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ConfigHomeResponseData {
    private final ConfigHome data;

    public static /* synthetic */ ConfigHomeResponseData copy$default(ConfigHomeResponseData configHomeResponseData, ConfigHome configHome, int i, Object obj) {
        if ((i & 1) != 0) {
            configHome = configHomeResponseData.data;
        }
        return configHomeResponseData.copy(configHome);
    }

    public final ConfigHome component1() {
        return this.data;
    }

    public final ConfigHomeResponseData copy(@JsonProperty("data") ConfigHome data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new ConfigHomeResponseData(data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConfigHomeResponseData) && Intrinsics.areEqual(this.data, ((ConfigHomeResponseData) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "ConfigHomeResponseData(data=" + this.data + ')';
    }

    public ConfigHomeResponseData(@JsonProperty("data") ConfigHome data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final ConfigHome getData() {
        return this.data;
    }
}
