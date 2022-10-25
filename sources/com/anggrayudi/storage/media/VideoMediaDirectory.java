package com.anggrayudi.storage.media;

import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum MOVIES uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: VideoMediaDirectory.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m107d2 = {"Lcom/anggrayudi/storage/media/VideoMediaDirectory;", "", "folderName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFolderName", "()Ljava/lang/String;", "MOVIES", "DCIM", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class VideoMediaDirectory {
    private static final /* synthetic */ VideoMediaDirectory[] $VALUES;
    public static final VideoMediaDirectory DCIM;
    public static final VideoMediaDirectory MOVIES;
    private final String folderName;

    private static final /* synthetic */ VideoMediaDirectory[] $values() {
        return new VideoMediaDirectory[]{MOVIES, DCIM};
    }

    public static VideoMediaDirectory valueOf(String str) {
        return (VideoMediaDirectory) Enum.valueOf(VideoMediaDirectory.class, str);
    }

    public static VideoMediaDirectory[] values() {
        return (VideoMediaDirectory[]) $VALUES.clone();
    }

    private VideoMediaDirectory(String str, int i, String str2) {
        this.folderName = str2;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    static {
        String DIRECTORY_MOVIES = Environment.DIRECTORY_MOVIES;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_MOVIES, "DIRECTORY_MOVIES");
        MOVIES = new VideoMediaDirectory("MOVIES", 0, DIRECTORY_MOVIES);
        String DIRECTORY_DCIM = Environment.DIRECTORY_DCIM;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_DCIM, "DIRECTORY_DCIM");
        DCIM = new VideoMediaDirectory("DCIM", 1, DIRECTORY_DCIM);
        $VALUES = $values();
    }
}
