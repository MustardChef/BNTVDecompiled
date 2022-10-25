package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.add_torrent_params;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.int_vector;
import com.frostwire.jlibtorrent.swig.storage_mode_t;
import com.frostwire.jlibtorrent.swig.string_int_pair;
import com.frostwire.jlibtorrent.swig.string_int_pair_vector;
import com.frostwire.jlibtorrent.swig.string_vector;
import com.frostwire.jlibtorrent.swig.tcp_endpoint_vector;
import com.frostwire.jlibtorrent.swig.torrent_flags_t;
import com.frostwire.jlibtorrent.swig.torrent_info;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AddTorrentParams {

    /* renamed from: p */
    private final add_torrent_params f2803p;

    public AddTorrentParams(add_torrent_params add_torrent_paramsVar) {
        this.f2803p = add_torrent_paramsVar;
    }

    public AddTorrentParams() {
        this(add_torrent_params.create_instance());
    }

    public add_torrent_params swig() {
        return this.f2803p;
    }

    public int version() {
        return this.f2803p.getVersion();
    }

    public TorrentInfo torrentInfo() {
        torrent_info ti_ptr = this.f2803p.ti_ptr();
        if (ti_ptr == null || !ti_ptr.is_valid()) {
            return null;
        }
        return new TorrentInfo(ti_ptr);
    }

    public void torrentInfo(TorrentInfo torrentInfo) {
        this.f2803p.set_ti(torrentInfo.swig());
    }

    public ArrayList<String> trackers() {
        string_vector string_vectorVar = this.f2803p.get_trackers();
        int size = (int) string_vectorVar.size();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(string_vectorVar.get(i));
        }
        return arrayList;
    }

    public void trackers(List<String> list) {
        string_vector string_vectorVar = new string_vector();
        for (String str : list) {
            string_vectorVar.push_back(str);
        }
        this.f2803p.set_trackers(string_vectorVar);
    }

    public ArrayList<Integer> trackerTiers() {
        int_vector int_vectorVar = this.f2803p.get_tracker_tiers();
        int size = (int) int_vectorVar.size();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(Integer.valueOf(int_vectorVar.get(i)));
        }
        return arrayList;
    }

    public void trackerTiers(List<Integer> list) {
        int_vector int_vectorVar = new int_vector();
        for (Integer num : list) {
            int_vectorVar.push_back(num.intValue());
        }
        this.f2803p.set_tracker_tiers(int_vectorVar);
    }

    public ArrayList<Pair<String, Integer>> dhtNodes() {
        string_int_pair_vector string_int_pair_vectorVar = this.f2803p.get_dht_nodes();
        int size = (int) string_int_pair_vectorVar.size();
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            string_int_pair string_int_pairVar = string_int_pair_vectorVar.get(i);
            arrayList.add(new Pair<>(string_int_pairVar.getFirst(), Integer.valueOf(string_int_pairVar.getSecond())));
        }
        return arrayList;
    }

    public void dhtNodes(List<Pair<String, Integer>> list) {
        string_int_pair_vector string_int_pair_vectorVar = new string_int_pair_vector();
        for (Pair<String, Integer> pair : list) {
            string_int_pair_vectorVar.push_back(pair.to_string_int_pair());
        }
        this.f2803p.set_dht_nodes(string_int_pair_vectorVar);
    }

    public String name() {
        return this.f2803p.getName();
    }

    public void name(String str) {
        this.f2803p.setName(str);
    }

    public String savePath() {
        return this.f2803p.getSave_path();
    }

    public void savePath(String str) {
        this.f2803p.setSave_path(str);
    }

    public StorageMode storageMode() {
        return StorageMode.fromSwig(this.f2803p.getStorage_mode().swigValue());
    }

    public void storageMode(StorageMode storageMode) {
        this.f2803p.setStorage_mode(storage_mode_t.swigToEnum(storageMode.swig()));
    }

    public String trackerId() {
        return this.f2803p.getTrackerid();
    }

    public void trackerId(String str) {
        this.f2803p.setTrackerid(str);
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(this.f2803p.getInfo_hash());
    }

    public void infoHash(Sha1Hash sha1Hash) {
        this.f2803p.setInfo_hash(sha1Hash.swig());
    }

    public int maxUploads() {
        return this.f2803p.getMax_uploads();
    }

    public void maxUploads(int i) {
        this.f2803p.setMax_uploads(i);
    }

    public int maxConnections() {
        return this.f2803p.getMax_connections();
    }

    public void maxConnections(int i) {
        this.f2803p.setMax_connections(i);
    }

    public int uploadLimit() {
        return this.f2803p.getUpload_limit();
    }

    public void uploadLimit(int i) {
        this.f2803p.setUpload_limit(i);
    }

    public int downloadLimit() {
        return this.f2803p.getDownload_limit();
    }

    public void downloadLimit(int i) {
        this.f2803p.setDownload_limit(i);
    }

    public torrent_flags_t flags() {
        return this.f2803p.getFlags();
    }

    public void flags(torrent_flags_t torrent_flags_tVar) {
        this.f2803p.setFlags(torrent_flags_tVar);
    }

    public ArrayList<String> urlSeeds() {
        string_vector string_vectorVar = this.f2803p.get_url_seeds();
        int size = (int) string_vectorVar.size();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(string_vectorVar.get(i));
        }
        return arrayList;
    }

    public void urlSeeds(List<String> list) {
        string_vector string_vectorVar = new string_vector();
        for (String str : list) {
            string_vectorVar.push_back(str);
        }
        this.f2803p.set_url_seeds(string_vectorVar);
    }

    public void filePriorities(Priority[] priorityArr) {
        this.f2803p.set_file_priorities2(Priority.array2byte_vector(priorityArr));
    }

    public void piecePriorities(Priority[] priorityArr) {
        this.f2803p.set_piece_priorities2(Priority.array2byte_vector(priorityArr));
    }

    public ArrayList<TcpEndpoint> peers() {
        tcp_endpoint_vector tcp_endpoint_vectorVar = this.f2803p.get_peers();
        int size = (int) tcp_endpoint_vectorVar.size();
        ArrayList<TcpEndpoint> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(new TcpEndpoint(tcp_endpoint_vectorVar.get(i)));
        }
        return arrayList;
    }

    public void peers(List<TcpEndpoint> list) {
        tcp_endpoint_vector tcp_endpoint_vectorVar = new tcp_endpoint_vector();
        for (TcpEndpoint tcpEndpoint : list) {
            tcp_endpoint_vectorVar.push_back(tcpEndpoint.swig());
        }
        this.f2803p.set_peers(tcp_endpoint_vectorVar);
    }

    public ArrayList<TcpEndpoint> bannedPeers() {
        tcp_endpoint_vector tcp_endpoint_vectorVar = this.f2803p.get_banned_peers();
        int size = (int) tcp_endpoint_vectorVar.size();
        ArrayList<TcpEndpoint> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(new TcpEndpoint(tcp_endpoint_vectorVar.get(i)));
        }
        return arrayList;
    }

    public void bannedPeers(List<TcpEndpoint> list) {
        tcp_endpoint_vector tcp_endpoint_vectorVar = new tcp_endpoint_vector();
        for (TcpEndpoint tcpEndpoint : list) {
            tcp_endpoint_vectorVar.push_back(tcpEndpoint.swig());
        }
        this.f2803p.set_banned_peers(tcp_endpoint_vectorVar);
    }

    public static AddTorrentParams createInstance() {
        return new AddTorrentParams(add_torrent_params.create_instance());
    }

    public static AddTorrentParams createInstanceDisabledStorage() {
        return new AddTorrentParams(add_torrent_params.create_instance_disabled_storage());
    }

    public static AddTorrentParams createInstanceZeroStorage() {
        return new AddTorrentParams(add_torrent_params.create_instance_zero_storage());
    }

    public static AddTorrentParams parseMagnetUri(String str) {
        error_code error_codeVar = new error_code();
        add_torrent_params parse_magnet_uri = add_torrent_params.parse_magnet_uri(str, error_codeVar);
        if (error_codeVar.value() != 0) {
            throw new IllegalArgumentException("Invalid magnet uri: " + error_codeVar.message());
        }
        return new AddTorrentParams(parse_magnet_uri);
    }
}
