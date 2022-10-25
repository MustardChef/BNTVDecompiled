package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.offline.-$$Lambda$DownloadManager$InternalHandler$OH12G4NteYquO91-EYFUVBFeiK8 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C3420xdeefc637 implements Comparator {
    public static final /* synthetic */ C3420xdeefc637 INSTANCE = new C3420xdeefc637();

    private /* synthetic */ C3420xdeefc637() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareStartTimes;
        compareStartTimes = DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
        return compareStartTimes;
    }
}
