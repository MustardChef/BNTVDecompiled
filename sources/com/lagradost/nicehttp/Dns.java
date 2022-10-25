package com.lagradost.nicehttp;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.dnsoverhttps.DnsOverHttps;

@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¨\u0006\u0006"}, m107d2 = {"addGenericDns", "Lokhttp3/OkHttpClient$Builder;", "url", "", "ips", "", "library_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.nicehttp.DnsKt */
/* loaded from: classes4.dex */
public final class Dns {
    public static final OkHttpClient.Builder addGenericDns(OkHttpClient.Builder builder, String url, List<String> ips) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(ips, "ips");
        DnsOverHttps.Builder url2 = new DnsOverHttps.Builder().client(builder.build()).url(HttpUrl.Companion.get(url));
        List<String> list = ips;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            arrayList.add(InetAddress.getByName(str));
        }
        return builder.dns(url2.bootstrapDnsHosts(arrayList).build());
    }
}
