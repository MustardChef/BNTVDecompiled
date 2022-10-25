package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class XmlDotQuery extends InfixExpression {

    /* renamed from: rp */
    private int f10770rp;

    public XmlDotQuery() {
        this.f10770rp = -1;
        this.type = 146;
    }

    public XmlDotQuery(int i) {
        super(i);
        this.f10770rp = -1;
        this.type = 146;
    }

    public XmlDotQuery(int i, int i2) {
        super(i, i2);
        this.f10770rp = -1;
        this.type = 146;
    }

    public int getRp() {
        return this.f10770rp;
    }

    public void setRp(int i) {
        this.f10770rp = i;
    }

    @Override // org.mozilla.javascript.ast.InfixExpression, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + getLeft().toSource(0) + ".(" + getRight().toSource(0) + ")";
    }
}
