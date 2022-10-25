package com.lagradost.cloudstream3;

import kotlin.Metadata;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/DubStatus;", "", "id", "", "(Ljava/lang/String;II)V", "getId", "()I", "Dubbed", "Subbed", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public enum DubStatus {
    Dubbed(1),
    Subbed(0);
    

    /* renamed from: id */
    private final int f9898id;

    DubStatus(int i) {
        this.f9898id = i;
    }

    public final int getId() {
        return this.f9898id;
    }
}
