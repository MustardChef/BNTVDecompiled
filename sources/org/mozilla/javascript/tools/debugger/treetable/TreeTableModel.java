package org.mozilla.javascript.tools.debugger.treetable;

import javax.swing.tree.TreeModel;

/* loaded from: classes5.dex */
public interface TreeTableModel extends TreeModel {
    Class<?> getColumnClass(int i);

    int getColumnCount();

    String getColumnName(int i);

    Object getValueAt(Object obj, int i);

    boolean isCellEditable(Object obj, int i);

    void setValueAt(Object obj, Object obj2, int i);
}
