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
public final class QName extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_localName = 1;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_uri = 2;
    private static final int MAX_INSTANCE_ID = 2;
    private static final int MAX_PROTOTYPE_ID = 3;
    private static final Object QNAME_TAG = "QName";
    static final long serialVersionUID = 416745167693026750L;
    private XmlNode.QName delegate;
    private XMLLibImpl lib;
    private QName prototype;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "QName";
    }

    private QName() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static QName create(XMLLibImpl xMLLibImpl, Scriptable scriptable, QName qName, XmlNode.QName qName2) {
        QName qName3 = new QName();
        qName3.lib = xMLLibImpl;
        qName3.setParentScope(scriptable);
        qName3.prototype = qName;
        qName3.setPrototype(qName);
        qName3.delegate = qName2;
        return qName3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void exportAsJSClass(boolean z) {
        exportAsJSClass(3, getParentScope(), z);
    }

    public String toString() {
        if (this.delegate.getNamespace() == null) {
            return "*::" + localName();
        } else if (this.delegate.getNamespace().isGlobal()) {
            return localName();
        } else {
            return uri() + "::" + localName();
        }
    }

    public String localName() {
        return this.delegate.getLocalName() == null ? "*" : this.delegate.getLocalName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String prefix() {
        if (this.delegate.getNamespace() == null) {
            return null;
        }
        return this.delegate.getNamespace().getPrefix();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uri() {
        if (this.delegate.getNamespace() == null) {
            return null;
        }
        return this.delegate.getNamespace().getUri();
    }

    final XmlNode.QName toNodeQname() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XmlNode.QName getDelegate() {
        return this.delegate;
    }

    public boolean equals(Object obj) {
        if (obj instanceof QName) {
            return equals((QName) obj);
        }
        return false;
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public Object equivalentValues(Object obj) {
        return !(obj instanceof QName) ? Scriptable.NOT_FOUND : equals((QName) obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    private boolean equals(QName qName) {
        return this.delegate.equals(qName.delegate);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return toString();
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
        } else if (length == 9) {
            str2 = "localName";
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
        return maxInstanceId != 1 ? maxInstanceId != 2 ? super.getInstanceIdName(i) : ShareConstants.MEDIA_URI : "localName";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId != 1) {
            if (maxInstanceId == 2) {
                return uri();
            }
            return super.getInstanceIdValue(i);
        }
        return localName();
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
        initPrototypeMethod(QNAME_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(QNAME_TAG)) {
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

    private QName realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (!(scriptable instanceof QName)) {
            throw incompatibleCallError(idFunctionObject);
        }
        return (QName) scriptable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName newQName(XMLLibImpl xMLLibImpl, String str, String str2, String str3) {
        XmlNode.Namespace create;
        QName qName = this.prototype;
        if (qName == null) {
            qName = this;
        }
        if (str3 != null) {
            create = XmlNode.Namespace.create(str3, str);
        } else {
            create = str != null ? XmlNode.Namespace.create(str) : null;
        }
        if (str2 != null && str2.equals("*")) {
            str2 = null;
        }
        return create(xMLLibImpl, getParentScope(), qName, XmlNode.QName.create(create, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName constructQName(XMLLibImpl xMLLibImpl, Context context, Object obj, Object obj2) {
        Namespace newNamespace;
        String prefix;
        if (obj2 instanceof QName) {
            if (obj == Undefined.instance) {
                return (QName) obj2;
            }
            ((QName) obj2).localName();
        }
        String scriptRuntime = obj2 == Undefined.instance ? "" : ScriptRuntime.toString(obj2);
        String str = null;
        if (obj == Undefined.instance) {
            obj = "*".equals(scriptRuntime) ? null : xMLLibImpl.getDefaultNamespace(context);
        }
        if (obj == null) {
            newNamespace = null;
        } else if (obj instanceof Namespace) {
            newNamespace = (Namespace) obj;
        } else {
            newNamespace = xMLLibImpl.newNamespace(ScriptRuntime.toString(obj));
        }
        if (obj == null) {
            prefix = null;
        } else {
            str = newNamespace.uri();
            prefix = newNamespace.prefix();
        }
        return newQName(xMLLibImpl, str, scriptRuntime, prefix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName constructQName(XMLLibImpl xMLLibImpl, Context context, Object obj) {
        return constructQName(xMLLibImpl, context, Undefined.instance, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName castToQName(XMLLibImpl xMLLibImpl, Context context, Object obj) {
        if (obj instanceof QName) {
            return (QName) obj;
        }
        return constructQName(xMLLibImpl, context, obj);
    }

    private Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (!z && objArr.length == 1) {
            return castToQName(this.lib, context, objArr[0]);
        }
        if (objArr.length == 0) {
            return constructQName(this.lib, context, Undefined.instance);
        }
        if (objArr.length == 1) {
            return constructQName(this.lib, context, objArr[0]);
        }
        return constructQName(this.lib, context, objArr[0], objArr[1]);
    }

    private String js_toSource() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        toSourceImpl(uri(), localName(), prefix(), stringBuffer);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    private static void toSourceImpl(String str, String str2, String str3, StringBuffer stringBuffer) {
        stringBuffer.append("new QName(");
        if (str == null && str3 == null) {
            if (!"*".equals(str2)) {
                stringBuffer.append("null, ");
            }
        } else {
            Namespace.toSourceImpl(str3, str, stringBuffer);
            stringBuffer.append(", ");
        }
        stringBuffer.append('\'');
        stringBuffer.append(ScriptRuntime.escapeString(str2, '\''));
        stringBuffer.append("')");
    }
}
