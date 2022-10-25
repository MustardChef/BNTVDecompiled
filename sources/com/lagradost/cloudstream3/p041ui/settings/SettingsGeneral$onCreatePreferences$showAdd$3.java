package com.lagradost.cloudstream3.p041ui.settings;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.bongngotv2.R;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.p041ui.settings.SettingsGeneral;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsGeneral.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "selection", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.SettingsGeneral$onCreatePreferences$showAdd$3 */
/* loaded from: classes4.dex */
public final class SettingsGeneral$onCreatePreferences$showAdd$3 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<MainAPI> $providers;
    final /* synthetic */ SettingsGeneral this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SettingsGeneral$onCreatePreferences$showAdd$3(List<? extends MainAPI> list, SettingsGeneral settingsGeneral) {
        super(1);
        this.$providers = list;
        this.this$0 = settingsGeneral;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        Context context;
        final MainAPI mainAPI = (MainAPI) CollectionsKt.getOrNull(this.$providers, i);
        if (mainAPI == null || (context = this.this$0.getContext()) == null) {
            return;
        }
        final AlertDialog create = new AlertDialog.Builder(context, R.style.AlertDialogCustom).setView(R.layout.add_site_input).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        TextView textView = (TextView) create.findViewById(C4761R.C4764id.text2);
        if (textView != null) {
            textView.setText(mainAPI.getName());
        }
        MaterialButton materialButton = (MaterialButton) create.findViewById(C4761R.C4764id.apply_btt);
        if (materialButton != null) {
            final SettingsGeneral settingsGeneral = this.this$0;
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$onCreatePreferences$showAdd$3$qVcT7F9BQQ8FJacbrFfGZq8niPY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsGeneral$onCreatePreferences$showAdd$3.m8916invoke$lambda0(AlertDialog.this, mainAPI, settingsGeneral, view);
                }
            });
        }
        MaterialButton materialButton2 = (MaterialButton) create.findViewById(C4761R.C4764id.cancel_btt);
        if (materialButton2 != null) {
            final SettingsGeneral settingsGeneral2 = this.this$0;
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$SettingsGeneral$onCreatePreferences$showAdd$3$l1ZM5Kcttqg7WKxMna1r5ManP4w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsGeneral$onCreatePreferences$showAdd$3.m8917invoke$lambda1(AlertDialog.this, settingsGeneral2, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8916invoke$lambda0(AlertDialog dialog, MainAPI provider, SettingsGeneral this$0, View view) {
        List onCreatePreferences$getCurrent;
        Editable text;
        Editable text2;
        Editable text3;
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(provider, "$provider");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = (EditText) dialog.findViewById(C4761R.C4764id.site_name_input);
        String str = null;
        String obj = (editText == null || (text3 = editText.getText()) == null) ? null : text3.toString();
        EditText editText2 = (EditText) dialog.findViewById(C4761R.C4764id.site_url_input);
        String obj2 = (editText2 == null || (text2 = editText2.getText()) == null) ? null : text2.toString();
        EditText editText3 = (EditText) dialog.findViewById(C4761R.C4764id.site_lang_input);
        if (editText3 != null && (text = editText3.getText()) != null) {
            str = text.toString();
        }
        String str2 = str;
        boolean z = true;
        if (str2 == null || StringsKt.isBlank(str2)) {
            str = provider.getLang();
        }
        String str3 = obj2;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            String str4 = obj;
            if (str4 != null && !StringsKt.isBlank(str4)) {
                z = false;
            }
            if (!z && str.length() == 2) {
                onCreatePreferences$getCurrent = SettingsGeneral.onCreatePreferences$getCurrent();
                String simpleName = provider.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "provider.javaClass.simpleName");
                onCreatePreferences$getCurrent.add(new SettingsGeneral.CustomSite(simpleName, obj, obj2, str));
                AcraApplication.Companion companion = AcraApplication.Companion;
                Object[] array = onCreatePreferences$getCurrent.toArray(new SettingsGeneral.CustomSite[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                companion.setKey(DataStoreKt.USER_PROVIDER_API, array);
                UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
                return;
            }
        }
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.error_invalid_data, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m8917invoke$lambda1(AlertDialog dialog, SettingsGeneral this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UIHelper.INSTANCE.dismissSafe(dialog, this$0.getActivity());
    }
}
