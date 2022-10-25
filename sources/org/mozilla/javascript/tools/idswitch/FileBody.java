package org.mozilla.javascript.tools.idswitch;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes5.dex */
public class FileBody {
    private char[] buffer = new char[16384];
    private int bufferEnd;
    ReplaceItem firstReplace;
    ReplaceItem lastReplace;
    private int lineBegin;
    private int lineEnd;
    private int lineNumber;
    private int nextLineStart;

    /* loaded from: classes5.dex */
    private static class ReplaceItem {
        int begin;
        int end;
        ReplaceItem next;
        String replacement;

        ReplaceItem(int i, int i2, String str) {
            this.begin = i;
            this.end = i2;
            this.replacement = str;
        }
    }

    public char[] getBuffer() {
        return this.buffer;
    }

    public void readData(Reader reader) throws IOException {
        int length = this.buffer.length;
        int i = 0;
        while (true) {
            int read = reader.read(this.buffer, i, length - i);
            if (read < 0) {
                this.bufferEnd = i;
                return;
            }
            i += read;
            if (length == i) {
                length *= 2;
                char[] cArr = new char[length];
                System.arraycopy(this.buffer, 0, cArr, 0, i);
                this.buffer = cArr;
            }
        }
    }

    public void writeInitialData(Writer writer) throws IOException {
        writer.write(this.buffer, 0, this.bufferEnd);
    }

    public void writeData(Writer writer) throws IOException {
        int i = 0;
        for (ReplaceItem replaceItem = this.firstReplace; replaceItem != null; replaceItem = replaceItem.next) {
            int i2 = replaceItem.begin - i;
            if (i2 > 0) {
                writer.write(this.buffer, i, i2);
            }
            writer.write(replaceItem.replacement);
            i = replaceItem.end;
        }
        int i3 = this.bufferEnd - i;
        if (i3 != 0) {
            writer.write(this.buffer, i, i3);
        }
    }

    public boolean wasModified() {
        return this.firstReplace != null;
    }

    public boolean setReplacement(int i, int i2, String str) {
        if (equals(str, this.buffer, i, i2)) {
            return false;
        }
        ReplaceItem replaceItem = new ReplaceItem(i, i2, str);
        ReplaceItem replaceItem2 = this.firstReplace;
        if (replaceItem2 == null) {
            this.lastReplace = replaceItem;
            this.firstReplace = replaceItem;
            return true;
        } else if (i < replaceItem2.begin) {
            replaceItem.next = this.firstReplace;
            this.firstReplace = replaceItem;
            return true;
        } else {
            ReplaceItem replaceItem3 = this.firstReplace;
            ReplaceItem replaceItem4 = replaceItem3.next;
            while (true) {
                ReplaceItem replaceItem5 = replaceItem4;
                ReplaceItem replaceItem6 = replaceItem3;
                replaceItem3 = replaceItem5;
                if (replaceItem3 == null) {
                    break;
                } else if (i < replaceItem3.begin) {
                    replaceItem.next = replaceItem3;
                    replaceItem6.next = replaceItem;
                    break;
                } else {
                    replaceItem4 = replaceItem3.next;
                }
            }
            if (replaceItem3 == null) {
                this.lastReplace.next = replaceItem;
                return true;
            }
            return true;
        }
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getLineBegin() {
        return this.lineBegin;
    }

    public int getLineEnd() {
        return this.lineEnd;
    }

    public void startLineLoop() {
        this.lineNumber = 0;
        this.nextLineStart = 0;
        this.lineEnd = 0;
        this.lineBegin = 0;
    }

    public boolean nextLine() {
        int i;
        int i2;
        int i3 = this.nextLineStart;
        char c = 0;
        if (i3 == this.bufferEnd) {
            this.lineNumber = 0;
            return false;
        }
        while (true) {
            i = this.bufferEnd;
            if (i3 == i || (c = this.buffer[i3]) == '\n' || c == '\r') {
                break;
            }
            i3++;
        }
        this.lineBegin = this.nextLineStart;
        this.lineEnd = i3;
        if (i3 == i) {
            this.nextLineStart = i3;
        } else if (c == '\r' && (i2 = i3 + 1) != i && this.buffer[i2] == '\n') {
            this.nextLineStart = i3 + 2;
        } else {
            this.nextLineStart = i3 + 1;
        }
        this.lineNumber++;
        return true;
    }

    private static boolean equals(String str, char[] cArr, int i, int i2) {
        if (str.length() == i2 - i) {
            int i3 = 0;
            while (i != i2) {
                if (cArr[i] != str.charAt(i3)) {
                    return false;
                }
                i++;
                i3++;
            }
            return true;
        }
        return false;
    }
}
