package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.Handler */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/Handler.class */
class Handler {
    Label start;
    Label end;
    Label handler;
    String desc;
    int type;
    Handler next;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler remove(Handler h, Label start, Label end) {
        if (h == null) {
            return null;
        }
        h.next = remove(h.next, start, end);
        int hstart = h.start.position;
        int hend = h.end.position;
        int s = start.position;
        int e = end == null ? Integer.MAX_VALUE : end.position;
        if (s < hend && e > hstart) {
            if (s <= hstart) {
                if (e >= hend) {
                    h = h.next;
                } else {
                    h.start = end;
                }
            } else if (e >= hend) {
                h.end = start;
            } else {
                Handler g = new Handler();
                g.start = end;
                g.end = h.end;
                g.handler = h.handler;
                g.desc = h.desc;
                g.type = h.type;
                g.next = h.next;
                h.end = start;
                h.next = g;
            }
        }
        return h;
    }
}
