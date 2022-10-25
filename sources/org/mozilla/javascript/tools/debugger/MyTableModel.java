package org.mozilla.javascript.tools.debugger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
public class MyTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 2971618907207577000L;
    private SwingGui debugGui;
    private List<String> expressions = Collections.synchronizedList(new ArrayList());
    private List<String> values = Collections.synchronizedList(new ArrayList());

    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return "Value";
        }
        return "Expression";
    }

    public boolean isCellEditable(int i, int i2) {
        return true;
    }

    public MyTableModel(SwingGui swingGui) {
        this.debugGui = swingGui;
        this.expressions.add("");
        this.values.add("");
    }

    public int getRowCount() {
        return this.expressions.size();
    }

    public Object getValueAt(int i, int i2) {
        if (i2 != 0) {
            return i2 != 1 ? "" : this.values.get(i);
        }
        return this.expressions.get(i);
    }

    public void setValueAt(Object obj, int i, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            fireTableDataChanged();
            return;
        }
        String obj2 = obj.toString();
        this.expressions.set(i, obj2);
        this.values.set(i, (obj2.length() <= 0 || (r3 = this.debugGui.dim.eval(obj2)) == null) ? "" : "");
        updateModel();
        int i3 = i + 1;
        if (i3 == this.expressions.size()) {
            this.expressions.add("");
            this.values.add("");
            fireTableRowsInserted(i3, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateModel() {
        String eval;
        for (int i = 0; i < this.expressions.size(); i++) {
            String str = this.expressions.get(i);
            String str2 = "";
            if (str.length() > 0 && (eval = this.debugGui.dim.eval(str)) != null) {
                str2 = eval;
            }
            this.values.set(i, str2.replace('\n', ' '));
        }
        fireTableDataChanged();
    }
}
