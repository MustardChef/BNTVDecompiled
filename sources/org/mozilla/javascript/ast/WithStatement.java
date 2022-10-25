package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class WithStatement extends AstNode {
    private AstNode expression;

    /* renamed from: lp */
    private int f10768lp;

    /* renamed from: rp */
    private int f10769rp;
    private AstNode statement;

    public WithStatement() {
        this.f10768lp = -1;
        this.f10769rp = -1;
        this.type = 123;
    }

    public WithStatement(int i) {
        super(i);
        this.f10768lp = -1;
        this.f10769rp = -1;
        this.type = 123;
    }

    public WithStatement(int i, int i2) {
        super(i, i2);
        this.f10768lp = -1;
        this.f10769rp = -1;
        this.type = 123;
    }

    public AstNode getExpression() {
        return this.expression;
    }

    public void setExpression(AstNode astNode) {
        assertNotNull(astNode);
        this.expression = astNode;
        astNode.setParent(this);
    }

    public AstNode getStatement() {
        return this.statement;
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    public int getLp() {
        return this.f10768lp;
    }

    public void setLp(int i) {
        this.f10768lp = i;
    }

    public int getRp() {
        return this.f10769rp;
    }

    public void setRp(int i) {
        this.f10769rp = i;
    }

    public void setParens(int i, int i2) {
        this.f10768lp = i;
        this.f10769rp = i2;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("with (");
        sb.append(this.expression.toSource(0));
        sb.append(") ");
        sb.append(this.statement.toSource(i + 1));
        if (!(this.statement instanceof Block)) {
            sb.append(";\n");
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.expression.visit(nodeVisitor);
            this.statement.visit(nodeVisitor);
        }
    }
}
