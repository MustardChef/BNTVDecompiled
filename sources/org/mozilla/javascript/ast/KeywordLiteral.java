package org.mozilla.javascript.ast;

import com.facebook.internal.ServerProtocol;

/* loaded from: classes5.dex */
public class KeywordLiteral extends AstNode {
    public KeywordLiteral() {
    }

    public KeywordLiteral(int i) {
        super(i);
    }

    public KeywordLiteral(int i, int i2) {
        super(i, i2);
    }

    public KeywordLiteral(int i, int i2, int i3) {
        super(i, i2);
        setType(i3);
    }

    @Override // org.mozilla.javascript.Node
    public KeywordLiteral setType(int i) {
        if (i != 43 && i != 42 && i != 45 && i != 44 && i != 160) {
            throw new IllegalArgumentException("Invalid node type: " + i);
        }
        this.type = i;
        return this;
    }

    public boolean isBooleanLiteral() {
        return this.type == 45 || this.type == 44;
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public String toSource(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent(i));
        int type = getType();
        if (type != 160) {
            switch (type) {
                case 42:
                    sb.append("null");
                    break;
                case 43:
                    sb.append("this");
                    break;
                case 44:
                    sb.append("false");
                    break;
                case 45:
                    sb.append(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    break;
                default:
                    throw new IllegalStateException("Invalid keyword literal type: " + getType());
            }
        } else {
            sb.append("debugger;\n");
        }
        return sb.toString();
    }

    @Override // org.mozilla.javascript.ast.AstNode
    public void visit(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
