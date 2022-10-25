package com.lagradost.cloudstream3;

import android.content.Context;
import android.widget.Toast;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: AcraApplication.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
final class CustomReportSender$send$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomReportSender$send$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AcraApplication.kt */
    @Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.CustomReportSender$send$1$1 */
    /* loaded from: classes3.dex */
    public static final class C47551 extends Lambda implements Functions<Unit> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C47551(Context context) {
            super(0);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Functions
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Functions
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Toast.makeText(this.$context, (int) com.bongngotv2.R.string.acra_report_toast, 0).show();
        }
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ArchComponentExt.normalSafeApiCall(new C47551(this.$context));
    }
}
