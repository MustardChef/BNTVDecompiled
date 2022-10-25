package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class peer_blocked_alert extends peer_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.peer_blocked_alert_priority_get();
    public static final int alert_type = libtorrent_jni.peer_blocked_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.peer_blocked_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public peer_blocked_alert(long j, boolean z) {
        super(libtorrent_jni.peer_blocked_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(peer_blocked_alert peer_blocked_alertVar) {
        if (peer_blocked_alertVar == null) {
            return 0L;
        }
        return peer_blocked_alertVar.swigCPtr;
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
                libtorrent_jni.delete_peer_blocked_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.peer_blocked_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.peer_blocked_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.peer_blocked_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.peer_alert, com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.peer_blocked_alert_message(this.swigCPtr, this);
    }

    public int getReason() {
        return libtorrent_jni.peer_blocked_alert_reason_get(this.swigCPtr, this);
    }

    /* loaded from: classes2.dex */
    public static final class reason_t {
        public static final reason_t i2p_mixed;
        public static final reason_t invalid_local_interface;
        public static final reason_t ip_filter;
        public static final reason_t port_filter;
        public static final reason_t privileged_ports;
        private static int swigNext;
        private static reason_t[] swigValues;
        public static final reason_t tcp_disabled;
        public static final reason_t utp_disabled;
        private final String swigName;
        private final int swigValue;

        static {
            reason_t reason_tVar = new reason_t("ip_filter");
            ip_filter = reason_tVar;
            reason_t reason_tVar2 = new reason_t("port_filter");
            port_filter = reason_tVar2;
            reason_t reason_tVar3 = new reason_t("i2p_mixed");
            i2p_mixed = reason_tVar3;
            reason_t reason_tVar4 = new reason_t("privileged_ports");
            privileged_ports = reason_tVar4;
            reason_t reason_tVar5 = new reason_t("utp_disabled");
            utp_disabled = reason_tVar5;
            reason_t reason_tVar6 = new reason_t("tcp_disabled");
            tcp_disabled = reason_tVar6;
            reason_t reason_tVar7 = new reason_t("invalid_local_interface");
            invalid_local_interface = reason_tVar7;
            swigValues = new reason_t[]{reason_tVar, reason_tVar2, reason_tVar3, reason_tVar4, reason_tVar5, reason_tVar6, reason_tVar7};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static reason_t swigToEnum(int i) {
            reason_t[] reason_tVarArr = swigValues;
            if (i < reason_tVarArr.length && i >= 0 && reason_tVarArr[i].swigValue == i) {
                return reason_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                reason_t[] reason_tVarArr2 = swigValues;
                if (i2 < reason_tVarArr2.length) {
                    if (reason_tVarArr2[i2].swigValue == i) {
                        return reason_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + reason_t.class + " with value " + i);
                }
            }
        }

        private reason_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private reason_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private reason_t(String str, reason_t reason_tVar) {
            this.swigName = str;
            int i = reason_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
