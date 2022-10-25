package com.blankj.utilcode.util;

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import com.blankj.utilcode.util.ShellUtils;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Collections;

/* loaded from: classes.dex */
public final class DeviceUtils {
    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getAndroidID() {
        return Settings.Secure.getString(Utils.getContext().getContentResolver(), "android_id");
    }

    public static String getMacAddress() {
        String macAddressByWifiInfo = getMacAddressByWifiInfo();
        if ("02:00:00:00:00:00".equals(macAddressByWifiInfo)) {
            String macAddressByNetworkInterface = getMacAddressByNetworkInterface();
            if ("02:00:00:00:00:00".equals(macAddressByNetworkInterface)) {
                String macAddressByFile = getMacAddressByFile();
                return !"02:00:00:00:00:00".equals(macAddressByFile) ? macAddressByFile : "please open wifi";
            }
            return macAddressByNetworkInterface;
        }
        return macAddressByWifiInfo;
    }

    private static String getMacAddressByFile() {
        String str;
        ShellUtils.CommandResult execCmd = ShellUtils.execCmd("getprop wifi.interface", false);
        if (execCmd.result != 0 || (str = execCmd.successMsg) == null) {
            return "02:00:00:00:00:00";
        }
        ShellUtils.CommandResult execCmd2 = ShellUtils.execCmd("cat /sys/class/net/" + str + "/address", false);
        return (execCmd2.result != 0 || execCmd2.successMsg == null) ? "02:00:00:00:00:00" : execCmd2.successMsg;
    }

    private static String getMacAddressByNetworkInterface() {
        byte[] hardwareAddress;
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = networkInterface.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i])));
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    private static String getMacAddressByWifiInfo() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) Utils.getContext().getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "02:00:00:00:00:00" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        String str = Build.MODEL;
        return str != null ? str.trim().replaceAll("\\s*", "") : "";
    }

    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean isDeviceRooted() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/"};
        for (int i = 0; i < 8; i++) {
            String str = strArr[i];
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public static void reboot() {
        ShellUtils.execCmd("reboot", true);
        Intent intent = new Intent("android.intent.action.REBOOT");
        intent.putExtra("nowait", 1);
        intent.putExtra("interval", 1);
        intent.putExtra("window", 0);
        Utils.getContext().sendBroadcast(intent);
    }

    public static void reboot(String str) {
        try {
            ((PowerManager) Utils.getContext().getSystemService("power")).reboot(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reboot2Bootloader() {
        ShellUtils.execCmd("reboot bootloader", true);
    }

    public static void reboot2Recovery() {
        ShellUtils.execCmd("reboot recovery", true);
    }

    public static void shutdown() {
        ShellUtils.execCmd("reboot -p", true);
        Intent intent = new Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN");
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        intent.setFlags(268435456);
        Utils.getContext().startActivity(intent);
    }
}
