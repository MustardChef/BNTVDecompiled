package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ArrayComprehension extends Scope {
    private AstNode filter;
    private int ifPosition;
    private List<ArrayComprehensionLoop> loops;

    /* renamed from: lp */
    private int f10748lp;
    private AstNode result;

    /* renamed from: rp */
    private int f10749rp;

    public ArrayComprehension() {
        this.loops = new ArrayList();
        this.ifPosition = -1;
        this.f10748lp = -1;
        this.f10749rp = -1;
        this.type = 157;
    }

    public ArrayComprehension(int i) {
        super(i);
        this.loops = new ArrayList();
        this.ifPosition = -1;
        this.f10748lp = -1;
        this.f10749rp = -1;
        this.type = 157;
    }

    public ArrayComprehension(int i, int i2) {
        super(i, i2);
        this.loops = new ArrayList();
        this.ifPosition = -1;
        this.f10748lp = -1;
        this.f10749rp = -1;
        this.type = 157;
    }

    public AstNode getResult() {
        return this.result;
    }

    public void setResult(AstNode astNode) {
        assertNotNull(astNode);
        this.result = astNode;
        astNode.setParent(this);
    }

    public List<ArrayComprehensionLoop> getLoops() {
        return this.loops;
    }

    public void setLoops(List<ArrayComprehensionLoop> list) {
        assertNotNull(list);
        this.loops.clear();
        for (ArrayComprehensionLoop arrayComprehensionLoop : list) {
            addLoop(arrayComprehensionLoop);
        }
    }

    public void addLoop(ArrayComprehensionLoop arrayComprehensionLoop) {
        assertNotNull(arrayComprehensionLoop);
        this.loops.add(arrayComprehensionLoop);
        arrayComprehensionLoop.setParent(this);
    }

    public AstNode getFilter() {
        return this.filter;
    }

    public void setFilter(AstNode astNode) {
        this.filter = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public int getIfPosition() {
        return this.ifPosition;
    }

    public void setIfPosition(int i) {
        this.ifPosition = i;
    }

    public int getFilterLp() {
        return this.f10748lp;
    }

    public void setFilterLp(int i) {
        this.f10748lp = i;
    }

    public int getFilterRp() {
        return this.f10749rp;
    }

    public void setFilterRp(int i) {
        this.f10749rp = i;
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder(250);
        sb.append("[");
        sb.append(this.result.toSource(0));
        for (ArrayComprehensionLoop arrayComprehensionLoop : this.loops) {
            sb.append(arrayComprehensionLoop.toSource(0));
        }
        if (this.filter != null) {
            sb.append(" if (");
            sb.append(this.filter.toSource(0));
            sb.append(")");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.Scope, org.mozilla.javascript.ast.Jump, org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.result.visit(nodeVisitor);
            for (ArrayComprehensionLoop arrayComprehensionLoop : this.loops) {
                arrayComprehensionLoop.visit(nodeVisitor);
            }
            AstNode astNode = this.filter;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
