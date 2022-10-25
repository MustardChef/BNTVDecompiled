package khttp.structures.authorization;

import kotlin.Metadata;
import kotlin.Tuples;

/* compiled from: Authorization.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m107d2 = {"Lkhttp/structures/authorization/Authorization;", "", "header", "Lkotlin/Pair;", "", "getHeader", "()Lkotlin/Pair;", "library_release"}, m106k = 1, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public interface Authorization {
    Tuples<String, String> getHeader();
}
