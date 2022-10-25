package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.Map;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.InsnNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/InsnNode.class */
public class InsnNode extends AbstractInsnNode {
    public InsnNode(int opcode) {
        super(opcode);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public int getType() {
        return 0;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor mv) {
        mv.visitInsn(this.opcode);
        acceptAnnotations(mv);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        return new InsnNode(this.opcode).cloneAnnotations(this);
    }
}
