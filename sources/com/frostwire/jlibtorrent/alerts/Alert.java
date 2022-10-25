package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.alert;
import com.frostwire.jlibtorrent.swig.alert_category_t;

/* loaded from: classes2.dex */
public interface Alert<T extends alert> {
    public static final alert_category_t ERROR_NOTIFICATION = alert.error_notification;
    public static final alert_category_t PEER_NOTIFICATION = alert.peer_notification;
    public static final alert_category_t PORT_MAPPING_NOTIFICATION = alert.port_mapping_notification;
    public static final alert_category_t STORAGE_NOTIFICATION = alert.storage_notification;
    public static final alert_category_t TRACKER_NOTIFICATION = alert.tracker_notification;
    public static final alert_category_t CONNECT_NOTIFICATION = alert.connect_notification;
    public static final alert_category_t STATUS_NOTIFICATION = alert.status_notification;
    public static final alert_category_t IP_BLOCK_NOTIFICATION = alert.ip_block_notification;
    public static final alert_category_t PERFORMANCE_WARNING = alert.performance_warning;
    public static final alert_category_t DHT_NOTIFICATION = alert.dht_notification;
    public static final alert_category_t STATS_NOTIFICATION = alert.stats_notification;
    public static final alert_category_t SESSION_LOG_NOTIFICATION = alert.session_log_notification;
    public static final alert_category_t TORRENT_LOG_NOTIFICATION = alert.torrent_log_notification;
    public static final alert_category_t PEER_LOG_NOTIFICATION = alert.peer_log_notification;
    public static final alert_category_t INCOMING_REQUEST_NOTIFICATION = alert.incoming_request_notification;
    public static final alert_category_t DHT_LOG_NOTIFICATION = alert.dht_log_notification;
    public static final alert_category_t DHT_OPERATION_NOTIFICATION = alert.dht_operation_notification;
    public static final alert_category_t PORT_MAPPING_LOG_NOTIFICATION = alert.port_mapping_log_notification;
    public static final alert_category_t PICKER_LOG_NOTIFICATION = alert.picker_log_notification;
    public static final alert_category_t FILE_PROGRESS_NOTIFICATION = alert.file_progress_notification;
    public static final alert_category_t PIECE_PROGRESS_NOTIFICATION = alert.piece_progress_notification;
    public static final alert_category_t UPLOAD_NOTIFICATION = alert.upload_notification;
    public static final alert_category_t BLOCK_PROGRESS_NOTIFICATION = alert.block_progress_notification;
    public static final alert_category_t ALL_CATEGORIES = alert.all_categories;

    alert_category_t category();

    String message();

    T swig();

    long timestamp();

    AlertType type();

    String what();
}
