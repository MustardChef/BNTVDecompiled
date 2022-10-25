package com.hippo.unifile;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes3.dex */
class IOUtils {
    IOUtils() {
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
