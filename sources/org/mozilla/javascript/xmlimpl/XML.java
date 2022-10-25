package org.mozilla.javascript.xmlimpl;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.xml.XMLObject;
import org.mozilla.javascript.xmlimpl.XmlNode;
import org.w3c.dom.Node;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class XML extends XMLObjectImpl {
    static final long serialVersionUID = -630969919086449092L;
    private XmlNode node;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XML";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public final XML getXML() {
        return this;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public int length() {
        return 1;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    Object valueOf() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject, XmlNode xmlNode) {
        super(xMLLibImpl, scriptable, xMLObject);
        initialize(xmlNode);
    }

    void initialize(XmlNode xmlNode) {
        this.node = xmlNode;
        xmlNode.setXml(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceWith(XML xml) {
        if (this.node.parent() != null) {
            this.node.replaceWith(xml.node);
        } else {
            initialize(xml.node);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML makeXmlFromString(XMLName xMLName, String str) {
        try {
            return newTextElementXML(this.node, xMLName.toQname(), str);
        } catch (Exception e) {
            throw ScriptRuntime.typeError(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XmlNode getAnnotation() {
        return this.node;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return i == 0 ? this : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        throw ScriptRuntime.typeError("Assignment to indexed XML is not allowed");
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return isPrototype() ? new Object[0] : new Object[]{0};
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i == 0) {
            remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XmlNode.QName getNodeQname() {
        return this.node.getQname();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML[] getChildren() {
        if (isElement()) {
            XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.TRUE);
            int length = matchingChildren.length;
            XML[] xmlArr = new XML[length];
            for (int i = 0; i < length; i++) {
                xmlArr[i] = toXML(matchingChildren[i]);
            }
            return xmlArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML[] getAttributes() {
        XmlNode[] attributes = this.node.getAttributes();
        int length = attributes.length;
        XML[] xmlArr = new XML[length];
        for (int i = 0; i < length; i++) {
            xmlArr[i] = toXML(attributes[i]);
        }
        return xmlArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLList getPropertyList(XMLName xMLName) {
        return xMLName.getMyValueOn(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void deleteXMLProperty(XMLName xMLName) {
        XMLList propertyList = getPropertyList(xMLName);
        for (int i = 0; i < propertyList.length(); i++) {
            propertyList.item(i).node.deleteMe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void putXMLProperty(XMLName xMLName, Object obj) {
        if (isPrototype()) {
            return;
        }
        xMLName.setMyValueOn(this, obj);
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean hasOwnProperty(XMLName xMLName) {
        if (isPrototype()) {
            if (findPrototypeId(xMLName.localName()) != 0) {
                return true;
            }
        } else if (getPropertyList(xMLName).length() > 0) {
            return true;
        }
        return false;
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    protected Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.instance) {
            objArr = new Object[]{""};
        }
        XML ecmaToXml = ecmaToXml(objArr[0]);
        return z ? ecmaToXml.copy() : ecmaToXml;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (hasSimpleContent()) {
            return ScriptRuntime.toObjectOrNull(context, toString());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeChild(int i) {
        this.node.removeChild(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void normalize() {
        this.node.normalize();
    }

    private XML toXML(XmlNode xmlNode) {
        if (xmlNode.getXml() == null) {
            xmlNode.setXml(newXML(xmlNode));
        }
        return xmlNode.getXml();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAttribute(XMLName xMLName, Object obj) {
        if (!isElement()) {
            throw new IllegalStateException("Can only set attributes on elements.");
        }
        if (xMLName.uri() == null && xMLName.localName().equals("*")) {
            throw ScriptRuntime.typeError("@* assignment not supported.");
        }
        this.node.setAttribute(xMLName.toQname(), ScriptRuntime.toString(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        this.node.deleteMe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public void addMatches(XMLList xMLList, XMLName xMLName) {
        xMLName.addMatches(xMLList, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList elements(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, xMLName.toQname());
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i = 0; i < matchingChildren.length; i++) {
            if (xMLName.matches(toXML(matchingChildren[i]))) {
                newXMLList.addToList(toXML(matchingChildren[i]));
            }
        }
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        XmlNode[] matchingChildren = this.node.getMatchingChildren(XmlNode.Filter.ELEMENT);
        for (int i = 0; i < matchingChildren.length; i++) {
            if (xMLName.matchesElement(matchingChildren[i].getQname())) {
                newXMLList.addToList(toXML(matchingChildren[i]));
            }
        }
        newXMLList.setTargets(this, xMLName.toQname());
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML replace(XMLName xMLName, Object obj) {
        putXMLProperty(xMLName, obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList children() {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, XMLName.formStar().toQname());
        for (XmlNode xmlNode : this.node.getMatchingChildren(XmlNode.Filter.TRUE)) {
            newXMLList.addToList(toXML(xmlNode));
        }
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList child(int i) {
        XMLList newXMLList = newXMLList();
        newXMLList.setTargets(this, null);
        if (i >= 0 && i < this.node.getChildCount()) {
            newXMLList.addToList(getXmlChild(i));
        }
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML getXmlChild(int i) {
        XmlNode child = this.node.getChild(i);
        if (child.getXml() == null) {
            child.setXml(newXML(child));
        }
        return child.getXml();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML getLastXmlChild() {
        int childCount = this.node.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        return getXmlChild(childCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int childIndex() {
        return this.node.getChildIndex();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean contains(Object obj) {
        if (obj instanceof XML) {
            return equivalentXml(obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean equivalentXml(Object obj) {
        if (obj instanceof XML) {
            return this.node.toXmlString(getProcessor()).equals(((XML) obj).node.toXmlString(getProcessor()));
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.length() == 1) {
                return equivalentXml(xMLList.getXML());
            }
            return false;
        } else if (hasSimpleContent()) {
            return toString().equals(ScriptRuntime.toString(obj));
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLObjectImpl copy() {
        return newXML(this.node.copy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasSimpleContent() {
        if (isComment() || isProcessingInstruction()) {
            return false;
        }
        if (isText() || this.node.isAttributeType()) {
            return true;
        }
        return !this.node.hasChildElement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public boolean hasComplexContent() {
        return !hasSimpleContent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: is */
    public boolean m34is(XML xml) {
        return this.node.isSameNode(xml.node);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object nodeKind() {
        return ecmaClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public Object parent() {
        if (this.node.parent() == null) {
            return null;
        }
        return newXML(this.node.parent());
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    boolean propertyIsEnumerable(Object obj) {
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            if (doubleValue == 0.0d && 1.0d / doubleValue > 0.0d) {
                return true;
            }
        } else {
            return ScriptRuntime.toString(obj).equals("0");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList comments() {
        XMLList newXMLList = newXMLList();
        this.node.addMatchingChildren(newXMLList, XmlNode.Filter.COMMENT);
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList text() {
        XMLList newXMLList = newXMLList();
        this.node.addMatchingChildren(newXMLList, XmlNode.Filter.TEXT);
        return newXMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public XMLList processingInstructions(XMLName xMLName) {
        XMLList newXMLList = newXMLList();
        this.node.addMatchingChildren(newXMLList, XmlNode.Filter.PROCESSING_INSTRUCTION(xMLName));
        return newXMLList;
    }

    private XmlNode[] getNodesForInsert(Object obj) {
        if (obj instanceof XML) {
            return new XmlNode[]{((XML) obj).node};
        }
        if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            XmlNode[] xmlNodeArr = new XmlNode[xMLList.length()];
            for (int i = 0; i < xMLList.length(); i++) {
                xmlNodeArr[i] = xMLList.item(i).node;
            }
            return xmlNodeArr;
        }
        return new XmlNode[]{XmlNode.createText(getProcessor(), ScriptRuntime.toString(obj))};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML replace(int i, Object obj) {
        XMLList child = child(i);
        if (child.length() > 0) {
            insertChildAfter(child.item(0), obj);
            removeChild(i);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML prependChild(Object obj) {
        if (this.node.isParentType()) {
            this.node.insertChildrenAt(0, getNodesForInsert(obj));
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML appendChild(Object obj) {
        if (this.node.isParentType()) {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            XmlNode xmlNode = this.node;
            xmlNode.insertChildrenAt(xmlNode.getChildCount(), nodesForInsert);
        }
        return this;
    }

    private int getChildIndexOf(XML xml) {
        for (int i = 0; i < this.node.getChildCount(); i++) {
            if (this.node.getChild(i).isSameNode(xml.node)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML insertChildBefore(XML xml, Object obj) {
        if (xml == null) {
            appendChild(obj);
        } else {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            int childIndexOf = getChildIndexOf(xml);
            if (childIndexOf != -1) {
                this.node.insertChildrenAt(childIndexOf, nodesForInsert);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML insertChildAfter(XML xml, Object obj) {
        if (xml == null) {
            prependChild(obj);
        } else {
            XmlNode[] nodesForInsert = getNodesForInsert(obj);
            int childIndexOf = getChildIndexOf(xml);
            if (childIndexOf != -1) {
                this.node.insertChildrenAt(childIndexOf + 1, nodesForInsert);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML setChildren(Object obj) {
        if (isElement()) {
            while (this.node.getChildCount() > 0) {
                this.node.removeChild(0);
            }
            this.node.insertChildrenAt(0, getNodesForInsert(obj));
            return this;
        }
        return this;
    }

    private void addInScopeNamespace(Namespace namespace) {
        if (isElement() && namespace.prefix() != null) {
            if (namespace.prefix().length() == 0 && namespace.uri().length() == 0) {
                return;
            }
            if (this.node.getQname().getNamespace().getPrefix().equals(namespace.prefix())) {
                this.node.invalidateNamespacePrefix();
            }
            this.node.declareNamespace(namespace.prefix(), namespace.uri());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace[] inScopeNamespaces() {
        return createNamespaces(this.node.getInScopeNamespaces());
    }

    private XmlNode.Namespace adapt(Namespace namespace) {
        if (namespace.prefix() == null) {
            return XmlNode.Namespace.create(namespace.uri());
        }
        return XmlNode.Namespace.create(namespace.prefix(), namespace.uri());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML removeNamespace(Namespace namespace) {
        if (isElement()) {
            this.node.removeNamespace(adapt(namespace));
            return this;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML addNamespace(Namespace namespace) {
        addInScopeNamespace(namespace);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QName name() {
        if (isText() || isComment()) {
            return null;
        }
        return isProcessingInstruction() ? newQName("", this.node.getQname().getLocalName(), null) : newQName(this.node.getQname());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace[] namespaceDeclarations() {
        return createNamespaces(this.node.getNamespaceDeclarations());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Namespace namespace(String str) {
        if (str == null) {
            return createNamespace(this.node.getNamespaceDeclaration());
        }
        return createNamespace(this.node.getNamespaceDeclaration(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String localName() {
        if (name() == null) {
            return null;
        }
        return name().localName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLocalName(String str) {
        if (isText() || isComment()) {
            return;
        }
        this.node.setLocalName(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(QName qName) {
        if (isText() || isComment()) {
            return;
        }
        if (isProcessingInstruction()) {
            this.node.setLocalName(qName.localName());
        } else {
            this.node.renameNode(qName.getDelegate());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNamespace(Namespace namespace) {
        if (isText() || isComment() || isProcessingInstruction()) {
            return;
        }
        setName(newQName(namespace.uri(), localName(), namespace.prefix()));
    }

    final String ecmaClass() {
        if (this.node.isTextType()) {
            return "text";
        }
        if (this.node.isAttributeType()) {
            return "attribute";
        }
        if (this.node.isCommentType()) {
            return "comment";
        }
        if (this.node.isProcessingInstructionType()) {
            return "processing-instruction";
        }
        if (this.node.isElementType()) {
            return "element";
        }
        throw new RuntimeException("Unrecognized type: " + this.node);
    }

    private String ecmaValue() {
        return this.node.ecmaValue();
    }

    private String ecmaToString() {
        if (isAttribute() || isText()) {
            return ecmaValue();
        }
        if (hasSimpleContent()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.node.getChildCount(); i++) {
                XmlNode child = this.node.getChild(i);
                if (!child.isProcessingInstructionType() && !child.isCommentType()) {
                    stringBuffer.append(new XML(getLib(), getParentScope(), (XMLObject) getPrototype(), child).toString());
                }
            }
            return stringBuffer.toString();
        }
        return toXMLString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toString() {
        return ecmaToString();
    }

    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    String toSource(int i) {
        return toXMLString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xmlimpl.XMLObjectImpl
    public String toXMLString() {
        return this.node.ecmaToXMLString(getProcessor());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isAttribute() {
        return this.node.isAttributeType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isComment() {
        return this.node.isCommentType();
    }

    final boolean isText() {
        return this.node.isTextType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isElement() {
        return this.node.isElementType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isProcessingInstruction() {
        return this.node.isProcessingInstructionType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node toDomNode() {
        return this.node.toDomNode();
    }
}
