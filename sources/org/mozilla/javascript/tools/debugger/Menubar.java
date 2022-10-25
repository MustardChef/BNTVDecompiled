package org.mozilla.javascript.tools.debugger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
public class Menubar extends JMenuBar implements ActionListener {
    private static final long serialVersionUID = 3217170497245911461L;
    private JCheckBoxMenuItem breakOnEnter;
    private JCheckBoxMenuItem breakOnExceptions;
    private JCheckBoxMenuItem breakOnReturn;
    private SwingGui debugGui;
    private List<JMenuItem> interruptOnlyItems = Collections.synchronizedList(new ArrayList());
    private List<JMenuItem> runOnlyItems = Collections.synchronizedList(new ArrayList());
    private JMenu windowMenu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Menubar(SwingGui swingGui) {
        char[] cArr;
        String[] strArr;
        this.debugGui = swingGui;
        String[] strArr2 = {"Open...", "Run...", "", "Exit"};
        String[] strArr3 = {"Open", "Load", "", "Exit"};
        char[] cArr2 = {'0', 'N', 0, 'X'};
        int[] iArr = {79, 78, 0, 81};
        String[] strArr4 = {"Cut", "Copy", "Paste", "Go to function..."};
        char[] cArr3 = {'T', 'C', 'P', 'F'};
        String[] strArr5 = {"Break", "Go", "Step Into", "Step Over", "Step Out"};
        char[] cArr4 = {'B', 'G', 'I', 'O', 'T'};
        String[] strArr6 = {"Metal", "Windows", "Motif"};
        char[] cArr5 = {'M', 'W', 'F'};
        int[] iArr2 = {19, 116, 122, 118, 119, 0, 0};
        JMenu jMenu = new JMenu("File");
        jMenu.setMnemonic('F');
        JMenu jMenu2 = new JMenu("Edit");
        jMenu2.setMnemonic('E');
        JMenu jMenu3 = new JMenu("Platform");
        jMenu3.setMnemonic('P');
        JMenu jMenu4 = new JMenu("Debug");
        jMenu4.setMnemonic('D');
        JMenu jMenu5 = jMenu4;
        JMenu jMenu6 = new JMenu("Window");
        this.windowMenu = jMenu6;
        jMenu6.setMnemonic('W');
        int i = 0;
        for (int i2 = 4; i < i2; i2 = 4) {
            if (strArr2[i].length() == 0) {
                jMenu.addSeparator();
                strArr = strArr2;
                cArr = cArr4;
            } else {
                cArr = cArr4;
                strArr = strArr2;
                JMenuItem jMenuItem = new JMenuItem(strArr2[i], cArr2[i]);
                jMenuItem.setActionCommand(strArr3[i]);
                jMenuItem.addActionListener(this);
                jMenu.add(jMenuItem);
                if (iArr[i] != 0) {
                    jMenuItem.setAccelerator(KeyStroke.getKeyStroke(iArr[i], 2));
                }
            }
            i++;
            cArr4 = cArr;
            strArr2 = strArr;
        }
        char[] cArr6 = cArr4;
        for (int i3 = 0; i3 < 4; i3++) {
            JMenuItem jMenuItem2 = new JMenuItem(strArr4[i3], cArr3[i3]);
            jMenuItem2.addActionListener(this);
            jMenu2.add(jMenuItem2);
        }
        for (int i4 = 0; i4 < 3; i4++) {
            JMenuItem jMenuItem3 = new JMenuItem(strArr6[i4], cArr5[i4]);
            jMenuItem3.addActionListener(this);
            jMenu3.add(jMenuItem3);
        }
        int i5 = 0;
        while (i5 < 5) {
            JMenuItem jMenuItem4 = new JMenuItem(strArr5[i5], cArr6[i5]);
            jMenuItem4.addActionListener(this);
            if (iArr2[i5] != 0) {
                jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(iArr2[i5], 0));
            }
            if (i5 != 0) {
                this.interruptOnlyItems.add(jMenuItem4);
            } else {
                this.runOnlyItems.add(jMenuItem4);
            }
            JMenu jMenu7 = jMenu5;
            jMenu7.add(jMenuItem4);
            i5++;
            jMenu5 = jMenu7;
        }
        JMenu jMenu8 = jMenu5;
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("Break on Exceptions");
        this.breakOnExceptions = jCheckBoxMenuItem;
        jCheckBoxMenuItem.setMnemonic('X');
        this.breakOnExceptions.addActionListener(this);
        this.breakOnExceptions.setSelected(false);
        jMenu8.add(this.breakOnExceptions);
        JCheckBoxMenuItem jCheckBoxMenuItem2 = new JCheckBoxMenuItem("Break on Function Enter");
        this.breakOnEnter = jCheckBoxMenuItem2;
        jCheckBoxMenuItem2.setMnemonic('E');
        this.breakOnEnter.addActionListener(this);
        this.breakOnEnter.setSelected(false);
        jMenu8.add(this.breakOnEnter);
        JCheckBoxMenuItem jCheckBoxMenuItem3 = new JCheckBoxMenuItem("Break on Function Return");
        this.breakOnReturn = jCheckBoxMenuItem3;
        jCheckBoxMenuItem3.setMnemonic('R');
        this.breakOnReturn.addActionListener(this);
        this.breakOnReturn.setSelected(false);
        jMenu8.add(this.breakOnReturn);
        add(jMenu);
        add(jMenu2);
        add(jMenu8);
        JMenu jMenu9 = this.windowMenu;
        JMenuItem jMenuItem5 = new JMenuItem("Cascade", 65);
        jMenu9.add(jMenuItem5);
        jMenuItem5.addActionListener(this);
        JMenu jMenu10 = this.windowMenu;
        JMenuItem jMenuItem6 = new JMenuItem("Tile", 84);
        jMenu10.add(jMenuItem6);
        jMenuItem6.addActionListener(this);
        this.windowMenu.addSeparator();
        JMenu jMenu11 = this.windowMenu;
        JMenuItem jMenuItem7 = new JMenuItem("Console", 67);
        jMenu11.add(jMenuItem7);
        jMenuItem7.addActionListener(this);
        add(this.windowMenu);
        updateEnabled(false);
    }

    public JCheckBoxMenuItem getBreakOnExceptions() {
        return this.breakOnExceptions;
    }

    public JCheckBoxMenuItem getBreakOnEnter() {
        return this.breakOnEnter;
    }

    public JCheckBoxMenuItem getBreakOnReturn() {
        return this.breakOnReturn;
    }

    public JMenu getDebugMenu() {
        return getMenu(2);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String str;
        String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Metal")) {
            str = "javax.swing.plaf.metal.MetalLookAndFeel";
        } else if (actionCommand.equals("Windows")) {
            str = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        } else if (!actionCommand.equals("Motif")) {
            Object source = actionEvent.getSource();
            if (source == this.breakOnExceptions) {
                this.debugGui.dim.setBreakOnExceptions(this.breakOnExceptions.isSelected());
                return;
            } else if (source == this.breakOnEnter) {
                this.debugGui.dim.setBreakOnEnter(this.breakOnEnter.isSelected());
                return;
            } else if (source == this.breakOnReturn) {
                this.debugGui.dim.setBreakOnReturn(this.breakOnReturn.isSelected());
                return;
            } else {
                this.debugGui.actionPerformed(actionEvent);
                return;
            }
        } else {
            str = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        }
        try {
            UIManager.setLookAndFeel(str);
            SwingUtilities.updateComponentTreeUI(this.debugGui);
            SwingUtilities.updateComponentTreeUI(this.debugGui.dlg);
        } catch (Exception unused) {
        }
    }

    public void addFile(String str) {
        int i;
        int itemCount = this.windowMenu.getItemCount();
        if (itemCount == 4) {
            this.windowMenu.addSeparator();
            itemCount++;
        }
        JMenuItem item = this.windowMenu.getItem(itemCount - 1);
        boolean z = false;
        if (item == null || !item.getText().equals("More Windows...")) {
            i = 5;
        } else {
            z = true;
            i = 6;
        }
        if (!z && itemCount - 4 == 5) {
            JMenu jMenu = this.windowMenu;
            JMenuItem jMenuItem = new JMenuItem("More Windows...", 77);
            jMenu.add(jMenuItem);
            jMenuItem.setActionCommand("More Windows...");
            jMenuItem.addActionListener(this);
        } else if (itemCount - 4 <= i) {
            if (z) {
                itemCount--;
                this.windowMenu.remove(item);
            }
            String shortName = SwingGui.getShortName(str);
            JMenu jMenu2 = this.windowMenu;
            StringBuilder sb = new StringBuilder();
            int i2 = (itemCount - 4) + 48;
            sb.append((char) i2);
            sb.append(" ");
            sb.append(shortName);
            JMenuItem jMenuItem2 = new JMenuItem(sb.toString(), i2);
            jMenu2.add(jMenuItem2);
            if (z) {
                this.windowMenu.add(item);
            }
            jMenuItem2.setActionCommand(str);
            jMenuItem2.addActionListener(this);
        }
    }

    public void updateEnabled(boolean z) {
        for (int i = 0; i != this.interruptOnlyItems.size(); i++) {
            this.interruptOnlyItems.get(i).setEnabled(z);
        }
        for (int i2 = 0; i2 != this.runOnlyItems.size(); i2++) {
            this.runOnlyItems.get(i2).setEnabled(!z);
        }
    }
}
