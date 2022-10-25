package org.mozilla.javascript;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.ArrayComprehension;
import org.mozilla.javascript.ast.ArrayComprehensionLoop;
import org.mozilla.javascript.ast.ArrayLiteral;
import org.mozilla.javascript.ast.Assignment;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Block;
import org.mozilla.javascript.ast.BreakStatement;
import org.mozilla.javascript.ast.CatchClause;
import org.mozilla.javascript.ast.ConditionalExpression;
import org.mozilla.javascript.ast.ContinueStatement;
import org.mozilla.javascript.ast.DestructuringForm;
import org.mozilla.javascript.ast.DoLoop;
import org.mozilla.javascript.ast.ElementGet;
import org.mozilla.javascript.ast.EmptyExpression;
import org.mozilla.javascript.ast.ExpressionStatement;
import org.mozilla.javascript.ast.ForInLoop;
import org.mozilla.javascript.ast.ForLoop;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.GeneratorExpression;
import org.mozilla.javascript.ast.GeneratorExpressionLoop;
import org.mozilla.javascript.ast.IfStatement;
import org.mozilla.javascript.ast.InfixExpression;
import org.mozilla.javascript.ast.Jump;
import org.mozilla.javascript.ast.Label;
import org.mozilla.javascript.ast.LabeledStatement;
import org.mozilla.javascript.ast.LetNode;
import org.mozilla.javascript.ast.Loop;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NewExpression;
import org.mozilla.javascript.ast.NumberLiteral;
import org.mozilla.javascript.ast.ObjectLiteral;
import org.mozilla.javascript.ast.ObjectProperty;
import org.mozilla.javascript.ast.ParenthesizedExpression;
import org.mozilla.javascript.ast.PropertyGet;
import org.mozilla.javascript.ast.RegExpLiteral;
import org.mozilla.javascript.ast.ReturnStatement;
import org.mozilla.javascript.ast.Scope;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.StringLiteral;
import org.mozilla.javascript.ast.SwitchCase;
import org.mozilla.javascript.ast.SwitchStatement;
import org.mozilla.javascript.ast.Symbol;
import org.mozilla.javascript.ast.ThrowStatement;
import org.mozilla.javascript.ast.TryStatement;
import org.mozilla.javascript.ast.UnaryExpression;
import org.mozilla.javascript.ast.VariableDeclaration;
import org.mozilla.javascript.ast.VariableInitializer;
import org.mozilla.javascript.ast.WhileLoop;
import org.mozilla.javascript.ast.WithStatement;
import org.mozilla.javascript.ast.XmlDotQuery;
import org.mozilla.javascript.ast.XmlElemRef;
import org.mozilla.javascript.ast.XmlExpression;
import org.mozilla.javascript.ast.XmlFragment;
import org.mozilla.javascript.ast.XmlLiteral;
import org.mozilla.javascript.ast.XmlMemberGet;
import org.mozilla.javascript.ast.XmlPropRef;
import org.mozilla.javascript.ast.XmlRef;
import org.mozilla.javascript.ast.XmlString;
import org.mozilla.javascript.ast.Yield;

/* loaded from: classes5.dex */
public final class IRFactory extends Parser {
    private static final int ALWAYS_FALSE_BOOLEAN = -1;
    private static final int ALWAYS_TRUE_BOOLEAN = 1;
    private static final int LOOP_DO_WHILE = 0;
    private static final int LOOP_FOR = 2;
    private static final int LOOP_WHILE = 1;
    private Decompiler decompiler;

    public IRFactory() {
        this.decompiler = new Decompiler();
    }

    public IRFactory(CompilerEnvirons compilerEnvirons) {
        this(compilerEnvirons, compilerEnvirons.getErrorReporter());
    }

    public IRFactory(CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter) {
        super(compilerEnvirons, errorReporter);
        this.decompiler = new Decompiler();
    }

