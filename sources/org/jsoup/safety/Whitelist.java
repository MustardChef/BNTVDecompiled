package org.jsoup.safety;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

@Deprecated
/* loaded from: classes5.dex */
public class Whitelist extends Safelist {
    public Whitelist() {
    }

    public Whitelist(Safelist safelist) {
        super(safelist);
    }

    public static Whitelist basic() {
        return new Whitelist(Safelist.basic());
    }

    public static Whitelist basicWithImages() {
        return new Whitelist(Safelist.basicWithImages());
    }

    public static Whitelist none() {
        return new Whitelist(Safelist.none());
    }

    public static Whitelist relaxed() {
        return new Whitelist(Safelist.relaxed());
    }

    public static Whitelist simpleText() {
        return new Whitelist(Safelist.simpleText());
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist addTags(String... strArr) {
        super.addTags(strArr);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist removeTags(String... strArr) {
        super.removeTags(strArr);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist addAttributes(String str, String... strArr) {
        super.addAttributes(str, strArr);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist removeAttributes(String str, String... strArr) {
        super.removeAttributes(str, strArr);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist addEnforcedAttribute(String str, String str2, String str3) {
        super.addEnforcedAttribute(str, str2, str3);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist removeEnforcedAttribute(String str, String str2) {
        super.removeEnforcedAttribute(str, str2);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist preserveRelativeLinks(boolean z) {
        super.preserveRelativeLinks(z);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist addProtocols(String str, String str2, String... strArr) {
        super.addProtocols(str, str2, strArr);
        return this;
    }

    @Override // org.jsoup.safety.Safelist
    public Whitelist removeProtocols(String str, String str2, String... strArr) {
        super.removeProtocols(str, str2, strArr);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.safety.Safelist
    public boolean isSafeTag(String str) {
        return super.isSafeTag(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.safety.Safelist
    public boolean isSafeAttribute(String str, Element element, Attribute attribute) {
        return super.isSafeAttribute(str, element, attribute);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.safety.Safelist
    public Attributes getEnforcedAttributes(String str) {
        return super.getEnforcedAttributes(str);
    }
}
