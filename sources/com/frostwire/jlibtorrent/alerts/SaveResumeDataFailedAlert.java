package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.ErrorCode;
import com.frostwire.jlibtorrent.swig.save_resume_data_failed_alert;

/* loaded from: classes2.dex */
public final class SaveResumeDataFailedAlert extends TorrentAlert<save_resume_data_failed_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SaveResumeDataFailedAlert(save_resume_data_failed_alert save_resume_data_failed_alertVar) {
        super(save_resume_data_failed_alertVar);
    }

    public ErrorCode error() {
        return new ErrorCode(((save_resume_data_failed_alert) this.alert).getError());
    }
}
