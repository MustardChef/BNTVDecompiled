package com.google.common.p039io;

import java.io.IOException;

/* renamed from: com.google.common.io.ByteProcessor */
/* loaded from: classes3.dex */
public interface ByteProcessor<T> {
    T getResult();

    boolean processBytes(byte[] bArr, int i, int i2) throws IOException;
}
