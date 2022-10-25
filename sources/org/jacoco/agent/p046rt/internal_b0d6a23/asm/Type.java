package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.fasterxml.jackson.core.JsonPointer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.HttpUrl;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.Type */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/Type.class */
public class Type {
    public static final int VOID = 0;
    public static final int BOOLEAN = 1;
    public static final int CHAR = 2;
    public static final int BYTE = 3;
    public static final int SHORT = 4;
    public static final int INT = 5;
    public static final int FLOAT = 6;
    public static final int LONG = 7;
    public static final int DOUBLE = 8;
    public static final int ARRAY = 9;
    public static final int OBJECT = 10;
    public static final int METHOD = 11;
    public static final Type VOID_TYPE = new Type(0, null, 1443168256, 1);
    public static final Type BOOLEAN_TYPE = new Type(1, null, 1509950721, 1);
    public static final Type CHAR_TYPE = new Type(2, null, 1124075009, 1);
    public static final Type BYTE_TYPE = new Type(3, null, 1107297537, 1);
    public static final Type SHORT_TYPE = new Type(4, null, 1392510721, 1);
    public static final Type INT_TYPE = new Type(5, null, 1224736769, 1);
    public static final Type FLOAT_TYPE = new Type(6, null, 1174536705, 1);
    public static final Type LONG_TYPE = new Type(7, null, 1241579778, 1);
    public static final Type DOUBLE_TYPE = new Type(8, null, 1141048066, 1);
    private final int sort;
    private final char[] buf;
    private final int off;
    private final int len;

    private Type(int sort, char[] buf, int off, int len) {
        this.sort = sort;
        this.buf = buf;
        this.off = off;
        this.len = len;
    }

    public static Type getType(String typeDescriptor) {
        return getType(typeDescriptor.toCharArray(), 0);
    }

    public static Type getObjectType(String internalName) {
        char[] buf = internalName.toCharArray();
        return new Type(buf[0] == '[' ? 9 : 10, buf, 0, buf.length);
    }

    public static Type getMethodType(String methodDescriptor) {
        return getType(methodDescriptor.toCharArray(), 0);
    }

    public static Type getMethodType(Type returnType, Type... argumentTypes) {
        return getType(getMethodDescriptor(returnType, argumentTypes));
    }

    public static Type getType(Class<?> c) {
        if (c.isPrimitive()) {
            if (c == Integer.TYPE) {
                return INT_TYPE;
            }
            if (c == Void.TYPE) {
                return VOID_TYPE;
            }
            if (c == Boolean.TYPE) {
                return BOOLEAN_TYPE;
            }
            if (c == Byte.TYPE) {
                return BYTE_TYPE;
            }
            if (c == Character.TYPE) {
                return CHAR_TYPE;
            }
            if (c == Short.TYPE) {
                return SHORT_TYPE;
            }
            if (c == Double.TYPE) {
                return DOUBLE_TYPE;
            }
            if (c == Float.TYPE) {
                return FLOAT_TYPE;
            }
            return LONG_TYPE;
        }
        return getType(getDescriptor(c));
    }

    public static Type getType(Constructor<?> c) {
        return getType(getConstructorDescriptor(c));
    }

    public static Type getType(Method m) {
        return getType(getMethodDescriptor(m));
    }

    public static Type[] getArgumentTypes(String methodDescriptor) {
        int i;
        char[] buf = methodDescriptor.toCharArray();
        int off = 1;
        int size = 0;
        while (true) {
            int i2 = off;
            off++;
            char car = buf[i2];
            if (car == ')') {
                break;
            } else if (car == 'L') {
                do {
                    i = off;
                    off++;
                } while (buf[i] != ';');
                size++;
            } else if (car != '[') {
                size++;
            }
        }
        Type[] args = new Type[size];
        int off2 = 1;
        int size2 = 0;
        while (buf[off2] != ')') {
            args[size2] = getType(buf, off2);
            off2 += args[size2].len + (args[size2].sort == 10 ? 2 : 0);
            size2++;
        }
        return args;
    }

