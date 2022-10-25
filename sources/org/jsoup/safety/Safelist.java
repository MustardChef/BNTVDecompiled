package org.jsoup.safety;

import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

/* loaded from: classes5.dex */
public class Safelist {
    private Map<TagName, Set<AttributeKey>> attributes;
    private Map<TagName, Map<AttributeKey, AttributeValue>> enforcedAttributes;
    private boolean preserveRelativeLinks;
    private Map<TagName, Map<AttributeKey, Set<Protocol>>> protocols;
    private Set<TagName> tagNames;

    public static Safelist none() {
        return new Safelist();
    }

    public static Safelist simpleText() {
        return new Safelist().addTags("b", UserDataStore.EMAIL, "i", "strong", "u");
    }

    public static Safelist basic() {
        return new Safelist().addTags("a", "b", "blockquote", TtmlNode.TAG_BR, "cite", "code", "dd", "dl", "dt", UserDataStore.EMAIL, "i", "li", "ol", TtmlNode.TAG_P, "pre", "q", "small", TtmlNode.TAG_SPAN, "strike", "strong", "sub", "sup", "u", "ul").addAttributes("a", ShareConstants.WEB_DIALOG_PARAM_HREF).addAttributes("blockquote", "cite").addAttributes("q", "cite").addProtocols("a", ShareConstants.WEB_DIALOG_PARAM_HREF, "ftp", "http", "https", "mailto").addProtocols("blockquote", "cite", "http", "https").addProtocols("cite", "cite", "http", "https").addEnforcedAttribute("a", "rel", "nofollow");
    }

