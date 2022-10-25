package p000;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\n8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, m107d2 = {"LUpInfo;", "", "()V", "upId", "", "getUpId", "()I", "setUpId", "(I)V", "upImgUrl", "", "getUpImgUrl", "()Ljava/lang/String;", "setUpImgUrl", "(Ljava/lang/String;)V", "upName", "getUpName", "setUpName", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: UpInfo */
/* loaded from: classes2.dex */
public final class UpInfo {
    private int upId;
    private String upImgUrl;
    private String upName;

    @JsonProperty("upId")
    public final int getUpId() {
        return this.upId;
    }

    public final void setUpId(int i) {
        this.upId = i;
    }

    @JsonProperty("upImgUrl")
    public final String getUpImgUrl() {
        return this.upImgUrl;
    }

    public final void setUpImgUrl(String str) {
        this.upImgUrl = str;
    }

    @JsonProperty("upName")
    public final String getUpName() {
        return this.upName;
    }

    public final void setUpName(String str) {
        this.upName = str;
    }
}
