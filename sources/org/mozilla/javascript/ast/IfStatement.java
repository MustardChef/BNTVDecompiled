package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class IfStatement extends AstNode {
    private AstNode condition;
    private AstNode elsePart;
    private int elsePosition;

    /* renamed from: lp */
    private int f10760lp;

    /* renamed from: rp */
    private int f10761rp;
    private AstNode thenPart;

    public IfStatement() {
        this.elsePosition = -1;
        this.f10760lp = -1;
        this.f10761rp = -1;
        this.type = 112;
    }

    public IfStatement(int i) {
        super(i);
        this.elsePosition = -1;
        this.f10760lp = -1;
        this.f10761rp = -1;
        this.type = 112;
    }

    public IfStatement(int i, int i2) {
        super(i, i2);
        this.elsePosition = -1;
        this.f10760lp = -1;
        this.f10761rp = -1;
        this.type = 112;
    }

    public AstNode getCondition() {
        return this.condition;
    }

    public void setCondition(AstNode astNode) {
        assertNotNull(astNode);
        this.condition = astNode;
        astNode.setParent(this);
    }

    public AstNode getThenPart() {
        return this.thenPart;
    }

    public void setThenPart(AstNode astNode) {
        assertNotNull(astNode);
        this.thenPart = astNode;
        astNode.setParent(this);
    }

    public AstNode getElsePart() {
        return this.elsePart;
    }

    public void setElsePart(AstNode astNode) {
        this.elsePart = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public int getElsePosition() {
        return this.elsePosition;
    }

    public void setElsePosition(int i) {
        this.elsePosition = i;
    }

    public int getLp() {
        return this.f10760lp;
    }

    public void setLp(int i) {
        this.f10760lp = i;
    }

    public int getRp() {
        return this.f10761rp;
    }

    public void setRp(int i) {
        this.f10761rp = i;
    }

    public void setParens(int i, int i2) {
        this.f10760lp = i;
        this.f10761rp = i2;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        String makeIndent = makeIndent(i);
        StringBuilder sb = new StringBuilder(32);
        sb.append(makeIndent);
        sb.append("if (");
        sb.append(this.condition.toSource(0));
        sb.append(") ");
        if (!(this.thenPart instanceof Block)) {
            sb.append("\n");
            sb.append(makeIndent(i));
        }
        sb.append(this.thenPart.toSource(i).trim());
        AstNode astNode = this.elsePart;
        if (astNode instanceof IfStatement) {
            sb.append(" else ");
            sb.append(this.elsePart.toSource(i).trim());
        } else if (astNode != null) {
            sb.append(" else ");
            sb.append(this.elsePart.toSource(i).trim());
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.condition.visit(nodeVisitor);
            this.thenPart.visit(nodeVisitor);
            AstNode astNode = this.elsePart;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
