package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;

/* loaded from: classes.dex */
public class SensitiveUserDataUtils {
    public static boolean isSensitiveUserData(View view) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (!isPassword(textView) && !isCreditCard(textView) && !isPersonName(textView) && !isPostalAddress(textView) && !isPhoneNumber(textView)) {
                    if (!isEmail(textView)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }

    private static boolean isPassword(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }

    private static boolean isEmail(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            if (textView.getInputType() == 32) {
                return true;
            }
            String textOfView = ViewHierarchy.getTextOfView(textView);
            if (textOfView != null && textOfView.length() != 0) {
                return Patterns.EMAIL_ADDRESS.matcher(textOfView).matches();
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }

    private static boolean isPersonName(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            return textView.getInputType() == 96;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }

    private static boolean isPostalAddress(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            return textView.getInputType() == 112;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }

    private static boolean isPhoneNumber(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            return textView.getInputType() == 3;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }

    private static boolean isCreditCard(TextView textView) {
        if (CrashShieldHandler.isObjectCrashing(SensitiveUserDataUtils.class)) {
            return false;
        }
        try {
            String replaceAll = ViewHierarchy.getTextOfView(textView).replaceAll("\\s", "");
            int length = replaceAll.length();
            if (length >= 12 && length <= 19) {
                int i = 0;
                boolean z = false;
                for (int i2 = length - 1; i2 >= 0; i2--) {
                    char charAt = replaceAll.charAt(i2);
                    if (charAt >= '0' && charAt <= '9') {
                        int i3 = charAt - '0';
                        if (z && (i3 = i3 * 2) > 9) {
                            i3 = (i3 % 10) + 1;
                        }
                        i += i3;
                        z = !z;
                    }
                    return false;
                }
                return i % 10 == 0;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SensitiveUserDataUtils.class);
            return false;
        }
    }
}
