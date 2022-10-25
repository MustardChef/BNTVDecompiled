package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.file_renamed_alert;

/* loaded from: classes2.dex */
public final class FileRenamedAlert extends TorrentAlert<file_renamed_alert> {
    public FileRenamedAlert(file_renamed_alert file_renamed_alertVar) {
        super(file_renamed_alertVar);
    }

    public String newName() {
        return ((file_renamed_alert) this.alert).new_name();
    }

    public int index() {
        return ((file_renamed_alert) this.alert).getIndex();
    }
}
