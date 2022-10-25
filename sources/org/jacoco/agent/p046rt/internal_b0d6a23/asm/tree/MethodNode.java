package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Attribute;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Handle;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Type;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.MethodNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/MethodNode.class */
public class MethodNode extends MethodVisitor {
    public int access;
    public String name;
    public String desc;
    public String signature;
    public List<String> exceptions;
    public List<ParameterNode> parameters;
    public List<AnnotationNode> visibleAnnotations;
    public List<AnnotationNode> invisibleAnnotations;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    public List<Attribute> attrs;
    public Object annotationDefault;
    public List<AnnotationNode>[] visibleParameterAnnotations;
    public List<AnnotationNode>[] invisibleParameterAnnotations;
    public InsnList instructions;
    public List<TryCatchBlockNode> tryCatchBlocks;
    public int maxStack;
    public int maxLocals;
    public List<LocalVariableNode> localVariables;
    public List<LocalVariableAnnotationNode> visibleLocalVariableAnnotations;
    public List<LocalVariableAnnotationNode> invisibleLocalVariableAnnotations;
    private boolean visited;

    public MethodNode() {
        this(327680);
        if (getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int api) {
        super(api);
        this.instructions = new InsnList();
    }

    public MethodNode(int access, String name, String desc, String signature, String[] exceptions) {
        this(327680, access, name, desc, signature, exceptions);
        if (getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public MethodNode(int api, int access, String name, String desc, String signature, String[] exceptions) {
        super(api);
        this.access = access;
        this.name = name;
        this.desc = desc;
        this.signature = signature;
        this.exceptions = new ArrayList(exceptions == null ? 0 : exceptions.length);
        boolean isAbstract = (access & 1024) != 0;
        if (!isAbstract) {
            this.localVariables = new ArrayList(5);
        }
        this.tryCatchBlocks = new ArrayList();
        if (exceptions != null) {
            this.exceptions.addAll(Arrays.asList(exceptions));
        }
        this.instructions = new InsnList();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitParameter(String name, int access) {
        if (this.parameters == null) {
            this.parameters = new ArrayList(5);
        }
        this.parameters.add(new ParameterNode(name, access));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitAnnotationDefault() {
        return new AnnotationNode(new ArrayList<Object>(0) { // from class: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.MethodNode.1
            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(Object o) {
                MethodNode.this.annotationDefault = o;
                return super.add(o);
            }
        });
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        AnnotationNode an = new AnnotationNode(desc);
        if (visible) {
            if (this.visibleAnnotations == null) {
                this.visibleAnnotations = new ArrayList(1);
            }
            this.visibleAnnotations.add(an);
        } else {
            if (this.invisibleAnnotations == null) {
                this.invisibleAnnotations = new ArrayList(1);
            }
            this.invisibleAnnotations.add(an);
        }
        return an;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (this.visibleTypeAnnotations == null) {
                this.visibleTypeAnnotations = new ArrayList(1);
            }
            this.visibleTypeAnnotations.add(an);
        } else {
            if (this.invisibleTypeAnnotations == null) {
                this.invisibleTypeAnnotations = new ArrayList(1);
            }
            this.invisibleTypeAnnotations.add(an);
        }
        return an;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitParameterAnnotation(int parameter, String desc, boolean visible) {
        AnnotationNode an = new AnnotationNode(desc);
        if (visible) {
            if (this.visibleParameterAnnotations == null) {
                int params = Type.getArgumentTypes(this.desc).length;
                this.visibleParameterAnnotations = new List[params];
            }
            if (this.visibleParameterAnnotations[parameter] == null) {
                this.visibleParameterAnnotations[parameter] = new ArrayList(1);
            }
            this.visibleParameterAnnotations[parameter].add(an);
        } else {
            if (this.invisibleParameterAnnotations == null) {
                int params2 = Type.getArgumentTypes(this.desc).length;
                this.invisibleParameterAnnotations = new List[params2];
            }
            if (this.invisibleParameterAnnotations[parameter] == null) {
                this.invisibleParameterAnnotations[parameter] = new ArrayList(1);
            }
            this.invisibleParameterAnnotations[parameter].add(an);
        }
        return an;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitAttribute(Attribute attr) {
        if (this.attrs == null) {
            this.attrs = new ArrayList(1);
        }
        this.attrs.add(attr);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitCode() {
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        this.instructions.add(new FrameNode(type, nLocal, local == null ? null : getLabelNodes(local), nStack, stack == null ? null : getLabelNodes(stack)));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitInsn(int opcode) {
        this.instructions.add(new InsnNode(opcode));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitIntInsn(int opcode, int operand) {
        this.instructions.add(new IntInsnNode(opcode, operand));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitVarInsn(int opcode, int var) {
        this.instructions.add(new VarInsnNode(opcode, var));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        this.instructions.add(new TypeInsnNode(opcode, type));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        this.instructions.add(new FieldInsnNode(opcode, owner, name, desc));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    @Deprecated
    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        if (this.api >= 327680) {
            super.visitMethodInsn(opcode, owner, name, desc);
        } else {
            this.instructions.add(new MethodInsnNode(opcode, owner, name, desc));
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (this.api < 327680) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
        } else {
            this.instructions.add(new MethodInsnNode(opcode, owner, name, desc, itf));
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        this.instructions.add(new InvokeDynamicInsnNode(name, desc, bsm, bsmArgs));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        this.instructions.add(new JumpInsnNode(opcode, getLabelNode(label)));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLabel(Label label) {
        this.instructions.add(getLabelNode(label));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLdcInsn(Object cst) {
        this.instructions.add(new LdcInsnNode(cst));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitIincInsn(int var, int increment) {
        this.instructions.add(new IincInsnNode(var, increment));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        this.instructions.add(new TableSwitchInsnNode(min, max, getLabelNode(dflt), getLabelNodes(labels)));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        this.instructions.add(new LookupSwitchInsnNode(getLabelNode(dflt), keys, getLabelNodes(labels)));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.instructions.add(new MultiANewArrayInsnNode(desc, dims));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitInsnAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        AbstractInsnNode insn;
        AbstractInsnNode last = this.instructions.getLast();
        while (true) {
            insn = last;
            if (insn.getOpcode() != -1) {
                break;
            }
            last = insn.getPrevious();
        }
        TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (insn.visibleTypeAnnotations == null) {
                insn.visibleTypeAnnotations = new ArrayList(1);
            }
            insn.visibleTypeAnnotations.add(an);
        } else {
            if (insn.invisibleTypeAnnotations == null) {
                insn.invisibleTypeAnnotations = new ArrayList(1);
            }
            insn.invisibleTypeAnnotations.add(an);
        }
        return an;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        this.tryCatchBlocks.add(new TryCatchBlockNode(getLabelNode(start), getLabelNode(end), getLabelNode(handler), type));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitTryCatchAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        TryCatchBlockNode tcb = this.tryCatchBlocks.get((typeRef & 16776960) >> 8);
        TypeAnnotationNode an = new TypeAnnotationNode(typeRef, typePath, desc);
        if (visible) {
            if (tcb.visibleTypeAnnotations == null) {
                tcb.visibleTypeAnnotations = new ArrayList(1);
            }
            tcb.visibleTypeAnnotations.add(an);
        } else {
            if (tcb.invisibleTypeAnnotations == null) {
                tcb.invisibleTypeAnnotations = new ArrayList(1);
            }
            tcb.invisibleTypeAnnotations.add(an);
        }
        return an;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        this.localVariables.add(new LocalVariableNode(name, desc, signature, getLabelNode(start), getLabelNode(end), index));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public AnnotationVisitor visitLocalVariableAnnotation(int typeRef, TypePath typePath, Label[] start, Label[] end, int[] index, String desc, boolean visible) {
        LocalVariableAnnotationNode an = new LocalVariableAnnotationNode(typeRef, typePath, getLabelNodes(start), getLabelNodes(end), index, desc);
        if (visible) {
            if (this.visibleLocalVariableAnnotations == null) {
                this.visibleLocalVariableAnnotations = new ArrayList(1);
            }
            this.visibleLocalVariableAnnotations.add(an);
        } else {
            if (this.invisibleLocalVariableAnnotations == null) {
                this.invisibleLocalVariableAnnotations = new ArrayList(1);
            }
            this.invisibleLocalVariableAnnotations.add(an);
        }
        return an;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLineNumber(int line, Label start) {
        this.instructions.add(new LineNumberNode(line, getLabelNode(start)));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMaxs(int maxStack, int maxLocals) {
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitEnd() {
    }

    protected LabelNode getLabelNode(Label l) {
        if (!(l.info instanceof LabelNode)) {
            l.info = new LabelNode();
        }
        return (LabelNode) l.info;
    }

    private LabelNode[] getLabelNodes(Label[] l) {
        LabelNode[] nodes = new LabelNode[l.length];
        for (int i = 0; i < l.length; i++) {
            nodes[i] = getLabelNode(l[i]);
        }
        return nodes;
    }

    private Object[] getLabelNodes(Object[] objs) {
        Object[] nodes = new Object[objs.length];
        for (int i = 0; i < objs.length; i++) {
            Object o = objs[i];
            if (o instanceof Label) {
                o = getLabelNode((Label) o);
            }
            nodes[i] = o;
        }
        return nodes;
    }

    public void check(int api) {
        if (api == 262144) {
            if (this.visibleTypeAnnotations != null && this.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (this.invisibleTypeAnnotations != null && this.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            int n = this.tryCatchBlocks == null ? 0 : this.tryCatchBlocks.size();
            for (int i = 0; i < n; i++) {
                TryCatchBlockNode tcb = this.tryCatchBlocks.get(i);
                if (tcb.visibleTypeAnnotations != null && tcb.visibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (tcb.invisibleTypeAnnotations != null && tcb.invisibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
            }
            for (int i2 = 0; i2 < this.instructions.size(); i2++) {
                AbstractInsnNode insn = this.instructions.get(i2);
                if (insn.visibleTypeAnnotations != null && insn.visibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (insn.invisibleTypeAnnotations != null && insn.invisibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (insn instanceof MethodInsnNode) {
                    boolean itf = ((MethodInsnNode) insn).itf;
                    if (itf != (insn.opcode == 185)) {
                        throw new RuntimeException();
                    }
                }
            }
            if (this.visibleLocalVariableAnnotations != null && this.visibleLocalVariableAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (this.invisibleLocalVariableAnnotations != null && this.invisibleLocalVariableAnnotations.size() > 0) {
                throw new RuntimeException();
            }
        }
    }

    public void accept(ClassVisitor cv) {
        String[] exceptions = new String[this.exceptions.size()];
        this.exceptions.toArray(exceptions);
        MethodVisitor mv = cv.visitMethod(this.access, this.name, this.desc, this.signature, exceptions);
        if (mv != null) {
            accept(mv);
        }
    }

    public void accept(MethodVisitor mv) {
        int n = this.parameters == null ? 0 : this.parameters.size();
        for (int i = 0; i < n; i++) {
            ParameterNode parameter = this.parameters.get(i);
            mv.visitParameter(parameter.name, parameter.access);
        }
        if (this.annotationDefault != null) {
            AnnotationVisitor av = mv.visitAnnotationDefault();
            AnnotationNode.accept(av, null, this.annotationDefault);
            if (av != null) {
                av.visitEnd();
            }
        }
        int n2 = this.visibleAnnotations == null ? 0 : this.visibleAnnotations.size();
        for (int i2 = 0; i2 < n2; i2++) {
            AnnotationNode an = this.visibleAnnotations.get(i2);
            an.accept(mv.visitAnnotation(an.desc, true));
        }
        int n3 = this.invisibleAnnotations == null ? 0 : this.invisibleAnnotations.size();
        for (int i3 = 0; i3 < n3; i3++) {
            AnnotationNode an2 = this.invisibleAnnotations.get(i3);
            an2.accept(mv.visitAnnotation(an2.desc, false));
        }
        int n4 = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (int i4 = 0; i4 < n4; i4++) {
            TypeAnnotationNode an3 = this.visibleTypeAnnotations.get(i4);
            an3.accept(mv.visitTypeAnnotation(an3.typeRef, an3.typePath, an3.desc, true));
        }
        int n5 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (int i5 = 0; i5 < n5; i5++) {
            TypeAnnotationNode an4 = this.invisibleTypeAnnotations.get(i5);
            an4.accept(mv.visitTypeAnnotation(an4.typeRef, an4.typePath, an4.desc, false));
        }
        int n6 = this.visibleParameterAnnotations == null ? 0 : this.visibleParameterAnnotations.length;
        for (int i6 = 0; i6 < n6; i6++) {
            List<?> l = this.visibleParameterAnnotations[i6];
            if (l != null) {
                for (int j = 0; j < l.size(); j++) {
                    AnnotationNode an5 = l.get(j);
                    an5.accept(mv.visitParameterAnnotation(i6, an5.desc, true));
                }
            }
        }
        int n7 = this.invisibleParameterAnnotations == null ? 0 : this.invisibleParameterAnnotations.length;
        for (int i7 = 0; i7 < n7; i7++) {
            List<?> l2 = this.invisibleParameterAnnotations[i7];
            if (l2 != null) {
                for (int j2 = 0; j2 < l2.size(); j2++) {
                    AnnotationNode an6 = l2.get(j2);
                    an6.accept(mv.visitParameterAnnotation(i7, an6.desc, false));
                }
            }
        }
        if (this.visited) {
            this.instructions.resetLabels();
        }
        int n8 = this.attrs == null ? 0 : this.attrs.size();
        for (int i8 = 0; i8 < n8; i8++) {
            mv.visitAttribute(this.attrs.get(i8));
        }
        if (this.instructions.size() > 0) {
            mv.visitCode();
            int n9 = this.tryCatchBlocks == null ? 0 : this.tryCatchBlocks.size();
            for (int i9 = 0; i9 < n9; i9++) {
                this.tryCatchBlocks.get(i9).updateIndex(i9);
                this.tryCatchBlocks.get(i9).accept(mv);
            }
            this.instructions.accept(mv);
            int n10 = this.localVariables == null ? 0 : this.localVariables.size();
            for (int i10 = 0; i10 < n10; i10++) {
                this.localVariables.get(i10).accept(mv);
            }
            int n11 = this.visibleLocalVariableAnnotations == null ? 0 : this.visibleLocalVariableAnnotations.size();
            for (int i11 = 0; i11 < n11; i11++) {
                this.visibleLocalVariableAnnotations.get(i11).accept(mv, true);
            }
            int n12 = this.invisibleLocalVariableAnnotations == null ? 0 : this.invisibleLocalVariableAnnotations.size();
            for (int i12 = 0; i12 < n12; i12++) {
                this.invisibleLocalVariableAnnotations.get(i12).accept(mv, false);
            }
            mv.visitMaxs(this.maxStack, this.maxLocals);
            this.visited = true;
        }
        mv.visitEnd();
    }
}
