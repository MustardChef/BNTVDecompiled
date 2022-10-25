package org.mozilla.classfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClassFileWriter.java */
/* loaded from: classes5.dex */
public final class ClassFileField {
    private short itsAttr1;
    private short itsAttr2;
    private short itsAttr3;
    private short itsFlags;
    private boolean itsHasAttributes = false;
    private int itsIndex;
    private short itsNameIndex;
    private short itsTypeIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassFileField(short s, short s2, short s3) {
        this.itsNameIndex = s;
        this.itsTypeIndex = s2;
        this.itsFlags = s3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAttributes(short s, short s2, short s3, int i) {
        this.itsHasAttributes = true;
        this.itsAttr1 = s;
        this.itsAttr2 = s2;
        this.itsAttr3 = s3;
        this.itsIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int write(byte[] bArr, int i) {
        int putInt16 = ClassFileWriter.putInt16(this.itsTypeIndex, bArr, ClassFileWriter.putInt16(this.itsNameIndex, bArr, ClassFileWriter.putInt16(this.itsFlags, bArr, i)));
        if (!this.itsHasAttributes) {
            return ClassFileWriter.putInt16(0, bArr, putInt16);
        }
        return ClassFileWriter.putInt16(this.itsIndex, bArr, ClassFileWriter.putInt16(this.itsAttr3, bArr, ClassFileWriter.putInt16(this.itsAttr2, bArr, ClassFileWriter.putInt16(this.itsAttr1, bArr, ClassFileWriter.putInt16(1, bArr, putInt16)))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWriteSize() {
        return !this.itsHasAttributes ? 8 : 16;
    }
}
