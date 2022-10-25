package com.lagradost.cloudstream3.p041ui.subtitles;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b6\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0003\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u000fHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0082\u0001\u0010?\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010\u000b\u001a\u00020\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0003\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015¨\u0006E"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "", "foregroundColor", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "windowColor", "edgeType", "edgeColor", "typeface", "typefaceFilePath", "", "elevation", "fixedTextSize", "", "removeCaptions", "", "removeBloat", "(IIIIILjava/lang/Integer;Ljava/lang/String;ILjava/lang/Float;ZZ)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "getEdgeColor", "setEdgeColor", "getEdgeType", "setEdgeType", "getElevation", "setElevation", "getFixedTextSize", "()Ljava/lang/Float;", "setFixedTextSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getForegroundColor", "setForegroundColor", "getRemoveBloat", "()Z", "setRemoveBloat", "(Z)V", "getRemoveCaptions", "setRemoveCaptions", "getTypeface", "()Ljava/lang/Integer;", "setTypeface", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTypefaceFilePath", "()Ljava/lang/String;", "setTypefaceFilePath", "(Ljava/lang/String;)V", "getWindowColor", "setWindowColor", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIILjava/lang/Integer;Ljava/lang/String;ILjava/lang/Float;ZZ)Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "equals", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SaveCaptionStyle */
/* loaded from: classes4.dex */
public final class SaveCaptionStyle {
    private int backgroundColor;
    private int edgeColor;
    private int edgeType;
    private int elevation;
    private Float fixedTextSize;
    private int foregroundColor;
    private boolean removeBloat;
    private boolean removeCaptions;
    private Integer typeface;
    private String typefaceFilePath;
    private int windowColor;

    public final int component1() {
        return this.foregroundColor;
    }

    public final boolean component10() {
        return this.removeCaptions;
    }

    public final boolean component11() {
        return this.removeBloat;
    }

    public final int component2() {
        return this.backgroundColor;
    }

    public final int component3() {
        return this.windowColor;
    }

    public final int component4() {
        return this.edgeType;
    }

    public final int component5() {
        return this.edgeColor;
    }

    public final Integer component6() {
        return this.typeface;
    }

    public final String component7() {
        return this.typefaceFilePath;
    }

    public final int component8() {
        return this.elevation;
    }

    public final Float component9() {
        return this.fixedTextSize;
    }

    public final SaveCaptionStyle copy(@JsonProperty("foregroundColor") int i, @JsonProperty("backgroundColor") int i2, @JsonProperty("windowColor") int i3, @JsonProperty("edgeType") int i4, @JsonProperty("edgeColor") int i5, @JsonProperty("typeface") Integer num, @JsonProperty("typefaceFilePath") String str, @JsonProperty("elevation") int i6, @JsonProperty("fixedTextSize") Float f, @JsonProperty("removeCaptions") boolean z, @JsonProperty("removeBloat") boolean z2) {
        return new SaveCaptionStyle(i, i2, i3, i4, i5, num, str, i6, f, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SaveCaptionStyle) {
            SaveCaptionStyle saveCaptionStyle = (SaveCaptionStyle) obj;
            return this.foregroundColor == saveCaptionStyle.foregroundColor && this.backgroundColor == saveCaptionStyle.backgroundColor && this.windowColor == saveCaptionStyle.windowColor && this.edgeType == saveCaptionStyle.edgeType && this.edgeColor == saveCaptionStyle.edgeColor && Intrinsics.areEqual(this.typeface, saveCaptionStyle.typeface) && Intrinsics.areEqual(this.typefaceFilePath, saveCaptionStyle.typefaceFilePath) && this.elevation == saveCaptionStyle.elevation && Intrinsics.areEqual((Object) this.fixedTextSize, (Object) saveCaptionStyle.fixedTextSize) && this.removeCaptions == saveCaptionStyle.removeCaptions && this.removeBloat == saveCaptionStyle.removeBloat;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = ((((((((this.foregroundColor * 31) + this.backgroundColor) * 31) + this.windowColor) * 31) + this.edgeType) * 31) + this.edgeColor) * 31;
        Integer num = this.typeface;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.typefaceFilePath;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.elevation) * 31;
        Float f = this.fixedTextSize;
        int hashCode3 = (hashCode2 + (f != null ? f.hashCode() : 0)) * 31;
        boolean z = this.removeCaptions;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode3 + i2) * 31;
        boolean z2 = this.removeBloat;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "SaveCaptionStyle(foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ", windowColor=" + this.windowColor + ", edgeType=" + this.edgeType + ", edgeColor=" + this.edgeColor + ", typeface=" + this.typeface + ", typefaceFilePath=" + this.typefaceFilePath + ", elevation=" + this.elevation + ", fixedTextSize=" + this.fixedTextSize + ", removeCaptions=" + this.removeCaptions + ", removeBloat=" + this.removeBloat + ')';
    }

    public SaveCaptionStyle(@JsonProperty("foregroundColor") int i, @JsonProperty("backgroundColor") int i2, @JsonProperty("windowColor") int i3, @JsonProperty("edgeType") int i4, @JsonProperty("edgeColor") int i5, @JsonProperty("typeface") Integer num, @JsonProperty("typefaceFilePath") String str, @JsonProperty("elevation") int i6, @JsonProperty("fixedTextSize") Float f, @JsonProperty("removeCaptions") boolean z, @JsonProperty("removeBloat") boolean z2) {
        this.foregroundColor = i;
        this.backgroundColor = i2;
        this.windowColor = i3;
        this.edgeType = i4;
        this.edgeColor = i5;
        this.typeface = num;
        this.typefaceFilePath = str;
        this.elevation = i6;
        this.fixedTextSize = f;
        this.removeCaptions = z;
        this.removeBloat = z2;
    }

    public /* synthetic */ SaveCaptionStyle(int i, int i2, int i3, int i4, int i5, Integer num, String str, int i6, Float f, boolean z, boolean z2, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4, i5, num, str, i6, f, (i7 & 512) != 0 ? false : z, (i7 & 1024) != 0 ? true : z2);
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    public final void setForegroundColor(int i) {
        this.foregroundColor = i;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final int getWindowColor() {
        return this.windowColor;
    }

    public final void setWindowColor(int i) {
        this.windowColor = i;
    }

    public final int getEdgeType() {
        return this.edgeType;
    }

    public final void setEdgeType(int i) {
        this.edgeType = i;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final void setEdgeColor(int i) {
        this.edgeColor = i;
    }

    public final Integer getTypeface() {
        return this.typeface;
    }

    public final void setTypeface(Integer num) {
        this.typeface = num;
    }

    public final String getTypefaceFilePath() {
        return this.typefaceFilePath;
    }

    public final void setTypefaceFilePath(String str) {
        this.typefaceFilePath = str;
    }

    public final int getElevation() {
        return this.elevation;
    }

    public final void setElevation(int i) {
        this.elevation = i;
    }

    public final Float getFixedTextSize() {
        return this.fixedTextSize;
    }

    public final void setFixedTextSize(Float f) {
        this.fixedTextSize = f;
    }

    public final boolean getRemoveCaptions() {
        return this.removeCaptions;
    }

    public final void setRemoveCaptions(boolean z) {
        this.removeCaptions = z;
    }

    public final boolean getRemoveBloat() {
        return this.removeBloat;
    }

    public final void setRemoveBloat(boolean z) {
        this.removeBloat = z;
    }
}
