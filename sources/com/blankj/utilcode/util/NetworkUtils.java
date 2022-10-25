package com.blankj.utilcode.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.blankj.utilcode.util.ShellUtils;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class NetworkUtils {
    private static final int NETWORK_TYPE_GSM = 16;
    private static final int NETWORK_TYPE_IWLAN = 18;
    private static final int NETWORK_TYPE_TD_SCDMA = 17;

    /* loaded from: classes.dex */
    public enum NetworkType {
        NETWORK_WIFI,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    private NetworkUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static NetworkInfo getActiveNetworkInfo() {
        return ((ConnectivityManager) Utils.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static boolean getDataEnabled() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getContext().getSystemService("phone");
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("getDataEnabled", new Class[0]);
            if (declaredMethod != null) {
                return ((Boolean) declaredMethod.invoke(telephonyManager, new Object[0])).booleanValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getDomainAddress(final String str) {
        try {
            return (String) Executors.newCachedThreadPool().submit(new Callable<String>() { // from class: com.blankj.utilcode.util.NetworkUtils.1
                @Override // java.util.concurrent.Callable
                public String call() {
                    try {
                        return InetAddress.getByName(str).getHostAddress();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getIPAddress(boolean z) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (!nextElement2.isLoopbackAddress()) {
                            String hostAddress = nextElement2.getHostAddress();
                            boolean z2 = hostAddress.indexOf(58) < 0;
                            if (z) {
                                if (z2) {
                                    return hostAddress;
                                }
                            } else if (!z2) {
                                int indexOf = hostAddress.indexOf(37);
                                return indexOf < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, indexOf).toUpperCase();
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getNetworkOperatorName() {
        TelephonyManager telephonyManager = (TelephonyManager) Utils.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkOperatorName();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r0.equalsIgnoreCase("CDMA2000") == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.blankj.utilcode.util.NetworkUtils.NetworkType getNetworkType() {
        /*
            com.blankj.utilcode.util.NetworkUtils$NetworkType r0 = com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_NO
            android.net.NetworkInfo r1 = getActiveNetworkInfo()
            if (r1 == 0) goto L4d
            boolean r2 = r1.isAvailable()
            if (r2 == 0) goto L4d
            int r0 = r1.getType()
            r2 = 1
            if (r0 != r2) goto L18
            com.blankj.utilcode.util.NetworkUtils$NetworkType r0 = com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_WIFI
            goto L4d
        L18:
            int r0 = r1.getType()
            if (r0 != 0) goto L4b
            int r0 = r1.getSubtype()
            switch(r0) {
                case 1: goto L48;
                case 2: goto L48;
                case 3: goto L45;
                case 4: goto L48;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L48;
                case 8: goto L45;
                case 9: goto L45;
                case 10: goto L45;
                case 11: goto L48;
                case 12: goto L45;
                case 13: goto L42;
                case 14: goto L45;
                case 15: goto L45;
                case 16: goto L48;
                case 17: goto L45;
                case 18: goto L42;
                default: goto L25;
            }
        L25:
            java.lang.String r0 = r1.getSubtypeName()
            java.lang.String r1 = "TD-SCDMA"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L45
            java.lang.String r1 = "WCDMA"
            boolean r1 = r0.equalsIgnoreCase(r1)
            if (r1 != 0) goto L45
            java.lang.String r1 = "CDMA2000"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L4b
            goto L45
        L42:
            com.blankj.utilcode.util.NetworkUtils$NetworkType r0 = com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_4G
            goto L4d
        L45:
            com.blankj.utilcode.util.NetworkUtils$NetworkType r0 = com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_3G
            goto L4d
        L48:
            com.blankj.utilcode.util.NetworkUtils$NetworkType r0 = com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_2G
            goto L4d
        L4b:
            com.blankj.utilcode.util.NetworkUtils$NetworkType r0 = com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_UNKNOWN
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.NetworkUtils.getNetworkType():com.blankj.utilcode.util.NetworkUtils$NetworkType");
    }

    public static boolean getWifiEnabled() {
        return ((WifiManager) Utils.getContext().getSystemService("wifi")).isWifiEnabled();
    }

    public static boolean is4G() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getSubtype() == 13;
    }

    public static boolean isAvailableByPing() {
        ShellUtils.CommandResult execCmd = ShellUtils.execCmd("ping -c 1 -w 1 223.5.5.5", false);
        boolean z = execCmd.result == 0;
        if (execCmd.errorMsg != null) {
            LogUtils.m6080d("isAvailableByPing errorMsg", execCmd.errorMsg);
        }
        if (execCmd.successMsg != null) {
            LogUtils.m6080d("isAvailableByPing successMsg", execCmd.successMsg);
        }
        return z;
    }

    public static boolean isConnected() {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isWifiAvailable() {
        return getWifiEnabled() && isAvailableByPing();
    }

    public static boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Utils.getContext().getSystemService("connectivity");
        return (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null || connectivityManager.getActiveNetworkInfo().getType() != 1) ? false : true;
    }

    public static void openWirelessSettings() {
        Context context;
        Intent intent;
        if (Build.VERSION.SDK_INT > 10) {
            context = Utils.getContext();
            intent = new Intent("android.settings.WIRELESS_SETTINGS");
        } else {
            context = Utils.getContext();
            intent = new Intent("android.settings.SETTINGS");
        }
        context.startActivity(intent.setFlags(268435456));
    }

    public static void setDataEnabled(boolean z) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) Utils.getContext().getSystemService("phone");
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod("setDataEnabled", Boolean.TYPE);
            if (declaredMethod != null) {
                declaredMethod.invoke(telephonyManager, Boolean.valueOf(z));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setWifiEnabled(boolean z) {
        boolean z2;
        WifiManager wifiManager = (WifiManager) Utils.getContext().getSystemService("wifi");
        if (z) {
            if (wifiManager.isWifiEnabled()) {
                return;
            }
            z2 = true;
        } else if (!wifiManager.isWifiEnabled()) {
            return;
        } else {
            z2 = false;
        }
        wifiManager.setWifiEnabled(z2);
    }
}
