package org.acra.interaction;

import android.content.Context;
import java.io.File;
import kotlin.Metadata;
import org.acra.config.CoreConfiguration;
import org.acra.plugins.Plugin;

/* compiled from: ReportInteraction.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m107d2 = {"Lorg/acra/interaction/ReportInteraction;", "Lorg/acra/plugins/Plugin;", "performInteraction", "", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportFile", "Ljava/io/File;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface ReportInteraction extends Plugin {
    boolean performInteraction(Context context, CoreConfiguration coreConfiguration, File file);
}
