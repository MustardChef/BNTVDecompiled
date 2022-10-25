package org.jsoup.parser;

import javax.annotation.Nullable;
import okio.Utf8;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class Token {
    TokenType type;

    /* loaded from: classes5.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Token reset();

    private Token() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String tokenType() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* loaded from: classes5.dex */
    static final class Doctype extends Token {
        boolean forceQuirks;
        final StringBuilder name;
        String pubSysKey;
        final StringBuilder publicIdentifier;
        final StringBuilder systemIdentifier;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Doctype() {
            super();
            this.name = new StringBuilder();
            this.pubSysKey = null;
            this.publicIdentifier = new StringBuilder();
            this.systemIdentifier = new StringBuilder();
            this.forceQuirks = false;
            this.type = TokenType.Doctype;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            reset(this.name);
            this.pubSysKey = null;
            reset(this.publicIdentifier);
            reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getName() {
            return this.name.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getPubSysKey() {
            return this.pubSysKey;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getPublicIdentifier() {
            return this.publicIdentifier.toString();
        }

        public String getSystemIdentifier() {
            return this.systemIdentifier.toString();
        }

        public boolean isForceQuirks() {
            return this.forceQuirks;
        }

        public String toString() {
            return "<!doctype " + getName() + ">";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class Tag extends Token {
        private static final int MaxAttributes = 512;
        private final StringBuilder attrName;
        @Nullable
        private String attrNameS;
        private final StringBuilder attrValue;
        @Nullable
        private String attrValueS;
        @Nullable
        Attributes attributes;
        private boolean hasAttrName;
        private boolean hasAttrValue;
        private boolean hasEmptyAttrValue;
        @Nullable
        protected String normalName;
        boolean selfClosing;
        @Nullable
        protected String tagName;

        public abstract String toString();

        Tag() {
            super();
            this.attrName = new StringBuilder();
            this.hasAttrName = false;
            this.attrValue = new StringBuilder();
            this.hasAttrValue = false;
            this.hasEmptyAttrValue = false;
            this.selfClosing = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Tag reset() {
            this.tagName = null;
            this.normalName = null;
            reset(this.attrName);
            this.attrNameS = null;
            this.hasAttrName = false;
            reset(this.attrValue);
            this.attrValueS = null;
            this.hasEmptyAttrValue = false;
            this.hasAttrValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void newAttribute() {
            String str;
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            if (this.hasAttrName && this.attributes.size() < 512) {
                String trim = (this.attrName.length() > 0 ? this.attrName.toString() : this.attrNameS).trim();
                if (trim.length() > 0) {
                    if (this.hasAttrValue) {
                        str = this.attrValue.length() > 0 ? this.attrValue.toString() : this.attrValueS;
                    } else {
                        str = this.hasEmptyAttrValue ? "" : null;
                    }
                    this.attributes.add(trim, str);
                }
            }
            reset(this.attrName);
            this.attrNameS = null;
            this.hasAttrName = false;
            reset(this.attrValue);
            this.attrValueS = null;
            this.hasAttrValue = false;
            this.hasEmptyAttrValue = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean hasAttributes() {
            return this.attributes != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean hasAttribute(String str) {
            Attributes attributes = this.attributes;
            return attributes != null && attributes.hasKey(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void finaliseTag() {
            if (this.hasAttrName) {
                newAttribute();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String normalName() {
            return this.normalName;
        }

        final String toStringName() {
            String str = this.tagName;
            return str != null ? str : "[unset]";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final Tag name(String str) {
            this.tagName = str;
            this.normalName = ParseSettings.normalName(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean isSelfClosing() {
            return this.selfClosing;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(String str) {
            String replace = str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER);
            String str2 = this.tagName;
            if (str2 != null) {
                replace = str2.concat(replace);
            }
            this.tagName = replace;
            this.normalName = ParseSettings.normalName(replace);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(char c) {
            appendTagName(String.valueOf(c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(String str) {
            String replace = str.replace((char) 0, Utf8.REPLACEMENT_CHARACTER);
            ensureAttrName();
            if (this.attrName.length() == 0) {
                this.attrNameS = replace;
            } else {
                this.attrName.append(replace);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(char c) {
            ensureAttrName();
            this.attrName.append(c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(String str) {
            ensureAttrValue();
            if (this.attrValue.length() == 0) {
                this.attrValueS = str;
            } else {
                this.attrValue.append(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(char c) {
            ensureAttrValue();
            this.attrValue.append(c);
        }

        final void appendAttributeValue(char[] cArr) {
            ensureAttrValue();
            this.attrValue.append(cArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(int[] iArr) {
            ensureAttrValue();
            for (int i : iArr) {
                this.attrValue.appendCodePoint(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void setEmptyAttributeValue() {
            this.hasEmptyAttrValue = true;
        }

        private void ensureAttrName() {
            this.hasAttrName = true;
            String str = this.attrNameS;
            if (str != null) {
                this.attrName.append(str);
                this.attrNameS = null;
            }
        }

        private void ensureAttrValue() {
            this.hasAttrValue = true;
            String str = this.attrValueS;
            if (str != null) {
                this.attrValue.append(str);
                this.attrValueS = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class StartTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public StartTag() {
            this.type = TokenType.StartTag;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token.Tag, org.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.attributes = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public StartTag nameAttr(String str, Attributes attributes) {
            this.tagName = str;
            this.attributes = attributes;
            this.normalName = ParseSettings.normalName(this.tagName);
            return this;
        }

        @Override // org.jsoup.parser.Token.Tag
        public String toString() {
            if (hasAttributes() && this.attributes.size() > 0) {
                return "<" + toStringName() + " " + this.attributes.toString() + ">";
            }
            return "<" + toStringName() + ">";
        }
    }

    /* loaded from: classes5.dex */
    static final class EndTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EndTag() {
            this.type = TokenType.EndTag;
        }

        @Override // org.jsoup.parser.Token.Tag
        public String toString() {
            return "</" + toStringName() + ">";
        }
    }

    /* loaded from: classes5.dex */
    static final class Comment extends Token {
        boolean bogus;
        private final StringBuilder data;
        private String dataS;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token reset() {
            reset(this.data);
            this.dataS = null;
            this.bogus = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment() {
            super();
            this.data = new StringBuilder();
            this.bogus = false;
            this.type = TokenType.Comment;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getData() {
            String str = this.dataS;
            return str != null ? str : this.data.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final Comment append(String str) {
            ensureData();
            if (this.data.length() == 0) {
                this.dataS = str;
            } else {
                this.data.append(str);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final Comment append(char c) {
            ensureData();
            this.data.append(c);
            return this;
        }

        private void ensureData() {
            String str = this.dataS;
            if (str != null) {
                this.data.append(str);
                this.dataS = null;
            }
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    /* loaded from: classes5.dex */
    static class Character extends Token {
        private String data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character() {
            super();
            this.type = TokenType.Character;
        }

        @Override // org.jsoup.parser.Token
        Token reset() {
            this.data = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character data(String str) {
            this.data = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getData() {
            return this.data;
        }

        public String toString() {
            return getData();
        }
    }

    /* loaded from: classes5.dex */
    static final class CData extends Character {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CData(String str) {
            data(str);
        }

        @Override // org.jsoup.parser.Token.Character
        public String toString() {
            return "<![CDATA[" + getData() + "]]>";
        }
    }

    /* loaded from: classes5.dex */
    static final class EOF extends Token {
        @Override // org.jsoup.parser.Token
        Token reset() {
            return this;
        }

        public String toString() {
            return "";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EOF() {
            super();
            this.type = TokenType.EOF;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isDoctype() {
        return this.type == TokenType.Doctype;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Doctype asDoctype() {
        return (Doctype) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isStartTag() {
        return this.type == TokenType.StartTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final StartTag asStartTag() {
        return (StartTag) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEndTag() {
        return this.type == TokenType.EndTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final EndTag asEndTag() {
        return (EndTag) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isComment() {
        return this.type == TokenType.Comment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Comment asComment() {
        return (Comment) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isCharacter() {
        return this.type == TokenType.Character;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isCData() {
        return this instanceof CData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Character asCharacter() {
        return (Character) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isEOF() {
        return this.type == TokenType.EOF;
    }
}