    public ScriptNode transformTree(AstRoot astRoot) {
        this.currentScriptOrFn = astRoot;
        this.inUseStrictDirective = astRoot.isInStrictMode();
        int currentOffset = this.decompiler.getCurrentOffset();
        ScriptNode scriptNode = (ScriptNode) transform(astRoot);
        scriptNode.setEncodedSourceBounds(currentOffset, this.decompiler.getCurrentOffset());
        if (this.compilerEnv.isGeneratingSource()) {
            scriptNode.setEncodedSource(this.decompiler.getEncodedSource());
        }
        this.decompiler = null;
        return scriptNode;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Node transform(AstNode astNode) {
        int type = astNode.getType();
        if (type != 65) {
            if (type != 66) {
                if (type != 128) {
                    if (type == 129) {
                        return transformBlock(astNode);
                    }
                    switch (type) {
                        case 4:
                            return transformReturn((ReturnStatement) astNode);
                        case 30:
                            return transformNewExpr((NewExpression) astNode);
                        case 33:
                            return transformPropertyGet((PropertyGet) astNode);
                        case 36:
                            return transformElementGet((ElementGet) astNode);
                        case 48:
                            return transformRegExp((RegExpLiteral) astNode);
                        case 50:
                            return transformThrow((ThrowStatement) astNode);
                        case 72:
                            return transformYield((Yield) astNode);
                        case 81:
                            return transformTry((TryStatement) astNode);
                        case 102:
                            return transformCondExpr((ConditionalExpression) astNode);
                        case 109:
                            return transformFunction((FunctionNode) astNode);
                        case 112:
                            return transformIf((IfStatement) astNode);
                        case 114:
                            return transformSwitch((SwitchStatement) astNode);
                        case 123:
                            return transformWith((WithStatement) astNode);
                        case 136:
                            return transformScript((ScriptNode) astNode);
                        case 157:
                            return transformArrayComp((ArrayComprehension) astNode);
                        case 160:
                            break;
                        case 162:
                            return transformGenExpr((GeneratorExpression) astNode);
                        default:
                            switch (type) {
                                case 38:
                                    return transformFunctionCall((FunctionCall) astNode);
                                case 39:
                                    return transformName((Name) astNode);
                                case 40:
                                    return transformNumber((NumberLiteral) astNode);
                                case 41:
                                    return transformString((StringLiteral) astNode);
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                    break;
                                default:
                                    switch (type) {
                                        case 117:
                                            return transformWhileLoop((WhileLoop) astNode);
                                        case 118:
                                            return transformDoLoop((DoLoop) astNode);
                                        case 119:
                                            if (astNode instanceof ForInLoop) {
                                                return transformForInLoop((ForInLoop) astNode);
                                            }
                                            return transformForLoop((ForLoop) astNode);
                                        case 120:
                                            return transformBreak((BreakStatement) astNode);
                                        case 121:
                                            return transformContinue((ContinueStatement) astNode);
                                        default:
                                            if (astNode instanceof ExpressionStatement) {
                                                return transformExprStmt((ExpressionStatement) astNode);
                                            }
                                            if (astNode instanceof Assignment) {
                                                return transformAssignment((Assignment) astNode);
                                            }
                                            if (astNode instanceof UnaryExpression) {
                                                return transformUnary((UnaryExpression) astNode);
                                            }
                                            if (astNode instanceof XmlMemberGet) {
                                                return transformXmlMemberGet((XmlMemberGet) astNode);
                                            }
                                            if (astNode instanceof InfixExpression) {
                                                return transformInfix((InfixExpression) astNode);
                                            }
                                            if (astNode instanceof VariableDeclaration) {
                                                return transformVariables((VariableDeclaration) astNode);
                                            }
                                            if (astNode instanceof ParenthesizedExpression) {
                                                return transformParenExpr((ParenthesizedExpression) astNode);
                                            }
                                            if (astNode instanceof LabeledStatement) {
                                                return transformLabeledStatement((LabeledStatement) astNode);
                                            }
                                            if (astNode instanceof LetNode) {
                                                return transformLetNode((LetNode) astNode);
                                            }
                                            if (astNode instanceof XmlRef) {
                                                return transformXmlRef((XmlRef) astNode);
                                            }
                                            if (astNode instanceof XmlLiteral) {
                                                return transformXmlLiteral((XmlLiteral) astNode);
                                            }
                                            throw new IllegalArgumentException("Can't transform: " + astNode);
                                    }
                            }
                    }
                    return transformLiteral(astNode);
                }
                return astNode;
            }
            return transformObjectLiteral((ObjectLiteral) astNode);
        }
        return transformArrayLiteral((ArrayLiteral) astNode);
    }

    private Node transformArrayComp(ArrayComprehension arrayComprehension) {
        int lineno = arrayComprehension.getLineno();
        Scope createScopeNode = createScopeNode(157, lineno);
        String nextTempName = this.currentScriptOrFn.getNextTempName();
        pushScope(createScopeNode);
        try {
            defineSymbol(153, nextTempName, false);
            Node node = new Node(129, lineno);
            node.addChildToBack(new Node(133, createAssignment(90, createName(nextTempName), createCallOrNew(30, createName("Array"))), lineno));
            node.addChildToBack(arrayCompTransformHelper(arrayComprehension, nextTempName));
            createScopeNode.addChildToBack(node);
            createScopeNode.addChildToBack(createName(nextTempName));
            return createScopeNode;
        } finally {
            popScope();
        }
    }

    private Node arrayCompTransformHelper(ArrayComprehension arrayComprehension, String str) {
        String str2;
        this.decompiler.addToken(83);
        int lineno = arrayComprehension.getLineno();
        Node transform = transform(arrayComprehension.getResult());
        List<ArrayComprehensionLoop> loops = arrayComprehension.getLoops();
        int size = loops.size();
        Node[] nodeArr = new Node[size];
        Node[] nodeArr2 = new Node[size];
        int i = 0;
        Node node = transform;
        for (int i2 = 0; i2 < size; i2++) {
            ArrayComprehensionLoop arrayComprehensionLoop = loops.get(i2);
            this.decompiler.addName(" ");
            this.decompiler.addToken(119);
            if (arrayComprehensionLoop.isForEach()) {
                this.decompiler.addName("each ");
            }
            this.decompiler.addToken(87);
            AstNode iterator = arrayComprehensionLoop.getIterator();
            if (iterator.getType() == 39) {
                str2 = iterator.getString();
                this.decompiler.addName(str2);
            } else {
                decompile(iterator);
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(87, nextTempName, false);
                node = createBinary(89, createAssignment(90, iterator, createName(nextTempName)), node);
                str2 = nextTempName;
            }
            Node createName = createName(str2);
            defineSymbol(153, str2, false);
            nodeArr[i2] = createName;
            this.decompiler.addToken(52);
            nodeArr2[i2] = transform(arrayComprehensionLoop.getIteratedObject());
            this.decompiler.addToken(88);
        }
        Node createCallOrNew = createCallOrNew(38, createPropertyGet(createName(str), null, "push", 0));
        Node node2 = new Node(133, createCallOrNew, lineno);
        if (arrayComprehension.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(112);
            this.decompiler.addToken(87);
            node2 = createIf(transform(arrayComprehension.getFilter()), node2, null, lineno);
            this.decompiler.addToken(88);
        }
        Node node3 = node2;
        int i3 = size - 1;
        int i4 = 0;
        while (i3 >= 0) {
            try {
                ArrayComprehensionLoop arrayComprehensionLoop2 = loops.get(i3);
                Scope createLoopNode = createLoopNode(null, arrayComprehensionLoop2.getLineno());
                pushScope(createLoopNode);
                int i5 = i4 + 1;
                try {
                    node3 = createForIn(153, createLoopNode, nodeArr[i3], nodeArr2[i3], node3, arrayComprehensionLoop2.isForEach());
                    i3--;
                    i4 = i5;
                } catch (Throwable th) {
                    th = th;
                    i4 = i5;
                    while (i < i4) {
                        popScope();
                        i++;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        while (i < i4) {
            popScope();
            i++;
        }
        this.decompiler.addToken(84);
        createCallOrNew.addChildToBack(node);
        return node3;
    }

    private Node transformArrayLiteral(ArrayLiteral arrayLiteral) {
        if (arrayLiteral.isDestructuring()) {
            return arrayLiteral;
        }
        this.decompiler.addToken(83);
        List<AstNode> elements = arrayLiteral.getElements();
        Node node = new Node(65);
        ArrayList arrayList = null;
        for (int i = 0; i < elements.size(); i++) {
            AstNode astNode = elements.get(i);
            if (astNode.getType() != 128) {
                node.addChildToBack(transform(astNode));
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(Integer.valueOf(i));
            }
            if (i < elements.size() - 1) {
                this.decompiler.addToken(89);
            }
        }
        this.decompiler.addToken(84);
        node.putIntProp(21, arrayLiteral.getDestructuringLength());
        if (arrayList != null) {
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            node.putProp(11, iArr);
        }
        return node;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.mozilla.javascript.Node] */
    /* JADX WARN: Type inference failed for: r3v0, types: [org.mozilla.javascript.IRFactory] */
    private Node transformAssignment(Assignment assignment) {
        AstNode astNode;
        AstNode removeParens = removeParens(assignment.getLeft());
        if (isDestructuring(removeParens)) {
            decompile(removeParens);
            astNode = removeParens;
        } else {
            astNode = transform(removeParens);
        }
        this.decompiler.addToken(assignment.getType());
        return createAssignment(assignment.getType(), astNode, transform(assignment.getRight()));
    }

    private Node transformBlock(AstNode astNode) {
        boolean z = astNode instanceof Scope;
        if (z) {
            pushScope((Scope) astNode);
        }
        try {
            ArrayList<Node> arrayList = new ArrayList();
            Iterator<Node> it = astNode.iterator();
            while (it.hasNext()) {
                arrayList.add(transform((AstNode) it.next()));
            }
            astNode.removeChildren();
            for (Node node : arrayList) {
                astNode.addChildToBack(node);
            }
            return astNode;
        } finally {
            if (z) {
                popScope();
            }
        }
    }

    private Node transformBreak(BreakStatement breakStatement) {
        this.decompiler.addToken(120);
        if (breakStatement.getBreakLabel() != null) {
            this.decompiler.addName(breakStatement.getBreakLabel().getIdentifier());
        }
        this.decompiler.addEOL(82);
        return breakStatement;
    }

    private Node transformCondExpr(ConditionalExpression conditionalExpression) {
        Node transform = transform(conditionalExpression.getTestExpression());
        this.decompiler.addToken(102);
        Node transform2 = transform(conditionalExpression.getTrueExpression());
        this.decompiler.addToken(103);
        return createCondExpr(transform, transform2, transform(conditionalExpression.getFalseExpression()));
    }

    private Node transformContinue(ContinueStatement continueStatement) {
        this.decompiler.addToken(121);
        if (continueStatement.getLabel() != null) {
            this.decompiler.addName(continueStatement.getLabel().getIdentifier());
        }
        this.decompiler.addEOL(82);
        return continueStatement;
    }

    private Node transformDoLoop(DoLoop doLoop) {
        doLoop.setType(132);
        pushScope(doLoop);
        try {
            this.decompiler.addToken(118);
            this.decompiler.addEOL(85);
            Node transform = transform(doLoop.getBody());
            this.decompiler.addToken(86);
            this.decompiler.addToken(117);
            this.decompiler.addToken(87);
            Node transform2 = transform(doLoop.getCondition());
            this.decompiler.addToken(88);
            this.decompiler.addEOL(82);
            return createLoop(doLoop, 0, transform, transform2, null, null);
        } finally {
            popScope();
        }
    }

    private Node transformElementGet(ElementGet elementGet) {
        Node transform = transform(elementGet.getTarget());
        this.decompiler.addToken(83);
        Node transform2 = transform(elementGet.getElement());
        this.decompiler.addToken(84);
        return new Node(36, transform, transform2);
    }

    private Node transformExprStmt(ExpressionStatement expressionStatement) {
        Node transform = transform(expressionStatement.getExpression());
        this.decompiler.addEOL(82);
        return new Node(expressionStatement.getType(), transform, expressionStatement.getLineno());
    }

    private Node transformForInLoop(ForInLoop forInLoop) {
        this.decompiler.addToken(119);
        if (forInLoop.isForEach()) {
            this.decompiler.addName("each ");
        }
        this.decompiler.addToken(87);
        forInLoop.setType(132);
        pushScope(forInLoop);
        try {
            AstNode iterator = forInLoop.getIterator();
            int type = iterator instanceof VariableDeclaration ? ((VariableDeclaration) iterator).getType() : -1;
            Node transform = transform(iterator);
            this.decompiler.addToken(52);
            Node transform2 = transform(forInLoop.getIteratedObject());
            this.decompiler.addToken(88);
            this.decompiler.addEOL(85);
            Node transform3 = transform(forInLoop.getBody());
            this.decompiler.addEOL(86);
            return createForIn(type, forInLoop, transform, transform2, transform3, forInLoop.isForEach());
        } finally {
            popScope();
        }
    }

    private Node transformForLoop(ForLoop forLoop) {
        this.decompiler.addToken(119);
        this.decompiler.addToken(87);
        forLoop.setType(132);
        Scope scope = this.currentScope;
        this.currentScope = forLoop;
        try {
            Node transform = transform(forLoop.getInitializer());
            this.decompiler.addToken(82);
            Node transform2 = transform(forLoop.getCondition());
            this.decompiler.addToken(82);
            Node transform3 = transform(forLoop.getIncrement());
            this.decompiler.addToken(88);
            this.decompiler.addEOL(85);
            Node transform4 = transform(forLoop.getBody());
            this.decompiler.addEOL(86);
            return createFor(forLoop, transform, transform2, transform3, transform4);
        } finally {
            this.currentScope = scope;
        }
    }

    private Node transformFunction(FunctionNode functionNode) {
        int functionType = functionNode.getFunctionType();
        int markFunctionStart = this.decompiler.markFunctionStart(functionType);
        Node decompileFunctionHeader = decompileFunctionHeader(functionNode);
        int addFunction = this.currentScriptOrFn.addFunction(functionNode);
        Parser.PerFunctionVariables perFunctionVariables = new Parser.PerFunctionVariables(functionNode);
        try {
            Node node = (Node) functionNode.getProp(23);
            functionNode.removeProp(23);
            int lineno = functionNode.getBody().getLineno();
            this.nestingOfFunction++;
            Node transform = transform(functionNode.getBody());
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addToken(86);
            }
            functionNode.setEncodedSourceBounds(markFunctionStart, this.decompiler.markFunctionEnd(markFunctionStart));
            if (functionType != 2 && !functionNode.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (node != null) {
                transform.addChildToFront(new Node(133, node, lineno));
            }
            int functionType2 = functionNode.getFunctionType();
            Node initFunction = initFunction(functionNode, addFunction, transform, functionType2);
            if (decompileFunctionHeader != null) {
                initFunction = createAssignment(90, decompileFunctionHeader, initFunction);
                if (functionType2 != 2) {
                    initFunction = createExprStatementNoReturn(initFunction, functionNode.getLineno());
                }
            }
            return initFunction;
        } finally {
            this.nestingOfFunction--;
            perFunctionVariables.restore();
        }
    }

    private Node transformFunctionCall(FunctionCall functionCall) {
        Node createCallOrNew = createCallOrNew(38, transform(functionCall.getTarget()));
        createCallOrNew.setLineno(functionCall.getLineno());
        this.decompiler.addToken(87);
        List<AstNode> arguments = functionCall.getArguments();
        for (int i = 0; i < arguments.size(); i++) {
            createCallOrNew.addChildToBack(transform(arguments.get(i)));
            if (i < arguments.size() - 1) {
                this.decompiler.addToken(89);
            }
        }
        this.decompiler.addToken(88);
        return createCallOrNew;
    }

    private Node transformGenExpr(GeneratorExpression generatorExpression) {
        FunctionNode functionNode = new FunctionNode();
        functionNode.setSourceName(this.currentScriptOrFn.getNextTempName());
        functionNode.setIsGenerator();
        functionNode.setFunctionType(2);
        functionNode.setRequiresActivation();
        int functionType = functionNode.getFunctionType();
        int markFunctionStart = this.decompiler.markFunctionStart(functionType);
        Node decompileFunctionHeader = decompileFunctionHeader(functionNode);
        int addFunction = this.currentScriptOrFn.addFunction(functionNode);
        Parser.PerFunctionVariables perFunctionVariables = new Parser.PerFunctionVariables(functionNode);
        try {
            Node node = (Node) functionNode.getProp(23);
            functionNode.removeProp(23);
            int i = generatorExpression.lineno;
            this.nestingOfFunction++;
            Node genExprTransformHelper = genExprTransformHelper(generatorExpression);
            if (!functionNode.isExpressionClosure()) {
                this.decompiler.addToken(86);
            }
            functionNode.setEncodedSourceBounds(markFunctionStart, this.decompiler.markFunctionEnd(markFunctionStart));
            if (functionType != 2 && !functionNode.isExpressionClosure()) {
                this.decompiler.addToken(1);
            }
            if (node != null) {
                genExprTransformHelper.addChildToFront(new Node(133, node, i));
            }
            int functionType2 = functionNode.getFunctionType();
            Node initFunction = initFunction(functionNode, addFunction, genExprTransformHelper, functionType2);
            if (decompileFunctionHeader != null) {
                initFunction = createAssignment(90, decompileFunctionHeader, initFunction);
                if (functionType2 != 2) {
                    initFunction = createExprStatementNoReturn(initFunction, functionNode.getLineno());
                }
            }
            this.nestingOfFunction--;
            perFunctionVariables.restore();
            Node createCallOrNew = createCallOrNew(38, initFunction);
            createCallOrNew.setLineno(generatorExpression.getLineno());
            this.decompiler.addToken(87);
            this.decompiler.addToken(88);
            return createCallOrNew;
        } catch (Throwable th) {
            this.nestingOfFunction--;
            perFunctionVariables.restore();
            throw th;
        }
    }

    private Node genExprTransformHelper(GeneratorExpression generatorExpression) {
        GeneratorExpressionLoop generatorExpressionLoop;
        Scope createLoopNode;
        int i;
        String str;
        int i2 = 87;
        this.decompiler.addToken(87);
        int lineno = generatorExpression.getLineno();
        Node transform = transform(generatorExpression.getResult());
        List<GeneratorExpressionLoop> loops = generatorExpression.getLoops();
        int size = loops.size();
        Node[] nodeArr = new Node[size];
        Node[] nodeArr2 = new Node[size];
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            GeneratorExpressionLoop generatorExpressionLoop2 = loops.get(i4);
            this.decompiler.addName(" ");
            this.decompiler.addToken(119);
            this.decompiler.addToken(i2);
            AstNode iterator = generatorExpressionLoop2.getIterator();
            if (iterator.getType() == 39) {
                str = iterator.getString();
                this.decompiler.addName(str);
            } else {
                decompile(iterator);
                String nextTempName = this.currentScriptOrFn.getNextTempName();
                defineSymbol(i2, nextTempName, false);
                transform = createBinary(89, createAssignment(90, iterator, createName(nextTempName)), transform);
                str = nextTempName;
            }
            Node createName = createName(str);
            defineSymbol(153, str, false);
            nodeArr[i4] = createName;
            this.decompiler.addToken(52);
            nodeArr2[i4] = transform(generatorExpressionLoop2.getIteratedObject());
            this.decompiler.addToken(88);
            i4++;
            i2 = 87;
        }
        Node node = new Node(133, new Node(72, transform, generatorExpression.getLineno()), lineno);
        if (generatorExpression.getFilter() != null) {
            this.decompiler.addName(" ");
            this.decompiler.addToken(112);
            this.decompiler.addToken(87);
            node = createIf(transform(generatorExpression.getFilter()), node, null, lineno);
            this.decompiler.addToken(88);
        }
        Node node2 = node;
        int i5 = size - 1;
        int i6 = 0;
        while (i5 >= 0) {
            try {
                generatorExpressionLoop = loops.get(i5);
                createLoopNode = createLoopNode(null, generatorExpressionLoop.getLineno());
                pushScope(createLoopNode);
                i = i6 + 1;
            } catch (Throwable th) {
                th = th;
            }
            try {
                node2 = createForIn(153, createLoopNode, nodeArr[i5], nodeArr2[i5], node2, generatorExpressionLoop.isForEach());
                i5--;
                i6 = i;
            } catch (Throwable th2) {
                th = th2;
                i6 = i;
                while (i3 < i6) {
                    popScope();
                    i3++;
                }
                throw th;
            }
        }
        while (i3 < i6) {
            popScope();
            i3++;
        }
        this.decompiler.addToken(88);
        return node2;
    }

    private Node transformIf(IfStatement ifStatement) {
        Node node;
        this.decompiler.addToken(112);
        this.decompiler.addToken(87);
        Node transform = transform(ifStatement.getCondition());
        this.decompiler.addToken(88);
        this.decompiler.addEOL(85);
        Node transform2 = transform(ifStatement.getThenPart());
        if (ifStatement.getElsePart() != null) {
            this.decompiler.addToken(86);
            this.decompiler.addToken(113);
            this.decompiler.addEOL(85);
            node = transform(ifStatement.getElsePart());
        } else {
            node = null;
        }
        this.decompiler.addEOL(86);
        return createIf(transform, transform2, node, ifStatement.getLineno());
    }

    private Node transformInfix(InfixExpression infixExpression) {
        Node transform = transform(infixExpression.getLeft());
        this.decompiler.addToken(infixExpression.getType());
        Node transform2 = transform(infixExpression.getRight());
        if (infixExpression instanceof XmlDotQuery) {
            this.decompiler.addToken(88);
        }
        return createBinary(infixExpression.getType(), transform, transform2);
    }

    private Node transformLabeledStatement(LabeledStatement labeledStatement) {
        for (Label label : labeledStatement.getLabels()) {
            this.decompiler.addName(label.getName());
            this.decompiler.addEOL(103);
        }
        Label firstLabel = labeledStatement.getFirstLabel();
        Node transform = transform(labeledStatement.getStatement());
        Node newTarget = Node.newTarget();
        Node node = new Node(129, firstLabel, transform, newTarget);
        firstLabel.target = newTarget;
        return node;
    }

    private Node transformLetNode(LetNode letNode) {
        pushScope(letNode);
        try {
            this.decompiler.addToken(153);
            this.decompiler.addToken(87);
            Node transformVariableInitializers = transformVariableInitializers(letNode.getVariables());
            this.decompiler.addToken(88);
            letNode.addChildToBack(transformVariableInitializers);
            boolean z = letNode.getType() == 158;
            if (letNode.getBody() != null) {
                if (z) {
                    this.decompiler.addName(" ");
                } else {
                    this.decompiler.addEOL(85);
                }
                letNode.addChildToBack(transform(letNode.getBody()));
                if (!z) {
                    this.decompiler.addEOL(86);
                }
            }
            return letNode;
        } finally {
            popScope();
        }
    }

    private Node transformLiteral(AstNode astNode) {
        this.decompiler.addToken(astNode.getType());
        return astNode;
    }

    private Node transformName(Name name) {
        this.decompiler.addName(name.getIdentifier());
        return name;
    }

    private Node transformNewExpr(NewExpression newExpression) {
        this.decompiler.addToken(30);
        Node createCallOrNew = createCallOrNew(30, transform(newExpression.getTarget()));
        createCallOrNew.setLineno(newExpression.getLineno());
        List<AstNode> arguments = newExpression.getArguments();
        this.decompiler.addToken(87);
        for (int i = 0; i < arguments.size(); i++) {
            createCallOrNew.addChildToBack(transform(arguments.get(i)));
            if (i < arguments.size() - 1) {
                this.decompiler.addToken(89);
            }
        }
        this.decompiler.addToken(88);
        if (newExpression.getInitializer() != null) {
            createCallOrNew.addChildToBack(transformObjectLiteral(newExpression.getInitializer()));
        }
        return createCallOrNew;
    }

    private Node transformNumber(NumberLiteral numberLiteral) {
        this.decompiler.addNumber(numberLiteral.getNumber());
        return numberLiteral;
    }

    private Node transformObjectLiteral(ObjectLiteral objectLiteral) {
        Object[] objArr;
        if (objectLiteral.isDestructuring()) {
            return objectLiteral;
        }
        this.decompiler.addToken(85);
        List<ObjectProperty> elements = objectLiteral.getElements();
        Node node = new Node(66);
        if (elements.isEmpty()) {
            objArr = ScriptRuntime.emptyArgs;
        } else {
            int size = elements.size();
            int i = 0;
            Object[] objArr2 = new Object[size];
            for (ObjectProperty objectProperty : elements) {
                if (objectProperty.isGetter()) {
                    this.decompiler.addToken(151);
                } else if (objectProperty.isSetter()) {
                    this.decompiler.addToken(152);
                }
                int i2 = i + 1;
                objArr2[i] = getPropKey(objectProperty.getLeft());
                if (!objectProperty.isGetter() && !objectProperty.isSetter()) {
                    this.decompiler.addToken(66);
                }
                Node transform = transform(objectProperty.getRight());
                if (objectProperty.isGetter()) {
                    transform = createUnary(151, transform);
                } else if (objectProperty.isSetter()) {
                    transform = createUnary(152, transform);
                }
                node.addChildToBack(transform);
                if (i2 < size) {
                    this.decompiler.addToken(89);
                }
                i = i2;
            }
            objArr = objArr2;
        }
        this.decompiler.addToken(86);
        node.putProp(12, objArr);
        return node;
    }

    private Object getPropKey(Node node) {
        if (node instanceof Name) {
            String identifier = ((Name) node).getIdentifier();
            this.decompiler.addName(identifier);
            return ScriptRuntime.getIndexObject(identifier);
        } else if (node instanceof StringLiteral) {
            String value = ((StringLiteral) node).getValue();
            this.decompiler.addString(value);
            return ScriptRuntime.getIndexObject(value);
        } else if (node instanceof NumberLiteral) {
            double number = ((NumberLiteral) node).getNumber();
            this.decompiler.addNumber(number);
            return ScriptRuntime.getIndexObject(number);
        } else {
            throw Kit.codeBug();
        }
    }

    private Node transformParenExpr(ParenthesizedExpression parenthesizedExpression) {
        AstNode expression = parenthesizedExpression.getExpression();
        this.decompiler.addToken(87);
        int i = 1;
        while (expression instanceof ParenthesizedExpression) {
            this.decompiler.addToken(87);
            i++;
            expression = ((ParenthesizedExpression) expression).getExpression();
        }
        Node transform = transform(expression);
        for (int i2 = 0; i2 < i; i2++) {
            this.decompiler.addToken(88);
        }
        transform.putProp(19, Boolean.TRUE);
        return transform;
    }

    private Node transformPropertyGet(PropertyGet propertyGet) {
        Node transform = transform(propertyGet.getTarget());
        String identifier = propertyGet.getProperty().getIdentifier();
        this.decompiler.addToken(108);
        this.decompiler.addName(identifier);
        return createPropertyGet(transform, null, identifier, 0);
    }

    private Node transformRegExp(RegExpLiteral regExpLiteral) {
        this.decompiler.addRegexp(regExpLiteral.getValue(), regExpLiteral.getFlags());
        this.currentScriptOrFn.addRegExp(regExpLiteral);
        return regExpLiteral;
    }

    private Node transformReturn(ReturnStatement returnStatement) {
        boolean equals = Boolean.TRUE.equals(returnStatement.getProp(25));
        if (equals) {
            this.decompiler.addName(" ");
        } else {
            this.decompiler.addToken(4);
        }
        AstNode returnValue = returnStatement.getReturnValue();
        Node transform = returnValue == null ? null : transform(returnValue);
        if (!equals) {
            this.decompiler.addEOL(82);
        }
        int lineno = returnStatement.getLineno();
        return returnValue == null ? new Node(4, lineno) : new Node(4, transform, lineno);
    }

    private Node transformScript(ScriptNode scriptNode) {
        this.decompiler.addToken(136);
        if (this.currentScope != null) {
            Kit.codeBug();
        }
        this.currentScope = scriptNode;
        Node node = new Node(129);
        Iterator<Node> it = scriptNode.iterator();
        while (it.hasNext()) {
            node.addChildToBack(transform((AstNode) it.next()));
        }
        scriptNode.removeChildren();
        Node firstChild = node.getFirstChild();
        if (firstChild != null) {
            scriptNode.addChildrenToBack(firstChild);
        }
        return scriptNode;
    }

    private Node transformString(StringLiteral stringLiteral) {
        this.decompiler.addString(stringLiteral.getValue());
        return Node.newString(stringLiteral.getValue());
    }

    private Node transformSwitch(SwitchStatement switchStatement) {
        this.decompiler.addToken(114);
        this.decompiler.addToken(87);
        Node transform = transform(switchStatement.getExpression());
        this.decompiler.addToken(88);
        switchStatement.addChildToBack(transform);
        Node node = new Node(129, switchStatement, switchStatement.getLineno());
        this.decompiler.addEOL(85);
        for (SwitchCase switchCase : switchStatement.getCases()) {
            AstNode expression = switchCase.getExpression();
            Node node2 = null;
            if (expression != null) {
                this.decompiler.addToken(115);
                node2 = transform(expression);
            } else {
                this.decompiler.addToken(116);
            }
            this.decompiler.addEOL(103);
            List<AstNode> statements = switchCase.getStatements();
            Block block = new Block();
            if (statements != null) {
                for (AstNode astNode : statements) {
                    block.addChildToBack(transform(astNode));
                }
            }
            addSwitchCase(node, node2, block);
        }
        this.decompiler.addEOL(86);
        closeSwitch(node);
        return node;
    }

    private Node transformThrow(ThrowStatement throwStatement) {
        this.decompiler.addToken(50);
        Node transform = transform(throwStatement.getExpression());
        this.decompiler.addEOL(82);
        return new Node(50, transform, throwStatement.getLineno());
    }

    private Node transformTry(TryStatement tryStatement) {
        Node emptyExpression;
        this.decompiler.addToken(81);
        this.decompiler.addEOL(85);
        Node transform = transform(tryStatement.getTryBlock());
        this.decompiler.addEOL(86);
        Block block = new Block();
        for (CatchClause catchClause : tryStatement.getCatchClauses()) {
            this.decompiler.addToken(124);
            this.decompiler.addToken(87);
            String identifier = catchClause.getVarName().getIdentifier();
            this.decompiler.addName(identifier);
            AstNode catchCondition = catchClause.getCatchCondition();
            if (catchCondition != null) {
                this.decompiler.addName(" ");
                this.decompiler.addToken(112);
                emptyExpression = transform(catchCondition);
            } else {
                emptyExpression = new EmptyExpression();
            }
            this.decompiler.addToken(88);
            this.decompiler.addEOL(85);
            Node transform2 = transform(catchClause.getBody());
            this.decompiler.addEOL(86);
            block.addChildToBack(createCatch(identifier, emptyExpression, transform2, catchClause.getLineno()));
        }
        Node node = null;
        if (tryStatement.getFinallyBlock() != null) {
            this.decompiler.addToken(125);
            this.decompiler.addEOL(85);
            node = transform(tryStatement.getFinallyBlock());
            this.decompiler.addEOL(86);
        }
        return createTryCatchFinally(transform, block, node, tryStatement.getLineno());
    }

    private Node transformUnary(UnaryExpression unaryExpression) {
        int type = unaryExpression.getType();
        if (type == 74) {
            return transformDefaultXmlNamepace(unaryExpression);
        }
        if (unaryExpression.isPrefix()) {
            this.decompiler.addToken(type);
        }
        Node transform = transform(unaryExpression.getOperand());
        if (unaryExpression.isPostfix()) {
            this.decompiler.addToken(type);
        }
        if (type == 106 || type == 107) {
            return createIncDec(type, unaryExpression.isPostfix(), transform);
        }
        return createUnary(type, transform);
    }

    private Node transformVariables(VariableDeclaration variableDeclaration) {
        this.decompiler.addToken(variableDeclaration.getType());
        transformVariableInitializers(variableDeclaration);
        AstNode parent = variableDeclaration.getParent();
        if (!(parent instanceof Loop) && !(parent instanceof LetNode)) {
            this.decompiler.addEOL(82);
        }
        return variableDeclaration;
    }

    private Node transformVariableInitializers(VariableDeclaration variableDeclaration) {
        Node node;
        List<VariableInitializer> variables = variableDeclaration.getVariables();
        int size = variables.size();
        int i = 0;
        for (VariableInitializer variableInitializer : variables) {
            AstNode target = variableInitializer.getTarget();
            AstNode initializer = variableInitializer.getInitializer();
            if (variableInitializer.isDestructuring()) {
                decompile(target);
                node = target;
            } else {
                node = transform(target);
            }
            Node node2 = null;
            if (initializer != null) {
                this.decompiler.addToken(90);
                node2 = transform(initializer);
            }
            if (!variableInitializer.isDestructuring()) {
                if (node2 != null) {
                    node.addChildToBack(node2);
                }
                variableDeclaration.addChildToBack(node);
            } else if (node2 == null) {
                variableDeclaration.addChildToBack(node);
            } else {
                variableDeclaration.addChildToBack(createDestructuringAssignment(variableDeclaration.getType(), node, node2));
            }
            int i2 = i + 1;
            if (i < size - 1) {
                this.decompiler.addToken(89);
            }
            i = i2;
        }
        return variableDeclaration;
    }

    private Node transformWhileLoop(WhileLoop whileLoop) {
        this.decompiler.addToken(117);
        whileLoop.setType(132);
        pushScope(whileLoop);
        try {
            this.decompiler.addToken(87);
            Node transform = transform(whileLoop.getCondition());
            this.decompiler.addToken(88);
            this.decompiler.addEOL(85);
            Node transform2 = transform(whileLoop.getBody());
            this.decompiler.addEOL(86);
            return createLoop(whileLoop, 1, transform2, transform, null, null);
        } finally {
            popScope();
        }
    }

    private Node transformWith(WithStatement withStatement) {
        this.decompiler.addToken(123);
        this.decompiler.addToken(87);
        Node transform = transform(withStatement.getExpression());
        this.decompiler.addToken(88);
        this.decompiler.addEOL(85);
        Node transform2 = transform(withStatement.getStatement());
        this.decompiler.addEOL(86);
        return createWith(transform, transform2, withStatement.getLineno());
    }

    private Node transformYield(Yield yield) {
        this.decompiler.addToken(72);
        Node transform = yield.getValue() == null ? null : transform(yield.getValue());
        if (transform != null) {
            return new Node(72, transform, yield.getLineno());
        }
        return new Node(72, yield.getLineno());
    }

    private Node transformXmlLiteral(XmlLiteral xmlLiteral) {
        Node transform;
        Node createUnary;
        Node node = new Node(30, xmlLiteral.getLineno());
        List<XmlFragment> fragments = xmlLiteral.getFragments();
        node.addChildToBack(createName(((XmlString) fragments.get(0)).getXml().trim().startsWith("<>") ? "XMLList" : "XML"));
        Node node2 = null;
        for (XmlFragment xmlFragment : fragments) {
            if (xmlFragment instanceof XmlString) {
                String xml = ((XmlString) xmlFragment).getXml();
                this.decompiler.addName(xml);
                if (node2 == null) {
                    node2 = createString(xml);
                } else {
                    node2 = createBinary(21, node2, createString(xml));
                }
            } else {
                XmlExpression xmlExpression = (XmlExpression) xmlFragment;
                boolean isXmlAttribute = xmlExpression.isXmlAttribute();
                this.decompiler.addToken(85);
                if (xmlExpression.getExpression() instanceof EmptyExpression) {
                    transform = createString("");
                } else {
                    transform = transform(xmlExpression.getExpression());
                }
                this.decompiler.addToken(86);
                if (isXmlAttribute) {
                    createUnary = createBinary(21, createBinary(21, createString("\""), createUnary(75, transform)), createString("\""));
                } else {
                    createUnary = createUnary(76, transform);
                }
                node2 = createBinary(21, node2, createUnary);
            }
        }
        node.addChildToBack(node2);
        return node;
    }

    private Node transformXmlMemberGet(XmlMemberGet xmlMemberGet) {
        XmlRef memberRef = xmlMemberGet.getMemberRef();
        Node transform = transform(xmlMemberGet.getLeft());
        int i = memberRef.isAttributeAccess() ? 2 : 0;
        if (xmlMemberGet.getType() == 143) {
            i |= 4;
            this.decompiler.addToken(143);
        } else {
            this.decompiler.addToken(108);
        }
        return transformXmlRef(transform, memberRef, i);
    }

    private Node transformXmlRef(XmlRef xmlRef) {
        return transformXmlRef(null, xmlRef, xmlRef.isAttributeAccess() ? 2 : 0);
    }

    private Node transformXmlRef(Node node, XmlRef xmlRef, int i) {
        if ((i & 2) != 0) {
            this.decompiler.addToken(147);
        }
        Name namespace = xmlRef.getNamespace();
        String identifier = namespace != null ? namespace.getIdentifier() : null;
        if (identifier != null) {
            this.decompiler.addName(identifier);
            this.decompiler.addToken(144);
        }
        if (xmlRef instanceof XmlPropRef) {
            String identifier2 = ((XmlPropRef) xmlRef).getPropName().getIdentifier();
            this.decompiler.addName(identifier2);
            return createPropertyGet(node, identifier, identifier2, i);
        }
        this.decompiler.addToken(83);
        Node transform = transform(((XmlElemRef) xmlRef).getExpression());
        this.decompiler.addToken(84);
        return createElementGet(node, identifier, transform, i);
    }

    private Node transformDefaultXmlNamepace(UnaryExpression unaryExpression) {
        this.decompiler.addToken(116);
        this.decompiler.addName(" xml");
        this.decompiler.addName(" namespace");
        this.decompiler.addToken(90);
        return createUnary(74, transform(unaryExpression.getOperand()));
    }

    private void addSwitchCase(Node node, Node node2, Node node3) {
        if (node.getType() != 129) {
            throw Kit.codeBug();
        }
        Jump jump = (Jump) node.getFirstChild();
        if (jump.getType() != 114) {
            throw Kit.codeBug();
        }
        Node newTarget = Node.newTarget();
        if (node2 != null) {
            Jump jump2 = new Jump(115, node2);
            jump2.target = newTarget;
            jump.addChildToBack(jump2);
        } else {
            jump.setDefault(newTarget);
        }
        node.addChildToBack(newTarget);
        node.addChildToBack(node3);
    }

    private void closeSwitch(Node node) {
        if (node.getType() != 129) {
            throw Kit.codeBug();
        }
        Jump jump = (Jump) node.getFirstChild();
        if (jump.getType() != 114) {
            throw Kit.codeBug();
        }
        Node newTarget = Node.newTarget();
        jump.target = newTarget;
        Node node2 = jump.getDefault();
        if (node2 == null) {
            node2 = newTarget;
        }
        node.addChildAfter(makeJump(5, node2), jump);
        node.addChildToBack(newTarget);
    }

    private Node createExprStatementNoReturn(Node node, int i) {
        return new Node(133, node, i);
    }

    private Node createString(String str) {
        return Node.newString(str);
    }

    private Node createCatch(String str, Node node, Node node2, int i) {
        if (node == null) {
            node = new Node(128);
        }
        return new Node(124, createName(str), node, node2, i);
    }

    private Node initFunction(FunctionNode functionNode, int i, Node node, int i2) {
        Name functionName;
        functionNode.setFunctionType(i2);
        functionNode.addChildToBack(node);
        if (functionNode.getFunctionCount() != 0) {
            functionNode.setRequiresActivation();
        }
        if (i2 == 2 && (functionName = functionNode.getFunctionName()) != null && functionName.length() != 0 && functionNode.getSymbol(functionName.getIdentifier()) == null) {
            functionNode.putSymbol(new Symbol(109, functionName.getIdentifier()));
            node.addChildrenToFront(new Node(133, new Node(8, Node.newString(49, functionName.getIdentifier()), new Node(63))));
        }
        Node lastChild = node.getLastChild();
        if (lastChild == null || lastChild.getType() != 4) {
            node.addChildToBack(new Node(4));
        }
        Node newString = Node.newString(109, functionNode.getName());
        newString.putIntProp(1, i);
        return newString;
    }

    private Scope createLoopNode(Node node, int i) {
        Scope createScopeNode = createScopeNode(132, i);
        if (node != null) {
            ((Jump) node).setLoop(createScopeNode);
        }
        return createScopeNode;
    }

    private Node createFor(Scope scope, Node node, Node node2, Node node3, Node node4) {
        if (node.getType() == 153) {
            Scope splitScope = Scope.splitScope(scope);
            splitScope.setType(153);
            splitScope.addChildrenToBack(node);
            splitScope.addChildToBack(createLoop(scope, 2, node4, node2, new Node(128), node3));
            return splitScope;
        }
        return createLoop(scope, 2, node4, node2, node, node3);
    }

    private Node createLoop(Jump jump, int i, Node node, Node node2, Node node3, Node node4) {
        Node newTarget = Node.newTarget();
        Node newTarget2 = Node.newTarget();
        if (i == 2 && node2.getType() == 128) {
            node2 = new Node(45);
        }
        Jump jump2 = new Jump(6, node2);
        jump2.target = newTarget;
        Node newTarget3 = Node.newTarget();
        jump.addChildToBack(newTarget);
        jump.addChildrenToBack(node);
        if (i == 1 || i == 2) {
            jump.addChildrenToBack(new Node(128, jump.getLineno()));
        }
        jump.addChildToBack(newTarget2);
        jump.addChildToBack(jump2);
        jump.addChildToBack(newTarget3);
        jump.target = newTarget3;
        if (i == 1 || i == 2) {
            jump.addChildToFront(makeJump(5, newTarget2));
            if (i == 2) {
                int type = node3.getType();
                if (type != 128) {
                    if (type != 122 && type != 153) {
                        node3 = new Node(133, node3);
                    }
                    jump.addChildToFront(node3);
                }
                newTarget2 = Node.newTarget();
                jump.addChildAfter(newTarget2, node);
                if (node4.getType() != 128) {
                    jump.addChildAfter(new Node(133, node4), newTarget2);
                }
            }
        }
        jump.setContinue(newTarget2);
        return jump;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.Node createForIn(int r17, org.mozilla.javascript.Node r18, org.mozilla.javascript.Node r19, org.mozilla.javascript.Node r20, org.mozilla.javascript.Node r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.createForIn(int, org.mozilla.javascript.Node, org.mozilla.javascript.Node, org.mozilla.javascript.Node, org.mozilla.javascript.Node, boolean):org.mozilla.javascript.Node");
    }

    private Node createTryCatchFinally(Node node, Node node2, Node node3, int i) {
        boolean z = false;
        boolean z2 = node3 != null && (node3.getType() != 129 || node3.hasChildren());
        if (node.getType() != 129 || node.hasChildren() || z2) {
            boolean hasChildren = node2.hasChildren();
            if (z2 || hasChildren) {
                Node node4 = new Node(141);
                Jump jump = new Jump(81, node, i);
                int i2 = 3;
                jump.putProp(3, node4);
                if (hasChildren) {
                    Node newTarget = Node.newTarget();
                    jump.addChildToBack(makeJump(5, newTarget));
                    Node newTarget2 = Node.newTarget();
                    jump.target = newTarget2;
                    jump.addChildToBack(newTarget2);
                    Node node5 = new Node(141);
                    Node firstChild = node2.getFirstChild();
                    int i3 = 0;
                    while (firstChild != null) {
                        int lineno = firstChild.getLineno();
                        Node firstChild2 = firstChild.getFirstChild();
                        Node next = firstChild2.getNext();
                        Node next2 = next.getNext();
                        firstChild.removeChild(firstChild2);
                        firstChild.removeChild(next);
                        firstChild.removeChild(next2);
                        next2.addChildToBack(new Node(i2));
                        next2.addChildToBack(makeJump(5, newTarget));
                        if (next.getType() == 128) {
                            z = true;
                        } else {
                            next2 = createIf(next, next2, null, lineno);
                        }
                        Node node6 = new Node(57, firstChild2, createUseLocal(node4));
                        node6.putProp(3, node5);
                        node6.putIntProp(14, i3);
                        node5.addChildToBack(node6);
                        node5.addChildToBack(createWith(createUseLocal(node5), next2, lineno));
                        firstChild = firstChild.getNext();
                        i3++;
                        i2 = 3;
                    }
                    jump.addChildToBack(node5);
                    if (!z) {
                        Node node7 = new Node(51);
                        node7.putProp(3, node4);
                        jump.addChildToBack(node7);
                    }
                    jump.addChildToBack(newTarget);
                }
                if (z2) {
                    Node newTarget3 = Node.newTarget();
                    jump.setFinally(newTarget3);
                    jump.addChildToBack(makeJump(135, newTarget3));
                    Node newTarget4 = Node.newTarget();
                    jump.addChildToBack(makeJump(5, newTarget4));
                    jump.addChildToBack(newTarget3);
                    Node node8 = new Node(125, node3);
                    node8.putProp(3, node4);
                    jump.addChildToBack(node8);
                    jump.addChildToBack(newTarget4);
                }
                node4.addChildToBack(jump);
                return node4;
            }
            return node;
        }
        return node;
    }

    private Node createWith(Node node, Node node2, int i) {
        setRequiresActivation();
        Node node3 = new Node(129, i);
        node3.addChildToBack(new Node(2, node));
        node3.addChildrenToBack(new Node(123, node2, i));
        node3.addChildToBack(new Node(3));
        return node3;
    }

    private Node createIf(Node node, Node node2, Node node3, int i) {
        int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
        if (isAlwaysDefinedBoolean == 1) {
            return node2;
        }
        if (isAlwaysDefinedBoolean == -1) {
            return node3 != null ? node3 : new Node(129, i);
        }
        Node node4 = new Node(129, i);
        Node newTarget = Node.newTarget();
        Jump jump = new Jump(7, node);
        jump.target = newTarget;
        node4.addChildToBack(jump);
        node4.addChildrenToBack(node2);
        if (node3 != null) {
            Node newTarget2 = Node.newTarget();
            node4.addChildToBack(makeJump(5, newTarget2));
            node4.addChildToBack(newTarget);
            node4.addChildrenToBack(node3);
            node4.addChildToBack(newTarget2);
        } else {
            node4.addChildToBack(newTarget);
        }
        return node4;
    }

    private Node createCondExpr(Node node, Node node2, Node node3) {
        int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
        return isAlwaysDefinedBoolean == 1 ? node2 : isAlwaysDefinedBoolean == -1 ? node3 : new Node(102, node, node2, node3);
    }

    private Node createUnary(int i, Node node) {
        int type = node.getType();
        switch (i) {
            case 26:
                int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
                if (isAlwaysDefinedBoolean != 0) {
                    int i2 = isAlwaysDefinedBoolean == 1 ? 44 : 45;
                    if (type == 45 || type == 44) {
                        node.setType(i2);
                        return node;
                    }
                    return new Node(i2);
                }
                break;
            case 27:
                if (type == 40) {
                    node.setDouble(~ScriptRuntime.toInt32(node.getDouble()));
                    return node;
                }
                break;
            case 29:
                if (type == 40) {
                    node.setDouble(-node.getDouble());
                    return node;
                }
                break;
            case 31:
                if (type == 39) {
                    node.setType(49);
                    return new Node(i, node, Node.newString(node.getString()));
                } else if (type == 33 || type == 36) {
                    Node firstChild = node.getFirstChild();
                    Node lastChild = node.getLastChild();
                    node.removeChild(firstChild);
                    node.removeChild(lastChild);
                    return new Node(i, firstChild, lastChild);
                } else if (type == 67) {
                    Node firstChild2 = node.getFirstChild();
                    node.removeChild(firstChild2);
                    return new Node(69, firstChild2);
                } else {
                    return new Node(i, new Node(45), node);
                }
            case 32:
                if (type == 39) {
                    node.setType(137);
                    return node;
                }
                break;
        }
        return new Node(i, node);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r7.getLastChild().getString().equals("eval") != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.mozilla.javascript.Node createCallOrNew(int r6, org.mozilla.javascript.Node r7) {
        /*
            r5 = this;
            int r0 = r7.getType()
            r1 = 1
            java.lang.String r2 = "eval"
            r3 = 0
            r4 = 39
            if (r0 != r4) goto L21
            java.lang.String r0 = r7.getString()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L17
            goto L39
        L17:
            java.lang.String r1 = "With"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L38
            r1 = 2
            goto L39
        L21:
            int r0 = r7.getType()
            r4 = 33
            if (r0 != r4) goto L38
            org.mozilla.javascript.Node r0 = r7.getLastChild()
            java.lang.String r0 = r0.getString()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L38
            goto L39
        L38:
            r1 = 0
        L39:
            org.mozilla.javascript.Node r0 = new org.mozilla.javascript.Node
            r0.<init>(r6, r7)
            if (r1 == 0) goto L48
            r5.setRequiresActivation()
            r6 = 10
            r0.putIntProp(r6, r1)
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.createCallOrNew(int, org.mozilla.javascript.Node):org.mozilla.javascript.Node");
    }

    private Node createIncDec(int i, boolean z, Node node) {
        Node makeReference = makeReference(node);
        int type = makeReference.getType();
        if (type == 33 || type == 36 || type == 39 || type == 67) {
            Node node2 = new Node(i, makeReference);
            int i2 = i == 107 ? 1 : 0;
            if (z) {
                i2 |= 2;
            }
            node2.putIntProp(13, i2);
            return node2;
        }
        throw Kit.codeBug();
    }

    private Node createPropertyGet(Node node, String str, String str2, int i) {
        if (str == null && i == 0) {
            if (node == null) {
                return createName(str2);
            }
            checkActivationName(str2, 33);
            if (ScriptRuntime.isSpecialProperty(str2)) {
                Node node2 = new Node(71, node);
                node2.putProp(17, str2);
                return new Node(67, node2);
            }
            return new Node(33, node, Node.newString(str2));
        }
        return createMemberRefGet(node, str, Node.newString(str2), i | 1);
    }

    private Node createElementGet(Node node, String str, Node node2, int i) {
        if (str == null && i == 0) {
            if (node == null) {
                throw Kit.codeBug();
            }
            return new Node(36, node, node2);
        }
        return createMemberRefGet(node, str, node2, i);
    }

    private Node createMemberRefGet(Node node, String str, Node node2, int i) {
        Node node3;
        Node node4;
        Node node5;
        if (str == null) {
            node3 = null;
        } else if (str.equals("*")) {
            node3 = new Node(42);
        } else {
            node3 = createName(str);
        }
        if (node != null) {
            if (str == null) {
                node4 = new Node(77, node, node2);
            } else {
                node4 = new Node(78, node, node3, node2);
            }
            node5 = node4;
        } else if (str == null) {
            node5 = new Node(79, node2);
        } else {
            node5 = new Node(80, node3, node2);
        }
        if (i != 0) {
            node5.putIntProp(16, i);
        }
        return new Node(67, node5);
    }

    private Node createBinary(int i, Node node, Node node2) {
        String numberToString;
        if (i == 104) {
            int isAlwaysDefinedBoolean = isAlwaysDefinedBoolean(node);
            if (isAlwaysDefinedBoolean == 1) {
                return node;
            }
            if (isAlwaysDefinedBoolean == -1) {
                return node2;
            }
        } else if (i != 105) {
            switch (i) {
                case 21:
                    if (node.type == 41) {
                        if (node2.type == 41) {
                            numberToString = node2.getString();
                        } else if (node2.type == 40) {
                            numberToString = ScriptRuntime.numberToString(node2.getDouble(), 10);
                        }
                        node.setString(node.getString().concat(numberToString));
                        return node;
                    } else if (node.type == 40) {
                        if (node2.type == 40) {
                            node.setDouble(node.getDouble() + node2.getDouble());
                            return node;
                        } else if (node2.type == 41) {
                            node2.setString(ScriptRuntime.numberToString(node.getDouble(), 10).concat(node2.getString()));
                            return node2;
                        }
                    }
                    break;
                case 22:
                    if (node.type == 40) {
                        double d = node.getDouble();
                        if (node2.type == 40) {
                            node.setDouble(d - node2.getDouble());
                            return node;
                        } else if (d == 0.0d) {
                            return new Node(29, node2);
                        }
                    } else if (node2.type == 40 && node2.getDouble() == 0.0d) {
                        return new Node(28, node);
                    }
                    break;
                case 23:
                    if (node.type == 40) {
                        double d2 = node.getDouble();
                        if (node2.type == 40) {
                            node.setDouble(d2 * node2.getDouble());
                            return node;
                        } else if (d2 == 1.0d) {
                            return new Node(28, node2);
                        }
                    } else if (node2.type == 40 && node2.getDouble() == 1.0d) {
                        return new Node(28, node);
                    }
                    break;
                case 24:
                    if (node2.type == 40) {
                        double d3 = node2.getDouble();
                        if (node.type == 40) {
                            node.setDouble(node.getDouble() / d3);
                            return node;
                        } else if (d3 == 1.0d) {
                            return new Node(28, node);
                        }
                    }
                    break;
            }
        } else {
            int isAlwaysDefinedBoolean2 = isAlwaysDefinedBoolean(node);
            if (isAlwaysDefinedBoolean2 == -1) {
                return node;
            }
            if (isAlwaysDefinedBoolean2 == 1) {
                return node2;
            }
        }
        return new Node(i, node, node2);
    }

    private Node createAssignment(int i, Node node, Node node2) {
        int i2;
        Node makeReference = makeReference(node);
        if (makeReference == null) {
            if (node.getType() != 65 && node.getType() != 66) {
                reportError("msg.bad.assign.left");
                return node2;
            } else if (i != 90) {
                reportError("msg.bad.destruct.op");
                return node2;
            } else {
                return createDestructuringAssignment(-1, node, node2);
            }
        }
        switch (i) {
            case 90:
                return simpleAssignment(makeReference, node2);
            case 91:
                i2 = 9;
                break;
            case 92:
                i2 = 10;
                break;
            case 93:
                i2 = 11;
                break;
            case 94:
                i2 = 18;
                break;
            case 95:
                i2 = 19;
                break;
            case 96:
                i2 = 20;
                break;
            case 97:
                i2 = 21;
                break;
            case 98:
                i2 = 22;
                break;
            case 99:
                i2 = 23;
                break;
            case 100:
                i2 = 24;
                break;
            case 101:
                i2 = 25;
                break;
            default:
                throw Kit.codeBug();
        }
        int type = makeReference.getType();
        if (type == 33 || type == 36) {
            return new Node(type == 33 ? 139 : 140, makeReference.getFirstChild(), makeReference.getLastChild(), new Node(i2, new Node(138), node2));
        } else if (type == 39) {
            return new Node(8, Node.newString(49, makeReference.getString()), new Node(i2, makeReference, node2));
        } else if (type == 67) {
            Node firstChild = makeReference.getFirstChild();
            checkMutableReference(firstChild);
            return new Node(142, firstChild, new Node(i2, new Node(138), node2));
        } else {
            throw Kit.codeBug();
        }
    }

    private Node createUseLocal(Node node) {
        if (141 != node.getType()) {
            throw Kit.codeBug();
        }
        Node node2 = new Node(54);
        node2.putProp(3, node);
        return node2;
    }

    private Jump makeJump(int i, Node node) {
        Jump jump = new Jump(i);
        jump.target = node;
        return jump;
    }

    private Node makeReference(Node node) {
        int type = node.getType();
        if (type != 33 && type != 36 && type != 67) {
            if (type == 38) {
                node.setType(70);
                return new Node(67, node);
            } else if (type != 39) {
                return null;
            }
        }
        return node;
    }

    private static int isAlwaysDefinedBoolean(Node node) {
        int type = node.getType();
        if (type == 40) {
            double d = node.getDouble();
            return (d != d || d == 0.0d) ? -1 : 1;
        } else if (type == 42 || type == 44) {
            return -1;
        } else {
            return type != 45 ? 0 : 1;
        }
    }

    boolean isDestructuring(Node node) {
        return (node instanceof DestructuringForm) && ((DestructuringForm) node).isDestructuring();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    org.mozilla.javascript.Node decompileFunctionHeader(org.mozilla.javascript.ast.FunctionNode r6) {
        /*
            r5 = this;
            org.mozilla.javascript.ast.Name r0 = r6.getFunctionName()
            if (r0 == 0) goto L10
            org.mozilla.javascript.Decompiler r0 = r5.decompiler
            java.lang.String r1 = r6.getName()
            r0.addName(r1)
            goto L1f
        L10:
            org.mozilla.javascript.ast.AstNode r0 = r6.getMemberExprNode()
            if (r0 == 0) goto L1f
            org.mozilla.javascript.ast.AstNode r0 = r6.getMemberExprNode()
            org.mozilla.javascript.Node r0 = r5.transform(r0)
            goto L20
        L1f:
            r0 = 0
        L20:
            org.mozilla.javascript.Decompiler r1 = r5.decompiler
            r2 = 87
            r1.addToken(r2)
            java.util.List r1 = r6.getParams()
            r2 = 0
        L2c:
            int r3 = r1.size()
            if (r2 >= r3) goto L4d
            java.lang.Object r3 = r1.get(r2)
            org.mozilla.javascript.ast.AstNode r3 = (org.mozilla.javascript.ast.AstNode) r3
            r5.decompile(r3)
            int r3 = r1.size()
            int r3 = r3 + (-1)
            if (r2 >= r3) goto L4a
            org.mozilla.javascript.Decompiler r3 = r5.decompiler
            r4 = 89
            r3.addToken(r4)
        L4a:
            int r2 = r2 + 1
            goto L2c
        L4d:
            org.mozilla.javascript.Decompiler r1 = r5.decompiler
            r2 = 88
            r1.addToken(r2)
            boolean r6 = r6.isExpressionClosure()
            if (r6 != 0) goto L61
            org.mozilla.javascript.Decompiler r6 = r5.decompiler
            r1 = 85
            r6.addEOL(r1)
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.IRFactory.decompileFunctionHeader(org.mozilla.javascript.ast.FunctionNode):org.mozilla.javascript.Node");
    }

    void decompile(AstNode astNode) {
        int type = astNode.getType();
        if (type == 33) {
            decompilePropertyGet((PropertyGet) astNode);
        } else if (type == 36) {
            decompileElementGet((ElementGet) astNode);
        } else if (type == 43) {
            this.decompiler.addToken(astNode.getType());
        } else if (type != 128) {
            if (type == 65) {
                decompileArrayLiteral((ArrayLiteral) astNode);
            } else if (type == 66) {
                decompileObjectLiteral((ObjectLiteral) astNode);
            } else {
                switch (type) {
                    case 39:
                        this.decompiler.addName(((Name) astNode).getIdentifier());
                        return;
                    case 40:
                        this.decompiler.addNumber(((NumberLiteral) astNode).getNumber());
                        return;
                    case 41:
                        this.decompiler.addString(((StringLiteral) astNode).getValue());
                        return;
                    default:
                        Kit.codeBug("unexpected token: " + Token.typeToName(astNode.getType()));
                        return;
                }
            }
        }
    }

    void decompileArrayLiteral(ArrayLiteral arrayLiteral) {
        this.decompiler.addToken(83);
        List<AstNode> elements = arrayLiteral.getElements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            decompile(elements.get(i));
            if (i < size - 1) {
                this.decompiler.addToken(89);
            }
        }
        this.decompiler.addToken(84);
    }

    void decompileObjectLiteral(ObjectLiteral objectLiteral) {
        this.decompiler.addToken(85);
        List<ObjectProperty> elements = objectLiteral.getElements();
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            ObjectProperty objectProperty = elements.get(i);
            boolean equals = Boolean.TRUE.equals(objectProperty.getProp(26));
            decompile(objectProperty.getLeft());
            if (!equals) {
                this.decompiler.addToken(103);
                decompile(objectProperty.getRight());
            }
            if (i < size - 1) {
                this.decompiler.addToken(89);
            }
        }
        this.decompiler.addToken(86);
    }

    void decompilePropertyGet(PropertyGet propertyGet) {
        decompile(propertyGet.getTarget());
        this.decompiler.addToken(108);
        decompile(propertyGet.getProperty());
    }

    void decompileElementGet(ElementGet elementGet) {
        decompile(elementGet.getTarget());
        this.decompiler.addToken(83);
        decompile(elementGet.getElement());
        this.decompiler.addToken(84);
    }
}
