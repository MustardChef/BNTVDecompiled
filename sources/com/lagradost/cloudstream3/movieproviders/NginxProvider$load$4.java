package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.Episode;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NginxProvider.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.NginxProvider$load$4", m98f = "NginxProvider.kt", m97i = {0, 0, 1, 1, 1, 1}, m96l = {137, 143}, m95m = "invokeSuspend", m94n = {"seasonString", "seasonInt", "seasonString", "seasonDocument", "episode", "seasonInt"}, m93s = {"L$0", "I$0", "L$0", "L$1", "L$6", "I$0"})
/* loaded from: classes3.dex */
public final class NginxProvider$load$4 extends SuspendLambda implements Function2<Tuples<? extends Integer, ? extends String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $authHeader;
    final /* synthetic */ ArrayList<Episode> $episodeList;
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ NginxProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NginxProvider$load$4(Map<String, String> map, ArrayList<Episode> arrayList, NginxProvider nginxProvider, Continuation<? super NginxProvider$load$4> continuation) {
        super(2, continuation);
        this.$authHeader = map;
        this.$episodeList = arrayList;
        this.this$0 = nginxProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NginxProvider$load$4 nginxProvider$load$4 = new NginxProvider$load$4(this.$authHeader, this.$episodeList, this.this$0, continuation);
        nginxProvider$load$4.L$0 = obj;
        return nginxProvider$load$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends Integer, ? extends String> tuples, Continuation<? super Unit> continuation) {
        return invoke2((Tuples<Integer, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<Integer, String> tuples, Continuation<? super Unit> continuation) {
        return ((NginxProvider$load$4) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x022a A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0129 -> B:21:0x0133). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.NginxProvider$load$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
