package org.mozilla.javascript;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.mozilla.javascript.NativeIterator;
import org.mozilla.javascript.TopLevel;
import org.mozilla.javascript.v8dtoa.FastDtoa;
import org.mozilla.javascript.xml.XMLLib;
import org.mozilla.javascript.xml.XMLObject;

/* loaded from: classes5.dex */
public class ScriptRuntime {
    private static final String DEFAULT_NS_TAG = "__default_namespace__";
    public static final int ENUMERATE_ARRAY = 2;
    public static final int ENUMERATE_ARRAY_NO_ITERATOR = 5;
    public static final int ENUMERATE_KEYS = 0;
    public static final int ENUMERATE_KEYS_NO_ITERATOR = 3;
    public static final int ENUMERATE_VALUES = 1;
    public static final int ENUMERATE_VALUES_NO_ITERATOR = 4;
    public static final double NaN;
    public static final Double NaNobj;
    private static BaseFunction THROW_TYPE_ERROR;
    public static final Object[] emptyArgs;
    public static final String[] emptyStrings;
    public static MessageProvider messageProvider;
    public static final double negativeZero;
    public static final Class<?> BooleanClass = Kit.classOrNull("java.lang.Boolean");
    public static final Class<?> ByteClass = Kit.classOrNull("java.lang.Byte");
    public static final Class<?> CharacterClass = Kit.classOrNull("java.lang.Character");
    public static final Class<?> ClassClass = Kit.classOrNull("java.lang.Class");
    public static final Class<?> DoubleClass = Kit.classOrNull("java.lang.Double");
    public static final Class<?> FloatClass = Kit.classOrNull("java.lang.Float");
    public static final Class<?> IntegerClass = Kit.classOrNull("java.lang.Integer");
    public static final Class<?> LongClass = Kit.classOrNull("java.lang.Long");
    public static final Class<?> NumberClass = Kit.classOrNull("java.lang.Number");
    public static final Class<?> ObjectClass = Kit.classOrNull("java.lang.Object");
    public static final Class<?> ShortClass = Kit.classOrNull("java.lang.Short");
    public static final Class<?> StringClass = Kit.classOrNull("java.lang.String");
    public static final Class<?> DateClass = Kit.classOrNull("java.util.Date");
    public static final Class<?> ContextClass = Kit.classOrNull("org.mozilla.javascript.Context");
    public static final Class<?> ContextFactoryClass = Kit.classOrNull("org.mozilla.javascript.ContextFactory");
    public static final Class<?> FunctionClass = Kit.classOrNull("org.mozilla.javascript.Function");
    public static final Class<?> ScriptableObjectClass = Kit.classOrNull("org.mozilla.javascript.ScriptableObject");
    public static final Class<Scriptable> ScriptableClass = Scriptable.class;
    public static Locale ROOT_LOCALE = new Locale("");
    private static final Object LIBRARY_SCOPE_KEY = "LIBRARY_SCOPE";

    /* loaded from: classes5.dex */
    public interface MessageProvider {
        String getMessage(String str, Object[] objArr);
    }

    public static boolean isJSLineTerminator(int i) {
        if ((57296 & i) != 0) {
            return false;
        }
        return i == 10 || i == 13 || i == 8232 || i == 8233;
    }

