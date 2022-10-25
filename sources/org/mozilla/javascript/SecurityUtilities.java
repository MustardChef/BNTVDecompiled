package org.mozilla.javascript;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

/* loaded from: classes5.dex */
public class SecurityUtilities {
    public static String getSystemProperty(final String str) {
        return (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: org.mozilla.javascript.SecurityUtilities.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.getProperty(str);
            }
        });
    }

    public static ProtectionDomain getProtectionDomain(final Class<?> cls) {
        return (ProtectionDomain) AccessController.doPrivileged(new PrivilegedAction<ProtectionDomain>() { // from class: org.mozilla.javascript.SecurityUtilities.2
            @Override // java.security.PrivilegedAction
            public ProtectionDomain run() {
                return cls.getProtectionDomain();
            }
        });
    }

    public static ProtectionDomain getScriptProtectionDomain() {
        final SecurityManager securityManager = System.getSecurityManager();
        if (securityManager instanceof RhinoSecurityManager) {
            return (ProtectionDomain) AccessController.doPrivileged(new PrivilegedAction<ProtectionDomain>() { // from class: org.mozilla.javascript.SecurityUtilities.3
                @Override // java.security.PrivilegedAction
                public ProtectionDomain run() {
                    Class currentScriptClass = ((RhinoSecurityManager) securityManager).getCurrentScriptClass();
                    if (currentScriptClass == null) {
                        return null;
                    }
                    return currentScriptClass.getProtectionDomain();
                }
            });
        }
        return null;
    }
}
