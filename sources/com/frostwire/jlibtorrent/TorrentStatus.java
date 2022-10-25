package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.torrent_flags_t;
import com.frostwire.jlibtorrent.swig.torrent_status;

/* loaded from: classes2.dex */
public final class TorrentStatus implements Cloneable {

    /* renamed from: ts */
    private final torrent_status f2833ts;

    private static long time2millis(long j) {
        return j * 1000;
    }

    public TorrentStatus(torrent_status torrent_statusVar) {
        this.f2833ts = torrent_statusVar;
    }

    public torrent_status swig() {
        return this.f2833ts;
    }

    public ErrorCode errorCode() {
        return new ErrorCode(this.f2833ts.getErrc());
    }

    public String name() {
        return this.f2833ts.getName();
    }

    public long nextAnnounce() {
        return this.f2833ts.get_next_announce();
    }

    public String currentTracker() {
        return this.f2833ts.getCurrent_tracker();
    }

    public long totalDownload() {
        return this.f2833ts.getTotal_download();
    }

    public long totalUpload() {
        return this.f2833ts.getTotal_upload();
    }

    public long totalPayloadDownload() {
        return this.f2833ts.getTotal_payload_download();
    }

    public long totalPayloadUpload() {
        return this.f2833ts.getTotal_payload_upload();
    }

    public long totalFailedBytes() {
        return this.f2833ts.getTotal_failed_bytes();
    }

    public long totalRedundantBytes() {
        return this.f2833ts.getTotal_redundant_bytes();
    }

    public PieceIndexBitfield pieces() {
        return new PieceIndexBitfield(this.f2833ts.getPieces(), this.f2833ts);
    }

    public PieceIndexBitfield verifiedPieces() {
        return new PieceIndexBitfield(this.f2833ts.getVerified_pieces(), this.f2833ts);
    }

    public long totalDone() {
        return this.f2833ts.getTotal_done();
    }

    public long total() {
        return this.f2833ts.getTotal();
    }

    public long totalWantedDone() {
        return this.f2833ts.getTotal_wanted_done();
    }

    public long totalWanted() {
        return this.f2833ts.getTotal_wanted();
    }

    public long allTimeUpload() {
        return this.f2833ts.getAll_time_upload();
    }

    public long allTimeDownload() {
        return this.f2833ts.getAll_time_download();
    }

    public long addedTime() {
        return time2millis(this.f2833ts.getAdded_time());
    }

    public long completedTime() {
        return time2millis(this.f2833ts.getCompleted_time());
    }

    public long lastSeenComplete() {
        return time2millis(this.f2833ts.getLast_seen_complete());
    }

    public final StorageMode storageMode() {
        return StorageMode.fromSwig(this.f2833ts.getStorage_mode().swigValue());
    }

    public float progress() {
        return this.f2833ts.getProgress();
    }

    public int progressPpm() {
        return this.f2833ts.getProgress_ppm();
    }

    public int queuePosition() {
        return this.f2833ts.get_queue_position();
    }

    public int downloadRate() {
        return this.f2833ts.getDownload_rate();
    }

    public int uploadRate() {
        return this.f2833ts.getUpload_rate();
    }

    public int downloadPayloadRate() {
        return this.f2833ts.getDownload_payload_rate();
    }

    public int uploadPayloadRate() {
        return this.f2833ts.getUpload_payload_rate();
    }

    public int numSeeds() {
        return this.f2833ts.getNum_seeds();
    }

    public int numPeers() {
        return this.f2833ts.getNum_peers();
    }

    public int numComplete() {
        return this.f2833ts.getNum_complete();
    }

    public int numIncomplete() {
        return this.f2833ts.getNum_incomplete();
    }

    public int listSeeds() {
        return this.f2833ts.getList_seeds();
    }

    public int listPeers() {
        return this.f2833ts.getList_peers();
    }

    public int connectCandidates() {
        return this.f2833ts.getConnect_candidates();
    }

    public int numPieces() {
        return this.f2833ts.getNum_pieces();
    }

    public int distributedFullCopies() {
        return this.f2833ts.getDistributed_full_copies();
    }

    public int distributedFraction() {
        return this.f2833ts.getDistributed_fraction();
    }

    public float distributedCopies() {
        return this.f2833ts.getDistributed_copies();
    }

    public int blockSize() {
        return this.f2833ts.getBlock_size();
    }

    public int numUploads() {
        return this.f2833ts.getNum_uploads();
    }

    public int numConnections() {
        return this.f2833ts.getNum_connections();
    }

    public int uploadsLimit() {
        return this.f2833ts.getUploads_limit();
    }

    public int connectionsLimit() {
        return this.f2833ts.getConnections_limit();
    }

    public int upBandwidthQueue() {
        return this.f2833ts.getUp_bandwidth_queue();
    }

    public int downBandwidthQueue() {
        return this.f2833ts.getDown_bandwidth_queue();
    }

    public int seedRank() {
        return this.f2833ts.getSeed_rank();
    }

    public State state() {
        return State.fromSwig(this.f2833ts.getState().swigValue());
    }

    public boolean needSaveResume() {
        return this.f2833ts.getNeed_save_resume();
    }

    public boolean isSeeding() {
        return this.f2833ts.getIs_seeding();
    }

    public boolean isFinished() {
        return this.f2833ts.getIs_finished();
    }

    public boolean hasMetadata() {
        return this.f2833ts.getHas_metadata();
    }

    public boolean hasIncoming() {
        return this.f2833ts.getHas_incoming();
    }

    public boolean isMovingStorage() {
        return this.f2833ts.getMoving_storage();
    }

    public boolean announcingToTrackers() {
        return this.f2833ts.getAnnouncing_to_trackers();
    }

    public boolean announcingToLsd() {
        return this.f2833ts.getAnnouncing_to_lsd();
    }

    public boolean announcingToDht() {
        return this.f2833ts.getAnnouncing_to_dht();
    }

    public Sha1Hash infoHash() {
        return new Sha1Hash(this.f2833ts.getInfo_hash());
    }

    public long lastUpload() {
        return this.f2833ts.get_last_upload();
    }

    public long lastDownload() {
        return this.f2833ts.get_last_download();
    }

    public long activeDuration() {
        return this.f2833ts.get_active_duration();
    }

    public long finishedDuration() {
        return this.f2833ts.get_finished_duration();
    }

    public long seedingDuration() {
        return this.f2833ts.get_seeding_duration();
    }

    public torrent_flags_t flags() {
        return this.f2833ts.getFlags();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public TorrentStatus m8572clone() {
        return new TorrentStatus(new torrent_status(this.f2833ts));
    }

    /* loaded from: classes2.dex */
    public enum State {
        CHECKING_FILES(torrent_status.state_t.checking_files.swigValue()),
        DOWNLOADING_METADATA(torrent_status.state_t.downloading_metadata.swigValue()),
        DOWNLOADING(torrent_status.state_t.downloading.swigValue()),
        FINISHED(torrent_status.state_t.finished.swigValue()),
        SEEDING(torrent_status.state_t.seeding.swigValue()),
        ALLOCATING(torrent_status.state_t.allocating.swigValue()),
        CHECKING_RESUME_DATA(torrent_status.state_t.checking_resume_data.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        State(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static State fromSwig(int i) {
            State[] stateArr;
            for (State state : (State[]) State.class.getEnumConstants()) {
                if (state.swig() == i) {
                    return state;
                }
            }
            return UNKNOWN;
        }
    }
}