    public static Safelist basicWithImages() {
        return basic().addTags("img").addAttributes("img", "align", "alt", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "src", "title", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addProtocols("img", "src", "http", "https");
    }

    public static Safelist relaxed() {
        return new Safelist().addTags("a", "b", "blockquote", TtmlNode.TAG_BR, "caption", "cite", "code", "col", "colgroup", "dd", TtmlNode.TAG_DIV, "dl", "dt", UserDataStore.EMAIL, "h1", "h2", "h3", "h4", "h5", "h6", "i", "img", "li", "ol", TtmlNode.TAG_P, "pre", "q", "small", TtmlNode.TAG_SPAN, "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", "ul").addAttributes("a", ShareConstants.WEB_DIALOG_PARAM_HREF, "title").addAttributes("blockquote", "cite").addAttributes("col", TtmlNode.TAG_SPAN, ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("colgroup", TtmlNode.TAG_SPAN, ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("img", "align", "alt", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "src", "title", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("ol", TtmlNode.START, "type").addAttributes("q", "cite").addAttributes("table", "summary", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("td", "abbr", "axis", "colspan", "rowspan", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("th", "abbr", "axis", "colspan", "rowspan", "scope", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("ul", "type").addProtocols("a", ShareConstants.WEB_DIALOG_PARAM_HREF, "ftp", "http", "https", "mailto").addProtocols("blockquote", "cite", "http", "https").addProtocols("cite", "cite", "http", "https").addProtocols("img", "src", "http", "https").addProtocols("q", "cite", "http", "https");
    }

    public Safelist() {
        this.tagNames = new HashSet();
        this.attributes = new HashMap();
        this.enforcedAttributes = new HashMap();
        this.protocols = new HashMap();
        this.preserveRelativeLinks = false;
    }

    public Safelist(Safelist safelist) {
        this();
        this.tagNames.addAll(safelist.tagNames);
        this.attributes.putAll(safelist.attributes);
        this.enforcedAttributes.putAll(safelist.enforcedAttributes);
        this.protocols.putAll(safelist.protocols);
        this.preserveRelativeLinks = safelist.preserveRelativeLinks;
    }

    public Safelist addTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            this.tagNames.add(TagName.valueOf(str));
        }
        return this;
    }

    public Safelist removeTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            TagName valueOf = TagName.valueOf(str);
            if (this.tagNames.remove(valueOf)) {
                this.attributes.remove(valueOf);
                this.enforcedAttributes.remove(valueOf);
                this.protocols.remove(valueOf);
            }
        }
        return this;
    }

    public Safelist addAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        TagName valueOf = TagName.valueOf(str);
        this.tagNames.add(valueOf);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.attributes.containsKey(valueOf)) {
            this.attributes.get(valueOf).addAll(hashSet);
        } else {
            this.attributes.put(valueOf, hashSet);
        }
        return this;
    }

    public Safelist removeAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        TagName valueOf = TagName.valueOf(str);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(AttributeKey.valueOf(str2));
        }
        if (this.tagNames.contains(valueOf) && this.attributes.containsKey(valueOf)) {
            Set<AttributeKey> set = this.attributes.get(valueOf);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.attributes.remove(valueOf);
            }
        }
        if (str.equals(":all")) {
            for (TagName tagName : this.attributes.keySet()) {
                Set<AttributeKey> set2 = this.attributes.get(tagName);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.attributes.remove(tagName);
                }
            }
        }
        return this;
    }

    public Safelist addEnforcedAttribute(String str, String str2, String str3) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notEmpty(str3);
        TagName valueOf = TagName.valueOf(str);
        this.tagNames.add(valueOf);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        AttributeValue valueOf3 = AttributeValue.valueOf(str3);
        if (this.enforcedAttributes.containsKey(valueOf)) {
            this.enforcedAttributes.get(valueOf).put(valueOf2, valueOf3);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(valueOf2, valueOf3);
            this.enforcedAttributes.put(valueOf, hashMap);
        }
        return this;
    }

    public Safelist removeEnforcedAttribute(String str, String str2) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        TagName valueOf = TagName.valueOf(str);
        if (this.tagNames.contains(valueOf) && this.enforcedAttributes.containsKey(valueOf)) {
            AttributeKey valueOf2 = AttributeKey.valueOf(str2);
            Map<AttributeKey, AttributeValue> map = this.enforcedAttributes.get(valueOf);
            map.remove(valueOf2);
            if (map.isEmpty()) {
                this.enforcedAttributes.remove(valueOf);
            }
        }
        return this;
    }

    public Safelist preserveRelativeLinks(boolean z) {
        this.preserveRelativeLinks = z;
        return this;
    }

    public Safelist addProtocols(String str, String str2, String... strArr) {
        Map<AttributeKey, Set<Protocol>> map;
        Set<Protocol> set;
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        if (this.protocols.containsKey(valueOf)) {
            map = this.protocols.get(valueOf);
        } else {
            HashMap hashMap = new HashMap();
            this.protocols.put(valueOf, hashMap);
            map = hashMap;
        }
        if (map.containsKey(valueOf2)) {
            set = map.get(valueOf2);
        } else {
            HashSet hashSet = new HashSet();
            map.put(valueOf2, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.add(Protocol.valueOf(str3));
        }
        return this;
    }

    public Safelist removeProtocols(String str, String str2, String... strArr) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(str2);
        Validate.isTrue(this.protocols.containsKey(valueOf), "Cannot remove a protocol that is not set.");
        Map<AttributeKey, Set<Protocol>> map = this.protocols.get(valueOf);
        Validate.isTrue(map.containsKey(valueOf2), "Cannot remove a protocol that is not set.");
        Set<Protocol> set = map.get(valueOf2);
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.remove(Protocol.valueOf(str3));
        }
        if (set.isEmpty()) {
            map.remove(valueOf2);
            if (map.isEmpty()) {
                this.protocols.remove(valueOf);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSafeTag(String str) {
        return this.tagNames.contains(TagName.valueOf(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSafeAttribute(String str, Element element, Attribute attribute) {
        TagName valueOf = TagName.valueOf(str);
        AttributeKey valueOf2 = AttributeKey.valueOf(attribute.getKey());
        Set<AttributeKey> set = this.attributes.get(valueOf);
        if (set != null && set.contains(valueOf2)) {
            if (this.protocols.containsKey(valueOf)) {
                Map<AttributeKey, Set<Protocol>> map = this.protocols.get(valueOf);
                return !map.containsKey(valueOf2) || testValidProtocol(element, attribute, map.get(valueOf2));
            }
            return true;
        }
        if (this.enforcedAttributes.get(valueOf) != null) {
            Attributes enforcedAttributes = getEnforcedAttributes(str);
            String key = attribute.getKey();
            if (enforcedAttributes.hasKeyIgnoreCase(key)) {
                return enforcedAttributes.getIgnoreCase(key).equals(attribute.getValue());
            }
        }
        return !str.equals(":all") && isSafeAttribute(":all", element, attribute);
    }

    private boolean testValidProtocol(Element element, Attribute attribute, Set<Protocol> set) {
        String absUrl = element.absUrl(attribute.getKey());
        if (absUrl.length() == 0) {
            absUrl = attribute.getValue();
        }
        if (!this.preserveRelativeLinks) {
            attribute.setValue(absUrl);
        }
        for (Protocol protocol : set) {
            String protocol2 = protocol.toString();
            if (protocol2.equals("#")) {
                if (isValidAnchor(absUrl)) {
                    return true;
                }
            } else {
                if (Normalizer.lowerCase(absUrl).startsWith(protocol2 + ":")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidAnchor(String str) {
        return str.startsWith("#") && !str.matches(".*\\s.*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Attributes getEnforcedAttributes(String str) {
        Attributes attributes = new Attributes();
        TagName valueOf = TagName.valueOf(str);
        if (this.enforcedAttributes.containsKey(valueOf)) {
            for (Map.Entry<AttributeKey, AttributeValue> entry : this.enforcedAttributes.get(valueOf).entrySet()) {
                attributes.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        return attributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class TagName extends TypedValue {
        TagName(String str) {
            super(str);
        }

        static TagName valueOf(String str) {
            return new TagName(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AttributeKey extends TypedValue {
        AttributeKey(String str) {
            super(str);
        }

        static AttributeKey valueOf(String str) {
            return new AttributeKey(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AttributeValue extends TypedValue {
        AttributeValue(String str) {
            super(str);
        }

        static AttributeValue valueOf(String str) {
            return new AttributeValue(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Protocol extends TypedValue {
        Protocol(String str) {
            super(str);
        }

        static Protocol valueOf(String str) {
            return new Protocol(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class TypedValue {
        private String value;

        TypedValue(String str) {
            Validate.notNull(str);
            this.value = str;
        }

        public int hashCode() {
            String str = this.value;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                TypedValue typedValue = (TypedValue) obj;
                String str = this.value;
                if (str == null) {
                    return typedValue.value == null;
                }
                return str.equals(typedValue.value);
            }
            return false;
        }

        public String toString() {
            return this.value;
        }
    }
}
