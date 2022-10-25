package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public class FunctionCall extends AstNode {
    protected static final List<AstNode> NO_ARGS = Collections.unmodifiableList(new ArrayList());
    protected List<AstNode> arguments;

    /* renamed from: lp */
    protected int f10754lp;

    /* renamed from: rp */
    protected int f10755rp;
    protected AstNode target;

    public FunctionCall() {
        this.f10754lp = -1;
        this.f10755rp = -1;
        this.type = 38;
    }

    public FunctionCall(int i) {
        super(i);
        this.f10754lp = -1;
        this.f10755rp = -1;
        this.type = 38;
    }

    public FunctionCall(int i, int i2) {
        super(i, i2);
        this.f10754lp = -1;
        this.f10755rp = -1;
        this.type = 38;
    }

    public AstNode getTarget() {
        return this.target;
    }

    public void setTarget(AstNode astNode) {
        assertNotNull(astNode);
        this.target = astNode;
        astNode.setParent(this);
    }

    public List<AstNode> getArguments() {
        List<AstNode> list = this.arguments;
        return list != null ? list : NO_ARGS;
    }

    public void setArguments(List<AstNode> list) {
        if (list == null) {
            this.arguments = null;
            return;
        }
        List<AstNode> list2 = this.arguments;
        if (list2 != null) {
            list2.clear();
        }
        for (AstNode astNode : list) {
            addArgument(astNode);
        }
    }

    public void addArgument(AstNode astNode) {
        assertNotNull(astNode);
        if (this.arguments == null) {
            this.arguments = new ArrayList();
        }
        this.arguments.add(astNode);
        astNode.setParent(this);
    }

    public int getLp() {
        return this.f10754lp;
    }

    public void setLp(int i) {
        this.f10754lp = i;
    }

    public int getRp() {
        return this.f10755rp;
    }

    public void setRp(int i) {
        this.f10755rp = i;
    }

    public void setParens(int i, int i2) {
        this.f10754lp = i;
        this.f10755rp = i2;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        sb.append(this.target.toSource(0));
        sb.append("(");
        List<AstNode> list = this.arguments;
        if (list != null) {
            printList(list, sb);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.target.visit(nodeVisitor);
            for (AstNode astNode : getArguments()) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
