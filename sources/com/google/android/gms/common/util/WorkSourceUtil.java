package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(2:2|3)|4|(18:42|43|7|8|9|10|11|12|13|(9:34|35|16|(6:29|30|19|(2:24|25)|21|22)|18|19|(0)|21|22)|15|16|(0)|18|19|(0)|21|22)|6|7|8|9|10|11|12|13|(0)|15|16|(0)|18|19|(0)|21|22) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "add"
            int r1 = android.os.Process.myUid()
            com.google.android.gms.common.util.WorkSourceUtil.zza = r1
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L18
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L18
            r4[r2] = r5     // Catch: java.lang.Exception -> L18
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.reflect.Method r4 = r5.getMethod(r0, r4)     // Catch: java.lang.Exception -> L18
            goto L19
        L18:
            r4 = r3
        L19:
            com.google.android.gms.common.util.WorkSourceUtil.zzb = r4
            boolean r4 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r5 = 2
            if (r4 == 0) goto L33
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L33
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L33
            r4[r2] = r6     // Catch: java.lang.Exception -> L33
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r1] = r6     // Catch: java.lang.Exception -> L33
            java.lang.Class<android.os.WorkSource> r6 = android.os.WorkSource.class
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch: java.lang.Exception -> L33
            goto L34
        L33:
            r0 = r3
        L34:
            com.google.android.gms.common.util.WorkSourceUtil.zzc = r0
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r4 = "size"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L41
            java.lang.reflect.Method r0 = r0.getMethod(r4, r6)     // Catch: java.lang.Exception -> L41
            goto L42
        L41:
            r0 = r3
        L42:
            com.google.android.gms.common.util.WorkSourceUtil.zzd = r0
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L53
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L53
            r0[r2] = r4     // Catch: java.lang.Exception -> L53
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "get"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch: java.lang.Exception -> L53
            goto L54
        L53:
            r0 = r3
        L54:
            com.google.android.gms.common.util.WorkSourceUtil.zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L6b
            java.lang.Class[] r0 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L6b
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L6b
            r0[r2] = r4     // Catch: java.lang.Exception -> L6b
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            java.lang.String r6 = "getName"
            java.lang.reflect.Method r0 = r4.getMethod(r6, r0)     // Catch: java.lang.Exception -> L6b
            goto L6c
        L6b:
            r0 = r3
        L6c:
            com.google.android.gms.common.util.WorkSourceUtil.zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r4 = "WorkSourceUtil"
            if (r0 == 0) goto L87
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r6 = "createWorkChain"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L81
            java.lang.reflect.Method r0 = r0.getMethod(r6, r7)     // Catch: java.lang.Exception -> L81
            goto L88
        L81:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r4, r6, r0)
        L87:
            r0 = r3
        L88:
            com.google.android.gms.common.util.WorkSourceUtil.zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto Lad
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> La7
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> La7
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> La7
            r5[r2] = r6     // Catch: java.lang.Exception -> La7
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            r5[r1] = r2     // Catch: java.lang.Exception -> La7
            java.lang.String r1 = "addNode"
            java.lang.reflect.Method r3 = r0.getMethod(r1, r5)     // Catch: java.lang.Exception -> La7
            goto Lad
        La7:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r4, r1, r0)
        Lad:
            com.google.android.gms.common.util.WorkSourceUtil.zzh = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    public static WorkSource fromPackage(Context context, String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                int i = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                zza(workSource, i, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
            }
        }
        return null;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", str.length() != 0 ? "Could not get applicationInfo from package: ".concat(str) : new String("Could not get applicationInfo from package: "));
            } else {
                i = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", str.length() != 0 ? "Could not find package: ".concat(str) : new String("Could not find package: "));
        }
        if (i < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            zza(workSource, i, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i2 = zza;
                if (i != i2) {
                    method.invoke(invoke, Integer.valueOf(i), str);
                }
                method.invoke(invoke, Integer.valueOf(i2), str2);
            } catch (Exception e) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
            }
        }
        return workSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> getNames(android.os.WorkSource r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = "Unable to assign blame through WorkSource"
            java.lang.String r2 = "WorkSourceUtil"
            r3 = 0
            if (r10 != 0) goto Le
        Lc:
            r4 = 0
            goto L27
        Le:
            java.lang.reflect.Method r4 = com.google.android.gms.common.util.WorkSourceUtil.zzd
            if (r4 == 0) goto Lc
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L22
            java.lang.Object r4 = r4.invoke(r10, r5)     // Catch: java.lang.Exception -> L22
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch: java.lang.Exception -> L22
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Exception -> L22
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> L22
            goto L27
        L22:
            r4 = move-exception
            android.util.Log.wtf(r2, r1, r4)
            goto Lc
        L27:
            if (r4 == 0) goto L55
            r5 = 0
        L2a:
            if (r5 >= r4) goto L55
            java.lang.reflect.Method r6 = com.google.android.gms.common.util.WorkSourceUtil.zzf
            r7 = 0
            if (r6 == 0) goto L46
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Exception -> L42
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L42
            r8[r3] = r9     // Catch: java.lang.Exception -> L42
            java.lang.Object r6 = r6.invoke(r10, r8)     // Catch: java.lang.Exception -> L42
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L42
            r7 = r6
            goto L46
        L42:
            r6 = move-exception
            android.util.Log.wtf(r2, r1, r6)
        L46:
            boolean r6 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r7)
            if (r6 != 0) goto L52
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            r0.add(r7)
        L52:
            int r5 = r5 + 1
            goto L2a
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.getNames(android.os.WorkSource):java.util.List");
    }

    public static boolean hasWorkSourcePermission(Context context) {
        return (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        Method method = zzc;
        if (method == null) {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, Integer.valueOf(i));
                    return;
                } catch (Exception e) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                    return;
                }
            }
            return;
        }
        try {
            method.invoke(workSource, Integer.valueOf(i), str);
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
        }
    }
}
