package androidx.mediarouter.media;

import java.util.function.Function;

/* compiled from: lambda */
/* renamed from: androidx.mediarouter.media.-$$Lambda$Twvfyu_CiYiiXMtHxak2eCeWHII  reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$Twvfyu_CiYiiXMtHxak2eCeWHII implements Function {
    public static final /* synthetic */ $$Lambda$Twvfyu_CiYiiXMtHxak2eCeWHII INSTANCE = new $$Lambda$Twvfyu_CiYiiXMtHxak2eCeWHII();

    private /* synthetic */ $$Lambda$Twvfyu_CiYiiXMtHxak2eCeWHII() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return MediaRouter2Utils.toFwkMediaRoute2Info((MediaRouteDescriptor) obj);
    }
}
