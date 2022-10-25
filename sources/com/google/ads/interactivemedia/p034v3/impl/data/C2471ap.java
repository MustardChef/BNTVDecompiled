package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avj;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ap */
/* loaded from: classes2.dex */
final class C2471ap implements TestingConfiguration.Builder {
    private Boolean disableExperiments;
    private Boolean disableOnScreenDetection;
    private Boolean disableSkipFadeTransition;
    private Boolean enableMonitorAppLifecycle;
    private avj<String, Object> extraParams;
    private avg<Integer> forceExperimentIds;
    private Boolean forceTvMode;
    private Boolean ignoreStrictModeFalsePositives;
    private Boolean useTestStreamManager;
    private Boolean useVideoElementMock;
    private Float videoElementMockDuration;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration build() {
        Boolean bool = this.disableExperiments;
        if (bool == null || this.disableOnScreenDetection == null || this.disableSkipFadeTransition == null || this.useVideoElementMock == null || this.videoElementMockDuration == null || this.useTestStreamManager == null || this.enableMonitorAppLifecycle == null || this.forceTvMode == null || this.ignoreStrictModeFalsePositives == null) {
            StringBuilder sb = new StringBuilder();
            if (this.disableExperiments == null) {
                sb.append(" disableExperiments");
            }
            if (this.disableOnScreenDetection == null) {
                sb.append(" disableOnScreenDetection");
            }
            if (this.disableSkipFadeTransition == null) {
                sb.append(" disableSkipFadeTransition");
            }
            if (this.useVideoElementMock == null) {
                sb.append(" useVideoElementMock");
            }
            if (this.videoElementMockDuration == null) {
                sb.append(" videoElementMockDuration");
            }
            if (this.useTestStreamManager == null) {
                sb.append(" useTestStreamManager");
            }
            if (this.enableMonitorAppLifecycle == null) {
                sb.append(" enableMonitorAppLifecycle");
            }
            if (this.forceTvMode == null) {
                sb.append(" forceTvMode");
            }
            if (this.ignoreStrictModeFalsePositives == null) {
                sb.append(" ignoreStrictModeFalsePositives");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new C2473ar(bool.booleanValue(), this.disableOnScreenDetection.booleanValue(), this.disableSkipFadeTransition.booleanValue(), this.forceExperimentIds, this.useVideoElementMock.booleanValue(), this.videoElementMockDuration.floatValue(), this.useTestStreamManager.booleanValue(), this.enableMonitorAppLifecycle.booleanValue(), this.forceTvMode.booleanValue(), this.ignoreStrictModeFalsePositives.booleanValue(), this.extraParams, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableExperiments(boolean z) {
        this.disableExperiments = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableOnScreenDetection(boolean z) {
        this.disableOnScreenDetection = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder disableSkipFadeTransition(boolean z) {
        this.disableSkipFadeTransition = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder enableMonitorAppLifecycle(boolean z) {
        this.enableMonitorAppLifecycle = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder extraParams(avj<String, Object> avjVar) {
        this.extraParams = avjVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder forceExperimentIds(avg<Integer> avgVar) {
        this.forceExperimentIds = avgVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder forceTvMode(boolean z) {
        this.forceTvMode = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder ignoreStrictModeFalsePositives(boolean z) {
        this.ignoreStrictModeFalsePositives = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder useTestStreamManager(boolean z) {
        this.useTestStreamManager = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder useVideoElementMock(boolean z) {
        this.useVideoElementMock = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration.Builder
    public TestingConfiguration.Builder videoElementMockDuration(float f) {
        this.videoElementMockDuration = Float.valueOf(f);
        return this;
    }
}
