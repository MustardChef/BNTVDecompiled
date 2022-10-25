package kotlinx.coroutines.sync;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mutex.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u0010\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lkotlinx/coroutines/sync/Empty;", "", TvContractCompat.Channels.COLUMN_LOCKED, "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Empty {
    public final Object locked;

    public Empty(Object obj) {
        this.locked = obj;
    }

    public String toString() {
        return "Empty[" + this.locked + ']';
    }
}
