package org.mozilla.javascript.xml.impl.xmlbeans;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

/* loaded from: classes5.dex */
class XMLCtor extends IdFunctionObject {
    private static final int Id_defaultSettings = 1;
    private static final int Id_ignoreComments = 1;
    private static final int Id_ignoreProcessingInstructions = 2;
    private static final int Id_ignoreWhitespace = 3;
    private static final int Id_prettyIndent = 4;
    private static final int Id_prettyPrinting = 5;
    private static final int Id_setSettings = 3;
    private static final int Id_settings = 2;
    private static final int MAX_FUNCTION_ID = 3;
    private static final int MAX_INSTANCE_ID = 5;
    private static final Object XMLCTOR_TAG = "XMLCtor";
    static final long serialVersionUID = -8708195078359817341L;
    private XMLLibImpl lib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public XMLCtor(XML xml, Object obj, int i, int i2) {
        super(xml, obj, i, i2);
        this.lib = xml.lib;
        activatePrototypeMap(3);
    }

    private void writeSetting(Scriptable scriptable) {
        for (int i = 1; i <= 5; i++) {
            int maxInstanceId = super.getMaxInstanceId() + i;
            ScriptableObject.putProperty(scriptable, getInstanceIdName(maxInstanceId), getInstanceIdValue(maxInstanceId));
        }
    }

    private void readSettings(Scriptable scriptable) {
        for (int i = 1; i <= 5; i++) {
            int maxInstanceId = super.getMaxInstanceId() + i;
            Object property = ScriptableObject.getProperty(scriptable, getInstanceIdName(maxInstanceId));
            if (property != Scriptable.NOT_FOUND) {
                if (i != 1 && i != 2 && i != 3) {
                    if (i == 4) {
                        if (!(property instanceof Number)) {
                        }
                        setInstanceIdValue(maxInstanceId, property);
                    } else if (i != 5) {
                        throw new IllegalStateException();
                    }
                }
                if (!(property instanceof Boolean)) {
                }
                setInstanceIdValue(maxInstanceId, property);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int getMaxInstanceId() {
        return super.getMaxInstanceId() + 5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 0;
        if (length == 12) {
            str2 = "prettyIndent";
            i = 4;
        } else if (length == 14) {
            char charAt = str.charAt(0);
            if (charAt == 'i') {
                str2 = "ignoreComments";
                i = 1;
            } else {
                if (charAt == 'p') {
                    str2 = "prettyPrinting";
                    i = 5;
                }
                str2 = null;
                i = 0;
            }
        } else if (length != 16) {
            if (length == 28) {
                str2 = "ignoreProcessingInstructions";
                i = 2;
            }
            str2 = null;
            i = 0;
        } else {
            str2 = "ignoreWhitespace";
            i = 3;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i2 = i;
        }
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5) {
            throw new IllegalStateException();
        }
        return instanceIdInfo(6, super.getMaxInstanceId() + i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public String getInstanceIdName(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        return maxInstanceId != 1 ? maxInstanceId != 2 ? maxInstanceId != 3 ? maxInstanceId != 4 ? maxInstanceId != 5 ? super.getInstanceIdName(i) : "prettyPrinting" : "prettyIndent" : "ignoreWhitespace" : "ignoreProcessingInstructions" : "ignoreComments";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public Object getInstanceIdValue(int i) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId != 1) {
            if (maxInstanceId != 2) {
                if (maxInstanceId != 3) {
                    if (maxInstanceId != 4) {
                        if (maxInstanceId == 5) {
                            return ScriptRuntime.wrapBoolean(this.lib.prettyPrinting);
                        }
                        return super.getInstanceIdValue(i);
                    }
                    return ScriptRuntime.wrapInt(this.lib.prettyIndent);
                }
                return ScriptRuntime.wrapBoolean(this.lib.ignoreWhitespace);
            }
            return ScriptRuntime.wrapBoolean(this.lib.ignoreProcessingInstructions);
        }
        return ScriptRuntime.wrapBoolean(this.lib.ignoreComments);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    public void setInstanceIdValue(int i, Object obj) {
        int maxInstanceId = i - super.getMaxInstanceId();
        if (maxInstanceId == 1) {
            this.lib.ignoreComments = ScriptRuntime.toBoolean(obj);
        } else if (maxInstanceId == 2) {
            this.lib.ignoreProcessingInstructions = ScriptRuntime.toBoolean(obj);
        } else if (maxInstanceId == 3) {
            this.lib.ignoreWhitespace = ScriptRuntime.toBoolean(obj);
        } else if (maxInstanceId == 4) {
            this.lib.prettyIndent = ScriptRuntime.toInt32(obj);
        } else if (maxInstanceId == 5) {
            this.lib.prettyPrinting = ScriptRuntime.toBoolean(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 8) {
            i = 2;
            str2 = "settings";
        } else if (length == 11) {
            i = 3;
            str2 = "setSettings";
        } else if (length == 15) {
            i = 1;
            str2 = "defaultSettings";
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        if (i == 1) {
            str = "defaultSettings";
        } else if (i != 2) {
            if (i != 3) {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            str2 = "setSettings";
            initPrototypeMethod(XMLCTOR_TAG, i, str2, i2);
        } else {
            str = "settings";
        }
        str2 = str;
        i2 = 0;
        initPrototypeMethod(XMLCTOR_TAG, i, str2, i2);
    }

    @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(XMLCTOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            this.lib.defaultSettings();
            Scriptable newObject = context.newObject(scriptable);
            writeSetting(newObject);
            return newObject;
        } else if (methodId == 2) {
            Scriptable newObject2 = context.newObject(scriptable);
            writeSetting(newObject2);
            return newObject2;
        } else if (methodId == 3) {
            if (objArr.length == 0 || objArr[0] == null || objArr[0] == Undefined.instance) {
                this.lib.defaultSettings();
            } else if (objArr[0] instanceof Scriptable) {
                readSettings((Scriptable) objArr[0]);
            }
            return Undefined.instance;
        } else {
            throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }
}
