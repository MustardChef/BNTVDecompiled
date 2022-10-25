package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.file_completed_alert;

/* loaded from: classes2.dex */
public final class FileCompletedAlert extends TorrentAlert<file_completed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FileCompletedAlert(file_completed_alert file_completed_alertVar) {
        super(file_completed_alertVar);
    }

    public int index() {
        return ((file_completed_alert) this.alert).getIndex();
    }
}
