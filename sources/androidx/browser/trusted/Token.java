package androidx.browser.trusted;

import android.content.pm.PackageManager;
import android.util.Log;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class Token {
    private static final String TAG = "Token";
    private final TokenContents mContents;

    public static Token create(String packageName, PackageManager packageManager) {
        List<byte[]> fingerprintsForPackage = PackageIdentityUtils.getFingerprintsForPackage(packageName, packageManager);
        if (fingerprintsForPackage == null) {
            return null;
        }
        try {
            return new Token(TokenContents.create(packageName, fingerprintsForPackage));
        } catch (IOException e) {
            Log.e(TAG, "Exception when creating token.", e);
            return null;
        }
    }

    public static Token deserialize(byte[] serialized) {
        return new Token(TokenContents.deserialize(serialized));
    }

    private Token(TokenContents contents) {
        this.mContents = contents;
    }

    public byte[] serialize() {
        return this.mContents.serialize();
    }

    public boolean matches(String packageName, PackageManager packageManager) {
        return PackageIdentityUtils.packageMatchesToken(packageName, packageManager, this.mContents);
    }
}
