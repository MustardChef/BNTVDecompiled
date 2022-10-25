package com.lagradost.nicehttp;

import com.fasterxml.jackson.core.JsonFactory;
import kotlin.Metadata;

/* compiled from: Requests.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lcom/lagradost/nicehttp/RequestBodyTypes;", "", "()V", JsonFactory.FORMAT_NAME_JSON, "", "TEXT", "library_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class RequestBodyTypes {
    public static final RequestBodyTypes INSTANCE = new RequestBodyTypes();
    public static final String JSON = "application/json;charset=utf-8";
    public static final String TEXT = "text/plain;charset=utf-8";

    private RequestBodyTypes() {
    }
}
