package org.mozilla.javascript.ast;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Node;
import org.mozilla.javascript.Token;

/* loaded from: classes5.dex */
public abstract class AstNode extends Node implements Comparable<AstNode> {
    private static Map<Integer, String> operatorNames;
    protected int length;
    protected AstNode parent;
    protected int position;

    public abstract String toSource(int i);

    public abstract void visit(NodeVisitor nodeVisitor);

    static {
        HashMap hashMap = new HashMap();
        operatorNames = hashMap;
        hashMap.put(52, "in");
        operatorNames.put(32, "typeof");
        operatorNames.put(53, "instanceof");
        operatorNames.put(31, "delete");
        operatorNames.put(89, ",");
        operatorNames.put(103, ":");
        operatorNames.put(104, "||");
        operatorNames.put(105, "&&");
        operatorNames.put(106, "++");
        operatorNames.put(107, "--");
        operatorNames.put(9, "|");
        operatorNames.put(10, "^");
        operatorNames.put(11, "&");
        operatorNames.put(12, "==");
        operatorNames.put(13, "!=");
        operatorNames.put(14, "<");
        operatorNames.put(16, ">");
        operatorNames.put(15, "<=");
        operatorNames.put(17, ">=");
        operatorNames.put(18, "<<");
        operatorNames.put(19, ">>");
        operatorNames.put(20, ">>>");
        operatorNames.put(21, "+");
        operatorNames.put(22, "-");
        operatorNames.put(23, "*");
        operatorNames.put(24, "/");
        operatorNames.put(25, "%");
        operatorNames.put(26, "!");
        operatorNames.put(27, "~");
        operatorNames.put(28, "+");
        operatorNames.put(29, "-");
        operatorNames.put(46, "===");
        operatorNames.put(47, "!==");
        operatorNames.put(90, "=");
        operatorNames.put(91, "|=");
        operatorNames.put(93, "&=");
        operatorNames.put(94, "<<=");
        operatorNames.put(95, ">>=");
        operatorNames.put(96, ">>>=");
        operatorNames.put(97, "+=");
        operatorNames.put(98, "-=");
        operatorNames.put(99, "*=");
        operatorNames.put(100, "/=");
        operatorNames.put(101, "%=");
        operatorNames.put(92, "^=");
        operatorNames.put(126, "void");
    }

    /* loaded from: classes5.dex */
    public static class PositionComparator implements Comparator<AstNode>, Serializable {
        private static final long serialVersionUID = 1;

        @Override // java.util.Comparator
        public int compare(AstNode astNode, AstNode astNode2) {
            return astNode.position - astNode2.position;
        }
    }

    public AstNode() {
        super(-1);
        this.position = -1;
        this.length = 1;
    }

    public AstNode(int i) {
        this();
        this.position = i;
    }

