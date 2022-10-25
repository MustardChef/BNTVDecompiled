package okio;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Options.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, m107d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", "", "trie", "", "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", "", "getSize", "()I", "getTrie$okio", "()[I", "get", FirebaseAnalytics.Param.INDEX, "Companion", "okio"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    /* renamed from: of */
    public static final Options m71of(ByteString... byteStringArr) {
        return Companion.m70of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    /* compiled from: Options.kt */
    @Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m107d2 = {"Lokio/Options$Companion;", "", "()V", "intCount", "", "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", "", "nodeOffset", "node", "byteStringOffset", "", "byteStrings", "", "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", "", "([Lokio/ByteString;)Lokio/Options;", "okio"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00ef, code lost:
            continue;
         */
        @kotlin.jvm.JvmStatic
        /* renamed from: of */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okio.Options m70of(okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 328
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.Options.Companion.m70of(okio.ByteString[]):okio.Options");
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j, Buffer buffer, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            companion.buildTrieRecursive((i4 & 1) != 0 ? 0L : j, buffer, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final void buildTrieRecursive(long j, Buffer buffer, int i, List<? extends ByteString> list, int i2, int i3, List<Integer> list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            Buffer buffer2;
            int i9 = i;
            if (!(i2 < i3)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i2 < i3) {
                int i10 = i2;
                while (true) {
                    int i11 = i10 + 1;
                    if (!(list.get(i10).size() >= i9)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i11 >= i3) {
                        break;
                    }
                    i10 = i11;
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list.get(i3 - 1);
            if (i9 == byteString.size()) {
                int i12 = i2 + 1;
                i4 = i12;
                i5 = list2.get(i2).intValue();
                byteString = list.get(i12);
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (byteString.getByte(i9) != byteString2.getByte(i9)) {
                int i13 = i4 + 1;
                int i14 = 1;
                if (i13 < i3) {
                    while (true) {
                        int i15 = i13 + 1;
                        if (list.get(i13 - 1).getByte(i9) != list.get(i13).getByte(i9)) {
                            i14++;
                        }
                        if (i15 >= i3) {
                            break;
                        }
                        i13 = i15;
                    }
                }
                long intCount = j + getIntCount(buffer) + 2 + (i14 * 2);
                buffer.writeInt(i14);
                buffer.writeInt(i5);
                if (i4 < i3) {
                    int i16 = i4;
                    while (true) {
                        int i17 = i16 + 1;
                        byte b = list.get(i16).getByte(i9);
                        if (i16 == i4 || b != list.get(i16 - 1).getByte(i9)) {
                            buffer.writeInt(b & 255);
                        }
                        if (i17 >= i3) {
                            break;
                        }
                        i16 = i17;
                    }
                }
                Buffer buffer3 = new Buffer();
                while (i4 < i3) {
                    byte b2 = list.get(i4).getByte(i9);
                    int i18 = i4 + 1;
                    if (i18 < i3) {
                        int i19 = i18;
                        while (true) {
                            int i20 = i19 + 1;
                            if (b2 != list.get(i19).getByte(i9)) {
                                i7 = i19;
                                break;
                            } else if (i20 >= i3) {
                                break;
                            } else {
                                i19 = i20;
                            }
                        }
                    }
                    i7 = i3;
                    if (i18 == i7 && i9 + 1 == list.get(i4).size()) {
                        buffer.writeInt(list2.get(i4).intValue());
                        i8 = i7;
                        buffer2 = buffer3;
                    } else {
                        buffer.writeInt(((int) (intCount + getIntCount(buffer3))) * (-1));
                        i8 = i7;
                        buffer2 = buffer3;
                        buildTrieRecursive(intCount, buffer3, i9 + 1, list, i4, i7, list2);
                    }
                    i4 = i8;
                    buffer3 = buffer2;
                }
                buffer.writeAll(buffer3);
                return;
            }
            int min = Math.min(byteString.size(), byteString2.size());
            if (i9 < min) {
                int i21 = i9;
                int i22 = 0;
                while (true) {
                    int i23 = i21 + 1;
                    if (byteString.getByte(i21) != byteString2.getByte(i21)) {
                        break;
                    }
                    i22++;
                    if (i23 >= min) {
                        break;
                    }
                    i21 = i23;
                }
                i6 = i22;
            } else {
                i6 = 0;
            }
            long intCount2 = j + getIntCount(buffer) + 2 + i6 + 1;
            buffer.writeInt(-i6);
            buffer.writeInt(i5);
            int i24 = i9 + i6;
            if (i9 < i24) {
                while (true) {
                    int i25 = i9 + 1;
                    buffer.writeInt(byteString.getByte(i9) & 255);
                    if (i25 >= i24) {
                        break;
                    }
                    i9 = i25;
                }
            }
            if (i4 + 1 == i3) {
                if (!(i24 == list.get(i4).size())) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                buffer.writeInt(list2.get(i4).intValue());
                return;
            }
            Buffer buffer4 = new Buffer();
            buffer.writeInt(((int) (getIntCount(buffer4) + intCount2)) * (-1));
            buildTrieRecursive(intCount2, buffer4, i24, list, i4, i3, list2);
            buffer.writeAll(buffer4);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / 4;
        }
    }
}
