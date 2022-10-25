package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.LocalVariableNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/LocalVariableNode.class */
public class LocalVariableNode {
    public String name;
    public String desc;
    public String signature;
    public LabelNode start;
    public LabelNode end;
    public int index;

    public LocalVariableNode(String name, String desc, String signature, LabelNode start, LabelNode end, int index) {
        this.name = name;
        this.desc = desc;
        this.signature = signature;
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public void accept(MethodVisitor mv) {
        mv.visitLocalVariable(this.name, this.desc, this.signature, this.start.getLabel(), this.end.getLabel(), this.index);
    }
}
