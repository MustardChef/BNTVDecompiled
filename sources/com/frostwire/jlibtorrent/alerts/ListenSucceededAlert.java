package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Address;
import com.frostwire.jlibtorrent.swig.listen_succeeded_alert;

/* loaded from: classes2.dex */
public final class ListenSucceededAlert extends AbstractAlert<listen_succeeded_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenSucceededAlert(listen_succeeded_alert listen_succeeded_alertVar) {
        super(listen_succeeded_alertVar);
    }

    public Address address() {
        return new Address(((listen_succeeded_alert) this.alert).get_address());
    }

    public int port() {
        return ((listen_succeeded_alert) this.alert).getPort();
    }

    public SocketType socketType() {
        return SocketType.fromSwig(((listen_succeeded_alert) this.alert).getSocket_type().swigValue());
    }
}
