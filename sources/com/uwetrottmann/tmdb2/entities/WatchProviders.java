package com.uwetrottmann.tmdb2.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

/* loaded from: classes4.dex */
public class WatchProviders {

    /* renamed from: id */
    public Integer f10083id;
    @Nonnull
    public Map<String, CountryInfo> results = new HashMap();

    /* loaded from: classes4.dex */
    public static class CountryInfo {
        public String link;
        @Nonnull
        public java.util.List<WatchProvider> flatrate = new ArrayList();
        @Nonnull
        public java.util.List<WatchProvider> free = new ArrayList();
        @Nonnull
        public java.util.List<WatchProvider> ads = new ArrayList();
        @Nonnull
        public java.util.List<WatchProvider> buy = new ArrayList();
    }

    /* loaded from: classes4.dex */
    public static class WatchProvider {
        public Integer display_priority;
        public String logo_path;
        public Integer provider_id;
        public String provider_name;
    }
}
