package com.google.android.gms.internal.p038firebaseauthapi;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaat */
/* loaded from: classes3.dex */
public final class zzaat {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzaar zzaarVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzaarVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzabp.zza(zzym.zzo((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzym) {
                sb.append(": \"");
                sb.append(zzabp.zza((zzym) obj));
                sb.append('\"');
            } else if (obj instanceof zzzo) {
                sb.append(" {");
                zzc((zzzo) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                zzb(sb, i4, SDKConstants.PARAM_KEY, entry2.getKey());
                zzb(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static void zzc(zzaar zzaarVar, StringBuilder sb, int i) {
        Method[] declaredMethods;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzaarVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i, zzd(concat), zzzo.zzA(method2, zzaarVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i, zzd(concat2), zzzo.zzA(method3, zzaarVar, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(substring);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (!hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(substring.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(substring);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(substring);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object zzA = zzzo.zzA(method4, zzaarVar, new Object[0]);
                    if (method5 == null) {
                        if (zzA instanceof Boolean) {
                            if (((Boolean) zzA).booleanValue()) {
                                zzb(sb, i, zzd(concat3), zzA);
                            }
                        } else if (zzA instanceof Integer) {
                            if (((Integer) zzA).intValue() != 0) {
                                zzb(sb, i, zzd(concat3), zzA);
                            }
                        } else if (zzA instanceof Float) {
                            if (((Float) zzA).floatValue() != 0.0f) {
                                zzb(sb, i, zzd(concat3), zzA);
                            }
                        } else if (zzA instanceof Double) {
                            if (((Double) zzA).doubleValue() != 0.0d) {
                                zzb(sb, i, zzd(concat3), zzA);
                            }
                        } else {
                            if (zzA instanceof String) {
                                equals = zzA.equals("");
                            } else if (zzA instanceof zzym) {
                                equals = zzA.equals(zzym.zzb);
                            } else if (zzA instanceof zzaar) {
                                if (zzA != ((zzaar) zzA).zzo()) {
                                    zzb(sb, i, zzd(concat3), zzA);
                                }
                            } else {
                                if ((zzA instanceof Enum) && ((Enum) zzA).ordinal() == 0) {
                                }
                                zzb(sb, i, zzd(concat3), zzA);
                            }
                            if (!equals) {
                                zzb(sb, i, zzd(concat3), zzA);
                            }
                        }
                    } else if (((Boolean) zzzo.zzA(method5, zzaarVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, zzd(concat3), zzA);
                    }
                }
            }
        }
        if (!(zzaarVar instanceof zzzl)) {
            zzabs zzabsVar = ((zzzo) zzaarVar).zzc;
            if (zzabsVar != null) {
                zzabsVar.zzg(sb, i);
                return;
            }
            return;
        }
        zzzg zzzgVar = ((zzzl) zzaarVar).zzb;
        throw null;
    }

    private static final String zzd(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
