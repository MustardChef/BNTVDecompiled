package com.lagradost.cloudstream3.subtitleproviders;

import com.facebook.appevents.UserDataStore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* compiled from: MovieIMDB.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bJ\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR \u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\b¨\u0006N"}, m107d2 = {"Lcom/lagradost/cloudstream3/subtitleproviders/MovieIMDB;", "", "()V", "actors", "", "getActors", "()Ljava/lang/String;", "setActors", "(Ljava/lang/String;)V", "awards", "getAwards", "setAwards", "boxOffice", "getBoxOffice", "setBoxOffice", UserDataStore.COUNTRY, "getCountry", "setCountry", "dVD", "getDVD", "setDVD", "director", "getDirector", "setDirector", "genre", "getGenre", "setGenre", "imdbID", "getImdbID", "setImdbID", "imdbRating", "getImdbRating", "setImdbRating", "imdbVotes", "getImdbVotes", "setImdbVotes", "language", "getLanguage", "setLanguage", "metascore", "getMetascore", "setMetascore", "plot", "getPlot", "setPlot", "poster", "getPoster", "setPoster", "production", "getProduction", "setProduction", "rated", "getRated", "setRated", "released", "getReleased", "setReleased", "response", "getResponse", "setResponse", "runtime", "getRuntime", "setRuntime", "title", "getTitle", "setTitle", "type", "getType", "setType", "website", "getWebsite", "setWebsite", "writer", "getWriter", "setWriter", "year", "getYear", "setYear", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class MovieIMDB {
    @SerializedName("Actors")
    @Expose
    private String actors;
    @SerializedName("Awards")
    @Expose
    private String awards;
    @SerializedName("BoxOffice")
    @Expose
    private String boxOffice;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("DVD")
    @Expose
    private String dVD;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("imdbID")
    @Expose
    private String imdbID;
    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;
    @SerializedName("imdbVotes")
    @Expose
    private String imdbVotes;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Metascore")
    @Expose
    private String metascore;
    @SerializedName("Plot")
    @Expose
    private String plot;
    @SerializedName("Poster")
    @Expose
    private String poster;
    @SerializedName("Production")
    @Expose
    private String production;
    @SerializedName("Rated")
    @Expose
    private String rated;
    @SerializedName("Released")
    @Expose
    private String released;
    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Runtime")
    @Expose
    private String runtime;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Website")
    @Expose
    private String website;
    @SerializedName("Writer")
    @Expose
    private String writer;
    @SerializedName("Year")
    @Expose
    private String year;

    public final String getResponse() {
        return this.response;
    }

    public final void setResponse(String str) {
        this.response = str;
    }

    public final String getWebsite() {
        return this.website;
    }

    public final void setWebsite(String str) {
        this.website = str;
    }

    public final String getProduction() {
        return this.production;
    }

    public final void setProduction(String str) {
        this.production = str;
    }

    public final String getBoxOffice() {
        return this.boxOffice;
    }

    public final void setBoxOffice(String str) {
        this.boxOffice = str;
    }

    public final String getDVD() {
        return this.dVD;
    }

    public final void setDVD(String str) {
        this.dVD = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getImdbID() {
        return this.imdbID;
    }

    public final void setImdbID(String str) {
        this.imdbID = str;
    }

    public final String getImdbVotes() {
        return this.imdbVotes;
    }

    public final void setImdbVotes(String str) {
        this.imdbVotes = str;
    }

    public final String getImdbRating() {
        return this.imdbRating;
    }

    public final void setImdbRating(String str) {
        this.imdbRating = str;
    }

    public final String getMetascore() {
        return this.metascore;
    }

    public final void setMetascore(String str) {
        this.metascore = str;
    }

    public final String getPoster() {
        return this.poster;
    }

    public final void setPoster(String str) {
        this.poster = str;
    }

    public final String getAwards() {
        return this.awards;
    }

    public final void setAwards(String str) {
        this.awards = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getPlot() {
        return this.plot;
    }

    public final void setPlot(String str) {
        this.plot = str;
    }

    public final String getActors() {
        return this.actors;
    }

    public final void setActors(String str) {
        this.actors = str;
    }

    public final String getWriter() {
        return this.writer;
    }

    public final void setWriter(String str) {
        this.writer = str;
    }

    public final String getDirector() {
        return this.director;
    }

    public final void setDirector(String str) {
        this.director = str;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final void setGenre(String str) {
        this.genre = str;
    }

    public final String getRuntime() {
        return this.runtime;
    }

    public final void setRuntime(String str) {
        this.runtime = str;
    }

    public final String getReleased() {
        return this.released;
    }

    public final void setReleased(String str) {
        this.released = str;
    }

    public final String getRated() {
        return this.rated;
    }

    public final void setRated(String str) {
        this.rated = str;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setYear(String str) {
        this.year = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
