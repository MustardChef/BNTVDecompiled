package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.settings_pack;

/* loaded from: classes2.dex */
public final class SettingsPack {

    /* renamed from: sp */
    private final settings_pack f2826sp;

    public SettingsPack(settings_pack settings_packVar) {
        this.f2826sp = settings_packVar;
    }

    public SettingsPack() {
        this(new settings_pack());
    }

    public settings_pack swig() {
        return this.f2826sp;
    }

    public boolean getBoolean(int i) {
        return this.f2826sp.get_bool(i);
    }

    public SettingsPack setBoolean(int i, boolean z) {
        this.f2826sp.set_bool(i, z);
        return this;
    }

    public int getInteger(int i) {
        return this.f2826sp.get_int(i);
    }

    public SettingsPack setInteger(int i, int i2) {
        this.f2826sp.set_int(i, i2);
        return this;
    }

    public String getString(int i) {
        return this.f2826sp.get_str(i);
    }

    public SettingsPack setString(int i, String str) {
        this.f2826sp.set_str(i, str);
        return this;
    }

    public void clear() {
        this.f2826sp.clear();
    }

    public void clear(int i) {
        this.f2826sp.clear(i);
    }

    public int downloadRateLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.download_rate_limit.swigValue());
    }

    public SettingsPack downloadRateLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.download_rate_limit.swigValue(), i);
        return this;
    }

    public int uploadRateLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.upload_rate_limit.swigValue());
    }

    public SettingsPack uploadRateLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.upload_rate_limit.swigValue(), i);
        return this;
    }

    public int activeDownloads() {
        return this.f2826sp.get_int(settings_pack.int_types.active_downloads.swigValue());
    }

    public SettingsPack activeDownloads(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_downloads.swigValue(), i);
        return this;
    }

    public int activeSeeds() {
        return this.f2826sp.get_int(settings_pack.int_types.active_seeds.swigValue());
    }

    public SettingsPack activeSeeds(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_seeds.swigValue(), i);
        return this;
    }

    public int activeChecking() {
        return this.f2826sp.get_int(settings_pack.int_types.active_checking.swigValue());
    }

    public SettingsPack activeChecking(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_checking.swigValue(), i);
        return this;
    }

    public int activeDhtLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.active_dht_limit.swigValue());
    }

    public SettingsPack activeDhtLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_dht_limit.swigValue(), i);
        return this;
    }

    public int dhtUploadRate() {
        return this.f2826sp.get_int(settings_pack.int_types.dht_upload_rate_limit.swigValue());
    }

    public SettingsPack dhtUploadRate(int i) {
        this.f2826sp.set_int(settings_pack.int_types.dht_upload_rate_limit.swigValue(), i);
        return this;
    }

    public int activeTrackerLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.active_tracker_limit.swigValue());
    }

    public SettingsPack activeTrackerLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_tracker_limit.swigValue(), i);
        return this;
    }

    public int activeLsdLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.active_lsd_limit.swigValue());
    }

    public SettingsPack activeLsdLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_lsd_limit.swigValue(), i);
        return this;
    }

    public int activeLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.active_limit.swigValue());
    }

    public SettingsPack activeLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.active_limit.swigValue(), i);
        return this;
    }

    public int connectionsLimit() {
        return this.f2826sp.get_int(settings_pack.int_types.connections_limit.swigValue());
    }

    public SettingsPack connectionsLimit(int i) {
        this.f2826sp.set_int(settings_pack.int_types.connections_limit.swigValue(), i);
        return this;
    }

    public int maxPeerlistSize() {
        return this.f2826sp.get_int(settings_pack.int_types.max_peerlist_size.swigValue());
    }

    public SettingsPack maxPeerlistSize(int i) {
        this.f2826sp.set_int(settings_pack.int_types.max_peerlist_size.swigValue(), i);
        return this;
    }

    public int maxQueuedDiskBytes() {
        return this.f2826sp.get_int(settings_pack.int_types.max_queued_disk_bytes.swigValue());
    }

    public SettingsPack maxQueuedDiskBytes(int i) {
        this.f2826sp.set_int(settings_pack.int_types.max_queued_disk_bytes.swigValue(), i);
        return this;
    }

    public int sendBufferWatermark() {
        return this.f2826sp.get_int(settings_pack.int_types.send_buffer_watermark.swigValue());
    }

    public SettingsPack sendBufferWatermark(int i) {
        this.f2826sp.set_int(settings_pack.int_types.send_buffer_watermark.swigValue(), i);
        return this;
    }

    public int cacheSize() {
        return this.f2826sp.get_int(settings_pack.int_types.cache_size.swigValue());
    }

    public SettingsPack cacheSize(int i) {
        this.f2826sp.set_int(settings_pack.int_types.cache_size.swigValue(), i);
        return this;
    }

    public int tickInterval() {
        return this.f2826sp.get_int(settings_pack.int_types.tick_interval.swigValue());
    }

    public SettingsPack tickInterval(int i) {
        this.f2826sp.set_int(settings_pack.int_types.tick_interval.swigValue(), i);
        return this;
    }

    public int inactivityTimeout() {
        return this.f2826sp.get_int(settings_pack.int_types.inactivity_timeout.swigValue());
    }

    public SettingsPack inactivityTimeout(int i) {
        this.f2826sp.set_int(settings_pack.int_types.inactivity_timeout.swigValue(), i);
        return this;
    }

    public boolean seedingOutgoingConnections() {
        return this.f2826sp.get_bool(settings_pack.bool_types.seeding_outgoing_connections.swigValue());
    }

    public SettingsPack seedingOutgoingConnections(boolean z) {
        this.f2826sp.set_bool(settings_pack.bool_types.seeding_outgoing_connections.swigValue(), z);
        return this;
    }

    public boolean anonymousMode() {
        return this.f2826sp.get_bool(settings_pack.bool_types.anonymous_mode.swigValue());
    }

    public SettingsPack anonymousMode(boolean z) {
        this.f2826sp.set_bool(settings_pack.bool_types.anonymous_mode.swigValue(), z);
        return this;
    }

    public boolean enableDht() {
        return this.f2826sp.get_bool(settings_pack.bool_types.enable_dht.swigValue());
    }

    public SettingsPack enableDht(boolean z) {
        this.f2826sp.set_bool(settings_pack.bool_types.enable_dht.swigValue(), z);
        return this;
    }

    public String listenInterfaces() {
        return this.f2826sp.get_str(settings_pack.string_types.listen_interfaces.swigValue());
    }

    public SettingsPack listenInterfaces(String str) {
        this.f2826sp.set_str(settings_pack.string_types.listen_interfaces.swigValue(), str);
        return this;
    }

    public int stopTrackerTimeout() {
        return this.f2826sp.get_int(settings_pack.int_types.stop_tracker_timeout.swigValue());
    }

    public SettingsPack stopTrackerTimeout(int i) {
        this.f2826sp.set_int(settings_pack.int_types.stop_tracker_timeout.swigValue(), i);
        return this;
    }

    public int alertQueueSize() {
        return this.f2826sp.get_int(settings_pack.int_types.alert_queue_size.swigValue());
    }

    public SettingsPack alertQueueSize(int i) {
        this.f2826sp.set_int(settings_pack.int_types.alert_queue_size.swigValue(), i);
        return this;
    }
}
