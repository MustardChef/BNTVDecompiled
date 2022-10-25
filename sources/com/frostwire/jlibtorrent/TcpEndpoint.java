package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.address;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.tcp_endpoint;

/* loaded from: classes2.dex */
public final class TcpEndpoint implements Cloneable {
    private final tcp_endpoint endp;

    public TcpEndpoint(tcp_endpoint tcp_endpointVar) {
        this.endp = tcp_endpointVar;
    }

    public TcpEndpoint() {
        this(new tcp_endpoint());
    }

    public TcpEndpoint(Address address, int i) {
        this(new tcp_endpoint(address.swig(), i));
    }

    public TcpEndpoint(String str, int i) {
        error_code error_codeVar = new error_code();
        address from_string = address.from_string(str, error_codeVar);
        if (error_codeVar.value() != 0) {
            throw new IllegalArgumentException(error_codeVar.message());
        }
        this.endp = new tcp_endpoint(from_string, i);
    }

    public tcp_endpoint swig() {
        return this.endp;
    }

    public Address address() {
        return new Address(this.endp.address());
    }

    public int port() {
        return this.endp.port();
    }

    public String toString() {
        address address = this.endp.address();
        String address2 = Address.toString(address);
        StringBuilder sb = new StringBuilder();
        if (!address.is_v4()) {
            address2 = "[" + address2 + "]";
        }
        sb.append(address2);
        sb.append(":");
        sb.append(this.endp.port());
        return sb.toString();
    }

    /* renamed from: clone */
    public TcpEndpoint m8571clone() {
        return new TcpEndpoint(new tcp_endpoint(this.endp));
    }
}
