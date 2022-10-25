package com.lagradost.cloudstream3.p041ui.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.p041ui.settings.AccountAdapter;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountAdapter.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/AccountAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "cardList", "", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", TtmlNode.TAG_LAYOUT, "", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/settings/AccountClickCallback;", "", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "getCardList", "()Ljava/util/List;", "getLayout", "()I", "getItemCount", "getItemId", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CardViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.settings.AccountAdapter */
/* loaded from: classes4.dex */
public final class AccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<AuthAPI.LoginInfo> cardList;
    private final Function1<AccountClickCallback, Unit> clickCallback;
    private final int layout;

    public /* synthetic */ AccountAdapter(List list, int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? R.layout.account_single : i, function1);
    }

    public final List<AuthAPI.LoginInfo> getCardList() {
        return this.cardList;
    }

    public final int getLayout() {
        return this.layout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AccountAdapter(List<AuthAPI.LoginInfo> cardList, int i, Function1<? super AccountClickCallback, Unit> clickCallback) {
        Intrinsics.checkNotNullParameter(cardList, "cardList");
        Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
        this.cardList = cardList;
        this.layout = i;
        this.clickCallback = clickCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…te(layout, parent, false)");
        return new CardViewHolder(inflate, this.clickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CardViewHolder) {
            ((CardViewHolder) holder).bind(this.cardList.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cardList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.cardList.get(i).getAccountIndex();
    }

    /* compiled from: AccountAdapter.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/settings/AccountAdapter$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/settings/AccountClickCallback;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "accountName", "Landroid/widget/TextView;", "pfp", "Landroid/widget/ImageView;", "bind", "card", "Lcom/lagradost/cloudstream3/syncproviders/AuthAPI$LoginInfo;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.settings.AccountAdapter$CardViewHolder */
    /* loaded from: classes4.dex */
    public static final class CardViewHolder extends RecyclerView.ViewHolder {
        private final TextView accountName;
        private final Function1<AccountClickCallback, Unit> clickCallback;
        private final ImageView pfp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public CardViewHolder(View itemView, Function1<? super AccountClickCallback, Unit> clickCallback) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(clickCallback, "clickCallback");
            this.clickCallback = clickCallback;
            View findViewById = itemView.findViewById(R.id.account_profile_picture);
            Intrinsics.checkNotNull(findViewById);
            this.pfp = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.account_name);
            Intrinsics.checkNotNull(findViewById2);
            this.accountName = (TextView) findViewById2;
        }

        public final void bind(final AuthAPI.LoginInfo card) {
            Intrinsics.checkNotNullParameter(card, "card");
            TextView textView = this.accountName;
            String name = card.getName();
            if (name == null) {
                name = String.format("%s %d", Arrays.copyOf(new Object[]{this.accountName.getContext().getString(R.string.account), Integer.valueOf(card.getAccountIndex())}, 2));
                Intrinsics.checkNotNullExpressionValue(name, "format(this, *args)");
            }
            textView.setText(name);
            this.pfp.setVisibility(UIHelper.setImage$default(UIHelper.INSTANCE, this.pfp, card.getProfilePicture(), null, null, 6, null) ? 0 : 8);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.settings.-$$Lambda$AccountAdapter$CardViewHolder$kBnWZZh2dT_EPo20mAzmc8M6CdI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AccountAdapter.CardViewHolder.m8893bind$lambda0(AccountAdapter.CardViewHolder.this, card, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8893bind$lambda0(CardViewHolder this$0, AuthAPI.LoginInfo card, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(card, "$card");
            Function1<AccountClickCallback, Unit> function1 = this$0.clickCallback;
            View itemView = this$0.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            function1.invoke(new AccountClickCallback(0, itemView, card));
        }
    }
}
