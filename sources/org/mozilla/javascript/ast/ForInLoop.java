package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ForInLoop extends Loop {
    protected int eachPosition;
    protected int inPosition;
    protected boolean isForEach;
    protected AstNode iteratedObject;
    protected AstNode iterator;

    public ForInLoop() {
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 119;
    }

    public ForInLoop(int i) {
        super(i);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 119;
    }

    public ForInLoop(int i, int i2) {
        super(i, i2);
        this.inPosition = -1;
        this.eachPosition = -1;
        this.type = 119;
    }

    public AstNode getIterator() {
        return this.iterator;
    }

    public void setIterator(AstNode astNode) {
        assertNotNull(astNode);
        this.iterator = astNode;
        astNode.setParent(this);
    }

    public AstNode getIteratedObject() {
        return this.iteratedObject;
    }

    public void setIteratedObject(AstNode astNode) {
        assertNotNull(astNode);
        this.iteratedObject = astNode;
        astNode.setParent(this);
    }

    public boolean isForEach() {
        return this.isForEach;
    }

    public void setIsForEach(boolean z) {
        this.isForEach = z;
    }

    public int getInPosition() {
        return this.inPosition;
    }

    public void setInPosition(int i) {
        this.inPosition = i;
    }

    public int getEachPosition() {
        return this.eachPosition;
    }

    public void setEachPosition(int i) {
        this.eachPosition = i;
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("for ");
        if (isForEach()) {
            sb.append("each ");
        }
        sb.append("(");
        sb.append(this.iterator.toSource(0));
        sb.append(" in ");
        sb.append(this.iteratedObject.toSource(0));
        sb.append(") ");
        if (this.body instanceof Block) {
            sb.append(this.body.toSource(i).trim());
            sb.append("\n");
        } else {
            sb.append("\n");
            sb.append(this.body.toSource(i + 1));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.iterator.visit(nodeVisitor);
            this.iteratedObject.visit(nodeVisitor);
            this.body.visit(nodeVisitor);
        }
    }
}
