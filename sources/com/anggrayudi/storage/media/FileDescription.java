package com.anggrayudi.storage.media;

import com.anggrayudi.storage.file.MimeType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileDescription.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\f¨\u0006\u001b"}, m107d2 = {"Lcom/anggrayudi/storage/media/FileDescription;", "", "name", "", "subFolder", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "fullName", "getFullName", "()Ljava/lang/String;", "getMimeType", "setMimeType", "(Ljava/lang/String;)V", "getName", "setName", "getSubFolder", "setSubFolder", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class FileDescription {
    private String mimeType;
    private String name;
    private String subFolder;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileDescription(String name) {
        this(name, null, null, 6, null);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileDescription(String name, String subFolder) {
        this(name, subFolder, null, 4, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subFolder, "subFolder");
    }

    public static /* synthetic */ FileDescription copy$default(FileDescription fileDescription, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileDescription.name;
        }
        if ((i & 2) != 0) {
            str2 = fileDescription.subFolder;
        }
        if ((i & 4) != 0) {
            str3 = fileDescription.mimeType;
        }
        return fileDescription.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.subFolder;
    }

    public final String component3() {
        return this.mimeType;
    }

    public final FileDescription copy(String name, String subFolder, String mimeType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subFolder, "subFolder");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        return new FileDescription(name, subFolder, mimeType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileDescription) {
            FileDescription fileDescription = (FileDescription) obj;
            return Intrinsics.areEqual(this.name, fileDescription.name) && Intrinsics.areEqual(this.subFolder, fileDescription.subFolder) && Intrinsics.areEqual(this.mimeType, fileDescription.mimeType);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.subFolder.hashCode()) * 31) + this.mimeType.hashCode();
    }

    public String toString() {
        return "FileDescription(name=" + this.name + ", subFolder=" + this.subFolder + ", mimeType=" + this.mimeType + ')';
    }

    public FileDescription(String name, String subFolder, String mimeType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(subFolder, "subFolder");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        this.name = name;
        this.subFolder = subFolder;
        this.mimeType = mimeType;
    }

    public /* synthetic */ FileDescription(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? MimeType.UNKNOWN : str3);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getSubFolder() {
        return this.subFolder;
    }

    public final void setSubFolder(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subFolder = str;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mimeType = str;
    }

    public final String getFullName() {
        return MimeType.getFullFileName(this.name, this.mimeType);
    }
}
