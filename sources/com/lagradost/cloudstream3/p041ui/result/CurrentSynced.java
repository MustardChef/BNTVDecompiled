package com.lagradost.cloudstream3.p041ui.result;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SyncViewModel.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000eJB\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/CurrentSynced;", "", "name", "", "idPrefix", "isSynced", "", "hasAccount", "icon", "", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;)V", "getHasAccount", "()Z", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdPrefix", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Integer;)Lcom/lagradost/cloudstream3/ui/result/CurrentSynced;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.CurrentSynced */
/* loaded from: classes4.dex */
public final class CurrentSynced {
    private final boolean hasAccount;
    private final Integer icon;
    private final String idPrefix;
    private final boolean isSynced;
    private final String name;

    public static /* synthetic */ CurrentSynced copy$default(CurrentSynced currentSynced, String str, String str2, boolean z, boolean z2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = currentSynced.name;
        }
        if ((i & 2) != 0) {
            str2 = currentSynced.idPrefix;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = currentSynced.isSynced;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            z2 = currentSynced.hasAccount;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            num = currentSynced.icon;
        }
        return currentSynced.copy(str, str3, z3, z4, num);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.idPrefix;
    }

    public final boolean component3() {
        return this.isSynced;
    }

    public final boolean component4() {
        return this.hasAccount;
    }

    public final Integer component5() {
        return this.icon;
    }

    public final CurrentSynced copy(String name, String idPrefix, boolean z, boolean z2, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(idPrefix, "idPrefix");
        return new CurrentSynced(name, idPrefix, z, z2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CurrentSynced) {
            CurrentSynced currentSynced = (CurrentSynced) obj;
            return Intrinsics.areEqual(this.name, currentSynced.name) && Intrinsics.areEqual(this.idPrefix, currentSynced.idPrefix) && this.isSynced == currentSynced.isSynced && this.hasAccount == currentSynced.hasAccount && Intrinsics.areEqual(this.icon, currentSynced.icon);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.idPrefix.hashCode()) * 31;
        boolean z = this.isSynced;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.hasAccount;
        int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
        Integer num = this.icon;
        return i3 + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "CurrentSynced(name=" + this.name + ", idPrefix=" + this.idPrefix + ", isSynced=" + this.isSynced + ", hasAccount=" + this.hasAccount + ", icon=" + this.icon + ')';
    }

    public CurrentSynced(String name, String idPrefix, boolean z, boolean z2, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(idPrefix, "idPrefix");
        this.name = name;
        this.idPrefix = idPrefix;
        this.isSynced = z;
        this.hasAccount = z2;
        this.icon = num;
    }

    public final String getName() {
        return this.name;
    }

    public final String getIdPrefix() {
        return this.idPrefix;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public final boolean getHasAccount() {
        return this.hasAccount;
    }

    public final Integer getIcon() {
        return this.icon;
    }
}
