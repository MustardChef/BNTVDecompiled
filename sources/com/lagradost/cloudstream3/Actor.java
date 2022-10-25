package com.lagradost.cloudstream3;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAPI.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m107d2 = {"Lcom/lagradost/cloudstream3/Actor;", "", "name", "", "image", "(Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class Actor {
    private final String image;
    private final String name;

    public static /* synthetic */ Actor copy$default(Actor actor, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actor.name;
        }
        if ((i & 2) != 0) {
            str2 = actor.image;
        }
        return actor.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.image;
    }

    public final Actor copy(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Actor(name, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Actor) {
            Actor actor = (Actor) obj;
            return Intrinsics.areEqual(this.name, actor.name) && Intrinsics.areEqual(this.image, actor.image);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.image;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Actor(name=" + this.name + ", image=" + this.image + ')';
    }

    public Actor(String name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.image = str;
    }

    public /* synthetic */ Actor(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getImage() {
        return this.image;
    }
}
