package org.jsoup.select;

import javax.annotation.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.NodeFilter;

/* loaded from: classes5.dex */
public class Collector {
    private Collector() {
    }

    public static Elements collect(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        NodeTraversor.traverse(new Accumulator(element, elements, evaluator), element);
        return elements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Accumulator implements NodeVisitor {
        private final Elements elements;
        private final Evaluator eval;
        private final Element root;

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
        }

        Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.root = element;
            this.elements = elements;
            this.eval = evaluator;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.eval.matches(this.root, element)) {
                    this.elements.add(element);
                }
            }
        }
    }

    @Nullable
    public static Element findFirst(Evaluator evaluator, Element element) {
        return new FirstFinder(evaluator).find(element, element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class FirstFinder implements NodeFilter {
        private final Evaluator eval;
        @Nullable
        private Element evalRoot = null;
        @Nullable
        private Element match = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FirstFinder(Evaluator evaluator) {
            this.eval = evaluator;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Nullable
        public Element find(Element element, Element element2) {
            this.evalRoot = element;
            this.match = null;
            NodeTraversor.filter(this, element2);
            return this.match;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.eval.matches(this.evalRoot, element)) {
                    this.match = element;
                    return NodeFilter.FilterResult.STOP;
                }
            }
            return NodeFilter.FilterResult.CONTINUE;
        }

        @Override // org.jsoup.select.NodeFilter
        public NodeFilter.FilterResult tail(Node node, int i) {
            return NodeFilter.FilterResult.CONTINUE;
        }
    }
}
