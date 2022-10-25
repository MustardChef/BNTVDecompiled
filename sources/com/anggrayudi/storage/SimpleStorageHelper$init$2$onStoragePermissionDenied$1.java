package com.anggrayudi.storage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: SimpleStorageHelper.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
final class SimpleStorageHelper$init$2$onStoragePermissionDenied$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ SimpleStorageHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleStorageHelper$init$2$onStoragePermissionDenied$1(SimpleStorageHelper simpleStorageHelper) {
        super(1);
        this.this$0 = simpleStorageHelper;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (!z) {
            this.this$0.reset();
        } else {
            SimpleStorage.openFolderPicker$default(this.this$0.getStorage(), 0, 1, null);
        }
    }
}
