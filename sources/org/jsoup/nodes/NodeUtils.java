package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.jsoup.parser.HtmlTreeBuilder;
import org.jsoup.parser.Parser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NodeUtils {
    NodeUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Document.OutputSettings outputSettings(Node node) {
        Document ownerDocument = node.ownerDocument();
        if (ownerDocument == null) {
            ownerDocument = new Document("");
        }
        return ownerDocument.outputSettings();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Parser parser(Node node) {
        Document ownerDocument = node.ownerDocument();
        return (ownerDocument == null || ownerDocument.parser() == null) ? new Parser(new HtmlTreeBuilder()) : ownerDocument.parser();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Node> List<T> selectXpath(String str, Element element, Class<T> cls) {
        Validate.notEmpty(str);
        Validate.notNull(element);
        Validate.notNull(cls);
        W3CDom w3CDom = new W3CDom();
        return w3CDom.sourceNodes(w3CDom.selectXpath(str, w3CDom.fromJsoup(element)), cls);
    }
}
