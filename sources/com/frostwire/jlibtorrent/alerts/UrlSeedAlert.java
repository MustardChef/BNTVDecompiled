package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.url_seed_alert;

/* loaded from: classes2.dex */
public final class UrlSeedAlert extends TorrentAlert<url_seed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public UrlSeedAlert(url_seed_alert url_seed_alertVar) {
        super(url_seed_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((url_seed_alert) this.alert).getError());
    }

    public String serverUrl() {
        return ((url_seed_alert) this.alert).server_url();
    }

    public String errorMessage() {
        return ((url_seed_alert) this.alert).error_message();
    }
}
