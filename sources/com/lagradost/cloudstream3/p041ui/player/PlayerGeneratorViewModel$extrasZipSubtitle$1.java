package com.lagradost.cloudstream3.p041ui.player;

import android.os.Looper;
import android.util.Log;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.p041ui.browser.SubtitleBrowserRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$extrasZipSubtitle$1", m98f = "PlayerGeneratorViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$extrasZipSubtitle$1 */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel$extrasZipSubtitle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<SubtitleData, Unit> $callback;
    final /* synthetic */ String $fileDir;
    final /* synthetic */ SubtitleData $subtitleFileZip;
    int label;
    final /* synthetic */ PlayerGeneratorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PlayerGeneratorViewModel$extrasZipSubtitle$1(SubtitleData subtitleData, String str, PlayerGeneratorViewModel playerGeneratorViewModel, Function1<? super SubtitleData, Unit> function1, Continuation<? super PlayerGeneratorViewModel$extrasZipSubtitle$1> continuation) {
        super(2, continuation);
        this.$subtitleFileZip = subtitleData;
        this.$fileDir = str;
        this.this$0 = playerGeneratorViewModel;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerGeneratorViewModel$extrasZipSubtitle$1(this.$subtitleFileZip, this.$fileDir, this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerGeneratorViewModel$extrasZipSubtitle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SubtitleBrowserRepository subtitleBrowserRepository = new SubtitleBrowserRepository();
            new ArrayList();
            Ref.IntRef intRef = new Ref.IntRef();
            Log.d("Duongkk", "Main Thread " + Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()));
            Log.e("Duongkk Thread", Thread.currentThread().getName());
            subtitleBrowserRepository.downloadSubtitle(this.$subtitleFileZip.getUrl(), this.$fileDir, new C48731(intRef, subtitleBrowserRepository, this.this$0, this.$callback));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerGeneratorViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "listFilePath", "", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$extrasZipSubtitle$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48731 extends Lambda implements Function1<List<? extends String>, Unit> {
        final /* synthetic */ Function1<SubtitleData, Unit> $callback;
        final /* synthetic */ SubtitleBrowserRepository $repository;
        final /* synthetic */ Ref.IntRef $size;
        final /* synthetic */ PlayerGeneratorViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C48731(Ref.IntRef intRef, SubtitleBrowserRepository subtitleBrowserRepository, PlayerGeneratorViewModel playerGeneratorViewModel, Function1<? super SubtitleData, Unit> function1) {
            super(1);
            this.$size = intRef;
            this.$repository = subtitleBrowserRepository;
            this.this$0 = playerGeneratorViewModel;
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> listFilePath) {
            Intrinsics.checkNotNullParameter(listFilePath, "listFilePath");
            this.$size.element = listFilePath.size();
            Log.d("BLUE", String.valueOf(listFilePath));
            ArrayList arrayList = new ArrayList();
            for (Object obj : listFilePath) {
                String str = (String) obj;
                boolean z = false;
                if ((StringsKt.endsWith$default(str, "srt", false, 2, (Object) null) || StringsKt.endsWith$default(str, "vtt", false, 2, (Object) null) || StringsKt.endsWith$default(str, "xml", false, 2, (Object) null)) ? true : true) {
                    arrayList.add(obj);
                }
            }
            this.$repository.uploadFile(new File((String) CollectionsKt.first((List<? extends Object>) arrayList)), new C48741(this.this$0, this.$callback));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: PlayerGeneratorViewModel.kt */
        @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "subtitleFile", "Lcom/lagradost/cloudstream3/SubtitleFile;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$extrasZipSubtitle$1$1$1 */
        /* loaded from: classes3.dex */
        public static final class C48741 extends Lambda implements Function1<SubtitleFile, Unit> {
            final /* synthetic */ Function1<SubtitleData, Unit> $callback;
            final /* synthetic */ PlayerGeneratorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C48741(PlayerGeneratorViewModel playerGeneratorViewModel, Function1<? super SubtitleData, Unit> function1) {
                super(1);
                this.this$0 = playerGeneratorViewModel;
                this.$callback = function1;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SubtitleFile subtitleFile) {
                invoke2(subtitleFile);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SubtitleFile subtitleFile) {
                IGenerator iGenerator;
                LoadResponse loadResponse;
                if (subtitleFile != null) {
                    PlayerGeneratorViewModel playerGeneratorViewModel = this.this$0;
                    Function1<SubtitleData, Unit> function1 = this.$callback;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Vietsub ");
                    iGenerator = playerGeneratorViewModel.generator;
                    sb.append((iGenerator == null || (loadResponse = iGenerator.getLoadResponse()) == null) ? null : loadResponse.getName());
                    sb.append(' ');
                    sb.append(System.currentTimeMillis());
                    SubtitleData subtitleData = new SubtitleData(sb.toString(), subtitleFile.getUrl(), SubtitleOrigin.URL, PlayerSubtitleHelper.Companion.toSubtitleMimeType(subtitleFile.getUrl()), false);
                    Log.d("BLUE", "auto choose " + subtitleData);
                    function1.invoke(subtitleData);
                }
            }
        }
    }
}
