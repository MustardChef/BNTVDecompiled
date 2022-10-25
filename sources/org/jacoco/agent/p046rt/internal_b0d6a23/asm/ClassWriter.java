package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.ContentTypeDetector;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.ClassWriter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/ClassWriter.class */
public class ClassWriter extends ClassVisitor {
    public static final int COMPUTE_MAXS = 1;
    public static final int COMPUTE_FRAMES = 2;
    static final int ACC_SYNTHETIC_ATTRIBUTE = 262144;
    static final int TO_ACC_SYNTHETIC = 64;
    static final int NOARG_INSN = 0;
    static final int SBYTE_INSN = 1;
    static final int SHORT_INSN = 2;
    static final int VAR_INSN = 3;
    static final int IMPLVAR_INSN = 4;
    static final int TYPE_INSN = 5;
    static final int FIELDORMETH_INSN = 6;
    static final int ITFMETH_INSN = 7;
    static final int INDYMETH_INSN = 8;
    static final int LABEL_INSN = 9;
    static final int LABELW_INSN = 10;
    static final int LDC_INSN = 11;
    static final int LDCW_INSN = 12;
    static final int IINC_INSN = 13;
    static final int TABL_INSN = 14;
    static final int LOOK_INSN = 15;
    static final int MANA_INSN = 16;
    static final int WIDE_INSN = 17;
    static final byte[] TYPE;
    static final int CLASS = 7;
    static final int FIELD = 9;
    static final int METH = 10;
    static final int IMETH = 11;
    static final int STR = 8;
    static final int INT = 3;
    static final int FLOAT = 4;
    static final int LONG = 5;
    static final int DOUBLE = 6;
    static final int NAME_TYPE = 12;
    static final int UTF8 = 1;
    static final int MTYPE = 16;
    static final int HANDLE = 15;
    static final int INDY = 18;
    static final int HANDLE_BASE = 20;
    static final int TYPE_NORMAL = 30;
    static final int TYPE_UNINIT = 31;
    static final int TYPE_MERGED = 32;
    static final int BSM = 33;

    /* renamed from: cr */
    ClassReader f10698cr;
    int version;
    int index;
    final ByteVector pool;
    Item[] items;
    int threshold;
    final Item key;
    final Item key2;
    final Item key3;
    final Item key4;
    Item[] typeTable;
    private short typeCount;
    private int access;
    private int name;
    String thisName;
    private int signature;
    private int superName;
    private int interfaceCount;
    private int[] interfaces;
    private int sourceFile;
    private ByteVector sourceDebug;
    private int enclosingMethodOwner;
    private int enclosingMethod;
    private AnnotationWriter anns;
    private AnnotationWriter ianns;
    private AnnotationWriter tanns;
    private AnnotationWriter itanns;
    private Attribute attrs;
    private int innerClassesCount;
    private ByteVector innerClasses;
    int bootstrapMethodsCount;
    ByteVector bootstrapMethods;
    FieldWriter firstField;
    FieldWriter lastField;
    MethodWriter firstMethod;
    MethodWriter lastMethod;
    private boolean computeMaxs;
    private boolean computeFrames;
    boolean invalidFrames;

