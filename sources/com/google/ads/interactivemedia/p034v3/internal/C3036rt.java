package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rt */
/* loaded from: classes2.dex */
public final class C3036rt implements InterfaceC3169wr {

    /* renamed from: a */
    private final InterfaceC3169wr f8777a;

    /* renamed from: b */
    private final List f8778b;

    public C3036rt(InterfaceC3169wr interfaceC3169wr, List list) {
        this.f8777a = interfaceC3169wr;
        this.f8778b = list;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3169wr
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo714a(Uri uri, InputStream inputStream) throws IOException {
        InterfaceC3035rs interfaceC3035rs = (InterfaceC3035rs) this.f8777a.mo714a(uri, inputStream);
        List list = this.f8778b;
        return (list == null || list.isEmpty()) ? interfaceC3035rs : (InterfaceC3035rs) interfaceC3035rs.mo1188e(this.f8778b);
    }
}
