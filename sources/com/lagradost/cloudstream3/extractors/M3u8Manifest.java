package com.lagradost.cloudstream3.extractors;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: M3u8Manifest.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005`\u00072\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/M3u8Manifest;", "", "()V", "extractLinks", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlin/collections/ArrayList;", "m3u8Data", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class M3u8Manifest {
    public static final M3u8Manifest INSTANCE = new M3u8Manifest();

    private M3u8Manifest() {
    }

    public final ArrayList<Tuples<String, String>> extractLinks(String m3u8Data) {
        Intrinsics.checkNotNullParameter(m3u8Data, "m3u8Data");
        ArrayList<Tuples<String, String>> arrayList = new ArrayList<>();
        for (MatchResult matchResult : Regex.findAll$default(new Regex("\"(.*?)\":\"(.*?)\""), m3u8Data, 0, 2, null)) {
            String replace$default = StringsKt.replace$default(matchResult.getGroupValues().get(1), "auto", "Auto", false, 4, (Object) null);
            if (!Intrinsics.areEqual(replace$default, "Auto") && !StringsKt.endsWith$default((CharSequence) replace$default, 'p', false, 2, (Object) null)) {
                replace$default = replace$default + 'p';
            }
            arrayList.add(new Tuples<>(matchResult.getGroupValues().get(2), replace$default));
        }
        return arrayList;
    }
}
