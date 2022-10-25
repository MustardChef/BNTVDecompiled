package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.peer_info;

/* loaded from: classes2.dex */
public class PeerInfo {
    protected String client;
    protected ConnectionType connectionType;
    protected int downSpeed;
    protected int flags;

    /* renamed from: ip */
    protected String f2820ip;
    protected float progress;
    protected int progressPpm;
    protected byte source;
    protected long totalDownload;
    protected long totalUpload;
    protected int upSpeed;

    public PeerInfo(peer_info peer_infoVar) {
        init(peer_infoVar);
    }

    public String client() {
        return this.client;
    }

    public long totalDownload() {
        return this.totalDownload;
    }

    public long totalUpload() {
        return this.totalUpload;
    }

    public int flags() {
        return this.flags;
    }

    public byte source() {
        return this.source;
    }

    public int upSpeed() {
        return this.upSpeed;
    }

    public int downSpeed() {
        return this.downSpeed;
    }

    public ConnectionType connectionType() {
        return this.connectionType;
    }

    public float progress() {
        return this.progress;
    }

    public int progressPpm() {
        return this.progressPpm;
    }

    /* renamed from: ip */
    public String m6060ip() {
        return this.f2820ip;
    }

    protected void init(peer_info peer_infoVar) {
        this.client = Vectors.byte_vector2utf8(peer_infoVar.get_client());
        this.totalDownload = peer_infoVar.getTotal_download();
        this.totalUpload = peer_infoVar.getTotal_upload();
        this.flags = peer_infoVar.get_flags();
        this.source = peer_infoVar.get_source();
        this.upSpeed = peer_infoVar.getUp_speed();
        this.downSpeed = peer_infoVar.getDown_speed();
        this.connectionType = ConnectionType.fromSwig(peer_infoVar.getConnection_type());
        this.progress = peer_infoVar.getProgress();
        this.progressPpm = peer_infoVar.getProgress_ppm();
        this.f2820ip = new TcpEndpoint(peer_infoVar.getIp()).toString();
    }

    /* loaded from: classes2.dex */
    public enum ConnectionType {
        STANDARD_BITTORRENT(peer_info.connection_type_t.standard_bittorrent.swigValue()),
        WEB_SEED(peer_info.connection_type_t.web_seed.swigValue()),
        HTTP_SEED(peer_info.connection_type_t.http_seed.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        ConnectionType(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static ConnectionType fromSwig(int i) {
            ConnectionType[] connectionTypeArr;
            for (ConnectionType connectionType : (ConnectionType[]) ConnectionType.class.getEnumConstants()) {
                if (connectionType.swig() == i) {
                    return connectionType;
                }
            }
            return UNKNOWN;
        }
    }
}
