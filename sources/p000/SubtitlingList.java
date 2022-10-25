package p000;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u00020\u00108GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m107d2 = {"LSubtitlingList;", "", "()V", "language", "", "getLanguage", "()Ljava/lang/String;", "setLanguage", "(Ljava/lang/String;)V", "languageAbbr", "getLanguageAbbr", "setLanguageAbbr", "subtitlingUrl", "getSubtitlingUrl", "setSubtitlingUrl", "translateType", "", "getTranslateType", "()I", "setTranslateType", "(I)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: SubtitlingList */
/* loaded from: classes2.dex */
public final class SubtitlingList {
    private String language;
    private String languageAbbr;
    private String subtitlingUrl;
    private int translateType;

    @JsonProperty("language")
    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    @JsonProperty("languageAbbr")
    public final String getLanguageAbbr() {
        return this.languageAbbr;
    }

    public final void setLanguageAbbr(String str) {
        this.languageAbbr = str;
    }

    @JsonProperty("subtitlingUrl")
    public final String getSubtitlingUrl() {
        return this.subtitlingUrl;
    }

    public final void setSubtitlingUrl(String str) {
        this.subtitlingUrl = str;
    }

    @JsonProperty("translateType")
    public final int getTranslateType() {
        return this.translateType;
    }

    public final void setTranslateType(int i) {
        this.translateType = i;
    }
}
