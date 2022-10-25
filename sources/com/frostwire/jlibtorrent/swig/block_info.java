package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class block_info {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public block_info(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(block_info block_infoVar) {
        if (block_infoVar == null) {
            return 0L;
        }
        return block_infoVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_block_info(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public tcp_endpoint peer() {
        return new tcp_endpoint(libtorrent_jni.block_info_peer(this.swigCPtr, this), true);
    }

    public void setBytes_progress(long j) {
        libtorrent_jni.block_info_bytes_progress_set(this.swigCPtr, this, j);
    }

    public long getBytes_progress() {
        return libtorrent_jni.block_info_bytes_progress_get(this.swigCPtr, this);
    }

    public void setBlock_size(long j) {
        libtorrent_jni.block_info_block_size_set(this.swigCPtr, this, j);
    }

    public long getBlock_size() {
        return libtorrent_jni.block_info_block_size_get(this.swigCPtr, this);
    }

    public void setState(long j) {
        libtorrent_jni.block_info_state_set(this.swigCPtr, this, j);
    }

    public long getState() {
        return libtorrent_jni.block_info_state_get(this.swigCPtr, this);
    }

    public void setNum_peers(long j) {
        libtorrent_jni.block_info_num_peers_set(this.swigCPtr, this, j);
    }

    public long getNum_peers() {
        return libtorrent_jni.block_info_num_peers_get(this.swigCPtr, this);
    }

    public block_info() {
        this(libtorrent_jni.new_block_info(), true);
    }

    /* loaded from: classes2.dex */
    public static final class block_state_t {
        public static final block_state_t finished;
        public static final block_state_t none;
        public static final block_state_t requested;
        private static int swigNext;
        private static block_state_t[] swigValues;
        public static final block_state_t writing;
        private final String swigName;
        private final int swigValue;

        static {
            block_state_t block_state_tVar = new block_state_t("none");
            none = block_state_tVar;
            block_state_t block_state_tVar2 = new block_state_t("requested");
            requested = block_state_tVar2;
            block_state_t block_state_tVar3 = new block_state_t("writing");
            writing = block_state_tVar3;
            block_state_t block_state_tVar4 = new block_state_t("finished");
            finished = block_state_tVar4;
            swigValues = new block_state_t[]{block_state_tVar, block_state_tVar2, block_state_tVar3, block_state_tVar4};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static block_state_t swigToEnum(int i) {
            block_state_t[] block_state_tVarArr = swigValues;
            if (i < block_state_tVarArr.length && i >= 0 && block_state_tVarArr[i].swigValue == i) {
                return block_state_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                block_state_t[] block_state_tVarArr2 = swigValues;
                if (i2 < block_state_tVarArr2.length) {
                    if (block_state_tVarArr2[i2].swigValue == i) {
                        return block_state_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + block_state_t.class + " with value " + i);
                }
            }
        }

        private block_state_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private block_state_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private block_state_t(String str, block_state_t block_state_tVar) {
            this.swigName = str;
            int i = block_state_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
