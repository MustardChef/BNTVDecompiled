package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public abstract class Loop extends Scope {
    protected AstNode body;

    /* renamed from: lp */
    protected int f10764lp;

    /* renamed from: rp */
    protected int f10765rp;

    public Loop() {
        this.f10764lp = -1;
        this.f10765rp = -1;
    }

    public Loop(int i) {
        super(i);
        this.f10764lp = -1;
        this.f10765rp = -1;
    }

    public Loop(int i, int i2) {
        super(i, i2);
        this.f10764lp = -1;
        this.f10765rp = -1;
    }

    public AstNode getBody() {
        return this.body;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        astNode.setParent(this);
    }

    public int getLp() {
        return this.f10764lp;
    }

    public void setLp(int i) {
        this.f10764lp = i;
    }

    public int getRp() {
        return this.f10765rp;
    }

    public void setRp(int i) {
        this.f10765rp = i;
    }

    public void setParens(int i, int i2) {
        this.f10764lp = i;
        this.f10765rp = i2;
    }
}
