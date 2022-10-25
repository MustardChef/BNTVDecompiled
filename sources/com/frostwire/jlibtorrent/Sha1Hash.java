package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.sha1_hash;
import com.frostwire.jlibtorrent.swig.sha1_hash_vector;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class Sha1Hash implements Comparable<Sha1Hash>, Cloneable {

    /* renamed from: h */
    private final sha1_hash f2827h;

    public Sha1Hash(sha1_hash sha1_hashVar) {
        this.f2827h = sha1_hashVar;
    }

    public Sha1Hash(byte[] bArr) {
        if (bArr.length != 20) {
            throw new IllegalArgumentException("bytes array must be of length 20");
        }
        this.f2827h = new sha1_hash(Vectors.bytes2byte_vector(bArr));
    }

    public Sha1Hash(String str) {
        this(Hex.decode(str));
    }

    public Sha1Hash() {
        this(new sha1_hash());
    }

    public sha1_hash swig() {
        return this.f2827h;
    }

    public void clear() {
        this.f2827h.clear();
    }

    public boolean isAllZeros() {
        return this.f2827h.is_all_zeros();
    }

    public int countLeadingZeroes() {
        return this.f2827h.count_leading_zeroes();
    }

    public String toHex() {
        return this.f2827h.to_hex();
    }

    @Override // java.lang.Comparable
    public int compareTo(Sha1Hash sha1Hash) {
        return sha1_hash.compare(this.f2827h, sha1Hash.f2827h);
    }

    public String toString() {
        return toHex();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Sha1Hash) {
            return this.f2827h.op_eq(((Sha1Hash) obj).f2827h);
        }
        return false;
    }

    public int hashCode() {
        return this.f2827h.hash_code();
    }

    /* renamed from: clone */
    public Sha1Hash m8570clone() {
        return new Sha1Hash(new sha1_hash(this.f2827h));
    }

    public static Sha1Hash max() {
        return new Sha1Hash(sha1_hash.max());
    }

    public static Sha1Hash min() {
        return new Sha1Hash(sha1_hash.min());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<Sha1Hash> convert(sha1_hash_vector sha1_hash_vectorVar) {
        int size = (int) sha1_hash_vectorVar.size();
        ArrayList<Sha1Hash> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Sha1Hash(sha1_hash_vectorVar.get(i)));
        }
        return arrayList;
    }
}
