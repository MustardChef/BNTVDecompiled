package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class ip_route {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ip_route(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(ip_route ip_routeVar) {
        if (ip_routeVar == null) {
            return 0L;
        }
        return ip_routeVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_ip_route(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setDestination(address addressVar) {
        libtorrent_jni.ip_route_destination_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getDestination() {
        long ip_route_destination_get = libtorrent_jni.ip_route_destination_get(this.swigCPtr, this);
        if (ip_route_destination_get == 0) {
            return null;
        }
        return new address(ip_route_destination_get, false);
    }

    public void setNetmask(address addressVar) {
        libtorrent_jni.ip_route_netmask_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getNetmask() {
        long ip_route_netmask_get = libtorrent_jni.ip_route_netmask_get(this.swigCPtr, this);
        if (ip_route_netmask_get == 0) {
            return null;
        }
        return new address(ip_route_netmask_get, false);
    }

    public void setGateway(address addressVar) {
        libtorrent_jni.ip_route_gateway_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getGateway() {
        long ip_route_gateway_get = libtorrent_jni.ip_route_gateway_get(this.swigCPtr, this);
        if (ip_route_gateway_get == 0) {
            return null;
        }
        return new address(ip_route_gateway_get, false);
    }

    public void setSource_hint(address addressVar) {
        libtorrent_jni.ip_route_source_hint_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getSource_hint() {
        long ip_route_source_hint_get = libtorrent_jni.ip_route_source_hint_get(this.swigCPtr, this);
        if (ip_route_source_hint_get == 0) {
            return null;
        }
        return new address(ip_route_source_hint_get, false);
    }

    public void setName(byte_vector byte_vectorVar) {
        libtorrent_jni.ip_route_name_set(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector getName() {
        long ip_route_name_get = libtorrent_jni.ip_route_name_get(this.swigCPtr, this);
        if (ip_route_name_get == 0) {
            return null;
        }
        return new byte_vector(ip_route_name_get, false);
    }

    public void setMtu(int i) {
        libtorrent_jni.ip_route_mtu_set(this.swigCPtr, this, i);
    }

    public int getMtu() {
        return libtorrent_jni.ip_route_mtu_get(this.swigCPtr, this);
    }

    public ip_route() {
        this(libtorrent_jni.new_ip_route(), true);
    }
}
