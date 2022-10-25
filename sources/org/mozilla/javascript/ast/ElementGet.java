package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ElementGet extends AstNode {
    private AstNode element;

    /* renamed from: lb */
    private int f10752lb;

    /* renamed from: rb */
    private int f10753rb;
    private AstNode target;

    public ElementGet() {
        this.f10752lb = -1;
        this.f10753rb = -1;
        this.type = 36;
    }

    public ElementGet(int i) {
        super(i);
        this.f10752lb = -1;
        this.f10753rb = -1;
        this.type = 36;
    }

    public ElementGet(int i, int i2) {
        super(i, i2);
        this.f10752lb = -1;
        this.f10753rb = -1;
        this.type = 36;
    }

    public ElementGet(AstNode astNode, AstNode astNode2) {
        this.f10752lb = -1;
        this.f10753rb = -1;
        this.type = 36;
        setTarget(astNode);
        setElement(astNode2);
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    public AstNode getElement() {
        return this.element;
    }

    public void setElement(AstNode astNode) {
        assertNotNull(astNode);
        this.element = astNode;
        astNode.setParent(this);
    }

    public int getLb() {
        return this.f10752lb;
    }

    public void setLb(int i) {
        this.f10752lb = i;
    }

    public int getRb() {
        return this.f10753rb;
    }

    public void setRb(int i) {
        this.f10753rb = i;
    }

    public void setParens(int i, int i2) {
        this.f10752lb = i;
        this.f10753rb = i2;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.target.toSource(0) + "[" + this.element.toSource(0) + "]";
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            this.element.visit(nodeVisitor);
        }
    }
}
