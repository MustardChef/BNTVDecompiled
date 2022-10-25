package okhttp3.dnsoverhttps;

import java.io.EOFException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio.Utf8;

/* compiled from: DnsRecordCodec.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m107d2 = {"Lokhttp3/dnsoverhttps/DnsRecordCodec;", "", "()V", "ASCII", "Ljava/nio/charset/Charset;", "NXDOMAIN", "", "SERVFAIL", "TYPE_A", "TYPE_AAAA", "TYPE_PTR", "decodeAnswers", "", "Ljava/net/InetAddress;", "hostname", "", "byteString", "Lokio/ByteString;", "encodeQuery", "host", "type", "skipName", "", "source", "Lokio/Buffer;", "okhttp-dnsoverhttps"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class DnsRecordCodec {
    private static final int NXDOMAIN = 3;
    private static final int SERVFAIL = 2;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;
    private static final int TYPE_PTR = 12;
    public static final DnsRecordCodec INSTANCE = new DnsRecordCodec();
    private static final Charset ASCII = Charsets.US_ASCII;

    private DnsRecordCodec() {
    }

    public final ByteString encodeQuery(String host, int i) {
        List<String> emptyList;
        boolean z;
        Intrinsics.checkNotNullParameter(host, "host");
        Buffer buffer = new Buffer();
        buffer.writeShort(0);
        buffer.writeShort(256);
        buffer.writeShort(1);
        buffer.writeShort(0);
        buffer.writeShort(0);
        buffer.writeShort(0);
        Buffer buffer2 = new Buffer();
        List split$default = StringsKt.split$default((CharSequence) host, new char[]{'.'}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            ListIterator listIterator = split$default.listIterator(split$default.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    emptyList = CollectionsKt.take(split$default, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt.emptyList();
        for (String str : emptyList) {
            long size$default = Utf8.size$default(str, 0, 0, 3, null);
            if (!(size$default == ((long) str.length()))) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("non-ascii hostname: ", host).toString());
            }
            buffer2.writeByte((int) size$default);
            buffer2.writeUtf8(str);
        }
        buffer2.writeByte(0);
        buffer2.copyTo(buffer, 0L, buffer2.size());
        buffer.writeShort(i);
        buffer.writeShort(1);
        return buffer.readByteString();
    }

    public final List<InetAddress> decodeAnswers(String hostname, ByteString byteString) throws Exception {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        ArrayList arrayList = new ArrayList();
        Buffer buffer = new Buffer();
        buffer.write(byteString);
        buffer.readShort();
        int readShort = buffer.readShort() & UShort.MAX_VALUE;
        int i = 0;
        if ((readShort >> 15) != 0) {
            int i2 = readShort & 15;
            if (i2 != 2) {
                if (i2 == 3) {
                    throw new UnknownHostException(Intrinsics.stringPlus(hostname, ": NXDOMAIN"));
                }
                int readShort2 = buffer.readShort() & UShort.MAX_VALUE;
                int readShort3 = buffer.readShort() & UShort.MAX_VALUE;
                buffer.readShort();
                buffer.readShort();
                int i3 = 0;
                while (i3 < readShort2) {
                    i3++;
                    skipName(buffer);
                    buffer.readShort();
                    buffer.readShort();
                }
                while (i < readShort3) {
                    i++;
                    skipName(buffer);
                    int readShort4 = buffer.readShort() & UShort.MAX_VALUE;
                    buffer.readShort();
                    buffer.readInt();
                    int readShort5 = buffer.readShort() & UShort.MAX_VALUE;
                    if (readShort4 == 1 || readShort4 == 28) {
                        byte[] bArr = new byte[readShort5];
                        buffer.read(bArr);
                        InetAddress byAddress = InetAddress.getByAddress(bArr);
                        Intrinsics.checkNotNullExpressionValue(byAddress, "getByAddress(bytes)");
                        arrayList.add(byAddress);
                    } else {
                        buffer.skip(readShort5);
                    }
                }
                return arrayList;
            }
            throw new UnknownHostException(Intrinsics.stringPlus(hostname, ": SERVFAIL"));
        }
        throw new IllegalArgumentException("not a response".toString());
    }

    private final void skipName(Buffer buffer) throws EOFException {
        byte readByte = buffer.readByte();
        if (readByte < 0) {
            buffer.skip(1L);
            return;
        }
        while (readByte > 0) {
            buffer.skip(readByte);
            readByte = buffer.readByte();
        }
    }
}
