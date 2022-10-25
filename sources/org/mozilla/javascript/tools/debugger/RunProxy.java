package org.mozilla.javascript.tools.debugger;

import org.mozilla.javascript.tools.debugger.Dim;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwingGui.java */
/* loaded from: classes5.dex */
public class RunProxy implements Runnable {
    static final int ENTER_INTERRUPT = 4;
    static final int LOAD_FILE = 2;
    static final int OPEN_FILE = 1;
    static final int UPDATE_SOURCE_TEXT = 3;
    String alertMessage;
    private SwingGui debugGui;
    String fileName;
    Dim.StackFrame lastFrame;
    Dim.SourceInfo sourceInfo;
    String text;
    String threadTitle;
    private int type;

    public RunProxy(SwingGui swingGui, int i) {
        this.debugGui = swingGui;
        this.type = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = this.type;
        if (i == 1) {
            try {
                this.debugGui.dim.compileScript(this.fileName, this.text);
            } catch (RuntimeException e) {
                SwingGui swingGui = this.debugGui;
                String message = e.getMessage();
                MessageDialogWrapper.showMessageDialog(swingGui, message, "Error Compiling " + this.fileName, 0);
            }
        } else if (i == 2) {
            try {
                this.debugGui.dim.evalScript(this.fileName, this.text);
            } catch (RuntimeException e2) {
                SwingGui swingGui2 = this.debugGui;
                String message2 = e2.getMessage();
                MessageDialogWrapper.showMessageDialog(swingGui2, message2, "Run error for " + this.fileName, 0);
            }
        } else if (i != 3) {
            if (i == 4) {
                this.debugGui.enterInterruptImpl(this.lastFrame, this.threadTitle, this.alertMessage);
                return;
            }
            throw new IllegalArgumentException(String.valueOf(this.type));
        } else {
            String url = this.sourceInfo.url();
            if (this.debugGui.updateFileWindow(this.sourceInfo) || url.equals("<stdin>")) {
                return;
            }
            this.debugGui.createFileWindow(this.sourceInfo, -1);
        }
    }
}
