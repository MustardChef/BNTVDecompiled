package org.mozilla.javascript.ast;

import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public class Comment extends AstNode {
    private Token.CommentType commentType;
    private String value;

    public Comment(int i, int i2, Token.CommentType commentType, String str) {
        super(i, i2);
        this.type = 161;
        this.commentType = commentType;
        this.value = str;
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    public void setCommentType(Token.CommentType commentType) {
        this.commentType = commentType;
    }

    public String getValue() {
        return this.value;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(getLength() + 10);
        sb.append(makeIndent(i));
        sb.append(this.value);
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
