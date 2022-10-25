package org.mozilla.javascript.xmlimpl;

import org.mozilla.javascript.NativeWith;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.xml.XMLObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class XMLWithScope extends NativeWith {
    private static final long serialVersionUID = -696429282095170887L;
    private int _currIndex;
    private XMLObject _dqPrototype;
    private XMLList _xmlList;
    private XMLLibImpl lib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLWithScope(XMLLibImpl xMLLibImpl, Scriptable scriptable, XMLObject xMLObject) {
        super(scriptable, xMLObject);
        this.lib = xMLLibImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initAsDotQuery() {
        XMLObject xMLObject = (XMLObject) getPrototype();
        this._currIndex = 0;
        this._dqPrototype = xMLObject;
        if (xMLObject instanceof XMLList) {
            XMLList xMLList = (XMLList) xMLObject;
            if (xMLList.length() > 0) {
                setPrototype((Scriptable) xMLList.get(0, (Scriptable) null));
            }
        }
        this._xmlList = this.lib.newXMLList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.NativeWith
    public Object updateDotQuery(boolean z) {
        XMLObject xMLObject = this._dqPrototype;
        XMLList xMLList = this._xmlList;
        if (xMLObject instanceof XMLList) {
            XMLList xMLList2 = (XMLList) xMLObject;
            int i = this._currIndex;
            if (z) {
                xMLList.addToList(xMLList2.get(i, (Scriptable) null));
            }
            int i2 = i + 1;
            if (i2 < xMLList2.length()) {
                this._currIndex = i2;
                setPrototype((Scriptable) xMLList2.get(i2, (Scriptable) null));
                return null;
            }
        } else if (z) {
            xMLList.addToList(xMLObject);
        }
        return xMLList;
    }
}
