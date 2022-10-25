package org.acra.collector;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.cast.HlsSegmentFormat;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.collector.Collector;
import org.acra.config.CoreConfiguration;
import org.acra.data.CrashReportData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MediaCodecListCollector.kt */
@Metadata(m108d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0017\u0018\u0000 )2\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0003J\b\u0010\"\u001a\u00020\u001eH\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001f\u001a\u00020 H\u0003J\b\u0010%\u001a\u00020\u0012H\u0002J(\u0010&\u001a\u00020'2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, m107d2 = {"Lorg/acra/collector/MediaCodecListCollector;", "Lorg/acra/collector/BaseReportFieldCollector;", "()V", "mAACProfileValues", "Landroid/util/SparseArray;", "", "mAVCLevelValues", "mAVCProfileValues", "mColorFormatValues", "mH263LevelValues", "mH263ProfileValues", "mMPEG4LevelValues", "mMPEG4ProfileValues", "order", "Lorg/acra/collector/Collector$Order;", "getOrder", "()Lorg/acra/collector/Collector$Order;", "collect", "", "reportField", "Lorg/acra/ReportField;", "context", "Landroid/content/Context;", "config", "Lorg/acra/config/CoreConfiguration;", "reportBuilder", "Lorg/acra/builder/ReportBuilder;", TypedValues.AttributesType.S_TARGET, "Lorg/acra/data/CrashReportData;", "collectCapabilitiesForType", "Lorg/json/JSONObject;", "codecInfo", "Landroid/media/MediaCodecInfo;", "type", "collectMediaCodecList", "identifyCodecType", "Lorg/acra/collector/MediaCodecListCollector$CodecType;", "prepare", "shouldCollect", "", "CodecType", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public class MediaCodecListCollector extends BaseReportFieldCollector {
    private static final String COLOR_FORMAT_PREFIX = "COLOR_";
    private final SparseArray<String> mAACProfileValues;
    private final SparseArray<String> mAVCLevelValues;
    private final SparseArray<String> mAVCProfileValues;
    private final SparseArray<String> mColorFormatValues;
    private final SparseArray<String> mH263LevelValues;
    private final SparseArray<String> mH263ProfileValues;
    private final SparseArray<String> mMPEG4LevelValues;
    private final SparseArray<String> mMPEG4ProfileValues;
    public static final Companion Companion = new Companion(null);
    private static final String[] MPEG4_TYPES = {"mp4", "mpeg4", "MP4", "MPEG4"};
    private static final String[] AVC_TYPES = {"avc", "h264", "AVC", "H264"};
    private static final String[] H263_TYPES = {"h263", "H263"};
    private static final String[] AAC_TYPES = {HlsSegmentFormat.AAC, "AAC"};

    /* compiled from: MediaCodecListCollector.kt */
    @Metadata(m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CodecType.valuesCustom().length];
            iArr[CodecType.AVC.ordinal()] = 1;
            iArr[CodecType.H263.ordinal()] = 2;
            iArr[CodecType.MPEG4.ordinal()] = 3;
            iArr[CodecType.AAC.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MediaCodecListCollector() {
        super(ReportField.MEDIA_CODEC_LIST);
        this.mColorFormatValues = new SparseArray<>();
        this.mAVCLevelValues = new SparseArray<>();
        this.mAVCProfileValues = new SparseArray<>();
        this.mH263LevelValues = new SparseArray<>();
        this.mH263ProfileValues = new SparseArray<>();
        this.mMPEG4LevelValues = new SparseArray<>();
        this.mMPEG4ProfileValues = new SparseArray<>();
        this.mAACProfileValues = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaCodecListCollector.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m107d2 = {"Lorg/acra/collector/MediaCodecListCollector$CodecType;", "", "(Ljava/lang/String;I)V", "AVC", "H263", "MPEG4", "AAC", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public enum CodecType {
        AVC,
        H263,
        MPEG4,
        AAC;

        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CodecType[] valuesCustom() {
            CodecType[] valuesCustom = values();
            return (CodecType[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    @Override // org.acra.collector.BaseReportFieldCollector, org.acra.collector.Collector
    public Collector.Order getOrder() {
        return Collector.Order.LATE;
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public void collect(ReportField reportField, Context context, CoreConfiguration config, ReportBuilder reportBuilder, CrashReportData target) throws JSONException {
        Intrinsics.checkNotNullParameter(reportField, "reportField");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        Intrinsics.checkNotNullParameter(target, "target");
        target.put(ReportField.MEDIA_CODEC_LIST, collectMediaCodecList());
    }

    @Override // org.acra.collector.BaseReportFieldCollector
    public boolean shouldCollect(Context context, CoreConfiguration config, ReportField collect, ReportBuilder reportBuilder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(collect, "collect");
        Intrinsics.checkNotNullParameter(reportBuilder, "reportBuilder");
        return super.shouldCollect(context, config, collect, reportBuilder) && Build.VERSION.SDK_INT >= 16;
    }

    private final void prepare() {
        try {
            Field[] fields = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getFields();
            Intrinsics.checkNotNullExpressionValue(fields, "codecCapabilitiesClass.fields");
            int length = fields.length;
            int i = 0;
            while (i < length) {
                Field field = fields[i];
                i++;
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "f.name");
                    if (StringsKt.startsWith$default(name, COLOR_FORMAT_PREFIX, false, 2, (Object) null)) {
                        this.mColorFormatValues.put(field.getInt(null), field.getName());
                    }
                }
            }
            Field[] fields2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getFields();
            Intrinsics.checkNotNullExpressionValue(fields2, "codecProfileLevelClass.fields");
            int length2 = fields2.length;
            int i2 = 0;
            while (i2 < length2) {
                Field field2 = fields2[i2];
                i2++;
                if (Modifier.isStatic(field2.getModifiers()) && Modifier.isFinal(field2.getModifiers())) {
                    String name2 = field2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "f.name");
                    if (StringsKt.startsWith$default(name2, "AVCLevel", false, 2, (Object) null)) {
                        this.mAVCLevelValues.put(field2.getInt(null), field2.getName());
                    } else {
                        String name3 = field2.getName();
                        Intrinsics.checkNotNullExpressionValue(name3, "f.name");
                        if (StringsKt.startsWith$default(name3, "AVCProfile", false, 2, (Object) null)) {
                            this.mAVCProfileValues.put(field2.getInt(null), field2.getName());
                        } else {
                            String name4 = field2.getName();
                            Intrinsics.checkNotNullExpressionValue(name4, "f.name");
                            if (StringsKt.startsWith$default(name4, "H263Level", false, 2, (Object) null)) {
                                this.mH263LevelValues.put(field2.getInt(null), field2.getName());
                            } else {
                                String name5 = field2.getName();
                                Intrinsics.checkNotNullExpressionValue(name5, "f.name");
                                if (StringsKt.startsWith$default(name5, "H263Profile", false, 2, (Object) null)) {
                                    this.mH263ProfileValues.put(field2.getInt(null), field2.getName());
                                } else {
                                    String name6 = field2.getName();
                                    Intrinsics.checkNotNullExpressionValue(name6, "f.name");
                                    if (StringsKt.startsWith$default(name6, "MPEG4Level", false, 2, (Object) null)) {
                                        this.mMPEG4LevelValues.put(field2.getInt(null), field2.getName());
                                    } else {
                                        String name7 = field2.getName();
                                        Intrinsics.checkNotNullExpressionValue(name7, "f.name");
                                        if (StringsKt.startsWith$default(name7, "MPEG4Profile", false, 2, (Object) null)) {
                                            this.mMPEG4ProfileValues.put(field2.getInt(null), field2.getName());
                                        } else {
                                            String name8 = field2.getName();
                                            Intrinsics.checkNotNullExpressionValue(name8, "f.name");
                                            if (StringsKt.startsWith$default(name8, "AAC", false, 2, (Object) null)) {
                                                this.mAACProfileValues.put(field2.getInt(null), field2.getName());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | SecurityException unused) {
        }
    }

    private final JSONObject collectMediaCodecList() throws JSONException {
        MediaCodecInfo[] codecInfos;
        prepare();
        if (Build.VERSION.SDK_INT < 21) {
            int codecCount = MediaCodecList.getCodecCount();
            codecInfos = new MediaCodecInfo[codecCount];
            if (codecCount > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    codecInfos[i] = MediaCodecList.getCodecInfoAt(i);
                    if (i2 >= codecCount) {
                        break;
                    }
                    i = i2;
                }
            }
        } else {
            codecInfos = new MediaCodecList(1).getCodecInfos();
            Intrinsics.checkNotNullExpressionValue(codecInfos, "MediaCodecList(MediaCodecList.ALL_CODECS).codecInfos");
        }
        JSONObject jSONObject = new JSONObject();
        int length = codecInfos.length - 1;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                MediaCodecInfo mediaCodecInfo = codecInfos[i3];
                JSONObject jSONObject2 = new JSONObject();
                Intrinsics.checkNotNull(mediaCodecInfo);
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                jSONObject2.put("name", mediaCodecInfo.getName()).put("isEncoder", mediaCodecInfo.isEncoder());
                JSONObject jSONObject3 = new JSONObject();
                Intrinsics.checkNotNullExpressionValue(supportedTypes, "supportedTypes");
                int length2 = supportedTypes.length;
                int i5 = 0;
                while (i5 < length2) {
                    String type = supportedTypes[i5];
                    i5++;
                    Intrinsics.checkNotNullExpressionValue(type, "type");
                    jSONObject3.put(type, collectCapabilitiesForType(mediaCodecInfo, type));
                }
                jSONObject2.put("supportedTypes", jSONObject3);
                jSONObject.put(String.valueOf(i3), jSONObject2);
                if (i4 > length) {
                    break;
                }
                i3 = i4;
            }
        }
        return jSONObject;
    }

    private final JSONObject collectCapabilitiesForType(MediaCodecInfo mediaCodecInfo, String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int[] colorFormats = capabilitiesForType.colorFormats;
        Intrinsics.checkNotNullExpressionValue(colorFormats, "colorFormats");
        int i = 0;
        if (!(colorFormats.length == 0)) {
            JSONArray jSONArray = new JSONArray();
            int length = colorFormats.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = colorFormats[i2];
                i2++;
                jSONArray.put(this.mColorFormatValues.get(i3));
            }
            jSONObject.put("colorFormats", jSONArray);
        }
        CodecType identifyCodecType = identifyCodecType(mediaCodecInfo);
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevels = capabilitiesForType.profileLevels;
        Intrinsics.checkNotNullExpressionValue(codecProfileLevels, "codecProfileLevels");
        if (!(codecProfileLevels.length == 0)) {
            JSONArray jSONArray2 = new JSONArray();
            int length2 = codecProfileLevels.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevels[i];
                i++;
                int i4 = codecProfileLevel.profile;
                int i5 = codecProfileLevel.level;
                if (identifyCodecType == null) {
                    jSONArray2.put(i4 + 45 + i5);
                    break;
                }
                int i6 = WhenMappings.$EnumSwitchMapping$0[identifyCodecType.ordinal()];
                if (i6 == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i4);
                    sb.append((Object) this.mAVCProfileValues.get(i4));
                    sb.append('-');
                    sb.append((Object) this.mAVCLevelValues.get(i5));
                    jSONArray2.put(sb.toString());
                } else if (i6 == 2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((Object) this.mH263ProfileValues.get(i4));
                    sb2.append('-');
                    sb2.append((Object) this.mH263LevelValues.get(i5));
                    jSONArray2.put(sb2.toString());
                } else if (i6 == 3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append((Object) this.mMPEG4ProfileValues.get(i4));
                    sb3.append('-');
                    sb3.append((Object) this.mMPEG4LevelValues.get(i5));
                    jSONArray2.put(sb3.toString());
                } else if (i6 == 4) {
                    jSONArray2.put(this.mAACProfileValues.get(i4));
                }
            }
            jSONObject.put("profileLevels", jSONArray2);
        }
        return jSONObject;
    }

    private final CodecType identifyCodecType(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        Intrinsics.checkNotNullExpressionValue(name, "codecInfo.name");
        String[] strArr = AVC_TYPES;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str, false, 2, (Object) null)) {
                return CodecType.AVC;
            }
        }
        String[] strArr2 = H263_TYPES;
        int length2 = strArr2.length;
        int i2 = 0;
        while (i2 < length2) {
            String str2 = strArr2[i2];
            i2++;
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str2, false, 2, (Object) null)) {
                return CodecType.H263;
            }
        }
        String[] strArr3 = MPEG4_TYPES;
        int length3 = strArr3.length;
        int i3 = 0;
        while (i3 < length3) {
            String str3 = strArr3[i3];
            i3++;
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str3, false, 2, (Object) null)) {
                return CodecType.MPEG4;
            }
        }
        String[] strArr4 = AAC_TYPES;
        int length4 = strArr4.length;
        int i4 = 0;
        while (i4 < length4) {
            String str4 = strArr4[i4];
            i4++;
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str4, false, 2, (Object) null)) {
                return CodecType.AAC;
            }
        }
        return null;
    }

    /* compiled from: MediaCodecListCollector.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, m107d2 = {"Lorg/acra/collector/MediaCodecListCollector$Companion;", "", "()V", "AAC_TYPES", "", "", "[Ljava/lang/String;", "AVC_TYPES", "COLOR_FORMAT_PREFIX", "H263_TYPES", "MPEG4_TYPES", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
