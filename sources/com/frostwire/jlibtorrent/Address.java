package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.address;
import com.frostwire.jlibtorrent.swig.error_code;

/* loaded from: classes2.dex */
public final class Address implements Comparable<Address>, Cloneable {
    private final address addr;

    public Address(address addressVar) {
        this.addr = addressVar;
    }

    public Address(String str) {
        error_code error_codeVar = new error_code();
        this.addr = address.from_string(str, error_codeVar);
        if (error_codeVar.value() != 0) {
            throw new IllegalArgumentException(error_codeVar.message());
        }
    }

    public Address() {
        this(new address());
    }

    public address swig() {
        return this.addr;
    }

    public boolean isV4() {
        return this.addr.is_v4();
    }

    public boolean isV6() {
        return this.addr.is_v6();
    }

    public boolean isLoopback() {
        return this.addr.is_loopback();
    }

    public boolean isUnspecified() {
        return this.addr.is_unspecified();
    }

    public boolean isMulticast() {
        return this.addr.is_multicast();
    }

    @Override // java.lang.Comparable
    public int compareTo(Address address) {
        return address.compare(this.addr, address.addr);
    }

    public String toString() {
        return toString(this.addr);
    }

    /* renamed from: clone */
    public Address m8569clone() {
        return new Address(new address(this.addr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(address addressVar) {
        error_code error_codeVar = new error_code();
        return error_codeVar.value() != 0 ? "<invalid address>" : addressVar.to_string(error_codeVar);
    }
}
