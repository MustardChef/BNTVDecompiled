package com.google.android.exoplayer2.transformer;

import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
interface Muxer {

    /* loaded from: classes2.dex */
    public interface Factory {
        Muxer create(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException;

        Muxer create(String str, String str2) throws IOException;

        boolean supportsOutputMimeType(String str);

        boolean supportsSampleMimeType(String str, String str2);
    }

    int addTrack(Format format);

    void release(boolean z);

    void writeSampleData(int i, ByteBuffer byteBuffer, boolean z, long j);
}
