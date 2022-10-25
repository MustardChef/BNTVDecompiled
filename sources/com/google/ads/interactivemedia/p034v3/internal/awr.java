package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awr */
/* loaded from: classes2.dex */
final class awr extends avg {

    /* renamed from: a */
    final /* synthetic */ aws f5214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awr(aws awsVar) {
        this.f5214a = awsVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return true;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.f5214a.f5217c;
        atm.m4613i(i, i2);
        aws awsVar = this.f5214a;
        int i3 = i + i;
        objArr = awsVar.f5216b;
        Object obj = objArr[i3];
        obj.getClass();
        objArr2 = awsVar.f5216b;
        Object obj2 = objArr2[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.f5214a.f5217c;
        return i;
    }
}
