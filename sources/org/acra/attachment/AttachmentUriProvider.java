package org.acra.attachment;

import android.content.Context;
import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import org.acra.config.CoreConfiguration;

/* compiled from: AttachmentUriProvider.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, m107d2 = {"Lorg/acra/attachment/AttachmentUriProvider;", "", "getAttachments", "", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "configuration", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public interface AttachmentUriProvider {
    List<Uri> getAttachments(Context context, CoreConfiguration coreConfiguration);
}
