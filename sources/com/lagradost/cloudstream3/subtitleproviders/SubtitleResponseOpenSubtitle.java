package com.lagradost.cloudstream3.subtitleproviders;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: SubtitleResponseOpenSubtitle.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b>\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\bk\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR\u001e\u0010K\u001a\u00020L8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR \u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR \u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR \u0010W\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR \u0010Z\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0006\"\u0004\b\\\u0010\bR \u0010]\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR \u0010`\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR \u0010c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR \u0010f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR \u0010i\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR \u0010l\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR \u0010o\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR \u0010r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR \u0010u\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\bR \u0010x\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR \u0010{\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0006\"\u0004\b}\u0010\bR!\u0010~\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\bR#\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0006\"\u0005\b\u0083\u0001\u0010\bR#\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR#\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\bR#\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR#\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR#\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010\u0006\"\u0005\b\u0092\u0001\u0010\bR#\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\bR#\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR#\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR#\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010\u0006\"\u0005\b\u009e\u0001\u0010\bR#\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u0006\"\u0005\b¡\u0001\u0010\bR#\u0010¢\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0006\"\u0005\b¤\u0001\u0010\bR#\u0010¥\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u0006\"\u0005\b§\u0001\u0010\bR#\u0010¨\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u0006\"\u0005\bª\u0001\u0010\bR#\u0010«\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u0006\"\u0005\b\u00ad\u0001\u0010\bR#\u0010®\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\u0006\"\u0005\b°\u0001\u0010\bR#\u0010±\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\u0006\"\u0005\b³\u0001\u0010\bR#\u0010´\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\u0006\"\u0005\b¶\u0001\u0010\b¨\u0006·\u0001"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitleproviders/SubtitleResponseOpenSubtitle;", "", "()V", "iDMovie", "", "getIDMovie", "()Ljava/lang/String;", "setIDMovie", "(Ljava/lang/String;)V", "iDMovieImdb", "getIDMovieImdb", "setIDMovieImdb", "iDSubMovieFile", "getIDSubMovieFile", "setIDSubMovieFile", "iDSubtitle", "getIDSubtitle", "setIDSubtitle", "iDSubtitleFile", "getIDSubtitleFile", "setIDSubtitleFile", "iSO639", "getISO639", "setISO639", "infoFormat", "getInfoFormat", "setInfoFormat", "infoOther", "getInfoOther", "setInfoOther", "infoReleaseGroup", "getInfoReleaseGroup", "setInfoReleaseGroup", "languageName", "getLanguageName", "setLanguageName", "matchedBy", "getMatchedBy", "setMatchedBy", "movieByteSize", "getMovieByteSize", "setMovieByteSize", "movieFPS", "getMovieFPS", "setMovieFPS", "movieHash", "getMovieHash", "setMovieHash", "movieImdbRating", "getMovieImdbRating", "setMovieImdbRating", "movieKind", "getMovieKind", "setMovieKind", "movieName", "getMovieName", "setMovieName", "movieReleaseName", "getMovieReleaseName", "setMovieReleaseName", "movieTimeMS", "getMovieTimeMS", "setMovieTimeMS", "movieYear", "getMovieYear", "setMovieYear", "queryCached", "", "getQueryCached", "()I", "setQueryCached", "(I)V", "queryNumber", "getQueryNumber", "setQueryNumber", "score", "", "getScore", "()D", "setScore", "(D)V", "seriesEpisode", "getSeriesEpisode", "setSeriesEpisode", "seriesIMDBParent", "getSeriesIMDBParent", "setSeriesIMDBParent", "seriesSeason", "getSeriesSeason", "setSeriesSeason", "subActualCD", "getSubActualCD", "setSubActualCD", "subAddDate", "getSubAddDate", "setSubAddDate", "subAuthorComment", "getSubAuthorComment", "setSubAuthorComment", "subAutoTranslation", "getSubAutoTranslation", "setSubAutoTranslation", "subBad", "getSubBad", "setSubBad", "subComments", "getSubComments", "setSubComments", "subDownloadLink", "getSubDownloadLink", "setSubDownloadLink", "subDownloadsCnt", "getSubDownloadsCnt", "setSubDownloadsCnt", "subEncoding", "getSubEncoding", "setSubEncoding", "subFeatured", "getSubFeatured", "setSubFeatured", "subFileName", "getSubFileName", "setSubFileName", "subForeignPartsOnly", "getSubForeignPartsOnly", "setSubForeignPartsOnly", "subFormat", "getSubFormat", "setSubFormat", "subFromTrusted", "getSubFromTrusted", "setSubFromTrusted", "subHD", "getSubHD", "setSubHD", "subHash", "getSubHash", "setSubHash", "subHearingImpaired", "getSubHearingImpaired", "setSubHearingImpaired", "subLanguageID", "getSubLanguageID", "setSubLanguageID", "subLastTS", "getSubLastTS", "setSubLastTS", "subRating", "getSubRating", "setSubRating", "subSize", "getSubSize", "setSubSize", "subSumCD", "getSubSumCD", "setSubSumCD", "subSumVotes", "getSubSumVotes", "setSubSumVotes", "subTSGroup", "getSubTSGroup", "setSubTSGroup", "subTSGroupHash", "getSubTSGroupHash", "setSubTSGroupHash", "subTranslator", "getSubTranslator", "setSubTranslator", "subtitlesLink", "getSubtitlesLink", "setSubtitlesLink", SDKConstants.PARAM_USER_ID, "getUserID", "setUserID", "userNickName", "getUserNickName", "setUserNickName", "userRank", "getUserRank", "setUserRank", "zipDownloadLink", "getZipDownloadLink", "setZipDownloadLink", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class SubtitleResponseOpenSubtitle {
    @SerializedName("IDMovie")
    @Expose
    private String iDMovie;
    @SerializedName("IDMovieImdb")
    @Expose
    private String iDMovieImdb;
    @SerializedName("IDSubMovieFile")
    @Expose
    private String iDSubMovieFile;
    @SerializedName("IDSubtitle")
    @Expose
    private String iDSubtitle;
    @SerializedName("IDSubtitleFile")
    @Expose
    private String iDSubtitleFile;
    @SerializedName("ISO639")
    @Expose
    private String iSO639;
    @SerializedName("InfoFormat")
    @Expose
    private String infoFormat;
    @SerializedName("InfoOther")
    @Expose
    private String infoOther;
    @SerializedName("InfoReleaseGroup")
    @Expose
    private String infoReleaseGroup;
    @SerializedName("LanguageName")
    @Expose
    private String languageName;
    @SerializedName("MatchedBy")
    @Expose
    private String matchedBy;
    @SerializedName("MovieByteSize")
    @Expose
    private String movieByteSize;
    @SerializedName("MovieFPS")
    @Expose
    private String movieFPS;
    @SerializedName("MovieHash")
    @Expose
    private String movieHash;
    @SerializedName("MovieImdbRating")
    @Expose
    private String movieImdbRating;
    @SerializedName("MovieKind")
    @Expose
    private String movieKind;
    @SerializedName("MovieName")
    @Expose
    private String movieName;
    @SerializedName("MovieReleaseName")
    @Expose
    private String movieReleaseName;
    @SerializedName("MovieTimeMS")
    @Expose
    private String movieTimeMS;
    @SerializedName("MovieYear")
    @Expose
    private String movieYear;
    @SerializedName("QueryCached")
    @Expose
    private int queryCached;
    @SerializedName("QueryNumber")
    @Expose
    private String queryNumber;
    @SerializedName("Score")
    @Expose
    private double score;
    @SerializedName("SeriesEpisode")
    @Expose
    private String seriesEpisode;
    @SerializedName("SeriesIMDBParent")
    @Expose
    private String seriesIMDBParent;
    @SerializedName("SeriesSeason")
    @Expose
    private String seriesSeason;
    @SerializedName("SubActualCD")
    @Expose
    private String subActualCD;
    @SerializedName("SubAddDate")
    @Expose
    private String subAddDate;
    @SerializedName("SubAuthorComment")
    @Expose
    private String subAuthorComment;
    @SerializedName("SubAutoTranslation")
    @Expose
    private String subAutoTranslation;
    @SerializedName("SubBad")
    @Expose
    private String subBad;
    @SerializedName("SubComments")
    @Expose
    private String subComments;
    @SerializedName("SubDownloadLink")
    @Expose
    private String subDownloadLink;
    @SerializedName("SubDownloadsCnt")
    @Expose
    private String subDownloadsCnt;
    @SerializedName("SubEncoding")
    @Expose
    private String subEncoding;
    @SerializedName("SubFeatured")
    @Expose
    private String subFeatured;
    @SerializedName("SubFileName")
    @Expose
    private String subFileName;
    @SerializedName("SubForeignPartsOnly")
    @Expose
    private String subForeignPartsOnly;
    @SerializedName("SubFormat")
    @Expose
    private String subFormat;
    @SerializedName("SubFromTrusted")
    @Expose
    private String subFromTrusted;
    @SerializedName("SubHD")
    @Expose
    private String subHD;
    @SerializedName("SubHash")
    @Expose
    private String subHash;
    @SerializedName("SubHearingImpaired")
    @Expose
    private String subHearingImpaired;
    @SerializedName("SubLanguageID")
    @Expose
    private String subLanguageID;
    @SerializedName("SubLastTS")
    @Expose
    private String subLastTS;
    @SerializedName("SubRating")
    @Expose
    private String subRating;
    @SerializedName("SubSize")
    @Expose
    private String subSize;
    @SerializedName("SubSumCD")
    @Expose
    private String subSumCD;
    @SerializedName("SubSumVotes")
    @Expose
    private String subSumVotes;
    @SerializedName("SubTSGroup")
    @Expose
    private String subTSGroup;
    @SerializedName("SubTSGroupHash")
    @Expose
    private String subTSGroupHash;
    @SerializedName("SubTranslator")
    @Expose
    private String subTranslator;
    @SerializedName("SubtitlesLink")
    @Expose
    private String subtitlesLink;
    @SerializedName("UserID")
    @Expose
    private String userID;
    @SerializedName("UserNickName")
    @Expose
    private String userNickName;
    @SerializedName("UserRank")
    @Expose
    private String userRank;
    @SerializedName("ZipDownloadLink")
    @Expose
    private String zipDownloadLink;

    public final double getScore() {
        return this.score;
    }

    public final void setScore(double d) {
        this.score = d;
    }

    public final String getQueryNumber() {
        return this.queryNumber;
    }

    public final void setQueryNumber(String str) {
        this.queryNumber = str;
    }

    public final String getSubtitlesLink() {
        return this.subtitlesLink;
    }

    public final void setSubtitlesLink(String str) {
        this.subtitlesLink = str;
    }

    public final String getZipDownloadLink() {
        return this.zipDownloadLink;
    }

    public final void setZipDownloadLink(String str) {
        this.zipDownloadLink = str;
    }

    public final String getSubDownloadLink() {
        return this.subDownloadLink;
    }

    public final void setSubDownloadLink(String str) {
        this.subDownloadLink = str;
    }

    public final String getSubTSGroupHash() {
        return this.subTSGroupHash;
    }

    public final void setSubTSGroupHash(String str) {
        this.subTSGroupHash = str;
    }

    public final int getQueryCached() {
        return this.queryCached;
    }

    public final void setQueryCached(int i) {
        this.queryCached = i;
    }

    public final String getSubFromTrusted() {
        return this.subFromTrusted;
    }

    public final void setSubFromTrusted(String str) {
        this.subFromTrusted = str;
    }

    public final String getSubForeignPartsOnly() {
        return this.subForeignPartsOnly;
    }

    public final void setSubForeignPartsOnly(String str) {
        this.subForeignPartsOnly = str;
    }

    public final String getSubAutoTranslation() {
        return this.subAutoTranslation;
    }

    public final void setSubAutoTranslation(String str) {
        this.subAutoTranslation = str;
    }

    public final String getSubEncoding() {
        return this.subEncoding;
    }

    public final void setSubEncoding(String str) {
        this.subEncoding = str;
    }

    public final String getSeriesIMDBParent() {
        return this.seriesIMDBParent;
    }

    public final void setSeriesIMDBParent(String str) {
        this.seriesIMDBParent = str;
    }

    public final String getSubHD() {
        return this.subHD;
    }

    public final void setSubHD(String str) {
        this.subHD = str;
    }

    public final String getMovieKind() {
        return this.movieKind;
    }

    public final void setMovieKind(String str) {
        this.movieKind = str;
    }

    public final String getSeriesEpisode() {
        return this.seriesEpisode;
    }

    public final void setSeriesEpisode(String str) {
        this.seriesEpisode = str;
    }

    public final String getSeriesSeason() {
        return this.seriesSeason;
    }

    public final void setSeriesSeason(String str) {
        this.seriesSeason = str;
    }

    public final String getUserRank() {
        return this.userRank;
    }

    public final void setUserRank(String str) {
        this.userRank = str;
    }

    public final String getSubHearingImpaired() {
        return this.subHearingImpaired;
    }

    public final void setSubHearingImpaired(String str) {
        this.subHearingImpaired = str;
    }

    public final String getSubComments() {
        return this.subComments;
    }

    public final void setSubComments(String str) {
        this.subComments = str;
    }

    public final String getLanguageName() {
        return this.languageName;
    }

    public final void setLanguageName(String str) {
        this.languageName = str;
    }

    public final String getISO639() {
        return this.iSO639;
    }

    public final void setISO639(String str) {
        this.iSO639 = str;
    }

    public final String getSubTranslator() {
        return this.subTranslator;
    }

    public final void setSubTranslator(String str) {
        this.subTranslator = str;
    }

    public final String getUserNickName() {
        return this.userNickName;
    }

    public final void setUserNickName(String str) {
        this.userNickName = str;
    }

    public final String getSubFeatured() {
        return this.subFeatured;
    }

    public final void setSubFeatured(String str) {
        this.subFeatured = str;
    }

    public final String getMovieImdbRating() {
        return this.movieImdbRating;
    }

    public final void setMovieImdbRating(String str) {
        this.movieImdbRating = str;
    }

    public final String getMovieYear() {
        return this.movieYear;
    }

    public final void setMovieYear(String str) {
        this.movieYear = str;
    }

    public final String getMovieName() {
        return this.movieName;
    }

    public final void setMovieName(String str) {
        this.movieName = str;
    }

    public final String getIDMovieImdb() {
        return this.iDMovieImdb;
    }

    public final void setIDMovieImdb(String str) {
        this.iDMovieImdb = str;
    }

    public final String getIDMovie() {
        return this.iDMovie;
    }

    public final void setIDMovie(String str) {
        this.iDMovie = str;
    }

    public final String getMovieFPS() {
        return this.movieFPS;
    }

    public final void setMovieFPS(String str) {
        this.movieFPS = str;
    }

    public final String getMovieReleaseName() {
        return this.movieReleaseName;
    }

    public final void setMovieReleaseName(String str) {
        this.movieReleaseName = str;
    }

    public final String getSubDownloadsCnt() {
        return this.subDownloadsCnt;
    }

    public final void setSubDownloadsCnt(String str) {
        this.subDownloadsCnt = str;
    }

    public final String getSubSumVotes() {
        return this.subSumVotes;
    }

    public final void setSubSumVotes(String str) {
        this.subSumVotes = str;
    }

    public final String getSubRating() {
        return this.subRating;
    }

    public final void setSubRating(String str) {
        this.subRating = str;
    }

    public final String getSubBad() {
        return this.subBad;
    }

    public final void setSubBad(String str) {
        this.subBad = str;
    }

    public final String getSubAddDate() {
        return this.subAddDate;
    }

    public final void setSubAddDate(String str) {
        this.subAddDate = str;
    }

    public final String getSubAuthorComment() {
        return this.subAuthorComment;
    }

    public final void setSubAuthorComment(String str) {
        this.subAuthorComment = str;
    }

    public final String getSubSumCD() {
        return this.subSumCD;
    }

    public final void setSubSumCD(String str) {
        this.subSumCD = str;
    }

    public final String getSubFormat() {
        return this.subFormat;
    }

    public final void setSubFormat(String str) {
        this.subFormat = str;
    }

    public final String getSubLanguageID() {
        return this.subLanguageID;
    }

    public final void setSubLanguageID(String str) {
        this.subLanguageID = str;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final void setUserID(String str) {
        this.userID = str;
    }

    public final String getIDSubtitle() {
        return this.iDSubtitle;
    }

    public final void setIDSubtitle(String str) {
        this.iDSubtitle = str;
    }

    public final String getInfoOther() {
        return this.infoOther;
    }

    public final void setInfoOther(String str) {
        this.infoOther = str;
    }

    public final String getInfoFormat() {
        return this.infoFormat;
    }

    public final void setInfoFormat(String str) {
        this.infoFormat = str;
    }

    public final String getInfoReleaseGroup() {
        return this.infoReleaseGroup;
    }

    public final void setInfoReleaseGroup(String str) {
        this.infoReleaseGroup = str;
    }

    public final String getSubTSGroup() {
        return this.subTSGroup;
    }

    public final void setSubTSGroup(String str) {
        this.subTSGroup = str;
    }

    public final String getSubLastTS() {
        return this.subLastTS;
    }

    public final void setSubLastTS(String str) {
        this.subLastTS = str;
    }

    public final String getSubHash() {
        return this.subHash;
    }

    public final void setSubHash(String str) {
        this.subHash = str;
    }

    public final String getSubSize() {
        return this.subSize;
    }

    public final void setSubSize(String str) {
        this.subSize = str;
    }

    public final String getSubActualCD() {
        return this.subActualCD;
    }

    public final void setSubActualCD(String str) {
        this.subActualCD = str;
    }

    public final String getSubFileName() {
        return this.subFileName;
    }

    public final void setSubFileName(String str) {
        this.subFileName = str;
    }

    public final String getIDSubtitleFile() {
        return this.iDSubtitleFile;
    }

    public final void setIDSubtitleFile(String str) {
        this.iDSubtitleFile = str;
    }

    public final String getMovieTimeMS() {
        return this.movieTimeMS;
    }

    public final void setMovieTimeMS(String str) {
        this.movieTimeMS = str;
    }

    public final String getMovieByteSize() {
        return this.movieByteSize;
    }

    public final void setMovieByteSize(String str) {
        this.movieByteSize = str;
    }

    public final String getMovieHash() {
        return this.movieHash;
    }

    public final void setMovieHash(String str) {
        this.movieHash = str;
    }

    public final String getIDSubMovieFile() {
        return this.iDSubMovieFile;
    }

    public final void setIDSubMovieFile(String str) {
        this.iDSubMovieFile = str;
    }

    public final String getMatchedBy() {
        return this.matchedBy;
    }

    public final void setMatchedBy(String str) {
        this.matchedBy = str;
    }
}
