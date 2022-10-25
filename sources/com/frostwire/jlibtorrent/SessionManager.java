package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.alerts.AddTorrentAlert;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.Alerts;
import com.frostwire.jlibtorrent.alerts.DhtGetPeersReplyAlert;
import com.frostwire.jlibtorrent.alerts.DhtImmutableItemAlert;
import com.frostwire.jlibtorrent.alerts.DhtMutableItemAlert;
import com.frostwire.jlibtorrent.alerts.ExternalIpAlert;
import com.frostwire.jlibtorrent.alerts.ListenFailedAlert;
import com.frostwire.jlibtorrent.alerts.ListenSucceededAlert;
import com.frostwire.jlibtorrent.alerts.SocketType;
import com.frostwire.jlibtorrent.swig.C2430session;
import com.frostwire.jlibtorrent.swig.add_torrent_params;
import com.frostwire.jlibtorrent.swig.alert;
import com.frostwire.jlibtorrent.swig.alert_category_t;
import com.frostwire.jlibtorrent.swig.byte_vector;
import com.frostwire.jlibtorrent.swig.entry;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.port_filter;
import com.frostwire.jlibtorrent.swig.remove_flags_t;
import com.frostwire.jlibtorrent.swig.session_params;
import com.frostwire.jlibtorrent.swig.settings_pack;
import com.frostwire.jlibtorrent.swig.sha1_hash;
import com.frostwire.jlibtorrent.swig.tcp_endpoint_vector;
import com.frostwire.jlibtorrent.swig.torrent_handle;
import com.frostwire.jlibtorrent.swig.torrent_handle_vector;
import com.frostwire.jlibtorrent.swig.torrent_status;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class SessionManager {
    private static final long ALERTS_LOOP_WAIT_MILLIS = 500;
    private static final String FETCH_MAGNET_DOWNLOAD_KEY = "fetch_magnet___";
    private static final long REQUEST_STATS_RESOLUTION_MILLIS = 1000;
    private Thread alertsLoop;
    private String externalAddress;
    private int externalPort;
    private boolean firewalled;
    private Throwable lastAlertError;
    private long lastStatsRequestTime;
    private final Map<String, String> listenEndpoints;
    private final AlertListener[] listeners;
    private final boolean logging;
    private volatile C2430session session;
    private final SessionStats stats;
    private final ReentrantLock sync;
    private final ReentrantLock syncMagnet;
    private static final Logger LOG = Logger.getLogger(SessionManager.class);
    private static final int[] METADATA_ALERT_TYPES = {AlertType.METADATA_RECEIVED.swig(), AlertType.METADATA_FAILED.swig()};
    private static final int[] DHT_IMMUTABLE_ITEM_TYPES = {AlertType.DHT_IMMUTABLE_ITEM.swig()};
    private static final int[] DHT_MUTABLE_ITEM_TYPES = {AlertType.DHT_MUTABLE_ITEM.swig()};
    private static final int[] DHT_GET_PEERS_REPLY_ALERT_TYPES = {AlertType.DHT_GET_PEERS_REPLY.swig()};

    protected void onAfterStart() {
    }

    protected void onAfterStop() {
    }

    protected void onApplySettings(SettingsPack settingsPack) {
    }

    protected void onBeforeStart() {
    }

    protected void onBeforeStop() {
    }

    public SessionManager(boolean z) {
        this.logging = z;
        this.listeners = new AlertListener[Alerts.NUM_ALERT_TYPES + 1];
        this.sync = new ReentrantLock();
        this.syncMagnet = new ReentrantLock();
        this.stats = new SessionStats();
        this.listenEndpoints = new HashMap();
        resetState();
    }

    public SessionManager() {
        this(false);
    }

    public C2430session swig() {
        return this.session;
    }

    public void addListener(AlertListener alertListener) {
        modifyListeners(true, alertListener);
    }

    public void removeListener(AlertListener alertListener) {
        modifyListeners(false, alertListener);
    }

    public void start(SessionParams sessionParams) {
        if (this.session != null) {
            return;
        }
        this.sync.lock();
        try {
            if (this.session != null) {
                return;
            }
            onBeforeStart();
            resetState();
            sessionParams.settings().setInteger(settings_pack.int_types.alert_mask.swigValue(), alertMask(this.logging).to_int());
            this.session = new C2430session(sessionParams.swig());
            alertsLoop();
            port_filter port_filterVar = new port_filter();
            port_filterVar.add_rule(0, 79, 1L);
            port_filterVar.add_rule(81, 442, 1L);
            port_filterVar.add_rule(444, AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES, 1L);
            this.session.set_port_filter(port_filterVar);
            onAfterStart();
        } finally {
            this.sync.unlock();
        }
    }

    public void start() {
        settings_pack settings_packVar = new settings_pack();
        settings_packVar.set_str(settings_pack.string_types.dht_bootstrap_nodes.swigValue(), dhtBootstrapNodes());
        start(new SessionParams(new session_params(settings_packVar)));
    }

    public void stop() {
        if (this.session == null) {
            return;
        }
        this.sync.lock();
        try {
            if (this.session == null) {
                return;
            }
            onBeforeStop();
            C2430session c2430session = this.session;
            this.session = null;
            c2430session.post_session_stats();
            try {
                Thread.sleep(750L);
            } catch (InterruptedException unused) {
            }
            Thread thread = this.alertsLoop;
            if (thread != null) {
                try {
                    thread.join();
                } catch (Throwable unused2) {
                }
            }
            resetState();
            c2430session.delete();
            onAfterStop();
        } finally {
            this.sync.unlock();
        }
    }

    public void restart() {
        this.sync.lock();
        try {
            stop();
            Thread.sleep(1000L);
            start();
        } catch (InterruptedException unused) {
        } catch (Throwable th) {
            this.sync.unlock();
            throw th;
        }
        this.sync.unlock();
    }

    public boolean isRunning() {
        return this.session != null;
    }

    public void pause() {
        if (this.session == null || this.session.is_paused()) {
            return;
        }
        this.session.pause();
    }

    public void resume() {
        if (this.session != null) {
            this.session.resume();
        }
    }

    public boolean isPaused() {
        if (this.session != null) {
            return this.session.is_paused();
        }
        return false;
    }

    public SessionStats stats() {
        return this.stats;
    }

    public long downloadRate() {
        return this.stats.downloadRate();
    }

    public long uploadRate() {
        return this.stats.uploadRate();
    }

    public long totalDownload() {
        return this.stats.totalDownload();
    }

    public long totalUpload() {
        return this.stats.totalUpload();
    }

    public long dhtNodes() {
        return this.stats.dhtNodes();
    }

    public boolean isFirewalled() {
        return this.firewalled;
    }

    public String externalAddress() {
        return this.externalAddress;
    }

    public List<String> listenEndpoints() {
        return new ArrayList(this.listenEndpoints.values());
    }

    public SettingsPack settings() {
        if (this.session != null) {
            return new SettingsPack(this.session.get_settings());
        }
        return null;
    }

    public void applySettings(SettingsPack settingsPack) {
        if (this.session != null) {
            if (settingsPack == null) {
                throw new IllegalArgumentException("settings pack can't be null");
            }
            this.session.apply_settings(settingsPack.swig());
            onApplySettings(settingsPack);
        }
    }

    public int downloadRateLimit() {
        if (this.session == null) {
            return 0;
        }
        return settings().downloadRateLimit();
    }

    public void downloadRateLimit(int i) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().downloadRateLimit(i));
    }

    public int uploadRateLimit() {
        if (this.session == null) {
            return 0;
        }
        return settings().uploadRateLimit();
    }

    public void uploadRateLimit(int i) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().uploadRateLimit(i));
    }

    public int maxActiveDownloads() {
        if (this.session == null) {
            return 0;
        }
        return settings().activeDownloads();
    }

    public void maxActiveDownloads(int i) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().activeDownloads(i));
    }

    public int maxActiveSeeds() {
        if (this.session == null) {
            return 0;
        }
        return settings().activeSeeds();
    }

    public void maxActiveSeeds(int i) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().activeSeeds(i));
    }

    public int maxConnections() {
        if (this.session == null) {
            return 0;
        }
        return settings().connectionsLimit();
    }

    public void maxConnections(int i) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().connectionsLimit(i));
    }

    public int maxPeers() {
        if (this.session == null) {
            return 0;
        }
        return settings().maxPeerlistSize();
    }

    public void maxPeers(int i) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().maxPeerlistSize(i));
    }

    public String listenInterfaces() {
        if (this.session == null) {
            return null;
        }
        return settings().listenInterfaces();
    }

    public void listenInterfaces(String str) {
        if (this.session == null) {
            return;
        }
        applySettings(new SettingsPack().listenInterfaces(str));
    }

    public void postSessionStats() {
        if (this.session != null) {
            this.session.post_session_stats();
        }
    }

    public void postDhtStats() {
        if (this.session != null) {
            this.session.post_dht_stats();
        }
    }

    public void postTorrentUpdates() {
        if (this.session != null) {
            this.session.post_torrent_updates();
        }
    }

    public boolean isDhtRunning() {
        if (this.session != null) {
            return this.session.is_dht_running();
        }
        return false;
    }

    public void startDht() {
        toggleDht(true);
    }

    public void stopDht() {
        toggleDht(false);
    }

    public TorrentHandle find(Sha1Hash sha1Hash) {
        torrent_handle find_torrent;
        if (this.session == null || (find_torrent = this.session.find_torrent(sha1Hash.swig())) == null || !find_torrent.is_valid()) {
            return null;
        }
        return new TorrentHandle(find_torrent);
    }

    public void download(TorrentInfo torrentInfo, File file, File file2, Priority[] priorityArr, List<TcpEndpoint> list) {
        if (this.session == null) {
            return;
        }
        if (!torrentInfo.isValid()) {
            throw new IllegalArgumentException("torrent info not valid");
        }
        torrent_handle find_torrent = this.session.find_torrent(torrentInfo.swig().info_hash());
        if (find_torrent != null && find_torrent.is_valid()) {
            if (priorityArr != null) {
                if (torrentInfo.numFiles() != priorityArr.length) {
                    throw new IllegalArgumentException("priorities count should be equals to the number of files");
                }
                find_torrent.prioritize_files2(Priority.array2vector(priorityArr));
                return;
            }
            find_torrent.prioritize_files2(Priority.array2vector(Priority.array(Priority.NORMAL, torrentInfo.numFiles())));
            return;
        }
        add_torrent_params add_torrent_paramsVar = null;
        if (file2 != null) {
            try {
                byte[] bytes = Files.bytes(file2);
                error_code error_codeVar = new error_code();
                add_torrent_paramsVar = add_torrent_params.read_resume_data(Vectors.bytes2byte_vector(bytes), error_codeVar);
                if (error_codeVar.value() != 0) {
                    throw new IllegalArgumentException("Unable to read the resume data: " + error_codeVar.message());
                }
            } catch (Throwable th) {
                LOG.warn("Unable to set resume data", th);
            }
        }
        if (add_torrent_paramsVar == null) {
            add_torrent_paramsVar = add_torrent_params.create_instance();
        }
        add_torrent_paramsVar.set_ti(torrentInfo.swig());
        if (file != null) {
            add_torrent_paramsVar.setSave_path(file.getAbsolutePath());
        }
        if (priorityArr != null) {
            if (torrentInfo.files().numFiles() != priorityArr.length) {
                throw new IllegalArgumentException("priorities count should be equals to the number of files");
            }
            byte_vector byte_vectorVar = new byte_vector();
            for (Priority priority : priorityArr) {
                byte_vectorVar.push_back((byte) priority.swig());
            }
            add_torrent_paramsVar.set_file_priorities2(byte_vectorVar);
        }
        if (list != null && !list.isEmpty()) {
            tcp_endpoint_vector tcp_endpoint_vectorVar = new tcp_endpoint_vector();
            for (TcpEndpoint tcpEndpoint : list) {
                tcp_endpoint_vectorVar.push_back(tcpEndpoint.swig());
            }
            add_torrent_paramsVar.set_peers(tcp_endpoint_vectorVar);
        }
        add_torrent_paramsVar.setFlags(add_torrent_paramsVar.getFlags().and_(TorrentFlags.AUTO_MANAGED.inv()));
        this.session.async_add_torrent(add_torrent_paramsVar);
    }

    public void download(String str, File file) {
        if (this.session == null) {
            return;
        }
        error_code error_codeVar = new error_code();
        add_torrent_params parse_magnet_uri = add_torrent_params.parse_magnet_uri(str, error_codeVar);
        if (error_codeVar.value() != 0) {
            throw new IllegalArgumentException(error_codeVar.message());
        }
        torrent_handle find_torrent = this.session.find_torrent(parse_magnet_uri.getInfo_hash());
        if (find_torrent == null || !find_torrent.is_valid()) {
            if (file != null) {
                parse_magnet_uri.setSave_path(file.getAbsolutePath());
            }
            parse_magnet_uri.setFlags(parse_magnet_uri.getFlags().and_(TorrentFlags.AUTO_MANAGED.inv()));
            this.session.async_add_torrent(parse_magnet_uri);
        }
    }

    public void download(TorrentInfo torrentInfo, File file) {
        download(torrentInfo, file, null, null, null);
    }

    public void remove(TorrentHandle torrentHandle, remove_flags_t remove_flags_tVar) {
        if (this.session == null || !torrentHandle.isValid()) {
            return;
        }
        this.session.remove_torrent(torrentHandle.swig(), remove_flags_tVar);
    }

    public void remove(TorrentHandle torrentHandle) {
        if (this.session == null || !torrentHandle.isValid()) {
            return;
        }
        this.session.remove_torrent(torrentHandle.swig());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f6, code lost:
        if (r0 != false) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.frostwire.jlibtorrent.SessionManager$1] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] fetchMagnet(java.lang.String r18, int r19, final boolean r20, final int r21) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.frostwire.jlibtorrent.SessionManager.fetchMagnet(java.lang.String, int, boolean, int):byte[]");
    }

    public byte[] fetchMagnet(String str, int i, boolean z) {
        return fetchMagnet(str, i, z, 2097152);
    }

    public byte[] fetchMagnet(String str, int i) {
        return fetchMagnet(str, i, false);
    }

    public Entry dhtGetItem(Sha1Hash sha1Hash, int i) {
        if (this.session == null) {
            return null;
        }
        final sha1_hash swig = sha1Hash.swig();
        final Entry[] entryArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        addListener(new AlertListener() { // from class: com.frostwire.jlibtorrent.SessionManager.2
            @Override // com.frostwire.jlibtorrent.AlertListener
            public int[] types() {
                return SessionManager.DHT_IMMUTABLE_ITEM_TYPES;
            }

            @Override // com.frostwire.jlibtorrent.AlertListener
            public void alert(Alert<?> alert) {
                DhtImmutableItemAlert dhtImmutableItemAlert = (DhtImmutableItemAlert) alert;
                if (swig.op_eq(dhtImmutableItemAlert.swig().getTarget())) {
                    entryArr[0] = new Entry(new entry(dhtImmutableItemAlert.swig().getItem()));
                    countDownLatch.countDown();
                }
            }
        });
        try {
            this.session.dht_get_item(swig);
            countDownLatch.await(i, TimeUnit.SECONDS);
        } finally {
            try {
                return entryArr[0];
            } finally {
            }
        }
        return entryArr[0];
    }

    public Sha1Hash dhtPutItem(Entry entry) {
        if (this.session != null) {
            return new SessionHandle(this.session).dhtPutItem(entry);
        }
        return null;
    }

    public MutableItem dhtGetItem(final byte[] bArr, final byte[] bArr2, int i) {
        if (this.session == null) {
            return null;
        }
        final MutableItem[] mutableItemArr = {null};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AlertListener alertListener = new AlertListener() { // from class: com.frostwire.jlibtorrent.SessionManager.3
            @Override // com.frostwire.jlibtorrent.AlertListener
            public int[] types() {
                return SessionManager.DHT_MUTABLE_ITEM_TYPES;
            }

            @Override // com.frostwire.jlibtorrent.AlertListener
            public void alert(Alert<?> alert) {
                DhtMutableItemAlert dhtMutableItemAlert = (DhtMutableItemAlert) alert;
                boolean equals = Arrays.equals(bArr, dhtMutableItemAlert.key());
                boolean equals2 = Arrays.equals(bArr2, dhtMutableItemAlert.salt());
                if (equals && equals2) {
                    mutableItemArr[0] = new MutableItem(new Entry(new entry(dhtMutableItemAlert.swig().getItem())), dhtMutableItemAlert.signature(), dhtMutableItemAlert.seq());
                    countDownLatch.countDown();
                }
            }
        };
        addListener(alertListener);
        try {
            new SessionHandle(this.session).dhtGetItem(bArr, bArr2);
            countDownLatch.await(i, TimeUnit.SECONDS);
        } finally {
            try {
                removeListener(alertListener);
                return mutableItemArr[0];
            } catch (Throwable th) {
            }
        }
        removeListener(alertListener);
        return mutableItemArr[0];
    }

    public void dhtPutItem(byte[] bArr, byte[] bArr2, Entry entry, byte[] bArr3) {
        if (this.session != null) {
            new SessionHandle(this.session).dhtPutItem(bArr, bArr2, entry, bArr3);
        }
    }

    public ArrayList<TcpEndpoint> dhtGetPeers(Sha1Hash sha1Hash, int i) {
        final ArrayList<TcpEndpoint> arrayList = new ArrayList<>();
        if (this.session == null) {
            return arrayList;
        }
        final sha1_hash swig = sha1Hash.swig();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        addListener(new AlertListener() { // from class: com.frostwire.jlibtorrent.SessionManager.4
            @Override // com.frostwire.jlibtorrent.AlertListener
            public int[] types() {
                return SessionManager.DHT_GET_PEERS_REPLY_ALERT_TYPES;
            }

            @Override // com.frostwire.jlibtorrent.AlertListener
            public void alert(Alert<?> alert) {
                DhtGetPeersReplyAlert dhtGetPeersReplyAlert = (DhtGetPeersReplyAlert) alert;
                if (swig.op_eq(dhtGetPeersReplyAlert.swig().getInfo_hash())) {
                    arrayList.addAll(dhtGetPeersReplyAlert.peers());
                    countDownLatch.countDown();
                }
            }
        });
        try {
            this.session.dht_get_peers(swig);
            countDownLatch.await(i, TimeUnit.SECONDS);
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    public void dhtAnnounce(Sha1Hash sha1Hash, int i, int i2) {
        if (this.session != null) {
            this.session.dht_announce(sha1Hash.swig(), i, i2);
        }
    }

    public void dhtAnnounce(Sha1Hash sha1Hash) {
        if (this.session != null) {
            this.session.dht_announce(sha1Hash.swig());
        }
    }

    public void moveStorage(File file) {
        if (this.session == null) {
            return;
        }
        try {
            torrent_handle_vector torrent_handle_vectorVar = this.session.get_torrents();
            int size = (int) torrent_handle_vectorVar.size();
            String absolutePath = file.getAbsolutePath();
            for (int i = 0; i < size; i++) {
                torrent_handle torrent_handleVar = torrent_handle_vectorVar.get(i);
                torrent_status status = torrent_handleVar.status();
                boolean z = (status.getIs_seeding() || status.getIs_finished()) ? false : true;
                if (torrent_handleVar.is_valid() && z) {
                    torrent_handleVar.move_storage(absolutePath);
                }
            }
        } catch (Throwable th) {
            LOG.error("Error changing save path for session", th);
        }
    }

    public byte[] saveState() {
        if (this.session != null) {
            return new SessionHandle(this.session).saveState();
        }
        return null;
    }

    public void loadState(byte[] bArr) {
        if (this.session != null) {
            new SessionHandle(this.session).loadState(bArr);
        }
    }

    public void reopenNetworkSockets() {
        if (this.session != null) {
            this.session.reopen_network_sockets();
        }
    }

    public String magnetPeers() {
        if (this.session == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (this.externalAddress != null && this.externalPort > 0) {
            sb.append("&x.pe=");
            sb.append(this.externalAddress);
            sb.append(":");
            sb.append(this.externalPort);
        }
        for (String str : this.listenEndpoints.values()) {
            sb.append("&x.pe=");
            sb.append(str);
        }
        return sb.toString();
    }

    public Throwable lastAlertError() {
        return this.lastAlertError;
    }

    protected void finalize() throws Throwable {
        stop();
        super.finalize();
    }

    private void resetState() {
        this.stats.clear();
        this.firewalled = true;
        this.listenEndpoints.clear();
        this.externalAddress = null;
        this.alertsLoop = null;
    }

    private void modifyListeners(boolean z, AlertListener alertListener) {
        if (alertListener == null) {
            return;
        }
        int[] types = alertListener.types();
        if (types == null) {
            modifyListeners(z, Alerts.NUM_ALERT_TYPES, alertListener);
            return;
        }
        for (int i : types) {
            modifyListeners(z, i, alertListener);
        }
    }

    private synchronized void modifyListeners(boolean z, int i, AlertListener alertListener) {
        if (z) {
            AlertListener[] alertListenerArr = this.listeners;
            alertListenerArr[i] = AlertMulticaster.add(alertListenerArr[i], alertListener);
        } else {
            AlertListener[] alertListenerArr2 = this.listeners;
            alertListenerArr2[i] = AlertMulticaster.remove(alertListenerArr2[i], alertListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireAlert(Alert<?> alert, int i) {
        AlertListener alertListener = this.listeners[i];
        if (alertListener != null) {
            try {
                alertListener.alert(alert);
            } catch (Throwable th) {
                Logger logger = LOG;
                logger.warn("Error calling alert listener: " + th.getMessage());
                this.lastAlertError = th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListenSucceeded(ListenSucceededAlert listenSucceededAlert) {
        String str;
        try {
            if (listenSucceededAlert.socketType() == SocketType.TCP) {
                return;
            }
            Address address = listenSucceededAlert.address();
            if (address.isV4()) {
                this.externalPort = listenSucceededAlert.port();
            }
            if (!address.isLoopback() && !address.isMulticast() && !address.isUnspecified()) {
                String address2 = address.toString();
                int port = listenSucceededAlert.port();
                if (!address2.contains("invalid") && !address2.startsWith("127.") && !address2.startsWith("fe80::")) {
                    StringBuilder sb = new StringBuilder();
                    if (address.isV6()) {
                        str = "[" + address2 + "]";
                    } else {
                        str = address2;
                    }
                    sb.append(str);
                    sb.append(":");
                    sb.append(port);
                    this.listenEndpoints.put(address2, sb.toString());
                }
            }
        } catch (Throwable th) {
            LOG.error("Error adding listen endpoint to internal list", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListenFailed(ListenFailedAlert listenFailedAlert) {
        Logger logger = LOG;
        logger.error("onListenFailed(): iface= " + listenFailedAlert.listenInterface() + ", address= " + listenFailedAlert.address() + ", port= " + listenFailedAlert.port() + ", socketType= " + listenFailedAlert.socketType() + ", errorCode= " + listenFailedAlert.error());
        StringBuilder sb = new StringBuilder();
        sb.append("onListenFailed(): error_message=");
        sb.append(listenFailedAlert.message());
        logger.error(sb.toString());
    }

    private void toggleDht(boolean z) {
        if (this.session == null || isDhtRunning() == z) {
            return;
        }
        applySettings(new SettingsPack().enableDht(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onExternalIpAlert(ExternalIpAlert externalIpAlert) {
        try {
            if (externalIpAlert.swig().get_external_address().is_v4()) {
                String address = externalIpAlert.externalAddress().toString();
                if (address.contains("invalid")) {
                    return;
                }
                this.externalAddress = address;
            }
        } catch (Throwable th) {
            LOG.error("Error saving reported external ip", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFetchMagnetDownload(AddTorrentAlert addTorrentAlert) {
        String str = addTorrentAlert.torrentName();
        return str != null && str.contains(FETCH_MAGNET_DOWNLOAD_KEY);
    }

    private static alert_category_t alertMask(boolean z) {
        alert_category_t alert_category_tVar = alert.all_categories;
        return !z ? alert_category_tVar.and_(alert.session_log_notification.or_(alert.torrent_log_notification).or_(alert.peer_log_notification).or_(alert.dht_log_notification).or_(alert.port_mapping_log_notification).or_(alert.picker_log_notification).inv()) : alert_category_tVar;
    }

    private static String dhtBootstrapNodes() {
        return "dht.libtorrent.org:25401,router.bittorrent.com:6881,dht.transmissionbt.com:6881,router.silotis.us:6881";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpecialType(int i) {
        return i == AlertType.SESSION_STATS.swig() || i == AlertType.STATE_UPDATE.swig() || i == AlertType.SESSION_STATS_HEADER.swig();
    }

    private void alertsLoop() {
        Thread thread = new Thread(new Runnable() { // from class: com.frostwire.jlibtorrent.SessionManager.5
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x00da A[ADDED_TO_REGION, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 280
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.frostwire.jlibtorrent.SessionManager.RunnableC23285.run():void");
            }
        }, "SessionManager-alertsLoop");
        thread.setDaemon(true);
        thread.start();
        this.alertsLoop = thread;
    }

    /* renamed from: com.frostwire.jlibtorrent.SessionManager$6 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C23296 {
        static final /* synthetic */ int[] $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType;

        static {
            int[] iArr = new int[AlertType.values().length];
            $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType = iArr;
            try {
                iArr[AlertType.SESSION_STATS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.PORTMAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.PORTMAP_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.LISTEN_SUCCEEDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.LISTEN_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.EXTERNAL_IP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.ADD_TORRENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class MutableItem {
        public final Entry item;
        public final long seq;
        public final byte[] signature;

        private MutableItem(Entry entry, byte[] bArr, long j) {
            this.item = entry;
            this.signature = bArr;
            this.seq = j;
        }
    }
}
