package p000;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\n8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m107d2 = {"LUpdateInfo;", "", "()V", "updatePeriod", "", "getUpdatePeriod", "()Ljava/lang/String;", "setUpdatePeriod", "(Ljava/lang/String;)V", "updateStatus", "", "getUpdateStatus", "()I", "setUpdateStatus", "(I)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: UpdateInfo */
/* loaded from: classes2.dex */
public final class UpdateInfo {
    private String updatePeriod;
    private int updateStatus;

    @JsonProperty("updatePeriod")
    public final String getUpdatePeriod() {
        return this.updatePeriod;
    }

    public final void setUpdatePeriod(String str) {
        this.updatePeriod = str;
    }

    @JsonProperty("updateStatus")
    public final int getUpdateStatus() {
        return this.updateStatus;
    }

    public final void setUpdateStatus(int i) {
        this.updateStatus = i;
    }
}
