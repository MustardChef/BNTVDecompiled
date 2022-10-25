package kotlin.reflect.jvm.internal.impl.load.java.structure;

/* compiled from: javaElements.kt */
/* loaded from: classes4.dex */
public interface JavaField extends JavaMember {
    boolean getHasConstantNotNullInitializer();

    JavaType getType();

    boolean isEnumEntry();
}
