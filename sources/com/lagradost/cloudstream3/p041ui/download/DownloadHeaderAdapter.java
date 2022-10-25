package com.lagradost.cloudstream3.p041ui.download;

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
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.download.DownloadHeaderAdapter;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadHeaderAdapter.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\fJ\u0012\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\tJ\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadHeaderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/download/DownloadHeaderClickEvent;", "", "movieClickCallback", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getCardList", "()Ljava/util/List;", "setCardList", "(Ljava/util/List;)V", "mBoundViewHolders", "Ljava/util/HashSet;", "Lcom/lagradost/cloudstream3/ui/download/DownloadButtonViewHolder;", "getAllBoundViewHolders", "", "getItemCount", "", "killAdapter", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "DownloadHeaderViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadHeaderAdapter */
/* loaded from: classes3.dex */
public final class DownloadHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<VisualDownloadHeaderCached> cardList;
    private final Function1<DownloadHeaderClickEvent, Unit> clickCallback;
    private final HashSet<DownloadButtonViewHolder> mBoundViewHolders;
    private final Function1<DownloadClickEvent, Unit> movieClickCallback;

    public final List<VisualDownloadHeaderCached> getCardList() {
        return this.cardList;
    }

    public final void setCardList(List<VisualDownloadHeaderCached> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cardList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadHeaderAdapter(List<VisualDownloadHeaderCached> cardList, Function1<? super DownloadHeaderClickEvent, Unit> clickCallback, Function1<? super DownloadClickEvent, Unit> movieClickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        Intrinsics.checkNotNullParameter(movieClickCallback, "movieClickCallback");
        this.cardList = cardList;
        this.clickCallback = clickCallback;
        this.movieClickCallback = movieClickCallback;
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
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.download_header_episode, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…r_episode, parent, false)");
        return new DownloadHeaderViewHolder(inflate, this.clickCallback, this.movieClickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DownloadHeaderViewHolder) {
            ((DownloadHeaderViewHolder) holder).bind(this.cardList.get(i));
            this.mBoundViewHolders.add(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardList.size();
    }

    /* compiled from: DownloadHeaderAdapter.kt */
    @Metadata(m108d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001bH\u0007J\b\u0010!\u001a\u00020\bH\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadHeaderAdapter$DownloadHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/lagradost/cloudstream3/ui/download/DownloadButtonViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/download/DownloadHeaderClickEvent;", "", "movieClickCallback", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "downloadBar", "Landroidx/core/widget/ContentLoadingProgressBar;", "downloadButton", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "getDownloadButton", "()Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "setDownloadButton", "(Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;)V", "downloadImage", "Landroid/widget/ImageView;", "extraInfo", "Landroid/widget/TextView;", "holder", "Landroidx/cardview/widget/CardView;", "localCard", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "normalImage", "poster", "title", "bind", "card", "reattachDownloadButton", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.DownloadHeaderAdapter$DownloadHeaderViewHolder */
    /* loaded from: classes3.dex */
    public static final class DownloadHeaderViewHolder extends RecyclerView.ViewHolder implements DownloadButtonViewHolder {
        private final Function1<DownloadHeaderClickEvent, Unit> clickCallback;
        private final ContentLoadingProgressBar downloadBar;
        private EasyDownloadButton downloadButton;
        private final ImageView downloadImage;
        private final TextView extraInfo;
        private final CardView holder;
        private VisualDownloadHeaderCached localCard;
        private final Function1<DownloadClickEvent, Unit> movieClickCallback;
        private final ImageView normalImage;
        private final ImageView poster;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public DownloadHeaderViewHolder(View itemView, Function1<? super DownloadHeaderClickEvent, Unit> clickCallback, Function1<? super DownloadClickEvent, Unit> movieClickCallback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            Intrinsics.checkNotNullParameter(movieClickCallback, "movieClickCallback");
            this.clickCallback = clickCallback;
            this.movieClickCallback = movieClickCallback;
            this.downloadButton = new EasyDownloadButton();
            this.poster = (ImageView) itemView.findViewById(C4761R.C4764id.download_header_poster);
            TextView textView = (TextView) itemView.findViewById(C4761R.C4764id.download_header_title);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.download_header_title");
            this.title = textView;
            TextView textView2 = (TextView) itemView.findViewById(C4761R.C4764id.download_header_info);
            Intrinsics.checkNotNullExpressionValue(textView2, "itemView.download_header_info");
            this.extraInfo = textView2;
            CardView cardView = (CardView) itemView.findViewById(C4761R.C4764id.episode_holder);
            Intrinsics.checkNotNullExpressionValue(cardView, "itemView.episode_holder");
            this.holder = cardView;
            ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) itemView.findViewById(C4761R.C4764id.download_header_progress_downloaded);
            Intrinsics.checkNotNullExpressionValue(contentLoadingProgressBar, "itemView.download_header_progress_downloaded");
            this.downloadBar = contentLoadingProgressBar;
            ImageView imageView = (ImageView) itemView.findViewById(C4761R.C4764id.download_header_episode_download);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.download_header_episode_download");
            this.downloadImage = imageView;
            ImageView imageView2 = (ImageView) itemView.findViewById(C4761R.C4764id.download_header_goto_child);
            Intrinsics.checkNotNullExpressionValue(imageView2, "itemView.download_header_goto_child");
            this.normalImage = imageView2;
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

        public final void bind(final VisualDownloadHeaderCached card) {
            Intrinsics.checkNotNullParameter(card, "card");
            this.localCard = card;
            final VideoDownloadHelper.DownloadHeaderCached data = card.getData();
            ImageView imageView = this.poster;
            if (imageView != null) {
                UIHelper.setImage$default(UIHelper.INSTANCE, imageView, data.getPoster(), null, null, 6, null);
            }
            ImageView imageView2 = this.poster;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$DownloadHeaderAdapter$DownloadHeaderViewHolder$ciI9uW7zU1HY5PMGqIQ32LM7MSA
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DownloadHeaderAdapter.DownloadHeaderViewHolder.m8625bind$lambda0(DownloadHeaderAdapter.DownloadHeaderViewHolder.this, data, view);
                    }
                });
            }
            this.title.setText(data.getName());
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) card.getTotalBytes()) / 1000000.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            if (card.getChild() != null) {
                this.downloadBar.setVisibility(0);
                this.downloadImage.setVisibility(0);
                this.normalImage.setVisibility(8);
                this.holder.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$DownloadHeaderAdapter$DownloadHeaderViewHolder$3zKNHTN8SDlUQQhBkNhNGx5LrME
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DownloadHeaderAdapter.DownloadHeaderViewHolder.m8626bind$lambda1(DownloadHeaderAdapter.DownloadHeaderViewHolder.this, card, view);
                    }
                });
                return;
            }
            this.downloadBar.setVisibility(8);
            this.downloadImage.setVisibility(8);
            this.normalImage.setVisibility(0);
            try {
                TextView textView = this.extraInfo;
                String string = textView.getContext().getString(R.string.extra_info_format);
                Intrinsics.checkNotNullExpressionValue(string, "extraInfo.context.getStr…string.extra_info_format)");
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(card.getTotalDownloads());
                objArr[1] = card.getTotalDownloads() == 1 ? this.extraInfo.getContext().getString(R.string.episode) : this.extraInfo.getContext().getString(R.string.episodes);
                objArr[2] = format;
                String format2 = String.format(string, Arrays.copyOf(objArr, 3));
                Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                textView.setText(format2);
            } catch (Exception e) {
                this.extraInfo.setText("Error");
                ArchComponentExt.logError(e);
            }
            this.holder.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$DownloadHeaderAdapter$DownloadHeaderViewHolder$B0w90_pwL4SLiiMh9QHkHFuv898
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadHeaderAdapter.DownloadHeaderViewHolder.m8627bind$lambda2(DownloadHeaderAdapter.DownloadHeaderViewHolder.this, data, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8625bind$lambda0(DownloadHeaderViewHolder this$0, VideoDownloadHelper.DownloadHeaderCached d, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(d, "$d");
            this$0.clickCallback.invoke(new DownloadHeaderClickEvent(1, d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-1  reason: not valid java name */
        public static final void m8626bind$lambda1(DownloadHeaderViewHolder this$0, VisualDownloadHeaderCached card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.movieClickCallback.invoke(new DownloadClickEvent(0, card.getChild()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-2  reason: not valid java name */
        public static final void m8627bind$lambda2(DownloadHeaderViewHolder this$0, VideoDownloadHelper.DownloadHeaderCached d, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(d, "$d");
            this$0.clickCallback.invoke(new DownloadHeaderClickEvent(0, d));
        }

        @Override // com.lagradost.cloudstream3.p041ui.download.DownloadButtonViewHolder
        public void reattachDownloadButton() {
            getDownloadButton().dispose();
            VisualDownloadHeaderCached visualDownloadHeaderCached = this.localCard;
            if ((visualDownloadHeaderCached != null ? visualDownloadHeaderCached.getChild() : null) != null) {
                getDownloadButton().setUpButton(Long.valueOf(visualDownloadHeaderCached.getCurrentBytes()), Long.valueOf(visualDownloadHeaderCached.getTotalBytes()), this.downloadBar, this.downloadImage, this.extraInfo, visualDownloadHeaderCached.getChild(), this.movieClickCallback);
            }
        }
    }
}
