package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.alerts.Alert;

/* loaded from: classes2.dex */
final class AlertMulticaster implements AlertListener {

    /* renamed from: a */
    private final AlertListener f2804a;

    /* renamed from: b */
    private final AlertListener f2805b;

    @Override // com.frostwire.jlibtorrent.AlertListener
    public int[] types() {
        return null;
    }

    public AlertMulticaster(AlertListener alertListener, AlertListener alertListener2) {
        this.f2804a = alertListener;
        this.f2805b = alertListener2;
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public void alert(Alert<?> alert) {
        this.f2804a.alert(alert);
        this.f2805b.alert(alert);
    }

    public static AlertListener add(AlertListener alertListener, AlertListener alertListener2) {
        return addInternal(alertListener, alertListener2);
    }

    public static AlertListener remove(AlertListener alertListener, AlertListener alertListener2) {
        return removeInternal(alertListener, alertListener2);
    }

    private AlertListener remove(AlertListener alertListener) {
        AlertListener alertListener2 = this.f2804a;
        if (alertListener == alertListener2) {
            return this.f2805b;
        }
        if (alertListener == this.f2805b) {
            return alertListener2;
        }
        AlertListener removeInternal = removeInternal(alertListener2, alertListener);
        AlertListener removeInternal2 = removeInternal(this.f2805b, alertListener);
        return (removeInternal == this.f2804a && removeInternal2 == this.f2805b) ? this : addInternal(removeInternal, removeInternal2);
    }

    private static AlertListener addInternal(AlertListener alertListener, AlertListener alertListener2) {
        return alertListener == null ? alertListener2 : alertListener2 == null ? alertListener : new AlertMulticaster(alertListener, alertListener2);
    }

    private static AlertListener removeInternal(AlertListener alertListener, AlertListener alertListener2) {
        if (alertListener == alertListener2 || alertListener == null) {
            return null;
        }
        return alertListener instanceof AlertMulticaster ? ((AlertMulticaster) alertListener).remove(alertListener2) : alertListener;
    }
}
