package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.Operation;
import com.frostwire.jlibtorrent.swig.dht_error_alert;

/* loaded from: classes2.dex */
public final class DhtErrorAlert extends AbstractAlert<dht_error_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtErrorAlert(dht_error_alert dht_error_alertVar) {
        super(dht_error_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((dht_error_alert) this.alert).getError());
    }

    public Operation operation() {
        return Operation.fromSwig(((dht_error_alert) this.alert).getOp());
    }
}
