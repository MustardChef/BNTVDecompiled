package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.AbstractInsnNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/AbstractInsnNode.class */
public abstract class AbstractInsnNode {
    public static final int INSN = 0;
    public static final int INT_INSN = 1;
    public static final int VAR_INSN = 2;
    public static final int TYPE_INSN = 3;
    public static final int FIELD_INSN = 4;
    public static final int METHOD_INSN = 5;
    public static final int INVOKE_DYNAMIC_INSN = 6;
    public static final int JUMP_INSN = 7;
    public static final int LABEL = 8;
    public static final int LDC_INSN = 9;
    public static final int IINC_INSN = 10;
    public static final int TABLESWITCH_INSN = 11;
    public static final int LOOKUPSWITCH_INSN = 12;
    public static final int MULTIANEWARRAY_INSN = 13;
    public static final int FRAME = 14;
    public static final int LINE = 15;
    protected int opcode;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;
    AbstractInsnNode prev;
    AbstractInsnNode next;
    int index = -1;

    public abstract int getType();

    public abstract void accept(MethodVisitor methodVisitor);

    public abstract AbstractInsnNode clone(Map<LabelNode, LabelNode> map);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractInsnNode(int opcode) {
        this.opcode = opcode;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public AbstractInsnNode getPrevious() {
        return this.prev;
    }

    public AbstractInsnNode getNext() {
        return this.next;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void acceptAnnotations(MethodVisitor mv) {
        int n = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (int i = 0; i < n; i++) {
            TypeAnnotationNode an = this.visibleTypeAnnotations.get(i);
            an.accept(mv.visitInsnAnnotation(an.typeRef, an.typePath, an.desc, true));
        }
        int n2 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (int i2 = 0; i2 < n2; i2++) {
            TypeAnnotationNode an2 = this.invisibleTypeAnnotations.get(i2);
            an2.accept(mv.visitInsnAnnotation(an2.typeRef, an2.typePath, an2.desc, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LabelNode clone(LabelNode label, Map<LabelNode, LabelNode> map) {
        return map.get(label);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LabelNode[] clone(List<LabelNode> labels, Map<LabelNode, LabelNode> map) {
        LabelNode[] clones = new LabelNode[labels.size()];
        for (int i = 0; i < clones.length; i++) {
            clones[i] = map.get(labels.get(i));
        }
        return clones;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AbstractInsnNode cloneAnnotations(AbstractInsnNode insn) {
        if (insn.visibleTypeAnnotations != null) {
            this.visibleTypeAnnotations = new ArrayList();
            for (int i = 0; i < insn.visibleTypeAnnotations.size(); i++) {
                TypeAnnotationNode src = insn.visibleTypeAnnotations.get(i);
                TypeAnnotationNode ann = new TypeAnnotationNode(src.typeRef, src.typePath, src.desc);
                src.accept(ann);
                this.visibleTypeAnnotations.add(ann);
            }
        }
        if (insn.invisibleTypeAnnotations != null) {
            this.invisibleTypeAnnotations = new ArrayList();
            for (int i2 = 0; i2 < insn.invisibleTypeAnnotations.size(); i2++) {
                TypeAnnotationNode src2 = insn.invisibleTypeAnnotations.get(i2);
                TypeAnnotationNode ann2 = new TypeAnnotationNode(src2.typeRef, src2.typePath, src2.desc);
                src2.accept(ann2);
                this.invisibleTypeAnnotations.add(ann2);
            }
        }
        return this;
    }
}
