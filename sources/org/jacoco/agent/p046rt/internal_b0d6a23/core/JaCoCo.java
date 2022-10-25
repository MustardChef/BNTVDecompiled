package org.jacoco.agent.p046rt.internal_b0d6a23.core;

import java.util.ResourceBundle;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.JaCoCo */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/JaCoCo.class */
public final class JaCoCo {
    public static final String VERSION;
    public static final String HOMEURL;
    public static final String RUNTIMEPACKAGE;
    public static final int ASM_API_VERSION = 327680;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("org.jacoco.agent.rt.internal_b0d6a23.core.jacoco");
        VERSION = bundle.getString("VERSION");
        HOMEURL = bundle.getString("HOMEURL");
        RUNTIMEPACKAGE = bundle.getString("RUNTIMEPACKAGE");
    }

    private JaCoCo() {
    }
}
