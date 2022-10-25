package com.lagradost.cloudstream3.extractors;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WcoStream.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/WcoStream;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", SDKConstants.PARAM_KEY, "", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public class WcoStream extends ExtractorApi {
    public static final Companion Companion = new Companion(null);
    private static String keytwo = "";
    private final boolean requiresReferer;
    private String name = "VidStream";
    private String mainUrl = "https://vidstream.pro";
    private final String key = "LCbu3iYC7ln24K7P";

    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return getUrl$suspendImpl(this, str, str2, (Continuation) continuation);
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

    /* compiled from: WcoStream.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/WcoStream$Companion;", "", "()V", "keytwo", "", "getKeytwo", "()Ljava/lang/String;", "setKeytwo", "(Ljava/lang/String;)V", "cipher", "inputOne", "inputTwo", "encrypt", TvContractCompat.PARAM_INPUT, "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getKeytwo() {
            return WcoStream.keytwo;
        }

        public final void setKeytwo(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WcoStream.keytwo = str;
        }

        public final String encrypt(String input) {
            boolean z;
            Intrinsics.checkNotNullParameter(input, "input");
            String str = input;
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = false;
                    break;
                }
                if (str.charAt(i) >= 256) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                throw new Exception("illegal characters!");
            }
            String str2 = "";
            int progressionLastElement = progressionUtil.getProgressionLastElement(0, input.length() - 1, 3);
            if (progressionLastElement >= 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr = {-1, -1, -1, -1};
                    iArr[0] = input.charAt(i2) >> 2;
                    iArr[1] = (input.charAt(i2) & 3) << 4;
                    int i3 = i2 + 1;
                    if (input.length() > i3) {
                        iArr[1] = iArr[1] | (input.charAt(i3) >> 4);
                        iArr[2] = (input.charAt(i3) & 15) << 2;
                    }
                    int i4 = i2 + 2;
                    if (input.length() > i4) {
                        iArr[2] = iArr[2] | (input.charAt(i4) >> 6);
                        iArr[3] = input.charAt(i4) & '?';
                    }
                    for (int i5 = 0; i5 < 4; i5++) {
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            str2 = str2 + '=';
                        } else if (i6 >= 0 && i6 < 64) {
                            str2 = str2 + getKeytwo().charAt(i6);
                        }
                    }
                    if (i2 == progressionLastElement) {
                        break;
                    }
                    i2 += 3;
                }
            }
            return str2;
        }

        public final String cipher(String inputOne, String inputTwo) {
            Intrinsics.checkNotNullParameter(inputOne, "inputOne");
            Intrinsics.checkNotNullParameter(inputTwo, "inputTwo");
            int[] iArr = new int[256];
            for (int i = 0; i < 256; i++) {
                iArr[i] = i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < 256; i3++) {
                i2 = ((i2 + iArr[i3]) + inputOne.charAt(i3 % inputOne.length())) % 256;
                int i4 = iArr[i3];
                iArr[i3] = iArr[i2];
                iArr[i2] = i4;
            }
            int length = inputTwo.length();
            String str = "";
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                i5 = (i5 + i7) % 256;
                i6 = (i6 + iArr[i5]) % 256;
                int i8 = iArr[i5];
                iArr[i5] = iArr[i6];
                iArr[i6] = i8;
                str = str + ((char) (inputTwo.charAt(i7) ^ iArr[(iArr[i5] + iArr[i6]) % 256]));
            }
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.WcoStream r41, java.lang.String r42, java.lang.String r43, kotlin.coroutines.Continuation r44) {
        /*
            Method dump skipped, instructions count: 829
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.WcoStream.getUrl$suspendImpl(com.lagradost.cloudstream3.extractors.WcoStream, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
