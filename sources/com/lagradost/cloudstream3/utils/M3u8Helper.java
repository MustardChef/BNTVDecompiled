package com.lagradost.cloudstream3.utils;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: M3u8Helper.kt */
@Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0003&'(B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\fH\u0002J#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u0004\u0018\u00010\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/M3u8Helper;", "", "()V", "ENCRYPTION_DETECTION_REGEX", "Lkotlin/text/Regex;", "ENCRYPTION_URL_IV_REGEX", "QUALITY_REGEX", "TS_EXTENSION_REGEX", "defaultIvGen", "", "", "absoluteExtensionDetermination", "", "url", "getDecrypter", "secretKey", "data", "iv", "getParentLink", ShareConstants.MEDIA_URI, "hlsYield", "Lcom/lagradost/cloudstream3/utils/M3u8Helper$HlsDownloadData;", "qualities", "", "Lcom/lagradost/cloudstream3/utils/M3u8Helper$M3u8Stream;", "startIndex", "", "isEncrypted", "", "m3u8Data", "isNotCompleteUrl", "m3u8Generation", "m3u8", "returnThis", "(Lcom/lagradost/cloudstream3/utils/M3u8Helper$M3u8Stream;Ljava/lang/Boolean;)Ljava/util/List;", "selectBest", "toBytes16Big", "n", "Companion", "HlsDownloadData", "M3u8Stream", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class M3u8Helper {
    public static final Companion Companion = new Companion(null);
    private static final M3u8Helper generator = new M3u8Helper();
    private final Regex ENCRYPTION_DETECTION_REGEX = new Regex("#EXT-X-KEY:METHOD=([^,]+),");
    private final Regex ENCRYPTION_URL_IV_REGEX = new Regex("#EXT-X-KEY:METHOD=([^,]+),URI=\"([^\"]+)\"(?:,IV=(.*))?");
    private final Regex QUALITY_REGEX = new Regex("#EXT-X-STREAM-INF:(?:(?:.*?(?:RESOLUTION=\\d+x(\\d+)).*?\\s+(.*))|(?:.*?\\s+(.*)))");
    private final Regex TS_EXTENSION_REGEX = new Regex("(.*\\.ts.*|.*\\.jpg.*|.*\\.html.*|.*\\.txt.*)");
    private final Iterator<byte[]> defaultIvGen = SequencesKt.sequence(new M3u8Helper$defaultIvGen$1(this, null)).iterator();

    /* compiled from: M3u8Helper.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JU\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/M3u8Helper$Companion;", "", "()V", "generator", "Lcom/lagradost/cloudstream3/utils/M3u8Helper;", "generateM3u8", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "source", "", "streamUrl", "referer", "quality", "", "headers", "", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;Ljava/lang/String;)Ljava/util/List;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ List generateM3u8$default(Companion companion, String str, String str2, String str3, Integer num, Map map, String str4, int i, Object obj) {
            if ((i & 8) != 0) {
                num = null;
            }
            Integer num2 = num;
            Map map2 = map;
            if ((i & 16) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return companion.generateM3u8(str, str2, str3, num2, map2, (i & 32) != 0 ? str : str4);
        }

        public final List<ExtractorLink> generateM3u8(String source, String streamUrl, String referer, Integer num, Map<String, String> headers, String name) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
            Intrinsics.checkNotNullParameter(referer, "referer");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(name, "name");
            List<M3u8Stream> m3u8Generation = M3u8Helper.generator.m3u8Generation(new M3u8Stream(streamUrl, num, headers), null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(m3u8Generation, 10));
            for (M3u8Stream m3u8Stream : m3u8Generation) {
                String streamUrl2 = m3u8Stream.getStreamUrl();
                Integer quality = m3u8Stream.getQuality();
                arrayList.add(new ExtractorLink(source, name, streamUrl2, referer, quality != null ? quality.intValue() : Qualities.Unknown.getValue(), true, m3u8Stream.getHeaders(), null, 128, null));
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String absoluteExtensionDetermination(String str) {
        List split$default;
        String str2 = (String) StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null).get(split$default.size() - 1), new String[]{"?"}, false, 0, 6, (Object) null).get(0);
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) ".", false, 2, (Object) null)) {
            List split$default2 = StringsKt.split$default((CharSequence) str2, new String[]{"."}, false, 0, 6, (Object) null);
            if (split$default2.isEmpty()) {
                split$default2 = null;
            }
            List list = split$default2;
            if (list != null) {
                return (String) CollectionsKt.last((List<? extends Object>) list);
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] toBytes16Big(int i) {
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = (byte) (Math.max(0, (int) (i / Math.pow(256.0d, 15 - i2))) % 256);
        }
        return bArr;
    }

    static /* synthetic */ byte[] getDecrypter$default(M3u8Helper m3u8Helper, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, Object obj) {
        if ((i & 4) != 0) {
            bArr3 = "".getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bArr3, "this as java.lang.String).getBytes(charset)");
        }
        return m3u8Helper.getDecrypter(bArr, bArr2, bArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] getDecrypter(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3.length == 0) {
            bArr3 = this.defaultIvGen.next();
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr3));
        byte[] doFinal = cipher.doFinal(bArr2);
        Intrinsics.checkNotNullExpressionValue(doFinal, "c.doFinal(data)");
        return doFinal;
    }

    private final boolean isEncrypted(String str) {
        MatchResult find$default = Regex.find$default(this.ENCRYPTION_DETECTION_REGEX, str, 0, 2, null);
        if (find$default != null) {
            return (find$default.getValue().length() > 0) || !Intrinsics.areEqual(find$default.getDestructured().getMatch().getGroupValues().get(1), "NONE");
        }
        return false;
    }

    /* compiled from: M3u8Helper.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0015\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J:\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/M3u8Helper$M3u8Stream;", "", "streamUrl", "", "quality", "", "headers", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getHeaders", "()Ljava/util/Map;", "getQuality", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStreamUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/lagradost/cloudstream3/utils/M3u8Helper$M3u8Stream;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class M3u8Stream {
        private final Map<String, String> headers;
        private final Integer quality;
        private final String streamUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ M3u8Stream copy$default(M3u8Stream m3u8Stream, String str, Integer num, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = m3u8Stream.streamUrl;
            }
            if ((i & 2) != 0) {
                num = m3u8Stream.quality;
            }
            if ((i & 4) != 0) {
                map = m3u8Stream.headers;
            }
            return m3u8Stream.copy(str, num, map);
        }

        public final String component1() {
            return this.streamUrl;
        }

        public final Integer component2() {
            return this.quality;
        }

        public final Map<String, String> component3() {
            return this.headers;
        }

        public final M3u8Stream copy(String streamUrl, Integer num, Map<String, String> headers) {
            Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            return new M3u8Stream(streamUrl, num, headers);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof M3u8Stream) {
                M3u8Stream m3u8Stream = (M3u8Stream) obj;
                return Intrinsics.areEqual(this.streamUrl, m3u8Stream.streamUrl) && Intrinsics.areEqual(this.quality, m3u8Stream.quality) && Intrinsics.areEqual(this.headers, m3u8Stream.headers);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.streamUrl.hashCode() * 31;
            Integer num = this.quality;
            return ((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.headers.hashCode();
        }

        public String toString() {
            return "M3u8Stream(streamUrl=" + this.streamUrl + ", quality=" + this.quality + ", headers=" + this.headers + ')';
        }

        public M3u8Stream(String streamUrl, Integer num, Map<String, String> headers) {
            Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.streamUrl = streamUrl;
            this.quality = num;
            this.headers = headers;
        }

        public final String getStreamUrl() {
            return this.streamUrl;
        }

        public final Integer getQuality() {
            return this.quality;
        }

        public /* synthetic */ M3u8Stream(String str, Integer num, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }
    }

    private final M3u8Stream selectBest(List<M3u8Stream> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.sortedWith(list, new Comparator() { // from class: com.lagradost.cloudstream3.utils.M3u8Helper$selectBest$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                M3u8Helper.M3u8Stream m3u8Stream = (M3u8Helper.M3u8Stream) t;
                int i = 0;
                Integer valueOf = Integer.valueOf((m3u8Stream.getQuality() == null || m3u8Stream.getQuality().intValue() > 1080) ? 0 : m3u8Stream.getQuality().intValue());
                M3u8Helper.M3u8Stream m3u8Stream2 = (M3u8Helper.M3u8Stream) t2;
                if (m3u8Stream2.getQuality() != null && m3u8Stream2.getQuality().intValue() <= 1080) {
                    i = m3u8Stream2.getQuality().intValue();
                }
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
            }
        })) {
            if (CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{"m3u", "m3u8"}), absoluteExtensionDetermination(((M3u8Stream) obj).getStreamUrl()))) {
                arrayList.add(obj);
            }
        }
        return (M3u8Stream) CollectionsKt.getOrNull(arrayList, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getParentLink(String str) {
        List mutableList = CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) str, new String[]{"/"}, false, 0, 6, (Object) null));
        CollectionsKt.removeLast(mutableList);
        return CollectionsKt.joinToString$default(mutableList, "/", null, null, 0, null, null, 62, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isNotCompleteUrl(String str) {
        String str2 = str;
        return (StringsKt.contains$default((CharSequence) str2, (CharSequence) "https://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "http://", false, 2, (Object) null)) ? false : true;
    }

    public final List<M3u8Stream> m3u8Generation(M3u8Stream m3u8, Boolean bool) {
        Intrinsics.checkNotNullParameter(m3u8, "m3u8");
        return SequencesKt.toList(SequencesKt.sequence(new M3u8Helper$m3u8Generation$generate$1(this, m3u8, bool, null)));
    }

    /* compiled from: M3u8Helper.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/M3u8Helper$HlsDownloadData;", "", "bytes", "", "currentIndex", "", "totalTs", "errored", "", "([BIIZ)V", "getBytes", "()[B", "getCurrentIndex", "()I", "getErrored", "()Z", "getTotalTs", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class HlsDownloadData {
        private final byte[] bytes;
        private final int currentIndex;
        private final boolean errored;
        private final int totalTs;

        public static /* synthetic */ HlsDownloadData copy$default(HlsDownloadData hlsDownloadData, byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                bArr = hlsDownloadData.bytes;
            }
            if ((i3 & 2) != 0) {
                i = hlsDownloadData.currentIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = hlsDownloadData.totalTs;
            }
            if ((i3 & 8) != 0) {
                z = hlsDownloadData.errored;
            }
            return hlsDownloadData.copy(bArr, i, i2, z);
        }

        public final byte[] component1() {
            return this.bytes;
        }

        public final int component2() {
            return this.currentIndex;
        }

        public final int component3() {
            return this.totalTs;
        }

        public final boolean component4() {
            return this.errored;
        }

        public final HlsDownloadData copy(byte[] bytes, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            return new HlsDownloadData(bytes, i, i2, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HlsDownloadData) {
                HlsDownloadData hlsDownloadData = (HlsDownloadData) obj;
                return Intrinsics.areEqual(this.bytes, hlsDownloadData.bytes) && this.currentIndex == hlsDownloadData.currentIndex && this.totalTs == hlsDownloadData.totalTs && this.errored == hlsDownloadData.errored;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((Arrays.hashCode(this.bytes) * 31) + this.currentIndex) * 31) + this.totalTs) * 31;
            boolean z = this.errored;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "HlsDownloadData(bytes=" + Arrays.toString(this.bytes) + ", currentIndex=" + this.currentIndex + ", totalTs=" + this.totalTs + ", errored=" + this.errored + ')';
        }

        public HlsDownloadData(byte[] bytes, int i, int i2, boolean z) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            this.bytes = bytes;
            this.currentIndex = i;
            this.totalTs = i2;
            this.errored = z;
        }

        public /* synthetic */ HlsDownloadData(byte[] bArr, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, i, i2, (i3 & 8) != 0 ? false : z);
        }

        public final byte[] getBytes() {
            return this.bytes;
        }

        public final int getCurrentIndex() {
            return this.currentIndex;
        }

        public final int getTotalTs() {
            return this.totalTs;
        }

        public final boolean getErrored() {
            return this.errored;
        }
    }

    public static /* synthetic */ Iterator hlsYield$default(M3u8Helper m3u8Helper, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m3u8Helper.hlsYield(list, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0123, code lost:
        if (r5 == null) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v8, types: [T, byte[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v14, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v6, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, byte[]] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Iterator<com.lagradost.cloudstream3.utils.M3u8Helper.HlsDownloadData> hlsYield(java.util.List<com.lagradost.cloudstream3.utils.M3u8Helper.M3u8Stream> r16, int r17) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.M3u8Helper.hlsYield(java.util.List, int):java.util.Iterator");
    }
}
