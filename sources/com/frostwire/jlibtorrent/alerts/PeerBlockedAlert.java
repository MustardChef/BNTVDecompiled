package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.peer_blocked_alert;

/* loaded from: classes2.dex */
public final class PeerBlockedAlert extends TorrentAlert<peer_blocked_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerBlockedAlert(peer_blocked_alert peer_blocked_alertVar) {
        super(peer_blocked_alertVar);
    }

    public Reason reason() {
        return Reason.fromSwig(((peer_blocked_alert) this.alert).getReason());
    }

    /* loaded from: classes2.dex */
    public enum Reason {
        IP_FILTER(peer_blocked_alert.reason_t.ip_filter.swigValue()),
        PORT_FILTER(peer_blocked_alert.reason_t.port_filter.swigValue()),
        I2P_MIXED(peer_blocked_alert.reason_t.i2p_mixed.swigValue()),
        PRIVILEGED_PORTS(peer_blocked_alert.reason_t.privileged_ports.swigValue()),
        UTP_DISABLED(peer_blocked_alert.reason_t.utp_disabled.swigValue()),
        TCP_DISABLED(peer_blocked_alert.reason_t.tcp_disabled.swigValue()),
        INVALID_LOCAL_INTERFACE(peer_blocked_alert.reason_t.invalid_local_interface.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        Reason(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static Reason fromSwig(int i) {
            Reason[] reasonArr;
            for (Reason reason : (Reason[]) Reason.class.getEnumConstants()) {
                if (reason.swig() == i) {
                    return reason;
                }
            }
            return UNKNOWN;
        }
    }
}
