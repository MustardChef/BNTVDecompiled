package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Vectors;
import com.frostwire.jlibtorrent.swig.announce_entry;
import com.frostwire.jlibtorrent.swig.announce_entry_vector;
import com.frostwire.jlibtorrent.swig.create_torrent;
import com.frostwire.jlibtorrent.swig.metadata_received_alert;
import com.frostwire.jlibtorrent.swig.string_vector;
import com.frostwire.jlibtorrent.swig.torrent_handle;
import com.frostwire.jlibtorrent.swig.torrent_info;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class MetadataReceivedAlert extends TorrentAlert<metadata_received_alert> {
    private byte[] data;
    private boolean invalid;
    private int size;
    private final ReentrantLock sync;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataReceivedAlert(metadata_received_alert metadata_received_alertVar) {
        super(metadata_received_alertVar);
        this.sync = new ReentrantLock();
    }

    public int metadataSize() {
        if (this.invalid) {
            return -1;
        }
        int i = this.size;
        if (i > 0) {
            return i;
        }
        this.sync.lock();
        try {
            try {
            } finally {
                this.sync.unlock();
            }
        } catch (Throwable unused) {
            this.invalid = true;
        }
        if (!this.invalid) {
            int i2 = this.size;
            if (i2 > 0) {
                return i2;
            }
            torrent_handle handle = ((metadata_received_alert) this.alert).getHandle();
            if (handle != null && handle.is_valid()) {
                torrent_info torrent_infoVar = handle.torrent_file_ptr();
                if (torrent_infoVar != null && torrent_infoVar.is_valid()) {
                    this.size = torrent_infoVar.metadata_size();
                    this.sync.unlock();
                    return this.size;
                }
                this.invalid = true;
            }
            this.invalid = true;
        }
        return -1;
    }

    public byte[] torrentData(boolean z) {
        if (this.invalid) {
            return null;
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            return bArr;
        }
        this.sync.lock();
        try {
            try {
            } catch (Throwable unused) {
                this.invalid = true;
            }
            if (!this.invalid) {
                byte[] bArr2 = this.data;
                if (bArr2 != null) {
                    return bArr2;
                }
                torrent_handle handle = ((metadata_received_alert) this.alert).getHandle();
                if (handle != null && handle.is_valid()) {
                    torrent_info torrent_infoVar = handle.torrent_file_ptr();
                    if (torrent_infoVar != null && torrent_infoVar.is_valid()) {
                        this.size = torrent_infoVar.metadata_size();
                        this.data = createTorrent(handle, torrent_infoVar, z);
                        this.sync.unlock();
                        return this.data;
                    }
                    this.invalid = true;
                }
                this.invalid = true;
            }
            return null;
        } finally {
            this.sync.unlock();
        }
    }

    public byte[] torrentData() {
        return torrentData(false);
    }

    private static byte[] createTorrent(torrent_handle torrent_handleVar, torrent_info torrent_infoVar, boolean z) {
        create_torrent create_torrentVar = new create_torrent(torrent_infoVar);
        if (z) {
            string_vector string_vectorVar = torrent_handleVar.get_url_seeds();
            int size = (int) string_vectorVar.size();
            for (int i = 0; i < size; i++) {
                create_torrentVar.add_url_seed(string_vectorVar.get(i));
            }
            string_vector string_vectorVar2 = torrent_handleVar.get_http_seeds();
            int size2 = (int) string_vectorVar2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                create_torrentVar.add_http_seed(string_vectorVar2.get(i2));
            }
            announce_entry_vector trackers = torrent_handleVar.trackers();
            int size3 = (int) trackers.size();
            for (int i3 = 0; i3 < size3; i3++) {
                announce_entry announce_entryVar = trackers.get(i3);
                create_torrentVar.add_tracker(Vectors.byte_vector2ascii(announce_entryVar.get_url()), announce_entryVar.getTier());
            }
        }
        return Vectors.byte_vector2bytes(create_torrentVar.generate().bencode());
    }
}