    public AstNode(int i, int i2) {
        this();
        this.position = i;
        this.length = i2;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getAbsolutePosition() {
        int i = this.position;
        for (AstNode astNode = this.parent; astNode != null; astNode = astNode.getParent()) {
            i += astNode.getPosition();
        }
        return i;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int i) {
        this.length = i;
    }

    public void setBounds(int i, int i2) {
        setPosition(i);
        setLength(i2 - i);
    }

    public void setRelative(int i) {
        this.position -= i;
    }

    public AstNode getParent() {
        return this.parent;
    }

    public void setParent(AstNode astNode) {
        AstNode astNode2 = this.parent;
        if (astNode == astNode2) {
            return;
        }
        if (astNode2 != null) {
            setRelative(-astNode2.getPosition());
        }
        this.parent = astNode;
        if (astNode != null) {
            setRelative(astNode.getPosition());
        }
    }

    public void addChild(AstNode astNode) {
        assertNotNull(astNode);
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        addChildToBack(astNode);
        astNode.setParent(this);
    }

    public AstRoot getAstRoot() {
        AstNode astNode = this;
        while (astNode != null && !(astNode instanceof AstRoot)) {
            astNode = astNode.getParent();
        }
        return (AstRoot) astNode;
    }

    public String toSource() {
        return toSource(0);
    }

    public String makeIndent(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public String shortName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public static String operatorToString(int i) {
        String str = operatorNames.get(Integer.valueOf(i));
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Invalid operator: " + i);
    }

    @Override // org.mozilla.javascript.Node
    public boolean hasSideEffects() {
        int type = getType();
        if (type == 30 || type == 31 || type == 37 || type == 38 || type == 50 || type == 51 || type == 56 || type == 57 || type == 81 || type == 82 || type == 106 || type == 107) {
            return true;
        }
        switch (type) {
            case -1:
            case 35:
            case 64:
            case 72:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 129:
            case 130:
            case 131:
            case 132:
            case 134:
            case 135:
            case 139:
            case 140:
            case 141:
            case 142:
            case 153:
            case 154:
            case 158:
            case 159:
                return true;
            default:
                switch (type) {
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return true;
                    default:
                        switch (type) {
                            case 68:
                            case 69:
                            case 70:
                                return true;
                            default:
                                switch (type) {
                                    case 109:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void assertNotNull(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("arg cannot be null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T extends AstNode> void printList(List<T> list, StringBuilder sb) {
        int size = list.size();
        int i = 0;
        for (T t : list) {
            sb.append(t.toSource(0));
            int i2 = i + 1;
            if (i < size - 1) {
                sb.append(", ");
            } else if (t instanceof EmptyExpression) {
                sb.append(",");
            }
            i = i2;
        }
    }

    public static RuntimeException codeBug() throws RuntimeException {
        throw Kit.codeBug();
    }

    public FunctionNode getEnclosingFunction() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof FunctionNode)) {
            parent = parent.getParent();
        }
        return (FunctionNode) parent;
    }

    public Scope getEnclosingScope() {
        AstNode parent = getParent();
        while (parent != null && !(parent instanceof Scope)) {
            parent = parent.getParent();
        }
        return (Scope) parent;
    }

    @Override // java.lang.Comparable
    public int compareTo(AstNode astNode) {
        if (equals(astNode)) {
            return 0;
        }
        int absolutePosition = getAbsolutePosition();
        int absolutePosition2 = astNode.getAbsolutePosition();
        if (absolutePosition < absolutePosition2) {
            return -1;
        }
        if (absolutePosition2 < absolutePosition) {
            return 1;
        }
        int length = getLength();
        int length2 = astNode.getLength();
        if (length < length2) {
            return -1;
        }
        if (length2 < length) {
            return 1;
        }
        return hashCode() - astNode.hashCode();
    }

    public int depth() {
        AstNode astNode = this.parent;
        if (astNode == null) {
            return 0;
        }
        return astNode.depth() + 1;
    }

    /* loaded from: classes5.dex */
    protected static class DebugPrintVisitor implements NodeVisitor {
        private static final int DEBUG_INDENT = 2;
        private StringBuilder buffer;

        public DebugPrintVisitor(StringBuilder sb) {
            this.buffer = sb;
        }

        public String toString() {
            return this.buffer.toString();
        }

        private String makeIndent(int i) {
            int i2 = i * 2;
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        @Override // org.mozilla.javascript.ast.NodeVisitor
        public boolean visit(AstNode astNode) {
            int type = astNode.getType();
            String typeToName = Token.typeToName(type);
            StringBuilder sb = this.buffer;
            sb.append(astNode.getAbsolutePosition());
            sb.append("\t");
            this.buffer.append(makeIndent(astNode.depth()));
            StringBuilder sb2 = this.buffer;
            sb2.append(typeToName);
            sb2.append(" ");
            StringBuilder sb3 = this.buffer;
            sb3.append(astNode.getPosition());
            sb3.append(" ");
            this.buffer.append(astNode.getLength());
            if (type == 39) {
                StringBuilder sb4 = this.buffer;
                sb4.append(" ");
                sb4.append(((Name) astNode).getIdentifier());
            }
            this.buffer.append("\n");
            return true;
        }
    }

    @Override // org.mozilla.javascript.Node
    public int getLineno() {
        if (this.lineno != -1) {
            return this.lineno;
        }
        AstNode astNode = this.parent;
        if (astNode != null) {
            return astNode.getLineno();
        }
        return -1;
    }

    public String debugPrint() {
        DebugPrintVisitor debugPrintVisitor = new DebugPrintVisitor(new StringBuilder(1000));
        visit(debugPrintVisitor);
        return debugPrintVisitor.toString();
    }
}
