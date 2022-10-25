package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

/* loaded from: classes5.dex */
public class NodeTraversor {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static void traverse(NodeVisitor nodeVisitor, Node node) {
        Validate.notNull(nodeVisitor);
        Validate.notNull(node);
        Node node2 = node;
        int i = 0;
        while (node2 != null) {
            Node parentNode = node2.parentNode();
            nodeVisitor.head(node2, i);
            if (parentNode != null && !node2.hasParent()) {
                node2 = parentNode.childNode(node2.siblingIndex());
            }
            if (node2.childNodeSize() > 0) {
                node2 = node2.childNode(0);
                i++;
            } else {
                while (node2.nextSibling() == null && i > 0) {
                    nodeVisitor.tail(node2, i);
                    node2 = node2.parentNode();
                    i--;
                }
                nodeVisitor.tail(node2, i);
                if (node2 == node) {
                    return;
                }
                node2 = node2.nextSibling();
            }
        }
    }

    public static void traverse(NodeVisitor nodeVisitor, Elements elements) {
        Validate.notNull(nodeVisitor);
        Validate.notNull(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            traverse(nodeVisitor, it.next());
        }
    }

    public static NodeFilter.FilterResult filter(NodeFilter nodeFilter, Node node) {
        Node node2 = node;
        int i = 0;
        while (node2 != null) {
            NodeFilter.FilterResult head = nodeFilter.head(node2, i);
            if (head == NodeFilter.FilterResult.STOP) {
                return head;
            }
            if (head == NodeFilter.FilterResult.CONTINUE && node2.childNodeSize() > 0) {
                node2 = node2.childNode(0);
                i++;
            } else {
                while (node2.nextSibling() == null && i > 0) {
                    if ((head == NodeFilter.FilterResult.CONTINUE || head == NodeFilter.FilterResult.SKIP_CHILDREN) && (head = nodeFilter.tail(node2, i)) == NodeFilter.FilterResult.STOP) {
                        return head;
                    }
                    Node parentNode = node2.parentNode();
                    i--;
                    if (head == NodeFilter.FilterResult.REMOVE) {
                        node2.remove();
                    }
                    head = NodeFilter.FilterResult.CONTINUE;
                    node2 = parentNode;
                }
                if ((head == NodeFilter.FilterResult.CONTINUE || head == NodeFilter.FilterResult.SKIP_CHILDREN) && (head = nodeFilter.tail(node2, i)) == NodeFilter.FilterResult.STOP) {
                    return head;
                }
                if (node2 == node) {
                    return head;
                }
                Node nextSibling = node2.nextSibling();
                if (head == NodeFilter.FilterResult.REMOVE) {
                    node2.remove();
                }
                node2 = nextSibling;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void filter(NodeFilter nodeFilter, Elements elements) {
        Validate.notNull(nodeFilter);
        Validate.notNull(elements);
        Iterator<Element> it = elements.iterator();
        while (it.hasNext() && filter(nodeFilter, it.next()) != NodeFilter.FilterResult.STOP) {
        }
    }
}
