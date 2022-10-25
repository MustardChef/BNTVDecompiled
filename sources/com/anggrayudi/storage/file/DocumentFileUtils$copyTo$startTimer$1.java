package com.anggrayudi.storage.file;

import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.CoroutineExt;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DocumentFileExt.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m107d2 = {"<anonymous>", "", TtmlNode.START, ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class DocumentFileUtils$copyTo$startTimer$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ Ref.LongRef $bytesMoved;
    final /* synthetic */ MultipleFileCallback $callback;
    final /* synthetic */ long $reportInterval;
    final /* synthetic */ Ref.ObjectRef<Job> $timer;
    final /* synthetic */ Ref.IntRef $totalCopiedFiles;
    final /* synthetic */ long $totalSizeToCopy;
    final /* synthetic */ Ref.IntRef $writeSpeed;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DocumentFileUtils$copyTo$startTimer$1(long j, Ref.ObjectRef<Job> objectRef, Ref.LongRef longRef, long j2, Ref.IntRef intRef, Ref.IntRef intRef2, MultipleFileCallback multipleFileCallback) {
        super(1);
        this.$reportInterval = j;
        this.$timer = objectRef;
        this.$bytesMoved = longRef;
        this.$totalSizeToCopy = j2;
        this.$writeSpeed = intRef;
        this.$totalCopiedFiles = intRef2;
        this.$callback = multipleFileCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DocumentFileExt.kt */
    @Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
    /* renamed from: com.anggrayudi.storage.file.DocumentFileUtils$copyTo$startTimer$1$1 */
    /* loaded from: classes.dex */
    public static final class C11241 extends Lambda implements Functions<Unit> {
        final /* synthetic */ Ref.LongRef $bytesMoved;
        final /* synthetic */ MultipleFileCallback $callback;
        final /* synthetic */ Ref.IntRef $totalCopiedFiles;
        final /* synthetic */ long $totalSizeToCopy;
        final /* synthetic */ Ref.IntRef $writeSpeed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11241(Ref.LongRef longRef, long j, Ref.IntRef intRef, Ref.IntRef intRef2, MultipleFileCallback multipleFileCallback) {
            super(0);
            this.$bytesMoved = longRef;
            this.$totalSizeToCopy = j;
            this.$writeSpeed = intRef;
            this.$totalCopiedFiles = intRef2;
            this.$callback = multipleFileCallback;
        }

        @Override // kotlin.jvm.functions.Functions
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Functions
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            MultipleFileCallback.Report report = new MultipleFileCallback.Report((((float) this.$bytesMoved.element) * 100.0f) / ((float) this.$totalSizeToCopy), this.$bytesMoved.element, this.$writeSpeed.element, this.$totalCopiedFiles.element);
            BuildersKt__Builders_commonKt.launch$default(this.$callback.getUiScope(), Dispatchers.getMain(), null, new C1100x2ce105ea(null, this.$callback, report), 2, null);
            this.$writeSpeed.element = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, kotlinx.coroutines.Job] */
    public final void invoke(boolean z) {
        ?? startCoroutineTimer;
        if (z) {
            long j = this.$reportInterval;
            if (j > 0) {
                Ref.ObjectRef<Job> objectRef = this.$timer;
                startCoroutineTimer = CoroutineExt.startCoroutineTimer((r14 & 1) != 0 ? 0L : 0L, (r14 & 2) != 0 ? 0L : j, (r14 & 4) != 0 ? false : false, new C11241(this.$bytesMoved, this.$totalSizeToCopy, this.$writeSpeed, this.$totalCopiedFiles, this.$callback));
                objectRef.element = startCoroutineTimer;
            }
        }
    }
}
