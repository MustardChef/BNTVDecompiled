package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class ListenerHolder<L> {
    private final zabv zaa;
    private volatile L zab;
    private volatile ListenerKey<L> zac;

    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    /* loaded from: classes2.dex */
    public static final class ListenerKey<L> {
        private final L zaa;
        private final String zab;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ListenerKey(L l, String str) {
            this.zaa = l;
            this.zab = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ListenerKey) {
                ListenerKey listenerKey = (ListenerKey) obj;
                return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    /* loaded from: classes2.dex */
    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListenerHolder(Looper looper, L l, String str) {
        this.zaa = new zabv(this, looper);
        this.zab = (L) Preconditions.checkNotNull(l, "Listener must not be null");
        this.zac = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
    }

    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    public boolean hasListener() {
        return this.zab != null;
    }

    public void notifyListener(Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.sendMessage(this.zaa.obtainMessage(1, notifier));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyListenerInternal(Notifier<? super L> notifier) {
        Object obj = (L) this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }
}
