package org.mozilla.javascript.xmlimpl;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeWith;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class XMLObjectImpl extends XMLObject {
    private static final int Id_addNamespace = 2;
    private static final int Id_appendChild = 3;
    private static final int Id_attribute = 4;
    private static final int Id_attributes = 5;
    private static final int Id_child = 6;
    private static final int Id_childIndex = 7;
    private static final int Id_children = 8;
    private static final int Id_comments = 9;
    private static final int Id_constructor = 1;
    private static final int Id_contains = 10;
    private static final int Id_copy = 11;
    private static final int Id_descendants = 12;
    private static final int Id_elements = 13;
    private static final int Id_hasComplexContent = 18;
    private static final int Id_hasOwnProperty = 17;
    private static final int Id_hasSimpleContent = 19;
    private static final int Id_inScopeNamespaces = 14;
    private static final int Id_insertChildAfter = 15;
    private static final int Id_insertChildBefore = 16;
    private static final int Id_length = 20;
    private static final int Id_localName = 21;
    private static final int Id_name = 22;
    private static final int Id_namespace = 23;
    private static final int Id_namespaceDeclarations = 24;
    private static final int Id_nodeKind = 25;
    private static final int Id_normalize = 26;
    private static final int Id_parent = 27;
    private static final int Id_prependChild = 28;
    private static final int Id_processingInstructions = 29;
    private static final int Id_propertyIsEnumerable = 30;
    private static final int Id_removeNamespace = 31;
    private static final int Id_replace = 32;
    private static final int Id_setChildren = 33;
    private static final int Id_setLocalName = 34;
    private static final int Id_setName = 35;
    private static final int Id_setNamespace = 36;
    private static final int Id_text = 37;
    private static final int Id_toSource = 39;
    private static final int Id_toString = 38;
    private static final int Id_toXMLString = 40;
    private static final int Id_valueOf = 41;
    private static final int MAX_PROTOTYPE_ID = 41;
    private static final Object XMLOBJECT_TAG = "XMLObject";
    private XMLLibImpl lib;
    private boolean prototypeFlag;

    abstract void addMatches(XMLList xMLList, XMLName xMLName);

    abstract XMLList child(int i);

    abstract XMLList child(XMLName xMLName);

    abstract XMLList children();

    abstract XMLList comments();

    abstract boolean contains(Object obj);

    abstract XMLObjectImpl copy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void deleteXMLProperty(XMLName xMLName);

    abstract XMLList elements(XMLName xMLName);

    abstract boolean equivalentXml(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract XML getXML();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object getXMLProperty(XMLName xMLName);

    abstract boolean hasComplexContent();

    abstract boolean hasOwnProperty(XMLName xMLName);

    abstract boolean hasSimpleContent();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasXMLProperty(XMLName xMLName);

    protected abstract Object jsConstructor(Context context, boolean z, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int length();

    abstract void normalize();

    abstract Object parent();

    abstract XMLList processingInstructions(XMLName xMLName);

    abstract boolean propertyIsEnumerable(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putXMLProperty(XMLName xMLName, Object obj);

    abstract XMLList text();

    abstract String toSource(int i);

    public abstract String toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String toXMLString();

    abstract Object valueOf();

    /* JADX INFO: Access modifiers changed from: protected */
    public XMLObjectImpl(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        initialize(xMLLibImpl, scriptable, xMLObject);
    }

    final void initialize(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        setParentScope(scriptable);
        setPrototype(xMLObject);
        this.prototypeFlag = xMLObject == null;
        this.lib = xMLLibImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isPrototype() {
        return this.prototypeFlag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLLibImpl getLib() {
        return this.lib;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XML newXML(XmlNode xmlNode) {
        return this.lib.newXML(xmlNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML xmlFromNode(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XMLList newXMLList() {
        return this.lib.newXMLList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XMLList newXMLListFrom(Object obj) {
        return this.lib.newXMLListFrom(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XmlProcessor getProcessor() {
        return this.lib.getProcessor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final QName newQName(String str, String str2, String str3) {
        return this.lib.newQName(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final QName newQName(XmlNode.QName qName) {
        return this.lib.newQName(qName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Namespace createNamespace(XmlNode.Namespace namespace) {
        if (namespace == null) {
            return null;
        }
        return this.lib.createNamespaces(new XmlNode.Namespace[]{namespace})[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Namespace[] createNamespaces(XmlNode.Namespace[] namespaceArr) {
        return this.lib.createNamespaces(namespaceArr);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Scriptable getPrototype() {
        return super.getPrototype();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final void setPrototype(Scriptable scriptable) {
        super.setPrototype(scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Scriptable getParentScope() {
        return super.getParentScope();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final void setParentScope(Scriptable scriptable) {
        super.setParentScope(scriptable);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Object getDefaultValue(Class<?> cls) {
        return toString();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final boolean hasInstance(Scriptable scriptable) {
        return super.hasInstance(scriptable);
    }

    private XMLList getMatches(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        addMatches(newXMLList, xMLName);
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public final Object equivalentValues(Object obj) {
        return equivalentXml(obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final boolean has(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            return has((int) ScriptRuntime.lastUint32Result(context), this);
        }
        return hasXMLProperty(xMLNameOrIndex);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return hasXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final Object get(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            Object obj2 = get((int) ScriptRuntime.lastUint32Result(context), this);
            return obj2 == Scriptable.NOT_FOUND ? Undefined.instance : obj2;
        }
        return getXMLProperty(xMLNameOrIndex);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return getXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final void put(Context context, Object obj, Object obj2) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            put((int) ScriptRuntime.lastUint32Result(context), this, obj2);
        } else {
            putXMLProperty(xMLNameOrIndex, obj2);
        }
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        putXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str), obj);
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public final boolean delete(Context context, Object obj) {
        if (context == null) {
            context = Context.getCurrentContext();
        }
        XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, obj);
        if (xMLNameOrIndex == null) {
            delete((int) ScriptRuntime.lastUint32Result(context));
            return true;
        }
        deleteXMLProperty(xMLNameOrIndex);
        return true;
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(String str) {
        deleteXMLProperty(this.lib.toXMLNameFromString(Context.getCurrentContext(), str));
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Object getFunctionProperty(Context context, int i) {
        if (isPrototype()) {
            return super.get(i, this);
        }
        Scriptable prototype = getPrototype();
        if (prototype instanceof XMLObject) {
            return ((XMLObject) prototype).getFunctionProperty(context, i);
        }
        return NOT_FOUND;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Object getFunctionProperty(Context context, String str) {
        if (isPrototype()) {
            return super.get(str, this);
        }
        Scriptable prototype = getPrototype();
        if (prototype instanceof XMLObject) {
            return ((XMLObject) prototype).getFunctionProperty(context, str);
        }
        return NOT_FOUND;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, int i) {
        boolean z = (i & 2) != 0;
        boolean z2 = (i & 4) != 0;
        if (!z && !z2) {
            throw Kit.codeBug();
        }
        XMLName create = XMLName.create(this.lib.toNodeQName(context, obj, z), z, z2);
        create.initXMLObject(this);
        return create;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, Object obj2, int i) {
        XMLName create = XMLName.create(this.lib.toNodeQName(context, obj, obj2), (i & 2) != 0, (i & 4) != 0);
        create.initXMLObject(this);
        return create;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public NativeWith enterWith(Scriptable scriptable) {
        return new XMLWithScope(this.lib, scriptable, this);
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public NativeWith enterDotQuery(Scriptable scriptable) {
        XMLWithScope xMLWithScope = new XMLWithScope(this.lib, scriptable, this);
        xMLWithScope.initAsDotQuery();
        return xMLWithScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [org.mozilla.javascript.xml.XMLObject] */
    @Override // org.mozilla.javascript.xml.XMLObject
    public final Object addValues(Context context, boolean z, Object obj) {
        XMLObject xMLObject;
        XMLObjectImpl xMLObjectImpl;
        if (obj instanceof XMLObject) {
            if (z) {
                xMLObjectImpl = (XMLObject) obj;
                xMLObject = this;
            } else {
                xMLObject = (XMLObject) obj;
                xMLObjectImpl = this;
            }
            return this.lib.addXMLObjects(context, xMLObject, xMLObjectImpl);
        } else if (obj == Undefined.instance) {
            return ScriptRuntime.toString(this);
        } else {
            return super.addValues(context, z, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void exportAsJSClass(boolean z) {
        this.prototypeFlag = true;
        exportAsJSClass(41, getParentScope(), z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i;
        switch (str.length()) {
            case 4:
                char charAt = str.charAt(0);
                if (charAt != 'c') {
                    if (charAt != 'n') {
                        if (charAt == 't') {
                            i = 37;
                            str2 = "text";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 22;
                        str2 = "name";
                        break;
                    }
                } else {
                    i = 11;
                    str2 = "copy";
                    break;
                }
            case 5:
                i = 6;
                str2 = "child";
                break;
            case 6:
                char charAt2 = str.charAt(0);
                if (charAt2 != 'l') {
                    if (charAt2 == 'p') {
                        i = 27;
                        str2 = "parent";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 20;
                    str2 = SessionDescription.ATTR_LENGTH;
                    break;
                }
            case 7:
                char charAt3 = str.charAt(0);
                if (charAt3 != 'r') {
                    if (charAt3 != 's') {
                        if (charAt3 == 'v') {
                            i = 41;
                            str2 = "valueOf";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 35;
                        str2 = "setName";
                        break;
                    }
                } else {
                    i = 32;
                    str2 = "replace";
                    break;
                }
            case 8:
                char charAt4 = str.charAt(2);
                if (charAt4 == 'S') {
                    char charAt5 = str.charAt(7);
                    if (charAt5 == 'e') {
                        i = 39;
                        str2 = "toSource";
                        break;
                    } else {
                        if (charAt5 == 'g') {
                            i = 38;
                            str2 = "toString";
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else if (charAt4 == 'i') {
                    i = 8;
                    str2 = "children";
                    break;
                } else if (charAt4 == 'd') {
                    i = 25;
                    str2 = "nodeKind";
                    break;
                } else if (charAt4 == 'e') {
                    i = 13;
                    str2 = MessengerShareContentUtility.ELEMENTS;
                    break;
                } else if (charAt4 == 'm') {
                    i = 9;
                    str2 = "comments";
                    break;
                } else {
                    if (charAt4 == 'n') {
                        i = 10;
                        str2 = "contains";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 9:
                char charAt6 = str.charAt(2);
                if (charAt6 == 'c') {
                    i = 21;
                    str2 = "localName";
                    break;
                } else if (charAt6 == 'm') {
                    i = 23;
                    str2 = "namespace";
                    break;
                } else if (charAt6 == 'r') {
                    i = 26;
                    str2 = "normalize";
                    break;
                } else {
                    if (charAt6 == 't') {
                        i = 4;
                        str2 = "attribute";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 10:
                char charAt7 = str.charAt(0);
                if (charAt7 != 'a') {
                    if (charAt7 == 'c') {
                        str2 = "childIndex";
                        i = 7;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 5;
                    str2 = "attributes";
                    break;
                }
            case 11:
                char charAt8 = str.charAt(0);
                if (charAt8 == 'a') {
                    str2 = "appendChild";
                    i = 3;
                    break;
                } else if (charAt8 == 'c') {
                    i = 1;
                    str2 = "constructor";
                    break;
                } else if (charAt8 == 'd') {
                    i = 12;
                    str2 = "descendants";
                    break;
                } else if (charAt8 == 's') {
                    i = 33;
                    str2 = "setChildren";
                    break;
                } else {
                    if (charAt8 == 't') {
                        i = 40;
                        str2 = "toXMLString";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 12:
                char charAt9 = str.charAt(0);
                if (charAt9 != 'a') {
                    if (charAt9 != 'p') {
                        if (charAt9 == 's') {
                            char charAt10 = str.charAt(3);
                            if (charAt10 != 'L') {
                                if (charAt10 == 'N') {
                                    i = 36;
                                    str2 = "setNamespace";
                                    break;
                                }
                            } else {
                                i = 34;
                                str2 = "setLocalName";
                                break;
                            }
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 28;
                        str2 = "prependChild";
                        break;
                    }
                } else {
                    str2 = "addNamespace";
                    i = 2;
                    break;
                }
            case 13:
            case 18:
            case 19:
            default:
                str2 = null;
                i = 0;
                break;
            case 14:
                i = 17;
                str2 = "hasOwnProperty";
                break;
            case 15:
                i = 31;
                str2 = "removeNamespace";
                break;
            case 16:
                char charAt11 = str.charAt(0);
                if (charAt11 != 'h') {
                    if (charAt11 == 'i') {
                        i = 15;
                        str2 = "insertChildAfter";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 19;
                    str2 = "hasSimpleContent";
                    break;
                }
            case 17:
                char charAt12 = str.charAt(3);
                if (charAt12 != 'C') {
                    if (charAt12 != 'c') {
                        if (charAt12 == 'e') {
                            i = 16;
                            str2 = "insertChildBefore";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 14;
                        str2 = "inScopeNamespaces";
                        break;
                    }
                } else {
                    i = 18;
                    str2 = "hasComplexContent";
                    break;
                }
            case 20:
                i = 30;
                str2 = "propertyIsEnumerable";
                break;
            case 21:
                i = 24;
                str2 = "namespaceDeclarations";
                break;
            case 22:
                i = 29;
                str2 = "processingInstructions";
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        IdFunctionObject idFunctionObject;
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                if (this instanceof XML) {
                    idFunctionObject = new XMLCtor((XML) this, XMLOBJECT_TAG, i, 1);
                } else {
                    idFunctionObject = new IdFunctionObject(this, XMLOBJECT_TAG, i, 1);
                }
                initPrototypeConstructor(idFunctionObject);
                return;
            case 2:
                str = "addNamespace";
                break;
            case 3:
                str = "appendChild";
                break;
            case 4:
                str = "attribute";
                break;
            case 5:
                str = "attributes";
                i2 = 0;
                break;
            case 6:
                str = "child";
                break;
            case 7:
                str = "childIndex";
                i2 = 0;
                break;
            case 8:
                str = "children";
                i2 = 0;
                break;
            case 9:
                str = "comments";
                i2 = 0;
                break;
            case 10:
                str = "contains";
                break;
            case 11:
                str = "copy";
                i2 = 0;
                break;
            case 12:
                str = "descendants";
                break;
            case 13:
                str = MessengerShareContentUtility.ELEMENTS;
                break;
            case 14:
                str = "inScopeNamespaces";
                i2 = 0;
                break;
            case 15:
                str2 = "insertChildAfter";
                str = str2;
                i2 = 2;
                break;
            case 16:
                str2 = "insertChildBefore";
                str = str2;
                i2 = 2;
                break;
            case 17:
                str = "hasOwnProperty";
                break;
            case 18:
                str = "hasComplexContent";
                i2 = 0;
                break;
            case 19:
                str = "hasSimpleContent";
                i2 = 0;
                break;
            case 20:
                str = SessionDescription.ATTR_LENGTH;
                i2 = 0;
                break;
            case 21:
                str = "localName";
                i2 = 0;
                break;
            case 22:
                str = "name";
                i2 = 0;
                break;
            case 23:
                str = "namespace";
                break;
            case 24:
                str = "namespaceDeclarations";
                i2 = 0;
                break;
            case 25:
                str = "nodeKind";
                i2 = 0;
                break;
            case 26:
                str = "normalize";
                i2 = 0;
                break;
            case 27:
                str = "parent";
                i2 = 0;
                break;
            case 28:
                str = "prependChild";
                break;
            case 29:
                str = "processingInstructions";
                break;
            case 30:
                str = "propertyIsEnumerable";
                break;
            case 31:
                str = "removeNamespace";
                break;
            case 32:
                str2 = "replace";
                str = str2;
                i2 = 2;
                break;
            case 33:
                str = "setChildren";
                break;
            case 34:
                str = "setLocalName";
                break;
            case 35:
                str = "setName";
                break;
            case 36:
                str = "setNamespace";
                break;
            case 37:
                str = "text";
                i2 = 0;
                break;
            case 38:
                str = "toString";
                i2 = 0;
                break;
            case 39:
                str = "toSource";
                break;
            case 40:
                str = "toXMLString";
                break;
            case 41:
                str = "valueOf";
                i2 = 0;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
    }

    private Object[] toObjectArray(Object[] objArr) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr2[i] = objArr[i];
        }
        return objArr2;
    }

    private void xmlMethodNotFound(Object obj, String str) {
        throw ScriptRuntime.notFunctionError(obj, str);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        String scriptRuntime;
        if (!idFunctionObject.hasTag(XMLOBJECT_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return jsConstructor(context, scriptable2 == null, objArr);
        } else if (!(scriptable2 instanceof XMLObjectImpl)) {
            throw incompatibleCallError(idFunctionObject);
        } else {
            XMLObjectImpl xMLObjectImpl = (XMLObjectImpl) scriptable2;
            XML xml = xMLObjectImpl.getXML();
            switch (methodId) {
                case 2:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "addNamespace");
                    }
                    return xml.addNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                case 3:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "appendChild");
                    }
                    return xml.appendChild(arg(objArr, 0));
                case 4:
                    return xMLObjectImpl.getMatches(XMLName.create(this.lib.toNodeQName(context, arg(objArr, 0), true), true, false));
                case 5:
                    return xMLObjectImpl.getMatches(XMLName.create(XmlNode.QName.create(null, null), true, false));
                case 6:
                    XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                    if (xMLNameOrIndex == null) {
                        return xMLObjectImpl.child((int) ScriptRuntime.lastUint32Result(context));
                    }
                    return xMLObjectImpl.child(xMLNameOrIndex);
                case 7:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "childIndex");
                    }
                    return ScriptRuntime.wrapInt(xml.childIndex());
                case 8:
                    return xMLObjectImpl.children();
                case 9:
                    return xMLObjectImpl.comments();
                case 10:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.contains(arg(objArr, 0)));
                case 11:
                    return xMLObjectImpl.copy();
                case 12:
                    return xMLObjectImpl.getMatches(XMLName.create(objArr.length == 0 ? XmlNode.QName.create(null, null) : this.lib.toNodeQName(context, objArr[0], false), false, true));
                case 13:
                    return xMLObjectImpl.elements(objArr.length == 0 ? XMLName.formStar() : this.lib.toXMLName(context, objArr[0]));
                case 14:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "inScopeNamespaces");
                    }
                    return context.newArray(scriptable, toObjectArray(xml.inScopeNamespaces()));
                case 15:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "insertChildAfter");
                    }
                    Object arg = arg(objArr, 0);
                    if (arg == null || (arg instanceof XML)) {
                        return xml.insertChildAfter((XML) arg, arg(objArr, 1));
                    }
                    return Undefined.instance;
                case 16:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "insertChildBefore");
                    }
                    Object arg2 = arg(objArr, 0);
                    if (arg2 == null || (arg2 instanceof XML)) {
                        return xml.insertChildBefore((XML) arg2, arg(objArr, 1));
                    }
                    return Undefined.instance;
                case 17:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasOwnProperty(this.lib.toXMLName(context, arg(objArr, 0))));
                case 18:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasComplexContent());
                case 19:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasSimpleContent());
                case 20:
                    return ScriptRuntime.wrapInt(xMLObjectImpl.length());
                case 21:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "localName");
                    }
                    return xml.localName();
                case 22:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "name");
                    }
                    return xml.name();
                case 23:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "namespace");
                    }
                    Namespace namespace = xml.namespace(objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : null);
                    return namespace == null ? Undefined.instance : namespace;
                case 24:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "namespaceDeclarations");
                    }
                    return context.newArray(scriptable, toObjectArray(xml.namespaceDeclarations()));
                case 25:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "nodeKind");
                    }
                    return xml.nodeKind();
                case 26:
                    xMLObjectImpl.normalize();
                    return Undefined.instance;
                case 27:
                    return xMLObjectImpl.parent();
                case 28:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "prependChild");
                    }
                    return xml.prependChild(arg(objArr, 0));
                case 29:
                    return xMLObjectImpl.processingInstructions(objArr.length > 0 ? this.lib.toXMLName(context, objArr[0]) : XMLName.formStar());
                case 30:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.propertyIsEnumerable(arg(objArr, 0)));
                case 31:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "removeNamespace");
                    }
                    return xml.removeNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                case 32:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "replace");
                    }
                    XMLName xMLNameOrIndex2 = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                    Object arg3 = arg(objArr, 1);
                    if (xMLNameOrIndex2 == null) {
                        return xml.replace((int) ScriptRuntime.lastUint32Result(context), arg3);
                    }
                    return xml.replace(xMLNameOrIndex2, arg3);
                case 33:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setChildren");
                    }
                    return xml.setChildren(arg(objArr, 0));
                case 34:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setLocalName");
                    }
                    Object arg4 = arg(objArr, 0);
                    if (arg4 instanceof QName) {
                        scriptRuntime = ((QName) arg4).localName();
                    } else {
                        scriptRuntime = ScriptRuntime.toString(arg4);
                    }
                    xml.setLocalName(scriptRuntime);
                    return Undefined.instance;
                case 35:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setName");
                    }
                    xml.setName(this.lib.constructQName(context, objArr.length != 0 ? objArr[0] : Undefined.instance));
                    return Undefined.instance;
                case 36:
                    if (xml == null) {
                        xmlMethodNotFound(xMLObjectImpl, "setNamespace");
                    }
                    xml.setNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                    return Undefined.instance;
                case 37:
                    return xMLObjectImpl.text();
                case 38:
                    return xMLObjectImpl.toString();
                case 39:
                    return xMLObjectImpl.toSource(ScriptRuntime.toInt32(objArr, 0));
                case 40:
                    return xMLObjectImpl.toXMLString();
                case 41:
                    return xMLObjectImpl.valueOf();
                default:
                    throw new IllegalArgumentException(String.valueOf(methodId));
            }
        }
    }

    private static Object arg(Object[] objArr, int i) {
        return i < objArr.length ? objArr[i] : Undefined.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XML newTextElementXML(XmlNode xmlNode, XmlNode.QName qName, String str) {
        return this.lib.newTextElementXML(xmlNode, qName, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XML newXMLFromJs(Object obj) {
        return this.lib.newXMLFromJs(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XML ecmaToXml(Object obj) {
        return this.lib.ecmaToXml(obj);
    }

    final String ecmaEscapeAttributeValue(String str) {
        String escapeAttributeValue = this.lib.escapeAttributeValue(str);
        return escapeAttributeValue.substring(1, escapeAttributeValue.length() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final XML createEmptyXML() {
        return newXML(XmlNode.createEmpty(getProcessor()));
    }
}
