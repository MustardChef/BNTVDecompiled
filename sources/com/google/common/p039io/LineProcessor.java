package com.google.common.p039io;

import java.io.IOException;

/* renamed from: com.google.common.io.LineProcessor */
/* loaded from: classes3.dex */
public interface LineProcessor<T> {
    T getResult();

    boolean processLine(String str) throws IOException;
}
