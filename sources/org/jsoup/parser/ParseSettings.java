package org.jsoup.parser;

import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;

/* loaded from: classes5.dex */
public class ParseSettings {
    public static final ParseSettings htmlDefault = new ParseSettings(false, false);
    public static final ParseSettings preserveCase = new ParseSettings(true, true);
    private final boolean preserveAttributeCase;
    private final boolean preserveTagCase;

    public boolean preserveTagCase() {
        return this.preserveTagCase;
    }

    public boolean preserveAttributeCase() {
        return this.preserveAttributeCase;
    }

    public ParseSettings(boolean z, boolean z2) {
        this.preserveTagCase = z;
        this.preserveAttributeCase = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseSettings(ParseSettings parseSettings) {
        this(parseSettings.preserveTagCase, parseSettings.preserveAttributeCase);
    }

    public String normalizeTag(String str) {
        String trim = str.trim();
        return !this.preserveTagCase ? Normalizer.lowerCase(trim) : trim;
    }

    public String normalizeAttribute(String str) {
        String trim = str.trim();
        return !this.preserveAttributeCase ? Normalizer.lowerCase(trim) : trim;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Attributes normalizeAttributes(Attributes attributes) {
        if (attributes != null && !this.preserveAttributeCase) {
            attributes.normalize();
        }
        return attributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String normalName(String str) {
        return Normalizer.lowerCase(str.trim());
    }
}
