package org.mozilla.javascript.tools.debugger;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import org.mozilla.javascript.tools.debugger.Dim;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
public class ContextWindow extends JPanel implements ActionListener {
    private static final long serialVersionUID = 2306040975490228051L;
    private EvalTextArea cmdLine;
    JComboBox context;
    private SwingGui debugGui;
    private boolean enabled = false;
    private Evaluator evaluator;
    private MyTreeTable localsTable;
    JSplitPane split;
    private MyTableModel tableModel;
    private JTabbedPane tabs;
    private JTabbedPane tabs2;
    private MyTreeTable thisTable;
    List<String> toolTips;

    public ContextWindow(final SwingGui swingGui) {
        this.debugGui = swingGui;
        JPanel jPanel = new JPanel();
        final JToolBar jToolBar = new JToolBar();
        jToolBar.setName("Variables");
        jToolBar.setLayout(new GridLayout());
        jToolBar.add(jPanel);
        final JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout());
        final JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayout());
        jPanel2.add(jToolBar);
        JLabel jLabel = new JLabel("Context:");
        JComboBox jComboBox = new JComboBox();
        this.context = jComboBox;
        jComboBox.setLightWeightPopupEnabled(false);
        this.toolTips = Collections.synchronizedList(new ArrayList());
        jLabel.setBorder(this.context.getBorder());
        this.context.addActionListener(this);
        this.context.setActionCommand("ContextSwitch");
        GridBagLayout gridBagLayout = new GridBagLayout();
        jPanel.setLayout(gridBagLayout);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets.left = 5;
        gridBagConstraints.anchor = 17;
        gridBagConstraints.ipadx = 5;
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        jPanel.add(jLabel);
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridwidth = 0;
        gridBagConstraints2.fill = 2;
        gridBagConstraints2.anchor = 17;
        gridBagLayout.setConstraints(this.context, gridBagConstraints2);
        jPanel.add(this.context);
        JTabbedPane jTabbedPane = new JTabbedPane(3);
        this.tabs = jTabbedPane;
        jTabbedPane.setPreferredSize(new Dimension(500, 300));
        this.thisTable = new MyTreeTable(new VariableModel());
        JScrollPane jScrollPane = new JScrollPane(this.thisTable);
        jScrollPane.getViewport().setViewSize(new Dimension(5, 2));
        this.tabs.add("this", jScrollPane);
        MyTreeTable myTreeTable = new MyTreeTable(new VariableModel());
        this.localsTable = myTreeTable;
        myTreeTable.setAutoResizeMode(4);
        this.localsTable.setPreferredSize(null);
        this.tabs.add("Locals", new JScrollPane(this.localsTable));
        gridBagConstraints2.weighty = 1.0d;
        gridBagConstraints2.weightx = 1.0d;
        gridBagConstraints2.gridheight = 0;
        gridBagConstraints2.fill = 1;
        gridBagConstraints2.anchor = 17;
        gridBagLayout.setConstraints(this.tabs, gridBagConstraints2);
        jPanel.add(this.tabs);
        this.evaluator = new Evaluator(swingGui);
        this.cmdLine = new EvalTextArea(swingGui);
        this.tableModel = this.evaluator.tableModel;
        JScrollPane jScrollPane2 = new JScrollPane(this.evaluator);
        final JToolBar jToolBar2 = new JToolBar();
        jToolBar2.setName("Evaluate");
        JTabbedPane jTabbedPane2 = new JTabbedPane(3);
        this.tabs2 = jTabbedPane2;
        jTabbedPane2.add("Watch", jScrollPane2);
        this.tabs2.add("Evaluate", new JScrollPane(this.cmdLine));
        this.tabs2.setPreferredSize(new Dimension(500, 300));
        jToolBar2.setLayout(new GridLayout());
        jToolBar2.add(this.tabs2);
        jPanel3.add(jToolBar2);
        this.evaluator.setAutoResizeMode(4);
        JSplitPane jSplitPane = new JSplitPane(1, jPanel2, jPanel3);
        this.split = jSplitPane;
        jSplitPane.setOneTouchExpandable(true);
        SwingGui.setResizeWeight(this.split, 0.5d);
        setLayout(new BorderLayout());
        add(this.split, "Center");
        final JSplitPane jSplitPane2 = this.split;
        ComponentListener componentListener = new ComponentListener() { // from class: org.mozilla.javascript.tools.debugger.ContextWindow.1
            boolean t2Docked = true;

            void check(Component component) {
                boolean z;
                boolean z2;
                JSplitPane parent = this.getParent();
                if (parent == null) {
                    return;
                }
                Container parent2 = jToolBar.getParent();
                boolean z3 = false;
                if (parent2 == null || parent2 == jPanel2) {
                    z = true;
                } else {
                    while (!(parent2 instanceof JFrame)) {
                        parent2 = parent2.getParent();
                    }
                    JFrame jFrame = (JFrame) parent2;
                    swingGui.addTopLevel("Variables", jFrame);
                    if (!jFrame.isResizable()) {
                        jFrame.setResizable(true);
                        jFrame.setDefaultCloseOperation(0);
                        final WindowListener[] listeners = jFrame.getListeners(WindowListener.class);
                        jFrame.removeWindowListener(listeners[0]);
                        jFrame.addWindowListener(new WindowAdapter() { // from class: org.mozilla.javascript.tools.debugger.ContextWindow.1.1
                            public void windowClosing(WindowEvent windowEvent) {
                                ContextWindow.this.context.hidePopup();
                                listeners[0].windowClosing(windowEvent);
                            }
                        });
                    }
                    z = false;
                }
                Container parent3 = jToolBar2.getParent();
                if (parent3 == null || parent3 == jPanel3) {
                    z3 = true;
                } else {
                    while (!(parent3 instanceof JFrame)) {
                        parent3 = parent3.getParent();
                    }
                    JFrame jFrame2 = (JFrame) parent3;
                    swingGui.addTopLevel("Evaluate", jFrame2);
                    jFrame2.setResizable(true);
                }
                if (z && (z2 = this.t2Docked) && z3 && z2) {
                    return;
                }
                this.t2Docked = z3;
                JSplitPane jSplitPane3 = parent;
                if (z) {
                    if (z3) {
                        jSplitPane2.setDividerLocation(0.5d);
                    } else {
                        jSplitPane2.setDividerLocation(1.0d);
                    }
                } else if (z3) {
                    jSplitPane2.setDividerLocation(0.0d);
                    jSplitPane3.setDividerLocation(0.66d);
                } else {
                    jSplitPane3.setDividerLocation(1.0d);
                }
            }

            public void componentHidden(ComponentEvent componentEvent) {
                check(componentEvent.getComponent());
            }

            public void componentMoved(ComponentEvent componentEvent) {
                check(componentEvent.getComponent());
            }

            public void componentResized(ComponentEvent componentEvent) {
                check(componentEvent.getComponent());
            }

            public void componentShown(ComponentEvent componentEvent) {
                check(componentEvent.getComponent());
            }
        };
        jPanel2.addContainerListener(new ContainerListener() { // from class: org.mozilla.javascript.tools.debugger.ContextWindow.2
            public void componentAdded(ContainerEvent containerEvent) {
                JSplitPane parent = this.getParent();
                if (containerEvent.getChild() == jToolBar) {
                    if (jToolBar2.getParent() == jPanel3) {
                        jSplitPane2.setDividerLocation(0.5d);
                    } else {
                        jSplitPane2.setDividerLocation(1.0d);
                    }
                    parent.setDividerLocation(0.66d);
                }
            }

            public void componentRemoved(ContainerEvent containerEvent) {
                JSplitPane parent = this.getParent();
                if (containerEvent.getChild() == jToolBar) {
                    if (jToolBar2.getParent() == jPanel3) {
                        jSplitPane2.setDividerLocation(0.0d);
                        parent.setDividerLocation(0.66d);
                        return;
                    }
                    parent.setDividerLocation(1.0d);
                }
            }
        });
        jToolBar.addComponentListener(componentListener);
        jToolBar2.addComponentListener(componentListener);
        setEnabled(false);
    }

    public void setEnabled(boolean z) {
        this.context.setEnabled(z);
        this.thisTable.setEnabled(z);
        this.localsTable.setEnabled(z);
        this.evaluator.setEnabled(z);
        this.cmdLine.setEnabled(z);
    }

    public void disableUpdate() {
        this.enabled = false;
    }

    public void enableUpdate() {
        this.enabled = true;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Dim.ContextData currentContextData;
        VariableModel variableModel;
        if (this.enabled && actionEvent.getActionCommand().equals("ContextSwitch") && (currentContextData = this.debugGui.dim.currentContextData()) != null) {
            int selectedIndex = this.context.getSelectedIndex();
            this.context.setToolTipText(this.toolTips.get(selectedIndex));
            if (selectedIndex >= currentContextData.frameCount()) {
                return;
            }
            Dim.StackFrame frame = currentContextData.getFrame(selectedIndex);
            Object scope = frame.scope();
            Object thisObj = frame.thisObj();
            this.thisTable.resetTree(new VariableModel(this.debugGui.dim, thisObj));
            if (scope != thisObj) {
                variableModel = new VariableModel(this.debugGui.dim, scope);
            } else {
                variableModel = new VariableModel();
            }
            this.localsTable.resetTree(variableModel);
            this.debugGui.dim.contextSwitch(selectedIndex);
            this.debugGui.showStopLine(frame);
            this.tableModel.updateModel();
        }
    }
}
