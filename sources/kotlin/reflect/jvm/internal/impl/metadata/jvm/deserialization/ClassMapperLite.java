package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.progressionUtil;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: ClassMapperLite.kt */
/* loaded from: classes4.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f10828kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    static {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = progressionUtil.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f10828kotlin;
                sb.append(str);
                sb.append(JsonPointer.SEPARATOR);
                sb.append((String) listOf.get(i2));
                linkedHashMap.put(sb.toString(), listOf.get(i2 + 1));
                linkedHashMap.put(str + JsonPointer.SEPARATOR + ((String) listOf.get(i2)) + "Array", '[' + ((String) listOf.get(i)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
            }
        }
        linkedHashMap.put(f10828kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m10319map$lambda0$add(linkedHashMap, "Any", "java/lang/Object");
        m10319map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m10319map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            m10319map$lambda0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            m10319map$lambda0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            m10319map$lambda0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        m10319map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m10319map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m10319map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m10319map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f10828kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i3);
            m10319map$lambda0$add(linkedHashMap, "Function" + i3, sb2.toString());
            m10319map$lambda0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            m10319map$lambda0$add(linkedHashMap, str5 + ".Companion", f10828kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    /* renamed from: map$lambda-0$add  reason: not valid java name */
    private static final void m10319map$lambda0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f10828kotlin + JsonPointer.SEPARATOR + str, 'L' + str2 + ';');
    }

    @JvmStatic
    public static final String mapClass(String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        if (str == null) {
            return 'L' + StringsKt.replace$default(classId, '.', (char) Typography.dollar, false, 4, (Object) null) + ';';
        }
        return str;
    }
}
