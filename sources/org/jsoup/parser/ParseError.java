package org.jsoup.parser;

/* loaded from: classes5.dex */
public class ParseError {
    private String cursorPos;
    private String errorMsg;
    private int pos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseError(CharacterReader characterReader, String str) {
        this.pos = characterReader.pos();
        this.cursorPos = characterReader.cursorPos();
        this.errorMsg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParseError(CharacterReader characterReader, String str, Object... objArr) {
        this.pos = characterReader.pos();
        this.cursorPos = characterReader.cursorPos();
        this.errorMsg = String.format(str, objArr);
    }

    ParseError(int i, String str) {
        this.pos = i;
        this.cursorPos = String.valueOf(i);
        this.errorMsg = str;
    }

    ParseError(int i, String str, Object... objArr) {
        this.pos = i;
        this.cursorPos = String.valueOf(i);
        this.errorMsg = String.format(str, objArr);
    }

    public String getErrorMessage() {
        return this.errorMsg;
    }

    public int getPosition() {
        return this.pos;
    }

    public String getCursorPos() {
        return this.cursorPos;
    }

    public String toString() {
        return "<" + this.cursorPos + ">: " + this.errorMsg;
    }
}
