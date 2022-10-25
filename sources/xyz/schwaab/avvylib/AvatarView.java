package xyz.schwaab.avvylib;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import xyz.schwaab.avvylib.animation.AvatarViewAnimationOrchestrator;
import xyz.schwaab.avvylib.animation.DefaultAnimationOrchestrator;

/* compiled from: AvatarView.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 ¿\u00012\u00020\u0001:\b½\u0001¾\u0001¿\u0001À\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0012\u0010\u0090\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\t\u0010\u0091\u0001\u001a\u00020\u0017H\u0002J\u001d\u0010\u0092\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0093\u0001\u001a\u00020!2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J\u0014\u0010\u0096\u0001\u001a\u00030\u008f\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u008f\u0001H\u0002J\u0017\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001e2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0002J\t\u0010\u009b\u0001\u001a\u00020aH\u0002J\u001b\u0010\u009c\u0001\u001a\u00020a2\u0007\u0010\u009d\u0001\u001a\u00020!2\u0007\u0010\u009e\u0001\u001a\u00020!H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u008f\u0001H\u0002J\n\u0010 \u0001\u001a\u00030\u008f\u0001H\u0002J\n\u0010¡\u0001\u001a\u00030\u008f\u0001H\u0002J\u0014\u0010¢\u0001\u001a\u00030\u008f\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0014J.\u0010£\u0001\u001a\u00030\u008f\u00012\u0007\u0010¤\u0001\u001a\u00020\t2\u0007\u0010¥\u0001\u001a\u00020\t2\u0007\u0010¦\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\tH\u0014J\u0013\u0010¨\u0001\u001a\u00020a2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0017J\t\u0010«\u0001\u001a\u00020aH\u0016J\t\u0010¬\u0001\u001a\u00020aH\u0016J\u001c\u0010\u00ad\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J\u0013\u0010®\u0001\u001a\u00030\u008f\u00012\u0007\u0010¯\u0001\u001a\u00020\u001eH\u0016J\u0016\u0010°\u0001\u001a\u00030\u008f\u00012\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\u0015\u0010±\u0001\u001a\u00030\u008f\u00012\t\b\u0001\u0010²\u0001\u001a\u00020\tH\u0016J.\u0010³\u0001\u001a\u00030\u008f\u00012\u0007\u0010´\u0001\u001a\u00020\t2\u0007\u0010µ\u0001\u001a\u00020\t2\u0007\u0010¶\u0001\u001a\u00020\t2\u0007\u0010·\u0001\u001a\u00020\tH\u0016J.\u0010¸\u0001\u001a\u00030\u008f\u00012\u0007\u0010¹\u0001\u001a\u00020\t2\u0007\u0010µ\u0001\u001a\u00020\t2\u0007\u0010º\u0001\u001a\u00020\t2\u0007\u0010·\u0001\u001a\u00020\tH\u0016J\n\u0010»\u0001\u001a\u00030\u008f\u0001H\u0002J\n\u0010¼\u0001\u001a\u00030\u008f\u0001H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R$\u0010$\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020!2\u0006\u0010\r\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u00102R$\u00103\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR\u000e\u00106\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00107\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001a\"\u0004\b9\u0010\u001cR\u000e\u0010:\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010?\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001a\"\u0004\bA\u0010\u001cR$\u0010B\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001a\"\u0004\bD\u0010\u001cR\u000e\u0010E\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010H\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001a\"\u0004\bJ\u0010\u001cR\u000e\u0010K\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010L\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u001a\"\u0004\bN\u0010\u001cR\u000e\u0010O\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010P\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u001a\"\u0004\bR\u0010\u001cR$\u0010S\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u001a\"\u0004\bU\u0010\u001cR$\u0010V\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001a\"\u0004\bX\u0010\u001cR$\u0010Y\u001a\u00020!2\u0006\u0010\r\u001a\u00020!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010#\"\u0004\b[\u00102R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010b\u001a\u00020a2\u0006\u0010\r\u001a\u00020a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010f\u001a\u00020a2\u0006\u0010\r\u001a\u00020a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010c\"\u0004\bg\u0010eR\u000e\u0010h\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020aX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010j\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u001a\"\u0004\bl\u0010\u001cR\u000e\u0010m\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010q\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u001a\"\u0004\bs\u0010\u001cR\u0016\u0010t\u001a\n v*\u0004\u0018\u00010u0uX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010y\u001a\u00020aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010c\"\u0004\b{\u0010eR$\u0010|\u001a\u00020a2\u0006\u0010\r\u001a\u00020a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010c\"\u0004\b~\u0010eR\u0015\u0010\u007f\u001a\u00020!8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010#R-\u0010\u0081\u0001\u001a\u0004\u0018\u00010]2\b\u0010\r\u001a\u0004\u0018\u00010]@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R'\u0010\u0086\u0001\u001a\u00020!2\u0006\u0010\r\u001a\u00020!@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010#\"\u0005\b\u0088\u0001\u00102R\u001b\u0010\u0089\u0001\u001a\u00020!*\u00020\f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u00020!*\u00020\f8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008d\u0001\u0010\u008b\u0001¨\u0006Á\u0001"}, m107d2 = {"Lxyz/schwaab/avvylib/AvatarView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationDrawingState", "Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState;", "value", "Lxyz/schwaab/avvylib/animation/AvatarViewAnimationOrchestrator;", "animationOrchestrator", "getAnimationOrchestrator", "()Lxyz/schwaab/avvylib/animation/AvatarViewAnimationOrchestrator;", "setAnimationOrchestrator", "(Lxyz/schwaab/avvylib/animation/AvatarViewAnimationOrchestrator;)V", "animatorInterface", "Lxyz/schwaab/avvylib/AvatarView$AnimatorInterface;", "arcBorderRect", "Landroid/graphics/RectF;", "avatarBackgroundColor", "getAvatarBackgroundColor", "()I", "setAvatarBackgroundColor", "(I)V", "avatarDrawable", "Landroid/graphics/Bitmap;", "avatarDrawableRect", "avatarInset", "", "getAvatarInset", "()F", "badgeColor", "getBadgeColor", "setBadgeColor", "badgePaint", "Landroid/graphics/Paint;", "Lxyz/schwaab/avvylib/BadgePosition;", "badgePosition", "getBadgePosition", "()Lxyz/schwaab/avvylib/BadgePosition;", "setBadgePosition", "(Lxyz/schwaab/avvylib/BadgePosition;)V", "badgeRadius", "getBadgeRadius", "setBadgeRadius", "(F)V", "badgeStrokeColor", "getBadgeStrokeColor", "setBadgeStrokeColor", "badgeStrokePaint", "badgeStrokeWidth", "getBadgeStrokeWidth", "setBadgeStrokeWidth", "bitmapHeight", "bitmapPaint", "bitmapShader", "Landroid/graphics/BitmapShader;", "bitmapWidth", "borderColor", "getBorderColor", "setBorderColor", "borderColorEnd", "getBorderColorEnd", "setBorderColorEnd", "borderPaint", "borderRadius", "borderRect", "borderThickness", "getBorderThickness", "setBorderThickness", "circleBackgroundPaint", "distanceToBorder", "getDistanceToBorder", "setDistanceToBorder", "drawableRadius", "highlightBorderColor", "getHighlightBorderColor", "setHighlightBorderColor", "highlightBorderColorEnd", "getHighlightBorderColorEnd", "setHighlightBorderColorEnd", "highlightedBorderThickness", "getHighlightedBorderThickness", "setHighlightedBorderThickness", "individualArcDegreeLength", "getIndividualArcDegreeLength", "setIndividualArcDegreeLength", "initials", "", "initialsPaint", "initialsRect", "Landroid/graphics/Rect;", "", "isAnimating", "()Z", "setAnimating", "(Z)V", "isHighlighted", "setHighlighted", "isReadingAttributes", "isReversedAnimating", "middleColor", "getMiddleColor", "setMiddleColor", "middlePaint", "middleRadius", "middleRect", "middleThickness", "numberOfArches", "getNumberOfArches", "setNumberOfArches", "scaleAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "shaderMatrix", "Landroid/graphics/Matrix;", "shouldBounceOnClick", "getShouldBounceOnClick", "setShouldBounceOnClick", "showBadge", "getShowBadge", "setShowBadge", "spaceBetweenArches", "getSpaceBetweenArches", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "totalArchesDegreeArea", "getTotalArchesDegreeArea", "setTotalArchesDegreeArea", "archesAreaInDegrees", "getArchesAreaInDegrees", "(Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState;)F", "rotationInDegrees", "getRotationInDegrees", "animateClick", "", "attachOrchestrator", "calculateBounds", "drawArches", "totalDegrees", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "findInitials", "getBitmapFromDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "hasAvatar", "inTouchableArea", "x", "y", "init", "initializeBitmap", "logWarningOnArcLengthIfNeeded", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "performClick", "performLongClick", "readAttrs", "setImageBitmap", "bm", "setImageDrawable", "setImageResource", "resId", "setPadding", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, TtmlNode.RIGHT, "bottom", "setPaddingRelative", TtmlNode.START, TtmlNode.END, "setup", "updateShaderMatrix", "AnimationDrawingState", "AnimatorInterface", "Companion", "OutlineProvider", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class AvatarView extends ImageView {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "AvatarView";
    private AnimationDrawingState animationDrawingState;
    private AvatarViewAnimationOrchestrator animationOrchestrator;
    private final AnimatorInterface animatorInterface;
    private final RectF arcBorderRect;
    private int avatarBackgroundColor;
    private Bitmap avatarDrawable;
    private final RectF avatarDrawableRect;
    private int badgeColor;
    private final Paint badgePaint;
    private BadgePosition badgePosition;
    private float badgeRadius;
    private int badgeStrokeColor;
    private final Paint badgeStrokePaint;
    private int badgeStrokeWidth;
    private int bitmapHeight;
    private final Paint bitmapPaint;
    private BitmapShader bitmapShader;
    private int bitmapWidth;
    private int borderColor;
    private int borderColorEnd;
    private final Paint borderPaint;
    private float borderRadius;
    private final RectF borderRect;
    private int borderThickness;
    private final Paint circleBackgroundPaint;
    private int distanceToBorder;
    private float drawableRadius;
    private int highlightBorderColor;
    private int highlightBorderColorEnd;
    private int highlightedBorderThickness;
    private float individualArcDegreeLength;
    private String initials;
    private final Paint initialsPaint;
    private final Rect initialsRect;
    private boolean isAnimating;
    private boolean isHighlighted;
    private boolean isReadingAttributes;
    private boolean isReversedAnimating;
    private int middleColor;
    private final Paint middlePaint;
    private float middleRadius;
    private final RectF middleRect;
    private float middleThickness;
    private int numberOfArches;
    private final ValueAnimator scaleAnimator;
    private final Matrix shaderMatrix;
    private boolean shouldBounceOnClick;
    private boolean showBadge;
    private String text;
    private float totalArchesDegreeArea;

    @Metadata(m109bv = {1, 0, 3}, m106k = 3, m105mv = {1, 4, 0})
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BadgePosition.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[BadgePosition.BOTTOM_RIGHT.ordinal()] = 1;
            iArr[BadgePosition.BOTTOM_LEFT.ordinal()] = 2;
            iArr[BadgePosition.TOP_RIGHT.ordinal()] = 3;
            iArr[BadgePosition.TOP_LEFT.ordinal()] = 4;
        }
    }

    /* compiled from: AvatarView.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lxyz/schwaab/avvylib/AvatarView$Companion;", "", "()V", "TAG", "", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final float getAvatarInset() {
        return this.distanceToBorder + Math.max(this.borderThickness, this.highlightedBorderThickness);
    }

    public final float getTotalArchesDegreeArea() {
        return this.totalArchesDegreeArea;
    }

    public final void setTotalArchesDegreeArea(float f) {
        this.totalArchesDegreeArea = f;
        logWarningOnArcLengthIfNeeded();
        setup();
    }

    public final int getNumberOfArches() {
        return this.numberOfArches;
    }

    public final void setNumberOfArches(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.numberOfArches = i;
        logWarningOnArcLengthIfNeeded();
        setup();
    }

    public final float getIndividualArcDegreeLength() {
        return this.individualArcDegreeLength;
    }

    public final void setIndividualArcDegreeLength(float f) {
        this.individualArcDegreeLength = f;
        logWarningOnArcLengthIfNeeded();
        setup();
    }

    private final void logWarningOnArcLengthIfNeeded() {
        if (this.individualArcDegreeLength * this.numberOfArches > this.totalArchesDegreeArea) {
            Log.w(TAG, "The arches are too big for them to be visible. (i.e. individualArcLength * numberOfArches > totalArchesDegreeArea)");
        }
    }

    public final int getMiddleColor() {
        return this.middleColor;
    }

    public final void setMiddleColor(int i) {
        this.middleColor = i;
        setup();
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final void setBorderColor(int i) {
        this.borderColor = i;
        setup();
    }

    public final int getBorderColorEnd() {
        return this.borderColorEnd;
    }

    public final void setBorderColorEnd(int i) {
        this.borderColorEnd = i;
        setup();
    }

    public final int getHighlightBorderColor() {
        return this.highlightBorderColor;
    }

    public final void setHighlightBorderColor(int i) {
        this.highlightBorderColor = i;
        setup();
    }

    public final int getHighlightBorderColorEnd() {
        return this.highlightBorderColorEnd;
    }

    public final void setHighlightBorderColorEnd(int i) {
        this.highlightBorderColorEnd = i;
        setup();
    }

    public final int getDistanceToBorder() {
        return this.distanceToBorder;
    }

    public final void setDistanceToBorder(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.distanceToBorder = i;
        setup();
    }

    public final int getBorderThickness() {
        return this.borderThickness;
    }

    public final void setBorderThickness(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.borderThickness = i;
        setup();
    }

    public final int getHighlightedBorderThickness() {
        return this.highlightedBorderThickness;
    }

    public final void setHighlightedBorderThickness(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.highlightedBorderThickness = i;
        setup();
    }

    public final int getAvatarBackgroundColor() {
        return this.avatarBackgroundColor;
    }

    public final void setAvatarBackgroundColor(int i) {
        this.avatarBackgroundColor = i;
        setup();
    }

    public final boolean getShouldBounceOnClick() {
        return this.shouldBounceOnClick;
    }

    public final void setShouldBounceOnClick(boolean z) {
        this.shouldBounceOnClick = z;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
        findInitials();
        setup();
    }

    public final float getBadgeRadius() {
        return this.badgeRadius;
    }

    public final void setBadgeRadius(float f) {
        this.badgeRadius = f;
        setup();
    }

    public final int getBadgeColor() {
        return this.badgeColor;
    }

    public final void setBadgeColor(int i) {
        this.badgeColor = i;
        setup();
    }

    public final int getBadgeStrokeColor() {
        return this.badgeStrokeColor;
    }

    public final void setBadgeStrokeColor(int i) {
        this.badgeStrokeColor = i;
        setup();
    }

    public final int getBadgeStrokeWidth() {
        return this.badgeStrokeWidth;
    }

    public final void setBadgeStrokeWidth(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.badgeStrokeWidth = i;
        setup();
    }

    public final boolean getShowBadge() {
        return this.showBadge;
    }

    public final void setShowBadge(boolean z) {
        this.showBadge = z;
        setup();
    }

    public final BadgePosition getBadgePosition() {
        return this.badgePosition;
    }

    public final void setBadgePosition(BadgePosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.badgePosition = value;
        setup();
    }

    private final float getSpaceBetweenArches() {
        return (this.totalArchesDegreeArea / this.numberOfArches) - this.individualArcDegreeLength;
    }

    private final float getArchesAreaInDegrees(AnimationDrawingState animationDrawingState) {
        return animationDrawingState.getCoercedArchesExpansionProgress() * this.totalArchesDegreeArea;
    }

    private final float getRotationInDegrees(AnimationDrawingState animationDrawingState) {
        return animationDrawingState.getCoercedRotationProgress() * 360;
    }

    public final boolean isHighlighted() {
        return this.isHighlighted;
    }

    public final void setHighlighted(boolean z) {
        this.isHighlighted = z;
        setup();
    }

    public final AvatarViewAnimationOrchestrator getAnimationOrchestrator() {
        return this.animationOrchestrator;
    }

    public final void setAnimationOrchestrator(AvatarViewAnimationOrchestrator value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(this.animationOrchestrator, value)) {
            return;
        }
        this.animationOrchestrator.cancel$avvylib_release();
        this.animationOrchestrator = value;
        attachOrchestrator(value);
    }

    private final void attachOrchestrator(AvatarViewAnimationOrchestrator avatarViewAnimationOrchestrator) {
        avatarViewAnimationOrchestrator.attach$avvylib_release(this.animatorInterface, new AvatarView$attachOrchestrator$1(this));
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    public final void setAnimating(boolean z) {
        if (z && !this.isAnimating) {
            if (this.isReversedAnimating) {
                this.animationOrchestrator.reverse$avvylib_release();
            }
            this.animationOrchestrator.start$avvylib_release();
        } else if (!z && this.isAnimating) {
            this.isReversedAnimating = true;
            this.animationOrchestrator.cancel$avvylib_release();
            this.animationOrchestrator.reverse$avvylib_release();
        }
        this.isAnimating = z;
        setup();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.avatarDrawableRect = new RectF();
        this.middleRect = new RectF();
        this.borderRect = new RectF();
        this.arcBorderRect = new RectF();
        this.initialsRect = new Rect();
        this.shaderMatrix = new Matrix();
        this.bitmapPaint = new Paint();
        this.middlePaint = new Paint();
        this.borderPaint = new Paint();
        this.circleBackgroundPaint = new Paint();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextSize(20.0f);
        setup();
        Unit unit = Unit.INSTANCE;
        this.initialsPaint = paint;
        this.badgePaint = new Paint();
        this.badgeStrokePaint = new Paint();
        this.totalArchesDegreeArea = 90.0f;
        this.numberOfArches = 5;
        this.individualArcDegreeLength = 3.0f;
        this.borderColor = Defaults.INSTANCE.getBORDER_COLOR();
        this.borderColorEnd = Defaults.INSTANCE.getBORDER_COLOR();
        this.highlightBorderColor = Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT();
        this.highlightBorderColorEnd = Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT();
        this.distanceToBorder = 25;
        this.borderThickness = 12;
        this.highlightedBorderThickness = 16;
        this.shouldBounceOnClick = true;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.badgeRadius = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        this.badgeColor = Defaults.INSTANCE.getBADGE_COLOR();
        this.badgeStrokeColor = Defaults.INSTANCE.getBADGE_STROKE_COLOR();
        this.badgePosition = BadgePosition.BOTTOM_RIGHT;
        this.animatorInterface = new AnimatorInterface();
        this.animationDrawingState = new AnimationDrawingState(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.9f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.schwaab.avvylib.AvatarView$$special$$inlined$apply$lambda$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                AvatarView avatarView = AvatarView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                avatarView.setScaleX(((Float) animatedValue).floatValue());
                AvatarView avatarView2 = AvatarView.this;
                Object animatedValue2 = it.getAnimatedValue();
                Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                avatarView2.setScaleY(((Float) animatedValue2).floatValue());
            }
        });
        Unit unit2 = Unit.INSTANCE;
        this.scaleAnimator = ofFloat;
        AvatarViewAnimationOrchestrator create$default = DefaultAnimationOrchestrator.create$default(DefaultAnimationOrchestrator.INSTANCE, 0L, 0L, 3, null);
        attachOrchestrator(create$default);
        Unit unit3 = Unit.INSTANCE;
        this.animationOrchestrator = create$default;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.avatarDrawableRect = new RectF();
        this.middleRect = new RectF();
        this.borderRect = new RectF();
        this.arcBorderRect = new RectF();
        this.initialsRect = new Rect();
        this.shaderMatrix = new Matrix();
        this.bitmapPaint = new Paint();
        this.middlePaint = new Paint();
        this.borderPaint = new Paint();
        this.circleBackgroundPaint = new Paint();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextSize(20.0f);
        setup();
        Unit unit = Unit.INSTANCE;
        this.initialsPaint = paint;
        this.badgePaint = new Paint();
        this.badgeStrokePaint = new Paint();
        this.totalArchesDegreeArea = 90.0f;
        this.numberOfArches = 5;
        this.individualArcDegreeLength = 3.0f;
        this.borderColor = Defaults.INSTANCE.getBORDER_COLOR();
        this.borderColorEnd = Defaults.INSTANCE.getBORDER_COLOR();
        this.highlightBorderColor = Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT();
        this.highlightBorderColorEnd = Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT();
        this.distanceToBorder = 25;
        this.borderThickness = 12;
        this.highlightedBorderThickness = 16;
        this.shouldBounceOnClick = true;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.badgeRadius = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        this.badgeColor = Defaults.INSTANCE.getBADGE_COLOR();
        this.badgeStrokeColor = Defaults.INSTANCE.getBADGE_STROKE_COLOR();
        this.badgePosition = BadgePosition.BOTTOM_RIGHT;
        this.animatorInterface = new AnimatorInterface();
        this.animationDrawingState = new AnimationDrawingState(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.9f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.schwaab.avvylib.AvatarView$$special$$inlined$apply$lambda$2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                AvatarView avatarView = AvatarView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                avatarView.setScaleX(((Float) animatedValue).floatValue());
                AvatarView avatarView2 = AvatarView.this;
                Object animatedValue2 = it.getAnimatedValue();
                Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                avatarView2.setScaleY(((Float) animatedValue2).floatValue());
            }
        });
        Unit unit2 = Unit.INSTANCE;
        this.scaleAnimator = ofFloat;
        AvatarViewAnimationOrchestrator create$default = DefaultAnimationOrchestrator.create$default(DefaultAnimationOrchestrator.INSTANCE, 0L, 0L, 3, null);
        attachOrchestrator(create$default);
        Unit unit3 = Unit.INSTANCE;
        this.animationOrchestrator = create$default;
        readAttrs$default(this, attrs, 0, 2, null);
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.avatarDrawableRect = new RectF();
        this.middleRect = new RectF();
        this.borderRect = new RectF();
        this.arcBorderRect = new RectF();
        this.initialsRect = new Rect();
        this.shaderMatrix = new Matrix();
        this.bitmapPaint = new Paint();
        this.middlePaint = new Paint();
        this.borderPaint = new Paint();
        this.circleBackgroundPaint = new Paint();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTextSize(20.0f);
        setup();
        Unit unit = Unit.INSTANCE;
        this.initialsPaint = paint;
        this.badgePaint = new Paint();
        this.badgeStrokePaint = new Paint();
        this.totalArchesDegreeArea = 90.0f;
        this.numberOfArches = 5;
        this.individualArcDegreeLength = 3.0f;
        this.borderColor = Defaults.INSTANCE.getBORDER_COLOR();
        this.borderColorEnd = Defaults.INSTANCE.getBORDER_COLOR();
        this.highlightBorderColor = Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT();
        this.highlightBorderColorEnd = Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT();
        this.distanceToBorder = 25;
        this.borderThickness = 12;
        this.highlightedBorderThickness = 16;
        this.shouldBounceOnClick = true;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        this.badgeRadius = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        this.badgeColor = Defaults.INSTANCE.getBADGE_COLOR();
        this.badgeStrokeColor = Defaults.INSTANCE.getBADGE_STROKE_COLOR();
        this.badgePosition = BadgePosition.BOTTOM_RIGHT;
        this.animatorInterface = new AnimatorInterface();
        this.animationDrawingState = new AnimationDrawingState(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.9f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.schwaab.avvylib.AvatarView$$special$$inlined$apply$lambda$3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator it) {
                AvatarView avatarView = AvatarView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Object animatedValue = it.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                avatarView.setScaleX(((Float) animatedValue).floatValue());
                AvatarView avatarView2 = AvatarView.this;
                Object animatedValue2 = it.getAnimatedValue();
                Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
                avatarView2.setScaleY(((Float) animatedValue2).floatValue());
            }
        });
        Unit unit2 = Unit.INSTANCE;
        this.scaleAnimator = ofFloat;
        AvatarViewAnimationOrchestrator create$default = DefaultAnimationOrchestrator.create$default(DefaultAnimationOrchestrator.INSTANCE, 0L, 0L, 3, null);
        attachOrchestrator(create$default);
        Unit unit3 = Unit.INSTANCE;
        this.animationOrchestrator = create$default;
        readAttrs(attrs, i);
        init();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        Intrinsics.checkNotNullParameter(bm, "bm");
        super.setImageBitmap(bm);
        initializeBitmap();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        initializeBitmap();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        initializeBitmap();
    }

    static /* synthetic */ void readAttrs$default(AvatarView avatarView, AttributeSet attributeSet, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        avatarView.readAttrs(attributeSet, i);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [org.jacoco.agent.rt.internal_b0d6a23.Agent, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int, void] */
    private final void readAttrs(AttributeSet attributeSet, int i) {
        this.isReadingAttributes = true;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5569R.styleable.AvatarView, i, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr….AvatarView, defStyle, 0)");
        setAvatarBackgroundColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_circle_background_color, 0));
        setDistanceToBorder(obtainStyledAttributes.getDimensionPixelSize(C5569R.styleable.AvatarView_avvy_distance_to_border, 25));
        setBorderThickness(obtainStyledAttributes.getDimensionPixelSize(C5569R.styleable.AvatarView_avvy_border_thickness, 12));
        setHighlightedBorderThickness(obtainStyledAttributes.getDimensionPixelSize(C5569R.styleable.AvatarView_avvy_border_thickness_highlight, 16));
        setMiddleColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_middle_color, 0));
        setBorderColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_border_color, Defaults.INSTANCE.getBORDER_COLOR()));
        setBorderColorEnd(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_border_color_end, this.borderColor));
        setHighlightBorderColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_border_highlight_color, Defaults.INSTANCE.getBORDER_COLOR_HIGHLIGHT()));
        setHighlightBorderColorEnd(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_border_highlight_color_end, this.highlightBorderColor));
        setHighlighted(obtainStyledAttributes.getBoolean(C5569R.styleable.AvatarView_avvy_highlighted, false));
        setTotalArchesDegreeArea(obtainStyledAttributes.getFloat(C5569R.styleable.AvatarView_avvy_loading_arches_degree_area, 90.0f));
        setNumberOfArches(obtainStyledAttributes.getInt(C5569R.styleable.AvatarView_avvy_loading_arches, 5));
        setIndividualArcDegreeLength(obtainStyledAttributes.getFloat(C5569R.styleable.AvatarView_avvy_loading_arc_degree_length, 3.0f));
        this.initialsPaint.setTextSize(obtainStyledAttributes.getDimension(C5569R.styleable.AvatarView_avvy_text_size, this.initialsPaint.getTextSize()));
        this.initialsPaint.setColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_text_color, this.initialsPaint.shutdown()));
        setText(obtainStyledAttributes.getString(C5569R.styleable.AvatarView_avvy_text));
        setShowBadge(obtainStyledAttributes.getBoolean(C5569R.styleable.AvatarView_avvy_show_badge, false));
        setBadgeColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_badge_color, Defaults.INSTANCE.getBADGE_COLOR()));
        setBadgeStrokeColor(obtainStyledAttributes.getColor(C5569R.styleable.AvatarView_avvy_badge_stroke_color, Defaults.INSTANCE.getBADGE_STROKE_COLOR()));
        setBadgeStrokeWidth(obtainStyledAttributes.getDimensionPixelSize(C5569R.styleable.AvatarView_avvy_badge_stroke_width, this.badgeStrokeWidth));
        setBadgeRadius(obtainStyledAttributes.getDimension(C5569R.styleable.AvatarView_avvy_badge_radius, this.badgeRadius));
        setBadgePosition(BadgePosition.values()[obtainStyledAttributes.getInt(C5569R.styleable.AvatarView_avvy_badge_position, 0)]);
        obtainStyledAttributes.recycle();
        this.isReadingAttributes = false;
    }

    private final void init() {
        setScaleType(Defaults.INSTANCE.getSCALE_TYPE());
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
        setup();
    }

    private final void setup() {
        int i;
        if (this.isReadingAttributes) {
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        Bitmap bitmap = this.avatarDrawable;
        if (bitmap == null) {
            setImageResource(17170445);
            return;
        }
        this.bitmapHeight = bitmap.getHeight();
        this.bitmapWidth = bitmap.getWidth();
        this.bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.bitmapPaint.setAntiAlias(true);
        this.bitmapPaint.setShader(this.bitmapShader);
        if (this.isHighlighted) {
            i = this.highlightedBorderThickness;
        } else {
            i = this.borderThickness;
        }
        float f = i;
        this.borderRect.set(calculateBounds());
        this.borderRadius = Math.min((this.borderRect.height() - f) / 2.0f, (this.borderRect.width() - f) / 2.0f);
        float width = this.borderRect.width();
        float height = this.borderRect.height();
        boolean z = this.isHighlighted;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, width, height, z ? this.highlightBorderColor : this.borderColor, z ? this.highlightBorderColorEnd : this.borderColorEnd, Shader.TileMode.CLAMP);
        Paint paint = this.borderPaint;
        paint.setShader(linearGradient);
        paint.setStrokeWidth(f);
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        this.avatarDrawableRect.set(this.borderRect);
        this.avatarDrawableRect.inset(getAvatarInset(), getAvatarInset());
        float f2 = 2;
        this.middleThickness = ((this.borderRect.width() - (f * f2)) - this.avatarDrawableRect.width()) / f2;
        this.middleRect.set(this.borderRect);
        RectF rectF = this.middleRect;
        float f3 = this.middleThickness;
        rectF.inset((f3 / f2) + f, (f3 / f2) + f);
        this.middleRadius = (float) RangesKt.coerceAtMost(Math.floor(this.middleRect.height() / 2.0d), Math.floor(this.middleRect.width() / 2.0d));
        this.drawableRadius = RangesKt.coerceAtMost(this.avatarDrawableRect.height() / 2.0f, this.avatarDrawableRect.width() / 2.0f);
        Paint paint2 = this.middlePaint;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.middleColor);
        paint2.setStrokeWidth(this.middleThickness);
        Paint paint3 = this.circleBackgroundPaint;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint3.setColor(this.avatarBackgroundColor);
        RectF rectF2 = this.arcBorderRect;
        rectF2.set(this.borderRect);
        float f4 = f / 2.0f;
        rectF2.inset(f4, f4);
        Paint paint4 = this.badgePaint;
        paint4.setStyle(Paint.Style.FILL);
        paint4.setAntiAlias(true);
        paint4.setColor(this.badgeColor);
        Paint paint5 = this.badgeStrokePaint;
        paint5.setStyle(Paint.Style.FILL);
        paint5.setAntiAlias(true);
        paint5.setColor(this.badgeStrokeColor);
        updateShaderMatrix();
        invalidate();
    }

    private final void updateShaderMatrix() {
        float width;
        float height;
        this.shaderMatrix.set(null);
        float f = 0.0f;
        if (this.bitmapWidth * this.avatarDrawableRect.height() > this.avatarDrawableRect.width() * this.bitmapHeight) {
            width = this.avatarDrawableRect.height() / this.bitmapHeight;
            f = (this.avatarDrawableRect.width() - (this.bitmapWidth * width)) / 2.0f;
            height = 0.0f;
        } else {
            width = this.avatarDrawableRect.width() / this.bitmapWidth;
            height = (this.avatarDrawableRect.height() - (this.bitmapHeight * width)) / 2.0f;
        }
        this.shaderMatrix.setScale(width, width);
        this.shaderMatrix.postTranslate(((int) (f + 0.5f)) + this.avatarDrawableRect.left, ((int) (height + 0.5f)) + this.avatarDrawableRect.top);
        BitmapShader bitmapShader = this.bitmapShader;
        Intrinsics.checkNotNull(bitmapShader);
        bitmapShader.setLocalMatrix(this.shaderMatrix);
    }

    private final Bitmap getBitmapFromDrawable(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, Defaults.INSTANCE.getBITMAP_CONFIG());
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Defaults.INSTANCE.getBITMAP_CONFIG());
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void initializeBitmap() {
        this.avatarDrawable = getBitmapFromDrawable(getDrawable());
        setup();
    }

    private final RectF calculateBounds() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return inTouchableArea(event.getX(), event.getY()) && super.onTouchEvent(event);
    }

    private final void animateClick() {
        if (this.shouldBounceOnClick) {
            this.scaleAnimator.start();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        animateClick();
        return super.performClick();
    }

    @Override // android.view.View
    public boolean performLongClick() {
        animateClick();
        return super.performLongClick();
    }

    private final boolean inTouchableArea(float f, float f2) {
        return Math.pow(((double) f) - ((double) this.borderRect.centerX()), 2.0d) + Math.pow(((double) f2) - ((double) this.borderRect.centerY()), 2.0d) <= Math.pow((double) this.borderRadius, 2.0d);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r6) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.schwaab.avvylib.AvatarView.onDraw(android.graphics.Canvas):void");
    }

    private final boolean hasAvatar() {
        Drawable drawable = getDrawable();
        return !((drawable instanceof ColorDrawable) && ((ColorDrawable) drawable).getAlpha() == 0);
    }

    private final void drawBorder(Canvas canvas) {
        if (this.isAnimating || this.isReversedAnimating) {
            float f = 360;
            float rotationInDegrees = (getRotationInDegrees(this.animationDrawingState) + 270.0f) % f;
            drawArches(rotationInDegrees, canvas);
            canvas.drawArc(this.arcBorderRect, rotationInDegrees + getArchesAreaInDegrees(this.animationDrawingState), f - getArchesAreaInDegrees(this.animationDrawingState), false, this.borderPaint);
            return;
        }
        canvas.drawCircle(this.borderRect.centerX(), this.borderRect.centerY(), this.borderRadius, this.borderPaint);
    }

    private final void drawArches(float f, Canvas canvas) {
        int i = this.numberOfArches;
        if (i < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            canvas.drawArc(this.arcBorderRect, f + ((getSpaceBetweenArches() + this.individualArcDegreeLength) * i2 * this.animationDrawingState.getCoercedArchesExpansionProgress()), this.individualArcDegreeLength, false, this.borderPaint);
            if (i2 == i) {
                return;
            }
            i2++;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        setup();
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        setup();
    }

    private final void findInitials() {
        String str = this.text;
        if (str != null) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt.trim((CharSequence) str).toString();
            if (obj != null) {
                String str2 = obj;
                int i = 1;
                if (!StringsKt.isBlank(str2)) {
                    List split$default = StringsKt.split$default((CharSequence) str2, new char[]{' '}, false, 0, 6, (Object) null);
                    this.initials = String.valueOf(StringsKt.first((CharSequence) split$default.get(0)));
                    if (split$default.size() > 1) {
                        i = 2;
                        this.initials += StringsKt.first((CharSequence) CollectionsKt.last((List<? extends Object>) split$default));
                    }
                    this.initialsPaint.getTextBounds(this.initials, 0, i, this.initialsRect);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AvatarView.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0083\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, m107d2 = {"Lxyz/schwaab/avvylib/AvatarView$OutlineProvider;", "Landroid/view/ViewOutlineProvider;", "(Lxyz/schwaab/avvylib/AvatarView;)V", "getOutline", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
    /* loaded from: classes5.dex */
    public final class OutlineProvider extends ViewOutlineProvider {
        public OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            Rect rect = new Rect();
            AvatarView.this.borderRect.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    /* compiled from: AvatarView.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m107d2 = {"Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState;", "", "archesExpansionProgress", "", "rotationProgress", "(FF)V", "coercedArchesExpansionProgress", "getCoercedArchesExpansionProgress", "()F", "coercedRotationProgress", "getCoercedRotationProgress", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
    /* loaded from: classes5.dex */
    public static final class AnimationDrawingState {
        public static final Companion Companion = new Companion(null);
        public static final float MAX_VALUE = 1.0f;
        public static final float MIN_VALUE = 0.0f;
        private final float archesExpansionProgress;
        private final float coercedArchesExpansionProgress;
        private final float coercedRotationProgress;
        private final float rotationProgress;

        private final float component1() {
            return this.archesExpansionProgress;
        }

        private final float component2() {
            return this.rotationProgress;
        }

        public static /* synthetic */ AnimationDrawingState copy$default(AnimationDrawingState animationDrawingState, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = animationDrawingState.archesExpansionProgress;
            }
            if ((i & 2) != 0) {
                f2 = animationDrawingState.rotationProgress;
            }
            return animationDrawingState.copy(f, f2);
        }

        public final AnimationDrawingState copy(float f, float f2) {
            return new AnimationDrawingState(f, f2);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof AnimationDrawingState) {
                    AnimationDrawingState animationDrawingState = (AnimationDrawingState) obj;
                    return Float.compare(this.archesExpansionProgress, animationDrawingState.archesExpansionProgress) == 0 && Float.compare(this.rotationProgress, animationDrawingState.rotationProgress) == 0;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.archesExpansionProgress) * 31) + Float.floatToIntBits(this.rotationProgress);
        }

        public String toString() {
            return "AnimationDrawingState(archesExpansionProgress=" + this.archesExpansionProgress + ", rotationProgress=" + this.rotationProgress + ")";
        }

        public AnimationDrawingState(float f, float f2) {
            this.archesExpansionProgress = f;
            this.rotationProgress = f2;
            this.coercedArchesExpansionProgress = RangesKt.coerceIn(f, 0.0f, 1.0f);
            this.coercedRotationProgress = RangesKt.coerceIn(f2, 0.0f, 1.0f);
        }

        public final float getCoercedArchesExpansionProgress() {
            return this.coercedArchesExpansionProgress;
        }

        public final float getCoercedRotationProgress() {
            return this.coercedRotationProgress;
        }

        /* compiled from: AvatarView.kt */
        @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState$Companion;", "", "()V", "MAX_VALUE", "", "MIN_VALUE", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
        /* loaded from: classes5.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: AvatarView.kt */
    @Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\nR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, m107d2 = {"Lxyz/schwaab/avvylib/AvatarView$AnimatorInterface;", "", "(Lxyz/schwaab/avvylib/AvatarView;)V", "currentAnimationState", "Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState;", "getCurrentAnimationState", "()Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState;", "updateAnimationState", "", "update", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "currentState", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
    /* loaded from: classes5.dex */
    public final class AnimatorInterface {
        public AnimatorInterface() {
        }

        private final AnimationDrawingState getCurrentAnimationState() {
            return AvatarView.this.animationDrawingState;
        }

        public final void updateAnimationState(Function1<? super AnimationDrawingState, AnimationDrawingState> update) {
            Intrinsics.checkNotNullParameter(update, "update");
            AvatarView.this.animationDrawingState = update.invoke(getCurrentAnimationState());
            AvatarView.this.invalidate();
        }
    }
}
