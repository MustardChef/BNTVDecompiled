package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.preference.PreferenceManager;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.bongngotv2.R;
import com.google.android.exoplayer2.text.SubtitleDecoder;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: CustomSubtitleDecoderFactory.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CustomDecoder;", "Lcom/google/android/exoplayer2/text/SubtitleDecoder;", "()V", "realDecoder", "dequeueInputBuffer", "Lcom/google/android/exoplayer2/text/SubtitleInputBuffer;", "dequeueOutputBuffer", "Lcom/google/android/exoplayer2/text/SubtitleOutputBuffer;", "flush", "", "getName", "", "getStr", TvContractCompat.PARAM_INPUT, "Lkotlin/Pair;", "Ljava/nio/charset/Charset;", "byteArray", "", "queueInputBuffer", "inputBuffer", "release", "setPositionUs", "positionUs", "", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.CustomDecoder */
/* loaded from: classes3.dex */
public final class CustomDecoder implements SubtitleDecoder {
    private static final String TAG = "CustomDecoder";
    private static final String UTF_8 = "UTF-8";
    private static String overrideEncoding;
    private static boolean regexSubtitlesToRemoveBloat;
    private static boolean regexSubtitlesToRemoveCaptions;
    private SubtitleDecoder realDecoder;
    public static final Companion Companion = new Companion(null);
    private static final List<Regex> bloatRegex = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("Support\\s+us\\s+and\\s+become\\s+VIP\\s+member\\s+to\\s+remove\\s+all\\s+ads\\s+from\\s+(www\\.|)OpenSubtitles(\\.org|)", RegexOption.IGNORE_CASE), new Regex("Please\\s+rate\\s+this\\s+subtitle\\s+at\\s+.*\\s+Help\\s+other\\s+users\\s+to\\s+choose\\s+the\\s+best\\s+subtitles", RegexOption.IGNORE_CASE), new Regex("Contact\\s(www\\.|)OpenSubtitles(\\.org|)\\s+today", RegexOption.IGNORE_CASE), new Regex("Advertise\\s+your\\s+product\\s+or\\s+brand\\s+here", RegexOption.IGNORE_CASE)});
    private static final List<Regex> captionRegex = CollectionsKt.listOf(new Regex("(-\\s?|)[\\[({][\\w\\d\\s]*?[])}]\\s*"));

    /* compiled from: CustomSubtitleDecoderFactory.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/CustomDecoder$Companion;", "", "()V", "TAG", "", "UTF_8", "bloatRegex", "", "Lkotlin/text/Regex;", "getBloatRegex", "()Ljava/util/List;", "captionRegex", "getCaptionRegex", "overrideEncoding", "regexSubtitlesToRemoveBloat", "", "getRegexSubtitlesToRemoveBloat", "()Z", "setRegexSubtitlesToRemoveBloat", "(Z)V", "regexSubtitlesToRemoveCaptions", "getRegexSubtitlesToRemoveCaptions", "setRegexSubtitlesToRemoveCaptions", "trimStr", TypedValues.Custom.S_STRING, "updateForcedEncoding", "", "context", "Landroid/content/Context;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.CustomDecoder$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void updateForcedEncoding(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(R.string.subtitles_encoding_key), null);
            String str = string;
            if (str == null || StringsKt.isBlank(str)) {
                string = null;
            }
            CustomDecoder.overrideEncoding = string;
        }

        public final boolean getRegexSubtitlesToRemoveCaptions() {
            return CustomDecoder.regexSubtitlesToRemoveCaptions;
        }

        public final void setRegexSubtitlesToRemoveCaptions(boolean z) {
            CustomDecoder.regexSubtitlesToRemoveCaptions = z;
        }

        public final boolean getRegexSubtitlesToRemoveBloat() {
            return CustomDecoder.regexSubtitlesToRemoveBloat;
        }

        public final void setRegexSubtitlesToRemoveBloat(boolean z) {
            CustomDecoder.regexSubtitlesToRemoveBloat = z;
        }

        public final List<Regex> getBloatRegex() {
            return CustomDecoder.bloatRegex;
        }

        public final List<Regex> getCaptionRegex() {
            return CustomDecoder.captionRegex;
        }

        public final String trimStr(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return new Regex("[ \u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a\u205f]").replace(StringsKt.trim(StringsKt.trimStart((CharSequence) string).toString(), 65279, 8203), " ");
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public String getName() {
        SubtitleDecoder subtitleDecoder = this.realDecoder;
        String name = subtitleDecoder != null ? subtitleDecoder.getName() : null;
        if (name == null) {
            String name2 = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "this::class.java.name");
            return name2;
        }
        return name;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleInputBuffer dequeueInputBuffer() {
        Log.i(TAG, "dequeueInputBuffer");
        SubtitleDecoder subtitleDecoder = this.realDecoder;
        SubtitleInputBuffer dequeueInputBuffer = subtitleDecoder != null ? subtitleDecoder.dequeueInputBuffer() : null;
        return dequeueInputBuffer == null ? new SubtitleInputBuffer() : dequeueInputBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003c, code lost:
        if (r3 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.Tuples<java.lang.String, java.nio.charset.Charset> getStr(byte[] r8) {
        /*
            r7 = this;
            java.lang.String r0 = "forName(charsetName)"
            java.lang.String r1 = "UTF-8"
            java.lang.String r2 = "CustomDecoder"
            java.lang.String r3 = com.lagradost.cloudstream3.p041ui.player.CustomDecoder.overrideEncoding     // Catch: java.lang.Exception -> L40
            if (r3 != 0) goto L1e
            r3 = r7
            com.lagradost.cloudstream3.ui.player.CustomDecoder r3 = (com.lagradost.cloudstream3.p041ui.player.CustomDecoder) r3     // Catch: java.lang.Exception -> L40
            org.mozilla.universalchardet.UniversalDetector r3 = new org.mozilla.universalchardet.UniversalDetector     // Catch: java.lang.Exception -> L40
            r3.<init>()     // Catch: java.lang.Exception -> L40
            r4 = 0
            int r5 = r8.length     // Catch: java.lang.Exception -> L40
            r3.handleData(r8, r4, r5)     // Catch: java.lang.Exception -> L40
            r3.dataEnd()     // Catch: java.lang.Exception -> L40
            java.lang.String r3 = r3.getDetectedCharset()     // Catch: java.lang.Exception -> L40
        L1e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L40
            r4.<init>()     // Catch: java.lang.Exception -> L40
            java.lang.String r5 = "Detected encoding with charset "
            r4.append(r5)     // Catch: java.lang.Exception -> L40
            r4.append(r3)     // Catch: java.lang.Exception -> L40
            java.lang.String r5 = " and override = "
            r4.append(r5)     // Catch: java.lang.Exception -> L40
            java.lang.String r5 = com.lagradost.cloudstream3.p041ui.player.CustomDecoder.overrideEncoding     // Catch: java.lang.Exception -> L40
            r4.append(r5)     // Catch: java.lang.Exception -> L40
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L40
            android.util.Log.i(r2, r4)     // Catch: java.lang.Exception -> L40
            if (r3 != 0) goto L4c
        L3e:
            r3 = r1
            goto L4c
        L40:
            r3 = move-exception
            java.lang.String r4 = "Failed to detect encoding throwing error"
            android.util.Log.e(r2, r4)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r3)
            goto L3e
        L4c:
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r3)     // Catch: java.lang.Exception -> L5e
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch: java.lang.Exception -> L5e
            kotlin.Pair r5 = new kotlin.Pair     // Catch: java.lang.Exception -> L5e
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L5e
            r6.<init>(r8, r4)     // Catch: java.lang.Exception -> L5e
            r5.<init>(r6, r4)     // Catch: java.lang.Exception -> L5e
            goto L88
        L5e:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to parse using encoding "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            android.util.Log.e(r2, r3)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r4)
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.String r8 = kotlin.text.StringsKt.decodeToString(r8)
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r5.<init>(r8, r1)
        L88:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.CustomDecoder.getStr(byte[]):kotlin.Pair");
    }

    private final String getStr(SubtitleInputBuffer subtitleInputBuffer) {
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.data;
            if (byteBuffer == null) {
                return null;
            }
            byteBuffer.position(0);
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return Companion.trimStr(getStr(bArr).getFirst());
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse text returning plain data");
            ArchComponentExt.logError(e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f A[Catch: Exception -> 0x0193, TryCatch #0 {Exception -> 0x0193, blocks: (B:3:0x000c, B:6:0x001e, B:8:0x0023, B:14:0x002f, B:16:0x003c, B:30:0x007e, B:32:0x009a, B:34:0x00a2, B:36:0x00ae, B:38:0x00b2, B:39:0x00ba, B:41:0x00c0, B:42:0x00cd, B:44:0x00d1, B:45:0x00d9, B:47:0x00df, B:48:0x00ec, B:49:0x0108, B:51:0x0110, B:17:0x0044, B:19:0x004c, B:20:0x0054, B:22:0x005c, B:25:0x0065, B:27:0x006d, B:29:0x0077, B:52:0x0115, B:54:0x011f, B:58:0x0128, B:60:0x0139, B:62:0x013d, B:63:0x0145, B:65:0x014b, B:66:0x0158, B:68:0x015c, B:69:0x0164, B:71:0x016a, B:72:0x0177, B:73:0x018b, B:75:0x018f), top: B:80:0x000c }] */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer r10) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.player.CustomDecoder.queueInputBuffer(com.google.android.exoplayer2.text.SubtitleInputBuffer):void");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.decoder.Decoder
    public SubtitleOutputBuffer dequeueOutputBuffer() {
        SubtitleDecoder subtitleDecoder = this.realDecoder;
        if (subtitleDecoder != null) {
            return subtitleDecoder.dequeueOutputBuffer();
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void flush() {
        SubtitleDecoder subtitleDecoder = this.realDecoder;
        if (subtitleDecoder != null) {
            subtitleDecoder.flush();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        SubtitleDecoder subtitleDecoder = this.realDecoder;
        if (subtitleDecoder != null) {
            subtitleDecoder.release();
        }
    }

    @Override // com.google.android.exoplayer2.text.SubtitleDecoder
    public void setPositionUs(long j) {
        SubtitleDecoder subtitleDecoder = this.realDecoder;
        if (subtitleDecoder != null) {
            subtitleDecoder.setPositionUs(j);
        }
    }
}
