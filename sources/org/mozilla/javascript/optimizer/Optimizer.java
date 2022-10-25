package org.mozilla.javascript.optimizer;

import org.mozilla.javascript.Node;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ast.ScriptNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class Optimizer {
    static final int AnyType = 3;
    static final int NoType = 0;
    static final int NumberType = 1;
    private boolean inDirectCallFunction;
    private boolean parameterUsedInNumberContext;
    OptFunctionNode theFunction;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void optimize(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            optimizeFunction(OptFunctionNode.get(scriptNode, i));
        }
    }

    private void optimizeFunction(OptFunctionNode optFunctionNode) {
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.inDirectCallFunction = optFunctionNode.isTargetOfDirectCall();
        this.theFunction = optFunctionNode;
        ObjArray objArray = new ObjArray();
        buildStatementList_r(optFunctionNode.fnode, objArray);
        int size = objArray.size();
        Node[] nodeArr = new Node[size];
        objArray.toArray(nodeArr);
        Block.runFlowAnalyzes(optFunctionNode, nodeArr);
        if (optFunctionNode.fnode.requiresActivation()) {
            return;
        }
        this.parameterUsedInNumberContext = false;
        for (int i = 0; i < size; i++) {
            rewriteForNumberVariables(nodeArr[i], 1);
        }
        optFunctionNode.setParameterNumberContext(this.parameterUsedInNumberContext);
    }

    private void markDCPNumberContext(Node node) {
        if (this.inDirectCallFunction && node.getType() == 55) {
            if (this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
                this.parameterUsedInNumberContext = true;
            }
        }
    }

    private boolean convertParameter(Node node) {
        if (this.inDirectCallFunction && node.getType() == 55) {
            if (this.theFunction.isParameter(this.theFunction.getVarIndex(node))) {
                node.removeProp(8);
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int rewriteForNumberVariables(Node node, int i) {
        int type = node.getType();
        if (type == 40) {
            node.putIntProp(8, 0);
            return 1;
        } else if (type == 133) {
            if (rewriteForNumberVariables(node.getFirstChild(), 1) == 1) {
                node.putIntProp(8, 0);
            }
            return 0;
        } else {
            if (type != 140) {
                if (type == 55) {
                    int varIndex = this.theFunction.getVarIndex(node);
                    if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex) && i == 1) {
                        node.putIntProp(8, 0);
                        return 1;
                    } else if (this.theFunction.isNumberVar(varIndex)) {
                        node.putIntProp(8, 0);
                        return 1;
                    } else {
                        return 0;
                    }
                } else if (type == 56) {
                    Node next = node.getFirstChild().getNext();
                    int rewriteForNumberVariables = rewriteForNumberVariables(next, 1);
                    int varIndex2 = this.theFunction.getVarIndex(node);
                    if (this.inDirectCallFunction && this.theFunction.isParameter(varIndex2)) {
                        if (rewriteForNumberVariables == 1) {
                            if (!convertParameter(next)) {
                                node.putIntProp(8, 0);
                                return 1;
                            }
                            markDCPNumberContext(next);
                            return 0;
                        }
                        return rewriteForNumberVariables;
                    } else if (this.theFunction.isNumberVar(varIndex2)) {
                        if (rewriteForNumberVariables != 1) {
                            node.removeChild(next);
                            node.addChildToBack(new Node(150, next));
                        }
                        node.putIntProp(8, 0);
                        markDCPNumberContext(next);
                        return 1;
                    } else {
                        if (rewriteForNumberVariables == 1 && !convertParameter(next)) {
                            node.removeChild(next);
                            node.addChildToBack(new Node(149, next));
                        }
                        return 0;
                    }
                } else if (type == 106 || type == 107) {
                    Node firstChild = node.getFirstChild();
                    if (firstChild.getType() == 55) {
                        if (rewriteForNumberVariables(firstChild, 1) != 1 || convertParameter(firstChild)) {
                            return 0;
                        }
                        node.putIntProp(8, 0);
                        markDCPNumberContext(firstChild);
                        return 1;
                    } else if (firstChild.getType() == 36 || firstChild.getType() == 33) {
                        return rewriteForNumberVariables(firstChild, 1);
                    } else {
                        return 0;
                    }
                } else {
                    switch (type) {
                        case 9:
                        case 10:
                        case 11:
                            break;
                        default:
                            switch (type) {
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    Node firstChild2 = node.getFirstChild();
                                    Node next2 = firstChild2.getNext();
                                    int rewriteForNumberVariables2 = rewriteForNumberVariables(firstChild2, 1);
                                    int rewriteForNumberVariables3 = rewriteForNumberVariables(next2, 1);
                                    markDCPNumberContext(firstChild2);
                                    markDCPNumberContext(next2);
                                    if (convertParameter(firstChild2)) {
                                        if (!convertParameter(next2) && rewriteForNumberVariables3 == 1) {
                                            node.putIntProp(8, 2);
                                        }
                                    } else if (convertParameter(next2)) {
                                        if (rewriteForNumberVariables2 == 1) {
                                            node.putIntProp(8, 1);
                                        }
                                    } else if (rewriteForNumberVariables2 == 1) {
                                        if (rewriteForNumberVariables3 == 1) {
                                            node.putIntProp(8, 0);
                                        } else {
                                            node.putIntProp(8, 1);
                                        }
                                    } else if (rewriteForNumberVariables3 == 1) {
                                        node.putIntProp(8, 2);
                                    }
                                    return 0;
                                case 18:
                                case 19:
                                    break;
                                default:
                                    switch (type) {
                                        case 21:
                                            Node firstChild3 = node.getFirstChild();
                                            Node next3 = firstChild3.getNext();
                                            int rewriteForNumberVariables4 = rewriteForNumberVariables(firstChild3, 1);
                                            int rewriteForNumberVariables5 = rewriteForNumberVariables(next3, 1);
                                            if (convertParameter(firstChild3)) {
                                                if (!convertParameter(next3) && rewriteForNumberVariables5 == 1) {
                                                    node.putIntProp(8, 2);
                                                }
                                            } else if (convertParameter(next3)) {
                                                if (rewriteForNumberVariables4 == 1) {
                                                    node.putIntProp(8, 1);
                                                }
                                            } else if (rewriteForNumberVariables4 == 1) {
                                                if (rewriteForNumberVariables5 == 1) {
                                                    node.putIntProp(8, 0);
                                                    return 1;
                                                }
                                                node.putIntProp(8, 1);
                                            } else if (rewriteForNumberVariables5 == 1) {
                                                node.putIntProp(8, 2);
                                            }
                                            return 0;
                                        case 22:
                                        case 23:
                                        case 24:
                                        case 25:
                                            break;
                                        default:
                                            switch (type) {
                                                case 36:
                                                    Node firstChild4 = node.getFirstChild();
                                                    Node next4 = firstChild4.getNext();
                                                    if (rewriteForNumberVariables(firstChild4, 1) == 1 && !convertParameter(firstChild4)) {
                                                        node.removeChild(firstChild4);
                                                        node.addChildToFront(new Node(149, firstChild4));
                                                    }
                                                    if (rewriteForNumberVariables(next4, 1) == 1 && !convertParameter(next4)) {
                                                        node.putIntProp(8, 2);
                                                    }
                                                    return 0;
                                                case 37:
                                                    break;
                                                case 38:
                                                    Node firstChild5 = node.getFirstChild();
                                                    rewriteAsObjectChildren(firstChild5, firstChild5.getFirstChild());
                                                    Node next5 = firstChild5.getNext();
                                                    if (((OptFunctionNode) node.getProp(9)) != null) {
                                                        while (next5 != null) {
                                                            if (rewriteForNumberVariables(next5, 1) == 1) {
                                                                markDCPNumberContext(next5);
                                                            }
                                                            next5 = next5.getNext();
                                                        }
                                                    } else {
                                                        rewriteAsObjectChildren(node, next5);
                                                    }
                                                    return 0;
                                                default:
                                                    rewriteAsObjectChildren(node, node.getFirstChild());
                                                    return 0;
                                            }
                                    }
                            }
                    }
                    Node firstChild6 = node.getFirstChild();
                    Node next6 = firstChild6.getNext();
                    int rewriteForNumberVariables6 = rewriteForNumberVariables(firstChild6, 1);
                    int rewriteForNumberVariables7 = rewriteForNumberVariables(next6, 1);
                    markDCPNumberContext(firstChild6);
                    markDCPNumberContext(next6);
                    if (rewriteForNumberVariables6 == 1) {
                        if (rewriteForNumberVariables7 == 1) {
                            node.putIntProp(8, 0);
                            return 1;
                        }
                        if (!convertParameter(next6)) {
                            node.removeChild(next6);
                            node.addChildToBack(new Node(150, next6));
                            node.putIntProp(8, 0);
                        }
                        return 1;
                    } else if (rewriteForNumberVariables7 == 1) {
                        if (!convertParameter(firstChild6)) {
                            node.removeChild(firstChild6);
                            node.addChildToFront(new Node(150, firstChild6));
                            node.putIntProp(8, 0);
                        }
                        return 1;
                    } else {
                        if (!convertParameter(firstChild6)) {
                            node.removeChild(firstChild6);
                            node.addChildToFront(new Node(150, firstChild6));
                        }
                        if (!convertParameter(next6)) {
                            node.removeChild(next6);
                            node.addChildToBack(new Node(150, next6));
                        }
                        node.putIntProp(8, 0);
                        return 1;
                    }
                }
            }
            Node firstChild7 = node.getFirstChild();
            Node next7 = firstChild7.getNext();
            Node next8 = next7.getNext();
            if (rewriteForNumberVariables(firstChild7, 1) == 1 && !convertParameter(firstChild7)) {
                node.removeChild(firstChild7);
                node.addChildToFront(new Node(149, firstChild7));
            }
            if (rewriteForNumberVariables(next7, 1) == 1 && !convertParameter(next7)) {
                node.putIntProp(8, 1);
            }
            if (rewriteForNumberVariables(next8, 1) == 1 && !convertParameter(next8)) {
                node.removeChild(next8);
                node.addChildToBack(new Node(149, next8));
            }
            return 0;
        }
    }

    private void rewriteAsObjectChildren(Node node, Node node2) {
        while (node2 != null) {
            Node next = node2.getNext();
            if (rewriteForNumberVariables(node2, 0) == 1 && !convertParameter(node2)) {
                node.removeChild(node2);
                Node node3 = new Node(149, node2);
                if (next == null) {
                    node.addChildToBack(node3);
                } else {
                    node.addChildBefore(node3, next);
                }
            }
            node2 = next;
        }
    }

    private static void buildStatementList_r(Node node, ObjArray objArray) {
        int type = node.getType();
        if (type == 129 || type == 141 || type == 132 || type == 109) {
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
                buildStatementList_r(firstChild, objArray);
            }
            return;
        }
        objArray.add(node);
    }
}
