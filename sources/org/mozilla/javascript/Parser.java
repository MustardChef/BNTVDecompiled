package org.mozilla.javascript;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.ArrayComprehension;
import org.mozilla.javascript.ast.ArrayLiteral;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.BreakStatement;
import org.mozilla.javascript.ast.CatchClause;
import org.mozilla.javascript.ast.Comment;
import org.mozilla.javascript.ast.ConditionalExpression;
import org.mozilla.javascript.ast.ContinueStatement;
import org.mozilla.javascript.ast.DestructuringForm;
import org.mozilla.javascript.ast.DoLoop;
import org.mozilla.javascript.ast.ElementGet;
import org.mozilla.javascript.ast.EmptyExpression;
import org.mozilla.javascript.ast.EmptyStatement;
import org.mozilla.javascript.ast.ErrorNode;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.GeneratorExpression;
import org.mozilla.javascript.ast.GeneratorExpressionLoop;
import org.mozilla.javascript.ast.IdeErrorReporter;
import org.mozilla.javascript.ast.IfStatement;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.KeywordLiteral;
import org.mozilla.javascript.ast.Label;
import org.mozilla.javascript.ast.LabeledStatement;
import org.mozilla.javascript.ast.LetNode;
import org.mozilla.javascript.ast.Loop;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.ParenthesizedExpression;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.RegExpLiteral;
import org.mozilla.javascript.ast.ReturnStatement;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.StringLiteral;
import org.mozilla.javascript.ast.SwitchCase;
import org.mozilla.javascript.ast.SwitchStatement;
import org.mozilla.javascript.ast.Symbol;
import org.mozilla.javascript.ast.ThrowStatement;
import org.mozilla.javascript.ast.TryStatement;
import org.mozilla.javascript.ast.UnaryExpression;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;
import org.mozilla.javascript.ast.WhileLoop;
import org.mozilla.javascript.ast.WithStatement;
import org.mozilla.javascript.ast.XmlDotQuery;
import org.mozilla.javascript.ast.XmlElemRef;
import org.mozilla.javascript.ast.XmlExpression;
import org.mozilla.javascript.ast.XmlLiteral;
import org.mozilla.javascript.ast.XmlMemberGet;
import org.mozilla.javascript.ast.XmlPropRef;
import org.mozilla.javascript.ast.XmlRef;
import org.mozilla.javascript.ast.XmlString;
import org.mozilla.javascript.ast.Yield;

/* loaded from: classes5.dex */
public class Parser {
    public static final int ARGC_LIMIT = 65536;
    static final int CLEAR_TI_MASK = 65535;
    private static final int GET_ENTRY = 2;
    private static final int PROP_ENTRY = 1;
    private static final int SET_ENTRY = 4;
    static final int TI_AFTER_EOL = 65536;
    static final int TI_CHECK_LABEL = 131072;
    boolean calledByCompileFunction;
    CompilerEnvirons compilerEnv;
    private int currentFlaggedToken;
    private Comment currentJsDocComment;
    private LabeledStatement currentLabel;
    Scope currentScope;
    ScriptNode currentScriptOrFn;
    private int currentToken;
    private int endFlags;
    private IdeErrorReporter errorCollector;
    private ErrorReporter errorReporter;
    private boolean inDestructuringAssignment;
    private boolean inForInit;
    protected boolean inUseStrictDirective;
    private Map<String, LabeledStatement> labelSet;
    private List<Jump> loopAndSwitchSet;
    private List<Loop> loopSet;
    protected int nestingOfFunction;
    private boolean parseFinished;
    private int prevNameTokenLineno;
    private int prevNameTokenStart;
    private String prevNameTokenString;
    private List<Comment> scannedComments;
    private char[] sourceChars;
    private String sourceURI;
    private int syntaxErrorCount;

    /* renamed from: ts */
    private TokenStream f10728ts;

