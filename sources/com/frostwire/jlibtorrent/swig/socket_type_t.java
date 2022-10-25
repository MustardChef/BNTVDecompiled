package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class socket_type_t {
    public static final socket_type_t i2p;
    public static final socket_type_t socks5;
    private static int swigNext;
    private static socket_type_t[] swigValues;
    public static final socket_type_t tcp;
    public static final socket_type_t tcp_ssl;
    public static final socket_type_t udp;
    public static final socket_type_t utp_ssl;
    private final String swigName;
    private final int swigValue;

    static {
        socket_type_t socket_type_tVar = new socket_type_t("tcp");
        tcp = socket_type_tVar;
        socket_type_t socket_type_tVar2 = new socket_type_t("tcp_ssl");
        tcp_ssl = socket_type_tVar2;
        socket_type_t socket_type_tVar3 = new socket_type_t("udp");
        udp = socket_type_tVar3;
        socket_type_t socket_type_tVar4 = new socket_type_t("i2p");
        i2p = socket_type_tVar4;
        socket_type_t socket_type_tVar5 = new socket_type_t("socks5");
        socks5 = socket_type_tVar5;
        socket_type_t socket_type_tVar6 = new socket_type_t("utp_ssl");
        utp_ssl = socket_type_tVar6;
        swigValues = new socket_type_t[]{socket_type_tVar, socket_type_tVar2, socket_type_tVar3, socket_type_tVar4, socket_type_tVar5, socket_type_tVar6};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static socket_type_t swigToEnum(int i) {
        socket_type_t[] socket_type_tVarArr = swigValues;
        if (i < socket_type_tVarArr.length && i >= 0 && socket_type_tVarArr[i].swigValue == i) {
            return socket_type_tVarArr[i];
        }
        int i2 = 0;
        while (true) {
            socket_type_t[] socket_type_tVarArr2 = swigValues;
            if (i2 < socket_type_tVarArr2.length) {
                if (socket_type_tVarArr2[i2].swigValue == i) {
                    return socket_type_tVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + socket_type_t.class + " with value " + i);
            }
        }
    }

    private socket_type_t(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private socket_type_t(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private socket_type_t(String str, socket_type_t socket_type_tVar) {
        this.swigName = str;
        int i = socket_type_tVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
