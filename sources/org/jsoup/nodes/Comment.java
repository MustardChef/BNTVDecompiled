package org.jsoup.nodes;

import java.io.IOException;
import javax.annotation.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;

/* loaded from: classes5.dex */
public class Comment extends LeafNode {
    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.LeafNode, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public Comment(String str) {
        this.value = str;
    }

    public String getData() {
        return coreValue();
    }

    public Comment setData(String str) {
        coreValue(str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && ((siblingIndex() == 0 && (this.parentNode instanceof Element) && ((Element) this.parentNode).tag().formatAsBlock()) || outputSettings.outline())) {
            indent(appendable, i, outputSettings);
        }
        appendable.append("<!--").append(getData()).append("-->");
    }

    @Override // org.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // org.jsoup.nodes.Node
    public Comment clone() {
        return (Comment) super.clone();
    }

    public boolean isXmlDeclaration() {
        return isXmlDeclarationData(getData());
    }

    private static boolean isXmlDeclarationData(String str) {
        return str.length() > 1 && (str.startsWith("!") || str.startsWith("?"));
    }

    @Nullable
    public XmlDeclaration asXmlDeclaration() {
        String data = getData();
        String substring = data.substring(1, data.length() - 1);
        if (isXmlDeclarationData(substring)) {
            return null;
        }
        Document parseInput = Parser.htmlParser().settings(ParseSettings.preserveCase).parseInput("<" + substring + ">", baseUri());
        if (parseInput.body().children().size() > 0) {
            Element child = parseInput.body().child(0);
            XmlDeclaration xmlDeclaration = new XmlDeclaration(NodeUtils.parser(parseInput).settings().normalizeTag(child.tagName()), data.startsWith("!"));
            xmlDeclaration.attributes().addAll(child.attributes());
            return xmlDeclaration;
        }
        return null;
    }
}
