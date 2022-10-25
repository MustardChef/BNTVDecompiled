package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;

/* loaded from: classes3.dex */
public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    private final DefaultCreateReportSpiCall javaReportSpiCall;
    private final NativeCreateReportSpiCall nativeReportSpiCall;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.javaReportSpiCall = defaultCreateReportSpiCall;
        this.nativeReportSpiCall = nativeCreateReportSpiCall;
    }

    /* renamed from: com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall$1 */
    /* loaded from: classes3.dex */
    static /* synthetic */ class C45341 {

        /* renamed from: $SwitchMap$com$google$firebase$crashlytics$internal$report$model$Report$Type */
        static final /* synthetic */ int[] f9847xc221d5a6;

        static {
            int[] iArr = new int[Report.Type.values().length];
            f9847xc221d5a6 = iArr;
            try {
                iArr[Report.Type.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9847xc221d5a6[Report.Type.NATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        int i = C45341.f9847xc221d5a6[createReportRequest.report.getType().ordinal()];
        if (i == 1) {
            this.javaReportSpiCall.invoke(createReportRequest, z);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.nativeReportSpiCall.invoke(createReportRequest, z);
            return true;
        }
    }
}
