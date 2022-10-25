package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class ip_interface {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ip_interface(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(ip_interface ip_interfaceVar) {
        if (ip_interfaceVar == null) {
            return 0L;
        }
        return ip_interfaceVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_ip_interface(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setInterface_address(address addressVar) {
        libtorrent_jni.ip_interface_interface_address_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getInterface_address() {
        long ip_interface_interface_address_get = libtorrent_jni.ip_interface_interface_address_get(this.swigCPtr, this);
        if (ip_interface_interface_address_get == 0) {
            return null;
        }
        return new address(ip_interface_interface_address_get, false);
    }

    public void setNetmask(address addressVar) {
        libtorrent_jni.ip_interface_netmask_set(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public address getNetmask() {
        long ip_interface_netmask_get = libtorrent_jni.ip_interface_netmask_get(this.swigCPtr, this);
        if (ip_interface_netmask_get == 0) {
            return null;
        }
        return new address(ip_interface_netmask_get, false);
    }

    public void setName(byte_vector byte_vectorVar) {
        libtorrent_jni.ip_interface_name_set(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector getName() {
        long ip_interface_name_get = libtorrent_jni.ip_interface_name_get(this.swigCPtr, this);
        if (ip_interface_name_get == 0) {
            return null;
        }
        return new byte_vector(ip_interface_name_get, false);
    }

    public void setFriendly_name(byte_vector byte_vectorVar) {
        libtorrent_jni.ip_interface_friendly_name_set(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector getFriendly_name() {
        long ip_interface_friendly_name_get = libtorrent_jni.ip_interface_friendly_name_get(this.swigCPtr, this);
        if (ip_interface_friendly_name_get == 0) {
            return null;
        }
        return new byte_vector(ip_interface_friendly_name_get, false);
    }

    public void setDescription(byte_vector byte_vectorVar) {
        libtorrent_jni.ip_interface_description_set(this.swigCPtr, this, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public byte_vector getDescription() {
        long ip_interface_description_get = libtorrent_jni.ip_interface_description_get(this.swigCPtr, this);
        if (ip_interface_description_get == 0) {
            return null;
        }
        return new byte_vector(ip_interface_description_get, false);
    }

    public void setPreferred(boolean z) {
        libtorrent_jni.ip_interface_preferred_set(this.swigCPtr, this, z);
    }

    public boolean getPreferred() {
        return libtorrent_jni.ip_interface_preferred_get(this.swigCPtr, this);
    }

    public ip_interface() {
        this(libtorrent_jni.new_ip_interface(), true);
    }
}
