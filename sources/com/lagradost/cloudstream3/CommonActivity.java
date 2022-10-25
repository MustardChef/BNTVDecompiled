package com.lagradost.cloudstream3;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.preference.PreferenceManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.player.PlayerEventType;
import com.lagradost.cloudstream3.utils.Event;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CommonActivity.kt */
@Metadata(m108d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001GB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010.J5\u0010/\u001a\u0004\u0018\u00010 2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u00020 H\u0002¢\u0006\u0002\u00105J\u0010\u00106\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,J\u0010\u00107\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,J\"\u00108\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00109\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u0019J\u0010\u0010:\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,J\u001a\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010\u0004J\"\u0010?\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0001\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u00020 J+\u0010?\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010@\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010A\u001a\u0004\u0018\u00010 ¢\u0006\u0002\u0010BJ\f\u0010C\u001a\u00020'*\u00020,H\u0002J\u000e\u0010D\u001a\u0004\u0018\u00010E*\u0004\u0018\u00010,J\n\u0010F\u001a\u00020'*\u00020=R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\nR6\u0010\u0016\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\u00060\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u00180\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R(\u0010%\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001d¨\u0006H"}, m107d2 = {"Lcom/lagradost/cloudstream3/CommonActivity;", "", "()V", "TAG", "", "canEnterPipMode", "", "getCanEnterPipMode", "()Z", "setCanEnterPipMode", "(Z)V", "canShowPipMode", "getCanShowPipMode", "setCanShowPipMode", "currentToast", "Landroid/widget/Toast;", "getCurrentToast", "()Landroid/widget/Toast;", "setCurrentToast", "(Landroid/widget/Toast;)V", "isInPIPMode", "setInPIPMode", "keyEventListener", "Lkotlin/Function1;", "Lkotlin/Pair;", "Landroid/view/KeyEvent;", "getKeyEventListener", "()Lkotlin/jvm/functions/Function1;", "setKeyEventListener", "(Lkotlin/jvm/functions/Function1;)V", "onColorSelectedEvent", "Lcom/lagradost/cloudstream3/utils/Event;", "", "getOnColorSelectedEvent", "()Lcom/lagradost/cloudstream3/utils/Event;", "onDialogDismissedEvent", "getOnDialogDismissedEvent", "playerEventListener", "Lcom/lagradost/cloudstream3/ui/player/PlayerEventType;", "", "getPlayerEventListener", "setPlayerEventListener", "dispatchKeyEvent", "act", "Landroid/app/Activity;", "event", "(Landroid/app/Activity;Landroid/view/KeyEvent;)Ljava/lang/Boolean;", "getNextFocus", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "direction", "Lcom/lagradost/cloudstream3/CommonActivity$FocusDirection;", "depth", "(Landroid/app/Activity;Landroid/view/View;Lcom/lagradost/cloudstream3/CommonActivity$FocusDirection;I)Ljava/lang/Integer;", "init", "loadThemes", "onKeyDown", "keyCode", "onUserLeaveHint", "setLocale", "context", "Landroid/content/Context;", "languageCode", "showToast", "message", TypedValues.TransitionType.S_DURATION, "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Integer;)V", "enterPIPMode", "getCastSession", "Lcom/google/android/gms/cast/framework/CastSession;", "updateLocale", "FocusDirection", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class CommonActivity {
    public static final String TAG = "COMPACT";
    private static boolean canEnterPipMode;
    private static boolean canShowPipMode;
    private static Toast currentToast;
    private static boolean isInPIPMode;
    private static Function1<? super Tuples<? extends KeyEvent, Boolean>, Boolean> keyEventListener;
    private static Function1<? super PlayerEventType, Unit> playerEventListener;
    public static final CommonActivity INSTANCE = new CommonActivity();
    private static final Event<Tuples<Integer, Integer>> onColorSelectedEvent = new Event<>();
    private static final Event<Integer> onDialogDismissedEvent = new Event<>();

    /* compiled from: CommonActivity.kt */
    @Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/CommonActivity$FocusDirection;", "", "(Ljava/lang/String;I)V", "Left", "Right", "Up", "Down", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public enum FocusDirection {
        Left,
        Right,
        Up,
        Down
    }

    /* compiled from: CommonActivity.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusDirection.values().length];
            iArr[FocusDirection.Left.ordinal()] = 1;
            iArr[FocusDirection.Up.ordinal()] = 2;
            iArr[FocusDirection.Right.ordinal()] = 3;
            iArr[FocusDirection.Down.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CommonActivity() {
    }

    public final CastSession getCastSession(Activity activity) {
        SessionManager mSessionManager;
        MainActivity mainActivity = (MainActivity) activity;
        if (mainActivity == null || (mSessionManager = mainActivity.getMSessionManager()) == null) {
            return null;
        }
        return mSessionManager.getCurrentCastSession();
    }

    public final boolean getCanEnterPipMode() {
        return canEnterPipMode;
    }

    public final void setCanEnterPipMode(boolean z) {
        canEnterPipMode = z;
    }

    public final boolean getCanShowPipMode() {
        return canShowPipMode;
    }

    public final void setCanShowPipMode(boolean z) {
        canShowPipMode = z;
    }

    public final boolean isInPIPMode() {
        return isInPIPMode;
    }

    public final void setInPIPMode(boolean z) {
        isInPIPMode = z;
    }

    public final Event<Tuples<Integer, Integer>> getOnColorSelectedEvent() {
        return onColorSelectedEvent;
    }

    public final Event<Integer> getOnDialogDismissedEvent() {
        return onDialogDismissedEvent;
    }

    public final Function1<PlayerEventType, Unit> getPlayerEventListener() {
        return playerEventListener;
    }

    public final void setPlayerEventListener(Function1<? super PlayerEventType, Unit> function1) {
        playerEventListener = function1;
    }

    public final Function1<Tuples<? extends KeyEvent, Boolean>, Boolean> getKeyEventListener() {
        return keyEventListener;
    }

    public final void setKeyEventListener(Function1<? super Tuples<? extends KeyEvent, Boolean>, Boolean> function1) {
        keyEventListener = function1;
    }

    public final Toast getCurrentToast() {
        return currentToast;
    }

    public final void setCurrentToast(Toast toast) {
        currentToast = toast;
    }

    public final void showToast(Activity activity, int i, int i2) {
        if (activity == null) {
            return;
        }
        showToast(activity, activity.getString(i), Integer.valueOf(i2));
    }

    public static /* synthetic */ void showToast$default(CommonActivity commonActivity, Activity activity, String str, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        commonActivity.showToast(activity, str, num);
    }

    public final void showToast(Activity activity, String str, Integer num) {
        if (activity == null || str == null) {
            Log.w(TAG, "invalid showToast act = " + activity + " message = " + str);
            return;
        }
        Log.i(TAG, "showToast = " + str);
        try {
            Toast toast = currentToast;
            if (toast != null) {
                toast.cancel();
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        try {
            Object systemService = activity.getSystemService("layout_inflater");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
            }
            View inflate = ((LayoutInflater) systemService).inflate(com.bongngotv2.R.layout.toast, (ViewGroup) activity.findViewById(com.bongngotv2.R.id.toast_layout_root));
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      … ViewGroup?\n            )");
            View findViewById = inflate.findViewById(com.bongngotv2.R.id.text);
            if (findViewById == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            ((TextView) findViewById).setText(StringsKt.trim((CharSequence) str).toString());
            Toast toast2 = new Toast(activity);
            toast2.setGravity(81, 0, UIHelper.INSTANCE.getToPx(5));
            toast2.setDuration(num != null ? num.intValue() : 0);
            toast2.setView(inflate);
            toast2.show();
            currentToast = toast2;
        } catch (Exception e2) {
            ArchComponentExt.logError(e2);
        }
    }

    public final void setLocale(Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        Locale locale = new Locale(str);
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        Configuration configuration = resources.getConfiguration();
        Locale.setDefault(locale);
        configuration.setLocale(locale);
        if (Build.VERSION.SDK_INT >= 24) {
            context.createConfigurationContext(configuration);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public final void updateLocale(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        setLocale(context, PreferenceManager.getDefaultSharedPreferences(context).getString(context.getString(com.bongngotv2.R.string.locale_key), null));
    }

    public final void init(Activity activity) {
        if (activity == null) {
            return;
        }
        canShowPipMode = Build.VERSION.SDK_INT >= 24 && activity.getPackageManager().hasSystemFeature("android.software.picture_in_picture") && UIHelper.INSTANCE.hasPIPPermission(activity);
        updateLocale(activity);
    }

    private final void enterPIPMode(Activity activity) {
        if (UIHelper.INSTANCE.shouldShowPIPMode(activity, canEnterPipMode) && canShowPipMode) {
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    try {
                        activity.enterPictureInPictureMode(new PictureInPictureParams.Builder().build());
                    } catch (Exception unused) {
                        activity.enterPictureInPictureMode();
                    }
                } else if (Build.VERSION.SDK_INT >= 24) {
                    activity.enterPictureInPictureMode();
                }
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        }
    }

    public final void onUserLeaveHint(Activity activity) {
        if (canEnterPipMode && canShowPipMode && activity != null) {
            enterPIPMode(activity);
        }
    }

    public final void loadThemes(Activity activity) {
        if (activity == null) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String string = defaultSharedPreferences.getString(activity.getString(com.bongngotv2.R.string.app_theme_key), "AmoledLight");
        int i = com.bongngotv2.R.style.AppTheme;
        if (string != null) {
            switch (string.hashCode()) {
                case 64266207:
                    string.equals("Black");
                    break;
                case 73417974:
                    if (string.equals("Light")) {
                        i = com.bongngotv2.R.style.LightMode;
                        break;
                    }
                    break;
                case 1964972424:
                    if (string.equals("Amoled")) {
                        i = com.bongngotv2.R.style.AmoledMode;
                        break;
                    }
                    break;
                case 2078007406:
                    if (string.equals("AmoledLight")) {
                        i = com.bongngotv2.R.style.AmoledModeLight;
                        break;
                    }
                    break;
            }
        }
        String string2 = defaultSharedPreferences.getString(activity.getString(com.bongngotv2.R.string.primary_color_key), "Normal");
        int i2 = com.bongngotv2.R.style.OverlayPrimaryColorNormal;
        if (string2 != null) {
            switch (string2.hashCode()) {
                case -2114143920:
                    if (string2.equals("NavyBlue")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorNavyBlue;
                        break;
                    }
                    break;
                case -1997434736:
                    if (string2.equals("Maroon")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorMaroon;
                        break;
                    }
                    break;
                case -1955878649:
                    string2.equals("Normal");
                    break;
                case -1893076004:
                    if (string2.equals("Purple")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorPurple;
                        break;
                    }
                    break;
                case 82033:
                    if (string2.equals("Red")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorRed;
                        break;
                    }
                    break;
                case 2227967:
                    if (string2.equals("Grey")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorGrey;
                        break;
                    }
                    break;
                case 2487702:
                    if (string2.equals("Pink")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorPink;
                        break;
                    }
                    break;
                case 64459030:
                    if (string2.equals("Brown")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorBrown;
                        break;
                    }
                    break;
                case 69066467:
                    if (string2.equals("Green")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorGreen;
                        break;
                    }
                    break;
                case 76884678:
                    if (string2.equals("Party")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorParty;
                        break;
                    }
                    break;
                case 83549193:
                    if (string2.equals("White")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorWhite;
                        break;
                    }
                    break;
                case 129648909:
                    if (string2.equals("DarkGreen")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorDarkGreen;
                        break;
                    }
                    break;
                case 1375944721:
                    if (string2.equals("CarnationPink")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorCarnationPink;
                        break;
                    }
                    break;
                case 1627490871:
                    if (string2.equals("GreenApple")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorGreenApple;
                        break;
                    }
                    break;
                case 1982479237:
                    if (string2.equals("Banana")) {
                        i2 = com.bongngotv2.R.style.OverlayPrimaryColorBanana;
                        break;
                    }
                    break;
            }
        }
        activity.getTheme().applyStyle(i, true);
        activity.getTheme().applyStyle(i2, true);
        activity.getTheme().applyStyle(com.bongngotv2.R.style.LoadedStyle, true);
    }

    static /* synthetic */ Integer getNextFocus$default(CommonActivity commonActivity, Activity activity, View view, FocusDirection focusDirection, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return commonActivity.getNextFocus(activity, view, focusDirection, i);
    }

    private final Integer getNextFocus(Activity activity, View view, FocusDirection focusDirection, int i) {
        int nextFocusLeftId;
        if (view == null || i >= 10 || activity == null) {
            return null;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[focusDirection.ordinal()];
        if (i2 == 1) {
            nextFocusLeftId = view.getNextFocusLeftId();
        } else if (i2 == 2) {
            nextFocusLeftId = view.getNextFocusUpId();
        } else if (i2 == 3) {
            nextFocusLeftId = view.getNextFocusRightId();
        } else if (i2 != 4) {
            throw new NoWhenBranchMatchedException();
        } else {
            nextFocusLeftId = view.getNextFocusDownId();
        }
        if (nextFocusLeftId != -1) {
            View findViewById = activity.findViewById(nextFocusLeftId);
            boolean z = false;
            if (findViewById != null && !findViewById.isShown()) {
                z = true;
            }
            if (z) {
                return getNextFocus(activity, findViewById, focusDirection, i + 1);
            }
            if (i == 0) {
                return null;
            }
            return Integer.valueOf(nextFocusLeftId);
        }
        return null;
    }

    public final void onKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        PlayerEventType playerEventType;
        Function1<? super PlayerEventType, Unit> function1;
        switch (i) {
            case 29:
            case 89:
            case bqk.f6533at /* 273 */:
                playerEventType = PlayerEventType.SeekBack;
                break;
            case 32:
            case 90:
            case 125:
            case bqk.f6532as /* 272 */:
                playerEventType = PlayerEventType.SeekForward;
                break;
            case 33:
            case 147:
                playerEventType = PlayerEventType.ShowSpeed;
                break;
            case 36:
            case 82:
                playerEventType = PlayerEventType.ToggleHide;
                break;
            case 40:
            case 151:
                playerEventType = PlayerEventType.Lock;
                break;
            case 41:
            case 164:
                playerEventType = PlayerEventType.ToggleMute;
                break;
            case 43:
            case 152:
                playerEventType = PlayerEventType.SearchSubtitlesOnline;
                break;
            case 44:
            case 62:
            case 66:
            case 85:
            case 160:
                playerEventType = PlayerEventType.PlayPauseToggle;
                break;
            case 46:
            case 144:
                playerEventType = PlayerEventType.Resize;
                break;
            case 47:
            case 153:
                playerEventType = PlayerEventType.ShowMirrors;
                break;
            case 87:
            case 103:
                playerEventType = PlayerEventType.NextEpisode;
                break;
            case 88:
            case 102:
                playerEventType = PlayerEventType.PrevEpisode;
                break;
            case 108:
            case 126:
                playerEventType = PlayerEventType.Play;
                break;
            case 127:
                playerEventType = PlayerEventType.Pause;
                break;
            default:
                playerEventType = null;
                break;
        }
        if (playerEventType == null || (function1 = playerEventListener) == null) {
            return;
        }
        function1.invoke(playerEventType);
    }

    public final Boolean dispatchKeyEvent(Activity activity, KeyEvent keyEvent) {
        Integer nextFocus$default;
        View findViewById;
        if (activity == null) {
            return null;
        }
        if (keyEvent != null) {
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() == 0 && activity.getCurrentFocus() != null) {
                switch (keyCode) {
                    case 19:
                        nextFocus$default = getNextFocus$default(INSTANCE, activity, activity.getCurrentFocus(), FocusDirection.Up, 0, 8, null);
                        break;
                    case 20:
                        nextFocus$default = getNextFocus$default(INSTANCE, activity, activity.getCurrentFocus(), FocusDirection.Down, 0, 8, null);
                        break;
                    case 21:
                        nextFocus$default = getNextFocus$default(INSTANCE, activity, activity.getCurrentFocus(), FocusDirection.Left, 0, 8, null);
                        break;
                    case 22:
                        nextFocus$default = getNextFocus$default(INSTANCE, activity, activity.getCurrentFocus(), FocusDirection.Right, 0, 8, null);
                        break;
                    default:
                        nextFocus$default = null;
                        break;
                }
                if (nextFocus$default != null && nextFocus$default.intValue() != -1 && (findViewById = activity.findViewById(nextFocus$default.intValue())) != null) {
                    findViewById.requestFocus();
                    Function1<? super Tuples<? extends KeyEvent, Boolean>, Boolean> function1 = keyEventListener;
                    if (function1 != null) {
                        function1.invoke(new Tuples(keyEvent, true));
                    }
                    return true;
                } else if (keyCode == 23 && ((activity.getCurrentFocus() instanceof SearchView) || (activity.getCurrentFocus() instanceof SearchView.SearchAutoComplete))) {
                    UIHelper uIHelper = UIHelper.INSTANCE;
                    View currentFocus = activity.getCurrentFocus();
                    uIHelper.showInputMethod(currentFocus != null ? currentFocus.findFocus() : null);
                }
            }
        }
        Function1<? super Tuples<? extends KeyEvent, Boolean>, Boolean> function12 = keyEventListener;
        boolean z = false;
        if (function12 != null && function12.invoke(new Tuples(keyEvent, false)).booleanValue()) {
            z = true;
        }
        return z ? true : null;
    }
}
