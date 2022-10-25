package com.frostwire.jlibtorrent.alerts;

import com.frostwire.jlibtorrent.Sha1Hash;
import com.frostwire.jlibtorrent.Vectors;
import com.frostwire.jlibtorrent.swig.dht_put_alert;

/* loaded from: classes2.dex */
public final class DhtPutAlert extends AbstractAlert<dht_put_alert> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhtPutAlert(dht_put_alert dht_put_alertVar) {
        super(dht_put_alertVar);
    }

    public Sha1Hash target() {
        return new Sha1Hash(((dht_put_alert) this.alert).getTarget());
    }

    public byte[] publicKey() {
        return Vectors.byte_vector2bytes(((dht_put_alert) this.alert).get_public_key());
    }

    public byte[] signature() {
        return Vectors.byte_vector2bytes(((dht_put_alert) this.alert).get_signature());
    }

    public byte[] salt() {
        return Vectors.byte_vector2bytes(((dht_put_alert) this.alert).get_salt());
    }

    public long seq() {
        return ((dht_put_alert) this.alert).get_seq();
    }
}
