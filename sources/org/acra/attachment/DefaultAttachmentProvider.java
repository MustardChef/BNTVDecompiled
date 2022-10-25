package org.acra.attachment;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.config.CoreConfiguration;

/* compiled from: DefaultAttachmentProvider.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m107d2 = {"Lorg/acra/attachment/DefaultAttachmentProvider;", "Lorg/acra/attachment/AttachmentUriProvider;", "()V", "getAttachments", "", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "configuration", "Lorg/acra/config/CoreConfiguration;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DefaultAttachmentProvider implements AttachmentUriProvider {
    @Override // org.acra.attachment.AttachmentUriProvider
    public List<Uri> getAttachments(Context context, CoreConfiguration configuration) {
        Uri uri;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        String[] attachmentUris = configuration.getAttachmentUris();
        ArrayList arrayList = new ArrayList();
        for (String str : attachmentUris) {
            try {
                uri = Uri.parse(str);
            } catch (Exception e) {
                ACRA.log.mo66e(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to parse Uri ", str), e);
                uri = null;
            }
            if (uri != null) {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }
}
