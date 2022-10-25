package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class web_seed_entry {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public web_seed_entry(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(web_seed_entry web_seed_entryVar) {
        if (web_seed_entryVar == null) {
            return 0L;
        }
        return web_seed_entryVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_web_seed_entry(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public web_seed_entry(String str, type_t type_tVar, String str2, string_string_pair_vector string_string_pair_vectorVar) {
        this(libtorrent_jni.new_web_seed_entry__SWIG_0(str, type_tVar.swigValue(), str2, string_string_pair_vector.getCPtr(string_string_pair_vectorVar), string_string_pair_vectorVar), true);
    }

    public web_seed_entry(String str, type_t type_tVar, String str2) {
        this(libtorrent_jni.new_web_seed_entry__SWIG_1(str, type_tVar.swigValue(), str2), true);
    }

    public web_seed_entry(String str, type_t type_tVar) {
        this(libtorrent_jni.new_web_seed_entry__SWIG_2(str, type_tVar.swigValue()), true);
    }

    public boolean op_eq(web_seed_entry web_seed_entryVar) {
        return libtorrent_jni.web_seed_entry_op_eq(this.swigCPtr, this, getCPtr(web_seed_entryVar), web_seed_entryVar);
    }

    public boolean op_lt(web_seed_entry web_seed_entryVar) {
        return libtorrent_jni.web_seed_entry_op_lt(this.swigCPtr, this, getCPtr(web_seed_entryVar), web_seed_entryVar);
    }

    public void setUrl(String str) {
        libtorrent_jni.web_seed_entry_url_set(this.swigCPtr, this, str);
    }

    public String getUrl() {
        return libtorrent_jni.web_seed_entry_url_get(this.swigCPtr, this);
    }

    public void setAuth(String str) {
        libtorrent_jni.web_seed_entry_auth_set(this.swigCPtr, this, str);
    }

    public String getAuth() {
        return libtorrent_jni.web_seed_entry_auth_get(this.swigCPtr, this);
    }

    public void setExtra_headers(string_string_pair_vector string_string_pair_vectorVar) {
        libtorrent_jni.web_seed_entry_extra_headers_set(this.swigCPtr, this, string_string_pair_vector.getCPtr(string_string_pair_vectorVar), string_string_pair_vectorVar);
    }

    public string_string_pair_vector getExtra_headers() {
        long web_seed_entry_extra_headers_get = libtorrent_jni.web_seed_entry_extra_headers_get(this.swigCPtr, this);
        if (web_seed_entry_extra_headers_get == 0) {
            return null;
        }
        return new string_string_pair_vector(web_seed_entry_extra_headers_get, false);
    }

    public void setType(short s) {
        libtorrent_jni.web_seed_entry_type_set(this.swigCPtr, this, s);
    }

    public short getType() {
        return libtorrent_jni.web_seed_entry_type_get(this.swigCPtr, this);
    }

    /* loaded from: classes2.dex */
    public static final class type_t {
        public static final type_t http_seed;
        private static int swigNext;
        private static type_t[] swigValues;
        public static final type_t url_seed;
        private final String swigName;
        private final int swigValue;

        static {
            type_t type_tVar = new type_t("url_seed");
            url_seed = type_tVar;
            type_t type_tVar2 = new type_t("http_seed");
            http_seed = type_tVar2;
            swigValues = new type_t[]{type_tVar, type_tVar2};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static type_t swigToEnum(int i) {
            type_t[] type_tVarArr = swigValues;
            if (i < type_tVarArr.length && i >= 0 && type_tVarArr[i].swigValue == i) {
                return type_tVarArr[i];
            }
            int i2 = 0;
            while (true) {
                type_t[] type_tVarArr2 = swigValues;
                if (i2 < type_tVarArr2.length) {
                    if (type_tVarArr2[i2].swigValue == i) {
                        return type_tVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + type_t.class + " with value " + i);
                }
            }
        }

        private type_t(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private type_t(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private type_t(String str, type_t type_tVar) {
            this.swigName = str;
            int i = type_tVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
