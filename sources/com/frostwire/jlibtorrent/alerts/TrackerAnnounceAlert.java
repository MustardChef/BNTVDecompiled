package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.tracker_announce_alert;

/* loaded from: classes2.dex */
public final class TrackerAnnounceAlert extends TrackerAlert<tracker_announce_alert> {
    public TrackerAnnounceAlert(tracker_announce_alert tracker_announce_alertVar) {
        super(tracker_announce_alertVar);
    }

    public TrackerAnnounceEvent getEvent() {
        return TrackerAnnounceEvent.fromSwig(((tracker_announce_alert) this.alert).getEvent());
    }

    /* loaded from: classes2.dex */
    public enum TrackerAnnounceEvent {
        NONE(0),
        COMPLETED(1),
        STARTED(2),
        STOPPED(3),
        UNKNOWN(-1);
        
        private final int swigValue;

        TrackerAnnounceEvent(int i) {
            this.swigValue = i;
        }

        public int getSwig() {
            return this.swigValue;
        }

        public static TrackerAnnounceEvent fromSwig(int i) {
            TrackerAnnounceEvent[] trackerAnnounceEventArr;
            for (TrackerAnnounceEvent trackerAnnounceEvent : (TrackerAnnounceEvent[]) TrackerAnnounceEvent.class.getEnumConstants()) {
                if (trackerAnnounceEvent.getSwig() == i) {
                    return trackerAnnounceEvent;
                }
            }
            return UNKNOWN;
        }
    }
}
