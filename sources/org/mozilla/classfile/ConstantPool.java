package org.mozilla.classfile;

import kotlin.UShort;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.UintMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClassFileWriter.java */
/* loaded from: classes5.dex */
public final class ConstantPool {
    static final byte CONSTANT_Class = 7;
    static final byte CONSTANT_Double = 6;
    static final byte CONSTANT_Fieldref = 9;
    static final byte CONSTANT_Float = 4;
    static final byte CONSTANT_Integer = 3;
    static final byte CONSTANT_InterfaceMethodref = 11;
    static final byte CONSTANT_Long = 5;
    static final byte CONSTANT_Methodref = 10;
    static final byte CONSTANT_NameAndType = 12;
    static final byte CONSTANT_String = 8;
    static final byte CONSTANT_Utf8 = 1;
    private static final int ConstantPoolSize = 256;
    private static final int MAX_UTF_ENCODING_SIZE = 65535;
    private ClassFileWriter cfw;
    private UintMap itsStringConstHash = new UintMap();
    private ObjToIntMap itsUtf8Hash = new ObjToIntMap();
    private ObjToIntMap itsFieldRefHash = new ObjToIntMap();
    private ObjToIntMap itsMethodRefHash = new ObjToIntMap();
    private ObjToIntMap itsClassHash = new ObjToIntMap();
    private UintMap itsConstantData = new UintMap();
    private UintMap itsPoolTypes = new UintMap();
    private int itsTopIndex = 1;
    private byte[] itsPool = new byte[256];
    private int itsTop = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstantPool(ClassFileWriter classFileWriter) {
        this.cfw = classFileWriter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int write(byte[] bArr, int i) {
        int putInt16 = ClassFileWriter.putInt16((short) this.itsTopIndex, bArr, i);
        System.arraycopy(this.itsPool, 0, bArr, putInt16, this.itsTop);
        return putInt16 + this.itsTop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getWriteSize() {
        return this.itsTop + 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addConstant(int i) {
        ensure(5);
        byte[] bArr = this.itsPool;
        int i2 = this.itsTop;
        int i3 = i2 + 1;
        this.itsTop = i3;
        bArr[i2] = 3;
        this.itsTop = ClassFileWriter.putInt32(i, bArr, i3);
        this.itsPoolTypes.put(this.itsTopIndex, 3);
        int i4 = this.itsTopIndex;
        this.itsTopIndex = i4 + 1;
        return (short) i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addConstant(long j) {
        ensure(9);
        byte[] bArr = this.itsPool;
        int i = this.itsTop;
        int i2 = i + 1;
        this.itsTop = i2;
        bArr[i] = 5;
        this.itsTop = ClassFileWriter.putInt64(j, bArr, i2);
        int i3 = this.itsTopIndex;
        this.itsTopIndex = i3 + 2;
        this.itsPoolTypes.put(i3, 5);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addConstant(float f) {
        ensure(5);
        byte[] bArr = this.itsPool;
        int i = this.itsTop;
        this.itsTop = i + 1;
        bArr[i] = 4;
        this.itsTop = ClassFileWriter.putInt32(Float.floatToIntBits(f), this.itsPool, this.itsTop);
        this.itsPoolTypes.put(this.itsTopIndex, 4);
        int i2 = this.itsTopIndex;
        this.itsTopIndex = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addConstant(double d) {
        ensure(9);
        byte[] bArr = this.itsPool;
        int i = this.itsTop;
        this.itsTop = i + 1;
        bArr[i] = 6;
        this.itsTop = ClassFileWriter.putInt64(Double.doubleToLongBits(d), this.itsPool, this.itsTop);
        int i2 = this.itsTopIndex;
        this.itsTopIndex = i2 + 2;
        this.itsPoolTypes.put(i2, 6);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int addConstant(String str) {
        int addUtf8 = addUtf8(str) & UShort.MAX_VALUE;
        int i = this.itsStringConstHash.getInt(addUtf8, -1);
        if (i == -1) {
            i = this.itsTopIndex;
            this.itsTopIndex = i + 1;
            ensure(3);
            byte[] bArr = this.itsPool;
            int i2 = this.itsTop;
            int i3 = i2 + 1;
            this.itsTop = i3;
            bArr[i2] = 8;
            this.itsTop = ClassFileWriter.putInt16(addUtf8, bArr, i3);
            this.itsStringConstHash.put(addUtf8, i);
        }
        this.itsPoolTypes.put(i, 8);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isUnderUtfEncodingLimit(String str) {
        int length = str.length();
        if (length * 3 <= 65535) {
            return true;
        }
        return length <= 65535 && length == getUtfEncodingLimit(str, 0, length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getUtfEncodingLimit(String str, int i, int i2) {
        int i3 = 65535;
        if ((i2 - i) * 3 <= 65535) {
            return i2;
        }
        while (i != i2) {
            char charAt = str.charAt(i);
            i3 = (charAt == 0 || charAt > 127) ? charAt < 2047 ? i3 - 2 : i3 - 3 : i3 - 1;
            if (i3 < 0) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public short addUtf8(java.lang.String r13) {
        /*
            r12 = this;
            org.mozilla.javascript.ObjToIntMap r0 = r12.itsUtf8Hash
            r1 = -1
            int r0 = r0.get(r13, r1)
            r2 = 1
            if (r0 != r1) goto Lb1
            int r1 = r13.length()
            r3 = 65535(0xffff, float:9.1834E-41)
            r4 = 0
            if (r1 <= r3) goto L17
        L14:
            r4 = 1
            goto La6
        L17:
            int r5 = r1 * 3
            int r5 = r5 + 3
            r12.ensure(r5)
            int r5 = r12.itsTop
            byte[] r6 = r12.itsPool
            int r7 = r5 + 1
            r6[r5] = r2
            int r7 = r7 + 2
            org.mozilla.classfile.ClassFileWriter r5 = r12.cfw
            char[] r5 = r5.getCharBuffer(r1)
            r13.getChars(r4, r1, r5, r4)
            r6 = 0
        L32:
            if (r6 == r1) goto L80
            char r8 = r5[r6]
            if (r8 == 0) goto L44
            r9 = 127(0x7f, float:1.78E-43)
            if (r8 > r9) goto L44
            byte[] r9 = r12.itsPool
            int r10 = r7 + 1
            byte r8 = (byte) r8
            r9[r7] = r8
            goto L67
        L44:
            r9 = 2047(0x7ff, float:2.868E-42)
            if (r8 <= r9) goto L69
            byte[] r9 = r12.itsPool
            int r10 = r7 + 1
            int r11 = r8 >> 12
            r11 = r11 | 224(0xe0, float:3.14E-43)
            byte r11 = (byte) r11
            r9[r7] = r11
            int r7 = r10 + 1
            int r11 = r8 >> 6
            r11 = r11 & 63
            r11 = r11 | 128(0x80, float:1.8E-43)
            byte r11 = (byte) r11
            r9[r10] = r11
            int r10 = r7 + 1
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.8E-43)
            byte r8 = (byte) r8
            r9[r7] = r8
        L67:
            r7 = r10
            goto L7d
        L69:
            byte[] r9 = r12.itsPool
            int r10 = r7 + 1
            int r11 = r8 >> 6
            r11 = r11 | 192(0xc0, float:2.69E-43)
            byte r11 = (byte) r11
            r9[r7] = r11
            int r7 = r10 + 1
            r8 = r8 & 63
            r8 = r8 | 128(0x80, float:1.8E-43)
            byte r8 = (byte) r8
            r9[r10] = r8
        L7d:
            int r6 = r6 + 1
            goto L32
        L80:
            int r1 = r12.itsTop
            int r5 = r1 + 1
            int r5 = r5 + 2
            int r5 = r7 - r5
            if (r5 <= r3) goto L8b
            goto L14
        L8b:
            byte[] r0 = r12.itsPool
            int r3 = r1 + 1
            int r6 = r5 >>> 8
            byte r6 = (byte) r6
            r0[r3] = r6
            int r1 = r1 + 2
            byte r3 = (byte) r5
            r0[r1] = r3
            r12.itsTop = r7
            int r0 = r12.itsTopIndex
            int r1 = r0 + 1
            r12.itsTopIndex = r1
            org.mozilla.javascript.ObjToIntMap r1 = r12.itsUtf8Hash
            r1.put(r13, r0)
        La6:
            if (r4 != 0) goto La9
            goto Lb1
        La9:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Too big string"
            r13.<init>(r0)
            throw r13
        Lb1:
            r12.setConstantData(r0, r13)
            org.mozilla.javascript.UintMap r13 = r12.itsPoolTypes
            r13.put(r0, r2)
            short r13 = (short) r0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.ConstantPool.addUtf8(java.lang.String):short");
    }

    private short addNameAndType(String str, String str2) {
        short addUtf8 = addUtf8(str);
        short addUtf82 = addUtf8(str2);
        ensure(5);
        byte[] bArr = this.itsPool;
        int i = this.itsTop;
        int i2 = i + 1;
        this.itsTop = i2;
        bArr[i] = 12;
        int putInt16 = ClassFileWriter.putInt16(addUtf8, bArr, i2);
        this.itsTop = putInt16;
        this.itsTop = ClassFileWriter.putInt16(addUtf82, this.itsPool, putInt16);
        this.itsPoolTypes.put(this.itsTopIndex, 12);
        int i3 = this.itsTopIndex;
        this.itsTopIndex = i3 + 1;
        return (short) i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short addClass(String str) {
        String str2;
        int i = this.itsClassHash.get(str, -1);
        if (i == -1) {
            if (str.indexOf(46) > 0) {
                String slashedForm = ClassFileWriter.getSlashedForm(str);
                int i2 = this.itsClassHash.get(slashedForm, -1);
                if (i2 != -1) {
                    this.itsClassHash.put(str, i2);
                }
                str2 = slashedForm;
                i = i2;
            } else {
                str2 = str;
            }
            if (i == -1) {
                short addUtf8 = addUtf8(str2);
                ensure(3);
                byte[] bArr = this.itsPool;
                int i3 = this.itsTop;
                int i4 = i3 + 1;
                this.itsTop = i4;
                bArr[i3] = 7;
                this.itsTop = ClassFileWriter.putInt16(addUtf8, bArr, i4);
                i = this.itsTopIndex;
                this.itsTopIndex = i + 1;
                this.itsClassHash.put(str2, i);
                if (str != str2) {
                    this.itsClassHash.put(str, i);
                }
            }
        }
        setConstantData(i, str);
        this.itsPoolTypes.put(i, 7);
        return (short) i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short addFieldRef(String str, String str2, String str3) {
        FieldOrMethodRef fieldOrMethodRef = new FieldOrMethodRef(str, str2, str3);
        int i = this.itsFieldRefHash.get(fieldOrMethodRef, -1);
        if (i == -1) {
            short addNameAndType = addNameAndType(str2, str3);
            short addClass = addClass(str);
            ensure(5);
            byte[] bArr = this.itsPool;
            int i2 = this.itsTop;
            int i3 = i2 + 1;
            this.itsTop = i3;
            bArr[i2] = 9;
            int putInt16 = ClassFileWriter.putInt16(addClass, bArr, i3);
            this.itsTop = putInt16;
            this.itsTop = ClassFileWriter.putInt16(addNameAndType, this.itsPool, putInt16);
            i = this.itsTopIndex;
            this.itsTopIndex = i + 1;
            this.itsFieldRefHash.put(fieldOrMethodRef, i);
        }
        setConstantData(i, fieldOrMethodRef);
        this.itsPoolTypes.put(i, 9);
        return (short) i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short addMethodRef(String str, String str2, String str3) {
        FieldOrMethodRef fieldOrMethodRef = new FieldOrMethodRef(str, str2, str3);
        int i = this.itsMethodRefHash.get(fieldOrMethodRef, -1);
        if (i == -1) {
            short addNameAndType = addNameAndType(str2, str3);
            short addClass = addClass(str);
            ensure(5);
            byte[] bArr = this.itsPool;
            int i2 = this.itsTop;
            int i3 = i2 + 1;
            this.itsTop = i3;
            bArr[i2] = 10;
            int putInt16 = ClassFileWriter.putInt16(addClass, bArr, i3);
            this.itsTop = putInt16;
            this.itsTop = ClassFileWriter.putInt16(addNameAndType, this.itsPool, putInt16);
            i = this.itsTopIndex;
            this.itsTopIndex = i + 1;
            this.itsMethodRefHash.put(fieldOrMethodRef, i);
        }
        setConstantData(i, fieldOrMethodRef);
        this.itsPoolTypes.put(i, 10);
        return (short) i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public short addInterfaceMethodRef(String str, String str2, String str3) {
        short addNameAndType = addNameAndType(str2, str3);
        short addClass = addClass(str);
        ensure(5);
        byte[] bArr = this.itsPool;
        int i = this.itsTop;
        int i2 = i + 1;
        this.itsTop = i2;
        bArr[i] = 11;
        int putInt16 = ClassFileWriter.putInt16(addClass, bArr, i2);
        this.itsTop = putInt16;
        this.itsTop = ClassFileWriter.putInt16(addNameAndType, this.itsPool, putInt16);
        setConstantData(this.itsTopIndex, new FieldOrMethodRef(str, str2, str3));
        this.itsPoolTypes.put(this.itsTopIndex, 11);
        int i3 = this.itsTopIndex;
        this.itsTopIndex = i3 + 1;
        return (short) i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getConstantData(int i) {
        return this.itsConstantData.getObject(i);
    }

    void setConstantData(int i, Object obj) {
        this.itsConstantData.put(i, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte getConstantType(int i) {
        return (byte) this.itsPoolTypes.getInt(i, 0);
    }

    void ensure(int i) {
        int i2 = this.itsTop;
        int i3 = i2 + i;
        byte[] bArr = this.itsPool;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i2 + i > length) {
                length = i2 + i;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.itsPool = bArr2;
        }
    }
}