    public static Type[] getArgumentTypes(Method method) {
        Class<?>[] classes = method.getParameterTypes();
        Type[] types = new Type[classes.length];
        for (int i = classes.length - 1; i >= 0; i--) {
            types[i] = getType(classes[i]);
        }
        return types;
    }

    public static Type getReturnType(String methodDescriptor) {
        char[] buf = methodDescriptor.toCharArray();
        return getType(buf, methodDescriptor.indexOf(41) + 1);
    }

    public static Type getReturnType(Method method) {
        return getType(method.getReturnType());
    }

    public static int getArgumentsAndReturnSizes(String desc) {
        int i;
        char car;
        int n = 1;
        int c = 1;
        while (true) {
            int i2 = c;
            c++;
            char car2 = desc.charAt(i2);
            if (car2 == ')') {
                break;
            } else if (car2 == 'L') {
                do {
                    i = c;
                    c++;
                } while (desc.charAt(i) != ';');
                n++;
            } else if (car2 == '[') {
                while (true) {
                    car = desc.charAt(c);
                    if (car != '[') {
                        break;
                    }
                    c++;
                }
                if (car == 'D' || car == 'J') {
                    n--;
                }
            } else if (car2 == 'D' || car2 == 'J') {
                n += 2;
            } else {
                n++;
            }
        }
        char car3 = desc.charAt(c);
        return (n << 2) | (car3 == 'V' ? 0 : (car3 == 'D' || car3 == 'J') ? 2 : 1);
    }

    private static Type getType(char[] buf, int off) {
        switch (buf[off]) {
            case 'B':
                return BYTE_TYPE;
            case 'C':
                return CHAR_TYPE;
            case 'D':
                return DOUBLE_TYPE;
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
            case 'W':
            case 'X':
            case 'Y':
            default:
                return new Type(11, buf, off, buf.length - off);
            case 'F':
                return FLOAT_TYPE;
            case 'I':
                return INT_TYPE;
            case 'J':
                return LONG_TYPE;
            case 'L':
                int len = 1;
                while (buf[off + len] != ';') {
                    len++;
                }
                return new Type(10, buf, off + 1, len - 1);
            case 'S':
                return SHORT_TYPE;
            case 'V':
                return VOID_TYPE;
            case 'Z':
                return BOOLEAN_TYPE;
            case '[':
                int len2 = 1;
                while (buf[off + len2] == '[') {
                    len2++;
                }
                if (buf[off + len2] == 'L') {
                    while (true) {
                        len2++;
                        if (buf[off + len2] != ';') {
                        }
                    }
                }
                return new Type(9, buf, off, len2 + 1);
        }
    }

    public int getSort() {
        return this.sort;
    }

    public int getDimensions() {
        int i = 1;
        while (this.buf[this.off + i] == '[') {
            i++;
        }
        return i;
    }

    public Type getElementType() {
        return getType(this.buf, this.off + getDimensions());
    }

    public String getClassName() {
        switch (this.sort) {
            case 0:
                return "void";
            case 1:
                return TypedValues.Custom.S_BOOLEAN;
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return TypedValues.Custom.S_FLOAT;
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuffer b = new StringBuffer(getElementType().getClassName());
                for (int i = getDimensions(); i > 0; i--) {
                    b.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                }
                return b.toString();
            case 10:
                return new String(this.buf, this.off, this.len).replace(JsonPointer.SEPARATOR, '.');
            default:
                return null;
        }
    }

    public String getInternalName() {
        return new String(this.buf, this.off, this.len);
    }

    public Type[] getArgumentTypes() {
        return getArgumentTypes(getDescriptor());
    }

    public Type getReturnType() {
        return getReturnType(getDescriptor());
    }

    public int getArgumentsAndReturnSizes() {
        return getArgumentsAndReturnSizes(getDescriptor());
    }

    public String getDescriptor() {
        StringBuffer buf = new StringBuffer();
        getDescriptor(buf);
        return buf.toString();
    }

