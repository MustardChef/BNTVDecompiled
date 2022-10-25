package com.lagradost.cloudstream3.movieproviders;

import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Ascii;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: SuperStream.kt */
@Metadata(m108d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001:\u0019<=>?@ABCDEFGHIJKLMNOPQRSTB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0011\u0010!\u001a\u00020\"H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'JI\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020.0,H\u0096@ø\u0001\u0000¢\u0006\u0002\u00101J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u00105\u001a\u0002H6\"\n\b\u0000\u00106\u0018\u0001*\u0002072\u0006\u00104\u001a\u00020\u0004H\u0082Hø\u0001\u0000¢\u0006\u0002\u0010'J\b\u00108\u001a\u00020\u0004H\u0002J\u001f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\u0006\u00104\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream;", "Lcom/lagradost/cloudstream3/MainAPI;", "()V", "apiUrl", "", "appId", "appKey", "hasChromecastSupport", "", "getHasChromecastSupport", "()Z", "hasMainPage", "getHasMainPage", "headers", "", "instantLinkLoading", "getInstantLinkLoading", "ip", "iv", SDKConstants.PARAM_KEY, "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "token", "getExpiryDate", "", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryApi", "Lcom/lagradost/nicehttp/NiceResponse;", "query", "queryApiParsed", ExifInterface.GPS_DIRECTION_TRUE, "", "randomToken", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "CipherUtils", "Data", "DataJSON", "HexDump", "LinkData", "LinkDataProp", "LinkList", "ListJSON", "LoadData", "MD5Util", "MainData", "MovieData", "MovieDataProp", "ParsedLinkData", "PostJSON", "PrivateSubtitleData", "ResponseTypes", "SeriesData", "SeriesDataProp", "SeriesEpisode", "SeriesLanguage", "SeriesSeasonProp", "SubtitleDataProp", "SubtitleList", "Subtitles", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SuperStream extends MainAPI {
    private final String apiUrl;
    private final String appId;
    private final String appKey;

    /* renamed from: ip */
    private final String f9973ip;
    private String name = "SuperStream";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;
    private final Set<TvType> supportedTypes = SetsKt.setOf((Object[]) new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AnimeMovie});
    private final boolean instantLinkLoading = true;
    private final Map<String, String> headers = MapsKt.mapOf(TuplesKt.m100to("Platform", "android"), TuplesKt.m100to("Accept", "charset=utf-8"));
    private final String token = randomToken();

    /* renamed from: iv */
    private final String f9974iv = MainAPIKt.base64Decode("d0VpcGhUbiE=");
    private final String key = MainAPIKt.base64Decode("MTIzZDZjZWRmNjI2ZHk1NDIzM2FhMXc2");

    public SuperStream() {
        String base64Decode = MainAPIKt.base64Decode("aHR0cHM6Ly8xNTIuMzIuMTQ5LjE2MA==");
        this.f9973ip = base64Decode;
        this.apiUrl = base64Decode + MainAPIKt.base64Decode("L2FwaS9hcGlfY2xpZW50L2luZGV4Lw==");
        this.appKey = MainAPIKt.base64Decode("bW92aWVib3g=");
        this.appId = MainAPIKt.base64Decode("Y29tLnRkby5zaG93Ym94");
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public String getName() {
        return this.name;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ResponseTypes;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toTvType", "Lcom/lagradost/cloudstream3/TvType;", "Series", "Movies", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public enum ResponseTypes {
        Series(2),
        Movies(1);
        
        public static final Companion Companion = new Companion(null);
        private final int value;

        ResponseTypes(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public final TvType toTvType() {
            return this == Series ? TvType.TvSeries : TvType.Movie;
        }

        /* compiled from: SuperStream.kt */
        @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ResponseTypes$Companion;", "", "()V", "getResponseType", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ResponseTypes;", "value", "", "(Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ResponseTypes;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ResponseTypes getResponseType(Integer num) {
                ResponseTypes responseTypes;
                ResponseTypes[] values = ResponseTypes.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        responseTypes = null;
                        break;
                    }
                    responseTypes = values[i];
                    if (num != null && responseTypes.getValue() == num.intValue()) {
                        break;
                    }
                    i++;
                }
                return responseTypes == null ? ResponseTypes.Movies : responseTypes;
            }
        }
    }

    @Override // com.lagradost.cloudstream3.MainAPI
    public boolean getInstantLinkLoading() {
        return this.instantLinkLoading;
    }

    private final String randomToken() {
        return CollectionsKt.joinToString$default(new IntRange(0, 31), "", null, null, 0, null, SuperStream$randomToken$1.INSTANCE, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$CipherUtils;", "", "()V", "ALGORITHM", "", "TRANSFORMATION", "encrypt", "str", SDKConstants.PARAM_KEY, "iv", "getVerify", "str2", "str3", "md5", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class CipherUtils {
        private static final String ALGORITHM = "DESede";
        public static final CipherUtils INSTANCE = new CipherUtils();
        private static final String TRANSFORMATION = "DESede/CBC/PKCS5Padding";

        private CipherUtils() {
        }

        public final String encrypt(String str, String key, String iv) {
            Intrinsics.checkNotNullParameter(str, "str");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(iv, "iv");
            try {
                Cipher cipher = Cipher.getInstance(TRANSFORMATION);
                Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(TRANSFORMATION)");
                byte[] bArr = new byte[24];
                byte[] bytes = key.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                int length = bytes.length <= 24 ? bytes.length : 24;
                System.arraycopy(bytes, 0, bArr, 0, length);
                while (length < 24) {
                    bArr[length] = 0;
                    length++;
                }
                byte[] bytes2 = iv.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                cipher.init(1, new SecretKeySpec(bArr, ALGORITHM), new IvParameterSpec(bytes2));
                byte[] bytes3 = str.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                byte[] encode = Base64.encode(cipher.doFinal(bytes3), 2);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(cipher.doFinal(str.toByteArray()), 2)");
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new String(encode, UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public final String md5(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            byte[] md5 = MD5Util.INSTANCE.md5(str);
            if (md5 != null) {
                String lowerCase = HexDump.toHexString$default(HexDump.INSTANCE, md5, 0, 0, 6, null).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                return lowerCase;
            }
            return null;
        }

        public final String getVerify(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str2, "str2");
            Intrinsics.checkNotNullParameter(str3, "str3");
            if (str != null) {
                return md5(md5(str2) + str3 + str);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$HexDump;", "", "()V", "HEX_DIGITS", "", "toHexString", "", "bArr", "", "i", "", "i2", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class HexDump {
        public static final HexDump INSTANCE = new HexDump();
        private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        public final String toHexString(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "bArr");
            return toHexString$default(this, bArr, 0, 0, 6, null);
        }

        public final String toHexString(byte[] bArr, int i) {
            Intrinsics.checkNotNullParameter(bArr, "bArr");
            return toHexString$default(this, bArr, i, 0, 4, null);
        }

        private HexDump() {
        }

        public static /* synthetic */ String toHexString$default(HexDump hexDump, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return hexDump.toHexString(bArr, i, i2);
        }

        public final String toHexString(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "bArr");
            char[] cArr = new char[i2 * 2];
            int i3 = i2 + i;
            int i4 = 0;
            while (i < i3) {
                byte b = bArr[i];
                int i5 = i4 + 1;
                char[] cArr2 = HEX_DIGITS;
                cArr[i4] = cArr2[(b >>> 4) & 15];
                i4 = i5 + 1;
                cArr[i5] = cArr2[b & Ascii.f9766SI];
                i++;
            }
            return new String(cArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MD5Util;", "", "()V", "md5", "", "bArr", "str", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MD5Util {
        public static final MD5Util INSTANCE = new MD5Util();

        private MD5Util() {
        }

        public final byte[] md5(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return md5(bytes);
        }

        public final byte[] md5(byte[] bArr) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (bArr == null) {
                    return null;
                }
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object queryApi(String str, Continuation<? super NiceResponse> continuation) {
        String encrypt = CipherUtils.INSTANCE.encrypt(str, this.key, this.f9974iv);
        Intrinsics.checkNotNull(encrypt);
        String md5 = CipherUtils.INSTANCE.md5(this.appKey);
        Intrinsics.checkNotNull(md5);
        byte[] bytes = ("{\"app_key\":\"" + md5 + "\",\"verify\":\"" + CipherUtils.INSTANCE.getVerify(encrypt, this.appKey, this.key) + "\",\"encrypt_data\":\"" + encrypt + "\"}").getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] encode = Base64.encode(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encode, "encode(newBody.toByteArray(), Base64.DEFAULT)");
        String str2 = new String(encode, Charsets.UTF_8);
        return Requests.post$default(MainActivityKt.getApp(), this.apiUrl, this.headers, null, null, null, MapsKt.mapOf(TuplesKt.m100to("data", str2), TuplesKt.m100to("appid", "27"), TuplesKt.m100to("platform", "android"), TuplesKt.m100to(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "129"), TuplesKt.m100to("medium", "Website&token" + this.token)), null, null, null, false, 0, null, 0L, null, false, continuation, 32732, null);
    }

    private final /* synthetic */ <T> Object queryApiParsed(String str, Continuation<? super T> continuation) {
        InlineMarker.mark(0);
        Object queryApi = queryApi(str, continuation);
        InlineMarker.mark(1);
        ObjectMapper mapper = Requests.Companion.getMapper();
        String text = ((NiceResponse) queryApi).getText();
        Intrinsics.needClassReification();
        return mapper.readValue(text, new TypeReference<T>() { // from class: com.lagradost.cloudstream3.movieproviders.SuperStream$queryApiParsed$$inlined$parsed$1
        });
    }

    private final long getExpiryDate() {
        return APIHolder.INSTANCE.getUnixTime() + 43200;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PostJSON;", "", "id", "", "title", "", "poster", "poster2", "boxType", "imdbRating", "quality_tag", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getImdbRating", "()Ljava/lang/String;", "getPoster", "getPoster2", "getQuality_tag", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PostJSON;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class PostJSON {
        private final Integer boxType;

        /* renamed from: id */
        private final Integer f9979id;
        private final String imdbRating;
        private final String poster;
        private final String poster2;
        private final String quality_tag;
        private final String title;

        public PostJSON() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ PostJSON copy$default(PostJSON postJSON, Integer num, String str, String str2, String str3, Integer num2, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                num = postJSON.f9979id;
            }
            if ((i & 2) != 0) {
                str = postJSON.title;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = postJSON.poster;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = postJSON.poster2;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                num2 = postJSON.boxType;
            }
            Integer num3 = num2;
            if ((i & 32) != 0) {
                str4 = postJSON.imdbRating;
            }
            String str9 = str4;
            if ((i & 64) != 0) {
                str5 = postJSON.quality_tag;
            }
            return postJSON.copy(num, str6, str7, str8, num3, str9, str5);
        }

        public final Integer component1() {
            return this.f9979id;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.poster;
        }

        public final String component4() {
            return this.poster2;
        }

        public final Integer component5() {
            return this.boxType;
        }

        public final String component6() {
            return this.imdbRating;
        }

        public final String component7() {
            return this.quality_tag;
        }

        public final PostJSON copy(@JsonProperty("id") Integer num, @JsonProperty("title") String str, @JsonProperty("poster") String str2, @JsonProperty("poster_2") String str3, @JsonProperty("box_type") Integer num2, @JsonProperty("imdb_rating") String str4, @JsonProperty("quality_tag") String str5) {
            return new PostJSON(num, str, str2, str3, num2, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PostJSON) {
                PostJSON postJSON = (PostJSON) obj;
                return Intrinsics.areEqual(this.f9979id, postJSON.f9979id) && Intrinsics.areEqual(this.title, postJSON.title) && Intrinsics.areEqual(this.poster, postJSON.poster) && Intrinsics.areEqual(this.poster2, postJSON.poster2) && Intrinsics.areEqual(this.boxType, postJSON.boxType) && Intrinsics.areEqual(this.imdbRating, postJSON.imdbRating) && Intrinsics.areEqual(this.quality_tag, postJSON.quality_tag);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9979id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.title;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.poster;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.poster2;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num2 = this.boxType;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str4 = this.imdbRating;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.quality_tag;
            return hashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "PostJSON(id=" + this.f9979id + ", title=" + this.title + ", poster=" + this.poster + ", poster2=" + this.poster2 + ", boxType=" + this.boxType + ", imdbRating=" + this.imdbRating + ", quality_tag=" + this.quality_tag + ')';
        }

        public PostJSON(@JsonProperty("id") Integer num, @JsonProperty("title") String str, @JsonProperty("poster") String str2, @JsonProperty("poster_2") String str3, @JsonProperty("box_type") Integer num2, @JsonProperty("imdb_rating") String str4, @JsonProperty("quality_tag") String str5) {
            this.f9979id = num;
            this.title = str;
            this.poster = str2;
            this.poster2 = str3;
            this.boxType = num2;
            this.imdbRating = str4;
            this.quality_tag = str5;
        }

        public /* synthetic */ PostJSON(Integer num, String str, String str2, String str3, Integer num2, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
        }

        public final Integer getId() {
            return this.f9979id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final String getPoster2() {
            return this.poster2;
        }

        public final Integer getBoxType() {
            return this.boxType;
        }

        public final String getImdbRating() {
            return this.imdbRating;
        }

        public final String getQuality_tag() {
            return this.quality_tag;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003JX\u0010\u001b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ListJSON;", "", "code", "", "type", "", "name", "boxType", "list", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PostJSON;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "getList", "()Ljava/util/ArrayList;", "getName", "()Ljava/lang/String;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ListJSON;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ListJSON {
        private final Integer boxType;
        private final Integer code;
        private final ArrayList<PostJSON> list;
        private final String name;
        private final String type;

        public ListJSON() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ ListJSON copy$default(ListJSON listJSON, Integer num, String str, String str2, Integer num2, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                num = listJSON.code;
            }
            if ((i & 2) != 0) {
                str = listJSON.type;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = listJSON.name;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                num2 = listJSON.boxType;
            }
            Integer num3 = num2;
            ArrayList<PostJSON> arrayList2 = arrayList;
            if ((i & 16) != 0) {
                arrayList2 = listJSON.list;
            }
            return listJSON.copy(num, str3, str4, num3, arrayList2);
        }

        public final Integer component1() {
            return this.code;
        }

        public final String component2() {
            return this.type;
        }

        public final String component3() {
            return this.name;
        }

        public final Integer component4() {
            return this.boxType;
        }

        public final ArrayList<PostJSON> component5() {
            return this.list;
        }

        public final ListJSON copy(@JsonProperty("code") Integer num, @JsonProperty("type") String str, @JsonProperty("name") String str2, @JsonProperty("box_type") Integer num2, @JsonProperty("list") ArrayList<PostJSON> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            return new ListJSON(num, str, str2, num2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListJSON) {
                ListJSON listJSON = (ListJSON) obj;
                return Intrinsics.areEqual(this.code, listJSON.code) && Intrinsics.areEqual(this.type, listJSON.type) && Intrinsics.areEqual(this.name, listJSON.name) && Intrinsics.areEqual(this.boxType, listJSON.boxType) && Intrinsics.areEqual(this.list, listJSON.list);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.code;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.type;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            Integer num2 = this.boxType;
            return ((hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31) + this.list.hashCode();
        }

        public String toString() {
            return "ListJSON(code=" + this.code + ", type=" + this.type + ", name=" + this.name + ", boxType=" + this.boxType + ", list=" + this.list + ')';
        }

        public ListJSON(@JsonProperty("code") Integer num, @JsonProperty("type") String str, @JsonProperty("name") String str2, @JsonProperty("box_type") Integer num2, @JsonProperty("list") ArrayList<PostJSON> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.code = num;
            this.type = str;
            this.name = str2;
            this.boxType = num2;
            this.list = list;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getType() {
            return this.type;
        }

        public final String getName() {
            return this.name;
        }

        public final Integer getBoxType() {
            return this.boxType;
        }

        public /* synthetic */ ListJSON(Integer num, String str, String str2, Integer num2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) == 0 ? num2 : null, (i & 16) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<PostJSON> getList() {
            return this.list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$DataJSON;", "", "data", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ListJSON;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class DataJSON {
        private final ArrayList<ListJSON> data;

        public DataJSON() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataJSON copy$default(DataJSON dataJSON, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = dataJSON.data;
            }
            return dataJSON.copy(arrayList);
        }

        public final ArrayList<ListJSON> component1() {
            return this.data;
        }

        public final DataJSON copy(@JsonProperty("data") ArrayList<ListJSON> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new DataJSON(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DataJSON) && Intrinsics.areEqual(this.data, ((DataJSON) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "DataJSON(data=" + this.data + ')';
        }

        public DataJSON(@JsonProperty("data") ArrayList<ListJSON> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public /* synthetic */ DataJSON(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<ListJSON> getData() {
            return this.data;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.lagradost.cloudstream3.HomePageList] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getMainPage(kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r20) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SuperStream.getMainPage(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jz\u0010#\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0010\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,J\t\u0010-\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000f¨\u0006."}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Data;", "", "id", "", "boxType", "title", "", "posterOrg", "poster", "cats", "year", "imdbRating", "qualityTag", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCats", "()Ljava/lang/String;", "getId", "getImdbRating", "getPoster", "getPosterOrg", "getQualityTag", "getTitle", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Data;", "equals", "", "other", "hashCode", "toSearchResponse", "Lcom/lagradost/cloudstream3/MovieSearchResponse;", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Data {
        private final Integer boxType;
        private final String cats;

        /* renamed from: id */
        private final Integer f9975id;
        private final String imdbRating;
        private final String poster;
        private final String posterOrg;
        private final String qualityTag;
        private final String title;
        private final Integer year;

        public Data() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public final Integer component1() {
            return this.f9975id;
        }

        public final Integer component2() {
            return this.boxType;
        }

        public final String component3() {
            return this.title;
        }

        public final String component4() {
            return this.posterOrg;
        }

        public final String component5() {
            return this.poster;
        }

        public final String component6() {
            return this.cats;
        }

        public final Integer component7() {
            return this.year;
        }

        public final String component8() {
            return this.imdbRating;
        }

        public final String component9() {
            return this.qualityTag;
        }

        public final Data copy(@JsonProperty("id") Integer num, @JsonProperty("box_type") Integer num2, @JsonProperty("title") String str, @JsonProperty("poster_org") String str2, @JsonProperty("poster") String str3, @JsonProperty("cats") String str4, @JsonProperty("year") Integer num3, @JsonProperty("imdb_rating") String str5, @JsonProperty("quality_tag") String str6) {
            return new Data(num, num2, str, str2, str3, str4, num3, str5, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.f9975id, data.f9975id) && Intrinsics.areEqual(this.boxType, data.boxType) && Intrinsics.areEqual(this.title, data.title) && Intrinsics.areEqual(this.posterOrg, data.posterOrg) && Intrinsics.areEqual(this.poster, data.poster) && Intrinsics.areEqual(this.cats, data.cats) && Intrinsics.areEqual(this.year, data.year) && Intrinsics.areEqual(this.imdbRating, data.imdbRating) && Intrinsics.areEqual(this.qualityTag, data.qualityTag);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9975id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.boxType;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.title;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.posterOrg;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.poster;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.cats;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num3 = this.year;
            int hashCode7 = (hashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str5 = this.imdbRating;
            int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.qualityTag;
            return hashCode8 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            return "Data(id=" + this.f9975id + ", boxType=" + this.boxType + ", title=" + this.title + ", posterOrg=" + this.posterOrg + ", poster=" + this.poster + ", cats=" + this.cats + ", year=" + this.year + ", imdbRating=" + this.imdbRating + ", qualityTag=" + this.qualityTag + ')';
        }

        public Data(@JsonProperty("id") Integer num, @JsonProperty("box_type") Integer num2, @JsonProperty("title") String str, @JsonProperty("poster_org") String str2, @JsonProperty("poster") String str3, @JsonProperty("cats") String str4, @JsonProperty("year") Integer num3, @JsonProperty("imdb_rating") String str5, @JsonProperty("quality_tag") String str6) {
            this.f9975id = num;
            this.boxType = num2;
            this.title = str;
            this.posterOrg = str2;
            this.poster = str3;
            this.cats = str4;
            this.year = num3;
            this.imdbRating = str5;
            this.qualityTag = str6;
        }

        public /* synthetic */ Data(Integer num, Integer num2, String str, String str2, String str3, String str4, Integer num3, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? null : str5, (i & 256) == 0 ? str6 : null);
        }

        public final Integer getId() {
            return this.f9975id;
        }

        public final Integer getBoxType() {
            return this.boxType;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getPosterOrg() {
            return this.posterOrg;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final String getCats() {
            return this.cats;
        }

        public final Integer getYear() {
            return this.year;
        }

        public final String getImdbRating() {
            return this.imdbRating;
        }

        public final String getQualityTag() {
            return this.qualityTag;
        }

        public final MovieSearchResponse toSearchResponse(MainAPI api) {
            Intrinsics.checkNotNullParameter(api, "api");
            String str = this.title;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            AppUtils appUtils = AppUtils.INSTANCE;
            Integer num = this.f9975id;
            if (num != null) {
                return MainAPIKt.newMovieSearchResponse(api, str2, appUtils.toJson(new LoadData(num.intValue(), this.boxType)), ResponseTypes.Companion.getResponseType(this.boxType).toTvType(), false, new SuperStream$Data$toSearchResponse$1(this));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MainData;", "", "data", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Data;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MainData {
        private final ArrayList<Data> data;

        public MainData() {
            this(null, 1, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MainData copy$default(MainData mainData, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = mainData.data;
            }
            return mainData.copy(arrayList);
        }

        public final ArrayList<Data> component1() {
            return this.data;
        }

        public final MainData copy(@JsonProperty("data") ArrayList<Data> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new MainData(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MainData) && Intrinsics.areEqual(this.data, ((MainData) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "MainData(data=" + this.data + ')';
        }

        public MainData(@JsonProperty("data") ArrayList<Data> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.data = data;
        }

        public /* synthetic */ MainData(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<Data> getData() {
            return this.data;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object search(java.lang.String r6, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.lagradost.cloudstream3.movieproviders.SuperStream$search$1
            if (r0 == 0) goto L14
            r0 = r7
            com.lagradost.cloudstream3.movieproviders.SuperStream$search$1 r0 = (com.lagradost.cloudstream3.movieproviders.SuperStream$search$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.lagradost.cloudstream3.movieproviders.SuperStream$search$1 r0 = new com.lagradost.cloudstream3.movieproviders.SuperStream$search$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            com.lagradost.cloudstream3.movieproviders.SuperStream r6 = (com.lagradost.cloudstream3.movieproviders.SuperStream) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L7c
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "{\"childmode\":\""
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = "\",\"app_version\":\"11.5\",\"appid\":\""
            r2.append(r7)
            java.lang.String r7 = r5.appId
            r2.append(r7)
            java.lang.String r7 = "\",\"module\":\"Search3\",\"channel\":\"Website\",\"page\":\"1\",\"lang\":\"en\",\"type\":\"all\",\"keyword\":\""
            r2.append(r7)
            r2.append(r6)
            java.lang.String r6 = "\",\"pagelimit\":\"20\",\"expired_date\":\""
            r2.append(r6)
            long r6 = r5.getExpiryDate()
            r2.append(r6)
            java.lang.String r6 = "\",\"platform\":\"android\"}"
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.lagradost.cloudstream3.utils.AppUtils r7 = com.lagradost.cloudstream3.utils.AppUtils.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r7 = r5.queryApi(r6, r0)
            if (r7 != r1) goto L7b
            return r1
        L7b:
            r6 = r5
        L7c:
            com.lagradost.nicehttp.NiceResponse r7 = (com.lagradost.nicehttp.NiceResponse) r7
            java.lang.String r7 = r7.getText()
            com.fasterxml.jackson.databind.json.JsonMapper r0 = com.lagradost.cloudstream3.MainAPIKt.getMapper()
            com.fasterxml.jackson.databind.ObjectMapper r0 = (com.fasterxml.jackson.databind.ObjectMapper) r0
            com.lagradost.cloudstream3.movieproviders.SuperStream$search$$inlined$parseJson$1 r1 = new com.lagradost.cloudstream3.movieproviders.SuperStream$search$$inlined$parseJson$1
            r1.<init>()
            com.fasterxml.jackson.core.type.TypeReference r1 = (com.fasterxml.jackson.core.type.TypeReference) r1
            java.lang.Object r7 = r0.readValue(r7, r1)
            com.lagradost.cloudstream3.movieproviders.SuperStream$MainData r7 = (com.lagradost.cloudstream3.movieproviders.SuperStream.MainData) r7
            java.util.ArrayList r7 = r7.getData()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r7 = r7.iterator()
        La6:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Lbf
            java.lang.Object r1 = r7.next()
            com.lagradost.cloudstream3.movieproviders.SuperStream$Data r1 = (com.lagradost.cloudstream3.movieproviders.SuperStream.Data) r1
            r2 = r6
            com.lagradost.cloudstream3.MainAPI r2 = (com.lagradost.cloudstream3.MainAPI) r2
            com.lagradost.cloudstream3.MovieSearchResponse r1 = r1.toSearchResponse(r2)
            if (r1 == 0) goto La6
            r0.add(r1)
            goto La6
        Lbf:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SuperStream.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LoadData;", "", "id", "", "type", "(ILjava/lang/Integer;)V", "getId", "()I", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LoadData;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LoadData {

        /* renamed from: id */
        private final int f9977id;
        private final Integer type;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, int i, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = loadData.f9977id;
            }
            if ((i2 & 2) != 0) {
                num = loadData.type;
            }
            return loadData.copy(i, num);
        }

        public final int component1() {
            return this.f9977id;
        }

        public final Integer component2() {
            return this.type;
        }

        public final LoadData copy(int i, Integer num) {
            return new LoadData(i, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadData) {
                LoadData loadData = (LoadData) obj;
                return this.f9977id == loadData.f9977id && Intrinsics.areEqual(this.type, loadData.type);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f9977id * 31;
            Integer num = this.type;
            return i + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "LoadData(id=" + this.f9977id + ", type=" + this.type + ')';
        }

        public LoadData(int i, Integer num) {
            this.f9977id = i;
            this.type = num;
        }

        public final int getId() {
            return this.f9977id;
        }

        public final Integer getType() {
            return this.type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0091\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0003\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\u0010\u001cJ\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009a\u0002\u0010M\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aHÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u0003HÖ\u0001J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b/\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b1\u0010 R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b2\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\b6\u0010 ¨\u0006T"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MovieData;", "", "id", "", "title", "", "director", "writer", "actors", "runtime", "poster", "description", "cats", "year", "imdbId", "imdbRating", "trailer", "released", "contentRating", "tmdbId", "tomatoMeter", "posterOrg", "trailerUrl", "imdbLink", "boxType", "recommend", "", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Data;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getActors", "()Ljava/lang/String;", "getBoxType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCats", "getContentRating", "getDescription", "getDirector", "getId", "getImdbId", "getImdbLink", "getImdbRating", "getPoster", "getPosterOrg", "getRecommend", "()Ljava/util/List;", "getReleased", "getRuntime", "getTitle", "getTmdbId", "getTomatoMeter", "getTrailer", "getTrailerUrl", "getWriter", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MovieData;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MovieData {
        private final String actors;
        private final Integer boxType;
        private final String cats;
        private final String contentRating;
        private final String description;
        private final String director;

        /* renamed from: id */
        private final Integer f9978id;
        private final String imdbId;
        private final String imdbLink;
        private final String imdbRating;
        private final String poster;
        private final String posterOrg;
        private final List<Data> recommend;
        private final String released;
        private final Integer runtime;
        private final String title;
        private final Integer tmdbId;
        private final Integer tomatoMeter;
        private final String trailer;
        private final String trailerUrl;
        private final String writer;
        private final Integer year;

        public MovieData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        public final Integer component1() {
            return this.f9978id;
        }

        public final Integer component10() {
            return this.year;
        }

        public final String component11() {
            return this.imdbId;
        }

        public final String component12() {
            return this.imdbRating;
        }

        public final String component13() {
            return this.trailer;
        }

        public final String component14() {
            return this.released;
        }

        public final String component15() {
            return this.contentRating;
        }

        public final Integer component16() {
            return this.tmdbId;
        }

        public final Integer component17() {
            return this.tomatoMeter;
        }

        public final String component18() {
            return this.posterOrg;
        }

        public final String component19() {
            return this.trailerUrl;
        }

        public final String component2() {
            return this.title;
        }

        public final String component20() {
            return this.imdbLink;
        }

        public final Integer component21() {
            return this.boxType;
        }

        public final List<Data> component22() {
            return this.recommend;
        }

        public final String component3() {
            return this.director;
        }

        public final String component4() {
            return this.writer;
        }

        public final String component5() {
            return this.actors;
        }

        public final Integer component6() {
            return this.runtime;
        }

        public final String component7() {
            return this.poster;
        }

        public final String component8() {
            return this.description;
        }

        public final String component9() {
            return this.cats;
        }

        public final MovieData copy(@JsonProperty("id") Integer num, @JsonProperty("title") String str, @JsonProperty("director") String str2, @JsonProperty("writer") String str3, @JsonProperty("actors") String str4, @JsonProperty("runtime") Integer num2, @JsonProperty("poster") String str5, @JsonProperty("description") String str6, @JsonProperty("cats") String str7, @JsonProperty("year") Integer num3, @JsonProperty("imdb_id") String str8, @JsonProperty("imdb_rating") String str9, @JsonProperty("trailer") String str10, @JsonProperty("released") String str11, @JsonProperty("content_rating") String str12, @JsonProperty("tmdb_id") Integer num4, @JsonProperty("tomato_meter") Integer num5, @JsonProperty("poster_org") String str13, @JsonProperty("trailer_url") String str14, @JsonProperty("imdb_link") String str15, @JsonProperty("box_type") Integer num6, @JsonProperty("recommend") List<Data> recommend) {
            Intrinsics.checkNotNullParameter(recommend, "recommend");
            return new MovieData(num, str, str2, str3, str4, num2, str5, str6, str7, num3, str8, str9, str10, str11, str12, num4, num5, str13, str14, str15, num6, recommend);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MovieData) {
                MovieData movieData = (MovieData) obj;
                return Intrinsics.areEqual(this.f9978id, movieData.f9978id) && Intrinsics.areEqual(this.title, movieData.title) && Intrinsics.areEqual(this.director, movieData.director) && Intrinsics.areEqual(this.writer, movieData.writer) && Intrinsics.areEqual(this.actors, movieData.actors) && Intrinsics.areEqual(this.runtime, movieData.runtime) && Intrinsics.areEqual(this.poster, movieData.poster) && Intrinsics.areEqual(this.description, movieData.description) && Intrinsics.areEqual(this.cats, movieData.cats) && Intrinsics.areEqual(this.year, movieData.year) && Intrinsics.areEqual(this.imdbId, movieData.imdbId) && Intrinsics.areEqual(this.imdbRating, movieData.imdbRating) && Intrinsics.areEqual(this.trailer, movieData.trailer) && Intrinsics.areEqual(this.released, movieData.released) && Intrinsics.areEqual(this.contentRating, movieData.contentRating) && Intrinsics.areEqual(this.tmdbId, movieData.tmdbId) && Intrinsics.areEqual(this.tomatoMeter, movieData.tomatoMeter) && Intrinsics.areEqual(this.posterOrg, movieData.posterOrg) && Intrinsics.areEqual(this.trailerUrl, movieData.trailerUrl) && Intrinsics.areEqual(this.imdbLink, movieData.imdbLink) && Intrinsics.areEqual(this.boxType, movieData.boxType) && Intrinsics.areEqual(this.recommend, movieData.recommend);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9978id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.title;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.director;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.writer;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.actors;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num2 = this.runtime;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str5 = this.poster;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.description;
            int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.cats;
            int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Integer num3 = this.year;
            int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str8 = this.imdbId;
            int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.imdbRating;
            int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
            String str10 = this.trailer;
            int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.released;
            int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.contentRating;
            int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Integer num4 = this.tmdbId;
            int hashCode16 = (hashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.tomatoMeter;
            int hashCode17 = (hashCode16 + (num5 == null ? 0 : num5.hashCode())) * 31;
            String str13 = this.posterOrg;
            int hashCode18 = (hashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.trailerUrl;
            int hashCode19 = (hashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.imdbLink;
            int hashCode20 = (hashCode19 + (str15 == null ? 0 : str15.hashCode())) * 31;
            Integer num6 = this.boxType;
            return ((hashCode20 + (num6 != null ? num6.hashCode() : 0)) * 31) + this.recommend.hashCode();
        }

        public String toString() {
            return "MovieData(id=" + this.f9978id + ", title=" + this.title + ", director=" + this.director + ", writer=" + this.writer + ", actors=" + this.actors + ", runtime=" + this.runtime + ", poster=" + this.poster + ", description=" + this.description + ", cats=" + this.cats + ", year=" + this.year + ", imdbId=" + this.imdbId + ", imdbRating=" + this.imdbRating + ", trailer=" + this.trailer + ", released=" + this.released + ", contentRating=" + this.contentRating + ", tmdbId=" + this.tmdbId + ", tomatoMeter=" + this.tomatoMeter + ", posterOrg=" + this.posterOrg + ", trailerUrl=" + this.trailerUrl + ", imdbLink=" + this.imdbLink + ", boxType=" + this.boxType + ", recommend=" + this.recommend + ')';
        }

        public MovieData(@JsonProperty("id") Integer num, @JsonProperty("title") String str, @JsonProperty("director") String str2, @JsonProperty("writer") String str3, @JsonProperty("actors") String str4, @JsonProperty("runtime") Integer num2, @JsonProperty("poster") String str5, @JsonProperty("description") String str6, @JsonProperty("cats") String str7, @JsonProperty("year") Integer num3, @JsonProperty("imdb_id") String str8, @JsonProperty("imdb_rating") String str9, @JsonProperty("trailer") String str10, @JsonProperty("released") String str11, @JsonProperty("content_rating") String str12, @JsonProperty("tmdb_id") Integer num4, @JsonProperty("tomato_meter") Integer num5, @JsonProperty("poster_org") String str13, @JsonProperty("trailer_url") String str14, @JsonProperty("imdb_link") String str15, @JsonProperty("box_type") Integer num6, @JsonProperty("recommend") List<Data> recommend) {
            Intrinsics.checkNotNullParameter(recommend, "recommend");
            this.f9978id = num;
            this.title = str;
            this.director = str2;
            this.writer = str3;
            this.actors = str4;
            this.runtime = num2;
            this.poster = str5;
            this.description = str6;
            this.cats = str7;
            this.year = num3;
            this.imdbId = str8;
            this.imdbRating = str9;
            this.trailer = str10;
            this.released = str11;
            this.contentRating = str12;
            this.tmdbId = num4;
            this.tomatoMeter = num5;
            this.posterOrg = str13;
            this.trailerUrl = str14;
            this.imdbLink = str15;
            this.boxType = num6;
            this.recommend = recommend;
        }

        public final Integer getId() {
            return this.f9978id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getDirector() {
            return this.director;
        }

        public final String getWriter() {
            return this.writer;
        }

        public final String getActors() {
            return this.actors;
        }

        public final Integer getRuntime() {
            return this.runtime;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getCats() {
            return this.cats;
        }

        public final Integer getYear() {
            return this.year;
        }

        public final String getImdbId() {
            return this.imdbId;
        }

        public final String getImdbRating() {
            return this.imdbRating;
        }

        public final String getTrailer() {
            return this.trailer;
        }

        public final String getReleased() {
            return this.released;
        }

        public final String getContentRating() {
            return this.contentRating;
        }

        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        public final String getPosterOrg() {
            return this.posterOrg;
        }

        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        public final String getImdbLink() {
            return this.imdbLink;
        }

        public final Integer getBoxType() {
            return this.boxType;
        }

        public /* synthetic */ MovieData(Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, String str6, String str7, Integer num3, String str8, String str9, String str10, String str11, String str12, Integer num4, Integer num5, String str13, String str14, String str15, Integer num6, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : num3, (i & 1024) != 0 ? null : str8, (i & 2048) != 0 ? null : str9, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : str12, (i & 32768) != 0 ? null : num4, (i & 65536) != 0 ? null : num5, (i & 131072) != 0 ? null : str13, (i & 262144) != 0 ? null : str14, (i & 524288) != 0 ? null : str15, (i & 1048576) != 0 ? null : num6, (i & 2097152) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<Data> getRecommend() {
            return this.recommend;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MovieDataProp;", "", "data", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MovieData;", "(Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MovieData;)V", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/SuperStream$MovieData;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class MovieDataProp {
        private final MovieData data;

        public MovieDataProp() {
            this(null, 1, null);
        }

        public static /* synthetic */ MovieDataProp copy$default(MovieDataProp movieDataProp, MovieData movieData, int i, Object obj) {
            if ((i & 1) != 0) {
                movieData = movieDataProp.data;
            }
            return movieDataProp.copy(movieData);
        }

        public final MovieData component1() {
            return this.data;
        }

        public final MovieDataProp copy(@JsonProperty("data") MovieData movieData) {
            return new MovieDataProp(movieData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof MovieDataProp) && Intrinsics.areEqual(this.data, ((MovieDataProp) obj).data);
        }

        public int hashCode() {
            MovieData movieData = this.data;
            if (movieData == null) {
                return 0;
            }
            return movieData.hashCode();
        }

        public String toString() {
            return "MovieDataProp(data=" + this.data + ')';
        }

        public MovieDataProp(@JsonProperty("data") MovieData movieData) {
            this.data = movieData;
        }

        public /* synthetic */ MovieDataProp(MovieData movieData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            MovieDataProp movieDataProp;
            MovieData movieData2;
            if ((i & 1) != 0) {
                movieData2 = new MovieData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
                movieDataProp = this;
            } else {
                movieDataProp = this;
                movieData2 = movieData;
            }
            new MovieDataProp(movieData2);
        }

        public final MovieData getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesDataProp;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesData;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesData;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesData;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesDataProp;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeriesDataProp {
        private final Integer code;
        private final SeriesData data;
        private final String msg;

        public SeriesDataProp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SeriesDataProp copy$default(SeriesDataProp seriesDataProp, Integer num, String str, SeriesData seriesData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seriesDataProp.code;
            }
            if ((i & 2) != 0) {
                str = seriesDataProp.msg;
            }
            if ((i & 4) != 0) {
                seriesData = seriesDataProp.data;
            }
            return seriesDataProp.copy(num, str, seriesData);
        }

        public final Integer component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final SeriesData component3() {
            return this.data;
        }

        public final SeriesDataProp copy(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") SeriesData seriesData) {
            return new SeriesDataProp(num, str, seriesData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeriesDataProp) {
                SeriesDataProp seriesDataProp = (SeriesDataProp) obj;
                return Intrinsics.areEqual(this.code, seriesDataProp.code) && Intrinsics.areEqual(this.msg, seriesDataProp.msg) && Intrinsics.areEqual(this.data, seriesDataProp.data);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.code;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.msg;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            SeriesData seriesData = this.data;
            return hashCode2 + (seriesData != null ? seriesData.hashCode() : 0);
        }

        public String toString() {
            return "SeriesDataProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SeriesDataProp(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") SeriesData seriesData) {
            this.code = num;
            this.msg = str;
            this.data = seriesData;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public /* synthetic */ SeriesDataProp(Integer num, String str, SeriesData seriesData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            SeriesDataProp seriesDataProp;
            SeriesData seriesData2;
            Integer num2 = (i & 1) != 0 ? null : num;
            String str2 = (i & 2) == 0 ? str : null;
            if ((i & 4) != 0) {
                seriesData2 = new SeriesData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 33554431, null);
                seriesDataProp = this;
            } else {
                seriesDataProp = this;
                seriesData2 = seriesData;
            }
            new SeriesDataProp(num2, str2, seriesData2);
        }

        public final SeriesData getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0003JD\u0010\u0015\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0003\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesSeasonProp;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesEpisode;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Ljava/util/ArrayList;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesSeasonProp;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeriesSeasonProp {
        private final Integer code;
        private final ArrayList<SeriesEpisode> data;
        private final String msg;

        public SeriesSeasonProp() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SeriesSeasonProp copy$default(SeriesSeasonProp seriesSeasonProp, Integer num, String str, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                num = seriesSeasonProp.code;
            }
            if ((i & 2) != 0) {
                str = seriesSeasonProp.msg;
            }
            if ((i & 4) != 0) {
                arrayList = seriesSeasonProp.data;
            }
            return seriesSeasonProp.copy(num, str, arrayList);
        }

        public final Integer component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final ArrayList<SeriesEpisode> component3() {
            return this.data;
        }

        public final SeriesSeasonProp copy(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") ArrayList<SeriesEpisode> arrayList) {
            return new SeriesSeasonProp(num, str, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeriesSeasonProp) {
                SeriesSeasonProp seriesSeasonProp = (SeriesSeasonProp) obj;
                return Intrinsics.areEqual(this.code, seriesSeasonProp.code) && Intrinsics.areEqual(this.msg, seriesSeasonProp.msg) && Intrinsics.areEqual(this.data, seriesSeasonProp.data);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.code;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.msg;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            ArrayList<SeriesEpisode> arrayList = this.data;
            return hashCode2 + (arrayList != null ? arrayList.hashCode() : 0);
        }

        public String toString() {
            return "SeriesSeasonProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SeriesSeasonProp(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") ArrayList<SeriesEpisode> arrayList) {
            this.code = num;
            this.msg = str;
            this.data = arrayList;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public /* synthetic */ SeriesSeasonProp(Integer num, String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<SeriesEpisode> getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\bf\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BÙ\u0003\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010,J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010_\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010h\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010m\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010p\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010w\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010.Jä\u0003\u0010\u0080\u0001\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0003\u0010\u0081\u0001J\u0016\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0086\u0001\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b0\u0010.R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b3\u0010.R\u0015\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b4\u0010.R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b5\u0010.R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b6\u0010.R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b7\u0010.R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b9\u0010.R\u0013\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u00102R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b<\u0010.R\u0013\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u00102R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\b>\u0010.R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u0013\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bD\u00102R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bE\u0010.R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bF\u0010.R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bG\u0010.R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bH\u0010.R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bI\u0010.R\u0015\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bJ\u0010.R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bK\u00102R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bM\u00102R\u0013\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u00102R\u0013\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bO\u00102R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bQ\u0010.R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bR\u00102R\u0015\u0010'\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bS\u0010.R\u0015\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bT\u0010.R\u0015\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bU\u0010.R\u0015\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bV\u0010.R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bW\u0010.R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010/\u001a\u0004\bX\u0010.¨\u0006\u0087\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesEpisode;", "", "id", "", "tid", "mbId", "imdbId", "", "imdbIdStatus", "srtStatus", "season", "episode", ServerProtocol.DIALOG_PARAM_STATE, "title", "thumbs", "thumbsBak", "thumbsOriginal", "posterImdb", "synopsis", "runtime", ViewHierarchyConstants.VIEW_KEY, "download", "sourceFile", "codeFile", "addTime", "updateTime", "released", "releasedTimestamp", "", "audioLang", "qualityTag", "_3d", "remark", "pending", "imdbRating", "display", "sync", "tomatoMeter", "tomatoMeterCount", "tomatoAudience", "tomatoAudienceCount", "thumbsMin", "thumbsOrg", "imdbLink", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "get_3d", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAddTime", "getAudioLang", "()Ljava/lang/String;", "getCodeFile", "getDisplay", "getDownload", "getEpisode", "getId", "getImdbId", "getImdbIdStatus", "getImdbLink", "getImdbRating", "getMbId", "getPending", "getPosterImdb", "getQualityTag", "getReleased", "getReleasedTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRemark", "getRuntime", "getSeason", "getSourceFile", "getSrtStatus", "getState", "getSync", "getSynopsis", "getThumbs", "getThumbsBak", "getThumbsMin", "getThumbsOrg", "getThumbsOriginal", "getTid", "getTitle", "getTomatoAudience", "getTomatoAudienceCount", "getTomatoMeter", "getTomatoMeterCount", "getUpdateTime", "getView", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesEpisode;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeriesEpisode {
        private final Integer _3d;
        private final Integer addTime;
        private final String audioLang;
        private final Integer codeFile;
        private final Integer display;
        private final Integer download;
        private final Integer episode;

        /* renamed from: id */
        private final Integer f9981id;
        private final String imdbId;
        private final Integer imdbIdStatus;
        private final String imdbLink;
        private final String imdbRating;
        private final Integer mbId;
        private final String pending;
        private final Integer posterImdb;
        private final String qualityTag;
        private final String released;
        private final Long releasedTimestamp;
        private final String remark;
        private final Integer runtime;
        private final Integer season;
        private final Integer sourceFile;
        private final Integer srtStatus;
        private final Integer state;
        private final Integer sync;
        private final String synopsis;
        private final String thumbs;
        private final String thumbsBak;
        private final String thumbsMin;
        private final String thumbsOrg;
        private final String thumbsOriginal;
        private final Integer tid;
        private final String title;
        private final Integer tomatoAudience;
        private final Integer tomatoAudienceCount;
        private final Integer tomatoMeter;
        private final Integer tomatoMeterCount;
        private final Integer updateTime;
        private final Integer view;

        public SeriesEpisode() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 127, null);
        }

        public final Integer component1() {
            return this.f9981id;
        }

        public final String component10() {
            return this.title;
        }

        public final String component11() {
            return this.thumbs;
        }

        public final String component12() {
            return this.thumbsBak;
        }

        public final String component13() {
            return this.thumbsOriginal;
        }

        public final Integer component14() {
            return this.posterImdb;
        }

        public final String component15() {
            return this.synopsis;
        }

        public final Integer component16() {
            return this.runtime;
        }

        public final Integer component17() {
            return this.view;
        }

        public final Integer component18() {
            return this.download;
        }

        public final Integer component19() {
            return this.sourceFile;
        }

        public final Integer component2() {
            return this.tid;
        }

        public final Integer component20() {
            return this.codeFile;
        }

        public final Integer component21() {
            return this.addTime;
        }

        public final Integer component22() {
            return this.updateTime;
        }

        public final String component23() {
            return this.released;
        }

        public final Long component24() {
            return this.releasedTimestamp;
        }

        public final String component25() {
            return this.audioLang;
        }

        public final String component26() {
            return this.qualityTag;
        }

        public final Integer component27() {
            return this._3d;
        }

        public final String component28() {
            return this.remark;
        }

        public final String component29() {
            return this.pending;
        }

        public final Integer component3() {
            return this.mbId;
        }

        public final String component30() {
            return this.imdbRating;
        }

        public final Integer component31() {
            return this.display;
        }

        public final Integer component32() {
            return this.sync;
        }

        public final Integer component33() {
            return this.tomatoMeter;
        }

        public final Integer component34() {
            return this.tomatoMeterCount;
        }

        public final Integer component35() {
            return this.tomatoAudience;
        }

        public final Integer component36() {
            return this.tomatoAudienceCount;
        }

        public final String component37() {
            return this.thumbsMin;
        }

        public final String component38() {
            return this.thumbsOrg;
        }

        public final String component39() {
            return this.imdbLink;
        }

        public final String component4() {
            return this.imdbId;
        }

        public final Integer component5() {
            return this.imdbIdStatus;
        }

        public final Integer component6() {
            return this.srtStatus;
        }

        public final Integer component7() {
            return this.season;
        }

        public final Integer component8() {
            return this.episode;
        }

        public final Integer component9() {
            return this.state;
        }

        public final SeriesEpisode copy(@JsonProperty("id") Integer num, @JsonProperty("tid") Integer num2, @JsonProperty("mb_id") Integer num3, @JsonProperty("imdb_id") String str, @JsonProperty("imdb_id_status") Integer num4, @JsonProperty("srt_status") Integer num5, @JsonProperty("season") Integer num6, @JsonProperty("episode") Integer num7, @JsonProperty("state") Integer num8, @JsonProperty("title") String str2, @JsonProperty("thumbs") String str3, @JsonProperty("thumbs_bak") String str4, @JsonProperty("thumbs_original") String str5, @JsonProperty("poster_imdb") Integer num9, @JsonProperty("synopsis") String str6, @JsonProperty("runtime") Integer num10, @JsonProperty("view") Integer num11, @JsonProperty("download") Integer num12, @JsonProperty("source_file") Integer num13, @JsonProperty("code_file") Integer num14, @JsonProperty("add_time") Integer num15, @JsonProperty("update_time") Integer num16, @JsonProperty("released") String str7, @JsonProperty("released_timestamp") Long l, @JsonProperty("audio_lang") String str8, @JsonProperty("quality_tag") String str9, @JsonProperty("3d") Integer num17, @JsonProperty("remark") String str10, @JsonProperty("pending") String str11, @JsonProperty("imdb_rating") String str12, @JsonProperty("display") Integer num18, @JsonProperty("sync") Integer num19, @JsonProperty("tomato_meter") Integer num20, @JsonProperty("tomato_meter_count") Integer num21, @JsonProperty("tomato_audience") Integer num22, @JsonProperty("tomato_audience_count") Integer num23, @JsonProperty("thumbs_min") String str13, @JsonProperty("thumbs_org") String str14, @JsonProperty("imdb_link") String str15) {
            return new SeriesEpisode(num, num2, num3, str, num4, num5, num6, num7, num8, str2, str3, str4, str5, num9, str6, num10, num11, num12, num13, num14, num15, num16, str7, l, str8, str9, num17, str10, str11, str12, num18, num19, num20, num21, num22, num23, str13, str14, str15);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeriesEpisode) {
                SeriesEpisode seriesEpisode = (SeriesEpisode) obj;
                return Intrinsics.areEqual(this.f9981id, seriesEpisode.f9981id) && Intrinsics.areEqual(this.tid, seriesEpisode.tid) && Intrinsics.areEqual(this.mbId, seriesEpisode.mbId) && Intrinsics.areEqual(this.imdbId, seriesEpisode.imdbId) && Intrinsics.areEqual(this.imdbIdStatus, seriesEpisode.imdbIdStatus) && Intrinsics.areEqual(this.srtStatus, seriesEpisode.srtStatus) && Intrinsics.areEqual(this.season, seriesEpisode.season) && Intrinsics.areEqual(this.episode, seriesEpisode.episode) && Intrinsics.areEqual(this.state, seriesEpisode.state) && Intrinsics.areEqual(this.title, seriesEpisode.title) && Intrinsics.areEqual(this.thumbs, seriesEpisode.thumbs) && Intrinsics.areEqual(this.thumbsBak, seriesEpisode.thumbsBak) && Intrinsics.areEqual(this.thumbsOriginal, seriesEpisode.thumbsOriginal) && Intrinsics.areEqual(this.posterImdb, seriesEpisode.posterImdb) && Intrinsics.areEqual(this.synopsis, seriesEpisode.synopsis) && Intrinsics.areEqual(this.runtime, seriesEpisode.runtime) && Intrinsics.areEqual(this.view, seriesEpisode.view) && Intrinsics.areEqual(this.download, seriesEpisode.download) && Intrinsics.areEqual(this.sourceFile, seriesEpisode.sourceFile) && Intrinsics.areEqual(this.codeFile, seriesEpisode.codeFile) && Intrinsics.areEqual(this.addTime, seriesEpisode.addTime) && Intrinsics.areEqual(this.updateTime, seriesEpisode.updateTime) && Intrinsics.areEqual(this.released, seriesEpisode.released) && Intrinsics.areEqual(this.releasedTimestamp, seriesEpisode.releasedTimestamp) && Intrinsics.areEqual(this.audioLang, seriesEpisode.audioLang) && Intrinsics.areEqual(this.qualityTag, seriesEpisode.qualityTag) && Intrinsics.areEqual(this._3d, seriesEpisode._3d) && Intrinsics.areEqual(this.remark, seriesEpisode.remark) && Intrinsics.areEqual(this.pending, seriesEpisode.pending) && Intrinsics.areEqual(this.imdbRating, seriesEpisode.imdbRating) && Intrinsics.areEqual(this.display, seriesEpisode.display) && Intrinsics.areEqual(this.sync, seriesEpisode.sync) && Intrinsics.areEqual(this.tomatoMeter, seriesEpisode.tomatoMeter) && Intrinsics.areEqual(this.tomatoMeterCount, seriesEpisode.tomatoMeterCount) && Intrinsics.areEqual(this.tomatoAudience, seriesEpisode.tomatoAudience) && Intrinsics.areEqual(this.tomatoAudienceCount, seriesEpisode.tomatoAudienceCount) && Intrinsics.areEqual(this.thumbsMin, seriesEpisode.thumbsMin) && Intrinsics.areEqual(this.thumbsOrg, seriesEpisode.thumbsOrg) && Intrinsics.areEqual(this.imdbLink, seriesEpisode.imdbLink);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9981id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.tid;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.mbId;
            int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
            String str = this.imdbId;
            int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num4 = this.imdbIdStatus;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.srtStatus;
            int hashCode6 = (hashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.season;
            int hashCode7 = (hashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.episode;
            int hashCode8 = (hashCode7 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.state;
            int hashCode9 = (hashCode8 + (num8 == null ? 0 : num8.hashCode())) * 31;
            String str2 = this.title;
            int hashCode10 = (hashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.thumbs;
            int hashCode11 = (hashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.thumbsBak;
            int hashCode12 = (hashCode11 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.thumbsOriginal;
            int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num9 = this.posterImdb;
            int hashCode14 = (hashCode13 + (num9 == null ? 0 : num9.hashCode())) * 31;
            String str6 = this.synopsis;
            int hashCode15 = (hashCode14 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num10 = this.runtime;
            int hashCode16 = (hashCode15 + (num10 == null ? 0 : num10.hashCode())) * 31;
            Integer num11 = this.view;
            int hashCode17 = (hashCode16 + (num11 == null ? 0 : num11.hashCode())) * 31;
            Integer num12 = this.download;
            int hashCode18 = (hashCode17 + (num12 == null ? 0 : num12.hashCode())) * 31;
            Integer num13 = this.sourceFile;
            int hashCode19 = (hashCode18 + (num13 == null ? 0 : num13.hashCode())) * 31;
            Integer num14 = this.codeFile;
            int hashCode20 = (hashCode19 + (num14 == null ? 0 : num14.hashCode())) * 31;
            Integer num15 = this.addTime;
            int hashCode21 = (hashCode20 + (num15 == null ? 0 : num15.hashCode())) * 31;
            Integer num16 = this.updateTime;
            int hashCode22 = (hashCode21 + (num16 == null ? 0 : num16.hashCode())) * 31;
            String str7 = this.released;
            int hashCode23 = (hashCode22 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Long l = this.releasedTimestamp;
            int hashCode24 = (hashCode23 + (l == null ? 0 : l.hashCode())) * 31;
            String str8 = this.audioLang;
            int hashCode25 = (hashCode24 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.qualityTag;
            int hashCode26 = (hashCode25 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Integer num17 = this._3d;
            int hashCode27 = (hashCode26 + (num17 == null ? 0 : num17.hashCode())) * 31;
            String str10 = this.remark;
            int hashCode28 = (hashCode27 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.pending;
            int hashCode29 = (hashCode28 + (str11 == null ? 0 : str11.hashCode())) * 31;
            String str12 = this.imdbRating;
            int hashCode30 = (hashCode29 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Integer num18 = this.display;
            int hashCode31 = (hashCode30 + (num18 == null ? 0 : num18.hashCode())) * 31;
            Integer num19 = this.sync;
            int hashCode32 = (hashCode31 + (num19 == null ? 0 : num19.hashCode())) * 31;
            Integer num20 = this.tomatoMeter;
            int hashCode33 = (hashCode32 + (num20 == null ? 0 : num20.hashCode())) * 31;
            Integer num21 = this.tomatoMeterCount;
            int hashCode34 = (hashCode33 + (num21 == null ? 0 : num21.hashCode())) * 31;
            Integer num22 = this.tomatoAudience;
            int hashCode35 = (hashCode34 + (num22 == null ? 0 : num22.hashCode())) * 31;
            Integer num23 = this.tomatoAudienceCount;
            int hashCode36 = (hashCode35 + (num23 == null ? 0 : num23.hashCode())) * 31;
            String str13 = this.thumbsMin;
            int hashCode37 = (hashCode36 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.thumbsOrg;
            int hashCode38 = (hashCode37 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.imdbLink;
            return hashCode38 + (str15 != null ? str15.hashCode() : 0);
        }

        public String toString() {
            return "SeriesEpisode(id=" + this.f9981id + ", tid=" + this.tid + ", mbId=" + this.mbId + ", imdbId=" + this.imdbId + ", imdbIdStatus=" + this.imdbIdStatus + ", srtStatus=" + this.srtStatus + ", season=" + this.season + ", episode=" + this.episode + ", state=" + this.state + ", title=" + this.title + ", thumbs=" + this.thumbs + ", thumbsBak=" + this.thumbsBak + ", thumbsOriginal=" + this.thumbsOriginal + ", posterImdb=" + this.posterImdb + ", synopsis=" + this.synopsis + ", runtime=" + this.runtime + ", view=" + this.view + ", download=" + this.download + ", sourceFile=" + this.sourceFile + ", codeFile=" + this.codeFile + ", addTime=" + this.addTime + ", updateTime=" + this.updateTime + ", released=" + this.released + ", releasedTimestamp=" + this.releasedTimestamp + ", audioLang=" + this.audioLang + ", qualityTag=" + this.qualityTag + ", _3d=" + this._3d + ", remark=" + this.remark + ", pending=" + this.pending + ", imdbRating=" + this.imdbRating + ", display=" + this.display + ", sync=" + this.sync + ", tomatoMeter=" + this.tomatoMeter + ", tomatoMeterCount=" + this.tomatoMeterCount + ", tomatoAudience=" + this.tomatoAudience + ", tomatoAudienceCount=" + this.tomatoAudienceCount + ", thumbsMin=" + this.thumbsMin + ", thumbsOrg=" + this.thumbsOrg + ", imdbLink=" + this.imdbLink + ')';
        }

        public SeriesEpisode(@JsonProperty("id") Integer num, @JsonProperty("tid") Integer num2, @JsonProperty("mb_id") Integer num3, @JsonProperty("imdb_id") String str, @JsonProperty("imdb_id_status") Integer num4, @JsonProperty("srt_status") Integer num5, @JsonProperty("season") Integer num6, @JsonProperty("episode") Integer num7, @JsonProperty("state") Integer num8, @JsonProperty("title") String str2, @JsonProperty("thumbs") String str3, @JsonProperty("thumbs_bak") String str4, @JsonProperty("thumbs_original") String str5, @JsonProperty("poster_imdb") Integer num9, @JsonProperty("synopsis") String str6, @JsonProperty("runtime") Integer num10, @JsonProperty("view") Integer num11, @JsonProperty("download") Integer num12, @JsonProperty("source_file") Integer num13, @JsonProperty("code_file") Integer num14, @JsonProperty("add_time") Integer num15, @JsonProperty("update_time") Integer num16, @JsonProperty("released") String str7, @JsonProperty("released_timestamp") Long l, @JsonProperty("audio_lang") String str8, @JsonProperty("quality_tag") String str9, @JsonProperty("3d") Integer num17, @JsonProperty("remark") String str10, @JsonProperty("pending") String str11, @JsonProperty("imdb_rating") String str12, @JsonProperty("display") Integer num18, @JsonProperty("sync") Integer num19, @JsonProperty("tomato_meter") Integer num20, @JsonProperty("tomato_meter_count") Integer num21, @JsonProperty("tomato_audience") Integer num22, @JsonProperty("tomato_audience_count") Integer num23, @JsonProperty("thumbs_min") String str13, @JsonProperty("thumbs_org") String str14, @JsonProperty("imdb_link") String str15) {
            this.f9981id = num;
            this.tid = num2;
            this.mbId = num3;
            this.imdbId = str;
            this.imdbIdStatus = num4;
            this.srtStatus = num5;
            this.season = num6;
            this.episode = num7;
            this.state = num8;
            this.title = str2;
            this.thumbs = str3;
            this.thumbsBak = str4;
            this.thumbsOriginal = str5;
            this.posterImdb = num9;
            this.synopsis = str6;
            this.runtime = num10;
            this.view = num11;
            this.download = num12;
            this.sourceFile = num13;
            this.codeFile = num14;
            this.addTime = num15;
            this.updateTime = num16;
            this.released = str7;
            this.releasedTimestamp = l;
            this.audioLang = str8;
            this.qualityTag = str9;
            this._3d = num17;
            this.remark = str10;
            this.pending = str11;
            this.imdbRating = str12;
            this.display = num18;
            this.sync = num19;
            this.tomatoMeter = num20;
            this.tomatoMeterCount = num21;
            this.tomatoAudience = num22;
            this.tomatoAudienceCount = num23;
            this.thumbsMin = str13;
            this.thumbsOrg = str14;
            this.imdbLink = str15;
        }

        public /* synthetic */ SeriesEpisode(Integer num, Integer num2, Integer num3, String str, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, String str2, String str3, String str4, String str5, Integer num9, String str6, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, String str7, Long l, String str8, String str9, Integer num17, String str10, String str11, String str12, Integer num18, Integer num19, Integer num20, Integer num21, Integer num22, Integer num23, String str13, String str14, String str15, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5, (i & 64) != 0 ? null : num6, (i & 128) != 0 ? null : num7, (i & 256) != 0 ? null : num8, (i & 512) != 0 ? null : str2, (i & 1024) != 0 ? null : str3, (i & 2048) != 0 ? null : str4, (i & 4096) != 0 ? null : str5, (i & 8192) != 0 ? null : num9, (i & 16384) != 0 ? null : str6, (i & 32768) != 0 ? null : num10, (i & 65536) != 0 ? null : num11, (i & 131072) != 0 ? null : num12, (i & 262144) != 0 ? null : num13, (i & 524288) != 0 ? null : num14, (i & 1048576) != 0 ? null : num15, (i & 2097152) != 0 ? null : num16, (i & 4194304) != 0 ? null : str7, (i & 8388608) != 0 ? null : l, (i & 16777216) != 0 ? null : str8, (i & 33554432) != 0 ? null : str9, (i & 67108864) != 0 ? null : num17, (i & 134217728) != 0 ? null : str10, (i & 268435456) != 0 ? null : str11, (i & 536870912) != 0 ? null : str12, (i & 1073741824) != 0 ? null : num18, (i & Integer.MIN_VALUE) != 0 ? null : num19, (i2 & 1) != 0 ? null : num20, (i2 & 2) != 0 ? null : num21, (i2 & 4) != 0 ? null : num22, (i2 & 8) != 0 ? null : num23, (i2 & 16) != 0 ? null : str13, (i2 & 32) != 0 ? null : str14, (i2 & 64) != 0 ? null : str15);
        }

        public final Integer getId() {
            return this.f9981id;
        }

        public final Integer getTid() {
            return this.tid;
        }

        public final Integer getMbId() {
            return this.mbId;
        }

        public final String getImdbId() {
            return this.imdbId;
        }

        public final Integer getImdbIdStatus() {
            return this.imdbIdStatus;
        }

        public final Integer getSrtStatus() {
            return this.srtStatus;
        }

        public final Integer getSeason() {
            return this.season;
        }

        public final Integer getEpisode() {
            return this.episode;
        }

        public final Integer getState() {
            return this.state;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getThumbs() {
            return this.thumbs;
        }

        public final String getThumbsBak() {
            return this.thumbsBak;
        }

        public final String getThumbsOriginal() {
            return this.thumbsOriginal;
        }

        public final Integer getPosterImdb() {
            return this.posterImdb;
        }

        public final String getSynopsis() {
            return this.synopsis;
        }

        public final Integer getRuntime() {
            return this.runtime;
        }

        public final Integer getView() {
            return this.view;
        }

        public final Integer getDownload() {
            return this.download;
        }

        public final Integer getSourceFile() {
            return this.sourceFile;
        }

        public final Integer getCodeFile() {
            return this.codeFile;
        }

        public final Integer getAddTime() {
            return this.addTime;
        }

        public final Integer getUpdateTime() {
            return this.updateTime;
        }

        public final String getReleased() {
            return this.released;
        }

        public final Long getReleasedTimestamp() {
            return this.releasedTimestamp;
        }

        public final String getAudioLang() {
            return this.audioLang;
        }

        public final String getQualityTag() {
            return this.qualityTag;
        }

        public final Integer get_3d() {
            return this._3d;
        }

        public final String getRemark() {
            return this.remark;
        }

        public final String getPending() {
            return this.pending;
        }

        public final String getImdbRating() {
            return this.imdbRating;
        }

        public final Integer getDisplay() {
            return this.display;
        }

        public final Integer getSync() {
            return this.sync;
        }

        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        public final Integer getTomatoMeterCount() {
            return this.tomatoMeterCount;
        }

        public final Integer getTomatoAudience() {
            return this.tomatoAudience;
        }

        public final Integer getTomatoAudienceCount() {
            return this.tomatoAudienceCount;
        }

        public final String getThumbsMin() {
            return this.thumbsMin;
        }

        public final String getThumbsOrg() {
            return this.thumbsOrg;
        }

        public final String getImdbLink() {
            return this.imdbLink;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesLanguage;", "", "title", "", "lang", "(Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeriesLanguage {
        private final String lang;
        private final String title;

        public SeriesLanguage() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ SeriesLanguage copy$default(SeriesLanguage seriesLanguage, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = seriesLanguage.title;
            }
            if ((i & 2) != 0) {
                str2 = seriesLanguage.lang;
            }
            return seriesLanguage.copy(str, str2);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.lang;
        }

        public final SeriesLanguage copy(@JsonProperty("title") String str, @JsonProperty("lang") String str2) {
            return new SeriesLanguage(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeriesLanguage) {
                SeriesLanguage seriesLanguage = (SeriesLanguage) obj;
                return Intrinsics.areEqual(this.title, seriesLanguage.title) && Intrinsics.areEqual(this.lang, seriesLanguage.lang);
            }
            return false;
        }

        public int hashCode() {
            String str = this.title;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.lang;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SeriesLanguage(title=" + this.title + ", lang=" + this.lang + ')';
        }

        public SeriesLanguage(@JsonProperty("title") String str, @JsonProperty("lang") String str2) {
            this.title = str;
            this.lang = str2;
        }

        public /* synthetic */ SeriesLanguage(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getLang() {
            return this.lang;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u007f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B÷\u0005\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0003\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`7\u0012\u0018\b\u0003\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`7\u0012\u0018\b\u0003\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000606j\b\u0012\u0004\u0012\u00020\u0006`7\u0012\n\b\u0003\u0010:\u001a\u0004\u0018\u00010\u0006\u0012\u0018\b\u0003\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`7\u0012\u0018\b\u0003\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>06j\b\u0012\u0004\u0012\u00020>`7\u0012\n\b\u0003\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010BJ\u0011\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010§\u0001\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0002\u0010|J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001a\u0010\u00ad\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`7HÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u001a\u0010¯\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`7HÆ\u0003J\u001a\u0010°\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u000606j\b\u0012\u0004\u0012\u00020\u0006`7HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001a\u0010²\u0001\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`7HÆ\u0003J\u001a\u0010³\u0001\u001a\u0012\u0012\u0004\u0012\u00020>06j\b\u0012\u0004\u0012\u00020>`7HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010·\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\u0011\u0010¸\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010FJ\f\u0010¹\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\f\u0010º\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0082\u0006\u0010»\u0001\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u00101\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u00103\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u00104\u001a\u0004\u0018\u00010\u00062\u0018\b\u0003\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`72\u0018\b\u0003\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`72\u0018\b\u0003\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000606j\b\u0012\u0004\u0012\u00020\u0006`72\n\b\u0003\u0010:\u001a\u0004\u0018\u00010\u00062\u0018\b\u0003\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`72\u0018\b\u0003\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>06j\b\u0012\u0004\u0012\u00020>`72\n\b\u0003\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010@\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0003\u0010¼\u0001J\u0016\u0010½\u0001\u001a\u00030¾\u00012\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010À\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010Á\u0001\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bE\u0010FR\u0015\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bH\u0010FR\u0015\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bI\u0010FR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010DR\u0013\u00102\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u0010DR\u0013\u00103\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bL\u0010DR\u0015\u0010?\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bM\u0010FR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bN\u0010DR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bO\u0010FR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bP\u0010FR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010DR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bR\u0010DR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bS\u0010DR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bT\u0010FR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bU\u0010FR\u0013\u0010-\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bV\u0010DR!\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<06j\b\u0012\u0004\u0012\u00020<`7¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bY\u0010DR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bZ\u0010FR!\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000606j\b\u0012\u0004\u0012\u00020\u0006`7¢\u0006\b\n\u0000\u001a\u0004\b[\u0010XR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\b\\\u0010FR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b]\u0010DR\u0013\u0010:\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b^\u0010DR\u0013\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b_\u0010DR!\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>06j\b\u0012\u0004\u0012\u00020>`7¢\u0006\b\n\u0000\u001a\u0004\b`\u0010XR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\ba\u0010FR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bb\u0010FR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bc\u0010FR\u0015\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bd\u0010FR\u0015\u0010,\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\be\u0010FR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bf\u0010DR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bg\u0010FR\u0013\u00100\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bh\u0010DR\u0013\u00101\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bi\u0010DR\u0013\u0010(\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bj\u0010DR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bk\u0010DR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bl\u0010FR\u0013\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bm\u0010DR!\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`7¢\u0006\b\n\u0000\u001a\u0004\bn\u0010XR\u0013\u0010A\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bo\u0010DR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bp\u0010FR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bq\u0010DR\u0015\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\br\u0010FR\u0015\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bs\u0010FR\u0015\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bt\u0010FR\u0013\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bu\u0010DR\u0013\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bv\u0010DR\u0013\u00104\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bw\u0010DR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bx\u0010DR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\by\u0010FR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\bz\u0010FR\u0015\u0010.\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0002\u0010}\u001a\u0004\b{\u0010|R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b~\u0010DR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010G\u001a\u0004\b\u007f\u0010FR\u0014\u0010@\u001a\u0004\u0018\u00010\u0006¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010DR\"\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000306j\b\u0012\u0004\u0012\u00020\u0003`7¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010X¨\u0006Â\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesData;", "", "id", "", "mbId", "title", "", "display", ServerProtocol.DIALOG_PARAM_STATE, "vipOnly", "codeFile", "director", "writer", "actors", "addTime", "poster", "posterImdb", "bannerMini", "description", "imdbId", "cats", "year", "collect", ViewHierarchyConstants.VIEW_KEY, "download", "updateTime", "released", "releasedTimestamp", "episodeReleased", "episodeReleasedTimestamp", "maxSeason", "maxEpisode", "remark", "imdbRating", "contentRating", "tmdbId", "tomatoUrl", "tomatoMeter", "tomatoMeterCount", "tomatoMeterState", "reelgoodUrl", "audienceScore", "audienceScoreCount", "noTomatoUrl", "orderYear", "episodateId", "weightsDay", "", "posterMin", "posterOrg", "bannerMiniMin", "bannerMiniOrg", "trailerUrl", "years", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "season", "history", "imdbLink", "episode", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesEpisode;", "language", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesLanguage;", "boxType", "yearYear", "seasonEpisode", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getActors", "()Ljava/lang/String;", "getAddTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAudienceScore", "getAudienceScoreCount", "getBannerMini", "getBannerMiniMin", "getBannerMiniOrg", "getBoxType", "getCats", "getCodeFile", "getCollect", "getContentRating", "getDescription", "getDirector", "getDisplay", "getDownload", "getEpisodateId", "getEpisode", "()Ljava/util/ArrayList;", "getEpisodeReleased", "getEpisodeReleasedTimestamp", "getHistory", "getId", "getImdbId", "getImdbLink", "getImdbRating", "getLanguage", "getMaxEpisode", "getMaxSeason", "getMbId", "getNoTomatoUrl", "getOrderYear", "getPoster", "getPosterImdb", "getPosterMin", "getPosterOrg", "getReelgoodUrl", "getReleased", "getReleasedTimestamp", "getRemark", "getSeason", "getSeasonEpisode", "getState", "getTitle", "getTmdbId", "getTomatoMeter", "getTomatoMeterCount", "getTomatoMeterState", "getTomatoUrl", "getTrailerUrl", "getUpdateTime", "getView", "getVipOnly", "getWeightsDay", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getWriter", "getYear", "getYearYear", "getYears", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SeriesData;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SeriesData {
        private final String actors;
        private final Integer addTime;
        private final Integer audienceScore;
        private final Integer audienceScoreCount;
        private final String bannerMini;
        private final String bannerMiniMin;
        private final String bannerMiniOrg;
        private final Integer boxType;
        private final String cats;
        private final Integer codeFile;
        private final Integer collect;
        private final String contentRating;
        private final String description;
        private final String director;
        private final Integer display;
        private final Integer download;
        private final String episodateId;
        private final ArrayList<SeriesEpisode> episode;
        private final String episodeReleased;
        private final Integer episodeReleasedTimestamp;
        private final ArrayList<String> history;

        /* renamed from: id */
        private final Integer f9980id;
        private final String imdbId;
        private final String imdbLink;
        private final String imdbRating;
        private final ArrayList<SeriesLanguage> language;
        private final Integer maxEpisode;
        private final Integer maxSeason;
        private final Integer mbId;
        private final Integer noTomatoUrl;
        private final Integer orderYear;
        private final String poster;
        private final Integer posterImdb;
        private final String posterMin;
        private final String posterOrg;
        private final String reelgoodUrl;
        private final String released;
        private final Integer releasedTimestamp;
        private final String remark;
        private final ArrayList<Integer> season;
        private final String seasonEpisode;
        private final Integer state;
        private final String title;
        private final Integer tmdbId;
        private final Integer tomatoMeter;
        private final Integer tomatoMeterCount;
        private final String tomatoMeterState;
        private final String tomatoUrl;
        private final String trailerUrl;
        private final String updateTime;
        private final Integer view;
        private final Integer vipOnly;
        private final Double weightsDay;
        private final String writer;
        private final Integer year;
        private final String yearYear;
        private final ArrayList<Integer> years;

        public SeriesData() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 33554431, null);
        }

        public final Integer component1() {
            return this.f9980id;
        }

        public final String component10() {
            return this.actors;
        }

        public final Integer component11() {
            return this.addTime;
        }

        public final String component12() {
            return this.poster;
        }

        public final Integer component13() {
            return this.posterImdb;
        }

        public final String component14() {
            return this.bannerMini;
        }

        public final String component15() {
            return this.description;
        }

        public final String component16() {
            return this.imdbId;
        }

        public final String component17() {
            return this.cats;
        }

        public final Integer component18() {
            return this.year;
        }

        public final Integer component19() {
            return this.collect;
        }

        public final Integer component2() {
            return this.mbId;
        }

        public final Integer component20() {
            return this.view;
        }

        public final Integer component21() {
            return this.download;
        }

        public final String component22() {
            return this.updateTime;
        }

        public final String component23() {
            return this.released;
        }

        public final Integer component24() {
            return this.releasedTimestamp;
        }

        public final String component25() {
            return this.episodeReleased;
        }

        public final Integer component26() {
            return this.episodeReleasedTimestamp;
        }

        public final Integer component27() {
            return this.maxSeason;
        }

        public final Integer component28() {
            return this.maxEpisode;
        }

        public final String component29() {
            return this.remark;
        }

        public final String component3() {
            return this.title;
        }

        public final String component30() {
            return this.imdbRating;
        }

        public final String component31() {
            return this.contentRating;
        }

        public final Integer component32() {
            return this.tmdbId;
        }

        public final String component33() {
            return this.tomatoUrl;
        }

        public final Integer component34() {
            return this.tomatoMeter;
        }

        public final Integer component35() {
            return this.tomatoMeterCount;
        }

        public final String component36() {
            return this.tomatoMeterState;
        }

        public final String component37() {
            return this.reelgoodUrl;
        }

        public final Integer component38() {
            return this.audienceScore;
        }

        public final Integer component39() {
            return this.audienceScoreCount;
        }

        public final Integer component4() {
            return this.display;
        }

        public final Integer component40() {
            return this.noTomatoUrl;
        }

        public final Integer component41() {
            return this.orderYear;
        }

        public final String component42() {
            return this.episodateId;
        }

        public final Double component43() {
            return this.weightsDay;
        }

        public final String component44() {
            return this.posterMin;
        }

        public final String component45() {
            return this.posterOrg;
        }

        public final String component46() {
            return this.bannerMiniMin;
        }

        public final String component47() {
            return this.bannerMiniOrg;
        }

        public final String component48() {
            return this.trailerUrl;
        }

        public final ArrayList<Integer> component49() {
            return this.years;
        }

        public final Integer component5() {
            return this.state;
        }

        public final ArrayList<Integer> component50() {
            return this.season;
        }

        public final ArrayList<String> component51() {
            return this.history;
        }

        public final String component52() {
            return this.imdbLink;
        }

        public final ArrayList<SeriesEpisode> component53() {
            return this.episode;
        }

        public final ArrayList<SeriesLanguage> component54() {
            return this.language;
        }

        public final Integer component55() {
            return this.boxType;
        }

        public final String component56() {
            return this.yearYear;
        }

        public final String component57() {
            return this.seasonEpisode;
        }

        public final Integer component6() {
            return this.vipOnly;
        }

        public final Integer component7() {
            return this.codeFile;
        }

        public final String component8() {
            return this.director;
        }

        public final String component9() {
            return this.writer;
        }

        public final SeriesData copy(@JsonProperty("id") Integer num, @JsonProperty("mb_id") Integer num2, @JsonProperty("title") String str, @JsonProperty("display") Integer num3, @JsonProperty("state") Integer num4, @JsonProperty("vip_only") Integer num5, @JsonProperty("code_file") Integer num6, @JsonProperty("director") String str2, @JsonProperty("writer") String str3, @JsonProperty("actors") String str4, @JsonProperty("add_time") Integer num7, @JsonProperty("poster") String str5, @JsonProperty("poster_imdb") Integer num8, @JsonProperty("banner_mini") String str6, @JsonProperty("description") String str7, @JsonProperty("imdb_id") String str8, @JsonProperty("cats") String str9, @JsonProperty("year") Integer num9, @JsonProperty("collect") Integer num10, @JsonProperty("view") Integer num11, @JsonProperty("download") Integer num12, @JsonProperty("update_time") String str10, @JsonProperty("released") String str11, @JsonProperty("released_timestamp") Integer num13, @JsonProperty("episode_released") String str12, @JsonProperty("episode_released_timestamp") Integer num14, @JsonProperty("max_season") Integer num15, @JsonProperty("max_episode") Integer num16, @JsonProperty("remark") String str13, @JsonProperty("imdb_rating") String str14, @JsonProperty("content_rating") String str15, @JsonProperty("tmdb_id") Integer num17, @JsonProperty("tomato_url") String str16, @JsonProperty("tomato_meter") Integer num18, @JsonProperty("tomato_meter_count") Integer num19, @JsonProperty("tomato_meter_state") String str17, @JsonProperty("reelgood_url") String str18, @JsonProperty("audience_score") Integer num20, @JsonProperty("audience_score_count") Integer num21, @JsonProperty("no_tomato_url") Integer num22, @JsonProperty("order_year") Integer num23, @JsonProperty("episodate_id") String str19, @JsonProperty("weights_day") Double d, @JsonProperty("poster_min") String str20, @JsonProperty("poster_org") String str21, @JsonProperty("banner_mini_min") String str22, @JsonProperty("banner_mini_org") String str23, @JsonProperty("trailer_url") String str24, @JsonProperty("years") ArrayList<Integer> years, @JsonProperty("season") ArrayList<Integer> season, @JsonProperty("history") ArrayList<String> history, @JsonProperty("imdb_link") String str25, @JsonProperty("episode") ArrayList<SeriesEpisode> episode, @JsonProperty("language") ArrayList<SeriesLanguage> language, @JsonProperty("box_type") Integer num24, @JsonProperty("year_year") String str26, @JsonProperty("season_episode") String str27) {
            Intrinsics.checkNotNullParameter(years, "years");
            Intrinsics.checkNotNullParameter(season, "season");
            Intrinsics.checkNotNullParameter(history, "history");
            Intrinsics.checkNotNullParameter(episode, "episode");
            Intrinsics.checkNotNullParameter(language, "language");
            return new SeriesData(num, num2, str, num3, num4, num5, num6, str2, str3, str4, num7, str5, num8, str6, str7, str8, str9, num9, num10, num11, num12, str10, str11, num13, str12, num14, num15, num16, str13, str14, str15, num17, str16, num18, num19, str17, str18, num20, num21, num22, num23, str19, d, str20, str21, str22, str23, str24, years, season, history, str25, episode, language, num24, str26, str27);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SeriesData) {
                SeriesData seriesData = (SeriesData) obj;
                return Intrinsics.areEqual(this.f9980id, seriesData.f9980id) && Intrinsics.areEqual(this.mbId, seriesData.mbId) && Intrinsics.areEqual(this.title, seriesData.title) && Intrinsics.areEqual(this.display, seriesData.display) && Intrinsics.areEqual(this.state, seriesData.state) && Intrinsics.areEqual(this.vipOnly, seriesData.vipOnly) && Intrinsics.areEqual(this.codeFile, seriesData.codeFile) && Intrinsics.areEqual(this.director, seriesData.director) && Intrinsics.areEqual(this.writer, seriesData.writer) && Intrinsics.areEqual(this.actors, seriesData.actors) && Intrinsics.areEqual(this.addTime, seriesData.addTime) && Intrinsics.areEqual(this.poster, seriesData.poster) && Intrinsics.areEqual(this.posterImdb, seriesData.posterImdb) && Intrinsics.areEqual(this.bannerMini, seriesData.bannerMini) && Intrinsics.areEqual(this.description, seriesData.description) && Intrinsics.areEqual(this.imdbId, seriesData.imdbId) && Intrinsics.areEqual(this.cats, seriesData.cats) && Intrinsics.areEqual(this.year, seriesData.year) && Intrinsics.areEqual(this.collect, seriesData.collect) && Intrinsics.areEqual(this.view, seriesData.view) && Intrinsics.areEqual(this.download, seriesData.download) && Intrinsics.areEqual(this.updateTime, seriesData.updateTime) && Intrinsics.areEqual(this.released, seriesData.released) && Intrinsics.areEqual(this.releasedTimestamp, seriesData.releasedTimestamp) && Intrinsics.areEqual(this.episodeReleased, seriesData.episodeReleased) && Intrinsics.areEqual(this.episodeReleasedTimestamp, seriesData.episodeReleasedTimestamp) && Intrinsics.areEqual(this.maxSeason, seriesData.maxSeason) && Intrinsics.areEqual(this.maxEpisode, seriesData.maxEpisode) && Intrinsics.areEqual(this.remark, seriesData.remark) && Intrinsics.areEqual(this.imdbRating, seriesData.imdbRating) && Intrinsics.areEqual(this.contentRating, seriesData.contentRating) && Intrinsics.areEqual(this.tmdbId, seriesData.tmdbId) && Intrinsics.areEqual(this.tomatoUrl, seriesData.tomatoUrl) && Intrinsics.areEqual(this.tomatoMeter, seriesData.tomatoMeter) && Intrinsics.areEqual(this.tomatoMeterCount, seriesData.tomatoMeterCount) && Intrinsics.areEqual(this.tomatoMeterState, seriesData.tomatoMeterState) && Intrinsics.areEqual(this.reelgoodUrl, seriesData.reelgoodUrl) && Intrinsics.areEqual(this.audienceScore, seriesData.audienceScore) && Intrinsics.areEqual(this.audienceScoreCount, seriesData.audienceScoreCount) && Intrinsics.areEqual(this.noTomatoUrl, seriesData.noTomatoUrl) && Intrinsics.areEqual(this.orderYear, seriesData.orderYear) && Intrinsics.areEqual(this.episodateId, seriesData.episodateId) && Intrinsics.areEqual((Object) this.weightsDay, (Object) seriesData.weightsDay) && Intrinsics.areEqual(this.posterMin, seriesData.posterMin) && Intrinsics.areEqual(this.posterOrg, seriesData.posterOrg) && Intrinsics.areEqual(this.bannerMiniMin, seriesData.bannerMiniMin) && Intrinsics.areEqual(this.bannerMiniOrg, seriesData.bannerMiniOrg) && Intrinsics.areEqual(this.trailerUrl, seriesData.trailerUrl) && Intrinsics.areEqual(this.years, seriesData.years) && Intrinsics.areEqual(this.season, seriesData.season) && Intrinsics.areEqual(this.history, seriesData.history) && Intrinsics.areEqual(this.imdbLink, seriesData.imdbLink) && Intrinsics.areEqual(this.episode, seriesData.episode) && Intrinsics.areEqual(this.language, seriesData.language) && Intrinsics.areEqual(this.boxType, seriesData.boxType) && Intrinsics.areEqual(this.yearYear, seriesData.yearYear) && Intrinsics.areEqual(this.seasonEpisode, seriesData.seasonEpisode);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.f9980id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Integer num2 = this.mbId;
            int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str = this.title;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num3 = this.display;
            int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.state;
            int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.vipOnly;
            int hashCode6 = (hashCode5 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Integer num6 = this.codeFile;
            int hashCode7 = (hashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
            String str2 = this.director;
            int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.writer;
            int hashCode9 = (hashCode8 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.actors;
            int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num7 = this.addTime;
            int hashCode11 = (hashCode10 + (num7 == null ? 0 : num7.hashCode())) * 31;
            String str5 = this.poster;
            int hashCode12 = (hashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num8 = this.posterImdb;
            int hashCode13 = (hashCode12 + (num8 == null ? 0 : num8.hashCode())) * 31;
            String str6 = this.bannerMini;
            int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.description;
            int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.imdbId;
            int hashCode16 = (hashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
            String str9 = this.cats;
            int hashCode17 = (hashCode16 + (str9 == null ? 0 : str9.hashCode())) * 31;
            Integer num9 = this.year;
            int hashCode18 = (hashCode17 + (num9 == null ? 0 : num9.hashCode())) * 31;
            Integer num10 = this.collect;
            int hashCode19 = (hashCode18 + (num10 == null ? 0 : num10.hashCode())) * 31;
            Integer num11 = this.view;
            int hashCode20 = (hashCode19 + (num11 == null ? 0 : num11.hashCode())) * 31;
            Integer num12 = this.download;
            int hashCode21 = (hashCode20 + (num12 == null ? 0 : num12.hashCode())) * 31;
            String str10 = this.updateTime;
            int hashCode22 = (hashCode21 + (str10 == null ? 0 : str10.hashCode())) * 31;
            String str11 = this.released;
            int hashCode23 = (hashCode22 + (str11 == null ? 0 : str11.hashCode())) * 31;
            Integer num13 = this.releasedTimestamp;
            int hashCode24 = (hashCode23 + (num13 == null ? 0 : num13.hashCode())) * 31;
            String str12 = this.episodeReleased;
            int hashCode25 = (hashCode24 + (str12 == null ? 0 : str12.hashCode())) * 31;
            Integer num14 = this.episodeReleasedTimestamp;
            int hashCode26 = (hashCode25 + (num14 == null ? 0 : num14.hashCode())) * 31;
            Integer num15 = this.maxSeason;
            int hashCode27 = (hashCode26 + (num15 == null ? 0 : num15.hashCode())) * 31;
            Integer num16 = this.maxEpisode;
            int hashCode28 = (hashCode27 + (num16 == null ? 0 : num16.hashCode())) * 31;
            String str13 = this.remark;
            int hashCode29 = (hashCode28 + (str13 == null ? 0 : str13.hashCode())) * 31;
            String str14 = this.imdbRating;
            int hashCode30 = (hashCode29 + (str14 == null ? 0 : str14.hashCode())) * 31;
            String str15 = this.contentRating;
            int hashCode31 = (hashCode30 + (str15 == null ? 0 : str15.hashCode())) * 31;
            Integer num17 = this.tmdbId;
            int hashCode32 = (hashCode31 + (num17 == null ? 0 : num17.hashCode())) * 31;
            String str16 = this.tomatoUrl;
            int hashCode33 = (hashCode32 + (str16 == null ? 0 : str16.hashCode())) * 31;
            Integer num18 = this.tomatoMeter;
            int hashCode34 = (hashCode33 + (num18 == null ? 0 : num18.hashCode())) * 31;
            Integer num19 = this.tomatoMeterCount;
            int hashCode35 = (hashCode34 + (num19 == null ? 0 : num19.hashCode())) * 31;
            String str17 = this.tomatoMeterState;
            int hashCode36 = (hashCode35 + (str17 == null ? 0 : str17.hashCode())) * 31;
            String str18 = this.reelgoodUrl;
            int hashCode37 = (hashCode36 + (str18 == null ? 0 : str18.hashCode())) * 31;
            Integer num20 = this.audienceScore;
            int hashCode38 = (hashCode37 + (num20 == null ? 0 : num20.hashCode())) * 31;
            Integer num21 = this.audienceScoreCount;
            int hashCode39 = (hashCode38 + (num21 == null ? 0 : num21.hashCode())) * 31;
            Integer num22 = this.noTomatoUrl;
            int hashCode40 = (hashCode39 + (num22 == null ? 0 : num22.hashCode())) * 31;
            Integer num23 = this.orderYear;
            int hashCode41 = (hashCode40 + (num23 == null ? 0 : num23.hashCode())) * 31;
            String str19 = this.episodateId;
            int hashCode42 = (hashCode41 + (str19 == null ? 0 : str19.hashCode())) * 31;
            Double d = this.weightsDay;
            int hashCode43 = (hashCode42 + (d == null ? 0 : d.hashCode())) * 31;
            String str20 = this.posterMin;
            int hashCode44 = (hashCode43 + (str20 == null ? 0 : str20.hashCode())) * 31;
            String str21 = this.posterOrg;
            int hashCode45 = (hashCode44 + (str21 == null ? 0 : str21.hashCode())) * 31;
            String str22 = this.bannerMiniMin;
            int hashCode46 = (hashCode45 + (str22 == null ? 0 : str22.hashCode())) * 31;
            String str23 = this.bannerMiniOrg;
            int hashCode47 = (hashCode46 + (str23 == null ? 0 : str23.hashCode())) * 31;
            String str24 = this.trailerUrl;
            int hashCode48 = (((((((hashCode47 + (str24 == null ? 0 : str24.hashCode())) * 31) + this.years.hashCode()) * 31) + this.season.hashCode()) * 31) + this.history.hashCode()) * 31;
            String str25 = this.imdbLink;
            int hashCode49 = (((((hashCode48 + (str25 == null ? 0 : str25.hashCode())) * 31) + this.episode.hashCode()) * 31) + this.language.hashCode()) * 31;
            Integer num24 = this.boxType;
            int hashCode50 = (hashCode49 + (num24 == null ? 0 : num24.hashCode())) * 31;
            String str26 = this.yearYear;
            int hashCode51 = (hashCode50 + (str26 == null ? 0 : str26.hashCode())) * 31;
            String str27 = this.seasonEpisode;
            return hashCode51 + (str27 != null ? str27.hashCode() : 0);
        }

        public String toString() {
            return "SeriesData(id=" + this.f9980id + ", mbId=" + this.mbId + ", title=" + this.title + ", display=" + this.display + ", state=" + this.state + ", vipOnly=" + this.vipOnly + ", codeFile=" + this.codeFile + ", director=" + this.director + ", writer=" + this.writer + ", actors=" + this.actors + ", addTime=" + this.addTime + ", poster=" + this.poster + ", posterImdb=" + this.posterImdb + ", bannerMini=" + this.bannerMini + ", description=" + this.description + ", imdbId=" + this.imdbId + ", cats=" + this.cats + ", year=" + this.year + ", collect=" + this.collect + ", view=" + this.view + ", download=" + this.download + ", updateTime=" + this.updateTime + ", released=" + this.released + ", releasedTimestamp=" + this.releasedTimestamp + ", episodeReleased=" + this.episodeReleased + ", episodeReleasedTimestamp=" + this.episodeReleasedTimestamp + ", maxSeason=" + this.maxSeason + ", maxEpisode=" + this.maxEpisode + ", remark=" + this.remark + ", imdbRating=" + this.imdbRating + ", contentRating=" + this.contentRating + ", tmdbId=" + this.tmdbId + ", tomatoUrl=" + this.tomatoUrl + ", tomatoMeter=" + this.tomatoMeter + ", tomatoMeterCount=" + this.tomatoMeterCount + ", tomatoMeterState=" + this.tomatoMeterState + ", reelgoodUrl=" + this.reelgoodUrl + ", audienceScore=" + this.audienceScore + ", audienceScoreCount=" + this.audienceScoreCount + ", noTomatoUrl=" + this.noTomatoUrl + ", orderYear=" + this.orderYear + ", episodateId=" + this.episodateId + ", weightsDay=" + this.weightsDay + ", posterMin=" + this.posterMin + ", posterOrg=" + this.posterOrg + ", bannerMiniMin=" + this.bannerMiniMin + ", bannerMiniOrg=" + this.bannerMiniOrg + ", trailerUrl=" + this.trailerUrl + ", years=" + this.years + ", season=" + this.season + ", history=" + this.history + ", imdbLink=" + this.imdbLink + ", episode=" + this.episode + ", language=" + this.language + ", boxType=" + this.boxType + ", yearYear=" + this.yearYear + ", seasonEpisode=" + this.seasonEpisode + ')';
        }

        public SeriesData(@JsonProperty("id") Integer num, @JsonProperty("mb_id") Integer num2, @JsonProperty("title") String str, @JsonProperty("display") Integer num3, @JsonProperty("state") Integer num4, @JsonProperty("vip_only") Integer num5, @JsonProperty("code_file") Integer num6, @JsonProperty("director") String str2, @JsonProperty("writer") String str3, @JsonProperty("actors") String str4, @JsonProperty("add_time") Integer num7, @JsonProperty("poster") String str5, @JsonProperty("poster_imdb") Integer num8, @JsonProperty("banner_mini") String str6, @JsonProperty("description") String str7, @JsonProperty("imdb_id") String str8, @JsonProperty("cats") String str9, @JsonProperty("year") Integer num9, @JsonProperty("collect") Integer num10, @JsonProperty("view") Integer num11, @JsonProperty("download") Integer num12, @JsonProperty("update_time") String str10, @JsonProperty("released") String str11, @JsonProperty("released_timestamp") Integer num13, @JsonProperty("episode_released") String str12, @JsonProperty("episode_released_timestamp") Integer num14, @JsonProperty("max_season") Integer num15, @JsonProperty("max_episode") Integer num16, @JsonProperty("remark") String str13, @JsonProperty("imdb_rating") String str14, @JsonProperty("content_rating") String str15, @JsonProperty("tmdb_id") Integer num17, @JsonProperty("tomato_url") String str16, @JsonProperty("tomato_meter") Integer num18, @JsonProperty("tomato_meter_count") Integer num19, @JsonProperty("tomato_meter_state") String str17, @JsonProperty("reelgood_url") String str18, @JsonProperty("audience_score") Integer num20, @JsonProperty("audience_score_count") Integer num21, @JsonProperty("no_tomato_url") Integer num22, @JsonProperty("order_year") Integer num23, @JsonProperty("episodate_id") String str19, @JsonProperty("weights_day") Double d, @JsonProperty("poster_min") String str20, @JsonProperty("poster_org") String str21, @JsonProperty("banner_mini_min") String str22, @JsonProperty("banner_mini_org") String str23, @JsonProperty("trailer_url") String str24, @JsonProperty("years") ArrayList<Integer> years, @JsonProperty("season") ArrayList<Integer> season, @JsonProperty("history") ArrayList<String> history, @JsonProperty("imdb_link") String str25, @JsonProperty("episode") ArrayList<SeriesEpisode> episode, @JsonProperty("language") ArrayList<SeriesLanguage> language, @JsonProperty("box_type") Integer num24, @JsonProperty("year_year") String str26, @JsonProperty("season_episode") String str27) {
            Intrinsics.checkNotNullParameter(years, "years");
            Intrinsics.checkNotNullParameter(season, "season");
            Intrinsics.checkNotNullParameter(history, "history");
            Intrinsics.checkNotNullParameter(episode, "episode");
            Intrinsics.checkNotNullParameter(language, "language");
            this.f9980id = num;
            this.mbId = num2;
            this.title = str;
            this.display = num3;
            this.state = num4;
            this.vipOnly = num5;
            this.codeFile = num6;
            this.director = str2;
            this.writer = str3;
            this.actors = str4;
            this.addTime = num7;
            this.poster = str5;
            this.posterImdb = num8;
            this.bannerMini = str6;
            this.description = str7;
            this.imdbId = str8;
            this.cats = str9;
            this.year = num9;
            this.collect = num10;
            this.view = num11;
            this.download = num12;
            this.updateTime = str10;
            this.released = str11;
            this.releasedTimestamp = num13;
            this.episodeReleased = str12;
            this.episodeReleasedTimestamp = num14;
            this.maxSeason = num15;
            this.maxEpisode = num16;
            this.remark = str13;
            this.imdbRating = str14;
            this.contentRating = str15;
            this.tmdbId = num17;
            this.tomatoUrl = str16;
            this.tomatoMeter = num18;
            this.tomatoMeterCount = num19;
            this.tomatoMeterState = str17;
            this.reelgoodUrl = str18;
            this.audienceScore = num20;
            this.audienceScoreCount = num21;
            this.noTomatoUrl = num22;
            this.orderYear = num23;
            this.episodateId = str19;
            this.weightsDay = d;
            this.posterMin = str20;
            this.posterOrg = str21;
            this.bannerMiniMin = str22;
            this.bannerMiniOrg = str23;
            this.trailerUrl = str24;
            this.years = years;
            this.season = season;
            this.history = history;
            this.imdbLink = str25;
            this.episode = episode;
            this.language = language;
            this.boxType = num24;
            this.yearYear = str26;
            this.seasonEpisode = str27;
        }

        public final Integer getId() {
            return this.f9980id;
        }

        public final Integer getMbId() {
            return this.mbId;
        }

        public final String getTitle() {
            return this.title;
        }

        public final Integer getDisplay() {
            return this.display;
        }

        public final Integer getState() {
            return this.state;
        }

        public final Integer getVipOnly() {
            return this.vipOnly;
        }

        public final Integer getCodeFile() {
            return this.codeFile;
        }

        public final String getDirector() {
            return this.director;
        }

        public final String getWriter() {
            return this.writer;
        }

        public final String getActors() {
            return this.actors;
        }

        public final Integer getAddTime() {
            return this.addTime;
        }

        public final String getPoster() {
            return this.poster;
        }

        public final Integer getPosterImdb() {
            return this.posterImdb;
        }

        public final String getBannerMini() {
            return this.bannerMini;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getImdbId() {
            return this.imdbId;
        }

        public final String getCats() {
            return this.cats;
        }

        public final Integer getYear() {
            return this.year;
        }

        public final Integer getCollect() {
            return this.collect;
        }

        public final Integer getView() {
            return this.view;
        }

        public final Integer getDownload() {
            return this.download;
        }

        public final String getUpdateTime() {
            return this.updateTime;
        }

        public final String getReleased() {
            return this.released;
        }

        public final Integer getReleasedTimestamp() {
            return this.releasedTimestamp;
        }

        public final String getEpisodeReleased() {
            return this.episodeReleased;
        }

        public final Integer getEpisodeReleasedTimestamp() {
            return this.episodeReleasedTimestamp;
        }

        public final Integer getMaxSeason() {
            return this.maxSeason;
        }

        public final Integer getMaxEpisode() {
            return this.maxEpisode;
        }

        public final String getRemark() {
            return this.remark;
        }

        public final String getImdbRating() {
            return this.imdbRating;
        }

        public final String getContentRating() {
            return this.contentRating;
        }

        public final Integer getTmdbId() {
            return this.tmdbId;
        }

        public final String getTomatoUrl() {
            return this.tomatoUrl;
        }

        public final Integer getTomatoMeter() {
            return this.tomatoMeter;
        }

        public final Integer getTomatoMeterCount() {
            return this.tomatoMeterCount;
        }

        public final String getTomatoMeterState() {
            return this.tomatoMeterState;
        }

        public final String getReelgoodUrl() {
            return this.reelgoodUrl;
        }

        public final Integer getAudienceScore() {
            return this.audienceScore;
        }

        public final Integer getAudienceScoreCount() {
            return this.audienceScoreCount;
        }

        public final Integer getNoTomatoUrl() {
            return this.noTomatoUrl;
        }

        public final Integer getOrderYear() {
            return this.orderYear;
        }

        public final String getEpisodateId() {
            return this.episodateId;
        }

        public final Double getWeightsDay() {
            return this.weightsDay;
        }

        public final String getPosterMin() {
            return this.posterMin;
        }

        public final String getPosterOrg() {
            return this.posterOrg;
        }

        public final String getBannerMiniMin() {
            return this.bannerMiniMin;
        }

        public final String getBannerMiniOrg() {
            return this.bannerMiniOrg;
        }

        public final String getTrailerUrl() {
            return this.trailerUrl;
        }

        public /* synthetic */ SeriesData(Integer num, Integer num2, String str, Integer num3, Integer num4, Integer num5, Integer num6, String str2, String str3, String str4, Integer num7, String str5, Integer num8, String str6, String str7, String str8, String str9, Integer num9, Integer num10, Integer num11, Integer num12, String str10, String str11, Integer num13, String str12, Integer num14, Integer num15, Integer num16, String str13, String str14, String str15, Integer num17, String str16, Integer num18, Integer num19, String str17, String str18, Integer num20, Integer num21, Integer num22, Integer num23, String str19, Double d, String str20, String str21, String str22, String str23, String str24, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, String str25, ArrayList arrayList4, ArrayList arrayList5, Integer num24, String str26, String str27, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : num5, (i & 64) != 0 ? null : num6, (i & 128) != 0 ? null : str2, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : num7, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : num8, (i & 8192) != 0 ? null : str6, (i & 16384) != 0 ? null : str7, (i & 32768) != 0 ? null : str8, (i & 65536) != 0 ? null : str9, (i & 131072) != 0 ? null : num9, (i & 262144) != 0 ? null : num10, (i & 524288) != 0 ? null : num11, (i & 1048576) != 0 ? null : num12, (i & 2097152) != 0 ? null : str10, (i & 4194304) != 0 ? null : str11, (i & 8388608) != 0 ? null : num13, (i & 16777216) != 0 ? null : str12, (i & 33554432) != 0 ? null : num14, (i & 67108864) != 0 ? null : num15, (i & 134217728) != 0 ? null : num16, (i & 268435456) != 0 ? null : str13, (i & 536870912) != 0 ? null : str14, (i & 1073741824) != 0 ? null : str15, (i & Integer.MIN_VALUE) != 0 ? null : num17, (i2 & 1) != 0 ? null : str16, (i2 & 2) != 0 ? null : num18, (i2 & 4) != 0 ? null : num19, (i2 & 8) != 0 ? null : str17, (i2 & 16) != 0 ? null : str18, (i2 & 32) != 0 ? null : num20, (i2 & 64) != 0 ? null : num21, (i2 & 128) != 0 ? null : num22, (i2 & 256) != 0 ? null : num23, (i2 & 512) != 0 ? null : str19, (i2 & 1024) != 0 ? null : d, (i2 & 2048) != 0 ? null : str20, (i2 & 4096) != 0 ? null : str21, (i2 & 8192) != 0 ? null : str22, (i2 & 16384) != 0 ? null : str23, (i2 & 32768) != 0 ? null : str24, (i2 & 65536) != 0 ? new ArrayList() : arrayList, (i2 & 131072) != 0 ? new ArrayList() : arrayList2, (i2 & 262144) != 0 ? new ArrayList() : arrayList3, (i2 & 524288) != 0 ? null : str25, (i2 & 1048576) != 0 ? new ArrayList() : arrayList4, (i2 & 2097152) != 0 ? new ArrayList() : arrayList5, (i2 & 4194304) != 0 ? null : num24, (i2 & 8388608) != 0 ? null : str26, (i2 & 16777216) != 0 ? null : str27);
        }

        public final ArrayList<Integer> getYears() {
            return this.years;
        }

        public final ArrayList<Integer> getSeason() {
            return this.season;
        }

        public final ArrayList<String> getHistory() {
            return this.history;
        }

        public final String getImdbLink() {
            return this.imdbLink;
        }

        public final ArrayList<SeriesEpisode> getEpisode() {
            return this.episode;
        }

        public final ArrayList<SeriesLanguage> getLanguage() {
            return this.language;
        }

        public final Integer getBoxType() {
            return this.boxType;
        }

        public final String getYearYear() {
            return this.yearYear;
        }

        public final String getSeasonEpisode() {
            return this.seasonEpisode;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x035f  */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0253 -> B:59:0x025b). Please submit an issue!!! */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(java.lang.String r33, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r34) {
        /*
            Method dump skipped, instructions count: 869
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SuperStream.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ:\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkData;", "", "id", "", "type", "season", "episode", "(IILjava/lang/Integer;Ljava/lang/Integer;)V", "getEpisode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()I", "getSeason", "getType", "component1", "component2", "component3", "component4", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkData;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LinkData {
        private final Integer episode;

        /* renamed from: id */
        private final int f9976id;
        private final Integer season;
        private final int type;

        public static /* synthetic */ LinkData copy$default(LinkData linkData, int i, int i2, Integer num, Integer num2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = linkData.f9976id;
            }
            if ((i3 & 2) != 0) {
                i2 = linkData.type;
            }
            if ((i3 & 4) != 0) {
                num = linkData.season;
            }
            if ((i3 & 8) != 0) {
                num2 = linkData.episode;
            }
            return linkData.copy(i, i2, num, num2);
        }

        public final int component1() {
            return this.f9976id;
        }

        public final int component2() {
            return this.type;
        }

        public final Integer component3() {
            return this.season;
        }

        public final Integer component4() {
            return this.episode;
        }

        public final LinkData copy(int i, int i2, Integer num, Integer num2) {
            return new LinkData(i, i2, num, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LinkData) {
                LinkData linkData = (LinkData) obj;
                return this.f9976id == linkData.f9976id && this.type == linkData.type && Intrinsics.areEqual(this.season, linkData.season) && Intrinsics.areEqual(this.episode, linkData.episode);
            }
            return false;
        }

        public int hashCode() {
            int i = ((this.f9976id * 31) + this.type) * 31;
            Integer num = this.season;
            int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.episode;
            return hashCode + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "LinkData(id=" + this.f9976id + ", type=" + this.type + ", season=" + this.season + ", episode=" + this.episode + ')';
        }

        public LinkData(int i, int i2, Integer num, Integer num2) {
            this.f9976id = i;
            this.type = i2;
            this.season = num;
            this.episode = num2;
        }

        public final int getId() {
            return this.f9976id;
        }

        public final int getType() {
            return this.type;
        }

        public final Integer getSeason() {
            return this.season;
        }

        public final Integer getEpisode() {
            return this.episode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkDataProp;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ParsedLinkData;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ParsedLinkData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ParsedLinkData;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ParsedLinkData;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkDataProp;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LinkDataProp {
        private final Integer code;
        private final ParsedLinkData data;
        private final String msg;

        public LinkDataProp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ LinkDataProp copy$default(LinkDataProp linkDataProp, Integer num, String str, ParsedLinkData parsedLinkData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = linkDataProp.code;
            }
            if ((i & 2) != 0) {
                str = linkDataProp.msg;
            }
            if ((i & 4) != 0) {
                parsedLinkData = linkDataProp.data;
            }
            return linkDataProp.copy(num, str, parsedLinkData);
        }

        public final Integer component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final ParsedLinkData component3() {
            return this.data;
        }

        public final LinkDataProp copy(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") ParsedLinkData parsedLinkData) {
            return new LinkDataProp(num, str, parsedLinkData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LinkDataProp) {
                LinkDataProp linkDataProp = (LinkDataProp) obj;
                return Intrinsics.areEqual(this.code, linkDataProp.code) && Intrinsics.areEqual(this.msg, linkDataProp.msg) && Intrinsics.areEqual(this.data, linkDataProp.data);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.code;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.msg;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            ParsedLinkData parsedLinkData = this.data;
            return hashCode2 + (parsedLinkData != null ? parsedLinkData.hashCode() : 0);
        }

        public String toString() {
            return "LinkDataProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public LinkDataProp(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") ParsedLinkData parsedLinkData) {
            this.code = num;
            this.msg = str;
            this.data = parsedLinkData;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public /* synthetic */ LinkDataProp(Integer num, String str, ParsedLinkData parsedLinkData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new ParsedLinkData(null, null, null, 7, null) : parsedLinkData);
        }

        public final ParsedLinkData getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\bD\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001bJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u00109\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010>\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010?\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010J\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010K\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010L\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0096\u0002\u0010M\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010R\u001a\u00020\u000bHÖ\u0001J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b(\u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b)\u0010\u001fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b*\u0010\u001fR\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b+\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b,\u0010\u001fR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b-\u0010\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b2\u0010#R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b3\u0010\u001fR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b4\u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b5\u0010\u001fR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010 \u001a\u0004\b6\u0010\u001f¨\u0006T"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkList;", "", "path", "", "quality", "realQuality", "format", "size", "sizeBytes", "", "count", "", "dateline", "fid", "mmfid", "h265", "hdr", "filename", "original", "colorbit", "success", "timeout", "vipLink", "fps", "bitstream", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBitstream", "()Ljava/lang/String;", "getColorbit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCount", "getDateline", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFid", "getFilename", "getFormat", "getFps", "getH265", "getHdr", "getHeight", "getMmfid", "getOriginal", "getPath", "getQuality", "getRealQuality", "getSize", "getSizeBytes", "getSuccess", "getTimeout", "getVipLink", "getWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkList;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class LinkList {
        private final String bitstream;
        private final Integer colorbit;
        private final Integer count;
        private final Long dateline;
        private final Integer fid;
        private final String filename;
        private final String format;
        private final Integer fps;
        private final Integer h265;
        private final Integer hdr;
        private final Integer height;
        private final Integer mmfid;
        private final Integer original;
        private final String path;
        private final String quality;
        private final String realQuality;
        private final String size;
        private final Long sizeBytes;
        private final Integer success;
        private final Integer timeout;
        private final Integer vipLink;
        private final Integer width;

        public LinkList() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        }

        public final String component1() {
            return this.path;
        }

        public final Integer component10() {
            return this.mmfid;
        }

        public final Integer component11() {
            return this.h265;
        }

        public final Integer component12() {
            return this.hdr;
        }

        public final String component13() {
            return this.filename;
        }

        public final Integer component14() {
            return this.original;
        }

        public final Integer component15() {
            return this.colorbit;
        }

        public final Integer component16() {
            return this.success;
        }

        public final Integer component17() {
            return this.timeout;
        }

        public final Integer component18() {
            return this.vipLink;
        }

        public final Integer component19() {
            return this.fps;
        }

        public final String component2() {
            return this.quality;
        }

        public final String component20() {
            return this.bitstream;
        }

        public final Integer component21() {
            return this.width;
        }

        public final Integer component22() {
            return this.height;
        }

        public final String component3() {
            return this.realQuality;
        }

        public final String component4() {
            return this.format;
        }

        public final String component5() {
            return this.size;
        }

        public final Long component6() {
            return this.sizeBytes;
        }

        public final Integer component7() {
            return this.count;
        }

        public final Long component8() {
            return this.dateline;
        }

        public final Integer component9() {
            return this.fid;
        }

        public final LinkList copy(@JsonProperty("path") String str, @JsonProperty("quality") String str2, @JsonProperty("real_quality") String str3, @JsonProperty("format") String str4, @JsonProperty("size") String str5, @JsonProperty("size_bytes") Long l, @JsonProperty("count") Integer num, @JsonProperty("dateline") Long l2, @JsonProperty("fid") Integer num2, @JsonProperty("mmfid") Integer num3, @JsonProperty("h265") Integer num4, @JsonProperty("hdr") Integer num5, @JsonProperty("filename") String str6, @JsonProperty("original") Integer num6, @JsonProperty("colorbit") Integer num7, @JsonProperty("success") Integer num8, @JsonProperty("timeout") Integer num9, @JsonProperty("vip_link") Integer num10, @JsonProperty("fps") Integer num11, @JsonProperty("bitstream") String str7, @JsonProperty("width") Integer num12, @JsonProperty("height") Integer num13) {
            return new LinkList(str, str2, str3, str4, str5, l, num, l2, num2, num3, num4, num5, str6, num6, num7, num8, num9, num10, num11, str7, num12, num13);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LinkList) {
                LinkList linkList = (LinkList) obj;
                return Intrinsics.areEqual(this.path, linkList.path) && Intrinsics.areEqual(this.quality, linkList.quality) && Intrinsics.areEqual(this.realQuality, linkList.realQuality) && Intrinsics.areEqual(this.format, linkList.format) && Intrinsics.areEqual(this.size, linkList.size) && Intrinsics.areEqual(this.sizeBytes, linkList.sizeBytes) && Intrinsics.areEqual(this.count, linkList.count) && Intrinsics.areEqual(this.dateline, linkList.dateline) && Intrinsics.areEqual(this.fid, linkList.fid) && Intrinsics.areEqual(this.mmfid, linkList.mmfid) && Intrinsics.areEqual(this.h265, linkList.h265) && Intrinsics.areEqual(this.hdr, linkList.hdr) && Intrinsics.areEqual(this.filename, linkList.filename) && Intrinsics.areEqual(this.original, linkList.original) && Intrinsics.areEqual(this.colorbit, linkList.colorbit) && Intrinsics.areEqual(this.success, linkList.success) && Intrinsics.areEqual(this.timeout, linkList.timeout) && Intrinsics.areEqual(this.vipLink, linkList.vipLink) && Intrinsics.areEqual(this.fps, linkList.fps) && Intrinsics.areEqual(this.bitstream, linkList.bitstream) && Intrinsics.areEqual(this.width, linkList.width) && Intrinsics.areEqual(this.height, linkList.height);
            }
            return false;
        }

        public int hashCode() {
            String str = this.path;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.quality;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.realQuality;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.format;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.size;
            int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Long l = this.sizeBytes;
            int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
            Integer num = this.count;
            int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
            Long l2 = this.dateline;
            int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
            Integer num2 = this.fid;
            int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
            Integer num3 = this.mmfid;
            int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.h265;
            int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.hdr;
            int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
            String str6 = this.filename;
            int hashCode13 = (hashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
            Integer num6 = this.original;
            int hashCode14 = (hashCode13 + (num6 == null ? 0 : num6.hashCode())) * 31;
            Integer num7 = this.colorbit;
            int hashCode15 = (hashCode14 + (num7 == null ? 0 : num7.hashCode())) * 31;
            Integer num8 = this.success;
            int hashCode16 = (hashCode15 + (num8 == null ? 0 : num8.hashCode())) * 31;
            Integer num9 = this.timeout;
            int hashCode17 = (hashCode16 + (num9 == null ? 0 : num9.hashCode())) * 31;
            Integer num10 = this.vipLink;
            int hashCode18 = (hashCode17 + (num10 == null ? 0 : num10.hashCode())) * 31;
            Integer num11 = this.fps;
            int hashCode19 = (hashCode18 + (num11 == null ? 0 : num11.hashCode())) * 31;
            String str7 = this.bitstream;
            int hashCode20 = (hashCode19 + (str7 == null ? 0 : str7.hashCode())) * 31;
            Integer num12 = this.width;
            int hashCode21 = (hashCode20 + (num12 == null ? 0 : num12.hashCode())) * 31;
            Integer num13 = this.height;
            return hashCode21 + (num13 != null ? num13.hashCode() : 0);
        }

        public String toString() {
            return "LinkList(path=" + this.path + ", quality=" + this.quality + ", realQuality=" + this.realQuality + ", format=" + this.format + ", size=" + this.size + ", sizeBytes=" + this.sizeBytes + ", count=" + this.count + ", dateline=" + this.dateline + ", fid=" + this.fid + ", mmfid=" + this.mmfid + ", h265=" + this.h265 + ", hdr=" + this.hdr + ", filename=" + this.filename + ", original=" + this.original + ", colorbit=" + this.colorbit + ", success=" + this.success + ", timeout=" + this.timeout + ", vipLink=" + this.vipLink + ", fps=" + this.fps + ", bitstream=" + this.bitstream + ", width=" + this.width + ", height=" + this.height + ')';
        }

        public LinkList(@JsonProperty("path") String str, @JsonProperty("quality") String str2, @JsonProperty("real_quality") String str3, @JsonProperty("format") String str4, @JsonProperty("size") String str5, @JsonProperty("size_bytes") Long l, @JsonProperty("count") Integer num, @JsonProperty("dateline") Long l2, @JsonProperty("fid") Integer num2, @JsonProperty("mmfid") Integer num3, @JsonProperty("h265") Integer num4, @JsonProperty("hdr") Integer num5, @JsonProperty("filename") String str6, @JsonProperty("original") Integer num6, @JsonProperty("colorbit") Integer num7, @JsonProperty("success") Integer num8, @JsonProperty("timeout") Integer num9, @JsonProperty("vip_link") Integer num10, @JsonProperty("fps") Integer num11, @JsonProperty("bitstream") String str7, @JsonProperty("width") Integer num12, @JsonProperty("height") Integer num13) {
            this.path = str;
            this.quality = str2;
            this.realQuality = str3;
            this.format = str4;
            this.size = str5;
            this.sizeBytes = l;
            this.count = num;
            this.dateline = l2;
            this.fid = num2;
            this.mmfid = num3;
            this.h265 = num4;
            this.hdr = num5;
            this.filename = str6;
            this.original = num6;
            this.colorbit = num7;
            this.success = num8;
            this.timeout = num9;
            this.vipLink = num10;
            this.fps = num11;
            this.bitstream = str7;
            this.width = num12;
            this.height = num13;
        }

        public /* synthetic */ LinkList(String str, String str2, String str3, String str4, String str5, Long l, Integer num, Long l2, Integer num2, Integer num3, Integer num4, Integer num5, String str6, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, String str7, Integer num12, Integer num13, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : num, (i & 128) != 0 ? null : l2, (i & 256) != 0 ? null : num2, (i & 512) != 0 ? null : num3, (i & 1024) != 0 ? null : num4, (i & 2048) != 0 ? null : num5, (i & 4096) != 0 ? null : str6, (i & 8192) != 0 ? null : num6, (i & 16384) != 0 ? null : num7, (i & 32768) != 0 ? null : num8, (i & 65536) != 0 ? null : num9, (i & 131072) != 0 ? null : num10, (i & 262144) != 0 ? null : num11, (i & 524288) != 0 ? null : str7, (i & 1048576) != 0 ? null : num12, (i & 2097152) != 0 ? null : num13);
        }

        public final String getPath() {
            return this.path;
        }

        public final String getQuality() {
            return this.quality;
        }

        public final String getRealQuality() {
            return this.realQuality;
        }

        public final String getFormat() {
            return this.format;
        }

        public final String getSize() {
            return this.size;
        }

        public final Long getSizeBytes() {
            return this.sizeBytes;
        }

        public final Integer getCount() {
            return this.count;
        }

        public final Long getDateline() {
            return this.dateline;
        }

        public final Integer getFid() {
            return this.fid;
        }

        public final Integer getMmfid() {
            return this.mmfid;
        }

        public final Integer getH265() {
            return this.h265;
        }

        public final Integer getHdr() {
            return this.hdr;
        }

        public final String getFilename() {
            return this.filename;
        }

        public final Integer getOriginal() {
            return this.original;
        }

        public final Integer getColorbit() {
            return this.colorbit;
        }

        public final Integer getSuccess() {
            return this.success;
        }

        public final Integer getTimeout() {
            return this.timeout;
        }

        public final Integer getVipLink() {
            return this.vipLink;
        }

        public final Integer getFps() {
            return this.fps;
        }

        public final String getBitstream() {
            return this.bitstream;
        }

        public final Integer getWidth() {
            return this.width;
        }

        public final Integer getHeight() {
            return this.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0003JN\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0018\b\u0003\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0005j\b\u0012\u0004\u0012\u00020\t`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ParsedLinkData;", "", "seconds", "", "quality", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "list", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$LinkList;", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getQuality", "getSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$ParsedLinkData;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParsedLinkData {
        private final ArrayList<LinkList> list;
        private final ArrayList<String> quality;
        private final Integer seconds;

        public ParsedLinkData() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsedLinkData copy$default(ParsedLinkData parsedLinkData, Integer num, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = parsedLinkData.seconds;
            }
            if ((i & 2) != 0) {
                arrayList = parsedLinkData.quality;
            }
            if ((i & 4) != 0) {
                arrayList2 = parsedLinkData.list;
            }
            return parsedLinkData.copy(num, arrayList, arrayList2);
        }

        public final Integer component1() {
            return this.seconds;
        }

        public final ArrayList<String> component2() {
            return this.quality;
        }

        public final ArrayList<LinkList> component3() {
            return this.list;
        }

        public final ParsedLinkData copy(@JsonProperty("seconds") Integer num, @JsonProperty("quality") ArrayList<String> quality, @JsonProperty("list") ArrayList<LinkList> list) {
            Intrinsics.checkNotNullParameter(quality, "quality");
            Intrinsics.checkNotNullParameter(list, "list");
            return new ParsedLinkData(num, quality, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ParsedLinkData) {
                ParsedLinkData parsedLinkData = (ParsedLinkData) obj;
                return Intrinsics.areEqual(this.seconds, parsedLinkData.seconds) && Intrinsics.areEqual(this.quality, parsedLinkData.quality) && Intrinsics.areEqual(this.list, parsedLinkData.list);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.seconds;
            return ((((num == null ? 0 : num.hashCode()) * 31) + this.quality.hashCode()) * 31) + this.list.hashCode();
        }

        public String toString() {
            return "ParsedLinkData(seconds=" + this.seconds + ", quality=" + this.quality + ", list=" + this.list + ')';
        }

        public ParsedLinkData(@JsonProperty("seconds") Integer num, @JsonProperty("quality") ArrayList<String> quality, @JsonProperty("list") ArrayList<LinkList> list) {
            Intrinsics.checkNotNullParameter(quality, "quality");
            Intrinsics.checkNotNullParameter(list, "list");
            this.seconds = num;
            this.quality = quality;
            this.list = list;
        }

        public final Integer getSeconds() {
            return this.seconds;
        }

        public /* synthetic */ ParsedLinkData(Integer num, ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? new ArrayList() : arrayList2);
        }

        public final ArrayList<String> getQuality() {
            return this.quality;
        }

        public final ArrayList<LinkList> getList() {
            return this.list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SubtitleDataProp;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PrivateSubtitleData;", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PrivateSubtitleData;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getData", "()Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PrivateSubtitleData;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PrivateSubtitleData;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SubtitleDataProp;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SubtitleDataProp {
        private final Integer code;
        private final PrivateSubtitleData data;
        private final String msg;

        public SubtitleDataProp() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SubtitleDataProp copy$default(SubtitleDataProp subtitleDataProp, Integer num, String str, PrivateSubtitleData privateSubtitleData, int i, Object obj) {
            if ((i & 1) != 0) {
                num = subtitleDataProp.code;
            }
            if ((i & 2) != 0) {
                str = subtitleDataProp.msg;
            }
            if ((i & 4) != 0) {
                privateSubtitleData = subtitleDataProp.data;
            }
            return subtitleDataProp.copy(num, str, privateSubtitleData);
        }

        public final Integer component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final PrivateSubtitleData component3() {
            return this.data;
        }

        public final SubtitleDataProp copy(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") PrivateSubtitleData privateSubtitleData) {
            return new SubtitleDataProp(num, str, privateSubtitleData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubtitleDataProp) {
                SubtitleDataProp subtitleDataProp = (SubtitleDataProp) obj;
                return Intrinsics.areEqual(this.code, subtitleDataProp.code) && Intrinsics.areEqual(this.msg, subtitleDataProp.msg) && Intrinsics.areEqual(this.data, subtitleDataProp.data);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.code;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.msg;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            PrivateSubtitleData privateSubtitleData = this.data;
            return hashCode2 + (privateSubtitleData != null ? privateSubtitleData.hashCode() : 0);
        }

        public String toString() {
            return "SubtitleDataProp(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ')';
        }

        public SubtitleDataProp(@JsonProperty("code") Integer num, @JsonProperty("msg") String str, @JsonProperty("data") PrivateSubtitleData privateSubtitleData) {
            this.code = num;
            this.msg = str;
            this.data = privateSubtitleData;
        }

        public final Integer getCode() {
            return this.code;
        }

        public final String getMsg() {
            return this.msg;
        }

        public /* synthetic */ SubtitleDataProp(Integer num, String str, PrivateSubtitleData privateSubtitleData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new PrivateSubtitleData(null, null, 3, null) : privateSubtitleData);
        }

        public final PrivateSubtitleData getData() {
            return this.data;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u009e\u0001\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b \u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\"\u0010\u0016¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Subtitles;", "", "sid", "", "mid", "", "filePath", "lang", "language", "delay", "point", "order", "adminOrder", "myselect", "addTime", "", "count", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)V", "getAddTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAdminOrder", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCount", "getDelay", "getFilePath", "()Ljava/lang/String;", "getLang", "getLanguage", "getMid", "getMyselect", "getOrder", "getPoint", "getSid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Subtitles;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Subtitles {
        private final Long addTime;
        private final Integer adminOrder;
        private final Integer count;
        private final Integer delay;
        private final String filePath;
        private final String lang;
        private final String language;
        private final String mid;
        private final Integer myselect;
        private final Integer order;
        private final String point;
        private final Integer sid;

        public Subtitles() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, 4095, null);
        }

        public final Integer component1() {
            return this.sid;
        }

        public final Integer component10() {
            return this.myselect;
        }

        public final Long component11() {
            return this.addTime;
        }

        public final Integer component12() {
            return this.count;
        }

        public final String component2() {
            return this.mid;
        }

        public final String component3() {
            return this.filePath;
        }

        public final String component4() {
            return this.lang;
        }

        public final String component5() {
            return this.language;
        }

        public final Integer component6() {
            return this.delay;
        }

        public final String component7() {
            return this.point;
        }

        public final Integer component8() {
            return this.order;
        }

        public final Integer component9() {
            return this.adminOrder;
        }

        public final Subtitles copy(@JsonProperty("sid") Integer num, @JsonProperty("mid") String str, @JsonProperty("file_path") String str2, @JsonProperty("lang") String str3, @JsonProperty("language") String str4, @JsonProperty("delay") Integer num2, @JsonProperty("point") String str5, @JsonProperty("order") Integer num3, @JsonProperty("admin_order") Integer num4, @JsonProperty("myselect") Integer num5, @JsonProperty("add_time") Long l, @JsonProperty("count") Integer num6) {
            return new Subtitles(num, str, str2, str3, str4, num2, str5, num3, num4, num5, l, num6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Subtitles) {
                Subtitles subtitles = (Subtitles) obj;
                return Intrinsics.areEqual(this.sid, subtitles.sid) && Intrinsics.areEqual(this.mid, subtitles.mid) && Intrinsics.areEqual(this.filePath, subtitles.filePath) && Intrinsics.areEqual(this.lang, subtitles.lang) && Intrinsics.areEqual(this.language, subtitles.language) && Intrinsics.areEqual(this.delay, subtitles.delay) && Intrinsics.areEqual(this.point, subtitles.point) && Intrinsics.areEqual(this.order, subtitles.order) && Intrinsics.areEqual(this.adminOrder, subtitles.adminOrder) && Intrinsics.areEqual(this.myselect, subtitles.myselect) && Intrinsics.areEqual(this.addTime, subtitles.addTime) && Intrinsics.areEqual(this.count, subtitles.count);
            }
            return false;
        }

        public int hashCode() {
            Integer num = this.sid;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            String str = this.mid;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.filePath;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.lang;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.language;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Integer num2 = this.delay;
            int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str5 = this.point;
            int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
            Integer num3 = this.order;
            int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
            Integer num4 = this.adminOrder;
            int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
            Integer num5 = this.myselect;
            int hashCode10 = (hashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
            Long l = this.addTime;
            int hashCode11 = (hashCode10 + (l == null ? 0 : l.hashCode())) * 31;
            Integer num6 = this.count;
            return hashCode11 + (num6 != null ? num6.hashCode() : 0);
        }

        public String toString() {
            return "Subtitles(sid=" + this.sid + ", mid=" + this.mid + ", filePath=" + this.filePath + ", lang=" + this.lang + ", language=" + this.language + ", delay=" + this.delay + ", point=" + this.point + ", order=" + this.order + ", adminOrder=" + this.adminOrder + ", myselect=" + this.myselect + ", addTime=" + this.addTime + ", count=" + this.count + ')';
        }

        public Subtitles(@JsonProperty("sid") Integer num, @JsonProperty("mid") String str, @JsonProperty("file_path") String str2, @JsonProperty("lang") String str3, @JsonProperty("language") String str4, @JsonProperty("delay") Integer num2, @JsonProperty("point") String str5, @JsonProperty("order") Integer num3, @JsonProperty("admin_order") Integer num4, @JsonProperty("myselect") Integer num5, @JsonProperty("add_time") Long l, @JsonProperty("count") Integer num6) {
            this.sid = num;
            this.mid = str;
            this.filePath = str2;
            this.lang = str3;
            this.language = str4;
            this.delay = num2;
            this.point = str5;
            this.order = num3;
            this.adminOrder = num4;
            this.myselect = num5;
            this.addTime = l;
            this.count = num6;
        }

        public /* synthetic */ Subtitles(Integer num, String str, String str2, String str3, String str4, Integer num2, String str5, Integer num3, Integer num4, Integer num5, Long l, Integer num6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? null : num4, (i & 512) != 0 ? null : num5, (i & 1024) != 0 ? null : l, (i & 2048) == 0 ? num6 : null);
        }

        public final Integer getSid() {
            return this.sid;
        }

        public final String getMid() {
            return this.mid;
        }

        public final String getFilePath() {
            return this.filePath;
        }

        public final String getLang() {
            return this.lang;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final Integer getDelay() {
            return this.delay;
        }

        public final String getPoint() {
            return this.point;
        }

        public final Integer getOrder() {
            return this.order;
        }

        public final Integer getAdminOrder() {
            return this.adminOrder;
        }

        public final Integer getMyselect() {
            return this.myselect;
        }

        public final Long getAddTime() {
            return this.addTime;
        }

        public final Integer getCount() {
            return this.count;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0003\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SubtitleList;", "", "language", "", "subtitles", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$Subtitles;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getLanguage", "()Ljava/lang/String;", "getSubtitles", "()Ljava/util/ArrayList;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class SubtitleList {
        private final String language;
        private final ArrayList<Subtitles> subtitles;

        public SubtitleList() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SubtitleList copy$default(SubtitleList subtitleList, String str, ArrayList arrayList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitleList.language;
            }
            if ((i & 2) != 0) {
                arrayList = subtitleList.subtitles;
            }
            return subtitleList.copy(str, arrayList);
        }

        public final String component1() {
            return this.language;
        }

        public final ArrayList<Subtitles> component2() {
            return this.subtitles;
        }

        public final SubtitleList copy(@JsonProperty("language") String str, @JsonProperty("subtitles") ArrayList<Subtitles> subtitles) {
            Intrinsics.checkNotNullParameter(subtitles, "subtitles");
            return new SubtitleList(str, subtitles);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubtitleList) {
                SubtitleList subtitleList = (SubtitleList) obj;
                return Intrinsics.areEqual(this.language, subtitleList.language) && Intrinsics.areEqual(this.subtitles, subtitleList.subtitles);
            }
            return false;
        }

        public int hashCode() {
            String str = this.language;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.subtitles.hashCode();
        }

        public String toString() {
            return "SubtitleList(language=" + this.language + ", subtitles=" + this.subtitles + ')';
        }

        public SubtitleList(@JsonProperty("language") String str, @JsonProperty("subtitles") ArrayList<Subtitles> subtitles) {
            Intrinsics.checkNotNullParameter(subtitles, "subtitles");
            this.language = str;
            this.subtitles = subtitles;
        }

        public final String getLanguage() {
            return this.language;
        }

        public /* synthetic */ SubtitleList(String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? new ArrayList() : arrayList);
        }

        public final ArrayList<Subtitles> getSubtitles() {
            return this.subtitles;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SuperStream.kt */
    @Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0018\b\u0003\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\u0002\u0010\bJ\u0019\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\u0019\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0018\b\u0003\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/movieproviders/SuperStream$PrivateSubtitleData;", "", "select", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "list", "Lcom/lagradost/cloudstream3/movieproviders/SuperStream$SubtitleList;", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getSelect", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class PrivateSubtitleData {
        private final ArrayList<SubtitleList> list;
        private final ArrayList<String> select;

        public PrivateSubtitleData() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PrivateSubtitleData copy$default(PrivateSubtitleData privateSubtitleData, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
            if ((i & 1) != 0) {
                arrayList = privateSubtitleData.select;
            }
            if ((i & 2) != 0) {
                arrayList2 = privateSubtitleData.list;
            }
            return privateSubtitleData.copy(arrayList, arrayList2);
        }

        public final ArrayList<String> component1() {
            return this.select;
        }

        public final ArrayList<SubtitleList> component2() {
            return this.list;
        }

        public final PrivateSubtitleData copy(@JsonProperty("select") ArrayList<String> select, @JsonProperty("list") ArrayList<SubtitleList> list) {
            Intrinsics.checkNotNullParameter(select, "select");
            Intrinsics.checkNotNullParameter(list, "list");
            return new PrivateSubtitleData(select, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PrivateSubtitleData) {
                PrivateSubtitleData privateSubtitleData = (PrivateSubtitleData) obj;
                return Intrinsics.areEqual(this.select, privateSubtitleData.select) && Intrinsics.areEqual(this.list, privateSubtitleData.list);
            }
            return false;
        }

        public int hashCode() {
            return (this.select.hashCode() * 31) + this.list.hashCode();
        }

        public String toString() {
            return "PrivateSubtitleData(select=" + this.select + ", list=" + this.list + ')';
        }

        public PrivateSubtitleData(@JsonProperty("select") ArrayList<String> select, @JsonProperty("list") ArrayList<SubtitleList> list) {
            Intrinsics.checkNotNullParameter(select, "select");
            Intrinsics.checkNotNullParameter(list, "list");
            this.select = select;
            this.list = list;
        }

        public /* synthetic */ PrivateSubtitleData(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2);
        }

        public final ArrayList<String> getSelect() {
            return this.select;
        }

        public final ArrayList<SubtitleList> getList() {
            return this.list;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0221 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0179 A[SYNTHETIC] */
    @Override // com.lagradost.cloudstream3.MainAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadLinks(java.lang.String r11, boolean r12, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r13, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r14, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.SuperStream.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final ExtractorLink loadLinks$toExtractorLink(LinkList linkList, SuperStream superStream) {
        String path = linkList.getPath();
        if (path == null || StringsKt.isBlank(path)) {
            return null;
        }
        String name = superStream.getName();
        String size = linkList.getSize();
        if (size == null) {
            size = "";
        }
        return new ExtractorLink(name, size, StringsKt.replace$default(linkList.getPath(), "\\/", "", false, 4, (Object) null), "", ExtractorApiKt.getQualityFromName(linkList.getQuality()), false, null, null, 224, null);
    }

    private static final SubtitleFile loadLinks$toSubtitleFile(Subtitles subtitles) {
        String language = subtitles.getLanguage();
        if (language == null && (language = subtitles.getLang()) == null) {
            language = "";
        }
        String str = language;
        String filePath = subtitles.getFilePath();
        if (filePath == null) {
            return null;
        }
        return new SubtitleFile(str, filePath, null, 4, null);
    }
}
