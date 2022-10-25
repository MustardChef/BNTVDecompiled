package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.RtspMessageUtil;
import com.google.android.exoplayer2.util.Util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RtspAuthenticationInfo {
    private static final String ALGORITHM = "MD5";
    public static final int BASIC = 1;
    public static final int DIGEST = 2;
    private static final String DIGEST_FORMAT = "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\"";
    private static final String DIGEST_FORMAT_WITH_OPAQUE = "Digest username=\"%s\", realm=\"%s\", nonce=\"%s\", uri=\"%s\", response=\"%s\", opaque=\"%s\"";
    public final int authenticationMechanism;
    public final String nonce;
    public final String opaque;
    public final String realm;

    public RtspAuthenticationInfo(int i, String str, String str2, String str3) {
        this.authenticationMechanism = i;
        this.realm = str;
        this.nonce = str2;
        this.opaque = str3;
    }

    public String getAuthorizationHeaderValue(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, Uri uri, int i) throws ParserException {
        int i2 = this.authenticationMechanism;
        if (i2 != 1) {
            if (i2 == 2) {
                return getDigestAuthorizationHeaderValue(rtspAuthUserInfo, uri, i);
            }
            throw ParserException.createForManifestWithUnsupportedFeature(null, new UnsupportedOperationException());
        }
        return getBasicAuthorizationHeaderValue(rtspAuthUserInfo);
    }

    private String getBasicAuthorizationHeaderValue(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo) {
        String str = rtspAuthUserInfo.username;
        String str2 = rtspAuthUserInfo.password;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return Base64.encodeToString(RtspMessageUtil.getStringBytes(sb.toString()), 0);
    }

    private String getDigestAuthorizationHeaderValue(RtspMessageUtil.RtspAuthUserInfo rtspAuthUserInfo, Uri uri, int i) throws ParserException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            String methodString = RtspMessageUtil.toMethodString(i);
            String str = rtspAuthUserInfo.username;
            String str2 = this.realm;
            String str3 = rtspAuthUserInfo.password;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            String hexString = Util.toHexString(messageDigest.digest(RtspMessageUtil.getStringBytes(sb.toString())));
            String valueOf = String.valueOf(uri);
            StringBuilder sb2 = new StringBuilder(String.valueOf(methodString).length() + 1 + String.valueOf(valueOf).length());
            sb2.append(methodString);
            sb2.append(":");
            sb2.append(valueOf);
            String hexString2 = Util.toHexString(messageDigest.digest(RtspMessageUtil.getStringBytes(sb2.toString())));
            String str4 = this.nonce;
            StringBuilder sb3 = new StringBuilder(String.valueOf(hexString).length() + 2 + String.valueOf(str4).length() + String.valueOf(hexString2).length());
            sb3.append(hexString);
            sb3.append(":");
            sb3.append(str4);
            sb3.append(":");
            sb3.append(hexString2);
            String hexString3 = Util.toHexString(messageDigest.digest(RtspMessageUtil.getStringBytes(sb3.toString())));
            return this.opaque.isEmpty() ? Util.formatInvariant(DIGEST_FORMAT, rtspAuthUserInfo.username, this.realm, this.nonce, uri, hexString3) : Util.formatInvariant(DIGEST_FORMAT_WITH_OPAQUE, rtspAuthUserInfo.username, this.realm, this.nonce, uri, hexString3, this.opaque);
        } catch (NoSuchAlgorithmException e) {
            throw ParserException.createForManifestWithUnsupportedFeature(null, e);
        }
    }
}