    private static final boolean nowAllSet(int i, int i2, int i3) {
        return (i & i3) != i3 && (i2 & i3) == i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ParserException extends RuntimeException {
        static final long serialVersionUID = 5882582646773765630L;

        private ParserException() {
        }
    }

    public Parser() {
        this(new CompilerEnvirons());
    }

    public Parser(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    public Parser(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        this.currentFlaggedToken = 0;
        this.prevNameTokenString = "";
        this.compilerEnv = compilerEnvirons;
        this.errorReporter = errorReporter;
        if (errorReporter instanceof IdeErrorReporter) {
            this.errorCollector = (IdeErrorReporter) errorReporter;
        }
    }

    void addStrictWarning(String str, String str2) {
        int i;
        TokenStream tokenStream = this.f10728ts;
        int i2 = -1;
        if (tokenStream != null) {
            i2 = tokenStream.tokenBeg;
            i = this.f10728ts.tokenEnd - this.f10728ts.tokenBeg;
        } else {
            i = -1;
        }
        addStrictWarning(str, str2, i2, i);
    }

    void addStrictWarning(String str, String str2, int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            addWarning(str, str2, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addWarning(String str, String str2) {
        int i;
        TokenStream tokenStream = this.f10728ts;
        int i2 = -1;
        if (tokenStream != null) {
            i2 = tokenStream.tokenBeg;
            i = this.f10728ts.tokenEnd - this.f10728ts.tokenBeg;
        } else {
            i = -1;
        }
        addWarning(str, str2, i2, i);
    }

    void addWarning(String str, int i, int i2) {
        addWarning(str, null, i, i2);
    }

    void addWarning(String str, String str2, int i, int i2) {
        String lookupMessage = lookupMessage(str, str2);
        if (this.compilerEnv.reportWarningAsError()) {
            addError(str, str2, i, i2);
            return;
        }
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.warning(lookupMessage, this.sourceURI, i, i2);
        } else {
            this.errorReporter.warning(lookupMessage, this.sourceURI, this.f10728ts.getLineno(), this.f10728ts.getLine(), this.f10728ts.getOffset());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addError(String str) {
        addError(str, this.f10728ts.tokenBeg, this.f10728ts.tokenEnd - this.f10728ts.tokenBeg);
    }

    void addError(String str, int i, int i2) {
        addError(str, null, i, i2);
    }

    void addError(String str, String str2) {
        addError(str, str2, this.f10728ts.tokenBeg, this.f10728ts.tokenEnd - this.f10728ts.tokenBeg);
    }

    void addError(String str, String str2, int i, int i2) {
        String str3;
        int i3;
        int i4;
        this.syntaxErrorCount++;
        String lookupMessage = lookupMessage(str, str2);
        IdeErrorReporter ideErrorReporter = this.errorCollector;
        if (ideErrorReporter != null) {
            ideErrorReporter.error(lookupMessage, this.sourceURI, i, i2);
            return;
        }
        TokenStream tokenStream = this.f10728ts;
        if (tokenStream != null) {
            int lineno = tokenStream.getLineno();
            str3 = this.f10728ts.getLine();
            i4 = this.f10728ts.getOffset();
            i3 = lineno;
        } else {
            str3 = "";
            i3 = 1;
            i4 = 1;
        }
        this.errorReporter.error(lookupMessage, this.sourceURI, i3, str3, i4);
    }

    String lookupMessage(String str) {
        return lookupMessage(str, null);
    }

    String lookupMessage(String str, String str2) {
        return str2 == null ? ScriptRuntime.getMessage0(str) : ScriptRuntime.getMessage1(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reportError(String str) {
        reportError(str, null);
    }

    void reportError(String str, String str2) {
        TokenStream tokenStream = this.f10728ts;
        if (tokenStream == null) {
            reportError(str, str2, 1, 1);
        } else {
            reportError(str, str2, tokenStream.tokenBeg, this.f10728ts.tokenEnd - this.f10728ts.tokenBeg);
        }
    }

    void reportError(String str, int i, int i2) {
        reportError(str, null, i, i2);
    }

    void reportError(String str, String str2, int i, int i2) {
        addError(str, i, i2);
        if (!this.compilerEnv.recoverFromErrors()) {
            throw new ParserException();
        }
    }

    private int getNodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private void recordComment(int i, String str) {
        if (this.scannedComments == null) {
            this.scannedComments = new ArrayList();
        }
        Comment comment = new Comment(this.f10728ts.tokenBeg, this.f10728ts.getTokenLength(), this.f10728ts.commentType, str);
        if (this.f10728ts.commentType == Token.CommentType.JSDOC && this.compilerEnv.isRecordingLocalJsDocComments()) {
            this.currentJsDocComment = comment;
        }
        comment.setLineno(i);
        this.scannedComments.add(comment);
    }

    private Comment getAndResetJsDoc() {
        Comment comment = this.currentJsDocComment;
        this.currentJsDocComment = null;
        return comment;
    }

    private int getNumberOfEols(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) == '\n') {
                i++;
            }
        }
        return i;
    }

    private int peekToken() throws IOException {
        if (this.currentFlaggedToken != 0) {
            return this.currentToken;
        }
        int lineno = this.f10728ts.getLineno();
        int token = this.f10728ts.getToken();
        boolean z = false;
        while (true) {
            if (token != 1 && token != 161) {
                break;
            }
            if (token == 1) {
                lineno++;
                z = true;
            } else if (this.compilerEnv.isRecordingComments()) {
                String andResetCurrentComment = this.f10728ts.getAndResetCurrentComment();
                recordComment(lineno, andResetCurrentComment);
                lineno += getNumberOfEols(andResetCurrentComment);
            }
            token = this.f10728ts.getToken();
        }
        this.currentToken = token;
        this.currentFlaggedToken = token | (z ? 65536 : 0);
        return token;
    }

    private int peekFlaggedToken() throws IOException {
        peekToken();
        return this.currentFlaggedToken;
    }

    private void consumeToken() {
        this.currentFlaggedToken = 0;
    }

    private int nextToken() throws IOException {
        int peekToken = peekToken();
        consumeToken();
        return peekToken;
    }

    private int nextFlaggedToken() throws IOException {
        peekToken();
        int i = this.currentFlaggedToken;
        consumeToken();
        return i;
    }

    private boolean matchToken(int i) throws IOException {
        if (peekToken() != i) {
            return false;
        }
        consumeToken();
        return true;
    }

    private int peekTokenOrEOL() throws IOException {
        int peekToken = peekToken();
        if ((this.currentFlaggedToken & 65536) != 0) {
            return 1;
        }
        return peekToken;
    }

    private boolean mustMatchToken(int i, String str) throws IOException {
        return mustMatchToken(i, str, this.f10728ts.tokenBeg, this.f10728ts.tokenEnd - this.f10728ts.tokenBeg);
    }

    private boolean mustMatchToken(int i, String str, int i2, int i3) throws IOException {
        if (matchToken(i)) {
            return true;
        }
        reportError(str, i2, i3);
        return false;
    }

    private void mustHaveXML() {
        if (this.compilerEnv.isXmlAvailable()) {
            return;
        }
        reportError("msg.XML.not.available");
    }

    public boolean eof() {
        return this.f10728ts.eof();
    }

    boolean insideFunction() {
        return this.nestingOfFunction != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushScope(Scope scope) {
        Scope parentScope = scope.getParentScope();
        if (parentScope != null) {
            if (parentScope != this.currentScope) {
                codeBug();
            }
        } else {
            this.currentScope.addChildScope(scope);
        }
        this.currentScope = scope;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void popScope() {
        this.currentScope = this.currentScope.getParentScope();
    }

    private void enterLoop(Loop loop) {
        if (this.loopSet == null) {
            this.loopSet = new ArrayList();
        }
        this.loopSet.add(loop);
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(loop);
        pushScope(loop);
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null) {
            labeledStatement.setStatement(loop);
            this.currentLabel.getFirstLabel().setLoop(loop);
            loop.setRelative(-this.currentLabel.getPosition());
        }
    }

    private void exitLoop() {
        List<Loop> list = this.loopSet;
        Loop remove = list.remove(list.size() - 1);
        List<Jump> list2 = this.loopAndSwitchSet;
        list2.remove(list2.size() - 1);
        if (remove.getParent() != null) {
            remove.setRelative(remove.getParent().getPosition());
        }
        popScope();
    }

    private void enterSwitch(SwitchStatement switchStatement) {
        if (this.loopAndSwitchSet == null) {
            this.loopAndSwitchSet = new ArrayList();
        }
        this.loopAndSwitchSet.add(switchStatement);
    }

    private void exitSwitch() {
        List<Jump> list = this.loopAndSwitchSet;
        list.remove(list.size() - 1);
    }

    public AstRoot parse(String str, String str2, int i) {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        this.sourceURI = str2;
        if (this.compilerEnv.isIdeMode()) {
            this.sourceChars = str.toCharArray();
        }
        this.f10728ts = new TokenStream(this, null, str, i);
        try {
            try {
                return parse();
            } catch (IOException unused) {
                throw new IllegalStateException();
            }
        } finally {
            this.parseFinished = true;
        }
    }

    public AstRoot parse(Reader reader, String str, int i) throws IOException {
        if (this.parseFinished) {
            throw new IllegalStateException("parser reused");
        }
        if (this.compilerEnv.isIdeMode()) {
            return parse(readFully(reader), str, i);
        }
        try {
            this.sourceURI = str;
            this.f10728ts = new TokenStream(this, reader, null, i);
            return parse();
        } finally {
            this.parseFinished = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.ast.AstRoot parse() throws java.io.IOException {
        /*
            r10 = this;
            org.mozilla.javascript.ast.AstRoot r0 = new org.mozilla.javascript.ast.AstRoot
            r1 = 0
            r0.<init>(r1)
            r10.currentScriptOrFn = r0
            r10.currentScope = r0
            org.mozilla.javascript.TokenStream r2 = r10.f10728ts
            int r6 = r2.lineno
            boolean r2 = r10.inUseStrictDirective
            r10.inUseStrictDirective = r1
            r3 = 1
            r4 = 1
            r5 = 0
        L15:
            int r7 = r10.peekToken()     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            if (r7 > 0) goto L1c
            goto L2f
        L1c:
            r8 = 109(0x6d, float:1.53E-43)
            if (r7 != r8) goto L32
            r10.consumeToken()     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            boolean r7 = r10.calledByCompileFunction     // Catch: org.mozilla.javascript.Parser.ParserException -> L2f java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            if (r7 == 0) goto L29
            r7 = 2
            goto L2a
        L29:
            r7 = 1
        L2a:
            org.mozilla.javascript.ast.FunctionNode r7 = r10.function(r7)     // Catch: org.mozilla.javascript.Parser.ParserException -> L2f java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            goto L4d
        L2f:
            r10.inUseStrictDirective = r2
            goto L6a
        L32:
            org.mozilla.javascript.ast.AstNode r7 = r10.statement()     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            if (r4 == 0) goto L4d
            java.lang.String r8 = r10.getDirective(r7)     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            if (r8 != 0) goto L40
            r4 = 0
            goto L4d
        L40:
            java.lang.String r9 = "use strict"
            boolean r8 = r8.equals(r9)     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            if (r8 == 0) goto L4d
            r10.inUseStrictDirective = r3     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            r0.setInStrictMode(r3)     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
        L4d:
            int r5 = r10.getNodeEnd(r7)     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            r0.addChildToBack(r7)     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            r7.setParent(r0)     // Catch: java.lang.Throwable -> L58 java.lang.StackOverflowError -> L5b
            goto L15
        L58:
            r0 = move-exception
            goto Ldb
        L5b:
            java.lang.String r4 = "msg.too.deep.parser.recursion"
            java.lang.String r4 = r10.lookupMessage(r4)     // Catch: java.lang.Throwable -> L58
            org.mozilla.javascript.CompilerEnvirons r7 = r10.compilerEnv     // Catch: java.lang.Throwable -> L58
            boolean r7 = r7.isIdeMode()     // Catch: java.lang.Throwable -> L58
            if (r7 == 0) goto Lcf
            goto L2f
        L6a:
            int r2 = r10.syntaxErrorCount
            if (r2 == 0) goto L8c
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = "msg.got.syntax.errors"
            java.lang.String r4 = r10.lookupMessage(r4, r2)
            org.mozilla.javascript.CompilerEnvirons r2 = r10.compilerEnv
            boolean r2 = r2.isIdeMode()
            if (r2 == 0) goto L81
            goto L8c
        L81:
            org.mozilla.javascript.ErrorReporter r3 = r10.errorReporter
            java.lang.String r5 = r10.sourceURI
            r7 = 0
            r8 = 0
            org.mozilla.javascript.EvaluatorException r0 = r3.runtimeError(r4, r5, r6, r7, r8)
            throw r0
        L8c:
            java.util.List<org.mozilla.javascript.ast.Comment> r2 = r10.scannedComments
            if (r2 == 0) goto Lbb
            int r2 = r2.size()
            int r2 = r2 - r3
            java.util.List<org.mozilla.javascript.ast.Comment> r3 = r10.scannedComments
            java.lang.Object r2 = r3.get(r2)
            org.mozilla.javascript.ast.AstNode r2 = (org.mozilla.javascript.ast.AstNode) r2
            int r2 = r10.getNodeEnd(r2)
            int r5 = java.lang.Math.max(r5, r2)
            java.util.List<org.mozilla.javascript.ast.Comment> r2 = r10.scannedComments
            java.util.Iterator r2 = r2.iterator()
        Lab:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Lbb
            java.lang.Object r3 = r2.next()
            org.mozilla.javascript.ast.Comment r3 = (org.mozilla.javascript.ast.Comment) r3
            r0.addComment(r3)
            goto Lab
        Lbb:
            int r5 = r5 - r1
            r0.setLength(r5)
            java.lang.String r1 = r10.sourceURI
            r0.setSourceName(r1)
            r0.setBaseLineno(r6)
            org.mozilla.javascript.TokenStream r1 = r10.f10728ts
            int r1 = r1.lineno
            r0.setEndLineno(r1)
            return r0
        Lcf:
            java.lang.String r0 = r10.sourceURI     // Catch: java.lang.Throwable -> L58
            org.mozilla.javascript.TokenStream r3 = r10.f10728ts     // Catch: java.lang.Throwable -> L58
            int r3 = r3.lineno     // Catch: java.lang.Throwable -> L58
            r5 = 0
            org.mozilla.javascript.EvaluatorException r0 = org.mozilla.javascript.Context.reportRuntimeError(r4, r0, r3, r5, r1)     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        Ldb:
            r10.inUseStrictDirective = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.parse():org.mozilla.javascript.ast.AstRoot");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(1:5)(8:6|7|8|(1:10)(2:19|(2:20|(3:24|(2:26|(1:38)(2:28|(2:30|31)(2:33|(2:35|36)(1:37))))(2:39|40)|32)(3:42|41|43)))|11|(1:15)|16|17))|48|7|8|(0)(0)|11|(2:13|15)|16|17|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
        r11.nestingOfFunction--;
        r11.inUseStrictDirective = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[Catch: all -> 0x008c, ParserException -> 0x0095, TRY_ENTER, TryCatch #2 {ParserException -> 0x0095, all -> 0x008c, blocks: (B:11:0x0038, B:13:0x0059, B:19:0x0068, B:21:0x006e, B:24:0x0076, B:26:0x007e, B:28:0x0088, B:27:0x0081), top: B:41:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.ast.AstNode parseFunctionBody() throws java.io.IOException {
        /*
            r11 = this;
            r0 = 85
            boolean r0 = r11.matchToken(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L1c
            org.mozilla.javascript.CompilerEnvirons r0 = r11.compilerEnv
            int r0 = r0.getLanguageVersion()
            r3 = 180(0xb4, float:2.52E-43)
            if (r0 >= r3) goto L1a
            java.lang.String r0 = "msg.no.brace.body"
            r11.reportError(r0)
            goto L1c
        L1a:
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            int r3 = r11.nestingOfFunction
            int r3 = r3 + r2
            r11.nestingOfFunction = r3
            org.mozilla.javascript.TokenStream r3 = r11.f10728ts
            int r3 = r3.tokenBeg
            org.mozilla.javascript.ast.Block r4 = new org.mozilla.javascript.ast.Block
            r4.<init>(r3)
            boolean r5 = r11.inUseStrictDirective
            org.mozilla.javascript.TokenStream r6 = r11.f10728ts
            int r6 = r6.lineno
            r4.setLineno(r6)
            r6 = 86
            if (r0 == 0) goto L58
            org.mozilla.javascript.ast.ReturnStatement r1 = new org.mozilla.javascript.ast.ReturnStatement     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            org.mozilla.javascript.TokenStream r7 = r11.f10728ts     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            int r7 = r7.lineno     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            org.mozilla.javascript.ast.AstNode r7 = r11.assignExpr()     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            r1.setReturnValue(r7)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            r8 = 25
            r1.putProp(r8, r7)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            r4.putProp(r8, r7)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            r4.addStatement(r1)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            goto L95
        L58:
            r7 = 1
        L59:
            int r8 = r11.peekToken()     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            r9 = -1
            if (r8 == r9) goto L95
            if (r8 == 0) goto L95
            if (r8 == r6) goto L95
            r9 = 109(0x6d, float:1.53E-43)
            if (r8 == r9) goto L81
            org.mozilla.javascript.ast.AstNode r8 = r11.statement()     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            if (r7 == 0) goto L88
            java.lang.String r9 = r11.getDirective(r8)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            if (r9 != 0) goto L76
            r7 = 0
            goto L88
        L76:
            java.lang.String r10 = "use strict"
            boolean r9 = r9.equals(r10)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            if (r9 == 0) goto L88
            r11.inUseStrictDirective = r2     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            goto L88
        L81:
            r11.consumeToken()     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            org.mozilla.javascript.ast.FunctionNode r8 = r11.function(r2)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
        L88:
            r4.addStatement(r8)     // Catch: java.lang.Throwable -> L8c org.mozilla.javascript.Parser.ParserException -> L95
            goto L59
        L8c:
            r0 = move-exception
            int r1 = r11.nestingOfFunction
            int r1 = r1 - r2
            r11.nestingOfFunction = r1
            r11.inUseStrictDirective = r5
            throw r0
        L95:
            int r1 = r11.nestingOfFunction
            int r1 = r1 - r2
            r11.nestingOfFunction = r1
            r11.inUseStrictDirective = r5
            org.mozilla.javascript.TokenStream r1 = r11.f10728ts
            int r1 = r1.tokenEnd
            r11.getAndResetJsDoc()
            if (r0 != 0) goto Lb1
            java.lang.String r0 = "msg.no.brace.after.body"
            boolean r0 = r11.mustMatchToken(r6, r0)
            if (r0 == 0) goto Lb1
            org.mozilla.javascript.TokenStream r0 = r11.f10728ts
            int r1 = r0.tokenEnd
        Lb1:
            int r1 = r1 - r3
            r4.setLength(r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.parseFunctionBody():org.mozilla.javascript.ast.AstNode");
    }

    private String getDirective(AstNode astNode) {
        if (astNode instanceof ExpressionStatement) {
            AstNode expression = ((ExpressionStatement) astNode).getExpression();
            if (expression instanceof StringLiteral) {
                return ((StringLiteral) expression).getValue();
            }
            return null;
        }
        return null;
    }

    private void parseFunctionParams(FunctionNode functionNode) throws IOException {
        if (matchToken(88)) {
            functionNode.setRp(this.f10728ts.tokenBeg - functionNode.getPosition());
            return;
        }
        HashMap hashMap = null;
        HashSet hashSet = new HashSet();
        do {
            int peekToken = peekToken();
            if (peekToken == 83 || peekToken == 85) {
                AstNode destructuringPrimaryExpr = destructuringPrimaryExpr();
                markDestructuring(destructuringPrimaryExpr);
                functionNode.addParam(destructuringPrimaryExpr);
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(87, nextTempName, false);
                hashMap.put(nextTempName, destructuringPrimaryExpr);
            } else if (mustMatchToken(39, "msg.no.parm")) {
                functionNode.addParam(createNameNode());
                String string = this.f10728ts.getString();
                defineSymbol(87, string);
                if (this.inUseStrictDirective) {
                    if ("eval".equals(string) || "arguments".equals(string)) {
                        reportError("msg.bad.id.strict", string);
                    }
                    if (hashSet.contains(string)) {
                        addError("msg.dup.param.strict", string);
                    }
                    hashSet.add(string);
                }
            } else {
                functionNode.addParam(makeErrorNode());
            }
        } while (matchToken(89));
        if (hashMap != null) {
            Node node = new Node(89);
            for (Map.Entry entry : hashMap.entrySet()) {
                node.addChildToBack(createDestructuringAssignment(122, (Node) entry.getValue(), createName((String) entry.getKey())));
            }
            functionNode.putProp(23, node);
        }
        if (mustMatchToken(88, "msg.no.paren.after.parms")) {
            functionNode.setRp(this.f10728ts.tokenBeg - functionNode.getPosition());
        }
    }

    private FunctionNode function(int i) throws IOException {
        Name name;
        int i2 = this.f10728ts.lineno;
        int i3 = this.f10728ts.tokenBeg;
        AstNode astNode = null;
        if (matchToken(39)) {
            name = createNameNode(true, 39);
            if (this.inUseStrictDirective) {
                String identifier = name.getIdentifier();
                if ("eval".equals(identifier) || "arguments".equals(identifier)) {
                    reportError("msg.bad.id.strict", identifier);
                }
            }
            if (!matchToken(87)) {
                if (this.compilerEnv.isAllowMemberExprAsFunctionName()) {
                    astNode = memberExprTail(false, name);
                    name = null;
                }
                mustMatchToken(87, "msg.no.paren.parms");
            }
        } else if (matchToken(87)) {
            name = null;
        } else {
            AstNode memberExpr = this.compilerEnv.isAllowMemberExprAsFunctionName() ? memberExpr(false) : null;
            mustMatchToken(87, "msg.no.paren.parms");
            astNode = memberExpr;
            name = null;
        }
        int i4 = this.currentToken == 87 ? this.f10728ts.tokenBeg : -1;
        if ((astNode != null ? 2 : i) != 2 && name != null && name.length() > 0) {
            defineSymbol(109, name.getIdentifier());
        }
        FunctionNode functionNode = new FunctionNode(i3, name);
        functionNode.setFunctionType(i);
        if (i4 != -1) {
            functionNode.setLp(i4 - i3);
        }
        functionNode.setJsDocNode(getAndResetJsDoc());
        PerFunctionVariables perFunctionVariables = new PerFunctionVariables(functionNode);
        try {
            parseFunctionParams(functionNode);
            functionNode.setBody(parseFunctionBody());
            functionNode.setEncodedSourceBounds(i3, this.f10728ts.tokenEnd);
            functionNode.setLength(this.f10728ts.tokenEnd - i3);
            if (this.compilerEnv.isStrictMode() && !functionNode.getBody().hasConsistentReturnUsage()) {
                addStrictWarning((name == null || name.length() <= 0) ? "msg.anon.no.return.value" : "msg.no.return.value", name == null ? "" : name.getIdentifier());
            }
            if (astNode != null) {
                Kit.codeBug();
                functionNode.setMemberExprNode(astNode);
            }
            functionNode.setSourceName(this.sourceURI);
            functionNode.setBaseLineno(i2);
            functionNode.setEndLineno(this.f10728ts.lineno);
            if (this.compilerEnv.isIdeMode()) {
                functionNode.setParentScope(this.currentScope);
            }
            return functionNode;
        } finally {
            perFunctionVariables.restore();
        }
    }

    private AstNode statements(AstNode astNode) throws IOException {
        if (this.currentToken != 85 && !this.compilerEnv.isIdeMode()) {
            codeBug();
        }
        int i = this.f10728ts.tokenBeg;
        if (astNode == null) {
            astNode = new Block(i);
        }
        astNode.setLineno(this.f10728ts.lineno);
        while (true) {
            int peekToken = peekToken();
            if (peekToken <= 0 || peekToken == 86) {
                break;
            }
            astNode.addChild(statement());
        }
        astNode.setLength(this.f10728ts.tokenBeg - i);
        return astNode;
    }

    private AstNode statements() throws IOException {
        return statements(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ConditionData {
        AstNode condition;

        /* renamed from: lp */
        int f10729lp;

        /* renamed from: rp */
        int f10730rp;

        private ConditionData() {
            this.f10729lp = -1;
            this.f10730rp = -1;
        }
    }

    private ConditionData condition() throws IOException {
        ConditionData conditionData = new ConditionData();
        if (mustMatchToken(87, "msg.no.paren.cond")) {
            conditionData.f10729lp = this.f10728ts.tokenBeg;
        }
        conditionData.condition = expr();
        if (mustMatchToken(88, "msg.no.paren.after.cond")) {
            conditionData.f10730rp = this.f10728ts.tokenBeg;
        }
        if (conditionData.condition instanceof Assignment) {
            addStrictWarning("msg.equal.as.assign", "", conditionData.condition.getPosition(), conditionData.condition.getLength());
        }
        return conditionData;
    }

    private AstNode statement() throws IOException {
        int peekTokenOrEOL;
        int i = this.f10728ts.tokenBeg;
        try {
            AstNode statementHelper = statementHelper();
            if (statementHelper != null) {
                if (this.compilerEnv.isStrictMode() && !statementHelper.hasSideEffects()) {
                    int position = statementHelper.getPosition();
                    int max = Math.max(position, lineBeginningFor(position));
                    addStrictWarning(statementHelper instanceof EmptyStatement ? "msg.extra.trailing.semi" : "msg.no.side.effects", "", max, nodeEnd(statementHelper) - max);
                }
                return statementHelper;
            }
        } catch (ParserException unused) {
        }
        do {
            peekTokenOrEOL = peekTokenOrEOL();
            consumeToken();
            if (peekTokenOrEOL == -1 || peekTokenOrEOL == 0 || peekTokenOrEOL == 1) {
                break;
            }
        } while (peekTokenOrEOL != 82);
        return new EmptyStatement(i, this.f10728ts.tokenBeg - i);
    }

    private AstNode statementHelper() throws IOException {
        AstNode returnOrYield;
        LabeledStatement labeledStatement = this.currentLabel;
        if (labeledStatement != null && labeledStatement.getStatement() != null) {
            this.currentLabel = null;
        }
        int peekToken = peekToken();
        int i = this.f10728ts.tokenBeg;
        if (peekToken != -1) {
            if (peekToken != 4) {
                if (peekToken == 39) {
                    returnOrYield = nameOrLabel();
                    if (!(returnOrYield instanceof ExpressionStatement)) {
                        return returnOrYield;
                    }
                } else if (peekToken == 50) {
                    returnOrYield = throwStatement();
                } else if (peekToken != 72) {
                    if (peekToken == 85) {
                        return block();
                    }
                    if (peekToken == 109) {
                        consumeToken();
                        return function(3);
                    } else if (peekToken == 112) {
                        return ifStatement();
                    } else {
                        if (peekToken == 114) {
                            return switchStatement();
                        }
                        if (peekToken == 160) {
                            consumeToken();
                            returnOrYield = new KeywordLiteral(this.f10728ts.tokenBeg, this.f10728ts.tokenEnd - this.f10728ts.tokenBeg, peekToken);
                            returnOrYield.setLineno(this.f10728ts.lineno);
                        } else if (peekToken == 81) {
                            return tryStatement();
                        } else {
                            if (peekToken == 82) {
                                consumeToken();
                                int i2 = this.f10728ts.tokenBeg;
                                EmptyStatement emptyStatement = new EmptyStatement(i2, this.f10728ts.tokenEnd - i2);
                                emptyStatement.setLineno(this.f10728ts.lineno);
                                return emptyStatement;
                            } else if (peekToken != 153) {
                                if (peekToken != 154) {
                                    switch (peekToken) {
                                        case 116:
                                            returnOrYield = defaultXmlNamespace();
                                            break;
                                        case 117:
                                            return whileLoop();
                                        case 118:
                                            return doLoop();
                                        case 119:
                                            return forLoop();
                                        case 120:
                                            returnOrYield = breakStatement();
                                            break;
                                        case 121:
                                            returnOrYield = continueStatement();
                                            break;
                                        case 122:
                                            break;
                                        case 123:
                                            if (this.inUseStrictDirective) {
                                                reportError("msg.no.with.strict");
                                            }
                                            return withStatement();
                                        default:
                                            int i3 = this.f10728ts.lineno;
                                            returnOrYield = new ExpressionStatement(expr(), true ^ insideFunction());
                                            returnOrYield.setLineno(i3);
                                            break;
                                    }
                                }
                                consumeToken();
                                int i4 = this.f10728ts.lineno;
                                returnOrYield = variables(this.currentToken, this.f10728ts.tokenBeg, true);
                                returnOrYield.setLineno(i4);
                            } else {
                                AstNode letStatement = letStatement();
                                if (!(letStatement instanceof VariableDeclaration) || peekToken() != 82) {
                                    return letStatement;
                                }
                                returnOrYield = letStatement;
                            }
                        }
                    }
                }
                autoInsertSemicolon(returnOrYield);
                return returnOrYield;
            }
            returnOrYield = returnOrYield(peekToken, false);
            autoInsertSemicolon(returnOrYield);
            return returnOrYield;
        }
        consumeToken();
        return makeErrorNode();
    }

    private void autoInsertSemicolon(AstNode astNode) throws IOException {
        int peekFlaggedToken = peekFlaggedToken();
        int position = astNode.getPosition();
        int i = 65535 & peekFlaggedToken;
        if (i != -1 && i != 0) {
            if (i == 82) {
                consumeToken();
                astNode.setLength(this.f10728ts.tokenEnd - position);
                return;
            } else if (i != 86) {
                if ((peekFlaggedToken & 65536) == 0) {
                    reportError("msg.no.semi.stmt");
                    return;
                } else {
                    warnMissingSemi(position, nodeEnd(astNode));
                    return;
                }
            }
        }
        warnMissingSemi(position, nodeEnd(astNode));
    }

    private IfStatement ifStatement() throws IOException {
        if (this.currentToken != 112) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.tokenBeg;
        int i2 = this.f10728ts.lineno;
        int i3 = -1;
        ConditionData condition = condition();
        AstNode statement = statement();
        AstNode astNode = null;
        if (matchToken(113)) {
            i3 = this.f10728ts.tokenBeg - i;
            astNode = statement();
        }
        IfStatement ifStatement = new IfStatement(i, getNodeEnd(astNode != null ? astNode : statement) - i);
        ifStatement.setCondition(condition.condition);
        ifStatement.setParens(condition.f10729lp - i, condition.f10730rp - i);
        ifStatement.setThenPart(statement);
        ifStatement.setElsePart(astNode);
        ifStatement.setElsePosition(i3);
        ifStatement.setLineno(i2);
        return ifStatement;
    }

    private SwitchStatement switchStatement() throws IOException {
        AstNode expr;
        if (this.currentToken != 114) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.tokenBeg;
        SwitchStatement switchStatement = new SwitchStatement(i);
        if (mustMatchToken(87, "msg.no.paren.switch")) {
            switchStatement.setLp(this.f10728ts.tokenBeg - i);
        }
        switchStatement.setLineno(this.f10728ts.lineno);
        switchStatement.setExpression(expr());
        enterSwitch(switchStatement);
        try {
            if (mustMatchToken(88, "msg.no.paren.after.switch")) {
                switchStatement.setRp(this.f10728ts.tokenBeg - i);
            }
            mustMatchToken(85, "msg.no.brace.switch");
            boolean z = false;
            while (true) {
                int nextToken = nextToken();
                int i2 = this.f10728ts.tokenBeg;
                int i3 = this.f10728ts.lineno;
                if (nextToken == 86) {
                    switchStatement.setLength(this.f10728ts.tokenEnd - i);
                    break;
                }
                if (nextToken == 115) {
                    expr = expr();
                    mustMatchToken(103, "msg.no.colon.case");
                } else if (nextToken == 116) {
                    if (z) {
                        reportError("msg.double.switch.default");
                    }
                    z = true;
                    expr = null;
                    mustMatchToken(103, "msg.no.colon.case");
                } else {
                    reportError("msg.bad.switch");
                    break;
                }
                SwitchCase switchCase = new SwitchCase(i2);
                switchCase.setExpression(expr);
                switchCase.setLength(this.f10728ts.tokenEnd - i);
                switchCase.setLineno(i3);
                while (true) {
                    int peekToken = peekToken();
                    if (peekToken != 86 && peekToken != 115 && peekToken != 116 && peekToken != 0) {
                        switchCase.addStatement(statement());
                    }
                }
                switchStatement.addCase(switchCase);
            }
            return switchStatement;
        } finally {
            exitSwitch();
        }
    }

    private WhileLoop whileLoop() throws IOException {
        if (this.currentToken != 117) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.tokenBeg;
        WhileLoop whileLoop = new WhileLoop(i);
        whileLoop.setLineno(this.f10728ts.lineno);
        enterLoop(whileLoop);
        try {
            ConditionData condition = condition();
            whileLoop.setCondition(condition.condition);
            whileLoop.setParens(condition.f10729lp - i, condition.f10730rp - i);
            AstNode statement = statement();
            whileLoop.setLength(getNodeEnd(statement) - i);
            whileLoop.setBody(statement);
            return whileLoop;
        } finally {
            exitLoop();
        }
    }

    private DoLoop doLoop() throws IOException {
        if (this.currentToken != 118) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.tokenBeg;
        DoLoop doLoop = new DoLoop(i);
        doLoop.setLineno(this.f10728ts.lineno);
        enterLoop(doLoop);
        try {
            AstNode statement = statement();
            mustMatchToken(117, "msg.no.while.do");
            doLoop.setWhilePosition(this.f10728ts.tokenBeg - i);
            ConditionData condition = condition();
            doLoop.setCondition(condition.condition);
            doLoop.setParens(condition.f10729lp - i, condition.f10730rp - i);
            int nodeEnd = getNodeEnd(statement);
            doLoop.setBody(statement);
            exitLoop();
            if (matchToken(82)) {
                nodeEnd = this.f10728ts.tokenEnd;
            }
            doLoop.setLength(nodeEnd - i);
            return doLoop;
        } catch (Throwable th) {
            exitLoop();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004e A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:6:0x0021, B:9:0x002c, B:11:0x003a, B:14:0x0046, B:16:0x004e, B:18:0x0055, B:20:0x0067, B:29:0x00bf, B:31:0x00c7, B:33:0x00ce, B:35:0x00d7, B:37:0x00e4, B:38:0x00e9, B:40:0x0108, B:42:0x0122, B:39:0x00f9, B:21:0x0074, B:23:0x0081, B:25:0x0096, B:27:0x00a5, B:28:0x00b8, B:24:0x0092, B:12:0x0041, B:41:0x0113), top: B:56:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:6:0x0021, B:9:0x002c, B:11:0x003a, B:14:0x0046, B:16:0x004e, B:18:0x0055, B:20:0x0067, B:29:0x00bf, B:31:0x00c7, B:33:0x00ce, B:35:0x00d7, B:37:0x00e4, B:38:0x00e9, B:40:0x0108, B:42:0x0122, B:39:0x00f9, B:21:0x0074, B:23:0x0081, B:25:0x0096, B:27:0x00a5, B:28:0x00b8, B:24:0x0092, B:12:0x0041, B:41:0x0113), top: B:56:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:6:0x0021, B:9:0x002c, B:11:0x003a, B:14:0x0046, B:16:0x004e, B:18:0x0055, B:20:0x0067, B:29:0x00bf, B:31:0x00c7, B:33:0x00ce, B:35:0x00d7, B:37:0x00e4, B:38:0x00e9, B:40:0x0108, B:42:0x0122, B:39:0x00f9, B:21:0x0074, B:23:0x0081, B:25:0x0096, B:27:0x00a5, B:28:0x00b8, B:24:0x0092, B:12:0x0041, B:41:0x0113), top: B:56:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c7 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:6:0x0021, B:9:0x002c, B:11:0x003a, B:14:0x0046, B:16:0x004e, B:18:0x0055, B:20:0x0067, B:29:0x00bf, B:31:0x00c7, B:33:0x00ce, B:35:0x00d7, B:37:0x00e4, B:38:0x00e9, B:40:0x0108, B:42:0x0122, B:39:0x00f9, B:21:0x0074, B:23:0x0081, B:25:0x0096, B:27:0x00a5, B:28:0x00b8, B:24:0x0092, B:12:0x0041, B:41:0x0113), top: B:56:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ce A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:6:0x0021, B:9:0x002c, B:11:0x003a, B:14:0x0046, B:16:0x004e, B:18:0x0055, B:20:0x0067, B:29:0x00bf, B:31:0x00c7, B:33:0x00ce, B:35:0x00d7, B:37:0x00e4, B:38:0x00e9, B:40:0x0108, B:42:0x0122, B:39:0x00f9, B:21:0x0074, B:23:0x0081, B:25:0x0096, B:27:0x00a5, B:28:0x00b8, B:24:0x0092, B:12:0x0041, B:41:0x0113), top: B:56:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f9 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:6:0x0021, B:9:0x002c, B:11:0x003a, B:14:0x0046, B:16:0x004e, B:18:0x0055, B:20:0x0067, B:29:0x00bf, B:31:0x00c7, B:33:0x00ce, B:35:0x00d7, B:37:0x00e4, B:38:0x00e9, B:40:0x0108, B:42:0x0122, B:39:0x00f9, B:21:0x0074, B:23:0x0081, B:25:0x0096, B:27:0x00a5, B:28:0x00b8, B:24:0x0092, B:12:0x0041, B:41:0x0113), top: B:56:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.ast.Loop forLoop() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.forLoop():org.mozilla.javascript.ast.Loop");
    }

    private AstNode forLoopInit(int i) throws IOException {
        AstNode variables;
        try {
            this.inForInit = true;
            if (i == 82) {
                variables = new EmptyExpression(this.f10728ts.tokenBeg, 1);
                variables.setLineno(this.f10728ts.lineno);
            } else {
                if (i != 122 && i != 153) {
                    variables = expr();
                    markDestructuring(variables);
                }
                consumeToken();
                variables = variables(i, this.f10728ts.tokenBeg, false);
            }
            return variables;
        } finally {
            this.inForInit = false;
        }
    }

    private TryStatement tryStatement() throws IOException {
        int i;
        ArrayList arrayList;
        int i2;
        AstNode astNode;
        int i3;
        AstNode astNode2;
        if (this.currentToken != 81) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        int i4 = this.f10728ts.tokenBeg;
        int i5 = this.f10728ts.lineno;
        int i6 = 85;
        if (peekToken() != 85) {
            reportError("msg.no.brace.try");
        }
        AstNode statement = statement();
        int nodeEnd = getNodeEnd(statement);
        boolean z = false;
        int peekToken = peekToken();
        if (peekToken == 124) {
            arrayList = null;
            for (int i7 = 124; matchToken(i7); i7 = 124) {
                int i8 = this.f10728ts.lineno;
                if (z) {
                    reportError("msg.catch.unreachable");
                }
                int i9 = this.f10728ts.tokenBeg;
                int i10 = mustMatchToken(87, "msg.no.paren.catch") ? this.f10728ts.tokenBeg : -1;
                mustMatchToken(39, "msg.bad.catchcond");
                Name createNameNode = createNameNode();
                String identifier = createNameNode.getIdentifier();
                if (this.inUseStrictDirective && ("eval".equals(identifier) || "arguments".equals(identifier))) {
                    reportError("msg.bad.id.strict", identifier);
                }
                if (matchToken(112)) {
                    i3 = this.f10728ts.tokenBeg;
                    astNode2 = expr();
                } else {
                    z = true;
                    i3 = -1;
                    astNode2 = null;
                }
                int i11 = mustMatchToken(88, "msg.bad.catchcond") ? this.f10728ts.tokenBeg : -1;
                mustMatchToken(i6, "msg.no.brace.catchblock");
                Block block = (Block) statements();
                int nodeEnd2 = getNodeEnd(block);
                CatchClause catchClause = new CatchClause(i9);
                catchClause.setVarName(createNameNode);
                catchClause.setCatchCondition(astNode2);
                catchClause.setBody(block);
                if (i3 != -1) {
                    catchClause.setIfPosition(i3 - i9);
                }
                catchClause.setParens(i10, i11);
                catchClause.setLineno(i8);
                nodeEnd = mustMatchToken(86, "msg.no.brace.after.body") ? this.f10728ts.tokenEnd : nodeEnd2;
                catchClause.setLength(nodeEnd - i9);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(catchClause);
                i6 = 85;
            }
            i = 125;
        } else {
            i = 125;
            if (peekToken != 125) {
                mustMatchToken(125, "msg.try.no.catchfinally");
            }
            arrayList = null;
        }
        if (matchToken(i)) {
            int i12 = this.f10728ts.tokenBeg;
            AstNode statement2 = statement();
            nodeEnd = getNodeEnd(statement2);
            astNode = statement2;
            i2 = i12;
        } else {
            i2 = -1;
            astNode = null;
        }
        TryStatement tryStatement = new TryStatement(i4, nodeEnd - i4);
        tryStatement.setTryBlock(statement);
        tryStatement.setCatchClauses(arrayList);
        tryStatement.setFinallyBlock(astNode);
        if (i2 != -1) {
            tryStatement.setFinallyPosition(i2 - i4);
        }
        tryStatement.setLineno(i5);
        if (andResetJsDoc != null) {
            tryStatement.setJsDocNode(andResetJsDoc);
        }
        return tryStatement;
    }

    private ThrowStatement throwStatement() throws IOException {
        if (this.currentToken != 50) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.tokenBeg;
        int i2 = this.f10728ts.lineno;
        if (peekTokenOrEOL() == 1) {
            reportError("msg.bad.throw.eol");
        }
        AstNode expr = expr();
        ThrowStatement throwStatement = new ThrowStatement(i, getNodeEnd(expr), expr);
        throwStatement.setLineno(i2);
        return throwStatement;
    }

    private LabeledStatement matchJumpLabelName() throws IOException {
        if (peekTokenOrEOL() == 39) {
            consumeToken();
            Map<String, LabeledStatement> map = this.labelSet;
            r1 = map != null ? map.get(this.f10728ts.getString()) : null;
            if (r1 == null) {
                reportError("msg.undef.label");
            }
        }
        return r1;
    }

    private BreakStatement breakStatement() throws IOException {
        int i;
        Name name;
        List<Jump> list;
        if (this.currentToken != 120) {
            codeBug();
        }
        consumeToken();
        int i2 = this.f10728ts.lineno;
        int i3 = this.f10728ts.tokenBeg;
        int i4 = this.f10728ts.tokenEnd;
        if (peekTokenOrEOL() == 39) {
            name = createNameNode();
            i = getNodeEnd(name);
        } else {
            i = i4;
            name = null;
        }
        LabeledStatement matchJumpLabelName = matchJumpLabelName();
        Jump firstLabel = matchJumpLabelName != null ? matchJumpLabelName.getFirstLabel() : null;
        if (firstLabel == null && name == null) {
            List<Jump> list2 = this.loopAndSwitchSet;
            if (list2 != null && list2.size() != 0) {
                firstLabel = this.loopAndSwitchSet.get(list.size() - 1);
            } else if (name == null) {
                reportError("msg.bad.break", i3, i - i3);
            }
        }
        BreakStatement breakStatement = new BreakStatement(i3, i - i3);
        breakStatement.setBreakLabel(name);
        if (firstLabel != null) {
            breakStatement.setBreakTarget(firstLabel);
        }
        breakStatement.setLineno(i2);
        return breakStatement;
    }

    private ContinueStatement continueStatement() throws IOException {
        int i;
        Name name;
        List<Loop> list;
        if (this.currentToken != 121) {
            codeBug();
        }
        consumeToken();
        int i2 = this.f10728ts.lineno;
        int i3 = this.f10728ts.tokenBeg;
        int i4 = this.f10728ts.tokenEnd;
        Loop loop = null;
        if (peekTokenOrEOL() == 39) {
            name = createNameNode();
            i = getNodeEnd(name);
        } else {
            i = i4;
            name = null;
        }
        LabeledStatement matchJumpLabelName = matchJumpLabelName();
        if (matchJumpLabelName == null && name == null) {
            List<Loop> list2 = this.loopSet;
            if (list2 == null || list2.size() == 0) {
                reportError("msg.continue.outside");
            } else {
                loop = this.loopSet.get(list.size() - 1);
            }
        } else {
            if (matchJumpLabelName == null || !(matchJumpLabelName.getStatement() instanceof Loop)) {
                reportError("msg.continue.nonloop", i3, i - i3);
            }
            if (matchJumpLabelName != null) {
                loop = (Loop) matchJumpLabelName.getStatement();
            }
        }
        ContinueStatement continueStatement = new ContinueStatement(i3, i - i3);
        if (loop != null) {
            continueStatement.setTarget(loop);
        }
        continueStatement.setLabel(name);
        continueStatement.setLineno(i2);
        return continueStatement;
    }

    private WithStatement withStatement() throws IOException {
        if (this.currentToken != 123) {
            codeBug();
        }
        consumeToken();
        Comment andResetJsDoc = getAndResetJsDoc();
        int i = this.f10728ts.lineno;
        int i2 = this.f10728ts.tokenBeg;
        int i3 = mustMatchToken(87, "msg.no.paren.with") ? this.f10728ts.tokenBeg : -1;
        AstNode expr = expr();
        int i4 = mustMatchToken(88, "msg.no.paren.after.with") ? this.f10728ts.tokenBeg : -1;
        AstNode statement = statement();
        WithStatement withStatement = new WithStatement(i2, getNodeEnd(statement) - i2);
        withStatement.setJsDocNode(andResetJsDoc);
        withStatement.setExpression(expr);
        withStatement.setStatement(statement);
        withStatement.setParens(i3, i4);
        withStatement.setLineno(i);
        return withStatement;
    }

    private AstNode letStatement() throws IOException {
        AstNode variables;
        if (this.currentToken != 153) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.lineno;
        int i2 = this.f10728ts.tokenBeg;
        if (peekToken() == 87) {
            variables = let(true, i2);
        } else {
            variables = variables(153, i2, true);
        }
        variables.setLineno(i);
        return variables;
    }

    private AstNode returnOrYield(int i, boolean z) throws IOException {
        AstNode yield;
        if (!insideFunction()) {
            reportError(i == 4 ? "msg.bad.return" : "msg.bad.yield");
        }
        consumeToken();
        int i2 = this.f10728ts.lineno;
        int i3 = this.f10728ts.tokenBeg;
        int i4 = this.f10728ts.tokenEnd;
        AstNode astNode = null;
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL != -1 && peekTokenOrEOL != 0 && peekTokenOrEOL != 1 && peekTokenOrEOL != 72 && peekTokenOrEOL != 82 && peekTokenOrEOL != 84 && peekTokenOrEOL != 86 && peekTokenOrEOL != 88) {
            astNode = expr();
            i4 = getNodeEnd(astNode);
        }
        int i5 = this.endFlags;
        if (i == 4) {
            this.endFlags = i5 | (astNode == null ? 2 : 4);
            int i6 = i4 - i3;
            yield = new ReturnStatement(i3, i6, astNode);
            if (nowAllSet(i5, this.endFlags, 6)) {
                addStrictWarning("msg.return.inconsistent", "", i3, i6);
            }
        } else {
            if (!insideFunction()) {
                reportError("msg.bad.yield");
            }
            this.endFlags |= 8;
            yield = new Yield(i3, i4 - i3, astNode);
            setRequiresActivation();
            setIsGenerator();
            if (!z) {
                yield = new ExpressionStatement(yield);
            }
        }
        if (insideFunction() && nowAllSet(i5, this.endFlags, 12)) {
            Name functionName = ((FunctionNode) this.currentScriptOrFn).getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                addError("msg.anon.generator.returns", "");
            } else {
                addError("msg.generator.returns", functionName.getIdentifier());
            }
        }
        yield.setLineno(i2);
        return yield;
    }

