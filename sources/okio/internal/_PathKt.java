package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;

/* compiled from: -Path.kt */
@Metadata(m108d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\u0080\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\u0080\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\u0080\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\u0080\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\u0080\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\u0080\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\u0080\b\u001a\u0012\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\u0080\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\u0080\b¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H\u0000\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, m107d2 = {"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _PathKt {
    private static final ByteString SLASH = ByteString.Companion.encodeUtf8("/");
    private static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    private static final ByteString DOT = ByteString.Companion.encodeUtf8(".");
    private static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8("..");

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    private static /* synthetic */ void getSLASH$annotations() {
    }

    public static final Path commonRoot(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            return null;
        }
        return new Path(path.getBytes$okio().substring(0, rootLength));
    }

    public static final List<ByteString> commonSegmentsBytes(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        if (rootLength < size) {
            int i = rootLength;
            while (true) {
                int i2 = rootLength + 1;
                if (path.getBytes$okio().getByte(rootLength) == ((byte) 47) || path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
                    arrayList.add(path.getBytes$okio().substring(i, rootLength));
                    i = i2;
                }
                if (i2 >= size) {
                    break;
                }
                rootLength = i2;
            }
            rootLength = i;
        }
        if (rootLength < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(rootLength, path.getBytes$okio().size()));
        }
        return arrayList;
    }

    public static final int rootLength(Path path) {
        if (path.getBytes$okio().size() == 0) {
            return -1;
        }
        boolean z = false;
        if (path.getBytes$okio().getByte(0) == ((byte) 47)) {
            return 1;
        }
        byte b = (byte) 92;
        if (path.getBytes$okio().getByte(0) == b) {
            if (path.getBytes$okio().size() <= 2 || path.getBytes$okio().getByte(1) != b) {
                return 1;
            }
            int indexOf = path.getBytes$okio().indexOf(BACKSLASH, 2);
            return indexOf == -1 ? path.getBytes$okio().size() : indexOf;
        } else if (path.getBytes$okio().size() > 2 && path.getBytes$okio().getByte(1) == ((byte) 58) && path.getBytes$okio().getByte(2) == b) {
            char c = (char) path.getBytes$okio().getByte(0);
            if ('a' <= c && c <= 'z') {
                return 3;
            }
            if ('A' <= c && c <= 'Z') {
                z = true;
            }
            return !z ? -1 : 3;
        } else {
            return -1;
        }
    }

    public static final boolean commonIsAbsolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return rootLength(path) != -1;
    }

    public static final boolean commonIsRelative(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return rootLength(path) == -1;
    }

    public static final Character commonVolumeLetter(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        boolean z = false;
        if (ByteString.indexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null) == -1 && path.getBytes$okio().size() >= 2 && path.getBytes$okio().getByte(1) == ((byte) 58)) {
            char c = (char) path.getBytes$okio().getByte(0);
            if (!('a' <= c && c <= 'z')) {
                if ('A' <= c && c <= 'Z') {
                    z = true;
                }
                if (!z) {
                    return null;
                }
            }
            return Character.valueOf(c);
        }
        return null;
    }

    public static final int getIndexOfLastSlash(Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes$okio(), SLASH, 0, 2, (Object) null);
        return lastIndexOf$default != -1 ? lastIndexOf$default : ByteString.lastIndexOf$default(path.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    public static final ByteString commonNameBytes(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash != -1) {
            return ByteString.substring$default(path.getBytes$okio(), indexOfLastSlash + 1, 0, 2, null);
        }
        return (path.volumeLetter() == null || path.getBytes$okio().size() != 2) ? path.getBytes$okio() : ByteString.EMPTY;
    }

    public static final String commonName(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.nameBytes().utf8();
    }

    public static final Path commonParent(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        if (Intrinsics.areEqual(path.getBytes$okio(), DOT) || Intrinsics.areEqual(path.getBytes$okio(), SLASH) || Intrinsics.areEqual(path.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot(path)) {
            return null;
        }
        int indexOfLastSlash = getIndexOfLastSlash(path);
        if (indexOfLastSlash != 2 || path.volumeLetter() == null) {
            if (indexOfLastSlash == 1 && path.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (indexOfLastSlash == -1 && path.volumeLetter() != null) {
                if (path.getBytes$okio().size() == 2) {
                    return null;
                }
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 2, 1, null));
            } else if (indexOfLastSlash == -1) {
                return new Path(DOT);
            } else {
                if (indexOfLastSlash == 0) {
                    return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 1, 1, null));
                }
                return new Path(ByteString.substring$default(path.getBytes$okio(), 0, indexOfLastSlash, 1, null));
            }
        } else if (path.getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default(path.getBytes$okio(), 0, 3, 1, null));
        }
    }

    public static final boolean lastSegmentIsDotDot(Path path) {
        return path.getBytes$okio().endsWith(DOT_DOT) && (path.getBytes$okio().size() == 2 || path.getBytes$okio().rangeEquals(path.getBytes$okio().size() + (-3), SLASH, 0, 1) || path.getBytes$okio().rangeEquals(path.getBytes$okio().size() + (-3), BACKSLASH, 0, 1));
    }

    public static final boolean commonIsRoot(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return rootLength(path) == path.getBytes$okio().size();
    }

    public static final Path commonResolve(Path path, String child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(new Buffer().writeUtf8(child), false), z);
    }

    public static final Path commonResolve(Path path, ByteString child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(new Buffer().write(child), false), z);
    }

    public static final Path commonResolve(Path path, Buffer child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve(path, toPath(child, false), z);
    }

    public static final Path commonResolve(Path path, Path child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = toSlash(Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes$okio());
        return toPath(buffer, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x00ab A[LOOP:2: B:78:0x00ab->B:81:0x00bc, LOOP_START, PHI: r5 
      PHI: (r5v2 int) = (r5v1 int), (r5v3 int) binds: [B:77:0x00a9, B:81:0x00bc] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okio.Path commonRelativeTo(okio.Path r8, okio.Path r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            okio.Path r0 = r8.getRoot()
            okio.Path r1 = r9.getRoot()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            java.lang.String r1 = " and "
            if (r0 == 0) goto Le6
            java.util.List r0 = r8.getSegmentsBytes()
            java.util.List r2 = r9.getSegmentsBytes()
            int r3 = r0.size()
            int r4 = r2.size()
            int r3 = java.lang.Math.min(r3, r4)
            r4 = 0
            r5 = 0
        L30:
            if (r5 >= r3) goto L43
            java.lang.Object r6 = r0.get(r5)
            java.lang.Object r7 = r2.get(r5)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L43
            int r5 = r5 + 1
            goto L30
        L43:
            r6 = 1
            if (r5 != r3) goto L62
            okio.ByteString r3 = r8.getBytes$okio()
            int r3 = r3.size()
            okio.ByteString r7 = r9.getBytes$okio()
            int r7 = r7.size()
            if (r3 != r7) goto L62
            okio.Path$Companion r8 = okio.Path.Companion
            r9 = 0
            java.lang.String r0 = "."
            okio.Path r8 = okio.Path.Companion.get$default(r8, r0, r4, r6, r9)
            return r8
        L62:
            int r3 = r2.size()
            java.util.List r3 = r2.subList(r5, r3)
            okio.ByteString r7 = access$getDOT_DOT$p()
            int r3 = r3.indexOf(r7)
            r7 = -1
            if (r3 != r7) goto L77
            r3 = 1
            goto L78
        L77:
            r3 = 0
        L78:
            if (r3 == 0) goto Lc3
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.ByteString r9 = access$getSlash(r9)
            if (r9 != 0) goto L91
            okio.ByteString r9 = access$getSlash(r8)
            if (r9 != 0) goto L91
            java.lang.String r8 = okio.Path.DIRECTORY_SEPARATOR
            okio.ByteString r9 = access$toSlash(r8)
        L91:
            int r8 = r2.size()
            if (r5 >= r8) goto La5
            r2 = r5
        L98:
            int r2 = r2 + r6
            okio.ByteString r3 = access$getDOT_DOT$p()
            r1.write(r3)
            r1.write(r9)
            if (r2 < r8) goto L98
        La5:
            int r8 = r0.size()
            if (r5 >= r8) goto Lbe
        Lab:
            int r2 = r5 + 1
            java.lang.Object r3 = r0.get(r5)
            okio.ByteString r3 = (okio.ByteString) r3
            r1.write(r3)
            r1.write(r9)
            if (r2 < r8) goto Lbc
            goto Lbe
        Lbc:
            r5 = r2
            goto Lab
        Lbe:
            okio.Path r8 = toPath(r1, r4)
            return r8
        Lc3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Impossible relative path to resolve: "
            r0.append(r2)
            r0.append(r8)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r8 = r0.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        Le6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Paths of different roots cannot be relative to each other: "
            r0.append(r2)
            r0.append(r8)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r8 = r0.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonRelativeTo(okio.Path, okio.Path):okio.Path");
    }

    public static final Path commonNormalized(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return Path.Companion.get(path.toString(), true);
    }

    public static final ByteString getSlash(Path path) {
        ByteString bytes$okio = path.getBytes$okio();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes$okio, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString bytes$okio2 = path.getBytes$okio();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes$okio2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    public static final int commonCompareTo(Path path, Path other) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return path.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(Path path, Object obj) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return (obj instanceof Path) && Intrinsics.areEqual(((Path) obj).getBytes$okio(), path.getBytes$okio());
    }

    public static final int commonHashCode(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes$okio().hashCode();
    }

    public static final String commonToString(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        return path.getBytes$okio().utf8();
    }

    public static final Path commonToPath(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z);
    }

    public static final Path toPath(Buffer buffer, boolean z) {
        ByteString byteString;
        ByteString readByteString;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        int i = 0;
        ByteString byteString2 = null;
        int i2 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString2 == null) {
                byteString2 = toSlash(readByte);
            }
            i2++;
        }
        boolean z2 = i2 >= 2 && Intrinsics.areEqual(byteString2, byteString);
        if (z2) {
            Intrinsics.checkNotNull(byteString2);
            buffer2.write(byteString2);
            buffer2.write(byteString2);
        } else if (i2 > 0) {
            Intrinsics.checkNotNull(byteString2);
            buffer2.write(byteString2);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString2 == null) {
                if (indexOfElement == -1) {
                    byteString2 = toSlash(Path.DIRECTORY_SEPARATOR);
                } else {
                    byteString2 = toSlash(buffer.getByte(indexOfElement));
                }
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString2)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
        }
        boolean z3 = buffer2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString3 = DOT_DOT;
            if (Intrinsics.areEqual(readByteString, byteString3)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (!z || (!z3 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.last((List<? extends Object>) arrayList), byteString3)))) {
                        arrayList.add(readByteString);
                    } else if (!z2 || arrayList.size() != 1) {
                        CollectionsKt.removeLastOrNull(arrayList);
                    }
                }
            } else if (!Intrinsics.areEqual(readByteString, DOT) && !Intrinsics.areEqual(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            while (true) {
                int i3 = i + 1;
                if (i > 0) {
                    buffer2.write(byteString2);
                }
                buffer2.write((ByteString) arrayList.get(i));
                if (i3 >= size) {
                    break;
                }
                i = i3;
            }
        }
        if (buffer2.size() == 0) {
            buffer2.write(DOT);
        }
        return new Path(buffer2.readByteString());
    }

    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", str));
    }

    private static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", Byte.valueOf(b)));
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (Intrinsics.areEqual(byteString, BACKSLASH) && buffer.size() >= 2 && buffer.getByte(1L) == ((byte) 58)) {
            char c = (char) buffer.getByte(0L);
            if (!('a' <= c && c <= 'z')) {
                if (!('A' <= c && c <= 'Z')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static final List<String> commonSegments(Path path) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int rootLength = rootLength(path);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < path.getBytes$okio().size() && path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
            rootLength++;
        }
        int size = path.getBytes$okio().size();
        if (rootLength < size) {
            int i = rootLength;
            while (true) {
                int i2 = rootLength + 1;
                if (path.getBytes$okio().getByte(rootLength) == ((byte) 47) || path.getBytes$okio().getByte(rootLength) == ((byte) 92)) {
                    arrayList.add(path.getBytes$okio().substring(i, rootLength));
                    i = i2;
                }
                if (i2 >= size) {
                    break;
                }
                rootLength = i2;
            }
            rootLength = i;
        }
        if (rootLength < path.getBytes$okio().size()) {
            arrayList.add(path.getBytes$okio().substring(rootLength, path.getBytes$okio().size()));
        }
        ArrayList<ByteString> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ByteString byteString : arrayList2) {
            arrayList3.add(byteString.utf8());
        }
        return arrayList3;
    }
}