    public static String getMethodDescriptor(Type returnType, Type... argumentTypes) {
        StringBuffer buf = new StringBuffer();
        buf.append('(');
        for (Type type : argumentTypes) {
            type.getDescriptor(buf);
        }
        buf.append(')');
        returnType.getDescriptor(buf);
        return buf.toString();
    }

    private void getDescriptor(StringBuffer buf) {
        if (this.buf == null) {
            buf.append((char) ((this.off & ViewCompat.MEASURED_STATE_MASK) >>> 24));
        } else if (this.sort == 10) {
            buf.append('L');
            buf.append(this.buf, this.off, this.len);
            buf.append(';');
        } else {
            buf.append(this.buf, this.off, this.len);
        }
    }

    public static String getInternalName(Class<?> c) {
        return c.getName().replace('.', JsonPointer.SEPARATOR);
    }

    public static String getDescriptor(Class<?> c) {
        StringBuffer buf = new StringBuffer();
        getDescriptor(buf, c);
        return buf.toString();
    }

    public static String getConstructorDescriptor(Constructor<?> c) {
        Class<?>[] parameters = c.getParameterTypes();
        StringBuffer buf = new StringBuffer();
        buf.append('(');
        for (Class<?> cls : parameters) {
            getDescriptor(buf, cls);
        }
        return buf.append(")V").toString();
    }

    public static String getMethodDescriptor(Method m) {
        Class<?>[] parameters = m.getParameterTypes();
        StringBuffer buf = new StringBuffer();
        buf.append('(');
        for (Class<?> cls : parameters) {
            getDescriptor(buf, cls);
        }
        buf.append(')');
        getDescriptor(buf, m.getReturnType());
        return buf.toString();
    }

    private static void getDescriptor(StringBuffer buf, Class<?> c) {
        char car;
        Class<?> cls = c;
        while (true) {
            Class<?> d = cls;
            if (d.isPrimitive()) {
                if (d == Integer.TYPE) {
                    car = 'I';
                } else if (d == Void.TYPE) {
                    car = 'V';
                } else if (d == Boolean.TYPE) {
                    car = 'Z';
                } else if (d == Byte.TYPE) {
                    car = 'B';
                } else if (d == Character.TYPE) {
                    car = 'C';
                } else if (d == Short.TYPE) {
                    car = 'S';
                } else if (d == Double.TYPE) {
                    car = 'D';
                } else if (d == Float.TYPE) {
                    car = 'F';
                } else {
                    car = 'J';
                }
                buf.append(car);
                return;
            } else if (d.isArray()) {
                buf.append('[');
                cls = d.getComponentType();
            } else {
                buf.append('L');
                String name = d.getName();
                int len = name.length();
                for (int i = 0; i < len; i++) {
                    char car2 = name.charAt(i);
                    buf.append(car2 == '.' ? JsonPointer.SEPARATOR : car2);
                }
                buf.append(';');
                return;
            }
        }
    }

    public int getSize() {
        if (this.buf == null) {
            return this.off & 255;
        }
        return 1;
    }

    public int getOpcode(int opcode) {
        if (opcode == 46 || opcode == 79) {
            return opcode + (this.buf == null ? (this.off & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8 : 4);
        }
        return opcode + (this.buf == null ? (this.off & 16711680) >> 16 : 4);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Type)) {
            return false;
        }
        Type t = (Type) o;
        if (this.sort != t.sort) {
            return false;
        }
        if (this.sort >= 9) {
            if (this.len != t.len) {
                return false;
            }
            int i = this.off;
            int j = t.off;
            int end = i + this.len;
            while (i < end) {
                if (this.buf[i] == t.buf[j]) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public int hashCode() {
        char c = 13 * this.sort;
        if (this.sort >= 9) {
            int i = this.off;
            int end = i + this.len;
            while (i < end) {
                c = 17 * (c + this.buf[i]);
                i++;
            }
        }
        return c;
    }

    public String toString() {
        return getDescriptor();
    }
}
