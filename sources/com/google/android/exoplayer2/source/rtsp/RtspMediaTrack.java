package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RtspMediaTrack {
    private static final String AAC_CODECS_PREFIX = "mp4a.40.";
    private static final String GENERIC_CONTROL_ATTR = "*";
    private static final String H264_CODECS_PREFIX = "avc1.";
    private static final String PARAMETER_PROFILE_LEVEL_ID = "profile-level-id";
    private static final String PARAMETER_SPROP_PARAMS = "sprop-parameter-sets";
    public final RtpPayloadFormat payloadFormat;
    public final Uri uri;

    public RtspMediaTrack(MediaDescription mediaDescription, Uri uri) {
        Assertions.checkArgument(mediaDescription.attributes.containsKey(SessionDescription.ATTR_CONTROL));
        this.payloadFormat = generatePayloadFormat(mediaDescription);
        this.uri = extractTrackUri(uri, (String) Util.castNonNull(mediaDescription.attributes.get(SessionDescription.ATTR_CONTROL)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RtspMediaTrack rtspMediaTrack = (RtspMediaTrack) obj;
        return this.payloadFormat.equals(rtspMediaTrack.payloadFormat) && this.uri.equals(rtspMediaTrack.uri);
    }

    public int hashCode() {
        return ((bqk.f6556bP + this.payloadFormat.hashCode()) * 31) + this.uri.hashCode();
    }

    static RtpPayloadFormat generatePayloadFormat(MediaDescription mediaDescription) {
        int i;
        char c;
        Format.Builder builder = new Format.Builder();
        if (mediaDescription.bitrate > 0) {
            builder.setAverageBitrate(mediaDescription.bitrate);
        }
        int i2 = mediaDescription.rtpMapAttribute.payloadType;
        String mimeTypeFromRtpMediaType = RtpPayloadFormat.getMimeTypeFromRtpMediaType(mediaDescription.rtpMapAttribute.mediaEncoding);
        builder.setSampleMimeType(mimeTypeFromRtpMediaType);
        int i3 = mediaDescription.rtpMapAttribute.clockRate;
        if ("audio".equals(mediaDescription.mediaType)) {
            i = inferChannelCount(mediaDescription.rtpMapAttribute.encodingParameters, mimeTypeFromRtpMediaType);
            builder.setSampleRate(i3).setChannelCount(i);
        } else {
            i = -1;
        }
        ImmutableMap<String, String> fmtpParametersAsMap = mediaDescription.getFmtpParametersAsMap();
        int hashCode = mimeTypeFromRtpMediaType.hashCode();
        if (hashCode == -53558318) {
            if (mimeTypeFromRtpMediaType.equals(MimeTypes.AUDIO_AAC)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 187078296) {
            if (hashCode == 1331836730 && mimeTypeFromRtpMediaType.equals(MimeTypes.VIDEO_H264)) {
                c = 1;
            }
            c = 65535;
        } else {
            if (mimeTypeFromRtpMediaType.equals(MimeTypes.AUDIO_AC3)) {
                c = 2;
            }
            c = 65535;
        }
        if (c == 0) {
            Assertions.checkArgument(i != -1);
            Assertions.checkArgument(!fmtpParametersAsMap.isEmpty());
            processAacFmtpAttribute(builder, fmtpParametersAsMap, i, i3);
        } else if (c == 1) {
            Assertions.checkArgument(!fmtpParametersAsMap.isEmpty());
            processH264FmtpAttribute(builder, fmtpParametersAsMap);
        }
        Assertions.checkArgument(i3 > 0);
        Assertions.checkArgument(i2 >= 96);
        return new RtpPayloadFormat(builder.build(), i2, i3, fmtpParametersAsMap);
    }

    private static int inferChannelCount(int i, String str) {
        return i != -1 ? i : str.equals(MimeTypes.AUDIO_AC3) ? 6 : 1;
    }

    private static void processAacFmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap, int i, int i2) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_PROFILE_LEVEL_ID));
        String valueOf = String.valueOf((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_PROFILE_LEVEL_ID)));
        builder.setCodecs(valueOf.length() != 0 ? AAC_CODECS_PREFIX.concat(valueOf) : new String(AAC_CODECS_PREFIX));
        builder.setInitializationData(ImmutableList.m294of(AacUtil.buildAacLcAudioSpecificConfig(i2, i)));
    }

    private static void processH264FmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_SPROP_PARAMS));
        String[] split = Util.split((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_SPROP_PARAMS)), ",");
        Assertions.checkArgument(split.length == 2);
        ImmutableList m293of = ImmutableList.m293of(getH264InitializationDataFromParameterSet(split[0]), getH264InitializationDataFromParameterSet(split[1]));
        builder.setInitializationData(m293of);
        byte[] bArr = (byte[]) m293of.get(0);
        NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(bArr, NalUnitUtil.NAL_START_CODE.length, bArr.length);
        builder.setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthHeightRatio);
        builder.setHeight(parseSpsNalUnit.height);
        builder.setWidth(parseSpsNalUnit.width);
        String str = immutableMap.get(PARAMETER_PROFILE_LEVEL_ID);
        if (str != null) {
            String valueOf = String.valueOf(str);
            builder.setCodecs(valueOf.length() != 0 ? H264_CODECS_PREFIX.concat(valueOf) : new String(H264_CODECS_PREFIX));
            return;
        }
        builder.setCodecs(CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc));
    }

    private static byte[] getH264InitializationDataFromParameterSet(String str) {
        byte[] decode = Base64.decode(str, 0);
        byte[] bArr = new byte[decode.length + NalUnitUtil.NAL_START_CODE.length];
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, 0, NalUnitUtil.NAL_START_CODE.length);
        System.arraycopy(decode, 0, bArr, NalUnitUtil.NAL_START_CODE.length, decode.length);
        return bArr;
    }

    private static Uri extractTrackUri(Uri uri, String str) {
        Uri parse = Uri.parse(str);
        return parse.isAbsolute() ? parse : str.equals(GENERIC_CONTROL_ATTR) ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }
}
