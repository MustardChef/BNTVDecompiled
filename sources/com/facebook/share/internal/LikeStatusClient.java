package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;

@Deprecated
/* loaded from: classes2.dex */
final class LikeStatusClient extends PlatformServiceClient {
    private String objectId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LikeStatusClient(Context context, String str, String str2) {
        super(context, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST, NativeProtocol.MESSAGE_GET_LIKE_STATUS_REPLY, NativeProtocol.PROTOCOL_VERSION_20141001, str);
        this.objectId = str2;
    }

    @Override // com.facebook.internal.PlatformServiceClient
    protected void populateRequestBundle(Bundle bundle) {
        bundle.putString(ShareConstants.EXTRA_OBJECT_ID, this.objectId);
    }
}
