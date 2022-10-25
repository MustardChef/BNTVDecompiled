package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.HtmlTreeBuilderState;
import org.jsoup.parser.Token;

/* loaded from: classes5.dex */
public class HtmlTreeBuilder extends TreeBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MaxScopeSearchDepth = 100;
    private static final int maxQueueDepth = 256;
    private static final int maxUsedFormattingElements = 12;
    private boolean baseUriSetFromDoc;
    @Nullable
    private Element contextElement;
    private Token.EndTag emptyEnd;
    @Nullable
    private FormElement formElement;
    private ArrayList<Element> formattingElements;
    private boolean fosterInserts;
    private boolean fragmentParsing;
    private boolean framesetOk;
    @Nullable
    private Element headElement;
    private HtmlTreeBuilderState originalState;
    private List<String> pendingTableCharacters;
    private String[] specificScopeTarget = {null};
    private HtmlTreeBuilderState state;
    private ArrayList<HtmlTreeBuilderState> tmplInsertMode;
    static final String[] TagsSearchInScope = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};
    static final String[] TagSearchList = {"ol", "ul"};
    static final String[] TagSearchButton = {"button"};
    static final String[] TagSearchTableScope = {"html", "table"};
    static final String[] TagSearchSelectScope = {"optgroup", "option"};
    static final String[] TagSearchEndTags = {"dd", "dt", "li", "optgroup", "option", TtmlNode.TAG_P, "rb", "rp", "rt", "rtc"};
    static final String[] TagThoroughSearchEndTags = {"caption", "colgroup", "dd", "dt", "li", "optgroup", "option", TtmlNode.TAG_P, "rb", "rp", "rt", "rtc", "tbody", "td", "tfoot", "th", "thead", "tr"};
    static final String[] TagSearchSpecial = {"address", "applet", "area", "article", "aside", TtmlNode.RUBY_BASE, "basefont", "bgsound", "blockquote", "body", TtmlNode.TAG_BR, "button", "caption", TtmlNode.CENTER, "col", "colgroup", "command", "dd", "details", "dir", TtmlNode.TAG_DIV, "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TypedValues.AttributesType.S_FRAME, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", TtmlNode.TAG_HEAD, "header", "hgroup", "hr", "html", "iframe", "img", TvContractCompat.PARAM_INPUT, "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", TtmlNode.TAG_P, "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};

    @Override // org.jsoup.parser.TreeBuilder
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    @Override // org.jsoup.parser.TreeBuilder
    ParseSettings defaultSettings() {
        return ParseSettings.htmlDefault;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.parser.TreeBuilder
    public HtmlTreeBuilder newInstance() {
        return new HtmlTreeBuilder();
    }

    @Override // org.jsoup.parser.TreeBuilder
    @ParametersAreNonnullByDefault
    protected void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.state = HtmlTreeBuilderState.Initial;
        this.originalState = null;
        this.baseUriSetFromDoc = false;
        this.headElement = null;
        this.formElement = null;
        this.contextElement = null;
        this.formattingElements = new ArrayList<>();
        this.tmplInsertMode = new ArrayList<>();
        this.pendingTableCharacters = new ArrayList();
        this.emptyEnd = new Token.EndTag();
        this.framesetOk = true;
        this.fosterInserts = false;
        this.fragmentParsing = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a6, code lost:
        if (r0.equals("iframe") == false) goto L8;
     */
    @Override // org.jsoup.parser.TreeBuilder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<org.jsoup.nodes.Node> parseFragment(java.lang.String r3, @javax.annotation.Nullable org.jsoup.nodes.Element r4, java.lang.String r5, org.jsoup.parser.Parser r6) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.parseFragment(java.lang.String, org.jsoup.nodes.Element, java.lang.String, org.jsoup.parser.Parser):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.parser.TreeBuilder
    public boolean process(Token token) {
        this.currentToken = token;
        return this.state.process(token, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean process(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.currentToken = token;
        return htmlTreeBuilderState.process(token, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transition(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.state = htmlTreeBuilderState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlTreeBuilderState state() {
        return this.state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markInsertionMode() {
        this.originalState = this.state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HtmlTreeBuilderState originalState() {
        return this.originalState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void framesetOk(boolean z) {
        this.framesetOk = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean framesetOk() {
        return this.framesetOk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document getDocument() {
        return this.doc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBaseUri() {
        return this.baseUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void maybeSetBaseUri(Element element) {
        if (this.baseUriSetFromDoc) {
            return;
        }
        String absUrl = element.absUrl(ShareConstants.WEB_DIALOG_PARAM_HREF);
        if (absUrl.length() != 0) {
            this.baseUri = absUrl;
            this.baseUriSetFromDoc = true;
            this.doc.setBaseUri(absUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFragmentParsing() {
        return this.fragmentParsing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.parser.getErrors().canAddError()) {
            this.parser.getErrors().add(new ParseError(this.reader, "Unexpected %s token [%s] when in state [%s]", this.currentToken.tokenType(), this.currentToken, htmlTreeBuilderState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element insert(Token.StartTag startTag) {
        if (startTag.hasAttributes() && !startTag.attributes.isEmpty() && startTag.attributes.deduplicate(this.settings) > 0) {
            error("Dropped duplicate attribute(s) in tag [%s]", startTag.normalName);
        }
        if (startTag.isSelfClosing()) {
            Element insertEmpty = insertEmpty(startTag);
            this.stack.add(insertEmpty);
            this.tokeniser.transition(TokeniserState.Data);
            this.tokeniser.emit(this.emptyEnd.reset().name(insertEmpty.tagName()));
            return insertEmpty;
        }
        Element element = new Element(tagFor(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        insert(element);
        return element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element insertStartTag(String str) {
        Element element = new Element(tagFor(str, this.settings), null);
        insert(element);
        return element;
    }

    void insert(Element element) {
        insertNode(element);
        this.stack.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element insertEmpty(Token.StartTag startTag) {
        Tag tagFor = tagFor(startTag.name(), this.settings);
        Element element = new Element(tagFor, null, this.settings.normalizeAttributes(startTag.attributes));
        insertNode(element);
        if (startTag.isSelfClosing()) {
            if (tagFor.isKnownTag()) {
                if (!tagFor.isEmpty()) {
                    this.tokeniser.error("Tag [%s] cannot be self closing; not a void tag", tagFor.normalName());
                }
            } else {
                tagFor.setSelfClosing();
            }
        }
        return element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FormElement insertForm(Token.StartTag startTag, boolean z, boolean z2) {
        FormElement formElement = new FormElement(tagFor(startTag.name(), this.settings), null, this.settings.normalizeAttributes(startTag.attributes));
        if (z2) {
            if (!onStack("template")) {
                setFormElement(formElement);
            }
        } else {
            setFormElement(formElement);
        }
        insertNode(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insert(Token.Comment comment) {
        insertNode(new Comment(comment.getData()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insert(Token.Character character) {
        Node textNode;
        Element currentElement = currentElement();
        String normalName = currentElement.normalName();
        String data = character.getData();
        if (character.isCData()) {
            textNode = new CDataNode(data);
        } else if (isContentForTagData(normalName)) {
            textNode = new DataNode(data);
        } else {
            textNode = new TextNode(data);
        }
        currentElement.appendChild(textNode);
    }

    private void insertNode(Node node) {
        FormElement formElement;
        if (this.stack.isEmpty()) {
            this.doc.appendChild(node);
        } else if (isFosterInserts() && StringUtil.inSorted(currentElement().normalName(), HtmlTreeBuilderState.Constants.InTableFoster)) {
            insertInFosterParent(node);
        } else {
            currentElement().appendChild(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (!element.tag().isFormListed() || (formElement = this.formElement) == null) {
                return;
            }
            formElement.addElement(element);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element pop() {
        return this.stack.remove(this.stack.size() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void push(Element element) {
        this.stack.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Element> getStack() {
        return this.stack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onStack(Element element) {
        return onStack(this.stack, element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onStack(String str) {
        return getFromStack(str) != null;
    }

    private static boolean onStack(ArrayList<Element> arrayList, Element element) {
        int size = arrayList.size() - 1;
        int i = size >= 256 ? size + InputDeviceCompat.SOURCE_ANY : 0;
        while (size >= i) {
            if (arrayList.get(size) == element) {
                return true;
            }
            size--;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Element getFromStack(String str) {
        int size = this.stack.size() - 1;
        int i = size >= 256 ? size + InputDeviceCompat.SOURCE_ANY : 0;
        while (size >= i) {
            Element element = this.stack.get(size);
            if (element.normalName().equals(str)) {
                return element;
            }
            size--;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeFromStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Element popStackToClose(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popStackToClose(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            this.stack.remove(size);
            if (StringUtil.inSorted(this.stack.get(size).normalName(), strArr)) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popStackToBefore(String str) {
        for (int size = this.stack.size() - 1; size >= 0 && !this.stack.get(size).normalName().equals(str); size--) {
            this.stack.remove(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearStackToTableContext() {
        clearStackToContext("table", "template");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearStackToTableBodyContext() {
        clearStackToContext("tbody", "tfoot", "thead", "template");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearStackToTableRowContext() {
        clearStackToContext("tr", "template");
    }

    private void clearStackToContext(String... strArr) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (StringUtil.m57in(element.normalName(), strArr) || element.normalName().equals("html")) {
                return;
            }
            this.stack.remove(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Element aboveOnStack(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                return this.stack.get(size - 1);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertOnStackAfter(Element element, Element element2) {
        int lastIndexOf = this.stack.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        this.stack.add(lastIndexOf + 1, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceOnStack(Element element, Element element2) {
        replaceInQueue(this.stack, element, element2);
    }

    private void replaceInQueue(ArrayList<Element> arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        Validate.isTrue(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetInsertionMode() {
        int size = this.stack.size() - 1;
        int i = size >= 256 ? size + InputDeviceCompat.SOURCE_ANY : 0;
        if (this.stack.size() == 0) {
            transition(HtmlTreeBuilderState.InBody);
        }
        boolean z = false;
        while (size >= i) {
            Element element = this.stack.get(size);
            if (size == i) {
                if (this.fragmentParsing) {
                    element = this.contextElement;
                }
                z = true;
            }
            String normalName = element != null ? element.normalName() : "";
            normalName.hashCode();
            char c = 65535;
            switch (normalName.hashCode()) {
                case -1644953643:
                    if (normalName.equals("frameset")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1321546630:
                    if (normalName.equals("template")) {
                        c = 1;
                        break;
                    }
                    break;
                case -906021636:
                    if (normalName.equals("select")) {
                        c = 2;
                        break;
                    }
                    break;
                case -636197633:
                    if (normalName.equals("colgroup")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3696:
                    if (normalName.equals("td")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3700:
                    if (normalName.equals("th")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3710:
                    if (normalName.equals("tr")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3029410:
                    if (normalName.equals("body")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3198432:
                    if (normalName.equals(TtmlNode.TAG_HEAD)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 110115790:
                    if (normalName.equals("table")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 110157846:
                    if (normalName.equals("tbody")) {
                        c = 11;
                        break;
                    }
                    break;
                case 110277346:
                    if (normalName.equals("tfoot")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 110326868:
                    if (normalName.equals("thead")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 552573414:
                    if (normalName.equals("caption")) {
                        c = 14;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    transition(HtmlTreeBuilderState.InFrameset);
                    return;
                case 1:
                    HtmlTreeBuilderState currentTemplateMode = currentTemplateMode();
                    Validate.notNull(currentTemplateMode, "Bug: no template insertion mode on stack!");
                    transition(currentTemplateMode);
                    return;
                case 2:
                    transition(HtmlTreeBuilderState.InSelect);
                    return;
                case 3:
                    transition(HtmlTreeBuilderState.InColumnGroup);
                    return;
                case 4:
                case 5:
                    if (!z) {
                        transition(HtmlTreeBuilderState.InCell);
                        return;
                    }
                    break;
                case 6:
                    transition(HtmlTreeBuilderState.InRow);
                    return;
                case 7:
                    transition(HtmlTreeBuilderState.InBody);
                    return;
                case '\b':
                    if (!z) {
                        transition(HtmlTreeBuilderState.InHead);
                        return;
                    }
                    break;
                case '\t':
                    transition(this.headElement == null ? HtmlTreeBuilderState.BeforeHead : HtmlTreeBuilderState.AfterHead);
                    return;
                case '\n':
                    transition(HtmlTreeBuilderState.InTable);
                    return;
                case 11:
                case '\f':
                case '\r':
                    transition(HtmlTreeBuilderState.InTableBody);
                    return;
                case 14:
                    transition(HtmlTreeBuilderState.InCaption);
                    return;
            }
            if (z) {
                transition(HtmlTreeBuilderState.InBody);
                return;
            }
            size--;
        }
    }

    private boolean inSpecificScope(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.specificScopeTarget;
        strArr3[0] = str;
        return inSpecificScope(strArr3, strArr, strArr2);
    }

    private boolean inSpecificScope(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.stack.size() - 1;
        int i = size > 100 ? size - 100 : 0;
        while (size >= i) {
            String normalName = this.stack.get(size).normalName();
            if (StringUtil.inSorted(normalName, strArr)) {
                return true;
            }
            if (StringUtil.inSorted(normalName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.inSorted(normalName, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inScope(String[] strArr) {
        return inSpecificScope(strArr, TagsSearchInScope, (String[]) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inScope(String str) {
        return inScope(str, null);
    }

    boolean inScope(String str, String[] strArr) {
        return inSpecificScope(str, TagsSearchInScope, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inListItemScope(String str) {
        return inScope(str, TagSearchList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inButtonScope(String str) {
        return inScope(str, TagSearchButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inTableScope(String str) {
        return inSpecificScope(str, TagSearchTableScope, (String[]) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean inSelectScope(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String normalName = this.stack.get(size).normalName();
            if (normalName.equals(str)) {
                return true;
            }
            if (!StringUtil.inSorted(normalName, TagSearchSelectScope)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHeadElement(Element element) {
        this.headElement = element;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getHeadElement() {
        return this.headElement;
    }

    boolean isFosterInserts() {
        return this.fosterInserts;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFosterInserts(boolean z) {
        this.fosterInserts = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public FormElement getFormElement() {
        return this.formElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFormElement(FormElement formElement) {
        this.formElement = formElement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void newPendingTableCharacters() {
        this.pendingTableCharacters = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> getPendingTableCharacters() {
        return this.pendingTableCharacters;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void generateImpliedEndTags(String str) {
        while (StringUtil.inSorted(currentElement().normalName(), TagSearchEndTags)) {
            if (str != null && currentElementIs(str)) {
                return;
            }
            pop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void generateImpliedEndTags() {
        generateImpliedEndTags(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void generateImpliedEndTags(boolean z) {
        String[] strArr = z ? TagThoroughSearchEndTags : TagSearchEndTags;
        while (StringUtil.inSorted(currentElement().normalName(), strArr)) {
            pop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeElement(String str) {
        generateImpliedEndTags(str);
        if (!str.equals(currentElement().normalName())) {
            error(state());
        }
        popStackToClose(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSpecial(Element element) {
        return StringUtil.inSorted(element.normalName(), TagSearchSpecial);
    }

    Element lastFormattingElement() {
        if (this.formattingElements.size() > 0) {
            ArrayList<Element> arrayList = this.formattingElements;
            return arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int positionOfElement(Element element) {
        for (int i = 0; i < this.formattingElements.size(); i++) {
            if (element == this.formattingElements.get(i)) {
                return i;
            }
        }
        return -1;
    }

    Element removeLastFormattingElement() {
        int size = this.formattingElements.size();
        if (size > 0) {
            return this.formattingElements.remove(size - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushActiveFormattingElements(Element element) {
        checkActiveFormattingElements(element);
        this.formattingElements.add(element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushWithBookmark(Element element, int i) {
        checkActiveFormattingElements(element);
        try {
            this.formattingElements.add(i, element);
        } catch (IndexOutOfBoundsException unused) {
            this.formattingElements.add(element);
        }
    }

    void checkActiveFormattingElements(Element element) {
        int i = 0;
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element2 = this.formattingElements.get(size);
            if (element2 == null) {
                return;
            }
            if (isSameFormattingElement(element, element2)) {
                i++;
            }
            if (i == 3) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    private boolean isSameFormattingElement(Element element, Element element2) {
        return element.normalName().equals(element2.normalName()) && element.attributes().equals(element2.attributes());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reconstructFormattingElements() {
        /*
            r7 = this;
            org.jsoup.nodes.Element r0 = r7.lastFormattingElement()
            if (r0 == 0) goto L61
            boolean r1 = r7.onStack(r0)
            if (r1 == 0) goto Ld
            goto L61
        Ld:
            java.util.ArrayList<org.jsoup.nodes.Element> r1 = r7.formattingElements
            int r1 = r1.size()
            int r2 = r1 + (-12)
            r3 = 0
            if (r2 >= 0) goto L19
            r2 = 0
        L19:
            r4 = 1
            int r1 = r1 - r4
            r5 = r1
        L1c:
            if (r5 != r2) goto L1f
            goto L32
        L1f:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.formattingElements
            int r5 = r5 + (-1)
            java.lang.Object r0 = r0.get(r5)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L31
            boolean r6 = r7.onStack(r0)
            if (r6 == 0) goto L1c
        L31:
            r4 = 0
        L32:
            if (r4 != 0) goto L3e
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.formattingElements
            int r5 = r5 + 1
            java.lang.Object r0 = r0.get(r5)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
        L3e:
            org.jsoup.helper.Validate.notNull(r0)
            java.lang.String r2 = r0.normalName()
            org.jsoup.nodes.Element r2 = r7.insertStartTag(r2)
            int r4 = r0.attributesSize()
            if (r4 <= 0) goto L5a
            org.jsoup.nodes.Attributes r4 = r2.attributes()
            org.jsoup.nodes.Attributes r6 = r0.attributes()
            r4.addAll(r6)
        L5a:
            java.util.ArrayList<org.jsoup.nodes.Element> r4 = r7.formattingElements
            r4.set(r5, r2)
            if (r5 != r1) goto L31
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.reconstructFormattingElements():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearFormattingElementsToLastMarker() {
        while (!this.formattingElements.isEmpty() && removeLastFormattingElement() != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFromActiveFormattingElements(Element element) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            if (this.formattingElements.get(size) == element) {
                this.formattingElements.remove(size);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInActiveFormattingElements(Element element) {
        return onStack(this.formattingElements, element);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Element getActiveFormattingElement(String str) {
        for (int size = this.formattingElements.size() - 1; size >= 0; size--) {
            Element element = this.formattingElements.get(size);
            if (element == null) {
                return null;
            }
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceActiveFormattingElement(Element element, Element element2) {
        replaceInQueue(this.formattingElements, element, element2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertMarkerToFormattingElements() {
        this.formattingElements.add(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void insertInFosterParent(Node node) {
        Element element;
        Element fromStack = getFromStack("table");
        boolean z = false;
        if (fromStack != null) {
            if (fromStack.parent() != null) {
                element = fromStack.parent();
                z = true;
            } else {
                element = aboveOnStack(fromStack);
            }
        } else {
            element = this.stack.get(0);
        }
        if (z) {
            Validate.notNull(fromStack);
            fromStack.before(node);
            return;
        }
        element.appendChild(node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushTemplateMode(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.tmplInsertMode.add(htmlTreeBuilderState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public HtmlTreeBuilderState popTemplateMode() {
        if (this.tmplInsertMode.size() > 0) {
            ArrayList<HtmlTreeBuilderState> arrayList = this.tmplInsertMode;
            return arrayList.remove(arrayList.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int templateModeSize() {
        return this.tmplInsertMode.size();
    }

    @Nullable
    HtmlTreeBuilderState currentTemplateMode() {
        if (this.tmplInsertMode.size() > 0) {
            ArrayList<HtmlTreeBuilderState> arrayList = this.tmplInsertMode;
            return arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
    }

    @Override // org.jsoup.parser.TreeBuilder
    protected boolean isContentForTagData(String str) {
        return str.equals("script") || str.equals("style");
    }
}
