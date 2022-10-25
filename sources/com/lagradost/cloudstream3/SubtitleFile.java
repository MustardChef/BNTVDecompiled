package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\bJ.\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/SubtitleFile;", "", "lang", "", "url", "isZipUrl", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLang", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/lagradost/cloudstream3/SubtitleFile;", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SubtitleFile {
    private final Boolean isZipUrl;
    private final String lang;
    private final String url;

    public static /* synthetic */ SubtitleFile copy$default(SubtitleFile subtitleFile, String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitleFile.lang;
        }
        if ((i & 2) != 0) {
            str2 = subtitleFile.url;
        }
        if ((i & 4) != 0) {
            bool = subtitleFile.isZipUrl;
        }
        return subtitleFile.copy(str, str2, bool);
    }

    public final String component1() {
        return this.lang;
    }

    public final String component2() {
        return this.url;
    }

    public final Boolean component3() {
        return this.isZipUrl;
    }

    public final SubtitleFile copy(String lang, String url, Boolean bool) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(url, "url");
        return new SubtitleFile(lang, url, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SubtitleFile) {
            SubtitleFile subtitleFile = (SubtitleFile) obj;
            return Intrinsics.areEqual(this.lang, subtitleFile.lang) && Intrinsics.areEqual(this.url, subtitleFile.url) && Intrinsics.areEqual(this.isZipUrl, subtitleFile.isZipUrl);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.lang.hashCode() * 31) + this.url.hashCode()) * 31;
        Boolean bool = this.isZipUrl;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "SubtitleFile(lang=" + this.lang + ", url=" + this.url + ", isZipUrl=" + this.isZipUrl + ')';
    }

    public SubtitleFile(String lang, String url, Boolean bool) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(url, "url");
        this.lang = lang;
        this.url = url;
        this.isZipUrl = bool;
    }

    public /* synthetic */ SubtitleFile(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : bool);
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean isZipUrl() {
        return this.isZipUrl;
    }
}
