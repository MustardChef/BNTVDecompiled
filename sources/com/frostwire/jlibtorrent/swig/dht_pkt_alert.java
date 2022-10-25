package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_pkt_alert extends alert {
    private transient long swigCPtr;
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_pkt_alert_static_category_get(), false);
    public static final int priority = libtorrent_jni.dht_pkt_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_pkt_alert_alert_type_get();

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_pkt_alert(long j, boolean z) {
        super(libtorrent_jni.dht_pkt_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_pkt_alert dht_pkt_alertVar) {
        if (dht_pkt_alertVar == null) {
            return 0L;
        }
        return dht_pkt_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_pkt_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_pkt_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_pkt_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_pkt_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_pkt_alert_message(this.swigCPtr, this);
    }

    public byte_const_span pkt_buf() {
        return new byte_const_span(libtorrent_jni.dht_pkt_alert_pkt_buf(this.swigCPtr, this), true);
    }

    public void setDirection(direction_t direction_tVar) {
        libtorrent_jni.dht_pkt_alert_direction_set(this.swigCPtr, this, direction_tVar.swigValue());
    }

    public direction_t getDirection() {
        return direction_t.swigToEnum(libtorrent_jni.dht_pkt_alert_direction_get(this.swigCPtr, this));
    }

    public udp_endpoint get_node() {
        return new udp_endpoint(libtorrent_jni.dht_pkt_alert_get_node(this.swigCPtr, this), true);
    }

    /* loaded from: classes2.dex */
    public static final class direction_t {
        public static final direction_t incoming;
        public static final direction_t outgoing;
        private static int swigNext;
        private static direction_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            direction_t direction_tVar = new direction_t("incoming");
            incoming = direction_tVar;
            direction_t direction_tVar2 = new direction_t("outgoing");
            outgoing = direction_tVar2;
            swigValues = new direction_t[]{direction_tVar, direction_tVar2};
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
