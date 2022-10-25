package com.anggrayudi.storage.media;

import android.os.Environment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum MUSIC uses external variables
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
/* compiled from: AudioMediaDirectory.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m107d2 = {"Lcom/anggrayudi/storage/media/AudioMediaDirectory;", "", "folderName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getFolderName", "()Ljava/lang/String;", "MUSIC", "PODCASTS", "RINGTONES", "ALARMS", "NOTIFICATIONS", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class AudioMediaDirectory {
    private static final /* synthetic */ AudioMediaDirectory[] $VALUES;
    public static final AudioMediaDirectory ALARMS;
    public static final AudioMediaDirectory MUSIC;
    public static final AudioMediaDirectory NOTIFICATIONS;
    public static final AudioMediaDirectory PODCASTS;
    public static final AudioMediaDirectory RINGTONES;
    private final String folderName;

    private static final /* synthetic */ AudioMediaDirectory[] $values() {
        return new AudioMediaDirectory[]{MUSIC, PODCASTS, RINGTONES, ALARMS, NOTIFICATIONS};
    }

    public static AudioMediaDirectory valueOf(String str) {
        return (AudioMediaDirectory) Enum.valueOf(AudioMediaDirectory.class, str);
    }

    public static AudioMediaDirectory[] values() {
        return (AudioMediaDirectory[]) $VALUES.clone();
    }

    private AudioMediaDirectory(String str, int i, String str2) {
        this.folderName = str2;
    }

    public final String getFolderName() {
        return this.folderName;
    }

    static {
        String DIRECTORY_MUSIC = Environment.DIRECTORY_MUSIC;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_MUSIC, "DIRECTORY_MUSIC");
        MUSIC = new AudioMediaDirectory("MUSIC", 0, DIRECTORY_MUSIC);
        String DIRECTORY_PODCASTS = Environment.DIRECTORY_PODCASTS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_PODCASTS, "DIRECTORY_PODCASTS");
        PODCASTS = new AudioMediaDirectory("PODCASTS", 1, DIRECTORY_PODCASTS);
        String DIRECTORY_RINGTONES = Environment.DIRECTORY_RINGTONES;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_RINGTONES, "DIRECTORY_RINGTONES");
        RINGTONES = new AudioMediaDirectory("RINGTONES", 2, DIRECTORY_RINGTONES);
        String DIRECTORY_ALARMS = Environment.DIRECTORY_ALARMS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_ALARMS, "DIRECTORY_ALARMS");
        ALARMS = new AudioMediaDirectory("ALARMS", 3, DIRECTORY_ALARMS);
        String DIRECTORY_NOTIFICATIONS = Environment.DIRECTORY_NOTIFICATIONS;
        Intrinsics.checkNotNullExpressionValue(DIRECTORY_NOTIFICATIONS, "DIRECTORY_NOTIFICATIONS");
        NOTIFICATIONS = new AudioMediaDirectory("NOTIFICATIONS", 4, DIRECTORY_NOTIFICATIONS);
        $VALUES = $values();
    }
}
