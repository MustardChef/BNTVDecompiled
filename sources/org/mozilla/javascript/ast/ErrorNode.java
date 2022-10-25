package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ErrorNode extends AstNode {
    private String message;

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return "";
    }

    public ErrorNode() {
        this.type = -1;
    }

    public ErrorNode(int i) {
        super(i);
        this.type = -1;
    }

    public ErrorNode(int i, int i2) {
        super(i, i2);
        this.type = -1;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
