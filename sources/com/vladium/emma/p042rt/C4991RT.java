package com.vladium.emma.p042rt;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p046rt.C5380RT;

@Deprecated
/* renamed from: com.vladium.emma.rt.RT */
/* loaded from: 5.6.84.apk:jacocoagent.jar:com/vladium/emma/rt/RT.class */
public final class C4991RT {
    private C4991RT() {
    }

    public static void dumpCoverageData(File outFile, boolean merge, boolean stopDataCollection) throws IOException {
        OutputStream out = new FileOutputStream(outFile, merge);
        try {
            out.write(C5380RT.getAgent().getExecutionData(false));
            out.close();
        } catch (Throwable th) {
            out.close();
            throw th;
        }
    }

    public static synchronized void dumpCoverageData(File outFile, boolean stopDataCollection) throws IOException {
        dumpCoverageData(outFile, true, stopDataCollection);
    }
}
