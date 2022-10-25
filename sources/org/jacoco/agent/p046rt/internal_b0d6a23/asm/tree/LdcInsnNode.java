package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.Map;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.LdcInsnNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/LdcInsnNode.class */
public class LdcInsnNode extends AbstractInsnNode {
    public Object cst;

    public LdcInsnNode(Object cst) {
        super(18);
        this.cst = cst;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public int getType() {
        return 9;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor mv) {
        mv.visitLdcInsn(this.cst);
        acceptAnnotations(mv);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        return new LdcInsnNode(this.cst).cloneAnnotations(this);
    }
}