    public static BaseFunction typeErrorThrower() {
        if (THROW_TYPE_ERROR == null) {
            BaseFunction baseFunction = new BaseFunction() { // from class: org.mozilla.javascript.ScriptRuntime.1
                static final long serialVersionUID = -5891740962154902286L;

                @Override // org.mozilla.javascript.BaseFunction
                public int getLength() {
                    return 0;
                }

                @Override // org.mozilla.javascript.BaseFunction, org.mozilla.javascript.Function, org.mozilla.javascript.Callable
                public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
                    throw ScriptRuntime.typeError0("msg.op.not.allowed");
                }
            };
            baseFunction.preventExtensions();
            THROW_TYPE_ERROR = baseFunction;
        }
        return THROW_TYPE_ERROR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class NoSuchMethodShim implements Callable {
        String methodName;
        Callable noSuchMethodMethod;

        NoSuchMethodShim(Callable callable, String str) {
            this.noSuchMethodMethod = callable;
            this.methodName = str;
        }

        @Override // org.mozilla.javascript.Callable
        public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
            return this.noSuchMethodMethod.call(context, scriptable, scriptable2, new Object[]{this.methodName, ScriptRuntime.newArrayLiteral(objArr, null, context, scriptable)});
        }
    }

    static {
        double longBitsToDouble = Double.longBitsToDouble(9221120237041090560L);
        NaN = longBitsToDouble;
        negativeZero = Double.longBitsToDouble(Long.MIN_VALUE);
        NaNobj = new Double(longBitsToDouble);
        messageProvider = new DefaultMessageProvider();
        emptyArgs = new Object[0];
        emptyStrings = new String[0];
    }

    public static boolean isRhinoRuntimeType(Class<?> cls) {
        return cls.isPrimitive() ? cls != Character.TYPE : cls == StringClass || cls == BooleanClass || NumberClass.isAssignableFrom(cls) || ScriptableClass.isAssignableFrom(cls);
    }

    public static ScriptableObject initStandardObjects(Context context, ScriptableObject scriptableObject, boolean z) {
        if (scriptableObject == null) {
            scriptableObject = new NativeObject();
        }
        scriptableObject.associateValue(LIBRARY_SCOPE_KEY, scriptableObject);
        new ClassCache().associate(scriptableObject);
        BaseFunction.init(scriptableObject, z);
        NativeObject.init(scriptableObject, z);
        Scriptable objectPrototype = ScriptableObject.getObjectPrototype(scriptableObject);
        ScriptableObject.getClassPrototype(scriptableObject, "Function").setPrototype(objectPrototype);
        if (scriptableObject.getPrototype() == null) {
            scriptableObject.setPrototype(objectPrototype);
        }
        NativeError.init(scriptableObject, z);
        NativeGlobal.init(context, scriptableObject, z);
        NativeArray.init(scriptableObject, z);
        if (context.getOptimizationLevel() > 0) {
            NativeArray.setMaximumInitialCapacity(200000);
        }
        NativeString.init(scriptableObject, z);
        NativeBoolean.init(scriptableObject, z);
        NativeNumber.init(scriptableObject, z);
        NativeDate.init(scriptableObject, z);
        NativeMath.init(scriptableObject, z);
        NativeJSON.init(scriptableObject, z);
        NativeWith.init(scriptableObject, z);
        NativeCall.init(scriptableObject, z);
        NativeScript.init(scriptableObject, z);
        NativeIterator.init(scriptableObject, z);
        boolean z2 = context.hasFeature(6) && context.getE4xImplementationFactory() != null;
        ScriptableObject scriptableObject2 = scriptableObject;
        new LazilyLoadedCtor(scriptableObject2, "RegExp", "org.mozilla.javascript.regexp.NativeRegExp", z, true);
        new LazilyLoadedCtor(scriptableObject2, "Packages", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObject2, "getClass", "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        new LazilyLoadedCtor(scriptableObject2, "JavaAdapter", "org.mozilla.javascript.JavaAdapter", z, true);
        new LazilyLoadedCtor(scriptableObject2, "JavaImporter", "org.mozilla.javascript.ImporterTopLevel", z, true);
        new LazilyLoadedCtor(scriptableObject2, "Continuation", "org.mozilla.javascript.NativeContinuation", z, true);
        for (String str : getTopPackageNames()) {
            new LazilyLoadedCtor(scriptableObject, str, "org.mozilla.javascript.NativeJavaTopPackage", z, true);
        }
        if (z2) {
            String implementationClassName = context.getE4xImplementationFactory().getImplementationClassName();
            ScriptableObject scriptableObject3 = scriptableObject;
            new LazilyLoadedCtor(scriptableObject3, "XML", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject3, "XMLList", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject3, "Namespace", implementationClassName, z, true);
            new LazilyLoadedCtor(scriptableObject3, "QName", implementationClassName, z, true);
        }
        if (scriptableObject instanceof TopLevel) {
            scriptableObject.cacheBuiltins();
        }
        return scriptableObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] getTopPackageNames() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new String[]{"java", "javax", "org", "com", "edu", "net", "android"} : new String[]{"java", "javax", "org", "com", "edu", "net"};
    }

    public static ScriptableObject getLibraryScopeOrNull(Scriptable scriptable) {
        return (ScriptableObject) ScriptableObject.getTopScopeValue(scriptable, LIBRARY_SCOPE_KEY);
    }

    public static boolean isJSWhitespaceOrLineTerminator(int i) {
        return isStrWhiteSpaceChar(i) || isJSLineTerminator(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isStrWhiteSpaceChar(int i) {
        if (i == 32 || i == 160 || i == 65279 || i == 8232 || i == 8233) {
            return true;
        }
        switch (i) {
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return true;
            default:
                return Character.getType(i) == 12;
        }
    }

    public static Boolean wrapBoolean(boolean z) {
        return z ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Integer wrapInt(int i) {
        return Integer.valueOf(i);
    }

    public static Number wrapNumber(double d) {
        if (d != d) {
            return NaNobj;
        }
        return new Double(d);
    }

    public static boolean toBoolean(Object obj) {
        while (!(obj instanceof Boolean)) {
            if (obj == null || obj == Undefined.instance) {
                return false;
            }
            if (obj instanceof CharSequence) {
                return ((CharSequence) obj).length() != 0;
            } else if (obj instanceof Number) {
                double doubleValue = ((Number) obj).doubleValue();
                return doubleValue == doubleValue && doubleValue != 0.0d;
            } else if (obj instanceof Scriptable) {
                if ((obj instanceof ScriptableObject) && ((ScriptableObject) obj).avoidObjectDetection()) {
                    return false;
                }
                if (Context.getContext().isVersionECMA1()) {
                    return true;
                }
                obj = ((Scriptable) obj).getDefaultValue(BooleanClass);
                if (obj instanceof Scriptable) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            } else {
                warnAboutNonJSObject(obj);
                return true;
            }
        }
        return ((Boolean) obj).booleanValue();
    }

    public static double toNumber(Object obj) {
        while (!(obj instanceof Number)) {
            if (obj == null) {
                return 0.0d;
            }
            if (obj == Undefined.instance) {
                return NaN;
            }
            if (obj instanceof String) {
                return toNumber((String) obj);
            }
            if (obj instanceof CharSequence) {
                return toNumber(obj.toString());
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue() ? 1.0d : 0.0d;
            } else if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
                if (obj instanceof Scriptable) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            } else {
                warnAboutNonJSObject(obj);
                return NaN;
            }
        }
        return ((Number) obj).doubleValue();
    }

    public static double toNumber(Object[] objArr, int i) {
        return i < objArr.length ? toNumber(objArr[i]) : NaN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
        if (r11 != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a1, code lost:
        if ((r11 & r13) != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        r15 = r15 + 1.0d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double stringToNumber(java.lang.String r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.stringToNumber(java.lang.String, int, int):double");
    }

    public static double toNumber(String str) {
        int i;
        char charAt;
        char charAt2;
        char charAt3;
        int length = str.length();
        int i2 = 0;
        while (i2 != length) {
            char charAt4 = str.charAt(i2);
            if (!isStrWhiteSpaceChar(charAt4)) {
                if (charAt4 == '0') {
                    int i3 = i2 + 2;
                    if (i3 < length && ((charAt3 = str.charAt(i2 + 1)) == 'x' || charAt3 == 'X')) {
                        return stringToNumber(str, i3, 16);
                    }
                } else if ((charAt4 == '+' || charAt4 == '-') && (i = i2 + 3) < length && str.charAt(i2 + 1) == '0' && ((charAt = str.charAt(i2 + 2)) == 'x' || charAt == 'X')) {
                    double stringToNumber = stringToNumber(str, i, 16);
                    return charAt4 == '-' ? -stringToNumber : stringToNumber;
                }
                while (true) {
                    length--;
                    charAt2 = str.charAt(length);
                    if (!isStrWhiteSpaceChar(charAt2)) {
                        break;
                    }
                }
                if (charAt2 == 'y') {
                    if (charAt4 == '+' || charAt4 == '-') {
                        i2++;
                    }
                    if (i2 + 7 == length && str.regionMatches(i2, "Infinity", 0, 8)) {
                        return charAt4 == '-' ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                    }
                    return NaN;
                }
                String substring = str.substring(i2, length + 1);
                for (int length2 = substring.length() - 1; length2 >= 0; length2--) {
                    char charAt5 = substring.charAt(length2);
                    if (('0' > charAt5 || charAt5 > '9') && charAt5 != '.' && charAt5 != 'e' && charAt5 != 'E' && charAt5 != '+' && charAt5 != '-') {
                        return NaN;
                    }
                }
                try {
                    return Double.parseDouble(substring);
                } catch (NumberFormatException unused) {
                    return NaN;
                }
            }
            i2++;
        }
        return 0.0d;
    }

    public static Object[] padArguments(Object[] objArr, int i) {
        if (i < objArr.length) {
            return objArr;
        }
        Object[] objArr2 = new Object[i];
        int i2 = 0;
        while (i2 < objArr.length) {
            objArr2[i2] = objArr[i2];
            i2++;
        }
        while (i2 < i) {
            objArr2[i2] = Undefined.instance;
            i2++;
        }
        return objArr2;
    }

    public static String escapeString(String str) {
        return escapeString(str, '\"');
    }

    public static String escapeString(String str, char c) {
        int i;
        if (c != '\"' && c != '\'') {
            Kit.codeBug();
        }
        StringBuffer stringBuffer = null;
        int length = str.length();
        for (int i2 = 0; i2 != length; i2++) {
            char charAt = str.charAt(i2);
            int i3 = 32;
            if (' ' > charAt || charAt > '~' || charAt == c || charAt == '\\') {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(length + 3);
                    stringBuffer.append(str);
                    stringBuffer.setLength(i2);
                }
                if (charAt != ' ') {
                    if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                i3 = 98;
                                break;
                            case '\t':
                                i3 = 116;
                                break;
                            case '\n':
                                i3 = 110;
                                break;
                            case 11:
                                i3 = 118;
                                break;
                            case '\f':
                                i3 = 102;
                                break;
                            case '\r':
                                i3 = 114;
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                    } else {
                        i3 = 92;
                    }
                }
                if (i3 >= 0) {
                    stringBuffer.append('\\');
                    stringBuffer.append((char) i3);
                } else if (charAt == c) {
                    stringBuffer.append('\\');
                    stringBuffer.append(c);
                } else {
                    if (charAt < 256) {
                        stringBuffer.append("\\x");
                        i = 2;
                    } else {
                        stringBuffer.append("\\u");
                        i = 4;
                    }
                    for (int i4 = (i - 1) * 4; i4 >= 0; i4 -= 4) {
                        int i5 = (charAt >> i4) & 15;
                        stringBuffer.append((char) (i5 < 10 ? i5 + 48 : i5 + 87));
                    }
                }
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer == null ? str : stringBuffer.toString();
    }

    static boolean isValidIdentifierName(String str) {
        int length = str.length();
        if (length != 0 && Character.isJavaIdentifierStart(str.charAt(0))) {
            for (int i = 1; i != length; i++) {
                if (!Character.isJavaIdentifierPart(str.charAt(i))) {
                    return false;
                }
            }
            return !TokenStream.isKeyword(str);
        }
        return false;
    }

    public static CharSequence toCharSequence(Object obj) {
        if (obj instanceof NativeString) {
            return ((NativeString) obj).toCharSequence();
        }
        return obj instanceof CharSequence ? (CharSequence) obj : toString(obj);
    }

    public static String toString(Object obj) {
        while (obj != null) {
            if (obj == Undefined.instance) {
                return "undefined";
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof Number) {
                return numberToString(((Number) obj).doubleValue(), 10);
            }
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(StringClass);
                if (obj instanceof Scriptable) {
                    throw errorWithClassName("msg.primitive.expected", obj);
                }
            } else {
                return obj.toString();
            }
        }
        return "null";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String defaultObjectToString(Scriptable scriptable) {
        return "[object " + scriptable.getClassName() + ']';
    }

    public static String toString(Object[] objArr, int i) {
        return i < objArr.length ? toString(objArr[i]) : "undefined";
    }

    public static String toString(double d) {
        return numberToString(d, 10);
    }

    public static String numberToString(double d, int i) {
        if (d != d) {
            return "NaN";
        }
        if (d == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        if (d == Double.NEGATIVE_INFINITY) {
            return "-Infinity";
        }
        if (d == 0.0d) {
            return "0";
        }
        if (i < 2 || i > 36) {
            throw Context.reportRuntimeError1("msg.bad.radix", Integer.toString(i));
        }
        if (i != 10) {
            return DToA.JS_dtobasestr(i, d);
        }
        String numberToString = FastDtoa.numberToString(d);
        if (numberToString != null) {
            return numberToString;
        }
        StringBuilder sb = new StringBuilder();
        DToA.JS_dtostr(sb, 0, 0, d);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String uneval(Context context, Scriptable scriptable, Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof CharSequence) {
            String escapeString = escapeString(obj.toString());
            StringBuffer stringBuffer = new StringBuffer(escapeString.length() + 2);
            stringBuffer.append('\"');
            stringBuffer.append(escapeString);
            stringBuffer.append('\"');
            return stringBuffer.toString();
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            return (doubleValue != 0.0d || 1.0d / doubleValue >= 0.0d) ? toString(doubleValue) : "-0";
        } else if (obj instanceof Boolean) {
            return toString(obj);
        } else {
            if (obj instanceof Scriptable) {
                Scriptable scriptable2 = (Scriptable) obj;
                if (ScriptableObject.hasProperty(scriptable2, "toSource")) {
                    Object property = ScriptableObject.getProperty(scriptable2, "toSource");
                    if (property instanceof Function) {
                        return toString(((Function) property).call(context, scriptable, scriptable2, emptyArgs));
                    }
                }
                return toString(obj);
            }
            warnAboutNonJSObject(obj);
            return obj.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String defaultObjectToSource(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        boolean has;
        boolean z;
        Object obj;
        if (context.iterating == null) {
            context.iterating = new ObjToIntMap(31);
            z = true;
            has = false;
        } else {
            has = context.iterating.has(scriptable2);
            z = false;
        }
        StringBuffer stringBuffer = new StringBuffer(128);
        if (z) {
            stringBuffer.append("(");
        }
        stringBuffer.append('{');
        if (!has) {
            try {
                context.iterating.intern(scriptable2);
                Object[] ids = scriptable2.getIds();
                for (int i = 0; i < ids.length; i++) {
                    Object obj2 = ids[i];
                    if (obj2 instanceof Integer) {
                        int intValue = ((Integer) obj2).intValue();
                        obj = scriptable2.get(intValue, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                stringBuffer.append(", ");
                            }
                            stringBuffer.append(intValue);
                            stringBuffer.append(':');
                            stringBuffer.append(uneval(context, scriptable, obj));
                        }
                    } else {
                        String str = (String) obj2;
                        obj = scriptable2.get(str, scriptable2);
                        if (obj != Scriptable.NOT_FOUND) {
                            if (i > 0) {
                                stringBuffer.append(", ");
                            }
                            if (isValidIdentifierName(str)) {
                                stringBuffer.append(str);
                            } else {
                                stringBuffer.append('\'');
                                stringBuffer.append(escapeString(str, '\''));
                                stringBuffer.append('\'');
                            }
                            stringBuffer.append(':');
                            stringBuffer.append(uneval(context, scriptable, obj));
                        }
                    }
                }
            } finally {
                if (z) {
                    context.iterating = null;
                }
            }
        }
        stringBuffer.append('}');
        if (z) {
            stringBuffer.append(')');
        }
        return stringBuffer.toString();
    }

    public static Scriptable toObject(Scriptable scriptable, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return toObject(Context.getContext(), scriptable, obj);
    }

    public static Scriptable toObjectOrNull(Context context, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, getTopCallScope(context), obj);
    }

    public static Scriptable toObjectOrNull(Context context, Object obj, Scriptable scriptable) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj == null || obj == Undefined.instance) {
            return null;
        }
        return toObject(context, scriptable, obj);
    }

    public static Scriptable toObject(Scriptable scriptable, Object obj, Class<?> cls) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return toObject(Context.getContext(), scriptable, obj);
    }

    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        if (obj instanceof CharSequence) {
            NativeString nativeString = new NativeString((CharSequence) obj);
            setBuiltinProtoAndParent(nativeString, scriptable, TopLevel.Builtins.String);
            return nativeString;
        } else if (obj instanceof Number) {
            NativeNumber nativeNumber = new NativeNumber(((Number) obj).doubleValue());
            setBuiltinProtoAndParent(nativeNumber, scriptable, TopLevel.Builtins.Number);
            return nativeNumber;
        } else if (obj instanceof Boolean) {
            NativeBoolean nativeBoolean = new NativeBoolean(((Boolean) obj).booleanValue());
            setBuiltinProtoAndParent(nativeBoolean, scriptable, TopLevel.Builtins.Boolean);
            return nativeBoolean;
        } else if (obj == null) {
            throw typeError0("msg.null.to.object");
        } else {
            if (obj == Undefined.instance) {
                throw typeError0("msg.undef.to.object");
            }
            Object wrap = context.getWrapFactory().wrap(context, scriptable, obj, null);
            if (wrap instanceof Scriptable) {
                return (Scriptable) wrap;
            }
            throw errorWithClassName("msg.invalid.type", obj);
        }
    }

    public static Scriptable toObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        return toObject(context, scriptable, obj);
    }

    public static Object call(Context context, Object obj, Object obj2, Object[] objArr, Scriptable scriptable) {
        if (!(obj instanceof Function)) {
            throw notFunctionError(toString(obj));
        }
        Function function = (Function) obj;
        Scriptable objectOrNull = toObjectOrNull(context, obj2);
        if (objectOrNull == null) {
            throw undefCallError(objectOrNull, "function");
        }
        return function.call(context, scriptable, objectOrNull, objArr);
    }

    public static Scriptable newObject(Context context, Scriptable scriptable, String str, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function existingCtor = getExistingCtor(context, topLevelScope, str);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return existingCtor.construct(context, topLevelScope, objArr);
    }

    public static Scriptable newBuiltinObject(Context context, Scriptable scriptable, TopLevel.Builtins builtins, Object[] objArr) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        Function builtinCtor = TopLevel.getBuiltinCtor(context, topLevelScope, builtins);
        if (objArr == null) {
            objArr = emptyArgs;
        }
        return builtinCtor.construct(context, topLevelScope, objArr);
    }

    public static double toInteger(Object obj) {
        return toInteger(toNumber(obj));
    }

    public static double toInteger(double d) {
        if (d != d) {
            return 0.0d;
        }
        int i = (d > 0.0d ? 1 : (d == 0.0d ? 0 : -1));
        if (i == 0 || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return d;
        }
        if (i > 0) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    public static double toInteger(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInteger(objArr[i]);
        }
        return 0.0d;
    }

    public static int toInt32(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return toInt32(toNumber(obj));
    }

    public static int toInt32(Object[] objArr, int i) {
        if (i < objArr.length) {
            return toInt32(objArr[i]);
        }
        return 0;
    }

    public static int toInt32(double d) {
        int i = (int) d;
        if (i == d) {
            return i;
        }
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return 0;
        }
        return (int) Math.IEEEremainder(d >= 0.0d ? Math.floor(d) : Math.ceil(d), 4.294967296E9d);
    }

    public static long toUint32(double d) {
        long j = (long) d;
        if (j == d) {
            return j & 4294967295L;
        }
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY) {
            return 0L;
        }
        return ((long) Math.IEEEremainder(d >= 0.0d ? Math.floor(d) : Math.ceil(d), 4.294967296E9d)) & 4294967295L;
    }

    public static long toUint32(Object obj) {
        return toUint32(toNumber(obj));
    }

    public static char toUint16(Object obj) {
        double number = toNumber(obj);
        int i = (int) number;
        if (i == number) {
            return (char) i;
        }
        if (number != number || number == Double.POSITIVE_INFINITY || number == Double.NEGATIVE_INFINITY) {
            return (char) 0;
        }
        return (char) Math.IEEEremainder(number >= 0.0d ? Math.floor(number) : Math.ceil(number), 65536);
    }

    public static Object setDefaultNamespace(Object obj, Context context) {
        Scriptable scriptable = context.currentActivationCall;
        if (scriptable == null) {
            scriptable = getTopCallScope(context);
        }
        Object defaultXmlNamespace = currentXMLLib(context).toDefaultXmlNamespace(context, obj);
        if (!scriptable.has(DEFAULT_NS_TAG, scriptable)) {
            ScriptableObject.defineProperty(scriptable, DEFAULT_NS_TAG, defaultXmlNamespace, 6);
        } else {
            scriptable.put(DEFAULT_NS_TAG, scriptable, defaultXmlNamespace);
        }
        return Undefined.instance;
    }

    public static Object searchDefaultNamespace(Context context) {
        Scriptable scriptable = context.currentActivationCall;
        if (scriptable == null) {
            scriptable = getTopCallScope(context);
        }
        while (true) {
            Scriptable parentScope = scriptable.getParentScope();
            if (parentScope == null) {
                Object property = ScriptableObject.getProperty(scriptable, DEFAULT_NS_TAG);
                if (property == Scriptable.NOT_FOUND) {
                    return null;
                }
                return property;
            }
            Object obj = scriptable.get(DEFAULT_NS_TAG, scriptable);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            scriptable = parentScope;
        }
    }

    public static Object getTopLevelProp(Scriptable scriptable, String str) {
        return ScriptableObject.getProperty(ScriptableObject.getTopLevelScope(scriptable), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Function getExistingCtor(Context context, Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property instanceof Function) {
            return (Function) property;
        }
        if (property == Scriptable.NOT_FOUND) {
            throw Context.reportRuntimeError1("msg.ctor.not.found", str);
        }
        throw Context.reportRuntimeError1("msg.not.ctor", str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
        if (r4 <= (r5 ? 8 : 7)) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long indexFromString(java.lang.String r12) {
        /*
            int r0 = r12.length()
            r1 = -1
            if (r0 <= 0) goto L68
            r3 = 0
            char r4 = r12.charAt(r3)
            r5 = 45
            r6 = 48
            r7 = 1
            if (r4 != r5) goto L20
            if (r0 <= r7) goto L20
            char r4 = r12.charAt(r7)
            if (r4 != r6) goto L1d
            return r1
        L1d:
            r5 = 1
            r8 = 1
            goto L22
        L20:
            r5 = 0
            r8 = 0
        L22:
            int r4 = r4 + (-48)
            if (r4 < 0) goto L68
            r9 = 9
            if (r4 > r9) goto L68
            if (r5 == 0) goto L2f
            r10 = 11
            goto L31
        L2f:
            r10 = 10
        L31:
            if (r0 > r10) goto L68
            int r10 = -r4
            int r8 = r8 + r7
            if (r10 == 0) goto L4b
        L37:
            if (r8 == r0) goto L4b
            char r4 = r12.charAt(r8)
            int r4 = r4 - r6
            if (r4 < 0) goto L4b
            if (r4 > r9) goto L4b
            int r3 = r10 * 10
            int r3 = r3 - r4
            int r8 = r8 + 1
            r11 = r10
            r10 = r3
            r3 = r11
            goto L37
        L4b:
            if (r8 != r0) goto L68
            r12 = -214748364(0xfffffffff3333334, float:-1.4197688E31)
            if (r3 > r12) goto L5c
            if (r3 != r12) goto L68
            if (r5 == 0) goto L59
            r12 = 8
            goto L5a
        L59:
            r12 = 7
        L5a:
            if (r4 > r12) goto L68
        L5c:
            r0 = 4294967295(0xffffffff, double:2.1219957905E-314)
            if (r5 == 0) goto L64
            goto L65
        L64:
            int r10 = -r10
        L65:
            long r2 = (long) r10
            long r0 = r0 & r2
            return r0
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.indexFromString(java.lang.String):long");
    }

    public static long testUint32String(String str) {
        int length = str.length();
        if (1 <= length && length <= 10) {
            int charAt = str.charAt(0) - '0';
            if (charAt == 0) {
                return length == 1 ? 0L : -1L;
            } else if (1 <= charAt && charAt <= 9) {
                long j = charAt;
                for (int i = 1; i != length; i++) {
                    int charAt2 = str.charAt(i) - '0';
                    if (charAt2 < 0 || charAt2 > 9) {
                        return -1L;
                    }
                    j = (j * 10) + charAt2;
                }
                if ((j >>> 32) == 0) {
                    return j;
                }
            }
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getIndexObject(String str) {
        long indexFromString = indexFromString(str);
        return indexFromString >= 0 ? Integer.valueOf((int) indexFromString) : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getIndexObject(double d) {
        int i = (int) d;
        if (i == d) {
            return Integer.valueOf(i);
        }
        return toString(d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toStringIdOrIndex(Context context, Object obj) {
        String scriptRuntime;
        if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            int i = (int) doubleValue;
            if (i == doubleValue) {
                storeIndexResult(context, i);
                return null;
            }
            return toString(obj);
        }
        if (obj instanceof String) {
            scriptRuntime = (String) obj;
        } else {
            scriptRuntime = toString(obj);
        }
        long indexFromString = indexFromString(scriptRuntime);
        if (indexFromString >= 0) {
            storeIndexResult(context, (int) indexFromString);
            return null;
        }
        return scriptRuntime;
    }

    public static Object getObjectElem(Object obj, Object obj2, Context context) {
        return getObjectElem(obj, obj2, context, getTopCallScope(context));
    }

    public static Object getObjectElem(Object obj, Object obj2, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, obj2);
        }
        return getObjectElem(objectOrNull, obj2, context);
    }

    public static Object getObjectElem(Scriptable scriptable, Object obj, Context context) {
        Object property;
        if (scriptable instanceof XMLObject) {
            property = ((XMLObject) scriptable).get(context, obj);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj);
            if (stringIdOrIndex == null) {
                property = ScriptableObject.getProperty(scriptable, lastIndexResult(context));
            } else {
                property = ScriptableObject.getProperty(scriptable, stringIdOrIndex);
            }
        }
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object getObjectProp(Object obj, String str, Context context) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        return getObjectProp(objectOrNull, str, context);
    }

    public static Object getObjectProp(Object obj, String str, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj, scriptable);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        return getObjectProp(objectOrNull, str, context);
    }

    public static Object getObjectProp(Scriptable scriptable, String str, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            if (context.hasFeature(11)) {
                Context.reportWarning(getMessage1("msg.ref.undefined.prop", str));
            }
            return Undefined.instance;
        }
        return property;
    }

    public static Object getObjectPropNoWarn(Object obj, String str, Context context) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Object property = ScriptableObject.getProperty(objectOrNull, str);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object getObjectIndex(Object obj, double d, Context context) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull != null) {
            int i = (int) d;
            if (i == d) {
                return getObjectIndex(objectOrNull, i, context);
            }
            return getObjectProp(objectOrNull, toString(d), context);
        }
        throw undefReadError(obj, toString(d));
    }

    public static Object getObjectIndex(Scriptable scriptable, int i, Context context) {
        Object property = ScriptableObject.getProperty(scriptable, i);
        return property == Scriptable.NOT_FOUND ? Undefined.instance : property;
    }

    public static Object setObjectElem(Object obj, Object obj2, Object obj3, Context context) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw undefWriteError(obj, obj2, obj3);
        }
        return setObjectElem(objectOrNull, obj2, obj3, context);
    }

    public static Object setObjectElem(Scriptable scriptable, Object obj, Object obj2, Context context) {
        if (scriptable instanceof XMLObject) {
            ((XMLObject) scriptable).put(context, obj, obj2);
        } else {
            String stringIdOrIndex = toStringIdOrIndex(context, obj);
            if (stringIdOrIndex == null) {
                ScriptableObject.putProperty(scriptable, lastIndexResult(context), obj2);
            } else {
                ScriptableObject.putProperty(scriptable, stringIdOrIndex, obj2);
            }
        }
        return obj2;
    }

    public static Object setObjectProp(Object obj, String str, Object obj2, Context context) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw undefWriteError(obj, str, obj2);
        }
        return setObjectProp(objectOrNull, str, obj2, context);
    }

    public static Object setObjectProp(Scriptable scriptable, String str, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, str, obj);
        return obj;
    }

    public static Object setObjectIndex(Object obj, double d, Object obj2, Context context) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull != null) {
            int i = (int) d;
            if (i == d) {
                return setObjectIndex(objectOrNull, i, obj2, context);
            }
            return setObjectProp(objectOrNull, toString(d), obj2, context);
        }
        throw undefWriteError(obj, String.valueOf(d), obj2);
    }

    public static Object setObjectIndex(Scriptable scriptable, int i, Object obj, Context context) {
        ScriptableObject.putProperty(scriptable, i, obj);
        return obj;
    }

    public static boolean deleteObjectElem(Scriptable scriptable, Object obj, Context context) {
        String stringIdOrIndex = toStringIdOrIndex(context, obj);
        if (stringIdOrIndex == null) {
            int lastIndexResult = lastIndexResult(context);
            scriptable.delete(lastIndexResult);
            return !scriptable.has(lastIndexResult, scriptable);
        }
        scriptable.delete(stringIdOrIndex);
        return !scriptable.has(stringIdOrIndex, scriptable);
    }

    public static boolean hasObjectElem(Scriptable scriptable, Object obj, Context context) {
        String stringIdOrIndex = toStringIdOrIndex(context, obj);
        if (stringIdOrIndex == null) {
            return ScriptableObject.hasProperty(scriptable, lastIndexResult(context));
        }
        return ScriptableObject.hasProperty(scriptable, stringIdOrIndex);
    }

    public static Object refGet(Ref ref, Context context) {
        return ref.get(context);
    }

    public static Object refSet(Ref ref, Object obj, Context context) {
        return ref.set(context, obj);
    }

    public static Object refDel(Ref ref, Context context) {
        return wrapBoolean(ref.delete(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSpecialProperty(String str) {
        return str.equals("__proto__") || str.equals("__parent__");
    }

    public static Ref specialRef(Object obj, String str, Context context) {
        return SpecialRef.createSpecial(context, obj, str);
    }

    public static Object delete(Object obj, Object obj2, Context context) {
        return delete(obj, obj2, context, false);
    }

    public static Object delete(Object obj, Object obj2, Context context, boolean z) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            if (z) {
                return Boolean.TRUE;
            }
            throw typeError2("msg.undef.prop.delete", toString(obj), obj2 == null ? "null" : obj2.toString());
        }
        return wrapBoolean(deleteObjectElem(objectOrNull, obj2, context));
    }

    public static Object name(Context context, Scriptable scriptable, String str) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope == null) {
            Object obj = topScopeName(context, scriptable, str);
            if (obj != Scriptable.NOT_FOUND) {
                return obj;
            }
            throw notFoundError(scriptable, str);
        }
        return nameOrFunction(context, scriptable, parentScope, str, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        r6 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075 A[LOOP:0: B:3:0x0002->B:42:0x0075, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x004e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object nameOrFunction(org.mozilla.javascript.Context r5, org.mozilla.javascript.Scriptable r6, org.mozilla.javascript.Scriptable r7, java.lang.String r8, boolean r9) {
        /*
            r0 = 0
            r1 = r6
        L2:
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeWith
            if (r2 == 0) goto L28
            org.mozilla.javascript.Scriptable r1 = r1.getPrototype()
            boolean r2 = r1 instanceof org.mozilla.javascript.xml.XMLObject
            if (r2 == 0) goto L1f
            org.mozilla.javascript.xml.XMLObject r1 = (org.mozilla.javascript.xml.XMLObject) r1
            boolean r2 = r1.has(r8, r1)
            if (r2 == 0) goto L1b
            java.lang.Object r6 = r1.get(r8, r1)
            goto L65
        L1b:
            if (r0 != 0) goto L48
            r0 = r1
            goto L48
        L1f:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r1, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r3) goto L48
            goto L46
        L28:
            boolean r2 = r1 instanceof org.mozilla.javascript.NativeCall
            if (r2 == 0) goto L3e
            java.lang.Object r1 = r1.get(r8, r1)
            java.lang.Object r2 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r1 == r2) goto L48
            if (r9 == 0) goto L3a
            org.mozilla.javascript.Scriptable r6 = org.mozilla.javascript.ScriptableObject.getTopLevelScope(r7)
        L3a:
            r4 = r1
            r1 = r6
            r6 = r4
            goto L65
        L3e:
            java.lang.Object r2 = org.mozilla.javascript.ScriptableObject.getProperty(r1, r8)
            java.lang.Object r3 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r2 == r3) goto L48
        L46:
            r6 = r2
            goto L65
        L48:
            org.mozilla.javascript.Scriptable r1 = r7.getParentScope()
            if (r1 != 0) goto L75
            java.lang.Object r6 = topScopeName(r5, r7, r8)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r6 != r1) goto L64
            if (r0 == 0) goto L5f
            if (r9 != 0) goto L5f
            java.lang.Object r6 = r0.get(r8, r0)
            goto L64
        L5f:
            java.lang.RuntimeException r5 = notFoundError(r7, r8)
            throw r5
        L64:
            r1 = r7
        L65:
            if (r9 == 0) goto L74
            boolean r7 = r6 instanceof org.mozilla.javascript.Callable
            if (r7 == 0) goto L6f
            storeScriptable(r5, r1)
            goto L74
        L6f:
            java.lang.RuntimeException r5 = notFunctionError(r6, r8)
            throw r5
        L74:
            return r6
        L75:
            r4 = r1
            r1 = r7
            r7 = r4
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.nameOrFunction(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.String, boolean):java.lang.Object");
    }

    private static Object topScopeName(Context context, Scriptable scriptable, String str) {
        if (context.useDynamicScope) {
            scriptable = checkDynamicScope(context.topCallScope, scriptable);
        }
        return ScriptableObject.getProperty(scriptable, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
        r5 = r0;
        r1 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.mozilla.javascript.Scriptable bind(org.mozilla.javascript.Context r4, org.mozilla.javascript.Scriptable r5, java.lang.String r6) {
        /*
            org.mozilla.javascript.Scriptable r0 = r5.getParentScope()
            r1 = 0
            if (r0 == 0) goto L47
            r2 = r1
        L8:
            boolean r1 = r5 instanceof org.mozilla.javascript.NativeWith
            if (r1 == 0) goto L33
            org.mozilla.javascript.Scriptable r5 = r5.getPrototype()
            boolean r1 = r5 instanceof org.mozilla.javascript.xml.XMLObject
            if (r1 == 0) goto L21
            org.mozilla.javascript.xml.XMLObject r5 = (org.mozilla.javascript.xml.XMLObject) r5
            boolean r1 = r5.has(r4, r6)
            if (r1 == 0) goto L1d
            return r5
        L1d:
            if (r2 != 0) goto L28
            r2 = r5
            goto L28
        L21:
            boolean r1 = org.mozilla.javascript.ScriptableObject.hasProperty(r5, r6)
            if (r1 == 0) goto L28
            return r5
        L28:
            org.mozilla.javascript.Scriptable r5 = r0.getParentScope()
            if (r5 != 0) goto L2f
            goto L40
        L2f:
            r3 = r0
            r0 = r5
            r5 = r3
            goto L8
        L33:
            boolean r1 = org.mozilla.javascript.ScriptableObject.hasProperty(r5, r6)
            if (r1 == 0) goto L3a
            return r5
        L3a:
            org.mozilla.javascript.Scriptable r5 = r0.getParentScope()
            if (r5 != 0) goto L43
        L40:
            r5 = r0
            r1 = r2
            goto L47
        L43:
            r3 = r0
            r0 = r5
            r5 = r3
            goto L33
        L47:
            boolean r0 = r4.useDynamicScope
            if (r0 == 0) goto L51
            org.mozilla.javascript.Scriptable r4 = r4.topCallScope
            org.mozilla.javascript.Scriptable r5 = checkDynamicScope(r4, r5)
        L51:
            boolean r4 = org.mozilla.javascript.ScriptableObject.hasProperty(r5, r6)
            if (r4 == 0) goto L58
            return r5
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.bind(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String):org.mozilla.javascript.Scriptable");
    }

    public static Object setName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
        } else {
            if (context.hasFeature(11) || context.hasFeature(8)) {
                Context.reportWarning(getMessage1("msg.assn.create.strict", str));
            }
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable2);
            if (context.useDynamicScope) {
                topLevelScope = checkDynamicScope(context.topCallScope, topLevelScope);
            }
            topLevelScope.put(str, topLevelScope, obj);
        }
        return obj;
    }

    public static Object strictSetName(Scriptable scriptable, Object obj, Context context, Scriptable scriptable2, String str) {
        if (scriptable != null) {
            ScriptableObject.putProperty(scriptable, str, obj);
            return obj;
        }
        throw constructError("ReferenceError", "Assignment to undefined \"" + str + "\" in strict mode");
    }

    public static Object setConst(Scriptable scriptable, Object obj, Context context, String str) {
        if (scriptable instanceof XMLObject) {
            scriptable.put(str, scriptable, obj);
        } else {
            ScriptableObject.putConstProperty(scriptable, str, obj);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class IdEnumeration implements Serializable {
        private static final long serialVersionUID = 1;
        Object currentId;
        boolean enumNumbers;
        int enumType;
        Object[] ids;
        int index;
        Scriptable iterator;
        Scriptable obj;
        ObjToIntMap used;

        private IdEnumeration() {
        }
    }

    public static Scriptable toIterator(Context context, Scriptable scriptable, Scriptable scriptable2, boolean z) {
        if (ScriptableObject.hasProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME)) {
            Object property = ScriptableObject.getProperty(scriptable2, NativeIterator.ITERATOR_PROPERTY_NAME);
            if (!(property instanceof Callable)) {
                throw typeError0("msg.invalid.iterator");
            }
            Callable callable = (Callable) property;
            Object[] objArr = new Object[1];
            objArr[0] = z ? Boolean.TRUE : Boolean.FALSE;
            Object call = callable.call(context, scriptable, scriptable2, objArr);
            if (!(call instanceof Scriptable)) {
                throw typeError0("msg.iterator.primitive");
            }
            return (Scriptable) call;
        }
        return null;
    }

    public static Object enumInit(Object obj, Context context, boolean z) {
        return enumInit(obj, context, z ? 1 : 0);
    }

    public static Object enumInit(Object obj, Context context, int i) {
        IdEnumeration idEnumeration = new IdEnumeration();
        idEnumeration.obj = toObjectOrNull(context, obj);
        if (idEnumeration.obj == null) {
            return idEnumeration;
        }
        idEnumeration.enumType = i;
        idEnumeration.iterator = null;
        if (i != 3 && i != 4 && i != 5) {
            idEnumeration.iterator = toIterator(context, idEnumeration.obj.getParentScope(), idEnumeration.obj, i == 0);
        }
        if (idEnumeration.iterator == null) {
            enumChangeObject(idEnumeration);
        }
        return idEnumeration;
    }

    public static void setEnumNumbers(Object obj, boolean z) {
        ((IdEnumeration) obj).enumNumbers = z;
    }

    public static Boolean enumNext(Object obj) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            Object property = ScriptableObject.getProperty(idEnumeration.iterator, "next");
            if (!(property instanceof Callable)) {
                return Boolean.FALSE;
            }
            try {
                idEnumeration.currentId = ((Callable) property).call(Context.getContext(), idEnumeration.iterator.getParentScope(), idEnumeration.iterator, emptyArgs);
                return Boolean.TRUE;
            } catch (JavaScriptException e) {
                if (e.getValue() instanceof NativeIterator.StopIteration) {
                    return Boolean.FALSE;
                }
                throw e;
            }
        }
        while (idEnumeration.obj != null) {
            if (idEnumeration.index == idEnumeration.ids.length) {
                idEnumeration.obj = idEnumeration.obj.getPrototype();
                enumChangeObject(idEnumeration);
            } else {
                Object[] objArr = idEnumeration.ids;
                int i = idEnumeration.index;
                idEnumeration.index = i + 1;
                Object obj2 = objArr[i];
                if (idEnumeration.used == null || !idEnumeration.used.has(obj2)) {
                    if (obj2 instanceof String) {
                        String str = (String) obj2;
                        if (idEnumeration.obj.has(str, idEnumeration.obj)) {
                            idEnumeration.currentId = str;
                            return Boolean.TRUE;
                        }
                    } else {
                        int intValue = ((Number) obj2).intValue();
                        if (idEnumeration.obj.has(intValue, idEnumeration.obj)) {
                            idEnumeration.currentId = idEnumeration.enumNumbers ? Integer.valueOf(intValue) : String.valueOf(intValue);
                            return Boolean.TRUE;
                        }
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    public static Object enumId(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        if (idEnumeration.iterator != null) {
            return idEnumeration.currentId;
        }
        int i = idEnumeration.enumType;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw Kit.codeBug();
                            }
                        }
                    }
                }
                return context.newArray(ScriptableObject.getTopLevelScope(idEnumeration.obj), new Object[]{idEnumeration.currentId, enumValue(obj, context)});
            }
            return enumValue(obj, context);
        }
        return idEnumeration.currentId;
    }

    public static Object enumValue(Object obj, Context context) {
        IdEnumeration idEnumeration = (IdEnumeration) obj;
        String stringIdOrIndex = toStringIdOrIndex(context, idEnumeration.currentId);
        if (stringIdOrIndex == null) {
            return idEnumeration.obj.get(lastIndexResult(context), idEnumeration.obj);
        }
        return idEnumeration.obj.get(stringIdOrIndex, idEnumeration.obj);
    }

    private static void enumChangeObject(IdEnumeration idEnumeration) {
        Object[] objArr = null;
        while (idEnumeration.obj != null) {
            objArr = idEnumeration.obj.getIds();
            if (objArr.length != 0) {
                break;
            }
            idEnumeration.obj = idEnumeration.obj.getPrototype();
        }
        if (idEnumeration.obj != null && idEnumeration.ids != null) {
            Object[] objArr2 = idEnumeration.ids;
            int length = objArr2.length;
            if (idEnumeration.used == null) {
                idEnumeration.used = new ObjToIntMap(length);
            }
            for (int i = 0; i != length; i++) {
                idEnumeration.used.intern(objArr2[i]);
            }
        }
        idEnumeration.ids = objArr;
        idEnumeration.index = 0;
    }

    public static Callable getNameFunctionAndThis(String str, Context context, Scriptable scriptable) {
        Scriptable parentScope = scriptable.getParentScope();
        if (parentScope == null) {
            Object obj = topScopeName(context, scriptable, str);
            if (!(obj instanceof Callable)) {
                if (obj == Scriptable.NOT_FOUND) {
                    throw notFoundError(scriptable, str);
                }
                throw notFunctionError(obj, str);
            }
            storeScriptable(context, scriptable);
            return (Callable) obj;
        }
        return (Callable) nameOrFunction(context, scriptable, parentScope, str, true);
    }

    public static Callable getElemFunctionAndThis(Object obj, Object obj2, Context context) {
        String stringIdOrIndex = toStringIdOrIndex(context, obj2);
        if (stringIdOrIndex != null) {
            return getPropFunctionAndThis(obj, stringIdOrIndex, context);
        }
        int lastIndexResult = lastIndexResult(context);
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw undefCallError(obj, String.valueOf(lastIndexResult));
        }
        Object property = ScriptableObject.getProperty(objectOrNull, lastIndexResult);
        if (!(property instanceof Callable)) {
            throw notFunctionError(property, obj2);
        }
        storeScriptable(context, objectOrNull);
        return (Callable) property;
    }

    public static Callable getPropFunctionAndThis(Object obj, String str, Context context) {
        return getPropFunctionAndThisHelper(obj, str, context, toObjectOrNull(context, obj));
    }

    public static Callable getPropFunctionAndThis(Object obj, String str, Context context, Scriptable scriptable) {
        return getPropFunctionAndThisHelper(obj, str, context, toObjectOrNull(context, obj, scriptable));
    }

    private static Callable getPropFunctionAndThisHelper(Object obj, String str, Context context, Scriptable scriptable) {
        if (scriptable == null) {
            throw undefCallError(obj, str);
        }
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (!(property instanceof Callable)) {
            Object property2 = ScriptableObject.getProperty(scriptable, "__noSuchMethod__");
            if (property2 instanceof Callable) {
                property = new NoSuchMethodShim((Callable) property2, str);
            }
        }
        if (!(property instanceof Callable)) {
            throw notFunctionError(scriptable, property, str);
        }
        storeScriptable(context, scriptable);
        return (Callable) property;
    }

    public static Callable getValueFunctionAndThis(Object obj, Context context) {
        if (!(obj instanceof Callable)) {
            throw notFunctionError(obj);
        }
        Callable callable = (Callable) obj;
        Scriptable parentScope = callable instanceof Scriptable ? ((Scriptable) callable).getParentScope() : null;
        if (parentScope == null) {
            if (context.topCallScope == null) {
                throw new IllegalStateException();
            }
            parentScope = context.topCallScope;
        }
        if (parentScope.getParentScope() != null && !(parentScope instanceof NativeWith) && (parentScope instanceof NativeCall)) {
            parentScope = ScriptableObject.getTopLevelScope(parentScope);
        }
        storeScriptable(context, parentScope);
        return callable;
    }

    public static Ref callRef(Callable callable, Scriptable scriptable, Object[] objArr, Context context) {
        if (callable instanceof RefCallable) {
            RefCallable refCallable = (RefCallable) callable;
            Ref refCall = refCallable.refCall(context, scriptable, objArr);
            if (refCall != null) {
                return refCall;
            }
            throw new IllegalStateException(refCallable.getClass().getName() + ".refCall() returned null");
        }
        throw constructError("ReferenceError", getMessage1("msg.no.ref.from.function", toString(callable)));
    }

    public static Scriptable newObject(Object obj, Context context, Scriptable scriptable, Object[] objArr) {
        if (!(obj instanceof Function)) {
            throw notFunctionError(obj);
        }
        return ((Function) obj).construct(context, scriptable, objArr);
    }

    public static Object callSpecial(Context context, Callable callable, Scriptable scriptable, Object[] objArr, Scriptable scriptable2, Scriptable scriptable3, int i, String str, int i2) {
        if (i == 1) {
            if (scriptable.getParentScope() == null && NativeGlobal.isEvalFunction(callable)) {
                return evalSpecial(context, scriptable2, scriptable3, objArr, str, i2);
            }
        } else if (i == 2) {
            if (NativeWith.isWithFunction(callable)) {
                throw Context.reportRuntimeError1("msg.only.from.new", "With");
            }
        } else {
            throw Kit.codeBug();
        }
        return callable.call(context, scriptable2, scriptable, objArr);
    }

    public static Object newSpecial(Context context, Object obj, Object[] objArr, Scriptable scriptable, int i) {
        if (i == 1) {
            if (NativeGlobal.isEvalFunction(obj)) {
                throw typeError1("msg.not.ctor", "eval");
            }
        } else if (i == 2) {
            if (NativeWith.isWithFunction(obj)) {
                return NativeWith.newWithSpecial(context, scriptable, objArr);
            }
        } else {
            throw Kit.codeBug();
        }
        return newObject(obj, context, scriptable, objArr);
    }

    public static Object applyOrCall(boolean z, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object[] objArr2;
        int length = objArr.length;
        Callable callable = getCallable(scriptable2);
        Scriptable objectOrNull = length != 0 ? toObjectOrNull(context, objArr[0]) : null;
        if (objectOrNull == null) {
            objectOrNull = getTopCallScope(context);
        }
        if (z) {
            objArr2 = length <= 1 ? emptyArgs : getApplyArguments(context, objArr[1]);
        } else if (length <= 1) {
            objArr2 = emptyArgs;
        } else {
            int i = length - 1;
            objArr2 = new Object[i];
            System.arraycopy(objArr, 1, objArr2, 0, i);
        }
        return callable.call(context, scriptable, objectOrNull, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] getApplyArguments(Context context, Object obj) {
        if (obj == null || obj == Undefined.instance) {
            return emptyArgs;
        }
        if ((obj instanceof NativeArray) || (obj instanceof Arguments)) {
            return context.getElements((Scriptable) obj);
        }
        throw typeError0("msg.arg.isnt.array");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable getCallable(Scriptable scriptable) {
        if (scriptable instanceof Callable) {
            return (Callable) scriptable;
        }
        Object defaultValue = scriptable.getDefaultValue(FunctionClass);
        if (!(defaultValue instanceof Callable)) {
            throw notFunctionError(defaultValue, scriptable);
        }
        return (Callable) defaultValue;
    }

    public static Object evalSpecial(Context context, Scriptable scriptable, Object obj, Object[] objArr, String str, int i) {
        if (objArr.length < 1) {
            return Undefined.instance;
        }
        Object obj2 = objArr[0];
        if (!(obj2 instanceof CharSequence)) {
            if (context.hasFeature(11) || context.hasFeature(9)) {
                throw Context.reportRuntimeError0("msg.eval.nonstring.strict");
            }
            Context.reportWarning(getMessage0("msg.eval.nonstring"));
            return obj2;
        }
        if (str == null) {
            int[] iArr = new int[1];
            String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
            if (sourcePositionFromStack != null) {
                i = iArr[0];
                str = sourcePositionFromStack;
            } else {
                str = "";
            }
        }
        String makeUrlForGeneratedScript = makeUrlForGeneratedScript(true, str, i);
        ErrorReporter forEval = DefaultErrorReporter.forEval(context.getErrorReporter());
        Evaluator createInterpreter = Context.createInterpreter();
        if (createInterpreter == null) {
            throw new JavaScriptException("Interpreter not present", str, i);
        }
        Script compileString = context.compileString(obj2.toString(), createInterpreter, forEval, makeUrlForGeneratedScript, 1, null);
        createInterpreter.setEvalScriptFlag(compileString);
        return ((Callable) compileString).call(context, scriptable, (Scriptable) obj, emptyArgs);
    }

    public static String typeof(Object obj) {
        if (obj == null) {
            return "object";
        }
        if (obj == Undefined.instance) {
            return "undefined";
        }
        if (obj instanceof ScriptableObject) {
            return ((ScriptableObject) obj).getTypeOf();
        }
        if (obj instanceof Scriptable) {
            return obj instanceof Callable ? "function" : "object";
        } else if (obj instanceof CharSequence) {
            return TypedValues.Custom.S_STRING;
        } else {
            if (obj instanceof Number) {
                return "number";
            }
            if (obj instanceof Boolean) {
                return TypedValues.Custom.S_BOOLEAN;
            }
            throw errorWithClassName("msg.invalid.type", obj);
        }
    }

    public static String typeofName(Scriptable scriptable, String str) {
        Context context = Context.getContext();
        Scriptable bind = bind(context, scriptable, str);
        return bind == null ? "undefined" : typeof(getObjectProp(bind, str, context));
    }

    public static Object add(Object obj, Object obj2, Context context) {
        Object addValues;
        Object addValues2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return wrapNumber(((Number) obj).doubleValue() + ((Number) obj2).doubleValue());
        }
        if (!(obj instanceof XMLObject) || (addValues2 = ((XMLObject) obj).addValues(context, true, obj2)) == Scriptable.NOT_FOUND) {
            if (!(obj2 instanceof XMLObject) || (addValues = ((XMLObject) obj2).addValues(context, false, obj)) == Scriptable.NOT_FOUND) {
                if (obj instanceof Scriptable) {
                    obj = ((Scriptable) obj).getDefaultValue(null);
                }
                if (obj2 instanceof Scriptable) {
                    obj2 = ((Scriptable) obj2).getDefaultValue(null);
                }
                if (!(obj instanceof CharSequence) && !(obj2 instanceof CharSequence)) {
                    if ((obj instanceof Number) && (obj2 instanceof Number)) {
                        return wrapNumber(((Number) obj).doubleValue() + ((Number) obj2).doubleValue());
                    }
                    return wrapNumber(toNumber(obj) + toNumber(obj2));
                }
                return new ConsString(toCharSequence(obj), toCharSequence(obj2));
            }
            return addValues;
        }
        return addValues2;
    }

    public static CharSequence add(CharSequence charSequence, Object obj) {
        return new ConsString(charSequence, toCharSequence(obj));
    }

    public static CharSequence add(Object obj, CharSequence charSequence) {
        return new ConsString(toCharSequence(obj), charSequence);
    }

    public static Object nameIncrDecr(Scriptable scriptable, String str, int i) {
        return nameIncrDecr(scriptable, str, Context.getContext(), i);
    }

    public static Object nameIncrDecr(Scriptable scriptable, String str, Context context, int i) {
        do {
            if (context.useDynamicScope && scriptable.getParentScope() == null) {
                scriptable = checkDynamicScope(context.topCallScope, scriptable);
            }
            Scriptable scriptable2 = scriptable;
            do {
                if ((scriptable2 instanceof NativeWith) && (scriptable2.getPrototype() instanceof XMLObject)) {
                    break;
                }
                Object obj = scriptable2.get(str, scriptable);
                if (obj == Scriptable.NOT_FOUND) {
                    scriptable2 = scriptable2.getPrototype();
                } else {
                    return doScriptableIncrDecr(scriptable2, str, scriptable, obj, i);
                }
            } while (scriptable2 != null);
            scriptable = scriptable.getParentScope();
        } while (scriptable != null);
        throw notFoundError(scriptable, str);
    }

    public static Object propIncrDecr(Object obj, String str, Context context, int i) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw undefReadError(obj, str);
        }
        Scriptable scriptable = objectOrNull;
        do {
            Object obj2 = scriptable.get(str, objectOrNull);
            if (obj2 == Scriptable.NOT_FOUND) {
                scriptable = scriptable.getPrototype();
            } else {
                return doScriptableIncrDecr(scriptable, str, objectOrNull, obj2, i);
            }
        } while (scriptable != null);
        Double d = NaNobj;
        objectOrNull.put(str, objectOrNull, d);
        return d;
    }

    private static Object doScriptableIncrDecr(Scriptable scriptable, String str, Scriptable scriptable2, Object obj, int i) {
        double number;
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number wrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        scriptable.put(str, scriptable2, wrapNumber);
        return z ? obj : wrapNumber;
    }

    public static Object elemIncrDecr(Object obj, Object obj2, Context context, int i) {
        double number;
        Object objectElem = getObjectElem(obj, obj2, context);
        boolean z = (i & 2) != 0;
        if (objectElem instanceof Number) {
            number = ((Number) objectElem).doubleValue();
        } else {
            number = toNumber(objectElem);
            if (z) {
                objectElem = wrapNumber(number);
            }
        }
        Number wrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        setObjectElem(obj, obj2, wrapNumber, context);
        return z ? objectElem : wrapNumber;
    }

    public static Object refIncrDecr(Ref ref, Context context, int i) {
        double number;
        Object obj = ref.get(context);
        boolean z = (i & 2) != 0;
        if (obj instanceof Number) {
            number = ((Number) obj).doubleValue();
        } else {
            number = toNumber(obj);
            if (z) {
                obj = wrapNumber(number);
            }
        }
        Number wrapNumber = wrapNumber((i & 1) == 0 ? number + 1.0d : number - 1.0d);
        ref.set(context, wrapNumber);
        return z ? obj : wrapNumber;
    }

    public static Object toPrimitive(Object obj) {
        return toPrimitive(obj, null);
    }

    public static Object toPrimitive(Object obj, Class<?> cls) {
        if (obj instanceof Scriptable) {
            Object defaultValue = ((Scriptable) obj).getDefaultValue(cls);
            if (defaultValue instanceof Scriptable) {
                throw typeError0("msg.bad.default.value");
            }
            return defaultValue;
        }
        return obj;
    }

    /* renamed from: eq */
    public static boolean m48eq(Object obj, Object obj2) {
        Object equivalentValues;
        Object equivalentValues2;
        Object equivalentValues3;
        Object equivalentValues4;
        Object equivalentValues5;
        if (obj == null || obj == Undefined.instance) {
            if (obj2 == null || obj2 == Undefined.instance) {
                return true;
            }
            if (!(obj2 instanceof ScriptableObject) || (equivalentValues = ((ScriptableObject) obj2).equivalentValues(obj)) == Scriptable.NOT_FOUND) {
                return false;
            }
            return ((Boolean) equivalentValues).booleanValue();
        } else if (obj instanceof Number) {
            return eqNumber(((Number) obj).doubleValue(), obj2);
        } else {
            if (obj == obj2) {
                return true;
            }
            if (obj instanceof CharSequence) {
                return eqString((CharSequence) obj, obj2);
            }
            if (obj instanceof Boolean) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                if (obj2 instanceof Boolean) {
                    return booleanValue == ((Boolean) obj2).booleanValue();
                } else if ((obj2 instanceof ScriptableObject) && (equivalentValues5 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                    return ((Boolean) equivalentValues5).booleanValue();
                } else {
                    return eqNumber(booleanValue ? 1.0d : 0.0d, obj2);
                }
            } else if (obj instanceof Scriptable) {
                if (obj2 instanceof Scriptable) {
                    if ((obj instanceof ScriptableObject) && (equivalentValues4 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
                        return ((Boolean) equivalentValues4).booleanValue();
                    }
                    if ((obj2 instanceof ScriptableObject) && (equivalentValues3 = ((ScriptableObject) obj2).equivalentValues(obj)) != Scriptable.NOT_FOUND) {
                        return ((Boolean) equivalentValues3).booleanValue();
                    }
                    if ((obj instanceof Wrapper) && (obj2 instanceof Wrapper)) {
                        Object unwrap = ((Wrapper) obj).unwrap();
                        Object unwrap2 = ((Wrapper) obj2).unwrap();
                        if (unwrap != unwrap2) {
                            return isPrimitive(unwrap) && isPrimitive(unwrap2) && m48eq(unwrap, unwrap2);
                        }
                        return true;
                    }
                    return false;
                } else if (obj2 instanceof Boolean) {
                    if ((obj instanceof ScriptableObject) && (equivalentValues2 = ((ScriptableObject) obj).equivalentValues(obj2)) != Scriptable.NOT_FOUND) {
                        return ((Boolean) equivalentValues2).booleanValue();
                    }
                    return eqNumber(((Boolean) obj2).booleanValue() ? 1.0d : 0.0d, obj);
                } else if (obj2 instanceof Number) {
                    return eqNumber(((Number) obj2).doubleValue(), obj);
                } else {
                    if (obj2 instanceof CharSequence) {
                        return eqString((CharSequence) obj2, obj);
                    }
                    return false;
                }
            } else {
                warnAboutNonJSObject(obj);
                return obj == obj2;
            }
        }
    }

    public static boolean isPrimitive(Object obj) {
        return obj == null || obj == Undefined.instance || (obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean eqNumber(double r5, java.lang.Object r7) {
        /*
        L0:
            r0 = 0
            if (r7 == 0) goto L64
            java.lang.Object r1 = org.mozilla.javascript.Undefined.instance
            if (r7 != r1) goto L8
            goto L64
        L8:
            boolean r1 = r7 instanceof java.lang.Number
            r2 = 1
            if (r1 == 0) goto L19
            java.lang.Number r7 = (java.lang.Number) r7
            double r3 = r7.doubleValue()
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L18
            r0 = 1
        L18:
            return r0
        L19:
            boolean r1 = r7 instanceof java.lang.CharSequence
            if (r1 == 0) goto L27
            double r3 = toNumber(r7)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L26
            r0 = 1
        L26:
            return r0
        L27:
            boolean r1 = r7 instanceof java.lang.Boolean
            if (r1 == 0) goto L3e
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L36
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L38
        L36:
            r3 = 0
        L38:
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L3d
            r0 = 1
        L3d:
            return r0
        L3e:
            boolean r1 = r7 instanceof org.mozilla.javascript.Scriptable
            if (r1 == 0) goto L61
            boolean r0 = r7 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 == 0) goto L5c
            java.lang.Number r0 = wrapNumber(r5)
            r1 = r7
            org.mozilla.javascript.ScriptableObject r1 = (org.mozilla.javascript.ScriptableObject) r1
            java.lang.Object r0 = r1.equivalentValues(r0)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r0 == r1) goto L5c
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            return r5
        L5c:
            java.lang.Object r7 = toPrimitive(r7)
            goto L0
        L61:
            warnAboutNonJSObject(r7)
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.eqNumber(double, java.lang.Object):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0088, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean eqString(java.lang.CharSequence r5, java.lang.Object r6) {
        /*
        L0:
            r0 = 0
            if (r6 == 0) goto L88
            java.lang.Object r1 = org.mozilla.javascript.Undefined.instance
            if (r6 != r1) goto L9
            goto L88
        L9:
            boolean r1 = r6 instanceof java.lang.CharSequence
            r2 = 1
            if (r1 == 0) goto L2a
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r1 = r5.length()
            int r3 = r6.length()
            if (r1 != r3) goto L29
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = r6.toString()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L29
            r0 = 1
        L29:
            return r0
        L2a:
            boolean r1 = r6 instanceof java.lang.Number
            if (r1 == 0) goto L42
            java.lang.String r5 = r5.toString()
            double r3 = toNumber(r5)
            java.lang.Number r6 = (java.lang.Number) r6
            double r5 = r6.doubleValue()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L41
            r0 = 1
        L41:
            return r0
        L42:
            boolean r1 = r6 instanceof java.lang.Boolean
            if (r1 == 0) goto L61
            java.lang.String r5 = r5.toString()
            double r3 = toNumber(r5)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 == 0) goto L59
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L5b
        L59:
            r5 = 0
        L5b:
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L60
            r0 = 1
        L60:
            return r0
        L61:
            boolean r1 = r6 instanceof org.mozilla.javascript.Scriptable
            if (r1 == 0) goto L85
            boolean r0 = r6 instanceof org.mozilla.javascript.ScriptableObject
            if (r0 == 0) goto L7f
            r0 = r6
            org.mozilla.javascript.ScriptableObject r0 = (org.mozilla.javascript.ScriptableObject) r0
            java.lang.String r1 = r5.toString()
            java.lang.Object r0 = r0.equivalentValues(r1)
            java.lang.Object r1 = org.mozilla.javascript.Scriptable.NOT_FOUND
            if (r0 == r1) goto L7f
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r5 = r0.booleanValue()
            return r5
        L7f:
            java.lang.Object r6 = toPrimitive(r6)
            goto L0
        L85:
            warnAboutNonJSObject(r6)
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.eqString(java.lang.CharSequence, java.lang.Object):boolean");
    }

    public static boolean shallowEq(Object obj, Object obj2) {
        if (obj == obj2) {
            if (obj instanceof Number) {
                double doubleValue = ((Number) obj).doubleValue();
                return doubleValue == doubleValue;
            }
            return true;
        } else if (obj == null || obj == Undefined.instance) {
            return false;
        } else {
            if (obj instanceof Number) {
                return (obj2 instanceof Number) && ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
            } else if (obj instanceof CharSequence) {
                if (obj2 instanceof CharSequence) {
                    return obj.toString().equals(obj2.toString());
                }
            } else if (obj instanceof Boolean) {
                if (obj2 instanceof Boolean) {
                    return obj.equals(obj2);
                }
            } else if (obj instanceof Scriptable) {
                return (obj instanceof Wrapper) && (obj2 instanceof Wrapper) && ((Wrapper) obj).unwrap() == ((Wrapper) obj2).unwrap();
            } else {
                warnAboutNonJSObject(obj);
                return obj == obj2;
            }
            return false;
        }
    }

    public static boolean instanceOf(Object obj, Object obj2, Context context) {
        if (!(obj2 instanceof Scriptable)) {
            throw typeError0("msg.instanceof.not.object");
        }
        if (obj instanceof Scriptable) {
            return ((Scriptable) obj2).hasInstance((Scriptable) obj);
        }
        return false;
    }

    public static boolean jsDelegatesTo(Scriptable scriptable, Scriptable scriptable2) {
        for (Scriptable prototype = scriptable.getPrototype(); prototype != null; prototype = prototype.getPrototype()) {
            if (prototype.equals(scriptable2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: in */
    public static boolean m47in(Object obj, Object obj2, Context context) {
        if (!(obj2 instanceof Scriptable)) {
            throw typeError0("msg.in.not.object");
        }
        return hasObjectElem((Scriptable) obj2, obj, context);
    }

    public static boolean cmp_LT(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) < 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number < number2;
    }

    public static boolean cmp_LE(Object obj, Object obj2) {
        double number;
        double number2;
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            number = ((Number) obj).doubleValue();
            number2 = ((Number) obj2).doubleValue();
        } else {
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(NumberClass);
            }
            if (obj2 instanceof Scriptable) {
                obj2 = ((Scriptable) obj2).getDefaultValue(NumberClass);
            }
            if ((obj instanceof CharSequence) && (obj2 instanceof CharSequence)) {
                return obj.toString().compareTo(obj2.toString()) <= 0;
            }
            number = toNumber(obj);
            number2 = toNumber(obj2);
        }
        return number <= number2;
    }

    public static ScriptableObject getGlobal(Context context) {
        Class<?> classOrNull = Kit.classOrNull("org.mozilla.javascript.tools.shell.Global");
        if (classOrNull != null) {
            try {
                return (ScriptableObject) classOrNull.getConstructor(ContextClass).newInstance(context);
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
        return new ImporterTopLevel(context);
    }

    public static boolean hasTopCall(Context context) {
        return context.topCallScope != null;
    }

    public static Scriptable getTopCallScope(Context context) {
        Scriptable scriptable = context.topCallScope;
        if (scriptable != null) {
            return scriptable;
        }
        throw new IllegalStateException();
    }

    public static Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (scriptable == null) {
            throw new IllegalArgumentException();
        }
        if (context.topCallScope != null) {
            throw new IllegalStateException();
        }
        context.topCallScope = ScriptableObject.getTopLevelScope(scriptable);
        context.useDynamicScope = context.hasFeature(7);
        try {
            Object doTopCall = context.getFactory().doTopCall(callable, context, scriptable, scriptable2, objArr);
            context.topCallScope = null;
            context.cachedXMLLib = null;
            if (context.currentActivationCall == null) {
                return doTopCall;
            }
            throw new IllegalStateException();
        } catch (Throwable th) {
            context.topCallScope = null;
            context.cachedXMLLib = null;
            if (context.currentActivationCall != null) {
                throw new IllegalStateException();
            }
            throw th;
        }
    }

    static Scriptable checkDynamicScope(Scriptable scriptable, Scriptable scriptable2) {
        if (scriptable == scriptable2) {
            return scriptable;
        }
        Scriptable scriptable3 = scriptable;
        do {
            scriptable3 = scriptable3.getPrototype();
            if (scriptable3 == scriptable2) {
                return scriptable;
            }
        } while (scriptable3 != null);
        return scriptable2;
    }

    public static void addInstructionCount(Context context, int i) {
        context.instructionCount += i;
        if (context.instructionCount > context.instructionThreshold) {
            context.observeInstructionCount(context.instructionCount);
            context.instructionCount = 0;
        }
    }

    public static void initScript(NativeFunction nativeFunction, Scriptable scriptable, Context context, Scriptable scriptable2, boolean z) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        int paramAndVarCount = nativeFunction.getParamAndVarCount();
        if (paramAndVarCount == 0) {
            return;
        }
        Scriptable scriptable3 = scriptable2;
        while (scriptable3 instanceof NativeWith) {
            scriptable3 = scriptable3.getParentScope();
        }
        while (true) {
            int i = paramAndVarCount - 1;
            if (paramAndVarCount == 0) {
                return;
            }
            String paramOrVarName = nativeFunction.getParamOrVarName(i);
            boolean paramOrVarConst = nativeFunction.getParamOrVarConst(i);
            if (ScriptableObject.hasProperty(scriptable2, paramOrVarName)) {
                ScriptableObject.redefineProperty(scriptable2, paramOrVarName, paramOrVarConst);
            } else if (z) {
                scriptable3.put(paramOrVarName, scriptable3, Undefined.instance);
            } else if (paramOrVarConst) {
                ScriptableObject.defineConstProperty(scriptable3, paramOrVarName);
            } else {
                ScriptableObject.defineProperty(scriptable3, paramOrVarName, Undefined.instance, 4);
            }
            paramAndVarCount = i;
        }
    }

    public static Scriptable createFunctionActivation(NativeFunction nativeFunction, Scriptable scriptable, Object[] objArr) {
        return new NativeCall(nativeFunction, scriptable, objArr);
    }

    public static void enterActivationFunction(Context context, Scriptable scriptable) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        NativeCall nativeCall = (NativeCall) scriptable;
        nativeCall.parentActivationCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall;
    }

    public static void exitActivationFunction(Context context) {
        NativeCall nativeCall = context.currentActivationCall;
        context.currentActivationCall = nativeCall.parentActivationCall;
        nativeCall.parentActivationCall = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeCall findFunctionActivation(Context context, Function function) {
        for (NativeCall nativeCall = context.currentActivationCall; nativeCall != null; nativeCall = nativeCall.parentActivationCall) {
            if (nativeCall.function == function) {
                return nativeCall;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.mozilla.javascript.Scriptable newCatchScope(java.lang.Throwable r11, org.mozilla.javascript.Scriptable r12, java.lang.String r13, org.mozilla.javascript.Context r14, org.mozilla.javascript.Scriptable r15) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.ScriptRuntime.newCatchScope(java.lang.Throwable, org.mozilla.javascript.Scriptable, java.lang.String, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable):org.mozilla.javascript.Scriptable");
    }

    private static boolean isVisible(Context context, Object obj) {
        ClassShutter classShutter = context.getClassShutter();
        return classShutter == null || classShutter.visibleToScripts(obj.getClass().getName());
    }

    public static Scriptable enterWith(Object obj, Context context, Scriptable scriptable) {
        Scriptable objectOrNull = toObjectOrNull(context, obj);
        if (objectOrNull == null) {
            throw typeError1("msg.undef.with", toString(obj));
        }
        if (objectOrNull instanceof XMLObject) {
            return ((XMLObject) objectOrNull).enterWith(scriptable);
        }
        return new NativeWith(scriptable, objectOrNull);
    }

    public static Scriptable leaveWith(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static Scriptable enterDotQuery(Object obj, Scriptable scriptable) {
        if (!(obj instanceof XMLObject)) {
            throw notXmlError(obj);
        }
        return ((XMLObject) obj).enterDotQuery(scriptable);
    }

    public static Object updateDotQuery(boolean z, Scriptable scriptable) {
        return ((NativeWith) scriptable).updateDotQuery(z);
    }

    public static Scriptable leaveDotQuery(Scriptable scriptable) {
        return ((NativeWith) scriptable).getParentScope();
    }

    public static void setFunctionProtoAndParent(BaseFunction baseFunction, Scriptable scriptable) {
        baseFunction.setParentScope(scriptable);
        baseFunction.setPrototype(ScriptableObject.getFunctionPrototype(scriptable));
    }

    public static void setObjectProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(ScriptableObject.getClassPrototype(topLevelScope, scriptableObject.getClassName()));
    }

    public static void setBuiltinProtoAndParent(ScriptableObject scriptableObject, Scriptable scriptable, TopLevel.Builtins builtins) {
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        scriptableObject.setParentScope(topLevelScope);
        scriptableObject.setPrototype(TopLevel.getBuiltinPrototype(topLevelScope, builtins));
    }

    public static void initFunction(Context context, Scriptable scriptable, NativeFunction nativeFunction, int i, boolean z) {
        if (i == 1) {
            String functionName = nativeFunction.getFunctionName();
            if (functionName == null || functionName.length() == 0) {
                return;
            }
            if (!z) {
                ScriptableObject.defineProperty(scriptable, functionName, nativeFunction, 4);
            } else {
                scriptable.put(functionName, scriptable, nativeFunction);
            }
        } else if (i == 3) {
            String functionName2 = nativeFunction.getFunctionName();
            if (functionName2 == null || functionName2.length() == 0) {
                return;
            }
            while (scriptable instanceof NativeWith) {
                scriptable = scriptable.getParentScope();
            }
            scriptable.put(functionName2, scriptable, nativeFunction);
        } else {
            throw Kit.codeBug();
        }
    }

    public static Scriptable newArrayLiteral(Object[] objArr, int[] iArr, Context context, Scriptable scriptable) {
        int length = objArr.length;
        int i = 0;
        int length2 = iArr != null ? iArr.length : 0;
        int i2 = length + length2;
        if (i2 > 1 && length2 * 2 < i2) {
            if (length2 != 0) {
                Object[] objArr2 = new Object[i2];
                int i3 = 0;
                int i4 = 0;
                while (i != i2) {
                    if (i3 != length2 && iArr[i3] == i) {
                        objArr2[i] = Scriptable.NOT_FOUND;
                        i3++;
                    } else {
                        objArr2[i] = objArr[i4];
                        i4++;
                    }
                    i++;
                }
                objArr = objArr2;
            }
            return context.newArray(scriptable, objArr);
        }
        Scriptable newArray = context.newArray(scriptable, i2);
        int i5 = 0;
        int i6 = 0;
        while (i != i2) {
            if (i5 == length2 || iArr[i5] != i) {
                ScriptableObject.putProperty(newArray, i, objArr[i6]);
                i6++;
            } else {
                i5++;
            }
            i++;
        }
        return newArray;
    }

    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, Context context, Scriptable scriptable) {
        return newObjectLiteral(objArr, objArr2, null, context, scriptable);
    }

    public static Scriptable newObjectLiteral(Object[] objArr, Object[] objArr2, int[] iArr, Context context, Scriptable scriptable) {
        Scriptable newObject = context.newObject(scriptable);
        int length = objArr.length;
        for (int i = 0; i != length; i++) {
            Object obj = objArr[i];
            int i2 = iArr == null ? 0 : iArr[i];
            Object obj2 = objArr2[i];
            if (!(obj instanceof String)) {
                newObject.put(((Integer) obj).intValue(), newObject, obj2);
            } else if (i2 == 0) {
                String str = (String) obj;
                if (isSpecialProperty(str)) {
                    specialRef(newObject, str, context).set(context, obj2);
                } else {
                    newObject.put(str, newObject, obj2);
                }
            } else {
                ((ScriptableObject) newObject).setGetterOrSetter((String) obj, 0, (Callable) obj2, i2 == 1);
            }
        }
        return newObject;
    }

    public static boolean isArrayObject(Object obj) {
        return (obj instanceof NativeArray) || (obj instanceof Arguments);
    }

    public static Object[] getArrayElements(Scriptable scriptable) {
        long lengthProperty = NativeArray.getLengthProperty(Context.getContext(), scriptable);
        if (lengthProperty <= 2147483647L) {
            int i = (int) lengthProperty;
            if (i == 0) {
                return emptyArgs;
            }
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                Object property = ScriptableObject.getProperty(scriptable, i2);
                if (property == Scriptable.NOT_FOUND) {
                    property = Undefined.instance;
                }
                objArr[i2] = property;
            }
            return objArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkDeprecated(Context context, String str) {
        int languageVersion = context.getLanguageVersion();
        if (languageVersion >= 140 || languageVersion == 0) {
            String message1 = getMessage1("msg.deprec.ctor", str);
            if (languageVersion == 0) {
                Context.reportWarning(message1);
                return;
            }
            throw Context.reportRuntimeError(message1);
        }
    }

    public static String getMessage0(String str) {
        return getMessage(str, null);
    }

    public static String getMessage1(String str, Object obj) {
        return getMessage(str, new Object[]{obj});
    }

    public static String getMessage2(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public static String getMessage3(String str, Object obj, Object obj2, Object obj3) {
        return getMessage(str, new Object[]{obj, obj2, obj3});
    }

    public static String getMessage4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return getMessage(str, new Object[]{obj, obj2, obj3, obj4});
    }

    public static String getMessage(String str, Object[] objArr) {
        return messageProvider.getMessage(str, objArr);
    }

    /* loaded from: classes5.dex */
    private static class DefaultMessageProvider implements MessageProvider {
        private DefaultMessageProvider() {
        }

        @Override // org.mozilla.javascript.ScriptRuntime.MessageProvider
        public String getMessage(String str, Object[] objArr) {
            Context currentContext = Context.getCurrentContext();
            try {
                return new MessageFormat(ResourceBundle.getBundle("org.mozilla.javascript.resources.Messages", currentContext != null ? currentContext.getLocale() : Locale.getDefault()).getString(str)).format(objArr);
            } catch (MissingResourceException unused) {
                throw new RuntimeException("no message resource found for message property " + str);
            }
        }
    }

    public static EcmaError constructError(String str, String str2) {
        int[] iArr = new int[1];
        return constructError(str, str2, Context.getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static EcmaError constructError(String str, String str2, int i) {
        int[] iArr = new int[1];
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        if (iArr[0] != 0) {
            iArr[0] = iArr[0] + i;
        }
        return constructError(str, str2, sourcePositionFromStack, iArr[0], null, 0);
    }

    public static EcmaError constructError(String str, String str2, String str3, int i, String str4, int i2) {
        return new EcmaError(str, str2, str3, i, str4, i2);
    }

    public static EcmaError typeError(String str) {
        return constructError("TypeError", str);
    }

    public static EcmaError typeError0(String str) {
        return typeError(getMessage0(str));
    }

    public static EcmaError typeError1(String str, String str2) {
        return typeError(getMessage1(str, str2));
    }

    public static EcmaError typeError2(String str, String str2, String str3) {
        return typeError(getMessage2(str, str2, str3));
    }

    public static EcmaError typeError3(String str, String str2, String str3, String str4) {
        return typeError(getMessage3(str, str2, str3, str4));
    }

    public static RuntimeException undefReadError(Object obj, Object obj2) {
        return typeError2("msg.undef.prop.read", toString(obj), obj2 == null ? "null" : obj2.toString());
    }

    public static RuntimeException undefCallError(Object obj, Object obj2) {
        return typeError2("msg.undef.method.call", toString(obj), obj2 == null ? "null" : obj2.toString());
    }

    public static RuntimeException undefWriteError(Object obj, Object obj2, Object obj3) {
        return typeError3("msg.undef.prop.write", toString(obj), obj2 == null ? "null" : obj2.toString(), obj3 instanceof Scriptable ? obj3.toString() : toString(obj3));
    }

    public static RuntimeException notFoundError(Scriptable scriptable, String str) {
        throw constructError("ReferenceError", getMessage1("msg.is.not.defined", str));
    }

    public static RuntimeException notFunctionError(Object obj) {
        return notFunctionError(obj, obj);
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2) {
        String obj3 = obj2 == null ? "null" : obj2.toString();
        if (obj == Scriptable.NOT_FOUND) {
            return typeError1("msg.function.not.found", obj3);
        }
        return typeError2("msg.isnt.function", obj3, typeof(obj));
    }

    public static RuntimeException notFunctionError(Object obj, Object obj2, String str) {
        int indexOf;
        String scriptRuntime = toString(obj);
        if ((obj instanceof NativeFunction) && (indexOf = scriptRuntime.indexOf(123)) > -1) {
            scriptRuntime = scriptRuntime.substring(0, indexOf + 1) + "...}";
        }
        if (obj2 == Scriptable.NOT_FOUND) {
            return typeError2("msg.function.not.found.in", str, scriptRuntime);
        }
        return typeError3("msg.isnt.function.in", str, scriptRuntime, typeof(obj2));
    }

    private static RuntimeException notXmlError(Object obj) {
        throw typeError1("msg.isnt.xml.object", toString(obj));
    }

    private static void warnAboutNonJSObject(Object obj) {
        String str = "RHINO USAGE WARNING: Missed Context.javaToJS() conversion:\nRhino runtime detected object " + obj + " of class " + obj.getClass().getName() + " where it expected String, Number, Boolean or Scriptable instance. Please check your code for missing Context.javaToJS() call.";
        Context.reportWarning(str);
        System.err.println(str);
    }

    public static RegExpProxy getRegExpProxy(Context context) {
        return context.getRegExpProxy();
    }

    public static void setRegExpProxy(Context context, RegExpProxy regExpProxy) {
        if (regExpProxy == null) {
            throw new IllegalArgumentException();
        }
        context.regExpProxy = regExpProxy;
    }

    public static RegExpProxy checkRegExpProxy(Context context) {
        RegExpProxy regExpProxy = getRegExpProxy(context);
        if (regExpProxy != null) {
            return regExpProxy;
        }
        throw Context.reportRuntimeError0("msg.no.regexp");
    }

    public static Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return context.getRegExpProxy().wrapRegExp(context, scriptable, obj);
    }

    private static XMLLib currentXMLLib(Context context) {
        if (context.topCallScope == null) {
            throw new IllegalStateException();
        }
        XMLLib xMLLib = context.cachedXMLLib;
        if (xMLLib == null) {
            xMLLib = XMLLib.extractFromScope(context.topCallScope);
            if (xMLLib == null) {
                throw new IllegalStateException();
            }
            context.cachedXMLLib = xMLLib;
        }
        return xMLLib;
    }

    public static String escapeAttributeValue(Object obj, Context context) {
        return currentXMLLib(context).escapeAttributeValue(obj);
    }

    public static String escapeTextValue(Object obj, Context context) {
        return currentXMLLib(context).escapeTextValue(obj);
    }

    public static Ref memberRef(Object obj, Object obj2, Context context, int i) {
        if (!(obj instanceof XMLObject)) {
            throw notXmlError(obj);
        }
        return ((XMLObject) obj).memberRef(context, obj2, i);
    }

    public static Ref memberRef(Object obj, Object obj2, Object obj3, Context context, int i) {
        if (!(obj instanceof XMLObject)) {
            throw notXmlError(obj);
        }
        return ((XMLObject) obj).memberRef(context, obj2, obj3, i);
    }

    public static Ref nameRef(Object obj, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, scriptable, i);
    }

    public static Ref nameRef(Object obj, Object obj2, Context context, Scriptable scriptable, int i) {
        return currentXMLLib(context).nameRef(context, obj, obj2, scriptable, i);
    }

    private static void storeIndexResult(Context context, int i) {
        context.scratchIndex = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int lastIndexResult(Context context) {
        return context.scratchIndex;
    }

    public static void storeUint32Result(Context context, long j) {
        if ((j >>> 32) != 0) {
            throw new IllegalArgumentException();
        }
        context.scratchUint32 = j;
    }

    public static long lastUint32Result(Context context) {
        long j = context.scratchUint32;
        if ((j >>> 32) == 0) {
            return j;
        }
        throw new IllegalStateException();
    }

    private static void storeScriptable(Context context, Scriptable scriptable) {
        if (context.scratchScriptable != null) {
            throw new IllegalStateException();
        }
        context.scratchScriptable = scriptable;
    }

    public static Scriptable lastStoredScriptable(Context context) {
        Scriptable scriptable = context.scratchScriptable;
        context.scratchScriptable = null;
        return scriptable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String makeUrlForGeneratedScript(boolean z, String str, int i) {
        if (z) {
            return str + '#' + i + "(eval)";
        }
        return str + '#' + i + "(Function)";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isGeneratedScript(String str) {
        return str.indexOf("(eval)") >= 0 || str.indexOf("(Function)") >= 0;
    }

    private static RuntimeException errorWithClassName(String str, Object obj) {
        return Context.reportRuntimeError1(str, obj.getClass().getName());
    }

    public static JavaScriptException throwError(Context context, Scriptable scriptable, String str) {
        int[] iArr = {0};
        String sourcePositionFromStack = Context.getSourcePositionFromStack(iArr);
        return new JavaScriptException(newBuiltinObject(context, scriptable, TopLevel.Builtins.Error, new Object[]{str, sourcePositionFromStack, Integer.valueOf(iArr[0])}), sourcePositionFromStack, iArr[0]);
    }
}
