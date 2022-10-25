package at.huber.youtubeExtractor;

/* loaded from: classes.dex */
public class YtFile {
    private final Format format;
    private final String url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YtFile(Format format, String str) {
        this.format = format;
        this.url = str;
    }

    public String getUrl() {
        return this.url;
    }

    public Format getFormat() {
        return this.format;
    }

    @Deprecated
    public Format getMeta() {
        return this.format;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        YtFile ytFile = (YtFile) obj;
        Format format = this.format;
        if (format == null ? ytFile.format == null : format.equals(ytFile.format)) {
            String str = this.url;
            String str2 = ytFile.url;
            return str != null ? str.equals(str2) : str2 == null;
        }
        return false;
    }

    public int hashCode() {
        Format format = this.format;
        int hashCode = (format != null ? format.hashCode() : 0) * 31;
        String str = this.url;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "YtFile{format=" + this.format + ", url='" + this.url + "'}";
    }
}
