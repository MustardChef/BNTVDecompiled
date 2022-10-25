package kotlin.reflect.jvm.internal;

/* renamed from: kotlin.reflect.jvm.internal.Util  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
class C5588Util {
    public static Object getEnumConstantByName(Class<? extends Enum<?>> cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
