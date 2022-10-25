package org.acra.sender;

import android.content.Context;
import kotlin.Metadata;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;

/* compiled from: ReportSenderFactory.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m107d2 = {"Lorg/acra/sender/ReportSenderFactory;", "Lorg/acra/plugins/Plugin;", "create", "Lorg/acra/sender/ReportSender;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ReportSenderFactory extends Plugin {
    ReportSender create(Context context, CoreConfiguration coreConfiguration);
}
