package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_log_alert extends alert {
    private transient long swigCPtr;
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.dht_log_alert_static_category_get(), false);
    public static final int priority = libtorrent_jni.dht_log_alert_priority_get();
    public static final int alert_type = libtorrent_jni.dht_log_alert_alert_type_get();

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_log_alert(long j, boolean z) {
        super(libtorrent_jni.dht_log_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(dht_log_alert dht_log_alertVar) {
        if (dht_log_alertVar == null) {
            return 0L;
        }
        return dht_log_alertVar.swigCPtr;
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
                libtorrent_jni.delete_dht_log_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.dht_log_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.dht_log_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.dht_log_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.dht_log_alert_message(this.swigCPtr, this);
    }

    public String log_message() {
        return libtorrent_jni.dht_log_alert_log_message(this.swigCPtr, this);
    }

    public void setModule(dht_module_t dht_module_tVar) {
        libtorrent_jni.dht_log_alert_module_set(this.swigCPtr, this, dht_module_tVar.swigValue());
    }

    public dht_module_t getModule() {
        return dht_module_t.swigToEnum(libtorrent_jni.dht_log_alert_module_get(this.swigCPtr, this));
    }

    /* loaded from: classes2.dex */
    public static final class dht_module_t {
        public static final dht_module_t node;
        public static final dht_module_t routing_table;
        public static final dht_module_t rpc_manager;
        private static int swigNext;
        private static dht_module_t[] swigValues;
        public static final dht_module_t tracker;
        public static final dht_module_t traversal;
        private final String swigName;
        private final int swigValue;

        static {
            dht_module_t dht_module_tVar = new dht_module_t("tracker");
            tracker = dht_module_tVar;
            dht_module_t dht_module_tVar2 = new dht_module_t("node");
            node = dht_module_tVar2;
            dht_module_t dht_module_tVar3 = new dht_module_t("routing_table");
            routing_table = dht_module_tVar3;
            dht_module_t dht_module_tVar4 = new dht_module_t("rpc_manager");
            rpc_manager = dht_module_tVar4;
            dht_module_t dht_module_tVar5 = new dht_module_t("traversal");
            traversal = dht_module_tVar5;
            swigValues = new dht_module_t[]{dht_module_tVar, dht_module_tVar2, dht_module_tVar3, dht_module_tVar4, dht_module_tVar5};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static dht_module_t swigToEnum(int i) {
            dht_module_t[] dht_module_tVarArr = swigValues;
            if (i < dht_module_tVarArr.length && i >= 0 && dht_module_tVarArr[i].swigValue == i) {
                return dht_module_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                dht_module_t[] dht_module_tVarArr2 = swigValues;
                if (i2 < dht_module_tVarArr2.length) {
                    if (dht_module_tVarArr2[i2].swigValue == i) {
                        return dht_module_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + dht_module_t.class + " with value " + i);
                }
            }
        }

        private dht_module_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private dht_module_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private dht_module_t(String str, dht_module_t dht_module_tVar) {
            this.swigName = str;
            int i = dht_module_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
