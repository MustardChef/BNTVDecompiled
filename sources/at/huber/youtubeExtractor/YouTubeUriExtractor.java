package at.huber.youtubeExtractor;

import android.content.Context;
import android.util.SparseArray;

@Deprecated
/* loaded from: classes.dex */
public abstract class YouTubeUriExtractor extends YouTubeExtractor {
    public abstract void onUrisAvailable(String str, String str2, SparseArray<YtFile> sparseArray);

    public YouTubeUriExtractor(Context context) {
        super(context);
    }

    @Override // at.huber.youtubeExtractor.YouTubeExtractor
    protected void onExtractionComplete(SparseArray<YtFile> sparseArray, VideoMeta videoMeta) {
        onUrisAvailable(videoMeta.getVideoId(), videoMeta.getTitle(), sparseArray);
    }
}
