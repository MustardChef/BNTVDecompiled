package com.anggrayudi.storage.media;

import com.anggrayudi.storage.callback.FileCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaFile.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class MediaFile$copyFileStream$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Ref.LongRef $bytesMoved;
    final /* synthetic */ FileCallback $callback;
    final /* synthetic */ long $srcSize;
    final /* synthetic */ Ref.IntRef $writeSpeed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaFile$copyFileStream$1(Ref.LongRef longRef, long j, Ref.IntRef intRef, FileCallback fileCallback) {
        super(0);
        this.$bytesMoved = longRef;
        this.$srcSize = j;
        this.$writeSpeed = intRef;
        this.$callback = fileCallback;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FileCallback.Report report = new FileCallback.Report((((float) this.$bytesMoved.element) * 100.0f) / ((float) this.$srcSize), this.$bytesMoved.element, this.$writeSpeed.element);
        BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new MediaFile$copyFileStream$1$invoke$$inlined$postToUi$1(null, this.$callback, report), 2, null);
        this.$writeSpeed.element = 0;
    }
}
