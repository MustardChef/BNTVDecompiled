package kotlinx.coroutines.channels;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m98f = "Deprecated.kt", m97i = {0, 0, 0}, m96l = {53}, m95m = "elementAtOrNull", m94n = {"$this$consume$iv", FirebaseAnalytics.Param.INDEX, "count"}, m93s = {"L$0", "I$0", "I$1"})
/* loaded from: classes4.dex */
public final class ChannelsKt__DeprecatedKt$elementAtOrNull$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$elementAtOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAtOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object elementAtOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        elementAtOrNull = Deprecated.elementAtOrNull(null, 0, this);
        return elementAtOrNull;
    }
}
