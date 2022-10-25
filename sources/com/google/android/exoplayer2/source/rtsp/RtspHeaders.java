package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RtspHeaders {
    public static final String ACCEPT = "Accept";
    public static final String ALLOW = "Allow";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BANDWIDTH = "Bandwidth";
    public static final String BLOCKSIZE = "Blocksize";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_BASE = "Content-Base";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LANGUAGE = "Content-Language";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_LOCATION = "Content-Location";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CSEQ = "CSeq";
    public static final String DATE = "Date";
    public static final RtspHeaders EMPTY = new Builder().build();
    public static final String EXPIRES = "Expires";
    public static final String LOCATION = "Location";
    public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
    public static final String PROXY_REQUIRE = "Proxy-Require";
    public static final String PUBLIC = "Public";
    public static final String RANGE = "Range";
    public static final String RTCP_INTERVAL = "RTCP-Interval";
    public static final String RTP_INFO = "RTP-Info";
    public static final String SCALE = "Scale";
    public static final String SESSION = "Session";
    public static final String SPEED = "Speed";
    public static final String SUPPORTED = "Supported";
    public static final String TIMESTAMP = "Timestamp";
    public static final String TRANSPORT = "Transport";
    public static final String USER_AGENT = "User-Agent";
    public static final String VIA = "Via";
    public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private final ImmutableListMultimap<String, String> namesAndValues;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final ImmutableListMultimap.Builder<String, String> namesAndValuesBuilder;

        public Builder() {
            this.namesAndValuesBuilder = new ImmutableListMultimap.Builder<>();
        }

        public Builder(String str, String str2, int i) {
            this();
            add("User-Agent", str);
            add(RtspHeaders.CSEQ, String.valueOf(i));
            if (str2 != null) {
                add(RtspHeaders.SESSION, str2);
            }
        }

        private Builder(ImmutableListMultimap.Builder<String, String> builder) {
            this.namesAndValuesBuilder = builder;
        }

        public Builder add(String str, String str2) {
            this.namesAndValuesBuilder.put((ImmutableListMultimap.Builder<String, String>) RtspHeaders.convertToStandardHeaderName(str.trim()), str2.trim());
            return this;
        }

        public Builder addAll(List<String> list) {
            for (int i = 0; i < list.size(); i++) {
                String[] splitAtFirst = Util.splitAtFirst(list.get(i), ":\\s?");
                if (splitAtFirst.length == 2) {
                    add(splitAtFirst[0], splitAtFirst[1]);
                }
            }
            return this;
        }

        public Builder addAll(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                add(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public RtspHeaders build() {
            return new RtspHeaders(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RtspHeaders) {
            return this.namesAndValues.equals(((RtspHeaders) obj).namesAndValues);
        }
        return false;
    }

    public int hashCode() {
        return this.namesAndValues.hashCode();
    }

    public Builder buildUpon() {
        ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
        builder.putAll((Multimap) this.namesAndValues);
        return new Builder(builder);
    }

    public ImmutableListMultimap<String, String> asMultiMap() {
        return this.namesAndValues;
    }

    public String get(String str) {
        ImmutableList<String> values = values(str);
        if (values.isEmpty()) {
            return null;
        }
        return (String) Iterables.getLast(values);
    }

    public ImmutableList<String> values(String str) {
        return this.namesAndValues.get((ImmutableListMultimap<String, String>) convertToStandardHeaderName(str));
    }

    private RtspHeaders(Builder builder) {
        this.namesAndValues = builder.namesAndValuesBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertToStandardHeaderName(String str) {
        return Ascii.equalsIgnoreCase(str, "Accept") ? "Accept" : Ascii.equalsIgnoreCase(str, "Allow") ? "Allow" : Ascii.equalsIgnoreCase(str, "Authorization") ? "Authorization" : Ascii.equalsIgnoreCase(str, BANDWIDTH) ? BANDWIDTH : Ascii.equalsIgnoreCase(str, BLOCKSIZE) ? BLOCKSIZE : Ascii.equalsIgnoreCase(str, "Cache-Control") ? "Cache-Control" : Ascii.equalsIgnoreCase(str, "Connection") ? "Connection" : Ascii.equalsIgnoreCase(str, CONTENT_BASE) ? CONTENT_BASE : Ascii.equalsIgnoreCase(str, "Content-Encoding") ? "Content-Encoding" : Ascii.equalsIgnoreCase(str, "Content-Language") ? "Content-Language" : Ascii.equalsIgnoreCase(str, "Content-Length") ? "Content-Length" : Ascii.equalsIgnoreCase(str, "Content-Location") ? "Content-Location" : Ascii.equalsIgnoreCase(str, "Content-Type") ? "Content-Type" : Ascii.equalsIgnoreCase(str, CSEQ) ? CSEQ : Ascii.equalsIgnoreCase(str, "Date") ? "Date" : Ascii.equalsIgnoreCase(str, "Expires") ? "Expires" : Ascii.equalsIgnoreCase(str, "Location") ? "Location" : Ascii.equalsIgnoreCase(str, "Proxy-Authenticate") ? "Proxy-Authenticate" : Ascii.equalsIgnoreCase(str, PROXY_REQUIRE) ? PROXY_REQUIRE : Ascii.equalsIgnoreCase(str, PUBLIC) ? PUBLIC : Ascii.equalsIgnoreCase(str, "Range") ? "Range" : Ascii.equalsIgnoreCase(str, RTP_INFO) ? RTP_INFO : Ascii.equalsIgnoreCase(str, RTCP_INTERVAL) ? RTCP_INTERVAL : Ascii.equalsIgnoreCase(str, SCALE) ? SCALE : Ascii.equalsIgnoreCase(str, SESSION) ? SESSION : Ascii.equalsIgnoreCase(str, SPEED) ? SPEED : Ascii.equalsIgnoreCase(str, SUPPORTED) ? SUPPORTED : Ascii.equalsIgnoreCase(str, TIMESTAMP) ? TIMESTAMP : Ascii.equalsIgnoreCase(str, TRANSPORT) ? TRANSPORT : Ascii.equalsIgnoreCase(str, "User-Agent") ? "User-Agent" : Ascii.equalsIgnoreCase(str, "Via") ? "Via" : Ascii.equalsIgnoreCase(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }
}
