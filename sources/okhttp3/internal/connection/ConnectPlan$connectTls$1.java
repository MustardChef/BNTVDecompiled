package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import okhttp3.Handshake;

/* compiled from: ConnectPlan.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class ConnectPlan$connectTls$1 extends Lambda implements Functions<List<? extends X509Certificate>> {
    final /* synthetic */ Handshake $handshake;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectPlan$connectTls$1(Handshake handshake) {
        super(0);
        this.$handshake = handshake;
    }

    @Override // kotlin.jvm.functions.Functions
    public final List<? extends X509Certificate> invoke() {
        List<Certificate> peerCertificates = this.$handshake.peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
