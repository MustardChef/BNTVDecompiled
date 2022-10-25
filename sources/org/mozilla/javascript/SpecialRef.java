package org.mozilla.javascript;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class SpecialRef extends Ref {
    private static final int SPECIAL_NONE = 0;
    private static final int SPECIAL_PARENT = 2;
    private static final int SPECIAL_PROTO = 1;
    static final long serialVersionUID = -7521596632456797847L;
    private String name;
    private Scriptable target;
    private int type;

    private SpecialRef(Scriptable scriptable, int i, String str) {
        this.target = scriptable;
        this.type = i;
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Ref createSpecial(Context context, Object obj, String str) {
        int i;
        Scriptable objectOrNull = ScriptRuntime.toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw ScriptRuntime.undefReadError(obj, str);
        }
        if (str.equals("__proto__")) {
            i = 1;
        } else if (!str.equals("__parent__")) {
            throw new IllegalArgumentException(str);
        } else {
            i = 2;
        }
        if (!context.hasFeature(5)) {
            i = 0;
        }
        return new SpecialRef(objectOrNull, i, str);
    }

    @Override // org.mozilla.javascript.Ref
    public Object get(Context context) {
        int i = this.type;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return this.target.getParentScope();
                }
                throw Kit.codeBug();
            }
            return this.target.getPrototype();
        }
        return ScriptRuntime.getObjectProp(this.target, this.name, context);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    @Override // org.mozilla.javascript.Ref
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object set(org.mozilla.javascript.Context r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.type
            if (r0 == 0) goto L44
            r1 = 1
            if (r0 == r1) goto L10
            r2 = 2
            if (r0 != r2) goto Lb
            goto L10
        Lb:
            java.lang.RuntimeException r4 = org.mozilla.javascript.Kit.codeBug()
            throw r4
        L10:
            org.mozilla.javascript.Scriptable r4 = org.mozilla.javascript.ScriptRuntime.toObjectOrNull(r4, r5)
            if (r4 == 0) goto L34
            r5 = r4
        L17:
            org.mozilla.javascript.Scriptable r0 = r3.target
            if (r5 == r0) goto L2b
            int r0 = r3.type
            if (r0 != r1) goto L24
            org.mozilla.javascript.Scriptable r5 = r5.getPrototype()
            goto L28
        L24:
            org.mozilla.javascript.Scriptable r5 = r5.getParentScope()
        L28:
            if (r5 != 0) goto L17
            goto L34
        L2b:
            java.lang.String r4 = r3.name
            java.lang.String r5 = "msg.cyclic.value"
            org.mozilla.javascript.EvaluatorException r4 = org.mozilla.javascript.Context.reportRuntimeError1(r5, r4)
            throw r4
        L34:
            int r5 = r3.type
            if (r5 != r1) goto L3e
            org.mozilla.javascript.Scriptable r5 = r3.target
            r5.setPrototype(r4)
            goto L43
        L3e:
            org.mozilla.javascript.Scriptable r5 = r3.target
            r5.setParentScope(r4)
        L43:
            return r4
        L44:
            org.mozilla.javascript.Scriptable r0 = r3.target
            java.lang.String r1 = r3.name
            java.lang.Object r4 = org.mozilla.javascript.ScriptRuntime.setObjectProp(r0, r1, r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.SpecialRef.set(org.mozilla.javascript.Context, java.lang.Object):java.lang.Object");
    }

    @Override // org.mozilla.javascript.Ref
    public boolean has(Context context) {
        if (this.type == 0) {
            return ScriptRuntime.hasObjectElem(this.target, this.name, context);
        }
        return true;
    }

    @Override // org.mozilla.javascript.Ref
    public boolean delete(Context context) {
        if (this.type == 0) {
            return ScriptRuntime.deleteObjectElem(this.target, this.name, context);
        }
        return false;
    }
}
