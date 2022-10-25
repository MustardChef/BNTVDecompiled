package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.announce_endpoint;

/* loaded from: classes2.dex */
public class AnnounceEndpoint {
    protected int fails;
    protected boolean isWorking;
    protected ErrorCode lastError;
    protected String localEndpoint;
    protected String message;
    protected long minAnnounce;
    protected long nextAnnounce;
    protected int scrapeComplete;
    protected int scrapeDownloaded;
    protected int scrapeIncomplete;
    protected boolean updating;

    public AnnounceEndpoint(announce_endpoint announce_endpointVar) {
        init(announce_endpointVar);
    }

    public String message() {
        return this.message;
    }

    public ErrorCode lastError() {
        return this.lastError;
    }

    public String localEndpoint() {
        return this.localEndpoint;
    }

    public long nextAnnounce() {
        return this.nextAnnounce;
    }

    public long minAnnounce() {
        return this.minAnnounce;
    }

    public int scrapeIncomplete() {
        return this.scrapeIncomplete;
    }

    public int scrapeComplete() {
        return this.scrapeComplete;
    }

    public int scrapeDownloaded() {
        return this.scrapeDownloaded;
    }

    public int fails() {
        return this.fails;
    }

    public boolean updating() {
        return this.updating;
    }

    public boolean isWorking() {
        return this.isWorking;
    }

    protected void init(announce_endpoint announce_endpointVar) {
        this.message = Vectors.byte_vector2ascii(announce_endpointVar.get_message());
        this.lastError = new ErrorCode(announce_endpointVar.getLast_error());
        this.localEndpoint = new TcpEndpoint(announce_endpointVar.getLocal_endpoint()).toString();
        this.nextAnnounce = announce_endpointVar.get_next_announce();
        this.minAnnounce = announce_endpointVar.get_min_announce();
        this.scrapeIncomplete = announce_endpointVar.getScrape_incomplete();
        this.scrapeComplete = announce_endpointVar.getScrape_complete();
        this.scrapeDownloaded = announce_endpointVar.getScrape_downloaded();
        this.fails = announce_endpointVar.getFails();
        this.updating = announce_endpointVar.getUpdating();
        this.isWorking = announce_endpointVar.is_working();
    }
}
