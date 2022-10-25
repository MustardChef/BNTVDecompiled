package com.anggrayudi.storage.extension;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m107d2 = {"toBoolean", "", "", "(Ljava/lang/Integer;)Z", "toInt", "(Ljava/lang/Boolean;)I", "storage_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.extension.PrimitivesExtKt */
/* loaded from: classes.dex */
public final class PrimitivesExt {
    public static final boolean toBoolean(Integer num) {
        return num != null && num.intValue() > 0;
    }

    public static final int toInt(Boolean bool) {
        return Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0;
    }
}
