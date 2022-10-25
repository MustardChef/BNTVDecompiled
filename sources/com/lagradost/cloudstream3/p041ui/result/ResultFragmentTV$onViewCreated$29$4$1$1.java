package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.utils.UIHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "Landroid/widget/ImageView;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$29$4$1$1", m98f = "ResultFragmentTV.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$29$4$1$1 */
/* loaded from: classes4.dex */
public final class ResultFragmentTV$onViewCreated$29$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageView>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ String $posterImageLink;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$29$4$1$1(Context context, String str, Continuation<? super ResultFragmentTV$onViewCreated$29$4$1$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
        this.$posterImageLink = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResultFragmentTV$onViewCreated$29$4$1$1(this.$ctx, this.$posterImageLink, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImageView> continuation) {
        return ((ResultFragmentTV$onViewCreated$29$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.$ctx);
            builder.setView(R.layout.result_poster);
            final AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "sourceBuilder.create()");
            create.show();
            ImageView imageView = (ImageView) create.findViewById(R.id.imgPoster);
            if (imageView != null) {
                UIHelper.setImage$default(UIHelper.INSTANCE, imageView, this.$posterImageLink, null, null, 6, null);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ResultFragmentTV$onViewCreated$29$4$1$1$wzc4-mWT_QZaMDMeivyPZIV8uH4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResultFragmentTV$onViewCreated$29$4$1$1.m8855invokeSuspend$lambda1$lambda0(AlertDialog.this, view);
                    }
                });
                return imageView;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1$lambda-0  reason: not valid java name */
    public static final void m8855invokeSuspend$lambda1$lambda0(AlertDialog alertDialog, View view) {
        UIHelper.INSTANCE.dismissSafe(alertDialog);
    }
}
