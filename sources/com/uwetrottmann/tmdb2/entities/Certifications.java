package com.uwetrottmann.tmdb2.entities;

import java.util.HashMap;

/* loaded from: classes4.dex */
public class Certifications {
    public HashMap<String, java.util.List<Certification>> certifications;

    /* loaded from: classes4.dex */
    public static class Certification {
        public String certification;
        public String meaning;
        public Integer order;
    }
}
