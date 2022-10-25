package com.applovin.impl.mediation;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxError;

/* loaded from: classes.dex */
public class MaxErrorImpl implements MaxError {
    private String adLoadFailureInfo;
    private final int errorCode;
    private final String errorMessage;

    public MaxErrorImpl(int i) {
        this(i, "");
    }

    public MaxErrorImpl(int i, String str) {
        this.errorCode = i;
        this.errorMessage = StringUtils.emptyIfNull(str);
    }

    public MaxErrorImpl(String str) {
        this(-1, str);
    }

    @Override // com.applovin.mediation.MaxError
    public String getAdLoadFailureInfo() {
        return this.adLoadFailureInfo;
    }

    @Override // com.applovin.mediation.MaxError
    public int getCode() {
        return this.errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // com.applovin.mediation.MaxError
    public String getMessage() {
        return this.errorMessage;
    }

    public void setAdLoadFailureInfo(String str) {
        this.adLoadFailureInfo = str;
    }

    public String toString() {
        return "MaxError{code=" + getCode() + ", message='" + getMessage() + "'}";
    }
}
