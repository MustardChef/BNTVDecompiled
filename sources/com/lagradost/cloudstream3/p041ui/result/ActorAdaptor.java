package com.lagradost.cloudstream3.p041ui.result;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.C4761R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActorAdaptor.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ActorAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "actors", "", "Lcom/lagradost/cloudstream3/ui/result/ActorAdaptor$ActorMetaData;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateActorList", "newList", "", "updateList", "Lcom/lagradost/cloudstream3/ActorData;", "ActorMetaData", "CardViewHolder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ActorAdaptor */
/* loaded from: classes4.dex */
public final class ActorAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ActorMetaData> actors = new ArrayList();

    /* compiled from: ActorAdaptor.kt */
    @Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ActorAdaptor$ActorMetaData;", "", "isInverted", "", "actor", "Lcom/lagradost/cloudstream3/ActorData;", "(ZLcom/lagradost/cloudstream3/ActorData;)V", "getActor", "()Lcom/lagradost/cloudstream3/ActorData;", "()Z", "setInverted", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ActorAdaptor$ActorMetaData */
    /* loaded from: classes4.dex */
    public static final class ActorMetaData {
        private final ActorData actor;
        private boolean isInverted;

        public static /* synthetic */ ActorMetaData copy$default(ActorMetaData actorMetaData, boolean z, ActorData actorData, int i, Object obj) {
            if ((i & 1) != 0) {
                z = actorMetaData.isInverted;
            }
            if ((i & 2) != 0) {
                actorData = actorMetaData.actor;
            }
            return actorMetaData.copy(z, actorData);
        }

        public final boolean component1() {
            return this.isInverted;
        }

        public final ActorData component2() {
            return this.actor;
        }

        public final ActorMetaData copy(boolean z, ActorData actor) {
            Intrinsics.checkNotNullParameter(actor, "actor");
            return new ActorMetaData(z, actor);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ActorMetaData) {
                ActorMetaData actorMetaData = (ActorMetaData) obj;
                return this.isInverted == actorMetaData.isInverted && Intrinsics.areEqual(this.actor, actorMetaData.actor);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.isInverted;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (r0 * 31) + this.actor.hashCode();
        }

        public String toString() {
            return "ActorMetaData(isInverted=" + this.isInverted + ", actor=" + this.actor + ')';
        }

        public ActorMetaData(boolean z, ActorData actor) {
            Intrinsics.checkNotNullParameter(actor, "actor");
            this.isInverted = z;
            this.actor = actor;
        }

        public final boolean isInverted() {
            return this.isInverted;
        }

        public final void setInverted(boolean z) {
            this.isInverted = z;
        }

        public final ActorData getActor() {
            return this.actor;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…cast_item, parent, false)");
        return new CardViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CardViewHolder) {
            ((CardViewHolder) holder).bind(this.actors.get(i).getActor(), this.actors.get(i).isInverted(), i, new ActorAdaptor$onBindViewHolder$1(this, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.actors.size();
    }

    private final void updateActorList(List<ActorMetaData> list) {
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new ActorDiffCallback(this.actors, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(\n         …ctors, newList)\n        )");
        this.actors.clear();
        this.actors.addAll(list);
        calculateDiff.dispatchUpdatesTo(this);
    }

    public final void updateList(List<ActorData> newList) {
        ActorMetaData actorMetaData;
        Intrinsics.checkNotNullParameter(newList, "newList");
        if (this.actors.size() >= newList.size()) {
            List<ActorData> list = newList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(ActorMetaData.copy$default(this.actors.get(i), false, (ActorData) obj, 1, null));
                i = i2;
            }
            updateActorList(arrayList);
            return;
        }
        List<ActorData> list2 = newList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        int i3 = 0;
        for (Object obj2 : list2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ActorData actorData = (ActorData) obj2;
            if (i3 < this.actors.size()) {
                actorMetaData = ActorMetaData.copy$default(this.actors.get(i3), false, actorData, 1, null);
            } else {
                actorMetaData = new ActorMetaData(false, actorData);
            }
            arrayList2.add(actorMetaData);
            i3 = i4;
        }
        updateActorList(arrayList2);
    }

    /* compiled from: ActorAdaptor.kt */
    @Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ActorAdaptor$CardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "actorExtra", "Landroid/widget/TextView;", "actorImage", "Landroid/widget/ImageView;", "actorName", "voiceActorImage", "voiceActorImageHolder", "voiceActorName", "bind", "", "actor", "Lcom/lagradost/cloudstream3/ActorData;", "isInverted", "", "position", "", "callback", "Lkotlin/Function1;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ActorAdaptor$CardViewHolder */
    /* loaded from: classes4.dex */
    private static final class CardViewHolder extends RecyclerView.ViewHolder {
        private final TextView actorExtra;
        private final ImageView actorImage;
        private final TextView actorName;
        private final ImageView voiceActorImage;
        private final View voiceActorImageHolder;
        private final TextView voiceActorName;

        /* compiled from: ActorAdaptor.kt */
        @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
        /* renamed from: com.lagradost.cloudstream3.ui.result.ActorAdaptor$CardViewHolder$WhenMappings */
        /* loaded from: classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ActorRole.values().length];
                iArr[ActorRole.Main.ordinal()] = 1;
                iArr[ActorRole.Supporting.ordinal()] = 2;
                iArr[ActorRole.Background.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            ImageView imageView = (ImageView) itemView.findViewById(C4761R.C4764id.actor_image);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.actor_image");
            this.actorImage = imageView;
            TextView textView = (TextView) itemView.findViewById(C4761R.C4764id.actor_name);
            Intrinsics.checkNotNullExpressionValue(textView, "itemView.actor_name");
            this.actorName = textView;
            TextView textView2 = (TextView) itemView.findViewById(C4761R.C4764id.actor_extra);
            Intrinsics.checkNotNullExpressionValue(textView2, "itemView.actor_extra");
            this.actorExtra = textView2;
            ImageView imageView2 = (ImageView) itemView.findViewById(C4761R.C4764id.voice_actor_image);
            Intrinsics.checkNotNullExpressionValue(imageView2, "itemView.voice_actor_image");
            this.voiceActorImage = imageView2;
            CardView cardView = (CardView) itemView.findViewById(C4761R.C4764id.voice_actor_image_holder);
            Intrinsics.checkNotNullExpressionValue(cardView, "itemView.voice_actor_image_holder");
            this.voiceActorImageHolder = cardView;
            TextView textView3 = (TextView) itemView.findViewById(C4761R.C4764id.voice_actor_name);
            Intrinsics.checkNotNullExpressionValue(textView3, "itemView.voice_actor_name");
            this.voiceActorName = textView3;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void bind(com.lagradost.cloudstream3.ActorData r19, boolean r20, final int r21, final kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r22) {
            /*
                Method dump skipped, instructions count: 324
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ActorAdaptor.CardViewHolder.bind(com.lagradost.cloudstream3.ActorData, boolean, int, kotlin.jvm.functions.Function1):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bind$lambda-0  reason: not valid java name */
        public static final void m8753bind$lambda0(Function1 callback, int i, View view) {
            Intrinsics.checkNotNullParameter(callback, "$callback");
            callback.invoke(Integer.valueOf(i));
        }
    }
}
