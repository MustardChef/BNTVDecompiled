package org.acra.file;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.ACRAConstants;

/* compiled from: CrashReportFileNameParser.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, m107d2 = {"Lorg/acra/file/CrashReportFileNameParser;", "", "()V", "getTimestamp", "Ljava/util/Calendar;", "reportFileName", "", "isApproved", "", "isSilent", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CrashReportFileNameParser {
    public final boolean isSilent(String reportFileName) {
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        return StringsKt.contains$default((CharSequence) reportFileName, (CharSequence) ACRAConstants.SILENT_SUFFIX, false, 2, (Object) null);
    }

    @Deprecated(message = "use {@link ReportLocator#getApprovedReports()} and {@link ReportLocator#getUnapprovedReports()} instead")
    public final boolean isApproved(String reportFileName) {
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        return isSilent(reportFileName) || StringsKt.contains$default((CharSequence) reportFileName, (CharSequence) ACRAConstants.APPROVED_SUFFIX, false, 2, (Object) null);
    }

    public final Calendar getTimestamp(String reportFileName) {
        Intrinsics.checkNotNullParameter(reportFileName, "reportFileName");
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(reportFileName, ACRAConstants.REPORTFILE_EXTENSION, "", false, 4, (Object) null), ACRAConstants.SILENT_SUFFIX, "", false, 4, (Object) null);
        Calendar calendar = Calendar.getInstance();
        try {
            Date parse = new SimpleDateFormat(ACRAConstants.DATE_TIME_FORMAT_STRING, Locale.ENGLISH).parse(replace$default);
            Intrinsics.checkNotNull(parse);
            calendar.setTime(parse);
        } catch (ParseException unused) {
        }
        Intrinsics.checkNotNullExpressionValue(calendar, "calendar");
        return calendar;
    }
}
