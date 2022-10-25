package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.string_int_pair;
import com.frostwire.jlibtorrent.swig.string_string_pair;

/* loaded from: classes2.dex */
public final class Pair<T1, T2> {
    public final T1 first;
    public final T2 second;

    public Pair(T1 t1, T2 t2) {
        this.first = t1;
        this.second = t2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public string_string_pair to_string_string_pair() {
        if (!String.class.equals(this.first.getClass()) || !String.class.equals(this.second.getClass())) {
            throw new IllegalArgumentException("Incompatible types");
        }
        return new string_string_pair((String) this.first, (String) this.second);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public string_int_pair to_string_int_pair() {
        if (!String.class.equals(this.first.getClass()) || !Integer.class.equals(this.second.getClass())) {
            throw new IllegalArgumentException("Incompatible types");
        }
        return new string_int_pair((String) this.first, ((Integer) this.second).intValue());
    }
}
