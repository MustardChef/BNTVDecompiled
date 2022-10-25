package com.lagradost.nicehttp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NiceFile.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, m107d2 = {"toNiceFiles", "", "Lcom/lagradost/nicehttp/NiceFile;", "", "", "library_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class NiceFileKt {
    public static final List<NiceFile> toNiceFiles(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new NiceFile(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
