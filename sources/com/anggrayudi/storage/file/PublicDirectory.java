package com.anggrayudi.storage.file;

import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum DOWNLOADS uses external variables
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
/* compiled from: PublicDirectory.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, m107d2 = {"Lcom/anggrayudi/storage/file/PublicDirectory;", "", "folderName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFolderName", "()Ljava/lang/String;", "DOWNLOADS", "MUSIC", "PODCASTS", "RINGTONES", "ALARMS", "NOTIFICATIONS", "PICTURES", "MOVIES", "DCIM", "DOCUMENTS", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class PublicDirectory {
    private static final /* synthetic */ PublicDirectory[] $VALUES;
    public static final PublicDirectory ALARMS;
    public static final PublicDirectory DCIM;
    public static final PublicDirectory DOCUMENTS;
    public static final PublicDirectory DOWNLOADS;
    public static final PublicDirectory MOVIES;
    public static final PublicDirectory MUSIC;
    public static final PublicDirectory NOTIFICATIONS;
    public static final PublicDirectory PICTURES;
    public static final PublicDirectory PODCASTS;
    public static final PublicDirectory RINGTONES;
    private final String folderName;

    private static final /* synthetic */ PublicDirectory[] $values() {
        return new PublicDirectory[]{DOWNLOADS, MUSIC, PODCASTS, RINGTONES, ALARMS, NOTIFICATIONS, PICTURES, MOVIES, DCIM, DOCUMENTS};
    }

    public static PublicDirectory valueOf(String str) {
        return (PublicDirectory) Enum.valueOf(PublicDirectory.class, str);
    }

    public static PublicDirectory[] values() {
        return (PublicDirectory[]) $VALUES.clone();
    }

    private PublicDirectory(String str, int i, String str2) {
        this.folderName = str2;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    static {
        String DIRECTORY_DOWNLOADS = Environment.DIRECTORY_DOWNLOADS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_DOWNLOADS, "DIRECTORY_DOWNLOADS");
        DOWNLOADS = new PublicDirectory("DOWNLOADS", 0, DIRECTORY_DOWNLOADS);
        String DIRECTORY_MUSIC = Environment.DIRECTORY_MUSIC;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_MUSIC, "DIRECTORY_MUSIC");
        MUSIC = new PublicDirectory("MUSIC", 1, DIRECTORY_MUSIC);
        String DIRECTORY_PODCASTS = Environment.DIRECTORY_PODCASTS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_PODCASTS, "DIRECTORY_PODCASTS");
        PODCASTS = new PublicDirectory("PODCASTS", 2, DIRECTORY_PODCASTS);
        String DIRECTORY_RINGTONES = Environment.DIRECTORY_RINGTONES;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_RINGTONES, "DIRECTORY_RINGTONES");
        RINGTONES = new PublicDirectory("RINGTONES", 3, DIRECTORY_RINGTONES);
        String DIRECTORY_ALARMS = Environment.DIRECTORY_ALARMS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_ALARMS, "DIRECTORY_ALARMS");
        ALARMS = new PublicDirectory("ALARMS", 4, DIRECTORY_ALARMS);
        String DIRECTORY_NOTIFICATIONS = Environment.DIRECTORY_NOTIFICATIONS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_NOTIFICATIONS, "DIRECTORY_NOTIFICATIONS");
        NOTIFICATIONS = new PublicDirectory("NOTIFICATIONS", 5, DIRECTORY_NOTIFICATIONS);
        String DIRECTORY_PICTURES = Environment.DIRECTORY_PICTURES;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_PICTURES, "DIRECTORY_PICTURES");
        PICTURES = new PublicDirectory("PICTURES", 6, DIRECTORY_PICTURES);
        String DIRECTORY_MOVIES = Environment.DIRECTORY_MOVIES;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_MOVIES, "DIRECTORY_MOVIES");
        MOVIES = new PublicDirectory("MOVIES", 7, DIRECTORY_MOVIES);
        String DIRECTORY_DCIM = Environment.DIRECTORY_DCIM;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_DCIM, "DIRECTORY_DCIM");
        DCIM = new PublicDirectory("DCIM", 8, DIRECTORY_DCIM);
        String DIRECTORY_DOCUMENTS = Environment.DIRECTORY_DOCUMENTS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_DOCUMENTS, "DIRECTORY_DOCUMENTS");
        DOCUMENTS = new PublicDirectory("DOCUMENTS", 9, DIRECTORY_DOCUMENTS);
        $VALUES = $values();
    }
}
