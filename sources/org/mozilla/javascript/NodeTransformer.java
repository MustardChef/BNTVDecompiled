package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
public class NodeTransformer {
    private boolean hasFinally;
    private ObjArray loopEnds;
    private ObjArray loops;

    /* JADX INFO: Access modifiers changed from: protected */
    public void visitCall(Node node, ScriptNode scriptNode) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void visitNew(Node node, ScriptNode scriptNode) {
    }

    public final void transform(ScriptNode scriptNode) {
        transformCompilationUnit(scriptNode);
        for (int i = 0; i != scriptNode.getFunctionCount(); i++) {
            transform(scriptNode.getFunctionNode(i));
        }
    }

    private void transformCompilationUnit(ScriptNode scriptNode) {
        this.loops = new ObjArray();
        this.loopEnds = new ObjArray();
        this.hasFinally = false;
        boolean z = scriptNode.getType() != 109 || ((FunctionNode) scriptNode).requiresActivation();
        scriptNode.flattenSymbolTable(!z);
        transformCompilationUnit_r(scriptNode, scriptNode, scriptNode, z, (scriptNode instanceof AstRoot) && ((AstRoot) scriptNode).isInStrictMode());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:210:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0170  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r13v7, types: [org.mozilla.javascript.ast.Scope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void transformCompilationUnit_r(org.mozilla.javascript.ast.ScriptNode r19, org.mozilla.javascript.Node r20, org.mozilla.javascript.ast.Scope r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NodeTransformer.transformCompilationUnit_r(org.mozilla.javascript.ast.ScriptNode, org.mozilla.javascript.Node, org.mozilla.javascript.ast.Scope, boolean, boolean):void");
    }

    protected Node visitLet(boolean z, Node node, Node node2, Node node3) {
        Node replaceCurrent;
        Node node4;
        Node node5;
        Node node6;
        Node node7;
        Node firstChild = node3.getFirstChild();
        Node next = firstChild.getNext();
        node3.removeChild(firstChild);
        node3.removeChild(next);
        int i = 158;
        boolean z2 = node3.getType() == 158;
        int i2 = 153;
        int i3 = 89;
        if (z) {
            replaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 159 : 129));
            ArrayList arrayList = new ArrayList();
            Node node8 = new Node(66);
            Node firstChild2 = firstChild.getFirstChild();
            while (firstChild2 != null) {
                if (firstChild2.getType() == i) {
                    List list = (List) firstChild2.getProp(22);
                    Node firstChild3 = firstChild2.getFirstChild();
                    if (firstChild3.getType() != i2) {
                        throw Kit.codeBug();
                    }
                    if (z2) {
                        node6 = new Node(i3, firstChild3.getNext(), next);
                    } else {
                        node6 = new Node(129, new Node(133, firstChild3.getNext()), next);
                    }
                    if (list != null) {
                        arrayList.addAll(list);
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            node8.addChildToBack(new Node(126, Node.newNumber(0.0d)));
                        }
                    }
                    node7 = firstChild3.getFirstChild();
                } else {
                    node6 = next;
                    node7 = firstChild2;
                }
                if (node7.getType() != 39) {
                    throw Kit.codeBug();
                }
                arrayList.add(ScriptRuntime.getIndexObject(node7.getString()));
                Node firstChild4 = node7.getFirstChild();
                if (firstChild4 == null) {
                    firstChild4 = new Node(126, Node.newNumber(0.0d));
                }
                node8.addChildToBack(firstChild4);
                firstChild2 = firstChild2.getNext();
                next = node6;
                i = 158;
                i2 = 153;
                i3 = 89;
            }
            node8.putProp(12, arrayList.toArray());
            replaceCurrent.addChildToBack(new Node(2, node8));
            replaceCurrent.addChildToBack(new Node(123, next));
            replaceCurrent.addChildToBack(new Node(3));
        } else {
            replaceCurrent = replaceCurrent(node, node2, node3, new Node(z2 ? 89 : 129));
            Node node9 = new Node(89);
            Node firstChild5 = firstChild.getFirstChild();
            while (firstChild5 != null) {
                if (firstChild5.getType() == 158) {
                    Node firstChild6 = firstChild5.getFirstChild();
                    if (firstChild6.getType() != 153) {
                        throw Kit.codeBug();
                    }
                    if (z2) {
                        node4 = new Node(89, firstChild6.getNext(), next);
                    } else {
                        node4 = new Node(129, new Node(133, firstChild6.getNext()), next);
                    }
                    Scope.joinScopes((Scope) firstChild5, (Scope) node3);
                    node5 = firstChild6.getFirstChild();
                } else {
                    node4 = next;
                    node5 = firstChild5;
                }
                if (node5.getType() != 39) {
                    throw Kit.codeBug();
                }
                Node newString = Node.newString(node5.getString());
                newString.setScope((Scope) node3);
                Node firstChild7 = node5.getFirstChild();
                if (firstChild7 == null) {
                    firstChild7 = new Node(126, Node.newNumber(0.0d));
                }
                node9.addChildToBack(new Node(56, newString, firstChild7));
                firstChild5 = firstChild5.getNext();
                next = node4;
            }
            if (z2) {
                replaceCurrent.addChildToBack(node9);
                node3.setType(89);
                replaceCurrent.addChildToBack(node3);
                node3.addChildToBack(next);
                if (next instanceof Scope) {
                    Scope scope = (Scope) next;
                    Scope parentScope = scope.getParentScope();
                    Scope scope2 = (Scope) node3;
                    scope.setParentScope(scope2);
                    scope2.setParentScope(parentScope);
                }
            } else {
                replaceCurrent.addChildToBack(new Node(133, node9));
                node3.setType(129);
                replaceCurrent.addChildToBack(node3);
                node3.addChildrenToBack(next);
                if (next instanceof Scope) {
                    Scope scope3 = (Scope) next;
                    Scope parentScope2 = scope3.getParentScope();
                    Scope scope4 = (Scope) node3;
                    scope3.setParentScope(scope4);
                    scope4.setParentScope(parentScope2);
                }
            }
        }
        return replaceCurrent;
    }

    private static Node addBeforeCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.addChildToFront(node4);
        } else {
            if (node3 != node2.getNext()) {
                Kit.codeBug();
            }
            node.addChildAfter(node4, node2);
        }
        return node4;
    }

    private static Node replaceCurrent(Node node, Node node2, Node node3, Node node4) {
        if (node2 == null) {
            if (node3 != node.getFirstChild()) {
                Kit.codeBug();
            }
            node.replaceChild(node3, node4);
        } else if (node2.next == node3) {
            node.replaceChildAfter(node2, node4);
        } else {
            node.replaceChild(node3, node4);
        }
        return node4;
    }
}
