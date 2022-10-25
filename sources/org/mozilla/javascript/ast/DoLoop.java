package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class DoLoop extends Loop {
    private AstNode condition;
    private int whilePosition;

    public DoLoop() {
        this.whilePosition = -1;
        this.type = 118;
    }

    public DoLoop(int i) {
        super(i);
        this.whilePosition = -1;
        this.type = 118;
    }

    public DoLoop(int i, int i2) {
        super(i, i2);
        this.whilePosition = -1;
        this.type = 118;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public int getWhilePosition() {
        return this.whilePosition;
    }

    public void setWhilePosition(int i) {
        this.whilePosition = i;
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + "do " + this.body.toSource(i).trim() + " while (" + this.condition.toSource(0) + ");\n";
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.body.visit(nodeVisitor);
            this.condition.visit(nodeVisitor);
        }
    }
}
