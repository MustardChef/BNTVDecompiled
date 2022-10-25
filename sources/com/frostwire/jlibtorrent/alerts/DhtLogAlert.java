package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.swig.dht_log_alert;

/* loaded from: classes2.dex */
public final class DhtLogAlert extends AbstractAlert<dht_log_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtLogAlert(dht_log_alert dht_log_alertVar) {
        super(dht_log_alertVar);
    }

    public String logMessage() {
        return ((dht_log_alert) this.alert).log_message();
    }

    public DhtModule module() {
        return DhtModule.fromSwig(((dht_log_alert) this.alert).getModule().swigValue());
    }

    /* loaded from: classes2.dex */
    public enum DhtModule {
        TRACKER(dht_log_alert.dht_module_t.tracker.swigValue()),
        NODE(dht_log_alert.dht_module_t.node.swigValue()),
        ROUTING_TABLE(dht_log_alert.dht_module_t.routing_table.swigValue()),
        RPC_MANAGER(dht_log_alert.dht_module_t.rpc_manager.swigValue()),
        TRAVERSAL(dht_log_alert.dht_module_t.traversal.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        DhtModule(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static DhtModule fromSwig(int i) {
            DhtModule[] dhtModuleArr;
            for (DhtModule dhtModule : (DhtModule[]) DhtModule.class.getEnumConstants()) {
                if (dhtModule.swig() == i) {
                    return dhtModule;
                }
            }
            return UNKNOWN;
        }
    }
}
