package org.mozilla.classfile;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.fasterxml.jackson.core.JsonPointer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClassFileWriter.java */
/* loaded from: classes5.dex */
public final class TypeInfo {
    static final int DOUBLE = 3;
    static final int FLOAT = 2;
    static final int INTEGER = 1;
    static final int LONG = 4;
    static final int NULL = 5;
    static final int OBJECT_TAG = 7;
    static final int TOP = 0;
    static final int UNINITIALIZED_THIS = 6;
    static final int UNINITIALIZED_VAR_TAG = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int OBJECT(int i) {
        return ((i & 65535) << 8) | 7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int UNINITIALIZED_VARIABLE(int i) {
        return ((i & 65535) << 8) | 8;
    }

    static final int getPayload(int i) {
        return i >>> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int getTag(int i) {
        return i & 255;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isTwoWords(int i) {
        return i == 3 || i == 4;
    }

    private TypeInfo() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int OBJECT(String str, ConstantPool constantPool) {
        return OBJECT(constantPool.addClass(str));
    }

    static final String getPayloadAsType(int i, ConstantPool constantPool) {
        if (getTag(i) == 7) {
            return (String) constantPool.getConstantData(getPayload(i));
        }
        throw new IllegalArgumentException("expecting object type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int fromType(String str, ConstantPool constantPool) {
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (charAt != 'F') {
                if (charAt != 'S' && charAt != 'Z' && charAt != 'I') {
                    if (charAt != 'J') {
                        switch (charAt) {
                            case 'B':
                            case 'C':
                                break;
                            case 'D':
                                return 3;
                            default:
                                throw new IllegalArgumentException("bad type");
                        }
                    } else {
                        return 4;
                    }
                }
                return 1;
            }
            return 2;
        }
        return OBJECT(str, constantPool);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int merge(int i, int i2, ConstantPool constantPool) {
        int tag = getTag(i);
        int tag2 = getTag(i2);
        boolean z = tag == 7;
        boolean z2 = tag2 == 7;
        if (i == i2 || (z && i2 == 5)) {
            return i;
        }
        if (tag == 0 || tag2 == 0) {
            return 0;
        }
        if (i == 5 && z2) {
            return i2;
        }
        if (z && z2) {
            String payloadAsType = getPayloadAsType(i, constantPool);
            String payloadAsType2 = getPayloadAsType(i2, constantPool);
            String str = (String) constantPool.getConstantData(2);
            String str2 = (String) constantPool.getConstantData(4);
            if (payloadAsType.equals(str)) {
                payloadAsType = str2;
            }
            if (payloadAsType2.equals(str)) {
                payloadAsType2 = str2;
            }
            Class<?> classFromInternalName = getClassFromInternalName(payloadAsType);
            Class<?> classFromInternalName2 = getClassFromInternalName(payloadAsType2);
            if (classFromInternalName.isAssignableFrom(classFromInternalName2)) {
                return i;
            }
            if (classFromInternalName2.isAssignableFrom(classFromInternalName)) {
                return i2;
            }
            if (classFromInternalName2.isInterface() || classFromInternalName.isInterface()) {
                return OBJECT("java/lang/Object", constantPool);
            }
            for (Class<? super Object> superclass = classFromInternalName2.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                if (superclass.isAssignableFrom(classFromInternalName)) {
                    return OBJECT(ClassFileWriter.getSlashedForm(superclass.getName()), constantPool);
                }
            }
        }
        throw new IllegalArgumentException("bad merge attempt between " + toString(i, constantPool) + " and " + toString(i2, constantPool));
    }

    static String toString(int i, ConstantPool constantPool) {
        int tag = getTag(i);
        switch (tag) {
            case 0:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 1:
                return "int";
            case 2:
                return TypedValues.Custom.S_FLOAT;
            case 3:
                return "double";
            case 4:
                return "long";
            case 5:
                return "null";
            case 6:
                return "uninitialized_this";
            default:
                if (tag == 7) {
                    return getPayloadAsType(i, constantPool);
                }
                if (tag == 8) {
                    return "uninitialized";
                }
                throw new IllegalArgumentException("bad type");
        }
    }

    static Class getClassFromInternalName(String str) {
        try {
            return Class.forName(str.replace(JsonPointer.SEPARATOR, '.'));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String toString(int[] iArr, ConstantPool constantPool) {
        return toString(iArr, iArr.length, constantPool);
    }

    static String toString(int[] iArr, int i, ConstantPool constantPool) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(toString(iArr[i2], constantPool));
        }
        sb.append("]");
        return sb.toString();
    }

    static void print(int[] iArr, int[] iArr2, ConstantPool constantPool) {
        print(iArr, iArr.length, iArr2, iArr2.length, constantPool);
    }

    static void print(int[] iArr, int i, int[] iArr2, int i2, ConstantPool constantPool) {
        System.out.print("locals: ");
        System.out.println(toString(iArr, i, constantPool));
        System.out.print("stack: ");
        System.out.println(toString(iArr2, i2, constantPool));
        System.out.println();
    }
}
