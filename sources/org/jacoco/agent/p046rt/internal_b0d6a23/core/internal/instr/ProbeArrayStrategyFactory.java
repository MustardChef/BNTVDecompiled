package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassReader;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.data.CRC64;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesAdapter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.ProbeArrayStrategyFactory */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/ProbeArrayStrategyFactory.class */
public final class ProbeArrayStrategyFactory {
    private ProbeArrayStrategyFactory() {
    }

    public static IProbeArrayStrategy createFor(ClassReader reader, IExecutionDataAccessorGenerator accessorGenerator) {
        String className = reader.getClassName();
        int version = getVersion(reader);
        long classId = CRC64.checksum(reader.f10696b);
        boolean withFrames = version >= 50;
        if (isInterface(reader)) {
            ProbeCounter counter = getProbeCounter(reader);
            if (counter.getCount() == 0) {
                return new NoneProbeArrayStrategy();
            }
            if (version >= 52 && counter.hasMethods()) {
                return new FieldProbeArrayStrategy(className, classId, withFrames, InstrSupport.DATAFIELD_INTF_ACC, accessorGenerator);
            }
            return new LocalProbeArrayStrategy(className, classId, counter.getCount(), accessorGenerator);
        }
        return new FieldProbeArrayStrategy(className, classId, withFrames, InstrSupport.DATAFIELD_ACC, accessorGenerator);
    }

    private static boolean isInterface(ClassReader reader) {
        return (reader.getAccess() & 512) != 0;
    }

    private static int getVersion(ClassReader reader) {
        return reader.readShort(6);
    }

    private static ProbeCounter getProbeCounter(ClassReader reader) {
        ProbeCounter counter = new ProbeCounter();
        reader.accept(new ClassProbesAdapter(counter, false), 0);
        return counter;
    }
}
