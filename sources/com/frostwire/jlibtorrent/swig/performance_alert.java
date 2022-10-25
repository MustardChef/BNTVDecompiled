package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class performance_alert extends torrent_alert {
    private transient long swigCPtr;
    public static final int priority = libtorrent_jni.performance_alert_priority_get();
    public static final int alert_type = libtorrent_jni.performance_alert_alert_type_get();
    public static final alert_category_t static_category = new alert_category_t(libtorrent_jni.performance_alert_static_category_get(), false);

    /* JADX INFO: Access modifiers changed from: protected */
    public performance_alert(long j, boolean z) {
        super(libtorrent_jni.performance_alert_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    protected static long getCPtr(performance_alert performance_alertVar) {
        if (performance_alertVar == null) {
            return 0L;
        }
        return performance_alertVar.swigCPtr;
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    protected void finalize() {
        delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_performance_alert(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public int type() {
        return libtorrent_jni.performance_alert_type(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public alert_category_t category() {
        return new alert_category_t(libtorrent_jni.performance_alert_category(this.swigCPtr, this), true);
    }

    @Override // com.frostwire.jlibtorrent.swig.alert
    public String what() {
        return libtorrent_jni.performance_alert_what(this.swigCPtr, this);
    }

    @Override // com.frostwire.jlibtorrent.swig.torrent_alert, com.frostwire.jlibtorrent.swig.alert
    public String message() {
        return libtorrent_jni.performance_alert_message(this.swigCPtr, this);
    }

    public performance_warning_t getWarning_code() {
        return performance_warning_t.swigToEnum(libtorrent_jni.performance_alert_warning_code_get(this.swigCPtr, this));
    }

    /* loaded from: classes2.dex */
    public static final class performance_warning_t {
        public static final performance_warning_t aio_limit_reached;
        public static final performance_warning_t bittyrant_with_no_uplimit;
        public static final performance_warning_t download_limit_too_low;
        public static final performance_warning_t num_warnings;
        public static final performance_warning_t outstanding_disk_buffer_limit_reached;
        public static final performance_warning_t outstanding_request_limit_reached;
        public static final performance_warning_t send_buffer_watermark_too_low;
        private static int swigNext;
        private static performance_warning_t[] swigValues;
        public static final performance_warning_t too_few_file_descriptors;
        public static final performance_warning_t too_few_outgoing_ports;
        public static final performance_warning_t too_high_disk_queue_limit;
        public static final performance_warning_t too_many_optimistic_unchoke_slots;
        public static final performance_warning_t upload_limit_too_low;
        private final String swigName;
        private final int swigValue;

        static {
            performance_warning_t performance_warning_tVar = new performance_warning_t("outstanding_disk_buffer_limit_reached");
            outstanding_disk_buffer_limit_reached = performance_warning_tVar;
            performance_warning_t performance_warning_tVar2 = new performance_warning_t("outstanding_request_limit_reached");
            outstanding_request_limit_reached = performance_warning_tVar2;
            performance_warning_t performance_warning_tVar3 = new performance_warning_t("upload_limit_too_low");
            upload_limit_too_low = performance_warning_tVar3;
            performance_warning_t performance_warning_tVar4 = new performance_warning_t("download_limit_too_low");
            download_limit_too_low = performance_warning_tVar4;
            performance_warning_t performance_warning_tVar5 = new performance_warning_t("send_buffer_watermark_too_low");
            send_buffer_watermark_too_low = performance_warning_tVar5;
            performance_warning_t performance_warning_tVar6 = new performance_warning_t("too_many_optimistic_unchoke_slots");
            too_many_optimistic_unchoke_slots = performance_warning_tVar6;
            performance_warning_t performance_warning_tVar7 = new performance_warning_t("too_high_disk_queue_limit");
            too_high_disk_queue_limit = performance_warning_tVar7;
            performance_warning_t performance_warning_tVar8 = new performance_warning_t("aio_limit_reached");
            aio_limit_reached = performance_warning_tVar8;
            performance_warning_t performance_warning_tVar9 = new performance_warning_t("bittyrant_with_no_uplimit");
            bittyrant_with_no_uplimit = performance_warning_tVar9;
            performance_warning_t performance_warning_tVar10 = new performance_warning_t("too_few_outgoing_ports");
            too_few_outgoing_ports = performance_warning_tVar10;
            performance_warning_t performance_warning_tVar11 = new performance_warning_t("too_few_file_descriptors");
            too_few_file_descriptors = performance_warning_tVar11;
            performance_warning_t performance_warning_tVar12 = new performance_warning_t("num_warnings");
            num_warnings = performance_warning_tVar12;
            swigValues = new performance_warning_t[]{performance_warning_tVar, performance_warning_tVar2, performance_warning_tVar3, performance_warning_tVar4, performance_warning_tVar5, performance_warning_tVar6, performance_warning_tVar7, performance_warning_tVar8, performance_warning_tVar9, performance_warning_tVar10, performance_warning_tVar11, performance_warning_tVar12};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static performance_warning_t swigToEnum(int i) {
            performance_warning_t[] performance_warning_tVarArr = swigValues;
            if (i < performance_warning_tVarArr.length && i >= 0 && performance_warning_tVarArr[i].swigValue == i) {
                return performance_warning_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                performance_warning_t[] performance_warning_tVarArr2 = swigValues;
                if (i2 < performance_warning_tVarArr2.length) {
                    if (performance_warning_tVarArr2[i2].swigValue == i) {
                        return performance_warning_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + performance_warning_t.class + " with value " + i);
                }
            }
        }

        private performance_warning_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private performance_warning_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private performance_warning_t(String str, performance_warning_t performance_warning_tVar) {
            this.swigName = str;
            int i = performance_warning_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
