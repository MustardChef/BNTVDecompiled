package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kr */
/* loaded from: classes2.dex */
final class C2845kr implements InterfaceC3169wr {

    /* renamed from: a */
    private static final Pattern f7908a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

    /* renamed from: b */
    public static final Long m1773b(InputStream inputStream) throws IOException {
        String readLine = new BufferedReader(new InputStreamReader(inputStream, atg.f5038b)).readLine();
        try {
            Matcher matcher = f7908a.matcher(readLine);
            if (!matcher.matches()) {
                String valueOf = String.valueOf(readLine);
                throw C2555ao.m4864c(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "), null);
            }
            String group = matcher.group(1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            long time = simpleDateFormat.parse(group).getTime();
            if (!"Z".equals(matcher.group(2))) {
                long j = true != "+".equals(matcher.group(4)) ? -1L : 1L;
                long parseLong = Long.parseLong(matcher.group(5));
                String group2 = matcher.group(7);
                time -= j * (((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0L : Long.parseLong(group2))) * 60000);
            }
            return Long.valueOf(time);
        } catch (ParseException e) {
            throw C2555ao.m4864c(null, e);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3169wr
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo714a(Uri uri, InputStream inputStream) throws IOException {
        return m1773b(inputStream);
    }
}
