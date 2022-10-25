package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class dht_settings {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public dht_settings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(dht_settings dht_settingsVar) {
        if (dht_settingsVar == null) {
            return 0L;
        }
        return dht_settingsVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_dht_settings(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMax_peers_reply(int i) {
        libtorrent_jni.dht_settings_max_peers_reply_set(this.swigCPtr, this, i);
    }

    public int getMax_peers_reply() {
        return libtorrent_jni.dht_settings_max_peers_reply_get(this.swigCPtr, this);
    }

    public void setSearch_branching(int i) {
        libtorrent_jni.dht_settings_search_branching_set(this.swigCPtr, this, i);
    }

    public int getSearch_branching() {
        return libtorrent_jni.dht_settings_search_branching_get(this.swigCPtr, this);
    }

    public void setMax_fail_count(int i) {
        libtorrent_jni.dht_settings_max_fail_count_set(this.swigCPtr, this, i);
    }

    public int getMax_fail_count() {
        return libtorrent_jni.dht_settings_max_fail_count_get(this.swigCPtr, this);
    }

    public void setMax_torrents(int i) {
        libtorrent_jni.dht_settings_max_torrents_set(this.swigCPtr, this, i);
    }

    public int getMax_torrents() {
        return libtorrent_jni.dht_settings_max_torrents_get(this.swigCPtr, this);
    }

    public void setMax_dht_items(int i) {
        libtorrent_jni.dht_settings_max_dht_items_set(this.swigCPtr, this, i);
    }

    public int getMax_dht_items() {
        return libtorrent_jni.dht_settings_max_dht_items_get(this.swigCPtr, this);
    }

    public void setMax_peers(int i) {
        libtorrent_jni.dht_settings_max_peers_set(this.swigCPtr, this, i);
    }

    public int getMax_peers() {
        return libtorrent_jni.dht_settings_max_peers_get(this.swigCPtr, this);
    }

    public void setMax_torrent_search_reply(int i) {
        libtorrent_jni.dht_settings_max_torrent_search_reply_set(this.swigCPtr, this, i);
    }

    public int getMax_torrent_search_reply() {
        return libtorrent_jni.dht_settings_max_torrent_search_reply_get(this.swigCPtr, this);
    }

    public void setRestrict_routing_ips(boolean z) {
        libtorrent_jni.dht_settings_restrict_routing_ips_set(this.swigCPtr, this, z);
    }

    public boolean getRestrict_routing_ips() {
        return libtorrent_jni.dht_settings_restrict_routing_ips_get(this.swigCPtr, this);
    }

    public void setRestrict_search_ips(boolean z) {
        libtorrent_jni.dht_settings_restrict_search_ips_set(this.swigCPtr, this, z);
    }

    public boolean getRestrict_search_ips() {
        return libtorrent_jni.dht_settings_restrict_search_ips_get(this.swigCPtr, this);
    }

    public void setExtended_routing_table(boolean z) {
        libtorrent_jni.dht_settings_extended_routing_table_set(this.swigCPtr, this, z);
    }

    public boolean getExtended_routing_table() {
        return libtorrent_jni.dht_settings_extended_routing_table_get(this.swigCPtr, this);
    }

    public void setAggressive_lookups(boolean z) {
        libtorrent_jni.dht_settings_aggressive_lookups_set(this.swigCPtr, this, z);
    }

    public boolean getAggressive_lookups() {
        return libtorrent_jni.dht_settings_aggressive_lookups_get(this.swigCPtr, this);
    }

    public void setPrivacy_lookups(boolean z) {
        libtorrent_jni.dht_settings_privacy_lookups_set(this.swigCPtr, this, z);
    }

    public boolean getPrivacy_lookups() {
        return libtorrent_jni.dht_settings_privacy_lookups_get(this.swigCPtr, this);
    }

    public void setEnforce_node_id(boolean z) {
        libtorrent_jni.dht_settings_enforce_node_id_set(this.swigCPtr, this, z);
    }

    public boolean getEnforce_node_id() {
        return libtorrent_jni.dht_settings_enforce_node_id_get(this.swigCPtr, this);
    }

    public void setIgnore_dark_internet(boolean z) {
        libtorrent_jni.dht_settings_ignore_dark_internet_set(this.swigCPtr, this, z);
    }

    public boolean getIgnore_dark_internet() {
        return libtorrent_jni.dht_settings_ignore_dark_internet_get(this.swigCPtr, this);
    }

    public void setBlock_timeout(int i) {
        libtorrent_jni.dht_settings_block_timeout_set(this.swigCPtr, this, i);
    }

    public int getBlock_timeout() {
        return libtorrent_jni.dht_settings_block_timeout_get(this.swigCPtr, this);
    }

    public void setBlock_ratelimit(int i) {
        libtorrent_jni.dht_settings_block_ratelimit_set(this.swigCPtr, this, i);
    }

    public int getBlock_ratelimit() {
        return libtorrent_jni.dht_settings_block_ratelimit_get(this.swigCPtr, this);
    }

    public void setRead_only(boolean z) {
        libtorrent_jni.dht_settings_read_only_set(this.swigCPtr, this, z);
    }

    public boolean getRead_only() {
        return libtorrent_jni.dht_settings_read_only_get(this.swigCPtr, this);
    }

    public void setItem_lifetime(int i) {
        libtorrent_jni.dht_settings_item_lifetime_set(this.swigCPtr, this, i);
    }

    public int getItem_lifetime() {
        return libtorrent_jni.dht_settings_item_lifetime_get(this.swigCPtr, this);
    }

    public void setUpload_rate_limit(int i) {
        libtorrent_jni.dht_settings_upload_rate_limit_set(this.swigCPtr, this, i);
    }

    public int getUpload_rate_limit() {
        return libtorrent_jni.dht_settings_upload_rate_limit_get(this.swigCPtr, this);
    }

    public void setSample_infohashes_interval(int i) {
        libtorrent_jni.dht_settings_sample_infohashes_interval_set(this.swigCPtr, this, i);
    }

    public int getSample_infohashes_interval() {
        return libtorrent_jni.dht_settings_sample_infohashes_interval_get(this.swigCPtr, this);
    }

    public void setMax_infohashes_sample_count(int i) {
        libtorrent_jni.dht_settings_max_infohashes_sample_count_set(this.swigCPtr, this, i);
    }

    public int getMax_infohashes_sample_count() {
        return libtorrent_jni.dht_settings_max_infohashes_sample_count_get(this.swigCPtr, this);
    }

    public dht_settings() {
        this(libtorrent_jni.new_dht_settings(), true);
    }
}