    static {
        byte[] b = new byte[bqk.f6558bR];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) ("AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKJJJJJJJJJJJJJJJJJJ".charAt(i) - 'A');
        }
        TYPE = b;
    }

    public ClassWriter(int flags) {
        super(327680);
        this.index = 1;
        this.pool = new ByteVector();
        this.items = new Item[256];
        this.threshold = (int) (0.75d * this.items.length);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
        this.key4 = new Item();
        this.computeMaxs = (flags & 1) != 0;
        this.computeFrames = (flags & 2) != 0;
    }

    public ClassWriter(ClassReader classReader, int flags) {
        this(flags);
        classReader.copyPool(this);
        this.f10698cr = classReader;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.version = version;
        this.access = access;
        this.name = newClass(name);
        this.thisName = name;
        if (signature != null) {
            this.signature = newUTF8(signature);
        }
        this.superName = superName == null ? 0 : newClass(superName);
        if (interfaces != null && interfaces.length > 0) {
            this.interfaceCount = interfaces.length;
            this.interfaces = new int[this.interfaceCount];
            for (int i = 0; i < this.interfaceCount; i++) {
                this.interfaces[i] = newClass(interfaces[i]);
            }
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final void visitSource(String file, String debug) {
        if (file != null) {
            this.sourceFile = newUTF8(file);
        }
        if (debug != null) {
            this.sourceDebug = new ByteVector().encodeUTF8(debug, 0, Integer.MAX_VALUE);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final void visitOuterClass(String owner, String name, String desc) {
        this.enclosingMethodOwner = newClass(owner);
        if (name != null && desc != null) {
            this.enclosingMethod = newNameType(name, desc);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        ByteVector bv = new ByteVector();
        bv.putShort(newUTF8(desc)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this, true, bv, bv, 2);
        if (visible) {
            aw.next = this.anns;
            this.anns = aw;
        } else {
            aw.next = this.ianns;
            this.ianns = aw;
        }
        return aw;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        ByteVector bv = new ByteVector();
        AnnotationWriter.putTarget(typeRef, typePath, bv);
        bv.putShort(newUTF8(desc)).putShort(0);
        AnnotationWriter aw = new AnnotationWriter(this, true, bv, bv, bv.length - 2);
        if (visible) {
            aw.next = this.tanns;
            this.tanns = aw;
        } else {
            aw.next = this.itanns;
            this.itanns = aw;
        }
        return aw;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final void visitAttribute(Attribute attr) {
        attr.next = this.attrs;
        this.attrs = attr;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final void visitInnerClass(String name, String outerName, String innerName, int access) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        Item nameItem = newClassItem(name);
        if (nameItem.intVal == 0) {
            this.innerClassesCount++;
            this.innerClasses.putShort(nameItem.index);
            this.innerClasses.putShort(outerName == null ? 0 : newClass(outerName));
            this.innerClasses.putShort(innerName == null ? 0 : newUTF8(innerName));
            this.innerClasses.putShort(access);
            nameItem.intVal = this.innerClassesCount;
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return new FieldWriter(this, access, name, desc, signature, value);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new MethodWriter(this, access, name, desc, signature, exceptions, this.computeMaxs, this.computeFrames);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final void visitEnd() {
    }

    public byte[] toByteArray() {
        if (this.index > 65535) {
            throw new RuntimeException("Class file too large!");
        }
        int size = 24 + (2 * this.interfaceCount);
        int nbFields = 0;
        FieldWriter fieldWriter = this.firstField;
        while (true) {
            FieldWriter fb = fieldWriter;
            if (fb == null) {
                break;
            }
            nbFields++;
            size += fb.getSize();
            fieldWriter = (FieldWriter) fb.f10699fv;
        }
        int nbMethods = 0;
        MethodWriter methodWriter = this.firstMethod;
        while (true) {
            MethodWriter mb = methodWriter;
            if (mb == null) {
                break;
            }
            nbMethods++;
            size += mb.getSize();
            methodWriter = (MethodWriter) mb.f10701mv;
        }
        int attributeCount = 0;
        if (this.bootstrapMethods != null) {
            attributeCount = 0 + 1;
            size += 8 + this.bootstrapMethods.length;
            newUTF8("BootstrapMethods");
        }
        if (this.signature != 0) {
            attributeCount++;
            size += 8;
            newUTF8("Signature");
        }
        if (this.sourceFile != 0) {
            attributeCount++;
            size += 8;
            newUTF8("SourceFile");
        }
        if (this.sourceDebug != null) {
            attributeCount++;
            size += this.sourceDebug.length + 6;
            newUTF8("SourceDebugExtension");
        }
        if (this.enclosingMethodOwner != 0) {
            attributeCount++;
            size += 10;
            newUTF8("EnclosingMethod");
        }
        if ((this.access & 131072) != 0) {
            attributeCount++;
            size += 6;
            newUTF8("Deprecated");
        }
        if ((this.access & 4096) != 0 && ((this.version & 65535) < 49 || (this.access & 262144) != 0)) {
            attributeCount++;
            size += 6;
            newUTF8("Synthetic");
        }
        if (this.innerClasses != null) {
            attributeCount++;
            size += 8 + this.innerClasses.length;
            newUTF8("InnerClasses");
        }
        if (this.anns != null) {
            attributeCount++;
            size += 8 + this.anns.getSize();
            newUTF8("RuntimeVisibleAnnotations");
        }
        if (this.ianns != null) {
            attributeCount++;
            size += 8 + this.ianns.getSize();
            newUTF8("RuntimeInvisibleAnnotations");
        }
        if (this.tanns != null) {
            attributeCount++;
            size += 8 + this.tanns.getSize();
            newUTF8("RuntimeVisibleTypeAnnotations");
        }
        if (this.itanns != null) {
            attributeCount++;
            size += 8 + this.itanns.getSize();
            newUTF8("RuntimeInvisibleTypeAnnotations");
        }
        if (this.attrs != null) {
            attributeCount += this.attrs.getCount();
            size += this.attrs.getSize(this, null, 0, -1, -1);
        }
        ByteVector out = new ByteVector(size + this.pool.length);
        out.putInt(ContentTypeDetector.CLASSFILE).putInt(this.version);
        out.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
        int mask = 393216 | ((this.access & 262144) / 64);
        out.putShort(this.access & (mask ^ (-1))).putShort(this.name).putShort(this.superName);
        out.putShort(this.interfaceCount);
        for (int i = 0; i < this.interfaceCount; i++) {
            out.putShort(this.interfaces[i]);
        }
        out.putShort(nbFields);
        FieldWriter fieldWriter2 = this.firstField;
        while (true) {
            FieldWriter fb2 = fieldWriter2;
            if (fb2 == null) {
                break;
            }
            fb2.put(out);
            fieldWriter2 = (FieldWriter) fb2.f10699fv;
        }
        out.putShort(nbMethods);
        MethodWriter methodWriter2 = this.firstMethod;
        while (true) {
            MethodWriter mb2 = methodWriter2;
            if (mb2 == null) {
                break;
            }
            mb2.put(out);
            methodWriter2 = (MethodWriter) mb2.f10701mv;
        }
        out.putShort(attributeCount);
        if (this.bootstrapMethods != null) {
            out.putShort(newUTF8("BootstrapMethods"));
            out.putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodsCount);
            out.putByteArray(this.bootstrapMethods.data, 0, this.bootstrapMethods.length);
        }
        if (this.signature != 0) {
            out.putShort(newUTF8("Signature")).putInt(2).putShort(this.signature);
        }
        if (this.sourceFile != 0) {
            out.putShort(newUTF8("SourceFile")).putInt(2).putShort(this.sourceFile);
        }
        if (this.sourceDebug != null) {
            int len = this.sourceDebug.length;
            out.putShort(newUTF8("SourceDebugExtension")).putInt(len);
            out.putByteArray(this.sourceDebug.data, 0, len);
        }
        if (this.enclosingMethodOwner != 0) {
            out.putShort(newUTF8("EnclosingMethod")).putInt(4);
            out.putShort(this.enclosingMethodOwner).putShort(this.enclosingMethod);
        }
        if ((this.access & 131072) != 0) {
            out.putShort(newUTF8("Deprecated")).putInt(0);
        }
        if ((this.access & 4096) != 0 && ((this.version & 65535) < 49 || (this.access & 262144) != 0)) {
            out.putShort(newUTF8("Synthetic")).putInt(0);
        }
        if (this.innerClasses != null) {
            out.putShort(newUTF8("InnerClasses"));
            out.putInt(this.innerClasses.length + 2).putShort(this.innerClassesCount);
            out.putByteArray(this.innerClasses.data, 0, this.innerClasses.length);
        }
        if (this.anns != null) {
            out.putShort(newUTF8("RuntimeVisibleAnnotations"));
            this.anns.put(out);
        }
        if (this.ianns != null) {
            out.putShort(newUTF8("RuntimeInvisibleAnnotations"));
            this.ianns.put(out);
        }
        if (this.tanns != null) {
            out.putShort(newUTF8("RuntimeVisibleTypeAnnotations"));
            this.tanns.put(out);
        }
        if (this.itanns != null) {
            out.putShort(newUTF8("RuntimeInvisibleTypeAnnotations"));
            this.itanns.put(out);
        }
        if (this.attrs != null) {
            this.attrs.put(this, null, 0, -1, -1, out);
        }
        if (this.invalidFrames) {
            this.anns = null;
            this.ianns = null;
            this.attrs = null;
            this.innerClassesCount = 0;
            this.innerClasses = null;
            this.bootstrapMethodsCount = 0;
            this.bootstrapMethods = null;
            this.firstField = null;
            this.lastField = null;
            this.firstMethod = null;
            this.lastMethod = null;
            this.computeMaxs = false;
            this.computeFrames = true;
            this.invalidFrames = false;
            new ClassReader(out.data).accept(this, 4);
            return toByteArray();
        }
        return out.data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newConstItem(Object cst) {
        if (cst instanceof Integer) {
            int val = ((Integer) cst).intValue();
            return newInteger(val);
        } else if (cst instanceof Byte) {
            int val2 = ((Byte) cst).intValue();
            return newInteger(val2);
        } else if (cst instanceof Character) {
            int val3 = ((Character) cst).charValue();
            return newInteger(val3);
        } else if (cst instanceof Short) {
            int val4 = ((Short) cst).intValue();
            return newInteger(val4);
        } else if (cst instanceof Boolean) {
            int val5 = ((Boolean) cst).booleanValue() ? 1 : 0;
            return newInteger(val5);
        } else if (cst instanceof Float) {
            float val6 = ((Float) cst).floatValue();
            return newFloat(val6);
        } else if (cst instanceof Long) {
            long val7 = ((Long) cst).longValue();
            return newLong(val7);
        } else if (cst instanceof Double) {
            double val8 = ((Double) cst).doubleValue();
            return newDouble(val8);
        } else if (cst instanceof String) {
            return newString((String) cst);
        } else {
            if (cst instanceof Type) {
                Type t = (Type) cst;
                int s = t.getSort();
                if (s == 10) {
                    return newClassItem(t.getInternalName());
                }
                if (s == 11) {
                    return newMethodTypeItem(t.getDescriptor());
                }
                return newClassItem(t.getDescriptor());
            } else if (cst instanceof Handle) {
                Handle h = (Handle) cst;
                return newHandleItem(h.tag, h.owner, h.name, h.desc);
            } else {
                throw new IllegalArgumentException("value " + cst);
            }
        }
    }

    public int newConst(Object cst) {
        return newConstItem(cst).index;
    }

    public int newUTF8(String value) {
        this.key.set(1, value, null, null);
        Item result = get(this.key);
        if (result == null) {
            this.pool.putByte(1).putUTF8(value);
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key);
            put(result);
        }
        return result.index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newClassItem(String value) {
        this.key2.set(7, value, null, null);
        Item result = get(this.key2);
        if (result == null) {
            this.pool.put12(7, newUTF8(value));
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key2);
            put(result);
        }
        return result;
    }

    public int newClass(String value) {
        return newClassItem(value).index;
    }

    Item newMethodTypeItem(String methodDesc) {
        this.key2.set(16, methodDesc, null, null);
        Item result = get(this.key2);
        if (result == null) {
            this.pool.put12(16, newUTF8(methodDesc));
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key2);
            put(result);
        }
        return result;
    }

    public int newMethodType(String methodDesc) {
        return newMethodTypeItem(methodDesc).index;
    }

    Item newHandleItem(int tag, String owner, String name, String desc) {
        this.key4.set(20 + tag, owner, name, desc);
        Item result = get(this.key4);
        if (result == null) {
            if (tag <= 4) {
                put112(15, tag, newField(owner, name, desc));
            } else {
                put112(15, tag, newMethod(owner, name, desc, tag == 9));
            }
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key4);
            put(result);
        }
        return result;
    }

    public int newHandle(int tag, String owner, String name, String desc) {
        return newHandleItem(tag, owner, name, desc).index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newInvokeDynamicItem(String name, String desc, Handle bsm, Object... bsmArgs) {
        Item result;
        int bootstrapMethodIndex;
        ByteVector bootstrapMethods = this.bootstrapMethods;
        if (bootstrapMethods == null) {
            ByteVector byteVector = new ByteVector();
            this.bootstrapMethods = byteVector;
            bootstrapMethods = byteVector;
        }
        int position = bootstrapMethods.length;
        int hashCode = bsm.hashCode();
        bootstrapMethods.putShort(newHandle(bsm.tag, bsm.owner, bsm.name, bsm.desc));
        int argsLength = bsmArgs.length;
        bootstrapMethods.putShort(argsLength);
        for (Object bsmArg : bsmArgs) {
            hashCode ^= bsmArg.hashCode();
            bootstrapMethods.putShort(newConst(bsmArg));
        }
        byte[] data = bootstrapMethods.data;
        int length = (2 + argsLength) << 1;
        int hashCode2 = hashCode & Integer.MAX_VALUE;
        Item item = this.items[hashCode2 % this.items.length];
        loop1: while (true) {
            result = item;
            if (result == null) {
                break;
            } else if (result.type != 33 || result.hashCode != hashCode2) {
                item = result.next;
            } else {
                int resultPosition = result.intVal;
                for (int p = 0; p < length; p++) {
                    if (data[position + p] != data[resultPosition + p]) {
                        item = result.next;
                    }
                }
                break loop1;
            }
        }
        if (result != null) {
            bootstrapMethodIndex = result.index;
            bootstrapMethods.length = position;
        } else {
            int i = this.bootstrapMethodsCount;
            this.bootstrapMethodsCount = i + 1;
            bootstrapMethodIndex = i;
            Item result2 = new Item(bootstrapMethodIndex);
            result2.set(position, hashCode2);
            put(result2);
        }
        this.key3.set(name, desc, bootstrapMethodIndex);
        Item result3 = get(this.key3);
        if (result3 == null) {
            put122(18, bootstrapMethodIndex, newNameType(name, desc));
            int i2 = this.index;
            this.index = i2 + 1;
            result3 = new Item(i2, this.key3);
            put(result3);
        }
        return result3;
    }

    public int newInvokeDynamic(String name, String desc, Handle bsm, Object... bsmArgs) {
        return newInvokeDynamicItem(name, desc, bsm, bsmArgs).index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newFieldItem(String owner, String name, String desc) {
        this.key3.set(9, owner, name, desc);
        Item result = get(this.key3);
        if (result == null) {
            put122(9, newClass(owner), newNameType(name, desc));
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key3);
            put(result);
        }
        return result;
    }

    public int newField(String owner, String name, String desc) {
        return newFieldItem(owner, name, desc).index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newMethodItem(String owner, String name, String desc, boolean itf) {
        int type = itf ? 11 : 10;
        this.key3.set(type, owner, name, desc);
        Item result = get(this.key3);
        if (result == null) {
            put122(type, newClass(owner), newNameType(name, desc));
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key3);
            put(result);
        }
        return result;
    }

    public int newMethod(String owner, String name, String desc, boolean itf) {
        return newMethodItem(owner, name, desc, itf).index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newInteger(int value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result == null) {
            this.pool.putByte(3).putInt(value);
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key);
            put(result);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newFloat(float value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result == null) {
            this.pool.putByte(4).putInt(this.key.intVal);
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key);
            put(result);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newLong(long value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result == null) {
            this.pool.putByte(5).putLong(value);
            result = new Item(this.index, this.key);
            this.index += 2;
            put(result);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Item newDouble(double value) {
        this.key.set(value);
        Item result = get(this.key);
        if (result == null) {
            this.pool.putByte(6).putLong(this.key.longVal);
            result = new Item(this.index, this.key);
            this.index += 2;
            put(result);
        }
        return result;
    }

    private Item newString(String value) {
        this.key2.set(8, value, null, null);
        Item result = get(this.key2);
        if (result == null) {
            this.pool.put12(8, newUTF8(value));
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key2);
            put(result);
        }
        return result;
    }

    public int newNameType(String name, String desc) {
        return newNameTypeItem(name, desc).index;
    }

    Item newNameTypeItem(String name, String desc) {
        this.key2.set(12, name, desc, null);
        Item result = get(this.key2);
        if (result == null) {
            put122(12, newUTF8(name), newUTF8(desc));
            int i = this.index;
            this.index = i + 1;
            result = new Item(i, this.key2);
            put(result);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addType(String type) {
        this.key.set(30, type, null, null);
        Item result = get(this.key);
        if (result == null) {
            result = addType(this.key);
        }
        return result.index;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addUninitializedType(String type, int offset) {
        this.key.type = 31;
        this.key.intVal = offset;
        this.key.strVal1 = type;
        this.key.hashCode = Integer.MAX_VALUE & (31 + type.hashCode() + offset);
        Item result = get(this.key);
        if (result == null) {
            result = addType(this.key);
        }
        return result.index;
    }

    private Item addType(Item item) {
        this.typeCount = (short) (this.typeCount + 1);
        Item result = new Item(this.typeCount, this.key);
        put(result);
        if (this.typeTable == null) {
            this.typeTable = new Item[16];
        }
        if (this.typeCount == this.typeTable.length) {
            Item[] newTable = new Item[2 * this.typeTable.length];
            System.arraycopy(this.typeTable, 0, newTable, 0, this.typeTable.length);
            this.typeTable = newTable;
        }
        this.typeTable[this.typeCount] = result;
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMergedType(int type1, int type2) {
        this.key2.type = 32;
        this.key2.longVal = type1 | (type2 << 32);
        this.key2.hashCode = Integer.MAX_VALUE & (32 + type1 + type2);
        Item result = get(this.key2);
        if (result == null) {
            String t = this.typeTable[type1].strVal1;
            String u = this.typeTable[type2].strVal1;
            this.key2.intVal = addType(getCommonSuperClass(t, u));
            result = new Item(0, this.key2);
            put(result);
        }
        return result.intVal;
    }

    protected String getCommonSuperClass(String type1, String type2) {
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> c = Class.forName(type1.replace(JsonPointer.SEPARATOR, '.'), false, classLoader);
            Class<?> d = Class.forName(type2.replace(JsonPointer.SEPARATOR, '.'), false, classLoader);
            if (c.isAssignableFrom(d)) {
                return type1;
            }
            if (d.isAssignableFrom(c)) {
                return type2;
            }
            if (c.isInterface() || d.isInterface()) {
                return "java/lang/Object";
            }
            do {
                c = c.getSuperclass();
            } while (!c.isAssignableFrom(d));
            return c.getName().replace('.', JsonPointer.SEPARATOR);
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    private Item get(Item key) {
        Item i;
        Item item = this.items[key.hashCode % this.items.length];
        while (true) {
            i = item;
            if (i == null || (i.type == key.type && key.isEqualTo(i))) {
                break;
            }
            item = i.next;
        }
        return i;
    }

    private void put(Item i) {
        if (this.index + this.typeCount > this.threshold) {
            int ll = this.items.length;
            int nl = (ll * 2) + 1;
            Item[] newItems = new Item[nl];
            for (int l = ll - 1; l >= 0; l--) {
                Item item = this.items[l];
                while (true) {
                    Item j = item;
                    if (j != null) {
                        int index = j.hashCode % newItems.length;
                        Item k = j.next;
                        j.next = newItems[index];
                        newItems[index] = j;
                        item = k;
                    }
                }
            }
            this.items = newItems;
            this.threshold = (int) (nl * 0.75d);
        }
        int index2 = i.hashCode % this.items.length;
        i.next = this.items[index2];
        this.items[index2] = i;
    }

    private void put122(int b, int s1, int s2) {
        this.pool.put12(b, s1).putShort(s2);
    }

    private void put112(int b1, int b2, int s) {
        this.pool.put11(b1, b2).putShort(s);
    }
}
