package org.mozilla.javascript.xml.impl.xmlbeans;

import java.io.Serializable;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;

/* loaded from: classes5.dex */
public final class XMLLibImpl extends XMLLib implements Serializable {
    private static final long serialVersionUID = 1;
    private Scriptable globalScope;
    boolean ignoreComments;
    boolean ignoreProcessingInstructions;
    boolean ignoreWhitespace;
    Namespace namespacePrototype;
    int prettyIndent;
    boolean prettyPrinting;
    QName qnamePrototype;
    XMLList xmlListPrototype;
    XML xmlPrototype;

    private static boolean isNCNameStartChar(int i) {
        if ((i & (-128)) == 0) {
            if (i >= 97) {
                return i <= 122;
            } else if (i >= 65) {
                return i <= 90 || i == 95;
            }
        } else if ((i & (-8192)) == 0) {
            return (192 <= i && i <= 214) || (216 <= i && i <= 246) || ((248 <= i && i <= 767) || ((880 <= i && i <= 893) || 895 <= i));
        }
        return (8204 <= i && i <= 8205) || (8304 <= i && i <= 8591) || ((11264 <= i && i <= 12271) || ((12289 <= i && i <= 55295) || ((63744 <= i && i <= 64975) || ((65008 <= i && i <= 65533) || (65536 <= i && i <= 983039)))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scriptable globalScope() {
        return this.globalScope;
    }

    private XMLLibImpl(Scriptable scriptable) {
        this.globalScope = scriptable;
        defaultSettings();
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        XMLLibImpl xMLLibImpl = new XMLLibImpl(scriptable);
        if (xMLLibImpl.bindToScope(scriptable) == xMLLibImpl) {
            xMLLibImpl.exportToScope(z);
        }
    }

    private void exportToScope(boolean z) {
        this.xmlPrototype = XML.createEmptyXML(this);
        this.xmlListPrototype = new XMLList(this);
        this.namespacePrototype = new Namespace(this, "", "");
        this.qnamePrototype = new QName(this, "", "", "");
        this.xmlPrototype.exportAsJSClass(z);
        this.xmlListPrototype.exportAsJSClass(z);
        this.namespacePrototype.exportAsJSClass(z);
        this.qnamePrototype.exportAsJSClass(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void defaultSettings() {
        this.ignoreComments = true;
        this.ignoreProcessingInstructions = true;
        this.ignoreWhitespace = true;
        this.prettyPrinting = true;
        this.prettyIndent = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLName toAttributeName(Context context, Object obj) {
        String scriptRuntime;
        String str = "";
        if (obj instanceof String) {
            scriptRuntime = (String) obj;
        } else if (obj instanceof XMLName) {
            XMLName xMLName = (XMLName) obj;
            if (!xMLName.isAttributeName()) {
                xMLName.setAttributeName();
            }
            return xMLName;
        } else if (obj instanceof QName) {
            QName qName = (QName) obj;
            str = qName.uri();
            scriptRuntime = qName.localName();
        } else if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        } else {
            scriptRuntime = ScriptRuntime.toString(obj);
        }
        XMLName formProperty = XMLName.formProperty(str, scriptRuntime);
        formProperty.setAttributeName();
        return formProperty;
    }

    private static RuntimeException badXMLName(Object obj) {
        String str;
        if (obj instanceof Number) {
            str = "Can not construct XML name from number: ";
        } else if (obj instanceof Boolean) {
            str = "Can not construct XML name from boolean: ";
        } else if (obj != Undefined.instance && obj != null) {
            throw new IllegalArgumentException(obj.toString());
        } else {
            str = "Can not construct XML name from ";
        }
        return ScriptRuntime.typeError(str + ScriptRuntime.toString(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLName toXMLName(Context context, Object obj) {
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            return XMLName.formProperty(qName.uri(), qName.localName());
        } else if (obj instanceof String) {
            return toXMLNameFromString(context, (String) obj);
        } else {
            if ((obj instanceof Boolean) || (obj instanceof Number) || obj == Undefined.instance || obj == null) {
                throw badXMLName(obj);
            }
            return toXMLNameFromString(context, ScriptRuntime.toString(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLName toXMLNameOrIndex(Context context, Object obj) {
        if (obj instanceof XMLName) {
            return (XMLName) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            long testUint32String = ScriptRuntime.testUint32String(str);
            if (testUint32String >= 0) {
                ScriptRuntime.storeUint32Result(context, testUint32String);
                return null;
            }
            return toXMLNameFromString(context, str);
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            long j = (long) doubleValue;
            if (j == doubleValue && 0 <= j && j <= 4294967295L) {
                ScriptRuntime.storeUint32Result(context, j);
                return null;
            }
            throw badXMLName(obj);
        } else if (obj instanceof QName) {
            QName qName = (QName) obj;
            String uri = qName.uri();
            boolean z = false;
            if (uri != null && uri.length() == 0) {
                long testUint32String2 = ScriptRuntime.testUint32String(uri);
                if (testUint32String2 >= 0) {
                    ScriptRuntime.storeUint32Result(context, testUint32String2);
                    z = true;
                }
            }
            if (z) {
                return null;
            }
            return XMLName.formProperty(uri, qName.localName());
        } else if ((obj instanceof Boolean) || obj == Undefined.instance || obj == null) {
            throw badXMLName(obj);
        } else {
            String scriptRuntime = ScriptRuntime.toString(obj);
            long testUint32String3 = ScriptRuntime.testUint32String(scriptRuntime);
            if (testUint32String3 >= 0) {
                ScriptRuntime.storeUint32Result(context, testUint32String3);
                return null;
            }
            return toXMLNameFromString(context, scriptRuntime);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLName toXMLNameFromString(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        int length = str.length();
        if (length != 0) {
            char charAt = str.charAt(0);
            if (charAt == '*') {
                if (length == 1) {
                    return XMLName.formStar();
                }
            } else if (charAt == '@') {
                XMLName formProperty = XMLName.formProperty("", str.substring(1));
                formProperty.setAttributeName();
                return formProperty;
            }
        }
        return XMLName.formProperty(getDefaultNamespaceURI(context), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace constructNamespace(Context context, Object obj) {
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
                String prefix = qName.prefix();
                scriptRuntime = uri;
                str = prefix;
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
        return new Namespace(this, str, scriptRuntime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace castToNamespace(Context context, Object obj) {
        if (obj instanceof Namespace) {
            return (Namespace) obj;
        }
        return constructNamespace(context, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace constructNamespace(Context context) {
        return new Namespace(this, "", "");
    }

    public Namespace constructNamespace(Context context, Object obj, Object obj2) {
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
        } else if (obj != Undefined.instance && isXMLName(context, obj)) {
            str = ScriptRuntime.toString(obj);
        }
        return new Namespace(this, str, scriptRuntime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDefaultNamespaceURI(Context context) {
        Object searchDefaultNamespace;
        if (context == null) {
            context = Context.getCurrentContext();
        }
        return (context == null || (searchDefaultNamespace = ScriptRuntime.searchDefaultNamespace(context)) == null || !(searchDefaultNamespace instanceof Namespace)) ? "" : ((Namespace) searchDefaultNamespace).uri();
    }

    Namespace getDefaultNamespace(Context context) {
        if (context == null && (context = Context.getCurrentContext()) == null) {
            return this.namespacePrototype;
        }
        Object searchDefaultNamespace = ScriptRuntime.searchDefaultNamespace(context);
        if (searchDefaultNamespace == null) {
            return this.namespacePrototype;
        }
        if (searchDefaultNamespace instanceof Namespace) {
            return (Namespace) searchDefaultNamespace;
        }
        return this.namespacePrototype;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName castToQName(Context context, Object obj) {
        if (obj instanceof QName) {
            return (QName) obj;
        }
        return constructQName(context, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName constructQName(Context context, Object obj) {
        if (obj instanceof QName) {
            QName qName = (QName) obj;
            return new QName(this, qName.uri(), qName.localName(), qName.prefix());
        }
        return constructQNameFromString(context, ScriptRuntime.toString(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName constructQNameFromString(Context context, String str) {
        String prefix;
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String str2 = null;
        if ("*".equals(str)) {
            prefix = null;
        } else {
            Namespace defaultNamespace = getDefaultNamespace(context);
            str2 = defaultNamespace.uri();
            prefix = defaultNamespace.prefix();
        }
        return new QName(this, str2, str, prefix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName constructQName(Context context, Object obj, Object obj2) {
        String scriptRuntime;
        Namespace constructNamespace;
        String prefix;
        if (obj2 instanceof QName) {
            scriptRuntime = ((QName) obj2).localName();
        } else {
            scriptRuntime = ScriptRuntime.toString(obj2);
        }
        String str = null;
        if (obj == Undefined.instance) {
            if (!"*".equals(scriptRuntime)) {
                constructNamespace = getDefaultNamespace(context);
            }
            constructNamespace = null;
        } else {
            if (obj != null) {
                if (obj instanceof Namespace) {
                    constructNamespace = (Namespace) obj;
                } else {
                    constructNamespace = constructNamespace(context, obj);
                }
            }
            constructNamespace = null;
        }
        if (constructNamespace == null) {
            prefix = null;
        } else {
            str = constructNamespace.uri();
            prefix = constructNamespace.prefix();
        }
        return new QName(this, str, scriptRuntime, prefix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object addXMLObjects(Context context, XMLObject xMLObject, XMLObject xMLObject2) {
        XMLList xMLList = new XMLList(this);
        if (xMLObject instanceof XMLList) {
            XMLList xMLList2 = (XMLList) xMLObject;
            if (xMLList2.length() == 1) {
                xMLList.addToList(xMLList2.item(0));
            } else {
                xMLList = new XMLList(this, xMLObject);
            }
        } else {
            xMLList.addToList(xMLObject);
        }
        if (xMLObject2 instanceof XMLList) {
            XMLList xMLList3 = (XMLList) xMLObject2;
            for (int i = 0; i < xMLList3.length(); i++) {
                xMLList.addToList(xMLList3.item(i));
            }
        } else if (xMLObject2 instanceof XML) {
            xMLList.addToList(xMLObject2);
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public boolean isXMLName(Context context, Object obj) {
        try {
            String scriptRuntime = ScriptRuntime.toString(obj);
            int length = scriptRuntime.length();
            if (length == 0 || !isNCNameStartChar(scriptRuntime.charAt(0))) {
                return false;
            }
            for (int i = 1; i != length; i++) {
                if (!isNCNameChar(scriptRuntime.charAt(i))) {
                    return false;
                }
            }
            return true;
        } catch (EcmaError e) {
            if ("TypeError".equals(e.getName())) {
                return false;
            }
            throw e;
        }
    }

    private static boolean isNCNameChar(int i) {
        return (i & (-128)) == 0 ? i >= 97 ? i <= 122 : i >= 65 ? i <= 90 || i == 95 : i >= 48 ? i <= 57 : i == 45 || i == 46 : (i & (-8192)) == 0 ? isNCNameStartChar(i) || i == 183 || (768 <= i && i <= 879) : isNCNameStartChar(i) || (8255 <= i && i <= 8256);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLName toQualifiedName(Context context, Object obj, Object obj2) {
        String scriptRuntime;
        Namespace constructNamespace;
        if (obj2 instanceof QName) {
            scriptRuntime = ((QName) obj2).localName();
        } else {
            scriptRuntime = ScriptRuntime.toString(obj2);
        }
        if (obj == Undefined.instance) {
            if (!"*".equals(scriptRuntime)) {
                constructNamespace = getDefaultNamespace(context);
            }
            constructNamespace = null;
        } else {
            if (obj != null) {
                if (obj instanceof Namespace) {
                    constructNamespace = (Namespace) obj;
                } else {
                    constructNamespace = constructNamespace(context, obj);
                }
            }
            constructNamespace = null;
        }
        return XMLName.formProperty(constructNamespace != null ? constructNamespace.uri() : null, scriptRuntime);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Scriptable scriptable, int i) {
        if ((i & 2) == 0) {
            throw Kit.codeBug();
        }
        return xmlPrimaryReference(context, toAttributeName(context, obj), scriptable);
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public Ref nameRef(Context context, Object obj, Object obj2, Scriptable scriptable, int i) {
        XMLName qualifiedName = toQualifiedName(context, obj, obj2);
        if ((i & 2) != 0 && !qualifiedName.isAttributeName()) {
            qualifiedName.setAttributeName();
        }
        return xmlPrimaryReference(context, qualifiedName, scriptable);
    }

    private Ref xmlPrimaryReference(Context context, XMLName xMLName, Scriptable scriptable) {
        XMLObjectImpl xMLObjectImpl;
        XMLObjectImpl xMLObjectImpl2 = null;
        while (true) {
            if (scriptable instanceof XMLWithScope) {
                xMLObjectImpl = (XMLObjectImpl) scriptable.getPrototype();
                if (xMLObjectImpl.hasXMLProperty(xMLName)) {
                    break;
                } else if (xMLObjectImpl2 == null) {
                    xMLObjectImpl2 = xMLObjectImpl;
                }
            }
            scriptable = scriptable.getParentScope();
            if (scriptable == null) {
                xMLObjectImpl = xMLObjectImpl2;
                break;
            }
        }
        if (xMLObjectImpl != null) {
            xMLName.initXMLObject(xMLObjectImpl);
        }
        return xMLName;
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public String escapeAttributeValue(Object obj) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        if (scriptRuntime.length() == 0) {
            return "";
        }
        XmlObject newInstance = XmlObject.Factory.newInstance();
        XmlCursor newCursor = newInstance.newCursor();
        newCursor.toNextToken();
        newCursor.beginElement("a");
        newCursor.insertAttributeWithValue("a", scriptRuntime);
        newCursor.dispose();
        String xmlObject = newInstance.toString();
        return xmlObject.substring(xmlObject.indexOf(34) + 1, xmlObject.lastIndexOf(34));
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public String escapeTextValue(Object obj) {
        if (obj instanceof XMLObjectImpl) {
            return ((XMLObjectImpl) obj).toXMLString(0);
        }
        String scriptRuntime = ScriptRuntime.toString(obj);
        if (scriptRuntime.length() == 0) {
            return scriptRuntime;
        }
        XmlObject newInstance = XmlObject.Factory.newInstance();
        XmlCursor newCursor = newInstance.newCursor();
        newCursor.toNextToken();
        newCursor.beginElement("a");
        newCursor.insertChars(scriptRuntime);
        newCursor.dispose();
        String xmlObject = newInstance.toString();
        int indexOf = xmlObject.indexOf(62) + 1;
        int lastIndexOf = xmlObject.lastIndexOf(60);
        return indexOf < lastIndexOf ? xmlObject.substring(indexOf, lastIndexOf) : "";
    }

    @Override // org.mozilla.javascript.xml.XMLLib
    public Object toDefaultXmlNamespace(Context context, Object obj) {
        return constructNamespace(context, obj);
    }
}
