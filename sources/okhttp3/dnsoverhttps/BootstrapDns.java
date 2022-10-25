package okhttp3.dnsoverhttps;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;

/* compiled from: BootstrapDns.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lokhttp3/dnsoverhttps/BootstrapDns;", "Lokhttp3/Dns;", "dnsHostname", "", "dnsServers", "", "Ljava/net/InetAddress;", "(Ljava/lang/String;Ljava/util/List;)V", "lookup", "hostname", "okhttp-dnsoverhttps"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class BootstrapDns implements Dns {
    private final String dnsHostname;
    private final List<InetAddress> dnsServers;

    /* JADX WARN: Multi-variable type inference failed */
    public BootstrapDns(String dnsHostname, List<? extends InetAddress> dnsServers) {
        Intrinsics.checkNotNullParameter(dnsHostname, "dnsHostname");
        Intrinsics.checkNotNullParameter(dnsServers, "dnsServers");
        this.dnsHostname = dnsHostname;
        this.dnsServers = dnsServers;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        if (!Intrinsics.areEqual(this.dnsHostname, hostname)) {
            throw new UnknownHostException("BootstrapDns called for " + hostname + " instead of " + this.dnsHostname);
        }
        return this.dnsServers;
    }
}
