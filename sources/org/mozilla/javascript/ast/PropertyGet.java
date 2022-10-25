package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class PropertyGet extends InfixExpression {
    public PropertyGet() {
        this.type = 33;
    }

    public PropertyGet(int i) {
        super(i);
        this.type = 33;
    }

    public PropertyGet(int i, int i2) {
        super(i, i2);
        this.type = 33;
    }

    public PropertyGet(int i, int i2, AstNode astNode, Name name) {
        super(i, i2, astNode, name);
        this.type = 33;
    }

    public PropertyGet(AstNode astNode, Name name) {
        super(astNode, name);
        this.type = 33;
    }

    public PropertyGet(AstNode astNode, Name name, int i) {
        super(33, astNode, name, i);
        this.type = 33;
    }

    public AstNode getTarget() {
        return getLeft();
    }

    public void setTarget(AstNode astNode) {
        setLeft(astNode);
    }

    public Name getProperty() {
        return (Name) getRight();
    }

    public void setProperty(Name name) {
        setRight(name);
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + "." + getRight().toSource(0);
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            getTarget().visit(nodeVisitor);
            getProperty().visit(nodeVisitor);
        }
    }
}
