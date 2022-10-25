package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class GeneratorExpressionLoop extends ForInLoop {
    @Override // org.mozilla.javascript.ast.ForInLoop
    public boolean isForEach() {
        return false;
    }

    public GeneratorExpressionLoop() {
    }

    public GeneratorExpressionLoop(int i) {
        super(i);
    }

    public GeneratorExpressionLoop(int i, int i2) {
        super(i, i2);
    }

    @Override // org.mozilla.javascript.ast.ForInLoop
    public void setIsForEach(boolean z) {
        throw new UnsupportedOperationException("this node type does not support for each");
    }

    @Override // org.mozilla.javascript.ast.ForInLoop, org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(" for ");
        sb.append(isForEach() ? "each " : "");
        sb.append("(");
        sb.append(this.iterator.toSource(0));
        sb.append(" in ");
        sb.append(this.iteratedObject.toSource(0));
        sb.append(")");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.ForInLoop, org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.iterator.visit(nodeVisitor);
            this.iteratedObject.visit(nodeVisitor);
        }
    }
}
