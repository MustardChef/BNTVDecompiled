package androidx.mediarouter.media;

import androidx.mediarouter.media.MediaRoute2ProviderServiceAdapter;
import java.util.function.Predicate;

/* compiled from: lambda */
/* renamed from: androidx.mediarouter.media.-$$Lambda$MediaRoute2ProviderServiceAdapter$3D53z38Pb96BXRMYfPIombydoa0 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0589xd2ec1109 implements Predicate {
    public static final /* synthetic */ C0589xd2ec1109 INSTANCE = new C0589xd2ec1109();

    private /* synthetic */ C0589xd2ec1109() {
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return MediaRoute2ProviderServiceAdapter.lambda$updateStaticSessions$3((MediaRoute2ProviderServiceAdapter.SessionRecord) obj);
    }
}
