package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.hippo.unifile.UniFile;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackupUtils.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u00020\f*\u00020\rJ\"\u0010\u000e\u001a\u00020\f*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J2\u0010\u0015\u001a\u00020\f\"\u0004\b\u0000\u0010\u0016*\u00020\u000f2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u0016\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0013H\u0002J\n\u0010\u001a\u001a\u00020\f*\u00020\rJ\n\u0010\u001b\u001a\u00020\f*\u00020\rR(\u0010\u0003\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/BackupUtils;", "", "()V", "restoreFileSelector", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "getRestoreFileSelector", "()Landroidx/activity/result/ActivityResultLauncher;", "setRestoreFileSelector", "(Landroidx/activity/result/ActivityResultLauncher;)V", "backup", "", "Landroidx/fragment/app/FragmentActivity;", "restore", "Landroid/content/Context;", "backupFile", "Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupFile;", "restoreSettings", "", "restoreDataStore", "restoreMap", ExifInterface.GPS_DIRECTION_TRUE, "map", "", "isEditingAppSettings", "restorePrompt", "setUpBackup", "BackupFile", "BackupVars", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class BackupUtils {
    public static final BackupUtils INSTANCE = new BackupUtils();
    private static ActivityResultLauncher<String[]> restoreFileSelector;

    private BackupUtils() {
    }

    public final ActivityResultLauncher<String[]> getRestoreFileSelector() {
        return restoreFileSelector;
    }

    public final void setRestoreFileSelector(ActivityResultLauncher<String[]> activityResultLauncher) {
        restoreFileSelector = activityResultLauncher;
    }

    /* compiled from: BackupUtils.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0016\b\u0001\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\u0016\b\u0001\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0001\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\u0016\b\u0001\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\u001e\b\u0001\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0018\u00010\u0003HÆ\u0003J¡\u0001\u0010\u001d\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0003\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0003\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\u0016\b\u0003\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u00032\u001e\b\u0003\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R'\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupVars;", "", "_Bool", "", "", "", "_Int", "", "_String", "_Float", "", "_Long", "", "_StringSet", "", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "get_Bool", "()Ljava/util/Map;", "get_Float", "get_Int", "get_Long", "get_String", "get_StringSet", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class BackupVars {
        private final Map<String, Boolean> _Bool;
        private final Map<String, Float> _Float;
        private final Map<String, Integer> _Int;
        private final Map<String, Long> _Long;
        private final Map<String, String> _String;
        private final Map<String, Set<String>> _StringSet;

        public static /* synthetic */ BackupVars copy$default(BackupVars backupVars, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, int i, Object obj) {
            Map<String, Boolean> map7 = map;
            if ((i & 1) != 0) {
                map7 = backupVars._Bool;
            }
            Map<String, Integer> map8 = map2;
            if ((i & 2) != 0) {
                map8 = backupVars._Int;
            }
            Map map9 = map8;
            Map<String, String> map10 = map3;
            if ((i & 4) != 0) {
                map10 = backupVars._String;
            }
            Map map11 = map10;
            Map<String, Float> map12 = map4;
            if ((i & 8) != 0) {
                map12 = backupVars._Float;
            }
            Map map13 = map12;
            Map<String, Long> map14 = map5;
            if ((i & 16) != 0) {
                map14 = backupVars._Long;
            }
            Map map15 = map14;
            Map<String, Set<String>> map16 = map6;
            if ((i & 32) != 0) {
                map16 = backupVars._StringSet;
            }
            return backupVars.copy(map7, map9, map11, map13, map15, map16);
        }

        public final Map<String, Boolean> component1() {
            return this._Bool;
        }

        public final Map<String, Integer> component2() {
            return this._Int;
        }

        public final Map<String, String> component3() {
            return this._String;
        }

        public final Map<String, Float> component4() {
            return this._Float;
        }

        public final Map<String, Long> component5() {
            return this._Long;
        }

        public final Map<String, Set<String>> component6() {
            return this._StringSet;
        }

        public final BackupVars copy(@JsonProperty("_Bool") Map<String, Boolean> map, @JsonProperty("_Int") Map<String, Integer> map2, @JsonProperty("_String") Map<String, String> map3, @JsonProperty("_Float") Map<String, Float> map4, @JsonProperty("_Long") Map<String, Long> map5, @JsonProperty("_StringSet") Map<String, ? extends Set<String>> map6) {
            return new BackupVars(map, map2, map3, map4, map5, map6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BackupVars) {
                BackupVars backupVars = (BackupVars) obj;
                return Intrinsics.areEqual(this._Bool, backupVars._Bool) && Intrinsics.areEqual(this._Int, backupVars._Int) && Intrinsics.areEqual(this._String, backupVars._String) && Intrinsics.areEqual(this._Float, backupVars._Float) && Intrinsics.areEqual(this._Long, backupVars._Long) && Intrinsics.areEqual(this._StringSet, backupVars._StringSet);
            }
            return false;
        }

        public int hashCode() {
            Map<String, Boolean> map = this._Bool;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            Map<String, Integer> map2 = this._Int;
            int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
            Map<String, String> map3 = this._String;
            int hashCode3 = (hashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31;
            Map<String, Float> map4 = this._Float;
            int hashCode4 = (hashCode3 + (map4 == null ? 0 : map4.hashCode())) * 31;
            Map<String, Long> map5 = this._Long;
            int hashCode5 = (hashCode4 + (map5 == null ? 0 : map5.hashCode())) * 31;
            Map<String, Set<String>> map6 = this._StringSet;
            return hashCode5 + (map6 != null ? map6.hashCode() : 0);
        }

        public String toString() {
            return "BackupVars(_Bool=" + this._Bool + ", _Int=" + this._Int + ", _String=" + this._String + ", _Float=" + this._Float + ", _Long=" + this._Long + ", _StringSet=" + this._StringSet + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BackupVars(@JsonProperty("_Bool") Map<String, Boolean> map, @JsonProperty("_Int") Map<String, Integer> map2, @JsonProperty("_String") Map<String, String> map3, @JsonProperty("_Float") Map<String, Float> map4, @JsonProperty("_Long") Map<String, Long> map5, @JsonProperty("_StringSet") Map<String, ? extends Set<String>> map6) {
            this._Bool = map;
            this._Int = map2;
            this._String = map3;
            this._Float = map4;
            this._Long = map5;
            this._StringSet = map6;
        }

        public final Map<String, Boolean> get_Bool() {
            return this._Bool;
        }

        public final Map<String, Integer> get_Int() {
            return this._Int;
        }

        public final Map<String, String> get_String() {
            return this._String;
        }

        public final Map<String, Float> get_Float() {
            return this._Float;
        }

        public final Map<String, Long> get_Long() {
            return this._Long;
        }

        public final Map<String, Set<String>> get_StringSet() {
            return this._StringSet;
        }
    }

    /* compiled from: BackupUtils.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupFile;", "", "datastore", "Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupVars;", "settings", "(Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupVars;Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupVars;)V", "getDatastore", "()Lcom/lagradost/cloudstream3/utils/BackupUtils$BackupVars;", "getSettings", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class BackupFile {
        private final BackupVars datastore;
        private final BackupVars settings;

        public static /* synthetic */ BackupFile copy$default(BackupFile backupFile, BackupVars backupVars, BackupVars backupVars2, int i, Object obj) {
            if ((i & 1) != 0) {
                backupVars = backupFile.datastore;
            }
            if ((i & 2) != 0) {
                backupVars2 = backupFile.settings;
            }
            return backupFile.copy(backupVars, backupVars2);
        }

        public final BackupVars component1() {
            return this.datastore;
        }

        public final BackupVars component2() {
            return this.settings;
        }

        public final BackupFile copy(@JsonProperty("datastore") BackupVars datastore, @JsonProperty("settings") BackupVars settings) {
            Intrinsics.checkNotNullParameter(datastore, "datastore");
            Intrinsics.checkNotNullParameter(settings, "settings");
            return new BackupFile(datastore, settings);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof BackupFile) {
                BackupFile backupFile = (BackupFile) obj;
                return Intrinsics.areEqual(this.datastore, backupFile.datastore) && Intrinsics.areEqual(this.settings, backupFile.settings);
            }
            return false;
        }

        public int hashCode() {
            return (this.datastore.hashCode() * 31) + this.settings.hashCode();
        }

        public String toString() {
            return "BackupFile(datastore=" + this.datastore + ", settings=" + this.settings + ')';
        }

        public BackupFile(@JsonProperty("datastore") BackupVars datastore, @JsonProperty("settings") BackupVars settings) {
            Intrinsics.checkNotNullParameter(datastore, "datastore");
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.datastore = datastore;
            this.settings = settings;
        }

        public final BackupVars getDatastore() {
            return this.datastore;
        }

        public final BackupVars getSettings() {
            return this.settings;
        }
    }

    public final void backup(FragmentActivity fragmentActivity) {
        OutputStream openOutputStream;
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        try {
            if (UIHelper.INSTANCE.checkWrite(fragmentActivity)) {
                UniFile first = VideoDownloadManager.INSTANCE.getBasePath(fragmentActivity).getFirst();
                String str = "CS3_Backup_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date(System.currentTimeMillis()));
                Map<String, ?> allData = DataStore.INSTANCE.getSharedPrefs(fragmentActivity).getAll();
                Map<String, ?> allSettings = DataStore.INSTANCE.getDefaultSharedPrefs(fragmentActivity).getAll();
                Intrinsics.checkNotNullExpressionValue(allData, "allData");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ?> entry : allData.entrySet()) {
                    if (entry.getValue() instanceof Boolean) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap2 = linkedHashMap instanceof Map ? linkedHashMap : null;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry2 : allData.entrySet()) {
                    if (entry2.getValue() instanceof Integer) {
                        linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                    }
                }
                LinkedHashMap linkedHashMap4 = linkedHashMap3 instanceof Map ? linkedHashMap3 : null;
                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry3 : allData.entrySet()) {
                    if (entry3.getValue() instanceof String) {
                        linkedHashMap5.put(entry3.getKey(), entry3.getValue());
                    }
                }
                LinkedHashMap linkedHashMap6 = linkedHashMap5 instanceof Map ? linkedHashMap5 : null;
                LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry4 : allData.entrySet()) {
                    if (entry4.getValue() instanceof Float) {
                        linkedHashMap7.put(entry4.getKey(), entry4.getValue());
                    }
                }
                LinkedHashMap linkedHashMap8 = linkedHashMap7 instanceof Map ? linkedHashMap7 : null;
                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry5 : allData.entrySet()) {
                    if (entry5.getValue() instanceof Long) {
                        linkedHashMap9.put(entry5.getKey(), entry5.getValue());
                    }
                }
                LinkedHashMap linkedHashMap10 = linkedHashMap9 instanceof Map ? linkedHashMap9 : null;
                LinkedHashMap linkedHashMap11 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry6 : allData.entrySet()) {
                    Object value = entry6.getValue();
                    if ((value instanceof Set ? (Set) value : null) != null) {
                        linkedHashMap11.put(entry6.getKey(), entry6.getValue());
                    }
                }
                BackupVars backupVars = new BackupVars(linkedHashMap2, linkedHashMap4, linkedHashMap6, linkedHashMap8, linkedHashMap10, linkedHashMap11 instanceof Map ? linkedHashMap11 : null);
                Intrinsics.checkNotNullExpressionValue(allSettings, "allSettings");
                LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry7 : allSettings.entrySet()) {
                    if (entry7.getValue() instanceof Boolean) {
                        linkedHashMap12.put(entry7.getKey(), entry7.getValue());
                    }
                }
                LinkedHashMap linkedHashMap13 = linkedHashMap12 instanceof Map ? linkedHashMap12 : null;
                LinkedHashMap linkedHashMap14 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry8 : allSettings.entrySet()) {
                    if (entry8.getValue() instanceof Integer) {
                        linkedHashMap14.put(entry8.getKey(), entry8.getValue());
                    }
                }
                LinkedHashMap linkedHashMap15 = linkedHashMap14 instanceof Map ? linkedHashMap14 : null;
                LinkedHashMap linkedHashMap16 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry9 : allSettings.entrySet()) {
                    if (entry9.getValue() instanceof String) {
                        linkedHashMap16.put(entry9.getKey(), entry9.getValue());
                    }
                }
                LinkedHashMap linkedHashMap17 = linkedHashMap16 instanceof Map ? linkedHashMap16 : null;
                LinkedHashMap linkedHashMap18 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry10 : allSettings.entrySet()) {
                    if (entry10.getValue() instanceof Float) {
                        linkedHashMap18.put(entry10.getKey(), entry10.getValue());
                    }
                }
                LinkedHashMap linkedHashMap19 = linkedHashMap18 instanceof Map ? linkedHashMap18 : null;
                LinkedHashMap linkedHashMap20 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry11 : allSettings.entrySet()) {
                    if (entry11.getValue() instanceof Long) {
                        linkedHashMap20.put(entry11.getKey(), entry11.getValue());
                    }
                }
                LinkedHashMap linkedHashMap21 = linkedHashMap20 instanceof Map ? linkedHashMap20 : null;
                LinkedHashMap linkedHashMap22 = new LinkedHashMap();
                for (Map.Entry<String, ?> entry12 : allSettings.entrySet()) {
                    Object value2 = entry12.getValue();
                    if ((value2 instanceof Set ? (Set) value2 : null) != null) {
                        linkedHashMap22.put(entry12.getKey(), entry12.getValue());
                    }
                }
                BackupFile backupFile = new BackupFile(backupVars, new BackupVars(linkedHashMap13, linkedHashMap15, linkedHashMap17, linkedHashMap19, linkedHashMap21, linkedHashMap22 instanceof Map ? linkedHashMap22 : null));
                if (Build.VERSION.SDK_INT >= 29) {
                    if (first != null && VideoDownloadManager.INSTANCE.isDownloadDir(first)) {
                        ContentResolver contentResolver = fragmentActivity.getContentResolver();
                        Uri contentUri = MediaStore.Downloads.getContentUri("external_primary");
                        Intrinsics.checkNotNullExpressionValue(contentUri, "getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)");
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_display_name", str);
                        contentValues.put("title", str);
                        contentValues.put("mime_type", AbstractSpiCall.ACCEPT_JSON_VALUE);
                        Unit unit = Unit.INSTANCE;
                        Uri insert = contentResolver.insert(contentUri, contentValues);
                        if (insert == null) {
                            throw new IOException("Error creating file uri");
                        }
                        openOutputStream = contentResolver.openOutputStream(insert, "w");
                        if (openOutputStream == null) {
                            throw new IOException("Error opening stream");
                        }
                        Intrinsics.checkNotNullExpressionValue(openOutputStream, "if (Build.VERSION.SDK_IN…m()\n                    }");
                        PrintWriter printWriter = new PrintWriter(openOutputStream);
                        printWriter.print(DataStore.INSTANCE.getMapper().writeValueAsString(backupFile));
                        printWriter.close();
                        CommonActivity.INSTANCE.showToast(fragmentActivity, R.string.backup_success, 1);
                        return;
                    }
                }
                String str2 = str + ".json";
                UniFile findFile = first != null ? first.findFile(str2) : null;
                if (findFile != null && findFile.exists()) {
                    findFile.delete();
                }
                UniFile createFile = first != null ? first.createFile(str2) : null;
                if (createFile == null) {
                    throw new IOException("Error creating file");
                }
                if (!createFile.exists()) {
                    throw new IOException("File does not exist");
                }
                openOutputStream = createFile.openOutputStream();
                Intrinsics.checkNotNullExpressionValue(openOutputStream, "if (Build.VERSION.SDK_IN…m()\n                    }");
                PrintWriter printWriter2 = new PrintWriter(openOutputStream);
                printWriter2.print(DataStore.INSTANCE.getMapper().writeValueAsString(backupFile));
                printWriter2.close();
                CommonActivity.INSTANCE.showToast(fragmentActivity, R.string.backup_success, 1);
                return;
            }
            CommonActivity.INSTANCE.showToast((Activity) fragmentActivity, fragmentActivity.getString(R.string.backup_failed), (Integer) 1);
            UIHelper.INSTANCE.requestRW(fragmentActivity);
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            try {
                String string = fragmentActivity.getString(R.string.backup_failed_error_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.backup_failed_error_format)");
                String format = String.format(string, Arrays.copyOf(new Object[]{e.toString()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                CommonActivity.INSTANCE.showToast((Activity) fragmentActivity, format, (Integer) 1);
            } catch (Exception e2) {
                ArchComponentExt.logError(e2);
            }
        }
    }

    public final void setUpBackup(final FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        try {
            restoreFileSelector = fragmentActivity.registerForActivityResult(new ActivityResultContracts.OpenDocument(), new ActivityResultCallback() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$BackupUtils$oW8X6wdZUsCXnsRKWfbtobfBmb4
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    BackupUtils.m8996setUpBackup$lambda15(FragmentActivity.this, (Uri) obj);
                }
            });
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setUpBackup$lambda-15  reason: not valid java name */
    public static final void m8996setUpBackup$lambda15(FragmentActivity this_setUpBackup, Uri uri) {
        Intrinsics.checkNotNullParameter(this_setUpBackup, "$this_setUpBackup");
        if (uri != null) {
            try {
                InputStream openInputStream = this_setUpBackup.getContentResolver().openInputStream(uri);
                if (openInputStream == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(openInputStream, "activity.contentResolver…registerForActivityResult");
                INSTANCE.restore(this_setUpBackup, (BackupFile) DataStore.INSTANCE.getMapper().readValue(openInputStream, new TypeReference<BackupFile>() { // from class: com.lagradost.cloudstream3.utils.BackupUtils$setUpBackup$lambda-15$lambda-14$lambda-13$$inlined$readValue$1
                }), true, true);
                this_setUpBackup.recreate();
            } catch (Exception e) {
                ArchComponentExt.logError(e);
                try {
                    CommonActivity commonActivity = CommonActivity.INSTANCE;
                    FragmentActivity fragmentActivity = this_setUpBackup;
                    String string = this_setUpBackup.getString(R.string.restore_failed_format);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.restore_failed_format)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{e.toString()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    CommonActivity.showToast$default(commonActivity, fragmentActivity, format, null, 4, null);
                } catch (Exception e2) {
                    ArchComponentExt.logError(e2);
                }
            }
        }
    }

    public final void restorePrompt(final FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        fragmentActivity.runOnUiThread(new Runnable() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$BackupUtils$VK90u8xQRPBNaj5jOdCbXboLf4M
            @Override // java.lang.Runnable
            public final void run() {
                BackupUtils.m8995restorePrompt$lambda16(FragmentActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: restorePrompt$lambda-16  reason: not valid java name */
    public static final void m8995restorePrompt$lambda16(FragmentActivity this_restorePrompt) {
        Intrinsics.checkNotNullParameter(this_restorePrompt, "$this_restorePrompt");
        try {
            ActivityResultLauncher<String[]> activityResultLauncher = restoreFileSelector;
            if (activityResultLauncher != null) {
                activityResultLauncher.launch(new String[]{"text/plain", "text/str", MimeTypes.TEXT_UNKNOWN, AbstractSpiCall.ACCEPT_JSON_VALUE, "unknown/unknown", "content/unknown"});
            }
        } catch (Exception e) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, this_restorePrompt, e.getMessage(), null, 4, null);
            ArchComponentExt.logError(e);
        }
    }

    static /* synthetic */ void restoreMap$default(BackupUtils backupUtils, Context context, Map map, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        backupUtils.restoreMap(context, map, z);
    }

    public final void restore(Context context, BackupFile backupFile, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        if (z) {
            restoreMap(context, backupFile.getSettings().get_Bool(), true);
            restoreMap(context, backupFile.getSettings().get_Int(), true);
            restoreMap(context, backupFile.getSettings().get_String(), true);
            restoreMap(context, backupFile.getSettings().get_Float(), true);
            restoreMap(context, backupFile.getSettings().get_Long(), true);
            restoreMap(context, backupFile.getSettings().get_StringSet(), true);
        }
        if (z2) {
            restoreMap$default(this, context, backupFile.getDatastore().get_Bool(), false, 2, null);
            restoreMap$default(this, context, backupFile.getDatastore().get_Int(), false, 2, null);
            restoreMap$default(this, context, backupFile.getDatastore().get_String(), false, 2, null);
            restoreMap$default(this, context, backupFile.getDatastore().get_Float(), false, 2, null);
            restoreMap$default(this, context, backupFile.getDatastore().get_Long(), false, 2, null);
            restoreMap$default(this, context, backupFile.getDatastore().get_StringSet(), false, 2, null);
        }
    }

    private final <T> void restoreMap(Context context, Map<String, ? extends T> map, boolean z) {
        if (map != null) {
            for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
                DataStore.INSTANCE.setKeyRaw(context, entry.getKey(), entry.getValue(), z);
            }
        }
    }
}
