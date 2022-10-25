package com.lagradost.cloudstream3.p041ui.browser;

import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.fragment.Fragment;
import com.blankj.utilcode.util.KeyboardUtils;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* compiled from: SubtitleBrowserFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "data", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserFragment$onViewCreated$10 */
/* loaded from: classes.dex */
final class SubtitleBrowserFragment$onViewCreated$10 extends Lambda implements Function1<Resource<? extends Object>, Unit> {
    final /* synthetic */ SubtitleBrowserFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleBrowserFragment$onViewCreated$10(SubtitleBrowserFragment subtitleBrowserFragment) {
        super(1);
        this.this$0 = subtitleBrowserFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends Object> resource) {
        invoke2(resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<? extends Object> data) {
        SavedStateHandle savedStateHandle;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Resource.Success) {
            ((ProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.loading)).setVisibility(8);
            Object value = ((Resource.Success) data).getValue();
            Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            KeyboardUtils.hideSoftInput(this.this$0.getActivity());
            NavController findNavController = Fragment.findNavController(this.this$0);
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) value) {
                String str = (String) obj;
                if (StringsKt.endsWith$default(str, "srt", false, 2, (Object) null) || StringsKt.endsWith$default(str, "vtt", false, 2, (Object) null) || StringsKt.endsWith$default(str, "xml", false, 2, (Object) null)) {
                    arrayList.add(obj);
                }
            }
            String str2 = (String) CollectionsKt.first((List<? extends Object>) arrayList);
            NavBackStackEntry previousBackStackEntry = findNavController.getPreviousBackStackEntry();
            if (previousBackStackEntry != null && (savedStateHandle = previousBackStackEntry.getSavedStateHandle()) != null) {
                savedStateHandle.set("your_key", str2);
            }
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                UIHelper.INSTANCE.popCurrentPage(activity);
            }
        } else if (data instanceof Resource.Loading) {
            ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.loading);
            if (progressBar != null) {
                progressBar.setIndeterminate(true);
            }
            ProgressBar progressBar2 = (ProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.loading);
            if (progressBar2 == null) {
                return;
            }
            progressBar2.setVisibility(0);
        } else if (data instanceof Resource.Failure) {
            ProgressBar progressBar3 = (ProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.loading);
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
            Toast.makeText(this.this$0.getContext(), "Error ", 0).show();
        }
    }
}
