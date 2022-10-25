package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class announce_entry {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public announce_entry(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(announce_entry announce_entryVar) {
        if (announce_entryVar == null) {
            return 0L;
        }
        return announce_entryVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_announce_entry(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setEndpoints(announce_endpoint_vector announce_endpoint_vectorVar) {
        libtorrent_jni.announce_entry_endpoints_set(this.swigCPtr, this, announce_endpoint_vector.getCPtr(announce_endpoint_vectorVar), announce_endpoint_vectorVar);
    }

    public announce_endpoint_vector getEndpoints() {
        long announce_entry_endpoints_get = libtorrent_jni.announce_entry_endpoints_get(this.swigCPtr, this);
        if (announce_entry_endpoints_get == 0) {
            return null;
        }
        return new announce_endpoint_vector(announce_entry_endpoints_get, false);
    }

    public void setTier(short s) {
        libtorrent_jni.announce_entry_tier_set(this.swigCPtr, this, s);
    }

    public short getTier() {
        return libtorrent_jni.announce_entry_tier_get(this.swigCPtr, this);
    }

    public void setFail_limit(short s) {
        libtorrent_jni.announce_entry_fail_limit_set(this.swigCPtr, this, s);
    }

    public short getFail_limit() {
        return libtorrent_jni.announce_entry_fail_limit_get(this.swigCPtr, this);
    }

    public void setSource(short s) {
        libtorrent_jni.announce_entry_source_set(this.swigCPtr, this, s);
    }

    public short getSource() {
        return libtorrent_jni.announce_entry_source_get(this.swigCPtr, this);
    }

    public void setVerified(boolean z) {
        libtorrent_jni.announce_entry_verified_set(this.swigCPtr, this, z);
    }

    public boolean getVerified() {
        return libtorrent_jni.announce_entry_verified_get(this.swigCPtr, this);
    }

    public announce_entry(byte_vector byte_vectorVar) {
        this(libtorrent_jni.new_announce_entry(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar), true);
    }

    public byte_vector get_url() {
        return new byte_vector(libtorrent_jni.announce_entry_get_url(this.swigCPtr, this), true);
    }

    public void set_url(byte_vector byte_vectorVar) {
        libtorrent_jni.announce_entry_set_url(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector get_trackerid() {
        return new byte_vector(libtorrent_jni.announce_entry_get_trackerid(this.swigCPtr, this), true);
    }

    public void set_trackerid(byte_vector byte_vectorVar) {
        libtorrent_jni.announce_entry_set_trackerid(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    /* loaded from: classes2.dex */
    public static final class tracker_source {
        public static final tracker_source source_client;
        public static final tracker_source source_magnet_link;
        public static final tracker_source source_tex;
        public static final tracker_source source_torrent;
        private static int swigNext;
        private static tracker_source[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            tracker_source tracker_sourceVar = new tracker_source("source_torrent", libtorrent_jni.announce_entry_source_torrent_get());
            source_torrent = tracker_sourceVar;
            tracker_source tracker_sourceVar2 = new tracker_source("source_client", libtorrent_jni.announce_entry_source_client_get());
            source_client = tracker_sourceVar2;
            tracker_source tracker_sourceVar3 = new tracker_source("source_magnet_link", libtorrent_jni.announce_entry_source_magnet_link_get());
            source_magnet_link = tracker_sourceVar3;
            tracker_source tracker_sourceVar4 = new tracker_source("source_tex", libtorrent_jni.announce_entry_source_tex_get());
            source_tex = tracker_sourceVar4;
            swigValues = new tracker_source[]{tracker_sourceVar, tracker_sourceVar2, tracker_sourceVar3, tracker_sourceVar4};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static tracker_source swigToEnum(int i) {
            tracker_source[] tracker_sourceVarArr = swigValues;
            if (i < tracker_sourceVarArr.length && i >= 0 && tracker_sourceVarArr[i].swigValue == i) {
                return tracker_sourceVarArr[i];
            }
            int i2 = 0;
            while (true) {
                tracker_source[] tracker_sourceVarArr2 = swigValues;
                if (i2 < tracker_sourceVarArr2.length) {
                    if (tracker_sourceVarArr2[i2].swigValue == i) {
                        return tracker_sourceVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + tracker_source.class + " with value " + i);
                }
            }
        }

        private tracker_source(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private tracker_source(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private tracker_source(String str, tracker_source tracker_sourceVar) {
            this.swigName = str;
            int i = tracker_sourceVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
