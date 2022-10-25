package com.anggrayudi.storage.file;

import android.content.Context;
import android.text.format.Formatter;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: FileProperties.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001@Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003Jo\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020=J\t\u0010>\u001a\u00020\nHÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\r\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u001c\"\u0004\b\u001f\u0010\u001eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006A"}, m107d2 = {"Lcom/anggrayudi/storage/file/FileProperties;", "", "name", "", FirebaseAnalytics.Param.LOCATION, "size", "", "isFolder", "", "folders", "", "files", "emptyFiles", "emptyFolders", "isVirtual", "lastModified", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;JZIIIIZLjava/util/Date;)V", "getEmptyFiles", "()I", "setEmptyFiles", "(I)V", "getEmptyFolders", "setEmptyFolders", "getFiles", "setFiles", "getFolders", "setFolders", "()Z", "setFolder", "(Z)V", "setVirtual", "getLastModified", "()Ljava/util/Date;", "setLastModified", "(Ljava/util/Date;)V", "getLocation", "()Ljava/lang/String;", "setLocation", "(Ljava/lang/String;)V", "getName", "setName", "getSize", "()J", "setSize", "(J)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "formattedSize", "context", "Landroid/content/Context;", "hashCode", "toString", "CalculationCallback", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class FileProperties {
    private int emptyFiles;
    private int emptyFolders;
    private int files;
    private int folders;
    private boolean isFolder;
    private boolean isVirtual;
    private Date lastModified;
    private String location;
    private String name;
    private long size;

    public FileProperties() {
        this(null, null, 0L, false, 0, 0, 0, 0, false, null, AnalyticsListener.EVENT_DROPPED_VIDEO_FRAMES, null);
    }

    public final String component1() {
        return this.name;
    }

    public final Date component10() {
        return this.lastModified;
    }

    public final String component2() {
        return this.location;
    }

    public final long component3() {
        return this.size;
    }

    public final boolean component4() {
        return this.isFolder;
    }

    public final int component5() {
        return this.folders;
    }

    public final int component6() {
        return this.files;
    }

    public final int component7() {
        return this.emptyFiles;
    }

    public final int component8() {
        return this.emptyFolders;
    }

    public final boolean component9() {
        return this.isVirtual;
    }

    public final FileProperties copy(String name, String location, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, Date date) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        return new FileProperties(name, location, j, z, i, i2, i3, i4, z2, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileProperties) {
            FileProperties fileProperties = (FileProperties) obj;
            return Intrinsics.areEqual(this.name, fileProperties.name) && Intrinsics.areEqual(this.location, fileProperties.location) && this.size == fileProperties.size && this.isFolder == fileProperties.isFolder && this.folders == fileProperties.folders && this.files == fileProperties.files && this.emptyFiles == fileProperties.emptyFiles && this.emptyFolders == fileProperties.emptyFolders && this.isVirtual == fileProperties.isVirtual && Intrinsics.areEqual(this.lastModified, fileProperties.lastModified);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.name.hashCode() * 31) + this.location.hashCode()) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.size)) * 31;
        boolean z = this.isFolder;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (((((((((hashCode + i) * 31) + this.folders) * 31) + this.files) * 31) + this.emptyFiles) * 31) + this.emptyFolders) * 31;
        boolean z2 = this.isVirtual;
        int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        Date date = this.lastModified;
        return i3 + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "FileProperties(name=" + this.name + ", location=" + this.location + ", size=" + this.size + ", isFolder=" + this.isFolder + ", folders=" + this.folders + ", files=" + this.files + ", emptyFiles=" + this.emptyFiles + ", emptyFolders=" + this.emptyFolders + ", isVirtual=" + this.isVirtual + ", lastModified=" + this.lastModified + ')';
    }

    public FileProperties(String name, String location, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, Date date) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        this.name = name;
        this.location = location;
        this.size = j;
        this.isFolder = z;
        this.folders = i;
        this.files = i2;
        this.emptyFiles = i3;
        this.emptyFolders = i4;
        this.isVirtual = z2;
        this.lastModified = date;
    }

    public /* synthetic */ FileProperties(String str, String str2, long j, boolean z, int i, int i2, int i3, int i4, boolean z2, Date date, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) == 0 ? str2 : "", (i5 & 4) != 0 ? 0L : j, (i5 & 8) != 0 ? false : z, (i5 & 16) != 0 ? 0 : i, (i5 & 32) != 0 ? 0 : i2, (i5 & 64) != 0 ? 0 : i3, (i5 & 128) != 0 ? 0 : i4, (i5 & 256) == 0 ? z2 : false, (i5 & 512) != 0 ? null : date);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.location = str;
    }

    public final long getSize() {
        return this.size;
    }

    public final void setSize(long j) {
        this.size = j;
    }

    public final boolean isFolder() {
        return this.isFolder;
    }

    public final void setFolder(boolean z) {
        this.isFolder = z;
    }

    public final int getFolders() {
        return this.folders;
    }

    public final void setFolders(int i) {
        this.folders = i;
    }

    public final int getFiles() {
        return this.files;
    }

    public final void setFiles(int i) {
        this.files = i;
    }

    public final int getEmptyFiles() {
        return this.emptyFiles;
    }

    public final void setEmptyFiles(int i) {
        this.emptyFiles = i;
    }

    public final int getEmptyFolders() {
        return this.emptyFolders;
    }

    public final void setEmptyFolders(int i) {
        this.emptyFolders = i;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public final void setVirtual(boolean z) {
        this.isVirtual = z;
    }

    public final Date getLastModified() {
        return this.lastModified;
    }

    public final void setLastModified(Date date) {
        this.lastModified = date;
    }

    public final String formattedSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String formatFileSize = Formatter.formatFileSize(context, this.size);
        Intrinsics.checkNotNullExpressionValue(formatFileSize, "formatFileSize(context, size)");
        return formatFileSize;
    }

    /* compiled from: FileProperties.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H'J\b\u0010\u0012\u001a\u00020\u000eH\u0017J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m107d2 = {"Lcom/anggrayudi/storage/file/FileProperties$CalculationCallback;", "", "updateInterval", "", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "(JLkotlinx/coroutines/CoroutineScope;)V", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "setUiScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "getUpdateInterval", "()J", "onCanceled", "", "properties", "Lcom/anggrayudi/storage/file/FileProperties;", "onComplete", "onError", "onUpdate", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static abstract class CalculationCallback {
        private CoroutineScope uiScope;
        private final long updateInterval;

        public CalculationCallback() {
            this(0L, null, 3, null);
        }

        public void onCanceled(FileProperties properties) {
            Intrinsics.checkNotNullParameter(properties, "properties");
        }

        public abstract void onComplete(FileProperties fileProperties);

        public void onError() {
        }

        public void onUpdate(FileProperties properties) {
            Intrinsics.checkNotNullParameter(properties, "properties");
        }

        public CalculationCallback(long j, CoroutineScope uiScope) {
            Intrinsics.checkNotNullParameter(uiScope, "uiScope");
            this.updateInterval = j;
            this.uiScope = uiScope;
        }

        public final long getUpdateInterval() {
            return this.updateInterval;
        }

        public /* synthetic */ CalculationCallback(long j, GlobalScope globalScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 500L : j, (i & 2) != 0 ? GlobalScope.INSTANCE : globalScope);
        }

        public final CoroutineScope getUiScope() {
            return this.uiScope;
        }

        public final void setUiScope(CoroutineScope coroutineScope) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
            this.uiScope = coroutineScope;
        }
    }
}
