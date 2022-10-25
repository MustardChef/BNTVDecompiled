package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Address;
import com.frostwire.jlibtorrent.swig.external_ip_alert;

/* loaded from: classes2.dex */
public final class ExternalIpAlert extends AbstractAlert<external_ip_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ExternalIpAlert(external_ip_alert external_ip_alertVar) {
        super(external_ip_alertVar);
    }

    public Address externalAddress() {
        return new Address(((external_ip_alert) this.alert).get_external_address());
    }
}
