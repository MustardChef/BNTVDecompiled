package p000;

import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: LokLokMovieDetailResponse.kt */
@Metadata(m108d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR0\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u001b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001e\u0010#\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001e\u0010&\u001a\u0004\u0018\u00010'8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u00020\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R0\u0010/\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010\nj\n\u0012\u0004\u0012\u000200\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000e\"\u0004\b2\u0010\u0010R\u001e\u00103\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR0\u00109\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010\nj\n\u0012\u0004\u0012\u00020:\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u000e\"\u0004\b<\u0010\u0010R\u001e\u0010=\u001a\u0004\u0018\u00010\u00048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001c\u0010@\u001a\u00020\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010\u0019R0\u0010C\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u000e\"\u0004\bE\u0010\u0010R\u001c\u0010F\u001a\u00020\u001b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001d\"\u0004\bH\u0010\u001fR\u001c\u0010I\u001a\u00020J8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u0004\u0018\u00010\u00018GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u00020\u001b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u001d\"\u0004\bV\u0010\u001fR0\u0010W\u001a\u0016\u0012\u0004\u0012\u00020X\u0018\u00010\nj\n\u0012\u0004\u0012\u00020X\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000e\"\u0004\bZ\u0010\u0010R0\u0010[\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\f8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000e\"\u0004\b]\u0010\u0010R\u001c\u0010^\u001a\u00020\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0017\"\u0004\b`\u0010\u0019R\u001e\u0010a\u001a\u0004\u0018\u00010b8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001e\u0010g\u001a\u0004\u0018\u00010h8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001c\u0010m\u001a\u00020\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0017\"\u0004\bo\u0010\u0019¨\u0006p"}, m107d2 = {"LLokLokMovieDetailResponse;", "", "()V", "aliasName", "", "getAliasName", "()Ljava/lang/String;", "setAliasName", "(Ljava/lang/String;)V", "areaList", "Ljava/util/ArrayList;", "LAreaList;", "Lkotlin/collections/ArrayList;", "getAreaList", "()Ljava/util/ArrayList;", "setAreaList", "(Ljava/util/ArrayList;)V", "areaNameList", "getAreaNameList", "setAreaNameList", MonitorLogServerProtocol.PARAM_CATEGORY, "", "getCategory", "()I", "setCategory", "(I)V", "collect", "", "getCollect", "()Z", "setCollect", "(Z)V", "coverHorizontalUrl", "getCoverHorizontalUrl", "setCoverHorizontalUrl", "coverVerticalUrl", "getCoverVerticalUrl", "setCoverVerticalUrl", "drameTypeVo", "LDrameTypeVo;", "getDrameTypeVo", "()LDrameTypeVo;", "setDrameTypeVo", "(LDrameTypeVo;)V", "episodeCount", "getEpisodeCount", "setEpisodeCount", "episodeVo", "LEpisodeVo;", "getEpisodeVo", "setEpisodeVo", "id", "getId", "setId", "introduction", "getIntroduction", "setIntroduction", "likeList", "LLikeList;", "getLikeList", "setLikeList", "name", "getName", "setName", "noLoginPlayTimeLimit", "getNoLoginPlayTimeLimit", "setNoLoginPlayTimeLimit", "refList", "getRefList", "setRefList", "reserved", "getReserved", "setReserved", "score", "", "getScore", "()D", "setScore", "(D)V", "seriesNo", "getSeriesNo", "()Ljava/lang/Object;", "setSeriesNo", "(Ljava/lang/Object;)V", "showSetName", "getShowSetName", "setShowSetName", "tagList", "LTagList;", "getTagList", "setTagList", "tagNameList", "getTagNameList", "setTagNameList", "translateType", "getTranslateType", "setTranslateType", "upInfo", "LUpInfo;", "getUpInfo", "()LUpInfo;", "setUpInfo", "(LUpInfo;)V", "updateInfo", "LUpdateInfo;", "getUpdateInfo", "()LUpdateInfo;", "setUpdateInfo", "(LUpdateInfo;)V", "year", "getYear", "setYear", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: LokLokMovieDetailResponse  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5587LokLokMovieDetailResponse {
    private String aliasName;
    private ArrayList<LokLokMovieDetailResponse> areaList;
    private ArrayList<String> areaNameList;
    private int category;
    private boolean collect;
    private String coverHorizontalUrl;
    private String coverVerticalUrl;
    private DrameTypeVo drameTypeVo;
    private int episodeCount;
    private ArrayList<EpisodeVo> episodeVo;

    /* renamed from: id */
    private String f3id;
    private String introduction;
    private ArrayList<LikeList> likeList;
    private String name;
    private int noLoginPlayTimeLimit;
    private ArrayList<Object> refList;
    private boolean reserved;
    private double score;
    private Object seriesNo;
    private boolean showSetName;
    private ArrayList<TagList> tagList;
    private ArrayList<String> tagNameList;
    private int translateType;
    private UpInfo upInfo;
    private UpdateInfo updateInfo;
    private int year;

    @JsonProperty("aliasName")
    public final String getAliasName() {
        return this.aliasName;
    }

    public final void setAliasName(String str) {
        this.aliasName = str;
    }

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

    @JsonProperty("collect")
    public final boolean getCollect() {
        return this.collect;
    }

    public final void setCollect(boolean z) {
        this.collect = z;
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

    @JsonProperty("episodeCount")
    public final int getEpisodeCount() {
        return this.episodeCount;
    }

    public final void setEpisodeCount(int i) {
        this.episodeCount = i;
    }

    @JsonProperty("episodeVo")
    public final ArrayList<EpisodeVo> getEpisodeVo() {
        return this.episodeVo;
    }

    public final void setEpisodeVo(ArrayList<EpisodeVo> arrayList) {
        this.episodeVo = arrayList;
    }

    @JsonProperty("id")
    public final String getId() {
        return this.f3id;
    }

    public final void setId(String str) {
        this.f3id = str;
    }

    @JsonProperty("introduction")
    public final String getIntroduction() {
        return this.introduction;
    }

    public final void setIntroduction(String str) {
        this.introduction = str;
    }

    @JsonProperty("likeList")
    public final ArrayList<LikeList> getLikeList() {
        return this.likeList;
    }

    public final void setLikeList(ArrayList<LikeList> arrayList) {
        this.likeList = arrayList;
    }

    @JsonProperty("name")
    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    @JsonProperty("noLoginPlayTimeLimit")
    public final int getNoLoginPlayTimeLimit() {
        return this.noLoginPlayTimeLimit;
    }

    public final void setNoLoginPlayTimeLimit(int i) {
        this.noLoginPlayTimeLimit = i;
    }

    @JsonProperty("refList")
    public final ArrayList<Object> getRefList() {
        return this.refList;
    }

    public final void setRefList(ArrayList<Object> arrayList) {
        this.refList = arrayList;
    }

    @JsonProperty("reserved")
    public final boolean getReserved() {
        return this.reserved;
    }

    public final void setReserved(boolean z) {
        this.reserved = z;
    }

    @JsonProperty("score")
    public final double getScore() {
        return this.score;
    }

    public final void setScore(double d) {
        this.score = d;
    }

    @JsonProperty("seriesNo")
    public final Object getSeriesNo() {
        return this.seriesNo;
    }

    public final void setSeriesNo(Object obj) {
        this.seriesNo = obj;
    }

    @JsonProperty("showSetName")
    public final boolean getShowSetName() {
        return this.showSetName;
    }

    public final void setShowSetName(boolean z) {
        this.showSetName = z;
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

    @JsonProperty("translateType")
    public final int getTranslateType() {
        return this.translateType;
    }

    public final void setTranslateType(int i) {
        this.translateType = i;
    }

    @JsonProperty("upInfo")
    public final UpInfo getUpInfo() {
        return this.upInfo;
    }

    public final void setUpInfo(UpInfo upInfo) {
        this.upInfo = upInfo;
    }

    @JsonProperty("updateInfo")
    public final UpdateInfo getUpdateInfo() {
        return this.updateInfo;
    }

    public final void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    @JsonProperty("year")
    public final int getYear() {
        return this.year;
    }

    public final void setYear(int i) {
        this.year = i;
    }
}
