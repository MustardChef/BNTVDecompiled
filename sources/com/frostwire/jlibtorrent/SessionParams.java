package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.session_params;

/* loaded from: classes2.dex */
public class SessionParams {

    /* renamed from: p */
    private final session_params f2825p;

    public SessionParams(session_params session_paramsVar) {
        this.f2825p = session_paramsVar;
    }

    public SessionParams() {
        this(new session_params());
    }

    public SessionParams(SettingsPack settingsPack) {
        this(new session_params(settingsPack.swig()));
    }

    public session_params swig() {
        return this.f2825p;
    }

    public SettingsPack settings() {
        return new SettingsPack(this.f2825p.getSettings());
    }
}
