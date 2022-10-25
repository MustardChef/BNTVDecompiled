package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.p041ui.result.ImageAdapter;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageAdapter.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\u0014\u0010\u001f\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ImageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", TtmlNode.TAG_LAYOUT, "", "clickCallback", "Lkotlin/Function1;", "", "nextFocusUp", "nextFocusDown", "(ILkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getClickCallback", "()Lkotlin/jvm/functions/Function1;", "images", "", "getLayout", "()I", "getNextFocusDown", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNextFocusUp", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateList", "newList", "", "ImageViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ImageAdapter */
/* loaded from: classes4.dex */
public final class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Function1<Integer, Unit> clickCallback;
    private final List<Integer> images;
    private final int layout;
    private final Integer nextFocusDown;
    private final Integer nextFocusUp;

    public /* synthetic */ ImageAdapter(int i, Function1 function1, Integer num, Integer num2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2);
    }

    public final int getLayout() {
        return this.layout;
    }

    public final Function1<Integer, Unit> getClickCallback() {
        return this.clickCallback;
    }

    public final Integer getNextFocusUp() {
        return this.nextFocusUp;
    }

    public final Integer getNextFocusDown() {
        return this.nextFocusDown;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageAdapter(int i, Function1<? super Integer, Unit> function1, Integer num, Integer num2) {
        this.layout = i;
        this.clickCallback = function1;
        this.nextFocusUp = num;
        this.nextFocusDown = num2;
        this.images = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
        return new ImageViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).bind(this.images.get(i).intValue(), this.clickCallback, this.nextFocusUp, this.nextFocusDown);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.images.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.images.get(i).intValue();
    }

    public final void updateList(List<Integer> newList) {
        Intrinsics.checkNotNullParameter(newList, "newList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffCallback(this.images, newList));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …mages, newList)\n        )");
        this.images.clear();
        this.images.addAll(newList);
        calculateDiff.dispatchUpdatesTo(this);
    }

    /* compiled from: ImageAdapter.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J=\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ImageAdapter$ImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "img", "", "clickCallback", "Lkotlin/Function1;", "nextFocusUp", "nextFocusDown", "(ILkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/Integer;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ImageAdapter$ImageViewHolder */
    /* loaded from: classes4.dex */
    public static final class ImageViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void bind(int i, final Function1<? super Integer, Unit> function1, Integer num, Integer num2) {
            View view = this.itemView;
            ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
            if (imageView != null) {
                imageView.setImageResource(i);
                if (num2 != null) {
                    imageView.setNextFocusDownId(num2.intValue());
                }
                if (num != null) {
                    imageView.setNextFocusUpId(num.intValue());
                }
                if (function1 != null) {
                    SettingsFragment.Companion companion = SettingsFragment.Companion;
                    Context context = imageView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    if (companion.isTrueTvSettings(context)) {
                        imageView.setClickable(true);
                        imageView.setLongClickable(true);
                        imageView.setFocusable(true);
                        imageView.setFocusableInTouchMode(true);
                    }
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ImageAdapter$ImageViewHolder$ebs6Cv3SXHTbEIKBudES_BJfzXw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            ImageAdapter.ImageViewHolder.m8759bind$lambda2$lambda0(Function1.this, view2);
                        }
                    });
                    imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$ImageAdapter$ImageViewHolder$PpvBnjFpDFV9RWIfAWbau4uhMWw
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View view2) {
                            boolean m8760bind$lambda2$lambda1;
                            m8760bind$lambda2$lambda1 = ImageAdapter.ImageViewHolder.m8760bind$lambda2$lambda1(Function1.this, view2);
                            return m8760bind$lambda2$lambda1;
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-0  reason: not valid java name */
        public static final void m8759bind$lambda2$lambda0(Function1 function1, View view) {
            function1.invoke(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-2$lambda-1  reason: not valid java name */
        public static final boolean m8760bind$lambda2$lambda1(Function1 function1, View view) {
            function1.invoke(1);
            return true;
        }
    }
}
