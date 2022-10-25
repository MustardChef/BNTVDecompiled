package org.mozilla.javascript.tools.shell;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConsoleTextArea.java */
/* loaded from: classes5.dex */
public class ConsoleWrite implements Runnable {
    private String str;
    private ConsoleTextArea textArea;

    public ConsoleWrite(ConsoleTextArea consoleTextArea, String str) {
        this.textArea = consoleTextArea;
        this.str = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.textArea.write(this.str);
    }
}
