package org.acra.config;

import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassValidator.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\"\u0006\u0012\u0002\b\u00030\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m107d2 = {"Lorg/acra/config/ClassValidator;", "", "()V", "check", "", "classes", "", "Ljava/lang/Class;", "([Ljava/lang/Class;)V", "acra-javacore"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ClassValidator {
    public static final ClassValidator INSTANCE = new ClassValidator();

    private ClassValidator() {
    }

    @JvmStatic
    public static final void check(Class<?>... classes) throws ACRAConfigurationException {
        Intrinsics.checkNotNullParameter(classes, "classes");
        int length = classes.length;
        int i = 0;
        while (i < length) {
            Class<?> cls = classes[i];
            i++;
            if (cls.isInterface()) {
                throw new ACRAConfigurationException("Expected class, but found interface " + ((Object) cls.getName()) + '.');
            } else if (Modifier.isAbstract(cls.getModifiers())) {
                throw new ACRAConfigurationException("Class " + ((Object) cls.getName()) + " cannot be abstract.");
            } else if (cls.getEnclosingClass() != null && !Modifier.isStatic(cls.getModifiers())) {
                throw new ACRAConfigurationException("Class " + ((Object) cls.getName()) + " has to be static.");
            } else {
                try {
                    cls.getConstructor(new Class[0]);
                } catch (NoSuchMethodException e) {
                    throw new ACRAConfigurationException("Class " + ((Object) cls.getName()) + " is missing a no-args Constructor.", e);
                }
            }
        }
    }
}
