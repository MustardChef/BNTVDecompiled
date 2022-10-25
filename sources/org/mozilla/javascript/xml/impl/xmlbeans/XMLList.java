package org.mozilla.javascript.xml.impl.xmlbeans;

import androidx.core.app.NotificationCompat;
import java.util.Vector;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.mozilla.javascript.Callable;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xml.impl.xmlbeans.XML;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class XMLList extends XMLObjectImpl implements Function {
    static final long serialVersionUID = -4543618751670781135L;
    private AnnotationList _annos;
    private XMLObjectImpl targetObject;
    private javax.xml.namespace.QName targetProperty;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XMLList";
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object valueOf() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AnnotationList {

        /* renamed from: v */
        private Vector f10800v = new Vector();

        AnnotationList() {
        }

        void add(XML.XScriptAnnotation xScriptAnnotation) {
            this.f10800v.add(xScriptAnnotation);
        }

        XML.XScriptAnnotation item(int i) {
            return (XML.XScriptAnnotation) this.f10800v.get(i);
        }

        void remove(int i) {
            this.f10800v.remove(i);
        }

        int length() {
            return this.f10800v.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLList(XMLLibImpl xMLLibImpl) {
        super(xMLLibImpl, xMLLibImpl.xmlListPrototype);
        this.targetObject = null;
        this.targetProperty = null;
        this._annos = new AnnotationList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLList(XMLLibImpl xMLLibImpl, Object obj) {
        super(xMLLibImpl, xMLLibImpl.xmlListPrototype);
        String str;
        this.targetObject = null;
        this.targetProperty = null;
        if (obj == null || (obj instanceof Undefined)) {
            return;
        }
        if (obj instanceof XML) {
            AnnotationList annotationList = new AnnotationList();
            this._annos = annotationList;
            annotationList.add(((XML) obj).getAnnotation());
            return;
        }
        int i = 0;
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            this._annos = new AnnotationList();
            while (i < xMLList._annos.length()) {
                this._annos.add(xMLList._annos.item(i));
                i++;
            }
            return;
        }
        String trim = ScriptRuntime.toString(obj).trim();
        if (!trim.startsWith("<>")) {
            trim = "<>" + trim + "</>";
        }
        if (!("<fragment>" + trim.substring(2)).endsWith("</>")) {
            throw ScriptRuntime.typeError("XML with anonymous tag missing end anonymous tag");
        }
        XMLList children = XML.createFromJS(xMLLibImpl, str.substring(0, str.length() - 3) + "</fragment>").children();
        this._annos = new AnnotationList();
        while (i < children._annos.length()) {
            this._annos.add(((XML) children.item(i).copy()).getAnnotation());
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTargets(XMLObjectImpl xMLObjectImpl, javax.xml.namespace.QName qName) {
        this.targetObject = xMLObjectImpl;
        this.targetProperty = qName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML getXmlFromAnnotation(int i) {
        if (i < 0 || i >= length()) {
            return null;
        }
        return XML.getFromAnnotation(this.lib, this._annos.item(i));
    }

    private void internalRemoveFromList(int i) {
        this._annos.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replace(int i, XML xml) {
        if (i >= length()) {
            return;
        }
        AnnotationList annotationList = new AnnotationList();
        for (int i2 = 0; i2 < i; i2++) {
            annotationList.add(this._annos.item(i2));
        }
        annotationList.add(xml.getAnnotation());
        while (true) {
            i++;
            if (i < length()) {
                annotationList.add(this._annos.item(i));
            } else {
                this._annos = annotationList;
                return;
            }
        }
    }

    private void insert(int i, XML xml) {
        if (i < length()) {
            AnnotationList annotationList = new AnnotationList();
            for (int i2 = 0; i2 < i; i2++) {
                annotationList.add(this._annos.item(i2));
            }
            annotationList.add(xml.getAnnotation());
            while (i < length()) {
                annotationList.add(this._annos.item(i));
                i++;
            }
            this._annos = annotationList;
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (i >= 0 && i < length()) {
            return getXmlFromAnnotation(i);
        }
        return Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i >= 0 && i < length();
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    void putXMLProperty(XMLName xMLName, Object obj) {
        javax.xml.namespace.QName qName;
        if (obj == null) {
            obj = "null";
        } else if (obj instanceof Undefined) {
            obj = "undefined";
        }
        if (length() > 1) {
            throw ScriptRuntime.typeError("Assignment to lists with more that one item is not supported");
        }
        if (length() == 0) {
            if (this.targetObject != null && (qName = this.targetProperty) != null && !qName.getLocalPart().equals("*")) {
                addToList(XML.createTextElement(this.lib, this.targetProperty, ""));
                if (xMLName.isAttributeName()) {
                    setAttribute(xMLName, obj);
                } else {
                    item(0).putXMLProperty(xMLName, obj);
                    replace(0, item(0));
                }
                this.targetObject.putXMLProperty(XMLName.formProperty(this.targetProperty.getNamespaceURI(), this.targetProperty.getLocalPart()), this);
                return;
            }
            throw ScriptRuntime.typeError("Assignment to empty XMLList without targets not supported");
        } else if (xMLName.isAttributeName()) {
            setAttribute(xMLName, obj);
        } else {
            item(0).putXMLProperty(xMLName, obj);
            replace(0, item(0));
        }
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        Object createTextElement;
        Object parent;
        Object obj2 = Undefined.instance;
        if (obj == null) {
            obj = "null";
        } else if (obj instanceof Undefined) {
            obj = "undefined";
        }
        if (obj instanceof XMLObject) {
            createTextElement = (XMLObject) obj;
        } else if (this.targetProperty == null) {
            createTextElement = XML.createFromJS(this.lib, obj.toString());
        } else {
            createTextElement = XML.createTextElement(this.lib, this.targetProperty, obj.toString());
        }
        if (i < length()) {
            parent = item(i).parent();
        } else {
            parent = parent();
        }
        if (parent instanceof XML) {
            XML xml = (XML) parent;
            if (i < length()) {
                XML xmlFromAnnotation = getXmlFromAnnotation(i);
                if (createTextElement instanceof XML) {
                    xmlFromAnnotation.replaceAll((XML) createTextElement);
                    replace(i, xmlFromAnnotation);
                    return;
                } else if (createTextElement instanceof XMLList) {
                    XMLList xMLList = (XMLList) createTextElement;
                    if (xMLList.length() > 0) {
                        int childIndex = xmlFromAnnotation.childIndex();
                        xmlFromAnnotation.replaceAll(xMLList.item(0));
                        replace(i, xMLList.item(0));
                        for (int i2 = 1; i2 < xMLList.length(); i2++) {
                            xml.insertChildAfter(xml.getXmlChild(childIndex), xMLList.item(i2));
                            childIndex++;
                            insert(i + i2, xMLList.item(i2));
                        }
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            xml.appendChild(createTextElement);
            addToList(xml.getXmlChild(i));
        } else if (i < length()) {
            XML fromAnnotation = XML.getFromAnnotation(this.lib, this._annos.item(i));
            if (createTextElement instanceof XML) {
                fromAnnotation.replaceAll((XML) createTextElement);
                replace(i, fromAnnotation);
            } else if (createTextElement instanceof XMLList) {
                XMLList xMLList2 = (XMLList) createTextElement;
                if (xMLList2.length() > 0) {
                    fromAnnotation.replaceAll(xMLList2.item(0));
                    replace(i, xMLList2.item(0));
                    for (int i3 = 1; i3 < xMLList2.length(); i3++) {
                        insert(i + i3, xMLList2.item(i3));
                    }
                }
            }
        } else {
            addToList(createTextElement);
        }
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    void deleteXMLProperty(XMLName xMLName) {
        for (int i = 0; i < length(); i++) {
            XML xmlFromAnnotation = getXmlFromAnnotation(i);
            if (xmlFromAnnotation.tokenType() == XmlCursor.TokenType.START) {
                xmlFromAnnotation.deleteXMLProperty(xMLName);
            }
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i < 0 || i >= length()) {
            return;
        }
        getXmlFromAnnotation(i).remove();
        internalRemoveFromList(i);
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        if (this.prototypeFlag) {
            return new Object[0];
        }
        int length = length();
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = new Integer(i);
        }
        return objArr;
    }

    public Object[] getIdsForDebug() {
        return getIds();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        for (int length = length() - 1; length >= 0; length--) {
            XML xmlFromAnnotation = getXmlFromAnnotation(length);
            if (xmlFromAnnotation != null) {
                xmlFromAnnotation.remove();
                internalRemoveFromList(length);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML item(int i) {
        return this._annos != null ? getXmlFromAnnotation(i) : XML.createEmptyXML(this.lib);
    }

    private void setAttribute(XMLName xMLName, Object obj) {
        for (int i = 0; i < length(); i++) {
            getXmlFromAnnotation(i).setAttribute(xMLName, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addToList(Object obj) {
        if (obj instanceof Undefined) {
            return;
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            for (int i = 0; i < xMLList.length(); i++) {
                this._annos.add(xMLList.item(i).getAnnotation());
            }
        } else if (obj instanceof XML) {
            this._annos.add(((XML) obj).getAnnotation());
        } else if (obj instanceof XML.XScriptAnnotation) {
            this._annos.add((XML.XScriptAnnotation) obj);
        }
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML addNamespace(Namespace namespace) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).addNamespace(namespace);
        }
        throw ScriptRuntime.typeError("The addNamespace method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML appendChild(Object obj) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).appendChild(obj);
        }
        throw ScriptRuntime.typeError("The appendChild method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList attribute(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).attribute(xMLName));
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList attributes() {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).attributes());
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList child(long j) {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).child(j));
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList child(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).child(xMLName));
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    int childIndex() {
        if (length() == 1) {
            return getXmlFromAnnotation(0).childIndex();
        }
        throw ScriptRuntime.typeError("The childIndex method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList children() {
        Vector vector = new Vector();
        for (int i = 0; i < length(); i++) {
            XML xmlFromAnnotation = getXmlFromAnnotation(i);
            if (xmlFromAnnotation != null) {
                XMLList children = xmlFromAnnotation.children();
                if (children instanceof XMLList) {
                    XMLList xMLList = children;
                    int length = xMLList.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        vector.addElement(xMLList.item(i2));
                    }
                }
            }
        }
        XMLList xMLList2 = new XMLList(this.lib);
        int size = vector.size();
        for (int i3 = 0; i3 < size; i3++) {
            xMLList2.addToList(vector.get(i3));
        }
        return xMLList2;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList comments() {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).comments());
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean contains(Object obj) {
        for (int i = 0; i < length(); i++) {
            if (getXmlFromAnnotation(i).equivalentXml(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object copy() {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).copy());
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList descendants(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).descendants(xMLName));
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object[] inScopeNamespaces() {
        if (length() == 1) {
            return getXmlFromAnnotation(0).inScopeNamespaces();
        }
        throw ScriptRuntime.typeError("The inScopeNamespaces method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML insertChildAfter(Object obj, Object obj2) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).insertChildAfter(obj, obj2);
        }
        throw ScriptRuntime.typeError("The insertChildAfter method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML insertChildBefore(Object obj, Object obj2) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).insertChildAfter(obj, obj2);
        }
        throw ScriptRuntime.typeError("The insertChildBefore method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean hasOwnProperty(XMLName xMLName) {
        if (this.prototypeFlag) {
            if (findPrototypeId(xMLName.localName()) != 0) {
                return true;
            }
        } else if (getPropertyList(xMLName).length() > 0) {
            return true;
        }
        return false;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean hasComplexContent() {
        int length = length();
        if (length != 0) {
            if (length == 1) {
                return getXmlFromAnnotation(0).hasComplexContent();
            }
            for (int i = 0; i < length; i++) {
                if (getXmlFromAnnotation(i).tokenType() == XmlCursor.TokenType.START) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean hasSimpleContent() {
        int length = length();
        if (length != 0) {
            if (length == 1) {
                return getXmlFromAnnotation(0).hasSimpleContent();
            }
            for (int i = 0; i < length; i++) {
                if (getXmlFromAnnotation(i).tokenType() == XmlCursor.TokenType.START) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public int length() {
        AnnotationList annotationList = this._annos;
        if (annotationList != null) {
            return annotationList.length();
        }
        return 0;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    String localName() {
        if (length() == 1) {
            return name().localName();
        }
        throw ScriptRuntime.typeError("The localName method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    QName name() {
        if (length() == 1) {
            return getXmlFromAnnotation(0).name();
        }
        throw ScriptRuntime.typeError("The name method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object namespace(String str) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).namespace(str);
        }
        throw ScriptRuntime.typeError("The namespace method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object[] namespaceDeclarations() {
        if (length() == 1) {
            return getXmlFromAnnotation(0).namespaceDeclarations();
        }
        throw ScriptRuntime.typeError("The namespaceDeclarations method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object nodeKind() {
        if (length() == 1) {
            return getXmlFromAnnotation(0).nodeKind();
        }
        throw ScriptRuntime.typeError("The nodeKind method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    void normalize() {
        for (int i = 0; i < length(); i++) {
            getXmlFromAnnotation(i).normalize();
        }
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object parent() {
        XMLObjectImpl xMLObjectImpl;
        Object obj = Undefined.instance;
        if (length() == 0 && (xMLObjectImpl = this.targetObject) != null && (xMLObjectImpl instanceof XML)) {
            return xMLObjectImpl;
        }
        for (int i = 0; i < length(); i++) {
            Object parent = getXmlFromAnnotation(i).parent();
            if (i == 0) {
                obj = parent;
            } else if (obj != parent) {
                return Undefined.instance;
            }
        }
        return obj;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML prependChild(Object obj) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).prependChild(obj);
        }
        throw ScriptRuntime.typeError("The prependChild method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object processingInstructions(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).processingInstructions(xMLName));
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean propertyIsEnumerable(Object obj) {
        long testUint32String;
        if (obj instanceof Integer) {
            testUint32String = ((Integer) obj).intValue();
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            long j = (long) doubleValue;
            if (j != doubleValue) {
                return false;
            }
            if (j == 0 && 1.0d / doubleValue < 0.0d) {
                return false;
            }
            testUint32String = j;
        } else {
            testUint32String = ScriptRuntime.testUint32String(ScriptRuntime.toString(obj));
        }
        return 0 <= testUint32String && testUint32String < ((long) length());
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML removeNamespace(Namespace namespace) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).removeNamespace(namespace);
        }
        throw ScriptRuntime.typeError("The removeNamespace method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML replace(long j, Object obj) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).replace(j, obj);
        }
        throw ScriptRuntime.typeError("The replace method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML replace(XMLName xMLName, Object obj) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).replace(xMLName, obj);
        }
        throw ScriptRuntime.typeError("The replace method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML setChildren(Object obj) {
        if (length() == 1) {
            return getXmlFromAnnotation(0).setChildren(obj);
        }
        throw ScriptRuntime.typeError("The setChildren method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    void setLocalName(String str) {
        if (length() == 1) {
            getXmlFromAnnotation(0).setLocalName(str);
            return;
        }
        throw ScriptRuntime.typeError("The setLocalName method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    void setName(QName qName) {
        if (length() == 1) {
            getXmlFromAnnotation(0).setName(qName);
            return;
        }
        throw ScriptRuntime.typeError("The setName method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    void setNamespace(Namespace namespace) {
        if (length() == 1) {
            getXmlFromAnnotation(0).setNamespace(namespace);
            return;
        }
        throw ScriptRuntime.typeError("The setNamespace method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XMLList text() {
        XMLList xMLList = new XMLList(this.lib);
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).text());
        }
        return xMLList;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public String toString() {
        if (hasSimpleContent()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < length(); i++) {
                stringBuffer.append(getXmlFromAnnotation(i).toString());
            }
            return stringBuffer.toString();
        }
        return toXMLString(0);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    String toSource(int i) {
        return "<>" + toXMLString(0) + "</>";
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    String toXMLString(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length(); i2++) {
            if (i2 > 0) {
                stringBuffer.append('\n');
            }
            stringBuffer.append(getXmlFromAnnotation(i2).toXMLString(i));
        }
        return stringBuffer.toString();
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean equivalentXml(Object obj) {
        if ((obj instanceof Undefined) && length() == 0) {
            return true;
        }
        if (length() == 1) {
            return getXmlFromAnnotation(0).equivalentXml(obj);
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.length() == length()) {
                for (int i = 0; i < length(); i++) {
                    if (getXmlFromAnnotation(i).equivalentXml(xMLList.getXmlFromAnnotation(i))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    private XMLList getPropertyList(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        xMLList.setTargets(this, (xMLName.isDescendants() || xMLName.isAttributeName()) ? null : new javax.xml.namespace.QName(xMLName.uri(), xMLName.localName()));
        for (int i = 0; i < length(); i++) {
            xMLList.addToList(getXmlFromAnnotation(i).getPropertyList(xMLName));
        }
        return xMLList;
    }

    private Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        String str = z ? "apply" : NotificationCompat.CATEGORY_CALL;
        if (!(scriptable2 instanceof XMLList) || ((XMLList) scriptable2).targetProperty == null) {
            throw ScriptRuntime.typeError1("msg.isnt.function", str);
        }
        return ScriptRuntime.applyOrCall(z, context, scriptable, scriptable2, objArr);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    protected Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (objArr.length == 0) {
            return new XMLList(this.lib);
        }
        Object obj = objArr[0];
        return (z || !(obj instanceof XMLList)) ? new XMLList(this.lib, obj) : obj;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XmlObject getXmlObject() {
        if (length() == 1) {
            return getXmlFromAnnotation(0).getXmlObject();
        }
        throw ScriptRuntime.typeError("getXmlObject method works only on lists containing one item");
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (length() == 1) {
            return getXmlFromAnnotation(0);
        }
        return null;
    }

    @Override // org.mozilla.javascript.Function, org.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Scriptable scriptable3;
        XMLObject xMLObject;
        javax.xml.namespace.QName qName = this.targetProperty;
        if (qName == null) {
            throw ScriptRuntime.notFunctionError(this);
        }
        String localPart = qName.getLocalPart();
        boolean equals = localPart.equals("apply");
        if (equals || localPart.equals(NotificationCompat.CATEGORY_CALL)) {
            return applyOrCall(equals, context, scriptable, scriptable2, objArr);
        }
        if (!(scriptable2 instanceof XMLObject)) {
            throw ScriptRuntime.typeError1("msg.incompat.call", localPart);
        }
        Object obj2 = null;
        loop0: while (true) {
            obj = obj2;
            do {
                scriptable3 = scriptable2;
                while ((scriptable2 instanceof XMLObject) && (obj = (xMLObject = (XMLObject) scriptable2).getFunctionProperty(context, localPart)) == Scriptable.NOT_FOUND) {
                    scriptable2 = xMLObject.getExtraMethodSource(context);
                    if (scriptable2 != null) {
                        break;
                    }
                }
            } while (scriptable2 instanceof XMLObject);
            obj2 = ScriptableObject.getProperty(scriptable2, localPart);
        }
        if (!(obj instanceof Callable)) {
            throw ScriptRuntime.notFunctionError(scriptable3, obj, localPart);
        }
        return ((Callable) obj).call(context, scriptable, scriptable3, objArr);
    }

    @Override // org.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        throw ScriptRuntime.typeError1("msg.not.ctor", "XMLList");
    }
}
