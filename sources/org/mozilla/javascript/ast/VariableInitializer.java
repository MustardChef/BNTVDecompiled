package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class VariableInitializer extends AstNode {
    private AstNode initializer;
    private AstNode target;

    public void setNodeType(int i) {
        if (i != 122 && i != 154 && i != 153) {
            throw new IllegalArgumentException("invalid node type");
        }
        setType(i);
    }

    public VariableInitializer() {
        this.type = 122;
    }

    public VariableInitializer(int i) {
        super(i);
        this.type = 122;
    }

    public VariableInitializer(int i, int i2) {
        super(i, i2);
        this.type = 122;
    }

    public boolean isDestructuring() {
        return !(this.target instanceof Name);
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setTarget(AstNode astNode) {
        if (astNode == null) {
            throw new IllegalArgumentException("invalid target arg");
        }
        this.target = astNode;
        astNode.setParent(this);
    }

    public AstNode getInitializer() {
        return this.initializer;
    }

    public void setInitializer(AstNode astNode) {
        this.initializer = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(this.target.toSource(0));
        if (this.initializer != null) {
            sb.append(" = ");
            sb.append(this.initializer.toSource(0));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            AstNode astNode = this.initializer;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
