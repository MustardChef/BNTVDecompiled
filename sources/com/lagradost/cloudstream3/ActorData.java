package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/ActorData;", "", "actor", "Lcom/lagradost/cloudstream3/Actor;", "role", "Lcom/lagradost/cloudstream3/ActorRole;", "roleString", "", "voiceActor", "(Lcom/lagradost/cloudstream3/Actor;Lcom/lagradost/cloudstream3/ActorRole;Ljava/lang/String;Lcom/lagradost/cloudstream3/Actor;)V", "getActor", "()Lcom/lagradost/cloudstream3/Actor;", "getRole", "()Lcom/lagradost/cloudstream3/ActorRole;", "getRoleString", "()Ljava/lang/String;", "getVoiceActor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class ActorData {
    private final Actor actor;
    private final ActorRole role;
    private final String roleString;
    private final Actor voiceActor;

    public static /* synthetic */ ActorData copy$default(ActorData actorData, Actor actor, ActorRole actorRole, String str, Actor actor2, int i, Object obj) {
        if ((i & 1) != 0) {
            actor = actorData.actor;
        }
        if ((i & 2) != 0) {
            actorRole = actorData.role;
        }
        if ((i & 4) != 0) {
            str = actorData.roleString;
        }
        if ((i & 8) != 0) {
            actor2 = actorData.voiceActor;
        }
        return actorData.copy(actor, actorRole, str, actor2);
    }

    public final Actor component1() {
        return this.actor;
    }

    public final ActorRole component2() {
        return this.role;
    }

    public final String component3() {
        return this.roleString;
    }

    public final Actor component4() {
        return this.voiceActor;
    }

    public final ActorData copy(Actor actor, ActorRole actorRole, String str, Actor actor2) {
        Intrinsics.checkNotNullParameter(actor, "actor");
        return new ActorData(actor, actorRole, str, actor2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ActorData) {
            ActorData actorData = (ActorData) obj;
            return Intrinsics.areEqual(this.actor, actorData.actor) && this.role == actorData.role && Intrinsics.areEqual(this.roleString, actorData.roleString) && Intrinsics.areEqual(this.voiceActor, actorData.voiceActor);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.actor.hashCode() * 31;
        ActorRole actorRole = this.role;
        int hashCode2 = (hashCode + (actorRole == null ? 0 : actorRole.hashCode())) * 31;
        String str = this.roleString;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Actor actor = this.voiceActor;
        return hashCode3 + (actor != null ? actor.hashCode() : 0);
    }

    public String toString() {
        return "ActorData(actor=" + this.actor + ", role=" + this.role + ", roleString=" + this.roleString + ", voiceActor=" + this.voiceActor + ')';
    }

    public ActorData(Actor actor, ActorRole actorRole, String str, Actor actor2) {
        Intrinsics.checkNotNullParameter(actor, "actor");
        this.actor = actor;
        this.role = actorRole;
        this.roleString = str;
        this.voiceActor = actor2;
    }

    public /* synthetic */ ActorData(Actor actor, ActorRole actorRole, String str, Actor actor2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(actor, (i & 2) != 0 ? null : actorRole, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : actor2);
    }

    public final Actor getActor() {
        return this.actor;
    }

    public final ActorRole getRole() {
        return this.role;
    }

    public final String getRoleString() {
        return this.roleString;
    }

    public final Actor getVoiceActor() {
        return this.voiceActor;
    }
}
