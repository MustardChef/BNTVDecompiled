package okhttp3.internal.connection;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilCommonKt;

@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0004"}, m107d2 = {"reorderForHappyEyeballs", "", "Ljava/net/InetAddress;", "addresses", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: okhttp3.internal.connection.InetAddressOrderKt */
/* loaded from: classes4.dex */
public final class InetAddressOrder {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<InetAddress> reorderForHappyEyeballs(List<? extends InetAddress> addresses) {
        Intrinsics.checkNotNullParameter(addresses, "addresses");
        if (addresses.size() < 2) {
            return addresses;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : addresses) {
            if (((InetAddress) obj) instanceof Inet6Address) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Tuples tuples = new Tuples(arrayList, arrayList2);
        List list = (List) tuples.component1();
        List list2 = (List) tuples.component2();
        return (list.isEmpty() || list2.isEmpty()) ? addresses : _UtilCommonKt.interleave(list, list2);
    }
}
