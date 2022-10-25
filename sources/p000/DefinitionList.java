package p000;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, m107d2 = {"LDefinitionList;", "", "()V", "code", "", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "fullDescription", "getFullDescription", "setFullDescription", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: DefinitionList */
/* loaded from: classes.dex */
public final class DefinitionList {
    private String code;
    private String description;
    private String fullDescription;

    @JsonProperty("code")
    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    @JsonProperty("description")
    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    @JsonProperty("fullDescription")
    public final String getFullDescription() {
        return this.fullDescription;
    }

    public final void setFullDescription(String str) {
        this.fullDescription = str;
    }
}
