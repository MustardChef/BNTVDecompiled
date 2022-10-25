package org.acra.collector;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.util.Installation;

/* compiled from: SimpleValuesCollector.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0014"}, m107d2 = {"Lorg/acra/collector/SimpleValuesCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "getApplicationFilePath", "", "shouldCollect", "", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class SimpleValuesCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);

    /* compiled from: SimpleValuesCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportField.valuesCustom().length];
            iArr[ReportField.IS_SILENT.ordinal()] = 1;
            iArr[ReportField.REPORT_ID.ordinal()] = 2;
            iArr[ReportField.INSTALLATION_ID.ordinal()] = 3;
            iArr[ReportField.PACKAGE_NAME.ordinal()] = 4;
            iArr[ReportField.PHONE_MODEL.ordinal()] = 5;
            iArr[ReportField.ANDROID_VERSION.ordinal()] = 6;
            iArr[ReportField.BRAND.ordinal()] = 7;
            iArr[ReportField.PRODUCT.ordinal()] = 8;
            iArr[ReportField.FILE_PATH.ordinal()] = 9;
            iArr[ReportField.USER_IP.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SimpleValuesCollector() {
        super(ReportField.IS_SILENT, ReportField.REPORT_ID, ReportField.INSTALLATION_ID, ReportField.PACKAGE_NAME, ReportField.PHONE_MODEL, ReportField.ANDROID_VERSION, ReportField.BRAND, ReportField.PRODUCT, ReportField.FILE_PATH, ReportField.USER_IP);
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws Exception {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        switch (WhenMappings.$EnumSwitchMapping$0[reportField.ordinal()]) {
            case 1:
                target.put(ReportField.IS_SILENT, reportBuilder.isSendSilently());
                return;
            case 2:
                target.put(ReportField.REPORT_ID, UUID.randomUUID().toString());
                return;
            case 3:
                ReportField reportField2 = ReportField.INSTALLATION_ID;
                Installation installation = Installation.INSTANCE;
                target.put(reportField2, Installation.m58id(context));
                return;
            case 4:
                target.put(ReportField.PACKAGE_NAME, context.getPackageName());
                return;
            case 5:
                target.put(ReportField.PHONE_MODEL, Build.MODEL);
                return;
            case 6:
                target.put(ReportField.ANDROID_VERSION, Build.VERSION.RELEASE);
                return;
            case 7:
                target.put(ReportField.BRAND, Build.BRAND);
                return;
            case 8:
                target.put(ReportField.PRODUCT, Build.PRODUCT);
                return;
            case 9:
                target.put(ReportField.FILE_PATH, getApplicationFilePath(context));
                return;
            case 10:
                target.put(ReportField.USER_IP, Companion.getLocalIpAddress());
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return collect == ReportField.IS_SILENT || collect == ReportField.REPORT_ID || super.shouldCollect(context, config, collect, reportBuilder);
    }

    private final String getApplicationFilePath(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "context.filesDir.absolutePath");
        return absolutePath;
    }

    /* compiled from: SimpleValuesCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, m107d2 = {"Lorg/acra/collector/SimpleValuesCollector$Companion;", "", "()V", "getLocalIpAddress", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getLocalIpAddress() throws SocketException {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            boolean z = true;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        if (!z) {
                            sb.append('\n');
                        }
                        sb.append(nextElement.getHostAddress());
                        z = false;
                    }
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
            return sb2;
        }
    }
}
