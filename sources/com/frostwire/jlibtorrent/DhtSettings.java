package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.dht_settings;

/* loaded from: classes2.dex */
public final class DhtSettings {

    /* renamed from: s */
    private final dht_settings f2811s;

    public DhtSettings(dht_settings dht_settingsVar) {
        this.f2811s = dht_settingsVar;
    }

    public DhtSettings() {
        this(new dht_settings());
    }

    public dht_settings swig() {
        return this.f2811s;
    }

    public int maxPeersReply() {
        return this.f2811s.getMax_peers_reply();
    }

    public void maxPeersReply(int i) {
        this.f2811s.setMax_peers_reply(i);
    }

    public int getSearchBranching() {
        return this.f2811s.getSearch_branching();
    }

    public void setSearchBranching(int i) {
        this.f2811s.setSearch_branching(i);
    }

    public int getMaxFailCount() {
        return this.f2811s.getMax_fail_count();
    }

    public void setMaxFailCount(int i) {
        this.f2811s.setMax_fail_count(i);
    }

    public int maxTorrents() {
        return this.f2811s.getMax_torrents();
    }

    public void maxTorrents(int i) {
        this.f2811s.setMax_torrents(i);
    }

    public int maxDhtItems() {
        return this.f2811s.getMax_dht_items();
    }

    public void maxDhtItems(int i) {
        this.f2811s.setMax_dht_items(i);
    }

    public int maxPeers() {
        return this.f2811s.getMax_peers();
    }

    public void maxPeers(int i) {
        this.f2811s.setMax_peers(i);
    }

    public int getMaxTorrentSearchReply() {
        return this.f2811s.getMax_torrent_search_reply();
    }

    public void setMaxTorrentSearchReply(int i) {
        this.f2811s.setMax_torrent_search_reply(i);
    }

    public boolean isRestrictRoutingIPs() {
        return this.f2811s.getRestrict_routing_ips();
    }

    public void setRestrictRoutingIPs(boolean z) {
        this.f2811s.setRestrict_routing_ips(z);
    }

    public boolean isRestrictSearchIPs() {
        return this.f2811s.getRestrict_search_ips();
    }

    public void setRestrictSearchIPs(boolean z) {
        this.f2811s.setRestrict_search_ips(z);
    }

    public boolean isExtendedRoutingTable() {
        return this.f2811s.getExtended_routing_table();
    }

    public void setExtendedRoutingTable(boolean z) {
        this.f2811s.setExtended_routing_table(z);
    }

    public boolean isAggressiveLookups() {
        return this.f2811s.getAggressive_lookups();
    }

    public void getAggressiveLookups(boolean z) {
        this.f2811s.setAggressive_lookups(z);
    }

    public boolean isPrivacyLookups() {
        return this.f2811s.getPrivacy_lookups();
    }

    public void setPrivacyLookups(boolean z) {
        this.f2811s.setPrivacy_lookups(z);
    }

    public boolean isEnforceNodeId() {
        return this.f2811s.getEnforce_node_id();
    }

    public void setEnforceNodeId(boolean z) {
        this.f2811s.setEnforce_node_id(z);
    }

    public boolean isIgnoreDarkInternet() {
        return this.f2811s.getIgnore_dark_internet();
    }

    public void setIgnoreDarkInternet(boolean z) {
        this.f2811s.setIgnore_dark_internet(z);
    }

    public int blockTimeout() {
        return this.f2811s.getBlock_timeout();
    }

    public void blockTimeout(int i) {
        this.f2811s.setBlock_timeout(i);
    }

    public int blockRatelimit() {
        return this.f2811s.getBlock_ratelimit();
    }

    public void blockRatelimit(int i) {
        this.f2811s.setBlock_ratelimit(i);
    }

    public boolean readOnly() {
        return this.f2811s.getRead_only();
    }

    public void readOnly(boolean z) {
        this.f2811s.setRead_only(z);
    }

    public int itemLifetime() {
        return this.f2811s.getItem_lifetime();
    }

    public void itemLifetime(int i) {
        this.f2811s.setItem_lifetime(i);
    }

    public int uploadRateLimit() {
        return this.f2811s.getUpload_rate_limit();
    }

    public void uploadRateLimit(int i) {
        this.f2811s.setUpload_rate_limit(i);
    }
}
