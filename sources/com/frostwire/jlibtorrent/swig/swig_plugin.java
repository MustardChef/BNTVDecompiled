package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class swig_plugin {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected swig_plugin(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(swig_plugin swig_pluginVar) {
        if (swig_pluginVar == null) {
            return 0L;
        }
        return swig_pluginVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_swig_plugin(j);
            }
            this.swigCPtr = 0L;
        }
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        libtorrent_jni.swig_plugin_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        libtorrent_jni.swig_plugin_change_ownership(this, this.swigCPtr, true);
    }

    public boolean on_dht_request(string_view string_viewVar, udp_endpoint udp_endpointVar, bdecode_node bdecode_nodeVar, entry entryVar) {
        return getClass() == swig_plugin.class ? libtorrent_jni.swig_plugin_on_dht_request(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar, bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar, entry.getCPtr(entryVar), entryVar) : libtorrent_jni.swig_plugin_on_dht_requestSwigExplicitswig_plugin(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar, udp_endpoint.getCPtr(udp_endpointVar), udp_endpointVar, bdecode_node.getCPtr(bdecode_nodeVar), bdecode_nodeVar, entry.getCPtr(entryVar), entryVar);
    }

    public swig_plugin() {
        this(libtorrent_jni.new_swig_plugin(), true);
        libtorrent_jni.swig_plugin_director_connect(this, this.swigCPtr, true, true);
    }
}
