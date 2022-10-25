package org.mozilla.javascript.optimizer;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.cast.MediaTrack;
import java.util.HashMap;
import java.util.List;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.ObjArray;
import org.mozilla.javascript.ObjToIntMap;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.ScriptNode;

/* loaded from: classes5.dex */
public class Codegen implements Evaluator {
    static final String DEFAULT_MAIN_METHOD_CLASS = "org.mozilla.javascript.optimizer.OptRuntime";
    static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    static final String ID_FIELD_NAME = "_id";
    static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    private static final String SUPER_CLASS_NAME = "org.mozilla.javascript.NativeFunction";
    private static final Object globalLock = new Object();
    private static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private ObjArray directCallTargets;
    private double[] itsConstantList;
    private int itsConstantListSize;
    String mainClassName;
    String mainClassSignature;
    private String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    private ObjToIntMap scriptOrFnIndexes;
    ScriptNode[] scriptOrFnNodes;

    private static String getStaticConstantWrapperType(double d) {
        return ((double) ((int) d)) == d ? "Ljava/lang/Integer;" : "Ljava/lang/Double;";
    }

    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i;
        synchronized (globalLock) {
            i = globalSerialClassCounter + 1;
            globalSerialClassCounter = i;
        }
        String str2 = "c";
        if (scriptNode.getSourceName().length() > 0) {
            str2 = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(str2.charAt(0))) {
                str2 = "_" + str2;
            }
        }
        String str3 = "org.mozilla.javascript.gen." + str2 + "_" + i;
        return new Object[]{str3, compileToClassFile(compilerEnvirons, str3, scriptNode, str, z)};
    }

    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader createLoader = SecurityController.createLoader(getClass().getClassLoader(), obj2);
        try {
            Class<?> defineClass = createLoader.defineClass(str, bArr);
            createLoader.linkClass(defineClass);
            return defineClass;
        } catch (IllegalArgumentException | SecurityException e) {
            throw new RuntimeException("Malformed optimizer package " + e);
        }
    }

    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        this.mainClassSignature = ClassFileWriter.classNameToSignature(str);
        try {
            return generateCode(str2);
        } catch (ClassFileWriter.ClassFileFormatException e) {
            throw reportClassFileFormatException(scriptNode, e.getMessage());
        }
    }

    private RuntimeException reportClassFileFormatException(ScriptNode scriptNode, String str) {
        return Context.reportRuntimeError(scriptNode instanceof FunctionNode ? ScriptRuntime.getMessage2("msg.while.compiling.fn", ((FunctionNode) scriptNode).getFunctionName(), str) : ScriptRuntime.getMessage1("msg.while.compiling.script", str), scriptNode.getSourceName(), scriptNode.getLineno(), null, 0);
    }

    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        int optimizationLevel = this.compilerEnv.getOptimizationLevel();
        HashMap hashMap = null;
        if (optimizationLevel > 0 && scriptNode.getType() == 136) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i = 0; i != functionCount; i++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (hashMap != null) {
            this.directCallTargets = new ObjArray();
        }
        new OptTransformer(hashMap, this.directCallTargets).transform(scriptNode);
        if (optimizationLevel > 0) {
            new Optimizer().optimize(scriptNode);
        }
    }

    private static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    private void initScriptNodesData(ScriptNode scriptNode) {
        ObjArray objArray = new ObjArray();
        collectScriptNodes_r(scriptNode, objArray);
        int size = objArray.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        objArray.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new ObjToIntMap(size);
        for (int i = 0; i != size; i++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i], i);
        }
    }

    private static void collectScriptNodes_r(ScriptNode scriptNode, ObjArray objArray) {
        objArray.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i), objArray);
        }
    }

    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 136;
        if (this.scriptOrFnNodes.length <= 1 && z2) {
            z = false;
        }
        ClassFileWriter classFileWriter = new ClassFileWriter(this.mainClassName, SUPER_CLASS_NAME, this.compilerEnv.isGenerateDebugInfo() ? this.scriptOrFnNodes[0].getSourceName() : null);
        classFileWriter.addField(ID_FIELD_NAME, "I", (short) 2);
        if (z) {
            generateFunctionConstructor(classFileWriter);
        }
        if (z2) {
            classFileWriter.addInterface("org/mozilla/javascript/Script");
            generateScriptCtor(classFileWriter);
            generateMain(classFileWriter);
            generateExecute(classFileWriter);
        }
        generateCallMethod(classFileWriter);
        generateResumeGenerator(classFileWriter);
        generateNativeFunctionOverrides(classFileWriter, str);
        int length = this.scriptOrFnNodes.length;
        for (int i = 0; i != length; i++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = classFileWriter;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i;
            try {
                bodyCodegen.generateBodyCode();
                if (scriptNode.getType() == 109) {
                    OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                    generateFunctionInit(classFileWriter, optFunctionNode);
                    if (optFunctionNode.isTargetOfDirectCall()) {
                        emitDirectConstructor(classFileWriter, optFunctionNode);
                    }
                }
            } catch (ClassFileWriter.ClassFileFormatException e) {
                throw reportClassFileFormatException(scriptNode, e.getMessage());
            }
        }
        emitRegExpInit(classFileWriter);
        emitConstantDudeInitializers(classFileWriter);
        return classFileWriter.toByteArray();
    }

    private void emitDirectConstructor(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.startMethod(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i = (paramCount * 3) + 4;
        int i2 = i + 1;
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addInvoke(182, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.addAStore(i2);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(i2);
        for (int i3 = 0; i3 < paramCount; i3++) {
            int i4 = i3 * 3;
            classFileWriter.addALoad(i4 + 4);
            classFileWriter.addDLoad(i4 + 5);
        }
        classFileWriter.addALoad(i);
        classFileWriter.addInvoke(184, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int acquireLabel = classFileWriter.acquireLabel();
        classFileWriter.add(89);
        classFileWriter.add(193, "org/mozilla/javascript/Scriptable");
        classFileWriter.add(153, acquireLabel);
        classFileWriter.add(192, "org/mozilla/javascript/Scriptable");
        classFileWriter.add(176);
        classFileWriter.markLabel(acquireLabel);
        classFileWriter.addALoad(i2);
        classFileWriter.add(176);
        classFileWriter.stopMethod((short) (i2 + 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 109 && ((FunctionNode) scriptNode).isGenerator();
    }

    private void generateResumeGenerator(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 >= scriptNodeArr.length) {
                break;
            }
            if (isGenerator(scriptNodeArr[i2])) {
                z = true;
            }
            i2++;
        }
        if (!z) {
            return;
        }
        classFileWriter.startMethod("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(4);
        classFileWriter.addALoad(5);
        classFileWriter.addILoad(3);
        classFileWriter.addLoadThis();
        classFileWriter.add(180, classFileWriter.getClassName(), ID_FIELD_NAME, "I");
        int addTableSwitch = classFileWriter.addTableSwitch(0, this.scriptOrFnNodes.length - 1);
        classFileWriter.markTableSwitchDefault(addTableSwitch);
        int acquireLabel = classFileWriter.acquireLabel();
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i < scriptNodeArr2.length) {
                ScriptNode scriptNode = scriptNodeArr2[i];
                classFileWriter.markTableSwitchCase(addTableSwitch, i, 6);
                if (isGenerator(scriptNode)) {
                    String str = this.mainClassName;
                    classFileWriter.addInvoke(184, str, getBodyMethodName(scriptNode) + "_gen", "(" + this.mainClassSignature + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                    classFileWriter.add(176);
                } else {
                    classFileWriter.add(167, acquireLabel);
                }
                i++;
            } else {
                classFileWriter.markLabel(acquireLabel);
                pushUndefined(classFileWriter);
                classFileWriter.add(176);
                classFileWriter.stopMethod((short) 6);
                return;
            }
        }
    }

    private void generateCallMethod(ClassFileWriter classFileWriter) {
        int i;
        int paramCount;
        classFileWriter.startMethod(NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int acquireLabel = classFileWriter.acquireLabel();
        classFileWriter.addALoad(1);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        classFileWriter.add(154, acquireLabel);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(3);
        classFileWriter.addALoad(4);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        classFileWriter.add(176);
        classFileWriter.markLabel(acquireLabel);
        classFileWriter.addALoad(0);
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(3);
        classFileWriter.addALoad(4);
        int length = this.scriptOrFnNodes.length;
        boolean z = 2 <= length;
        if (z) {
            classFileWriter.addLoadThis();
            classFileWriter.add(180, classFileWriter.getClassName(), ID_FIELD_NAME, "I");
            i = classFileWriter.addTableSwitch(1, length - 1);
        } else {
            i = 0;
        }
        short s = 0;
        for (int i2 = 0; i2 != length; i2++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            if (z) {
                if (i2 == 0) {
                    classFileWriter.markTableSwitchDefault(i);
                    s = classFileWriter.getStackTop();
                } else {
                    classFileWriter.markTableSwitchCase(i, i2 - 1, s);
                }
            }
            if (scriptNode.getType() == 109) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i3 = 0; i3 != paramCount; i3++) {
                        classFileWriter.add(190);
                        classFileWriter.addPush(i3);
                        int acquireLabel2 = classFileWriter.acquireLabel();
                        int acquireLabel3 = classFileWriter.acquireLabel();
                        classFileWriter.add(164, acquireLabel2);
                        classFileWriter.addALoad(4);
                        classFileWriter.addPush(i3);
                        classFileWriter.add(50);
                        classFileWriter.add(167, acquireLabel3);
                        classFileWriter.markLabel(acquireLabel2);
                        pushUndefined(classFileWriter);
                        classFileWriter.markLabel(acquireLabel3);
                        classFileWriter.adjustStackTop(-1);
                        classFileWriter.addPush(0.0d);
                        classFileWriter.addALoad(4);
                    }
                }
            }
            classFileWriter.addInvoke(184, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            classFileWriter.add(176);
        }
        classFileWriter.stopMethod((short) 5);
    }

    private void generateMain(ClassFileWriter classFileWriter) {
        classFileWriter.startMethod(MediaTrack.ROLE_MAIN, "([Ljava/lang/String;)V", (short) 9);
        classFileWriter.add(187, classFileWriter.getClassName());
        classFileWriter.add(89);
        classFileWriter.addInvoke(183, classFileWriter.getClassName(), "<init>", "()V");
        classFileWriter.add(42);
        classFileWriter.addInvoke(184, this.mainMethodClass, MediaTrack.ROLE_MAIN, "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        classFileWriter.add(177);
        classFileWriter.stopMethod((short) 1);
    }

    private void generateExecute(ClassFileWriter classFileWriter) {
        classFileWriter.startMethod("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        classFileWriter.addLoadThis();
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.add(89);
        classFileWriter.add(1);
        classFileWriter.addInvoke(182, classFileWriter.getClassName(), NotificationCompat.CATEGORY_CALL, "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        classFileWriter.add(176);
        classFileWriter.stopMethod((short) 3);
    }

    private void generateScriptCtor(ClassFileWriter classFileWriter) {
        classFileWriter.startMethod("<init>", "()V", (short) 1);
        classFileWriter.addLoadThis();
        classFileWriter.addInvoke(183, SUPER_CLASS_NAME, "<init>", "()V");
        classFileWriter.addLoadThis();
        classFileWriter.addPush(0);
        classFileWriter.add(181, classFileWriter.getClassName(), ID_FIELD_NAME, "I");
        classFileWriter.add(177);
        classFileWriter.stopMethod((short) 1);
    }

    private void generateFunctionConstructor(ClassFileWriter classFileWriter) {
        int i;
        classFileWriter.startMethod("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        short s = 0;
        classFileWriter.addALoad(0);
        classFileWriter.addInvoke(183, SUPER_CLASS_NAME, "<init>", "()V");
        classFileWriter.addLoadThis();
        classFileWriter.addILoad(3);
        classFileWriter.add(181, classFileWriter.getClassName(), ID_FIELD_NAME, "I");
        classFileWriter.addLoadThis();
        classFileWriter.addALoad(2);
        classFileWriter.addALoad(1);
        int i2 = this.scriptOrFnNodes[0].getType() == 136 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i2 == length) {
            throw badTree();
        }
        boolean z = 2 <= length - i2;
        if (z) {
            classFileWriter.addILoad(3);
            i = classFileWriter.addTableSwitch(i2 + 1, length - 1);
        } else {
            i = 0;
        }
        for (int i3 = i2; i3 != length; i3++) {
            if (z) {
                if (i3 == i2) {
                    classFileWriter.markTableSwitchDefault(i);
                    s = classFileWriter.getStackTop();
                } else {
                    classFileWriter.markTableSwitchCase(i, (i3 - 1) - i2, s);
                }
            }
            classFileWriter.addInvoke(183, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i3])), FUNCTION_INIT_SIGNATURE);
            classFileWriter.add(177);
        }
        classFileWriter.stopMethod((short) 4);
    }

    private void generateFunctionInit(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.startMethod(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        classFileWriter.addLoadThis();
        classFileWriter.addALoad(1);
        classFileWriter.addALoad(2);
        classFileWriter.addInvoke(182, "org/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            classFileWriter.addALoad(1);
            classFileWriter.addInvoke(184, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        classFileWriter.add(177);
        classFileWriter.stopMethod((short) 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void generateNativeFunctionOverrides(org.mozilla.classfile.ClassFileWriter r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.Codegen.generateNativeFunctionOverrides(org.mozilla.classfile.ClassFileWriter, java.lang.String):void");
    }

    private void emitRegExpInit(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 == scriptNodeArr.length) {
                break;
            }
            i3 += scriptNodeArr[i2].getRegexpCount();
            i2++;
        }
        if (i3 == 0) {
            return;
        }
        short s = 10;
        classFileWriter.startMethod(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        classFileWriter.addField("_reInitDone", "Z", (short) 74);
        classFileWriter.add(178, this.mainClassName, "_reInitDone", "Z");
        int acquireLabel = classFileWriter.acquireLabel();
        classFileWriter.add(153, acquireLabel);
        classFileWriter.add(177);
        classFileWriter.markLabel(acquireLabel);
        classFileWriter.addALoad(0);
        classFileWriter.addInvoke(184, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        classFileWriter.addAStore(1);
        int i4 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i4 != scriptNodeArr2.length) {
                ScriptNode scriptNode = scriptNodeArr2[i4];
                int regexpCount = scriptNode.getRegexpCount();
                int i5 = 0;
                while (i5 != regexpCount) {
                    String compiledRegexpName = getCompiledRegexpName(scriptNode, i5);
                    String regexpString = scriptNode.getRegexpString(i5);
                    String regexpFlags = scriptNode.getRegexpFlags(i5);
                    classFileWriter.addField(compiledRegexpName, "Ljava/lang/Object;", s);
                    classFileWriter.addALoad(1);
                    classFileWriter.addALoad(i);
                    classFileWriter.addPush(regexpString);
                    if (regexpFlags == null) {
                        classFileWriter.add(1);
                    } else {
                        classFileWriter.addPush(regexpFlags);
                    }
                    classFileWriter.addInvoke(185, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                    classFileWriter.add(179, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                    i5++;
                    i = 0;
                    s = 10;
                }
                i4++;
                i = 0;
                s = 10;
            } else {
                classFileWriter.addPush(1);
                classFileWriter.add(179, this.mainClassName, "_reInitDone", "Z");
                classFileWriter.add(177);
                classFileWriter.stopMethod((short) 2);
                return;
            }
        }
    }

    private void emitConstantDudeInitializers(ClassFileWriter classFileWriter) {
        int i = this.itsConstantListSize;
        if (i == 0) {
            return;
        }
        classFileWriter.startMethod("<clinit>", "()V", (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i2 = 0; i2 != i; i2++) {
            double d = dArr[i2];
            String str = "_k" + i2;
            String staticConstantWrapperType = getStaticConstantWrapperType(d);
            classFileWriter.addField(str, staticConstantWrapperType, (short) 10);
            int i3 = (int) d;
            if (i3 == d) {
                classFileWriter.addPush(i3);
                classFileWriter.addInvoke(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                classFileWriter.addPush(d);
                addDoubleWrap(classFileWriter);
            }
            classFileWriter.add(179, this.mainClassName, str, staticConstantWrapperType);
        }
        classFileWriter.add(177);
        classFileWriter.stopMethod((short) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pushNumberAsObject(ClassFileWriter classFileWriter, double d) {
        if (d == 0.0d) {
            if (1.0d / d > 0.0d) {
                classFileWriter.add(178, "org/mozilla/javascript/optimizer/OptRuntime", "zeroObj", "Ljava/lang/Double;");
                return;
            }
            classFileWriter.addPush(d);
            addDoubleWrap(classFileWriter);
        } else if (d == 1.0d) {
            classFileWriter.add(178, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Double;");
        } else if (d == -1.0d) {
            classFileWriter.add(178, "org/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Double;");
        } else if (d != d) {
            classFileWriter.add(178, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
        } else {
            int i = this.itsConstantListSize;
            if (i >= 2000) {
                classFileWriter.addPush(d);
                addDoubleWrap(classFileWriter);
                return;
            }
            int i2 = 0;
            if (i == 0) {
                this.itsConstantList = new double[64];
            } else {
                double[] dArr = this.itsConstantList;
                int i3 = 0;
                while (i3 != i && dArr[i3] != d) {
                    i3++;
                }
                if (i == dArr.length) {
                    double[] dArr2 = new double[i * 2];
                    System.arraycopy(this.itsConstantList, 0, dArr2, 0, i);
                    this.itsConstantList = dArr2;
                }
                i2 = i3;
            }
            if (i2 == i) {
                this.itsConstantList[i] = d;
                this.itsConstantListSize = i + 1;
            }
            classFileWriter.add(178, this.mainClassName, "_k" + i2, getStaticConstantWrapperType(d));
        }
    }

    private static void addDoubleWrap(ClassFileWriter classFileWriter) {
        classFileWriter.addInvoke(184, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void pushUndefined(ClassFileWriter classFileWriter) {
        classFileWriter.add(178, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.getExisting(scriptNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDirectCtorName(ScriptNode scriptNode) {
        return "_n" + getIndex(scriptNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBodyMethodName(ScriptNode scriptNode) {
        return "_c_" + cleanName(scriptNode) + "_" + getIndex(scriptNode);
    }

    String cleanName(ScriptNode scriptNode) {
        if (scriptNode instanceof FunctionNode) {
            Name functionName = ((FunctionNode) scriptNode).getFunctionName();
            return functionName == null ? "anonymous" : functionName.getIdentifier();
        }
        return "script";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(this.mainClassSignature);
        stringBuffer.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 109) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i = 0; i != paramCount; i++) {
                    stringBuffer.append("Ljava/lang/Object;D");
                }
            }
        }
        stringBuffer.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return stringBuffer.toString();
    }

    String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        return "_i" + getIndex(optFunctionNode.fnode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getCompiledRegexpName(ScriptNode scriptNode, int i) {
        return "_re" + getIndex(scriptNode) + "_" + i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
