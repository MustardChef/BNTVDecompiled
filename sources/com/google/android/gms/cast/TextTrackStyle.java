package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.PlatformVersion;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public final class TextTrackStyle extends AbstractSafeParcelable {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final Parcelable.Creator<TextTrackStyle> CREATOR = new zzdj();
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    String zza;
    private float zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private String zzj;
    private int zzk;
    private int zzl;
    private JSONObject zzm;

    public TextTrackStyle() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        CaptioningManager captioningManager;
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (PlatformVersion.isAtLeastKitKat() && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null) {
            textTrackStyle.setFontScale(captioningManager.getFontScale());
            CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
            textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
            textTrackStyle.setForegroundColor(userStyle.foregroundColor);
            int i = userStyle.edgeType;
            if (i == 1) {
                textTrackStyle.setEdgeType(1);
            } else if (i == 2) {
                textTrackStyle.setEdgeType(2);
            } else {
                textTrackStyle.setEdgeType(0);
            }
            textTrackStyle.setEdgeColor(userStyle.edgeColor);
            Typeface typeface = userStyle.getTypeface();
            if (typeface != null) {
                if (Typeface.MONOSPACE.equals(typeface)) {
                    textTrackStyle.setFontGenericFamily(1);
                } else if (Typeface.SANS_SERIF.equals(typeface)) {
                    textTrackStyle.setFontGenericFamily(0);
                } else if (Typeface.SERIF.equals(typeface)) {
                    textTrackStyle.setFontGenericFamily(2);
                } else {
                    textTrackStyle.setFontGenericFamily(0);
                }
                boolean isBold = typeface.isBold();
                boolean isItalic = typeface.isItalic();
                if (isBold && isItalic) {
                    textTrackStyle.setFontStyle(3);
                } else if (isBold) {
                    textTrackStyle.setFontStyle(1);
                } else if (isItalic) {
                    textTrackStyle.setFontStyle(2);
                } else {
                    textTrackStyle.setFontStyle(0);
                }
            }
            return textTrackStyle;
        }
        return textTrackStyle;
    }

    private static final int zzb(String str) {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    private static final String zzc(int i) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TextTrackStyle) {
            TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
            JSONObject jSONObject = this.zzm;
            boolean z = jSONObject == null;
            JSONObject jSONObject2 = textTrackStyle.zzm;
            if (z != (jSONObject2 == null)) {
                return false;
            }
            return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.zzb == textTrackStyle.zzb && this.zzc == textTrackStyle.zzc && this.zzd == textTrackStyle.zzd && this.zze == textTrackStyle.zze && this.zzf == textTrackStyle.zzf && this.zzg == textTrackStyle.zzg && this.zzh == textTrackStyle.zzh && this.zzi == textTrackStyle.zzi && CastUtils.zza(this.zzj, textTrackStyle.zzj) && this.zzk == textTrackStyle.zzk && this.zzl == textTrackStyle.zzl;
        }
        return false;
    }

    public void fromJson(JSONObject jSONObject) throws JSONException {
        this.zzb = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzc = zzb(jSONObject.optString("foregroundColor"));
        this.zzd = zzb(jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zze = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zze = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zze = 2;
            } else if ("RAISED".equals(string)) {
                this.zze = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zze = 4;
            }
        }
        this.zzf = zzb(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzg = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzg = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzg = 2;
            }
        }
        this.zzh = zzb(jSONObject.optString("windowColor"));
        if (this.zzg == 2) {
            this.zzi = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzj = CastUtils.optStringOrNull(jSONObject, TtmlNode.ATTR_TTS_FONT_FAMILY);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzk = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzk = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzk = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzk = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzk = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.zzk = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.zzk = 6;
            }
        }
        if (jSONObject.has(TtmlNode.ATTR_TTS_FONT_STYLE)) {
            String string4 = jSONObject.getString(TtmlNode.ATTR_TTS_FONT_STYLE);
            if ("NORMAL".equals(string4)) {
                this.zzl = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzl = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzl = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzl = 3;
            }
        }
        this.zzm = jSONObject.optJSONObject("customData");
    }

    public int getBackgroundColor() {
        return this.zzd;
    }

    public JSONObject getCustomData() {
        return this.zzm;
    }

    public int getEdgeColor() {
        return this.zzf;
    }

    public int getEdgeType() {
        return this.zze;
    }

    public String getFontFamily() {
        return this.zzj;
    }

    public int getFontGenericFamily() {
        return this.zzk;
    }

    public float getFontScale() {
        return this.zzb;
    }

    public int getFontStyle() {
        return this.zzl;
    }

    public int getForegroundColor() {
        return this.zzc;
    }

    public int getWindowColor() {
        return this.zzh;
    }

    public int getWindowCornerRadius() {
        return this.zzi;
    }

    public int getWindowType() {
        return this.zzg;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(this.zzf), Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), String.valueOf(this.zzm));
    }

    public void setBackgroundColor(int i) {
        this.zzd = i;
    }

    public void setCustomData(JSONObject jSONObject) {
        this.zzm = jSONObject;
    }

    public void setEdgeColor(int i) {
        this.zzf = i;
    }

    public void setEdgeType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zze = i;
    }

    public void setFontFamily(String str) {
        this.zzj = str;
    }

    public void setFontGenericFamily(int i) {
        if (i < 0 || i > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzk = i;
    }

    public void setFontScale(float f) {
        this.zzb = f;
    }

    public void setFontStyle(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzl = i;
    }

    public void setForegroundColor(int i) {
        this.zzc = i;
    }

    public void setWindowColor(int i) {
        this.zzh = i;
    }

    public void setWindowCornerRadius(int i) {
        if (i >= 0) {
            this.zzi = i;
            return;
        }
        throw new IllegalArgumentException("invalid windowCornerRadius");
    }

    public void setWindowType(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzg = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        JSONObject jSONObject = this.zzm;
        this.zza = jSONObject == null ? null : jSONObject.toString();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, getFontScale());
        SafeParcelWriter.writeInt(parcel, 3, getForegroundColor());
        SafeParcelWriter.writeInt(parcel, 4, getBackgroundColor());
        SafeParcelWriter.writeInt(parcel, 5, getEdgeType());
        SafeParcelWriter.writeInt(parcel, 6, getEdgeColor());
        SafeParcelWriter.writeInt(parcel, 7, getWindowType());
        SafeParcelWriter.writeInt(parcel, 8, getWindowColor());
        SafeParcelWriter.writeInt(parcel, 9, getWindowCornerRadius());
        SafeParcelWriter.writeString(parcel, 10, getFontFamily(), false);
        SafeParcelWriter.writeInt(parcel, 11, getFontGenericFamily());
        SafeParcelWriter.writeInt(parcel, 12, getFontStyle());
        SafeParcelWriter.writeString(parcel, 13, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.zzb);
            int i = this.zzc;
            if (i != 0) {
                jSONObject.put("foregroundColor", zzc(i));
            }
            int i2 = this.zzd;
            if (i2 != 0) {
                jSONObject.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, zzc(i2));
            }
            int i3 = this.zze;
            if (i3 == 0) {
                jSONObject.put("edgeType", "NONE");
            } else if (i3 == 1) {
                jSONObject.put("edgeType", "OUTLINE");
            } else if (i3 == 2) {
                jSONObject.put("edgeType", "DROP_SHADOW");
            } else if (i3 == 3) {
                jSONObject.put("edgeType", "RAISED");
            } else if (i3 == 4) {
                jSONObject.put("edgeType", "DEPRESSED");
            }
            int i4 = this.zzf;
            if (i4 != 0) {
                jSONObject.put("edgeColor", zzc(i4));
            }
            int i5 = this.zzg;
            if (i5 == 0) {
                jSONObject.put("windowType", "NONE");
            } else if (i5 == 1) {
                jSONObject.put("windowType", "NORMAL");
            } else if (i5 == 2) {
                jSONObject.put("windowType", "ROUNDED_CORNERS");
            }
            int i6 = this.zzh;
            if (i6 != 0) {
                jSONObject.put("windowColor", zzc(i6));
            }
            if (this.zzg == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzi);
            }
            String str = this.zzj;
            if (str != null) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_FAMILY, str);
            }
            switch (this.zzk) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            int i7 = this.zzl;
            if (i7 == 0) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "NORMAL");
            } else if (i7 == 1) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "BOLD");
            } else if (i7 == 2) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "ITALIC");
            } else if (i7 == 3) {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_STYLE, "BOLD_ITALIC");
            }
            JSONObject jSONObject2 = this.zzm;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextTrackStyle(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str, int i8, int i9, String str2) {
        this.zzb = f;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = i6;
        this.zzi = i7;
        this.zzj = str;
        this.zzk = i8;
        this.zzl = i9;
        this.zza = str2;
        if (str2 == null) {
            this.zzm = null;
            return;
        }
        try {
            this.zzm = new JSONObject(str2);
        } catch (JSONException unused) {
            this.zzm = null;
            this.zza = null;
        }
    }
}
