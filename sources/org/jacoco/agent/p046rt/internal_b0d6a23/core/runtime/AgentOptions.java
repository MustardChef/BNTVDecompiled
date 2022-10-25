package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.AgentOptions */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/AgentOptions.class */
public final class AgentOptions {
    public static final String DEFAULT_DESTFILE = "jacoco.exec";
    public static final String ADDRESS = "address";
    public static final int DEFAULT_PORT = 6300;
    private final Map<String, String> options;
    public static final String DEFAULT_ADDRESS = null;
    public static final String DESTFILE = "destfile";
    public static final String APPEND = "append";
    public static final String INCLUDES = "includes";
    public static final String EXCLUDES = "excludes";
    public static final String EXCLCLASSLOADER = "exclclassloader";
    public static final String INCLBOOTSTRAPCLASSES = "inclbootstrapclasses";
    public static final String SESSIONID = "sessionid";
    public static final String DUMPONEXIT = "dumponexit";
    public static final String OUTPUT = "output";
    public static final String PORT = "port";
    public static final String CLASSDUMPDIR = "classdumpdir";
    public static final String JMX = "jmx";
    private static final Collection<String> VALID_OPTIONS = Arrays.asList(DESTFILE, APPEND, INCLUDES, EXCLUDES, EXCLCLASSLOADER, INCLBOOTSTRAPCLASSES, SESSIONID, DUMPONEXIT, OUTPUT, "address", PORT, CLASSDUMPDIR, JMX);

    /* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.AgentOptions$OutputMode */
    /* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/AgentOptions$OutputMode.class */
    public enum OutputMode {
        file,
        tcpserver,
        tcpclient,
        none
    }

    public AgentOptions() {
        this.options = new HashMap();
    }

    public AgentOptions(String optionstr) {
        this();
        if (optionstr != null && optionstr.length() > 0) {
            String[] arr$ = optionstr.split(",");
            for (String entry : arr$) {
                int pos = entry.indexOf(61);
                if (pos == -1) {
                    throw new IllegalArgumentException(String.format("Invalid agent option syntax \"%s\".", optionstr));
                }
                String key = entry.substring(0, pos);
                if (!VALID_OPTIONS.contains(key)) {
                    throw new IllegalArgumentException(String.format("Unknown agent option \"%s\".", key));
                }
                String value = entry.substring(pos + 1);
                setOption(key, value);
            }
            validateAll();
        }
    }

    public AgentOptions(Properties properties) {
        this();
        for (String key : VALID_OPTIONS) {
            String value = properties.getProperty(key);
            if (value != null) {
                setOption(key, value);
            }
        }
    }

    private void validateAll() {
        validatePort(getPort());
        getOutput();
    }

    private void validatePort(int port) {
        if (port < 0) {
            throw new IllegalArgumentException("port must be positive");
        }
    }

    public String getDestfile() {
        return getOption(DESTFILE, DEFAULT_DESTFILE);
    }

    public void setDestfile(String destfile) {
        setOption(DESTFILE, destfile);
    }

    public boolean getAppend() {
        return getOption(APPEND, true);
    }

    public void setAppend(boolean append) {
        setOption(APPEND, append);
    }

    public String getIncludes() {
        return getOption(INCLUDES, "*");
    }

    public void setIncludes(String includes) {
        setOption(INCLUDES, includes);
    }

    public String getExcludes() {
        return getOption(EXCLUDES, "");
    }

    public void setExcludes(String excludes) {
        setOption(EXCLUDES, excludes);
    }

    public String getExclClassloader() {
        return getOption(EXCLCLASSLOADER, "sun.reflect.DelegatingClassLoader");
    }

    public void setExclClassloader(String expression) {
        setOption(EXCLCLASSLOADER, expression);
    }

    public boolean getInclBootstrapClasses() {
        return getOption(INCLBOOTSTRAPCLASSES, false);
    }

    public void setInclBootstrapClasses(boolean include) {
        setOption(INCLBOOTSTRAPCLASSES, include);
    }

    public String getSessionId() {
        return getOption(SESSIONID, (String) null);
    }

    public void setSessionId(String id) {
        setOption(SESSIONID, id);
    }

    public boolean getDumpOnExit() {
        return getOption(DUMPONEXIT, true);
    }

    public void setDumpOnExit(boolean dumpOnExit) {
        setOption(DUMPONEXIT, dumpOnExit);
    }

    public int getPort() {
        return getOption(PORT, DEFAULT_PORT);
    }

    public void setPort(int port) {
        validatePort(port);
        setOption(PORT, port);
    }

    public String getAddress() {
        return getOption("address", DEFAULT_ADDRESS);
    }

    public void setAddress(String address) {
        setOption("address", address);
    }

    public OutputMode getOutput() {
        String value = this.options.get(OUTPUT);
        return value == null ? OutputMode.file : OutputMode.valueOf(value);
    }

    public void setOutput(String output) {
        setOutput(OutputMode.valueOf(output));
    }

    public void setOutput(OutputMode output) {
        setOption(OUTPUT, output.name());
    }

    public String getClassDumpDir() {
        return getOption(CLASSDUMPDIR, (String) null);
    }

    public void setClassDumpDir(String location) {
        setOption(CLASSDUMPDIR, location);
    }

    public boolean getJmx() {
        return getOption(JMX, false);
    }

    public void setJmx(boolean jmx) {
        setOption(JMX, jmx);
    }

    private void setOption(String key, int value) {
        setOption(key, Integer.toString(value));
    }

    private void setOption(String key, boolean value) {
        setOption(key, Boolean.toString(value));
    }

    private void setOption(String key, String value) {
        if (value.contains(",")) {
            throw new IllegalArgumentException(String.format("Invalid character in option argument \"%s\"", value));
        }
        this.options.put(key, value);
    }

    private String getOption(String key, String defaultValue) {
        String value = this.options.get(key);
        return value == null ? defaultValue : value;
    }

    private boolean getOption(String key, boolean defaultValue) {
        String value = this.options.get(key);
        return value == null ? defaultValue : Boolean.parseBoolean(value);
    }

    private int getOption(String key, int defaultValue) {
        String value = this.options.get(key);
        return value == null ? defaultValue : Integer.parseInt(value);
    }

    public String getVMArgument(File agentJarFile) {
        return String.format("-javaagent:%s=%s", agentJarFile, this);
    }

    public String getQuotedVMArgument(File agentJarFile) {
        return CommandLineSupport.quote(getVMArgument(agentJarFile));
    }

    public String prependVMArguments(String arguments, File agentJarFile) {
        List<String> args = CommandLineSupport.split(arguments);
        String plainAgent = String.format("-javaagent:%s", agentJarFile);
        Iterator<String> i = args.iterator();
        while (i.hasNext()) {
            if (i.next().startsWith(plainAgent)) {
                i.remove();
            }
        }
        args.add(0, getVMArgument(agentJarFile));
        return CommandLineSupport.quote(args);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : VALID_OPTIONS) {
            String value = this.options.get(key);
            if (value != null) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(key).append('=').append(value);
            }
        }
        return sb.toString();
    }
}
