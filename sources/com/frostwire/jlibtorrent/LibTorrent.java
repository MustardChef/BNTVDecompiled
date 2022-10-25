package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.libtorrent;
import com.frostwire.jlibtorrent.swig.libtorrent_jni;
import com.frostwire.jlibtorrent.swig.stats_metric_vector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class LibTorrent {
    public static String revision() {
        return "b5bf6c3260bd726b0181671625c007be5ad49845";
    }

    private LibTorrent() {
    }

    public static int versionNum() {
        return libtorrent.LIBTORRENT_VERSION_NUM;
    }

    public static String version() {
        return libtorrent.version();
    }

    public static int boostVersionNum() {
        return libtorrent.boost_version();
    }

    public static String boostVersion() {
        return libtorrent.boost_lib_version();
    }

    public static int opensslVersionNum() {
        return libtorrent.openssl_version_number();
    }

    public static String opensslVersion() {
        return libtorrent.openssl_version_text();
    }

    public static String jlibtorrentVersion() {
        return libtorrent_jni.jlibtorrentVersion();
    }

    public static List<StatsMetric> sessionStatsMetrics() {
        stats_metric_vector session_stats_metrics = libtorrent.session_stats_metrics();
        int size = (int) session_stats_metrics.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new StatsMetric(session_stats_metrics.get(i)));
        }
        return arrayList;
    }

    public static int findMetricIdx(String str) {
        return libtorrent.find_metric_idx_s(str);
    }

    public static boolean hasArmNeonSupport() {
        return libtorrent.arm_neon_support();
    }
}
