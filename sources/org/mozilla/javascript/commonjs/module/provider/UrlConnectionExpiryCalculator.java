package org.mozilla.javascript.commonjs.module.provider;

import java.net.URLConnection;

/* loaded from: classes5.dex */
public interface UrlConnectionExpiryCalculator {
    long calculateExpiry(URLConnection uRLConnection);
}
