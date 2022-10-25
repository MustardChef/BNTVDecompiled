package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: -FileSystem.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
@DebugMetadata(m99c = "okio.internal._FileSystemKt$commonListRecursively$1", m98f = "-FileSystem.kt", m97i = {0, 0}, m96l = {93}, m95m = "invokeSuspend", m94n = {"$this$sequence", "stack"}, m93s = {"L$0", "L$1"})
/* loaded from: classes4.dex */
public final class _FileSystemKt$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Path $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ FileSystem $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _FileSystemKt$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z, Continuation<? super _FileSystemKt$commonListRecursively$1> continuation) {
        super(2, continuation);
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1 = new _FileSystemKt$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, continuation);
        _filesystemkt_commonlistrecursively_1.L$0 = obj;
        return _filesystemkt_commonlistrecursively_1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return ((_FileSystemKt$commonListRecursively$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1;
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        Iterator<Path> it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.addLast(this.$dir);
            _filesystemkt_commonlistrecursively_1 = this;
            sequenceScope = (SequenceScope) this.L$0;
            arrayDeque = arrayDeque2;
            it = this.$this_commonListRecursively.list(this.$dir).iterator();
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            it = (Iterator) this.L$2;
            ResultKt.throwOnFailure(obj);
            _filesystemkt_commonlistrecursively_1 = this;
            arrayDeque = (ArrayDeque) this.L$1;
            sequenceScope = (SequenceScope) this.L$0;
        }
        while (it.hasNext()) {
            FileSystem fileSystem = _filesystemkt_commonlistrecursively_1.$this_commonListRecursively;
            _filesystemkt_commonlistrecursively_1.L$0 = sequenceScope;
            _filesystemkt_commonlistrecursively_1.L$1 = arrayDeque;
            _filesystemkt_commonlistrecursively_1.L$2 = it;
            _filesystemkt_commonlistrecursively_1.label = 1;
            if (_FileSystemKt.collectRecursively(sequenceScope, fileSystem, arrayDeque, it.next(), _filesystemkt_commonlistrecursively_1.$followSymlinks, false, _filesystemkt_commonlistrecursively_1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
