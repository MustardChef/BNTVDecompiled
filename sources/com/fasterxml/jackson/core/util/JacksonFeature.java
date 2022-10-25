package com.fasterxml.jackson.core.util;

/* loaded from: classes2.dex */
public interface JacksonFeature {
    boolean enabledByDefault();

    boolean enabledIn(int i);

    int getMask();
}
