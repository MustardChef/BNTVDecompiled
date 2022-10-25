package org.jsoup.nodes;

import java.util.List;
import org.jsoup.helper.Validate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class LeafNode extends Node {
    Object value;

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return 0;
    }

    @Override // org.jsoup.nodes.Node
    protected void doSetBaseUri(String str) {
    }

    @Override // org.jsoup.nodes.Node
    public Node empty() {
        return this;
    }

    @Override // org.jsoup.nodes.Node
    protected final boolean hasAttributes() {
        return this.value instanceof Attributes;
    }

    @Override // org.jsoup.nodes.Node
    public final Attributes attributes() {
        ensureAttributes();
        return (Attributes) this.value;
    }

    private void ensureAttributes() {
        if (hasAttributes()) {
            return;
        }
        Object obj = this.value;
        Attributes attributes = new Attributes();
        this.value = attributes;
        if (obj != null) {
            attributes.put(nodeName(), (String) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String coreValue() {
        return attr(nodeName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void coreValue(String str) {
        attr(nodeName(), str);
    }

    @Override // org.jsoup.nodes.Node
    public String attr(String str) {
        Validate.notNull(str);
        if (hasAttributes()) {
            return super.attr(str);
        }
        return str.equals(nodeName()) ? (String) this.value : "";
    }

    @Override // org.jsoup.nodes.Node
    public Node attr(String str, String str2) {
        if (!hasAttributes() && str.equals(nodeName())) {
            this.value = str2;
        } else {
            ensureAttributes();
            super.attr(str, str2);
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public boolean hasAttr(String str) {
        ensureAttributes();
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public Node removeAttr(String str) {
        ensureAttributes();
        return super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public String absUrl(String str) {
        ensureAttributes();
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return hasParent() ? parent().baseUri() : "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        return EmptyNodes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public LeafNode doClone(Node node) {
        LeafNode leafNode = (LeafNode) super.doClone(node);
        if (hasAttributes()) {
            leafNode.value = ((Attributes) this.value).clone();
        }
        return leafNode;
    }
}
