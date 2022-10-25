package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avj;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ar */
/* loaded from: classes2.dex */
final class C2473ar extends TestingConfiguration {
    private final boolean disableExperiments;
    private final boolean disableOnScreenDetection;
    private final boolean disableSkipFadeTransition;
    private final boolean enableMonitorAppLifecycle;
    private final avj<String, Object> extraParams;
    private final avg<Integer> forceExperimentIds;
    private final boolean forceTvMode;
    private final boolean ignoreStrictModeFalsePositives;
    private final boolean useTestStreamManager;
    private final boolean useVideoElementMock;
    private final float videoElementMockDuration;

    private C2473ar(boolean z, boolean z2, boolean z3, avg<Integer> avgVar, boolean z4, float f, boolean z5, boolean z6, boolean z7, boolean z8, avj<String, Object> avjVar) {
        this.disableExperiments = z;
        this.disableOnScreenDetection = z2;
        this.disableSkipFadeTransition = z3;
        this.forceExperimentIds = avgVar;
        this.useVideoElementMock = z4;
        this.videoElementMockDuration = f;
        this.useTestStreamManager = z5;
        this.enableMonitorAppLifecycle = z6;
        this.forceTvMode = z7;
        this.ignoreStrictModeFalsePositives = z8;
        this.extraParams = avjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2473ar(boolean z, boolean z2, boolean z3, avg avgVar, boolean z4, float f, boolean z5, boolean z6, boolean z7, boolean z8, avj avjVar, C2472aq c2472aq) {
        this(z, z2, z3, avgVar, z4, f, z5, z6, z7, z8, avjVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean disableExperiments() {
        return this.disableExperiments;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean disableOnScreenDetection() {
        return this.disableOnScreenDetection;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean disableSkipFadeTransition() {
        return this.disableSkipFadeTransition;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean enableMonitorAppLifecycle() {
        return this.enableMonitorAppLifecycle;
    }

    public boolean equals(Object obj) {
        avg<Integer> avgVar;
        avj<String, Object> avjVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TestingConfiguration) {
            TestingConfiguration testingConfiguration = (TestingConfiguration) obj;
            if (this.disableExperiments == testingConfiguration.disableExperiments() && this.disableOnScreenDetection == testingConfiguration.disableOnScreenDetection() && this.disableSkipFadeTransition == testingConfiguration.disableSkipFadeTransition() && ((avgVar = this.forceExperimentIds) != null ? avgVar.equals(testingConfiguration.forceExperimentIds()) : testingConfiguration.forceExperimentIds() == null) && this.useVideoElementMock == testingConfiguration.useVideoElementMock() && Float.floatToIntBits(this.videoElementMockDuration) == Float.floatToIntBits(testingConfiguration.videoElementMockDuration()) && this.useTestStreamManager == testingConfiguration.useTestStreamManager() && this.enableMonitorAppLifecycle == testingConfiguration.enableMonitorAppLifecycle() && this.forceTvMode == testingConfiguration.forceTvMode() && this.ignoreStrictModeFalsePositives == testingConfiguration.ignoreStrictModeFalsePositives() && ((avjVar = this.extraParams) != null ? avjVar.equals(testingConfiguration.extraParams()) : testingConfiguration.extraParams() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public avj<String, Object> extraParams() {
        return this.extraParams;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public avg<Integer> forceExperimentIds() {
        return this.forceExperimentIds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean forceTvMode() {
        return this.forceTvMode;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean ignoreStrictModeFalsePositives() {
        return this.ignoreStrictModeFalsePositives;
    }

    public String toString() {
        boolean z = this.disableExperiments;
        boolean z2 = this.disableOnScreenDetection;
        boolean z3 = this.disableSkipFadeTransition;
        String valueOf = String.valueOf(this.forceExperimentIds);
        boolean z4 = this.useVideoElementMock;
        float f = this.videoElementMockDuration;
        boolean z5 = this.useTestStreamManager;
        boolean z6 = this.enableMonitorAppLifecycle;
        boolean z7 = this.forceTvMode;
        boolean z8 = this.ignoreStrictModeFalsePositives;
        String valueOf2 = String.valueOf(this.extraParams);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 333 + String.valueOf(valueOf2).length());
        sb.append("TestingConfiguration{disableExperiments=");
        sb.append(z);
        sb.append(", disableOnScreenDetection=");
        sb.append(z2);
        sb.append(", disableSkipFadeTransition=");
        sb.append(z3);
        sb.append(", forceExperimentIds=");
        sb.append(valueOf);
        sb.append(", useVideoElementMock=");
        sb.append(z4);
        sb.append(", videoElementMockDuration=");
        sb.append(f);
        sb.append(", useTestStreamManager=");
        sb.append(z5);
        sb.append(", enableMonitorAppLifecycle=");
        sb.append(z6);
        sb.append(", forceTvMode=");
        sb.append(z7);
        sb.append(", ignoreStrictModeFalsePositives=");
        sb.append(z8);
        sb.append(", extraParams=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean useTestStreamManager() {
        return this.useTestStreamManager;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public boolean useVideoElementMock() {
        return this.useVideoElementMock;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration
    public float videoElementMockDuration() {
        return this.videoElementMockDuration;
    }

    public int hashCode() {
        int i = ((((((true != this.disableExperiments ? 1237 : 1231) ^ 1000003) * 1000003) ^ (true != this.disableOnScreenDetection ? 1237 : 1231)) * 1000003) ^ (true != this.disableSkipFadeTransition ? 1237 : 1231)) * 1000003;
        avg<Integer> avgVar = this.forceExperimentIds;
        int hashCode = (((((((((((((i ^ (avgVar == null ? 0 : avgVar.hashCode())) * 1000003) ^ (true != this.useVideoElementMock ? 1237 : 1231)) * 1000003) ^ Float.floatToIntBits(this.videoElementMockDuration)) * 1000003) ^ (true != this.useTestStreamManager ? 1237 : 1231)) * 1000003) ^ (true != this.enableMonitorAppLifecycle ? 1237 : 1231)) * 1000003) ^ (true != this.forceTvMode ? 1237 : 1231)) * 1000003) ^ (true == this.ignoreStrictModeFalsePositives ? 1231 : 1237)) * 1000003;
        avj<String, Object> avjVar = this.extraParams;
        return hashCode ^ (avjVar != null ? avjVar.hashCode() : 0);
    }
}
