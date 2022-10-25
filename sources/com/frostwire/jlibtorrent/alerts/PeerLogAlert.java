package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.peer_log_alert;

/* loaded from: classes2.dex */
public final class PeerLogAlert extends PeerAlert<peer_log_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PeerLogAlert(peer_log_alert peer_log_alertVar) {
        super(peer_log_alertVar);
    }

    public String eventType() {
        return ((peer_log_alert) this.alert).get_event_type();
    }

    public Direction direction() {
        return Direction.fromSwig(((peer_log_alert) this.alert).getDirection().swigValue());
    }

    public String logMessage() {
        return ((peer_log_alert) this.alert).log_message();
    }

    /* loaded from: classes2.dex */
    public enum Direction {
        INCOMING_MESSAGE(peer_log_alert.direction_t.incoming_message.swigValue()),
        OUTGOING_MESSAGE(peer_log_alert.direction_t.outgoing_message.swigValue()),
        INCOMING(peer_log_alert.direction_t.incoming.swigValue()),
        OUTGOING(peer_log_alert.direction_t.outgoing.swigValue()),
        INFO(peer_log_alert.direction_t.info.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        Direction(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static Direction fromSwig(int i) {
            Direction[] directionArr;
            for (Direction direction : (Direction[]) Direction.class.getEnumConstants()) {
                if (direction.swig() == i) {
                    return direction;
                }
            }
            return UNKNOWN;
        }
    }
}
