package androidx.mediarouter.media;

import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.function.Function;

/* compiled from: lambda */
/* renamed from: androidx.mediarouter.media.-$$Lambda$RegisteredMediaRouteProviderWatcher$OE32BQCzIds-f8qqGlirA97I_us */
/* loaded from: classes.dex */
public final /* synthetic */ class C0595xc29a1a33 implements Function {
    public static final /* synthetic */ C0595xc29a1a33 INSTANCE = new C0595xc29a1a33();

    private /* synthetic */ C0595xc29a1a33() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        ServiceInfo serviceInfo;
        serviceInfo = ((ResolveInfo) obj).serviceInfo;
        return serviceInfo;
    }
}
