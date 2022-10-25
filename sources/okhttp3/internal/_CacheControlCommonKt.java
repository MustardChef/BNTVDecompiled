package okhttp3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnitJvm;
import okhttp3.CacheControl;

/* compiled from: -CacheControlCommon.kt */
@Metadata(m108d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0001H\u0000\u001a\u001e\u0010\u001b\u001a\u00020\u0004*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0002¨\u0006\u001e"}, m107d2 = {"commonBuild", "Lokhttp3/CacheControl;", "Lokhttp3/CacheControl$Builder;", "commonClampToInt", "", "", "commonForceCache", "Lokhttp3/CacheControl$Companion;", "commonForceNetwork", "commonImmutable", "commonMaxAge", "maxAge", "timeUnit", "Lkotlin/time/DurationUnit;", "commonMaxStale", "maxStale", "commonMinFresh", "minFresh", "commonNoCache", "commonNoStore", "commonNoTransform", "commonOnlyIfCached", "commonParse", "headers", "Lokhttp3/Headers;", "commonToString", "", "indexOfElement", "characters", "startIndex", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _CacheControlCommonKt {
    public static final int commonClampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static final String commonToString(CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(cacheControl, "<this>");
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp == null) {
            StringBuilder sb = new StringBuilder();
            if (cacheControl.noCache()) {
                sb.append("no-cache, ");
            }
            if (cacheControl.noStore()) {
                sb.append("no-store, ");
            }
            if (cacheControl.maxAgeSeconds() != -1) {
                sb.append("max-age=");
                sb.append(cacheControl.maxAgeSeconds());
                sb.append(", ");
            }
            if (cacheControl.sMaxAgeSeconds() != -1) {
                sb.append("s-maxage=");
                sb.append(cacheControl.sMaxAgeSeconds());
                sb.append(", ");
            }
            if (cacheControl.isPrivate()) {
                sb.append("private, ");
            }
            if (cacheControl.isPublic()) {
                sb.append("public, ");
            }
            if (cacheControl.mustRevalidate()) {
                sb.append("must-revalidate, ");
            }
            if (cacheControl.maxStaleSeconds() != -1) {
                sb.append("max-stale=");
                sb.append(cacheControl.maxStaleSeconds());
                sb.append(", ");
            }
            if (cacheControl.minFreshSeconds() != -1) {
                sb.append("min-fresh=");
                sb.append(cacheControl.minFreshSeconds());
                sb.append(", ");
            }
            if (cacheControl.onlyIfCached()) {
                sb.append("only-if-cached, ");
            }
            if (cacheControl.noTransform()) {
                sb.append("no-transform, ");
            }
            if (cacheControl.immutable()) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(sb.delete(sb.length() - 2, sb.length()), "this.delete(startIndex, endIndex)");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            cacheControl.setHeaderValue$okhttp(sb2);
            return sb2;
        }
        return headerValue$okhttp;
    }

    public static final CacheControl.Builder commonMaxAge(CacheControl.Builder builder, int i, DurationUnitJvm timeUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxAge < 0: ", Integer.valueOf(i)).toString());
        }
        builder.setMaxAgeSeconds$okhttp(commonClampToInt(Duration.m10382getInWholeSecondsimpl(DurationKt.toDuration(i, timeUnit))));
        return builder;
    }

    public static final CacheControl.Builder commonMaxStale(CacheControl.Builder builder, int i, DurationUnitJvm timeUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("maxStale < 0: ", Integer.valueOf(i)).toString());
        }
        builder.setMaxStaleSeconds$okhttp(commonClampToInt(Duration.m10382getInWholeSecondsimpl(DurationKt.toDuration(i, timeUnit))));
        return builder;
    }

    public static final CacheControl.Builder commonMinFresh(CacheControl.Builder builder, int i, DurationUnitJvm timeUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("minFresh < 0: ", Integer.valueOf(i)).toString());
        }
        builder.setMinFreshSeconds$okhttp(commonClampToInt(Duration.m10382getInWholeSecondsimpl(DurationKt.toDuration(i, timeUnit))));
        return builder;
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl commonForceCache(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CacheControl.Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, DurationUnitJvm.SECONDS).build();
    }

    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okhttp3.CacheControl commonParse(okhttp3.CacheControl.Companion r28, okhttp3.Headers r29) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonParse(okhttp3.CacheControl$Companion, okhttp3.Headers):okhttp3.CacheControl");
    }

    static /* synthetic */ int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }

    private static final int indexOfElement(String str, String str2, int i) {
        int length = str.length();
        while (i < length) {
            int i2 = i + 1;
            if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i = i2;
        }
        return str.length();
    }
}
