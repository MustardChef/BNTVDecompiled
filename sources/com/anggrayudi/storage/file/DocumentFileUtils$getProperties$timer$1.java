package com.anggrayudi.storage.file;

import com.anggrayudi.storage.file.FileProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
final class DocumentFileUtils$getProperties$timer$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ FileProperties.CalculationCallback $callback;
    final /* synthetic */ FileProperties $properties;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$getProperties$timer$1(FileProperties.CalculationCallback calculationCallback, FileProperties fileProperties) {
        super(0);
        this.$callback = calculationCallback;
        this.$properties = fileProperties;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new C1103x72f712c4(null, this.$callback, this.$properties), 2, null);
    }
}
