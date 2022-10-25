package com.applovin.impl.sdk.utils;

import android.util.Xml;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/* renamed from: com.applovin.impl.sdk.utils.q */
/* loaded from: classes.dex */
public class C1767q {

    /* renamed from: a */
    private final C1710r f2593a;

    /* renamed from: b */
    private Stack<C1769a> f2594b;

    /* renamed from: c */
    private StringBuilder f2595c;

    /* renamed from: d */
    private long f2596d;

    /* renamed from: e */
    private C1769a f2597e;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.utils.q$a */
    /* loaded from: classes.dex */
    public static class C1769a extends C1766p {
        C1769a(String str, Map<String, String> map, C1766p c1766p) {
            super(str, map, c1766p);
        }

        /* renamed from: a */
        void m6136a(C1766p c1766p) {
            if (c1766p == null) {
                throw new IllegalArgumentException("None specified.");
            }
            this.f2589c.add(c1766p);
        }

        /* renamed from: d */
        void m6135d(String str) {
            this.f2588b = str;
        }
    }

    C1767q(C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f2593a = c1662k.m6588z();
    }

    /* renamed from: a */
    public static C1766p m6142a(String str, C1662k c1662k) throws SAXException {
        return new C1767q(c1662k).m6143a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, String> m6141a(Attributes attributes) {
        if (attributes != null) {
            int length = attributes.getLength();
            HashMap hashMap = new HashMap(length);
            for (int i = 0; i < length; i++) {
                hashMap.put(attributes.getQName(i), attributes.getValue(i));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    /* renamed from: a */
    public C1766p m6143a(String str) throws SAXException {
        if (str != null) {
            this.f2595c = new StringBuilder();
            this.f2594b = new Stack<>();
            this.f2597e = null;
            Xml.parse(str, new ContentHandler() { // from class: com.applovin.impl.sdk.utils.q.1
                @Override // org.xml.sax.ContentHandler
                public void characters(char[] cArr, int i, int i2) {
                    String trim = new String(Arrays.copyOfRange(cArr, i, i2)).trim();
                    if (StringUtils.isValidString(trim)) {
                        C1767q.this.f2595c.append(trim);
                    }
                }

                @Override // org.xml.sax.ContentHandler
                public void endDocument() {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - C1767q.this.f2596d;
                    C1710r c1710r = C1767q.this.f2593a;
                    c1710r.m6319b("XmlParser", "Finished parsing in " + seconds + " seconds");
                }

                @Override // org.xml.sax.ContentHandler
                public void endElement(String str2, String str3, String str4) {
                    C1767q c1767q = C1767q.this;
                    c1767q.f2597e = (C1769a) c1767q.f2594b.pop();
                    C1767q.this.f2597e.m6135d(C1767q.this.f2595c.toString().trim());
                    C1767q.this.f2595c.setLength(0);
                }

                @Override // org.xml.sax.ContentHandler
                public void endPrefixMapping(String str2) {
                }

                @Override // org.xml.sax.ContentHandler
                public void ignorableWhitespace(char[] cArr, int i, int i2) {
                }

                @Override // org.xml.sax.ContentHandler
                public void processingInstruction(String str2, String str3) {
                }

                @Override // org.xml.sax.ContentHandler
                public void setDocumentLocator(Locator locator) {
                }

                @Override // org.xml.sax.ContentHandler
                public void skippedEntity(String str2) {
                }

                @Override // org.xml.sax.ContentHandler
                public void startDocument() {
                    C1767q.this.f2593a.m6319b("XmlParser", "Begin parsing...");
                    C1767q.this.f2596d = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
                }

                @Override // org.xml.sax.ContentHandler
                public void startElement(String str2, String str3, String str4, Attributes attributes) throws SAXException {
                    try {
                        C1769a c1769a = C1767q.this.f2594b.isEmpty() ? null : (C1769a) C1767q.this.f2594b.peek();
                        C1769a c1769a2 = new C1769a(str3, C1767q.this.m6141a(attributes), c1769a);
                        if (c1769a != null) {
                            c1769a.m6136a(c1769a2);
                        }
                        C1767q.this.f2594b.push(c1769a2);
                    } catch (Exception e) {
                        C1710r c1710r = C1767q.this.f2593a;
                        c1710r.m6318b("XmlParser", "Unable to process element <" + str3 + ">", e);
                        throw new SAXException("Failed to start element", e);
                    }
                }

                @Override // org.xml.sax.ContentHandler
                public void startPrefixMapping(String str2, String str3) {
                }
            });
            C1769a c1769a = this.f2597e;
            if (c1769a != null) {
                return c1769a;
            }
            throw new SAXException("Unable to parse XML into node");
        }
        throw new IllegalArgumentException("Unable to parse. No XML specified.");
    }
}
