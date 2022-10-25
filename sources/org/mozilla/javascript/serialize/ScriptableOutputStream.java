package org.mozilla.javascript.serialize;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.UniqueTag;

/* loaded from: classes5.dex */
public class ScriptableOutputStream extends ObjectOutputStream {
    private Scriptable scope;
    private Map<Object, String> table;

    public ScriptableOutputStream(OutputStream outputStream, Scriptable scriptable) throws IOException {
        super(outputStream);
        this.scope = scriptable;
        HashMap hashMap = new HashMap();
        this.table = hashMap;
        hashMap.put(scriptable, "");
        enableReplaceObject(true);
        excludeStandardObjectNames();
    }

    public void excludeAllIds(Object[] objArr) {
        for (Object obj : objArr) {
            if (obj instanceof String) {
                Scriptable scriptable = this.scope;
                String str = (String) obj;
                if (scriptable.get(str, scriptable) instanceof Scriptable) {
                    addExcludedName(str);
                }
            }
        }
    }

    public void addOptionalExcludedName(String str) {
        Object lookupQualifiedName = lookupQualifiedName(this.scope, str);
        if (lookupQualifiedName == null || lookupQualifiedName == UniqueTag.NOT_FOUND) {
            return;
        }
        if (!(lookupQualifiedName instanceof Scriptable)) {
            throw new IllegalArgumentException("Object for excluded name " + str + " is not a Scriptable, it is " + lookupQualifiedName.getClass().getName());
        }
        this.table.put(lookupQualifiedName, str);
    }

    public void addExcludedName(String str) {
        Object lookupQualifiedName = lookupQualifiedName(this.scope, str);
        if (!(lookupQualifiedName instanceof Scriptable)) {
            throw new IllegalArgumentException("Object for excluded name " + str + " not found.");
        }
        this.table.put(lookupQualifiedName, str);
    }

    public boolean hasExcludedName(String str) {
        return this.table.get(str) != null;
    }

    public void removeExcludedName(String str) {
        this.table.remove(str);
    }

    public void excludeStandardObjectNames() {
        String[] strArr = {"Object", "Object.prototype", "Function", "Function.prototype", "String", "String.prototype", "Math", "Array", "Array.prototype", "Error", "Error.prototype", "Number", "Number.prototype", "Date", "Date.prototype", "RegExp", "RegExp.prototype", "Script", "Script.prototype", "Continuation", "Continuation.prototype"};
        for (int i = 0; i < 21; i++) {
            addExcludedName(strArr[i]);
        }
        String[] strArr2 = {"XML", "XML.prototype", "XMLList", "XMLList.prototype"};
        for (int i2 = 0; i2 < 4; i2++) {
            addOptionalExcludedName(strArr2[i2]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object lookupQualifiedName(Scriptable scriptable, String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        Object obj = scriptable;
        while (stringTokenizer.hasMoreTokens()) {
            obj = ScriptableObject.getProperty((Scriptable) obj, stringTokenizer.nextToken());
            if (obj == null) {
                break;
            }
            boolean z = obj instanceof Scriptable;
            obj = obj;
            if (!z) {
                break;
            }
        }
        return obj;
    }

    /* loaded from: classes5.dex */
    static class PendingLookup implements Serializable {
        static final long serialVersionUID = -2692990309789917727L;
        private String name;

        PendingLookup(String str) {
            this.name = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String getName() {
            return this.name;
        }
    }

    @Override // java.io.ObjectOutputStream
    protected Object replaceObject(Object obj) throws IOException {
        String str = this.table.get(obj);
        return str == null ? obj : new PendingLookup(str);
    }
}
