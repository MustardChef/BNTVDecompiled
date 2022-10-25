package org.jacoco.agent.p046rt.internal_b0d6a23.core.data;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.data.SessionInfo */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/data/SessionInfo.class */
public class SessionInfo implements Comparable<SessionInfo> {

    /* renamed from: id */
    private final String f10706id;
    private final long start;
    private final long dump;

    public SessionInfo(String id, long start, long dump) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        this.f10706id = id;
        this.start = start;
        this.dump = dump;
    }

    public String getId() {
        return this.f10706id;
    }

    public long getStartTimeStamp() {
        return this.start;
    }

    public long getDumpTimeStamp() {
        return this.dump;
    }

    @Override // java.lang.Comparable
    public int compareTo(SessionInfo other) {
        if (this.dump < other.dump) {
            return -1;
        }
        if (this.dump > other.dump) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        return "SessionInfo[" + this.f10706id + "]";
    }
}
