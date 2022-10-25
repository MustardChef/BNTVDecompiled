package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PackageIdentityUtils {
    private static final String TAG = "PackageIdentity";

    /* loaded from: classes.dex */
    interface SignaturesCompat {
        List<byte[]> getFingerprintsForPackage(String name, PackageManager pm) throws PackageManager.NameNotFoundException;

        boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) throws IOException, PackageManager.NameNotFoundException;
    }

    private PackageIdentityUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<byte[]> getFingerprintsForPackage(String name, PackageManager pm) {
        try {
            return getImpl().getFingerprintsForPackage(name, pm);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not get fingerprint for package.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) {
        try {
            return getImpl().packageMatchesToken(name, pm, token);
        } catch (PackageManager.NameNotFoundException | IOException e) {
            Log.e(TAG, "Could not check if package matches token.", e);
            return false;
        }
    }

    private static SignaturesCompat getImpl() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new Api28Implementation();
        }
        return new Pre28Implementation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Implementation implements SignaturesCompat {
        Api28Implementation() {
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public List<byte[]> getFingerprintsForPackage(String name, PackageManager pm) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = pm.getPackageInfo(name, 134217728);
            ArrayList arrayList = new ArrayList();
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                for (Signature signature : signingInfo.getApkContentsSigners()) {
                    arrayList.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(signature));
                }
            } else {
                arrayList.add(PackageIdentityUtils.getCertificateSHA256Fingerprint(signingInfo.getSigningCertificateHistory()[0]));
            }
            return arrayList;
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) throws PackageManager.NameNotFoundException, IOException {
            List<byte[]> fingerprintsForPackage;
            if (token.getPackageName().equals(name) && (fingerprintsForPackage = getFingerprintsForPackage(name, pm)) != null) {
                if (fingerprintsForPackage.size() == 1) {
                    return pm.hasSigningCertificate(name, token.getFingerprint(0), 1);
                }
                return token.equals(TokenContents.create(name, fingerprintsForPackage));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Pre28Implementation implements SignaturesCompat {
        Pre28Implementation() {
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public List<byte[]> getFingerprintsForPackage(String name, PackageManager pm) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = pm.getPackageInfo(name, 64);
            ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                byte[] certificateSHA256Fingerprint = PackageIdentityUtils.getCertificateSHA256Fingerprint(signature);
                if (certificateSHA256Fingerprint == null) {
                    return null;
                }
                arrayList.add(certificateSHA256Fingerprint);
            }
            return arrayList;
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public boolean packageMatchesToken(String name, PackageManager pm, TokenContents token) throws IOException, PackageManager.NameNotFoundException {
            List<byte[]> fingerprintsForPackage;
            if (name.equals(token.getPackageName()) && (fingerprintsForPackage = getFingerprintsForPackage(name, pm)) != null) {
                return token.equals(TokenContents.create(name, fingerprintsForPackage));
            }
            return false;
        }
    }

    static byte[] getCertificateSHA256Fingerprint(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
