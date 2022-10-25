package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class EmptyStatement extends AstNode {
    public EmptyStatement() {
        this.type = 128;
    }

    public EmptyStatement(int i) {
        super(i);
        this.type = 128;
    }

    public EmptyStatement(int i, int i2) {
        super(i, i2);
        this.type = 128;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + ";\n";
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
