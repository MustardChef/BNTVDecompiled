package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.Frame */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/Frame.class */
public final class Frame {
    static final int DIM = -268435456;
    static final int ARRAY_OF = 268435456;
    static final int ELEMENT_OF = -268435456;
    static final int KIND = 251658240;
    static final int TOP_IF_LONG_OR_DOUBLE = 8388608;
    static final int VALUE = 8388607;
    static final int BASE_KIND = 267386880;
    static final int BASE_VALUE = 1048575;
    static final int BASE = 16777216;
    static final int OBJECT = 24117248;
    static final int UNINITIALIZED = 25165824;
    private static final int LOCAL = 33554432;
    private static final int STACK = 50331648;
    static final int TOP = 16777216;
    static final int BOOLEAN = 16777225;
    static final int BYTE = 16777226;
    static final int CHAR = 16777227;
    static final int SHORT = 16777228;
    static final int INTEGER = 16777217;
    static final int FLOAT = 16777218;
    static final int DOUBLE = 16777219;
    static final int LONG = 16777220;
    static final int NULL = 16777221;
    static final int UNINITIALIZED_THIS = 16777222;
    static final int[] SIZE;
    Label owner;
    int[] inputLocals;
    int[] inputStack;
    private int[] outputLocals;
    private int[] outputStack;
    private int outputStackTop;
    private int initializationCount;
    private int[] initializations;

