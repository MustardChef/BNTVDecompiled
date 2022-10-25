package androidx.window.layout;

import android.graphics.Rect;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeWindowLayoutComponentProvider.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends Lambda implements Functions<Boolean> {
    final /* synthetic */ ClassLoader $classLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(ClassLoader classLoader) {
        super(0);
        this.$classLoader = classLoader;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Functions
    public final Boolean invoke() {
        Class foldingFeatureClass;
        boolean doesReturn;
        boolean isPublic;
        boolean doesReturn2;
        boolean isPublic2;
        boolean doesReturn3;
        boolean isPublic3;
        foldingFeatureClass = SafeWindowLayoutComponentProvider.INSTANCE.foldingFeatureClass(this.$classLoader);
        boolean z = false;
        Method getBoundsMethod = foldingFeatureClass.getMethod("getBounds", new Class[0]);
        Method getTypeMethod = foldingFeatureClass.getMethod("getType", new Class[0]);
        Method getStateMethod = foldingFeatureClass.getMethod("getState", new Class[0]);
        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(getBoundsMethod, "getBoundsMethod");
        doesReturn = safeWindowLayoutComponentProvider.doesReturn(getBoundsMethod, Reflection.getOrCreateKotlinClass(Rect.class));
        if (doesReturn) {
            isPublic = SafeWindowLayoutComponentProvider.INSTANCE.isPublic(getBoundsMethod);
            if (isPublic) {
                SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider2 = SafeWindowLayoutComponentProvider.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(getTypeMethod, "getTypeMethod");
                doesReturn2 = safeWindowLayoutComponentProvider2.doesReturn(getTypeMethod, Reflection.getOrCreateKotlinClass(Integer.TYPE));
                if (doesReturn2) {
                    isPublic2 = SafeWindowLayoutComponentProvider.INSTANCE.isPublic(getTypeMethod);
                    if (isPublic2) {
                        SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider3 = SafeWindowLayoutComponentProvider.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(getStateMethod, "getStateMethod");
                        doesReturn3 = safeWindowLayoutComponentProvider3.doesReturn(getStateMethod, Reflection.getOrCreateKotlinClass(Integer.TYPE));
                        if (doesReturn3) {
                            isPublic3 = SafeWindowLayoutComponentProvider.INSTANCE.isPublic(getStateMethod);
                            if (isPublic3) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
