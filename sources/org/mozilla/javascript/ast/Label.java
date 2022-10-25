package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class Label extends Jump {
    private String name;

    public Label() {
        this.type = 130;
    }

    public Label(int i) {
        this(i, -1);
    }

    public Label(int i, int i2) {
        this.type = 130;
        this.position = i;
        this.length = i2;
    }

    public Label(int i, int i2, String str) {
        this(i, i2);
        setName(str);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        String trim = str == null ? null : str.trim();
        if (trim == null || "".equals(trim)) {
            throw new IllegalArgumentException("invalid label name");
        }
        this.name = trim;
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        return makeIndent(i) + this.name + ":\n";
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
