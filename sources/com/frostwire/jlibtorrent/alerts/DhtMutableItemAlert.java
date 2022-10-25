package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Entry;
import com.frostwire.jlibtorrent.Vectors;
import com.frostwire.jlibtorrent.swig.dht_mutable_item_alert;

/* loaded from: classes2.dex */
public final class DhtMutableItemAlert extends AbstractAlert<dht_mutable_item_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtMutableItemAlert(dht_mutable_item_alert dht_mutable_item_alertVar) {
        super(dht_mutable_item_alertVar);
    }

    public byte[] key() {
        return Vectors.byte_vector2bytes(((dht_mutable_item_alert) this.alert).get_key());
    }

    public byte[] signature() {
        return Vectors.byte_vector2bytes(((dht_mutable_item_alert) this.alert).get_signature());
    }

    public long seq() {
        return ((dht_mutable_item_alert) this.alert).get_seq();
    }

    public byte[] salt() {
        return Vectors.byte_vector2bytes(((dht_mutable_item_alert) this.alert).get_salt());
    }

    public Entry item() {
        return new Entry(((dht_mutable_item_alert) this.alert).getItem());
    }
}
