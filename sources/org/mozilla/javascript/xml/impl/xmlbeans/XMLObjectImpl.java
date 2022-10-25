package org.mozilla.javascript.xml.impl.xmlbeans;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import org.apache.xmlbeans.XmlObject;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeWith;
import org.mozilla.javascript.Ref;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;

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
    private static final int Id_getXmlObject = 41;
    private static final int Id_hasComplexContent = 17;
    private static final int Id_hasOwnProperty = 16;
    private static final int Id_hasSimpleContent = 18;
    private static final int Id_inScopeNamespaces = 13;
    private static final int Id_insertChildAfter = 14;
    private static final int Id_insertChildBefore = 15;
    private static final int Id_length = 19;
    private static final int Id_localName = 20;
    private static final int Id_name = 21;
    private static final int Id_namespace = 22;
    private static final int Id_namespaceDeclarations = 23;
    private static final int Id_nodeKind = 24;
    private static final int Id_normalize = 25;
    private static final int Id_parent = 26;
    private static final int Id_prependChild = 27;
    private static final int Id_processingInstructions = 28;
    private static final int Id_propertyIsEnumerable = 29;
    private static final int Id_removeNamespace = 30;
    private static final int Id_replace = 31;
    private static final int Id_setChildren = 32;
    private static final int Id_setLocalName = 33;
    private static final int Id_setName = 34;
    private static final int Id_setNamespace = 35;
    private static final int Id_text = 36;
    private static final int Id_toSource = 38;
    private static final int Id_toString = 37;
    private static final int Id_toXMLString = 39;
    private static final int Id_valueOf = 40;
    private static final int MAX_PROTOTYPE_ID = 41;
    private static final Object XMLOBJECT_TAG = "XMLObject";
    protected final XMLLibImpl lib;
    protected boolean prototypeFlag;

    abstract XML addNamespace(Namespace namespace);

    abstract XML appendChild(Object obj);

    abstract XMLList attribute(XMLName xMLName);

    abstract XMLList attributes();

    abstract XMLList child(long j);

    abstract XMLList child(XMLName xMLName);

    abstract int childIndex();

    abstract XMLList children();

    abstract XMLList comments();

    abstract boolean contains(Object obj);

    abstract Object copy();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void deleteXMLProperty(XMLName xMLName);

    abstract XMLList descendants(XMLName xMLName);

    abstract boolean equivalentXml(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object getXMLProperty(XMLName xMLName);

    abstract XmlObject getXmlObject();

    abstract boolean hasComplexContent();

    abstract boolean hasOwnProperty(XMLName xMLName);

    abstract boolean hasSimpleContent();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasXMLProperty(XMLName xMLName);

    abstract Object[] inScopeNamespaces();

    abstract XML insertChildAfter(Object obj, Object obj2);

    abstract XML insertChildBefore(Object obj, Object obj2);

    protected abstract Object jsConstructor(Context context, boolean z, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int length();

    abstract String localName();

    abstract QName name();

    abstract Object namespace(String str);

    abstract Object[] namespaceDeclarations();

    abstract Object nodeKind();

    abstract void normalize();

    abstract Object parent();

    abstract XML prependChild(Object obj);

    abstract Object processingInstructions(XMLName xMLName);

    abstract boolean propertyIsEnumerable(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void putXMLProperty(XMLName xMLName, Object obj);

    abstract XML removeNamespace(Namespace namespace);

    abstract XML replace(long j, Object obj);

    abstract XML replace(XMLName xMLName, Object obj);

    abstract XML setChildren(Object obj);

    abstract void setLocalName(String str);

    abstract void setName(QName qName);

    abstract void setNamespace(Namespace namespace);

    abstract XMLList text();

    abstract String toSource(int i);

    public abstract String toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String toXMLString(int i);

    abstract Object valueOf();

    /* JADX INFO: Access modifiers changed from: protected */
    public XMLObjectImpl(XMLLibImpl xMLLibImpl, XMLObject xMLObject) {
        super(xMLLibImpl.globalScope(), xMLObject);
        this.lib = xMLLibImpl;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public final Object getDefaultValue(Class cls) {
        return toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.ScriptableObject
    public final Object equivalentValues(Object obj) {
        return equivalentXml(obj) ? Boolean.TRUE : Boolean.FALSE;
    }

    public final XMLLib lib() {
        return this.lib;
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
        if (this.prototypeFlag) {
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
        if (this.prototypeFlag) {
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
        XMLName xMLName;
        if ((i & 2) != 0) {
            xMLName = this.lib.toAttributeName(context, obj);
        } else if ((i & 4) == 0) {
            throw Kit.codeBug();
        } else {
            xMLName = this.lib.toXMLName(context, obj);
        }
        if ((i & 4) != 0) {
            xMLName.setIsDescendants();
        }
        xMLName.initXMLObject(this);
        return xMLName;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Ref memberRef(Context context, Object obj, Object obj2, int i) {
        XMLName qualifiedName = this.lib.toQualifiedName(context, obj, obj2);
        if ((i & 2) != 0 && !qualifiedName.isAttributeName()) {
            qualifiedName.setAttributeName();
        }
        if ((i & 4) != 0) {
            qualifiedName.setIsDescendants();
        }
        qualifiedName.initXMLObject(this);
        return qualifiedName;
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
        exportAsJSClass(41, this.lib.globalScope(), z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        String str2;
        int i = 2;
        switch (str.length()) {
            case 4:
                char charAt = str.charAt(0);
                if (charAt != 'c') {
                    if (charAt != 'n') {
                        if (charAt == 't') {
                            i = 36;
                            str2 = "text";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 21;
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
                        i = 26;
                        str2 = "parent";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 19;
                    str2 = SessionDescription.ATTR_LENGTH;
                    break;
                }
            case 7:
                char charAt3 = str.charAt(0);
                if (charAt3 != 'r') {
                    if (charAt3 != 's') {
                        if (charAt3 == 'v') {
                            i = 40;
                            str2 = "valueOf";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 34;
                        str2 = "setName";
                        break;
                    }
                } else {
                    i = 31;
                    str2 = "replace";
                    break;
                }
            case 8:
                char charAt4 = str.charAt(4);
                if (charAt4 == 'K') {
                    i = 24;
                    str2 = "nodeKind";
                    break;
                } else if (charAt4 == 'a') {
                    i = 10;
                    str2 = "contains";
                    break;
                } else if (charAt4 == 'r') {
                    i = 37;
                    str2 = "toString";
                    break;
                } else if (charAt4 == 'u') {
                    i = 38;
                    str2 = "toSource";
                    break;
                } else if (charAt4 == 'd') {
                    i = 8;
                    str2 = "children";
                    break;
                } else {
                    if (charAt4 == 'e') {
                        i = 9;
                        str2 = "comments";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 9:
                char charAt5 = str.charAt(2);
                if (charAt5 == 'c') {
                    i = 20;
                    str2 = "localName";
                    break;
                } else if (charAt5 == 'm') {
                    i = 22;
                    str2 = "namespace";
                    break;
                } else if (charAt5 == 'r') {
                    i = 25;
                    str2 = "normalize";
                    break;
                } else {
                    if (charAt5 == 't') {
                        str2 = "attribute";
                        i = 4;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 10:
                char charAt6 = str.charAt(0);
                if (charAt6 != 'a') {
                    if (charAt6 == 'c') {
                        i = 7;
                        str2 = "childIndex";
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
                char charAt7 = str.charAt(0);
                if (charAt7 == 'a') {
                    str2 = "appendChild";
                    i = 3;
                    break;
                } else if (charAt7 == 'c') {
                    i = 1;
                    str2 = "constructor";
                    break;
                } else if (charAt7 == 'd') {
                    i = 12;
                    str2 = "descendants";
                    break;
                } else if (charAt7 == 's') {
                    i = 32;
                    str2 = "setChildren";
                    break;
                } else {
                    if (charAt7 == 't') {
                        i = 39;
                        str2 = "toXMLString";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                }
            case 12:
                char charAt8 = str.charAt(0);
                if (charAt8 == 'a') {
                    str2 = "addNamespace";
                    break;
                } else if (charAt8 == 'g') {
                    i = 41;
                    str2 = "getXmlObject";
                    break;
                } else if (charAt8 == 'p') {
                    i = 27;
                    str2 = "prependChild";
                    break;
                } else {
                    if (charAt8 == 's') {
                        char charAt9 = str.charAt(3);
                        if (charAt9 != 'L') {
                            if (charAt9 == 'N') {
                                i = 35;
                                str2 = "setNamespace";
                                break;
                            }
                        } else {
                            i = 33;
                            str2 = "setLocalName";
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
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
                i = 16;
                str2 = "hasOwnProperty";
                break;
            case 15:
                i = 30;
                str2 = "removeNamespace";
                break;
            case 16:
                char charAt10 = str.charAt(0);
                if (charAt10 != 'h') {
                    if (charAt10 == 'i') {
                        i = 14;
                        str2 = "insertChildAfter";
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    i = 18;
                    str2 = "hasSimpleContent";
                    break;
                }
            case 17:
                char charAt11 = str.charAt(3);
                if (charAt11 != 'C') {
                    if (charAt11 != 'c') {
                        if (charAt11 == 'e') {
                            i = 15;
                            str2 = "insertChildBefore";
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        i = 13;
                        str2 = "inScopeNamespaces";
                        break;
                    }
                } else {
                    i = 17;
                    str2 = "hasComplexContent";
                    break;
                }
            case 20:
                i = 29;
                str2 = "propertyIsEnumerable";
                break;
            case 21:
                i = 23;
                str2 = "namespaceDeclarations";
                break;
            case 22:
                i = 28;
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
        int i2 = 0;
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
                i2 = 1;
                break;
            case 3:
                str = "appendChild";
                i2 = 1;
                break;
            case 4:
                str = "attribute";
                i2 = 1;
                break;
            case 5:
                str = "attributes";
                break;
            case 6:
                str = "child";
                i2 = 1;
                break;
            case 7:
                str = "childIndex";
                break;
            case 8:
                str = "children";
                break;
            case 9:
                str = "comments";
                break;
            case 10:
                str = "contains";
                i2 = 1;
                break;
            case 11:
                str = "copy";
                break;
            case 12:
                str = "descendants";
                i2 = 1;
                break;
            case 13:
                str = "inScopeNamespaces";
                break;
            case 14:
                str2 = "insertChildAfter";
                str = str2;
                i2 = 2;
                break;
            case 15:
                str2 = "insertChildBefore";
                str = str2;
                i2 = 2;
                break;
            case 16:
                str = "hasOwnProperty";
                i2 = 1;
                break;
            case 17:
                str = "hasComplexContent";
                break;
            case 18:
                str = "hasSimpleContent";
                break;
            case 19:
                str = SessionDescription.ATTR_LENGTH;
                break;
            case 20:
                str = "localName";
                break;
            case 21:
                str = "name";
                break;
            case 22:
                str = "namespace";
                i2 = 1;
                break;
            case 23:
                str = "namespaceDeclarations";
                break;
            case 24:
                str = "nodeKind";
                break;
            case 25:
                str = "normalize";
                break;
            case 26:
                str = "parent";
                break;
            case 27:
                str = "prependChild";
                i2 = 1;
                break;
            case 28:
                str = "processingInstructions";
                i2 = 1;
                break;
            case 29:
                str = "propertyIsEnumerable";
                i2 = 1;
                break;
            case 30:
                str = "removeNamespace";
                i2 = 1;
                break;
            case 31:
                str2 = "replace";
                str = str2;
                i2 = 2;
                break;
            case 32:
                str = "setChildren";
                i2 = 1;
                break;
            case 33:
                str = "setLocalName";
                i2 = 1;
                break;
            case 34:
                str = "setName";
                i2 = 1;
                break;
            case 35:
                str = "setNamespace";
                i2 = 1;
                break;
            case 36:
                str = "text";
                break;
            case 37:
                str = "toString";
                break;
            case 38:
                str = "toSource";
                i2 = 1;
                break;
            case 39:
                str = "toXMLString";
                i2 = 1;
                break;
            case 40:
                str = "valueOf";
                break;
            case 41:
                str = "getXmlObject";
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(XMLOBJECT_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        String scriptRuntime;
        QName constructQName;
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
            switch (methodId) {
                case 2:
                    return xMLObjectImpl.addNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                case 3:
                    return xMLObjectImpl.appendChild(arg(objArr, 0));
                case 4:
                    return xMLObjectImpl.attribute(this.lib.toAttributeName(context, arg(objArr, 0)));
                case 5:
                    return xMLObjectImpl.attributes();
                case 6:
                    XMLName xMLNameOrIndex = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                    if (xMLNameOrIndex == null) {
                        return xMLObjectImpl.child(ScriptRuntime.lastUint32Result(context));
                    }
                    return xMLObjectImpl.child(xMLNameOrIndex);
                case 7:
                    return ScriptRuntime.wrapInt(xMLObjectImpl.childIndex());
                case 8:
                    return xMLObjectImpl.children();
                case 9:
                    return xMLObjectImpl.comments();
                case 10:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.contains(arg(objArr, 0)));
                case 11:
                    return xMLObjectImpl.copy();
                case 12:
                    return xMLObjectImpl.descendants(objArr.length == 0 ? XMLName.formStar() : this.lib.toXMLName(context, objArr[0]));
                case 13:
                    return context.newArray(scriptable, xMLObjectImpl.inScopeNamespaces());
                case 14:
                    return xMLObjectImpl.insertChildAfter(arg(objArr, 0), arg(objArr, 1));
                case 15:
                    return xMLObjectImpl.insertChildBefore(arg(objArr, 0), arg(objArr, 1));
                case 16:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasOwnProperty(this.lib.toXMLName(context, arg(objArr, 0))));
                case 17:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasComplexContent());
                case 18:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.hasSimpleContent());
                case 19:
                    return ScriptRuntime.wrapInt(xMLObjectImpl.length());
                case 20:
                    return xMLObjectImpl.localName();
                case 21:
                    return xMLObjectImpl.name();
                case 22:
                    return xMLObjectImpl.namespace(objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : null);
                case 23:
                    return context.newArray(scriptable, xMLObjectImpl.namespaceDeclarations());
                case 24:
                    return xMLObjectImpl.nodeKind();
                case 25:
                    xMLObjectImpl.normalize();
                    return Undefined.instance;
                case 26:
                    return xMLObjectImpl.parent();
                case 27:
                    return xMLObjectImpl.prependChild(arg(objArr, 0));
                case 28:
                    return xMLObjectImpl.processingInstructions(objArr.length > 0 ? this.lib.toXMLName(context, objArr[0]) : XMLName.formStar());
                case 29:
                    return ScriptRuntime.wrapBoolean(xMLObjectImpl.propertyIsEnumerable(arg(objArr, 0)));
                case 30:
                    return xMLObjectImpl.removeNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                case 31:
                    XMLName xMLNameOrIndex2 = this.lib.toXMLNameOrIndex(context, arg(objArr, 0));
                    Object arg = arg(objArr, 1);
                    if (xMLNameOrIndex2 == null) {
                        return xMLObjectImpl.replace(ScriptRuntime.lastUint32Result(context), arg);
                    }
                    return xMLObjectImpl.replace(xMLNameOrIndex2, arg);
                case 32:
                    return xMLObjectImpl.setChildren(arg(objArr, 0));
                case 33:
                    Object arg2 = arg(objArr, 0);
                    if (arg2 instanceof QName) {
                        scriptRuntime = ((QName) arg2).localName();
                    } else {
                        scriptRuntime = ScriptRuntime.toString(arg2);
                    }
                    xMLObjectImpl.setLocalName(scriptRuntime);
                    return Undefined.instance;
                case 34:
                    Object obj = objArr.length != 0 ? objArr[0] : Undefined.instance;
                    if (obj instanceof QName) {
                        QName qName = (QName) obj;
                        if (qName.uri() == null) {
                            constructQName = this.lib.constructQNameFromString(context, qName.localName());
                        } else {
                            constructQName = this.lib.constructQName(context, qName);
                        }
                    } else {
                        constructQName = this.lib.constructQName(context, obj);
                    }
                    xMLObjectImpl.setName(constructQName);
                    return Undefined.instance;
                case 35:
                    xMLObjectImpl.setNamespace(this.lib.castToNamespace(context, arg(objArr, 0)));
                    return Undefined.instance;
                case 36:
                    return xMLObjectImpl.text();
                case 37:
                    return xMLObjectImpl.toString();
                case 38:
                    return xMLObjectImpl.toSource(ScriptRuntime.toInt32(objArr, 0));
                case 39:
                    return xMLObjectImpl.toXMLString(ScriptRuntime.toInt32(objArr, 0));
                case 40:
                    return xMLObjectImpl.valueOf();
                case 41:
                    return Context.javaToJS(xMLObjectImpl.getXmlObject(), scriptable);
                default:
                    throw new IllegalArgumentException(String.valueOf(methodId));
            }
        }
    }

    private static Object arg(Object[] objArr, int i) {
        return i < objArr.length ? objArr[i] : Undefined.instance;
    }
}
