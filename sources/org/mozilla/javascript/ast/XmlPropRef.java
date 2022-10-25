package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class XmlPropRef extends XmlRef {
    private Name propName;

    public XmlPropRef() {
        this.type = 79;
    }

    public XmlPropRef(int i) {
        super(i);
        this.type = 79;
    }

    public XmlPropRef(int i, int i2) {
        super(i, i2);
        this.type = 79;
    }

    public Name getPropName() {
        return this.propName;
    }

    public void setPropName(Name name) {
        assertNotNull(name);
        this.propName = name;
        name.setParent(this);
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        if (isAttributeAccess()) {
            sb.append("@");
        }
        if (this.namespace != null) {
            sb.append(this.namespace.toSource(0));
            sb.append("::");
        }
        sb.append(this.propName.toSource(0));
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            if (this.namespace != null) {
                this.namespace.visit(nodeVisitor);
            }
            this.propName.visit(nodeVisitor);
        }
    }
}