    private AstNode block() throws IOException {
        if (this.currentToken != 85) {
            codeBug();
        }
        consumeToken();
        int i = this.f10728ts.tokenBeg;
        Scope scope = new Scope(i);
        scope.setLineno(this.f10728ts.lineno);
        pushScope(scope);
        try {
            statements(scope);
            mustMatchToken(86, "msg.no.brace.block");
            scope.setLength(this.f10728ts.tokenEnd - i);
            return scope;
        } finally {
            popScope();
        }
    }

    private AstNode defaultXmlNamespace() throws IOException {
        if (this.currentToken != 116) {
            codeBug();
        }
        consumeToken();
        mustHaveXML();
        setRequiresActivation();
        int i = this.f10728ts.lineno;
        int i2 = this.f10728ts.tokenBeg;
        if (!matchToken(39) || !"xml".equals(this.f10728ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(39) || !"namespace".equals(this.f10728ts.getString())) {
            reportError("msg.bad.namespace");
        }
        if (!matchToken(90)) {
            reportError("msg.bad.namespace");
        }
        AstNode expr = expr();
        UnaryExpression unaryExpression = new UnaryExpression(i2, getNodeEnd(expr) - i2);
        unaryExpression.setOperator(74);
        unaryExpression.setOperand(expr);
        unaryExpression.setLineno(i);
        return new ExpressionStatement((AstNode) unaryExpression, true);
    }

    private void recordLabel(Label label, LabeledStatement labeledStatement) throws IOException {
        if (peekToken() != 103) {
            codeBug();
        }
        consumeToken();
        String name = label.getName();
        Map<String, LabeledStatement> map = this.labelSet;
        if (map == null) {
            this.labelSet = new HashMap();
        } else {
            LabeledStatement labeledStatement2 = map.get(name);
            if (labeledStatement2 != null) {
                if (this.compilerEnv.isIdeMode()) {
                    Label labelByName = labeledStatement2.getLabelByName(name);
                    reportError("msg.dup.label", labelByName.getAbsolutePosition(), labelByName.getLength());
                }
                reportError("msg.dup.label", label.getPosition(), label.getLength());
            }
        }
        labeledStatement.addLabel(label);
        this.labelSet.put(name, labeledStatement);
    }

    private AstNode nameOrLabel() throws IOException {
        AstNode astNode;
        if (this.currentToken != 39) {
            throw codeBug();
        }
        int i = this.f10728ts.tokenBeg;
        this.currentFlaggedToken |= 131072;
        AstNode expr = expr();
        if (expr.getType() != 130) {
            ExpressionStatement expressionStatement = new ExpressionStatement(expr, !insideFunction());
            expressionStatement.lineno = expr.lineno;
            return expressionStatement;
        }
        LabeledStatement labeledStatement = new LabeledStatement(i);
        recordLabel((Label) expr, labeledStatement);
        labeledStatement.setLineno(this.f10728ts.lineno);
        while (true) {
            if (peekToken() != 39) {
                astNode = null;
                break;
            }
            this.currentFlaggedToken |= 131072;
            AstNode expr2 = expr();
            if (expr2.getType() != 130) {
                astNode = new ExpressionStatement(expr2, !insideFunction());
                autoInsertSemicolon(astNode);
                break;
            }
            recordLabel((Label) expr2, labeledStatement);
        }
        try {
            this.currentLabel = labeledStatement;
            if (astNode == null) {
                astNode = statementHelper();
            }
            labeledStatement.setLength(astNode.getParent() == null ? getNodeEnd(astNode) - i : getNodeEnd(astNode));
            labeledStatement.setStatement(astNode);
            return labeledStatement;
        } finally {
            this.currentLabel = null;
            for (Label next : labeledStatement.getLabels()) {
                this.labelSet.remove(next.getName());
            }
        }
    }

    private VariableDeclaration variables(int i, int i2, boolean z) throws IOException {
        AstNode destructuringPrimaryExpr;
        int i3;
        Name name;
        VariableDeclaration variableDeclaration = new VariableDeclaration(i2);
        variableDeclaration.setType(i);
        variableDeclaration.setLineno(this.f10728ts.lineno);
        Comment andResetJsDoc = getAndResetJsDoc();
        if (andResetJsDoc != null) {
            variableDeclaration.setJsDocNode(andResetJsDoc);
        }
        do {
            int peekToken = peekToken();
            int i4 = this.f10728ts.tokenBeg;
            int i5 = this.f10728ts.tokenEnd;
            AstNode astNode = null;
            if (peekToken == 83 || peekToken == 85) {
                destructuringPrimaryExpr = destructuringPrimaryExpr();
                int nodeEnd = getNodeEnd(destructuringPrimaryExpr);
                if (!(destructuringPrimaryExpr instanceof DestructuringForm)) {
                    reportError("msg.bad.assign.left", i4, nodeEnd - i4);
                }
                markDestructuring(destructuringPrimaryExpr);
                i3 = nodeEnd;
                name = null;
            } else {
                mustMatchToken(39, "msg.bad.var");
                Name createNameNode = createNameNode();
                createNameNode.setLineno(this.f10728ts.getLineno());
                if (this.inUseStrictDirective) {
                    String string = this.f10728ts.getString();
                    if ("eval".equals(string) || "arguments".equals(this.f10728ts.getString())) {
                        reportError("msg.bad.id.strict", string);
                    }
                }
                defineSymbol(i, this.f10728ts.getString(), this.inForInit);
                i3 = i5;
                name = createNameNode;
                destructuringPrimaryExpr = null;
            }
            int i6 = this.f10728ts.lineno;
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (matchToken(90)) {
                astNode = assignExpr();
                i3 = getNodeEnd(astNode);
            }
            VariableInitializer variableInitializer = new VariableInitializer(i4, i3 - i4);
            if (destructuringPrimaryExpr != null) {
                if (astNode == null && !this.inForInit) {
                    reportError("msg.destruct.assign.no.init");
                }
                variableInitializer.setTarget(destructuringPrimaryExpr);
            } else {
                variableInitializer.setTarget(name);
            }
            variableInitializer.setInitializer(astNode);
            variableInitializer.setType(i);
            variableInitializer.setJsDocNode(andResetJsDoc2);
            variableInitializer.setLineno(i6);
            variableDeclaration.addVariable(variableInitializer);
        } while (matchToken(89));
        variableDeclaration.setLength(i3 - i2);
        variableDeclaration.setIsStatement(z);
        return variableDeclaration;
    }

    private AstNode let(boolean z, int i) throws IOException {
        LetNode letNode = new LetNode(i);
        letNode.setLineno(this.f10728ts.lineno);
        if (mustMatchToken(87, "msg.no.paren.after.let")) {
            letNode.setLp(this.f10728ts.tokenBeg - i);
        }
        pushScope(letNode);
        try {
            letNode.setVariables(variables(153, this.f10728ts.tokenBeg, z));
            if (mustMatchToken(88, "msg.no.paren.let")) {
                letNode.setRp(this.f10728ts.tokenBeg - i);
            }
            if (z && peekToken() == 85) {
                consumeToken();
                int i2 = this.f10728ts.tokenBeg;
                AstNode statements = statements();
                mustMatchToken(86, "msg.no.curly.let");
                statements.setLength(this.f10728ts.tokenEnd - i2);
                letNode.setLength(this.f10728ts.tokenEnd - i);
                letNode.setBody(statements);
                letNode.setType(153);
            } else {
                AstNode expr = expr();
                letNode.setLength(getNodeEnd(expr) - i);
                letNode.setBody(expr);
                if (z) {
                    ExpressionStatement expressionStatement = new ExpressionStatement(letNode, !insideFunction());
                    expressionStatement.setLineno(letNode.getLineno());
                    return expressionStatement;
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    void defineSymbol(int i, String str) {
        defineSymbol(i, str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void defineSymbol(int i, String str, boolean z) {
        if (str == null) {
            if (this.compilerEnv.isIdeMode()) {
                return;
            }
            codeBug();
        }
        Scope definingScope = this.currentScope.getDefiningScope(str);
        Symbol symbol = definingScope != null ? definingScope.getSymbol(str) : null;
        int declType = symbol != null ? symbol.getDeclType() : -1;
        String str2 = "msg.var.redecl";
        if (symbol != null && (declType == 154 || i == 154 || (definingScope == this.currentScope && declType == 153))) {
            if (declType == 154) {
                str2 = "msg.const.redecl";
            } else if (declType == 153) {
                str2 = "msg.let.redecl";
            } else if (declType != 122) {
                str2 = declType == 109 ? "msg.fn.redecl" : "msg.parm.redecl";
            }
            addError(str2, str);
        } else if (i == 87) {
            if (symbol != null) {
                addWarning("msg.dup.parms", str);
            }
            this.currentScriptOrFn.putSymbol(new Symbol(i, str));
        } else {
            if (i != 109 && i != 122) {
                if (i == 153) {
                    if (!z && (this.currentScope.getType() == 112 || (this.currentScope instanceof Loop))) {
                        addError("msg.let.decl.not.in.block");
                        return;
                    } else {
                        this.currentScope.putSymbol(new Symbol(i, str));
                        return;
                    }
                } else if (i != 154) {
                    throw codeBug();
                }
            }
            if (symbol == null) {
                this.currentScriptOrFn.putSymbol(new Symbol(i, str));
            } else if (declType == 122) {
                addStrictWarning("msg.var.redecl", str);
            } else if (declType == 87) {
                addStrictWarning("msg.var.hides.arg", str);
            }
        }
    }

    private AstNode expr() throws IOException {
        AstNode assignExpr = assignExpr();
        int position = assignExpr.getPosition();
        while (matchToken(89)) {
            int i = this.f10728ts.tokenBeg;
            if (this.compilerEnv.isStrictMode() && !assignExpr.hasSideEffects()) {
                addStrictWarning("msg.no.side.effects", "", position, nodeEnd(assignExpr) - position);
            }
            if (peekToken() == 72) {
                reportError("msg.yield.parenthesized");
            }
            assignExpr = new InfixExpression(89, assignExpr, assignExpr(), i);
        }
        return assignExpr;
    }

    private AstNode assignExpr() throws IOException {
        int peekToken = peekToken();
        if (peekToken == 72) {
            return returnOrYield(peekToken, true);
        }
        AstNode condExpr = condExpr();
        int peekToken2 = peekToken();
        if (90 <= peekToken2 && peekToken2 <= 101) {
            consumeToken();
            Comment andResetJsDoc = getAndResetJsDoc();
            markDestructuring(condExpr);
            Assignment assignment = new Assignment(peekToken2, condExpr, assignExpr(), this.f10728ts.tokenBeg);
            if (andResetJsDoc != null) {
                assignment.setJsDocNode(andResetJsDoc);
            }
            return assignment;
        } else if (peekToken2 != 82 || this.currentJsDocComment == null) {
            return condExpr;
        } else {
            condExpr.setJsDocNode(getAndResetJsDoc());
            return condExpr;
        }
    }

    private AstNode condExpr() throws IOException {
        AstNode orExpr = orExpr();
        if (matchToken(102)) {
            int i = this.f10728ts.lineno;
            int i2 = this.f10728ts.tokenBeg;
            AstNode assignExpr = assignExpr();
            int i3 = mustMatchToken(103, "msg.no.colon.cond") ? this.f10728ts.tokenBeg : -1;
            AstNode assignExpr2 = assignExpr();
            int position = orExpr.getPosition();
            ConditionalExpression conditionalExpression = new ConditionalExpression(position, getNodeEnd(assignExpr2) - position);
            conditionalExpression.setLineno(i);
            conditionalExpression.setTestExpression(orExpr);
            conditionalExpression.setTrueExpression(assignExpr);
            conditionalExpression.setFalseExpression(assignExpr2);
            conditionalExpression.setQuestionMarkPosition(i2 - position);
            conditionalExpression.setColonPosition(i3 - position);
            return conditionalExpression;
        }
        return orExpr;
    }

    private AstNode orExpr() throws IOException {
        AstNode andExpr = andExpr();
        if (matchToken(104)) {
            return new InfixExpression(104, andExpr, orExpr(), this.f10728ts.tokenBeg);
        }
        return andExpr;
    }

    private AstNode andExpr() throws IOException {
        AstNode bitOrExpr = bitOrExpr();
        if (matchToken(105)) {
            return new InfixExpression(105, bitOrExpr, andExpr(), this.f10728ts.tokenBeg);
        }
        return bitOrExpr;
    }

    private AstNode bitOrExpr() throws IOException {
        AstNode bitXorExpr = bitXorExpr();
        while (matchToken(9)) {
            bitXorExpr = new InfixExpression(9, bitXorExpr, bitXorExpr(), this.f10728ts.tokenBeg);
        }
        return bitXorExpr;
    }

    private AstNode bitXorExpr() throws IOException {
        AstNode bitAndExpr = bitAndExpr();
        while (matchToken(10)) {
            bitAndExpr = new InfixExpression(10, bitAndExpr, bitAndExpr(), this.f10728ts.tokenBeg);
        }
        return bitAndExpr;
    }

    private AstNode bitAndExpr() throws IOException {
        AstNode eqExpr = eqExpr();
        while (matchToken(11)) {
            eqExpr = new InfixExpression(11, eqExpr, eqExpr(), this.f10728ts.tokenBeg);
        }
        return eqExpr;
    }

    private AstNode eqExpr() throws IOException {
        AstNode relExpr = relExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f10728ts.tokenBeg;
            if (peekToken != 12 && peekToken != 13 && peekToken != 46 && peekToken != 47) {
                return relExpr;
            }
            consumeToken();
            if (this.compilerEnv.getLanguageVersion() == 120) {
                if (peekToken == 12) {
                    peekToken = 46;
                } else if (peekToken == 13) {
                    peekToken = 47;
                }
            }
            relExpr = new InfixExpression(peekToken, relExpr, relExpr(), i);
        }
    }

    private AstNode relExpr() throws IOException {
        AstNode shiftExpr = shiftExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f10728ts.tokenBeg;
            if (peekToken == 52) {
                if (!this.inForInit) {
                    consumeToken();
                    shiftExpr = new InfixExpression(peekToken, shiftExpr, shiftExpr(), i);
                }
            } else {
                if (peekToken != 53) {
                    switch (peekToken) {
                    }
                } else {
                    continue;
                }
                consumeToken();
                shiftExpr = new InfixExpression(peekToken, shiftExpr, shiftExpr(), i);
            }
        }
        return shiftExpr;
    }

    private AstNode shiftExpr() throws IOException {
        AstNode addExpr = addExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f10728ts.tokenBeg;
            switch (peekToken) {
                case 18:
                case 19:
                case 20:
                    consumeToken();
                    addExpr = new InfixExpression(peekToken, addExpr, addExpr(), i);
                default:
                    return addExpr;
            }
        }
    }

    private AstNode addExpr() throws IOException {
        AstNode mulExpr = mulExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f10728ts.tokenBeg;
            if (peekToken != 21 && peekToken != 22) {
                return mulExpr;
            }
            consumeToken();
            mulExpr = new InfixExpression(peekToken, mulExpr, mulExpr(), i);
        }
    }

    private AstNode mulExpr() throws IOException {
        AstNode unaryExpr = unaryExpr();
        while (true) {
            int peekToken = peekToken();
            int i = this.f10728ts.tokenBeg;
            switch (peekToken) {
                case 23:
                case 24:
                case 25:
                    consumeToken();
                    unaryExpr = new InfixExpression(peekToken, unaryExpr, unaryExpr(), i);
                default:
                    return unaryExpr;
            }
        }
    }

    private AstNode unaryExpr() throws IOException {
        int peekToken = peekToken();
        int i = this.f10728ts.lineno;
        if (peekToken == -1) {
            consumeToken();
            return makeErrorNode();
        }
        if (peekToken != 14) {
            if (peekToken != 126) {
                if (peekToken == 21) {
                    consumeToken();
                    UnaryExpression unaryExpression = new UnaryExpression(28, this.f10728ts.tokenBeg, unaryExpr());
                    unaryExpression.setLineno(i);
                    return unaryExpression;
                } else if (peekToken == 22) {
                    consumeToken();
                    UnaryExpression unaryExpression2 = new UnaryExpression(29, this.f10728ts.tokenBeg, unaryExpr());
                    unaryExpression2.setLineno(i);
                    return unaryExpression2;
                } else if (peekToken != 26 && peekToken != 27) {
                    if (peekToken == 31) {
                        consumeToken();
                        UnaryExpression unaryExpression3 = new UnaryExpression(peekToken, this.f10728ts.tokenBeg, unaryExpr());
                        unaryExpression3.setLineno(i);
                        return unaryExpression3;
                    } else if (peekToken != 32) {
                        if (peekToken == 106 || peekToken == 107) {
                            consumeToken();
                            UnaryExpression unaryExpression4 = new UnaryExpression(peekToken, this.f10728ts.tokenBeg, memberExpr(true));
                            unaryExpression4.setLineno(i);
                            checkBadIncDec(unaryExpression4);
                            return unaryExpression4;
                        }
                    }
                }
            }
            consumeToken();
            UnaryExpression unaryExpression5 = new UnaryExpression(peekToken, this.f10728ts.tokenBeg, unaryExpr());
            unaryExpression5.setLineno(i);
            return unaryExpression5;
        } else if (this.compilerEnv.isXmlAvailable()) {
            consumeToken();
            return memberExprTail(true, xmlInitializer());
        }
        AstNode memberExpr = memberExpr(true);
        int peekTokenOrEOL = peekTokenOrEOL();
        if (peekTokenOrEOL == 106 || peekTokenOrEOL == 107) {
            consumeToken();
            UnaryExpression unaryExpression6 = new UnaryExpression(peekTokenOrEOL, this.f10728ts.tokenBeg, memberExpr, true);
            unaryExpression6.setLineno(i);
            checkBadIncDec(unaryExpression6);
            return unaryExpression6;
        }
        return memberExpr;
    }

    private AstNode xmlInitializer() throws IOException {
        if (this.currentToken != 14) {
            codeBug();
        }
        int i = this.f10728ts.tokenBeg;
        int firstXMLToken = this.f10728ts.getFirstXMLToken();
        if (firstXMLToken != 145 && firstXMLToken != 148) {
            reportError("msg.syntax");
            return makeErrorNode();
        }
        XmlLiteral xmlLiteral = new XmlLiteral(i);
        xmlLiteral.setLineno(this.f10728ts.lineno);
        while (firstXMLToken == 145) {
            xmlLiteral.addFragment(new XmlString(this.f10728ts.tokenBeg, this.f10728ts.getString()));
            mustMatchToken(85, "msg.syntax");
            int i2 = this.f10728ts.tokenBeg;
            AstNode emptyExpression = peekToken() == 86 ? new EmptyExpression(i2, this.f10728ts.tokenEnd - i2) : expr();
            mustMatchToken(86, "msg.syntax");
            XmlExpression xmlExpression = new XmlExpression(i2, emptyExpression);
            xmlExpression.setIsXmlAttribute(this.f10728ts.isXMLAttribute());
            xmlExpression.setLength(this.f10728ts.tokenEnd - i2);
            xmlLiteral.addFragment(xmlExpression);
            firstXMLToken = this.f10728ts.getNextXMLToken();
        }
        if (firstXMLToken == 148) {
            xmlLiteral.addFragment(new XmlString(this.f10728ts.tokenBeg, this.f10728ts.getString()));
            return xmlLiteral;
        }
        reportError("msg.syntax");
        return makeErrorNode();
    }

    private List<AstNode> argumentList() throws IOException {
        if (matchToken(88)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.inForInit;
        this.inForInit = false;
        do {
            try {
                if (peekToken() == 72) {
                    reportError("msg.yield.parenthesized");
                }
                AstNode assignExpr = assignExpr();
                if (peekToken() == 119) {
                    try {
                        arrayList.add(generatorExpression(assignExpr, 0, true));
                    } catch (IOException unused) {
                    }
                } else {
                    arrayList.add(assignExpr);
                }
            } catch (Throwable th) {
                this.inForInit = z;
                throw th;
            }
        } while (matchToken(89));
        this.inForInit = z;
        mustMatchToken(88, "msg.no.paren.arg");
        return arrayList;
    }

    private AstNode memberExpr(boolean z) throws IOException {
        AstNode astNode;
        int peekToken = peekToken();
        int i = this.f10728ts.lineno;
        if (peekToken != 30) {
            astNode = primaryExpr();
        } else {
            consumeToken();
            int i2 = this.f10728ts.tokenBeg;
            NewExpression newExpression = new NewExpression(i2);
            AstNode memberExpr = memberExpr(false);
            int nodeEnd = getNodeEnd(memberExpr);
            newExpression.setTarget(memberExpr);
            if (matchToken(87)) {
                int i3 = this.f10728ts.tokenBeg;
                List<AstNode> argumentList = argumentList();
                if (argumentList != null && argumentList.size() > 65536) {
                    reportError("msg.too.many.constructor.args");
                }
                int i4 = this.f10728ts.tokenBeg;
                int i5 = this.f10728ts.tokenEnd;
                if (argumentList != null) {
                    newExpression.setArguments(argumentList);
                }
                newExpression.setParens(i3 - i2, i4 - i2);
                nodeEnd = i5;
            }
            if (matchToken(85)) {
                ObjectLiteral objectLiteral = objectLiteral();
                nodeEnd = getNodeEnd(objectLiteral);
                newExpression.setInitializer(objectLiteral);
            }
            newExpression.setLength(nodeEnd - i2);
            astNode = newExpression;
        }
        astNode.setLineno(i);
        return memberExprTail(z, astNode);
    }

    private AstNode memberExprTail(boolean z, AstNode astNode) throws IOException {
        AstNode astNode2;
        if (astNode == null) {
            codeBug();
        }
        int position = astNode.getPosition();
        while (true) {
            int peekToken = peekToken();
            int i = -1;
            if (peekToken == 83) {
                consumeToken();
                int i2 = this.f10728ts.tokenBeg;
                int i3 = this.f10728ts.lineno;
                AstNode expr = expr();
                int nodeEnd = getNodeEnd(expr);
                if (mustMatchToken(84, "msg.no.bracket.index")) {
                    i = this.f10728ts.tokenBeg;
                    nodeEnd = this.f10728ts.tokenEnd;
                }
                ElementGet elementGet = new ElementGet(position, nodeEnd - position);
                elementGet.setTarget(astNode);
                elementGet.setElement(expr);
                elementGet.setParens(i2, i);
                elementGet.setLineno(i3);
                astNode2 = elementGet;
            } else if (peekToken != 87) {
                if (peekToken == 108 || peekToken == 143) {
                    int i4 = this.f10728ts.lineno;
                    astNode = propertyAccess(peekToken, astNode);
                    astNode.setLineno(i4);
                } else if (peekToken != 146) {
                    break;
                } else {
                    consumeToken();
                    int i5 = this.f10728ts.tokenBeg;
                    int i6 = this.f10728ts.lineno;
                    mustHaveXML();
                    setRequiresActivation();
                    AstNode expr2 = expr();
                    int nodeEnd2 = getNodeEnd(expr2);
                    if (mustMatchToken(88, "msg.no.paren")) {
                        i = this.f10728ts.tokenBeg;
                        nodeEnd2 = this.f10728ts.tokenEnd;
                    }
                    XmlDotQuery xmlDotQuery = new XmlDotQuery(position, nodeEnd2 - position);
                    xmlDotQuery.setLeft(astNode);
                    xmlDotQuery.setRight(expr2);
                    xmlDotQuery.setOperatorPosition(i5);
                    xmlDotQuery.setRp(i - position);
                    xmlDotQuery.setLineno(i6);
                    astNode2 = xmlDotQuery;
                }
            } else if (!z) {
                break;
            } else {
                int i7 = this.f10728ts.lineno;
                consumeToken();
                checkCallRequiresActivation(astNode);
                FunctionCall functionCall = new FunctionCall(position);
                functionCall.setTarget(astNode);
                functionCall.setLineno(i7);
                functionCall.setLp(this.f10728ts.tokenBeg - position);
                List<AstNode> argumentList = argumentList();
                if (argumentList != null && argumentList.size() > 65536) {
                    reportError("msg.too.many.function.args");
                }
                functionCall.setArguments(argumentList);
                functionCall.setRp(this.f10728ts.tokenBeg - position);
                functionCall.setLength(this.f10728ts.tokenEnd - position);
                astNode = functionCall;
            }
            astNode = astNode2;
        }
        return astNode;
    }

    private AstNode propertyAccess(int i, AstNode astNode) throws IOException {
        AstNode propertyName;
        String keywordToName;
        if (astNode == null) {
            codeBug();
        }
        int i2 = 0;
        int i3 = this.f10728ts.lineno;
        int i4 = this.f10728ts.tokenBeg;
        consumeToken();
        if (i == 143) {
            mustHaveXML();
            i2 = 4;
        }
        if (!this.compilerEnv.isXmlAvailable()) {
            if (nextToken() != 39 && (!this.compilerEnv.isReservedKeywordAsIdentifier() || !TokenStream.isKeyword(this.f10728ts.getString()))) {
                reportError("msg.no.name.after.dot");
            }
            PropertyGet propertyGet = new PropertyGet(astNode, createNameNode(true, 33), i4);
            propertyGet.setLineno(i3);
            return propertyGet;
        }
        int nextToken = nextToken();
        if (nextToken == 23) {
            saveNameTokenData(this.f10728ts.tokenBeg, "*", this.f10728ts.lineno);
            propertyName = propertyName(-1, "*", i2);
        } else if (nextToken == 39) {
            propertyName = propertyName(-1, this.f10728ts.getString(), i2);
        } else if (nextToken == 50) {
            saveNameTokenData(this.f10728ts.tokenBeg, "throw", this.f10728ts.lineno);
            propertyName = propertyName(-1, "throw", i2);
        } else if (nextToken == 147) {
            propertyName = attributeAccess();
        } else if (this.compilerEnv.isReservedKeywordAsIdentifier() && (keywordToName = Token.keywordToName(nextToken)) != null) {
            saveNameTokenData(this.f10728ts.tokenBeg, keywordToName, this.f10728ts.lineno);
            propertyName = propertyName(-1, keywordToName, i2);
        } else {
            reportError("msg.no.name.after.dot");
            return makeErrorNode();
        }
        boolean z = propertyName instanceof XmlRef;
        InfixExpression xmlMemberGet = z ? new XmlMemberGet() : new PropertyGet();
        if (z && i == 108) {
            xmlMemberGet.setType(108);
        }
        int position = astNode.getPosition();
        xmlMemberGet.setPosition(position);
        xmlMemberGet.setLength(getNodeEnd(propertyName) - position);
        xmlMemberGet.setOperatorPosition(i4 - position);
        xmlMemberGet.setLineno(astNode.getLineno());
        xmlMemberGet.setLeft(astNode);
        xmlMemberGet.setRight(propertyName);
        return xmlMemberGet;
    }

    private AstNode attributeAccess() throws IOException {
        int nextToken = nextToken();
        int i = this.f10728ts.tokenBeg;
        if (nextToken == 23) {
            saveNameTokenData(this.f10728ts.tokenBeg, "*", this.f10728ts.lineno);
            return propertyName(i, "*", 0);
        } else if (nextToken != 39) {
            if (nextToken == 83) {
                return xmlElemRef(i, null, -1);
            }
            reportError("msg.no.name.after.xmlAttr");
            return makeErrorNode();
        } else {
            return propertyName(i, this.f10728ts.getString(), 0);
        }
    }

    private AstNode propertyName(int i, String str, int i2) throws IOException {
        Name name;
        int i3;
        int i4 = i != -1 ? i : this.f10728ts.tokenBeg;
        int i5 = this.f10728ts.lineno;
        Name createNameNode = createNameNode(true, this.currentToken);
        if (matchToken(144)) {
            i3 = this.f10728ts.tokenBeg;
            int nextToken = nextToken();
            if (nextToken == 23) {
                saveNameTokenData(this.f10728ts.tokenBeg, "*", this.f10728ts.lineno);
                name = createNameNode(false, -1);
            } else if (nextToken != 39) {
                if (nextToken == 83) {
                    return xmlElemRef(i, createNameNode, i3);
                }
                reportError("msg.no.name.after.coloncolon");
                return makeErrorNode();
            } else {
                name = createNameNode();
            }
        } else {
            name = createNameNode;
            createNameNode = null;
            i3 = -1;
        }
        if (createNameNode == null && i2 == 0 && i == -1) {
            return name;
        }
        XmlPropRef xmlPropRef = new XmlPropRef(i4, getNodeEnd(name) - i4);
        xmlPropRef.setAtPos(i);
        xmlPropRef.setNamespace(createNameNode);
        xmlPropRef.setColonPos(i3);
        xmlPropRef.setPropName(name);
        xmlPropRef.setLineno(i5);
        return xmlPropRef;
    }

    private XmlElemRef xmlElemRef(int i, Name name, int i2) throws IOException {
        int i3 = this.f10728ts.tokenBeg;
        int i4 = -1;
        int i5 = i != -1 ? i : i3;
        AstNode expr = expr();
        int nodeEnd = getNodeEnd(expr);
        if (mustMatchToken(84, "msg.no.bracket.index")) {
            i4 = this.f10728ts.tokenBeg;
            nodeEnd = this.f10728ts.tokenEnd;
        }
        XmlElemRef xmlElemRef = new XmlElemRef(i5, nodeEnd - i5);
        xmlElemRef.setNamespace(name);
        xmlElemRef.setColonPos(i2);
        xmlElemRef.setAtPos(i);
        xmlElemRef.setExpression(expr);
        xmlElemRef.setBrackets(i3, i4);
        return xmlElemRef;
    }

    private AstNode destructuringPrimaryExpr() throws IOException, ParserException {
        try {
            this.inDestructuringAssignment = true;
            return primaryExpr();
        } finally {
            this.inDestructuringAssignment = false;
        }
    }

    private AstNode primaryExpr() throws IOException {
        int nextFlaggedToken = nextFlaggedToken();
        int i = 65535 & nextFlaggedToken;
        if (i != -1) {
            if (i != 0) {
                if (i != 24) {
                    if (i == 83) {
                        return arrayLiteral();
                    }
                    if (i == 85) {
                        return objectLiteral();
                    }
                    if (i == 87) {
                        return parenExpr();
                    }
                    if (i != 100) {
                        if (i == 109) {
                            return function(2);
                        }
                        if (i == 127) {
                            reportError("msg.reserved.id");
                        } else if (i == 147) {
                            mustHaveXML();
                            return attributeAccess();
                        } else if (i == 153) {
                            return let(false, this.f10728ts.tokenBeg);
                        } else {
                            switch (i) {
                                case 39:
                                    return name(nextFlaggedToken, i);
                                case 40:
                                    String string = this.f10728ts.getString();
                                    if (this.inUseStrictDirective && this.f10728ts.isNumberOctal()) {
                                        reportError("msg.no.octal.strict");
                                    }
                                    return new NumberLiteral(this.f10728ts.tokenBeg, string, this.f10728ts.getNumber());
                                case 41:
                                    return createStringLiteral();
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    int i2 = this.f10728ts.tokenBeg;
                                    return new KeywordLiteral(i2, this.f10728ts.tokenEnd - i2, i);
                                default:
                                    reportError("msg.syntax");
                                    break;
                            }
                        }
                    }
                }
                this.f10728ts.readRegExp(i);
                int i3 = this.f10728ts.tokenBeg;
                RegExpLiteral regExpLiteral = new RegExpLiteral(i3, this.f10728ts.tokenEnd - i3);
                regExpLiteral.setValue(this.f10728ts.getString());
                regExpLiteral.setFlags(this.f10728ts.readAndClearRegExpFlags());
                return regExpLiteral;
            }
            reportError("msg.unexpected.eof");
        }
        return makeErrorNode();
    }

    private AstNode parenExpr() throws IOException {
        boolean z = this.inForInit;
        this.inForInit = false;
        try {
            Comment andResetJsDoc = getAndResetJsDoc();
            int i = this.f10728ts.lineno;
            int i2 = this.f10728ts.tokenBeg;
            AstNode expr = expr();
            if (peekToken() == 119) {
                return generatorExpression(expr, i2);
            }
            ParenthesizedExpression parenthesizedExpression = new ParenthesizedExpression(expr);
            if (andResetJsDoc == null) {
                andResetJsDoc = getAndResetJsDoc();
            }
            if (andResetJsDoc != null) {
                parenthesizedExpression.setJsDocNode(andResetJsDoc);
            }
            mustMatchToken(88, "msg.no.paren");
            parenthesizedExpression.setLength(this.f10728ts.tokenEnd - parenthesizedExpression.getPosition());
            parenthesizedExpression.setLineno(i);
            return parenthesizedExpression;
        } finally {
            this.inForInit = z;
        }
    }

    private AstNode name(int i, int i2) throws IOException {
        String string = this.f10728ts.getString();
        int i3 = this.f10728ts.tokenBeg;
        int i4 = this.f10728ts.lineno;
        if ((i & 131072) != 0 && peekToken() == 103) {
            Label label = new Label(i3, this.f10728ts.tokenEnd - i3);
            label.setName(string);
            label.setLineno(this.f10728ts.lineno);
            return label;
        }
        saveNameTokenData(i3, string, i4);
        if (this.compilerEnv.isXmlAvailable()) {
            return propertyName(-1, string, 0);
        }
        return createNameNode(true, 39);
    }

    private AstNode arrayLiteral() throws IOException {
        int peekToken;
        if (this.currentToken != 83) {
            codeBug();
        }
        int i = this.f10728ts.tokenBeg;
        int i2 = this.f10728ts.tokenEnd;
        ArrayList<AstNode> arrayList = new ArrayList();
        ArrayLiteral arrayLiteral = new ArrayLiteral(i);
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int i5 = -1;
            while (true) {
                peekToken = peekToken();
                if (peekToken != 89) {
                    break;
                }
                consumeToken();
                i5 = this.f10728ts.tokenEnd;
                if (i3 == 0) {
                    i3 = 1;
                } else {
                    arrayList.add(new EmptyExpression(this.f10728ts.tokenBeg, 1));
                    i4++;
                }
            }
            if (peekToken == 84) {
                consumeToken();
                i2 = this.f10728ts.tokenEnd;
                arrayLiteral.setDestructuringLength(arrayList.size() + i3);
                arrayLiteral.setSkipCount(i4);
                if (i5 != -1) {
                    warnTrailingComma(i, arrayList, i5);
                }
            } else if (peekToken == 119 && i3 == 0 && arrayList.size() == 1) {
                return arrayComprehension((AstNode) arrayList.get(0), i);
            } else {
                if (peekToken == 0) {
                    reportError("msg.no.bracket.arg");
                    break;
                }
                if (i3 == 0) {
                    reportError("msg.no.bracket.arg");
                }
                arrayList.add(assignExpr());
                i3 = 0;
            }
        }
        for (AstNode astNode : arrayList) {
            arrayLiteral.addElement(astNode);
        }
        arrayLiteral.setLength(i2 - i);
        return arrayLiteral;
    }

    private AstNode arrayComprehension(AstNode astNode, int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 119) {
            arrayList.add(arrayComprehensionLoop());
        }
        int i2 = -1;
        ConditionData conditionData = null;
        if (peekToken() == 112) {
            consumeToken();
            i2 = this.f10728ts.tokenBeg - i;
            conditionData = condition();
        }
        mustMatchToken(84, "msg.no.bracket.arg");
        ArrayComprehension arrayComprehension = new ArrayComprehension(i, this.f10728ts.tokenEnd - i);
        arrayComprehension.setResult(astNode);
        arrayComprehension.setLoops(arrayList);
        if (conditionData != null) {
            arrayComprehension.setIfPosition(i2);
            arrayComprehension.setFilter(conditionData.condition);
            arrayComprehension.setFilterLp(conditionData.f10729lp - i);
            arrayComprehension.setFilterRp(conditionData.f10730rp - i);
        }
        return arrayComprehension;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:6:0x0019, B:9:0x0022, B:11:0x0030, B:14:0x003a, B:16:0x0042, B:18:0x0049, B:24:0x0058, B:27:0x006d, B:29:0x0074, B:30:0x007f, B:32:0x0089, B:34:0x0090, B:36:0x009e, B:38:0x00a5, B:42:0x00bd, B:25:0x005e, B:26:0x0066, B:12:0x0036), top: B:48:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:6:0x0019, B:9:0x0022, B:11:0x0030, B:14:0x003a, B:16:0x0042, B:18:0x0049, B:24:0x0058, B:27:0x006d, B:29:0x0074, B:30:0x007f, B:32:0x0089, B:34:0x0090, B:36:0x009e, B:38:0x00a5, B:42:0x00bd, B:25:0x005e, B:26:0x0066, B:12:0x0036), top: B:48:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:6:0x0019, B:9:0x0022, B:11:0x0030, B:14:0x003a, B:16:0x0042, B:18:0x0049, B:24:0x0058, B:27:0x006d, B:29:0x0074, B:30:0x007f, B:32:0x0089, B:34:0x0090, B:36:0x009e, B:38:0x00a5, B:42:0x00bd, B:25:0x005e, B:26:0x0066, B:12:0x0036), top: B:48:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0089 A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:6:0x0019, B:9:0x0022, B:11:0x0030, B:14:0x003a, B:16:0x0042, B:18:0x0049, B:24:0x0058, B:27:0x006d, B:29:0x0074, B:30:0x007f, B:32:0x0089, B:34:0x0090, B:36:0x009e, B:38:0x00a5, B:42:0x00bd, B:25:0x005e, B:26:0x0066, B:12:0x0036), top: B:48:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e A[Catch: all -> 0x00c7, TryCatch #0 {all -> 0x00c7, blocks: (B:6:0x0019, B:9:0x0022, B:11:0x0030, B:14:0x003a, B:16:0x0042, B:18:0x0049, B:24:0x0058, B:27:0x006d, B:29:0x0074, B:30:0x007f, B:32:0x0089, B:34:0x0090, B:36:0x009e, B:38:0x00a5, B:42:0x00bd, B:25:0x005e, B:26:0x0066, B:12:0x0036), top: B:48:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.ast.ArrayComprehensionLoop arrayComprehensionLoop() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.nextToken()
            r1 = 119(0x77, float:1.67E-43)
            if (r0 == r1) goto Lb
            r11.codeBug()
        Lb:
            org.mozilla.javascript.TokenStream r0 = r11.f10728ts
            int r0 = r0.tokenBeg
            org.mozilla.javascript.ast.ArrayComprehensionLoop r1 = new org.mozilla.javascript.ast.ArrayComprehensionLoop
            r1.<init>(r0)
            r11.pushScope(r1)
            r2 = 39
            boolean r3 = r11.matchToken(r2)     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r4 = "msg.no.paren.for"
            r5 = -1
            if (r3 == 0) goto L39
            org.mozilla.javascript.TokenStream r3 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r3 = r3.getString()     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r6 = "each"
            boolean r3 = r3.equals(r6)     // Catch: java.lang.Throwable -> Lc7
            if (r3 == 0) goto L36
            org.mozilla.javascript.TokenStream r3 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            int r3 = r3.tokenBeg     // Catch: java.lang.Throwable -> Lc7
            int r3 = r3 - r0
            goto L3a
        L36:
            r11.reportError(r4)     // Catch: java.lang.Throwable -> Lc7
        L39:
            r3 = -1
        L3a:
            r6 = 87
            boolean r4 = r11.mustMatchToken(r6, r4)     // Catch: java.lang.Throwable -> Lc7
            if (r4 == 0) goto L48
            org.mozilla.javascript.TokenStream r4 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            int r4 = r4.tokenBeg     // Catch: java.lang.Throwable -> Lc7
            int r4 = r4 - r0
            goto L49
        L48:
            r4 = -1
        L49:
            r6 = 0
            int r7 = r11.peekToken()     // Catch: java.lang.Throwable -> Lc7
            if (r7 == r2) goto L66
            r8 = 83
            if (r7 == r8) goto L5e
            r8 = 85
            if (r7 == r8) goto L5e
            java.lang.String r7 = "msg.bad.var"
            r11.reportError(r7)     // Catch: java.lang.Throwable -> Lc7
            goto L6d
        L5e:
            org.mozilla.javascript.ast.AstNode r6 = r11.destructuringPrimaryExpr()     // Catch: java.lang.Throwable -> Lc7
            r11.markDestructuring(r6)     // Catch: java.lang.Throwable -> Lc7
            goto L6d
        L66:
            r11.consumeToken()     // Catch: java.lang.Throwable -> Lc7
            org.mozilla.javascript.ast.Name r6 = r11.createNameNode()     // Catch: java.lang.Throwable -> Lc7
        L6d:
            int r7 = r6.getType()     // Catch: java.lang.Throwable -> Lc7
            r8 = 1
            if (r7 != r2) goto L7f
            r2 = 153(0x99, float:2.14E-43)
            org.mozilla.javascript.TokenStream r7 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            java.lang.String r7 = r7.getString()     // Catch: java.lang.Throwable -> Lc7
            r11.defineSymbol(r2, r7, r8)     // Catch: java.lang.Throwable -> Lc7
        L7f:
            r2 = 52
            java.lang.String r7 = "msg.in.after.for.name"
            boolean r2 = r11.mustMatchToken(r2, r7)     // Catch: java.lang.Throwable -> Lc7
            if (r2 == 0) goto L8f
            org.mozilla.javascript.TokenStream r2 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            int r2 = r2.tokenBeg     // Catch: java.lang.Throwable -> Lc7
            int r2 = r2 - r0
            goto L90
        L8f:
            r2 = -1
        L90:
            org.mozilla.javascript.ast.AstNode r7 = r11.expr()     // Catch: java.lang.Throwable -> Lc7
            r9 = 88
            java.lang.String r10 = "msg.no.paren.for.ctrl"
            boolean r9 = r11.mustMatchToken(r9, r10)     // Catch: java.lang.Throwable -> Lc7
            if (r9 == 0) goto La4
            org.mozilla.javascript.TokenStream r9 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            int r9 = r9.tokenBeg     // Catch: java.lang.Throwable -> Lc7
            int r9 = r9 - r0
            goto La5
        La4:
            r9 = -1
        La5:
            org.mozilla.javascript.TokenStream r10 = r11.f10728ts     // Catch: java.lang.Throwable -> Lc7
            int r10 = r10.tokenEnd     // Catch: java.lang.Throwable -> Lc7
            int r10 = r10 - r0
            r1.setLength(r10)     // Catch: java.lang.Throwable -> Lc7
            r1.setIterator(r6)     // Catch: java.lang.Throwable -> Lc7
            r1.setIteratedObject(r7)     // Catch: java.lang.Throwable -> Lc7
            r1.setInPosition(r2)     // Catch: java.lang.Throwable -> Lc7
            r1.setEachPosition(r3)     // Catch: java.lang.Throwable -> Lc7
            if (r3 == r5) goto Lbc
            goto Lbd
        Lbc:
            r8 = 0
        Lbd:
            r1.setIsForEach(r8)     // Catch: java.lang.Throwable -> Lc7
            r1.setParens(r4, r9)     // Catch: java.lang.Throwable -> Lc7
            r11.popScope()
            return r1
        Lc7:
            r0 = move-exception
            r11.popScope()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.arrayComprehensionLoop():org.mozilla.javascript.ast.ArrayComprehensionLoop");
    }

    private AstNode generatorExpression(AstNode astNode, int i) throws IOException {
        return generatorExpression(astNode, i, false);
    }

    private AstNode generatorExpression(AstNode astNode, int i, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (peekToken() == 119) {
            arrayList.add(generatorExpressionLoop());
        }
        int i2 = -1;
        ConditionData conditionData = null;
        if (peekToken() == 112) {
            consumeToken();
            i2 = this.f10728ts.tokenBeg - i;
            conditionData = condition();
        }
        if (!z) {
            mustMatchToken(88, "msg.no.paren.let");
        }
        GeneratorExpression generatorExpression = new GeneratorExpression(i, this.f10728ts.tokenEnd - i);
        generatorExpression.setResult(astNode);
        generatorExpression.setLoops(arrayList);
        if (conditionData != null) {
            generatorExpression.setIfPosition(i2);
            generatorExpression.setFilter(conditionData.condition);
            generatorExpression.setFilterLp(conditionData.f10729lp - i);
            generatorExpression.setFilterRp(conditionData.f10730rp - i);
        }
        return generatorExpression;
    }

    private GeneratorExpressionLoop generatorExpressionLoop() throws IOException {
        if (nextToken() != 119) {
            codeBug();
        }
        int i = this.f10728ts.tokenBeg;
        GeneratorExpressionLoop generatorExpressionLoop = new GeneratorExpressionLoop(i);
        pushScope(generatorExpressionLoop);
        try {
            int i2 = mustMatchToken(87, "msg.no.paren.for") ? this.f10728ts.tokenBeg - i : -1;
            AstNode astNode = null;
            int peekToken = peekToken();
            if (peekToken == 39) {
                consumeToken();
                astNode = createNameNode();
            } else if (peekToken == 83 || peekToken == 85) {
                astNode = destructuringPrimaryExpr();
                markDestructuring(astNode);
            } else {
                reportError("msg.bad.var");
            }
            if (astNode.getType() == 39) {
                defineSymbol(153, this.f10728ts.getString(), true);
            }
            int i3 = mustMatchToken(52, "msg.in.after.for.name") ? this.f10728ts.tokenBeg - i : -1;
            AstNode expr = expr();
            int i4 = mustMatchToken(88, "msg.no.paren.for.ctrl") ? this.f10728ts.tokenBeg - i : -1;
            generatorExpressionLoop.setLength(this.f10728ts.tokenEnd - i);
            generatorExpressionLoop.setIterator(astNode);
            generatorExpressionLoop.setIteratedObject(expr);
            generatorExpressionLoop.setInPosition(i3);
            generatorExpressionLoop.setParens(i2, i4);
            return generatorExpressionLoop;
        } finally {
            popScope();
        }
    }

    private ObjectLiteral objectLiteral() throws IOException {
        HashSet hashSet;
        HashSet hashSet2;
        String string;
        char c;
        int i = this.f10728ts.tokenBeg;
        int i2 = this.f10728ts.lineno;
        ArrayList arrayList = new ArrayList();
        if (this.inUseStrictDirective) {
            hashSet = new HashSet();
            hashSet2 = new HashSet();
        } else {
            hashSet = null;
            hashSet2 = null;
        }
        Comment andResetJsDoc = getAndResetJsDoc();
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int peekToken = peekToken();
            Comment andResetJsDoc2 = getAndResetJsDoc();
            if (peekToken == 39) {
                Name createNameNode = createNameNode();
                string = this.f10728ts.getString();
                int i5 = this.f10728ts.tokenBeg;
                consumeToken();
                int peekToken2 = peekToken();
                if (("get".equals(string) || "set".equals(string)) && peekToken2 != 89 && peekToken2 != 103 && peekToken2 != 86) {
                    boolean equals = "get".equals(string);
                    c = equals ? (char) 2 : (char) 4;
                    AstNode objliteralProperty = objliteralProperty();
                    if (objliteralProperty != null) {
                        string = this.f10728ts.getString();
                        ObjectProperty objectProperty = getterSetterProperty(i5, objliteralProperty, equals);
                        objliteralProperty.setJsDocNode(andResetJsDoc2);
                        arrayList.add(objectProperty);
                    }
                    string = null;
                } else {
                    createNameNode.setJsDocNode(andResetJsDoc2);
                    arrayList.add(plainProperty(createNameNode, peekToken));
                    c = 1;
                }
            } else if (peekToken != 86) {
                AstNode objliteralProperty2 = objliteralProperty();
                if (objliteralProperty2 == null) {
                    c = 1;
                    string = null;
                } else {
                    string = this.f10728ts.getString();
                    objliteralProperty2.setJsDocNode(andResetJsDoc2);
                    arrayList.add(plainProperty(objliteralProperty2, peekToken));
                    c = 1;
                }
            } else if (i4 != i3) {
                warnTrailingComma(i, arrayList, i4);
            }
            if (this.inUseStrictDirective && string != null) {
                if (c == 1) {
                    if (hashSet.contains(string) || hashSet2.contains(string)) {
                        addError("msg.dup.obj.lit.prop.strict", string);
                    }
                    hashSet.add(string);
                    hashSet2.add(string);
                } else if (c == 2) {
                    if (hashSet.contains(string)) {
                        addError("msg.dup.obj.lit.prop.strict", string);
                    }
                    hashSet.add(string);
                } else if (c == 4) {
                    if (hashSet2.contains(string)) {
                        addError("msg.dup.obj.lit.prop.strict", string);
                    }
                    hashSet2.add(string);
                }
            }
            getAndResetJsDoc();
            if (!matchToken(89)) {
                break;
            }
            i4 = this.f10728ts.tokenEnd;
            i3 = -1;
        }
        mustMatchToken(86, "msg.no.brace.prop");
        ObjectLiteral objectLiteral = new ObjectLiteral(i, this.f10728ts.tokenEnd - i);
        if (andResetJsDoc != null) {
            objectLiteral.setJsDocNode(andResetJsDoc);
        }
        objectLiteral.setElements(arrayList);
        objectLiteral.setLineno(i2);
        return objectLiteral;
    }

    private AstNode objliteralProperty() throws IOException {
        AstNode createNameNode;
        switch (peekToken()) {
            case 39:
                createNameNode = createNameNode();
                break;
            case 40:
                createNameNode = new NumberLiteral(this.f10728ts.tokenBeg, this.f10728ts.getString(), this.f10728ts.getNumber());
                break;
            case 41:
                createNameNode = createStringLiteral();
                break;
            default:
                if (this.compilerEnv.isReservedKeywordAsIdentifier() && TokenStream.isKeyword(this.f10728ts.getString())) {
                    createNameNode = createNameNode();
                    break;
                } else {
                    reportError("msg.bad.prop");
                    return null;
                }
        }
        consumeToken();
        return createNameNode;
    }

    private ObjectProperty plainProperty(AstNode astNode, int i) throws IOException {
        int peekToken = peekToken();
        if ((peekToken == 89 || peekToken == 86) && i == 39 && this.compilerEnv.getLanguageVersion() >= 180) {
            if (!this.inDestructuringAssignment) {
                reportError("msg.bad.object.init");
            }
            Name name = new Name(astNode.getPosition(), astNode.getString());
            ObjectProperty objectProperty = new ObjectProperty();
            objectProperty.putProp(26, Boolean.TRUE);
            objectProperty.setLeftAndRight(astNode, name);
            return objectProperty;
        }
        mustMatchToken(103, "msg.no.colon.prop");
        ObjectProperty objectProperty2 = new ObjectProperty();
        objectProperty2.setOperatorPosition(this.f10728ts.tokenBeg);
        objectProperty2.setLeftAndRight(astNode, assignExpr());
        return objectProperty2;
    }

    private ObjectProperty getterSetterProperty(int i, AstNode astNode, boolean z) throws IOException {
        FunctionNode function = function(2);
        Name functionName = function.getFunctionName();
        if (functionName != null && functionName.length() != 0) {
            reportError("msg.bad.prop");
        }
        ObjectProperty objectProperty = new ObjectProperty(i);
        if (z) {
            objectProperty.setIsGetter();
        } else {
            objectProperty.setIsSetter();
        }
        int nodeEnd = getNodeEnd(function);
        objectProperty.setLeft(astNode);
        objectProperty.setRight(function);
        objectProperty.setLength(nodeEnd - i);
        return objectProperty;
    }

    private Name createNameNode() {
        return createNameNode(false, 39);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.ast.Name createNameNode(boolean r6, int r7) {
        /*
            r5 = this;
            org.mozilla.javascript.TokenStream r0 = r5.f10728ts
            int r0 = r0.tokenBeg
            org.mozilla.javascript.TokenStream r1 = r5.f10728ts
            java.lang.String r1 = r1.getString()
            org.mozilla.javascript.TokenStream r2 = r5.f10728ts
            int r2 = r2.lineno
            java.lang.String r3 = r5.prevNameTokenString
            java.lang.String r4 = ""
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L25
            int r0 = r5.prevNameTokenStart
            java.lang.String r1 = r5.prevNameTokenString
            int r2 = r5.prevNameTokenLineno
            r3 = 0
            r5.prevNameTokenStart = r3
            r5.prevNameTokenString = r4
            r5.prevNameTokenLineno = r3
        L25:
            if (r1 != 0) goto L33
            org.mozilla.javascript.CompilerEnvirons r3 = r5.compilerEnv
            boolean r3 = r3.isIdeMode()
            if (r3 == 0) goto L30
            goto L34
        L30:
            r5.codeBug()
        L33:
            r4 = r1
        L34:
            org.mozilla.javascript.ast.Name r1 = new org.mozilla.javascript.ast.Name
            r1.<init>(r0, r4)
            r1.setLineno(r2)
            if (r6 == 0) goto L41
            r5.checkActivationName(r4, r7)
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Parser.createNameNode(boolean, int):org.mozilla.javascript.ast.Name");
    }

    private StringLiteral createStringLiteral() {
        int i = this.f10728ts.tokenBeg;
        StringLiteral stringLiteral = new StringLiteral(i, this.f10728ts.tokenEnd - i);
        stringLiteral.setLineno(this.f10728ts.lineno);
        stringLiteral.setValue(this.f10728ts.getString());
        stringLiteral.setQuoteCharacter(this.f10728ts.getQuoteChar());
        return stringLiteral;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkActivationName(String str, int i) {
        if (insideFunction()) {
            boolean z = false;
            if ("arguments".equals(str) || ((this.compilerEnv.getActivationNames() != null && this.compilerEnv.getActivationNames().contains(str)) || (SessionDescription.ATTR_LENGTH.equals(str) && i == 33 && this.compilerEnv.getLanguageVersion() == 120))) {
                z = true;
            }
            if (z) {
                setRequiresActivation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRequiresActivation() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setRequiresActivation();
        }
    }

    private void checkCallRequiresActivation(AstNode astNode) {
        if ((astNode.getType() == 39 && "eval".equals(((Name) astNode).getIdentifier())) || (astNode.getType() == 33 && "eval".equals(((PropertyGet) astNode).getProperty().getIdentifier()))) {
            setRequiresActivation();
        }
    }

    protected void setIsGenerator() {
        if (insideFunction()) {
            ((FunctionNode) this.currentScriptOrFn).setIsGenerator();
        }
    }

    private void checkBadIncDec(UnaryExpression unaryExpression) {
        int type = removeParens(unaryExpression.getOperand()).getType();
        if (type == 39 || type == 33 || type == 36 || type == 67 || type == 38) {
            return;
        }
        reportError(unaryExpression.getType() == 106 ? "msg.bad.incr" : "msg.bad.decr");
    }

    private ErrorNode makeErrorNode() {
        ErrorNode errorNode = new ErrorNode(this.f10728ts.tokenBeg, this.f10728ts.tokenEnd - this.f10728ts.tokenBeg);
        errorNode.setLineno(this.f10728ts.lineno);
        return errorNode;
    }

    private int nodeEnd(AstNode astNode) {
        return astNode.getPosition() + astNode.getLength();
    }

    private void saveNameTokenData(int i, String str, int i2) {
        this.prevNameTokenStart = i;
        this.prevNameTokenString = str;
        this.prevNameTokenLineno = i2;
    }

    private int lineBeginningFor(int i) {
        char c;
        char[] cArr = this.sourceChars;
        if (cArr == null) {
            return -1;
        }
        if (i <= 0) {
            return 0;
        }
        if (i >= cArr.length) {
            i = cArr.length - 1;
        }
        do {
            i--;
            if (i < 0) {
                return 0;
            }
            c = cArr[i];
            if (c == '\n') {
                break;
            }
        } while (c != '\r');
        return i + 1;
    }

    private void warnMissingSemi(int i, int i2) {
        if (this.compilerEnv.isStrictMode()) {
            int max = Math.max(i, lineBeginningFor(i2));
            if (i2 == -1) {
                i2 = this.f10728ts.cursor;
            }
            addStrictWarning("msg.missing.semi", "", max, i2 - max);
        }
    }

    private void warnTrailingComma(int i, List<?> list, int i2) {
        if (this.compilerEnv.getWarnTrailingComma()) {
            if (!list.isEmpty()) {
                i = ((AstNode) list.get(0)).getPosition();
            }
            int max = Math.max(i, lineBeginningFor(i2));
            addWarning("msg.extra.trailing.comma", max, i2 - max);
        }
    }

    private String readFully(Reader reader) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            char[] cArr = new char[1024];
            StringBuilder sb = new StringBuilder(1024);
            while (true) {
                int read = bufferedReader.read(cArr, 0, 1024);
                if (read != -1) {
                    sb.append(cArr, 0, read);
                } else {
                    return sb.toString();
                }
            }
        } finally {
            bufferedReader.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public class PerFunctionVariables {
        private Scope savedCurrentScope;
        private ScriptNode savedCurrentScriptOrFn;
        private int savedEndFlags;
        private boolean savedInForInit;
        private Map<String, LabeledStatement> savedLabelSet;
        private List<Jump> savedLoopAndSwitchSet;
        private List<Loop> savedLoopSet;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PerFunctionVariables(FunctionNode functionNode) {
            this.savedCurrentScriptOrFn = Parser.this.currentScriptOrFn;
            Parser.this.currentScriptOrFn = functionNode;
            this.savedCurrentScope = Parser.this.currentScope;
            Parser.this.currentScope = functionNode;
            this.savedLabelSet = Parser.this.labelSet;
            Parser.this.labelSet = null;
            this.savedLoopSet = Parser.this.loopSet;
            Parser.this.loopSet = null;
            this.savedLoopAndSwitchSet = Parser.this.loopAndSwitchSet;
            Parser.this.loopAndSwitchSet = null;
            this.savedEndFlags = Parser.this.endFlags;
            Parser.this.endFlags = 0;
            this.savedInForInit = Parser.this.inForInit;
            Parser.this.inForInit = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void restore() {
            Parser.this.currentScriptOrFn = this.savedCurrentScriptOrFn;
            Parser.this.currentScope = this.savedCurrentScope;
            Parser.this.labelSet = this.savedLabelSet;
            Parser.this.loopSet = this.savedLoopSet;
            Parser.this.loopAndSwitchSet = this.savedLoopAndSwitchSet;
            Parser.this.endFlags = this.savedEndFlags;
            Parser.this.inForInit = this.savedInForInit;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node createDestructuringAssignment(int i, Node node, Node node2) {
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        Node destructuringAssignmentHelper = destructuringAssignmentHelper(i, node, node2, nextTempName);
        destructuringAssignmentHelper.getLastChild().addChildToBack(createName(nextTempName));
        return destructuringAssignmentHelper;
    }

    Node destructuringAssignmentHelper(int i, Node node, Node node2, String str) {
        Scope createScopeNode = createScopeNode(158, node.getLineno());
        createScopeNode.addChildToFront(new Node(153, createName(39, str, node2)));
        try {
            pushScope(createScopeNode);
            boolean z = true;
            defineSymbol(153, str, true);
            popScope();
            Node node3 = new Node(89);
            createScopeNode.addChildToBack(node3);
            List<String> arrayList = new ArrayList<>();
            int type = node.getType();
            if (type == 33 || type == 36) {
                if (i == 122 || i == 153 || i == 154) {
                    reportError("msg.bad.assign.left");
                }
                node3.addChildToBack(simpleAssignment(node, createName(str)));
            } else if (type == 65) {
                z = destructuringArray((ArrayLiteral) node, i, str, node3, arrayList);
            } else if (type == 66) {
                z = destructuringObject((ObjectLiteral) node, i, str, node3, arrayList);
            } else {
                reportError("msg.bad.assign.left");
            }
            if (z) {
                node3.addChildToBack(createNumber(0.0d));
            }
            createScopeNode.putProp(22, arrayList);
            return createScopeNode;
        } catch (Throwable th) {
            popScope();
            throw th;
        }
    }

    boolean destructuringArray(ArrayLiteral arrayLiteral, int i, String str, Node node, List<String> list) {
        int i2 = i == 154 ? 155 : 8;
        boolean z = true;
        int i3 = 0;
        for (AstNode astNode : arrayLiteral.getElements()) {
            if (astNode.getType() == 128) {
                i3++;
            } else {
                Node node2 = new Node(36, createName(str), createNumber(i3));
                if (astNode.getType() == 39) {
                    String string = astNode.getString();
                    node.addChildToBack(new Node(i2, createName(49, string, null), node2));
                    if (i != -1) {
                        defineSymbol(i, string, true);
                        list.add(string);
                    }
                } else {
                    node.addChildToBack(destructuringAssignmentHelper(i, astNode, node2, this.currentScriptOrFn.getNextTempName()));
                }
                i3++;
                z = false;
            }
        }
        return z;
    }

    boolean destructuringObject(ObjectLiteral objectLiteral, int i, String str, Node node, List<String> list) {
        Node node2;
        int i2 = i == 154 ? 155 : 8;
        boolean z = true;
        for (ObjectProperty objectProperty : objectLiteral.getElements()) {
            TokenStream tokenStream = this.f10728ts;
            int i3 = tokenStream != null ? tokenStream.lineno : 0;
            AstNode left = objectProperty.getLeft();
            if (left instanceof Name) {
                node2 = new Node(33, createName(str), Node.newString(((Name) left).getIdentifier()));
            } else if (left instanceof StringLiteral) {
                node2 = new Node(33, createName(str), Node.newString(((StringLiteral) left).getValue()));
            } else if (left instanceof NumberLiteral) {
                node2 = new Node(36, createName(str), createNumber((int) ((NumberLiteral) left).getNumber()));
            } else {
                throw codeBug();
            }
            node2.setLineno(i3);
            AstNode right = objectProperty.getRight();
            if (right.getType() == 39) {
                String identifier = ((Name) right).getIdentifier();
                node.addChildToBack(new Node(i2, createName(49, identifier, null), node2));
                if (i != -1) {
                    defineSymbol(i, identifier, true);
                    list.add(identifier);
                }
            } else {
                node.addChildToBack(destructuringAssignmentHelper(i, right, node2, this.currentScriptOrFn.getNextTempName()));
            }
            z = false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Node createName(String str) {
        checkActivationName(str, 39);
        return Node.newString(39, str);
    }

    protected Node createName(int i, String str, Node node) {
        Node createName = createName(str);
        createName.setType(i);
        if (node != null) {
            createName.addChildToBack(node);
        }
        return createName;
    }

    protected Node createNumber(double d) {
        return Node.newNumber(d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Scope createScopeNode(int i, int i2) {
        Scope scope = new Scope();
        scope.setType(i);
        scope.setLineno(i2);
        return scope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Node simpleAssignment(Node node, Node node2) {
        Node firstChild;
        Node lastChild;
        int i;
        int type = node.getType();
        if (type != 33 && type != 36) {
            if (type != 39) {
                if (type == 67) {
                    Node firstChild2 = node.getFirstChild();
                    checkMutableReference(firstChild2);
                    return new Node(68, firstChild2, node2);
                }
                throw codeBug();
            }
            if (this.inUseStrictDirective) {
                Name name = (Name) node;
                if ("eval".equals(name.getIdentifier())) {
                    reportError("msg.bad.id.strict", name.getIdentifier());
                }
            }
            node.setType(49);
            return new Node(8, node, node2);
        }
        if (node instanceof PropertyGet) {
            PropertyGet propertyGet = (PropertyGet) node;
            firstChild = propertyGet.getTarget();
            lastChild = propertyGet.getProperty();
        } else if (node instanceof ElementGet) {
            ElementGet elementGet = (ElementGet) node;
            firstChild = elementGet.getTarget();
            lastChild = elementGet.getElement();
        } else {
            firstChild = node.getFirstChild();
            lastChild = node.getLastChild();
        }
        if (type == 33) {
            i = 35;
            lastChild.setType(41);
        } else {
            i = 37;
        }
        return new Node(i, firstChild, lastChild, node2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkMutableReference(Node node) {
        if ((node.getIntProp(16, 0) & 4) != 0) {
            reportError("msg.bad.assign.left");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AstNode removeParens(AstNode astNode) {
        while (astNode instanceof ParenthesizedExpression) {
            astNode = ((ParenthesizedExpression) astNode).getExpression();
        }
        return astNode;
    }

    void markDestructuring(AstNode astNode) {
        if (astNode instanceof DestructuringForm) {
            ((DestructuringForm) astNode).setIsDestructuring(true);
        } else if (astNode instanceof ParenthesizedExpression) {
            markDestructuring(((ParenthesizedExpression) astNode).getExpression());
        }
    }

    private RuntimeException codeBug() throws RuntimeException {
        throw Kit.codeBug("ts.cursor=" + this.f10728ts.cursor + ", ts.tokenBeg=" + this.f10728ts.tokenBeg + ", currentToken=" + this.currentToken);
    }
}
