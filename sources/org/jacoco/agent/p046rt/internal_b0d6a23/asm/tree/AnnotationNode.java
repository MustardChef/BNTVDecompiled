package org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.tree.AnnotationNode */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/tree/AnnotationNode.class */
public class AnnotationNode extends AnnotationVisitor {
    public String desc;
    public List<Object> values;

    public AnnotationNode(String desc) {
        this(327680, desc);
        if (getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationNode(int api, String desc) {
        super(api);
        this.desc = desc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnnotationNode(List<Object> values) {
        super(327680);
        this.values = values;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor
    public void visit(String name, Object value) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        this.values.add(value);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor
    public void visitEnum(String name, String desc, String value) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        this.values.add(new String[]{desc, value});
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor
    public AnnotationVisitor visitAnnotation(String name, String desc) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        AnnotationNode annotation = new AnnotationNode(desc);
        this.values.add(annotation);
        return annotation;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor
    public AnnotationVisitor visitArray(String name) {
        if (this.values == null) {
            this.values = new ArrayList(this.desc != null ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(name);
        }
        List<Object> array = new ArrayList<>();
        this.values.add(array);
        return new AnnotationNode(array);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.AnnotationVisitor
    public void visitEnd() {
    }

    public void check(int api) {
    }

    public void accept(AnnotationVisitor av) {
        if (av != null) {
            if (this.values != null) {
                for (int i = 0; i < this.values.size(); i += 2) {
                    String name = (String) this.values.get(i);
                    Object value = this.values.get(i + 1);
                    accept(av, name, value);
                }
            }
            av.visitEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void accept(AnnotationVisitor av, String name, Object value) {
        if (av != null) {
            if (value instanceof String[]) {
                String[] typeconst = (String[]) value;
                av.visitEnum(name, typeconst[0], typeconst[1]);
            } else if (value instanceof AnnotationNode) {
                AnnotationNode an = (AnnotationNode) value;
                an.accept(av.visitAnnotation(name, an.desc));
            } else if (value instanceof List) {
                AnnotationVisitor v = av.visitArray(name);
                List<?> array = (List) value;
                for (int j = 0; j < array.size(); j++) {
                    accept(v, null, array.get(j));
                }
                v.visitEnd();
            } else {
                av.visit(name, value);
            }
        }
    }
}
