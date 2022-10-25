package org.jacoco.agent.p046rt.internal_b0d6a23;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.data.CRC64;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.ClassFileDumper */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/ClassFileDumper.class */
class ClassFileDumper {
    private final File location;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClassFileDumper(String location) {
        if (location == null) {
            this.location = null;
        } else {
            this.location = new File(location);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(String name, byte[] contents) throws IOException {
        File outputdir;
        String localname;
        if (this.location != null) {
            int pkgpos = name.lastIndexOf(47);
            if (pkgpos != -1) {
                outputdir = new File(this.location, name.substring(0, pkgpos));
                localname = name.substring(pkgpos + 1);
            } else {
                outputdir = this.location;
                localname = name;
            }
            outputdir.mkdirs();
            Long id = Long.valueOf(CRC64.checksum(contents));
            File file = new File(outputdir, String.format("%s.%016x.class", localname, id));
            OutputStream out = new FileOutputStream(file);
            out.write(contents);
            out.close();
        }
    }
}
