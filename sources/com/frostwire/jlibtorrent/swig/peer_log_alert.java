package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_log_alert extends peer_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.peer_log_alert_priority_get();
    public static final int alert_type = libtorrent_jni.peer_log_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.peer_log_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_log_alert(long j, boolean z) {
        super(libtorrent_jni.peer_log_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(peer_log_alert peer_log_alertVar) {
        if (peer_log_alertVar == null) {
            return 0L;
        }
        return peer_log_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_peer_log_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.peer_log_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.peer_log_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.peer_log_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.peer_log_alert_message(this.swigCPtr, this);
    }

    public void setDirection(direction_t direction_tVar) {
        libtorrent_jni.peer_log_alert_direction_set(this.swigCPtr, this, direction_tVar.swigValue());
    }

    public direction_t getDirection() {
        return direction_t.swigToEnum(libtorrent_jni.peer_log_alert_direction_get(this.swigCPtr, this));
    }

    public String log_message() {
        return libtorrent_jni.peer_log_alert_log_message(this.swigCPtr, this);
    }

    public String get_event_type() {
        return libtorrent_jni.peer_log_alert_get_event_type(this.swigCPtr, this);
    }

    /* loaded from: classes2.dex */
    public static final class direction_t {
        public static final direction_t incoming;
        public static final direction_t incoming_message;
        public static final direction_t info;
        public static final direction_t outgoing;
        public static final direction_t outgoing_message;
        private static int swigNext;
        private static direction_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            direction_t direction_tVar = new direction_t("incoming_message");
            incoming_message = direction_tVar;
            direction_t direction_tVar2 = new direction_t("outgoing_message");
            outgoing_message = direction_tVar2;
            direction_t direction_tVar3 = new direction_t("incoming");
            incoming = direction_tVar3;
            direction_t direction_tVar4 = new direction_t("outgoing");
            outgoing = direction_tVar4;
            direction_t direction_tVar5 = new direction_t("info");
            info = direction_tVar5;
            swigValues = new direction_t[]{direction_tVar, direction_tVar2, direction_tVar3, direction_tVar4, direction_tVar5};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static direction_t swigToEnum(int i) {
            direction_t[] direction_tVarArr = swigValues;
            if (i < direction_tVarArr.length && i >= 0 && direction_tVarArr[i].swigValue == i) {
                return direction_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                direction_t[] direction_tVarArr2 = swigValues;
                if (i2 < direction_tVarArr2.length) {
                    if (direction_tVarArr2[i2].swigValue == i) {
                        return direction_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + direction_t.class + " with value " + i);
                }
            }
        }

        private direction_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private direction_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private direction_t(String str, direction_t direction_tVar) {
            this.swigName = str;
            int i = direction_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
