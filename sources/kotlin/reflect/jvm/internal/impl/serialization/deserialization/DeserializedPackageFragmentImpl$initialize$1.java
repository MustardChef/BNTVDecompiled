package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedPackageFragmentImpl.kt */
/* loaded from: classes4.dex */
final class DeserializedPackageFragmentImpl$initialize$1 extends Lambda implements Functions<Collection<? extends Name>> {
    final /* synthetic */ DeserializedPackageFragmentImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl$initialize$1(DeserializedPackageFragmentImpl deserializedPackageFragmentImpl) {
        super(0);
        this.this$0 = deserializedPackageFragmentImpl;
    }

    @Override // kotlin.jvm.functions.Functions
    public final Collection<? extends Name> invoke() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.this$0.getClassDataFinder().getAllClassIds()) {
            ClassId classId = (ClassId) obj;
            if ((classId.isNestedClass() || ClassDeserializer.Companion.getBLACK_LIST().contains(classId)) ? false : true) {
                arrayList.add(obj);
            }
        }
        ArrayList<ClassId> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ClassId classId2 : arrayList2) {
            arrayList3.add(classId2.getShortClassName());
        }
        return arrayList3;
    }
}
