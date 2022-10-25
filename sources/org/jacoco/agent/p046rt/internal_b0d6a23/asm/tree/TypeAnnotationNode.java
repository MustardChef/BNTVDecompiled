package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.TypePath;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.TypeAnnotationNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/TypeAnnotationNode.class */
public class TypeAnnotationNode extends AnnotationNode {
    public int typeRef;
    public TypePath typePath;

    public TypeAnnotationNode(int typeRef, TypePath typePath, String desc) {
        this(327680, typeRef, typePath, desc);
        if (getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public TypeAnnotationNode(int api, int typeRef, TypePath typePath, String desc) {
        super(api, desc);
        this.typeRef = typeRef;
        this.typePath = typePath;
    }
}
