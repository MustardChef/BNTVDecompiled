package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.utils.M3u8Helper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.text.MatchResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: M3u8Helper.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lcom/lagradost/cloudstream3/utils/M3u8Helper$HlsDownloadData;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.M3u8Helper$hlsYield$tsByteGen$1", m98f = "M3u8Helper.kt", m97i = {0, 0, 0, 1, 1, 1}, m96l = {246, 250, 255}, m95m = "invokeSuspend", m94n = {"$this$sequence", "url", "c", "$this$sequence", "url", "c"}, m93s = {"L$0", "L$2", "I$1", "L$0", "L$2", "I$1"})
/* loaded from: classes4.dex */
public final class M3u8Helper$hlsYield$tsByteGen$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super M3u8Helper.HlsDownloadData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Sequence<MatchResult> $allTs;
    final /* synthetic */ Ref.ObjectRef<byte[]> $encryptionData;
    final /* synthetic */ Ref.ObjectRef<byte[]> $encryptionIv;
    final /* synthetic */ boolean $encryptionState;
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ Ref.IntRef $lastYield;
    final /* synthetic */ String $relativeUrl;
    final /* synthetic */ Ref.IntRef $retries;
    final /* synthetic */ int $startIndex;
    final /* synthetic */ int $totalTs;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ M3u8Helper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public M3u8Helper$hlsYield$tsByteGen$1(Sequence<? extends MatchResult> sequence, M3u8Helper m3u8Helper, String str, int i, Ref.IntRef intRef, boolean z, Ref.ObjectRef<byte[]> objectRef, Ref.ObjectRef<byte[]> objectRef2, int i2, Ref.IntRef intRef2, Map<String, String> map, Continuation<? super M3u8Helper$hlsYield$tsByteGen$1> continuation) {
        super(2, continuation);
        this.$allTs = sequence;
        this.this$0 = m3u8Helper;
        this.$relativeUrl = str;
        this.$startIndex = i;
        this.$lastYield = intRef;
        this.$encryptionState = z;
        this.$encryptionData = objectRef;
        this.$encryptionIv = objectRef2;
        this.$totalTs = i2;
        this.$retries = intRef2;
        this.$headers = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        M3u8Helper$hlsYield$tsByteGen$1 m3u8Helper$hlsYield$tsByteGen$1 = new M3u8Helper$hlsYield$tsByteGen$1(this.$allTs, this.this$0, this.$relativeUrl, this.$startIndex, this.$lastYield, this.$encryptionState, this.$encryptionData, this.$encryptionIv, this.$totalTs, this.$retries, this.$headers, continuation);
        m3u8Helper$hlsYield$tsByteGen$1.L$0 = obj;
        return m3u8Helper$hlsYield$tsByteGen$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super M3u8Helper.HlsDownloadData> sequenceScope, Continuation<? super Unit> continuation) {
        return ((M3u8Helper$hlsYield$tsByteGen$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:19|20|21|22|(1:24)(8:26|27|28|29|4|(5:6|(1:8)(1:72)|9|10|(3:12|4|(0))(0))|73|74)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:44|(1:45)|46|47|48|49|(1:51)(7:52|53|54|55|40|10|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0104, code lost:
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x016e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016f, code lost:
        r14 = r3;
        r11 = r4;
        r12 = r5;
        r13 = r6;
        r15 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ae, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01b2, code lost:
        r14 = r3;
        r11 = r4;
        r12 = r5;
        r13 = r6;
        r15 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0066: MOVE  (r11 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]), block:B:17:0x0061 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0063: MOVE  (r14 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:17:0x0061 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0067: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]), block:B:17:0x0061 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0061: MOVE  (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:17:0x0061 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0062: MOVE  (r13 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:17:0x0061 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v6, types: [kotlin.coroutines.Continuation, java.lang.Object, kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x015b -> B:19:0x007a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0202 -> B:26:0x00e5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0205 -> B:19:0x007a). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.M3u8Helper$hlsYield$tsByteGen$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
