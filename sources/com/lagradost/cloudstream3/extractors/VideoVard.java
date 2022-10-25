package com.lagradost.cloudstream3.extractors;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.facebook.internal.ServerProtocol;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: VideoVard.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/VideoVard;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "url", "referer", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class VideoVard extends ExtractorApi {
    public static final Companion Companion = new Companion(null);
    private static final BigInteger big0;
    private static final BigInteger big15;
    private static final BigInteger big16;
    private static final BigInteger big255;
    private static final BigInteger big3;
    private static final BigInteger big4;
    private final boolean requiresReferer;
    private String name = "Videovard";
    private String mainUrl = "https://videovard.to";

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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0124 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c2  */
    @Override // com.lagradost.cloudstream3.utils.ExtractorApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getUrl(java.lang.String r33, java.lang.String r34, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.utils.ExtractorLink>> r35) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.VideoVard.getUrl(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: VideoVard.kt */
    @Metadata(m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002*+B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0002J*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J*\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J*\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/VideoVard$Companion;", "", "()V", "big0", "Ljava/math/BigInteger;", "big15", "big16", "big255", "big3", "big4", "ascii2bytes", "", TvContractCompat.PARAM_INPUT, "", "binaryDigest", "blocks2bytes", "inp", "bytes2blocks", "a22", "decode", "dataFile", "seed", "digestPad", TypedValues.Custom.S_STRING, "padLastChars", "rShift", "by", "", "replace", "a", "tearCode", "", "list1", "list2", "tearDecode", "a90", "a91", "unPad", "a46", "xorBlocks", "a76", "a77", "HashResponse", "SetupResponse", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String decode(String str, String str2) {
            List<BigInteger> binaryDigest = binaryDigest(replace(str2));
            List<BigInteger> bytes2blocks = bytes2blocks(ascii2bytes(str));
            int i = 0;
            List<Number> listOf = CollectionsKt.listOf((Object[]) new Integer[]{1633837924, 1650680933});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
            for (Number number : listOf) {
                BigInteger valueOf = BigInteger.valueOf(number.intValue());
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
                arrayList.add(valueOf);
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList();
            int progressionLastElement = progressionUtil.getProgressionLastElement(0, bytes2blocks.size() - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    List<? extends BigInteger> slice = CollectionsKt.slice((List) bytes2blocks, new IntRange(i, i + 1));
                    CollectionsKt.addAll(arrayList3, xorBlocks(arrayList2, tearDecode(slice, binaryDigest)));
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                    arrayList2 = slice;
                }
            }
            List<BigInteger> unPad = unPad(blocks2bytes(arrayList3));
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(unPad, 10));
            for (BigInteger bigInteger : unPad) {
                arrayList4.add(Character.valueOf((char) bigInteger.intValue()));
            }
            return padLastChars(replace(CollectionsKt.joinToString$default(arrayList4, "", null, null, 0, null, null, 62, null)));
        }

        private final List<BigInteger> binaryDigest(String str) {
            List<Number> listOf = CollectionsKt.listOf((Object[]) new Integer[]{1633837924, 1650680933, 1667523942, 1684366951});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
            for (Number number : listOf) {
                BigInteger valueOf = BigInteger.valueOf(number.intValue());
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
                arrayList.add(valueOf);
            }
            ArrayList arrayList2 = arrayList;
            List<? extends BigInteger> slice = CollectionsKt.slice((List) arrayList2, new IntRange(0, 1));
            List<BigInteger> bytes2blocks = bytes2blocks(digestPad(str));
            int progressionLastElement = progressionUtil.getProgressionLastElement(0, bytes2blocks.size() - 1, 4);
            List<? extends BigInteger> list = slice;
            if (progressionLastElement >= 0) {
                int i = 0;
                while (true) {
                    slice = CollectionsKt.toMutableList((Collection) tearCode(xorBlocks(CollectionsKt.slice((List) bytes2blocks, new IntRange(i, i + 1)), slice), arrayList2));
                    list = CollectionsKt.toMutableList((Collection) tearCode(xorBlocks(CollectionsKt.slice((List) bytes2blocks, new IntRange(i + 2, i + 3)), list), arrayList2));
                    slice.set(0, slice.get(1));
                    slice.set(1, list.get(0));
                    list.set(0, list.get(1));
                    list.set(1, slice.get(0));
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 4;
                }
            }
            return CollectionsKt.listOf((Object[]) new BigInteger[]{slice.get(0), slice.get(1), list.get(0), list.get(1)});
        }

        private final List<BigInteger> tearDecode(List<? extends BigInteger> list, List<? extends BigInteger> list2) {
            BigInteger bigInteger = list.get(0);
            BigInteger bigInteger2 = list.get(1);
            BigInteger valueOf = BigInteger.valueOf(-957401312);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
            for (int i = 0; i < 32; i++) {
                BigInteger shiftLeft = bigInteger.shiftLeft(4);
                Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
                BigInteger xor = shiftLeft.xor(rShift(bigInteger, 5));
                Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
                BigInteger add = xor.add(bigInteger);
                Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
                BigInteger rShift = rShift(valueOf, 11);
                long j = 3;
                BigInteger valueOf2 = BigInteger.valueOf(j);
                Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(this.toLong())");
                BigInteger add2 = valueOf.add(list2.get(rShift.and(valueOf2).intValue()));
                Intrinsics.checkNotNullExpressionValue(add2, "this.add(other)");
                BigInteger xor2 = add.xor(add2);
                Intrinsics.checkNotNullExpressionValue(xor2, "this.xor(other)");
                bigInteger2 = bigInteger2.subtract(xor2);
                Intrinsics.checkNotNullExpressionValue(bigInteger2, "this.subtract(other)");
                BigInteger valueOf3 = BigInteger.valueOf(1640531527);
                Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(this.toLong())");
                valueOf = valueOf.add(valueOf3);
                Intrinsics.checkNotNullExpressionValue(valueOf, "this.add(other)");
                BigInteger shiftLeft2 = bigInteger2.shiftLeft(4);
                Intrinsics.checkNotNullExpressionValue(shiftLeft2, "this.shiftLeft(n)");
                BigInteger xor3 = shiftLeft2.xor(rShift(bigInteger2, 5));
                Intrinsics.checkNotNullExpressionValue(xor3, "this.xor(other)");
                BigInteger add3 = xor3.add(bigInteger2);
                Intrinsics.checkNotNullExpressionValue(add3, "this.add(other)");
                BigInteger valueOf4 = BigInteger.valueOf(j);
                Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(this.toLong())");
                BigInteger add4 = valueOf.add(list2.get(valueOf.and(valueOf4).intValue()));
                Intrinsics.checkNotNullExpressionValue(add4, "this.add(other)");
                BigInteger xor4 = add3.xor(add4);
                Intrinsics.checkNotNullExpressionValue(xor4, "this.xor(other)");
                bigInteger = bigInteger.subtract(xor4);
                Intrinsics.checkNotNullExpressionValue(bigInteger, "this.subtract(other)");
            }
            return CollectionsKt.mutableListOf(bigInteger, bigInteger2);
        }

        private final List<BigInteger> digestPad(String str) {
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            BigInteger bigInteger = VideoVard.big15;
            BigInteger valueOf = BigInteger.valueOf(length);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
            BigInteger remainder = valueOf.remainder(VideoVard.big16);
            Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
            BigInteger subtract = bigInteger.subtract(remainder);
            Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
            arrayList.add(subtract);
            for (int i = 0; i < length; i++) {
                BigInteger valueOf2 = BigInteger.valueOf(str.charAt(i));
                Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(this.toLong())");
                arrayList.add(valueOf2);
            }
            int intValue = subtract.intValue();
            for (int i2 = 0; i2 < intValue; i2++) {
                arrayList.add(VideoVard.big0);
            }
            return arrayList;
        }

        private final List<BigInteger> bytes2blocks(List<? extends BigInteger> list) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = i2 % 4;
                BigInteger shiftLeft = list.get(i2).shiftLeft((3 - i3) * 8);
                Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
                if (i3 == 0) {
                    arrayList.add(shiftLeft);
                } else {
                    BigInteger or = ((BigInteger) arrayList.get(i)).or(shiftLeft);
                    Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
                    arrayList.set(i, or);
                }
                if (i3 == 3) {
                    i++;
                }
            }
            return arrayList;
        }

        private final List<BigInteger> blocks2bytes(List<? extends BigInteger> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = CollectionsKt.getIndices(list).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                ArrayList arrayList2 = arrayList;
                BigInteger and = VideoVard.big255.and(VideoVard.Companion.rShift(list.get(nextInt), 24));
                Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
                arrayList2.add(and);
                BigInteger and2 = VideoVard.big255.and(VideoVard.Companion.rShift(list.get(nextInt), 16));
                Intrinsics.checkNotNullExpressionValue(and2, "this.and(other)");
                arrayList2.add(and2);
                BigInteger and3 = VideoVard.big255.and(VideoVard.Companion.rShift(list.get(nextInt), 8));
                Intrinsics.checkNotNullExpressionValue(and3, "this.and(other)");
                arrayList2.add(and3);
                BigInteger and4 = VideoVard.big255.and(list.get(nextInt));
                Intrinsics.checkNotNullExpressionValue(and4, "this.and(other)");
                arrayList2.add(and4);
            }
            return arrayList;
        }

        private final List<BigInteger> unPad(List<? extends BigInteger> list) {
            int intValue = list.get(0).intValue() % 2;
            IntRange until = RangesKt.until(1, list.size() - (intValue + ((((intValue ^ 2) & ((-intValue) | intValue)) >> 31) & 2)));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(list.get(((IntIterator) it).nextInt()));
            }
            return arrayList;
        }

        private final List<BigInteger> xorBlocks(List<? extends BigInteger> list, List<? extends BigInteger> list2) {
            BigInteger xor = list.get(0).xor(list2.get(0));
            Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
            BigInteger xor2 = list.get(1).xor(list2.get(1));
            Intrinsics.checkNotNullExpressionValue(xor2, "this.xor(other)");
            return CollectionsKt.listOf((Object[]) new BigInteger[]{xor, xor2});
        }

        private final BigInteger rShift(BigInteger bigInteger, int i) {
            BigInteger valueOf = BigInteger.valueOf(4294967296L);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
            BigInteger mod = bigInteger.mod(valueOf);
            Intrinsics.checkNotNullExpressionValue(mod, "input.mod(4294967296.toBigInteger())");
            BigInteger shiftRight = mod.shiftRight(i);
            Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
            return shiftRight;
        }

        private final List<BigInteger> tearCode(List<? extends BigInteger> list, List<? extends BigInteger> list2) {
            BigInteger bigInteger = list.get(0);
            BigInteger bigInteger2 = list.get(1);
            BigInteger bigInteger3 = VideoVard.big0;
            for (int i = 0; i < 32; i++) {
                BigInteger shiftLeft = bigInteger2.shiftLeft(4);
                Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
                BigInteger xor = shiftLeft.xor(rShift(bigInteger2, 5));
                Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
                BigInteger add = xor.add(bigInteger2);
                Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
                BigInteger and = bigInteger3.and(VideoVard.big3);
                Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
                BigInteger add2 = bigInteger3.add(list2.get(and.intValue()));
                Intrinsics.checkNotNullExpressionValue(add2, "this.add(other)");
                BigInteger xor2 = add.xor(add2);
                Intrinsics.checkNotNullExpressionValue(xor2, "this.xor(other)");
                bigInteger = bigInteger.add(xor2);
                Intrinsics.checkNotNullExpressionValue(bigInteger, "this.add(other)");
                BigInteger valueOf = BigInteger.valueOf(1640531527);
                Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
                bigInteger3 = bigInteger3.subtract(valueOf);
                Intrinsics.checkNotNullExpressionValue(bigInteger3, "this.subtract(other)");
                BigInteger shiftLeft2 = bigInteger.shiftLeft(4);
                Intrinsics.checkNotNullExpressionValue(shiftLeft2, "this.shiftLeft(n)");
                BigInteger xor3 = shiftLeft2.xor(rShift(bigInteger, 5));
                Intrinsics.checkNotNullExpressionValue(xor3, "this.xor(other)");
                BigInteger add3 = xor3.add(bigInteger);
                Intrinsics.checkNotNullExpressionValue(add3, "this.add(other)");
                BigInteger and2 = rShift(bigInteger3, 11).and(VideoVard.big3);
                Intrinsics.checkNotNullExpressionValue(and2, "this.and(other)");
                BigInteger add4 = bigInteger3.add(list2.get(and2.intValue()));
                Intrinsics.checkNotNullExpressionValue(add4, "this.add(other)");
                BigInteger xor4 = add3.xor(add4);
                Intrinsics.checkNotNullExpressionValue(xor4, "this.xor(other)");
                bigInteger2 = bigInteger2.add(xor4);
                Intrinsics.checkNotNullExpressionValue(bigInteger2, "this.add(other)");
            }
            return CollectionsKt.mutableListOf(bigInteger, bigInteger2);
        }

        private final List<BigInteger> ascii2bytes(String str) {
            ArrayList arrayList = new ArrayList(r0.length());
            int i = 0;
            int i2 = 0;
            while (i < r0.length()) {
                int i3 = i2 + 1;
                Character valueOf = Character.valueOf(r0.charAt(i));
                BigInteger valueOf2 = BigInteger.valueOf(i2);
                Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(this.toLong())");
                arrayList.add(TuplesKt.m100to(valueOf, valueOf2));
                i++;
                i2 = i3;
            }
            Map map = MapsKt.toMap(arrayList);
            int i4 = -1;
            int length = str.length();
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            while (true) {
                int length2 = str.length();
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        break;
                    } else if (StringsKt.contains$default((CharSequence) r0, str.charAt(i6), false, 2, (Object) null)) {
                        i4++;
                        break;
                    } else {
                        i6++;
                    }
                }
                Character orNull = StringsKt.getOrNull(str, i4);
                if (orNull == null) {
                    return arrayList2;
                }
                Object obj = map.get(Character.valueOf(orNull.charValue()));
                Intrinsics.checkNotNull(obj);
                BigInteger multiply = ((BigInteger) obj).multiply(VideoVard.big4);
                Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
                arrayList2.add(multiply);
                do {
                    i4++;
                } while (!StringsKt.contains$default((CharSequence) r0, str.charAt(i4), false, 2, (Object) null));
                Object obj2 = map.get(Character.valueOf(str.charAt(i4)));
                Intrinsics.checkNotNull(obj2);
                BigInteger bigInteger = (BigInteger) obj2;
                BigInteger or = ((BigInteger) arrayList2.get(i5)).or(rShift(bigInteger, 4));
                Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
                arrayList2.set(i5, or);
                int i7 = i5 + 1;
                BigInteger and = VideoVard.big15.and(bigInteger);
                Intrinsics.checkNotNullExpressionValue(and, "big15.and(temp)");
                if (Intrinsics.areEqual(and, VideoVard.big0) && i4 == length - 1) {
                    return arrayList2;
                }
                BigInteger multiply2 = and.multiply(VideoVard.big4);
                Intrinsics.checkNotNullExpressionValue(multiply2, "this.multiply(other)");
                BigInteger multiply3 = multiply2.multiply(VideoVard.big4);
                Intrinsics.checkNotNullExpressionValue(multiply3, "this.multiply(other)");
                arrayList2.add(multiply3);
                do {
                    i4++;
                    if (i4 >= length) {
                        return arrayList2;
                    }
                } while (!StringsKt.contains$default((CharSequence) r0, str.charAt(i4), false, 2, (Object) null));
                Object obj3 = map.get(Character.valueOf(str.charAt(i4)));
                Intrinsics.checkNotNull(obj3);
                BigInteger bigInteger2 = (BigInteger) obj3;
                BigInteger or2 = ((BigInteger) arrayList2.get(i7)).or(rShift(bigInteger2, 2));
                Intrinsics.checkNotNullExpressionValue(or2, "this.or(other)");
                arrayList2.set(i7, or2);
                int i8 = i7 + 1;
                BigInteger and2 = VideoVard.big3.and(bigInteger2);
                Intrinsics.checkNotNullExpressionValue(and2, "this.and(other)");
                if (Intrinsics.areEqual(and2, VideoVard.big0) && i4 == length - 1) {
                    return arrayList2;
                }
                BigInteger shiftLeft = and2.shiftLeft(6);
                Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
                arrayList2.add(shiftLeft);
                int length3 = str.length();
                for (int i9 = 0; i9 < length3; i9++) {
                    str.charAt(i9);
                    i4++;
                    if (StringsKt.contains$default((CharSequence) r0, str.charAt(i4), false, 2, (Object) null)) {
                        break;
                    }
                }
                Object obj4 = map.get(Character.valueOf(str.charAt(i4)));
                Intrinsics.checkNotNull(obj4);
                BigInteger or3 = ((BigInteger) arrayList2.get(i8)).or((BigInteger) obj4);
                Intrinsics.checkNotNullExpressionValue(or3, "this.or(other)");
                arrayList2.set(i8, or3);
                i5 = i8 + 1;
            }
        }

        private final String replace(String str) {
            Map mapOf = MapsKt.mapOf(TuplesKt.m100to('0', '5'), TuplesKt.m100to('1', '6'), TuplesKt.m100to('2', '7'), TuplesKt.m100to('5', '0'), TuplesKt.m100to('6', '1'), TuplesKt.m100to('7', '2'));
            String str2 = str;
            String str3 = "";
            for (int i = 0; i < str2.length(); i++) {
                char charAt = str2.charAt(i);
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(mapOf.containsKey(Character.valueOf(charAt)) ? (Character) mapOf.get(Character.valueOf(charAt)) : Character.valueOf(charAt));
                str3 = sb.toString();
            }
            return str3;
        }

        private final String padLastChars(String str) {
            return Character.isDigit(StringsKt.reversed((CharSequence) str).toString().charAt(3)) ? str : StringsKt.dropLast(str, 4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: VideoVard.kt */
        @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/VideoVard$Companion$HashResponse;", "", "hash", "", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "(Ljava/lang/String;Ljava/lang/String;)V", "getHash", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public static final class HashResponse {
            private final String hash;
            private final String version;

            public HashResponse() {
                this(null, null, 3, null);
            }

            public static /* synthetic */ HashResponse copy$default(HashResponse hashResponse, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hashResponse.hash;
                }
                if ((i & 2) != 0) {
                    str2 = hashResponse.version;
                }
                return hashResponse.copy(str, str2);
            }

            public final String component1() {
                return this.hash;
            }

            public final String component2() {
                return this.version;
            }

            public final HashResponse copy(String str, String str2) {
                return new HashResponse(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HashResponse) {
                    HashResponse hashResponse = (HashResponse) obj;
                    return Intrinsics.areEqual(this.hash, hashResponse.hash) && Intrinsics.areEqual(this.version, hashResponse.version);
                }
                return false;
            }

            public int hashCode() {
                String str = this.hash;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.version;
                return hashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "HashResponse(hash=" + this.hash + ", version=" + this.version + ')';
            }

            public HashResponse(String str, String str2) {
                this.hash = str;
                this.version = str2;
            }

            public /* synthetic */ HashResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
            }

            public final String getHash() {
                return this.hash;
            }

            public final String getVersion() {
                return this.version;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: VideoVard.kt */
        @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/VideoVard$Companion$SetupResponse;", "", "seed", "", "src", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getSeed", "getSrc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
        /* loaded from: classes3.dex */
        public static final class SetupResponse {
            private final String link;
            private final String seed;
            private final String src;

            public static /* synthetic */ SetupResponse copy$default(SetupResponse setupResponse, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setupResponse.seed;
                }
                if ((i & 2) != 0) {
                    str2 = setupResponse.src;
                }
                if ((i & 4) != 0) {
                    str3 = setupResponse.link;
                }
                return setupResponse.copy(str, str2, str3);
            }

            public final String component1() {
                return this.seed;
            }

            public final String component2() {
                return this.src;
            }

            public final String component3() {
                return this.link;
            }

            public final SetupResponse copy(String seed, String str, String str2) {
                Intrinsics.checkNotNullParameter(seed, "seed");
                return new SetupResponse(seed, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SetupResponse) {
                    SetupResponse setupResponse = (SetupResponse) obj;
                    return Intrinsics.areEqual(this.seed, setupResponse.seed) && Intrinsics.areEqual(this.src, setupResponse.src) && Intrinsics.areEqual(this.link, setupResponse.link);
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.seed.hashCode() * 31;
                String str = this.src;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.link;
                return hashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "SetupResponse(seed=" + this.seed + ", src=" + this.src + ", link=" + this.link + ')';
            }

            public SetupResponse(String seed, String str, String str2) {
                Intrinsics.checkNotNullParameter(seed, "seed");
                this.seed = seed;
                this.src = str;
                this.link = str2;
            }

            public /* synthetic */ SetupResponse(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
            }

            public final String getSeed() {
                return this.seed;
            }

            public final String getSrc() {
                return this.src;
            }

            public final String getLink() {
                return this.link;
            }
        }
    }

    static {
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        big0 = valueOf;
        BigInteger valueOf2 = BigInteger.valueOf(3);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(this.toLong())");
        big3 = valueOf2;
        BigInteger valueOf3 = BigInteger.valueOf(4);
        Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(this.toLong())");
        big4 = valueOf3;
        BigInteger valueOf4 = BigInteger.valueOf(15);
        Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(this.toLong())");
        big15 = valueOf4;
        BigInteger valueOf5 = BigInteger.valueOf(16);
        Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(this.toLong())");
        big16 = valueOf5;
        BigInteger valueOf6 = BigInteger.valueOf(255);
        Intrinsics.checkNotNullExpressionValue(valueOf6, "valueOf(this.toLong())");
        big255 = valueOf6;
    }
}
