package org.mozilla.javascript.tools.debugger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import org.mozilla.javascript.tools.shell.ConsoleTextArea;

/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
class JSInternalConsole extends JInternalFrame implements ActionListener {
    private static final long serialVersionUID = -5523468828771087292L;
    ConsoleTextArea consoleTextArea;

    public JSInternalConsole(String str) {
        super(str, true, false, true, true);
        ConsoleTextArea consoleTextArea = new ConsoleTextArea(null);
        this.consoleTextArea = consoleTextArea;
        consoleTextArea.setRows(24);
        this.consoleTextArea.setColumns(80);
        setContentPane(new JScrollPane(this.consoleTextArea));
        pack();
        addInternalFrameListener(new InternalFrameAdapter() { // from class: org.mozilla.javascript.tools.debugger.JSInternalConsole.1
            public void internalFrameActivated(InternalFrameEvent internalFrameEvent) {
                if (JSInternalConsole.this.consoleTextArea.hasFocus()) {
                    JSInternalConsole.this.consoleTextArea.getCaret().setVisible(false);
                    JSInternalConsole.this.consoleTextArea.getCaret().setVisible(true);
                }
            }
        });
    }

    public InputStream getIn() {
        return this.consoleTextArea.getIn();
    }

    public PrintStream getOut() {
        return this.consoleTextArea.getOut();
    }

    public PrintStream getErr() {
        return this.consoleTextArea.getErr();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();
        if (actionCommand.equals("Cut")) {
            this.consoleTextArea.cut();
        } else if (actionCommand.equals("Copy")) {
            this.consoleTextArea.copy();
        } else if (actionCommand.equals("Paste")) {
            this.consoleTextArea.paste();
        }
    }
}
