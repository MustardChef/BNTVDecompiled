package org.mozilla.javascript;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JavaMembers.java */
/* loaded from: classes5.dex */
public class BeanProperty {
    MemberBox getter;
    MemberBox setter;
    NativeJavaMethod setters;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BeanProperty(MemberBox memberBox, MemberBox memberBox2, NativeJavaMethod nativeJavaMethod) {
        this.getter = memberBox;
        this.setter = memberBox2;
        this.setters = nativeJavaMethod;
    }
}
