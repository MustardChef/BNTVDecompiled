package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class EmptyExpression extends AstNode {
    public EmptyExpression() {
        this.type = 128;
    }

    public EmptyExpression(int i) {
        super(i);
        this.type = 128;
    }

    public EmptyExpression(int i, int i2) {
        super(i, i2);
        this.type = 128;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
