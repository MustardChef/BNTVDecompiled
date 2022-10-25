package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Supervideo.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/Files;", "", "id", "", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Files {

    /* renamed from: id */
    private final String f9958id;
    private final String label;

    public static /* synthetic */ Files copy$default(Files files, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = files.f9958id;
        }
        if ((i & 2) != 0) {
            str2 = files.label;
        }
        return files.copy(str, str2);
    }

    public final String component1() {
        return this.f9958id;
    }

    public final String component2() {
        return this.label;
    }

    public final Files copy(@JsonProperty("file") String id, @JsonProperty("label") String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new Files(id, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Files) {
            Files files = (Files) obj;
            return Intrinsics.areEqual(this.f9958id, files.f9958id) && Intrinsics.areEqual(this.label, files.label);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f9958id.hashCode() * 31;
        String str = this.label;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Files(id=" + this.f9958id + ", label=" + this.label + ')';
    }

    public Files(@JsonProperty("file") String id, @JsonProperty("label") String str) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f9958id = id;
        this.label = str;
    }

    public /* synthetic */ Files(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getId() {
        return this.f9958id;
    }

    public final String getLabel() {
        return this.label;
    }
}
