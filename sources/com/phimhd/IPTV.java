package com.phimhd;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0001\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003JK\u0010\u0016\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, m107d2 = {"Lcom/phimhd/IPTV;", "", "id", "", "title", "thumbnail", "userAgent", "link", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getLink", "()Ljava/util/List;", "getThumbnail", "getTitle", "getUserAgent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class IPTV {

    /* renamed from: id */
    private final String f10040id;
    private final List<String> link;
    private final String thumbnail;
    private final String title;
    private final String userAgent;

    public static /* synthetic */ IPTV copy$default(IPTV iptv, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iptv.f10040id;
        }
        if ((i & 2) != 0) {
            str2 = iptv.title;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = iptv.thumbnail;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = iptv.userAgent;
        }
        String str7 = str4;
        List<String> list2 = list;
        if ((i & 16) != 0) {
            list2 = iptv.link;
        }
        return iptv.copy(str, str5, str6, str7, list2);
    }

    public final String component1() {
        return this.f10040id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.thumbnail;
    }

    public final String component4() {
        return this.userAgent;
    }

    public final List<String> component5() {
        return this.link;
    }

    public final IPTV copy(@JsonProperty("id") String str, @JsonProperty("title") String str2, @JsonProperty("thumbnail") String str3, @JsonProperty("userAgent") String str4, @JsonProperty("link") List<String> list) {
        return new IPTV(str, str2, str3, str4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IPTV) {
            IPTV iptv = (IPTV) obj;
            return Intrinsics.areEqual(this.f10040id, iptv.f10040id) && Intrinsics.areEqual(this.title, iptv.title) && Intrinsics.areEqual(this.thumbnail, iptv.thumbnail) && Intrinsics.areEqual(this.userAgent, iptv.userAgent) && Intrinsics.areEqual(this.link, iptv.link);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f10040id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnail;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userAgent;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<String> list = this.link;
        return hashCode4 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "IPTV(id=" + this.f10040id + ", title=" + this.title + ", thumbnail=" + this.thumbnail + ", userAgent=" + this.userAgent + ", link=" + this.link + ')';
    }

    public IPTV(@JsonProperty("id") String str, @JsonProperty("title") String str2, @JsonProperty("thumbnail") String str3, @JsonProperty("userAgent") String str4, @JsonProperty("link") List<String> list) {
        this.f10040id = str;
        this.title = str2;
        this.thumbnail = str3;
        this.userAgent = str4;
        this.link = list;
    }

    public final String getId() {
        return this.f10040id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public final List<String> getLink() {
        return this.link;
    }
}
