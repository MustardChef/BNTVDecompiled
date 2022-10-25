package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.add_files_listener;
import com.frostwire.jlibtorrent.swig.create_flags_t;
import com.frostwire.jlibtorrent.swig.create_torrent;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.file_storage;
import com.frostwire.jlibtorrent.swig.libtorrent;
import com.frostwire.jlibtorrent.swig.set_piece_hashes_listener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public final class TorrentBuilder {
    private String comment;
    private String creator;
    private Listener listener;
    private File path;
    private boolean priv;
    public static final create_flags_t OPTIMIZE_ALIGNMENT = create_torrent.optimize_alignment;
    public static final create_flags_t MERKLE = create_torrent.merkle;
    public static final create_flags_t MODIFICATION_TIME = create_torrent.modification_time;
    public static final create_flags_t SYMLINKS = create_torrent.symlinks;
    public static final create_flags_t MUTABLE_TORRENT_SUPPORT = create_torrent.mutable_torrent_support;
    private int pieceSize = 0;
    private int padFileLimit = -1;
    private create_flags_t flags = OPTIMIZE_ALIGNMENT;
    private int alignment = -1;
    private List<String> urlSeeds = new LinkedList();
    private List<String> httpSeeds = new LinkedList();
    private List<Pair<String, Integer>> nodes = new LinkedList();
    private List<Pair<String, Integer>> trackers = new LinkedList();
    private List<Sha1Hash> similarTorrents = new LinkedList();
    private List<String> collections = new LinkedList();

    /* loaded from: classes2.dex */
    public interface Listener {
        boolean accept(String str);

        void progress(int i, int i2);
    }

    public File path() {
        return this.path;
    }

    public TorrentBuilder path(File file) {
        this.path = file;
        return this;
    }

    public int pieceSize() {
        return this.pieceSize;
    }

    public TorrentBuilder pieceSize(int i) {
        this.pieceSize = i;
        return this;
    }

    public int padFileLimit() {
        return this.padFileLimit;
    }

    public TorrentBuilder padFileLimit(int i) {
        this.padFileLimit = i;
        return this;
    }

    public create_flags_t flags() {
        return this.flags;
    }

    public TorrentBuilder flags(create_flags_t create_flags_tVar) {
        this.flags = create_flags_tVar;
        return this;
    }

    public int alignment() {
        return this.alignment;
    }

    public TorrentBuilder alignment(int i) {
        this.alignment = i;
        return this;
    }

    public String comment() {
        return this.comment;
    }

    public TorrentBuilder comment(String str) {
        this.comment = str;
        return this;
    }

    public String creator() {
        return this.creator;
    }

    public TorrentBuilder creator(String str) {
        this.creator = str;
        return this;
    }

    public List<String> urlSeeds() {
        return this.urlSeeds;
    }

    public TorrentBuilder addUrlSeeds(List<String> list) {
        if (list != null) {
            this.urlSeeds.addAll(list);
        }
        return this;
    }

    public TorrentBuilder addUrlSeed(String str) {
        if (str != null) {
            this.urlSeeds.add(str);
        }
        return this;
    }

    public List<String> httpSeeds() {
        return this.httpSeeds;
    }

    public TorrentBuilder addHttpSeeds(List<String> list) {
        if (list != null) {
            this.httpSeeds.addAll(list);
        }
        return this;
    }

    public TorrentBuilder addHttpSeed(String str) {
        if (str != null) {
            this.httpSeeds.add(str);
        }
        return this;
    }

    public List<Pair<String, Integer>> nodes() {
        return this.nodes;
    }

    public TorrentBuilder addNodes(List<Pair<String, Integer>> list) {
        if (list != null) {
            this.nodes.addAll(list);
        }
        return this;
    }

    public TorrentBuilder addNode(Pair<String, Integer> pair) {
        if (pair != null) {
            this.nodes.add(pair);
        }
        return this;
    }

    public List<Pair<String, Integer>> trackers() {
        return this.trackers;
    }

    public TorrentBuilder addTrackers(List<Pair<String, Integer>> list) {
        if (list != null) {
            this.trackers.addAll(list);
        }
        return this;
    }

    public TorrentBuilder addTracker(Pair<String, Integer> pair) {
        if (pair != null) {
            this.trackers.add(pair);
        }
        return this;
    }

    public TorrentBuilder addTracker(String str, int i) {
        return addTracker(new Pair<>(str, Integer.valueOf(i)));
    }

    public TorrentBuilder addTracker(String str) {
        return addTracker(str, 0);
    }

    public boolean isPrivate() {
        return this.priv;
    }

    public TorrentBuilder setPrivate(boolean z) {
        this.priv = z;
        return this;
    }

    public List<Sha1Hash> similarTorrents() {
        return this.similarTorrents;
    }

    public TorrentBuilder addSimilarTorrents(List<Sha1Hash> list) {
        if (list != null) {
            this.similarTorrents.addAll(list);
        }
        return this;
    }

    public TorrentBuilder addSimilarTorrent(Sha1Hash sha1Hash) {
        if (sha1Hash != null) {
            this.similarTorrents.add(sha1Hash);
        }
        return this;
    }

    public List<String> collections() {
        return this.collections;
    }

    public TorrentBuilder addCollections(List<String> list) {
        if (list != null) {
            this.collections.addAll(list);
        }
        return this;
    }

    public TorrentBuilder addCollection(String str) {
        if (str != null) {
            this.collections.add(str);
        }
        return this;
    }

    public Listener listener() {
        return this.listener;
    }

    public TorrentBuilder listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    public Result generate() throws IOException {
        File file = this.path;
        if (file == null) {
            throw new IOException("path can't be null");
        }
        File absoluteFile = file.getAbsoluteFile();
        file_storage file_storageVar = new file_storage();
        libtorrent.add_files_ex(file_storageVar, absoluteFile.getPath(), new add_files_listener() { // from class: com.frostwire.jlibtorrent.TorrentBuilder.1
            @Override // com.frostwire.jlibtorrent.swig.add_files_listener
            public boolean pred(String str) {
                if (TorrentBuilder.this.listener != null) {
                    return TorrentBuilder.this.listener.accept(str);
                }
                return true;
            }
        }, this.flags);
        if (file_storageVar.total_size() == 0) {
            throw new IOException("content total size can't be 0");
        }
        create_torrent create_torrentVar = new create_torrent(file_storageVar, this.pieceSize, this.padFileLimit, this.flags, this.alignment);
        final int num_pieces = create_torrentVar.num_pieces();
        set_piece_hashes_listener set_piece_hashes_listenerVar = new set_piece_hashes_listener() { // from class: com.frostwire.jlibtorrent.TorrentBuilder.2
            @Override // com.frostwire.jlibtorrent.swig.set_piece_hashes_listener
            public void progress(int i) {
                if (TorrentBuilder.this.listener != null) {
                    TorrentBuilder.this.listener.progress(i, num_pieces);
                }
            }
        };
        File parentFile = absoluteFile.getParentFile();
        if (parentFile == null) {
            throw new IOException("path's parent can't be null");
        }
        error_code error_codeVar = new error_code();
        libtorrent.set_piece_hashes_ex(create_torrentVar, parentFile.getAbsolutePath(), set_piece_hashes_listenerVar, error_codeVar);
        if (error_codeVar.value() != 0) {
            throw new IOException(error_codeVar.message());
        }
        String str = this.comment;
        if (str != null) {
            create_torrentVar.set_comment(str);
        }
        String str2 = this.creator;
        if (str2 != null) {
            create_torrentVar.set_creator(str2);
        }
        for (String str3 : this.urlSeeds) {
            create_torrentVar.add_url_seed(str3);
        }
        for (String str4 : this.httpSeeds) {
            create_torrentVar.add_http_seed(str4);
        }
        for (Pair<String, Integer> pair : this.nodes) {
            create_torrentVar.add_node(pair.to_string_int_pair());
        }
        for (Pair<String, Integer> pair2 : this.trackers) {
            create_torrentVar.add_tracker(pair2.first, pair2.second.intValue());
        }
        boolean z = this.priv;
        if (z) {
            create_torrentVar.set_priv(z);
        }
        if (!this.similarTorrents.isEmpty()) {
            for (Sha1Hash sha1Hash : this.similarTorrents) {
                create_torrentVar.add_similar_torrent(sha1Hash.swig());
            }
        }
        if (!this.collections.isEmpty()) {
            for (String str5 : this.collections) {
                create_torrentVar.add_collection(str5);
            }
        }
        return new Result(create_torrentVar);
    }

    /* loaded from: classes2.dex */
    public static final class Result {
        private final Entry entry;

        /* renamed from: t */
        private final create_torrent f2829t;

        private Result(create_torrent create_torrentVar) {
            this.f2829t = create_torrentVar;
            this.entry = new Entry(create_torrentVar.generate());
        }

        public Entry entry() {
            return this.entry;
        }

        public int numPieces() {
            return this.f2829t.num_pieces();
        }

        public int pieceLength() {
            return this.f2829t.piece_length();
        }

        public int pieceSize(int i) {
            return this.f2829t.piece_size(i);
        }

        public ArrayList<Sha1Hash> merkleTree() {
            return Sha1Hash.convert(this.f2829t.merkle_tree());
        }
    }
}
