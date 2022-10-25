package com.frostwire.jlibtorrent.swig;

/* loaded from: classes2.dex */
public final class http_errors {
    public static final http_errors accepted;
    public static final http_errors bad_gateway;
    public static final http_errors bad_request;
    public static final http_errors cont;
    public static final http_errors created;
    public static final http_errors forbidden;
    public static final http_errors internal_server_error;
    public static final http_errors moved_permanently;
    public static final http_errors moved_temporarily;
    public static final http_errors multiple_choices;
    public static final http_errors no_content;
    public static final http_errors not_found;
    public static final http_errors not_implemented;
    public static final http_errors not_modified;

    /* renamed from: ok */
    public static final http_errors f2835ok;
    public static final http_errors service_unavailable;
    private static int swigNext;
    private static http_errors[] swigValues;
    public static final http_errors unauthorized;
    private final String swigName;
    private final int swigValue;

    static {
        http_errors http_errorsVar = new http_errors("cont", libtorrent_jni.cont_get());
        cont = http_errorsVar;
        http_errors http_errorsVar2 = new http_errors("ok", libtorrent_jni.ok_get());
        f2835ok = http_errorsVar2;
        http_errors http_errorsVar3 = new http_errors("created", libtorrent_jni.created_get());
        created = http_errorsVar3;
        http_errors http_errorsVar4 = new http_errors("accepted", libtorrent_jni.accepted_get());
        accepted = http_errorsVar4;
        http_errors http_errorsVar5 = new http_errors("no_content", libtorrent_jni.no_content_get());
        no_content = http_errorsVar5;
        http_errors http_errorsVar6 = new http_errors("multiple_choices", libtorrent_jni.multiple_choices_get());
        multiple_choices = http_errorsVar6;
        http_errors http_errorsVar7 = new http_errors("moved_permanently", libtorrent_jni.moved_permanently_get());
        moved_permanently = http_errorsVar7;
        http_errors http_errorsVar8 = new http_errors("moved_temporarily", libtorrent_jni.moved_temporarily_get());
        moved_temporarily = http_errorsVar8;
        http_errors http_errorsVar9 = new http_errors("not_modified", libtorrent_jni.not_modified_get());
        not_modified = http_errorsVar9;
        http_errors http_errorsVar10 = new http_errors("bad_request", libtorrent_jni.bad_request_get());
        bad_request = http_errorsVar10;
        http_errors http_errorsVar11 = new http_errors("unauthorized", libtorrent_jni.unauthorized_get());
        unauthorized = http_errorsVar11;
        http_errors http_errorsVar12 = new http_errors("forbidden", libtorrent_jni.forbidden_get());
        forbidden = http_errorsVar12;
        http_errors http_errorsVar13 = new http_errors("not_found", libtorrent_jni.not_found_get());
        not_found = http_errorsVar13;
        http_errors http_errorsVar14 = new http_errors("internal_server_error", libtorrent_jni.internal_server_error_get());
        internal_server_error = http_errorsVar14;
        http_errors http_errorsVar15 = new http_errors("not_implemented", libtorrent_jni.not_implemented_get());
        not_implemented = http_errorsVar15;
        http_errors http_errorsVar16 = new http_errors("bad_gateway", libtorrent_jni.bad_gateway_get());
        bad_gateway = http_errorsVar16;
        http_errors http_errorsVar17 = new http_errors("service_unavailable", libtorrent_jni.service_unavailable_get());
        service_unavailable = http_errorsVar17;
        swigValues = new http_errors[]{http_errorsVar, http_errorsVar2, http_errorsVar3, http_errorsVar4, http_errorsVar5, http_errorsVar6, http_errorsVar7, http_errorsVar8, http_errorsVar9, http_errorsVar10, http_errorsVar11, http_errorsVar12, http_errorsVar13, http_errorsVar14, http_errorsVar15, http_errorsVar16, http_errorsVar17};
        swigNext = 0;
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static http_errors swigToEnum(int i) {
        http_errors[] http_errorsVarArr = swigValues;
        if (i < http_errorsVarArr.length && i >= 0 && http_errorsVarArr[i].swigValue == i) {
            return http_errorsVarArr[i];
        }
        int i2 = 0;
        while (true) {
            http_errors[] http_errorsVarArr2 = swigValues;
            if (i2 < http_errorsVarArr2.length) {
                if (http_errorsVarArr2[i2].swigValue == i) {
                    return http_errorsVarArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + http_errors.class + " with value " + i);
            }
        }
    }

    private http_errors(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private http_errors(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private http_errors(String str, http_errors http_errorsVar) {
        this.swigName = str;
        int i = http_errorsVar.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
