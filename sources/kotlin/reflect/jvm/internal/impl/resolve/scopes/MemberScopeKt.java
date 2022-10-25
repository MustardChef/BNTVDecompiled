package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: MemberScope.kt */
/* loaded from: classes4.dex */
public final class MemberScopeKt {
    public static final Set<Name> flatMapClassifierNamesOrNull(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends MemberScope> it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Set<Name> classifierNames = it.next().getClassifierNames();
            if (classifierNames == null) {
                hashSet = null;
                break;
            }
            CollectionsKt.addAll(hashSet, classifierNames);
        }
        return hashSet;
    }
}