    static {
        int[] b = new int[202];
        for (int i = 0; i < b.length; i++) {
            b[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
        }
        SIZE = b;
    }

    private int get(int local) {
        if (this.outputLocals == null || local >= this.outputLocals.length) {
            return LOCAL | local;
        }
        int type = this.outputLocals[local];
        if (type == 0) {
            int[] iArr = this.outputLocals;
            int i = LOCAL | local;
            iArr[local] = i;
            type = i;
        }
        return type;
    }

    private void set(int local, int type) {
        if (this.outputLocals == null) {
            this.outputLocals = new int[10];
        }
        int n = this.outputLocals.length;
        if (local >= n) {
            int[] t = new int[Math.max(local + 1, 2 * n)];
            System.arraycopy(this.outputLocals, 0, t, 0, n);
            this.outputLocals = t;
        }
        this.outputLocals[local] = type;
    }

    private void push(int type) {
        if (this.outputStack == null) {
            this.outputStack = new int[10];
        }
        int n = this.outputStack.length;
        if (this.outputStackTop >= n) {
            int[] t = new int[Math.max(this.outputStackTop + 1, 2 * n)];
            System.arraycopy(this.outputStack, 0, t, 0, n);
            this.outputStack = t;
        }
        int[] iArr = this.outputStack;
        int i = this.outputStackTop;
        this.outputStackTop = i + 1;
        iArr[i] = type;
        int top = this.owner.inputStackTop + this.outputStackTop;
        if (top > this.owner.outputStackMax) {
            this.owner.outputStackMax = top;
        }
    }

    private void push(ClassWriter cw, String desc) {
        int type = type(cw, desc);
        if (type != 0) {
            push(type);
            if (type == LONG || type == DOUBLE) {
                push(16777216);
            }
        }
    }

    private static int type(ClassWriter cw, String desc) {
        int data;
        int index = desc.charAt(0) == '(' ? desc.indexOf(41) + 1 : 0;
        switch (desc.charAt(index)) {
            case 'B':
            case 'C':
            case 'I':
            case 'S':
            case 'Z':
                return INTEGER;
            case 'D':
                return DOUBLE;
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
                int dims = index + 1;
                while (desc.charAt(dims) == '[') {
                    dims++;
                }
                switch (desc.charAt(dims)) {
                    case 'B':
                        data = BYTE;
                        break;
                    case 'C':
                        data = CHAR;
                        break;
                    case 'D':
                        data = DOUBLE;
                        break;
                    case 'E':
                    case 'G':
                    case 'H':
                    case 'K':
                    case 'L':
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
                        String t = desc.substring(dims + 1, desc.length() - 1);
                        data = OBJECT | cw.addType(t);
                        break;
                    case 'F':
                        data = FLOAT;
                        break;
                    case 'I':
                        data = INTEGER;
                        break;
                    case 'J':
                        data = LONG;
                        break;
                    case 'S':
                        data = SHORT;
                        break;
                    case 'Z':
                        data = BOOLEAN;
                        break;
                }
                return ((dims - index) << 28) | data;
            case 'F':
                return FLOAT;
            case 'J':
                return LONG;
            case 'L':
                String t2 = desc.substring(index + 1, desc.length() - 1);
                return OBJECT | cw.addType(t2);
            case 'V':
                return 0;
        }
    }

    private int pop() {
        if (this.outputStackTop > 0) {
            int[] iArr = this.outputStack;
            int i = this.outputStackTop - 1;
            this.outputStackTop = i;
            return iArr[i];
        }
        Label label = this.owner;
        int i2 = label.inputStackTop - 1;
        label.inputStackTop = i2;
        return STACK | (-i2);
    }

    private void pop(int elements) {
        if (this.outputStackTop >= elements) {
            this.outputStackTop -= elements;
            return;
        }
        this.owner.inputStackTop -= elements - this.outputStackTop;
        this.outputStackTop = 0;
    }

    private void pop(String desc) {
        char c = desc.charAt(0);
        if (c == '(') {
            pop((Type.getArgumentsAndReturnSizes(desc) >> 2) - 1);
        } else if (c == 'J' || c == 'D') {
            pop(2);
        } else {
            pop(1);
        }
    }

    private void init(int var) {
        if (this.initializations == null) {
            this.initializations = new int[2];
        }
        int n = this.initializations.length;
        if (this.initializationCount >= n) {
            int[] t = new int[Math.max(this.initializationCount + 1, 2 * n)];
            System.arraycopy(this.initializations, 0, t, 0, n);
            this.initializations = t;
        }
        int[] iArr = this.initializations;
        int i = this.initializationCount;
        this.initializationCount = i + 1;
        iArr[i] = var;
    }

    private int init(ClassWriter cw, int t) {
        int s;
        if (t == UNINITIALIZED_THIS) {
            s = OBJECT | cw.addType(cw.thisName);
        } else if ((t & (-1048576)) == UNINITIALIZED) {
            String type = cw.typeTable[t & BASE_VALUE].strVal1;
            s = OBJECT | cw.addType(type);
        } else {
            return t;
        }
        for (int j = 0; j < this.initializationCount; j++) {
            int u = this.initializations[j];
            int dim = u & (-268435456);
            int kind = u & KIND;
            if (kind == LOCAL) {
                u = dim + this.inputLocals[u & VALUE];
            } else if (kind == STACK) {
                u = dim + this.inputStack[this.inputStack.length - (u & VALUE)];
            }
            if (t == u) {
                return s;
            }
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initInputFrame(ClassWriter cw, int access, Type[] args, int maxLocals) {
        this.inputLocals = new int[maxLocals];
        this.inputStack = new int[0];
        int i = 0;
        if ((access & 8) == 0) {
            if ((access & 524288) == 0) {
                i = 0 + 1;
                this.inputLocals[0] = OBJECT | cw.addType(cw.thisName);
            } else {
                i = 0 + 1;
                this.inputLocals[0] = UNINITIALIZED_THIS;
            }
        }
        for (Type type : args) {
            int t = type(cw, type.getDescriptor());
            int i2 = i;
            i++;
            this.inputLocals[i2] = t;
            if (t == LONG || t == DOUBLE) {
                i++;
                this.inputLocals[i] = 16777216;
            }
        }
        while (i < maxLocals) {
            int i3 = i;
            i++;
            this.inputLocals[i3] = 16777216;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void execute(int opcode, int arg, ClassWriter cw, Item item) {
        switch (opcode) {
            case 0:
            case 116:
            case 117:
            case 118:
            case 119:
            case 145:
            case 146:
            case 147:
            case 167:
            case 177:
                return;
            case 1:
                push(NULL);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 16:
            case 17:
            case 21:
                push(INTEGER);
                return;
            case 9:
            case 10:
            case 22:
                push(LONG);
                push(16777216);
                return;
            case 11:
            case 12:
            case 13:
            case 23:
                push(FLOAT);
                return;
            case 14:
            case 15:
            case 24:
                push(DOUBLE);
                push(16777216);
                return;
            case 18:
                switch (item.type) {
                    case 3:
                        push(INTEGER);
                        return;
                    case 4:
                        push(FLOAT);
                        return;
                    case 5:
                        push(LONG);
                        push(16777216);
                        return;
                    case 6:
                        push(DOUBLE);
                        push(16777216);
                        return;
                    case 7:
                        push(OBJECT | cw.addType("java/lang/Class"));
                        return;
                    case 8:
                        push(OBJECT | cw.addType("java/lang/String"));
                        return;
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    default:
                        push(OBJECT | cw.addType("java/lang/invoke/MethodHandle"));
                        return;
                    case 16:
                        push(OBJECT | cw.addType("java/lang/invoke/MethodType"));
                        return;
                }
            case 19:
            case 20:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 196:
            case 197:
            default:
                pop(arg);
                push(cw, item.strVal1);
                return;
            case 25:
                push(get(arg));
                return;
            case 46:
            case 51:
            case 52:
            case 53:
                pop(2);
                push(INTEGER);
                return;
            case 47:
            case 143:
                pop(2);
                push(LONG);
                push(16777216);
                return;
            case 48:
                pop(2);
                push(FLOAT);
                return;
            case 49:
            case 138:
                pop(2);
                push(DOUBLE);
                push(16777216);
                return;
            case 50:
                pop(1);
                int t1 = pop();
                push((-268435456) + t1);
                return;
            case 54:
            case 56:
            case 58:
                int t12 = pop();
                set(arg, t12);
                if (arg > 0) {
                    int t2 = get(arg - 1);
                    if (t2 == LONG || t2 == DOUBLE) {
                        set(arg - 1, 16777216);
                        return;
                    } else if ((t2 & KIND) != 16777216) {
                        set(arg - 1, t2 | 8388608);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 55:
            case 57:
                pop(1);
                int t13 = pop();
                set(arg, t13);
                set(arg + 1, 16777216);
                if (arg > 0) {
                    int t22 = get(arg - 1);
                    if (t22 == LONG || t22 == DOUBLE) {
                        set(arg - 1, 16777216);
                        return;
                    } else if ((t22 & KIND) != 16777216) {
                        set(arg - 1, t22 | 8388608);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            case 79:
            case 81:
            case 83:
            case 84:
            case 85:
            case 86:
                pop(3);
                return;
            case 80:
            case 82:
                pop(4);
                return;
            case 87:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 170:
            case 171:
            case 172:
            case 174:
            case 176:
            case 191:
            case 194:
            case 195:
            case 198:
            case 199:
                pop(1);
                return;
            case 88:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 173:
            case 175:
                pop(2);
                return;
            case 89:
                int t14 = pop();
                push(t14);
                push(t14);
                return;
            case 90:
                int t15 = pop();
                int t23 = pop();
                push(t15);
                push(t23);
                push(t15);
                return;
            case 91:
                int t16 = pop();
                int t24 = pop();
                int t3 = pop();
                push(t16);
                push(t3);
                push(t24);
                push(t16);
                return;
            case 92:
                int t17 = pop();
                int t25 = pop();
                push(t25);
                push(t17);
                push(t25);
                push(t17);
                return;
            case 93:
                int t18 = pop();
                int t26 = pop();
                int t32 = pop();
                push(t26);
                push(t18);
                push(t32);
                push(t26);
                push(t18);
                return;
            case 94:
                int t19 = pop();
                int t27 = pop();
                int t33 = pop();
                int t4 = pop();
                push(t27);
                push(t19);
                push(t4);
                push(t33);
                push(t27);
                push(t19);
                return;
            case 95:
                int t110 = pop();
                int t28 = pop();
                push(t110);
                push(t28);
                return;
            case 96:
            case 100:
            case 104:
            case 108:
            case 112:
            case 120:
            case 122:
            case 124:
            case 126:
            case 128:
            case 130:
            case 136:
            case 142:
            case 149:
            case 150:
                pop(2);
                push(INTEGER);
                return;
            case 97:
            case 101:
            case 105:
            case 109:
            case 113:
            case 127:
            case 129:
            case 131:
                pop(4);
                push(LONG);
                push(16777216);
                return;
            case 98:
            case 102:
            case 106:
            case 110:
            case 114:
            case 137:
            case 144:
                pop(2);
                push(FLOAT);
                return;
            case 99:
            case 103:
            case 107:
            case 111:
            case 115:
                pop(4);
                push(DOUBLE);
                push(16777216);
                return;
            case 121:
            case 123:
            case 125:
                pop(3);
                push(LONG);
                push(16777216);
                return;
            case 132:
                set(arg, INTEGER);
                return;
            case 133:
            case 140:
                pop(1);
                push(LONG);
                push(16777216);
                return;
            case 134:
                pop(1);
                push(FLOAT);
                return;
            case 135:
            case 141:
                pop(1);
                push(DOUBLE);
                push(16777216);
                return;
            case 139:
            case 190:
            case 193:
                pop(1);
                push(INTEGER);
                return;
            case 148:
            case 151:
            case 152:
                pop(4);
                push(INTEGER);
                return;
            case 168:
            case 169:
                throw new RuntimeException("JSR/RET are not supported with computeFrames option");
            case 178:
                push(cw, item.strVal3);
                return;
            case 179:
                pop(item.strVal3);
                return;
            case 180:
                pop(1);
                push(cw, item.strVal3);
                return;
            case 181:
                pop(item.strVal3);
                pop();
                return;
            case 182:
            case 183:
            case 184:
            case 185:
                pop(item.strVal3);
                if (opcode != 184) {
                    int t111 = pop();
                    if (opcode == 183 && item.strVal2.charAt(0) == '<') {
                        init(t111);
                    }
                }
                push(cw, item.strVal3);
                return;
            case 186:
                pop(item.strVal2);
                push(cw, item.strVal2);
                return;
            case 187:
                push(UNINITIALIZED | cw.addUninitializedType(item.strVal1, arg));
                return;
            case 188:
                pop();
                switch (arg) {
                    case 4:
                        push(285212681);
                        return;
                    case 5:
                        push(285212683);
                        return;
                    case 6:
                        push(285212674);
                        return;
                    case 7:
                        push(285212675);
                        return;
                    case 8:
                        push(285212682);
                        return;
                    case 9:
                        push(285212684);
                        return;
                    case 10:
                        push(285212673);
                        return;
                    default:
                        push(285212676);
                        return;
                }
            case 189:
                String s = item.strVal1;
                pop();
                if (s.charAt(0) == '[') {
                    push(cw, '[' + s);
                    return;
                } else {
                    push(292552704 | cw.addType(s));
                    return;
                }
            case 192:
                String s2 = item.strVal1;
                pop();
                if (s2.charAt(0) == '[') {
                    push(cw, s2);
                    return;
                } else {
                    push(OBJECT | cw.addType(s2));
                    return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean merge(ClassWriter cw, Frame frame, int edge) {
        int t;
        int t2;
        boolean changed = false;
        int nLocal = this.inputLocals.length;
        int nStack = this.inputStack.length;
        if (frame.inputLocals == null) {
            frame.inputLocals = new int[nLocal];
            changed = true;
        }
        for (int i = 0; i < nLocal; i++) {
            if (this.outputLocals != null && i < this.outputLocals.length) {
                int s = this.outputLocals[i];
                if (s == 0) {
                    t2 = this.inputLocals[i];
                } else {
                    int dim = s & (-268435456);
                    int kind = s & KIND;
                    if (kind == 16777216) {
                        t2 = s;
                    } else {
                        if (kind == LOCAL) {
                            t2 = dim + this.inputLocals[s & VALUE];
                        } else {
                            t2 = dim + this.inputStack[nStack - (s & VALUE)];
                        }
                        if ((s & 8388608) != 0 && (t2 == LONG || t2 == DOUBLE)) {
                            t2 = 16777216;
                        }
                    }
                }
            } else {
                t2 = this.inputLocals[i];
            }
            if (this.initializations != null) {
                t2 = init(cw, t2);
            }
            changed |= merge(cw, t2, frame.inputLocals, i);
        }
        if (edge > 0) {
            for (int i2 = 0; i2 < nLocal; i2++) {
                int t3 = this.inputLocals[i2];
                changed |= merge(cw, t3, frame.inputLocals, i2);
            }
            if (frame.inputStack == null) {
                frame.inputStack = new int[1];
                changed = true;
            }
            return changed | merge(cw, edge, frame.inputStack, 0);
        }
        int nInputStack = this.inputStack.length + this.owner.inputStackTop;
        if (frame.inputStack == null) {
            frame.inputStack = new int[nInputStack + this.outputStackTop];
            changed = true;
        }
        for (int i3 = 0; i3 < nInputStack; i3++) {
            int t4 = this.inputStack[i3];
            if (this.initializations != null) {
                t4 = init(cw, t4);
            }
            changed |= merge(cw, t4, frame.inputStack, i3);
        }
        for (int i4 = 0; i4 < this.outputStackTop; i4++) {
            int s2 = this.outputStack[i4];
            int dim2 = s2 & (-268435456);
            int kind2 = s2 & KIND;
            if (kind2 == 16777216) {
                t = s2;
            } else {
                if (kind2 == LOCAL) {
                    t = dim2 + this.inputLocals[s2 & VALUE];
                } else {
                    t = dim2 + this.inputStack[nStack - (s2 & VALUE)];
                }
                if ((s2 & 8388608) != 0 && (t == LONG || t == DOUBLE)) {
                    t = 16777216;
                }
            }
            if (this.initializations != null) {
                t = init(cw, t);
            }
            changed |= merge(cw, t, frame.inputStack, nInputStack + i4);
        }
        return changed;
    }

    private static boolean merge(ClassWriter cw, int t, int[] types, int index) {
        int v;
        int u = types[index];
        if (u == t) {
            return false;
        }
        if ((t & 268435455) == NULL) {
            if (u == NULL) {
                return false;
            }
            t = NULL;
        }
        if (u == 0) {
            types[index] = t;
            return true;
        }
        if ((u & BASE_KIND) == OBJECT || (u & (-268435456)) != 0) {
            if (t == NULL) {
                return false;
            }
            if ((t & (-1048576)) == (u & (-1048576))) {
                if ((u & BASE_KIND) == OBJECT) {
                    v = (t & (-268435456)) | OBJECT | cw.getMergedType(t & BASE_VALUE, u & BASE_VALUE);
                } else {
                    v = OBJECT | cw.addType("java/lang/Object");
                }
            } else if ((t & BASE_KIND) == OBJECT || (t & (-268435456)) != 0) {
                int tdim = t & (-268435456);
                int udim = u & (-268435456);
                v = (udim != tdim ? Math.min(tdim, udim) : 0) | OBJECT | cw.addType("java/lang/Object");
            } else {
                v = 16777216;
            }
        } else if (u == NULL) {
            v = ((t & BASE_KIND) == OBJECT || (t & (-268435456)) != 0) ? t : 16777216;
        } else {
            v = 16777216;
        }
        if (u != v) {
            types[index] = v;
            return true;
        }
        return false;
    }
}
