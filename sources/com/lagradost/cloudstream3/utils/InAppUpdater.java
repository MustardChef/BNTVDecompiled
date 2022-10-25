package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.preference.PreferenceManager;
import com.bongngotv2.R;
import com.facebook.share.internal.ShareConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.InAppUpdater;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.concurrent.Thread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: InAppUpdater.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater;", "", "()V", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class InAppUpdater {
    public static final Companion Companion = new Companion(null);
    private static final JsonMapper mapper = JsonMapper.builder().addModule(new KotlinModule(0, false, false, false, null, false, 63, null)).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).build();

    /* compiled from: InAppUpdater.kt */
    @Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0005\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u000eH\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u000eH\u0002J\f\u0010\u0014\u001a\u00020\u0012*\u00020\u000eH\u0002J\u0014\u0010\u0015\u001a\u00020\r*\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\rR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion;", "", "()V", "mapper", "Lcom/fasterxml/jackson/databind/json/JsonMapper;", "kotlin.jvm.PlatformType", "openApk", "", "context", "Landroid/content/Context;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "downloadUpdate", "", "Landroid/app/Activity;", "url", "", "getAppUpdate", "Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$Update;", "getPreReleaseUpdate", "getReleaseUpdate", "runAutoUpdate", "checkAutoUpdate", "GithubAsset", "GithubObject", "GithubRelease", "GithubTag", "Update", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runAutoUpdate$lambda-16$lambda-15$lambda-13  reason: not valid java name */
        public static final void m9003runAutoUpdate$lambda16$lambda15$lambda13(DialogInterface dialogInterface, int i) {
        }

        private Companion() {
        }

        /* compiled from: InAppUpdater.kt */
        @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubAsset;", "", "name", "", "size", "", "browser_download_url", FirebaseAnalytics.Param.CONTENT_TYPE, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getBrowser_download_url", "()Ljava/lang/String;", "getContent_type", "getName", "getSize", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes4.dex */
        public static final class GithubAsset {
            private final String browser_download_url;
            private final String content_type;
            private final String name;
            private final int size;

            public static /* synthetic */ GithubAsset copy$default(GithubAsset githubAsset, String str, int i, String str2, String str3, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = githubAsset.name;
                }
                if ((i2 & 2) != 0) {
                    i = githubAsset.size;
                }
                if ((i2 & 4) != 0) {
                    str2 = githubAsset.browser_download_url;
                }
                if ((i2 & 8) != 0) {
                    str3 = githubAsset.content_type;
                }
                return githubAsset.copy(str, i, str2, str3);
            }

            public final String component1() {
                return this.name;
            }

            public final int component2() {
                return this.size;
            }

            public final String component3() {
                return this.browser_download_url;
            }

            public final String component4() {
                return this.content_type;
            }

            public final GithubAsset copy(@JsonProperty("name") String name, @JsonProperty("size") int i, @JsonProperty("browser_download_url") String browser_download_url, @JsonProperty("content_type") String content_type) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(browser_download_url, "browser_download_url");
                Intrinsics.checkNotNullParameter(content_type, "content_type");
                return new GithubAsset(name, i, browser_download_url, content_type);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof GithubAsset) {
                    GithubAsset githubAsset = (GithubAsset) obj;
                    return Intrinsics.areEqual(this.name, githubAsset.name) && this.size == githubAsset.size && Intrinsics.areEqual(this.browser_download_url, githubAsset.browser_download_url) && Intrinsics.areEqual(this.content_type, githubAsset.content_type);
                }
                return false;
            }

            public int hashCode() {
                return (((((this.name.hashCode() * 31) + this.size) * 31) + this.browser_download_url.hashCode()) * 31) + this.content_type.hashCode();
            }

            public String toString() {
                return "GithubAsset(name=" + this.name + ", size=" + this.size + ", browser_download_url=" + this.browser_download_url + ", content_type=" + this.content_type + ')';
            }

            public GithubAsset(@JsonProperty("name") String name, @JsonProperty("size") int i, @JsonProperty("browser_download_url") String browser_download_url, @JsonProperty("content_type") String content_type) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(browser_download_url, "browser_download_url");
                Intrinsics.checkNotNullParameter(content_type, "content_type");
                this.name = name;
                this.size = i;
                this.browser_download_url = browser_download_url;
                this.content_type = content_type;
            }

            public final String getName() {
                return this.name;
            }

            public final int getSize() {
                return this.size;
            }

            public final String getBrowser_download_url() {
                return this.browser_download_url;
            }

            public final String getContent_type() {
                return this.content_type;
            }
        }

        /* compiled from: InAppUpdater.kt */
        @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubRelease;", "", "tag_name", "", "body", "assets", "", "Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubAsset;", "target_commitish", "prerelease", "", "node_id", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getAssets", "()Ljava/util/List;", "getBody", "()Ljava/lang/String;", "getNode_id", "getPrerelease", "()Z", "getTag_name", "getTarget_commitish", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes4.dex */
        public static final class GithubRelease {
            private final List<GithubAsset> assets;
            private final String body;
            private final String node_id;
            private final boolean prerelease;
            private final String tag_name;
            private final String target_commitish;

            public static /* synthetic */ GithubRelease copy$default(GithubRelease githubRelease, String str, String str2, List list, String str3, boolean z, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = githubRelease.tag_name;
                }
                if ((i & 2) != 0) {
                    str2 = githubRelease.body;
                }
                String str5 = str2;
                List<GithubAsset> list2 = list;
                if ((i & 4) != 0) {
                    list2 = githubRelease.assets;
                }
                List list3 = list2;
                if ((i & 8) != 0) {
                    str3 = githubRelease.target_commitish;
                }
                String str6 = str3;
                if ((i & 16) != 0) {
                    z = githubRelease.prerelease;
                }
                boolean z2 = z;
                if ((i & 32) != 0) {
                    str4 = githubRelease.node_id;
                }
                return githubRelease.copy(str, str5, list3, str6, z2, str4);
            }

            public final String component1() {
                return this.tag_name;
            }

            public final String component2() {
                return this.body;
            }

            public final List<GithubAsset> component3() {
                return this.assets;
            }

            public final String component4() {
                return this.target_commitish;
            }

            public final boolean component5() {
                return this.prerelease;
            }

            public final String component6() {
                return this.node_id;
            }

            public final GithubRelease copy(@JsonProperty("tag_name") String tag_name, @JsonProperty("body") String body, @JsonProperty("assets") List<GithubAsset> assets, @JsonProperty("target_commitish") String target_commitish, @JsonProperty("prerelease") boolean z, @JsonProperty("node_id") String node_id) {
                Intrinsics.checkNotNullParameter(tag_name, "tag_name");
                Intrinsics.checkNotNullParameter(body, "body");
                Intrinsics.checkNotNullParameter(assets, "assets");
                Intrinsics.checkNotNullParameter(target_commitish, "target_commitish");
                Intrinsics.checkNotNullParameter(node_id, "node_id");
                return new GithubRelease(tag_name, body, assets, target_commitish, z, node_id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof GithubRelease) {
                    GithubRelease githubRelease = (GithubRelease) obj;
                    return Intrinsics.areEqual(this.tag_name, githubRelease.tag_name) && Intrinsics.areEqual(this.body, githubRelease.body) && Intrinsics.areEqual(this.assets, githubRelease.assets) && Intrinsics.areEqual(this.target_commitish, githubRelease.target_commitish) && this.prerelease == githubRelease.prerelease && Intrinsics.areEqual(this.node_id, githubRelease.node_id);
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = ((((((this.tag_name.hashCode() * 31) + this.body.hashCode()) * 31) + this.assets.hashCode()) * 31) + this.target_commitish.hashCode()) * 31;
                boolean z = this.prerelease;
                int i = z;
                if (z != 0) {
                    i = 1;
                }
                return ((hashCode + i) * 31) + this.node_id.hashCode();
            }

            public String toString() {
                return "GithubRelease(tag_name=" + this.tag_name + ", body=" + this.body + ", assets=" + this.assets + ", target_commitish=" + this.target_commitish + ", prerelease=" + this.prerelease + ", node_id=" + this.node_id + ')';
            }

            public GithubRelease(@JsonProperty("tag_name") String tag_name, @JsonProperty("body") String body, @JsonProperty("assets") List<GithubAsset> assets, @JsonProperty("target_commitish") String target_commitish, @JsonProperty("prerelease") boolean z, @JsonProperty("node_id") String node_id) {
                Intrinsics.checkNotNullParameter(tag_name, "tag_name");
                Intrinsics.checkNotNullParameter(body, "body");
                Intrinsics.checkNotNullParameter(assets, "assets");
                Intrinsics.checkNotNullParameter(target_commitish, "target_commitish");
                Intrinsics.checkNotNullParameter(node_id, "node_id");
                this.tag_name = tag_name;
                this.body = body;
                this.assets = assets;
                this.target_commitish = target_commitish;
                this.prerelease = z;
                this.node_id = node_id;
            }

            public final String getTag_name() {
                return this.tag_name;
            }

            public final String getBody() {
                return this.body;
            }

            public final List<GithubAsset> getAssets() {
                return this.assets;
            }

            public final String getTarget_commitish() {
                return this.target_commitish;
            }

            public final boolean getPrerelease() {
                return this.prerelease;
            }

            public final String getNode_id() {
                return this.node_id;
            }
        }

        /* compiled from: InAppUpdater.kt */
        @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubObject;", "", "sha", "", "type", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSha", "()Ljava/lang/String;", "getType", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes4.dex */
        public static final class GithubObject {
            private final String sha;
            private final String type;
            private final String url;

            public static /* synthetic */ GithubObject copy$default(GithubObject githubObject, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = githubObject.sha;
                }
                if ((i & 2) != 0) {
                    str2 = githubObject.type;
                }
                if ((i & 4) != 0) {
                    str3 = githubObject.url;
                }
                return githubObject.copy(str, str2, str3);
            }

            public final String component1() {
                return this.sha;
            }

            public final String component2() {
                return this.type;
            }

            public final String component3() {
                return this.url;
            }

            public final GithubObject copy(@JsonProperty("sha") String sha, @JsonProperty("type") String type, @JsonProperty("url") String url) {
                Intrinsics.checkNotNullParameter(sha, "sha");
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(url, "url");
                return new GithubObject(sha, type, url);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof GithubObject) {
                    GithubObject githubObject = (GithubObject) obj;
                    return Intrinsics.areEqual(this.sha, githubObject.sha) && Intrinsics.areEqual(this.type, githubObject.type) && Intrinsics.areEqual(this.url, githubObject.url);
                }
                return false;
            }

            public int hashCode() {
                return (((this.sha.hashCode() * 31) + this.type.hashCode()) * 31) + this.url.hashCode();
            }

            public String toString() {
                return "GithubObject(sha=" + this.sha + ", type=" + this.type + ", url=" + this.url + ')';
            }

            public GithubObject(@JsonProperty("sha") String sha, @JsonProperty("type") String type, @JsonProperty("url") String url) {
                Intrinsics.checkNotNullParameter(sha, "sha");
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(url, "url");
                this.sha = sha;
                this.type = type;
                this.url = url;
            }

            public final String getSha() {
                return this.sha;
            }

            public final String getType() {
                return this.type;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        /* compiled from: InAppUpdater.kt */
        @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubTag;", "", "github_object", "Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubObject;", "(Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubObject;)V", "getGithub_object", "()Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$GithubObject;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes4.dex */
        public static final class GithubTag {
            private final GithubObject github_object;

            public static /* synthetic */ GithubTag copy$default(GithubTag githubTag, GithubObject githubObject, int i, Object obj) {
                if ((i & 1) != 0) {
                    githubObject = githubTag.github_object;
                }
                return githubTag.copy(githubObject);
            }

            public final GithubObject component1() {
                return this.github_object;
            }

            public final GithubTag copy(@JsonProperty("object") GithubObject github_object) {
                Intrinsics.checkNotNullParameter(github_object, "github_object");
                return new GithubTag(github_object);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof GithubTag) && Intrinsics.areEqual(this.github_object, ((GithubTag) obj).github_object);
            }

            public int hashCode() {
                return this.github_object.hashCode();
            }

            public String toString() {
                return "GithubTag(github_object=" + this.github_object + ')';
            }

            public GithubTag(@JsonProperty("object") GithubObject github_object) {
                Intrinsics.checkNotNullParameter(github_object, "github_object");
                this.github_object = github_object;
            }

            public final GithubObject getGithub_object() {
                return this.github_object;
            }
        }

        /* compiled from: InAppUpdater.kt */
        @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/InAppUpdater$Companion$Update;", "", "shouldUpdate", "", "updateURL", "", "updateVersion", "changelog", "updateNodeId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChangelog", "()Ljava/lang/String;", "getShouldUpdate", "()Z", "getUpdateNodeId", "getUpdateURL", "getUpdateVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes4.dex */
        public static final class Update {
            private final String changelog;
            private final boolean shouldUpdate;
            private final String updateNodeId;
            private final String updateURL;
            private final String updateVersion;

            public static /* synthetic */ Update copy$default(Update update, boolean z, String str, String str2, String str3, String str4, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = update.shouldUpdate;
                }
                if ((i & 2) != 0) {
                    str = update.updateURL;
                }
                String str5 = str;
                if ((i & 4) != 0) {
                    str2 = update.updateVersion;
                }
                String str6 = str2;
                if ((i & 8) != 0) {
                    str3 = update.changelog;
                }
                String str7 = str3;
                if ((i & 16) != 0) {
                    str4 = update.updateNodeId;
                }
                return update.copy(z, str5, str6, str7, str4);
            }

            public final boolean component1() {
                return this.shouldUpdate;
            }

            public final String component2() {
                return this.updateURL;
            }

            public final String component3() {
                return this.updateVersion;
            }

            public final String component4() {
                return this.changelog;
            }

            public final String component5() {
                return this.updateNodeId;
            }

            public final Update copy(@JsonProperty("shouldUpdate") boolean z, @JsonProperty("updateURL") String str, @JsonProperty("updateVersion") String str2, @JsonProperty("changelog") String str3, @JsonProperty("updateNodeId") String str4) {
                return new Update(z, str, str2, str3, str4);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Update) {
                    Update update = (Update) obj;
                    return this.shouldUpdate == update.shouldUpdate && Intrinsics.areEqual(this.updateURL, update.updateURL) && Intrinsics.areEqual(this.updateVersion, update.updateVersion) && Intrinsics.areEqual(this.changelog, update.changelog) && Intrinsics.areEqual(this.updateNodeId, update.updateNodeId);
                }
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v10 */
            /* JADX WARN: Type inference failed for: r0v11 */
            public int hashCode() {
                boolean z = this.shouldUpdate;
                ?? r0 = z;
                if (z) {
                    r0 = 1;
                }
                int i = r0 * 31;
                String str = this.updateURL;
                int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.updateVersion;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.changelog;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.updateNodeId;
                return hashCode3 + (str4 != null ? str4.hashCode() : 0);
            }

            public String toString() {
                return "Update(shouldUpdate=" + this.shouldUpdate + ", updateURL=" + this.updateURL + ", updateVersion=" + this.updateVersion + ", changelog=" + this.changelog + ", updateNodeId=" + this.updateNodeId + ')';
            }

            public Update(@JsonProperty("shouldUpdate") boolean z, @JsonProperty("updateURL") String str, @JsonProperty("updateVersion") String str2, @JsonProperty("changelog") String str3, @JsonProperty("updateNodeId") String str4) {
                this.shouldUpdate = z;
                this.updateURL = str;
                this.updateVersion = str2;
                this.changelog = str3;
                this.updateNodeId = str4;
            }

            public final boolean getShouldUpdate() {
                return this.shouldUpdate;
            }

            public final String getUpdateURL() {
                return this.updateURL;
            }

            public final String getUpdateVersion() {
                return this.updateVersion;
            }

            public final String getChangelog() {
                return this.changelog;
            }

            public final String getUpdateNodeId() {
                return this.updateNodeId;
            }
        }

        private final Update getAppUpdate(Activity activity) {
            Update releaseUpdate;
            try {
                if (PreferenceManager.getDefaultSharedPreferences(activity).getBoolean(activity.getString(R.string.prerelease_update_key), false)) {
                    releaseUpdate = getPreReleaseUpdate(activity);
                } else {
                    releaseUpdate = getReleaseUpdate(activity);
                }
                return releaseUpdate;
            } catch (Exception e) {
                System.out.println(e);
                return new Update(false, null, null, null, null);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0167  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final com.lagradost.cloudstream3.utils.InAppUpdater.Companion.Update getReleaseUpdate(android.app.Activity r17) {
            /*
                Method dump skipped, instructions count: 383
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.InAppUpdater.Companion.getReleaseUpdate(android.app.Activity):com.lagradost.cloudstream3.utils.InAppUpdater$Companion$Update");
        }

        private final Update getPreReleaseUpdate(Activity activity) {
            Object runBlocking$default;
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new InAppUpdater$Companion$getPreReleaseUpdate$1(activity, null), 1, null);
            return (Update) runBlocking$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean downloadUpdate(final Activity activity, String str) {
            final long j;
            Object systemService = ContextCompat.getSystemService(activity, DownloadManager.class);
            Intrinsics.checkNotNull(systemService);
            final DownloadManager downloadManager = (DownloadManager) systemService;
            try {
                j = downloadManager.enqueue(new DownloadManager.Request(Uri.parse(str)).setMimeType("application/vnd.android.package-archive").setTitle("BongNgoTV Update").setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, activity.getString(R.string.app_name) + ".apk").setAllowedNetworkTypes(3).setAllowedOverRoaming(true).setNotificationVisibility(1));
            } catch (Exception e) {
                ArchComponentExt.logError(e);
                CommonActivity.INSTANCE.showToast(activity, R.string.storage_error, 0);
                j = -1;
            }
            if (j == -1) {
                return true;
            }
            activity.registerReceiver(new BroadcastReceiver() { // from class: com.lagradost.cloudstream3.utils.InAppUpdater$Companion$downloadUpdate$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    long j2;
                    try {
                        if (intent != null) {
                            j2 = intent.getLongExtra("extra_download_id", j);
                        } else {
                            j2 = j;
                        }
                        DownloadManager.Query query = new DownloadManager.Query();
                        query.setFilterById(j2);
                        Cursor query2 = downloadManager.query(query);
                        if (query2.moveToFirst() && 8 == query2.getInt(query2.getColumnIndex("status"))) {
                            query2.getColumnIndex("mediaprovider_uri");
                            Uri uri = Uri.parse(query2.getString(query2.getColumnIndex("local_uri")));
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            InAppUpdater.Companion.openApk(activity, uri);
                        }
                    } catch (Exception e2) {
                        ArchComponentExt.logError(e2);
                    }
                }
            }, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            return true;
        }

        public final void openApk(Context context, Uri uri) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            try {
                String path = uri.getPath();
                if (path != null) {
                    Uri uriForFile = FileProvider.getUriForFile(context, "com.bongngotv2.provider", new File(path));
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(1);
                    intent.addFlags(67108864);
                    intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
                    intent.setData(uriForFile);
                    context.startActivity(intent);
                }
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }

        public static /* synthetic */ boolean runAutoUpdate$default(Companion companion, Activity activity, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = true;
            }
            return companion.runAutoUpdate(activity, z);
        }

        public final boolean runAutoUpdate(final Activity activity, final boolean z) {
            Intrinsics.checkNotNullParameter(activity, "<this>");
            final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
            if (!z || defaultSharedPreferences.getBoolean(activity.getString(R.string.auto_update_key), true)) {
                final Update appUpdate = getAppUpdate(activity);
                if (!appUpdate.getShouldUpdate() || appUpdate.getUpdateURL() == null) {
                    return false;
                }
                if (StringsKt.equals$default(appUpdate.getUpdateNodeId(), defaultSharedPreferences.getString(activity.getString(R.string.skip_update_key), ""), false, 2, null)) {
                    return false;
                }
                activity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$InAppUpdater$Companion$pNdtEfQm-ZeoE1acYRtPjROPZtA
                    @Override // java.lang.Runnable
                    public final void run() {
                        InAppUpdater.Companion.m9001runAutoUpdate$lambda16(activity, appUpdate, z, defaultSharedPreferences);
                    }
                });
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runAutoUpdate$lambda-16  reason: not valid java name */
        public static final void m9001runAutoUpdate$lambda16(final Activity this_runAutoUpdate, final Update update, boolean z, final SharedPreferences sharedPreferences) {
            Intrinsics.checkNotNullParameter(this_runAutoUpdate, "$this_runAutoUpdate");
            Intrinsics.checkNotNullParameter(update, "$update");
            try {
                String packageName = this_runAutoUpdate.getPackageName();
                PackageInfo packageInfo = packageName != null ? this_runAutoUpdate.getPackageManager().getPackageInfo(packageName, 0) : null;
                AlertDialog.Builder builder = new AlertDialog.Builder(this_runAutoUpdate);
                String string = this_runAutoUpdate.getString(R.string.new_update_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.new_update_format)");
                Object[] objArr = new Object[2];
                objArr[0] = packageInfo != null ? packageInfo.versionName : null;
                objArr[1] = update.getUpdateVersion();
                String format = String.format(string, Arrays.copyOf(objArr, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                builder.setTitle(format);
                builder.setMessage(String.valueOf(update.getChangelog()));
                builder.setPositiveButton(R.string.update, new DialogInterface.OnClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$InAppUpdater$Companion$CPVgpZg3x-LdaMJZcLdUFDJS4Eo
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InAppUpdater.Companion.m9002runAutoUpdate$lambda16$lambda15$lambda12(this_runAutoUpdate, this_runAutoUpdate, update, dialogInterface, i);
                    }
                });
                builder.setNegativeButton(R.string.cancel, $$Lambda$InAppUpdater$Companion$sR65Wcj52hCgBgmmIZES0Av70.INSTANCE);
                if (z) {
                    builder.setNeutralButton(R.string.skip_update, new DialogInterface.OnClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$InAppUpdater$Companion$gSM6YJrxozwDO8gk0mbCkbW3D_o
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            InAppUpdater.Companion.m9004runAutoUpdate$lambda16$lambda15$lambda14(sharedPreferences, this_runAutoUpdate, update, dialogInterface, i);
                        }
                    });
                }
                builder.show();
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runAutoUpdate$lambda-16$lambda-15$lambda-12  reason: not valid java name */
        public static final void m9002runAutoUpdate$lambda16$lambda15$lambda12(Activity context, Activity this_runAutoUpdate, Update update, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(this_runAutoUpdate, "$this_runAutoUpdate");
            Intrinsics.checkNotNullParameter(update, "$update");
            CommonActivity.INSTANCE.showToast(context, R.string.download_started, 1);
            Thread.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new InAppUpdater$Companion$runAutoUpdate$1$1$1$1(this_runAutoUpdate, context, update));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: runAutoUpdate$lambda-16$lambda-15$lambda-14  reason: not valid java name */
        public static final void m9004runAutoUpdate$lambda16$lambda15$lambda14(SharedPreferences sharedPreferences, Activity this_runAutoUpdate, Update update, DialogInterface dialogInterface, int i) {
            Intrinsics.checkNotNullParameter(this_runAutoUpdate, "$this_runAutoUpdate");
            Intrinsics.checkNotNullParameter(update, "$update");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = this_runAutoUpdate.getString(R.string.skip_update_key);
            String updateNodeId = update.getUpdateNodeId();
            if (updateNodeId == null) {
                updateNodeId = "";
            }
            edit.putString(string, updateNodeId).apply();
        }
    }
}
