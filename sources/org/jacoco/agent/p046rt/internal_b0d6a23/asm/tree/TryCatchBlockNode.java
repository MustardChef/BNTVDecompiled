package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.List;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.TryCatchBlockNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/TryCatchBlockNode.class */
public class TryCatchBlockNode {
    public LabelNode start;
    public LabelNode end;
    public LabelNode handler;
    public String type;
    public List<TypeAnnotationNode> visibleTypeAnnotations;
    public List<TypeAnnotationNode> invisibleTypeAnnotations;

    public TryCatchBlockNode(LabelNode start, LabelNode end, LabelNode handler, String type) {
        this.start = start;
        this.end = end;
        this.handler = handler;
        this.type = type;
    }

    public void updateIndex(int index) {
        int newTypeRef = 1107296256 | (index << 8);
        if (this.visibleTypeAnnotations != null) {
            for (TypeAnnotationNode tan : this.visibleTypeAnnotations) {
                tan.typeRef = newTypeRef;
            }
        }
        if (this.invisibleTypeAnnotations != null) {
            for (TypeAnnotationNode tan2 : this.invisibleTypeAnnotations) {
                tan2.typeRef = newTypeRef;
            }
        }
    }

    public void accept(MethodVisitor mv) {
        mv.visitTryCatchBlock(this.start.getLabel(), this.end.getLabel(), this.handler == null ? null : this.handler.getLabel(), this.type);
        int n = this.visibleTypeAnnotations == null ? 0 : this.visibleTypeAnnotations.size();
        for (int i = 0; i < n; i++) {
            TypeAnnotationNode an = this.visibleTypeAnnotations.get(i);
            an.accept(mv.visitTryCatchAnnotation(an.typeRef, an.typePath, an.desc, true));
        }
        int n2 = this.invisibleTypeAnnotations == null ? 0 : this.invisibleTypeAnnotations.size();
        for (int i2 = 0; i2 < n2; i2++) {
            TypeAnnotationNode an2 = this.invisibleTypeAnnotations.get(i2);
            an2.accept(mv.visitTryCatchAnnotation(an2.typeRef, an2.typePath, an2.desc, false));
        }
    }
}
