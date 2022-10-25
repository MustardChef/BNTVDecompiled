package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.javaLoading;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes4.dex */
public final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {
    final /* synthetic */ ClassDeclaredMemberIndex this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.this$0 = classDeclaredMemberIndex;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(JavaMethod m) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(m, "m");
        function1 = this.this$0.memberFilter;
        return Boolean.valueOf(((Boolean) function1.invoke(m)).booleanValue() && !javaLoading.isObjectMethodInInterface(m));
    }
}
