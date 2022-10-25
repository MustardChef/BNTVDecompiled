package com.lagradost.cloudstream3.extractors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.firebase.messaging.Constants;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamSB.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0003\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J+\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/StreamSB;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "hexArray", "", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "bytesToHex", "bytes", "", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Main", "StreamData", "Subs", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class StreamSB extends ExtractorApi {
    private final char[] hexArray;
    private final boolean requiresReferer;
    private String name = "StreamSB";
    private String mainUrl = "https://watchsb.com";

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, (Continuation) continuation);
    }

    public StreamSB() {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        this.hexArray = charArray;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainUrl = str;
    }

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    private final String bytesToHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = this.hexArray;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* compiled from: StreamSB.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/StreamSB$Subs;", "", "file", "", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Subs {
        private final String file;
        private final String label;

        public static /* synthetic */ Subs copy$default(Subs subs, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subs.file;
            }
            if ((i & 2) != 0) {
                str2 = subs.label;
            }
            return subs.copy(str, str2);
        }

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.label;
        }

        public final Subs copy(@JsonProperty("file") String file, @JsonProperty("label") String label) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            return new Subs(file, label);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Subs) {
                Subs subs = (Subs) obj;
                return Intrinsics.areEqual(this.file, subs.file) && Intrinsics.areEqual(this.label, subs.label);
            }
            return false;
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + this.label.hashCode();
        }

        public String toString() {
            return "Subs(file=" + this.file + ", label=" + this.label + ')';
        }

        public Subs(@JsonProperty("file") String file, @JsonProperty("label") String label) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(label, "label");
            this.file = file;
            this.label = label;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: StreamSB.kt */
    @Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\u0010\b\u0001\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003Ja\u0010 \u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\u0010\b\u0003\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f¨\u0006'"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/StreamSB$StreamData;", "", "file", "", "cdnImg", "hash", "subs", "", "Lcom/lagradost/cloudstream3/extractors/StreamSB$Subs;", SessionDescription.ATTR_LENGTH, "id", "title", "backup", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackup", "()Ljava/lang/String;", "getCdnImg", "getFile", "getHash", "getId", "getLength", "getSubs", "()Ljava/util/List;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class StreamData {
        private final String backup;
        private final String cdnImg;
        private final String file;
        private final String hash;

        /* renamed from: id */
        private final String f9959id;
        private final String length;
        private final List<Subs> subs;
        private final String title;

        public final String component1() {
            return this.file;
        }

        public final String component2() {
            return this.cdnImg;
        }

        public final String component3() {
            return this.hash;
        }

        public final List<Subs> component4() {
            return this.subs;
        }

        public final String component5() {
            return this.length;
        }

        public final String component6() {
            return this.f9959id;
        }

        public final String component7() {
            return this.title;
        }

        public final String component8() {
            return this.backup;
        }

        public final StreamData copy(@JsonProperty("file") String file, @JsonProperty("cdn_img") String cdnImg, @JsonProperty("hash") String hash, @JsonProperty("subs") List<Subs> list, @JsonProperty("length") String length, @JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("backup") String backup) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(cdnImg, "cdnImg");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(length, "length");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(backup, "backup");
            return new StreamData(file, cdnImg, hash, list, length, id, title, backup);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StreamData) {
                StreamData streamData = (StreamData) obj;
                return Intrinsics.areEqual(this.file, streamData.file) && Intrinsics.areEqual(this.cdnImg, streamData.cdnImg) && Intrinsics.areEqual(this.hash, streamData.hash) && Intrinsics.areEqual(this.subs, streamData.subs) && Intrinsics.areEqual(this.length, streamData.length) && Intrinsics.areEqual(this.f9959id, streamData.f9959id) && Intrinsics.areEqual(this.title, streamData.title) && Intrinsics.areEqual(this.backup, streamData.backup);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = ((((this.file.hashCode() * 31) + this.cdnImg.hashCode()) * 31) + this.hash.hashCode()) * 31;
            List<Subs> list = this.subs;
            return ((((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.length.hashCode()) * 31) + this.f9959id.hashCode()) * 31) + this.title.hashCode()) * 31) + this.backup.hashCode();
        }

        public String toString() {
            return "StreamData(file=" + this.file + ", cdnImg=" + this.cdnImg + ", hash=" + this.hash + ", subs=" + this.subs + ", length=" + this.length + ", id=" + this.f9959id + ", title=" + this.title + ", backup=" + this.backup + ')';
        }

        public StreamData(@JsonProperty("file") String file, @JsonProperty("cdn_img") String cdnImg, @JsonProperty("hash") String hash, @JsonProperty("subs") List<Subs> list, @JsonProperty("length") String length, @JsonProperty("id") String id, @JsonProperty("title") String title, @JsonProperty("backup") String backup) {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(cdnImg, "cdnImg");
            Intrinsics.checkNotNullParameter(hash, "hash");
            Intrinsics.checkNotNullParameter(length, "length");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(backup, "backup");
            this.file = file;
            this.cdnImg = cdnImg;
            this.hash = hash;
            this.subs = list;
            this.length = length;
            this.f9959id = id;
            this.title = title;
            this.backup = backup;
        }

        public final String getFile() {
            return this.file;
        }

        public final String getCdnImg() {
            return this.cdnImg;
        }

        public final String getHash() {
            return this.hash;
        }

        public final List<Subs> getSubs() {
            return this.subs;
        }

        public final String getLength() {
            return this.length;
        }

        public final String getId() {
            return this.f9959id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getBackup() {
            return this.backup;
        }
    }

    /* compiled from: StreamSB.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/StreamSB$Main;", "", "streamData", "Lcom/lagradost/cloudstream3/extractors/StreamSB$StreamData;", "statusCode", "", "(Lcom/lagradost/cloudstream3/extractors/StreamSB$StreamData;I)V", "getStatusCode", "()I", "getStreamData", "()Lcom/lagradost/cloudstream3/extractors/StreamSB$StreamData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Main {
        private final int statusCode;
        private final StreamData streamData;

        public static /* synthetic */ Main copy$default(Main main, StreamData streamData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                streamData = main.streamData;
            }
            if ((i2 & 2) != 0) {
                i = main.statusCode;
            }
            return main.copy(streamData, i);
        }

        public final StreamData component1() {
            return this.streamData;
        }

        public final int component2() {
            return this.statusCode;
        }

        public final Main copy(@JsonProperty("stream_data") StreamData streamData, @JsonProperty("status_code") int i) {
            Intrinsics.checkNotNullParameter(streamData, "streamData");
            return new Main(streamData, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Main) {
                Main main = (Main) obj;
                return Intrinsics.areEqual(this.streamData, main.streamData) && this.statusCode == main.statusCode;
            }
            return false;
        }

        public int hashCode() {
            return (this.streamData.hashCode() * 31) + this.statusCode;
        }

        public String toString() {
            return "Main(streamData=" + this.streamData + ", statusCode=" + this.statusCode + ')';
        }

        public Main(@JsonProperty("stream_data") StreamData streamData, @JsonProperty("status_code") int i) {
            Intrinsics.checkNotNullParameter(streamData, "streamData");
            this.streamData = streamData;
            this.statusCode = i;
        }

        public final StreamData getStreamData() {
            return this.streamData;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x016b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.StreamSB r26, java.lang.String r27, java.lang.String r28, kotlin.coroutines.Continuation r29) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.StreamSB.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.StreamSB, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
