package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awm */
/* loaded from: classes2.dex */
public final class awm extends atp {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    transient atn f5209a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awm(Map map, atn atnVar) {
        super(map);
        this.f5209a = atnVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f5209a = (atn) objectInputStream.readObject();
        m4578p((Map) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f5209a);
        objectOutputStream.writeObject(m4582i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.atp, com.google.ads.interactivemedia.p034v3.internal.auf
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Collection mo4455a() {
        return (List) this.f5209a.mo1308a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auf, com.google.ads.interactivemedia.p034v3.internal.aui
    /* renamed from: j */
    final Map mo4454j() {
        return m4581k();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.auf, com.google.ads.interactivemedia.p034v3.internal.aui
    /* renamed from: l */
    final Set mo4453l() {
        return m4580m();
    }
}
