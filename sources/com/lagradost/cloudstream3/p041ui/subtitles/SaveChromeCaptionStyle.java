package com.lagradost.cloudstream3.p041ui.subtitles;

import androidx.core.view.ViewCompat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChromecastSubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0003\u0010\b\u001a\u00020\u0005\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005\u0012\b\b\u0003\u0010\n\u001a\u00020\u000b\u0012\b\b\u0003\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003Jb\u0010/\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u00052\b\b\u0003\u0010\b\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u00052\b\b\u0003\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011¨\u00066"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/subtitles/SaveChromeCaptionStyle;", "", TtmlNode.ATTR_TTS_FONT_FAMILY, "", "fontGenericFamily", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "edgeColor", "edgeType", "foregroundColor", "fontScale", "", "windowColor", "(Ljava/lang/String;Ljava/lang/Integer;IIIIFI)V", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "getEdgeColor", "setEdgeColor", "getEdgeType", "setEdgeType", "getFontFamily", "()Ljava/lang/String;", "setFontFamily", "(Ljava/lang/String;)V", "getFontGenericFamily", "()Ljava/lang/Integer;", "setFontGenericFamily", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFontScale", "()F", "setFontScale", "(F)V", "getForegroundColor", "setForegroundColor", "getWindowColor", "setWindowColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Integer;IIIIFI)Lcom/lagradost/cloudstream3/ui/subtitles/SaveChromeCaptionStyle;", "equals", "", "other", "hashCode", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SaveChromeCaptionStyle */
/* loaded from: classes4.dex */
public final class SaveChromeCaptionStyle {
    private int backgroundColor;
    private int edgeColor;
    private int edgeType;
    private String fontFamily;
    private Integer fontGenericFamily;
    private float fontScale;
    private int foregroundColor;
    private int windowColor;

    public SaveChromeCaptionStyle() {
        this(null, null, 0, 0, 0, 0, 0.0f, 0, 255, null);
    }

    public final String component1() {
        return this.fontFamily;
    }

    public final Integer component2() {
        return this.fontGenericFamily;
    }

    public final int component3() {
        return this.backgroundColor;
    }

    public final int component4() {
        return this.edgeColor;
    }

    public final int component5() {
        return this.edgeType;
    }

    public final int component6() {
        return this.foregroundColor;
    }

    public final float component7() {
        return this.fontScale;
    }

    public final int component8() {
        return this.windowColor;
    }

    public final SaveChromeCaptionStyle copy(@JsonProperty("fontFamily") String str, @JsonProperty("fontGenericFamily") Integer num, @JsonProperty("backgroundColor") int i, @JsonProperty("edgeColor") int i2, @JsonProperty("edgeType") int i3, @JsonProperty("foregroundColor") int i4, @JsonProperty("fontScale") float f, @JsonProperty("windowColor") int i5) {
        return new SaveChromeCaptionStyle(str, num, i, i2, i3, i4, f, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SaveChromeCaptionStyle) {
            SaveChromeCaptionStyle saveChromeCaptionStyle = (SaveChromeCaptionStyle) obj;
            return Intrinsics.areEqual(this.fontFamily, saveChromeCaptionStyle.fontFamily) && Intrinsics.areEqual(this.fontGenericFamily, saveChromeCaptionStyle.fontGenericFamily) && this.backgroundColor == saveChromeCaptionStyle.backgroundColor && this.edgeColor == saveChromeCaptionStyle.edgeColor && this.edgeType == saveChromeCaptionStyle.edgeType && this.foregroundColor == saveChromeCaptionStyle.foregroundColor && Intrinsics.areEqual((Object) Float.valueOf(this.fontScale), (Object) Float.valueOf(saveChromeCaptionStyle.fontScale)) && this.windowColor == saveChromeCaptionStyle.windowColor;
        }
        return false;
    }

    public int hashCode() {
        String str = this.fontFamily;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.fontGenericFamily;
        return ((((((((((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.backgroundColor) * 31) + this.edgeColor) * 31) + this.edgeType) * 31) + this.foregroundColor) * 31) + Float.floatToIntBits(this.fontScale)) * 31) + this.windowColor;
    }

    public String toString() {
        return "SaveChromeCaptionStyle(fontFamily=" + this.fontFamily + ", fontGenericFamily=" + this.fontGenericFamily + ", backgroundColor=" + this.backgroundColor + ", edgeColor=" + this.edgeColor + ", edgeType=" + this.edgeType + ", foregroundColor=" + this.foregroundColor + ", fontScale=" + this.fontScale + ", windowColor=" + this.windowColor + ')';
    }

    public SaveChromeCaptionStyle(@JsonProperty("fontFamily") String str, @JsonProperty("fontGenericFamily") Integer num, @JsonProperty("backgroundColor") int i, @JsonProperty("edgeColor") int i2, @JsonProperty("edgeType") int i3, @JsonProperty("foregroundColor") int i4, @JsonProperty("fontScale") float f, @JsonProperty("windowColor") int i5) {
        this.fontFamily = str;
        this.fontGenericFamily = num;
        this.backgroundColor = i;
        this.edgeColor = i2;
        this.edgeType = i3;
        this.foregroundColor = i4;
        this.fontScale = f;
        this.windowColor = i5;
    }

    public /* synthetic */ SaveChromeCaptionStyle(String str, Integer num, int i, int i2, int i3, int i4, float f, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) == 0 ? num : null, (i6 & 4) != 0 ? ViewCompat.MEASURED_SIZE_MASK : i, (i6 & 8) != 0 ? ViewCompat.MEASURED_STATE_MASK : i2, (i6 & 16) != 0 ? 1 : i3, (i6 & 32) != 0 ? -1 : i4, (i6 & 64) != 0 ? 1.05f : f, (i6 & 128) != 0 ? 0 : i5);
    }

    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final void setFontFamily(String str) {
        this.fontFamily = str;
    }

    public final Integer getFontGenericFamily() {
        return this.fontGenericFamily;
    }

    public final void setFontGenericFamily(Integer num) {
        this.fontGenericFamily = num;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final void setEdgeColor(int i) {
        this.edgeColor = i;
    }

    public final int getEdgeType() {
        return this.edgeType;
    }

    public final void setEdgeType(int i) {
        this.edgeType = i;
    }

    public final int getForegroundColor() {
        return this.foregroundColor;
    }

    public final void setForegroundColor(int i) {
        this.foregroundColor = i;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final void setFontScale(float f) {
        this.fontScale = f;
    }

    public final int getWindowColor() {
        return this.windowColor;
    }

    public final void setWindowColor(int i) {
        this.windowColor = i;
    }
}
