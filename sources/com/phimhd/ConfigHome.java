package com.phimhd;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigHome.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, m107d2 = {"Lcom/phimhd/ConfigHome;", "", "collections", "", "Lcom/phimhd/Collection;", "listBanners", "Lcom/phimhd/Banner;", "(Ljava/util/List;Ljava/util/List;)V", "getCollections", "()Ljava/util/List;", "getListBanners", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ConfigHome {
    private final List<Collection> collections;
    private final List<Banner> listBanners;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigHome copy$default(ConfigHome configHome, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = configHome.collections;
        }
        if ((i & 2) != 0) {
            list2 = configHome.listBanners;
        }
        return configHome.copy(list, list2);
    }

    public final List<Collection> component1() {
        return this.collections;
    }

    public final List<Banner> component2() {
        return this.listBanners;
    }

    public final ConfigHome copy(@JsonProperty("collections") List<Collection> collections, @JsonProperty("listBanners") List<Banner> listBanners) {
        Intrinsics.checkNotNullParameter(collections, "collections");
        Intrinsics.checkNotNullParameter(listBanners, "listBanners");
        return new ConfigHome(collections, listBanners);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConfigHome) {
            ConfigHome configHome = (ConfigHome) obj;
            return Intrinsics.areEqual(this.collections, configHome.collections) && Intrinsics.areEqual(this.listBanners, configHome.listBanners);
        }
        return false;
    }

    public int hashCode() {
        return (this.collections.hashCode() * 31) + this.listBanners.hashCode();
    }

    public String toString() {
        return "ConfigHome(collections=" + this.collections + ", listBanners=" + this.listBanners + ')';
    }

    public ConfigHome(@JsonProperty("collections") List<Collection> collections, @JsonProperty("listBanners") List<Banner> listBanners) {
        Intrinsics.checkNotNullParameter(collections, "collections");
        Intrinsics.checkNotNullParameter(listBanners, "listBanners");
        this.collections = collections;
        this.listBanners = listBanners;
    }

    public final List<Collection> getCollections() {
        return this.collections;
    }

    public final List<Banner> getListBanners() {
        return this.listBanners;
    }
}
