package org.mozilla.javascript;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import okhttp3.HttpUrl;
import org.mozilla.javascript.json.JsonParser;

/* loaded from: classes5.dex */
public final class NativeJSON extends IdScriptableObject {
    private static final int Id_parse = 2;
    private static final int Id_stringify = 3;
    private static final int Id_toSource = 1;
    private static final Object JSON_TAG = JsonFactory.FORMAT_NAME_JSON;
    private static final int LAST_METHOD_ID = 3;
    private static final int MAX_ID = 3;
    private static final int MAX_STRINGIFY_GAP_LENGTH = 10;
    static final long serialVersionUID = -4567599697595654984L;

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return JsonFactory.FORMAT_NAME_JSON;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        NativeJSON nativeJSON = new NativeJSON();
        nativeJSON.activatePrototypeMap(3);
        nativeJSON.setPrototype(getObjectPrototype(scriptable));
        nativeJSON.setParentScope(scriptable);
        if (z) {
            nativeJSON.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, JsonFactory.FORMAT_NAME_JSON, nativeJSON, 2);
    }

    private NativeJSON() {
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 3;
        if (i <= 3) {
            if (i == 1) {
                i2 = 0;
                str = "toSource";
            } else if (i == 2) {
                str = "parse";
                i2 = 2;
            } else if (i != 3) {
                throw new IllegalStateException(String.valueOf(i));
            } else {
                str = "stringify";
            }
            initPrototypeMethod(JSON_TAG, i, str, i2);
            return;
        }
        throw new IllegalStateException(String.valueOf(i));
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object obj;
        Object obj2;
        Object obj3;
        if (!idFunctionObject.hasTag(JSON_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId != 1) {
            if (methodId == 2) {
                String scriptRuntime = ScriptRuntime.toString(objArr, 0);
                r2 = objArr.length > 1 ? objArr[1] : null;
                if (r2 instanceof Callable) {
                    return parse(context, scriptable, scriptRuntime, r2);
                }
                return parse(context, scriptable, scriptRuntime);
            } else if (methodId == 3) {
                int length = objArr.length;
                if (length != 0) {
                    if (length != 1) {
                        Object obj4 = length != 2 ? objArr[2] : null;
                        r2 = objArr[1];
                        obj3 = obj4;
                    } else {
                        obj3 = null;
                    }
                    obj2 = obj3;
                    obj = r2;
                    r2 = objArr[0];
                } else {
                    obj = null;
                    obj2 = null;
                }
                return stringify(context, scriptable, r2, obj, obj2);
            } else {
                throw new IllegalStateException(String.valueOf(methodId));
            }
        }
        return JsonFactory.FORMAT_NAME_JSON;
    }

    private static Object parse(Context context, Scriptable scriptable, String str) {
        try {
            return new JsonParser(context, scriptable).parseValue(str);
        } catch (JsonParser.ParseException e) {
            throw ScriptRuntime.constructError("SyntaxError", e.getMessage());
        }
    }

    public static Object parse(Context context, Scriptable scriptable, String str, Callable callable) {
        Object parse = parse(context, scriptable, str);
        Scriptable newObject = context.newObject(scriptable);
        newObject.put("", newObject, parse);
        return walk(context, scriptable, callable, newObject, "");
    }

    private static Object walk(Context context, Scriptable scriptable, Callable callable, Scriptable scriptable2, Object obj) {
        Object obj2;
        Object[] ids;
        if (obj instanceof Number) {
            obj2 = scriptable2.get(((Number) obj).intValue(), scriptable2);
        } else {
            obj2 = scriptable2.get((String) obj, scriptable2);
        }
        if (obj2 instanceof Scriptable) {
            Scriptable scriptable3 = (Scriptable) obj2;
            if (scriptable3 instanceof NativeArray) {
                int length = (int) ((NativeArray) scriptable3).getLength();
                for (int i = 0; i < length; i++) {
                    Object walk = walk(context, scriptable, callable, scriptable3, Integer.valueOf(i));
                    if (walk == Undefined.instance) {
                        scriptable3.delete(i);
                    } else {
                        scriptable3.put(i, scriptable3, walk);
                    }
                }
            } else {
                for (Object obj3 : scriptable3.getIds()) {
                    Object walk2 = walk(context, scriptable, callable, scriptable3, obj3);
                    if (walk2 == Undefined.instance) {
                        if (obj3 instanceof Number) {
                            scriptable3.delete(((Number) obj3).intValue());
                        } else {
                            scriptable3.delete((String) obj3);
                        }
                    } else if (obj3 instanceof Number) {
                        scriptable3.put(((Number) obj3).intValue(), scriptable3, walk2);
                    } else {
                        scriptable3.put((String) obj3, scriptable3, walk2);
                    }
                }
            }
        }
        return callable.call(context, scriptable, scriptable2, new Object[]{obj, obj2});
    }

    private static String repeat(char c, int i) {
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class StringifyState {

        /* renamed from: cx */
        Context f10721cx;
        String gap;
        String indent;
        List<Object> propertyList;
        Callable replacer;
        Scriptable scope;
        Object space;
        Stack<Scriptable> stack = new Stack<>();

        StringifyState(Context context, Scriptable scriptable, String str, String str2, Callable callable, List<Object> list, Object obj) {
            this.f10721cx = context;
            this.scope = scriptable;
            this.indent = str;
            this.gap = str2;
            this.replacer = callable;
            this.propertyList = list;
            this.space = obj;
        }
    }

    public static Object stringify(Context context, Scriptable scriptable, Object obj, Object obj2, Object obj3) {
        Callable callable;
        LinkedList linkedList;
        Object scriptRuntime;
        Object obj4;
        String str;
        String str2;
        if (obj2 instanceof Callable) {
            callable = (Callable) obj2;
            linkedList = null;
        } else if (obj2 instanceof NativeArray) {
            LinkedList linkedList2 = new LinkedList();
            NativeArray nativeArray = (NativeArray) obj2;
            for (Integer num : nativeArray.getIndexIds()) {
                Object obj5 = nativeArray.get(num.intValue(), nativeArray);
                if ((obj5 instanceof String) || (obj5 instanceof Number)) {
                    linkedList2.add(obj5);
                } else if ((obj5 instanceof NativeString) || (obj5 instanceof NativeNumber)) {
                    linkedList2.add(ScriptRuntime.toString(obj5));
                }
            }
            linkedList = linkedList2;
            callable = null;
        } else {
            callable = null;
            linkedList = null;
        }
        if (obj3 instanceof NativeNumber) {
            scriptRuntime = Double.valueOf(ScriptRuntime.toNumber(obj3));
        } else {
            scriptRuntime = obj3 instanceof NativeString ? ScriptRuntime.toString(obj3) : obj3;
        }
        if (scriptRuntime instanceof Number) {
            int min = Math.min(10, (int) ScriptRuntime.toInteger(scriptRuntime));
            str2 = min > 0 ? repeat(' ', min) : "";
            scriptRuntime = Integer.valueOf(min);
        } else if (scriptRuntime instanceof String) {
            str2 = (String) scriptRuntime;
            if (str2.length() > 10) {
                str2 = str2.substring(0, 10);
            }
        } else {
            obj4 = scriptRuntime;
            str = "";
            StringifyState stringifyState = new StringifyState(context, scriptable, "", str, callable, linkedList, obj4);
            NativeObject nativeObject = new NativeObject();
            nativeObject.setParentScope(scriptable);
            nativeObject.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
            nativeObject.defineProperty("", obj, 0);
            return str("", nativeObject, stringifyState);
        }
        obj4 = scriptRuntime;
        str = str2;
        StringifyState stringifyState2 = new StringifyState(context, scriptable, "", str, callable, linkedList, obj4);
        NativeObject nativeObject2 = new NativeObject();
        nativeObject2.setParentScope(scriptable);
        nativeObject2.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeObject2.defineProperty("", obj, 0);
        return str("", nativeObject2, stringifyState2);
    }

    private static Object str(Object obj, Scriptable scriptable, StringifyState stringifyState) {
        Object property;
        if (obj instanceof String) {
            property = getProperty(scriptable, (String) obj);
        } else {
            property = getProperty(scriptable, ((Number) obj).intValue());
        }
        if (property instanceof Scriptable) {
            Scriptable scriptable2 = (Scriptable) property;
            if (getProperty(scriptable2, "toJSON") instanceof Callable) {
                property = callMethod(stringifyState.f10721cx, scriptable2, "toJSON", new Object[]{obj});
            }
        }
        if (stringifyState.replacer != null) {
            property = stringifyState.replacer.call(stringifyState.f10721cx, stringifyState.scope, scriptable, new Object[]{obj, property});
        }
        if (property instanceof NativeNumber) {
            property = Double.valueOf(ScriptRuntime.toNumber(property));
        } else if (property instanceof NativeString) {
            property = ScriptRuntime.toString(property);
        } else if (property instanceof NativeBoolean) {
            property = ((NativeBoolean) property).getDefaultValue(ScriptRuntime.BooleanClass);
        }
        if (property == null) {
            return "null";
        }
        if (property.equals(Boolean.TRUE)) {
            return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        }
        if (property.equals(Boolean.FALSE)) {
            return "false";
        }
        if (property instanceof CharSequence) {
            return quote(property.toString());
        }
        if (property instanceof Number) {
            double doubleValue = ((Number) property).doubleValue();
            return (doubleValue != doubleValue || doubleValue == Double.POSITIVE_INFINITY || doubleValue == Double.NEGATIVE_INFINITY) ? "null" : ScriptRuntime.toString(property);
        } else if ((property instanceof Scriptable) && !(property instanceof Callable)) {
            if (property instanceof NativeArray) {
                return m50ja((NativeArray) property, stringifyState);
            }
            return m49jo((Scriptable) property, stringifyState);
        } else {
            return Undefined.instance;
        }
    }

    private static String join(Collection<Object> collection, String str) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<Object> it = collection.iterator();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder(it.next().toString());
            while (it.hasNext()) {
                sb.append(str);
                sb.append(it.next().toString());
            }
            return sb.toString();
        }
        return "";
    }

    /* renamed from: jo */
    private static String m49jo(Scriptable scriptable, StringifyState stringifyState) {
        Object[] ids;
        String str;
        if (stringifyState.stack.search(scriptable) != -1) {
            throw ScriptRuntime.typeError0("msg.cyclic.value");
        }
        stringifyState.stack.push(scriptable);
        String str2 = stringifyState.indent;
        stringifyState.indent += stringifyState.gap;
        if (stringifyState.propertyList != null) {
            ids = stringifyState.propertyList.toArray();
        } else {
            ids = scriptable.getIds();
        }
        LinkedList linkedList = new LinkedList();
        for (Object obj : ids) {
            Object str3 = str(obj, scriptable, stringifyState);
            if (str3 != Undefined.instance) {
                String str4 = quote(obj.toString()) + ":";
                if (stringifyState.gap.length() > 0) {
                    str4 = str4 + " ";
                }
                linkedList.add(str4 + str3);
            }
        }
        if (linkedList.isEmpty()) {
            str = JsonUtils.EMPTY_JSON;
        } else if (stringifyState.gap.length() == 0) {
            str = '{' + join(linkedList, ",") + '}';
        } else {
            str = "{\n" + stringifyState.indent + join(linkedList, ",\n" + stringifyState.indent) + '\n' + str2 + '}';
        }
        stringifyState.stack.pop();
        stringifyState.indent = str2;
        return str;
    }

    /* renamed from: ja */
    private static String m50ja(NativeArray nativeArray, StringifyState stringifyState) {
        String str;
        if (stringifyState.stack.search(nativeArray) != -1) {
            throw ScriptRuntime.typeError0("msg.cyclic.value");
        }
        stringifyState.stack.push(nativeArray);
        String str2 = stringifyState.indent;
        stringifyState.indent += stringifyState.gap;
        LinkedList linkedList = new LinkedList();
        int length = (int) nativeArray.getLength();
        for (int i = 0; i < length; i++) {
            Object str3 = str(Integer.valueOf(i), nativeArray, stringifyState);
            if (str3 == Undefined.instance) {
                linkedList.add("null");
            } else {
                linkedList.add(str3);
            }
        }
        if (linkedList.isEmpty()) {
            str = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        } else if (stringifyState.gap.length() == 0) {
            str = '[' + join(linkedList, ",") + ']';
        } else {
            str = "[\n" + stringifyState.indent + join(linkedList, ",\n" + stringifyState.indent) + '\n' + str2 + ']';
        }
        stringifyState.stack.pop();
        stringifyState.indent = str2;
        return str;
    }

    private static String quote(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() + 2);
        stringBuffer.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt == '\\') {
                            stringBuffer.append("\\\\");
                        } else {
                            switch (charAt) {
                                case '\b':
                                    stringBuffer.append("\\b");
                                    continue;
                                case '\t':
                                    stringBuffer.append("\\t");
                                    continue;
                                case '\n':
                                    stringBuffer.append("\\n");
                                    continue;
                                default:
                                    if (charAt < ' ') {
                                        stringBuffer.append("\\u");
                                        stringBuffer.append(String.format("%04x", Integer.valueOf(charAt)));
                                        continue;
                                    } else {
                                        stringBuffer.append(charAt);
                                        break;
                                    }
                            }
                        }
                    } else {
                        stringBuffer.append("\\\"");
                    }
                } else {
                    stringBuffer.append("\\r");
                }
            } else {
                stringBuffer.append("\\f");
            }
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 5) {
            str2 = "parse";
            i = 2;
        } else if (length == 8) {
            str2 = "toSource";
            i = 1;
        } else if (length != 9) {
            str2 = null;
            i = 0;
        } else {
            str2 = "stringify";
            i = 3;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }
}
