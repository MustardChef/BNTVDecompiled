package org.mozilla.javascript.xml.impl.xmlbeans;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Undefined;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class XMLName extends Ref {
    static final long serialVersionUID = 3832176310755686977L;
    private boolean isAttributeName;
    private boolean isDescendants;
    private String localName;
    private String uri;
    private XMLObjectImpl xmlObject;

    private XMLName(String str, String str2) {
        this.uri = str;
        this.localName = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XMLName formStar() {
        return new XMLName(null, "*");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XMLName formProperty(String str, String str2) {
        return new XMLName(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initXMLObject(XMLObjectImpl xMLObjectImpl) {
        if (xMLObjectImpl == null) {
            throw new IllegalArgumentException();
        }
        if (this.xmlObject != null) {
            throw new IllegalStateException();
        }
        this.xmlObject = xMLObjectImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String uri() {
        return this.uri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String localName() {
        return this.localName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAttributeName() {
        return this.isAttributeName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAttributeName() {
        if (this.isAttributeName) {
            throw new IllegalStateException();
        }
        this.isAttributeName = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDescendants() {
        return this.isDescendants;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsDescendants() {
        if (this.isDescendants) {
            throw new IllegalStateException();
        }
        this.isDescendants = true;
    }

    @Override // org.mozilla.javascript.Ref
    public boolean has(Context context) {
        XMLObjectImpl xMLObjectImpl = this.xmlObject;
        if (xMLObjectImpl == null) {
            return false;
        }
        return xMLObjectImpl.hasXMLProperty(this);
    }

    @Override // org.mozilla.javascript.Ref
    public Object get(Context context) {
        XMLObjectImpl xMLObjectImpl = this.xmlObject;
        if (xMLObjectImpl == null) {
            throw ScriptRuntime.undefReadError(Undefined.instance, toString());
        }
        return xMLObjectImpl.getXMLProperty(this);
    }

    @Override // org.mozilla.javascript.Ref
    public Object set(Context context, Object obj) {
        XMLObjectImpl xMLObjectImpl = this.xmlObject;
        if (xMLObjectImpl == null) {
            throw ScriptRuntime.undefWriteError(Undefined.instance, toString(), obj);
        }
        if (this.isDescendants) {
            throw Kit.codeBug();
        }
        xMLObjectImpl.putXMLProperty(this, obj);
        return obj;
    }

    @Override // org.mozilla.javascript.Ref
    public boolean delete(Context context) {
        XMLObjectImpl xMLObjectImpl = this.xmlObject;
        if (xMLObjectImpl == null) {
            return true;
        }
        xMLObjectImpl.deleteXMLProperty(this);
        return !this.xmlObject.hasXMLProperty(this);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.isDescendants) {
            stringBuffer.append("..");
        }
        if (this.isAttributeName) {
            stringBuffer.append('@');
        }
        if (this.uri == null) {
            stringBuffer.append('*');
            if (localName().equals("*")) {
                return stringBuffer.toString();
            }
        } else {
            stringBuffer.append('\"');
            stringBuffer.append(uri());
            stringBuffer.append('\"');
        }
        stringBuffer.append(':');
        stringBuffer.append(localName());
        return stringBuffer.toString();
    }
}
