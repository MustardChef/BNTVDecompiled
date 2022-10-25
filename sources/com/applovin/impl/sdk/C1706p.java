package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1585e;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.p */
/* loaded from: classes.dex */
public class C1706p {

    /* renamed from: b */
    private final C1662k f2443b;

    /* renamed from: c */
    private final C1710r f2444c;

    /* renamed from: a */
    private final String f2442a = "FileManager";

    /* renamed from: d */
    private final Object f2445d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1706p(C1662k c1662k) {
        this.f2443b = c1662k;
        this.f2444c = c1662k.m6588z();
    }

    /* renamed from: a */
    private long m6356a() {
        long longValue = ((Long) this.f2443b.m6656a(C1568b.f1740bg)).longValue();
        if (longValue < 0 || !m6344b()) {
            return -1L;
        }
        return longValue;
    }

    /* renamed from: a */
    private long m6355a(long j) {
        return j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    /* renamed from: a */
    private void m6354a(long j, Context context) {
        C1710r c1710r;
        String str;
        if (m6344b()) {
            long intValue = ((Integer) this.f2443b.m6656a(C1568b.f1741bh)).intValue();
            if (intValue == -1) {
                c1710r = this.f2444c;
                str = "Cache has no maximum size set; skipping drop...";
            } else {
                int i = (m6355a(j) > intValue ? 1 : (m6355a(j) == intValue ? 0 : -1));
                c1710r = this.f2444c;
                if (i > 0) {
                    c1710r.m6319b("FileManager", "Cache has exceeded maximum size; dropping...");
                    for (File file : m6338d(context)) {
                        m6341b(file);
                    }
                    this.f2443b.m6669R().m6893a(C1586f.f2037f);
                    return;
                }
                str = "Cache is present but under size limit; not dropping...";
            }
            c1710r.m6319b("FileManager", str);
        }
    }

    /* renamed from: a */
    private boolean m6347a(File file, String str, List<String> list, boolean z, C1585e c1585e) {
        if (file == null || !file.exists() || file.isDirectory()) {
            ByteArrayOutputStream m6345a = m6345a(str, list, z, c1585e);
            if (c1585e != null && m6345a != null) {
                c1585e.m6910a(m6345a.size());
            }
            return m6350a(m6345a, file);
        }
        C1710r c1710r = this.f2444c;
        c1710r.m6319b("FileManager", "File exists for " + str);
        if (c1585e != null) {
            c1585e.m6907b(file.length());
            return true;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m6344b() {
        return ((Boolean) this.f2443b.m6656a(C1568b.f1739bf)).booleanValue();
    }

    /* renamed from: b */
    private boolean m6342b(ByteArrayOutputStream byteArrayOutputStream, File file) {
        C1662k c1662k;
        boolean z;
        FileOutputStream fileOutputStream;
        C1710r c1710r = this.f2444c;
        c1710r.m6319b("FileManager", "Writing resource to filesystem: " + file.getName());
        synchronized (this.f2445d) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byteArrayOutputStream.writeTo(fileOutputStream);
                z = true;
                Utils.close(fileOutputStream, this.f2443b);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                this.f2444c.m6318b("FileManager", "Unable to write data to file.", e);
                c1662k = this.f2443b;
                Utils.close(fileOutputStream2, c1662k);
                z = false;
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                this.f2444c.m6318b("FileManager", "Unknown failure to write file.", th);
                c1662k = this.f2443b;
                Utils.close(fileOutputStream2, c1662k);
                z = false;
                return z;
            }
        }
        return z;
    }

    /* renamed from: b */
    private boolean m6341b(File file) {
        boolean delete;
        C1710r c1710r = this.f2444c;
        c1710r.m6319b("FileManager", "Removing file " + file.getName() + " from filesystem...");
        synchronized (this.f2445d) {
            try {
                try {
                    delete = file.delete();
                } catch (Exception e) {
                    C1710r c1710r2 = this.f2444c;
                    c1710r2.m6318b("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return delete;
    }

    /* renamed from: c */
    private long m6339c(Context context) {
        long j;
        boolean z;
        long m6356a = m6356a();
        boolean z2 = m6356a != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f2445d) {
            List<String> m6625b = this.f2443b.m6625b(C1568b.f1746bm);
            j = 0;
            for (File file : m6338d(context)) {
                if (!z2 || m6625b.contains(file.getName()) || seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) <= m6356a) {
                    z = false;
                } else {
                    C1710r c1710r = this.f2444c;
                    c1710r.m6319b("FileManager", "File " + file.getName() + " has expired, removing...");
                    z = m6341b(file);
                }
                if (z) {
                    this.f2443b.m6669R().m6893a(C1586f.f2036e);
                } else {
                    j += file.length();
                }
            }
        }
        return j;
    }

    /* renamed from: d */
    private List<File> m6338d(Context context) {
        List<File> asList;
        File m6337e = m6337e(context);
        if (m6337e.isDirectory()) {
            synchronized (this.f2445d) {
                asList = Arrays.asList(m6337e.listFiles());
            }
            return asList;
        }
        return Collections.emptyList();
    }

    /* renamed from: e */
    private File m6337e(Context context) {
        return new File(context.getFilesDir(), "al");
    }

    /* renamed from: a */
    public ByteArrayOutputStream m6349a(File file) {
        FileInputStream fileInputStream;
        if (file == null) {
            return null;
        }
        this.f2444c.m6319b("FileManager", "Reading resource from filesystem: " + file.getName());
        synchronized (this.f2445d) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e = e;
                fileInputStream = null;
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read < 0) {
                            Utils.close(fileInputStream, this.f2443b);
                            return byteArrayOutputStream;
                        }
                        try {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Exception unused) {
                            Utils.close(byteArrayOutputStream, this.f2443b);
                            Utils.close(fileInputStream, this.f2443b);
                            return null;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    this.f2444c.m6317c("FileManager", "File not found. " + e);
                    Utils.close(fileInputStream, this.f2443b);
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    this.f2444c.m6319b("FileManager", "Failed to read file: " + file.getName() + e);
                    Utils.close(fileInputStream, this.f2443b);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                this.f2444c.m6318b("FileManager", "Unknown failure to read file.", th);
                Utils.close(fileInputStream, this.f2443b);
                return null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v5, types: [com.applovin.impl.sdk.r] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    /* renamed from: a */
    public ByteArrayOutputStream m6345a(String str, List<String> list, boolean z, C1585e c1585e) {
        InputStream inputStream;
        Closeable closeable = null;
        if (z && !Utils.isDomainWhitelisted(str, list)) {
            this.f2444c.m6319b("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            return null;
        }
        if (((Boolean) this.f2443b.m6656a(C1568b.f1779cT)).booleanValue() && !str.contains("https://")) {
            this.f2444c.m6315d("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            str = str.replace("http://", "https://");
        }
        ?? r9 = this.f2444c;
        ?? r10 = "Loading " + str + "...";
        r9.m6319b("FileManager", r10);
        try {
            try {
                r9 = new ByteArrayOutputStream();
            } catch (IOException e) {
                e = e;
                r9 = 0;
                r10 = 0;
            } catch (Throwable th) {
                th = th;
                r9 = 0;
                r10 = 0;
            }
            try {
                r10 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    r10.setConnectTimeout(((Integer) this.f2443b.m6656a(C1568b.f1777cR)).intValue());
                    r10.setReadTimeout(((Integer) this.f2443b.m6656a(C1568b.f1778cS)).intValue());
                    r10.setDefaultUseCaches(true);
                    r10.setUseCaches(true);
                    r10.setAllowUserInteraction(false);
                    r10.setInstanceFollowRedirects(true);
                    int responseCode = r10.getResponseCode();
                    c1585e.m6911a(responseCode);
                    if (responseCode >= 200 && responseCode < 300) {
                        inputStream = r10.getInputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr, 0, 1024);
                                if (read < 0) {
                                    this.f2444c.m6319b("FileManager", "Loaded resource at " + str);
                                    Utils.close(inputStream, this.f2443b);
                                    Utils.close(r9, this.f2443b);
                                    Utils.disconnect(r10, this.f2443b);
                                    return r9;
                                }
                                try {
                                    r9.write(bArr, 0, read);
                                } catch (Exception unused) {
                                    Utils.close(r9, this.f2443b);
                                    Utils.close(inputStream, this.f2443b);
                                    Utils.close(r9, this.f2443b);
                                    Utils.disconnect(r10, this.f2443b);
                                    return null;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            this.f2444c.m6318b("FileManager", "Error loading " + str, e);
                            c1585e.m6909a(e);
                            Utils.close(inputStream, this.f2443b);
                            Utils.close(r9, this.f2443b);
                            Utils.disconnect(r10, this.f2443b);
                            return null;
                        }
                    }
                    Utils.close(null, this.f2443b);
                    Utils.close(r9, this.f2443b);
                    Utils.disconnect(r10, this.f2443b);
                    return null;
                } catch (IOException e3) {
                    e = e3;
                    inputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.close(closeable, this.f2443b);
                    Utils.close(r9, this.f2443b);
                    Utils.disconnect(r10, this.f2443b);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                r10 = 0;
                r9 = r9;
                inputStream = r10;
                this.f2444c.m6318b("FileManager", "Error loading " + str, e);
                c1585e.m6909a(e);
                Utils.close(inputStream, this.f2443b);
                Utils.close(r9, this.f2443b);
                Utils.disconnect(r10, this.f2443b);
                return null;
            } catch (Throwable th3) {
                th = th3;
                r10 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
            closeable = "...";
        }
    }

    /* renamed from: a */
    public File m6346a(String str, Context context) {
        File file;
        if (!StringUtils.isValidString(str)) {
            this.f2444c.m6319b("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        C1710r c1710r = this.f2444c;
        c1710r.m6319b("FileManager", "Looking up cached resource: " + str);
        if (str.contains("icon")) {
            str = str.replace("/", "_").replace(".", "_");
        }
        synchronized (this.f2445d) {
            File m6337e = m6337e(context);
            file = new File(m6337e, str);
            m6337e.mkdirs();
        }
        return file;
    }

    /* renamed from: a */
    public String m6352a(Context context, String str, String str2, List<String> list, boolean z, C1585e c1585e) {
        return m6351a(context, str, str2, list, z, false, c1585e);
    }

    /* renamed from: a */
    public String m6351a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, C1585e c1585e) {
        if (!StringUtils.isValidString(str)) {
            this.f2444c.m6319b("FileManager", "Nothing to cache, skipping...");
            return null;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (StringUtils.isValidString(lastPathSegment) && StringUtils.isValidString(str2)) {
            lastPathSegment = str2 + lastPathSegment;
        }
        String str3 = lastPathSegment;
        File m6346a = m6346a(str3, context);
        if (m6347a(m6346a, str, list, z, c1585e)) {
            this.f2444c.m6319b("FileManager", "Caching succeeded for file " + str3);
            return z2 ? Uri.fromFile(m6346a).toString() : str3;
        }
        return null;
    }

    /* renamed from: a */
    public void m6353a(Context context) {
        if (m6344b() && this.f2443b.m6617c()) {
            this.f2444c.m6319b("FileManager", "Compacting cache...");
            synchronized (this.f2445d) {
                m6354a(m6339c(context), context);
            }
        }
    }

    /* renamed from: a */
    public boolean m6350a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        C1710r c1710r = this.f2444c;
        c1710r.m6319b("FileManager", "Caching " + file.getAbsolutePath() + "...");
        if (byteArrayOutputStream == null || byteArrayOutputStream.size() <= 0) {
            C1710r c1710r2 = this.f2444c;
            c1710r2.m6315d("FileManager", "No data for " + file.getAbsolutePath());
            return false;
        } else if (m6342b(byteArrayOutputStream, file)) {
            C1710r c1710r3 = this.f2444c;
            c1710r3.m6319b("FileManager", "Caching completed for " + file);
            return true;
        } else {
            C1710r c1710r4 = this.f2444c;
            c1710r4.m6314e("FileManager", "Unable to cache " + file.getAbsolutePath());
            return false;
        }
    }

    /* renamed from: a */
    public boolean m6348a(File file, String str, List<String> list, C1585e c1585e) {
        return m6347a(file, str, list, true, c1585e);
    }

    /* renamed from: b */
    public void m6343b(Context context) {
        try {
            m6346a(".nomedia", context);
            File file = new File(m6337e(context), ".nomedia");
            if (file.exists()) {
                return;
            }
            C1710r c1710r = this.f2444c;
            c1710r.m6319b("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
            if (file.createNewFile()) {
                return;
            }
            this.f2444c.m6314e("FileManager", "Failed to create .nomedia file");
        } catch (IOException e) {
            this.f2444c.m6318b("FileManager", "Failed to create .nomedia file", e);
        }
    }

    /* renamed from: b */
    public boolean m6340b(String str, Context context) {
        boolean z;
        synchronized (this.f2445d) {
            File m6346a = m6346a(str, context);
            z = (m6346a == null || !m6346a.exists() || m6346a.isDirectory()) ? false : true;
        }
        return z;
    }
}
