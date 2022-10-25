package org.mozilla.javascript.ast;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class LabeledStatement extends AstNode {
    private List<Label> labels;
    private AstNode statement;

    public LabeledStatement() {
        this.labels = new ArrayList();
        this.type = 133;
    }

    public LabeledStatement(int i) {
        super(i);
        this.labels = new ArrayList();
        this.type = 133;
    }

    public LabeledStatement(int i, int i2) {
        super(i, i2);
        this.labels = new ArrayList();
        this.type = 133;
    }

    public List<Label> getLabels() {
        return this.labels;
    }

    public void setLabels(List<Label> list) {
        assertNotNull(list);
        List<Label> list2 = this.labels;
        if (list2 != null) {
            list2.clear();
        }
        for (Label label : list) {
            addLabel(label);
        }
    }

    public void addLabel(Label label) {
        assertNotNull(label);
        this.labels.add(label);
        label.setParent(this);
    }

    public AstNode getStatement() {
        return this.statement;
    }

    public Label getLabelByName(String str) {
        for (Label label : this.labels) {
            if (str.equals(label.getName())) {
                return label;
            }
        }
        return null;
    }

    public void setStatement(AstNode astNode) {
        assertNotNull(astNode);
        this.statement = astNode;
        astNode.setParent(this);
    }

    public Label getFirstLabel() {
        return this.labels.get(0);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        for (Label label : this.labels) {
            sb.append(label.toSource(i));
        }
        sb.append(this.statement.toSource(i + 1));
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            for (Label label : this.labels) {
                label.visit(nodeVisitor);
            }
            this.statement.visit(nodeVisitor);
        }
    }
}
