package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.Label */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/Label.class */
public class Label {
    static final int DEBUG = 1;
    static final int RESOLVED = 2;
    static final int RESIZED = 4;
    static final int PUSHED = 8;
    static final int TARGET = 16;
    static final int STORE = 32;
    static final int REACHABLE = 64;
    static final int JSR = 128;
    static final int RET = 256;
    static final int SUBROUTINE = 512;
    static final int VISITED = 1024;
    static final int VISITED2 = 2048;
    public Object info;
    int status;
    int line;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int inputStackTop;
    int outputStackMax;
    Frame frame;
    Label successor;
    Edge successors;
    Label next;

    public int getOffset() {
        if ((this.status & 2) == 0) {
            throw new IllegalStateException("Label offset position has not been resolved yet");
        }
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(MethodWriter owner, ByteVector out, int source, boolean wideOffset) {
        if ((this.status & 2) == 0) {
            if (wideOffset) {
                addReference((-1) - source, out.length);
                out.putInt(-1);
                return;
            }
            addReference(source, out.length);
            out.putShort(-1);
        } else if (wideOffset) {
            out.putInt(this.position - source);
        } else {
            out.putShort(this.position - source);
        }
    }

    private void addReference(int sourcePosition, int referencePosition) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        if (this.referenceCount >= this.srcAndRefPositions.length) {
            int[] a = new int[this.srcAndRefPositions.length + 6];
            System.arraycopy(this.srcAndRefPositions, 0, a, 0, this.srcAndRefPositions.length);
            this.srcAndRefPositions = a;
        }
        int[] iArr = this.srcAndRefPositions;
        int i = this.referenceCount;
        this.referenceCount = i + 1;
        iArr[i] = sourcePosition;
        int[] iArr2 = this.srcAndRefPositions;
        int i2 = this.referenceCount;
        this.referenceCount = i2 + 1;
        iArr2[i2] = referencePosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean resolve(MethodWriter owner, int position, byte[] data) {
        boolean needUpdate = false;
        this.status |= 2;
        this.position = position;
        int i = 0;
        while (i < this.referenceCount) {
            int i2 = i;
            int i3 = i + 1;
            int source = this.srcAndRefPositions[i2];
            i = i3 + 1;
            int reference = this.srcAndRefPositions[i3];
            if (source >= 0) {
                int offset = position - source;
                if (offset < -32768 || offset > 32767) {
                    int opcode = data[reference - 1] & 255;
                    if (opcode <= 168) {
                        data[reference - 1] = (byte) (opcode + 49);
                    } else {
                        data[reference - 1] = (byte) (opcode + 20);
                    }
                    needUpdate = true;
                }
                data[reference] = (byte) (offset >>> 8);
                data[reference + 1] = (byte) offset;
            } else {
                int offset2 = position + source + 1;
                int reference2 = reference + 1;
                data[reference] = (byte) (offset2 >>> 24);
                int reference3 = reference2 + 1;
                data[reference2] = (byte) (offset2 >>> 16);
                data[reference3] = (byte) (offset2 >>> 8);
                data[reference3 + 1] = (byte) offset2;
            }
        }
        return needUpdate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Label getFirst() {
        return this.frame == null ? this : this.frame.owner;
    }

    boolean inSubroutine(long id) {
        return ((this.status & 1024) == 0 || (this.srcAndRefPositions[(int) (id >>> 32)] & ((int) id)) == 0) ? false : true;
    }

    boolean inSameSubroutine(Label block) {
        if ((this.status & 1024) == 0 || (block.status & 1024) == 0) {
            return false;
        }
        for (int i = 0; i < this.srcAndRefPositions.length; i++) {
            if ((this.srcAndRefPositions[i] & block.srcAndRefPositions[i]) != 0) {
                return true;
            }
        }
        return false;
    }

    void addToSubroutine(long id, int nbSubroutines) {
        if ((this.status & 1024) == 0) {
            this.status |= 1024;
            this.srcAndRefPositions = new int[((nbSubroutines - 1) / 32) + 1];
        }
        int[] iArr = this.srcAndRefPositions;
        int i = (int) (id >>> 32);
        iArr[i] = iArr[i] | ((int) id);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void visitSubroutine(org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label r6, long r7, int r9) {
        /*
            r5 = this;
            r0 = r5
            r10 = r0
        L3:
            r0 = r10
            if (r0 == 0) goto Le3
            r0 = r10
            r11 = r0
            r0 = r11
            org.jacoco.agent.rt.internal_b0d6a23.asm.Label r0 = r0.next
            r10 = r0
            r0 = r11
            r1 = 0
            r0.next = r1
            r0 = r6
            if (r0 == 0) goto L81
            r0 = r11
            int r0 = r0.status
            r1 = 2048(0x800, float:2.87E-42)
            r0 = r0 & r1
            if (r0 == 0) goto L2c
            goto L3
        L2c:
            r0 = r11
            r1 = r0
            int r1 = r1.status
            r2 = 2048(0x800, float:2.87E-42)
            r1 = r1 | r2
            r0.status = r1
            r0 = r11
            int r0 = r0.status
            r1 = 256(0x100, float:3.59E-43)
            r0 = r0 & r1
            if (r0 == 0) goto L95
            r0 = r11
            r1 = r6
            boolean r0 = r0.inSameSubroutine(r1)
            if (r0 != 0) goto L95
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r0 = new org.jacoco.agent.rt.internal_b0d6a23.asm.Edge
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r12
            r1 = r11
            int r1 = r1.inputStackTop
            r0.info = r1
            r0 = r12
            r1 = r6
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r1 = r1.successors
            org.jacoco.agent.rt.internal_b0d6a23.asm.Label r1 = r1.successor
            r0.successor = r1
            r0 = r12
            r1 = r11
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r1 = r1.successors
            r0.next = r1
            r0 = r11
            r1 = r12
            r0.successors = r1
            goto L95
        L81:
            r0 = r11
            r1 = r7
            boolean r0 = r0.inSubroutine(r1)
            if (r0 == 0) goto L8d
            goto L3
        L8d:
            r0 = r11
            r1 = r7
            r2 = r9
            r0.addToSubroutine(r1, r2)
        L95:
            r0 = r11
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r0 = r0.successors
            r12 = r0
        L9c:
            r0 = r12
            if (r0 == 0) goto Le0
            r0 = r11
            int r0 = r0.status
            r1 = 128(0x80, float:1.8E-43)
            r0 = r0 & r1
            if (r0 == 0) goto Lba
            r0 = r12
            r1 = r11
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r1 = r1.successors
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r1 = r1.next
            if (r0 == r1) goto Ld6
        Lba:
            r0 = r12
            org.jacoco.agent.rt.internal_b0d6a23.asm.Label r0 = r0.successor
            org.jacoco.agent.rt.internal_b0d6a23.asm.Label r0 = r0.next
            if (r0 != 0) goto Ld6
            r0 = r12
            org.jacoco.agent.rt.internal_b0d6a23.asm.Label r0 = r0.successor
            r1 = r10
            r0.next = r1
            r0 = r12
            org.jacoco.agent.rt.internal_b0d6a23.asm.Label r0 = r0.successor
            r10 = r0
        Ld6:
            r0 = r12
            org.jacoco.agent.rt.internal_b0d6a23.asm.Edge r0 = r0.next
            r12 = r0
            goto L9c
        Le0:
            goto L3
        Le3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label.visitSubroutine(org.jacoco.agent.rt.internal_b0d6a23.asm.Label, long, int):void");
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
