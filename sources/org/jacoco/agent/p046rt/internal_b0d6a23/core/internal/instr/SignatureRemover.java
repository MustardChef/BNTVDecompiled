package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.SignatureRemover */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/SignatureRemover.class */
public class SignatureRemover {
    private static final Pattern SIGNATURE_FILES = Pattern.compile("META-INF/[^/]*\\.SF|META-INF/[^/]*\\.DSA|META-INF/[^/]*\\.RSA|META-INF/SIG-[^/]*");
    private static final String MANIFEST_MF = "META-INF/MANIFEST.MF";
    private static final String DIGEST_SUFFIX = "-Digest";
    private boolean active = true;

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean removeEntry(String name) {
        return this.active && SIGNATURE_FILES.matcher(name).matches();
    }

    public boolean filterEntry(String name, InputStream in, OutputStream out) throws IOException {
        if (!this.active || !MANIFEST_MF.equals(name)) {
            return false;
        }
        Manifest mf = new Manifest(in);
        filterManifestEntry(mf.getEntries().values());
        mf.write(out);
        return true;
    }

    private void filterManifestEntry(Collection<Attributes> entry) {
        Iterator<Attributes> i = entry.iterator();
        while (i.hasNext()) {
            Attributes attributes = i.next();
            filterManifestEntryAttributes(attributes);
            if (attributes.isEmpty()) {
                i.remove();
            }
        }
    }

    private void filterManifestEntryAttributes(Attributes attrs) {
        Iterator<Object> i = attrs.keySet().iterator();
        while (i.hasNext()) {
            if (String.valueOf(i.next()).endsWith(DIGEST_SUFFIX)) {
                i.remove();
            }
        }
    }
}
