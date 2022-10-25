package at.huber.youtubeExtractor;

/* loaded from: classes.dex */
public class Format {
    private ACodec aCodec;
    private final int audioBitrate;
    private final String ext;
    private final int fps;
    private final int height;
    private final boolean isDashContainer;
    private final boolean isHlsContent;
    private final int itag;
    private VCodec vCodec;

    /* loaded from: classes.dex */
    public enum ACodec {
        MP3,
        AAC,
        VORBIS,
        OPUS,
        NONE
    }

    /* loaded from: classes.dex */
    public enum VCodec {
        H263,
        H264,
        MPEG4,
        VP8,
        VP9,
        NONE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, ACodec aCodec, boolean z) {
        this.itag = i;
        this.ext = str;
        this.height = i2;
        this.fps = 30;
        this.audioBitrate = -1;
        this.isDashContainer = z;
        this.isHlsContent = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, VCodec vCodec, ACodec aCodec, int i2, boolean z) {
        this.itag = i;
        this.ext = str;
        this.height = -1;
        this.fps = 30;
        this.audioBitrate = i2;
        this.isDashContainer = z;
        this.isHlsContent = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, ACodec aCodec, int i3, boolean z) {
        this.itag = i;
        this.ext = str;
        this.height = i2;
        this.fps = 30;
        this.audioBitrate = i3;
        this.isDashContainer = z;
        this.isHlsContent = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, ACodec aCodec, int i3, boolean z, boolean z2) {
        this.itag = i;
        this.ext = str;
        this.height = i2;
        this.fps = 30;
        this.audioBitrate = i3;
        this.isDashContainer = z;
        this.isHlsContent = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format(int i, String str, int i2, VCodec vCodec, int i3, ACodec aCodec, boolean z) {
        this.itag = i;
        this.ext = str;
        this.height = i2;
        this.audioBitrate = -1;
        this.fps = i3;
        this.isDashContainer = z;
        this.isHlsContent = false;
    }

    public int getFps() {
        return this.fps;
    }

    public int getAudioBitrate() {
        return this.audioBitrate;
    }

    public int getItag() {
        return this.itag;
    }

    public String getExt() {
        return this.ext;
    }

    public boolean isDashContainer() {
        return this.isDashContainer;
    }

    public ACodec getAudioCodec() {
        return this.aCodec;
    }

    public VCodec getVideoCodec() {
        return this.vCodec;
    }

    public boolean isHlsContent() {
        return this.isHlsContent;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        if (this.itag == format.itag && this.height == format.height && this.fps == format.fps && this.audioBitrate == format.audioBitrate && this.isDashContainer == format.isDashContainer && this.isHlsContent == format.isHlsContent) {
            String str = this.ext;
            if (str == null ? format.ext == null : str.equals(format.ext)) {
                return this.vCodec == format.vCodec && this.aCodec == format.aCodec;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.itag * 31;
        String str = this.ext;
        int hashCode = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.height) * 31) + this.fps) * 31;
        VCodec vCodec = this.vCodec;
        int hashCode2 = (hashCode + (vCodec != null ? vCodec.hashCode() : 0)) * 31;
        ACodec aCodec = this.aCodec;
        return ((((((hashCode2 + (aCodec != null ? aCodec.hashCode() : 0)) * 31) + this.audioBitrate) * 31) + (this.isDashContainer ? 1 : 0)) * 31) + (this.isHlsContent ? 1 : 0);
    }

    public String toString() {
        return "Format{itag=" + this.itag + ", ext='" + this.ext + "', height=" + this.height + ", fps=" + this.fps + ", vCodec=" + this.vCodec + ", aCodec=" + this.aCodec + ", audioBitrate=" + this.audioBitrate + ", isDashContainer=" + this.isDashContainer + ", isHlsContent=" + this.isHlsContent + '}';
    }
}
