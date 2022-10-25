package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.performance_alert;

/* loaded from: classes2.dex */
public final class PerformanceAlert extends TorrentAlert<performance_alert> {
    public PerformanceAlert(performance_alert performance_alertVar) {
        super(performance_alertVar);
    }

    public PerformanceWarning getWarningCode() {
        return PerformanceWarning.fromSwig(((performance_alert) this.alert).getWarning_code().swigValue());
    }

    /* loaded from: classes2.dex */
    public enum PerformanceWarning {
        OUTSTANDING_DISK_BUFFER_LIMIT_REACHED(performance_alert.performance_warning_t.outstanding_disk_buffer_limit_reached.swigValue()),
        OUTSTANDING_REQUEST_LIMIT_REACHED(performance_alert.performance_warning_t.outstanding_request_limit_reached.swigValue()),
        UPLOAD_LIMIT_TOO_LOW(performance_alert.performance_warning_t.upload_limit_too_low.swigValue()),
        DOWNLOAD_LIMIT_TOO_LOW(performance_alert.performance_warning_t.download_limit_too_low.swigValue()),
        SEND_BUFFER_WATERMARK_TOO_LOW(performance_alert.performance_warning_t.send_buffer_watermark_too_low.swigValue()),
        TOO_MANY_OPTIMISTIC_UNCHOKE_SLOTS(performance_alert.performance_warning_t.too_many_optimistic_unchoke_slots.swigValue()),
        TOO_HIGH_DISK_QUEUE_LIMIT(performance_alert.performance_warning_t.too_high_disk_queue_limit.swigValue()),
        BITTYRANT_WITH_NO_UPLIMIT(performance_alert.performance_warning_t.bittyrant_with_no_uplimit.swigValue()),
        TOO_FEW_OUTGOING_PORTS(performance_alert.performance_warning_t.too_few_outgoing_ports.swigValue()),
        TOO_FEW_FILE_DESCRIPTORS(performance_alert.performance_warning_t.too_few_file_descriptors.swigValue()),
        NUM_WARNINGS(performance_alert.performance_warning_t.num_warnings.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        PerformanceWarning(int i) {
            this.swigValue = i;
        }

        public int getSwig() {
            return this.swigValue;
        }

        public static PerformanceWarning fromSwig(int i) {
            PerformanceWarning[] performanceWarningArr;
            for (PerformanceWarning performanceWarning : (PerformanceWarning[]) PerformanceWarning.class.getEnumConstants()) {
                if (performanceWarning.getSwig() == i) {
                    return performanceWarning;
                }
            }
            return UNKNOWN;
        }
    }
}
