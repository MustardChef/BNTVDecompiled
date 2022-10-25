package org.acra.collector;

import android.content.Context;
import android.os.Build;
import android.os.DropBoxManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.acra.prefs.SharedPreferencesFactory;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.SystemServices;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DropBoxCollector.kt */
@Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, m107d2 = {"Lorg/acra/collector/DropBoxCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "order", "Lorg/acra/collector/Collector$Order;", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "shouldCollect", "", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class DropBoxCollector extends BaseReportFieldCollector {
    public static final Companion Companion = new Companion(null);
    private static final String[] SYSTEM_TAGS = {"system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"};
    private final SimpleDateFormat dateFormat;

    public DropBoxCollector() {
        super(ReportField.DROPBOX);
        this.dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.FIRST;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws Exception {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        SystemServices systemServices = SystemServices.INSTANCE;
        DropBoxManager dropBoxManager = SystemServices.getDropBoxManager(context);
        Calendar calendar = Calendar.getInstance();
        calendar.roll(12, -config.getDropboxCollectionMinutes());
        long timeInMillis = calendar.getTimeInMillis();
        this.dateFormat.format(calendar.getTime());
        ArrayList<String> arrayList = new ArrayList();
        if (config.getIncludeDropBoxSystemTags()) {
            CollectionsKt.addAll(arrayList, SYSTEM_TAGS);
        }
        List list = ArraysKt.toList(config.getAdditionalDropBoxTags());
        if (!list.isEmpty()) {
            arrayList.addAll(list);
        }
        if (!arrayList.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (String str : arrayList) {
                StringBuilder sb = new StringBuilder();
                DropBoxManager.Entry nextEntry = dropBoxManager.getNextEntry(str, timeInMillis);
                if (nextEntry == null) {
                    sb.append("Nothing.");
                    sb.append('\n');
                } else {
                    while (nextEntry != null) {
                        long timeMillis = nextEntry.getTimeMillis();
                        calendar.setTimeInMillis(timeMillis);
                        sb.append('@');
                        sb.append(this.dateFormat.format(calendar.getTime()));
                        sb.append('\n');
                        String text = nextEntry.getText(500);
                        if (text != null) {
                            sb.append("Text: ");
                            sb.append(text);
                            sb.append('\n');
                        } else {
                            sb.append("Not Text!");
                            sb.append('\n');
                        }
                        nextEntry.close();
                        nextEntry = dropBoxManager.getNextEntry(str, timeMillis);
                    }
                    try {
                        jSONObject.put(str, sb.toString());
                    } catch (JSONException e) {
                        ACRA.log.mo60w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to collect data for tag ", str), e);
                    }
                }
            }
            target.put(ReportField.DROPBOX, jSONObject);
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return super.shouldCollect(context, config, collect, reportBuilder) && (Build.VERSION.SDK_INT >= 16 || new PackageManagerWrapper(context).hasPermission("android.permission.READ_LOGS")) && new SharedPreferencesFactory(context, config).create().getBoolean(ACRA.PREF_ENABLE_SYSTEM_LOGS, true);
    }

    /* compiled from: DropBoxCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, m107d2 = {"Lorg/acra/collector/DropBoxCollector$Companion;", "", "()V", "SYSTEM_TAGS", "", "", "[Ljava/lang/String;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
