package org.mozilla.javascript.commonjs.module.provider;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class UrlModuleSourceProvider extends ModuleSourceProviderBase {
    private static final long serialVersionUID = 1;
    private final Iterable<URI> fallbackUris;
    private final Iterable<URI> privilegedUris;
    private final UrlConnectionExpiryCalculator urlConnectionExpiryCalculator;
    private final UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider;

    protected void onFailedClosingUrlConnection(URLConnection uRLConnection, IOException iOException) {
    }

    public UrlModuleSourceProvider(Iterable<URI> iterable, Iterable<URI> iterable2) {
        this(iterable, iterable2, new DefaultUrlConnectionExpiryCalculator(), null);
    }

    public UrlModuleSourceProvider(Iterable<URI> iterable, Iterable<URI> iterable2, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator, UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider) {
        this.privilegedUris = iterable;
        this.fallbackUris = iterable2;
        this.urlConnectionExpiryCalculator = urlConnectionExpiryCalculator;
        this.urlConnectionSecurityDomainProvider = urlConnectionSecurityDomainProvider;
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected ModuleSource loadFromPrivilegedLocations(String str, Object obj) throws IOException, URISyntaxException {
        return loadFromPathList(str, obj, this.privilegedUris);
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected ModuleSource loadFromFallbackLocations(String str, Object obj) throws IOException, URISyntaxException {
        return loadFromPathList(str, obj, this.fallbackUris);
    }

    private ModuleSource loadFromPathList(String str, Object obj, Iterable<URI> iterable) throws IOException, URISyntaxException {
        if (iterable == null) {
            return null;
        }
        for (URI uri : iterable) {
            ModuleSource loadFromUri = loadFromUri(uri.resolve(str), uri, obj);
            if (loadFromUri != null) {
                return loadFromUri;
            }
        }
        return null;
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected ModuleSource loadFromUri(URI uri, URI uri2, Object obj) throws IOException, URISyntaxException {
        ModuleSource loadFromActualUri = loadFromActualUri(new URI(uri + ".js"), uri2, obj);
        return loadFromActualUri != null ? loadFromActualUri : loadFromActualUri(uri, uri2, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r15.appliesTo(r13) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected org.mozilla.javascript.commonjs.module.provider.ModuleSource loadFromActualUri(java.net.URI r13, java.net.URI r14, java.lang.Object r15) throws java.io.IOException {
        /*
            r12 = this;
            java.net.URL r0 = new java.net.URL
            r1 = 0
            if (r14 != 0) goto L7
            r2 = r1
            goto Lb
        L7:
            java.net.URL r2 = r14.toURL()
        Lb:
            java.lang.String r3 = r13.toString()
            r0.<init>(r2, r3)
            long r7 = java.lang.System.currentTimeMillis()
            java.net.URLConnection r0 = r12.openUrlConnection(r0)
            boolean r2 = r15 instanceof org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.URLValidator
            if (r2 == 0) goto L27
            org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider$URLValidator r15 = (org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.URLValidator) r15
            boolean r2 = r15.appliesTo(r13)
            if (r2 == 0) goto L27
            goto L28
        L27:
            r15 = r1
        L28:
            if (r15 == 0) goto L2d
            r15.applyConditionals(r0)
        L2d:
            r0.connect()     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            if (r15 == 0) goto L40
            org.mozilla.javascript.commonjs.module.provider.UrlConnectionExpiryCalculator r2 = r12.urlConnectionExpiryCalculator     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            boolean r15 = r15.updateValidator(r0, r7, r2)     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            if (r15 == 0) goto L40
            r12.close(r0)     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            org.mozilla.javascript.commonjs.module.provider.ModuleSource r13 = org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.NOT_MODIFIED     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            return r13
        L40:
            org.mozilla.javascript.commonjs.module.provider.ModuleSource r15 = new org.mozilla.javascript.commonjs.module.provider.ModuleSource     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            java.io.Reader r3 = getReader(r0)     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            java.lang.Object r10 = r12.getSecurityDomain(r0)     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider$URLValidator r11 = new org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider$URLValidator     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            org.mozilla.javascript.commonjs.module.provider.UrlConnectionExpiryCalculator r9 = r12.urlConnectionExpiryCalculator     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            r4 = r11
            r5 = r13
            r6 = r0
            r4.<init>(r5, r6, r7, r9)     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            r2 = r15
            r4 = r10
            r5 = r13
            r6 = r14
            r7 = r11
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.io.IOException -> L5d java.lang.RuntimeException -> L62 java.io.FileNotFoundException -> L67
            return r15
        L5d:
            r13 = move-exception
            r12.close(r0)
            throw r13
        L62:
            r13 = move-exception
            r12.close(r0)
            throw r13
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider.loadFromActualUri(java.net.URI, java.net.URI, java.lang.Object):org.mozilla.javascript.commonjs.module.provider.ModuleSource");
    }

    private static Reader getReader(URLConnection uRLConnection) throws IOException {
        return new InputStreamReader(uRLConnection.getInputStream(), getCharacterEncoding(uRLConnection));
    }

    private static String getCharacterEncoding(URLConnection uRLConnection) {
        ParsedContentType parsedContentType = new ParsedContentType(uRLConnection.getContentType());
        String encoding = parsedContentType.getEncoding();
        if (encoding != null) {
            return encoding;
        }
        String contentType = parsedContentType.getContentType();
        return (contentType == null || !contentType.startsWith("text/")) ? "utf-8" : "8859_1";
    }

    private Object getSecurityDomain(URLConnection uRLConnection) {
        UrlConnectionSecurityDomainProvider urlConnectionSecurityDomainProvider = this.urlConnectionSecurityDomainProvider;
        if (urlConnectionSecurityDomainProvider == null) {
            return null;
        }
        return urlConnectionSecurityDomainProvider.getSecurityDomain(uRLConnection);
    }

    private void close(URLConnection uRLConnection) {
        try {
            uRLConnection.getInputStream().close();
        } catch (IOException e) {
            onFailedClosingUrlConnection(uRLConnection, e);
        }
    }

    protected URLConnection openUrlConnection(URL url) throws IOException {
        return url.openConnection();
    }

    @Override // org.mozilla.javascript.commonjs.module.provider.ModuleSourceProviderBase
    protected boolean entityNeedsRevalidation(Object obj) {
        return !(obj instanceof URLValidator) || ((URLValidator) obj).entityNeedsRevalidation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class URLValidator implements Serializable {
        private static final long serialVersionUID = 1;
        private final String entityTags;
        private long expiry;
        private final long lastModified;
        private final URI uri;

        public URLValidator(URI uri, URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            this.uri = uri;
            this.lastModified = uRLConnection.getLastModified();
            this.entityTags = getEntityTags(uRLConnection);
            this.expiry = calculateExpiry(uRLConnection, j, urlConnectionExpiryCalculator);
        }

        boolean updateValidator(URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) throws IOException {
            boolean isResourceChanged = isResourceChanged(uRLConnection);
            if (!isResourceChanged) {
                this.expiry = calculateExpiry(uRLConnection, j, urlConnectionExpiryCalculator);
            }
            return isResourceChanged;
        }

        private boolean isResourceChanged(URLConnection uRLConnection) throws IOException {
            return uRLConnection instanceof HttpURLConnection ? ((HttpURLConnection) uRLConnection).getResponseCode() == 304 : this.lastModified == uRLConnection.getLastModified();
        }

        private long calculateExpiry(URLConnection uRLConnection, long j, UrlConnectionExpiryCalculator urlConnectionExpiryCalculator) {
            if ("no-cache".equals(uRLConnection.getHeaderField(HttpHeaders.PRAGMA))) {
                return 0L;
            }
            String headerField = uRLConnection.getHeaderField("Cache-Control");
            if (headerField != null) {
                if (headerField.indexOf("no-cache") != -1) {
                    return 0L;
                }
                int maxAge = getMaxAge(headerField);
                if (-1 != maxAge) {
                    long currentTimeMillis = System.currentTimeMillis();
                    return (maxAge * 1000) + (currentTimeMillis - (Math.max(Math.max(0L, currentTimeMillis - uRLConnection.getDate()), uRLConnection.getHeaderFieldInt(HttpHeaders.AGE, 0) * 1000) + (currentTimeMillis - j)));
                }
            }
            long headerFieldDate = uRLConnection.getHeaderFieldDate("Expires", -1L);
            if (headerFieldDate != -1) {
                return headerFieldDate;
            }
            if (urlConnectionExpiryCalculator == null) {
                return 0L;
            }
            return urlConnectionExpiryCalculator.calculateExpiry(uRLConnection);
        }

        private int getMaxAge(String str) {
            int indexOf;
            String substring;
            int indexOf2 = str.indexOf("max-age");
            if (indexOf2 == -1 || (indexOf = str.indexOf(61, indexOf2 + 7)) == -1) {
                return -1;
            }
            int i = indexOf + 1;
            int indexOf3 = str.indexOf(44, i);
            if (indexOf3 == -1) {
                substring = str.substring(i);
            } else {
                substring = str.substring(i, indexOf3);
            }
            try {
                return Integer.parseInt(substring);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        private String getEntityTags(URLConnection uRLConnection) {
            List<String> list = uRLConnection.getHeaderFields().get(HttpHeaders.ETAG);
            if (list == null || list.isEmpty()) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            sb.append(it.next());
            while (it.hasNext()) {
                sb.append(", ");
                sb.append(it.next());
            }
            return sb.toString();
        }

        boolean appliesTo(URI uri) {
            return this.uri.equals(uri);
        }

        void applyConditionals(URLConnection uRLConnection) {
            long j = this.lastModified;
            if (j != 0) {
                uRLConnection.setIfModifiedSince(j);
            }
            String str = this.entityTags;
            if (str == null || str.length() <= 0) {
                return;
            }
            uRLConnection.addRequestProperty(HttpHeaders.IF_NONE_MATCH, this.entityTags);
        }

        boolean entityNeedsRevalidation() {
            return System.currentTimeMillis() > this.expiry;
        }
    }
}
