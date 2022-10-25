package org.jacoco.agent.p046rt.internal_b0d6a23;

import com.fasterxml.jackson.core.JsonPointer;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.instr.Instrumenter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRuntime;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.WildcardMatcher;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.CoverageTransformer */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/CoverageTransformer.class */
public class CoverageTransformer implements ClassFileTransformer {
    private static final String AGENT_PREFIX;
    private final Instrumenter instrumenter;
    private final IExceptionLogger logger;
    private final WildcardMatcher includes;
    private final WildcardMatcher excludes;
    private final WildcardMatcher exclClassloader;
    private final ClassFileDumper classFileDumper;
    private final boolean includeBootstrapClasses;

    static {
        String name = CoverageTransformer.class.getName();
        AGENT_PREFIX = toVMName(name.substring(0, name.lastIndexOf(46)));
    }

    public CoverageTransformer(IRuntime runtime, AgentOptions options, IExceptionLogger logger) {
        this.instrumenter = new Instrumenter(runtime);
        this.logger = logger;
        this.includes = new WildcardMatcher(toVMName(options.getIncludes()));
        this.excludes = new WildcardMatcher(toVMName(options.getExcludes()));
        this.exclClassloader = new WildcardMatcher(options.getExclClassloader());
        this.classFileDumper = new ClassFileDumper(options.getClassDumpDir());
        this.includeBootstrapClasses = options.getInclBootstrapClasses();
    }

    public byte[] transform(ClassLoader loader, String classname, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (classBeingRedefined != null) {
            return null;
        }
        if ((loader != null && !hasSourceLocation(protectionDomain)) || !filter(loader, classname)) {
            return null;
        }
        try {
            this.classFileDumper.dump(classname, classfileBuffer);
            return this.instrumenter.instrument(classfileBuffer, classname);
        } catch (Exception ex) {
            Exception illegalClassFormatException = new IllegalClassFormatException(ex.getMessage());
            illegalClassFormatException.initCause(ex);
            this.logger.logExeption(illegalClassFormatException);
            throw illegalClassFormatException;
        }
    }

    boolean hasSourceLocation(ProtectionDomain protectionDomain) {
        CodeSource codeSource;
        return (protectionDomain == null || (codeSource = protectionDomain.getCodeSource()) == null || codeSource.getLocation() == null) ? false : true;
    }

    boolean filter(ClassLoader loader, String classname) {
        if (loader == null) {
            if (!this.includeBootstrapClasses) {
                return false;
            }
        } else if (this.exclClassloader.matches(loader.getClass().getName())) {
            return false;
        }
        return (classname.startsWith(AGENT_PREFIX) || !this.includes.matches(classname) || this.excludes.matches(classname)) ? false : true;
    }

    private static String toVMName(String srcName) {
        return srcName.replace('.', JsonPointer.SEPARATOR);
    }
}
