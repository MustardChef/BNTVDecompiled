package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: JvmNameResolver.kt */
/* loaded from: classes4.dex */
public final class JvmNameResolver implements NameResolver {
    public static final Companion Companion = new Companion(null);
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f10829kotlin;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;
    private final JvmProtoBuf.StringTableTypes types;

    /* compiled from: JvmNameResolver.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolver(JvmProtoBuf.StringTableTypes types, String[] strings) {
        Set<Integer> set;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(strings, "strings");
        this.types = types;
        this.strings = strings;
        List<Integer> localNameList = types.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNullExpressionValue(localNameList, "");
            set = CollectionsKt.toSet(localNameList);
        }
        this.localNameIndices = set;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = types.getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record record : recordList) {
            int range = record.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        this.records = arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i) {
        String string;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            string = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = PREDEFINED_STRINGS;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    string = list.get(record.getPredefinedIndex());
                }
            }
            string = this.strings[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer begin = substringIndexList.get(0);
            Integer end = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(begin, "begin");
            if (begin.intValue() >= 0) {
                int intValue = begin.intValue();
                Intrinsics.checkNotNullExpressionValue(end, "end");
                if (intValue <= end.intValue() && end.intValue() <= string.length()) {
                    Intrinsics.checkNotNullExpressionValue(string, "string");
                    string = string.substring(begin.intValue(), end.intValue());
                    Intrinsics.checkNotNullExpressionValue(string, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
        }
        String string2 = string;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Intrinsics.checkNotNullExpressionValue(string2, "string");
            string2 = StringsKt.replace$default(string2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String string3 = string2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 == 2) {
            Intrinsics.checkNotNullExpressionValue(string3, "string");
            string3 = StringsKt.replace$default(string3, (char) Typography.dollar, '.', false, 4, (Object) null);
        } else if (i2 == 3) {
            if (string3.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(string3, "string");
                string3 = string3.substring(1, string3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(string3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String string4 = string3;
            Intrinsics.checkNotNullExpressionValue(string4, "string");
            string3 = StringsKt.replace$default(string4, (char) Typography.dollar, '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(string3, "string");
        return string3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }

    /* compiled from: JvmNameResolver.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f10829kotlin = joinToString$default;
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{joinToString$default + "/Any", joinToString$default + "/Nothing", joinToString$default + "/Unit", joinToString$default + "/Throwable", joinToString$default + "/Number", joinToString$default + "/Byte", joinToString$default + "/Double", joinToString$default + "/Float", joinToString$default + "/Int", joinToString$default + "/Long", joinToString$default + "/Short", joinToString$default + "/Boolean", joinToString$default + "/Char", joinToString$default + "/CharSequence", joinToString$default + "/String", joinToString$default + "/Comparable", joinToString$default + "/Enum", joinToString$default + "/Array", joinToString$default + "/ByteArray", joinToString$default + "/DoubleArray", joinToString$default + "/FloatArray", joinToString$default + "/IntArray", joinToString$default + "/LongArray", joinToString$default + "/ShortArray", joinToString$default + "/BooleanArray", joinToString$default + "/CharArray", joinToString$default + "/Cloneable", joinToString$default + "/Annotation", joinToString$default + "/collections/Iterable", joinToString$default + "/collections/MutableIterable", joinToString$default + "/collections/Collection", joinToString$default + "/collections/MutableCollection", joinToString$default + "/collections/List", joinToString$default + "/collections/MutableList", joinToString$default + "/collections/Set", joinToString$default + "/collections/MutableSet", joinToString$default + "/collections/Map", joinToString$default + "/collections/MutableMap", joinToString$default + "/collections/Map.Entry", joinToString$default + "/collections/MutableMap.MutableEntry", joinToString$default + "/collections/Iterator", joinToString$default + "/collections/MutableIterator", joinToString$default + "/collections/ListIterator", joinToString$default + "/collections/MutableListIterator"});
        PREDEFINED_STRINGS = listOf;
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(listOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }
}
