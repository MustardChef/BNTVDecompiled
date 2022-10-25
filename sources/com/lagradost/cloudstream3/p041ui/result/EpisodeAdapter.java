package com.lagradost.cloudstream3.p041ui.result;

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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.download.DownloadButtonViewHolder;
import com.lagradost.cloudstream3.p041ui.download.DownloadClickEvent;
import com.lagradost.cloudstream3.p041ui.download.EasyDownloadButton;
import com.lagradost.cloudstream3.p041ui.result.EpisodeAdapter;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EpisodeAdapter.kt */
@Metadata(m108d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'BC\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0006\u0010\u001b\u001a\u00020\u000bJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0006\u0010&\u001a\u00020\u000bR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/EpisodeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "hasDownloadSupport", "", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/result/EpisodeClickEvent;", "", "downloadClickCallback", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getCardList", "()Ljava/util/List;", "setCardList", "(Ljava/util/List;)V", TtmlNode.TAG_LAYOUT, "", "mBoundViewHolders", "Ljava/util/HashSet;", "Lcom/lagradost/cloudstream3/ui/download/DownloadButtonViewHolder;", "getAllBoundViewHolders", "", "getItemCount", "killAdapter", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "updateLayout", "EpisodeCardViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.EpisodeAdapter */
/* loaded from: classes4.dex */
public final class EpisodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResultEpisode> cardList;
    private final Function1<EpisodeClickEvent, Unit> clickCallback;
    private final Function1<DownloadClickEvent, Unit> downloadClickCallback;
    private final boolean hasDownloadSupport;
    private int layout;
    private final HashSet<DownloadButtonViewHolder> mBoundViewHolders;

    public final List<ResultEpisode> getCardList() {
        return this.cardList;
    }

    public final void setCardList(List<ResultEpisode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cardList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EpisodeAdapter(List<ResultEpisode> cardList, boolean z, Function1<? super EpisodeClickEvent, Unit> clickCallback, Function1<? super DownloadClickEvent, Unit> downloadClickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        Intrinsics.checkNotNullParameter(downloadClickCallback, "downloadClickCallback");
        this.cardList = cardList;
        this.hasDownloadSupport = z;
        this.clickCallback = clickCallback;
        this.downloadClickCallback = downloadClickCallback;
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

    public final void updateLayout() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.cardList) {
            if (((ResultEpisode) obj).getPoster() != null) {
                arrayList.add(obj);
            }
        }
        this.layout = ((float) arrayList.size()) >= ((float) this.cardList.size()) / 2.0f ? R.layout.result_episode_large : R.layout.result_episode;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
        return new EpisodeCardViewHolder(inflate, this.hasDownloadSupport, this.clickCallback, this.downloadClickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof EpisodeCardViewHolder) {
            ((EpisodeCardViewHolder) holder).bind(this.cardList.get(i));
            this.mBoundViewHolders.add(holder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardList.size();
    }

    /* compiled from: EpisodeAdapter.kt */
    @Metadata(m108d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\rJ\u0010\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020$H\u0007J\b\u0010+\u001a\u00020\nH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/EpisodeAdapter$EpisodeCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/lagradost/cloudstream3/ui/download/DownloadButtonViewHolder;", "itemView", "Landroid/view/View;", "hasDownloadSupport", "", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/result/EpisodeClickEvent;", "", "downloadClickCallback", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "(Landroid/view/View;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "downloadButton", "Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "getDownloadButton", "()Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;", "setDownloadButton", "(Lcom/lagradost/cloudstream3/ui/download/EasyDownloadButton;)V", "episodeDescript", "Landroid/widget/TextView;", "episodeDownloadBar", "Landroidx/core/widget/ContentLoadingProgressBar;", "episodeDownloadImage", "Landroid/widget/ImageView;", "episodeFiller", "Lcom/google/android/material/button/MaterialButton;", "episodeHolder", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "episodePoster", "episodeProgress", "episodeRating", "episodeText", "localCard", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "getLocalCard", "()Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "setLocalCard", "(Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;)V", "bind", "card", "reattachDownloadButton", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.EpisodeAdapter$EpisodeCardViewHolder */
    /* loaded from: classes4.dex */
    public static final class EpisodeCardViewHolder extends RecyclerView.ViewHolder implements DownloadButtonViewHolder {
        private final Function1<EpisodeClickEvent, Unit> clickCallback;
        private EasyDownloadButton downloadButton;
        private final Function1<DownloadClickEvent, Unit> downloadClickCallback;
        private final TextView episodeDescript;
        private final ContentLoadingProgressBar episodeDownloadBar;
        private final ImageView episodeDownloadImage;
        private final MaterialButton episodeFiller;
        private final CardView episodeHolder;
        private final ImageView episodePoster;
        private final ContentLoadingProgressBar episodeProgress;
        private final TextView episodeRating;
        private final TextView episodeText;
        private final boolean hasDownloadSupport;
        private ResultEpisode localCard;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public EpisodeCardViewHolder(View itemView, boolean z, Function1<? super EpisodeClickEvent, Unit> clickCallback, Function1<? super DownloadClickEvent, Unit> downloadClickCallback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            Intrinsics.checkNotNullParameter(downloadClickCallback, "downloadClickCallback");
            this.hasDownloadSupport = z;
            this.clickCallback = clickCallback;
            this.downloadClickCallback = downloadClickCallback;
            this.downloadButton = new EasyDownloadButton();
            TextView textView = (TextView) itemView.findViewById(C4761R.C4764id.episode_text);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.episode_text");
            this.episodeText = textView;
            this.episodeFiller = (MaterialButton) itemView.findViewById(C4761R.C4764id.episode_filler);
            this.episodeRating = (TextView) itemView.findViewById(C4761R.C4764id.episode_rating);
            this.episodeDescript = (TextView) itemView.findViewById(C4761R.C4764id.episode_descript);
            this.episodeProgress = (ContentLoadingProgressBar) itemView.findViewById(C4761R.C4764id.episode_progress);
            this.episodePoster = (ImageView) itemView.findViewById(C4761R.C4764id.episode_poster);
            ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) itemView.findViewById(C4761R.C4764id.result_episode_progress_downloaded);
            Intrinsics.checkNotNullExpressionValue(contentLoadingProgressBar, "itemView.result_episode_progress_downloaded");
            this.episodeDownloadBar = contentLoadingProgressBar;
            ImageView imageView = (ImageView) itemView.findViewById(C4761R.C4764id.result_episode_download);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.result_episode_download");
            this.episodeDownloadImage = imageView;
            this.episodeHolder = (CardView) itemView.findViewById(C4761R.C4764id.episode_holder);
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

        public final ResultEpisode getLocalCard() {
            return this.localCard;
        }

        public final void setLocalCard(ResultEpisode resultEpisode) {
            this.localCard = resultEpisode;
        }

        public final void bind(final ResultEpisode card) {
            StringBuilder sb;
            String str;
            Context context;
            String string;
            Intrinsics.checkNotNullParameter(card, "card");
            this.localCard = card;
            if (card.getName() == null) {
                sb = new StringBuilder();
                sb.append(this.episodeText.getContext().getString(R.string.episode));
                sb.append(' ');
                sb.append(card.getEpisode());
            } else {
                sb = new StringBuilder();
                sb.append(card.getEpisode());
                sb.append(". ");
                sb.append(card.getName());
            }
            String sb2 = sb.toString();
            MaterialButton materialButton = this.episodeFiller;
            if (materialButton != null) {
                materialButton.setVisibility(Intrinsics.areEqual((Object) card.isFiller(), (Object) true) ? 0 : 8);
            }
            this.episodeText.setText(sb2);
            this.episodeText.setSelected(true);
            long displayPosition = ResultFragmentPhimHDKt.getDisplayPosition(card);
            ContentLoadingProgressBar contentLoadingProgressBar = this.episodeProgress;
            if (contentLoadingProgressBar != null) {
                contentLoadingProgressBar.setMax((int) (card.getDuration() / 1000));
            }
            ContentLoadingProgressBar contentLoadingProgressBar2 = this.episodeProgress;
            if (contentLoadingProgressBar2 != null) {
                contentLoadingProgressBar2.setProgress((int) (displayPosition / 1000));
            }
            ContentLoadingProgressBar contentLoadingProgressBar3 = this.episodeProgress;
            if (contentLoadingProgressBar3 != null) {
                contentLoadingProgressBar3.setVisibility(displayPosition > 0 ? 0 : 8);
            }
            if (card.getPoster() != null) {
                ImageView imageView = this.episodePoster;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                ImageView imageView2 = this.episodePoster;
                if (imageView2 != null) {
                    UIHelper.setImage$default(UIHelper.INSTANCE, imageView2, card.getPoster(), null, null, 6, null);
                }
            } else {
                ImageView imageView3 = this.episodePoster;
                if (imageView3 != null) {
                    imageView3.setVisibility(8);
                }
            }
            if (card.getRating() != null) {
                TextView textView = this.episodeRating;
                if (textView != null) {
                    if (textView == null || (context = textView.getContext()) == null || (string = context.getString(R.string.rated_format)) == null) {
                        str = null;
                    } else {
                        str = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(card.getRating().intValue() / 10.0f)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(this, *args)");
                    }
                    textView.setText(str);
                }
            } else {
                TextView textView2 = this.episodeRating;
                if (textView2 != null) {
                    textView2.setText("");
                }
            }
            if (card.getDescription() != null) {
                TextView textView3 = this.episodeDescript;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = this.episodeDescript;
                if (textView4 != null) {
                    textView4.setText(card.getDescription());
                }
            } else {
                TextView textView5 = this.episodeDescript;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            }
            ImageView imageView4 = this.episodePoster;
            if (imageView4 != null) {
                imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$EpisodeAdapter$EpisodeCardViewHolder$hpSo3PdWLu3t7mraFmGjtdl7xGQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        EpisodeAdapter.EpisodeCardViewHolder.m8754bind$lambda0(EpisodeAdapter.EpisodeCardViewHolder.this, card, view);
                    }
                });
            }
            ImageView imageView5 = this.episodePoster;
            if (imageView5 != null) {
                imageView5.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$EpisodeAdapter$EpisodeCardViewHolder$H0X8QY2nVVKgKis1YUyfxQL_iOw
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean m8755bind$lambda1;
                        m8755bind$lambda1 = EpisodeAdapter.EpisodeCardViewHolder.m8755bind$lambda1(EpisodeAdapter.EpisodeCardViewHolder.this, card, view);
                        return m8755bind$lambda1;
                    }
                });
            }
            this.episodeHolder.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$EpisodeAdapter$EpisodeCardViewHolder$VP0GW3WKvVSJ-wfPpH10jig36Po
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EpisodeAdapter.EpisodeCardViewHolder.m8756bind$lambda2(EpisodeAdapter.EpisodeCardViewHolder.this, card, view);
                }
            });
            SettingsFragment.Companion companion = SettingsFragment.Companion;
            Context context2 = this.episodeHolder.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "episodeHolder.context");
            if (companion.isTrueTvSettings(context2)) {
                this.episodeHolder.setFocusable(true);
                this.episodeHolder.setFocusableInTouchMode(true);
                this.episodeHolder.setTouchscreenBlocksFocus(false);
            }
            this.episodeHolder.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.result.-$$Lambda$EpisodeAdapter$EpisodeCardViewHolder$dSo0Svc_cii1czG5TxbCRsV4yGE
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean m8757bind$lambda3;
                    m8757bind$lambda3 = EpisodeAdapter.EpisodeCardViewHolder.m8757bind$lambda3(EpisodeAdapter.EpisodeCardViewHolder.this, card, view);
                    return m8757bind$lambda3;
                }
            });
            this.episodeDownloadImage.setVisibility(this.hasDownloadSupport ? 0 : 8);
            this.episodeDownloadBar.setVisibility(this.hasDownloadSupport ? 0 : 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8754bind$lambda0(EpisodeCardViewHolder this$0, ResultEpisode card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.clickCallback.invoke(new EpisodeClickEvent(11, card));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-1  reason: not valid java name */
        public static final boolean m8755bind$lambda1(EpisodeCardViewHolder this$0, ResultEpisode card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.clickCallback.invoke(new EpisodeClickEvent(12, card));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-2  reason: not valid java name */
        public static final void m8756bind$lambda2(EpisodeCardViewHolder this$0, ResultEpisode card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.clickCallback.invoke(new EpisodeClickEvent(11, card));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-3  reason: not valid java name */
        public static final boolean m8757bind$lambda3(EpisodeCardViewHolder this$0, ResultEpisode card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            this$0.clickCallback.invoke(new EpisodeClickEvent(10, card));
            return true;
        }

        @Override // com.lagradost.cloudstream3.p041ui.download.DownloadButtonViewHolder
        public void reattachDownloadButton() {
            getDownloadButton().dispose();
            ResultEpisode resultEpisode = this.localCard;
            if (!this.hasDownloadSupport || resultEpisode == null) {
                return;
            }
            VideoDownloadManager videoDownloadManager = VideoDownloadManager.INSTANCE;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            VideoDownloadManager.DownloadedFileInfoResult downloadFileInfoAndUpdateSettings = videoDownloadManager.getDownloadFileInfoAndUpdateSettings(context, resultEpisode.getId());
            getDownloadButton().setUpButton(downloadFileInfoAndUpdateSettings != null ? Long.valueOf(downloadFileInfoAndUpdateSettings.getFileLength()) : null, downloadFileInfoAndUpdateSettings != null ? Long.valueOf(downloadFileInfoAndUpdateSettings.getTotalBytes()) : null, this.episodeDownloadBar, this.episodeDownloadImage, null, new VideoDownloadHelper.DownloadEpisodeCached(resultEpisode.getName(), resultEpisode.getPoster(), resultEpisode.getEpisode(), resultEpisode.getSeason(), resultEpisode.getId(), resultEpisode.getParentId(), resultEpisode.getRating(), resultEpisode.getDescription(), System.currentTimeMillis()), new EpisodeAdapter$EpisodeCardViewHolder$reattachDownloadButton$1(this, resultEpisode));
        }
    }
}
