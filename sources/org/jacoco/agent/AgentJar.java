package org.jacoco.agent;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes4.dex */
public final class AgentJar {
    private static final String RESOURCE = "/jacocoagent.jar";
    private static final String ERRORMSG = String.format("The resource %s has not been found. Please see /org.jacoco.agent/README.TXT for details.", RESOURCE);

    private AgentJar() {
    }

    public static URL getResource() {
        URL resource = AgentJar.class.getResource(RESOURCE);
        if (resource != null) {
            return resource;
        }
        throw new AssertionError(ERRORMSG);
    }

    public static InputStream getResourceAsStream() {
        InputStream resourceAsStream = AgentJar.class.getResourceAsStream(RESOURCE);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new AssertionError(ERRORMSG);
    }

    public static File extractToTempLocation() throws IOException {
        File createTempFile = File.createTempFile("jacocoagent", ".jar");
        createTempFile.deleteOnExit();
        extractTo(createTempFile);
        return createTempFile;
    }

    public static void extractTo(File file) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream resourceAsStream = getResourceAsStream();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = resourceAsStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    safeClose(resourceAsStream);
                    safeClose(fileOutputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            safeClose(resourceAsStream);
            safeClose(fileOutputStream2);
            throw th;
        }
    }

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
