package org.mozilla.javascript.xmlimpl;

import com.facebook.share.internal.ShareConstants;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.IdScriptableObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xmlimpl.XmlNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class Namespace extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_prefix = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_uri = 2;
    private static final int MAX_INSTANCE_ID = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final Object NAMESPACE_TAG = "Namespace";
    static final long serialVersionUID = -5765755238131301744L;

    /* renamed from: ns */
    private XmlNode.Namespace f10801ns;
    private Namespace prototype;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Namespace";
    }

    private Namespace() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Namespace create(Scriptable scriptable, Namespace namespace, XmlNode.Namespace namespace2) {
        Namespace namespace3 = new Namespace();
        namespace3.setParentScope(scriptable);
        namespace3.prototype = namespace;
        namespace3.setPrototype(namespace);
        namespace3.f10801ns = namespace2;
        return namespace3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XmlNode.Namespace getDelegate() {
        return this.f10801ns;
    }

    public void exportAsJSClass(boolean z) {
        exportAsJSClass(3, getParentScope(), z);
    }

    public String uri() {
        return this.f10801ns.getUri();
    }

    public String prefix() {
        return this.f10801ns.getPrefix();
    }

    public String toString() {
        return uri();
    }

    public String toLocaleString() {
        return toString();
    }

    private boolean equals(Namespace namespace) {
        return uri().equals(namespace.uri());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Namespace) {
            return equals((Namespace) obj);
        }
        return false;
    }

    public int hashCode() {
        return uri().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public Object equivalentValues(Object obj) {
        return !(obj instanceof Namespace) ? Scriptable.NOT_FOUND : equals((Namespace) obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return uri();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return super.getMaxInstanceId() + 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 0;
        if (length == 3) {
            str2 = ShareConstants.MEDIA_URI;
            i = 2;
        } else if (length == 6) {
            str2 = "prefix";
            i = 1;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i2 = i;
        }
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return instanceIdInfo(5, super.getMaxInstanceId() + i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        return maxInstanceId != 1 ? maxInstanceId != 2 ? super.getInstanceIdName(i) : ShareConstants.MEDIA_URI : "prefix";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            return this.f10801ns.getPrefix() == null ? Undefined.instance : this.f10801ns.getPrefix();
        } else if (maxInstanceId == 2) {
            return this.f10801ns.getUri();
        } else {
            return super.getInstanceIdValue(i);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 3;
        if (length == 8) {
            char charAt = str.charAt(3);
            if (charAt == 'o') {
                str2 = "toSource";
            } else {
                if (charAt == 't') {
                    i = 2;
                    str2 = "toString";
                }
                str2 = null;
                i = 0;
            }
        } else {
            if (length == 11) {
                i = 1;
                str2 = "constructor";
            }
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 0;
        if (i == 1) {
            str = "constructor";
            i2 = 2;
        } else if (i == 2) {
            str = "toString";
        } else if (i != 3) {
            throw new IllegalArgumentException(String.valueOf(i));
        } else {
            str = "toSource";
        }
        initPrototypeMethod(NAMESPACE_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NAMESPACE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return jsConstructor(context, scriptable2 == null, objArr);
        } else if (methodId != 2) {
            if (methodId == 3) {
                return realThis(scriptable2, idFunctionObject).js_toSource();
            }
            throw new IllegalArgumentException(String.valueOf(methodId));
        } else {
            return realThis(scriptable2, idFunctionObject).toString();
        }
    }

    private Namespace realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof Namespace)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (Namespace) scriptable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace newNamespace(String str) {
        Namespace namespace = this.prototype;
        if (namespace == null) {
            namespace = this;
        }
        return create(getParentScope(), namespace, XmlNode.Namespace.create(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace newNamespace(String str, String str2) {
        if (str == null) {
            return newNamespace(str2);
        }
        Namespace namespace = this.prototype;
        if (namespace == null) {
            namespace = this;
        }
        return create(getParentScope(), namespace, XmlNode.Namespace.create(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace constructNamespace(Object obj) {
        String scriptRuntime;
        String str;
        if (obj instanceof Namespace) {
            Namespace namespace = (Namespace) obj;
            str = namespace.prefix();
            scriptRuntime = namespace.uri();
        } else if (obj instanceof QName) {
            QName qName = (QName) obj;
            String uri = qName.uri();
            if (uri != null) {
                str = qName.prefix();
                scriptRuntime = uri;
            } else {
                scriptRuntime = qName.toString();
                str = null;
            }
        } else {
            scriptRuntime = ScriptRuntime.toString(obj);
            if (scriptRuntime.length() == 0) {
                str = "";
            }
            str = null;
        }
        return newNamespace(str, scriptRuntime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace castToNamespace(Object obj) {
        if (obj instanceof Namespace) {
            return (Namespace) obj;
        }
        return constructNamespace(obj);
    }

    private Namespace constructNamespace(Object obj, Object obj2) {
        String scriptRuntime;
        if (obj2 instanceof QName) {
            QName qName = (QName) obj2;
            scriptRuntime = qName.uri();
            if (scriptRuntime == null) {
                scriptRuntime = qName.toString();
            }
        } else {
            scriptRuntime = ScriptRuntime.toString(obj2);
        }
        String str = "";
        if (scriptRuntime.length() == 0) {
            if (obj != Undefined.instance) {
                str = ScriptRuntime.toString(obj);
                if (str.length() != 0) {
                    throw ScriptRuntime.typeError("Illegal prefix '" + str + "' for 'no namespace'.");
                }
            }
        } else if (obj != Undefined.instance && XMLName.accept(obj)) {
            str = ScriptRuntime.toString(obj);
        }
        return newNamespace(str, scriptRuntime);
    }

    private Namespace constructNamespace() {
        return newNamespace("", "");
    }

    private Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (!z && objArr.length == 1) {
            return castToNamespace(objArr[0]);
        }
        if (objArr.length == 0) {
            return constructNamespace();
        }
        if (objArr.length == 1) {
            return constructNamespace(objArr[0]);
        }
        return constructNamespace(objArr[0], objArr[1]);
    }

    private String js_toSource() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        toSourceImpl(this.f10801ns.getPrefix(), this.f10801ns.getUri(), stringBuffer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void toSourceImpl(String str, String str2, StringBuffer stringBuffer) {
        stringBuffer.append("new Namespace(");
        if (str2.length() == 0) {
            if (!"".equals(str)) {
                throw new IllegalArgumentException(str);
            }
        } else {
            stringBuffer.append('\'');
            if (str != null) {
                stringBuffer.append(ScriptRuntime.escapeString(str, '\''));
                stringBuffer.append("', '");
            }
            stringBuffer.append(ScriptRuntime.escapeString(str2, '\''));
            stringBuffer.append('\'');
        }
        stringBuffer.append(')');
    }
}
