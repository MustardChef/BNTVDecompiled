package xyz.schwaab.avvylib;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import kotlin.Metadata;

/* compiled from: Defaults.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\bR\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001bX\u0086T¢\u0006\u0002\n\u0000¨\u0006#"}, m107d2 = {"Lxyz/schwaab/avvylib/Defaults;", "", "()V", "ARCHES_DEGREES_AREA", "", "BADGE_COLOR", "", "getBADGE_COLOR", "()I", "BADGE_RADIUS", "BADGE_STROKE_COLOR", "getBADGE_STROKE_COLOR", "BITMAP_CONFIG", "Landroid/graphics/Bitmap$Config;", "getBITMAP_CONFIG", "()Landroid/graphics/Bitmap$Config;", "BORDER_COLOR", "getBORDER_COLOR", "BORDER_COLOR_HIGHLIGHT", "getBORDER_COLOR_HIGHLIGHT", "BORDER_THICKNESS", "CIRCLE_BACKGROUND_COLOR", "COLORDRAWABLE_DIMENSION", "DISTANCE_TO_BORDER", "HIGHLIGHTED_BORDER_THICKNESS", "INDIVIDUAL_ARCH_DEGREES_LENGTH", "IS_HIGHLIGHTED", "", "MIDDLE_COLOR", "NUMBER_OF_ARCHES", "SCALE_TYPE", "Landroid/widget/ImageView$ScaleType;", "getSCALE_TYPE", "()Landroid/widget/ImageView$ScaleType;", "SHOW_BADGE", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class Defaults {
    public static final float ARCHES_DEGREES_AREA = 90.0f;
    public static final float BADGE_RADIUS = 8.0f;
    public static final int BORDER_THICKNESS = 12;
    public static final int CIRCLE_BACKGROUND_COLOR = 0;
    public static final int COLORDRAWABLE_DIMENSION = 2;
    public static final int DISTANCE_TO_BORDER = 25;
    public static final int HIGHLIGHTED_BORDER_THICKNESS = 16;
    public static final float INDIVIDUAL_ARCH_DEGREES_LENGTH = 3.0f;
    public static final boolean IS_HIGHLIGHTED = false;
    public static final int MIDDLE_COLOR = 0;
    public static final int NUMBER_OF_ARCHES = 5;
    public static final boolean SHOW_BADGE = false;
    public static final Defaults INSTANCE = new Defaults();
    private static final ImageView.ScaleType SCALE_TYPE = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int BORDER_COLOR_HIGHLIGHT = Color.parseColor("#ffff6d00");
    private static final int BORDER_COLOR = Color.parseColor("#ff757575");
    private static final int BADGE_COLOR = Color.parseColor("#00FF00");
    private static final int BADGE_STROKE_COLOR = Color.parseColor("#FFFFFF");

    private Defaults() {
    }

    public final ImageView.ScaleType getSCALE_TYPE() {
        return SCALE_TYPE;
    }

    public final Bitmap.Config getBITMAP_CONFIG() {
        return BITMAP_CONFIG;
    }

    public final int getBORDER_COLOR_HIGHLIGHT() {
        return BORDER_COLOR_HIGHLIGHT;
    }

    public final int getBORDER_COLOR() {
        return BORDER_COLOR;
    }

    public final int getBADGE_COLOR() {
        return BADGE_COLOR;
    }

    public final int getBADGE_STROKE_COLOR() {
        return BADGE_STROKE_COLOR;
    }
}
