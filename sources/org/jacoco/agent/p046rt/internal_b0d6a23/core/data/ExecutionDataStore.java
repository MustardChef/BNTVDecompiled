package org.jacoco.agent.p046rt.internal_b0d6a23.core.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.data.ExecutionDataStore */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/data/ExecutionDataStore.class */
public final class ExecutionDataStore implements IExecutionDataVisitor {
    private final Map<Long, ExecutionData> entries = new HashMap();
    private final Set<String> names = new HashSet();

    public void put(ExecutionData data) throws IllegalStateException {
        Long id = Long.valueOf(data.getId());
        ExecutionData entry = this.entries.get(id);
        if (entry == null) {
            this.entries.put(id, data);
            this.names.add(data.getName());
            return;
        }
        entry.merge(data);
    }

    public void subtract(ExecutionData data) throws IllegalStateException {
        Long id = Long.valueOf(data.getId());
        ExecutionData entry = this.entries.get(id);
        if (entry != null) {
            entry.merge(data, false);
        }
    }

    public void subtract(ExecutionDataStore store) {
        for (ExecutionData data : store.getContents()) {
            subtract(data);
        }
    }

    public ExecutionData get(long id) {
        return this.entries.get(Long.valueOf(id));
    }

    public boolean contains(String name) {
        return this.names.contains(name);
    }

    public ExecutionData get(Long id, String name, int probecount) {
        ExecutionData entry = this.entries.get(id);
        if (entry == null) {
            entry = new ExecutionData(id.longValue(), name, probecount);
            this.entries.put(id, entry);
            this.names.add(name);
        } else {
            entry.assertCompatibility(id.longValue(), name, probecount);
        }
        return entry;
    }

    public void reset() {
        for (ExecutionData executionData : this.entries.values()) {
            executionData.reset();
        }
    }

    public Collection<ExecutionData> getContents() {
        return this.entries.values();
    }

    public void accept(IExecutionDataVisitor visitor) {
        for (ExecutionData data : this.entries.values()) {
            visitor.visitClassExecution(data);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.data.IExecutionDataVisitor
    public void visitClassExecution(ExecutionData data) {
        put(data);
    }
}
