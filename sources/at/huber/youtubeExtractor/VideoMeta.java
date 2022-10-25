package at.huber.youtubeExtractor;

/* loaded from: classes.dex */
public class VideoMeta {
    private static final String IMAGE_BASE_URL = "http://i.ytimg.com/vi/";
    private final String author;
    private final String channelId;
    private final boolean isLiveStream;
    private final String shortDescript;
    private final String title;
    private final String videoId;
    private final long videoLength;
    private final long viewCount;

    /* JADX INFO: Access modifiers changed from: protected */
    public VideoMeta(String str, String str2, String str3, String str4, long j, long j2, boolean z, String str5) {
        this.videoId = str;
        this.title = str2;
        this.author = str3;
        this.channelId = str4;
        this.videoLength = j;
        this.viewCount = j2;
        this.isLiveStream = z;
        this.shortDescript = str5;
    }

    public String getThumbUrl() {
        return IMAGE_BASE_URL + this.videoId + "/default.jpg";
    }

    public String getMqImageUrl() {
        return IMAGE_BASE_URL + this.videoId + "/mqdefault.jpg";
    }

    public String getHqImageUrl() {
        return IMAGE_BASE_URL + this.videoId + "/hqdefault.jpg";
    }

    public String getSdImageUrl() {
        return IMAGE_BASE_URL + this.videoId + "/sddefault.jpg";
    }

    public String getMaxResImageUrl() {
        return IMAGE_BASE_URL + this.videoId + "/maxresdefault.jpg";
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public boolean isLiveStream() {
        return this.isLiveStream;
    }

    public long getVideoLength() {
        return this.videoLength;
    }

    public long getViewCount() {
        return this.viewCount;
    }

    public String getShortDescription() {
        return this.shortDescript;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VideoMeta videoMeta = (VideoMeta) obj;
        if (this.videoLength == videoMeta.videoLength && this.viewCount == videoMeta.viewCount && this.isLiveStream == videoMeta.isLiveStream) {
            String str = this.videoId;
            if (str == null ? videoMeta.videoId == null : str.equals(videoMeta.videoId)) {
                String str2 = this.title;
                if (str2 == null ? videoMeta.title == null : str2.equals(videoMeta.title)) {
                    String str3 = this.author;
                    if (str3 == null ? videoMeta.author == null : str3.equals(videoMeta.author)) {
                        String str4 = this.channelId;
                        String str5 = videoMeta.channelId;
                        return str4 != null ? str4.equals(str5) : str5 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.videoId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.author;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.channelId;
        int hashCode4 = str4 != null ? str4.hashCode() : 0;
        long j = this.videoLength;
        long j2 = this.viewCount;
        return ((((((hashCode3 + hashCode4) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.isLiveStream ? 1 : 0);
    }

    public String toString() {
        return "VideoMeta{videoId='" + this.videoId + "', title='" + this.title + "', author='" + this.author + "', channelId='" + this.channelId + "', videoLength=" + this.videoLength + ", viewCount=" + this.viewCount + ", isLiveStream=" + this.isLiveStream + '}';
    }
}
