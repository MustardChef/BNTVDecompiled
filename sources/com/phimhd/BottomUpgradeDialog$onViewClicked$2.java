package com.phimhd;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: BottomUpgradeDialog.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class BottomUpgradeDialog$onViewClicked$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef<String> $url;
    final /* synthetic */ BottomUpgradeDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomUpgradeDialog$onViewClicked$2(Ref.ObjectRef<String> objectRef, BottomUpgradeDialog bottomUpgradeDialog) {
        super(1);
        this.$url = objectRef;
        this.this$0 = bottomUpgradeDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4, types: [T] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final void invoke(int i) {
        Config config;
        Config config2;
        Ref.ObjectRef<String> objectRef = this.$url;
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        r1 = 0;
        if (i == 0) {
            AppController companion = AppController.Companion.getInstance();
            if (companion != null && (config2 = companion.getConfig()) != null) {
                r1 = config2.urlPaymentMomo;
            }
            if (r1 == 0) {
                r1 = Constants.URL_RECEIVE;
            }
        } else {
            AppController companion2 = AppController.Companion.getInstance();
            if (companion2 != null && (config = companion2.getConfig()) != null) {
                r1 = config.urlPaymentPaypal;
            }
            if (r1 == 0) {
                r1 = Constants.URL_RECEIVE_PAYPAL;
            }
        }
        objectRef.element = r1;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(this.$url.element));
        this.this$0.startActivity(intent);
    }
}
