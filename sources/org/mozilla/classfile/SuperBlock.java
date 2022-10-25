package org.mozilla.classfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClassFileWriter.java */
/* loaded from: classes5.dex */
public final class SuperBlock {
    private int end;
    private int index;
    private boolean isInQueue;
    private boolean isInitialized;
    private int[] locals;
    private int[] stack;
    private int start;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SuperBlock(int i, int i2, int i3, int[] iArr) {
        this.index = i;
        this.start = i2;
        this.end = i3;
        int[] iArr2 = new int[iArr.length];
        this.locals = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.stack = new int[0];
        this.isInitialized = false;
        this.isInQueue = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getIndex() {
        return this.index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getLocals() {
        int[] iArr = this.locals;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getTrimmedLocals() {
        int length = this.locals.length - 1;
        while (length >= 0) {
            int[] iArr = this.locals;
            if (iArr[length] != 0 || TypeInfo.isTwoWords(iArr[length - 1])) {
                break;
            }
            length--;
        }
        int i = length + 1;
        int i2 = 0;
        int i3 = i;
        for (int i4 = 0; i4 < i; i4++) {
            if (TypeInfo.isTwoWords(this.locals[i4])) {
                i3--;
            }
        }
        int[] iArr2 = new int[i3];
        int i5 = 0;
        while (i2 < i3) {
            int[] iArr3 = this.locals;
            iArr2[i2] = iArr3[i5];
            if (TypeInfo.isTwoWords(iArr3[i5])) {
                i5++;
            }
            i2++;
            i5++;
        }
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getStack() {
        int[] iArr = this.stack;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean merge(int[] iArr, int i, int[] iArr2, int i2, ConstantPool constantPool) {
        if (!this.isInitialized) {
            System.arraycopy(iArr, 0, this.locals, 0, i);
            int[] iArr3 = new int[i2];
            this.stack = iArr3;
            System.arraycopy(iArr2, 0, iArr3, 0, i2);
            this.isInitialized = true;
            return true;
        }
        int[] iArr4 = this.locals;
        if (iArr4.length == i && this.stack.length == i2) {
            return mergeState(iArr4, iArr, i, constantPool) || mergeState(this.stack, iArr2, i2, constantPool);
        }
        throw new IllegalArgumentException("bad merge attempt");
    }

    private boolean mergeState(int[] iArr, int[] iArr2, int i, ConstantPool constantPool) {
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            iArr[i2] = TypeInfo.merge(iArr[i2], iArr2[i2], constantPool);
            if (i3 != iArr[i2]) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStart() {
        return this.start;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEnd() {
        return this.end;
    }

    public String toString() {
        return "sb " + this.index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.isInitialized;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInitialized(boolean z) {
        this.isInitialized = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInQueue() {
        return this.isInQueue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInQueue(boolean z) {
        this.isInQueue = z;
    }
}
