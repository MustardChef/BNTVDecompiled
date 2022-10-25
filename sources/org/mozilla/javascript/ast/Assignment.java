package org.mozilla.javascript.ast;

/* loaded from: classes5.dex */
public class Assignment extends InfixExpression {
    public Assignment() {
    }

    public Assignment(int i) {
        super(i);
    }

    public Assignment(int i, int i2) {
        super(i, i2);
    }

    public Assignment(int i, int i2, AstNode astNode, AstNode astNode2) {
        super(i, i2, astNode, astNode2);
    }

    public Assignment(AstNode astNode, AstNode astNode2) {
        super(astNode, astNode2);
    }

    public Assignment(int i, AstNode astNode, AstNode astNode2, int i2) {
        super(i, astNode, astNode2, i2);
    }
}
