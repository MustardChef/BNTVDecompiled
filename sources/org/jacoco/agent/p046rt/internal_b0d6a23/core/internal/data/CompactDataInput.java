package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.data.CompactDataInput */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/data/CompactDataInput.class */
public class CompactDataInput extends DataInputStream {
    public CompactDataInput(InputStream in) {
        super(in);
    }

    public int readVarInt() throws IOException {
        int value = 255 & readByte();
        if ((value & 128) == 0) {
            return value;
        }
        return (value & 127) | (readVarInt() << 7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean[] readBooleanArray() throws IOException {
        boolean[] value = new boolean[readVarInt()];
        int buffer = 0;
        for (int i = 0; i < value.length; i++) {
            if (i % 8 == 0) {
                buffer = readByte();
            }
            value[i] = (buffer & 1) != 0;
            buffer >>>= 1;
        }
        return value;
    }
}
