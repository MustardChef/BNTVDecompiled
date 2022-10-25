package com.google.android.exoplayer2.extractor.p035ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.p035ts.TsPayloadReader;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.SignedBytes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory */
/* loaded from: classes2.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS = 64;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final List<Format> closedCaptionFormats;
    private final int flags;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory$Flags */
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    public DefaultTsPayloadReaderFactory(int i) {
        this(i, ImmutableList.m295of());
    }

    public DefaultTsPayloadReaderFactory(int i, List<Format> list) {
        this.flags = i;
        this.closedCaptionFormats = list;
    }

    @Override // com.google.android.exoplayer2.extractor.p035ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.p035ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int i, TsPayloadReader.EsInfo esInfo) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new PesReader(new MpegAudioReader(esInfo.language));
            }
            if (i != 21) {
                if (i == 27) {
                    if (isSet(4)) {
                        return null;
                    }
                    return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
                } else if (i != 36) {
                    if (i != 89) {
                        if (i != 138) {
                            if (i != 172) {
                                if (i != 257) {
                                    if (i != 134) {
                                        if (i != 135) {
                                            switch (i) {
                                                case 15:
                                                    if (isSet(2)) {
                                                        return null;
                                                    }
                                                    return new PesReader(new AdtsReader(false, esInfo.language));
                                                case 16:
                                                    return new PesReader(new H263Reader(buildUserDataReader(esInfo)));
                                                case 17:
                                                    if (isSet(2)) {
                                                        return null;
                                                    }
                                                    return new PesReader(new LatmReader(esInfo.language));
                                                default:
                                                    switch (i) {
                                                        case 128:
                                                            break;
                                                        case 129:
                                                            break;
                                                        case 130:
                                                            if (!isSet(64)) {
                                                                return null;
                                                            }
                                                            break;
                                                        default:
                                                            return null;
                                                    }
                                            }
                                        }
                                        return new PesReader(new Ac3Reader(esInfo.language));
                                    } else if (isSet(16)) {
                                        return null;
                                    } else {
                                        return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_SCTE35));
                                    }
                                }
                                return new SectionReader(new PassthroughSectionPayloadReader(MimeTypes.APPLICATION_AIT));
                            }
                            return new PesReader(new Ac4Reader(esInfo.language));
                        }
                        return new PesReader(new DtsReader(esInfo.language));
                    }
                    return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                } else {
                    return new PesReader(new H265Reader(buildSeiReader(esInfo)));
                }
            }
            return new PesReader(new Id3Reader());
        }
        return new PesReader(new H262Reader(buildUserDataReader(esInfo)));
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(getClosedCaptionFormats(esInfo));
    }

    private UserDataReader buildUserDataReader(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(getClosedCaptionFormats(esInfo));
    }

    private List<Format> getClosedCaptionFormats(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i;
        if (isSet(32)) {
            return this.closedCaptionFormats;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> list = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                list = new ArrayList<>();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                    String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z = (readUnsignedByte3 & 128) != 0;
                    if (z) {
                        i = readUnsignedByte3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte readUnsignedByte4 = (byte) parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    List<byte[]> list2 = null;
                    if (z) {
                        list2 = CodecSpecificDataUtil.buildCea708InitializationData((readUnsignedByte4 & SignedBytes.MAX_POWER_OF_TWO) != 0);
                    }
                    list.add(new Format.Builder().setSampleMimeType(str).setLanguage(readString).setAccessibilityChannel(i).setInitializationData(list2).build());
                }
            }
            parsableByteArray.setPosition(position);
        }
        return list;
    }

    private boolean isSet(int i) {
        return (i & this.flags) != 0;
    }
}
