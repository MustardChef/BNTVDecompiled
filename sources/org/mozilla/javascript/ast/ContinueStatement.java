package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class ContinueStatement extends Jump {
    private Name label;
    private Loop target;

    public ContinueStatement() {
        this.type = 121;
    }

    public ContinueStatement(int i) {
        this(i, -1);
    }

    public ContinueStatement(int i, int i2) {
        this.type = 121;
        this.position = i;
        this.length = i2;
    }

    public ContinueStatement(Name name) {
        this.type = 121;
        setLabel(name);
    }

    public ContinueStatement(int i, Name name) {
        this(i);
        setLabel(name);
    }

    public ContinueStatement(int i, int i2, Name name) {
        this(i, i2);
        setLabel(name);
    }

    public Loop getTarget() {
        return this.target;
    }

    public void setTarget(Loop loop) {
        assertNotNull(loop);
        this.target = loop;
        setJumpStatement(loop);
    }

    public Name getLabel() {
        return this.label;
    }

    public void setLabel(Name name) {
        this.label = name;
        if (name != null) {
            name.setParent(this);
        }
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append("continue");
        if (this.label != null) {
            sb.append(" ");
            sb.append(this.label.toSource(0));
        }
        sb.append(";\n");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        Name name;
        if (!nodeVisitor.visit(this) || (name = this.label) == null) {
            return;
        }
        name.visit(nodeVisitor);
    }
}
