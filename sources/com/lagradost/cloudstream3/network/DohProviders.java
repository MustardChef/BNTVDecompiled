package com.lagradost.cloudstream3.network;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.dnsoverhttps.DnsOverHttps;

@Metadata(m108d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001¨\u0006\t"}, m107d2 = {"addAdGuardDns", "Lokhttp3/OkHttpClient$Builder;", "addCloudFlareDns", "addGenericDns", "url", "", "ips", "", "addGoogleDns", "app_release"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.network.DohProvidersKt */
/* loaded from: classes3.dex */
public final class DohProviders {
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

    public static final OkHttpClient.Builder addGoogleDns(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return addGenericDns(builder, "https://dns.google/dns-query", CollectionsKt.listOf((Object[]) new String[]{"8.8.4.4", "8.8.8.8"}));
    }

    public static final OkHttpClient.Builder addCloudFlareDns(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return addGenericDns(builder, "https://cloudflare-dns.com/dns-query", CollectionsKt.listOf((Object[]) new String[]{"1.1.1.1", "1.0.0.1", "2606:4700:4700::1111", "2606:4700:4700::1001"}));
    }

    public static final OkHttpClient.Builder addAdGuardDns(OkHttpClient.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return addGenericDns(builder, "https://dns.adguard.com/dns-query", CollectionsKt.listOf((Object[]) new String[]{"94.140.14.140", "94.140.14.141"}));
    }
}
