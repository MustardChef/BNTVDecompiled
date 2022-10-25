package org.jsoup.nodes;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;

/* loaded from: classes5.dex */
public class Element extends Node {
    @Nullable
    private Attributes attributes;
    List<Node> childNodes;
    @Nullable
    private WeakReference<List<Element>> shadowChildrenRef;
    private Tag tag;
    private static final List<Element> EmptyChildren = Collections.emptyList();
    private static final Pattern ClassSplit = Pattern.compile("\\s+");
    private static final String BaseUriKey = Attributes.internalKey("baseUri");

    public Element(String str) {
        this(Tag.valueOf(str), "", null);
    }

    public Element(Tag tag, @Nullable String str, @Nullable Attributes attributes) {
        Validate.notNull(tag);
        this.childNodes = EmptyNodes;
        this.attributes = attributes;
        this.tag = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    public Element(Tag tag, @Nullable String str) {
        this(tag, str, null);
    }

    protected boolean hasChildNodes() {
        return this.childNodes != EmptyNodes;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        if (this.childNodes == EmptyNodes) {
            this.childNodes = new NodeList(this, 4);
        }
        return this.childNodes;
    }

    @Override // org.jsoup.nodes.Node
    protected boolean hasAttributes() {
        return this.attributes != null;
    }

    @Override // org.jsoup.nodes.Node
    public Attributes attributes() {
        if (this.attributes == null) {
            this.attributes = new Attributes();
        }
        return this.attributes;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return searchUpForAttribute(this, BaseUriKey);
    }

    private static String searchUpForAttribute(Element element, String str) {
        while (element != null) {
            Attributes attributes = element.attributes;
            if (attributes != null && attributes.hasKey(str)) {
                return element.attributes.get(str);
            }
            element = element.parent();
        }
        return "";
    }

    @Override // org.jsoup.nodes.Node
    protected void doSetBaseUri(String str) {
        attributes().put(BaseUriKey, str);
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return this.childNodes.size();
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return this.tag.getName();
    }

    public String tagName() {
        return this.tag.getName();
    }

    public String normalName() {
        return this.tag.normalName();
    }

    public Element tagName(String str) {
        Validate.notEmpty(str, "Tag name must not be empty.");
        this.tag = Tag.valueOf(str, NodeUtils.parser(this).settings());
        return this;
    }

    public Tag tag() {
        return this.tag;
    }

    public boolean isBlock() {
        return this.tag.isBlock();
    }

    /* renamed from: id */
    public String m56id() {
        Attributes attributes = this.attributes;
        return attributes != null ? attributes.getIgnoreCase("id") : "";
    }

    /* renamed from: id */
    public Element m55id(String str) {
        Validate.notNull(str);
        attr("id", str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element attr(String str, String str2) {
        super.attr(str, str2);
        return this;
    }

    public Element attr(String str, boolean z) {
        attributes().put(str, z);
        return this;
    }

    public Map<String, String> dataset() {
        return attributes().dataset();
    }

    @Override // org.jsoup.nodes.Node
    @Nullable
    public final Element parent() {
        return (Element) this.parentNode;
    }

    public Elements parents() {
        Elements elements = new Elements();
        accumulateParents(this, elements);
        return elements;
    }

    private static void accumulateParents(Element element, Elements elements) {
        Element parent = element.parent();
        if (parent == null || parent.tagName().equals("#root")) {
            return;
        }
        elements.add(parent);
        accumulateParents(parent, elements);
    }

    public Element child(int i) {
        return childElementsList().get(i);
    }

    public int childrenSize() {
        return childElementsList().size();
    }

    public Elements children() {
        return new Elements(childElementsList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Element> childElementsList() {
        List<Element> list;
        if (childNodeSize() == 0) {
            return EmptyChildren;
        }
        WeakReference<List<Element>> weakReference = this.shadowChildrenRef;
        if (weakReference == null || (list = weakReference.get()) == null) {
            int size = this.childNodes.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Node node = this.childNodes.get(i);
                if (node instanceof Element) {
                    arrayList.add((Element) node);
                }
            }
            this.shadowChildrenRef = new WeakReference<>(arrayList);
            return arrayList;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.nodes.Node
    public void nodelistChanged() {
        super.nodelistChanged();
        this.shadowChildrenRef = null;
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<DataNode> dataNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Elements select(Evaluator evaluator) {
        return Selector.select(evaluator, this);
    }

    @Nullable
    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    @Nullable
    public Element selectFirst(Evaluator evaluator) {
        return Collector.findFirst(evaluator, this);
    }

    /* renamed from: is */
    public boolean m54is(String str) {
        return m53is(QueryParser.parse(str));
    }

    /* renamed from: is */
    public boolean m53is(Evaluator evaluator) {
        return evaluator.matches(root(), this);
    }

    @Nullable
    public Element closest(String str) {
        return closest(QueryParser.parse(str));
    }

    @Nullable
    public Element closest(Evaluator evaluator) {
        Validate.notNull(evaluator);
        Element root = root();
        Element element = this;
        while (!evaluator.matches(root, element)) {
            element = element.parent();
            if (element == null) {
                return null;
            }
        }
        return element;
    }

    public Elements selectXpath(String str) {
        return new Elements((List<Element>) NodeUtils.selectXpath(str, this, Element.class));
    }

    public <T extends Node> List<T> selectXpath(String str, Class<T> cls) {
        return NodeUtils.selectXpath(str, this, cls);
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.childNodes.add(node);
        node.setSiblingIndex(this.childNodes.size() - 1);
        return this;
    }

    public Element appendChildren(Collection<? extends Node> collection) {
        insertChildren(-1, collection);
        return this;
    }

    public Element appendTo(Element element) {
        Validate.notNull(element);
        element.appendChild(this);
        return this;
    }

    public Element prependChild(Node node) {
        Validate.notNull(node);
        addChildren(0, node);
        return this;
    }

    public Element prependChildren(Collection<? extends Node> collection) {
        insertChildren(0, collection);
        return this;
    }

    public Element insertChildren(int i, Collection<? extends Node> collection) {
        Validate.notNull(collection, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i < 0) {
            i += childNodeSize + 1;
        }
        Validate.isTrue(i >= 0 && i <= childNodeSize, "Insert position out of bounds.");
        addChildren(i, (Node[]) new ArrayList(collection).toArray(new Node[0]));
        return this;
    }

    public Element insertChildren(int i, Node... nodeArr) {
        Validate.notNull(nodeArr, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i < 0) {
            i += childNodeSize + 1;
        }
        Validate.isTrue(i >= 0 && i <= childNodeSize, "Insert position out of bounds.");
        addChildren(i, nodeArr);
        return this;
    }

    public Element appendElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        appendChild(element);
        return element;
    }

    public Element prependElement(String str) {
        Element element = new Element(Tag.valueOf(str, NodeUtils.parser(this).settings()), baseUri());
        prependChild(element);
        return element;
    }

    public Element appendText(String str) {
        Validate.notNull(str);
        appendChild(new TextNode(str));
        return this;
    }

    public Element prependText(String str) {
        Validate.notNull(str);
        prependChild(new TextNode(str));
        return this;
    }

    public Element append(String str) {
        Validate.notNull(str);
        addChildren((Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element prepend(String str) {
        Validate.notNull(str);
        addChildren(0, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element before(String str) {
        return (Element) super.before(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element before(Node node) {
        return (Element) super.before(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element after(String str) {
        return (Element) super.after(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element after(Node node) {
        return (Element) super.after(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element empty() {
        this.childNodes.clear();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element wrap(String str) {
        return (Element) super.wrap(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r3.get(0) == r5) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String cssSelector() {
        /*
            r5 = this;
            java.lang.String r0 = r5.m56id()
            int r0 = r0.length()
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L38
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "#"
            r0.append(r3)
            java.lang.String r3 = r5.m56id()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            org.jsoup.nodes.Document r3 = r5.ownerDocument()
            if (r3 == 0) goto L37
            org.jsoup.select.Elements r3 = r3.select(r0)
            int r4 = r3.size()
            if (r4 != r2) goto L38
            java.lang.Object r3 = r3.get(r1)
            if (r3 != r5) goto L38
        L37:
            return r0
        L38:
            java.lang.String r0 = r5.tagName()
            r3 = 58
            r4 = 124(0x7c, float:1.74E-43)
            java.lang.String r0 = r0.replace(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            java.util.Set r0 = r5.classNames()
            java.lang.String r4 = "."
            java.lang.String r0 = org.jsoup.internal.StringUtil.join(r0, r4)
            int r4 = r0.length()
            if (r4 <= 0) goto L61
            r4 = 46
            r3.append(r4)
            r3.append(r0)
        L61:
            org.jsoup.nodes.Element r0 = r5.parent()
            if (r0 == 0) goto Lb9
            org.jsoup.nodes.Element r0 = r5.parent()
            boolean r0 = r0 instanceof org.jsoup.nodes.Document
            if (r0 == 0) goto L70
            goto Lb9
        L70:
            java.lang.String r0 = " > "
            r3.insert(r1, r0)
            org.jsoup.nodes.Element r0 = r5.parent()
            java.lang.String r4 = r3.toString()
            org.jsoup.select.Elements r0 = r0.select(r4)
            int r0 = r0.size()
            if (r0 <= r2) goto L9d
            java.lang.Object[] r0 = new java.lang.Object[r2]
            int r4 = r5.elementSiblingIndex()
            int r4 = r4 + r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0[r1] = r2
            java.lang.String r1 = ":nth-child(%d)"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r3.append(r0)
        L9d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            org.jsoup.nodes.Element r1 = r5.parent()
            java.lang.String r1 = r1.cssSelector()
            r0.append(r1)
            java.lang.String r1 = r3.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        Lb9:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Element.cssSelector():java.lang.String");
    }

    public Elements siblingElements() {
        if (this.parentNode == null) {
            return new Elements(0);
        }
        List<Element> childElementsList = parent().childElementsList();
        Elements elements = new Elements(childElementsList.size() - 1);
        for (Element element : childElementsList) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    @Nullable
    public Element nextElementSibling() {
        if (this.parentNode == null) {
            return null;
        }
        List<Element> childElementsList = parent().childElementsList();
        int indexInList = indexInList(this, childElementsList) + 1;
        if (childElementsList.size() > indexInList) {
            return childElementsList.get(indexInList);
        }
        return null;
    }

    public Elements nextElementSiblings() {
        return nextElementSiblings(true);
    }

    @Nullable
    public Element previousElementSibling() {
        List<Element> childElementsList;
        int indexInList;
        if (this.parentNode != null && (indexInList = indexInList(this, (childElementsList = parent().childElementsList()))) > 0) {
            return childElementsList.get(indexInList - 1);
        }
        return null;
    }

    public Elements previousElementSiblings() {
        return nextElementSiblings(false);
    }

    private Elements nextElementSiblings(boolean z) {
        Elements elements = new Elements();
        if (this.parentNode == null) {
            return elements;
        }
        elements.add(this);
        return z ? elements.nextAll() : elements.prevAll();
    }

    public Element firstElementSibling() {
        if (parent() != null) {
            List<Element> childElementsList = parent().childElementsList();
            return childElementsList.size() > 1 ? childElementsList.get(0) : this;
        }
        return this;
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return indexInList(this, parent().childElementsList());
    }

    public Element lastElementSibling() {
        if (parent() != null) {
            List<Element> childElementsList = parent().childElementsList();
            return childElementsList.size() > 1 ? childElementsList.get(childElementsList.size() - 1) : this;
        }
        return this;
    }

    private static <E extends Element> int indexInList(Element element, List<E> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == element) {
                return i;
            }
        }
        return 0;
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    @Nullable
    public Element getElementById(String str) {
        Validate.notEmpty(str);
        Elements collect = Collector.collect(new Evaluator.C5493Id(str), this);
        if (collect.size() > 0) {
            return collect.get(0);
        }
        return null;
    }

    public Elements getElementsByClass(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Class(str), this);
    }

    public Elements getElementsByAttribute(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Attribute(str.trim()), this);
    }

    public Elements getElementsByAttributeStarting(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public Elements getElementsByAttributeValue(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Elements getElementsByAttributeValueNot(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    public Elements getElementsByAttributeValueStarting(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements getElementsByAttributeValueEnding(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    public Elements getElementsByAttributeValueContaining(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, Pattern pattern) {
        return Collector.collect(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, String str2) {
        try {
            return getElementsByAttributeValueMatching(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Pattern syntax error: " + str2, e);
        }
    }

    public Elements getElementsByIndexLessThan(int i) {
        return Collector.collect(new Evaluator.IndexLessThan(i), this);
    }

    public Elements getElementsByIndexGreaterThan(int i) {
        return Collector.collect(new Evaluator.IndexGreaterThan(i), this);
    }

    public Elements getElementsByIndexEquals(int i) {
        return Collector.collect(new Evaluator.IndexEquals(i), this);
    }

    public Elements getElementsContainingText(String str) {
        return Collector.collect(new Evaluator.ContainsText(str), this);
    }

    public Elements getElementsContainingOwnText(String str) {
        return Collector.collect(new Evaluator.ContainsOwnText(str), this);
    }

    public Elements getElementsMatchingText(Pattern pattern) {
        return Collector.collect(new Evaluator.Matches(pattern), this);
    }

    public Elements getElementsMatchingText(String str) {
        try {
            return getElementsMatchingText(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e);
        }
    }

    public Elements getElementsMatchingOwnText(Pattern pattern) {
        return Collector.collect(new Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingOwnText(String str) {
        try {
            return getElementsMatchingOwnText(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Pattern syntax error: " + str, e);
        }
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public String text() {
        final StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.1
            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i) {
                if (node instanceof TextNode) {
                    Element.appendNormalisedText(borrowBuilder, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (borrowBuilder.length() > 0) {
                        if ((element.isBlock() || element.tag.normalName().equals(TtmlNode.TAG_BR)) && !TextNode.lastCharIsWhitespace(borrowBuilder)) {
                            borrowBuilder.append(' ');
                        }
                    }
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i) {
                if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode) && !TextNode.lastCharIsWhitespace(borrowBuilder)) {
                    borrowBuilder.append(' ');
                }
            }
        }, this);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    public String wholeText() {
        final StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new NodeVisitor() { // from class: org.jsoup.nodes.Element.2
            @Override // org.jsoup.select.NodeVisitor
            public void tail(Node node, int i) {
            }

            @Override // org.jsoup.select.NodeVisitor
            public void head(Node node, int i) {
                if (node instanceof TextNode) {
                    borrowBuilder.append(((TextNode) node).getWholeText());
                }
            }
        }, this);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public String ownText() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        ownText(borrowBuilder);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    private void ownText(StringBuilder sb) {
        for (int i = 0; i < childNodeSize(); i++) {
            Node node = this.childNodes.get(i);
            if (node instanceof TextNode) {
                appendNormalisedText(sb, (TextNode) node);
            } else if (node instanceof Element) {
                appendWhitespaceIfBr((Element) node, sb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void appendNormalisedText(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (preserveWhitespace(textNode.parentNode) || (textNode instanceof CDataNode)) {
            sb.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.lastCharIsWhitespace(sb));
        }
    }

    private static void appendWhitespaceIfBr(Element element, StringBuilder sb) {
        if (!element.tag.normalName().equals(TtmlNode.TAG_BR) || TextNode.lastCharIsWhitespace(sb)) {
            return;
        }
        sb.append(" ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean preserveWhitespace(@Nullable Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            int i = 0;
            while (!element.tag.preserveWhitespace()) {
                element = element.parent();
                i++;
                if (i < 6) {
                    if (element == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Element text(String str) {
        Validate.notNull(str);
        empty();
        Document ownerDocument = ownerDocument();
        if (ownerDocument != null && ownerDocument.parser().isContentForTagData(normalName())) {
            appendChild(new DataNode(str));
        } else {
            appendChild(new TextNode(str));
        }
        return this;
    }

    public boolean hasText() {
        for (Node node : this.childNodes) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).isBlank()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).hasText()) {
                return true;
            }
        }
        return false;
    }

    public String data() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.childNodes) {
            if (node instanceof DataNode) {
                borrowBuilder.append(((DataNode) node).getWholeData());
            } else if (node instanceof Comment) {
                borrowBuilder.append(((Comment) node).getData());
            } else if (node instanceof Element) {
                borrowBuilder.append(((Element) node).data());
            } else if (node instanceof CDataNode) {
                borrowBuilder.append(((CDataNode) node).getWholeText());
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public String className() {
        return attr("class").trim();
    }

    public Set<String> classNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(ClassSplit.split(className())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element classNames(Set<String> set) {
        Validate.notNull(set);
        if (set.isEmpty()) {
            attributes().remove("class");
        } else {
            attributes().put("class", StringUtil.join(set, " "));
        }
        return this;
    }

    public boolean hasClass(String str) {
        Attributes attributes = this.attributes;
        if (attributes == null) {
            return false;
        }
        String ignoreCase = attributes.getIgnoreCase("class");
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            boolean z = false;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Character.isWhitespace(ignoreCase.charAt(i2))) {
                    if (!z) {
                        continue;
                    } else if (i2 - i == length2 && ignoreCase.regionMatches(true, i, str, 0, length2)) {
                        return true;
                    } else {
                        z = false;
                    }
                } else if (!z) {
                    i = i2;
                    z = true;
                }
            }
            if (z && length - i == length2) {
                return ignoreCase.regionMatches(true, i, str, 0, length2);
            }
        }
        return false;
    }

    public Element addClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.add(str);
        classNames(classNames);
        return this;
    }

    public Element removeClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.remove(str);
        classNames(classNames);
        return this;
    }

    public Element toggleClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        if (classNames.contains(str)) {
            classNames.remove(str);
        } else {
            classNames.add(str);
        }
        classNames(classNames);
        return this;
    }

    public String val() {
        if (normalName().equals("textarea")) {
            return text();
        }
        return attr("value");
    }

    public Element val(String str) {
        if (normalName().equals("textarea")) {
            text(str);
        } else {
            attr("value", str);
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlHead(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint() && isFormatAsBlock(outputSettings) && !isInlineable(outputSettings)) {
            if (appendable instanceof StringBuilder) {
                if (((StringBuilder) appendable).length() > 0) {
                    indent(appendable, i, outputSettings);
                }
            } else {
                indent(appendable, i, outputSettings);
            }
        }
        appendable.append(Typography.less).append(tagName());
        Attributes attributes = this.attributes;
        if (attributes != null) {
            attributes.html(appendable, outputSettings);
        }
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
                appendable.append(Typography.greater);
                return;
            } else {
                appendable.append(" />");
                return;
            }
        }
        appendable.append(Typography.greater);
    }

    @Override // org.jsoup.nodes.Node
    void outerHtmlTail(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
            return;
        }
        if (outputSettings.prettyPrint() && !this.childNodes.isEmpty() && (this.tag.formatAsBlock() || (outputSettings.outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && !(this.childNodes.get(0) instanceof TextNode)))))) {
            indent(appendable, i, outputSettings);
        }
        appendable.append("</").append(tagName()).append(Typography.greater);
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        html((Element) borrowBuilder);
        String releaseBuilder = StringUtil.releaseBuilder(borrowBuilder);
        return NodeUtils.outputSettings(this).prettyPrint() ? releaseBuilder.trim() : releaseBuilder;
    }

    @Override // org.jsoup.nodes.Node
    public <T extends Appendable> T html(T t) {
        int size = this.childNodes.size();
        for (int i = 0; i < size; i++) {
            this.childNodes.get(i).outerHtml(t);
        }
        return t;
    }

    public Element html(String str) {
        empty();
        append(str);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element clone() {
        return (Element) super.clone();
    }

    @Override // org.jsoup.nodes.Node
    public Element shallowClone() {
        Tag tag = this.tag;
        String baseUri = baseUri();
        Attributes attributes = this.attributes;
        return new Element(tag, baseUri, attributes == null ? null : attributes.clone());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.Node
    public Element doClone(@Nullable Node node) {
        Element element = (Element) super.doClone(node);
        Attributes attributes = this.attributes;
        element.attributes = attributes != null ? attributes.clone() : null;
        NodeList nodeList = new NodeList(element, this.childNodes.size());
        element.childNodes = nodeList;
        nodeList.addAll(this.childNodes);
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public Element clearAttributes() {
        if (this.attributes != null) {
            super.clearAttributes();
            this.attributes = null;
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element removeAttr(String str) {
        return (Element) super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element root() {
        return (Element) super.root();
    }

    @Override // org.jsoup.nodes.Node
    public Element traverse(NodeVisitor nodeVisitor) {
        return (Element) super.traverse(nodeVisitor);
    }

    @Override // org.jsoup.nodes.Node
    public Element filter(NodeFilter nodeFilter) {
        return (Element) super.filter(nodeFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class NodeList extends ChangeNotifyingArrayList<Node> {
        private final Element owner;

        NodeList(Element element, int i) {
            super(i);
            this.owner = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.owner.nodelistChanged();
        }
    }

    private boolean isFormatAsBlock(Document.OutputSettings outputSettings) {
        return this.tag.formatAsBlock() || (parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline();
    }

    private boolean isInlineable(Document.OutputSettings outputSettings) {
        return (!tag().isInline() || tag().isEmpty() || (parent() != null && !parent().isBlock()) || previousSibling() == null || outputSettings.outline()) ? false : true;
    }
}
