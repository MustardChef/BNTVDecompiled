package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.AddTorrentParams;
import com.frostwire.jlibtorrent.swig.save_resume_data_alert;

/* loaded from: classes2.dex */
public final class SaveResumeDataAlert extends TorrentAlert<save_resume_data_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaveResumeDataAlert(save_resume_data_alert save_resume_data_alertVar) {
        super(save_resume_data_alertVar);
    }

    public AddTorrentParams params() {
        return new AddTorrentParams(((save_resume_data_alert) this.alert).getParams());
    }
}
