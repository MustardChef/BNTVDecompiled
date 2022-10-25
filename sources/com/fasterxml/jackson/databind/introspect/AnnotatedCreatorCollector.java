package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AnnotatedCreatorCollector extends CollectorBase {
    private final boolean _collectAnnotations;
    private AnnotatedConstructor _defaultConstructor;
    private final TypeResolutionContext _typeContext;

    AnnotatedCreatorCollector(AnnotationIntrospector annotationIntrospector, TypeResolutionContext typeResolutionContext, boolean z) {
        super(annotationIntrospector);
        this._typeContext = typeResolutionContext;
        this._collectAnnotations = z;
    }

    public static AnnotatedClass.Creators collectCreators(AnnotationIntrospector annotationIntrospector, TypeFactory typeFactory, TypeResolutionContext typeResolutionContext, JavaType javaType, Class<?> cls, boolean z) {
        return new AnnotatedCreatorCollector(annotationIntrospector, typeResolutionContext, z | (cls != null)).collect(typeFactory, javaType, cls);
    }

    AnnotatedClass.Creators collect(TypeFactory typeFactory, JavaType javaType, Class<?> cls) {
        List<AnnotatedConstructor> _findPotentialConstructors = _findPotentialConstructors(javaType, cls);
        List<AnnotatedMethod> _findPotentialFactories = _findPotentialFactories(typeFactory, javaType, cls);
        if (this._collectAnnotations) {
            if (this._defaultConstructor != null && this._intr.hasIgnoreMarker(this._defaultConstructor)) {
                this._defaultConstructor = null;
            }
            int size = _findPotentialConstructors.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else if (this._intr.hasIgnoreMarker(_findPotentialConstructors.get(size))) {
                    _findPotentialConstructors.remove(size);
                }
            }
            int size2 = _findPotentialFactories.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    break;
                } else if (this._intr.hasIgnoreMarker(_findPotentialFactories.get(size2))) {
                    _findPotentialFactories.remove(size2);
                }
            }
        }
        return new AnnotatedClass.Creators(this._defaultConstructor, _findPotentialConstructors, _findPotentialFactories);
    }

    private List<AnnotatedConstructor> _findPotentialConstructors(JavaType javaType, Class<?> cls) {
        ClassUtil.Ctor ctor;
        ArrayList arrayList;
        int i;
        List<AnnotatedConstructor> list;
        ClassUtil.Ctor[] constructors;
        ClassUtil.Ctor[] constructors2;
        if (javaType.isEnumType()) {
            ctor = null;
            arrayList = null;
        } else {
            ctor = null;
            arrayList = null;
            for (ClassUtil.Ctor ctor2 : ClassUtil.getConstructors(javaType.getRawClass())) {
                if (isIncludableConstructor(ctor2.getConstructor())) {
                    if (ctor2.getParamCount() == 0) {
                        ctor = ctor2;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(ctor2);
                    }
                }
            }
        }
        if (arrayList == null) {
            list = Collections.emptyList();
            if (ctor == null) {
                return list;
            }
            i = 0;
        } else {
            int size = arrayList.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(null);
            }
            i = size;
            list = arrayList2;
        }
        if (cls != null) {
            MemberKey[] memberKeyArr = null;
            for (ClassUtil.Ctor ctor3 : ClassUtil.getConstructors(cls)) {
                if (ctor3.getParamCount() == 0) {
                    if (ctor != null) {
                        this._defaultConstructor = constructDefaultConstructor(ctor, ctor3);
                        ctor = null;
                    }
                } else if (arrayList != null) {
                    if (memberKeyArr == null) {
                        memberKeyArr = new MemberKey[i];
                        for (int i3 = 0; i3 < i; i3++) {
                            memberKeyArr[i3] = new MemberKey(((ClassUtil.Ctor) arrayList.get(i3)).getConstructor());
                        }
                    }
                    MemberKey memberKey = new MemberKey(ctor3.getConstructor());
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i) {
                            break;
                        } else if (memberKey.equals(memberKeyArr[i4])) {
                            list.set(i4, constructNonDefaultConstructor((ClassUtil.Ctor) arrayList.get(i4), ctor3));
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
        }
        if (ctor != null) {
            this._defaultConstructor = constructDefaultConstructor(ctor, null);
        }
        for (int i5 = 0; i5 < i; i5++) {
            if (list.get(i5) == null) {
                list.set(i5, constructNonDefaultConstructor((ClassUtil.Ctor) arrayList.get(i5), null));
            }
        }
        return list;
    }

    private List<AnnotatedMethod> _findPotentialFactories(TypeFactory typeFactory, JavaType javaType, Class<?> cls) {
        Method[] classMethods;
        Method[] declaredMethods;
        ArrayList arrayList = null;
        for (Method method : ClassUtil.getClassMethods(javaType.getRawClass())) {
            if (_isIncludableFactoryMethod(method)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(method);
            }
        }
        if (arrayList == null) {
            return Collections.emptyList();
        }
        TypeResolutionContext typeResolutionContext = this._typeContext;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        if (cls != null) {
            MemberKey[] memberKeyArr = null;
            for (Method method2 : cls.getDeclaredMethods()) {
                if (_isIncludableFactoryMethod(method2)) {
                    if (memberKeyArr == null) {
                        memberKeyArr = new MemberKey[size];
                        for (int i2 = 0; i2 < size; i2++) {
                            memberKeyArr[i2] = new MemberKey((Method) arrayList.get(i2));
                        }
                    }
                    MemberKey memberKey = new MemberKey(method2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        } else if (memberKey.equals(memberKeyArr[i3])) {
                            arrayList2.set(i3, constructFactoryCreator((Method) arrayList.get(i3), typeResolutionContext, method2));
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (((AnnotatedMethod) arrayList2.get(i4)) == null) {
                Method method3 = (Method) arrayList.get(i4);
                arrayList2.set(i4, constructFactoryCreator(method3, MethodGenericTypeResolver.narrowMethodTypeParameters(method3, javaType, typeFactory, typeResolutionContext), null));
            }
        }
        return arrayList2;
    }

    private static boolean _isIncludableFactoryMethod(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    protected AnnotatedConstructor constructDefaultConstructor(ClassUtil.Ctor ctor, ClassUtil.Ctor ctor2) {
        return new AnnotatedConstructor(this._typeContext, ctor.getConstructor(), collectAnnotations(ctor, ctor2), NO_ANNOTATION_MAPS);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.fasterxml.jackson.databind.introspect.AnnotatedConstructor constructNonDefaultConstructor(com.fasterxml.jackson.databind.util.ClassUtil.Ctor r9, com.fasterxml.jackson.databind.util.ClassUtil.Ctor r10) {
        /*
            r8 = this;
            int r0 = r9.getParamCount()
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r8._intr
            if (r1 != 0) goto L1c
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r10 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            com.fasterxml.jackson.databind.introspect.TypeResolutionContext r1 = r8._typeContext
            java.lang.reflect.Constructor r9 = r9.getConstructor()
            com.fasterxml.jackson.databind.introspect.AnnotationMap r2 = _emptyAnnotationMap()
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r0 = _emptyAnnotationMaps(r0)
            r10.<init>(r1, r9, r2, r0)
            return r10
        L1c:
            if (r0 != 0) goto L30
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            com.fasterxml.jackson.databind.introspect.TypeResolutionContext r1 = r8._typeContext
            java.lang.reflect.Constructor r2 = r9.getConstructor()
            com.fasterxml.jackson.databind.introspect.AnnotationMap r9 = r8.collectAnnotations(r9, r10)
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r10 = com.fasterxml.jackson.databind.introspect.AnnotatedCreatorCollector.NO_ANNOTATION_MAPS
            r0.<init>(r1, r2, r9, r10)
            return r0
        L30:
            java.lang.annotation.Annotation[][] r1 = r9.getParameterAnnotations()
            int r2 = r1.length
            r3 = 0
            if (r0 == r2) goto L9f
            java.lang.Class r2 = r9.getDeclaringClass()
            boolean r4 = com.fasterxml.jackson.databind.util.ClassUtil.isEnumType(r2)
            r5 = 0
            r6 = 1
            r7 = 2
            if (r4 == 0) goto L59
            int r4 = r1.length
            int r4 = r4 + r7
            if (r0 != r4) goto L59
            int r2 = r1.length
            int r2 = r2 + r7
            java.lang.annotation.Annotation[][] r2 = new java.lang.annotation.Annotation[r2]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r5, r2, r7, r4)
            java.lang.annotation.Annotation[][] r3 = (java.lang.annotation.Annotation[][]) r3
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r3 = r8.collectAnnotations(r2, r3)
        L57:
            r1 = r2
            goto L76
        L59:
            boolean r2 = r2.isMemberClass()
            if (r2 == 0) goto L76
            int r2 = r1.length
            int r2 = r2 + r6
            if (r0 != r2) goto L76
            int r2 = r1.length
            int r2 = r2 + r6
            java.lang.annotation.Annotation[][] r2 = new java.lang.annotation.Annotation[r2]
            int r4 = r1.length
            java.lang.System.arraycopy(r1, r5, r2, r6, r4)
            java.lang.annotation.Annotation[] r1 = com.fasterxml.jackson.databind.introspect.AnnotatedCreatorCollector.NO_ANNOTATIONS
            r2[r5] = r1
            java.lang.annotation.Annotation[][] r3 = (java.lang.annotation.Annotation[][]) r3
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r3 = r8.collectAnnotations(r2, r3)
            goto L57
        L76:
            if (r3 == 0) goto L79
            goto Lac
        L79:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Class r9 = r9.getDeclaringClass()
            java.lang.String r9 = r9.getName()
            r2[r5] = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
            r2[r6] = r9
            int r9 = r1.length
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r2[r7] = r9
            java.lang.String r9 = "Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations"
            java.lang.String r9 = java.lang.String.format(r9, r2)
            r10.<init>(r9)
            throw r10
        L9f:
            if (r10 != 0) goto La4
            java.lang.annotation.Annotation[][] r3 = (java.lang.annotation.Annotation[][]) r3
            goto La8
        La4:
            java.lang.annotation.Annotation[][] r3 = r10.getParameterAnnotations()
        La8:
            com.fasterxml.jackson.databind.introspect.AnnotationMap[] r3 = r8.collectAnnotations(r1, r3)
        Lac:
            com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r0 = new com.fasterxml.jackson.databind.introspect.AnnotatedConstructor
            com.fasterxml.jackson.databind.introspect.TypeResolutionContext r1 = r8._typeContext
            java.lang.reflect.Constructor r2 = r9.getConstructor()
            com.fasterxml.jackson.databind.introspect.AnnotationMap r9 = r8.collectAnnotations(r9, r10)
            r0.<init>(r1, r2, r9, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.introspect.AnnotatedCreatorCollector.constructNonDefaultConstructor(com.fasterxml.jackson.databind.util.ClassUtil$Ctor, com.fasterxml.jackson.databind.util.ClassUtil$Ctor):com.fasterxml.jackson.databind.introspect.AnnotatedConstructor");
    }

    protected AnnotatedMethod constructFactoryCreator(Method method, TypeResolutionContext typeResolutionContext, Method method2) {
        int length = method.getParameterTypes().length;
        if (this._intr == null) {
            return new AnnotatedMethod(typeResolutionContext, method, _emptyAnnotationMap(), _emptyAnnotationMaps(length));
        }
        if (length == 0) {
            return new AnnotatedMethod(typeResolutionContext, method, collectAnnotations(method, method2), NO_ANNOTATION_MAPS);
        }
        return new AnnotatedMethod(typeResolutionContext, method, collectAnnotations(method, method2), collectAnnotations(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    private AnnotationMap[] collectAnnotations(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (this._collectAnnotations) {
            int length = annotationArr.length;
            AnnotationMap[] annotationMapArr = new AnnotationMap[length];
            for (int i = 0; i < length; i++) {
                AnnotationCollector collectAnnotations = collectAnnotations(AnnotationCollector.emptyCollector(), annotationArr[i]);
                if (annotationArr2 != null) {
                    collectAnnotations = collectAnnotations(collectAnnotations, annotationArr2[i]);
                }
                annotationMapArr[i] = collectAnnotations.asAnnotationMap();
            }
            return annotationMapArr;
        }
        return NO_ANNOTATION_MAPS;
    }

    private AnnotationMap collectAnnotations(ClassUtil.Ctor ctor, ClassUtil.Ctor ctor2) {
        if (this._collectAnnotations) {
            AnnotationCollector collectAnnotations = collectAnnotations(ctor.getDeclaredAnnotations());
            if (ctor2 != null) {
                collectAnnotations = collectAnnotations(collectAnnotations, ctor2.getDeclaredAnnotations());
            }
            return collectAnnotations.asAnnotationMap();
        }
        return _emptyAnnotationMap();
    }

    private final AnnotationMap collectAnnotations(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        AnnotationCollector collectAnnotations = collectAnnotations(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            collectAnnotations = collectAnnotations(collectAnnotations, annotatedElement2.getDeclaredAnnotations());
        }
        return collectAnnotations.asAnnotationMap();
    }

    private static boolean isIncludableConstructor(Constructor<?> constructor) {
        return !constructor.isSynthetic();
    }
}
