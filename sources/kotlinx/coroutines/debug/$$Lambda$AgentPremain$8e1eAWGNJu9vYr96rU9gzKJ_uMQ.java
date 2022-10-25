package kotlinx.coroutines.debug;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/* compiled from: lambda */
/* renamed from: kotlinx.coroutines.debug.-$$Lambda$AgentPremain$8e1eAWGNJu9vYr96rU9gzKJ_uMQ  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$AgentPremain$8e1eAWGNJu9vYr96rU9gzKJ_uMQ implements SignalHandler {
    public static final /* synthetic */ $$Lambda$AgentPremain$8e1eAWGNJu9vYr96rU9gzKJ_uMQ INSTANCE = new $$Lambda$AgentPremain$8e1eAWGNJu9vYr96rU9gzKJ_uMQ();

    private /* synthetic */ $$Lambda$AgentPremain$8e1eAWGNJu9vYr96rU9gzKJ_uMQ() {
    }

    public final void handle(Signal signal) {
        AgentPremain.m10537installSignalHandler$lambda1(signal);
    }
}
