package androidx.mediarouter.media;

import android.media.MediaRoute2Info;
import java.util.function.Function;

/* compiled from: lambda */
/* renamed from: androidx.mediarouter.media.-$$Lambda$iyp1EEA7zCvqlfmUyS8TKLSdbCY  reason: invalid class name */
/* loaded from: classes.dex */
public final /* synthetic */ class $$Lambda$iyp1EEA7zCvqlfmUyS8TKLSdbCY implements Function {
    public static final /* synthetic */ $$Lambda$iyp1EEA7zCvqlfmUyS8TKLSdbCY INSTANCE = new $$Lambda$iyp1EEA7zCvqlfmUyS8TKLSdbCY();

    private /* synthetic */ $$Lambda$iyp1EEA7zCvqlfmUyS8TKLSdbCY() {
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return MediaRouter2Utils.toMediaRouteDescriptor((MediaRoute2Info) obj);
    }
}
