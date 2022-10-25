package org.jsoup.nodes;

import com.facebook.internal.ServerProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import javax.annotation.Nullable;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

/* loaded from: classes5.dex */
public class Document extends Element {
    private static final Evaluator titleEval = new Evaluator.Tag("title");
    @Nullable
    private Connection connection;
    private final String location;
    private OutputSettings outputSettings;
    private Parser parser;
    private QuirksMode quirksMode;
    private boolean updateMetaCharset;

    /* loaded from: classes5.dex */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.updateMetaCharset = false;
        this.location = str;
        this.parser = Parser.htmlParser();
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        document.parser = document.parser();
        Element appendElement = document.appendElement("html");
        appendElement.appendElement(TtmlNode.TAG_HEAD);
        appendElement.appendElement("body");
        return document;
    }

    public String location() {
        return this.location;
    }

    public Connection connection() {
        Connection connection = this.connection;
        return connection == null ? Jsoup.newSession() : connection;
    }

    @Nullable
    public DocumentType documentType() {
        for (Node node : this.childNodes) {
            if (node instanceof DocumentType) {
                return (DocumentType) node;
            }
            if (!(node instanceof LeafNode)) {
                return null;
            }
        }
        return null;
    }

    private Element htmlEl() {
        for (Element element : childElementsList()) {
            if (element.normalName().equals("html")) {
                return element;
            }
        }
        return appendElement("html");
    }

    public Element head() {
        Element htmlEl = htmlEl();
        for (Element element : htmlEl.childElementsList()) {
            if (element.normalName().equals(TtmlNode.TAG_HEAD)) {
                return element;
            }
        }
        return htmlEl.prependElement(TtmlNode.TAG_HEAD);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jsoup.nodes.Element body() {
        /*
            r5 = this;
            org.jsoup.nodes.Element r0 = r5.htmlEl()
            java.util.List r1 = r0.childElementsList()
            java.util.Iterator r1 = r1.iterator()
        Lc:
            boolean r2 = r1.hasNext()
            java.lang.String r3 = "body"
            if (r2 == 0) goto L31
            java.lang.Object r2 = r1.next()
            org.jsoup.nodes.Element r2 = (org.jsoup.nodes.Element) r2
            java.lang.String r4 = r2.normalName()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L30
            java.lang.String r3 = r2.normalName()
            java.lang.String r4 = "frameset"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto Lc
        L30:
            return r2
        L31:
            org.jsoup.nodes.Element r0 = r0.appendElement(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Document.body():org.jsoup.nodes.Element");
    }

    public String title() {
        Element selectFirst = head().selectFirst(titleEval);
        return selectFirst != null ? StringUtil.normaliseWhitespace(selectFirst.text()).trim() : "";
    }

    public void title(String str) {
        Validate.notNull(str);
        Element selectFirst = head().selectFirst(titleEval);
        if (selectFirst == null) {
            selectFirst = head().appendElement("title");
        }
        selectFirst.text(str);
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str, ParseSettings.preserveCase), baseUri());
    }

    public Document normalise() {
        Element htmlEl = htmlEl();
        Element head = head();
        body();
        normaliseTextNodes(head);
        normaliseTextNodes(htmlEl);
        normaliseTextNodes(this);
        normaliseStructure(TtmlNode.TAG_HEAD, htmlEl);
        normaliseStructure("body", htmlEl);
        ensureMetaCharsetElement();
        return this;
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(" "));
            body().prependChild(node2);
        }
    }

    private void normaliseStructure(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element first = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList<Node> arrayList = new ArrayList();
            for (int i = 1; i < elementsByTag.size(); i++) {
                Element element2 = elementsByTag.get(i);
                arrayList.addAll(element2.ensureChildNodes());
                element2.remove();
            }
            for (Node node : arrayList) {
                first.appendChild(node);
            }
        }
        if (first.parent() == null || first.parent().equals(element)) {
            return;
        }
        element.appendChild(first);
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    @Override // org.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }

    public Charset charset() {
        return this.outputSettings.charset();
    }

    public void updateMetaCharsetElement(boolean z) {
        this.updateMetaCharset = z;
    }

    public boolean updateMetaCharsetElement() {
        return this.updateMetaCharset;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public Document clone() {
        Document document = (Document) super.clone();
        document.outputSettings = this.outputSettings.clone();
        return document;
    }

    private void ensureMetaCharsetElement() {
        if (this.updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element selectFirst = selectFirst("meta[charset]");
                if (selectFirst != null) {
                    selectFirst.attr("charset", charset().displayName());
                } else {
                    head().appendElement("meta").attr("charset", charset().displayName());
                }
                select("meta[name=charset]").remove();
            } else if (syntax == OutputSettings.Syntax.xml) {
                Node node = ensureChildNodes().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration = (XmlDeclaration) node;
                    if (xmlDeclaration.name().equals("xml")) {
                        xmlDeclaration.attr("encoding", charset().displayName());
                        if (xmlDeclaration.hasAttr(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)) {
                            xmlDeclaration.attr(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "1.0");
                            return;
                        }
                        return;
                    }
                    XmlDeclaration xmlDeclaration2 = new XmlDeclaration("xml", false);
                    xmlDeclaration2.attr(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "1.0");
                    xmlDeclaration2.attr("encoding", charset().displayName());
                    prependChild(xmlDeclaration2);
                    return;
                }
                XmlDeclaration xmlDeclaration3 = new XmlDeclaration("xml", false);
                xmlDeclaration3.attr(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "1.0");
                xmlDeclaration3.attr("encoding", charset().displayName());
                prependChild(xmlDeclaration3);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class OutputSettings implements Cloneable {
        @Nullable
        Entities.CoreCharset coreCharset;
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private Charset charset = DataUtil.UTF_8;
        private final ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;
        private Syntax syntax = Syntax.html;

        /* loaded from: classes5.dex */
        public enum Syntax {
            html,
            xml
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public Charset charset() {
            return this.charset;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsetEncoder prepareEncoder() {
            CharsetEncoder newEncoder = this.charset.newEncoder();
            this.encoderThreadLocal.set(newEncoder);
            this.coreCharset = Entities.CoreCharset.byName(newEncoder.charset().name());
            return newEncoder;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsetEncoder encoder() {
            CharsetEncoder charsetEncoder = this.encoderThreadLocal.get();
            return charsetEncoder != null ? charsetEncoder : prepareEncoder();
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public boolean outline() {
            return this.outline;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public OutputSettings indentAmount(int i) {
            Validate.isTrue(i >= 0);
            this.indentAmount = i;
            return this;
        }

        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    public Parser parser() {
        return this.parser;
    }

    public Document parser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public Document connection(Connection connection) {
        Validate.notNull(connection);
        this.connection = connection;
        return this;
    }
}
