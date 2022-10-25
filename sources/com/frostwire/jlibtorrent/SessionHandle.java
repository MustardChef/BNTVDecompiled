package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.bdecode_node;
import com.frostwire.jlibtorrent.swig.byte_vector;
import com.frostwire.jlibtorrent.swig.entry;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.port_mapping_t_vector;
import com.frostwire.jlibtorrent.swig.portmap_protocol;
import com.frostwire.jlibtorrent.swig.remove_flags_t;
import com.frostwire.jlibtorrent.swig.reopen_network_flags_t;
import com.frostwire.jlibtorrent.swig.save_state_flags_t;
import com.frostwire.jlibtorrent.swig.session_handle;
import com.frostwire.jlibtorrent.swig.status_flags_t;
import com.frostwire.jlibtorrent.swig.torrent_handle;
import com.frostwire.jlibtorrent.swig.torrent_handle_vector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SessionHandle {
    public static final int DHT_ANNOUNCE_IMPLIED_PORT = 2;
    public static final int DHT_ANNOUNCE_SEED = 1;
    public static final int DHT_ANNOUNCE_SSL_TORRENT = 4;

    /* renamed from: s */
    protected final session_handle f2824s;
    private static final Logger LOG = Logger.getLogger(SessionHandle.class);
    public static final save_state_flags_t SAVE_SETTINGS = session_handle.save_settings;
    public static final save_state_flags_t SAVE_DHT_SETTINGS = session_handle.save_dht_settings;
    public static final save_state_flags_t SAVE_DHT_STATE = session_handle.save_dht_state;
    public static final remove_flags_t DELETE_FILES = session_handle.delete_files;
    public static final remove_flags_t DELETE_PARTFILE = session_handle.delete_partfile;
    public static final reopen_network_flags_t REOPEN_MAP_PORTS = session_handle.reopen_map_ports;

    public SessionHandle(session_handle session_handleVar) {
        this.f2824s = session_handleVar;
    }

    public session_handle swig() {
        return this.f2824s;
    }

    public boolean isValid() {
        return this.f2824s.is_valid();
    }

    public byte[] saveState(save_state_flags_t save_state_flags_tVar) {
        entry entryVar = new entry();
        this.f2824s.save_state(entryVar, save_state_flags_tVar);
        return Vectors.byte_vector2bytes(entryVar.bencode());
    }

    public byte[] saveState() {
        entry entryVar = new entry();
        this.f2824s.save_state(entryVar);
        return Vectors.byte_vector2bytes(entryVar.bencode());
    }

    public void loadState(byte[] bArr, save_state_flags_t save_state_flags_tVar) {
        byte_vector bytes2byte_vector = Vectors.bytes2byte_vector(bArr);
        bdecode_node bdecode_nodeVar = new bdecode_node();
        error_code error_codeVar = new error_code();
        if (bdecode_node.bdecode(bytes2byte_vector, bdecode_nodeVar, error_codeVar) == 0) {
            this.f2824s.load_state(bdecode_nodeVar, save_state_flags_tVar);
            bytes2byte_vector.clear();
            return;
        }
        Logger logger = LOG;
        logger.error("failed to decode bencoded data: " + error_codeVar.message());
    }

    public void loadState(byte[] bArr) {
        byte_vector bytes2byte_vector = Vectors.bytes2byte_vector(bArr);
        bdecode_node bdecode_nodeVar = new bdecode_node();
        error_code error_codeVar = new error_code();
        if (bdecode_node.bdecode(bytes2byte_vector, bdecode_nodeVar, error_codeVar) == 0) {
            this.f2824s.load_state(bdecode_nodeVar);
            bytes2byte_vector.clear();
            return;
        }
        Logger logger = LOG;
        logger.error("failed to decode bencoded data: " + error_codeVar.message());
    }

    public void postTorrentUpdates(status_flags_t status_flags_tVar) {
        this.f2824s.post_torrent_updates(status_flags_tVar);
    }

    public void postTorrentUpdates() {
        this.f2824s.post_torrent_updates();
    }

    public void postSessionStats() {
        this.f2824s.post_session_stats();
    }

    public void postDhtStats() {
        this.f2824s.post_dht_stats();
    }

    public TorrentHandle findTorrent(Sha1Hash sha1Hash) {
        torrent_handle find_torrent = this.f2824s.find_torrent(sha1Hash.swig());
        if (find_torrent == null || !find_torrent.is_valid()) {
            return null;
        }
        return new TorrentHandle(find_torrent);
    }

    public List<TorrentHandle> torrents() {
        torrent_handle_vector torrent_handle_vectorVar = this.f2824s.get_torrents();
        int size = (int) torrent_handle_vectorVar.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new TorrentHandle(torrent_handle_vectorVar.get(i)));
        }
        return arrayList;
    }

    public TorrentHandle addTorrent(AddTorrentParams addTorrentParams, ErrorCode errorCode) {
        error_code error_codeVar = new error_code();
        TorrentHandle torrentHandle = new TorrentHandle(this.f2824s.add_torrent(addTorrentParams.swig(), error_codeVar));
        errorCode.assign(error_codeVar);
        return torrentHandle;
    }

    public void asyncAddTorrent(AddTorrentParams addTorrentParams) {
        this.f2824s.async_add_torrent(addTorrentParams.swig());
    }

    public void removeTorrent(TorrentHandle torrentHandle, remove_flags_t remove_flags_tVar) {
        if (torrentHandle.isValid()) {
            this.f2824s.remove_torrent(torrentHandle.swig(), remove_flags_tVar);
        }
    }

    public void removeTorrent(TorrentHandle torrentHandle) {
        if (torrentHandle.isValid()) {
            this.f2824s.remove_torrent(torrentHandle.swig());
        }
    }

    public void pause() {
        this.f2824s.pause();
    }

    public void resume() {
        this.f2824s.resume();
    }

    public boolean isPaused() {
        return this.f2824s.is_paused();
    }

    void setDhtSettings(DhtSettings dhtSettings) {
        this.f2824s.set_dht_settings(dhtSettings.swig());
    }

    public boolean isDhtRunning() {
        return this.f2824s.is_dht_running();
    }

    public void addDhtNode(Pair<String, Integer> pair) {
        this.f2824s.add_dht_node(pair.to_string_int_pair());
    }

    public void applySettings(SettingsPack settingsPack) {
        this.f2824s.apply_settings(settingsPack.swig());
    }

    public SettingsPack settings() {
        return new SettingsPack(this.f2824s.get_settings());
    }

    public int[] addPortMapping(PortmapProtocol portmapProtocol, int i, int i2) {
        port_mapping_t_vector add_port_mapping = this.f2824s.add_port_mapping(portmap_protocol.swigToEnum(portmapProtocol.swig()), i, i2);
        int size = (int) add_port_mapping.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = add_port_mapping.get(i3);
        }
        return iArr;
    }

    public void deletePortMapping(int i) {
        this.f2824s.delete_port_mapping(i);
    }

    public void reopenNetworkSockets(reopen_network_flags_t reopen_network_flags_tVar) {
        this.f2824s.reopen_network_sockets(reopen_network_flags_tVar);
    }

    public void reopenNetworkSockets() {
        this.f2824s.reopen_network_sockets();
    }

    public void dhtGetItem(Sha1Hash sha1Hash) {
        this.f2824s.dht_get_item(sha1Hash.swig());
    }

    public void dhtGetItem(byte[] bArr, byte[] bArr2) {
        this.f2824s.dht_get_item(Vectors.bytes2byte_vector(bArr), Vectors.bytes2byte_vector(bArr2));
    }

    public Sha1Hash dhtPutItem(Entry entry) {
        return new Sha1Hash(this.f2824s.dht_put_item(entry.swig()));
    }

    public void dhtPutItem(byte[] bArr, byte[] bArr2, Entry entry, byte[] bArr3) {
        this.f2824s.dht_put_item(Vectors.bytes2byte_vector(bArr), Vectors.bytes2byte_vector(bArr2), entry.swig(), Vectors.bytes2byte_vector(bArr3));
    }

    public void dhtGetPeers(Sha1Hash sha1Hash) {
        this.f2824s.dht_get_peers(sha1Hash.swig());
    }

    public void dhtAnnounce(Sha1Hash sha1Hash, int i, int i2) {
        this.f2824s.dht_announce(sha1Hash.swig(), i, i2);
    }

    public void dhtAnnounce(Sha1Hash sha1Hash) {
        this.f2824s.dht_announce(sha1Hash.swig());
    }

    public void dhtDirectRequest(UdpEndpoint udpEndpoint, Entry entry, long j) {
        this.f2824s.dht_direct_request(udpEndpoint.swig(), entry.swig(), j);
    }

    public void dhtDirectRequest(UdpEndpoint udpEndpoint, Entry entry) {
        this.f2824s.dht_direct_request(udpEndpoint.swig(), entry.swig());
    }

    public int getListenPort() {
        return this.f2824s.listen_port();
    }

    public int getSslListenPort() {
        return this.f2824s.ssl_listen_port();
    }

    public boolean isListening() {
        return this.f2824s.is_listening();
    }

    public void addExtension(Plugin plugin) {
        SwigPlugin swigPlugin = new SwigPlugin(plugin);
        this.f2824s.add_extension(swigPlugin);
        swigPlugin.swigReleaseOwnership();
    }
}
