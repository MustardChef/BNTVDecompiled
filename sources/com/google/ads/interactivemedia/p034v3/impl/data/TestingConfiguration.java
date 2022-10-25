package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avj;

/* compiled from: IMASDK */
@ate(m4626a = C2473ar.class, m4625b = {"extraParams", "isTv", "ignoreStrictModeFalsePositives"})
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration */
/* loaded from: classes2.dex */
public abstract class TestingConfiguration {
    public static final String PARAMETER_KEY = "tcnfp";

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.impl.data.TestingConfiguration$Builder */
    /* loaded from: classes2.dex */
    public interface Builder {
        TestingConfiguration build();

        Builder disableExperiments(boolean z);

        Builder disableOnScreenDetection(boolean z);

        Builder disableSkipFadeTransition(boolean z);

        Builder enableMonitorAppLifecycle(boolean z);

        Builder extraParams(avj<String, Object> avjVar);

        Builder forceExperimentIds(avg<Integer> avgVar);

        Builder forceTvMode(boolean z);

        Builder ignoreStrictModeFalsePositives(boolean z);

        Builder useTestStreamManager(boolean z);

        Builder useVideoElementMock(boolean z);

        Builder videoElementMockDuration(float f);
    }

    public static Builder builder() {
        C2471ap c2471ap = new C2471ap();
        c2471ap.disableExperiments(true);
        c2471ap.disableOnScreenDetection(false);
        c2471ap.disableSkipFadeTransition(true);
        c2471ap.useVideoElementMock(false);
        c2471ap.videoElementMockDuration(30.0f);
        c2471ap.useTestStreamManager(false);
        c2471ap.ignoreStrictModeFalsePositives(false);
        c2471ap.forceTvMode(false);
        c2471ap.forceExperimentIds(null);
        c2471ap.enableMonitorAppLifecycle(true);
        return c2471ap;
    }

    public Builder copy() {
        C2471ap c2471ap = new C2471ap();
        c2471ap.disableExperiments(disableExperiments());
        c2471ap.disableOnScreenDetection(disableOnScreenDetection());
        c2471ap.disableSkipFadeTransition(disableSkipFadeTransition());
        c2471ap.useVideoElementMock(useVideoElementMock());
        c2471ap.videoElementMockDuration(videoElementMockDuration());
        c2471ap.useTestStreamManager(useTestStreamManager());
        c2471ap.forceExperimentIds(forceExperimentIds());
        c2471ap.enableMonitorAppLifecycle(enableMonitorAppLifecycle());
        c2471ap.forceTvMode(forceTvMode());
        c2471ap.ignoreStrictModeFalsePositives(ignoreStrictModeFalsePositives());
        c2471ap.extraParams(extraParams());
        return c2471ap;
    }

    public abstract boolean disableExperiments();

    public abstract boolean disableOnScreenDetection();

    public abstract boolean disableSkipFadeTransition();

    public abstract boolean enableMonitorAppLifecycle();

    public abstract avj<String, Object> extraParams();

    public abstract avg<Integer> forceExperimentIds();

    public abstract boolean forceTvMode();

    public abstract boolean ignoreStrictModeFalsePositives();

    public abstract boolean useTestStreamManager();

    public abstract boolean useVideoElementMock();

    public abstract float videoElementMockDuration();
}
