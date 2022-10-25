package org.mozilla.javascript.tools.debugger.treetable;

import java.util.EventObject;
import javax.swing.CellEditor;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;

/* loaded from: classes5.dex */
public class AbstractCellEditor implements CellEditor {
    protected EventListenerList listenerList = new EventListenerList();

    public void cancelCellEditing() {
    }

    public Object getCellEditorValue() {
        return null;
    }

    public boolean isCellEditable(EventObject eventObject) {
        return true;
    }

    public boolean shouldSelectCell(EventObject eventObject) {
        return false;
    }

    public boolean stopCellEditing() {
        return true;
    }

    public void addCellEditorListener(CellEditorListener cellEditorListener) {
        this.listenerList.add(CellEditorListener.class, cellEditorListener);
    }

    public void removeCellEditorListener(CellEditorListener cellEditorListener) {
        this.listenerList.remove(CellEditorListener.class, cellEditorListener);
    }

    protected void fireEditingStopped() {
        Object[] listenerList = this.listenerList.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            if (listenerList[length] == CellEditorListener.class) {
                ((CellEditorListener) listenerList[length + 1]).editingStopped(new ChangeEvent(this));
            }
        }
    }

    protected void fireEditingCanceled() {
        Object[] listenerList = this.listenerList.getListenerList();
        for (int length = listenerList.length - 2; length >= 0; length -= 2) {
            if (listenerList[length] == CellEditorListener.class) {
                ((CellEditorListener) listenerList[length + 1]).editingCanceled(new ChangeEvent(this));
            }
        }
    }
}
