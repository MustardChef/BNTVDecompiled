package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class TreeBuilder {
    protected String baseUri;
    protected Token currentToken;
    protected Document doc;
    protected Parser parser;
    CharacterReader reader;
    protected Map<String, Tag> seenTags;
    protected ParseSettings settings;
    protected ArrayList<Element> stack;
    Tokeniser tokeniser;
    private Token.StartTag start = new Token.StartTag();
    private Token.EndTag end = new Token.EndTag();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ParseSettings defaultSettings();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isContentForTagData(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract TreeBuilder newInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<Node> parseFragment(String str, Element element, String str2, Parser parser);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean process(Token token);

    /* JADX INFO: Access modifiers changed from: protected */
    @ParametersAreNonnullByDefault
    public void initialiseParse(Reader reader, String str, Parser parser) {
        Validate.notNull(reader, "String input must not be null");
        Validate.notNull(str, "BaseURI must not be null");
        Validate.notNull(parser);
        Document document = new Document(str);
        this.doc = document;
        document.parser(parser);
        this.parser = parser;
        this.settings = parser.settings();
        CharacterReader characterReader = new CharacterReader(reader);
        this.reader = characterReader;
        characterReader.trackNewlines(parser.isTrackErrors());
        this.currentToken = null;
        this.tokeniser = new Tokeniser(this.reader, parser.getErrors());
        this.stack = new ArrayList<>(32);
        this.seenTags = new HashMap();
        this.baseUri = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ParametersAreNonnullByDefault
    public Document parse(Reader reader, String str, Parser parser) {
        initialiseParse(reader, str, parser);
        runParser();
        this.reader.close();
        this.reader = null;
        this.tokeniser = null;
        this.stack = null;
        this.seenTags = null;
        return this.doc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void runParser() {
        Token read;
        Tokeniser tokeniser = this.tokeniser;
        Token.TokenType tokenType = Token.TokenType.EOF;
        do {
            read = tokeniser.read();
            process(read);
            read.reset();
        } while (read.type != tokenType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean processStartTag(String str) {
        Token.StartTag startTag = this.start;
        if (this.currentToken == startTag) {
            return process(new Token.StartTag().name(str));
        }
        return process(startTag.reset().name(str));
    }

    public boolean processStartTag(String str, Attributes attributes) {
        Token.StartTag startTag = this.start;
        if (this.currentToken == startTag) {
            return process(new Token.StartTag().nameAttr(str, attributes));
        }
        startTag.reset();
        startTag.nameAttr(str, attributes);
        return process(startTag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean processEndTag(String str) {
        Token token = this.currentToken;
        Token.EndTag endTag = this.end;
        if (token == endTag) {
            return process(new Token.EndTag().name(str));
        }
        return process(endTag.reset().name(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Element currentElement() {
        int size = this.stack.size();
        return size > 0 ? this.stack.get(size - 1) : this.doc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean currentElementIs(String str) {
        Element currentElement;
        return (this.stack.size() == 0 || (currentElement = currentElement()) == null || !currentElement.normalName().equals(str)) ? false : true;
    }

    protected void error(String str) {
        error(str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void error(String str, Object... objArr) {
        ParseErrorList errors = this.parser.getErrors();
        if (errors.canAddError()) {
            errors.add(new ParseError(this.reader, str, objArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Tag tagFor(String str, ParseSettings parseSettings) {
        Tag tag = this.seenTags.get(str);
        if (tag == null) {
            Tag valueOf = Tag.valueOf(str, parseSettings);
            this.seenTags.put(str, valueOf);
            return valueOf;
        }
        return tag;
    }
}
