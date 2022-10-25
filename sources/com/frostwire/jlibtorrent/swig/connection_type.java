package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class connection_type {
    public static final connection_type bittorrent;
    public static final connection_type http_seed;
    private static int swigNext;
    private static connection_type[] swigValues;
    public static final connection_type url_seed;
    private final String swigName;
    private final int swigValue;

    static {
        connection_type connection_typeVar = new connection_type("bittorrent");
        bittorrent = connection_typeVar;
        connection_type connection_typeVar2 = new connection_type("url_seed");
        url_seed = connection_typeVar2;
        connection_type connection_typeVar3 = new connection_type("http_seed");
        http_seed = connection_typeVar3;
        swigValues = new connection_type[]{connection_typeVar, connection_typeVar2, connection_typeVar3};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static connection_type swigToEnum(int i) {
        connection_type[] connection_typeVarArr = swigValues;
        if (i < connection_typeVarArr.length && i >= 0 && connection_typeVarArr[i].swigValue == i) {
            return connection_typeVarArr[i];
        }
        int i2 = 0;
        while (true) {
            connection_type[] connection_typeVarArr2 = swigValues;
            if (i2 < connection_typeVarArr2.length) {
                if (connection_typeVarArr2[i2].swigValue == i) {
                    return connection_typeVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + connection_type.class + " with value " + i);
            }
        }
    }

    private connection_type(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private connection_type(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private connection_type(String str, connection_type connection_typeVar) {
        this.swigName = str;
        int i = connection_typeVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
