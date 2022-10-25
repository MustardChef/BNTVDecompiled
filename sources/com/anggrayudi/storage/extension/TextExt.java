package com.anggrayudi.storage.extension;

import com.fasterxml.jackson.core.JsonPointer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u001a\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\u0002¨\u0006\f"}, m107d2 = {"count", "", "", "text", "hasParent", "", "parentPath", "replaceCompletely", "match", "replaceWith", "trimFileSeparator", "trimWhiteSpace", "storage_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.extension.TextUtils */
/* loaded from: classes.dex */
public final class TextExt {
    public static final int count(String str, String text) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        String str2 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, text, 0, false, 6, (Object) null);
        if ((text.length() == 0) || indexOf$default == -1) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            indexOf$default = StringsKt.indexOf$default((CharSequence) str2, text, indexOf$default + text.length(), false, 4, (Object) null);
            if (!(1 <= indexOf$default && indexOf$default < str.length())) {
                return i2;
            }
            i = i2;
        }
    }

    public static final String trimFileSeparator(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.trim(str, JsonPointer.SEPARATOR);
    }

    public static final String replaceCompletely(String str, String match, String replaceWith) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(match, "match");
        Intrinsics.checkNotNullParameter(replaceWith, "replaceWith");
        String str3 = str;
        do {
            str3 = StringsKt.replace$default(str3, match, replaceWith, false, 4, (Object) null);
            str2 = str3;
            if (!(str2.length() > 0)) {
                break;
            }
        } while (StringsKt.contains$default((CharSequence) str2, (CharSequence) match, false, 2, (Object) null));
        return str3;
    }

    public static final boolean hasParent(String str, String parentPath) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(parentPath, "parentPath");
        List<String> split$default = StringsKt.split$default((CharSequence) parentPath, new char[]{JsonPointer.SEPARATOR}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            arrayList.add(trimFileSeparator(str2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List<String> split$default2 = StringsKt.split$default((CharSequence) str, new char[]{JsonPointer.SEPARATOR}, false, 0, 6, (Object) null);
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
        for (String str3 : split$default2) {
            arrayList4.add(trimFileSeparator(str3));
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (((String) obj2).length() > 0) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        return arrayList3.size() <= arrayList6.size() && Intrinsics.areEqual(CollectionsKt.take(arrayList6, arrayList3.size()), arrayList3);
    }

    public static final String trimWhiteSpace(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str2.subSequence(i, length + 1).toString();
    }
}
