package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.announce_entry_vector;
import com.frostwire.jlibtorrent.swig.bdecode_node;
import com.frostwire.jlibtorrent.swig.byte_vector;
import com.frostwire.jlibtorrent.swig.create_torrent;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.libtorrent;
import com.frostwire.jlibtorrent.swig.libtorrent_jni;
import com.frostwire.jlibtorrent.swig.sha1_hash_vector;
import com.frostwire.jlibtorrent.swig.string_int_pair;
import com.frostwire.jlibtorrent.swig.string_int_pair_vector;
import com.frostwire.jlibtorrent.swig.string_string_pair_vector;
import com.frostwire.jlibtorrent.swig.string_vector;
import com.frostwire.jlibtorrent.swig.torrent_info;
import com.frostwire.jlibtorrent.swig.web_seed_entry_vector;
import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class TorrentInfo {

    /* renamed from: ti */
    private final torrent_info f2831ti;

    public TorrentInfo(torrent_info torrent_infoVar) {
        this.f2831ti = torrent_infoVar;
    }

    public TorrentInfo(File file) {
        this(bdecode0(file));
    }

    public TorrentInfo(byte[] bArr) {
        this(bdecode0(bArr));
    }

    public TorrentInfo(MappedByteBuffer mappedByteBuffer) {
        try {
            long directBufferAddress = libtorrent_jni.directBufferAddress(mappedByteBuffer);
            long directBufferCapacity = libtorrent_jni.directBufferCapacity(mappedByteBuffer);
            error_code error_codeVar = new error_code();
            this.f2831ti = new torrent_info(directBufferAddress, (int) directBufferCapacity, error_codeVar);
            if (error_codeVar.value() == 0) {
                return;
            }
            throw new IllegalArgumentException("Can't decode data: " + error_codeVar.message());
        } catch (Throwable th) {
            throw new IllegalArgumentException("Can't decode data mapped buffer: " + th.getMessage(), th);
        }
    }

    public torrent_info swig() {
        return this.f2831ti;
    }

    public FileStorage files() {
        return new FileStorage(this.f2831ti.files(), this.f2831ti);
    }

    public FileStorage origFiles() {
        return new FileStorage(this.f2831ti.orig_files(), this.f2831ti);
    }

    public void renameFile(int i, String str) {
        this.f2831ti.rename_file(i, str);
    }

    public void remapFiles(FileStorage fileStorage) {
        this.f2831ti.remap_files(fileStorage.swig());
    }

    public void addTracker(String str) {
        this.f2831ti.add_tracker(str);
    }

    public void addTracker(String str, int i) {
        this.f2831ti.add_tracker(str, i);
    }

    public ArrayList<AnnounceEntry> trackers() {
        return trackers(this.f2831ti.trackers());
    }

    public ArrayList<Sha1Hash> similarTorrents() {
        return Sha1Hash.convert(this.f2831ti.similar_torrents());
    }

    public ArrayList<String> collections() {
        string_vector collections = this.f2831ti.collections();
        int size = (int) collections.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(collections.get(i));
        }
        return arrayList;
    }

    public void clearTrackers() {
        this.f2831ti.trackers().clear();
    }

    public void addUrlSeed(String str) {
        this.f2831ti.add_url_seed(str);
    }

    public void addUrlSeed(String str, String str2) {
        this.f2831ti.add_url_seed(str, str2);
    }

    public void addUrlSeed(String str, String str2, List<Pair<String, String>> list) {
        string_string_pair_vector string_string_pair_vectorVar = new string_string_pair_vector();
        for (Pair<String, String> pair : list) {
            string_string_pair_vectorVar.push_back(pair.to_string_string_pair());
        }
        this.f2831ti.add_url_seed(str, str2, string_string_pair_vectorVar);
    }

    public void addHttpSeed(String str) {
        this.f2831ti.add_url_seed(str);
    }

    public void addHttpSeed(String str, String str2) {
        this.f2831ti.add_url_seed(str, str2);
    }

    public void addHttpSeed(String str, String str2, List<Pair<String, String>> list) {
        string_string_pair_vector string_string_pair_vectorVar = new string_string_pair_vector();
        for (Pair<String, String> pair : list) {
            string_string_pair_vectorVar.push_back(pair.to_string_string_pair());
        }
        this.f2831ti.add_url_seed(str, str2, string_string_pair_vectorVar);
    }

    public ArrayList<WebSeedEntry> webSeeds() {
        web_seed_entry_vector web_seeds = this.f2831ti.web_seeds();
        int size = (int) web_seeds.size();
        ArrayList<WebSeedEntry> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new WebSeedEntry(web_seeds.get(i)));
        }
        return arrayList;
    }

    public void setWebSeeds(List<WebSeedEntry> list) {
        web_seed_entry_vector web_seed_entry_vectorVar = new web_seed_entry_vector();
        for (WebSeedEntry webSeedEntry : list) {
            web_seed_entry_vectorVar.push_back(webSeedEntry.swig());
        }
        this.f2831ti.set_web_seeds(web_seed_entry_vectorVar);
    }

    public long totalSize() {
        return this.f2831ti.total_size();
    }

    public int pieceLength() {
        return this.f2831ti.piece_length();
    }

    public int numPieces() {
        return this.f2831ti.num_pieces();
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(this.f2831ti.info_hash());
    }

    public int numFiles() {
        return this.f2831ti.num_files();
    }

    public ArrayList<FileSlice> mapBlock(int i, long j, int i2) {
        return FileStorage.mapBlock(this.f2831ti.map_block(i, j, i2));
    }

    public PeerRequest mapFile(int i, long j, int i2) {
        return new PeerRequest(this.f2831ti.map_file(i, j, i2));
    }

    byte[] sslCert() {
        return Vectors.byte_vector2bytes(this.f2831ti.ssl_cert().to_bytes());
    }

    public boolean isValid() {
        return this.f2831ti.is_valid();
    }

    public boolean isPrivate() {
        return this.f2831ti.priv();
    }

    public boolean isI2p() {
        return this.f2831ti.is_i2p();
    }

    public int pieceSize(int i) {
        return this.f2831ti.piece_size(i);
    }

    public Sha1Hash hashForPiece(int i) {
        return new Sha1Hash(this.f2831ti.hash_for_piece(i));
    }

    public boolean isLoaded() {
        return this.f2831ti.is_loaded();
    }

    public ArrayList<Sha1Hash> merkleTree() {
        return Sha1Hash.convert(this.f2831ti.merkle_tree());
    }

    public void merkleTree(List<Sha1Hash> list) {
        sha1_hash_vector sha1_hash_vectorVar = new sha1_hash_vector();
        for (Sha1Hash sha1Hash : list) {
            sha1_hash_vectorVar.push_back(sha1Hash.swig());
        }
        this.f2831ti.set_merkle_tree(sha1_hash_vectorVar);
    }

    public String name() {
        return this.f2831ti.name();
    }

    public long creationDate() {
        return this.f2831ti.creation_date();
    }

    public String creator() {
        return this.f2831ti.creator();
    }

    public String comment() {
        return this.f2831ti.comment();
    }

    public ArrayList<Pair<String, Integer>> nodes() {
        string_int_pair_vector nodes = this.f2831ti.nodes();
        int size = (int) nodes.size();
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            string_int_pair string_int_pairVar = nodes.get(i);
            arrayList.add(new Pair<>(string_int_pairVar.getFirst(), Integer.valueOf(string_int_pairVar.getSecond())));
        }
        return arrayList;
    }

    public void addNode(String str, int i) {
        this.f2831ti.add_node(new string_int_pair(str, i));
    }

    public bdecode_node info(String str) {
        return this.f2831ti.info(str);
    }

    public boolean isMerkleTorrent() {
        return this.f2831ti.is_merkle_torrent();
    }

    public String makeMagnetUri() {
        if (this.f2831ti.is_valid()) {
            return libtorrent.make_magnet_uri(this.f2831ti);
        }
        return null;
    }

    public Entry toEntry() {
        return new Entry(new create_torrent(this.f2831ti).generate());
    }

    public byte[] bencode() {
        return toEntry().bencode();
    }

    public static TorrentInfo bdecode(byte[] bArr) {
        return new TorrentInfo(bdecode0(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<AnnounceEntry> trackers(announce_entry_vector announce_entry_vectorVar) {
        int size = (int) announce_entry_vectorVar.size();
        ArrayList<AnnounceEntry> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new AnnounceEntry(announce_entry_vectorVar.get(i)));
        }
        return arrayList;
    }

    private static torrent_info bdecode0(File file) {
        try {
            return bdecode0(Files.bytes(file));
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't decode data from file: " + file, e);
        }
    }

    private static torrent_info bdecode0(byte[] bArr) {
        byte_vector bytes2byte_vector = Vectors.bytes2byte_vector(bArr);
        bdecode_node bdecode_nodeVar = new bdecode_node();
        error_code error_codeVar = new error_code();
        if (bdecode_node.bdecode(bytes2byte_vector, bdecode_nodeVar, error_codeVar) == 0) {
            error_codeVar.clear();
            torrent_info torrent_infoVar = new torrent_info(bdecode_nodeVar, error_codeVar);
            bytes2byte_vector.clear();
            if (error_codeVar.value() == 0) {
                return torrent_infoVar;
            }
            throw new IllegalArgumentException("Can't decode data: " + error_codeVar.message());
        }
        throw new IllegalArgumentException("Can't decode data: " + error_codeVar.message());
    }
}
