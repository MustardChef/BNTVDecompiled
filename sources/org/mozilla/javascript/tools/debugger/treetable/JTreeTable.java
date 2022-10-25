package org.mozilla.javascript.tools.debugger.treetable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/* loaded from: classes5.dex */
public class JTreeTable extends JTable {
    private static final long serialVersionUID = -2103973006456695515L;
    protected TreeTableCellRenderer tree;

    public JTreeTable(TreeTableModel treeTableModel) {
        this.tree = new TreeTableCellRenderer(treeTableModel);
        super.setModel(new TreeTableModelAdapter(treeTableModel, this.tree));
        TreeSelectionModel listToTreeSelectionModelWrapper = new ListToTreeSelectionModelWrapper();
        this.tree.setSelectionModel(listToTreeSelectionModelWrapper);
        setSelectionModel(listToTreeSelectionModelWrapper.getListSelectionModel());
        setDefaultRenderer(TreeTableModel.class, this.tree);
        setDefaultEditor(TreeTableModel.class, new TreeTableCellEditor());
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        if (this.tree.getRowHeight() < 1) {
            setRowHeight(18);
        }
    }

    public void updateUI() {
        super.updateUI();
        TreeTableCellRenderer treeTableCellRenderer = this.tree;
        if (treeTableCellRenderer != null) {
            treeTableCellRenderer.updateUI();
        }
        LookAndFeel.installColorsAndFont(this, "Tree.background", "Tree.foreground", "Tree.font");
    }

    public int getEditingRow() {
        if (getColumnClass(this.editingColumn) == TreeTableModel.class) {
            return -1;
        }
        return this.editingRow;
    }

    public void setRowHeight(int i) {
        super.setRowHeight(i);
        TreeTableCellRenderer treeTableCellRenderer = this.tree;
        if (treeTableCellRenderer == null || treeTableCellRenderer.getRowHeight() == i) {
            return;
        }
        this.tree.setRowHeight(getRowHeight());
    }

    public JTree getTree() {
        return this.tree;
    }

    /* loaded from: classes5.dex */
    public class TreeTableCellRenderer extends JTree implements TableCellRenderer {
        private static final long serialVersionUID = -193867880014600717L;
        protected int visibleRow;

        public TreeTableCellRenderer(TreeModel treeModel) {
            super(treeModel);
        }

        public void updateUI() {
            super.updateUI();
            DefaultTreeCellRenderer cellRenderer = getCellRenderer();
            if (cellRenderer instanceof DefaultTreeCellRenderer) {
                DefaultTreeCellRenderer defaultTreeCellRenderer = cellRenderer;
                defaultTreeCellRenderer.setTextSelectionColor(UIManager.getColor("Table.selectionForeground"));
                defaultTreeCellRenderer.setBackgroundSelectionColor(UIManager.getColor("Table.selectionBackground"));
            }
        }

        public void setRowHeight(int i) {
            if (i > 0) {
                super.setRowHeight(i);
                JTreeTable jTreeTable = JTreeTable.this;
                if (jTreeTable == null || jTreeTable.getRowHeight() == i) {
                    return;
                }
                JTreeTable.this.setRowHeight(getRowHeight());
            }
        }

        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, 0, i3, JTreeTable.this.getHeight());
        }

        public void paint(Graphics graphics) {
            graphics.translate(0, (-this.visibleRow) * getRowHeight());
            super.paint(graphics);
        }

        public Component getTableCellRendererComponent(JTable jTable, Object obj, boolean z, boolean z2, int i, int i2) {
            if (z) {
                setBackground(jTable.getSelectionBackground());
            } else {
                setBackground(jTable.getBackground());
            }
            this.visibleRow = i;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public class TreeTableCellEditor extends AbstractCellEditor implements TableCellEditor {
        public TreeTableCellEditor() {
        }

        public Component getTableCellEditorComponent(JTable jTable, Object obj, boolean z, int i, int i2) {
            return JTreeTable.this.tree;
        }

        @Override // org.mozilla.javascript.tools.debugger.treetable.AbstractCellEditor
        public boolean isCellEditable(EventObject eventObject) {
            if (eventObject instanceof MouseEvent) {
                int columnCount = JTreeTable.this.getColumnCount() - 1;
                while (true) {
                    if (columnCount < 0) {
                        break;
                    } else if (JTreeTable.this.getColumnClass(columnCount) == TreeTableModel.class) {
                        MouseEvent mouseEvent = (MouseEvent) eventObject;
                        JTreeTable.this.tree.dispatchEvent(new MouseEvent(JTreeTable.this.tree, mouseEvent.getID(), mouseEvent.getWhen(), mouseEvent.getModifiers(), mouseEvent.getX() - JTreeTable.this.getCellRect(0, columnCount, true).x, mouseEvent.getY(), mouseEvent.getClickCount(), mouseEvent.isPopupTrigger()));
                        break;
                    } else {
                        columnCount--;
                    }
                }
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class ListToTreeSelectionModelWrapper extends DefaultTreeSelectionModel {
        private static final long serialVersionUID = 8168140829623071131L;
        protected boolean updatingListSelectionModel;

        public ListToTreeSelectionModelWrapper() {
            getListSelectionModel().addListSelectionListener(createListSelectionListener());
        }

        public ListSelectionModel getListSelectionModel() {
            return this.listSelectionModel;
        }

        public void resetRowSelection() {
            if (this.updatingListSelectionModel) {
                return;
            }
            this.updatingListSelectionModel = true;
            try {
                super.resetRowSelection();
            } finally {
                this.updatingListSelectionModel = false;
            }
        }

        protected ListSelectionListener createListSelectionListener() {
            return new ListSelectionHandler();
        }

        protected void updateSelectedPathsFromSelectedRows() {
            TreePath pathForRow;
            if (this.updatingListSelectionModel) {
                return;
            }
            this.updatingListSelectionModel = true;
            try {
                int minSelectionIndex = this.listSelectionModel.getMinSelectionIndex();
                int maxSelectionIndex = this.listSelectionModel.getMaxSelectionIndex();
                clearSelection();
                if (minSelectionIndex != -1 && maxSelectionIndex != -1) {
                    while (minSelectionIndex <= maxSelectionIndex) {
                        if (this.listSelectionModel.isSelectedIndex(minSelectionIndex) && (pathForRow = JTreeTable.this.tree.getPathForRow(minSelectionIndex)) != null) {
                            addSelectionPath(pathForRow);
                        }
                        minSelectionIndex++;
                    }
                }
            } finally {
                this.updatingListSelectionModel = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class ListSelectionHandler implements ListSelectionListener {
            ListSelectionHandler() {
            }

            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                ListToTreeSelectionModelWrapper.this.updateSelectedPathsFromSelectedRows();
            }
        }
    }
}
