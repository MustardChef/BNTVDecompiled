package org.mozilla.javascript.tools.debugger;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import org.mozilla.javascript.tools.debugger.treetable.JTreeTable;
import org.mozilla.javascript.tools.debugger.treetable.TreeTableModel;
import org.mozilla.javascript.tools.debugger.treetable.TreeTableModelAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
public class MyTreeTable extends JTreeTable {
    private static final long serialVersionUID = 3457265548184453049L;

    public MyTreeTable(VariableModel variableModel) {
        super(variableModel);
    }

    public JTree resetTree(TreeTableModel treeTableModel) {
        this.tree = new JTreeTable.TreeTableCellRenderer(treeTableModel);
        super.setModel(new TreeTableModelAdapter(treeTableModel, this.tree));
        TreeSelectionModel listToTreeSelectionModelWrapper = new JTreeTable.ListToTreeSelectionModelWrapper();
        this.tree.setSelectionModel(listToTreeSelectionModelWrapper);
        setSelectionModel(listToTreeSelectionModelWrapper.getListSelectionModel());
        if (this.tree.getRowHeight() < 1) {
            setRowHeight(18);
        }
        setDefaultRenderer(TreeTableModel.class, this.tree);
        setDefaultEditor(TreeTableModel.class, new JTreeTable.TreeTableCellEditor());
        setShowGrid(true);
        setIntercellSpacing(new Dimension(1, 1));
        this.tree.setRootVisible(false);
        this.tree.setShowsRootHandles(true);
        DefaultTreeCellRenderer cellRenderer = this.tree.getCellRenderer();
        cellRenderer.setOpenIcon((Icon) null);
        cellRenderer.setClosedIcon((Icon) null);
        cellRenderer.setLeafIcon((Icon) null);
        return this.tree;
    }

    public boolean isCellEditable(EventObject eventObject) {
        if (!(eventObject instanceof MouseEvent)) {
            return eventObject == null;
        }
        MouseEvent mouseEvent = (MouseEvent) eventObject;
        if (mouseEvent.getModifiers() == 0 || ((mouseEvent.getModifiers() & 1040) != 0 && (mouseEvent.getModifiers() & 6863) == 0)) {
            int rowAtPoint = rowAtPoint(mouseEvent.getPoint());
            int columnCount = getColumnCount() - 1;
            while (true) {
                if (columnCount < 0) {
                    break;
                } else if (TreeTableModel.class == getColumnClass(columnCount)) {
                    this.tree.dispatchEvent(new MouseEvent(this.tree, mouseEvent.getID(), mouseEvent.getWhen(), mouseEvent.getModifiers(), mouseEvent.getX() - getCellRect(rowAtPoint, columnCount, true).x, mouseEvent.getY(), mouseEvent.getClickCount(), mouseEvent.isPopupTrigger()));
                    break;
                } else {
                    columnCount--;
                }
            }
        }
        return mouseEvent.getClickCount() >= 3;
    }
}
