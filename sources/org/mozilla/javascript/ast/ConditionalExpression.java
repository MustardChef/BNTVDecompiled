package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ConditionalExpression extends AstNode {
    private int colonPosition;
    private AstNode falseExpression;
    private int questionMarkPosition;
    private AstNode testExpression;
    private AstNode trueExpression;

    public ConditionalExpression() {
        this.questionMarkPosition = -1;
        this.colonPosition = -1;
        this.type = 102;
    }

    public ConditionalExpression(int i) {
        super(i);
        this.questionMarkPosition = -1;
        this.colonPosition = -1;
        this.type = 102;
    }

    public ConditionalExpression(int i, int i2) {
        super(i, i2);
        this.questionMarkPosition = -1;
        this.colonPosition = -1;
        this.type = 102;
    }

    public AstNode getTestExpression() {
        return this.testExpression;
    }

    public void setTestExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.testExpression = astNode;
        astNode.setParent(this);
    }

    public AstNode getTrueExpression() {
        return this.trueExpression;
    }

    public void setTrueExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.trueExpression = astNode;
        astNode.setParent(this);
    }

    public AstNode getFalseExpression() {
        return this.falseExpression;
    }

    public void setFalseExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.falseExpression = astNode;
        astNode.setParent(this);
    }

    public int getQuestionMarkPosition() {
        return this.questionMarkPosition;
    }

    public void setQuestionMarkPosition(int i) {
        this.questionMarkPosition = i;
    }

    public int getColonPosition() {
        return this.colonPosition;
    }

    public void setColonPosition(int i) {
        this.colonPosition = i;
    }

    @Override // org.mozilla.javascript.ast.AstNode, org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        if (this.testExpression == null || this.trueExpression == null || this.falseExpression == null) {
            codeBug();
        }
        return this.trueExpression.hasSideEffects() && this.falseExpression.hasSideEffects();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.testExpression.toSource(i) + " ? " + this.trueExpression.toSource(0) + " : " + this.falseExpression.toSource(0);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.testExpression.visit(nodeVisitor);
            this.trueExpression.visit(nodeVisitor);
            this.falseExpression.visit(nodeVisitor);
        }
    }
}
