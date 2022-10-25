package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.add_piece_flags_t;
import com.frostwire.jlibtorrent.swig.announce_entry_vector;
import com.frostwire.jlibtorrent.swig.deadline_flags_t;
import com.frostwire.jlibtorrent.swig.int64_vector;
import com.frostwire.jlibtorrent.swig.int_vector;
import com.frostwire.jlibtorrent.swig.libtorrent;
import com.frostwire.jlibtorrent.swig.partial_piece_info_vector;
import com.frostwire.jlibtorrent.swig.peer_info_vector;
import com.frostwire.jlibtorrent.swig.reannounce_flags_t;
import com.frostwire.jlibtorrent.swig.resume_data_flags_t;
import com.frostwire.jlibtorrent.swig.status_flags_t;
import com.frostwire.jlibtorrent.swig.torrent_flags_t;
import com.frostwire.jlibtorrent.swig.torrent_handle;
import com.frostwire.jlibtorrent.swig.torrent_info;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class TorrentHandle {
    private static final long REQUEST_STATUS_RESOLUTION_MILLIS = 500;
    private TorrentStatus lastStatus;
    private long lastStatusRequestTime;

    /* renamed from: th */
    private final torrent_handle f2830th;
    private static final status_flags_t STATUS_FLAGS_ZERO = new status_flags_t();
    public static final add_piece_flags_t OVERWRITE_EXISTING = torrent_handle.overwrite_existing;
    public static final status_flags_t QUERY_DISTRIBUTED_COPIES = torrent_handle.query_distributed_copies;
    public static final status_flags_t QUERY_ACCURATE_DOWNLOAD_COUNTERS = torrent_handle.query_accurate_download_counters;
    public static final status_flags_t QUERY_LAST_SEEN_COMPLETE = torrent_handle.query_last_seen_complete;
    public static final status_flags_t QUERY_PIECES = torrent_handle.query_pieces;
    public static final status_flags_t QUERY_VERIFIED_PIECES = torrent_handle.query_verified_pieces;
    public static final status_flags_t QUERY_TORRENT_FILE = torrent_handle.query_torrent_file;
    public static final status_flags_t QUERY_NAME = torrent_handle.query_name;
    public static final status_flags_t QUERY_SAVE_PATH = torrent_handle.query_save_path;
    public static final resume_data_flags_t FLUSH_DISK_CACHE = torrent_handle.flush_disk_cache;
    public static final resume_data_flags_t SAVE_INFO_DICT = torrent_handle.save_info_dict;
    public static final resume_data_flags_t ONLY_IF_MODIFIED = torrent_handle.only_if_modified;
    public static final reannounce_flags_t IGNORE_MIN_INTERVAL = torrent_handle.ignore_min_interval;
    public static final deadline_flags_t ALERT_WHEN_AVAILABLE = torrent_handle.alert_when_available;

    public TorrentHandle(torrent_handle torrent_handleVar) {
        this.f2830th = torrent_handleVar;
    }

    public torrent_handle swig() {
        return this.f2830th;
    }

    public void addPiece(int i, byte[] bArr, add_piece_flags_t add_piece_flags_tVar) {
        this.f2830th.add_piece_bytes(i, Vectors.bytes2byte_vector(bArr), add_piece_flags_tVar);
    }

    public void addPiece(int i, byte[] bArr) {
        this.f2830th.add_piece_bytes(i, Vectors.bytes2byte_vector(bArr));
    }

    public void readPiece(int i) {
        this.f2830th.read_piece(i);
    }

    public boolean havePiece(int i) {
        return this.f2830th.have_piece(i);
    }

    public List<PeerInfo> peerInfo() {
        if (!this.f2830th.is_valid()) {
            return new ArrayList();
        }
        peer_info_vector peer_info_vectorVar = new peer_info_vector();
        this.f2830th.get_peer_info(peer_info_vectorVar);
        int size = (int) peer_info_vectorVar.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new PeerInfo(peer_info_vectorVar.get(i)));
        }
        return arrayList;
    }

    public TorrentInfo torrentFile() {
        torrent_info torrent_infoVar;
        if (this.f2830th.is_valid() && (torrent_infoVar = this.f2830th.torrent_file_ptr()) != null) {
            return new TorrentInfo(torrent_infoVar);
        }
        return null;
    }

    public TorrentStatus status(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis - this.lastStatusRequestTime >= 500) {
            this.lastStatusRequestTime = currentTimeMillis;
            this.lastStatus = new TorrentStatus(this.f2830th.status(STATUS_FLAGS_ZERO));
        }
        return this.lastStatus;
    }

    public TorrentStatus status() {
        return status(false);
    }

    public TorrentStatus status(status_flags_t status_flags_tVar) {
        return new TorrentStatus(this.f2830th.status(status_flags_tVar));
    }

    public ArrayList<PartialPieceInfo> getDownloadQueue() {
        partial_piece_info_vector partial_piece_info_vectorVar = new partial_piece_info_vector();
        this.f2830th.get_download_queue(partial_piece_info_vectorVar);
        int size = (int) partial_piece_info_vectorVar.size();
        ArrayList<PartialPieceInfo> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new PartialPieceInfo(partial_piece_info_vectorVar.get(i)));
        }
        return arrayList;
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(this.f2830th.info_hash());
    }

    public void pause() {
        this.f2830th.pause();
    }

    public void resume() {
        this.f2830th.resume();
    }

    public torrent_flags_t flags() {
        return this.f2830th.flags();
    }

    public void setFlags(torrent_flags_t torrent_flags_tVar, torrent_flags_t torrent_flags_tVar2) {
        this.f2830th.set_flags(torrent_flags_tVar, torrent_flags_tVar2);
    }

    public void setFlags(torrent_flags_t torrent_flags_tVar) {
        this.f2830th.set_flags(torrent_flags_tVar);
    }

    public void unsetFlags(torrent_flags_t torrent_flags_tVar) {
        this.f2830th.unset_flags(torrent_flags_tVar);
    }

    public void flushCache() {
        this.f2830th.flush_cache();
    }

    public boolean needSaveResumeData() {
        return this.f2830th.need_save_resume_data();
    }

    public int queuePosition() {
        return this.f2830th.queue_position2();
    }

    public void queuePositionUp() {
        this.f2830th.queue_position_up();
    }

    public void queuePositionDown() {
        this.f2830th.queue_position_down();
    }

    public void queuePositionTop() {
        this.f2830th.queue_position_top();
    }

    public void queuePositionBottom() {
        this.f2830th.queue_position_bottom();
    }

    public void queuePositionSet(int i) {
        this.f2830th.queue_position_set2(i);
    }

    public void setSslCertificate(String str, String str2, String str3) {
        this.f2830th.set_ssl_certificate(str, str2, str3);
    }

    public void setSslCertificate(String str, String str2, String str3, String str4) {
        this.f2830th.set_ssl_certificate(str, str2, str3, str4);
    }

    void setSslCertificateBuffer(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f2830th.set_ssl_certificate_buffer2(Vectors.bytes2byte_vector(bArr), Vectors.bytes2byte_vector(bArr2), Vectors.bytes2byte_vector(bArr3));
    }

    public void saveResumeData(resume_data_flags_t resume_data_flags_tVar) {
        this.f2830th.save_resume_data(resume_data_flags_tVar);
    }

    public void saveResumeData() {
        this.f2830th.save_resume_data();
    }

    public boolean isValid() {
        return this.f2830th.is_valid();
    }

    public String makeMagnetUri() {
        if (this.f2830th.is_valid()) {
            return libtorrent.make_magnet_uri(this.f2830th);
        }
        return null;
    }

    public int getUploadLimit() {
        return this.f2830th.upload_limit();
    }

    public void setUploadLimit(int i) {
        this.f2830th.set_upload_limit(i);
    }

    public int getDownloadLimit() {
        return this.f2830th.download_limit();
    }

    public void setDownloadLimit(int i) {
        this.f2830th.set_download_limit(i);
    }

    public void forceRecheck() {
        this.f2830th.force_recheck();
    }

    public void forceReannounce(int i, int i2, reannounce_flags_t reannounce_flags_tVar) {
        this.f2830th.force_reannounce(i, i2, reannounce_flags_tVar);
    }

    public void forceReannounce(int i, int i2) {
        this.f2830th.force_reannounce(i, i2);
    }

    public void forceReannounce(int i) {
        this.f2830th.force_reannounce(i);
    }

    public void forceReannounce() {
        this.f2830th.force_reannounce();
    }

    public void forceDHTAnnounce() {
        this.f2830th.force_dht_announce();
    }

    public List<AnnounceEntry> trackers() {
        if (!this.f2830th.is_valid()) {
            return Collections.emptyList();
        }
        return TorrentInfo.trackers(this.f2830th.trackers());
    }

    public void scrapeTracker() {
        this.f2830th.scrape_tracker();
    }

    public void replaceTrackers(List<AnnounceEntry> list) {
        announce_entry_vector announce_entry_vectorVar = new announce_entry_vector();
        for (AnnounceEntry announceEntry : list) {
            announce_entry_vectorVar.push_back(announceEntry.swig());
        }
        this.f2830th.replace_trackers(announce_entry_vectorVar);
    }

    public void addTracker(AnnounceEntry announceEntry) {
        this.f2830th.add_tracker(announceEntry.swig());
    }

    public void addUrlSeed(String str) {
        this.f2830th.add_url_seed(str);
    }

    public void removeUrlSeed(String str) {
        this.f2830th.remove_url_seed(str);
    }

    public List<String> urlSeeds() {
        return Vectors.string_vector2list(this.f2830th.get_url_seeds());
    }

    public void addHttpSeed(String str) {
        this.f2830th.add_url_seed(str);
    }

    public void removeHttpSeed(String str) {
        this.f2830th.remove_http_seed(str);
    }

    public List<String> httpSeeds() {
        return Vectors.string_vector2list(this.f2830th.get_http_seeds());
    }

    public int[] pieceAvailability() {
        int_vector int_vectorVar = new int_vector();
        this.f2830th.piece_availability(int_vectorVar);
        return Vectors.int_vector2ints(int_vectorVar);
    }

    public void piecePriority(int i, Priority priority) {
        this.f2830th.piece_priority2(i, priority.swig());
    }

    public Priority piecePriority(int i) {
        return Priority.fromSwig(this.f2830th.piece_priority2(i));
    }

    public void prioritizePieces(Priority[] priorityArr) {
        this.f2830th.prioritize_pieces2(Priority.array2vector(priorityArr));
    }

    public Priority[] piecePriorities() {
        int_vector int_vectorVar = this.f2830th.get_piece_priorities2();
        int size = (int) int_vectorVar.size();
        Priority[] priorityArr = new Priority[size];
        for (int i = 0; i < size; i++) {
            priorityArr[i] = Priority.fromSwig(int_vectorVar.get(i));
        }
        return priorityArr;
    }

    public void filePriority(int i, Priority priority) {
        this.f2830th.file_priority2(i, priority.swig());
    }

    public Priority filePriority(int i) {
        return Priority.fromSwig(this.f2830th.file_priority2(i));
    }

    public void prioritizeFiles(Priority[] priorityArr) {
        this.f2830th.prioritize_files2(Priority.array2vector(priorityArr));
    }

    public Priority[] filePriorities() {
        int_vector int_vectorVar = this.f2830th.get_file_priorities2();
        int size = (int) int_vectorVar.size();
        Priority[] priorityArr = new Priority[size];
        for (int i = 0; i < size; i++) {
            priorityArr[i] = Priority.fromSwig(int_vectorVar.get(i));
        }
        return priorityArr;
    }

    public void setPieceDeadline(int i, int i2) {
        this.f2830th.set_piece_deadline(i, i2);
    }

    public void setPieceDeadline(int i, int i2, deadline_flags_t deadline_flags_tVar) {
        this.f2830th.set_piece_deadline(i, i2, deadline_flags_tVar);
    }

    public void resetPieceDeadline(int i) {
        this.f2830th.reset_piece_deadline(i);
    }

    public void clearPieceDeadlines() {
        this.f2830th.clear_piece_deadlines();
    }

    public long[] fileProgress(FileProgressFlags fileProgressFlags) {
        int64_vector int64_vectorVar = new int64_vector();
        this.f2830th.file_progress(int64_vectorVar, fileProgressFlags.swig());
        return Vectors.int64_vector2longs(int64_vectorVar);
    }

    public long[] fileProgress() {
        int64_vector int64_vectorVar = new int64_vector();
        this.f2830th.file_progress(int64_vectorVar);
        return Vectors.int64_vector2longs(int64_vectorVar);
    }

    public String savePath() {
        return this.f2830th.status(torrent_handle.query_save_path).getSave_path();
    }

    public String name() {
        return this.f2830th.status(torrent_handle.query_name).getName();
    }

    public void moveStorage(String str, MoveFlags moveFlags) {
        this.f2830th.move_storage(str, moveFlags.swig());
    }

    public void moveStorage(String str) {
        this.f2830th.move_storage(str);
    }

    public void renameFile(int i, String str) {
        this.f2830th.rename_file(i, str);
    }

    /* loaded from: classes2.dex */
    public enum FileProgressFlags {
        PIECE_GRANULARITY(torrent_handle.file_progress_flags_t.piece_granularity.swigValue());
        
        private final int swigValue;

        FileProgressFlags(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }
    }
}
