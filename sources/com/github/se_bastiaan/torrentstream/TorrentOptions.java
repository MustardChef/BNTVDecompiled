package com.github.se_bastiaan.torrentstream;

import java.io.File;

/* loaded from: classes2.dex */
public final class TorrentOptions {
    Boolean anonymousMode;
    Boolean autoDownload;
    Integer listeningPort;
    Integer maxConnections;
    Integer maxDht;
    Integer maxDownloadSpeed;
    Integer maxUploadSpeed;
    String peerFingerprint;
    Long prepareSize;
    String proxyHost;
    String proxyPassword;
    String proxyUsername;
    Boolean removeFiles;
    String saveLocation;

    private TorrentOptions() {
        this.saveLocation = "/";
        this.maxDownloadSpeed = 0;
        this.maxUploadSpeed = 0;
        this.maxConnections = 200;
        this.maxDht = 88;
        this.listeningPort = -1;
        this.removeFiles = false;
        this.anonymousMode = false;
        this.autoDownload = true;
        this.prepareSize = 15728640L;
    }

    private TorrentOptions(TorrentOptions torrentOptions) {
        this.saveLocation = "/";
        this.maxDownloadSpeed = 0;
        this.maxUploadSpeed = 0;
        this.maxConnections = 200;
        this.maxDht = 88;
        this.listeningPort = -1;
        this.removeFiles = false;
        this.anonymousMode = false;
        this.autoDownload = true;
        this.prepareSize = 15728640L;
        this.saveLocation = torrentOptions.saveLocation;
        this.proxyHost = torrentOptions.proxyHost;
        this.proxyUsername = torrentOptions.proxyUsername;
        this.proxyPassword = torrentOptions.proxyPassword;
        this.peerFingerprint = torrentOptions.peerFingerprint;
        this.maxDownloadSpeed = torrentOptions.maxDownloadSpeed;
        this.maxUploadSpeed = torrentOptions.maxUploadSpeed;
        this.maxConnections = torrentOptions.maxConnections;
        this.maxDht = torrentOptions.maxDht;
        this.listeningPort = torrentOptions.listeningPort;
        this.removeFiles = torrentOptions.removeFiles;
        this.anonymousMode = torrentOptions.anonymousMode;
        this.autoDownload = torrentOptions.autoDownload;
        this.prepareSize = torrentOptions.prepareSize;
    }

    public Builder toBuilder() {
        return new Builder();
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private TorrentOptions torrentOptions;

        public Builder() {
            this.torrentOptions = new TorrentOptions();
        }

        private Builder(TorrentOptions torrentOptions) {
            new TorrentOptions();
        }

        public Builder saveLocation(String str) {
            this.torrentOptions.saveLocation = str;
            return this;
        }

        public Builder saveLocation(File file) {
            this.torrentOptions.saveLocation = file.getAbsolutePath();
            return this;
        }

        public Builder maxUploadSpeed(Integer num) {
            this.torrentOptions.maxUploadSpeed = num;
            return this;
        }

        public Builder maxDownloadSpeed(Integer num) {
            this.torrentOptions.maxDownloadSpeed = num;
            return this;
        }

        public Builder maxConnections(Integer num) {
            this.torrentOptions.maxConnections = num;
            return this;
        }

        public Builder maxActiveDHT(Integer num) {
            this.torrentOptions.maxDht = num;
            return this;
        }

        public Builder removeFilesAfterStop(Boolean bool) {
            this.torrentOptions.removeFiles = bool;
            return this;
        }

        public Builder prepareSize(Long l) {
            this.torrentOptions.prepareSize = l;
            return this;
        }

        public Builder listeningPort(Integer num) {
            this.torrentOptions.listeningPort = num;
            return this;
        }

        public Builder proxy(String str, String str2, String str3) {
            this.torrentOptions.proxyHost = str;
            this.torrentOptions.proxyUsername = str2;
            this.torrentOptions.proxyPassword = str3;
            return this;
        }

        public Builder peerFingerprint(String str) {
            this.torrentOptions.peerFingerprint = str;
            this.torrentOptions.anonymousMode = false;
            return this;
        }

        public Builder anonymousMode(Boolean bool) {
            this.torrentOptions.anonymousMode = bool;
            if (this.torrentOptions.anonymousMode.booleanValue()) {
                this.torrentOptions.peerFingerprint = null;
            }
            return this;
        }

        public Builder autoDownload(Boolean bool) {
            this.torrentOptions.autoDownload = bool;
            return this;
        }

        public TorrentOptions build() {
            return this.torrentOptions;
        }
    }
}
