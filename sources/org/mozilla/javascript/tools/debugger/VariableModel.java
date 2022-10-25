package org.mozilla.javascript.tools.debugger;

import java.util.Arrays;
import java.util.Comparator;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import org.mozilla.javascript.tools.debugger.treetable.TreeTableModel;

/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
class VariableModel implements TreeTableModel {
    private Dim debugger;
    private VariableNode root;
    private static final String[] cNames = {" Name", " Value"};
    private static final Class<?>[] cTypes = {TreeTableModel.class, String.class};
    private static final VariableNode[] CHILDLESS = new VariableNode[0];

    public void addTreeModelListener(TreeModelListener treeModelListener) {
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public boolean isCellEditable(Object obj, int i) {
        return i == 0;
    }

    public void removeTreeModelListener(TreeModelListener treeModelListener) {
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public void setValueAt(Object obj, Object obj2, int i) {
    }

    public void valueForPathChanged(TreePath treePath, Object obj) {
    }

    public VariableModel() {
    }

    public VariableModel(Dim dim, Object obj) {
        this.debugger = dim;
        this.root = new VariableNode(obj, "this");
    }

    public Object getRoot() {
        if (this.debugger == null) {
            return null;
        }
        return this.root;
    }

    public int getChildCount(Object obj) {
        if (this.debugger == null) {
            return 0;
        }
        return children((VariableNode) obj).length;
    }

    public Object getChild(Object obj, int i) {
        if (this.debugger == null) {
            return null;
        }
        return children((VariableNode) obj)[i];
    }

    public boolean isLeaf(Object obj) {
        return this.debugger == null || children((VariableNode) obj).length == 0;
    }

    public int getIndexOfChild(Object obj, Object obj2) {
        if (this.debugger == null) {
            return -1;
        }
        VariableNode variableNode = (VariableNode) obj2;
        VariableNode[] children = children((VariableNode) obj);
        for (int i = 0; i != children.length; i++) {
            if (children[i] == variableNode) {
                return i;
            }
        }
        return -1;
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public int getColumnCount() {
        return cNames.length;
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public String getColumnName(int i) {
        return cNames[i];
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public Class<?> getColumnClass(int i) {
        return cTypes[i];
    }

    @Override // org.mozilla.javascript.tools.debugger.treetable.TreeTableModel
    public Object getValueAt(Object obj, int i) {
        String message;
        Dim dim = this.debugger;
        if (dim == null) {
            return null;
        }
        VariableNode variableNode = (VariableNode) obj;
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            try {
                message = dim.objectToString(getValue(variableNode));
            } catch (RuntimeException e) {
                message = e.getMessage();
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = message.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = message.charAt(i2);
                if (Character.isISOControl(charAt)) {
                    charAt = ' ';
                }
                stringBuffer.append(charAt);
            }
            return stringBuffer.toString();
        }
        return variableNode.toString();
    }

    private VariableNode[] children(VariableNode variableNode) {
        VariableNode[] variableNodeArr;
        if (variableNode.children == null) {
            Object value = getValue(variableNode);
            Object[] objectIds = this.debugger.getObjectIds(value);
            if (objectIds == null || objectIds.length == 0) {
                variableNodeArr = CHILDLESS;
            } else {
                Arrays.sort(objectIds, new Comparator<Object>() { // from class: org.mozilla.javascript.tools.debugger.VariableModel.1
                    @Override // java.util.Comparator
                    public int compare(Object obj, Object obj2) {
                        if (obj instanceof String) {
                            if (obj2 instanceof Integer) {
                                return -1;
                            }
                            return ((String) obj).compareToIgnoreCase((String) obj2);
                        } else if (obj2 instanceof String) {
                            return 1;
                        } else {
                            return ((Integer) obj).intValue() - ((Integer) obj2).intValue();
                        }
                    }
                });
                variableNodeArr = new VariableNode[objectIds.length];
                for (int i = 0; i != objectIds.length; i++) {
                    variableNodeArr[i] = new VariableNode(value, objectIds[i]);
                }
            }
            variableNode.children = variableNodeArr;
            return variableNodeArr;
        }
        return variableNode.children;
    }

    public Object getValue(VariableNode variableNode) {
        try {
            return this.debugger.getObjectProperty(variableNode.object, variableNode.f10788id);
        } catch (Exception unused) {
            return "undefined";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SwingGui.java */
    /* loaded from: classes5.dex */
    public static class VariableNode {
        private VariableNode[] children;

        /* renamed from: id */
        private Object f10788id;
        private Object object;

        public VariableNode(Object obj, Object obj2) {
            this.object = obj;
            this.f10788id = obj2;
        }

        public String toString() {
            Object obj = this.f10788id;
            if (obj instanceof String) {
                return (String) obj;
            }
            return "[" + ((Integer) this.f10788id).intValue() + "]";
        }
    }
}
