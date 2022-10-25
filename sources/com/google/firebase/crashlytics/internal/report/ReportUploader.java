package com.google.firebase.crashlytics.internal.report;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ReportUploader {
    private static final short[] RETRY_INTERVALS = {10, 20, 30, 60, 120, 300};
    private final CreateReportSpiCall createReportCall;
    private final DataTransportState dataTransportState;
    private final String googleAppId;
    private final HandlingExceptionCheck handlingExceptionCheck;
    private final String organizationId;
    private final ReportManager reportManager;
    private Thread uploadThread;

    /* loaded from: classes3.dex */
    public interface HandlingExceptionCheck {
        boolean isHandlingException();
    }

    /* loaded from: classes3.dex */
    public interface Provider {
        ReportUploader createReportUploader(AppSettingsData appSettingsData);
    }

    /* loaded from: classes3.dex */
    public interface ReportFilesProvider {
        File[] getCompleteSessionFiles();

        File[] getNativeReportFiles();
    }

    public ReportUploader(String str, String str2, DataTransportState dataTransportState, ReportManager reportManager, CreateReportSpiCall createReportSpiCall, HandlingExceptionCheck handlingExceptionCheck) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.createReportCall = createReportSpiCall;
        this.organizationId = str;
        this.googleAppId = str2;
        this.dataTransportState = dataTransportState;
        this.reportManager = reportManager;
        this.handlingExceptionCheck = handlingExceptionCheck;
    }

    public synchronized void uploadReportsAsync(List<Report> list, boolean z, float f) {
        if (this.uploadThread != null) {
            Logger.getLogger().m151d("Report upload has already been started.");
            return;
        }
        Thread thread = new Thread(new Worker(list, z, f), "Crashlytics Report Uploader");
        this.uploadThread = thread;
        thread.start();
    }

    boolean isUploading() {
        return this.uploadThread != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060 A[Catch: Exception -> 0x0067, TRY_LEAVE, TryCatch #0 {Exception -> 0x0067, blocks: (B:3:0x0001, B:6:0x0013, B:19:0x0060, B:7:0x001b, B:9:0x0021, B:11:0x0029, B:13:0x0032, B:17:0x004d), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean uploadReport(com.google.firebase.crashlytics.internal.report.model.Report r7, boolean r8) {
        /*
            r6 = this;
            r0 = 0
            com.google.firebase.crashlytics.internal.report.model.CreateReportRequest r1 = new com.google.firebase.crashlytics.internal.report.model.CreateReportRequest     // Catch: java.lang.Exception -> L67
            java.lang.String r2 = r6.organizationId     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = r6.googleAppId     // Catch: java.lang.Exception -> L67
            r1.<init>(r2, r3, r7)     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.internal.common.DataTransportState r2 = r6.dataTransportState     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.internal.common.DataTransportState r3 = com.google.firebase.crashlytics.internal.common.DataTransportState.ALL     // Catch: java.lang.Exception -> L67
            java.lang.String r4 = "Report configured to be sent via DataTransport."
            r5 = 1
            if (r2 != r3) goto L1b
            com.google.firebase.crashlytics.internal.Logger r8 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Exception -> L67
            r8.m151d(r4)     // Catch: java.lang.Exception -> L67
            goto L30
        L1b:
            com.google.firebase.crashlytics.internal.common.DataTransportState r2 = r6.dataTransportState     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.internal.common.DataTransportState r3 = com.google.firebase.crashlytics.internal.common.DataTransportState.JAVA_ONLY     // Catch: java.lang.Exception -> L67
            if (r2 != r3) goto L32
            com.google.firebase.crashlytics.internal.report.model.Report$Type r2 = r7.getType()     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.internal.report.model.Report$Type r3 = com.google.firebase.crashlytics.internal.report.model.Report.Type.JAVA     // Catch: java.lang.Exception -> L67
            if (r2 != r3) goto L32
            com.google.firebase.crashlytics.internal.Logger r8 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Exception -> L67
            r8.m151d(r4)     // Catch: java.lang.Exception -> L67
        L30:
            r8 = 1
            goto L5e
        L32:
            com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall r2 = r6.createReportCall     // Catch: java.lang.Exception -> L67
            boolean r8 = r2.invoke(r1, r8)     // Catch: java.lang.Exception -> L67
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()     // Catch: java.lang.Exception -> L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L67
            r2.<init>()     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = "Crashlytics Reports Endpoint upload "
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            if (r8 == 0) goto L4b
            java.lang.String r3 = "complete: "
            goto L4d
        L4b:
            java.lang.String r3 = "FAILED: "
        L4d:
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r3 = r7.getIdentifier()     // Catch: java.lang.Exception -> L67
            r2.append(r3)     // Catch: java.lang.Exception -> L67
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L67
            r1.m147i(r2)     // Catch: java.lang.Exception -> L67
        L5e:
            if (r8 == 0) goto L80
            com.google.firebase.crashlytics.internal.report.ReportManager r8 = r6.reportManager     // Catch: java.lang.Exception -> L67
            r8.deleteReport(r7)     // Catch: java.lang.Exception -> L67
            r0 = 1
            goto L80
        L67:
            r8 = move-exception
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error occurred sending report "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.m148e(r7, r8)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.report.ReportUploader.uploadReport(com.google.firebase.crashlytics.internal.report.model.Report, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Worker extends BackgroundPriorityRunnable {
        private final boolean dataCollectionToken;
        private final float delay;
        private final List<Report> reports;

        Worker(List<Report> list, boolean z, float f) {
            this.reports = list;
            this.dataCollectionToken = z;
            this.delay = f;
        }

        @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
        public void onRun() {
            try {
                attemptUploadWithRetry(this.reports, this.dataCollectionToken);
            } catch (Exception e) {
                Logger.getLogger().m148e("An unexpected error occurred while attempting to upload crash reports.", e);
            }
            ReportUploader.this.uploadThread = null;
        }

        private void attemptUploadWithRetry(List<Report> list, boolean z) {
            float f;
            Logger.getLogger().m151d("Starting report processing in " + this.delay + " second(s)...");
            if (this.delay > 0.0f) {
                try {
                    Thread.sleep(f * 1000.0f);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                return;
            }
            int i = 0;
            while (list.size() > 0 && !ReportUploader.this.handlingExceptionCheck.isHandlingException()) {
                Logger.getLogger().m151d("Attempting to send " + list.size() + " report(s)");
                ArrayList arrayList = new ArrayList();
                for (Report report : list) {
                    if (!ReportUploader.this.uploadReport(report, z)) {
                        arrayList.add(report);
                    }
                }
                if (arrayList.size() > 0) {
                    int i2 = i + 1;
                    long j = ReportUploader.RETRY_INTERVALS[Math.min(i, ReportUploader.RETRY_INTERVALS.length - 1)];
                    Logger.getLogger().m151d("Report submission: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }
    }
}
