package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class TokenContents {
    private final byte[] mContents;
    private List<byte[]> mFingerprints;
    private String mPackageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TokenContents deserialize(byte[] serialized) {
        return new TokenContents(serialized);
    }

    private TokenContents(byte[] contents) {
        this.mContents = contents;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TokenContents create(String packageName, List<byte[]> fingerprints) throws IOException {
        return new TokenContents(createToken(packageName, fingerprints), packageName, fingerprints);
    }

    private TokenContents(byte[] contents, String packageName, List<byte[]> fingerprints) {
        this.mContents = contents;
        this.mPackageName = packageName;
        this.mFingerprints = new ArrayList(fingerprints.size());
        for (byte[] bArr : fingerprints) {
            this.mFingerprints.add(Arrays.copyOf(bArr, bArr.length));
        }
    }

    public String getPackageName() throws IOException {
        parseIfNeeded();
        String str = this.mPackageName;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException();
    }

    public int getFingerprintCount() throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list == null) {
            throw new IllegalStateException();
        }
        return list.size();
    }

    public byte[] getFingerprint(int i) throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list == null) {
            throw new IllegalStateException();
        }
        return Arrays.copyOf(list.get(i), this.mFingerprints.get(i).length);
    }

    public byte[] serialize() {
        byte[] bArr = this.mContents;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Arrays.equals(this.mContents, ((TokenContents) o).mContents);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mContents);
    }

    private static byte[] createToken(String packageName, List<byte[]> fingerprints) throws IOException {
        Collections.sort(fingerprints, $$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70.INSTANCE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(packageName);
        dataOutputStream.writeInt(fingerprints.size());
        for (byte[] bArr : fingerprints) {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByteArrays(byte[] a, byte[] b) {
        int length;
        int length2;
        if (a == b) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }
        int i = 0;
        while (true) {
            if (i < Math.min(a.length, b.length)) {
                if (a[i] != b[i]) {
                    length = a[i];
                    length2 = b[i];
                    break;
                }
                i++;
            } else if (a.length == b.length) {
                return 0;
            } else {
                length = a.length;
                length2 = b.length;
            }
        }
        return length - length2;
    }

    private void parseIfNeeded() throws IOException {
        if (this.mPackageName != null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.mContents));
        this.mPackageName = dataInputStream.readUTF();
        int readInt = dataInputStream.readInt();
        this.mFingerprints = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            int readInt2 = dataInputStream.readInt();
            byte[] bArr = new byte[readInt2];
            if (dataInputStream.read(bArr) != readInt2) {
                throw new IllegalStateException("Could not read fingerprint");
            }
            this.mFingerprints.add(bArr);
        }
    }
}
