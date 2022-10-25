package com.lagradost.cloudstream3.services;

import android.app.IntentService;
import android.content.Intent;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import kotlin.Metadata;
import kotlin.Tuples;

/* compiled from: VideoDownloadService.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/services/VideoDownloadService;", "Landroid/app/IntentService;", "()V", "onHandleIntent", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class VideoDownloadService extends IntentService {
    public VideoDownloadService() {
        super("VideoDownloadService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        VideoDownloadManager.DownloadActionType downloadActionType;
        if (intent != null) {
            int intExtra = intent.getIntExtra("id", -1);
            String stringExtra = intent.getStringExtra("type");
            if (intExtra == -1 || stringExtra == null) {
                return;
            }
            int hashCode = stringExtra.hashCode();
            if (hashCode != -934426579) {
                if (hashCode != 3540994) {
                    if (hashCode != 106440182 || !stringExtra.equals("pause")) {
                        return;
                    }
                    downloadActionType = VideoDownloadManager.DownloadActionType.Pause;
                } else if (!stringExtra.equals("stop")) {
                    return;
                } else {
                    downloadActionType = VideoDownloadManager.DownloadActionType.Stop;
                }
            } else if (!stringExtra.equals("resume")) {
                return;
            } else {
                downloadActionType = VideoDownloadManager.DownloadActionType.Resume;
            }
            VideoDownloadManager.INSTANCE.getDownloadEvent().invoke(new Tuples<>(Integer.valueOf(intExtra), downloadActionType));
        }
    }
}
