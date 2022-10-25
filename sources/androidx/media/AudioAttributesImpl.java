package androidx.media;

import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes.dex */
public interface AudioAttributesImpl extends VersionedParcelable {

    /* loaded from: classes.dex */
    public interface Builder {
        AudioAttributesImpl build();

        Builder setContentType(int contentType);

        Builder setFlags(int flags);

        Builder setLegacyStreamType(int streamType);

        Builder setUsage(int usage);
    }

    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();
}
