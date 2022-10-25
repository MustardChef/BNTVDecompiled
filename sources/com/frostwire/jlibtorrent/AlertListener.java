package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.alerts.Alert;

/* loaded from: classes2.dex */
public interface AlertListener {
    void alert(Alert<?> alert);

    int[] types();
}
