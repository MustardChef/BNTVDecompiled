package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.LocalVariableAnnotationNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/LocalVariableAnnotationNode.class */
public class LocalVariableAnnotationNode extends TypeAnnotationNode {
    public List<LabelNode> start;
    public List<LabelNode> end;
    public List<Integer> index;

    public LocalVariableAnnotationNode(int typeRef, TypePath typePath, LabelNode[] start, LabelNode[] end, int[] index, String desc) {
        this(327680, typeRef, typePath, start, end, index, desc);
    }

    public LocalVariableAnnotationNode(int api, int typeRef, TypePath typePath, LabelNode[] start, LabelNode[] end, int[] index, String desc) {
        super(api, typeRef, typePath, desc);
        this.start = new ArrayList(start.length);
        this.start.addAll(Arrays.asList(start));
        this.end = new ArrayList(end.length);
        this.end.addAll(Arrays.asList(end));
        this.index = new ArrayList(index.length);
        for (int i : index) {
            this.index.add(Integer.valueOf(i));
        }
    }

    public void accept(MethodVisitor mv, boolean visible) {
        Label[] start = new Label[this.start.size()];
        Label[] end = new Label[this.end.size()];
        int[] index = new int[this.index.size()];
        for (int i = 0; i < start.length; i++) {
            start[i] = this.start.get(i).getLabel();
            end[i] = this.end.get(i).getLabel();
            index[i] = this.index.get(i).intValue();
        }
        accept(mv.visitLocalVariableAnnotation(this.typeRef, this.typePath, start, end, index, this.desc, true));
    }
}
