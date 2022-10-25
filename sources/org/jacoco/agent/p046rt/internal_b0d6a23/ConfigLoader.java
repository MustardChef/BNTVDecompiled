package org.jacoco.agent.p046rt.internal_b0d6a23;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.ConfigLoader */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/ConfigLoader.class */
final class ConfigLoader {
    private static final String SYS_PREFIX = "jacoco-agent.";
    private static final Pattern SUBST_PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Properties load(String resource, Properties system) {
        Properties result = new Properties();
        loadResource(resource, result);
        loadSystemProperties(system, result);
        substSystemProperties(result, system);
        return result;
    }

    private static void loadResource(String resource, Properties result) {
        InputStream file = Offline.class.getResourceAsStream(resource);
        if (file != null) {
            try {
                result.load(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void loadSystemProperties(Properties system, Properties result) {
        for (Map.Entry<Object, Object> entry : system.entrySet()) {
            String keystr = entry.getKey().toString();
            if (keystr.startsWith(SYS_PREFIX)) {
                result.put(keystr.substring(SYS_PREFIX.length()), entry.getValue());
            }
        }
    }

    private static void substSystemProperties(Properties result, Properties system) {
        int pos;
        for (Map.Entry<Object, Object> entry : result.entrySet()) {
            String oldValue = (String) entry.getValue();
            StringBuilder newValue = new StringBuilder();
            Matcher m = SUBST_PATTERN.matcher(oldValue);
            int i = 0;
            while (true) {
                pos = i;
                if (m.find()) {
                    newValue.append(oldValue.substring(pos, m.start()));
                    String sub = system.getProperty(m.group(1));
                    newValue.append(sub == null ? m.group(0) : sub);
                    i = m.end();
                }
            }
            newValue.append(oldValue.substring(pos));
            entry.setValue(newValue.toString());
        }
    }

    private ConfigLoader() {
    }
}
