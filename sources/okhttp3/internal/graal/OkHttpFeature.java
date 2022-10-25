package okhttp3.internal.graal;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.configure.ResourcesRegistry;
import kotlin.Metadata;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;

/* compiled from: OkHttpFeature.kt */
@AutomaticFeature
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, m107d2 = {"Lokhttp3/internal/graal/OkHttpFeature;", "Lorg/graalvm/nativeimage/hosted/Feature;", "()V", "beforeAnalysis", "", "access", "Lorg/graalvm/nativeimage/hosted/Feature$BeforeAnalysisAccess;", "okhttp"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class OkHttpFeature implements Feature {
    public void beforeAnalysis(Feature.BeforeAnalysisAccess beforeAnalysisAccess) {
        ((ResourcesRegistry) ImageSingletons.lookup(ResourcesRegistry.class)).addResources("\\Qokhttp3/internal/publicsuffix/PublicSuffixDatabase.gz\\E");
    }
}
