package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class NewExpression extends FunctionCall {
    private ObjectLiteral initializer;

    public NewExpression() {
        this.type = 30;
    }

    public NewExpression(int i) {
        super(i);
        this.type = 30;
    }

    public NewExpression(int i, int i2) {
        super(i, i2);
        this.type = 30;
    }

    public ObjectLiteral getInitializer() {
        return this.initializer;
    }

    public void setInitializer(ObjectLiteral objectLiteral) {
        this.initializer = objectLiteral;
        if (objectLiteral != null) {
            objectLiteral.setParent(this);
        }
    }

    @Override // org.mozilla.javascript.ast.FunctionCall, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("new ");
        sb.append(this.target.toSource(0));
        sb.append("(");
        if (this.arguments != null) {
            printList(this.arguments, sb);
        }
        sb.append(")");
        if (this.initializer != null) {
            sb.append(" ");
            sb.append(this.initializer.toSource(0));
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.FunctionCall, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            for (AstNode astNode : getArguments()) {
                astNode.visit(nodeVisitor);
            }
            ObjectLiteral objectLiteral = this.initializer;
            if (objectLiteral != null) {
                objectLiteral.visit(nodeVisitor);
            }
        }
    }
}
