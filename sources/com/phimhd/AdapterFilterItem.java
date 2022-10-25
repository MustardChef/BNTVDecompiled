package com.phimhd;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.Page;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdapterFilterItem.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, m107d2 = {"Lcom/phimhd/AdapterFilterItem;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/phimhd/AdapterFilterItem$ViewHolder;", "list", "", "Lcom/lagradost/cloudstream3/Page;", "iCallback", "Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "(Ljava/util/List;Lcom/lagradost/cloudstream3/ui/browser/ICallback;)V", "getICallback", "()Lcom/lagradost/cloudstream3/ui/browser/ICallback;", "getList", "()Ljava/util/List;", "clearSelected", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class AdapterFilterItem extends RecyclerView.Adapter<ViewHolder> {
    private final ICallback<Page> iCallback;
    private final List<Page> list;

    public final ICallback<Page> getICallback() {
        return this.iCallback;
    }

    public final List<Page> getList() {
        return this.list;
    }

    public AdapterFilterItem(List<Page> list, ICallback<Page> iCallback) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(iCallback, "iCallback");
        this.list = list;
        this.iCallback = iCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_item_layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…em_layout, parent, false)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final Page page = this.list.get(i);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        if (i == 0) {
            layoutParams2.setMargins(0, holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_top_filter_blur), 0, 0);
        } else if (i == getItemCount() - 1) {
            layoutParams2.setMargins(0, 0, 0, holder.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_bottom_filter_blur));
        } else {
            layoutParams2.setMargins(0, 0, 0, 0);
        }
        holder.itemView.setLayoutParams(layoutParams2);
        if (page.isSelected()) {
            TextView tvName = holder.getTvName();
            if (tvName != null) {
                tvName.setTextSize(22.0f);
            }
            TextView tvName2 = holder.getTvName();
            if (tvName2 != null) {
                tvName2.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white));
            }
            TextView tvName3 = holder.getTvName();
            if (tvName3 != null) {
                TextView tvName4 = holder.getTvName();
                tvName3.setTypeface(tvName4 != null ? tvName4.getTypeface() : null, 1);
            }
        } else {
            TextView tvName5 = holder.getTvName();
            if (tvName5 != null) {
                tvName5.setTextSize(16.0f);
            }
            TextView tvName6 = holder.getTvName();
            if (tvName6 != null) {
                tvName6.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.white_90));
            }
            TextView tvName7 = holder.getTvName();
            if (tvName7 != null) {
                TextView tvName8 = holder.getTvName();
                tvName7.setTypeface(tvName8 != null ? tvName8.getTypeface() : null, 0);
            }
        }
        if (page.getDescription() != null) {
            TextView tvDes = holder.getTvDes();
            if (tvDes != null) {
                tvDes.setText(page.getDescription());
            }
            TextView tvDes2 = holder.getTvDes();
            if (tvDes2 != null) {
                tvDes2.setVisibility(0);
            }
        } else {
            TextView tvDes3 = holder.getTvDes();
            if (tvDes3 != null) {
                tvDes3.setVisibility(8);
            }
        }
        TextView tvName9 = holder.getTvName();
        if (tvName9 != null) {
            tvName9.setText(page.getName());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.phimhd.-$$Lambda$AdapterFilterItem$CJ1WVOX-iDBpfVB-LZKrTMB4H0U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdapterFilterItem.m9029onBindViewHolder$lambda1(AdapterFilterItem.this, page, i, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m9029onBindViewHolder$lambda1(final AdapterFilterItem this$0, final Page item, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.clearSelected();
        item.setSelected(true);
        this$0.notifyItemChanged(i);
        new Handler().postDelayed(new Runnable() { // from class: com.phimhd.-$$Lambda$AdapterFilterItem$e5NOxep_RrYy0ONrnOqCsB_7YqY
            @Override // java.lang.Runnable
            public final void run() {
                AdapterFilterItem.m9030onBindViewHolder$lambda1$lambda0(AdapterFilterItem.this, item);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1$lambda-0  reason: not valid java name */
    public static final void m9030onBindViewHolder$lambda1$lambda0(AdapterFilterItem this$0, Page item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.iCallback.onCallback(item);
    }

    private final void clearSelected() {
        int size = this.list.size();
        for (int i = 0; i < size; i++) {
            Page page = this.list.get(i);
            if (page.isSelected()) {
                page.setSelected(false);
                notifyItemChanged(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Page> list = this.list;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* compiled from: AdapterFilterItem.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, m107d2 = {"Lcom/phimhd/AdapterFilterItem$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "tvDes", "Landroid/widget/TextView;", "getTvDes", "()Landroid/widget/TextView;", "setTvDes", "(Landroid/widget/TextView;)V", "tvName", "getTvName", "setTvName", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDes;
        private TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvDes = (TextView) itemView.findViewById(R.id.tvDes);
        }

        public final TextView getTvName() {
            return this.tvName;
        }

        public final void setTvName(TextView textView) {
            this.tvName = textView;
        }

        public final TextView getTvDes() {
            return this.tvDes;
        }

        public final void setTvDes(TextView textView) {
            this.tvDes = textView;
        }
    }
}
