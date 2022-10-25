package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.alert;
import com.frostwire.jlibtorrent.swig.alert_category_t;

/* loaded from: classes2.dex */
public abstract class AbstractAlert<T extends alert> implements Alert<T> {
    protected final T alert;
    private final AlertType type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractAlert(T t) {
        this.alert = t;
        this.type = AlertType.fromSwig(t.type());
    }

    @Override // com.frostwire.jlibtorrent.alerts.Alert
    public final T swig() {
        return this.alert;
    }

    @Override // com.frostwire.jlibtorrent.alerts.Alert
    public long timestamp() {
        return this.alert.get_timestamp();
    }

    @Override // com.frostwire.jlibtorrent.alerts.Alert
    public AlertType type() {
        return this.type;
    }

    @Override // com.frostwire.jlibtorrent.alerts.Alert
    public String what() {
        return this.alert.what();
    }

    @Override // com.frostwire.jlibtorrent.alerts.Alert
    public String message() {
        return this.alert.message();
    }

    @Override // com.frostwire.jlibtorrent.alerts.Alert
    public alert_category_t category() {
        return this.alert.category();
    }

    public String toString() {
        return type() + " - " + what() + " - " + message();
    }
}
