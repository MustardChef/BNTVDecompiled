package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class announce_endpoint {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public announce_endpoint(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(announce_endpoint announce_endpointVar) {
        if (announce_endpointVar == null) {
            return 0L;
        }
        return announce_endpointVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_announce_endpoint(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setLast_error(error_code error_codeVar) {
        libtorrent_jni.announce_endpoint_last_error_set(this.swigCPtr, this, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    public error_code getLast_error() {
        long announce_endpoint_last_error_get = libtorrent_jni.announce_endpoint_last_error_get(this.swigCPtr, this);
        if (announce_endpoint_last_error_get == 0) {
            return null;
        }
        return new error_code(announce_endpoint_last_error_get, false);
    }

    public void setLocal_endpoint(tcp_endpoint tcp_endpointVar) {
        libtorrent_jni.announce_endpoint_local_endpoint_set(this.swigCPtr, this, tcp_endpoint.getCPtr(tcp_endpointVar), tcp_endpointVar);
    }

    public tcp_endpoint getLocal_endpoint() {
        long announce_endpoint_local_endpoint_get = libtorrent_jni.announce_endpoint_local_endpoint_get(this.swigCPtr, this);
        if (announce_endpoint_local_endpoint_get == 0) {
            return null;
        }
        return new tcp_endpoint(announce_endpoint_local_endpoint_get, false);
    }

    public void setScrape_incomplete(int i) {
        libtorrent_jni.announce_endpoint_scrape_incomplete_set(this.swigCPtr, this, i);
    }

    public int getScrape_incomplete() {
        return libtorrent_jni.announce_endpoint_scrape_incomplete_get(this.swigCPtr, this);
    }

    public void setScrape_complete(int i) {
        libtorrent_jni.announce_endpoint_scrape_complete_set(this.swigCPtr, this, i);
    }

    public int getScrape_complete() {
        return libtorrent_jni.announce_endpoint_scrape_complete_get(this.swigCPtr, this);
    }

    public void setScrape_downloaded(int i) {
        libtorrent_jni.announce_endpoint_scrape_downloaded_set(this.swigCPtr, this, i);
    }

    public int getScrape_downloaded() {
        return libtorrent_jni.announce_endpoint_scrape_downloaded_get(this.swigCPtr, this);
    }

    public void setFails(short s) {
        libtorrent_jni.announce_endpoint_fails_set(this.swigCPtr, this, s);
    }

    public short getFails() {
        return libtorrent_jni.announce_endpoint_fails_get(this.swigCPtr, this);
    }

    public void setUpdating(boolean z) {
        libtorrent_jni.announce_endpoint_updating_set(this.swigCPtr, this, z);
    }

    public boolean getUpdating() {
        return libtorrent_jni.announce_endpoint_updating_get(this.swigCPtr, this);
    }

    public boolean is_working() {
        return libtorrent_jni.announce_endpoint_is_working(this.swigCPtr, this);
    }

    public byte_vector get_message() {
        return new byte_vector(libtorrent_jni.announce_endpoint_get_message(this.swigCPtr, this), true);
    }

    public long get_next_announce() {
        return libtorrent_jni.announce_endpoint_get_next_announce(this.swigCPtr, this);
    }

    public long get_min_announce() {
        return libtorrent_jni.announce_endpoint_get_min_announce(this.swigCPtr, this);
    }
}
