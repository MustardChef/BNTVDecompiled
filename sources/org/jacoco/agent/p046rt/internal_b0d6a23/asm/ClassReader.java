package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.ClassReader */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/ClassReader.class */
public class ClassReader {
    static final boolean SIGNATURES = true;
    static final boolean ANNOTATIONS = true;
    static final boolean FRAMES = true;
    static final boolean WRITER = true;
    static final boolean RESIZE = true;
    public static final int SKIP_CODE = 1;
    public static final int SKIP_DEBUG = 2;
    public static final int SKIP_FRAMES = 4;
    public static final int EXPAND_FRAMES = 8;

    /* renamed from: b */
    public final byte[] f10696b;
    private final int[] items;
    private final String[] strings;
    private final int maxStringLength;
    public final int header;

    public ClassReader(byte[] b) {
        this(b, 0, b.length);
    }

    public ClassReader(byte[] b, int off, int len) {
        int size;
        this.f10696b = b;
        if (readShort(off + 6) > 52) {
            throw new IllegalArgumentException();
        }
        this.items = new int[readUnsignedShort(off + 8)];
        int n = this.items.length;
        this.strings = new String[n];
        int max = 0;
        int index = off + 10;
        int i = 1;
        while (i < n) {
            this.items[i] = index + 1;
            switch (b[index]) {
                case 1:
                    size = 3 + readUnsignedShort(index + 1);
                    if (size <= max) {
                        break;
                    } else {
                        max = size;
                        break;
                    }
                case 2:
                case 7:
                case 8:
                case 13:
                case 14:
                case 16:
                case 17:
                default:
                    size = 3;
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 18:
                    size = 5;
                    break;
                case 5:
                case 6:
                    size = 9;
                    i++;
                    break;
                case 15:
                    size = 4;
                    break;
            }
            index += size;
            i++;
        }
        this.maxStringLength = max;
        this.header = index;
    }

    public int getAccess() {
        return readUnsignedShort(this.header);
    }

    public String getClassName() {
        return readClass(this.header + 2, new char[this.maxStringLength]);
    }

    public String getSuperName() {
        return readClass(this.header + 4, new char[this.maxStringLength]);
    }

