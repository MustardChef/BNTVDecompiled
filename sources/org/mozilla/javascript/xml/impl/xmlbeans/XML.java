package org.mozilla.javascript.xml.impl.xmlbeans;

import java.io.Serializable;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.Wrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class XML extends XMLObjectImpl {
    private static final int APPEND_CHILD = 1;
    private static final int PREPEND_CHILD = 2;
    static final long serialVersionUID = -630969919086449092L;
    private XScriptAnnotation _anno;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "XML";
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i == 0;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    int length() {
        return 1;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object valueOf() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class XScriptAnnotation extends XmlCursor.XmlBookmark implements Serializable {
        private static final long serialVersionUID = 1;
        javax.xml.namespace.QName _name;
        XML _xScriptXML;

        XScriptAnnotation(XmlCursor xmlCursor) {
            this._name = xmlCursor.getName();
        }
    }

    /* loaded from: classes5.dex */
    static final class NamespaceDeclarations {
        private String _defaultNSURI;
        private int _prefixIdx = 0;
        private StringBuffer _namespaceDecls = new StringBuffer();

        NamespaceDeclarations(XmlCursor xmlCursor) {
            XML.skipNonElements(xmlCursor);
            this._defaultNSURI = xmlCursor.namespaceForPrefix("");
            if (isAnyDefaultNamespace()) {
                addDecl("", this._defaultNSURI);
            }
        }

        private void addDecl(String str, String str2) {
            String str3;
            StringBuffer stringBuffer = this._namespaceDecls;
            StringBuilder sb = new StringBuilder();
            if (str.length() > 0) {
                str3 = "declare namespace " + str;
            } else {
                str3 = "default element namespace";
            }
            sb.append(str3);
            sb.append(" = \"");
            sb.append(str2);
            sb.append("\"");
            sb.append("\n");
            stringBuffer.append(sb.toString());
        }

        String getNextPrefix(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("NS");
            int i = this._prefixIdx;
            this._prefixIdx = i + 1;
            sb.append(i);
            String sb2 = sb.toString();
            StringBuffer stringBuffer = this._namespaceDecls;
            stringBuffer.append("declare namespace " + sb2 + " = \"" + str + "\"\n");
            return sb2;
        }

        boolean isAnyDefaultNamespace() {
            String str = this._defaultNSURI;
            return str != null && str.length() > 0;
        }

        String getDeclarations() {
            return this._namespaceDecls.toString();
        }
    }

    private XML(XMLLibImpl xMLLibImpl, XScriptAnnotation xScriptAnnotation) {
        super(xMLLibImpl, xMLLibImpl.xmlPrototype);
        this._anno = xScriptAnnotation;
        xScriptAnnotation._xScriptXML = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XML createEmptyXML(XMLLibImpl xMLLibImpl) {
        XmlCursor newCursor = XmlObject.Factory.newInstance().newCursor();
        try {
            XScriptAnnotation xScriptAnnotation = new XScriptAnnotation(newCursor);
            newCursor.setBookmark(xScriptAnnotation);
            newCursor.dispose();
            return new XML(xMLLibImpl, xScriptAnnotation);
        } catch (Throwable th) {
            newCursor.dispose();
            throw th;
        }
    }

    private static XML createXML(XMLLibImpl xMLLibImpl, XmlCursor xmlCursor) {
        if (xmlCursor.currentTokenType().isStartdoc()) {
            xmlCursor.toFirstContentToken();
        }
        return new XML(xMLLibImpl, findAnnotation(xmlCursor));
    }

    private static XML createAttributeXML(XMLLibImpl xMLLibImpl, XmlCursor xmlCursor) {
        if (!xmlCursor.isAttr()) {
            throw new IllegalArgumentException();
        }
        XScriptAnnotation xScriptAnnotation = new XScriptAnnotation(xmlCursor);
        xmlCursor.setBookmark(xScriptAnnotation);
        return new XML(xMLLibImpl, xScriptAnnotation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XML createTextElement(XMLLibImpl xMLLibImpl, javax.xml.namespace.QName qName, String str) {
        XmlCursor newCursor = XmlObject.Factory.newInstance().newCursor();
        try {
            newCursor.toNextToken();
            newCursor.beginElement(qName.getLocalPart(), qName.getNamespaceURI());
            newCursor.insertChars(str);
            newCursor.toStartDoc();
            newCursor.toNextToken();
            XScriptAnnotation xScriptAnnotation = new XScriptAnnotation(newCursor);
            newCursor.setBookmark(xScriptAnnotation);
            newCursor.dispose();
            return new XML(xMLLibImpl, xScriptAnnotation);
        } catch (Throwable th) {
            newCursor.dispose();
            throw th;
        }
    }

    static XML createFromXmlObject(XMLLibImpl xMLLibImpl, XmlObject xmlObject) {
        XmlCursor newCursor = xmlObject.newCursor();
        if (newCursor.currentTokenType().isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        try {
            XScriptAnnotation xScriptAnnotation = new XScriptAnnotation(newCursor);
            newCursor.setBookmark(xScriptAnnotation);
            newCursor.dispose();
            return new XML(xMLLibImpl, xScriptAnnotation);
        } catch (Throwable th) {
            newCursor.dispose();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XML createFromJS(XMLLibImpl xMLLibImpl, Object obj) {
        String str;
        boolean z;
        XmlObject newInstance;
        XmlCursor newCursor;
        boolean z2;
        if (obj == null || obj == Undefined.instance) {
            str = "";
        } else if (obj instanceof XMLObjectImpl) {
            str = ((XMLObjectImpl) obj).toXMLString(0);
        } else {
            if (obj instanceof Wrapper) {
                Object unwrap = ((Wrapper) obj).unwrap();
                if (unwrap instanceof XmlObject) {
                    return createFromXmlObject(xMLLibImpl, (XmlObject) unwrap);
                }
            }
            str = ScriptRuntime.toString(obj);
        }
        if (str.trim().startsWith("<>")) {
            throw ScriptRuntime.typeError("Invalid use of XML object anonymous tags <></>.");
        }
        if (str.indexOf("<") == -1) {
            str = "<textFragment>" + str + "</textFragment>";
            z = true;
        } else {
            z = false;
        }
        XmlOptions xmlOptions = new XmlOptions();
        if (xMLLibImpl.ignoreComments) {
            xmlOptions.put("LOAD_STRIP_COMMENTS");
        }
        if (xMLLibImpl.ignoreProcessingInstructions) {
            xmlOptions.put("LOAD_STRIP_PROCINSTS");
        }
        if (xMLLibImpl.ignoreWhitespace) {
            xmlOptions.put("LOAD_STRIP_WHITESPACE");
        }
        try {
            newInstance = XmlObject.Factory.parse(str, xmlOptions);
            String defaultNamespaceURI = xMLLibImpl.getDefaultNamespaceURI(Context.getCurrentContext());
            if (defaultNamespaceURI.length() > 0) {
                newCursor = newInstance.newCursor();
                boolean z3 = true;
                while (!newCursor.toNextToken().isEnddoc()) {
                    if (newCursor.isStart()) {
                        newCursor.push();
                        while (true) {
                            if (!newCursor.toNextToken().isAnyAttr()) {
                                z2 = false;
                                break;
                            } else if (newCursor.isNamespace() && newCursor.getName().getLocalPart().length() == 0) {
                                z2 = true;
                                break;
                            }
                        }
                        newCursor.pop();
                        if (z2) {
                            newCursor.toEndToken();
                        } else {
                            javax.xml.namespace.QName name = newCursor.getName();
                            if (name.getNamespaceURI().length() == 0) {
                                newCursor.setName(new javax.xml.namespace.QName(defaultNamespaceURI, name.getLocalPart()));
                            }
                            if (z3) {
                                newCursor.push();
                                newCursor.toNextToken();
                                newCursor.insertNamespace("", defaultNamespaceURI);
                                newCursor.pop();
                                z3 = false;
                            }
                        }
                    }
                }
            }
        } catch (XmlException e) {
            if (e.getMessage().equals("error: Unexpected end of file after null")) {
                newInstance = XmlObject.Factory.newInstance();
            } else {
                throw ScriptRuntime.typeError(e.getMessage());
            }
        }
        newCursor = newInstance.newCursor();
        if (newCursor.currentTokenType().isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        if (z) {
            newCursor.toFirstContentToken();
        }
        try {
            XScriptAnnotation xScriptAnnotation = new XScriptAnnotation(newCursor);
            newCursor.setBookmark(xScriptAnnotation);
            newCursor.dispose();
            return new XML(xMLLibImpl, xScriptAnnotation);
        } finally {
            newCursor.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static XML getFromAnnotation(XMLLibImpl xMLLibImpl, XScriptAnnotation xScriptAnnotation) {
        if (xScriptAnnotation._xScriptXML == null) {
            xScriptAnnotation._xScriptXML = new XML(xMLLibImpl, xScriptAnnotation);
        }
        return xScriptAnnotation._xScriptXML;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static XmlCursor.TokenType skipNonElements(XmlCursor xmlCursor) {
        XmlCursor.TokenType currentTokenType = xmlCursor.currentTokenType();
        while (true) {
            if (!currentTokenType.isComment() && !currentTokenType.isProcinst()) {
                return currentTokenType;
            }
            currentTokenType = xmlCursor.toNextToken();
        }
    }

    protected static XScriptAnnotation findAnnotation(XmlCursor xmlCursor) {
        XmlCursor.XmlBookmark bookmark = xmlCursor.getBookmark(XScriptAnnotation.class);
        if (bookmark == null) {
            bookmark = new XScriptAnnotation(xmlCursor);
            xmlCursor.setBookmark(bookmark);
        }
        return (XScriptAnnotation) bookmark;
    }

    private XmlOptions getOptions() {
        XmlOptions xmlOptions = new XmlOptions();
        if (this.lib.ignoreComments) {
            xmlOptions.put("LOAD_STRIP_COMMENTS");
        }
        if (this.lib.ignoreProcessingInstructions) {
            xmlOptions.put("LOAD_STRIP_PROCINSTS");
        }
        if (this.lib.ignoreWhitespace) {
            xmlOptions.put("LOAD_STRIP_WHITESPACE");
        }
        if (this.lib.prettyPrinting) {
            xmlOptions.put("SAVE_PRETTY_PRINT", (Object) null);
            xmlOptions.put("SAVE_PRETTY_PRINT_INDENT", new Integer(this.lib.prettyIndent));
        }
        return xmlOptions;
    }

    private static String dumpNode(XmlCursor xmlCursor, XmlOptions xmlOptions) {
        if (xmlCursor.isText()) {
            return xmlCursor.getChars();
        }
        if (xmlCursor.isFinish()) {
            return "";
        }
        xmlCursor.push();
        boolean z = xmlCursor.isStartdoc() && !xmlCursor.toFirstChild();
        xmlCursor.pop();
        return z ? xmlCursor.getTextValue() : xmlCursor.xmlText(xmlOptions);
    }

    private XmlCursor newCursor() {
        XScriptAnnotation xScriptAnnotation = this._anno;
        if (xScriptAnnotation != null) {
            XmlCursor createCursor = xScriptAnnotation.createCursor();
            if (createCursor == null) {
                XmlCursor newCursor = XmlObject.Factory.newInstance().newCursor();
                if (this._anno._name != null) {
                    newCursor.toNextToken();
                    newCursor.insertElement(this._anno._name);
                    newCursor.toPrevSibling();
                }
                newCursor.setBookmark(this._anno);
                return newCursor;
            }
            return createCursor;
        }
        return XmlObject.Factory.newInstance().newCursor();
    }

    private boolean moveToChild(XmlCursor xmlCursor, long j, boolean z, boolean z2) {
        long j2 = 0;
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (!z2 && xmlCursor.currentTokenType().isStartdoc()) {
            xmlCursor.toFirstContentToken();
        }
        XmlCursor.TokenType firstContentToken = xmlCursor.toFirstContentToken();
        if (firstContentToken.isNone() || firstContentToken.isEnd()) {
            return z && i == 0;
        }
        while (j != j2) {
            XmlCursor.TokenType currentTokenType = xmlCursor.currentTokenType();
            if (currentTokenType.isText()) {
                xmlCursor.toNextToken();
            } else if (currentTokenType.isStart()) {
                xmlCursor.toEndToken();
                xmlCursor.toNextToken();
            } else if (!currentTokenType.isComment() && !currentTokenType.isProcinst()) {
                return false;
            }
            j2++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XmlCursor.TokenType tokenType() {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        newCursor.dispose();
        return currentTokenType;
    }

    private boolean moveSrcToDest(XmlCursor xmlCursor, XmlCursor xmlCursor2, boolean z) {
        XmlCursor.TokenType currentTokenType;
        do {
            if (z && xmlCursor.isInSameDocument(xmlCursor2) && xmlCursor.comparePosition(xmlCursor2) == 0) {
                return false;
            }
            if (xmlCursor2.currentTokenType().isStartdoc()) {
                xmlCursor2.toNextToken();
            }
            XmlCursor copy = copy(xmlCursor);
            copy.moveXml(xmlCursor2);
            copy.dispose();
            currentTokenType = xmlCursor.currentTokenType();
            if (currentTokenType.isStart() || currentTokenType.isEnd()) {
                break;
            }
        } while (!currentTokenType.isEnddoc());
        return true;
    }

    private XmlCursor copy(XmlCursor xmlCursor) {
        XmlCursor newCursor;
        XmlObject newInstance = XmlObject.Factory.newInstance();
        if (xmlCursor.currentTokenType().isText()) {
            try {
                newCursor = XmlObject.Factory.parse("<x:fragment xmlns:x=\"http://www.openuri.org/fragment\">" + xmlCursor.getChars() + "</x:fragment>").newCursor();
                if (!xmlCursor.toNextSibling() && xmlCursor.currentTokenType().isText()) {
                    xmlCursor.toNextToken();
                }
            } catch (Exception e) {
                throw ScriptRuntime.typeError(e.getMessage());
            }
        } else {
            newCursor = newInstance.newCursor();
            newCursor.toFirstContentToken();
            if (xmlCursor.currentTokenType() == XmlCursor.TokenType.STARTDOC) {
                xmlCursor.toNextToken();
            }
            xmlCursor.copyXml(newCursor);
            if (!xmlCursor.toNextSibling() && xmlCursor.currentTokenType().isText()) {
                xmlCursor.toNextToken();
            }
        }
        newCursor.toStartDoc();
        newCursor.toFirstContentToken();
        return newCursor;
    }

    private void insertChild(XmlCursor xmlCursor, Object obj) {
        if (obj == null || (obj instanceof Undefined)) {
            return;
        }
        if (obj instanceof XmlCursor) {
            moveSrcToDest((XmlCursor) obj, xmlCursor, true);
        } else if (obj instanceof XML) {
            XML xml = (XML) obj;
            if (xml.tokenType() == XmlCursor.TokenType.ATTR) {
                insertChild(xmlCursor, xml.toString());
                return;
            }
            XmlCursor newCursor = xml.newCursor();
            moveSrcToDest(newCursor, xmlCursor, true);
            newCursor.dispose();
        } else if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            for (int i = 0; i < xMLList.length(); i++) {
                insertChild(xmlCursor, xMLList.item(i));
            }
        } else {
            String scriptRuntime = ScriptRuntime.toString(obj);
            XmlCursor newCursor2 = XmlObject.Factory.newInstance().newCursor();
            newCursor2.toNextToken();
            newCursor2.insertChars(scriptRuntime);
            newCursor2.toPrevToken();
            moveSrcToDest(newCursor2, xmlCursor, true);
        }
    }

    private void insertChild(XML xml, Object obj, int i) {
        XmlCursor newCursor = newCursor();
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        XmlCursor newCursor2 = xml.newCursor();
        if (currentTokenType.isStartdoc()) {
            currentTokenType = newCursor.toFirstContentToken();
        }
        if (currentTokenType.isContainer()) {
            XmlCursor.TokenType nextToken = newCursor.toNextToken();
            while (true) {
                if (nextToken.isEnd()) {
                    break;
                } else if (nextToken.isStart() && newCursor.comparePosition(newCursor2) == 0) {
                    if (i == 1) {
                        newCursor.toEndToken();
                        newCursor.toNextToken();
                    }
                    insertChild(newCursor, obj);
                } else {
                    if (nextToken.isStart()) {
                        newCursor.toEndToken();
                    }
                    nextToken = newCursor.toNextToken();
                }
            }
        }
        newCursor2.dispose();
        newCursor.dispose();
    }

    protected void removeToken(XmlCursor xmlCursor) {
        XmlCursor newCursor = XmlObject.Factory.newInstance().newCursor();
        newCursor.toFirstContentToken();
        xmlCursor.moveXml(newCursor);
        newCursor.dispose();
    }

    protected void removeChild(long j) {
        XmlCursor newCursor = newCursor();
        if (moveToChild(newCursor, j, false, false)) {
            removeToken(newCursor);
        }
        newCursor.dispose();
    }

    protected static javax.xml.namespace.QName computeQName(Object obj) {
        int indexOf;
        String str = null;
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.startsWith("\"") && (indexOf = str2.indexOf(":")) != -1) {
                str = str2.substring(1, indexOf - 1);
                str2 = str2.substring(indexOf + 1);
            }
            if (str == null) {
                return new javax.xml.namespace.QName(str2);
            }
            return new javax.xml.namespace.QName(str, str2);
        }
        return null;
    }

    private void replace(XmlCursor xmlCursor, XML xml) {
        if (xmlCursor.isStartdoc()) {
            xmlCursor.toFirstContentToken();
        }
        removeToken(xmlCursor);
        XmlCursor newCursor = xml.newCursor();
        if (newCursor.currentTokenType().isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        moveSrcToDest(newCursor, xmlCursor, false);
        if (!xmlCursor.toPrevSibling()) {
            xmlCursor.toPrevToken();
        }
        xmlCursor.setBookmark(new XScriptAnnotation(xmlCursor));
        xmlCursor.toEndToken();
        xmlCursor.toNextToken();
        newCursor.dispose();
    }

    private boolean doPut(XMLName xMLName, XML xml, XMLObjectImpl xMLObjectImpl) {
        XML xml2;
        XmlCursor newCursor = xml.newCursor();
        try {
            try {
                int length = xMLObjectImpl.length();
                for (int i = 0; i < length; i++) {
                    if (xMLObjectImpl instanceof XMLList) {
                        xml2 = ((XMLList) xMLObjectImpl).item(i);
                    } else {
                        xml2 = (XML) xMLObjectImpl;
                    }
                    XmlCursor.TokenType tokenType = xml2.tokenType();
                    if (tokenType == XmlCursor.TokenType.ATTR || tokenType == XmlCursor.TokenType.TEXT) {
                        xml2 = makeXmlFromString(this.lib, xMLName, xml2.toString());
                    }
                    if (i == 0) {
                        replace(newCursor, xml2);
                    } else {
                        insertChild(newCursor, xml2);
                    }
                }
                newCursor.dispose();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                throw ScriptRuntime.typeError(e.getMessage());
            }
        } catch (Throwable th) {
            newCursor.dispose();
            throw th;
        }
    }

    private XML makeXmlFromString(XMLLibImpl xMLLibImpl, XMLName xMLName, String str) {
        try {
            return createTextElement(xMLLibImpl, new javax.xml.namespace.QName(xMLName.uri(), xMLName.localName()), str);
        } catch (Exception e) {
            throw ScriptRuntime.typeError(e.getMessage());
        }
    }

    private XMLList matchAttributes(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        XmlCursor newCursor = newCursor();
        if (newCursor.currentTokenType().isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        if (newCursor.isStart() && newCursor.toFirstAttribute()) {
            do {
                if (qnameMatches(xMLName, newCursor.getName())) {
                    xMLList.addToList(createAttributeObject(newCursor));
                }
            } while (newCursor.toNextAttribute());
            newCursor.dispose();
            return xMLList;
        }
        newCursor.dispose();
        return xMLList;
    }

    private XML createAttributeObject(XmlCursor xmlCursor) {
        if (xmlCursor.currentTokenType().isAttr()) {
            return createAttributeXML(this.lib, xmlCursor);
        }
        return null;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return i == 0 ? this : Scriptable.NOT_FOUND;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean hasXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName).length() > 0;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this.prototypeFlag ? new Object[0] : new Object[]{new Integer(0)};
    }

    public Object[] getIdsForDebug() {
        return getIds();
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    Object getXMLProperty(XMLName xMLName) {
        return getPropertyList(xMLName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public void putXMLProperty(XMLName xMLName, Object obj) {
        XMLObjectImpl makeXmlFromString;
        if (this.prototypeFlag) {
            return;
        }
        if (obj == null) {
            obj = "null";
        } else if (obj instanceof Undefined) {
            obj = "undefined";
        }
        if (xMLName.isAttributeName()) {
            setAttribute(xMLName, obj);
        } else if (xMLName.uri() == null && xMLName.localName().equals("*")) {
            setChildren(obj);
        } else {
            if (obj instanceof XMLObjectImpl) {
                makeXmlFromString = (XMLObjectImpl) obj;
                if ((makeXmlFromString instanceof XML) && ((XML) makeXmlFromString).tokenType() == XmlCursor.TokenType.ATTR) {
                    makeXmlFromString = makeXmlFromString(this.lib, xMLName, makeXmlFromString.toString());
                }
                if (makeXmlFromString instanceof XMLList) {
                    for (int i = 0; i < makeXmlFromString.length(); i++) {
                        XMLList xMLList = (XMLList) makeXmlFromString;
                        XML item = xMLList.item(i);
                        if (item.tokenType() == XmlCursor.TokenType.ATTR) {
                            xMLList.replace(i, makeXmlFromString(this.lib, xMLName, item.toString()));
                        }
                    }
                }
            } else {
                makeXmlFromString = makeXmlFromString(this.lib, xMLName, ScriptRuntime.toString(obj));
            }
            XMLList propertyList = getPropertyList(xMLName);
            if (propertyList.length() == 0) {
                appendChild(makeXmlFromString);
                return;
            }
            for (int i2 = 1; i2 < propertyList.length(); i2++) {
                removeChild(propertyList.item(i2).childIndex());
            }
            doPut(xMLName, propertyList.item(0), makeXmlFromString);
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        throw ScriptRuntime.typeError("Assignment to indexed XML is not allowed");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public void deleteXMLProperty(XMLName xMLName) {
        if (!xMLName.isDescendants() && xMLName.isAttributeName()) {
            XmlCursor newCursor = newCursor();
            if (xMLName.localName().equals("*")) {
                if (newCursor.toFirstAttribute()) {
                    while (newCursor.currentTokenType().isAttr()) {
                        newCursor.removeXml();
                    }
                }
            } else {
                newCursor.removeAttribute(new javax.xml.namespace.QName(xMLName.uri(), xMLName.localName()));
            }
            newCursor.dispose();
            return;
        }
        getPropertyList(xMLName).remove();
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public void delete(int i) {
        if (i == 0) {
            remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public XScriptAnnotation getAnnotation() {
        return this._anno;
    }

    protected void changeNS(String str, String str2) {
        XmlCursor newCursor = newCursor();
        do {
        } while (newCursor.toParent());
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        if (currentTokenType.isStartdoc()) {
            currentTokenType = newCursor.toFirstContentToken();
        }
        if (currentTokenType.isStart()) {
            do {
                if (currentTokenType.isStart() || currentTokenType.isAttr() || currentTokenType.isNamespace()) {
                    javax.xml.namespace.QName name = newCursor.getName();
                    if (str.equals(name.getNamespaceURI())) {
                        newCursor.setName(new javax.xml.namespace.QName(str2, name.getLocalPart()));
                    }
                }
                currentTokenType = newCursor.toNextToken();
                if (currentTokenType.isEnddoc()) {
                    break;
                }
            } while (!currentTokenType.isNone());
        }
        newCursor.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        XmlCursor newCursor = newCursor();
        if (newCursor.currentTokenType().isStartdoc()) {
            for (XmlCursor.TokenType firstContentToken = newCursor.toFirstContentToken(); !firstContentToken.isEnd() && !firstContentToken.isEnddoc(); firstContentToken = newCursor.currentTokenType()) {
                removeToken(newCursor);
            }
        } else {
            removeToken(newCursor);
        }
        newCursor.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void replaceAll(XML xml) {
        XmlCursor newCursor = newCursor();
        replace(newCursor, xml);
        this._anno = xml._anno;
        newCursor.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAttribute(XMLName xMLName, Object obj) {
        if (xMLName.uri() == null && xMLName.localName().equals("*")) {
            throw ScriptRuntime.typeError("@* assignment not supported.");
        }
        XmlCursor newCursor = newCursor();
        String scriptRuntime = ScriptRuntime.toString(obj);
        if (newCursor.currentTokenType().isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        try {
            javax.xml.namespace.QName qName = new javax.xml.namespace.QName(xMLName.uri(), xMLName.localName());
            if (!newCursor.setAttributeText(qName, scriptRuntime)) {
                if (newCursor.currentTokenType().isStart()) {
                    newCursor.toNextToken();
                }
                newCursor.insertAttributeWithValue(qName, scriptRuntime);
            }
            newCursor.dispose();
        } catch (Exception e) {
            throw ScriptRuntime.typeError(e.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0084, code lost:
        if (r3.getLocalPart().equals(r1.getName().getLocalPart()) == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.xml.impl.xmlbeans.XMLList allChildNodes(java.lang.String r9) {
        /*
            r8 = this;
            org.mozilla.javascript.xml.impl.xmlbeans.XMLList r0 = new org.mozilla.javascript.xml.impl.xmlbeans.XMLList
            org.mozilla.javascript.xml.impl.xmlbeans.XMLLibImpl r1 = r8.lib
            r0.<init>(r1)
            org.apache.xmlbeans.XmlCursor r1 = r8.newCursor()
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.currentTokenType()
            javax.xml.namespace.QName r3 = new javax.xml.namespace.QName
            java.lang.String r4 = "*"
            r3.<init>(r9, r4)
            boolean r5 = r2.isStartdoc()
            if (r5 == 0) goto L20
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.toFirstContentToken()
        L20:
            boolean r2 = r2.isContainer()
            if (r2 == 0) goto L95
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.toFirstContentToken()
        L2a:
            boolean r5 = r2.isEnd()
            if (r5 != 0) goto L95
            boolean r5 = r2.isStart()
            r6 = 0
            if (r5 != 0) goto L40
            org.mozilla.javascript.xml.impl.xmlbeans.XML$XScriptAnnotation r3 = findAnnotation(r1)
            r0.addToList(r3)
        L3e:
            r3 = r6
            goto L87
        L40:
            if (r9 == 0) goto L5c
            int r5 = r9.length()
            if (r5 == 0) goto L5c
            boolean r5 = r9.equals(r4)
            if (r5 != 0) goto L5c
            javax.xml.namespace.QName r5 = r1.getName()
            java.lang.String r5 = r5.getNamespaceURI()
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L87
        L5c:
            org.mozilla.javascript.xml.impl.xmlbeans.XML$XScriptAnnotation r5 = findAnnotation(r1)
            r0.addToList(r5)
            if (r3 == 0) goto L87
            java.lang.String r5 = r3.getLocalPart()
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L74
            javax.xml.namespace.QName r3 = r1.getName()
            goto L87
        L74:
            java.lang.String r5 = r3.getLocalPart()
            javax.xml.namespace.QName r7 = r1.getName()
            java.lang.String r7 = r7.getLocalPart()
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L87
            goto L3e
        L87:
            boolean r2 = r2.isStart()
            if (r2 == 0) goto L90
            r1.toEndToken()
        L90:
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.toNextToken()
            goto L2a
        L95:
            r1.dispose()
            r0.setTargets(r8, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.xml.impl.xmlbeans.XML.allChildNodes(java.lang.String):org.mozilla.javascript.xml.impl.xmlbeans.XMLList");
    }

    private XMLList matchDescendantAttributes(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        XmlCursor newCursor = newCursor();
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        xMLList.setTargets(this, null);
        if (currentTokenType.isStartdoc()) {
            currentTokenType = newCursor.toFirstContentToken();
        }
        if (currentTokenType.isContainer()) {
            int i = 1;
            while (i > 0) {
                XmlCursor.TokenType nextToken = newCursor.toNextToken();
                if (nextToken.isAttr() && qnameMatches(xMLName, newCursor.getName())) {
                    xMLList.addToList(findAnnotation(newCursor));
                }
                if (nextToken.isStart()) {
                    i++;
                } else if (nextToken.isEnd()) {
                    i--;
                } else if (nextToken.isEnddoc()) {
                    break;
                }
            }
        }
        newCursor.dispose();
        return xMLList;
    }

    private XMLList matchDescendantChildren(XMLName xMLName) {
        XMLList xMLList = new XMLList(this.lib);
        XmlCursor newCursor = newCursor();
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        xMLList.setTargets(this, null);
        if (currentTokenType.isStartdoc()) {
            currentTokenType = newCursor.toFirstContentToken();
        }
        if (currentTokenType.isContainer()) {
            int i = 1;
            while (i > 0) {
                XmlCursor.TokenType nextToken = newCursor.toNextToken();
                if (!nextToken.isAttr() && !nextToken.isEnd() && !nextToken.isEnddoc()) {
                    if (!nextToken.isStart() && !nextToken.isProcinst()) {
                        if (xMLName.localName().equals("*")) {
                            xMLList.addToList(findAnnotation(newCursor));
                        }
                    } else if (qnameMatches(xMLName, newCursor.getName())) {
                        xMLList.addToList(findAnnotation(newCursor));
                    }
                }
                if (nextToken.isStart()) {
                    i++;
                } else if (nextToken.isEnd()) {
                    i--;
                } else if (nextToken.isEnddoc()) {
                    break;
                }
            }
        }
        newCursor.dispose();
        return xMLList;
    }

    private XMLList matchChildren(XmlCursor.TokenType tokenType) {
        return matchChildren(tokenType, XMLName.formStar());
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
        if (r3.getLocalPart().equals(r1.getName().getLocalPart()) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.xml.impl.xmlbeans.XMLList matchChildren(org.apache.xmlbeans.XmlCursor.TokenType r8, org.mozilla.javascript.xml.impl.xmlbeans.XMLName r9) {
        /*
            r7 = this;
            org.mozilla.javascript.xml.impl.xmlbeans.XMLList r0 = new org.mozilla.javascript.xml.impl.xmlbeans.XMLList
            org.mozilla.javascript.xml.impl.xmlbeans.XMLLibImpl r1 = r7.lib
            r0.<init>(r1)
            org.apache.xmlbeans.XmlCursor r1 = r7.newCursor()
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.currentTokenType()
            javax.xml.namespace.QName r3 = new javax.xml.namespace.QName
            java.lang.String r4 = r9.uri()
            java.lang.String r5 = r9.localName()
            r3.<init>(r4, r5)
            boolean r4 = r2.isStartdoc()
            if (r4 == 0) goto L26
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.toFirstContentToken()
        L26:
            boolean r2 = r2.isContainer()
            if (r2 == 0) goto L93
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.toFirstContentToken()
        L30:
            boolean r4 = r2.isEnd()
            if (r4 != 0) goto L93
            r4 = 0
            if (r2 != r8) goto L85
            boolean r5 = r2.isStart()
            if (r5 != 0) goto L4e
            boolean r5 = r2.isProcinst()
            if (r5 != 0) goto L4e
            org.mozilla.javascript.xml.impl.xmlbeans.XML$XScriptAnnotation r3 = findAnnotation(r1)
            r0.addToList(r3)
        L4c:
            r3 = r4
            goto L85
        L4e:
            javax.xml.namespace.QName r5 = r1.getName()
            boolean r5 = r7.qnameMatches(r9, r5)
            if (r5 == 0) goto L85
            org.mozilla.javascript.xml.impl.xmlbeans.XML$XScriptAnnotation r5 = findAnnotation(r1)
            r0.addToList(r5)
            if (r3 == 0) goto L85
            java.lang.String r5 = r3.getLocalPart()
            java.lang.String r6 = "*"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L72
            javax.xml.namespace.QName r3 = r1.getName()
            goto L85
        L72:
            java.lang.String r5 = r3.getLocalPart()
            javax.xml.namespace.QName r6 = r1.getName()
            java.lang.String r6 = r6.getLocalPart()
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L85
            goto L4c
        L85:
            boolean r2 = r2.isStart()
            if (r2 == 0) goto L8e
            r1.toEndToken()
        L8e:
            org.apache.xmlbeans.XmlCursor$TokenType r2 = r1.toNextToken()
            goto L30
        L93:
            r1.dispose()
            org.apache.xmlbeans.XmlCursor$TokenType r9 = org.apache.xmlbeans.XmlCursor.TokenType.START
            if (r8 != r9) goto L9d
            r0.setTargets(r7, r3)
        L9d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.xml.impl.xmlbeans.XML.matchChildren(org.apache.xmlbeans.XmlCursor$TokenType, org.mozilla.javascript.xml.impl.xmlbeans.XMLName):org.mozilla.javascript.xml.impl.xmlbeans.XMLList");
    }

    private boolean qnameMatches(XMLName xMLName, javax.xml.namespace.QName qName) {
        return (xMLName.uri() == null || xMLName.uri().equals(qName.getNamespaceURI())) && (xMLName.localName().equals("*") || xMLName.localName().equals(qName.getLocalPart()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML addNamespace(Namespace namespace) {
        String prefix = namespace.prefix();
        if (prefix == null) {
            return this;
        }
        XmlCursor newCursor = newCursor();
        try {
            if (newCursor.isContainer()) {
                if (newCursor.getName().getNamespaceURI().equals("") && prefix.equals("")) {
                    return this;
                }
                String str = (String) NamespaceHelper.getAllNamespaces(this.lib, newCursor).get(prefix);
                if (str != null) {
                    if (str.equals(namespace.uri())) {
                        return this;
                    }
                    newCursor.push();
                    while (true) {
                        if (!newCursor.toNextToken().isAnyAttr()) {
                            break;
                        } else if (newCursor.isNamespace() && newCursor.getName().getLocalPart().equals(prefix)) {
                            newCursor.removeXml();
                            break;
                        }
                    }
                    newCursor.pop();
                }
                newCursor.toNextToken();
                newCursor.insertNamespace(prefix, namespace.uri());
                return this;
            }
            return this;
        } finally {
            newCursor.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML appendChild(Object obj) {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        if (newCursor.isStart()) {
            newCursor.toEndToken();
        }
        insertChild(newCursor, obj);
        newCursor.dispose();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList attribute(XMLName xMLName) {
        return matchAttributes(xMLName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList attributes() {
        return matchAttributes(XMLName.formStar());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList child(long j) {
        XMLList xMLList = new XMLList(this.lib);
        xMLList.setTargets(this, null);
        xMLList.addToList(getXmlChild(j));
        return xMLList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList child(XMLName xMLName) {
        if (xMLName == null) {
            return new XMLList(this.lib);
        }
        if (xMLName.localName().equals("*")) {
            return allChildNodes(xMLName.uri());
        }
        return matchChildren(XmlCursor.TokenType.START, xMLName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XML getXmlChild(long j) {
        XmlCursor newCursor = newCursor();
        XML createXML = moveToChild(newCursor, j, false, true) ? createXML(this.lib, newCursor) : null;
        newCursor.dispose();
        return createXML;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public int childIndex() {
        XmlCursor newCursor = newCursor();
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        int i = 0;
        while (true) {
            if (currentTokenType.isText()) {
                i++;
                if (!newCursor.toPrevSibling()) {
                    break;
                }
                currentTokenType = newCursor.currentTokenType();
            } else if (currentTokenType.isStart()) {
                if (!newCursor.toPrevToken().isEnd()) {
                    break;
                }
                newCursor.toNextToken();
                if (!newCursor.toPrevSibling()) {
                    break;
                }
                i++;
                currentTokenType = newCursor.currentTokenType();
            } else if (!currentTokenType.isComment() && !currentTokenType.isProcinst()) {
                break;
            } else {
                newCursor.toPrevToken();
                currentTokenType = newCursor.currentTokenType();
            }
        }
        if (newCursor.currentTokenType().isStartdoc()) {
            i = -1;
        }
        newCursor.dispose();
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList children() {
        return allChildNodes(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList comments() {
        return matchChildren(XmlCursor.TokenType.COMMENT);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    boolean contains(Object obj) {
        if (obj instanceof XML) {
            return equivalentXml(obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object copy() {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        XML createEmptyXML = createEmptyXML(this.lib);
        XmlCursor newCursor2 = createEmptyXML.newCursor();
        newCursor2.toFirstContentToken();
        newCursor.copyXml(newCursor2);
        newCursor2.dispose();
        newCursor.dispose();
        return createEmptyXML;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList descendants(XMLName xMLName) {
        if (xMLName.isAttributeName()) {
            return matchDescendantAttributes(xMLName);
        }
        return matchDescendantChildren(xMLName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object[] inScopeNamespaces() {
        XmlCursor newCursor = newCursor();
        Object[] inScopeNamespaces = NamespaceHelper.inScopeNamespaces(this.lib, newCursor);
        newCursor.dispose();
        return inScopeNamespaces;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML insertChildAfter(Object obj, Object obj2) {
        if (obj == null) {
            prependChild(obj2);
        } else if (obj instanceof XML) {
            insertChild((XML) obj, obj2, 1);
        }
        return this;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    XML insertChildBefore(Object obj, Object obj2) {
        if (obj == null) {
            appendChild(obj2);
        } else if (obj instanceof XML) {
            insertChild((XML) obj, obj2, 2);
        }
        return this;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public boolean hasComplexContent() {
        return !hasSimpleContent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public boolean hasSimpleContent() {
        XmlCursor newCursor = newCursor();
        if (newCursor.isAttr() || newCursor.isText()) {
            return true;
        }
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        boolean z = !newCursor.toFirstChild();
        newCursor.dispose();
        return z;
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    String localName() {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        String str = null;
        if (newCursor.isStart() || newCursor.isAttr() || newCursor.isProcinst()) {
            str = newCursor.getName().getLocalPart();
        }
        newCursor.dispose();
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public QName name() {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        QName qName = null;
        if (newCursor.isStart() || newCursor.isAttr() || newCursor.isProcinst()) {
            javax.xml.namespace.QName name = newCursor.getName();
            if (newCursor.isProcinst()) {
                qName = new QName(this.lib, "", name.getLocalPart(), "");
            } else {
                qName = new QName(this.lib, name.getNamespaceURI(), name.getLocalPart(), name.getPrefix());
            }
        }
        newCursor.dispose();
        return qName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object namespace(String str) {
        Object obj;
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        Namespace namespace = null;
        if (str == null) {
            if (newCursor.isStart() || newCursor.isAttr()) {
                Object[] inScopeNamespaces = NamespaceHelper.inScopeNamespaces(this.lib, newCursor);
                XmlCursor newCursor2 = newCursor();
                if (newCursor2.isStartdoc()) {
                    newCursor2.toFirstContentToken();
                }
                obj = NamespaceHelper.getNamespace(this.lib, newCursor2, inScopeNamespaces);
                newCursor2.dispose();
                namespace = obj;
            }
        } else {
            String str2 = (String) NamespaceHelper.getAllNamespaces(this.lib, newCursor).get(str);
            if (str2 == null) {
                obj = Undefined.instance;
                namespace = obj;
            } else {
                namespace = new Namespace(this.lib, str, str2);
            }
        }
        newCursor.dispose();
        return namespace;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object[] namespaceDeclarations() {
        XmlCursor newCursor = newCursor();
        Object[] namespaceDeclarations = NamespaceHelper.namespaceDeclarations(this.lib, newCursor);
        newCursor.dispose();
        return namespaceDeclarations;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object nodeKind() {
        XmlCursor.TokenType tokenType = tokenType();
        return tokenType == XmlCursor.TokenType.ATTR ? "attribute" : tokenType == XmlCursor.TokenType.TEXT ? "text" : tokenType == XmlCursor.TokenType.COMMENT ? "comment" : tokenType == XmlCursor.TokenType.PROCINST ? "processing-instruction" : tokenType == XmlCursor.TokenType.START ? "element" : "text";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public void normalize() {
        XmlCursor newCursor = newCursor();
        XmlCursor.TokenType currentTokenType = newCursor.currentTokenType();
        if (currentTokenType.isStartdoc()) {
            currentTokenType = newCursor.toFirstContentToken();
        }
        if (currentTokenType.isContainer()) {
            int i = 1;
            String str = null;
            while (i > 0) {
                XmlCursor.TokenType nextToken = newCursor.toNextToken();
                if (nextToken == XmlCursor.TokenType.TEXT) {
                    String trim = newCursor.getChars().trim();
                    if (trim.trim().length() == 0) {
                        removeToken(newCursor);
                        newCursor.toPrevToken();
                    } else if (str == null) {
                        str = trim;
                    } else {
                        newCursor.toPrevToken();
                        removeToken(newCursor);
                        removeToken(newCursor);
                        newCursor.insertChars(str + trim);
                    }
                } else {
                    str = null;
                }
                if (nextToken.isStart()) {
                    i++;
                } else if (nextToken.isEnd()) {
                    i--;
                } else if (nextToken.isEnddoc()) {
                    break;
                }
            }
        }
        newCursor.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object parent() {
        Object obj;
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            obj = Undefined.instance;
        } else if (newCursor.toParent()) {
            if (newCursor.isStartdoc()) {
                obj = Undefined.instance;
            } else {
                obj = getFromAnnotation(this.lib, findAnnotation(newCursor));
            }
        } else {
            obj = Undefined.instance;
        }
        newCursor.dispose();
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML prependChild(Object obj) {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        newCursor.toFirstContentToken();
        insertChild(newCursor, obj);
        newCursor.dispose();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public Object processingInstructions(XMLName xMLName) {
        return matchChildren(XmlCursor.TokenType.PROCINST, xMLName);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
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
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009b, code lost:
        return r10;
     */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.mozilla.javascript.xml.impl.xmlbeans.XML removeNamespace(org.mozilla.javascript.xml.impl.xmlbeans.Namespace r11) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.xml.impl.xmlbeans.XML.removeNamespace(org.mozilla.javascript.xml.impl.xmlbeans.Namespace):org.mozilla.javascript.xml.impl.xmlbeans.XML");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML replace(long j, Object obj) {
        XMLList child = child(j);
        if (child.length() > 0) {
            insertChildAfter(child.item(0), obj);
            removeChild(j);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML replace(XMLName xMLName, Object obj) {
        putXMLProperty(xMLName, obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XML setChildren(Object obj) {
        getPropertyList(XMLName.formStar()).remove();
        appendChild(obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public void setLocalName(String str) {
        XmlCursor newCursor = newCursor();
        try {
            if (newCursor.isStartdoc()) {
                newCursor.toFirstContentToken();
            }
            if (!newCursor.isText() && !newCursor.isComment()) {
                javax.xml.namespace.QName name = newCursor.getName();
                newCursor.setName(new javax.xml.namespace.QName(name.getNamespaceURI(), str, name.getPrefix()));
            }
        } finally {
            newCursor.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public void setName(QName qName) {
        XmlCursor newCursor = newCursor();
        try {
            if (newCursor.isStartdoc()) {
                newCursor.toFirstContentToken();
            }
            if (!newCursor.isText() && !newCursor.isComment()) {
                if (newCursor.isProcinst()) {
                    newCursor.setName(new javax.xml.namespace.QName(qName.localName()));
                } else {
                    String prefix = qName.prefix();
                    if (prefix == null) {
                        prefix = "";
                    }
                    newCursor.setName(new javax.xml.namespace.QName(qName.uri(), qName.localName(), prefix));
                }
            }
        } finally {
            newCursor.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public void setNamespace(Namespace namespace) {
        XmlCursor newCursor = newCursor();
        try {
            if (newCursor.isStartdoc()) {
                newCursor.toFirstContentToken();
            }
            if (!newCursor.isText() && !newCursor.isComment() && !newCursor.isProcinst()) {
                String prefix = namespace.prefix();
                if (prefix == null) {
                    prefix = "";
                }
                newCursor.setName(new javax.xml.namespace.QName(namespace.uri(), localName(), prefix));
            }
        } finally {
            newCursor.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XMLList text() {
        return matchChildren(XmlCursor.TokenType.TEXT);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public String toString() {
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        if (newCursor.isText()) {
            return newCursor.getChars();
        }
        if (newCursor.isStart() && hasSimpleContent()) {
            return newCursor.getTextValue();
        }
        return toXMLString(0);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    String toSource(int i) {
        return toXMLString(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public String toXMLString(int i) {
        String dumpNode;
        XmlCursor newCursor = newCursor();
        if (newCursor.isStartdoc()) {
            newCursor.toFirstContentToken();
        }
        try {
            if (newCursor.isText()) {
                dumpNode = newCursor.getChars();
            } else if (newCursor.isAttr()) {
                dumpNode = newCursor.getTextValue();
            } else {
                if (!newCursor.isComment() && !newCursor.isProcinst()) {
                    dumpNode = dumpNode(newCursor, getOptions());
                }
                dumpNode = dumpNode(newCursor, getOptions());
                if (dumpNode.startsWith("<xml-fragment>")) {
                    dumpNode = dumpNode.substring(14);
                }
                if (dumpNode.endsWith("</xml-fragment>")) {
                    dumpNode = dumpNode.substring(0, dumpNode.length() - 15);
                }
            }
            return dumpNode;
        } finally {
            newCursor.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public boolean equivalentXml(Object obj) {
        if (obj instanceof XML) {
            XML xml = (XML) obj;
            XmlCursor.TokenType tokenType = tokenType();
            XmlCursor.TokenType tokenType2 = xml.tokenType();
            if (tokenType == XmlCursor.TokenType.ATTR || tokenType2 == XmlCursor.TokenType.ATTR || tokenType == XmlCursor.TokenType.TEXT || tokenType2 == XmlCursor.TokenType.TEXT) {
                return toString().equals(xml.toString());
            }
            XmlCursor newCursor = newCursor();
            XmlCursor newCursor2 = xml.newCursor();
            boolean nodesEqual = LogicalEquality.nodesEqual(newCursor, newCursor2);
            newCursor.dispose();
            newCursor2.dispose();
            return nodesEqual;
        } else if (obj instanceof XMLList) {
            XMLList xMLList = (XMLList) obj;
            if (xMLList.length() == 1) {
                return equivalentXml(xMLList.getXmlFromAnnotation(0));
            }
            return false;
        } else if (hasSimpleContent()) {
            return toString().equals(ScriptRuntime.toString(obj));
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLList getPropertyList(XMLName xMLName) {
        if (xMLName.isDescendants()) {
            return descendants(xMLName);
        }
        if (xMLName.isAttributeName()) {
            return attribute(xMLName);
        }
        return child(xMLName);
    }

    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    protected Object jsConstructor(Context context, boolean z, Object[] objArr) {
        if (objArr.length == 0) {
            return createFromJS(this.lib, "");
        }
        Object obj = objArr[0];
        return (z || !(obj instanceof XML)) ? createFromJS(this.lib, obj) : obj;
    }

    @Override // org.mozilla.javascript.xml.XMLObject
    public Scriptable getExtraMethodSource(Context context) {
        if (hasSimpleContent()) {
            return ScriptRuntime.toObjectOrNull(context, toString());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.mozilla.javascript.xml.impl.xmlbeans.XMLObjectImpl
    public XmlObject getXmlObject() {
        XmlCursor newCursor = newCursor();
        try {
            return newCursor.getObject();
        } finally {
            newCursor.dispose();
        }
    }
}
