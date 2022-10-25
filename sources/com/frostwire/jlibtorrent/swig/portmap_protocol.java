package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class portmap_protocol {
    public static final portmap_protocol none;
    private static int swigNext;
    private static portmap_protocol[] swigValues;
    public static final portmap_protocol tcp;
    public static final portmap_protocol udp;
    private final String swigName;
    private final int swigValue;

    static {
        portmap_protocol portmap_protocolVar = new portmap_protocol("none");
        none = portmap_protocolVar;
        portmap_protocol portmap_protocolVar2 = new portmap_protocol("tcp");
        tcp = portmap_protocolVar2;
        portmap_protocol portmap_protocolVar3 = new portmap_protocol("udp");
        udp = portmap_protocolVar3;
        swigValues = new portmap_protocol[]{portmap_protocolVar, portmap_protocolVar2, portmap_protocolVar3};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static portmap_protocol swigToEnum(int i) {
        portmap_protocol[] portmap_protocolVarArr = swigValues;
        if (i < portmap_protocolVarArr.length && i >= 0 && portmap_protocolVarArr[i].swigValue == i) {
            return portmap_protocolVarArr[i];
        }
        int i2 = 0;
        while (true) {
            portmap_protocol[] portmap_protocolVarArr2 = swigValues;
            if (i2 < portmap_protocolVarArr2.length) {
                if (portmap_protocolVarArr2[i2].swigValue == i) {
                    return portmap_protocolVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + portmap_protocol.class + " with value " + i);
            }
        }
    }

    private portmap_protocol(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private portmap_protocol(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private portmap_protocol(String str, portmap_protocol portmap_protocolVar) {
        this.swigName = str;
        int i = portmap_protocolVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
