package com.hippo.unifile;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.anggrayudi.storage.file.MimeType;
import com.fasterxml.jackson.core.JsonPointer;

/* loaded from: classes3.dex */
class Utils {
    private Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getTypeForName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1).toLowerCase());
            return !TextUtils.isEmpty(mimeTypeFromExtension) ? mimeTypeFromExtension : MimeType.BINARY_FILE;
        }
        return MimeType.BINARY_FILE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String normalize(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '/' || c != '/') {
                charArray[i2] = c2;
                i2++;
            }
            i++;
            c = c2;
        }
        if (c == '/' && length > 1) {
            i2--;
        }
        return i2 != length ? new String(charArray, 0, i2) : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String resolve(String str, String str2) {
        if (str2.length() == 0 || str2.equals("/")) {
            return str;
        }
        if (str2.charAt(0) == '/') {
            if (str.equals("/")) {
                return str2;
            }
            return str + str2;
        } else if (str.equals("/")) {
            return str + str2;
        } else {
            return str + JsonPointer.SEPARATOR + str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equals(String str, String str2, boolean z) {
        if (z) {
            return str.equalsIgnoreCase(str2);
        }
        return str.equals(str2);
    }
}
