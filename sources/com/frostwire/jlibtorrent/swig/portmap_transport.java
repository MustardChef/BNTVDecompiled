package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class portmap_transport {
    public static final portmap_transport natpmp;
    private static int swigNext;
    private static portmap_transport[] swigValues;
    public static final portmap_transport upnp;
    private final String swigName;
    private final int swigValue;

    static {
        portmap_transport portmap_transportVar = new portmap_transport("natpmp");
        natpmp = portmap_transportVar;
        portmap_transport portmap_transportVar2 = new portmap_transport("upnp");
        upnp = portmap_transportVar2;
        swigValues = new portmap_transport[]{portmap_transportVar, portmap_transportVar2};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static portmap_transport swigToEnum(int i) {
        portmap_transport[] portmap_transportVarArr = swigValues;
        if (i < portmap_transportVarArr.length && i >= 0 && portmap_transportVarArr[i].swigValue == i) {
            return portmap_transportVarArr[i];
        }
        int i2 = 0;
        while (true) {
            portmap_transport[] portmap_transportVarArr2 = swigValues;
            if (i2 < portmap_transportVarArr2.length) {
                if (portmap_transportVarArr2[i2].swigValue == i) {
                    return portmap_transportVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + portmap_transport.class + " with value " + i);
            }
        }
    }

    private portmap_transport(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private portmap_transport(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private portmap_transport(String str, portmap_transport portmap_transportVar) {
        this.swigName = str;
        int i = portmap_transportVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
