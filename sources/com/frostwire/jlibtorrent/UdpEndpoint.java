package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.address;
import com.frostwire.jlibtorrent.swig.error_code;
import com.frostwire.jlibtorrent.swig.udp_endpoint;

/* loaded from: classes2.dex */
public final class UdpEndpoint implements Cloneable {
    private final udp_endpoint endp;

    public UdpEndpoint(udp_endpoint udp_endpointVar) {
        this.endp = udp_endpointVar;
    }

    public UdpEndpoint() {
        this(new udp_endpoint());
    }

    public UdpEndpoint(Address address, int i) {
        this(new udp_endpoint(address.swig(), i));
    }

    public UdpEndpoint(String str, int i) {
        error_code error_codeVar = new error_code();
        address from_string = address.from_string(str, error_codeVar);
        if (error_codeVar.value() != 0) {
            throw new IllegalArgumentException(error_codeVar.message());
        }
        this.endp = new udp_endpoint(from_string, i);
    }

    public udp_endpoint swig() {
        return this.endp;
    }

    public Address address() {
        return new Address(this.endp.address());
    }

    public int port() {
        return this.endp.port();
    }

    public String toString() {
        return "udp:" + Address.toString(this.endp.address()) + ":" + this.endp.port();
    }

    /* renamed from: clone */
    public UdpEndpoint m8573clone() {
        return new UdpEndpoint(new udp_endpoint(this.endp));
    }
}
