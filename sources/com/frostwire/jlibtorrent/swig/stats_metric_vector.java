package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class stats_metric_vector {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public stats_metric_vector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(stats_metric_vector stats_metric_vectorVar) {
        if (stats_metric_vectorVar == null) {
            return 0L;
        }
        return stats_metric_vectorVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_stats_metric_vector(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public stats_metric_vector() {
        this(libtorrent_jni.new_stats_metric_vector(), true);
    }

    public long size() {
        return libtorrent_jni.stats_metric_vector_size(this.swigCPtr, this);
    }

    public long capacity() {
        return libtorrent_jni.stats_metric_vector_capacity(this.swigCPtr, this);
    }

    public void reserve(long j) {
        libtorrent_jni.stats_metric_vector_reserve(this.swigCPtr, this, j);
    }

    public boolean empty() {
        return libtorrent_jni.stats_metric_vector_empty(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.stats_metric_vector_clear(this.swigCPtr, this);
    }

    public void push_back(stats_metric stats_metricVar) {
        libtorrent_jni.stats_metric_vector_push_back(this.swigCPtr, this, stats_metric.getCPtr(stats_metricVar), stats_metricVar);
    }

    public stats_metric get(int i) {
        return new stats_metric(libtorrent_jni.stats_metric_vector_get(this.swigCPtr, this, i), false);
    }

    public void set(int i, stats_metric stats_metricVar) {
        libtorrent_jni.stats_metric_vector_set(this.swigCPtr, this, i, stats_metric.getCPtr(stats_metricVar), stats_metricVar);
    }
}
