package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public class bdecode_node {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    /* JADX INFO: Access modifiers changed from: protected */
    public bdecode_node(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long getCPtr(bdecode_node bdecode_nodeVar) {
        if (bdecode_nodeVar == null) {
            return 0L;
        }
        return bdecode_nodeVar.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                libtorrent_jni.delete_bdecode_node(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public bdecode_node() {
        this(libtorrent_jni.new_bdecode_node__SWIG_0(), true);
    }

    public bdecode_node(bdecode_node bdecode_nodeVar) {
        this(libtorrent_jni.new_bdecode_node__SWIG_1(getCPtr(bdecode_nodeVar), bdecode_nodeVar), true);
    }

    public type_t type() {
        return type_t.swigToEnum(libtorrent_jni.bdecode_node_type(this.swigCPtr, this));
    }

    public boolean op_bool() {
        return libtorrent_jni.bdecode_node_op_bool(this.swigCPtr, this);
    }

    public bdecode_node list_at(int i) {
        return new bdecode_node(libtorrent_jni.bdecode_node_list_at(this.swigCPtr, this, i), true);
    }

    public long list_int_value_at(int i, long j) {
        return libtorrent_jni.bdecode_node_list_int_value_at__SWIG_0(this.swigCPtr, this, i, j);
    }

    public long list_int_value_at(int i) {
        return libtorrent_jni.bdecode_node_list_int_value_at__SWIG_1(this.swigCPtr, this, i);
    }

    public int list_size() {
        return libtorrent_jni.bdecode_node_list_size(this.swigCPtr, this);
    }

    public string_view_bdecode_node_pair dict_at(int i) {
        return new string_view_bdecode_node_pair(libtorrent_jni.bdecode_node_dict_at(this.swigCPtr, this, i), true);
    }

    public int dict_size() {
        return libtorrent_jni.bdecode_node_dict_size(this.swigCPtr, this);
    }

    public long int_value() {
        return libtorrent_jni.bdecode_node_int_value(this.swigCPtr, this);
    }

    public int string_length() {
        return libtorrent_jni.bdecode_node_string_length(this.swigCPtr, this);
    }

    public void clear() {
        libtorrent_jni.bdecode_node_clear(this.swigCPtr, this);
    }

    public String list_string_value_at_s(int i, String str) {
        return libtorrent_jni.bdecode_node_list_string_value_at_s__SWIG_0(this.swigCPtr, this, i, str);
    }

    public String list_string_value_at_s(int i) {
        return libtorrent_jni.bdecode_node_list_string_value_at_s__SWIG_1(this.swigCPtr, this, i);
    }

    public bdecode_node dict_find_s(String str) {
        return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_s(this.swigCPtr, this, str), true);
    }

    public bdecode_node dict_find_dict_s(String str) {
        return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_dict_s(this.swigCPtr, this, str), true);
    }

    public bdecode_node dict_find_list_s(String str) {
        return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_list_s(this.swigCPtr, this, str), true);
    }

    public bdecode_node dict_find_string_s(String str) {
        return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_string_s(this.swigCPtr, this, str), true);
    }

    public bdecode_node dict_find_int_s(String str) {
        return new bdecode_node(libtorrent_jni.bdecode_node_dict_find_int_s(this.swigCPtr, this, str), true);
    }

    public String dict_find_string_value_s(String str, String str2) {
        return libtorrent_jni.bdecode_node_dict_find_string_value_s__SWIG_0(this.swigCPtr, this, str, str2);
    }

    public String dict_find_string_value_s(String str) {
        return libtorrent_jni.bdecode_node_dict_find_string_value_s__SWIG_1(this.swigCPtr, this, str);
    }

    public long dict_find_int_value_s(String str, long j) {
        return libtorrent_jni.bdecode_node_dict_find_int_value_s__SWIG_0(this.swigCPtr, this, str, j);
    }

    public long dict_find_int_value_s(String str) {
        return libtorrent_jni.bdecode_node_dict_find_int_value_s__SWIG_1(this.swigCPtr, this, str);
    }

    public String string_value_s() {
        return libtorrent_jni.bdecode_node_string_value_s(this.swigCPtr, this);
    }

    public static String to_string(bdecode_node bdecode_nodeVar, boolean z, int i) {
        return libtorrent_jni.bdecode_node_to_string(getCPtr(bdecode_nodeVar), bdecode_nodeVar, z, i);
    }

    public static int bdecode(byte_vector byte_vectorVar, bdecode_node bdecode_nodeVar, error_code error_codeVar) {
        return libtorrent_jni.bdecode_node_bdecode(byte_vector.getCPtr(byte_vectorVar), byte_vectorVar, getCPtr(bdecode_nodeVar), bdecode_nodeVar, error_code.getCPtr(error_codeVar), error_codeVar);
    }

    /* loaded from: classes2.dex */
    public static final class type_t {
        public static final type_t dict_t;
        public static final type_t int_t;
        public static final type_t list_t;
        public static final type_t none_t;
        public static final type_t string_t;
        private static int swigNext;
        private static type_t[] swigValues;
        private final String swigName;
        private final int swigValue;

        static {
            type_t type_tVar = new type_t("none_t");
            none_t = type_tVar;
            type_t type_tVar2 = new type_t("dict_t");
            dict_t = type_tVar2;
            type_t type_tVar3 = new type_t("list_t");
            list_t = type_tVar3;
            type_t type_tVar4 = new type_t("string_t");
            string_t = type_tVar4;
            type_t type_tVar5 = new type_t("int_t");
            int_t = type_tVar5;
            swigValues = new type_t[]{type_tVar, type_tVar2, type_tVar3, type_tVar4, type_tVar5};
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
