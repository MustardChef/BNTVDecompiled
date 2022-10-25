package org.acra.data;

import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CrashReportData.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0018\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n"}, m107d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "", "it"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CrashReportData$toMap$1 extends Lambda implements Function1<String, Tuples<? extends String, ? extends Object>> {
    final /* synthetic */ CrashReportData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrashReportData$toMap$1(CrashReportData crashReportData) {
        super(1);
        this.this$0 = crashReportData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Tuples<String, Object> invoke(String it) {
        CrashReportData crashReportData = this.this$0;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        return TuplesKt.m100to(it, crashReportData.get(it));
    }
}
