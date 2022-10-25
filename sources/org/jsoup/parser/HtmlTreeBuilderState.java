package org.jsoup.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                Token.Doctype asDoctype = token.asDoctype();
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(asDoctype.getName()), asDoctype.getPublicIdentifier(), asDoctype.getSystemIdentifier());
                documentType.setPubSysKey(asDoctype.getPubSysKey());
                htmlTreeBuilder.getDocument().appendChild(documentType);
                if (asDoctype.isForceQuirks()) {
                    htmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.transition(BeforeHtml);
            } else {
                htmlTreeBuilder.transition(BeforeHtml);
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (!token.isComment()) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    htmlTreeBuilder.insert(token.asCharacter());
                    return true;
                } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                    htmlTreeBuilder.insert(token.asStartTag());
                    htmlTreeBuilder.transition(BeforeHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.insertStartTag("html");
            htmlTreeBuilder.transition(BeforeHead);
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return InBody.process(token, htmlTreeBuilder);
            } else {
                if (token.isStartTag() && token.asStartTag().normalName().equals(TtmlNode.TAG_HEAD)) {
                    htmlTreeBuilder.setHeadElement(htmlTreeBuilder.insert(token.asStartTag()));
                    htmlTreeBuilder.transition(InHead);
                    return true;
                } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.BeforeHtmlToHead)) {
                    htmlTreeBuilder.processStartTag(TtmlNode.TAG_HEAD);
                    return htmlTreeBuilder.process(token);
                } else if (token.isEndTag()) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    htmlTreeBuilder.processStartTag(TtmlNode.TAG_HEAD);
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            }
            int i = C541425.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 1) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (i == 2) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("html")) {
                    return InBody.process(token, htmlTreeBuilder);
                }
                if (StringUtil.inSorted(normalName, Constants.InHeadEmpty)) {
                    Element insertEmpty = htmlTreeBuilder.insertEmpty(asStartTag);
                    if (normalName.equals(TtmlNode.RUBY_BASE) && insertEmpty.hasAttr(ShareConstants.WEB_DIALOG_PARAM_HREF)) {
                        htmlTreeBuilder.maybeSetBaseUri(insertEmpty);
                    }
                } else if (normalName.equals("meta")) {
                    htmlTreeBuilder.insertEmpty(asStartTag);
                } else if (normalName.equals("title")) {
                    HtmlTreeBuilderState.handleRcData(asStartTag, htmlTreeBuilder);
                } else if (StringUtil.inSorted(normalName, Constants.InHeadRaw)) {
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                } else if (normalName.equals("noscript")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InHeadNoscript);
                } else if (normalName.equals("script")) {
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData);
                    htmlTreeBuilder.markInsertionMode();
                    htmlTreeBuilder.transition(Text);
                    htmlTreeBuilder.insert(asStartTag);
                } else if (normalName.equals(TtmlNode.TAG_HEAD)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (normalName.equals("template")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InTemplate);
                    htmlTreeBuilder.pushTemplateMode(InTemplate);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (i == 4) {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals(TtmlNode.TAG_HEAD)) {
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(AfterHead);
                } else if (StringUtil.inSorted(normalName2, Constants.InHeadEnd)) {
                    return anythingElse(token, htmlTreeBuilder);
                } else {
                    if (normalName2.equals("template")) {
                        if (!htmlTreeBuilder.onStack(normalName2)) {
                            htmlTreeBuilder.error(this);
                        } else {
                            htmlTreeBuilder.generateImpliedEndTags(true);
                            if (!normalName2.equals(htmlTreeBuilder.currentElement().normalName())) {
                                htmlTreeBuilder.error(this);
                            }
                            htmlTreeBuilder.popStackToClose(normalName2);
                            htmlTreeBuilder.clearFormattingElementsToLastMarker();
                            htmlTreeBuilder.popTemplateMode();
                            htmlTreeBuilder.resetInsertionMode();
                        }
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                }
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, TreeBuilder treeBuilder) {
            treeBuilder.processEndTag(TtmlNode.TAG_HEAD);
            return treeBuilder.process(token);
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (!token.isEndTag() || !token.asEndTag().normalName().equals("noscript")) {
                    if (HtmlTreeBuilderState.isWhitespace(token) || token.isComment() || (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoScriptHead))) {
                        return htmlTreeBuilder.process(token, InHead);
                    }
                    if (token.isEndTag() && token.asEndTag().normalName().equals(TtmlNode.TAG_BR)) {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InHeadNoscriptIgnore)) || token.isEndTag()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(InHead);
                return true;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.insert(new Token.Character().data(token.toString()));
            return true;
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return true;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("html")) {
                    return htmlTreeBuilder.process(token, InBody);
                }
                if (normalName.equals("body")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InBody);
                    return true;
                } else if (normalName.equals("frameset")) {
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InFrameset);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                    htmlTreeBuilder.error(this);
                    Element headElement = htmlTreeBuilder.getHeadElement();
                    htmlTreeBuilder.push(headElement);
                    htmlTreeBuilder.process(token, InHead);
                    htmlTreeBuilder.removeFromStack(headElement);
                    return true;
                } else if (normalName.equals(TtmlNode.TAG_HEAD)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                }
            } else if (token.isEndTag()) {
                String normalName2 = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName2, Constants.AfterHeadBody)) {
                    anythingElse(token, htmlTreeBuilder);
                    return true;
                } else if (normalName2.equals("template")) {
                    htmlTreeBuilder.process(token, InHead);
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    return false;
                }
            } else {
                anythingElse(token, htmlTreeBuilder);
                return true;
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag("body");
            htmlTreeBuilder.framesetOk(true);
            return htmlTreeBuilder.process(token);
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        private static final int MaxStackScan = 24;

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (C541425.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    return true;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    return inBodyStartTag(token, htmlTreeBuilder);
                case 4:
                    return inBodyEndTag(token, htmlTreeBuilder);
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else if (htmlTreeBuilder.framesetOk() && HtmlTreeBuilderState.isWhitespace(asCharacter)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                        return true;
                    } else {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insert(asCharacter);
                        htmlTreeBuilder.framesetOk(false);
                        return true;
                    }
                case 6:
                    if (htmlTreeBuilder.templateModeSize() > 0) {
                        return htmlTreeBuilder.process(token, InTemplate);
                    }
                    return true;
                default:
                    return true;
            }
        }

        private boolean inBodyStartTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            FormElement formElement;
            Token.StartTag asStartTag = token.asStartTag();
            String normalName = asStartTag.normalName();
            normalName.hashCode();
            char c = 65535;
            switch (normalName.hashCode()) {
                case -1644953643:
                    if (normalName.equals("frameset")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1377687758:
                    if (normalName.equals("button")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1191214428:
                    if (normalName.equals("iframe")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1010136971:
                    if (normalName.equals("option")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1003243718:
                    if (normalName.equals("textarea")) {
                        c = 4;
                        break;
                    }
                    break;
                case -906021636:
                    if (normalName.equals("select")) {
                        c = 5;
                        break;
                    }
                    break;
                case -80773204:
                    if (normalName.equals("optgroup")) {
                        c = 6;
                        break;
                    }
                    break;
                case 97:
                    if (normalName.equals("a")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3200:
                    if (normalName.equals("dd")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3273:
                    if (normalName.equals("h1")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3274:
                    if (normalName.equals("h2")) {
                        c = 11;
                        break;
                    }
                    break;
                case 3275:
                    if (normalName.equals("h3")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 3276:
                    if (normalName.equals("h4")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 3277:
                    if (normalName.equals("h5")) {
                        c = 14;
                        break;
                    }
                    break;
                case 3278:
                    if (normalName.equals("h6")) {
                        c = 15;
                        break;
                    }
                    break;
                case 3338:
                    if (normalName.equals("hr")) {
                        c = 16;
                        break;
                    }
                    break;
                case 3453:
                    if (normalName.equals("li")) {
                        c = 17;
                        break;
                    }
                    break;
                case 3646:
                    if (normalName.equals("rp")) {
                        c = 18;
                        break;
                    }
                    break;
                case 3650:
                    if (normalName.equals("rt")) {
                        c = 19;
                        break;
                    }
                    break;
                case 111267:
                    if (normalName.equals("pre")) {
                        c = 20;
                        break;
                    }
                    break;
                case 114276:
                    if (normalName.equals("svg")) {
                        c = 21;
                        break;
                    }
                    break;
                case 118811:
                    if (normalName.equals("xmp")) {
                        c = 22;
                        break;
                    }
                    break;
                case 3029410:
                    if (normalName.equals("body")) {
                        c = 23;
                        break;
                    }
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c = 24;
                        break;
                    }
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = 25;
                        break;
                    }
                    break;
                case 3344136:
                    if (normalName.equals("math")) {
                        c = 26;
                        break;
                    }
                    break;
                case 3386833:
                    if (normalName.equals("nobr")) {
                        c = 27;
                        break;
                    }
                    break;
                case 3536714:
                    if (normalName.equals(TtmlNode.TAG_SPAN)) {
                        c = 28;
                        break;
                    }
                    break;
                case 100313435:
                    if (normalName.equals("image")) {
                        c = 29;
                        break;
                    }
                    break;
                case 100358090:
                    if (normalName.equals(TvContractCompat.PARAM_INPUT)) {
                        c = 30;
                        break;
                    }
                    break;
                case 110115790:
                    if (normalName.equals("table")) {
                        c = 31;
                        break;
                    }
                    break;
                case 181975684:
                    if (normalName.equals("listing")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 1973234167:
                    if (normalName.equals("plaintext")) {
                        c = '!';
                        break;
                    }
                    break;
                case 2091304424:
                    if (normalName.equals("isindex")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 2115613112:
                    if (normalName.equals("noembed")) {
                        c = '#';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack = htmlTreeBuilder.getStack();
                    if (stack.size() != 1) {
                        if ((stack.size() <= 2 || stack.get(1).normalName().equals("body")) && htmlTreeBuilder.framesetOk()) {
                            Element element = stack.get(1);
                            if (element.parent() != null) {
                                element.remove();
                            }
                            while (stack.size() > 1) {
                                stack.remove(stack.size() - 1);
                            }
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.transition(InFrameset);
                            return true;
                        }
                        return false;
                    }
                    return false;
                case 1:
                    if (htmlTreeBuilder.inButtonScope("button")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("button");
                        htmlTreeBuilder.process(asStartTag);
                        return true;
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    return true;
                case 2:
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    break;
                case 3:
                case 6:
                    if (htmlTreeBuilder.currentElementIs("option")) {
                        htmlTreeBuilder.processEndTag("option");
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 4:
                    htmlTreeBuilder.insert(asStartTag);
                    if (!asStartTag.isSelfClosing()) {
                        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
                        htmlTreeBuilder.markInsertionMode();
                        htmlTreeBuilder.framesetOk(false);
                        htmlTreeBuilder.transition(Text);
                        break;
                    }
                    break;
                case 5:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    if (!asStartTag.selfClosing) {
                        HtmlTreeBuilderState state = htmlTreeBuilder.state();
                        if (state.equals(InTable) || state.equals(InCaption) || state.equals(InTableBody) || state.equals(InRow) || state.equals(InCell)) {
                            htmlTreeBuilder.transition(InSelectInTable);
                            break;
                        } else {
                            htmlTreeBuilder.transition(InSelect);
                            break;
                        }
                    }
                    break;
                case 7:
                    if (htmlTreeBuilder.getActiveFormattingElement("a") != null) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("a");
                        Element fromStack = htmlTreeBuilder.getFromStack("a");
                        if (fromStack != null) {
                            htmlTreeBuilder.removeFromActiveFormattingElements(fromStack);
                            htmlTreeBuilder.removeFromStack(fromStack);
                        }
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    break;
                case '\b':
                case '\t':
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack2 = htmlTreeBuilder.getStack();
                    int size = stack2.size() - 1;
                    int i = size >= 24 ? size - 24 : 0;
                    while (true) {
                        if (size >= i) {
                            Element element2 = stack2.get(size);
                            if (StringUtil.inSorted(element2.normalName(), Constants.DdDt)) {
                                htmlTreeBuilder.processEndTag(element2.normalName());
                            } else if (!htmlTreeBuilder.isSpecial(element2) || StringUtil.inSorted(element2.normalName(), Constants.InBodyStartLiBreakers)) {
                                size--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case 14:
                case 15:
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.pop();
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 16:
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insertEmpty(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    break;
                case 17:
                    htmlTreeBuilder.framesetOk(false);
                    ArrayList<Element> stack3 = htmlTreeBuilder.getStack();
                    int size2 = stack3.size() - 1;
                    while (true) {
                        if (size2 > 0) {
                            Element element3 = stack3.get(size2);
                            if (element3.normalName().equals("li")) {
                                htmlTreeBuilder.processEndTag("li");
                            } else if (!htmlTreeBuilder.isSpecial(element3) || StringUtil.inSorted(element3.normalName(), Constants.InBodyStartLiBreakers)) {
                                size2--;
                            }
                        }
                    }
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 18:
                case 19:
                    if (htmlTreeBuilder.inScope(TtmlNode.ATTR_TTS_RUBY)) {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(TtmlNode.ATTR_TTS_RUBY)) {
                            htmlTreeBuilder.error(this);
                            htmlTreeBuilder.popStackToBefore(TtmlNode.ATTR_TTS_RUBY);
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    }
                    break;
                case 20:
                case ' ':
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.reader.matchConsume("\n");
                    htmlTreeBuilder.framesetOk(false);
                    break;
                case 21:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 22:
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.framesetOk(false);
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    break;
                case 23:
                    htmlTreeBuilder.error(this);
                    ArrayList<Element> stack4 = htmlTreeBuilder.getStack();
                    if (stack4.size() == 1) {
                        return false;
                    }
                    if ((stack4.size() > 2 && !stack4.get(1).normalName().equals("body")) || htmlTreeBuilder.onStack("template")) {
                        return false;
                    }
                    htmlTreeBuilder.framesetOk(false);
                    Element element4 = stack4.get(1);
                    if (asStartTag.hasAttributes()) {
                        Iterator<Attribute> it = asStartTag.attributes.iterator();
                        while (it.hasNext()) {
                            Attribute next = it.next();
                            if (!element4.hasAttr(next.getKey())) {
                                element4.attributes().put(next);
                            }
                        }
                        break;
                    }
                    break;
                case 24:
                    if (htmlTreeBuilder.getFormElement() != null && !htmlTreeBuilder.onStack("template")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.closeElement(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insertForm(asStartTag, true, true);
                    break;
                    break;
                case 25:
                    htmlTreeBuilder.error(this);
                    if (!htmlTreeBuilder.onStack("template")) {
                        if (htmlTreeBuilder.getStack().size() > 0) {
                            Element element5 = htmlTreeBuilder.getStack().get(0);
                            if (asStartTag.hasAttributes()) {
                                Iterator<Attribute> it2 = asStartTag.attributes.iterator();
                                while (it2.hasNext()) {
                                    Attribute next2 = it2.next();
                                    if (!element5.hasAttr(next2.getKey())) {
                                        element5.attributes().put(next2);
                                    }
                                }
                                break;
                            }
                        }
                    } else {
                        return false;
                    }
                    break;
                case 26:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 27:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (htmlTreeBuilder.inScope("nobr")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processEndTag("nobr");
                        htmlTreeBuilder.reconstructFormattingElements();
                    }
                    htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                    break;
                case 28:
                    htmlTreeBuilder.reconstructFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 29:
                    if (htmlTreeBuilder.getFromStack("svg") == null) {
                        return htmlTreeBuilder.process(asStartTag.name("img"));
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    break;
                case 30:
                    htmlTreeBuilder.reconstructFormattingElements();
                    if (!htmlTreeBuilder.insertEmpty(asStartTag).attr("type").equalsIgnoreCase("hidden")) {
                        htmlTreeBuilder.framesetOk(false);
                        break;
                    }
                    break;
                case 31:
                    if (htmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.framesetOk(false);
                    htmlTreeBuilder.transition(InTable);
                    break;
                case '!':
                    if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                        htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                    }
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT);
                    break;
                case '\"':
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.getFormElement() == null) {
                        htmlTreeBuilder.processStartTag("form");
                        if (asStartTag.hasAttribute("action") && (formElement = htmlTreeBuilder.getFormElement()) != null && asStartTag.hasAttribute("action")) {
                            formElement.attributes().put("action", asStartTag.attributes.get("action"));
                        }
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processStartTag(Constants.ScionAnalytics.PARAM_LABEL);
                        htmlTreeBuilder.process(new Token.Character().data(asStartTag.hasAttribute("prompt") ? asStartTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: "));
                        Attributes attributes = new Attributes();
                        if (asStartTag.hasAttributes()) {
                            Iterator<Attribute> it3 = asStartTag.attributes.iterator();
                            while (it3.hasNext()) {
                                Attribute next3 = it3.next();
                                if (!StringUtil.inSorted(next3.getKey(), Constants.InBodyStartInputAttribs)) {
                                    attributes.put(next3);
                                }
                            }
                        }
                        attributes.put("name", "isindex");
                        htmlTreeBuilder.processStartTag(TvContractCompat.PARAM_INPUT, attributes);
                        htmlTreeBuilder.processEndTag(Constants.ScionAnalytics.PARAM_LABEL);
                        htmlTreeBuilder.processStartTag("hr");
                        htmlTreeBuilder.processEndTag("form");
                        break;
                    } else {
                        return false;
                    }
                case '#':
                    HtmlTreeBuilderState.handleRawtext(asStartTag, htmlTreeBuilder);
                    break;
                default:
                    if (!Tag.isKnownTag(normalName)) {
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartEmptyFormatters)) {
                        htmlTreeBuilder.reconstructFormattingElements();
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        htmlTreeBuilder.framesetOk(false);
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartPClosers)) {
                        if (htmlTreeBuilder.inButtonScope(TtmlNode.TAG_P)) {
                            htmlTreeBuilder.processEndTag(TtmlNode.TAG_P);
                        }
                        htmlTreeBuilder.insert(asStartTag);
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartToHead)) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        if (StringUtil.inSorted(normalName, Constants.Formatters)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.pushActiveFormattingElements(htmlTreeBuilder.insert(asStartTag));
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            htmlTreeBuilder.insertMarkerToFormattingElements();
                            htmlTreeBuilder.framesetOk(false);
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartMedia)) {
                            htmlTreeBuilder.insertEmpty(asStartTag);
                        } else if (StringUtil.inSorted(normalName, Constants.InBodyStartDrop)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        } else {
                            htmlTreeBuilder.reconstructFormattingElements();
                            htmlTreeBuilder.insert(asStartTag);
                            break;
                        }
                    }
                    break;
            }
            return true;
        }

        private boolean inBodyEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Token.EndTag asEndTag = token.asEndTag();
            String normalName = asEndTag.normalName();
            normalName.hashCode();
            char c = 65535;
            switch (normalName.hashCode()) {
                case -1321546630:
                    if (normalName.equals("template")) {
                        c = 0;
                        break;
                    }
                    break;
                case 112:
                    if (normalName.equals(TtmlNode.TAG_P)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3152:
                    if (normalName.equals(TtmlNode.TAG_BR)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3200:
                    if (normalName.equals("dd")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3216:
                    if (normalName.equals("dt")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3273:
                    if (normalName.equals("h1")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3274:
                    if (normalName.equals("h2")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3275:
                    if (normalName.equals("h3")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3276:
                    if (normalName.equals("h4")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3277:
                    if (normalName.equals("h5")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 3278:
                    if (normalName.equals("h6")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3453:
                    if (normalName.equals("li")) {
                        c = 11;
                        break;
                    }
                    break;
                case 3029410:
                    if (normalName.equals("body")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 3148996:
                    if (normalName.equals("form")) {
                        c = '\r';
                        break;
                    }
                    break;
                case 3213227:
                    if (normalName.equals("html")) {
                        c = 14;
                        break;
                    }
                    break;
                case 3536714:
                    if (normalName.equals(TtmlNode.TAG_SPAN)) {
                        c = 15;
                        break;
                    }
                    break;
                case 1869063452:
                    if (normalName.equals("sarcasm")) {
                        c = 16;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    htmlTreeBuilder.process(token, InHead);
                    break;
                case 1:
                    if (!htmlTreeBuilder.inButtonScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.processStartTag(normalName);
                        return htmlTreeBuilder.process(asEndTag);
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElementIs(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    break;
                case 2:
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag(TtmlNode.TAG_BR);
                    return false;
                case 3:
                case 4:
                    if (!htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElementIs(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    break;
                case 5:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                    if (!htmlTreeBuilder.inScope(Constants.Headings)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElementIs(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(Constants.Headings);
                    break;
                case 11:
                    if (!htmlTreeBuilder.inListItemScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags(normalName);
                    if (!htmlTreeBuilder.currentElementIs(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    break;
                case '\f':
                    if (!htmlTreeBuilder.inScope("body")) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(AfterBody);
                    break;
                case '\r':
                    if (!htmlTreeBuilder.onStack("template")) {
                        FormElement formElement = htmlTreeBuilder.getFormElement();
                        htmlTreeBuilder.setFormElement(null);
                        if (formElement == null || !htmlTreeBuilder.inScope(normalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.removeFromStack(formElement);
                        break;
                    } else if (!htmlTreeBuilder.inScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(normalName);
                        break;
                    }
                case 14:
                    if (htmlTreeBuilder.processEndTag("body")) {
                        return htmlTreeBuilder.process(asEndTag);
                    }
                    break;
                case 15:
                case 16:
                    return anyOtherEndTag(token, htmlTreeBuilder);
                default:
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndAdoptionFormatters)) {
                        return inBodyEndTagAdoption(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(normalName, Constants.InBodyEndClosers)) {
                        if (!htmlTreeBuilder.inScope(normalName)) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.generateImpliedEndTags();
                        if (!htmlTreeBuilder.currentElementIs(normalName)) {
                            htmlTreeBuilder.error(this);
                        }
                        htmlTreeBuilder.popStackToClose(normalName);
                        break;
                    } else if (StringUtil.inSorted(normalName, Constants.InBodyStartApplets)) {
                        if (!htmlTreeBuilder.inScope("name")) {
                            if (!htmlTreeBuilder.inScope(normalName)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.generateImpliedEndTags();
                            if (!htmlTreeBuilder.currentElementIs(normalName)) {
                                htmlTreeBuilder.error(this);
                            }
                            htmlTreeBuilder.popStackToClose(normalName);
                            htmlTreeBuilder.clearFormattingElementsToLastMarker();
                            break;
                        }
                    } else {
                        return anyOtherEndTag(token, htmlTreeBuilder);
                    }
                    break;
            }
            return true;
        }

        boolean anyOtherEndTag(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String str = token.asEndTag().normalName;
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            if (htmlTreeBuilder.getFromStack(str) == null) {
                htmlTreeBuilder.error(this);
                return false;
            }
            int size = stack.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = stack.get(size);
                if (element.normalName().equals(str)) {
                    htmlTreeBuilder.generateImpliedEndTags(str);
                    if (!htmlTreeBuilder.currentElementIs(str)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(str);
                } else if (htmlTreeBuilder.isSpecial(element)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }

        private boolean inBodyEndTagAdoption(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String normalName = token.asEndTag().normalName();
            ArrayList<Element> stack = htmlTreeBuilder.getStack();
            boolean z = false;
            int i = 0;
            while (i < 8) {
                Element activeFormattingElement = htmlTreeBuilder.getActiveFormattingElement(normalName);
                if (activeFormattingElement == null) {
                    return anyOtherEndTag(token, htmlTreeBuilder);
                }
                if (!htmlTreeBuilder.onStack(activeFormattingElement)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    return true;
                } else if (!htmlTreeBuilder.inScope(activeFormattingElement.normalName())) {
                    htmlTreeBuilder.error(this);
                    return z;
                } else {
                    if (htmlTreeBuilder.currentElement() != activeFormattingElement) {
                        htmlTreeBuilder.error(this);
                    }
                    int size = stack.size();
                    int i2 = -1;
                    Element element = null;
                    Element element2 = null;
                    int i3 = 1;
                    boolean z2 = false;
                    while (true) {
                        if (i3 >= size || i3 >= 64) {
                            break;
                        }
                        Element element3 = stack.get(i3);
                        if (element3 == activeFormattingElement) {
                            element2 = stack.get(i3 - 1);
                            i2 = htmlTreeBuilder.positionOfElement(element3);
                            z2 = true;
                        } else if (z2 && htmlTreeBuilder.isSpecial(element3)) {
                            element = element3;
                            break;
                        }
                        i3++;
                    }
                    if (element == null) {
                        htmlTreeBuilder.popStackToClose(activeFormattingElement.normalName());
                        htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                        return true;
                    }
                    Element element4 = element;
                    Element element5 = element4;
                    for (int i4 = 0; i4 < 3; i4++) {
                        if (htmlTreeBuilder.onStack(element4)) {
                            element4 = htmlTreeBuilder.aboveOnStack(element4);
                        }
                        if (!htmlTreeBuilder.isInActiveFormattingElements(element4)) {
                            htmlTreeBuilder.removeFromStack(element4);
                        } else if (element4 == activeFormattingElement) {
                            break;
                        } else {
                            Element element6 = new Element(htmlTreeBuilder.tagFor(element4.nodeName(), ParseSettings.preserveCase), htmlTreeBuilder.getBaseUri());
                            htmlTreeBuilder.replaceActiveFormattingElement(element4, element6);
                            htmlTreeBuilder.replaceOnStack(element4, element6);
                            if (element5 == element) {
                                i2 = htmlTreeBuilder.positionOfElement(element6) + 1;
                            }
                            if (element5.parent() != null) {
                                element5.remove();
                            }
                            element6.appendChild(element5);
                            element4 = element6;
                            element5 = element4;
                        }
                    }
                    if (element2 != null) {
                        if (StringUtil.inSorted(element2.normalName(), Constants.InBodyEndTableFosters)) {
                            if (element5.parent() != null) {
                                element5.remove();
                            }
                            htmlTreeBuilder.insertInFosterParent(element5);
                        } else {
                            if (element5.parent() != null) {
                                element5.remove();
                            }
                            element2.appendChild(element5);
                        }
                    }
                    Element element7 = new Element(activeFormattingElement.tag(), htmlTreeBuilder.getBaseUri());
                    element7.attributes().addAll(activeFormattingElement.attributes());
                    element7.appendChildren(element.childNodes());
                    element.appendChild(element7);
                    htmlTreeBuilder.removeFromActiveFormattingElements(activeFormattingElement);
                    htmlTreeBuilder.pushWithBookmark(element7, i2);
                    htmlTreeBuilder.removeFromStack(activeFormattingElement);
                    htmlTreeBuilder.insertOnStackAfter(element, element7);
                    i++;
                    z = false;
                }
            }
            return true;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter()) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isEOF()) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return htmlTreeBuilder.process(token);
            } else if (token.isEndTag()) {
                htmlTreeBuilder.pop();
                htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
                return true;
            } else {
                return true;
            }
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isCharacter() && StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                htmlTreeBuilder.newPendingTableCharacters();
                htmlTreeBuilder.markInsertionMode();
                htmlTreeBuilder.transition(InTableText);
                return htmlTreeBuilder.process(token);
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("caption")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCaption);
                } else if (normalName.equals("colgroup")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InColumnGroup);
                } else if (normalName.equals("col")) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                } else if (StringUtil.inSorted(normalName, Constants.InTableToBody)) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InTableBody);
                } else if (StringUtil.inSorted(normalName, Constants.InTableAddBody)) {
                    htmlTreeBuilder.clearStackToTableContext();
                    htmlTreeBuilder.processStartTag("tbody");
                    return htmlTreeBuilder.process(token);
                } else if (normalName.equals("table")) {
                    htmlTreeBuilder.error(this);
                    if (htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.popStackToClose(normalName);
                        htmlTreeBuilder.resetInsertionMode();
                        if (htmlTreeBuilder.state() == InTable) {
                            htmlTreeBuilder.insert(asStartTag);
                            return true;
                        }
                        return htmlTreeBuilder.process(token);
                    }
                    return false;
                } else if (StringUtil.inSorted(normalName, Constants.InTableToHead)) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (normalName.equals(TvContractCompat.PARAM_INPUT)) {
                        if (!asStartTag.hasAttributes() || !asStartTag.attributes.get("type").equalsIgnoreCase("hidden")) {
                            return anythingElse(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.insertEmpty(asStartTag);
                    } else if (normalName.equals("form")) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.getFormElement() != null || htmlTreeBuilder.onStack("template")) {
                            return false;
                        }
                        htmlTreeBuilder.insertForm(asStartTag, false, false);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
                return true;
            } else if (token.isEndTag()) {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("table")) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.popStackToClose("table");
                    htmlTreeBuilder.resetInsertionMode();
                } else if (StringUtil.inSorted(normalName2, Constants.InTableEndErr)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (normalName2.equals("template")) {
                    htmlTreeBuilder.process(token, InHead);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
                return true;
            } else if (token.isEOF()) {
                if (htmlTreeBuilder.currentElementIs("html")) {
                    htmlTreeBuilder.error(this);
                }
                return true;
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            htmlTreeBuilder.setFosterInserts(true);
            htmlTreeBuilder.process(token, InBody);
            htmlTreeBuilder.setFosterInserts(false);
            return true;
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.type == Token.TokenType.Character) {
                Token.Character asCharacter = token.asCharacter();
                if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.getPendingTableCharacters().add(asCharacter.getData());
                return true;
            }
            if (htmlTreeBuilder.getPendingTableCharacters().size() > 0) {
                for (String str : htmlTreeBuilder.getPendingTableCharacters()) {
                    if (!HtmlTreeBuilderState.isWhitespace(str)) {
                        htmlTreeBuilder.error(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), Constants.InTableFoster)) {
                            htmlTreeBuilder.setFosterInserts(true);
                            htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                            htmlTreeBuilder.setFosterInserts(false);
                        } else {
                            htmlTreeBuilder.process(new Token.Character().data(str), InBody);
                        }
                    } else {
                        htmlTreeBuilder.insert(new Token.Character().data(str));
                    }
                }
                htmlTreeBuilder.newPendingTableCharacters();
            }
            htmlTreeBuilder.transition(htmlTreeBuilder.originalState());
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag() && token.asEndTag().normalName().equals("caption")) {
                if (!htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.generateImpliedEndTags();
                if (!htmlTreeBuilder.currentElementIs("caption")) {
                    htmlTreeBuilder.error(this);
                }
                htmlTreeBuilder.popStackToClose("caption");
                htmlTreeBuilder.clearFormattingElementsToLastMarker();
                htmlTreeBuilder.transition(InTable);
                return true;
            } else if ((token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) || (token.isEndTag() && token.asEndTag().normalName().equals("table"))) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.processEndTag("caption")) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InCaptionIgnore)) {
                htmlTreeBuilder.error(this);
                return false;
            } else {
                return htmlTreeBuilder.process(token, InBody);
            }
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
            if (r3.equals("html") == false) goto L38;
         */
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean process(org.jsoup.parser.Token r10, org.jsoup.parser.HtmlTreeBuilder r11) {
            /*
                r9 = this;
                boolean r0 = org.jsoup.parser.HtmlTreeBuilderState.access$100(r10)
                r1 = 1
                if (r0 == 0) goto Lf
                org.jsoup.parser.Token$Character r10 = r10.asCharacter()
                r11.insert(r10)
                return r1
            Lf:
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.C541425.$SwitchMap$org$jsoup$parser$Token$TokenType
                org.jsoup.parser.Token$TokenType r2 = r10.type
                int r2 = r2.ordinal()
                r0 = r0[r2]
                if (r0 == r1) goto Lc0
                r2 = 2
                if (r0 == r2) goto Lbc
                r3 = 3
                java.lang.String r4 = "html"
                r5 = 0
                java.lang.String r6 = "template"
                if (r0 == r3) goto L74
                r2 = 4
                if (r0 == r2) goto L3d
                r2 = 6
                if (r0 == r2) goto L31
                boolean r10 = r9.anythingElse(r10, r11)
                return r10
            L31:
                boolean r0 = r11.currentElementIs(r4)
                if (r0 == 0) goto L38
                return r1
            L38:
                boolean r10 = r9.anythingElse(r10, r11)
                return r10
            L3d:
                org.jsoup.parser.Token$EndTag r0 = r10.asEndTag()
                java.lang.String r0 = r0.normalName()
                r0.hashCode()
                boolean r2 = r0.equals(r6)
                if (r2 != 0) goto L6e
                java.lang.String r2 = "colgroup"
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L5b
                boolean r10 = r9.anythingElse(r10, r11)
                return r10
            L5b:
                boolean r10 = r11.currentElementIs(r0)
                if (r10 != 0) goto L65
                r11.error(r9)
                return r5
            L65:
                r11.pop()
                org.jsoup.parser.HtmlTreeBuilderState r10 = org.jsoup.parser.HtmlTreeBuilderState.C540012.InTable
                r11.transition(r10)
                goto Lc7
            L6e:
                org.jsoup.parser.HtmlTreeBuilderState r0 = org.jsoup.parser.HtmlTreeBuilderState.C540012.InHead
                r11.process(r10, r0)
                goto Lc7
            L74:
                org.jsoup.parser.Token$StartTag r0 = r10.asStartTag()
                java.lang.String r3 = r0.normalName()
                r3.hashCode()
                r7 = -1
                int r8 = r3.hashCode()
                switch(r8) {
                    case -1321546630: goto L9b;
                    case 98688: goto L90;
                    case 3213227: goto L89;
                    default: goto L87;
                }
            L87:
                r2 = -1
                goto La3
            L89:
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto La3
                goto L87
            L90:
                java.lang.String r2 = "col"
                boolean r2 = r3.equals(r2)
                if (r2 != 0) goto L99
                goto L87
            L99:
                r2 = 1
                goto La3
            L9b:
                boolean r2 = r3.equals(r6)
                if (r2 != 0) goto La2
                goto L87
            La2:
                r2 = 0
            La3:
                switch(r2) {
                    case 0: goto Lb6;
                    case 1: goto Lb2;
                    case 2: goto Lab;
                    default: goto La6;
                }
            La6:
                boolean r10 = r9.anythingElse(r10, r11)
                return r10
            Lab:
                org.jsoup.parser.HtmlTreeBuilderState r0 = org.jsoup.parser.HtmlTreeBuilderState.C540012.InBody
                boolean r10 = r11.process(r10, r0)
                return r10
            Lb2:
                r11.insertEmpty(r0)
                goto Lc7
            Lb6:
                org.jsoup.parser.HtmlTreeBuilderState r0 = org.jsoup.parser.HtmlTreeBuilderState.C540012.InHead
                r11.process(r10, r0)
                goto Lc7
            Lbc:
                r11.error(r9)
                goto Lc7
            Lc0:
                org.jsoup.parser.Token$Comment r10 = r10.asComment()
                r11.insert(r10)
            Lc7:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.C540012.process(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.currentElementIs("colgroup")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.pop();
            htmlTreeBuilder.transition(InTable);
            htmlTreeBuilder.process(token);
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int i = C541425.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()];
            if (i == 3) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (normalName.equals("tr")) {
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InRow);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.processStartTag("tr");
                    return htmlTreeBuilder.process(asStartTag);
                } else if (StringUtil.inSorted(normalName, Constants.InTableBodyExit)) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (i == 4) {
                String normalName2 = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName2, Constants.InTableEndIgnore)) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableBodyContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTable);
                    return true;
                } else if (normalName2.equals("table")) {
                    return exitTableBody(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.inSorted(normalName2, Constants.InTableBodyEndIgnore)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean exitTableBody(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!htmlTreeBuilder.inTableScope("tbody") && !htmlTreeBuilder.inTableScope("thead") && !htmlTreeBuilder.inScope("tfoot")) {
                htmlTreeBuilder.error(this);
                return false;
            }
            htmlTreeBuilder.clearStackToTableBodyContext();
            htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
            return htmlTreeBuilder.process(token);
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.insert(asStartTag);
                    htmlTreeBuilder.transition(InCell);
                    htmlTreeBuilder.insertMarkerToFormattingElements();
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InRowMissing)) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (token.isEndTag()) {
                String normalName2 = token.asEndTag().normalName();
                if (normalName2.equals("tr")) {
                    if (!htmlTreeBuilder.inTableScope(normalName2)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.clearStackToTableRowContext();
                    htmlTreeBuilder.pop();
                    htmlTreeBuilder.transition(InTableBody);
                    return true;
                } else if (normalName2.equals("table")) {
                    return handleMissingTr(token, htmlTreeBuilder);
                } else {
                    if (StringUtil.inSorted(normalName2, Constants.InTableToBody)) {
                        if (!htmlTreeBuilder.inTableScope(normalName2) || !htmlTreeBuilder.inTableScope("tr")) {
                            htmlTreeBuilder.error(this);
                            return false;
                        }
                        htmlTreeBuilder.clearStackToTableRowContext();
                        htmlTreeBuilder.pop();
                        htmlTreeBuilder.transition(InTableBody);
                        return true;
                    } else if (StringUtil.inSorted(normalName2, Constants.InRowIgnore)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                }
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InTable);
        }

        private boolean handleMissingTr(Token token, TreeBuilder treeBuilder) {
            if (treeBuilder.processEndTag("tr")) {
                return treeBuilder.process(token);
            }
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isEndTag()) {
                String normalName = token.asEndTag().normalName();
                if (StringUtil.inSorted(normalName, Constants.InCellNames)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.transition(InRow);
                        return false;
                    }
                    htmlTreeBuilder.generateImpliedEndTags();
                    if (!htmlTreeBuilder.currentElementIs(normalName)) {
                        htmlTreeBuilder.error(this);
                    }
                    htmlTreeBuilder.popStackToClose(normalName);
                    htmlTreeBuilder.clearFormattingElementsToLastMarker();
                    htmlTreeBuilder.transition(InRow);
                    return true;
                } else if (StringUtil.inSorted(normalName, Constants.InCellBody)) {
                    htmlTreeBuilder.error(this);
                    return false;
                } else if (StringUtil.inSorted(normalName, Constants.InCellTable)) {
                    if (!htmlTreeBuilder.inTableScope(normalName)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    closeCell(htmlTreeBuilder);
                    return htmlTreeBuilder.process(token);
                } else {
                    return anythingElse(token, htmlTreeBuilder);
                }
            } else if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InCellCol)) {
                if (!htmlTreeBuilder.inTableScope("td") && !htmlTreeBuilder.inTableScope("th")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                closeCell(htmlTreeBuilder);
                return htmlTreeBuilder.process(token);
            } else {
                return anythingElse(token, htmlTreeBuilder);
            }
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.process(token, InBody);
        }

        private void closeCell(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.inTableScope("td")) {
                htmlTreeBuilder.processEndTag("td");
            } else {
                htmlTreeBuilder.processEndTag("th");
            }
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (C541425.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                    htmlTreeBuilder.insert(token.asComment());
                    break;
                case 2:
                    htmlTreeBuilder.error(this);
                    return false;
                case 3:
                    Token.StartTag asStartTag = token.asStartTag();
                    String normalName = asStartTag.normalName();
                    if (normalName.equals("html")) {
                        return htmlTreeBuilder.process(asStartTag, InBody);
                    }
                    if (normalName.equals("option")) {
                        if (htmlTreeBuilder.currentElementIs("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (normalName.equals("optgroup")) {
                        if (htmlTreeBuilder.currentElementIs("option")) {
                            htmlTreeBuilder.processEndTag("option");
                        }
                        if (htmlTreeBuilder.currentElementIs("optgroup")) {
                            htmlTreeBuilder.processEndTag("optgroup");
                        }
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    } else if (normalName.equals("select")) {
                        htmlTreeBuilder.error(this);
                        return htmlTreeBuilder.processEndTag("select");
                    } else if (StringUtil.inSorted(normalName, Constants.InSelectEnd)) {
                        htmlTreeBuilder.error(this);
                        if (htmlTreeBuilder.inSelectScope("select")) {
                            htmlTreeBuilder.processEndTag("select");
                            return htmlTreeBuilder.process(asStartTag);
                        }
                        return false;
                    } else if (normalName.equals("script") || normalName.equals("template")) {
                        return htmlTreeBuilder.process(token, InHead);
                    } else {
                        return anythingElse(token, htmlTreeBuilder);
                    }
                    break;
                case 4:
                    String normalName2 = token.asEndTag().normalName();
                    normalName2.hashCode();
                    char c = 65535;
                    switch (normalName2.hashCode()) {
                        case -1321546630:
                            if (normalName2.equals("template")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1010136971:
                            if (normalName2.equals("option")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -906021636:
                            if (normalName2.equals("select")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -80773204:
                            if (normalName2.equals("optgroup")) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return htmlTreeBuilder.process(token, InHead);
                        case 1:
                            if (htmlTreeBuilder.currentElementIs("option")) {
                                htmlTreeBuilder.pop();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                break;
                            }
                        case 2:
                            if (!htmlTreeBuilder.inSelectScope(normalName2)) {
                                htmlTreeBuilder.error(this);
                                return false;
                            }
                            htmlTreeBuilder.popStackToClose(normalName2);
                            htmlTreeBuilder.resetInsertionMode();
                            break;
                        case 3:
                            if (htmlTreeBuilder.currentElementIs("option") && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()) != null && htmlTreeBuilder.aboveOnStack(htmlTreeBuilder.currentElement()).normalName().equals("optgroup")) {
                                htmlTreeBuilder.processEndTag("option");
                            }
                            if (htmlTreeBuilder.currentElementIs("optgroup")) {
                                htmlTreeBuilder.pop();
                                break;
                            } else {
                                htmlTreeBuilder.error(this);
                                break;
                            }
                            break;
                        default:
                            return anythingElse(token, htmlTreeBuilder);
                    }
                case 5:
                    Token.Character asCharacter = token.asCharacter();
                    if (asCharacter.getData().equals(HtmlTreeBuilderState.nullString)) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.insert(asCharacter);
                    break;
                case 6:
                    if (!htmlTreeBuilder.currentElementIs("html")) {
                        htmlTreeBuilder.error(this);
                        break;
                    }
                    break;
                default:
                    return anythingElse(token, htmlTreeBuilder);
            }
            return true;
        }

        private boolean anythingElse(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.error(this);
            return false;
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isStartTag() && StringUtil.inSorted(token.asStartTag().normalName(), Constants.InSelectTableEnd)) {
                htmlTreeBuilder.error(this);
                htmlTreeBuilder.popStackToClose("select");
                htmlTreeBuilder.resetInsertionMode();
                return htmlTreeBuilder.process(token);
            } else if (token.isEndTag() && StringUtil.inSorted(token.asEndTag().normalName(), Constants.InSelectTableEnd)) {
                htmlTreeBuilder.error(this);
                if (htmlTreeBuilder.inTableScope(token.asEndTag().normalName())) {
                    htmlTreeBuilder.popStackToClose("select");
                    htmlTreeBuilder.resetInsertionMode();
                    return htmlTreeBuilder.process(token);
                }
                return false;
            } else {
                return htmlTreeBuilder.process(token, InSelect);
            }
        }
    },
    InTemplate { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (C541425.$SwitchMap$org$jsoup$parser$Token$TokenType[token.type.ordinal()]) {
                case 1:
                case 2:
                case 5:
                    htmlTreeBuilder.process(token, InBody);
                    break;
                case 3:
                    String normalName = token.asStartTag().normalName();
                    if (StringUtil.inSorted(normalName, Constants.InTemplateToHead)) {
                        htmlTreeBuilder.process(token, InHead);
                        break;
                    } else if (StringUtil.inSorted(normalName, Constants.InTemplateToTable)) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InTable);
                        htmlTreeBuilder.transition(InTable);
                        return htmlTreeBuilder.process(token);
                    } else if (normalName.equals("col")) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InColumnGroup);
                        htmlTreeBuilder.transition(InColumnGroup);
                        return htmlTreeBuilder.process(token);
                    } else if (normalName.equals("tr")) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InTableBody);
                        htmlTreeBuilder.transition(InTableBody);
                        return htmlTreeBuilder.process(token);
                    } else if (normalName.equals("td") || normalName.equals("th")) {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InRow);
                        htmlTreeBuilder.transition(InRow);
                        return htmlTreeBuilder.process(token);
                    } else {
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.pushTemplateMode(InBody);
                        htmlTreeBuilder.transition(InBody);
                        return htmlTreeBuilder.process(token);
                    }
                    break;
                case 4:
                    if (token.asEndTag().normalName().equals("template")) {
                        htmlTreeBuilder.process(token, InHead);
                        break;
                    } else {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                case 6:
                    if (htmlTreeBuilder.onStack("template")) {
                        htmlTreeBuilder.error(this);
                        htmlTreeBuilder.popStackToClose("template");
                        htmlTreeBuilder.clearFormattingElementsToLastMarker();
                        htmlTreeBuilder.popTemplateMode();
                        htmlTreeBuilder.resetInsertionMode();
                        if (htmlTreeBuilder.state() == InTemplate || htmlTreeBuilder.templateModeSize() >= 12) {
                            return true;
                        }
                        return htmlTreeBuilder.process(token);
                    }
                    return true;
            }
            return true;
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                    if (htmlTreeBuilder.isFragmentParsing()) {
                        htmlTreeBuilder.error(this);
                        return false;
                    }
                    htmlTreeBuilder.transition(AfterAfterBody);
                    return true;
                } else if (token.isEOF()) {
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag()) {
                Token.StartTag asStartTag = token.asStartTag();
                String normalName = asStartTag.normalName();
                normalName.hashCode();
                char c = 65535;
                switch (normalName.hashCode()) {
                    case -1644953643:
                        if (normalName.equals("frameset")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3213227:
                        if (normalName.equals("html")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 97692013:
                        if (normalName.equals(TypedValues.AttributesType.S_FRAME)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (normalName.equals("noframes")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        htmlTreeBuilder.insert(asStartTag);
                        break;
                    case 1:
                        return htmlTreeBuilder.process(asStartTag, InBody);
                    case 2:
                        htmlTreeBuilder.insertEmpty(asStartTag);
                        break;
                    case 3:
                        return htmlTreeBuilder.process(asStartTag, InHead);
                    default:
                        htmlTreeBuilder.error(this);
                        return false;
                }
            } else if (token.isEndTag() && token.asEndTag().normalName().equals("frameset")) {
                if (htmlTreeBuilder.currentElementIs("html")) {
                    htmlTreeBuilder.error(this);
                    return false;
                }
                htmlTreeBuilder.pop();
                if (!htmlTreeBuilder.isFragmentParsing() && !htmlTreeBuilder.currentElementIs("frameset")) {
                    htmlTreeBuilder.transition(AfterFrameset);
                }
            } else if (token.isEOF()) {
                if (!htmlTreeBuilder.currentElementIs("html")) {
                    htmlTreeBuilder.error(this);
                }
            } else {
                htmlTreeBuilder.error(this);
                return false;
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                htmlTreeBuilder.insert(token.asCharacter());
                return true;
            } else if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype()) {
                htmlTreeBuilder.error(this);
                return false;
            } else if (token.isStartTag() && token.asStartTag().normalName().equals("html")) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEndTag() && token.asEndTag().normalName().equals("html")) {
                    htmlTreeBuilder.transition(AfterAfterFrameset);
                    return true;
                } else if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                } else {
                    if (token.isEOF()) {
                        return true;
                    }
                    htmlTreeBuilder.error(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (!token.isDoctype() && (!token.isStartTag() || !token.asStartTag().normalName().equals("html"))) {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    Element popStackToClose = htmlTreeBuilder.popStackToClose("html");
                    htmlTreeBuilder.insert(token.asCharacter());
                    if (popStackToClose != null) {
                        htmlTreeBuilder.stack.add(popStackToClose);
                        Element selectFirst = popStackToClose.selectFirst("body");
                        if (selectFirst != null) {
                            htmlTreeBuilder.stack.add(selectFirst);
                            return true;
                        }
                        return true;
                    }
                    return true;
                } else if (token.isEOF()) {
                    return true;
                } else {
                    htmlTreeBuilder.error(this);
                    htmlTreeBuilder.transition(InBody);
                    return htmlTreeBuilder.process(token);
                }
            } else {
                return htmlTreeBuilder.process(token, InBody);
            }
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.isComment()) {
                htmlTreeBuilder.insert(token.asComment());
                return true;
            } else if (token.isDoctype() || HtmlTreeBuilderState.isWhitespace(token) || (token.isStartTag() && token.asStartTag().normalName().equals("html"))) {
                return htmlTreeBuilder.process(token, InBody);
            } else {
                if (token.isEOF()) {
                    return true;
                }
                if (token.isStartTag() && token.asStartTag().normalName().equals("noframes")) {
                    return htmlTreeBuilder.process(token, InHead);
                }
                htmlTreeBuilder.error(this);
                return false;
            }
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.24
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    private static final String nullString = String.valueOf((char) 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean process(Token token, HtmlTreeBuilder htmlTreeBuilder);

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$25 */
    /* loaded from: classes5.dex */
    static /* synthetic */ class C541425 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$org$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jsoup$parser$Token$TokenType[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.isCharacter()) {
            return StringUtil.isBlank(token.asCharacter().getData());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return StringUtil.isBlank(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
        htmlTreeBuilder.markInsertionMode();
        htmlTreeBuilder.transition(Text);
        htmlTreeBuilder.insert(startTag);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Constants {
        static final String[] InHeadEmpty = {TtmlNode.RUBY_BASE, "basefont", "bgsound", "command", "link"};
        static final String[] InHeadRaw = {"noframes", "style"};
        static final String[] InHeadEnd = {"body", TtmlNode.TAG_BR, "html"};
        static final String[] AfterHeadBody = {"body", TtmlNode.TAG_BR, "html"};
        static final String[] BeforeHtmlToHead = {"body", TtmlNode.TAG_BR, TtmlNode.TAG_HEAD, "html"};
        static final String[] InHeadNoScriptHead = {"basefont", "bgsound", "link", "meta", "noframes", "style"};
        static final String[] InBodyStartToHead = {TtmlNode.RUBY_BASE, "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "template", "title"};
        static final String[] InBodyStartPClosers = {"address", "article", "aside", "blockquote", TtmlNode.CENTER, "details", "dir", TtmlNode.TAG_DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", TtmlNode.TAG_P, "section", "summary", "ul"};
        static final String[] Headings = {"h1", "h2", "h3", "h4", "h5", "h6"};
        static final String[] InBodyStartLiBreakers = {"address", TtmlNode.TAG_DIV, TtmlNode.TAG_P};
        static final String[] DdDt = {"dd", "dt"};
        static final String[] Formatters = {"b", "big", "code", UserDataStore.EMAIL, "font", "i", "s", "small", "strike", "strong", TtmlNode.TAG_TT, "u"};
        static final String[] InBodyStartApplets = {"applet", "marquee", "object"};
        static final String[] InBodyStartEmptyFormatters = {"area", TtmlNode.TAG_BR, "embed", "img", "keygen", "wbr"};
        static final String[] InBodyStartMedia = {"param", "source", "track"};
        static final String[] InBodyStartInputAttribs = {"action", "name", "prompt"};
        static final String[] InBodyStartDrop = {"caption", "col", "colgroup", TypedValues.AttributesType.S_FRAME, TtmlNode.TAG_HEAD, "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InBodyEndClosers = {"address", "article", "aside", "blockquote", "button", TtmlNode.CENTER, "details", "dir", TtmlNode.TAG_DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
        static final String[] InBodyEndAdoptionFormatters = {"a", "b", "big", "code", UserDataStore.EMAIL, "font", "i", "nobr", "s", "small", "strike", "strong", TtmlNode.TAG_TT, "u"};
        static final String[] InBodyEndTableFosters = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InTableToBody = {"tbody", "tfoot", "thead"};
        static final String[] InTableAddBody = {"td", "th", "tr"};
        static final String[] InTableToHead = {"script", "style", "template"};
        static final String[] InCellNames = {"td", "th"};
        static final String[] InCellBody = {"body", "caption", "col", "colgroup", "html"};
        static final String[] InCellTable = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InCellCol = {"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableEndErr = {"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableFoster = {"table", "tbody", "tfoot", "thead", "tr"};
        static final String[] InTableBodyExit = {"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
        static final String[] InTableBodyEndIgnore = {"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
        static final String[] InRowMissing = {"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        static final String[] InRowIgnore = {"body", "caption", "col", "colgroup", "html", "td", "th"};
        static final String[] InSelectEnd = {TvContractCompat.PARAM_INPUT, "keygen", "textarea"};
        static final String[] InSelectTableEnd = {"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTableEndIgnore = {"tbody", "tfoot", "thead"};
        static final String[] InHeadNoscriptIgnore = {TtmlNode.TAG_HEAD, "noscript"};
        static final String[] InCaptionIgnore = {"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        static final String[] InTemplateToHead = {TtmlNode.RUBY_BASE, "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "template", "title"};
        static final String[] InTemplateToTable = {"caption", "colgroup", "tbody", "tfoot", "thead"};

        Constants() {
        }
    }
}
