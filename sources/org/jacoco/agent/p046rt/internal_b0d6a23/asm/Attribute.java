package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.Attribute */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/Attribute.class */
public class Attribute {
    public final String type;
    byte[] value;
    Attribute next;

    /* JADX INFO: Access modifiers changed from: protected */
    public Attribute(String type) {
        this.type = type;
    }

    public boolean isUnknown() {
        return true;
    }

    public boolean isCodeAttribute() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Label[] getLabels() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Attribute read(ClassReader cr, int off, int len, char[] buf, int codeOff, Label[] labels) {
        Attribute attr = new Attribute(this.type);
        attr.value = new byte[len];
        System.arraycopy(cr.f10696b, off, attr.value, 0, len);
        return attr;
    }

    protected ByteVector write(ClassWriter cw, byte[] code, int len, int maxStack, int maxLocals) {
        ByteVector v = new ByteVector();
        v.data = this.value;
        v.length = this.value.length;
        return v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getCount() {
        int count = 0;
        Attribute attribute = this;
        while (true) {
            Attribute attr = attribute;
            if (attr != null) {
                count++;
                attribute = attr.next;
            } else {
                return count;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getSize(ClassWriter cw, byte[] code, int len, int maxStack, int maxLocals) {
        int size = 0;
        for (Attribute attr = this; attr != null; attr = attr.next) {
            cw.newUTF8(attr.type);
            size += attr.write(cw, code, len, maxStack, maxLocals).length + 6;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void put(ClassWriter cw, byte[] code, int len, int maxStack, int maxLocals, ByteVector out) {
        Attribute attribute = this;
        while (true) {
            Attribute attr = attribute;
            if (attr != null) {
                ByteVector b = attr.write(cw, code, len, maxStack, maxLocals);
                out.putShort(cw.newUTF8(attr.type)).putInt(b.length);
                out.putByteArray(b.data, 0, b.length);
                attribute = attr.next;
            } else {
                return;
            }
        }
    }
}
