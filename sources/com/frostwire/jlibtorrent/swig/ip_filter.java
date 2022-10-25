package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class ip_filter {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public ip_filter(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(ip_filter ip_filterVar) {
        if (ip_filterVar == null) {
            return 0L;
        }
        return ip_filterVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_ip_filter(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void add_rule(address addressVar, address addressVar2, long j) {
        libtorrent_jni.ip_filter_add_rule(this.swigCPtr, this, address.getCPtr(addressVar), addressVar, address.getCPtr(addressVar2), addressVar2, j);
    }

    public long access(address addressVar) {
        return libtorrent_jni.ip_filter_access(this.swigCPtr, this, address.getCPtr(addressVar), addressVar);
    }

    public ip_filter() {
        this(libtorrent_jni.new_ip_filter(), true);
    }

    /* loaded from: classes2.dex */
    public static final class access_flags {
        public static final access_flags blocked;
        private static int swigNext;
        private static access_flags[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            access_flags access_flagsVar = new access_flags("blocked", libtorrent_jni.ip_filter_blocked_get());
            blocked = access_flagsVar;
            swigValues = new access_flags[]{access_flagsVar};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static access_flags swigToEnum(int i) {
            access_flags[] access_flagsVarArr = swigValues;
            if (i < access_flagsVarArr.length && i >= 0 && access_flagsVarArr[i].swigValue == i) {
                return access_flagsVarArr[i];
            }
            int i2 = 0;
            while (true) {
                access_flags[] access_flagsVarArr2 = swigValues;
                if (i2 < access_flagsVarArr2.length) {
                    if (access_flagsVarArr2[i2].swigValue == i) {
                        return access_flagsVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + access_flags.class + " with value " + i);
                }
            }
        }

        private access_flags(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private access_flags(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private access_flags(String str, access_flags access_flagsVar) {
            this.swigName = str;
            int i = access_flagsVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
