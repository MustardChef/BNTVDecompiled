package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzgl implements zzou {
    ERROR_UNKNOWN(0),
    ERROR_PEER_DISCONNECTED(1),
    ERROR_IO(2),
    ERROR_SSL(3),
    ERROR_TIMEOUT(4),
    ERROR_RELAY(5),
    ERROR_DEVICE_AUTH(6),
    ERROR_DEVICE_AUTH_ERROR_RECEIVED(7),
    ERROR_DEVICE_AUTH_CLIENT_AUTH_CERT_MALFORMED(8),
    ERROR_DEVICE_AUTH_CLIENT_AUTH_CERT_NOT_X509(9),
    ERROR_DEVICE_AUTH_CLIENT_AUTH_CERT_NOT_TRUSTED(10),
    ERROR_DEVICE_AUTH_SSL_CERT_NOT_TRUSTED(11),
    ERROR_DEVICE_AUTH_RESPONSE_MALFORMED(12),
    ERROR_CANCELED(13),
    ERROR_CAST_NEARBY_INVALID_REQUEST(14),
    ERROR_CANCELLED(15),
    ERROR_CRL_INVALID(16),
    ERROR_CRL_REVOCATION_CHECK_FAILED(17),
    ERROR_DEVICE_AUTH_TIMEOUT(18),
    ERROR_DEVICE_AUTH_PARSE_FAILURE(19),
    ERROR_DEVICE_AUTH_CHALLENGE_RECEIVED(20),
    ERROR_RELAY_CASTING_DISABLED(21),
    ERROR_RELAY_CASTING_NO_ACCOUNT_CONFIGURED(22),
    ERROR_RELAY_CASTING_DEVICE_NOT_FOUND_ON_LOCAL_NETWORK(23),
    ERROR_RELAY_CASTING_GRPC_SERVER_ERROR(24),
    ERROR_RELAY_CASTING_INVALID_SERVER_RESPONSE(25),
    ERROR_RELAY_CASTING_SOCKET_CONNECT_EXCEPTION(26),
    ERROR_RELAY_CASTING_RAT_MISSING(27),
    ERROR_RELAY_CASTING_RAT_INVALID(28),
    ERROR_RELAY_CASTING_SERVER_RESPONSE_HAS_NO_SESSION(29),
    ERROR_RELAY_CASTING_INVALID_SERVER_ADDRESS(30),
    ERROR_RELAY_CASTING_DEVICE_NOT_LINKED_TO_USER(31),
    ERROR_RELAY_CASTING_DEVICE_NOT_SUPPORTED(32),
    ERROR_RELAY_CASTING_DEVICE_CERTIFICATE_ABSENT(33),
    ERROR_RELAY_CASTING_FAILED_TO_COMMUNICATE_DEVICE(34),
    ERROR_RELAY_CASTING_RAT_REJECTED_BY_SERVER(35),
    ERROR_RELAY_CASTING_CLOUD_DEVICE_ID_NOT_FOUND(36),
    ERROR_RELAY_CASTING_SERVER_ERROR_UNKNOWN(37),
    ERROR_RELAY_CASTING_DEVICE_AUTHENTICATION_FAILURE(38),
    ERROR_RELAY_CASTING_PEER_PK_HASH_ABSENT(39),
    ERROR_HASH_SIG_ALGORITHM_STRING_GENERATION_ERROR(40),
    ERROR_RELAY_CASTING_DEVICE_PUBLISHED_AS_LOCAL(41),
    ERROR_RELAY_CASTING_DEVICE_PUBLISHED_AS_CLOUD(42),
    ERROR_RELAY_CASTING_DISABLED_BY_OWNER(43),
    ERROR_RELAY_CASTING_NO_ACCOUNT_LINKED(44),
    ERROR_RELAY_CASTING_TARGET_DEVICE_NOT_ELIGIBLE_FOR_REMOTE_CASTING(45),
    ERROR_OTHER(99);
    
    private static final zzov<zzgl> zzV = new zzov<zzgl>() { // from class: com.google.android.gms.internal.cast.zzgj
    };
    private final int zzW;

    zzgl(int i) {
        this.zzW = i;
    }

    public static zzow zza() {
        return zzgk.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzW + " name=" + name() + Typography.greater;
    }
}
