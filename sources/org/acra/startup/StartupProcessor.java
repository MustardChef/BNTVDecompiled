package org.acra.startup;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;

/* compiled from: StartupProcessor.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, m107d2 = {"Lorg/acra/startup/StartupProcessor;", "Lorg/acra/plugins/Plugin;", "processReports", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reports", "", "Lorg/acra/startup/Report;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface StartupProcessor extends Plugin {
    void processReports(Context context, CoreConfiguration coreConfiguration, List<Report> list);
}
