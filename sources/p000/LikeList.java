package p000;

import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R0\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR0\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u00020\u00108GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001e\u0010&\u001a\u0004\u0018\u00010\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u00020*8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R0\u0010/\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010\u0004j\n\u0012\u0004\u0012\u000200\u0018\u0001`\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\b\"\u0004\b2\u0010\nR0\u00103\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00068GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\b\"\u0004\b5\u0010\nR\u001e\u00106\u001a\u0004\u0018\u00010\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0017\"\u0004\b8\u0010\u0019R\u001e\u00109\u001a\u0004\u0018\u00010\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\u001c\u0010<\u001a\u00020\u00108GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014¨\u0006?"}, m107d2 = {"LLikeList;", "", "()V", "areaList", "Ljava/util/ArrayList;", "LAreaList;", "Lkotlin/collections/ArrayList;", "getAreaList", "()Ljava/util/ArrayList;", "setAreaList", "(Ljava/util/ArrayList;)V", "areaNameList", "", "getAreaNameList", "setAreaNameList", MonitorLogServerProtocol.PARAM_CATEGORY, "", "getCategory", "()I", "setCategory", "(I)V", "coverHorizontalUrl", "getCoverHorizontalUrl", "()Ljava/lang/String;", "setCoverHorizontalUrl", "(Ljava/lang/String;)V", "coverVerticalUrl", "getCoverVerticalUrl", "setCoverVerticalUrl", "drameTypeVo", "LDrameTypeVo;", "getDrameTypeVo", "()LDrameTypeVo;", "setDrameTypeVo", "(LDrameTypeVo;)V", "id", "getId", "setId", "name", "getName", "setName", "score", "", "getScore", "()D", "setScore", "(D)V", "tagList", "LTagList;", "getTagList", "setTagList", "tagNameList", "getTagNameList", "setTagNameList", "upImgUrl", "getUpImgUrl", "setUpImgUrl", "upName", "getUpName", "setUpName", "year", "getYear", "setYear", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: LikeList */
/* loaded from: classes2.dex */
public final class LikeList {
    private ArrayList<LokLokMovieDetailResponse> areaList;
    private ArrayList<String> areaNameList;
    private int category;
    private String coverHorizontalUrl;
    private String coverVerticalUrl;
    private DrameTypeVo drameTypeVo;

    /* renamed from: id */
    private String f2id;
    private String name;
    private double score;
    private ArrayList<TagList> tagList;
    private ArrayList<String> tagNameList;
    private String upImgUrl;
    private String upName;
    private int year;

    @JsonProperty("areaList")
    public final ArrayList<LokLokMovieDetailResponse> getAreaList() {
        return this.areaList;
    }

    public final void setAreaList(ArrayList<LokLokMovieDetailResponse> arrayList) {
        this.areaList = arrayList;
    }

    @JsonProperty("areaNameList")
    public final ArrayList<String> getAreaNameList() {
        return this.areaNameList;
    }

    public final void setAreaNameList(ArrayList<String> arrayList) {
        this.areaNameList = arrayList;
    }

    @JsonProperty(MonitorLogServerProtocol.PARAM_CATEGORY)
    public final int getCategory() {
        return this.category;
    }

    public final void setCategory(int i) {
        this.category = i;
    }

    @JsonProperty("coverHorizontalUrl")
    public final String getCoverHorizontalUrl() {
        return this.coverHorizontalUrl;
    }

    public final void setCoverHorizontalUrl(String str) {
        this.coverHorizontalUrl = str;
    }

    @JsonProperty("coverVerticalUrl")
    public final String getCoverVerticalUrl() {
        return this.coverVerticalUrl;
    }

    public final void setCoverVerticalUrl(String str) {
        this.coverVerticalUrl = str;
    }

    @JsonProperty("drameTypeVo")
    public final DrameTypeVo getDrameTypeVo() {
        return this.drameTypeVo;
    }

    public final void setDrameTypeVo(DrameTypeVo drameTypeVo) {
        this.drameTypeVo = drameTypeVo;
    }

    @JsonProperty("id")
    public final String getId() {
        return this.f2id;
    }

    public final void setId(String str) {
        this.f2id = str;
    }

    @JsonProperty("name")
    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    @JsonProperty("score")
    public final double getScore() {
        return this.score;
    }

    public final void setScore(double d) {
        this.score = d;
    }

    @JsonProperty("tagList")
    public final ArrayList<TagList> getTagList() {
        return this.tagList;
    }

    public final void setTagList(ArrayList<TagList> arrayList) {
        this.tagList = arrayList;
    }

    @JsonProperty("tagNameList")
    public final ArrayList<String> getTagNameList() {
        return this.tagNameList;
    }

    public final void setTagNameList(ArrayList<String> arrayList) {
        this.tagNameList = arrayList;
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

    @JsonProperty("year")
    public final int getYear() {
        return this.year;
    }

    public final void setYear(int i) {
        this.year = i;
    }
}
