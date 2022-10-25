package com.lagradost.cloudstream3.p041ui.result;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "list", "", "Lcom/lagradost/cloudstream3/ui/result/CurrentSynced;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$15 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$15 extends Lambda implements Function1<List<? extends CurrentSynced>, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$15(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends CurrentSynced> list) {
        invoke2((List<CurrentSynced>) list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ui/result/CurrentSynced;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$15$2 */
    /* loaded from: classes4.dex */
    public static final class C49442 extends Lambda implements Function1<CurrentSynced, CharSequence> {
        public static final C49442 INSTANCE = new C49442();

        C49442() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(CurrentSynced it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getName();
        }
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<CurrentSynced> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_names);
        if (textView != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                CurrentSynced currentSynced = (CurrentSynced) obj;
                if (currentSynced.isSynced() && currentSynced.getHasAccount()) {
                    arrayList.add(obj);
                }
            }
            textView.setText(CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, C49442.INSTANCE, 31, null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            CurrentSynced currentSynced2 = (CurrentSynced) obj2;
            if (currentSynced2.isSynced() && currentSynced2.getHasAccount()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList<CurrentSynced> arrayList3 = arrayList2;
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_mini_sync);
        if (recyclerView != null) {
            recyclerView.setVisibility(true ^ arrayList3.isEmpty() ? 0 : 8);
        }
        RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_mini_sync);
        RecyclerView.Adapter adapter = recyclerView2 != null ? recyclerView2.getAdapter() : null;
        ImageAdapter imageAdapter = adapter instanceof ImageAdapter ? (ImageAdapter) adapter : null;
        if (imageAdapter != null) {
            ArrayList arrayList4 = new ArrayList();
            for (CurrentSynced currentSynced3 : arrayList3) {
                Integer icon = currentSynced3.getIcon();
                if (icon != null) {
                    arrayList4.add(icon);
                }
            }
            imageAdapter.updateList(arrayList4);
        }
    }
}
