package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class string_view_bdecode_node_pair {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public string_view_bdecode_node_pair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(string_view_bdecode_node_pair string_view_bdecode_node_pairVar) {
        if (string_view_bdecode_node_pairVar == null) {
            return 0L;
        }
        return string_view_bdecode_node_pairVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_string_view_bdecode_node_pair(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public string_view_bdecode_node_pair() {
        this(libtorrent_jni.new_string_view_bdecode_node_pair__SWIG_0(), true);
    }

    public string_view_bdecode_node_pair(string_view string_viewVar, bdecode_node bdecode_nodeVar) {
        this(libtorrent_jni.new_string_view_bdecode_node_pair__SWIG_1(string_view.getCPtr(string_viewVar), string_viewVar, bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar), true);
    }

    public string_view_bdecode_node_pair(string_view_bdecode_node_pair string_view_bdecode_node_pairVar) {
        this(libtorrent_jni.new_string_view_bdecode_node_pair__SWIG_2(getCPtr(string_view_bdecode_node_pairVar), string_view_bdecode_node_pairVar), true);
    }

    public void setFirst(string_view string_viewVar) {
        libtorrent_jni.string_view_bdecode_node_pair_first_set(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar);
    }

    public string_view getFirst() {
        long string_view_bdecode_node_pair_first_get = libtorrent_jni.string_view_bdecode_node_pair_first_get(this.swigCPtr, this);
        if (string_view_bdecode_node_pair_first_get == 0) {
            return null;
        }
        return new string_view(string_view_bdecode_node_pair_first_get, false);
    }

    public void setSecond(bdecode_node bdecode_nodeVar) {
        libtorrent_jni.string_view_bdecode_node_pair_second_set(this.swigCPtr, this, bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar);
    }

    public bdecode_node getSecond() {
        long string_view_bdecode_node_pair_second_get = libtorrent_jni.string_view_bdecode_node_pair_second_get(this.swigCPtr, this);
        if (string_view_bdecode_node_pair_second_get == 0) {
            return null;
        }
        return new bdecode_node(string_view_bdecode_node_pair_second_get, false);
    }
}
