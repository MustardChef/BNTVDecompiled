package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class entry {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public entry(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(entry entryVar) {
        if (entryVar == null) {
            return 0L;
        }
        return entryVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_entry(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public data_type type() {
        return data_type.swigToEnum(libtorrent_jni.entry_type(this.swigCPtr, this));
    }

    public entry(string_entry_map string_entry_mapVar) {
        this(libtorrent_jni.new_entry__SWIG_0(string_entry_map.getCPtr(string_entry_mapVar), string_entry_mapVar), true);
    }

    public entry(byte_const_span byte_const_spanVar) {
        this(libtorrent_jni.new_entry__SWIG_1(byte_const_span.getCPtr(byte_const_spanVar), byte_const_spanVar), true);
    }

    public entry(String str) {
        this(libtorrent_jni.new_entry__SWIG_2(str), true);
    }

    public entry(entry_vector entry_vectorVar) {
        this(libtorrent_jni.new_entry__SWIG_3(entry_vector.getCPtr(entry_vectorVar), entry_vectorVar), true);
    }

    public entry(long j) {
        this(libtorrent_jni.new_entry__SWIG_4(j), true);
    }

    public entry(data_type data_typeVar) {
        this(libtorrent_jni.new_entry__SWIG_5(data_typeVar.swigValue()), true);
    }

    public entry(entry entryVar) {
        this(libtorrent_jni.new_entry__SWIG_6(getCPtr(entryVar), entryVar), true);
    }

    public entry() {
        this(libtorrent_jni.new_entry__SWIG_7(), true);
    }

    public long integer() {
        return libtorrent_jni.entry_integer(this.swigCPtr, this);
    }

    public String string() {
        return libtorrent_jni.entry_string(this.swigCPtr, this);
    }

    public entry_vector list() {
        return new entry_vector(libtorrent_jni.entry_list(this.swigCPtr, this), false);
    }

    public string_entry_map dict() {
        return new string_entry_map(libtorrent_jni.entry_dict(this.swigCPtr, this), false);
    }

    public entry find_key(string_view string_viewVar) {
        long entry_find_key = libtorrent_jni.entry_find_key(this.swigCPtr, this, string_view.getCPtr(string_viewVar), string_viewVar);
        if (entry_find_key == 0) {
            return null;
        }
        return new entry(entry_find_key, false);
    }

    public String to_string() {
        return libtorrent_jni.entry_to_string(this.swigCPtr, this);
    }

    public entry get(String str) {
        return new entry(libtorrent_jni.entry_get(this.swigCPtr, this, str), false);
    }

    public void set(String str, String str2) {
        libtorrent_jni.entry_set__SWIG_0(this.swigCPtr, this, str, str2);
    }

    public void set(String str, byte_vector byte_vectorVar) {
        libtorrent_jni.entry_set__SWIG_1(this.swigCPtr, this, str, byte_vector.getCPtr(byte_vectorVar), byte_vectorVar);
    }

    public void set(String str, long j) {
        libtorrent_jni.entry_set__SWIG_2(this.swigCPtr, this, str, j);
    }

    public void set(String str, entry entryVar) {
        libtorrent_jni.entry_set__SWIG_3(this.swigCPtr, this, str, getCPtr(entryVar), entryVar);
    }

    public byte_vector string_bytes() {
        return new byte_vector(libtorrent_jni.entry_string_bytes(this.swigCPtr, this), true);
    }

    public byte_vector preformatted_bytes() {
        return new byte_vector(libtorrent_jni.entry_preformatted_bytes(this.swigCPtr, this), true);
    }

    public byte_vector bencode() {
        return new byte_vector(libtorrent_jni.entry_bencode(this.swigCPtr, this), true);
    }

    public static entry from_string_bytes(byte_vector byte_vectorVar) {
        return new entry(libtorrent_jni.entry_from_string_bytes(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar), true);
    }

    public static entry from_preformatted_bytes(byte_vector byte_vectorVar) {
        return new entry(libtorrent_jni.entry_from_preformatted_bytes(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar), true);
    }

    public static entry bdecode(byte_vector byte_vectorVar) {
        return new entry(libtorrent_jni.entry_bdecode(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar), true);
    }

    /* loaded from: classes2.dex */
    public static final class data_type {
        public static final data_type dictionary_t;
        public static final data_type int_t;
        public static final data_type list_t;
        public static final data_type preformatted_t;
        public static final data_type string_t;
        private static int swigNext;
        private static data_type[] swigValues;
        public static final data_type undefined_t;
        private final String swigName;
        private final int swigValue;

        static {
            data_type data_typeVar = new data_type("int_t");
            int_t = data_typeVar;
            data_type data_typeVar2 = new data_type("string_t");
            string_t = data_typeVar2;
            data_type data_typeVar3 = new data_type("list_t");
            list_t = data_typeVar3;
            data_type data_typeVar4 = new data_type("dictionary_t");
            dictionary_t = data_typeVar4;
            data_type data_typeVar5 = new data_type("undefined_t");
            undefined_t = data_typeVar5;
            data_type data_typeVar6 = new data_type("preformatted_t");
            preformatted_t = data_typeVar6;
            swigValues = new data_type[]{data_typeVar, data_typeVar2, data_typeVar3, data_typeVar4, data_typeVar5, data_typeVar6};
            swigNext = 0;
        }

        public final int swigValue() {
            return this.swigValue;
        }

        public String toString() {
            return this.swigName;
        }

        public static data_type swigToEnum(int i) {
            data_type[] data_typeVarArr = swigValues;
            if (i < data_typeVarArr.length && i >= 0 && data_typeVarArr[i].swigValue == i) {
                return data_typeVarArr[i];
            }
            int i2 = 0;
            while (true) {
                data_type[] data_typeVarArr2 = swigValues;
                if (i2 < data_typeVarArr2.length) {
                    if (data_typeVarArr2[i2].swigValue == i) {
                        return data_typeVarArr2[i2];
                    }
                    i2++;
                } else {
                    throw new IllegalArgumentException("No enum " + data_type.class + " with value " + i);
                }
            }
        }

        private data_type(String str) {
            this.swigName = str;
            int i = swigNext;
            swigNext = i + 1;
            this.swigValue = i;
        }

        private data_type(String str, int i) {
            this.swigName = str;
            this.swigValue = i;
            swigNext = i + 1;
        }

        private data_type(String str, data_type data_typeVar) {
            this.swigName = str;
            int i = data_typeVar.swigValue;
            this.swigValue = i;
            swigNext = i + 1;
        }
    }
}
