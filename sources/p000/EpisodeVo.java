package p000;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R0\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00128GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u00020\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R0\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u001e\u0010!\u001a\u0004\u0018\u00010\u00128GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006$"}, m107d2 = {"LEpisodeVo;", "", "()V", "definitionList", "Ljava/util/ArrayList;", "LDefinitionList;", "Lkotlin/collections/ArrayList;", "getDefinitionList", "()Ljava/util/ArrayList;", "setDefinitionList", "(Ljava/util/ArrayList;)V", "id", "", "getId", "()I", "setId", "(I)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "resourceType", "getResourceType", "setResourceType", "seriesNo", "getSeriesNo", "setSeriesNo", "subtitlingList", "LSubtitlingList;", "getSubtitlingList", "setSubtitlingList", "vid", "getVid", "setVid", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: EpisodeVo */
/* loaded from: classes.dex */
public final class EpisodeVo {
    private ArrayList<DefinitionList> definitionList;

    /* renamed from: id */
    private int f1id;
    private String name;
    private int resourceType;
    private int seriesNo;
    private ArrayList<SubtitlingList> subtitlingList;
    private String vid;

    @JsonProperty("definitionList")
    public final ArrayList<DefinitionList> getDefinitionList() {
        return this.definitionList;
    }

    public final void setDefinitionList(ArrayList<DefinitionList> arrayList) {
        this.definitionList = arrayList;
    }

    @JsonProperty("id")
    public final int getId() {
        return this.f1id;
    }

    public final void setId(int i) {
        this.f1id = i;
    }

    @JsonProperty("name")
    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    @JsonProperty("resourceType")
    public final int getResourceType() {
        return this.resourceType;
    }

    public final void setResourceType(int i) {
        this.resourceType = i;
    }

    @JsonProperty("seriesNo")
    public final int getSeriesNo() {
        return this.seriesNo;
    }

    public final void setSeriesNo(int i) {
        this.seriesNo = i;
    }

    @JsonProperty("subtitlingList")
    public final ArrayList<SubtitlingList> getSubtitlingList() {
        return this.subtitlingList;
    }

    public final void setSubtitlingList(ArrayList<SubtitlingList> arrayList) {
        this.subtitlingList = arrayList;
    }

    @JsonProperty("vid")
    public final String getVid() {
        return this.vid;
    }

    public final void setVid(String str) {
        this.vid = str;
    }
}
