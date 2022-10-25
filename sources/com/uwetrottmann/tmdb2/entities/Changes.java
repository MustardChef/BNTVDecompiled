package com.uwetrottmann.tmdb2.entities;

import com.google.gson.JsonElement;

/* loaded from: classes4.dex */
public class Changes {
    public java.util.List<Entries> changes;

    /* loaded from: classes4.dex */
    public static class Change {
        public String action;

        /* renamed from: id */
        public String f10059id;
        public String iso_639_1;
        public JsonElement original_value;
        public String time;
        public JsonElement value;
    }

    /* loaded from: classes4.dex */
    public static class Entries {
        public java.util.List<Change> items;
        public String key;
    }
}
