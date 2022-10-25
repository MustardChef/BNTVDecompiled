package com.github.se_bastiaan.torrentstream.listeners;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.alerts.AddTorrentAlert;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;

/* loaded from: classes2.dex */
public abstract class TorrentAddedAlertListener implements AlertListener {
    public abstract void torrentAdded(AddTorrentAlert addTorrentAlert);

    @Override // com.frostwire.jlibtorrent.AlertListener
    public int[] types() {
        return new int[]{AlertType.ADD_TORRENT.swig()};
    }

    /* renamed from: com.github.se_bastiaan.torrentstream.listeners.TorrentAddedAlertListener$1 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C24541 {
        static final /* synthetic */ int[] $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType;

        static {
            int[] iArr = new int[AlertType.values().length];
            $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType = iArr;
            try {
                iArr[AlertType.ADD_TORRENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public void alert(Alert<?> alert) {
        if (C24541.$SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[alert.type().ordinal()] != 1) {
            return;
        }
        torrentAdded((AddTorrentAlert) alert);
    }
}
