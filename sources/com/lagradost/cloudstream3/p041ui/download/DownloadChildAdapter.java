package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.download.DownloadChildAdapter;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadChildAdapter.kt */
@Metadata(m108d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\tJ\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadChildAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadChildCached;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getCardList", "()Ljava/util/List;", "setCardList", "(Ljava/util/List;)V", "mBoundViewHolders", "Ljava/util/HashSet;", "Lcom/lagradost/cloudstream3/ui/download/DownloadButtonViewHolder;", "getAllBoundViewHolders", "", "getItemCount", "", "killAdapter", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "DownloadChildViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildAdapter */
/* loaded from: classes3.dex */
public final class DownloadChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<VisualDownloadChildCached> cardList;
    private final Function1<DownloadClickEvent, Unit> clickCallback;
    private final HashSet<DownloadButtonViewHolder> mBoundViewHolders;

    public final List<VisualDownloadChildCached> getCardList() {
        return this.cardList;
    }

    public final void setCardList(List<VisualDownloadChildCached> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cardList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadChildAdapter(List<VisualDownloadChildCached> cardList, Function1<? super DownloadClickEvent, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.cardList = cardList;
        this.clickCallback = clickCallback;
        this.mBoundViewHolders = new HashSet<>();
    }

    private final Set<DownloadButtonViewHolder> getAllBoundViewHolders() {
        return Collections.unmodifiableSet(this.mBoundViewHolders);
    }

    public final void killAdapter() {
        EasyDownloadButton downloadButton;
        Set<DownloadButtonViewHolder> allBoundViewHolders = getAllBoundViewHolders();
        if (allBoundViewHolders != null) {
            for (DownloadButtonViewHolder downloadButtonViewHolder : allBoundViewHolders) {
                if (downloadButtonViewHolder != null && (downloadButton = downloadButtonViewHolder.getDownloadButton()) != null) {
                    downloadButton.dispose();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DownloadButtonViewHolder) {
            ((DownloadButtonViewHolder) holder).getDownloadButton().dispose();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DownloadButtonViewHolder) {
            ((DownloadButtonViewHolder) holder).getDownloadButton().dispose();
            this.mBoundViewHolders.remove(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DownloadButtonViewHolder) {
            ((DownloadButtonViewHolder) holder).reattachDownloadButton();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_child_episode, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…d_episode, parent, false)");
        return new DownloadChildViewHolder(inflate, this.clickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DownloadChildViewHolder) {
            ((DownloadChildViewHolder) holder).bind(this.cardList.get(i));
            this.mBoundViewHolders.add(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardList.size();
    }

    /* compiled from: DownloadChildAdapter.kt */
    @Metadata(m108d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadChildAdapter$DownloadChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/lagradost/cloudstream3/ui/download/DownloadButtonViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "downloadButton", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "getDownloadButton", "()Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "setDownloadButton", "(Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;)V", "downloadImage", "Landroid/widget/ImageView;", "extraInfo", "Landroid/widget/TextView;", "holder", "Landroidx/cardview/widget/CardView;", "localCard", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadChildCached;", "progressBar", "Landroidx/core/widget/ContentLoadingProgressBar;", "progressBarDownload", "title", "bind", "card", "reattachDownloadButton", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildAdapter$DownloadChildViewHolder */
    /* loaded from: classes3.dex */
    public static final class DownloadChildViewHolder extends RecyclerView.ViewHolder implements DownloadButtonViewHolder {
        private final Function1<DownloadClickEvent, Unit> clickCallback;
        private EasyDownloadButton downloadButton;
        private final ImageView downloadImage;
        private final TextView extraInfo;
        private final CardView holder;
        private VisualDownloadChildCached localCard;
        private final ContentLoadingProgressBar progressBar;
        private final ContentLoadingProgressBar progressBarDownload;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DownloadChildViewHolder(View itemView, Function1<? super DownloadClickEvent, Unit> clickCallback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            this.clickCallback = clickCallback;
            this.downloadButton = new EasyDownloadButton();
            TextView textView = (TextView) itemView.findViewById(C4761R.C4764id.download_child_episode_text);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.download_child_episode_text");
            this.title = textView;
            TextView textView2 = (TextView) itemView.findViewById(C4761R.C4764id.download_child_episode_text_extra);
            Intrinsics.checkNotNullExpressionValue(textView2, "itemView.download_child_episode_text_extra");
            this.extraInfo = textView2;
            CardView cardView = (CardView) itemView.findViewById(C4761R.C4764id.download_child_episode_holder);
            Intrinsics.checkNotNullExpressionValue(cardView, "itemView.download_child_episode_holder");
            this.holder = cardView;
            ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) itemView.findViewById(C4761R.C4764id.download_child_episode_progress);
            Intrinsics.checkNotNullExpressionValue(contentLoadingProgressBar, "itemView.download_child_episode_progress");
            this.progressBar = contentLoadingProgressBar;
            ContentLoadingProgressBar contentLoadingProgressBar2 = (ContentLoadingProgressBar) itemView.findViewById(C4761R.C4764id.download_child_episode_progress_downloaded);
            Intrinsics.checkNotNullExpressionValue(contentLoadingProgressBar2, "itemView.download_child_…isode_progress_downloaded");
            this.progressBarDownload = contentLoadingProgressBar2;
            ImageView imageView = (ImageView) itemView.findViewById(C4761R.C4764id.download_child_episode_download);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.download_child_episode_download");
            this.downloadImage = imageView;
        }

        @Override // com.lagradost.cloudstream3.p041ui.download.DownloadButtonViewHolder
        public EasyDownloadButton getDownloadButton() {
            return this.downloadButton;
        }

        @Override // com.lagradost.cloudstream3.p041ui.download.DownloadButtonViewHolder
        public void setDownloadButton(EasyDownloadButton easyDownloadButton) {
            Intrinsics.checkNotNullParameter(easyDownloadButton, "<set-?>");
            this.downloadButton = easyDownloadButton;
        }

        public final void bind(VisualDownloadChildCached card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.localCard = card;
            final VideoDownloadHelper.DownloadEpisodeCached data = card.getData();
            DataStoreHelper.PosDur viewPos = DataStoreHelper.INSTANCE.getViewPos(Integer.valueOf(data.getId()));
            if (viewPos != null) {
                DataStoreHelper.PosDur fixVisual = DataStoreHelper.INSTANCE.fixVisual(viewPos);
                long j = 1000;
                this.progressBar.setMax((int) (fixVisual.getDuration() / j));
                this.progressBar.setProgress((int) (fixVisual.getPosition() / j));
                this.progressBar.setVisibility(0);
            } else {
                this.progressBar.setVisibility(8);
            }
            TextView textView = this.title;
            AppUtils appUtils = AppUtils.INSTANCE;
            Context context = this.title.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "title.context");
            textView.setText(appUtils.getNameFull(context, data.getName(), Integer.valueOf(data.getEpisode()), data.getSeason()));
            this.title.setSelected(true);
            getDownloadButton().setUpButton(Long.valueOf(card.getCurrentBytes()), Long.valueOf(card.getTotalBytes()), this.progressBarDownload, this.downloadImage, this.extraInfo, card.getData(), this.clickCallback);
            this.holder.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$DownloadChildAdapter$DownloadChildViewHolder$qd_faaq8AeT61_45y0sJl8XuQ_M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadChildAdapter.DownloadChildViewHolder.m8622bind$lambda0(DownloadChildAdapter.DownloadChildViewHolder.this, data, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8622bind$lambda0(DownloadChildViewHolder this$0, VideoDownloadHelper.DownloadEpisodeCached d, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(d, "$d");
            this$0.clickCallback.invoke(new DownloadClickEvent(0, d));
        }

        @Override // com.lagradost.cloudstream3.p041ui.download.DownloadButtonViewHolder
        public void reattachDownloadButton() {
            getDownloadButton().dispose();
            VisualDownloadChildCached visualDownloadChildCached = this.localCard;
            if (visualDownloadChildCached != null) {
                getDownloadButton().setUpButton(Long.valueOf(visualDownloadChildCached.getCurrentBytes()), Long.valueOf(visualDownloadChildCached.getTotalBytes()), this.progressBarDownload, this.downloadImage, this.extraInfo, visualDownloadChildCached.getData(), this.clickCallback);
            }
        }
    }
}