    public String[] getInterfaces() {
        int index = this.header + 6;
        int n = readUnsignedShort(index);
        String[] interfaces = new String[n];
        if (n > 0) {
            char[] buf = new char[this.maxStringLength];
            for (int i = 0; i < n; i++) {
                index += 2;
                interfaces[i] = readClass(index, buf);
            }
        }
        return interfaces;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyPool(ClassWriter classWriter) {
        char[] buf = new char[this.maxStringLength];
        int ll = this.items.length;
        Item[] items2 = new Item[ll];
        int i = 1;
        while (i < ll) {
            int index = this.items[i];
            byte b = this.f10696b[index - 1];
            Item item = new Item(i);
            switch (b) {
                case 1:
                    String s = this.strings[i];
                    if (s == null) {
                        int index2 = this.items[i];
                        String readUTF = readUTF(index2 + 2, readUnsignedShort(index2), buf);
                        this.strings[i] = readUTF;
                        s = readUTF;
                    }
                    item.set(b, s, null, null);
                    break;
                case 2:
                case 7:
                case 8:
                case 13:
                case 14:
                case 16:
                case 17:
                default:
                    item.set(b, readUTF8(index, buf), null, null);
                    break;
                case 3:
                    item.set(readInt(index));
                    break;
                case 4:
                    item.set(Float.intBitsToFloat(readInt(index)));
                    break;
                case 5:
                    item.set(readLong(index));
                    i++;
                    break;
                case 6:
                    item.set(Double.longBitsToDouble(readLong(index)));
                    i++;
                    break;
                case 9:
                case 10:
                case 11:
                    int nameType = this.items[readUnsignedShort(index + 2)];
                    item.set(b, readClass(index, buf), readUTF8(nameType, buf), readUTF8(nameType + 2, buf));
                    break;
                case 12:
                    item.set(b, readUTF8(index, buf), readUTF8(index + 2, buf), null);
                    break;
                case 15:
                    int fieldOrMethodRef = this.items[readUnsignedShort(index + 1)];
                    int nameType2 = this.items[readUnsignedShort(fieldOrMethodRef + 2)];
                    item.set(20 + readByte(index), readClass(fieldOrMethodRef, buf), readUTF8(nameType2, buf), readUTF8(nameType2 + 2, buf));
                    break;
                case 18:
                    if (classWriter.bootstrapMethods == null) {
                        copyBootstrapMethods(classWriter, items2, buf);
                    }
                    int nameType3 = this.items[readUnsignedShort(index + 2)];
                    item.set(readUTF8(nameType3, buf), readUTF8(nameType3 + 2, buf), readUnsignedShort(index));
                    break;
            }
            int index22 = item.hashCode % items2.length;
            item.next = items2[index22];
            items2[index22] = item;
            i++;
        }
        int off = this.items[1] - 1;
        classWriter.pool.putByteArray(this.f10696b, off, this.header - off);
        classWriter.items = items2;
        classWriter.threshold = (int) (0.75d * ll);
        classWriter.index = ll;
    }

    private void copyBootstrapMethods(ClassWriter classWriter, Item[] items, char[] c) {
        int u = getAttributes();
        boolean found = false;
        int i = readUnsignedShort(u);
        while (true) {
            if (i <= 0) {
                break;
            }
            String attrName = readUTF8(u + 2, c);
            if ("BootstrapMethods".equals(attrName)) {
                found = true;
                break;
            } else {
                u += 6 + readInt(u + 4);
                i--;
            }
        }
        if (!found) {
            return;
        }
        int boostrapMethodCount = readUnsignedShort(u + 8);
        int v = u + 10;
        for (int j = 0; j < boostrapMethodCount; j++) {
            int position = (v - u) - 10;
            int hashCode = readConst(readUnsignedShort(v), c).hashCode();
            for (int k = readUnsignedShort(v + 2); k > 0; k--) {
                hashCode ^= readConst(readUnsignedShort(v + 4), c).hashCode();
                v += 2;
            }
            v += 4;
            Item item = new Item(j);
            item.set(position, hashCode & Integer.MAX_VALUE);
            int index = item.hashCode % items.length;
            item.next = items[index];
            items[index] = item;
        }
        int attrSize = readInt(u + 4);
        ByteVector bootstrapMethods = new ByteVector(attrSize + 62);
        bootstrapMethods.putByteArray(this.f10696b, u + 10, attrSize - 2);
        classWriter.bootstrapMethodsCount = boostrapMethodCount;
        classWriter.bootstrapMethods = bootstrapMethods;
    }

    public ClassReader(InputStream is) throws IOException {
        this(readClass(is, false));
    }

    public ClassReader(String name) throws IOException {
        this(readClass(ClassLoader.getSystemResourceAsStream(name.replace('.', JsonPointer.SEPARATOR) + ".class"), true));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r9 >= r8.length) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002f, code lost:
        r0 = new byte[r9];
        java.lang.System.arraycopy(r8, 0, r0, 0, r9);
        r8 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] readClass(java.io.InputStream r6, boolean r7) throws java.io.IOException {
        /*
            r0 = r6
            if (r0 != 0) goto Le
            java.io.IOException r0 = new java.io.IOException
            r1 = r0
            java.lang.String r2 = "Class not found"
            r1.<init>(r2)
            throw r0
        Le:
            r0 = r6
            int r0 = r0.available()     // Catch: java.lang.Throwable -> L95
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L95
            r8 = r0
            r0 = 0
            r9 = r0
        L17:
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r8
            int r3 = r3.length     // Catch: java.lang.Throwable -> L95
            r4 = r9
            int r3 = r3 - r4
            int r0 = r0.read(r1, r2, r3)     // Catch: java.lang.Throwable -> L95
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 != r1) goto L4e
            r0 = r9
            r1 = r8
            int r1 = r1.length     // Catch: java.lang.Throwable -> L95
            if (r0 >= r1) goto L40
            r0 = r9
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L95
            r11 = r0
            r0 = r8
            r1 = 0
            r2 = r11
            r3 = 0
            r4 = r9
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L95
            r0 = r11
            r8 = r0
        L40:
            r0 = r8
            r11 = r0
            r0 = r7
            if (r0 == 0) goto L4b
            r0 = r6
            r0.close()
        L4b:
            r0 = r11
            return r0
        L4e:
            r0 = r9
            r1 = r10
            int r0 = r0 + r1
            r9 = r0
            r0 = r9
            r1 = r8
            int r1 = r1.length     // Catch: java.lang.Throwable -> L95
            if (r0 != r1) goto L92
            r0 = r6
            int r0 = r0.read()     // Catch: java.lang.Throwable -> L95
            r11 = r0
            r0 = r11
            if (r0 >= 0) goto L72
            r0 = r8
            r12 = r0
            r0 = r7
            if (r0 == 0) goto L6f
            r0 = r6
            r0.close()
        L6f:
            r0 = r12
            return r0
        L72:
            r0 = r8
            int r0 = r0.length     // Catch: java.lang.Throwable -> L95
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r0 + r1
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L95
            r12 = r0
            r0 = r8
            r1 = 0
            r2 = r12
            r3 = 0
            r4 = r9
            java.lang.System.arraycopy(r0, r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L95
            r0 = r12
            r1 = r9
            int r9 = r9 + 1
            r2 = r11
            byte r2 = (byte) r2     // Catch: java.lang.Throwable -> L95
            r0[r1] = r2     // Catch: java.lang.Throwable -> L95
            r0 = r12
            r8 = r0
        L92:
            goto L17
        L95:
            r13 = move-exception
            r0 = r7
            if (r0 == 0) goto L9f
            r0 = r6
            r0.close()
        L9f:
            r0 = r13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassReader.readClass(java.io.InputStream, boolean):byte[]");
    }

    public void accept(ClassVisitor classVisitor, int flags) {
        accept(classVisitor, new Attribute[0], flags);
    }

    public void accept(ClassVisitor classVisitor, Attribute[] attrs, int flags) {
        int u = this.header;
        char[] c = new char[this.maxStringLength];
        Context context = new Context();
        context.attrs = attrs;
        context.flags = flags;
        context.buffer = c;
        int access = readUnsignedShort(u);
        String name = readClass(u + 2, c);
        String superClass = readClass(u + 4, c);
        String[] interfaces = new String[readUnsignedShort(u + 6)];
        int u2 = u + 8;
        for (int i = 0; i < interfaces.length; i++) {
            interfaces[i] = readClass(u2, c);
            u2 += 2;
        }
        String signature = null;
        String sourceFile = null;
        String sourceDebug = null;
        String enclosingOwner = null;
        String enclosingName = null;
        String enclosingDesc = null;
        int anns = 0;
        int ianns = 0;
        int tanns = 0;
        int itanns = 0;
        int innerClasses = 0;
        Attribute attributes = null;
        int u3 = getAttributes();
        for (int i2 = readUnsignedShort(u3); i2 > 0; i2--) {
            String attrName = readUTF8(u3 + 2, c);
            if ("SourceFile".equals(attrName)) {
                sourceFile = readUTF8(u3 + 8, c);
            } else if ("InnerClasses".equals(attrName)) {
                innerClasses = u3 + 8;
            } else if ("EnclosingMethod".equals(attrName)) {
                enclosingOwner = readClass(u3 + 8, c);
                int item = readUnsignedShort(u3 + 10);
                if (item != 0) {
                    enclosingName = readUTF8(this.items[item], c);
                    enclosingDesc = readUTF8(this.items[item] + 2, c);
                }
            } else if ("Signature".equals(attrName)) {
                signature = readUTF8(u3 + 8, c);
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u3 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u3 + 8;
            } else if ("Deprecated".equals(attrName)) {
                access |= 131072;
            } else if ("Synthetic".equals(attrName)) {
                access |= 266240;
            } else if ("SourceDebugExtension".equals(attrName)) {
                int len = readInt(u3 + 4);
                sourceDebug = readUTF(u3 + 8, len, new char[len]);
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u3 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u3 + 8;
            } else if ("BootstrapMethods".equals(attrName)) {
                int[] bootstrapMethods = new int[readUnsignedShort(u3 + 8)];
                int v = u3 + 10;
                for (int j = 0; j < bootstrapMethods.length; j++) {
                    bootstrapMethods[j] = v;
                    v += (2 + readUnsignedShort(v + 2)) << 1;
                }
                context.bootstrapMethods = bootstrapMethods;
            } else {
                Attribute attr = readAttribute(attrs, attrName, u3 + 8, readInt(u3 + 4), c, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u3 += 6 + readInt(u3 + 4);
        }
        classVisitor.visit(readInt(this.items[1] - 7), access, name, signature, superClass, interfaces);
        if ((flags & 2) == 0 && (sourceFile != null || sourceDebug != null)) {
            classVisitor.visitSource(sourceFile, sourceDebug);
        }
        if (enclosingOwner != null) {
            classVisitor.visitOuterClass(enclosingOwner, enclosingName, enclosingDesc);
        }
        if (anns != 0) {
            int v2 = anns + 2;
            for (int i3 = readUnsignedShort(anns); i3 > 0; i3--) {
                v2 = readAnnotationValues(v2 + 2, c, true, classVisitor.visitAnnotation(readUTF8(v2, c), true));
            }
        }
        if (ianns != 0) {
            int v3 = ianns + 2;
            for (int i4 = readUnsignedShort(ianns); i4 > 0; i4--) {
                v3 = readAnnotationValues(v3 + 2, c, true, classVisitor.visitAnnotation(readUTF8(v3, c), false));
            }
        }
        if (tanns != 0) {
            int v4 = tanns + 2;
            for (int i5 = readUnsignedShort(tanns); i5 > 0; i5--) {
                int v5 = readAnnotationTarget(context, v4);
                v4 = readAnnotationValues(v5 + 2, c, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(v5, c), true));
            }
        }
        if (itanns != 0) {
            int v6 = itanns + 2;
            for (int i6 = readUnsignedShort(itanns); i6 > 0; i6--) {
                int v7 = readAnnotationTarget(context, v6);
                v6 = readAnnotationValues(v7 + 2, c, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(v7, c), false));
            }
        }
        while (attributes != null) {
            Attribute attr2 = attributes.next;
            attributes.next = null;
            classVisitor.visitAttribute(attributes);
            attributes = attr2;
        }
        if (innerClasses != 0) {
            int v8 = innerClasses + 2;
            for (int i7 = readUnsignedShort(innerClasses); i7 > 0; i7--) {
                classVisitor.visitInnerClass(readClass(v8, c), readClass(v8 + 2, c), readUTF8(v8 + 4, c), readUnsignedShort(v8 + 6));
                v8 += 8;
            }
        }
        int u4 = this.header + 10 + (2 * interfaces.length);
        for (int i8 = readUnsignedShort(u4 - 2); i8 > 0; i8--) {
            u4 = readField(classVisitor, context, u4);
        }
        int u5 = u4 + 2;
        for (int i9 = readUnsignedShort(u5 - 2); i9 > 0; i9--) {
            u5 = readMethod(classVisitor, context, u5);
        }
        classVisitor.visitEnd();
    }

    private int readField(ClassVisitor classVisitor, Context context, int u) {
        char[] c = context.buffer;
        int access = readUnsignedShort(u);
        String name = readUTF8(u + 2, c);
        String desc = readUTF8(u + 4, c);
        int u2 = u + 6;
        String signature = null;
        int anns = 0;
        int ianns = 0;
        int tanns = 0;
        int itanns = 0;
        Object value = null;
        Attribute attributes = null;
        for (int i = readUnsignedShort(u2); i > 0; i--) {
            String attrName = readUTF8(u2 + 2, c);
            if ("ConstantValue".equals(attrName)) {
                int item = readUnsignedShort(u2 + 8);
                value = item == 0 ? null : readConst(item, c);
            } else if ("Signature".equals(attrName)) {
                signature = readUTF8(u2 + 8, c);
            } else if ("Deprecated".equals(attrName)) {
                access |= 131072;
            } else if ("Synthetic".equals(attrName)) {
                access |= 266240;
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u2 + 8;
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u2 + 8;
            } else {
                Attribute attr = readAttribute(context.attrs, attrName, u2 + 8, readInt(u2 + 4), c, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u2 += 6 + readInt(u2 + 4);
        }
        int u3 = u2 + 2;
        FieldVisitor fv = classVisitor.visitField(access, name, desc, signature, value);
        if (fv == null) {
            return u3;
        }
        if (anns != 0) {
            int v = anns + 2;
            for (int i2 = readUnsignedShort(anns); i2 > 0; i2--) {
                v = readAnnotationValues(v + 2, c, true, fv.visitAnnotation(readUTF8(v, c), true));
            }
        }
        if (ianns != 0) {
            int v2 = ianns + 2;
            for (int i3 = readUnsignedShort(ianns); i3 > 0; i3--) {
                v2 = readAnnotationValues(v2 + 2, c, true, fv.visitAnnotation(readUTF8(v2, c), false));
            }
        }
        if (tanns != 0) {
            int v3 = tanns + 2;
            for (int i4 = readUnsignedShort(tanns); i4 > 0; i4--) {
                int v4 = readAnnotationTarget(context, v3);
                v3 = readAnnotationValues(v4 + 2, c, true, fv.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(v4, c), true));
            }
        }
        if (itanns != 0) {
            int v5 = itanns + 2;
            for (int i5 = readUnsignedShort(itanns); i5 > 0; i5--) {
                int v6 = readAnnotationTarget(context, v5);
                v5 = readAnnotationValues(v6 + 2, c, true, fv.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(v6, c), false));
            }
        }
        while (attributes != null) {
            Attribute attr2 = attributes.next;
            attributes.next = null;
            fv.visitAttribute(attributes);
            attributes = attr2;
        }
        fv.visitEnd();
        return u3;
    }

    private int readMethod(ClassVisitor classVisitor, Context context, int u) {
        char[] c = context.buffer;
        context.access = readUnsignedShort(u);
        context.name = readUTF8(u + 2, c);
        context.desc = readUTF8(u + 4, c);
        int u2 = u + 6;
        int code = 0;
        int exception = 0;
        String[] exceptions = null;
        String signature = null;
        int methodParameters = 0;
        int anns = 0;
        int ianns = 0;
        int tanns = 0;
        int itanns = 0;
        int dann = 0;
        int mpanns = 0;
        int impanns = 0;
        Attribute attributes = null;
        for (int i = readUnsignedShort(u2); i > 0; i--) {
            String attrName = readUTF8(u2 + 2, c);
            if ("Code".equals(attrName)) {
                if ((context.flags & 1) == 0) {
                    code = u2 + 8;
                }
            } else if ("Exceptions".equals(attrName)) {
                exceptions = new String[readUnsignedShort(u2 + 8)];
                exception = u2 + 10;
                for (int j = 0; j < exceptions.length; j++) {
                    exceptions[j] = readClass(exception, c);
                    exception += 2;
                }
            } else if ("Signature".equals(attrName)) {
                signature = readUTF8(u2 + 8, c);
            } else if ("Deprecated".equals(attrName)) {
                context.access |= 131072;
            } else if ("RuntimeVisibleAnnotations".equals(attrName)) {
                anns = u2 + 8;
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = u2 + 8;
            } else if ("AnnotationDefault".equals(attrName)) {
                dann = u2 + 8;
            } else if ("Synthetic".equals(attrName)) {
                context.access |= 266240;
            } else if ("RuntimeInvisibleAnnotations".equals(attrName)) {
                ianns = u2 + 8;
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = u2 + 8;
            } else if ("RuntimeVisibleParameterAnnotations".equals(attrName)) {
                mpanns = u2 + 8;
            } else if ("RuntimeInvisibleParameterAnnotations".equals(attrName)) {
                impanns = u2 + 8;
            } else if ("MethodParameters".equals(attrName)) {
                methodParameters = u2 + 8;
            } else {
                Attribute attr = readAttribute(context.attrs, attrName, u2 + 8, readInt(u2 + 4), c, -1, null);
                if (attr != null) {
                    attr.next = attributes;
                    attributes = attr;
                }
            }
            u2 += 6 + readInt(u2 + 4);
        }
        int u3 = u2 + 2;
        MethodVisitor mv = classVisitor.visitMethod(context.access, context.name, context.desc, signature, exceptions);
        if (mv == null) {
            return u3;
        }
        if (mv instanceof MethodWriter) {
            MethodWriter mw = (MethodWriter) mv;
            if (mw.f10702cw.f10698cr == this && signature == mw.signature) {
                boolean sameExceptions = false;
                if (exceptions == null) {
                    sameExceptions = mw.exceptionCount == 0;
                } else if (exceptions.length == mw.exceptionCount) {
                    sameExceptions = true;
                    int j2 = exceptions.length - 1;
                    while (true) {
                        if (j2 < 0) {
                            break;
                        }
                        exception -= 2;
                        if (mw.exceptions[j2] != readUnsignedShort(exception)) {
                            sameExceptions = false;
                            break;
                        }
                        j2--;
                    }
                }
                if (sameExceptions) {
                    mw.classReaderOffset = u2;
                    mw.classReaderLength = u3 - u2;
                    return u3;
                }
            }
        }
        if (methodParameters != 0) {
            int i2 = this.f10696b[methodParameters] & 255;
            int i3 = methodParameters;
            int i4 = 1;
            while (true) {
                int v = i3 + i4;
                if (i2 <= 0) {
                    break;
                }
                mv.visitParameter(readUTF8(v, c), readUnsignedShort(v + 2));
                i2--;
                i3 = v;
                i4 = 4;
            }
        }
        if (dann != 0) {
            AnnotationVisitor dv = mv.visitAnnotationDefault();
            readAnnotationValue(dann, c, null, dv);
            if (dv != null) {
                dv.visitEnd();
            }
        }
        if (anns != 0) {
            int v2 = anns + 2;
            for (int i5 = readUnsignedShort(anns); i5 > 0; i5--) {
                v2 = readAnnotationValues(v2 + 2, c, true, mv.visitAnnotation(readUTF8(v2, c), true));
            }
        }
        if (ianns != 0) {
            int v3 = ianns + 2;
            for (int i6 = readUnsignedShort(ianns); i6 > 0; i6--) {
                v3 = readAnnotationValues(v3 + 2, c, true, mv.visitAnnotation(readUTF8(v3, c), false));
            }
        }
        if (tanns != 0) {
            int v4 = tanns + 2;
            for (int i7 = readUnsignedShort(tanns); i7 > 0; i7--) {
                int v5 = readAnnotationTarget(context, v4);
                v4 = readAnnotationValues(v5 + 2, c, true, mv.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(v5, c), true));
            }
        }
        if (itanns != 0) {
            int v6 = itanns + 2;
            for (int i8 = readUnsignedShort(itanns); i8 > 0; i8--) {
                int v7 = readAnnotationTarget(context, v6);
                v6 = readAnnotationValues(v7 + 2, c, true, mv.visitTypeAnnotation(context.typeRef, context.typePath, readUTF8(v7, c), false));
            }
        }
        if (mpanns != 0) {
            readParameterAnnotations(mv, context, mpanns, true);
        }
        if (impanns != 0) {
            readParameterAnnotations(mv, context, impanns, false);
        }
        while (attributes != null) {
            Attribute attr2 = attributes.next;
            attributes.next = null;
            mv.visitAttribute(attributes);
            attributes = attr2;
        }
        if (code != 0) {
            mv.visitCode();
            readCode(mv, context, code);
        }
        mv.visitEnd();
        return u3;
    }

    private void readCode(MethodVisitor mv, Context context, int u) {
        int v;
        Attribute attr;
        byte[] b = this.f10696b;
        char[] c = context.buffer;
        int maxStack = readUnsignedShort(u);
        int maxLocals = readUnsignedShort(u + 2);
        int codeLength = readInt(u + 4);
        int u2 = u + 8;
        int codeEnd = u2 + codeLength;
        Label[] labels = new Label[codeLength + 2];
        context.labels = labels;
        readLabel(codeLength + 1, labels);
        while (u2 < codeEnd) {
            int offset = u2 - u2;
            switch (ClassWriter.TYPE[b[u2] & 255]) {
                case 0:
                case 4:
                    u2++;
                    break;
                case 1:
                case 3:
                case 11:
                    u2 += 2;
                    break;
                case 2:
                case 5:
                case 6:
                case 12:
                case 13:
                    u2 += 3;
                    break;
                case 7:
                case 8:
                    u2 += 5;
                    break;
                case 9:
                    readLabel(offset + readShort(u2 + 1), labels);
                    u2 += 3;
                    break;
                case 10:
                    readLabel(offset + readInt(u2 + 1), labels);
                    u2 += 5;
                    break;
                case 14:
                    int u3 = (u2 + 4) - (offset & 3);
                    readLabel(offset + readInt(u3), labels);
                    for (int i = (readInt(u3 + 8) - readInt(u3 + 4)) + 1; i > 0; i--) {
                        readLabel(offset + readInt(u3 + 12), labels);
                        u3 += 4;
                    }
                    u2 = u3 + 12;
                    break;
                case 15:
                    int u4 = (u2 + 4) - (offset & 3);
                    readLabel(offset + readInt(u4), labels);
                    for (int i2 = readInt(u4 + 4); i2 > 0; i2--) {
                        readLabel(offset + readInt(u4 + 12), labels);
                        u4 += 8;
                    }
                    u2 = u4 + 8;
                    break;
                case 16:
                default:
                    u2 += 4;
                    break;
                case 17:
                    if ((b[u2 + 1] & 255) == 132) {
                        u2 += 6;
                        break;
                    } else {
                        u2 += 4;
                        break;
                    }
            }
        }
        for (int i3 = readUnsignedShort(u2); i3 > 0; i3--) {
            Label start = readLabel(readUnsignedShort(u2 + 2), labels);
            Label end = readLabel(readUnsignedShort(u2 + 4), labels);
            Label handler = readLabel(readUnsignedShort(u2 + 6), labels);
            String type = readUTF8(this.items[readUnsignedShort(u2 + 8)], c);
            mv.visitTryCatchBlock(start, end, handler, type);
            u2 += 8;
        }
        int u5 = u2 + 2;
        int[] tanns = null;
        int[] itanns = null;
        int tann = 0;
        int itann = 0;
        int ntoff = -1;
        int nitoff = -1;
        int varTable = 0;
        int varTypeTable = 0;
        boolean zip = true;
        boolean unzip = (context.flags & 8) != 0;
        int stackMap = 0;
        int stackMapSize = 0;
        int frameCount = 0;
        Context frame = null;
        Attribute attributes = null;
        for (int i4 = readUnsignedShort(u5); i4 > 0; i4--) {
            String attrName = readUTF8(u5 + 2, c);
            if ("LocalVariableTable".equals(attrName)) {
                if ((context.flags & 2) == 0) {
                    varTable = u5 + 8;
                    int v2 = u5;
                    for (int j = readUnsignedShort(u5 + 8); j > 0; j--) {
                        int label = readUnsignedShort(v2 + 10);
                        if (labels[label] == null) {
                            readLabel(label, labels).status |= 1;
                        }
                        int label2 = label + readUnsignedShort(v2 + 12);
                        if (labels[label2] == null) {
                            readLabel(label2, labels).status |= 1;
                        }
                        v2 += 10;
                    }
                }
            } else if ("LocalVariableTypeTable".equals(attrName)) {
                varTypeTable = u5 + 8;
            } else if ("LineNumberTable".equals(attrName)) {
                if ((context.flags & 2) == 0) {
                    int v3 = u5;
                    for (int j2 = readUnsignedShort(u5 + 8); j2 > 0; j2--) {
                        int label3 = readUnsignedShort(v3 + 10);
                        if (labels[label3] == null) {
                            readLabel(label3, labels).status |= 1;
                        }
                        labels[label3].line = readUnsignedShort(v3 + 12);
                        v3 += 4;
                    }
                }
            } else if ("RuntimeVisibleTypeAnnotations".equals(attrName)) {
                tanns = readTypeAnnotations(mv, context, u5 + 8, true);
                ntoff = (tanns.length == 0 || readByte(tanns[0]) < 67) ? -1 : readUnsignedShort(tanns[0] + 1);
            } else if ("RuntimeInvisibleTypeAnnotations".equals(attrName)) {
                itanns = readTypeAnnotations(mv, context, u5 + 8, false);
                nitoff = (itanns.length == 0 || readByte(itanns[0]) < 67) ? -1 : readUnsignedShort(itanns[0] + 1);
            } else if ("StackMapTable".equals(attrName)) {
                if ((context.flags & 4) == 0) {
                    stackMap = u5 + 10;
                    stackMapSize = readInt(u5 + 4);
                    frameCount = readUnsignedShort(u5 + 8);
                }
            } else if ("StackMap".equals(attrName)) {
                if ((context.flags & 4) == 0) {
                    zip = false;
                    stackMap = u5 + 10;
                    stackMapSize = readInt(u5 + 4);
                    frameCount = readUnsignedShort(u5 + 8);
                }
            } else {
                for (int j3 = 0; j3 < context.attrs.length; j3++) {
                    if (context.attrs[j3].type.equals(attrName) && (attr = context.attrs[j3].read(this, u5 + 8, readInt(u5 + 4), c, u2 - 8, labels)) != null) {
                        attr.next = attributes;
                        attributes = attr;
                    }
                }
            }
            u5 += 6 + readInt(u5 + 4);
        }
        int i5 = u5 + 2;
        if (stackMap != 0) {
            frame = context;
            frame.offset = -1;
            frame.mode = 0;
            frame.localCount = 0;
            frame.localDiff = 0;
            frame.stackCount = 0;
            frame.local = new Object[maxLocals];
            frame.stack = new Object[maxStack];
            if (unzip) {
                getImplicitFrame(context);
            }
            for (int i6 = stackMap; i6 < (stackMap + stackMapSize) - 2; i6++) {
                if (b[i6] == 8 && (v = readUnsignedShort(i6 + 1)) >= 0 && v < codeLength && (b[u2 + v] & 255) == 187) {
                    readLabel(v, labels);
                }
            }
        }
        int u6 = u2;
        while (u6 < codeEnd) {
            int offset2 = u6 - u2;
            Label l = labels[offset2];
            if (l != null) {
                mv.visitLabel(l);
                if ((context.flags & 2) == 0 && l.line > 0) {
                    mv.visitLineNumber(l.line, l);
                }
            }
            while (frame != null && (frame.offset == offset2 || frame.offset == -1)) {
                if (frame.offset != -1) {
                    if (!zip || unzip) {
                        mv.visitFrame(-1, frame.localCount, frame.local, frame.stackCount, frame.stack);
                    } else {
                        mv.visitFrame(frame.mode, frame.localDiff, frame.local, frame.stackCount, frame.stack);
                    }
                }
                if (frameCount > 0) {
                    stackMap = readFrame(stackMap, zip, unzip, frame);
                    frameCount--;
                } else {
                    frame = null;
                }
            }
            int opcode = b[u6] & 255;
            switch (ClassWriter.TYPE[opcode]) {
                case 0:
                    mv.visitInsn(opcode);
                    u6++;
                    break;
                case 1:
                    mv.visitIntInsn(opcode, b[u6 + 1]);
                    u6 += 2;
                    break;
                case 2:
                    mv.visitIntInsn(opcode, readShort(u6 + 1));
                    u6 += 3;
                    break;
                case 3:
                    mv.visitVarInsn(opcode, b[u6 + 1] & 255);
                    u6 += 2;
                    break;
                case 4:
                    if (opcode > 54) {
                        int opcode2 = opcode - 59;
                        mv.visitVarInsn(54 + (opcode2 >> 2), opcode2 & 3);
                    } else {
                        int opcode3 = opcode - 26;
                        mv.visitVarInsn(21 + (opcode3 >> 2), opcode3 & 3);
                    }
                    u6++;
                    break;
                case 5:
                    mv.visitTypeInsn(opcode, readClass(u6 + 1, c));
                    u6 += 3;
                    break;
                case 6:
                case 7:
                    int cpIndex = this.items[readUnsignedShort(u6 + 1)];
                    boolean itf = b[cpIndex - 1] == 11;
                    String iowner = readClass(cpIndex, c);
                    int cpIndex2 = this.items[readUnsignedShort(cpIndex + 2)];
                    String iname = readUTF8(cpIndex2, c);
                    String idesc = readUTF8(cpIndex2 + 2, c);
                    if (opcode < 182) {
                        mv.visitFieldInsn(opcode, iowner, iname, idesc);
                    } else {
                        mv.visitMethodInsn(opcode, iowner, iname, idesc, itf);
                    }
                    if (opcode == 185) {
                        u6 += 5;
                        break;
                    } else {
                        u6 += 3;
                        break;
                    }
                case 8:
                    int cpIndex3 = this.items[readUnsignedShort(u6 + 1)];
                    int bsmIndex = context.bootstrapMethods[readUnsignedShort(cpIndex3)];
                    Handle bsm = (Handle) readConst(readUnsignedShort(bsmIndex), c);
                    int bsmArgCount = readUnsignedShort(bsmIndex + 2);
                    Object[] bsmArgs = new Object[bsmArgCount];
                    int bsmIndex2 = bsmIndex + 4;
                    for (int i7 = 0; i7 < bsmArgCount; i7++) {
                        bsmArgs[i7] = readConst(readUnsignedShort(bsmIndex2), c);
                        bsmIndex2 += 2;
                    }
                    int cpIndex4 = this.items[readUnsignedShort(cpIndex3 + 2)];
                    mv.visitInvokeDynamicInsn(readUTF8(cpIndex4, c), readUTF8(cpIndex4 + 2, c), bsm, bsmArgs);
                    u6 += 5;
                    break;
                case 9:
                    mv.visitJumpInsn(opcode, labels[offset2 + readShort(u6 + 1)]);
                    u6 += 3;
                    break;
                case 10:
                    mv.visitJumpInsn(opcode - 33, labels[offset2 + readInt(u6 + 1)]);
                    u6 += 5;
                    break;
                case 11:
                    mv.visitLdcInsn(readConst(b[u6 + 1] & 255, c));
                    u6 += 2;
                    break;
                case 12:
                    mv.visitLdcInsn(readConst(readUnsignedShort(u6 + 1), c));
                    u6 += 3;
                    break;
                case 13:
                    mv.visitIincInsn(b[u6 + 1] & 255, b[u6 + 2]);
                    u6 += 3;
                    break;
                case 14:
                    int u7 = (u6 + 4) - (offset2 & 3);
                    int label4 = offset2 + readInt(u7);
                    int min = readInt(u7 + 4);
                    int max = readInt(u7 + 8);
                    Label[] table = new Label[(max - min) + 1];
                    u6 = u7 + 12;
                    for (int i8 = 0; i8 < table.length; i8++) {
                        table[i8] = labels[offset2 + readInt(u6)];
                        u6 += 4;
                    }
                    mv.visitTableSwitchInsn(min, max, labels[label4], table);
                    break;
                case 15:
                    int u8 = (u6 + 4) - (offset2 & 3);
                    int label5 = offset2 + readInt(u8);
                    int len = readInt(u8 + 4);
                    int[] keys = new int[len];
                    Label[] values = new Label[len];
                    u6 = u8 + 8;
                    for (int i9 = 0; i9 < len; i9++) {
                        keys[i9] = readInt(u6);
                        values[i9] = labels[offset2 + readInt(u6 + 4)];
                        u6 += 8;
                    }
                    mv.visitLookupSwitchInsn(labels[label5], keys, values);
                    break;
                case 16:
                default:
                    mv.visitMultiANewArrayInsn(readClass(u6 + 1, c), b[u6 + 3] & 255);
                    u6 += 4;
                    break;
                case 17:
                    int opcode4 = b[u6 + 1] & 255;
                    if (opcode4 == 132) {
                        mv.visitIincInsn(readUnsignedShort(u6 + 2), readShort(u6 + 4));
                        u6 += 6;
                        break;
                    } else {
                        mv.visitVarInsn(opcode4, readUnsignedShort(u6 + 2));
                        u6 += 4;
                        break;
                    }
            }
            while (tanns != null && tann < tanns.length && ntoff <= offset2) {
                if (ntoff == offset2) {
                    int v4 = readAnnotationTarget(context, tanns[tann]);
                    readAnnotationValues(v4 + 2, c, true, mv.visitInsnAnnotation(context.typeRef, context.typePath, readUTF8(v4, c), true));
                }
                tann++;
                ntoff = (tann >= tanns.length || readByte(tanns[tann]) < 67) ? -1 : readUnsignedShort(tanns[tann] + 1);
            }
            while (itanns != null && itann < itanns.length && nitoff <= offset2) {
                if (nitoff == offset2) {
                    int v5 = readAnnotationTarget(context, itanns[itann]);
                    readAnnotationValues(v5 + 2, c, true, mv.visitInsnAnnotation(context.typeRef, context.typePath, readUTF8(v5, c), false));
                }
                itann++;
                nitoff = (itann >= itanns.length || readByte(itanns[itann]) < 67) ? -1 : readUnsignedShort(itanns[itann] + 1);
            }
        }
        if (labels[codeLength] != null) {
            mv.visitLabel(labels[codeLength]);
        }
        if ((context.flags & 2) == 0 && varTable != 0) {
            int[] typeTable = null;
            if (varTypeTable != 0) {
                int u9 = varTypeTable + 2;
                typeTable = new int[readUnsignedShort(varTypeTable) * 3];
                int i10 = typeTable.length;
                while (i10 > 0) {
                    int i11 = i10 - 1;
                    typeTable[i11] = u9 + 6;
                    int i12 = i11 - 1;
                    typeTable[i12] = readUnsignedShort(u9 + 8);
                    i10 = i12 - 1;
                    typeTable[i10] = readUnsignedShort(u9);
                    u9 += 10;
                }
            }
            int u10 = varTable + 2;
            for (int i13 = readUnsignedShort(varTable); i13 > 0; i13--) {
                int start2 = readUnsignedShort(u10);
                int length = readUnsignedShort(u10 + 2);
                int index = readUnsignedShort(u10 + 8);
                String vsignature = null;
                if (typeTable != null) {
                    int j4 = 0;
                    while (true) {
                        if (j4 >= typeTable.length) {
                            break;
                        } else if (typeTable[j4] != start2 || typeTable[j4 + 1] != index) {
                            j4 += 3;
                        } else {
                            vsignature = readUTF8(typeTable[j4 + 2], c);
                        }
                    }
                }
                mv.visitLocalVariable(readUTF8(u10 + 4, c), readUTF8(u10 + 6, c), vsignature, labels[start2], labels[start2 + length], index);
                u10 += 10;
            }
        }
        if (tanns != null) {
            for (int i14 = 0; i14 < tanns.length; i14++) {
                if ((readByte(tanns[i14]) >> 1) == 32) {
                    int v6 = readAnnotationTarget(context, tanns[i14]);
                    readAnnotationValues(v6 + 2, c, true, mv.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, readUTF8(v6, c), true));
                }
            }
        }
        if (itanns != null) {
            for (int i15 = 0; i15 < itanns.length; i15++) {
                if ((readByte(itanns[i15]) >> 1) == 32) {
                    int v7 = readAnnotationTarget(context, itanns[i15]);
                    readAnnotationValues(v7 + 2, c, true, mv.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, readUTF8(v7, c), false));
                }
            }
        }
        while (attributes != null) {
            Attribute attr2 = attributes.next;
            attributes.next = null;
            mv.visitAttribute(attributes);
            attributes = attr2;
        }
        mv.visitMaxs(maxStack, maxLocals);
    }

    private int[] readTypeAnnotations(MethodVisitor mv, Context context, int u, boolean visible) {
        int u2;
        int readAnnotationValues;
        char[] c = context.buffer;
        int[] offsets = new int[readUnsignedShort(u)];
        int u3 = u + 2;
        for (int i = 0; i < offsets.length; i++) {
            offsets[i] = u3;
            int target = readInt(u3);
            switch (target >>> 24) {
                case 0:
                case 1:
                case 22:
                    u2 = u3 + 2;
                    break;
                case 19:
                case 20:
                case 21:
                    u2 = u3 + 1;
                    break;
                case 64:
                case 65:
                    for (int j = readUnsignedShort(u3 + 1); j > 0; j--) {
                        int start = readUnsignedShort(u3 + 3);
                        int length = readUnsignedShort(u3 + 5);
                        readLabel(start, context.labels);
                        readLabel(start + length, context.labels);
                        u3 += 6;
                    }
                    u2 = u3 + 3;
                    break;
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    u2 = u3 + 4;
                    break;
                default:
                    u2 = u3 + 3;
                    break;
            }
            int pathLength = readByte(u2);
            if ((target >>> 24) == 66) {
                TypePath path = pathLength == 0 ? null : new TypePath(this.f10696b, u2);
                int u4 = u2 + 1 + (2 * pathLength);
                readAnnotationValues = readAnnotationValues(u4 + 2, c, true, mv.visitTryCatchAnnotation(target, path, readUTF8(u4, c), visible));
            } else {
                readAnnotationValues = readAnnotationValues(u2 + 3 + (2 * pathLength), c, true, null);
            }
            u3 = readAnnotationValues;
        }
        return offsets;
    }

    private int readAnnotationTarget(Context context, int u) {
        int target;
        int u2;
        int target2 = readInt(u);
        switch (target2 >>> 24) {
            case 0:
            case 1:
            case 22:
                target = target2 & SupportMenu.CATEGORY_MASK;
                u2 = u + 2;
                break;
            case 19:
            case 20:
            case 21:
                target = target2 & ViewCompat.MEASURED_STATE_MASK;
                u2 = u + 1;
                break;
            case 64:
            case 65:
                target = target2 & ViewCompat.MEASURED_STATE_MASK;
                int n = readUnsignedShort(u + 1);
                context.start = new Label[n];
                context.end = new Label[n];
                context.index = new int[n];
                u2 = u + 3;
                for (int i = 0; i < n; i++) {
                    int start = readUnsignedShort(u2);
                    int length = readUnsignedShort(u2 + 2);
                    context.start[i] = readLabel(start, context.labels);
                    context.end[i] = readLabel(start + length, context.labels);
                    context.index[i] = readUnsignedShort(u2 + 4);
                    u2 += 6;
                }
                break;
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                target = target2 & (-16776961);
                u2 = u + 4;
                break;
            default:
                target = target2 & ((target2 >>> 24) < 67 ? InputDeviceCompat.SOURCE_ANY : ViewCompat.MEASURED_STATE_MASK);
                u2 = u + 3;
                break;
        }
        int pathLength = readByte(u2);
        context.typeRef = target;
        context.typePath = pathLength == 0 ? null : new TypePath(this.f10696b, u2);
        return u2 + 1 + (2 * pathLength);
    }

    private void readParameterAnnotations(MethodVisitor mv, Context context, int v, boolean visible) {
        int v2 = v + 1;
        int n = this.f10696b[v] & 255;
        int synthetics = Type.getArgumentTypes(context.desc).length - n;
        int i = 0;
        while (i < synthetics) {
            AnnotationVisitor av = mv.visitParameterAnnotation(i, "Ljava/lang/Synthetic;", false);
            if (av != null) {
                av.visitEnd();
            }
            i++;
        }
        char[] c = context.buffer;
        while (i < n + synthetics) {
            v2 += 2;
            for (int j = readUnsignedShort(v2); j > 0; j--) {
                v2 = readAnnotationValues(v2 + 2, c, true, mv.visitParameterAnnotation(i, readUTF8(v2, c), visible));
            }
            i++;
        }
    }

    private int readAnnotationValues(int v, char[] buf, boolean named, AnnotationVisitor av) {
        int i = readUnsignedShort(v);
        int v2 = v + 2;
        if (named) {
            while (i > 0) {
                v2 = readAnnotationValue(v2 + 2, buf, readUTF8(v2, buf), av);
                i--;
            }
        } else {
            while (i > 0) {
                v2 = readAnnotationValue(v2, buf, null, av);
                i--;
            }
        }
        if (av != null) {
            av.visitEnd();
        }
        return v2;
    }

    private int readAnnotationValue(int v, char[] buf, String name, AnnotationVisitor av) {
        if (av == null) {
            switch (this.f10696b[v] & 255) {
                case 64:
                    return readAnnotationValues(v + 3, buf, true, null);
                case 91:
                    return readAnnotationValues(v + 1, buf, false, null);
                case 101:
                    return v + 5;
                default:
                    return v + 3;
            }
        }
        int v2 = v + 1;
        switch (this.f10696b[v] & 255) {
            case 64:
                v2 = readAnnotationValues(v2 + 2, buf, true, av.visitAnnotation(name, readUTF8(v2, buf)));
                break;
            case 66:
                av.visit(name, new Byte((byte) readInt(this.items[readUnsignedShort(v2)])));
                v2 += 2;
                break;
            case 67:
                av.visit(name, new Character((char) readInt(this.items[readUnsignedShort(v2)])));
                v2 += 2;
                break;
            case 68:
            case 70:
            case 73:
            case 74:
                av.visit(name, readConst(readUnsignedShort(v2), buf));
                v2 += 2;
                break;
            case 83:
                av.visit(name, new Short((short) readInt(this.items[readUnsignedShort(v2)])));
                v2 += 2;
                break;
            case 90:
                av.visit(name, readInt(this.items[readUnsignedShort(v2)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
                v2 += 2;
                break;
            case 91:
                int size = readUnsignedShort(v2);
                int v3 = v2 + 2;
                if (size == 0) {
                    return readAnnotationValues(v3 - 2, buf, false, av.visitArray(name));
                }
                int v4 = v3 + 1;
                switch (this.f10696b[v3] & 255) {
                    case 66:
                        byte[] bv = new byte[size];
                        for (int i = 0; i < size; i++) {
                            bv[i] = (byte) readInt(this.items[readUnsignedShort(v4)]);
                            v4 += 3;
                        }
                        av.visit(name, bv);
                        v2 = v4 - 1;
                        break;
                    case 67:
                        char[] cv = new char[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            cv[i2] = (char) readInt(this.items[readUnsignedShort(v4)]);
                            v4 += 3;
                        }
                        av.visit(name, cv);
                        v2 = v4 - 1;
                        break;
                    case 68:
                        double[] dv = new double[size];
                        for (int i3 = 0; i3 < size; i3++) {
                            dv[i3] = Double.longBitsToDouble(readLong(this.items[readUnsignedShort(v4)]));
                            v4 += 3;
                        }
                        av.visit(name, dv);
                        v2 = v4 - 1;
                        break;
                    case 69:
                    case 71:
                    case 72:
                    case 75:
                    case 76:
                    case 77:
                    case 78:
                    case 79:
                    case 80:
                    case 81:
                    case 82:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    default:
                        v2 = readAnnotationValues(v4 - 3, buf, false, av.visitArray(name));
                        break;
                    case 70:
                        float[] fv = new float[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            fv[i4] = Float.intBitsToFloat(readInt(this.items[readUnsignedShort(v4)]));
                            v4 += 3;
                        }
                        av.visit(name, fv);
                        v2 = v4 - 1;
                        break;
                    case 73:
                        int[] iv = new int[size];
                        for (int i5 = 0; i5 < size; i5++) {
                            iv[i5] = readInt(this.items[readUnsignedShort(v4)]);
                            v4 += 3;
                        }
                        av.visit(name, iv);
                        v2 = v4 - 1;
                        break;
                    case 74:
                        long[] lv = new long[size];
                        for (int i6 = 0; i6 < size; i6++) {
                            lv[i6] = readLong(this.items[readUnsignedShort(v4)]);
                            v4 += 3;
                        }
                        av.visit(name, lv);
                        v2 = v4 - 1;
                        break;
                    case 83:
                        short[] sv = new short[size];
                        for (int i7 = 0; i7 < size; i7++) {
                            sv[i7] = (short) readInt(this.items[readUnsignedShort(v4)]);
                            v4 += 3;
                        }
                        av.visit(name, sv);
                        v2 = v4 - 1;
                        break;
                    case 90:
                        boolean[] zv = new boolean[size];
                        for (int i8 = 0; i8 < size; i8++) {
                            zv[i8] = readInt(this.items[readUnsignedShort(v4)]) != 0;
                            v4 += 3;
                        }
                        av.visit(name, zv);
                        v2 = v4 - 1;
                        break;
                }
            case 99:
                av.visit(name, Type.getType(readUTF8(v2, buf)));
                v2 += 2;
                break;
            case 101:
                av.visitEnum(name, readUTF8(v2, buf), readUTF8(v2 + 2, buf));
                v2 += 4;
                break;
            case 115:
                av.visit(name, readUTF8(v2, buf));
                v2 += 2;
                break;
        }
        return v2;
    }

    private void getImplicitFrame(Context frame) {
        String desc = frame.desc;
        Object[] locals = frame.local;
        int local = 0;
        if ((frame.access & 8) == 0) {
            if ("<init>".equals(frame.name)) {
                local = 0 + 1;
                locals[0] = Opcodes.UNINITIALIZED_THIS;
            } else {
                local = 0 + 1;
                locals[0] = readClass(this.header + 2, frame.buffer);
            }
        }
        int i = 1;
        while (true) {
            int j = i;
            int i2 = i;
            i++;
            switch (desc.charAt(i2)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z':
                    int i3 = local;
                    local++;
                    locals[i3] = Opcodes.INTEGER;
                    break;
                case 'D':
                    int i4 = local;
                    local++;
                    locals[i4] = Opcodes.DOUBLE;
                    break;
                case 'E':
                case 'G':
                case 'H':
                case 'K':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                default:
                    frame.localCount = local;
                    return;
                case 'F':
                    int i5 = local;
                    local++;
                    locals[i5] = Opcodes.FLOAT;
                    break;
                case 'J':
                    int i6 = local;
                    local++;
                    locals[i6] = Opcodes.LONG;
                    break;
                case 'L':
                    while (desc.charAt(i) != ';') {
                        i++;
                    }
                    int i7 = local;
                    local++;
                    int i8 = i;
                    i++;
                    locals[i7] = desc.substring(j + 1, i8);
                    break;
                case '[':
                    while (desc.charAt(i) == '[') {
                        i++;
                    }
                    if (desc.charAt(i) == 'L') {
                        while (true) {
                            i++;
                            if (desc.charAt(i) != ';') {
                            }
                        }
                    }
                    int i9 = local;
                    local++;
                    i++;
                    locals[i9] = desc.substring(j, i);
                    break;
            }
        }
    }

    private int readFrame(int stackMap, boolean zip, boolean unzip, Context frame) {
        int tag;
        int delta;
        char[] c = frame.buffer;
        Label[] labels = frame.labels;
        if (zip) {
            stackMap++;
            tag = this.f10696b[stackMap] & 255;
        } else {
            tag = 255;
            frame.offset = -1;
        }
        frame.localDiff = 0;
        if (tag < 64) {
            delta = tag;
            frame.mode = 3;
            frame.stackCount = 0;
        } else if (tag < 128) {
            delta = tag - 64;
            stackMap = readFrameType(frame.stack, 0, stackMap, c, labels);
            frame.mode = 4;
            frame.stackCount = 1;
        } else {
            delta = readUnsignedShort(stackMap);
            stackMap += 2;
            if (tag == 247) {
                stackMap = readFrameType(frame.stack, 0, stackMap, c, labels);
                frame.mode = 4;
                frame.stackCount = 1;
            } else if (tag >= 248 && tag < 251) {
                frame.mode = 2;
                frame.localDiff = bqk.f6602ci - tag;
                frame.localCount -= frame.localDiff;
                frame.stackCount = 0;
            } else if (tag == 251) {
                frame.mode = 3;
                frame.stackCount = 0;
            } else if (tag < 255) {
                int local = unzip ? frame.localCount : 0;
                for (int i = tag - bqk.f6602ci; i > 0; i--) {
                    int i2 = local;
                    local++;
                    stackMap = readFrameType(frame.local, i2, stackMap, c, labels);
                }
                frame.mode = 1;
                frame.localDiff = tag - bqk.f6602ci;
                frame.localCount += frame.localDiff;
                frame.stackCount = 0;
            } else {
                frame.mode = 0;
                int n = readUnsignedShort(stackMap);
                int stackMap2 = stackMap + 2;
                frame.localDiff = n;
                frame.localCount = n;
                int local2 = 0;
                while (n > 0) {
                    int i3 = local2;
                    local2++;
                    stackMap2 = readFrameType(frame.local, i3, stackMap2, c, labels);
                    n--;
                }
                int n2 = readUnsignedShort(stackMap2);
                stackMap = stackMap2 + 2;
                frame.stackCount = n2;
                int stack = 0;
                while (n2 > 0) {
                    int i4 = stack;
                    stack++;
                    stackMap = readFrameType(frame.stack, i4, stackMap, c, labels);
                    n2--;
                }
            }
        }
        frame.offset += delta + 1;
        readLabel(frame.offset, labels);
        return stackMap;
    }

    private int readFrameType(Object[] frame, int index, int v, char[] buf, Label[] labels) {
        int v2 = v + 1;
        int type = this.f10696b[v] & 255;
        switch (type) {
            case 0:
                frame[index] = Opcodes.TOP;
                break;
            case 1:
                frame[index] = Opcodes.INTEGER;
                break;
            case 2:
                frame[index] = Opcodes.FLOAT;
                break;
            case 3:
                frame[index] = Opcodes.DOUBLE;
                break;
            case 4:
                frame[index] = Opcodes.LONG;
                break;
            case 5:
                frame[index] = Opcodes.NULL;
                break;
            case 6:
                frame[index] = Opcodes.UNINITIALIZED_THIS;
                break;
            case 7:
                frame[index] = readClass(v2, buf);
                v2 += 2;
                break;
            default:
                frame[index] = readLabel(readUnsignedShort(v2), labels);
                v2 += 2;
                break;
        }
        return v2;
    }

    protected Label readLabel(int offset, Label[] labels) {
        if (labels[offset] == null) {
            labels[offset] = new Label();
        }
        return labels[offset];
    }

    private int getAttributes() {
        int u = this.header + 8 + (readUnsignedShort(this.header + 6) * 2);
        for (int i = readUnsignedShort(u); i > 0; i--) {
            for (int j = readUnsignedShort(u + 8); j > 0; j--) {
                u += 6 + readInt(u + 12);
            }
            u += 8;
        }
        int u2 = u + 2;
        for (int i2 = readUnsignedShort(u2); i2 > 0; i2--) {
            for (int j2 = readUnsignedShort(u2 + 8); j2 > 0; j2--) {
                u2 += 6 + readInt(u2 + 12);
            }
            u2 += 8;
        }
        return u2 + 2;
    }

    private Attribute readAttribute(Attribute[] attrs, String type, int off, int len, char[] buf, int codeOff, Label[] labels) {
        for (int i = 0; i < attrs.length; i++) {
            if (attrs[i].type.equals(type)) {
                return attrs[i].read(this, off, len, buf, codeOff, labels);
            }
        }
        return new Attribute(type).read(this, off, len, null, -1, null);
    }

    public int getItemCount() {
        return this.items.length;
    }

    public int getItem(int item) {
        return this.items[item];
    }

    public int getMaxStringLength() {
        return this.maxStringLength;
    }

    public int readByte(int index) {
        return this.f10696b[index] & 255;
    }

    public int readUnsignedShort(int index) {
        byte[] b = this.f10696b;
        return ((b[index] & 255) << 8) | (b[index + 1] & 255);
    }

    public short readShort(int index) {
        byte[] b = this.f10696b;
        return (short) (((b[index] & 255) << 8) | (b[index + 1] & 255));
    }

    public int readInt(int index) {
        byte[] b = this.f10696b;
        return ((b[index] & 255) << 24) | ((b[index + 1] & 255) << 16) | ((b[index + 2] & 255) << 8) | (b[index + 3] & 255);
    }

    public long readLong(int index) {
        long l1 = readInt(index);
        long l0 = readInt(index + 4) & 4294967295L;
        return (l1 << 32) | l0;
    }

    public String readUTF8(int index, char[] buf) {
        int item = readUnsignedShort(index);
        if (index == 0 || item == 0) {
            return null;
        }
        String s = this.strings[item];
        if (s != null) {
            return s;
        }
        int index2 = this.items[item];
        String[] strArr = this.strings;
        String readUTF = readUTF(index2 + 2, readUnsignedShort(index2), buf);
        strArr[item] = readUTF;
        return readUTF;
    }

    private String readUTF(int index, int utfLen, char[] buf) {
        int endIndex = index + utfLen;
        byte[] b = this.f10696b;
        int strLen = 0;
        int st = 0;
        char cc = 0;
        while (index < endIndex) {
            int i = index;
            index++;
            byte b2 = b[i];
            switch (st) {
                case 0:
                    int c = b2 & 255;
                    if (c < 128) {
                        int i2 = strLen;
                        strLen++;
                        buf[i2] = (char) c;
                        break;
                    } else if (c < 224 && c > 191) {
                        cc = (char) (c & 31);
                        st = 1;
                        break;
                    } else {
                        cc = (char) (c & 15);
                        st = 2;
                        break;
                    }
                    break;
                case 1:
                    int i3 = strLen;
                    strLen++;
                    buf[i3] = (char) ((cc << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
                    st = 0;
                    break;
                case 2:
                    cc = (char) ((cc << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
                    st = 1;
                    break;
            }
        }
        return new String(buf, 0, strLen);
    }

    public String readClass(int index, char[] buf) {
        return readUTF8(this.items[readUnsignedShort(index)], buf);
    }

    public Object readConst(int item, char[] buf) {
        int index = this.items[item];
        switch (this.f10696b[index - 1]) {
            case 3:
                return new Integer(readInt(index));
            case 4:
                return new Float(Float.intBitsToFloat(readInt(index)));
            case 5:
                return new Long(readLong(index));
            case 6:
                return new Double(Double.longBitsToDouble(readLong(index)));
            case 7:
                return Type.getObjectType(readUTF8(index, buf));
            case 8:
                return readUTF8(index, buf);
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            default:
                int tag = readByte(index);
                int[] items = this.items;
                int cpIndex = items[readUnsignedShort(index + 1)];
                String owner = readClass(cpIndex, buf);
                int cpIndex2 = items[readUnsignedShort(cpIndex + 2)];
                String name = readUTF8(cpIndex2, buf);
                String desc = readUTF8(cpIndex2 + 2, buf);
                return new Handle(tag, owner, name, desc);
            case 16:
                return Type.getMethodType(readUTF8(index, buf));
        }
    }
}
