package com.applovin.impl.p010a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import okhttp3.internal.http.HttpStatusCodes;

/* renamed from: com.applovin.impl.a.d */
/* loaded from: classes.dex */
public enum EnumC1136d {
    UNSPECIFIED(-1),
    XML_PARSING(100),
    GENERAL_WRAPPER_ERROR(300),
    TIMED_OUT(301),
    WRAPPER_LIMIT_REACHED(302),
    NO_WRAPPER_RESPONSE(303),
    GENERAL_LINEAR_ERROR(400),
    NO_MEDIA_FILE_PROVIDED(401),
    MEDIA_FILE_TIMEOUT(402),
    MEDIA_FILE_ERROR(HttpStatusCodes.HTTP_BAD_METHOD),
    GENERAL_COMPANION_AD_ERROR(600),
    UNABLE_TO_FETCH_COMPANION_AD_RESOURCE(TypedValues.MotionType.TYPE_EASING),
    CAN_NOT_FIND_COMPANION_AD_RESOURCE(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR);
    

    /* renamed from: n */
    private final int f237n;

    EnumC1136d(int i) {
        this.f237n = i;
    }

    /* renamed from: a */
    public int m8372a() {
        return this.f237n;
    }
}
