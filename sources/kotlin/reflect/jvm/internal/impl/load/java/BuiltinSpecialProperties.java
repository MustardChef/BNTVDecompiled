package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
/* loaded from: classes4.dex */
public final class BuiltinSpecialProperties {
    private static final Map<Name, List<Name>> GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP;
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();
    private static final Map<FqName, Name> PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    private static final Set<FqName> SPECIAL_FQ_NAMES;
    private static final Set<Name> SPECIAL_SHORT_NAMES;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP;
    }

    static {
        FqName childSafe;
        FqName childSafe2;
        FqName child;
        FqName child2;
        FqName childSafe3;
        FqName child3;
        FqName child4;
        FqName child5;
        childSafe = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "name");
        childSafe2 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames._enum, "ordinal");
        child = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.collection, "size");
        child2 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "size");
        childSafe3 = BuiltinSpecialPropertiesKt.childSafe(StandardNames.FqNames.charSequence, SessionDescription.ATTR_LENGTH);
        child3 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "keys");
        child4 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "values");
        child5 = BuiltinSpecialPropertiesKt.child(StandardNames.FqNames.map, "entries");
        Map<FqName, Name> mapOf = MapsKt.mapOf(TuplesKt.m100to(childSafe, Name.identifier("name")), TuplesKt.m100to(childSafe2, Name.identifier("ordinal")), TuplesKt.m100to(child, Name.identifier("size")), TuplesKt.m100to(child2, Name.identifier("size")), TuplesKt.m100to(childSafe3, Name.identifier(SessionDescription.ATTR_LENGTH)), TuplesKt.m100to(child3, Name.identifier("keySet")), TuplesKt.m100to(child4, Name.identifier("values")), TuplesKt.m100to(child5, Name.identifier("entrySet")));
        PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP = mapOf;
        Set<Map.Entry<FqName, Name>> entrySet = mapOf.entrySet();
        ArrayList<Tuples> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new Tuples(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Tuples tuples : arrayList) {
            Name name = (Name) tuples.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) tuples.getFirst());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt.distinct((Iterable) entry2.getValue()));
        }
        GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP = linkedHashMap2;
        Set<FqName> keySet = PROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP.keySet();
        SPECIAL_FQ_NAMES = keySet;
        Set<FqName> set = keySet;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (FqName fqName : set) {
            arrayList2.add(fqName.shortName());
        }
        SPECIAL_SHORT_NAMES = CollectionsKt.toSet(arrayList2);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return SPECIAL_FQ_NAMES;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return SPECIAL_SHORT_NAMES;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name1) {
        Intrinsics.checkNotNullParameter(name1, "name1");
        List<Name> list = GETTER_JVM_NAME_TO_PROPERTIES_SHORT_NAME_MAP.get(name1);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
