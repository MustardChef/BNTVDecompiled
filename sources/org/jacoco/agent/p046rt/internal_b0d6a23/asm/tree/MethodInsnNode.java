package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.Map;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.MethodInsnNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/MethodInsnNode.class */
public class MethodInsnNode extends AbstractInsnNode {
    public String owner;
    public String name;
    public String desc;
    public boolean itf;

    @Deprecated
    public MethodInsnNode(int opcode, String owner, String name, String desc) {
        this(opcode, owner, name, desc, opcode == 185);
    }

    public MethodInsnNode(int opcode, String owner, String name, String desc, boolean itf) {
        super(opcode);
        this.owner = owner;
        this.name = name;
        this.desc = desc;
        this.itf = itf;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public int getType() {
        return 5;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor mv) {
        mv.visitMethodInsn(this.opcode, this.owner, this.name, this.desc, this.itf);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        return new MethodInsnNode(this.opcode, this.owner, this.name, this.desc, this.itf);
    }
}
