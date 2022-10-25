package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.alert;
import com.frostwire.jlibtorrent.swig.libtorrent;

/* loaded from: classes2.dex */
public final class Alerts {
    public static final int NUM_ALERT_TYPES = libtorrent.getNum_alert_types();
    private static final CastLambda[] TABLE = buildTable();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface CastLambda {
        Alert cast(alert alertVar);
    }

    private Alerts() {
    }

    public static Alert cast(alert alertVar) {
        return TABLE[alertVar.type()].cast(alertVar);
    }

    private static CastLambda[] buildTable() {
        CastLambda[] castLambdaArr = new CastLambda[NUM_ALERT_TYPES];
        castLambdaArr[0] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.1
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[1] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.2
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[2] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.3
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[3] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.4
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[4] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.5
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentRemovedAlert(alert.cast_to_torrent_removed_alert(alertVar));
            }
        };
        castLambdaArr[5] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.6
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new ReadPieceAlert(alert.cast_to_read_piece_alert(alertVar));
            }
        };
        castLambdaArr[6] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.7
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new FileCompletedAlert(alert.cast_to_file_completed_alert(alertVar));
            }
        };
        castLambdaArr[7] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.8
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new FileRenamedAlert(alert.cast_to_file_renamed_alert(alertVar));
            }
        };
        castLambdaArr[8] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.9
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new FileRenameFailedAlert(alert.cast_to_file_rename_failed_alert(alertVar));
            }
        };
        castLambdaArr[9] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.10
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PerformanceAlert(alert.cast_to_performance_alert(alertVar));
            }
        };
        castLambdaArr[10] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.11
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new StateChangedAlert(alert.cast_to_state_changed_alert(alertVar));
            }
        };
        castLambdaArr[11] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.12
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TrackerErrorAlert(alert.cast_to_tracker_error_alert(alertVar));
            }
        };
        castLambdaArr[12] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.13
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TrackerWarningAlert(alert.cast_to_tracker_warning_alert(alertVar));
            }
        };
        castLambdaArr[13] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.14
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new ScrapeReplyAlert(alert.cast_to_scrape_reply_alert(alertVar));
            }
        };
        castLambdaArr[14] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.15
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new ScrapeFailedAlert(alert.cast_to_scrape_failed_alert(alertVar));
            }
        };
        castLambdaArr[15] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.16
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TrackerReplyAlert(alert.cast_to_tracker_reply_alert(alertVar));
            }
        };
        castLambdaArr[16] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.17
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtReplyAlert(alert.cast_to_dht_reply_alert(alertVar));
            }
        };
        castLambdaArr[17] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.18
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TrackerAnnounceAlert(alert.cast_to_tracker_announce_alert(alertVar));
            }
        };
        castLambdaArr[18] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.19
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new HashFailedAlert(alert.cast_to_hash_failed_alert(alertVar));
            }
        };
        castLambdaArr[19] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.20
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerBanAlert(alert.cast_to_peer_ban_alert(alertVar));
            }
        };
        castLambdaArr[20] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.21
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerUnsnubbedAlert(alert.cast_to_peer_unsnubbed_alert(alertVar));
            }
        };
        castLambdaArr[21] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.22
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerSnubbedAlert(alert.cast_to_peer_snubbed_alert(alertVar));
            }
        };
        castLambdaArr[22] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.23
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerErrorAlert(alert.cast_to_peer_error_alert(alertVar));
            }
        };
        castLambdaArr[23] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.24
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerConnectAlert(alert.cast_to_peer_connect_alert(alertVar));
            }
        };
        castLambdaArr[24] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.25
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerDisconnectedAlert(alert.cast_to_peer_disconnected_alert(alertVar));
            }
        };
        castLambdaArr[25] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.26
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new InvalidRequestAlert(alert.cast_to_invalid_request_alert(alertVar));
            }
        };
        castLambdaArr[26] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.27
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentFinishedAlert(alert.cast_to_torrent_finished_alert(alertVar));
            }
        };
        castLambdaArr[27] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.28
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PieceFinishedAlert(alert.cast_to_piece_finished_alert(alertVar));
            }
        };
        castLambdaArr[28] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.29
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new RequestDroppedAlert(alert.cast_to_request_dropped_alert(alertVar));
            }
        };
        castLambdaArr[29] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.30
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new BlockTimeoutAlert(alert.cast_to_block_timeout_alert(alertVar));
            }
        };
        castLambdaArr[30] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.31
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new BlockFinishedAlert(alert.cast_to_block_finished_alert(alertVar));
            }
        };
        castLambdaArr[31] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.32
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new BlockDownloadingAlert(alert.cast_to_block_downloading_alert(alertVar));
            }
        };
        castLambdaArr[32] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.33
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new UnwantedBlockAlert(alert.cast_to_unwanted_block_alert(alertVar));
            }
        };
        castLambdaArr[33] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.34
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new StorageMovedAlert(alert.cast_to_storage_moved_alert(alertVar));
            }
        };
        castLambdaArr[34] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.35
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new StorageMovedFailedAlert(alert.cast_to_storage_moved_failed_alert(alertVar));
            }
        };
        castLambdaArr[35] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.36
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentDeletedAlert(alert.cast_to_torrent_deleted_alert(alertVar));
            }
        };
        castLambdaArr[36] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.37
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentDeleteFailedAlert(alert.cast_to_torrent_delete_failed_alert(alertVar));
            }
        };
        castLambdaArr[37] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.38
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new SaveResumeDataAlert(alert.cast_to_save_resume_data_alert(alertVar));
            }
        };
        castLambdaArr[38] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.39
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new SaveResumeDataFailedAlert(alert.cast_to_save_resume_data_failed_alert(alertVar));
            }
        };
        castLambdaArr[39] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.40
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentPausedAlert(alert.cast_to_torrent_paused_alert(alertVar));
            }
        };
        castLambdaArr[40] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.41
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentResumedAlert(alert.cast_to_torrent_resumed_alert(alertVar));
            }
        };
        castLambdaArr[41] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.42
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentCheckedAlert(alert.cast_to_torrent_checked_alert(alertVar));
            }
        };
        castLambdaArr[42] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.43
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new UrlSeedAlert(alert.cast_to_url_seed_alert(alertVar));
            }
        };
        castLambdaArr[43] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.44
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new FileErrorAlert(alert.cast_to_file_error_alert(alertVar));
            }
        };
        castLambdaArr[44] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.45
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new MetadataFailedAlert(alert.cast_to_metadata_failed_alert(alertVar));
            }
        };
        castLambdaArr[45] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.46
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new MetadataReceivedAlert(alert.cast_to_metadata_received_alert(alertVar));
            }
        };
        castLambdaArr[46] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.47
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new UdpErrorAlert(alert.cast_to_udp_error_alert(alertVar));
            }
        };
        castLambdaArr[47] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.48
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new ExternalIpAlert(alert.cast_to_external_ip_alert(alertVar));
            }
        };
        castLambdaArr[48] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.49
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new ListenFailedAlert(alert.cast_to_listen_failed_alert(alertVar));
            }
        };
        castLambdaArr[49] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.50
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new ListenSucceededAlert(alert.cast_to_listen_succeeded_alert(alertVar));
            }
        };
        castLambdaArr[50] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.51
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PortmapErrorAlert(alert.cast_to_portmap_error_alert(alertVar));
            }
        };
        castLambdaArr[51] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.52
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PortmapAlert(alert.cast_to_portmap_alert(alertVar));
            }
        };
        castLambdaArr[52] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.53
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PortmapLogAlert(alert.cast_to_portmap_log_alert(alertVar));
            }
        };
        castLambdaArr[53] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.54
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new FastresumeRejectedAlert(alert.cast_to_fastresume_rejected_alert(alertVar));
            }
        };
        castLambdaArr[54] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.55
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerBlockedAlert(alert.cast_to_peer_blocked_alert(alertVar));
            }
        };
        castLambdaArr[55] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.56
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtAnnounceAlert(alert.cast_to_dht_announce_alert(alertVar));
            }
        };
        castLambdaArr[56] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.57
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtGetPeersAlert(alert.cast_to_dht_get_peers_alert(alertVar));
            }
        };
        castLambdaArr[57] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.58
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new StatsAlert(alert.cast_to_stats_alert(alertVar));
            }
        };
        castLambdaArr[58] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.59
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new CacheFlushedAlert(alert.cast_to_cache_flushed_alert(alertVar));
            }
        };
        castLambdaArr[59] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.60
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[60] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.61
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new LsdPeerAlert(alert.cast_to_lsd_peer_alert(alertVar));
            }
        };
        castLambdaArr[61] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.62
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TrackeridAlert(alert.cast_to_trackerid_alert(alertVar));
            }
        };
        castLambdaArr[62] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.63
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtBootstrapAlert(alert.cast_to_dht_bootstrap_alert(alertVar));
            }
        };
        castLambdaArr[63] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.64
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[64] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.65
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentErrorAlert(alert.cast_to_torrent_error_alert(alertVar));
            }
        };
        castLambdaArr[65] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.66
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentNeedCertAlert(alert.cast_to_torrent_need_cert_alert(alertVar));
            }
        };
        castLambdaArr[66] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.67
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new IncomingConnectionAlert(alert.cast_to_incoming_connection_alert(alertVar));
            }
        };
        castLambdaArr[67] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.68
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new AddTorrentAlert(alert.cast_to_add_torrent_alert(alertVar));
            }
        };
        castLambdaArr[68] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.69
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new StateUpdateAlert(alert.cast_to_state_update_alert(alertVar));
            }
        };
        castLambdaArr[69] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.70
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[70] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.71
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new SessionStatsAlert(alert.cast_to_session_stats_alert(alertVar));
            }
        };
        castLambdaArr[71] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.72
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[72] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.73
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return Alerts.handleUnknownAlert(alertVar);
            }
        };
        castLambdaArr[73] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.74
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtErrorAlert(alert.cast_to_dht_error_alert(alertVar));
            }
        };
        castLambdaArr[74] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.75
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtImmutableItemAlert(alert.cast_to_dht_immutable_item_alert(alertVar));
            }
        };
        castLambdaArr[75] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.76
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtMutableItemAlert(alert.cast_to_dht_mutable_item_alert(alertVar));
            }
        };
        castLambdaArr[76] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.77
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtPutAlert(alert.cast_to_dht_put_alert(alertVar));
            }
        };
        castLambdaArr[77] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.78
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new I2pAlert(alert.cast_to_i2p_alert(alertVar));
            }
        };
        castLambdaArr[78] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.79
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtOutgoingGetPeersAlert(alert.cast_to_dht_outgoing_get_peers_alert(alertVar));
            }
        };
        castLambdaArr[79] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.80
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new LogAlert(alert.cast_to_log_alert(alertVar));
            }
        };
        castLambdaArr[80] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.81
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new TorrentLogAlert(alert.cast_to_torrent_log_alert(alertVar));
            }
        };
        castLambdaArr[81] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.82
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PeerLogAlert(alert.cast_to_peer_log_alert(alertVar));
            }
        };
        castLambdaArr[82] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.83
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new LsdErrorAlert(alert.cast_to_lsd_error_alert(alertVar));
            }
        };
        castLambdaArr[83] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.84
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtStatsAlert(alert.cast_to_dht_stats_alert(alertVar));
            }
        };
        castLambdaArr[84] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.85
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new IncomingRequestAlert(alert.cast_to_incoming_request_alert(alertVar));
            }
        };
        castLambdaArr[85] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.86
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtLogAlert(alert.cast_to_dht_log_alert(alertVar));
            }
        };
        castLambdaArr[86] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.87
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtPktAlert(alert.cast_to_dht_pkt_alert(alertVar));
            }
        };
        castLambdaArr[87] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.88
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtGetPeersReplyAlert(alert.cast_to_dht_get_peers_reply_alert(alertVar));
            }
        };
        castLambdaArr[88] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.89
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtDirectResponseAlert(alert.cast_to_dht_direct_response_alert(alertVar));
            }
        };
        castLambdaArr[89] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.90
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new PickerLogAlert(alert.cast_to_picker_log_alert(alertVar));
            }
        };
        castLambdaArr[90] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.91
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new SessionErrorAlert(alert.cast_to_session_error_alert(alertVar));
            }
        };
        castLambdaArr[91] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.92
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtLiveNodesAlert(alert.cast_to_dht_live_nodes_alert(alertVar));
            }
        };
        castLambdaArr[92] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.93
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new SessionStatsHeaderAlert(alert.cast_to_session_stats_header_alert(alertVar));
            }
        };
        castLambdaArr[93] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.94
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new DhtSampleInfohashesAlert(alert.cast_to_dht_sample_infohashes_alert(alertVar));
            }
        };
        castLambdaArr[94] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.95
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new BlockUploadedAlert(alert.cast_to_block_uploaded_alert(alertVar));
            }
        };
        castLambdaArr[95] = new CastLambda() { // from class: com.frostwire.jlibtorrent.alerts.Alerts.96
            @Override // com.frostwire.jlibtorrent.alerts.Alerts.CastLambda
            public Alert cast(alert alertVar) {
                return new AlertsDroppedAlert(alert.cast_to_alerts_dropped_alert(alertVar));
            }
        };
        return castLambdaArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Alert handleUnknownAlert(alert alertVar) {
        throw new IllegalArgumentException("alert not known: " + alertVar.type() + " - " + alertVar.message());
    }
}
