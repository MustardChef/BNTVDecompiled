package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.FrameNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/FrameNode.class */
public class FrameNode extends AbstractInsnNode {
    public int type;
    public List<Object> local;
    public List<Object> stack;

    private FrameNode() {
        super(-1);
    }

    public FrameNode(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        super(-1);
        this.type = type;
        switch (type) {
            case -1:
            case 0:
                this.local = asList(nLocal, local);
                this.stack = asList(nStack, stack);
                return;
            case 1:
                this.local = asList(nLocal, local);
                return;
            case 2:
                this.local = Arrays.asList(new Object[nLocal]);
                return;
            case 3:
            default:
                return;
            case 4:
                this.stack = asList(1, stack);
                return;
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public int getType() {
        return 14;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor mv) {
        switch (this.type) {
            case -1:
            case 0:
                mv.visitFrame(this.type, this.local.size(), asArray(this.local), this.stack.size(), asArray(this.stack));
                return;
            case 1:
                mv.visitFrame(this.type, this.local.size(), asArray(this.local), 0, null);
                return;
            case 2:
                mv.visitFrame(this.type, this.local.size(), null, 0, null);
                return;
            case 3:
                mv.visitFrame(this.type, 0, null, 0, null);
                return;
            case 4:
                mv.visitFrame(this.type, 0, null, 1, asArray(this.stack));
                return;
            default:
                return;
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> labels) {
        FrameNode clone = new FrameNode();
        clone.type = this.type;
        if (this.local != null) {
            clone.local = new ArrayList();
            for (int i = 0; i < this.local.size(); i++) {
                Object l = this.local.get(i);
                if (l instanceof LabelNode) {
                    l = labels.get(l);
                }
                clone.local.add(l);
            }
        }
        if (this.stack != null) {
            clone.stack = new ArrayList();
            for (int i2 = 0; i2 < this.stack.size(); i2++) {
                Object s = this.stack.get(i2);
                if (s instanceof LabelNode) {
                    s = labels.get(s);
                }
                clone.stack.add(s);
            }
        }
        return clone;
    }

    private static List<Object> asList(int n, Object[] o) {
        return Arrays.asList(o).subList(0, n);
    }

    private static Object[] asArray(List<Object> l) {
        Object[] objs = new Object[l.size()];
        for (int i = 0; i < objs.length; i++) {
            Object o = l.get(i);
            if (o instanceof LabelNode) {
                o = ((LabelNode) o).getLabel();
            }
            objs[i] = o;
        }
        return objs;
    }
}
