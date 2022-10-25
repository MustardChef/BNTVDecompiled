package org.mozilla.javascript.jdk15;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Wrapper;
import org.mozilla.javascript.jdk13.VMBridge_jdk13;

/* loaded from: classes5.dex */
public class VMBridge_jdk15 extends VMBridge_jdk13 {
    public VMBridge_jdk15() throws SecurityException, InstantiationException {
        try {
            Method.class.getMethod("isVarArgs", null);
        } catch (NoSuchMethodException e) {
            throw new InstantiationException(e.getMessage());
        }
    }

    @Override // org.mozilla.javascript.jdk13.VMBridge_jdk13, org.mozilla.javascript.VMBridge
    public boolean isVarArgs(Member member) {
        if (member instanceof Method) {
            return ((Method) member).isVarArgs();
        }
        if (member instanceof Constructor) {
            return ((Constructor) member).isVarArgs();
        }
        return false;
    }

    @Override // org.mozilla.javascript.VMBridge
    public Iterator<?> getJavaIterator(Context context, Scriptable scriptable, Object obj) {
        if (obj instanceof Wrapper) {
            Object unwrap = ((Wrapper) obj).unwrap();
            return unwrap instanceof Iterable ? ((Iterable) unwrap).iterator() : unwrap instanceof Iterator ? (Iterator) unwrap : null;
        }
        return null;
    }
}
