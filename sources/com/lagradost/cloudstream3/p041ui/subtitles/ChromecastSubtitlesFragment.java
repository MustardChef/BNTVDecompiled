package com.lagradost.cloudstream3.p041ui.subtitles;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.p036ui.SubtitleView;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.Event;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChromecastSubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J#\u0010\u001a\u001a\u00020\u000b*\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\u00020\u000b*\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/subtitles/ChromecastSubtitlesFragment;", "Landroidx/fragment/app/Fragment;", "()V", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/lagradost/cloudstream3/ui/subtitles/SaveChromeCaptionStyle;", "getColor", "", "id", "onColorSelected", "", "stuff", "Lkotlin/Pair;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismissed", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setColor", "Landroid/content/Context;", "color", "(Landroid/content/Context;ILjava/lang/Integer;)V", "updateState", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.ChromecastSubtitlesFragment */
/* loaded from: classes4.dex */
public final class ChromecastSubtitlesFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private static final Event<SaveChromeCaptionStyle> applyStyleEvent = new Event<>();
    private static final SaveChromeCaptionStyle defaultState = new SaveChromeCaptionStyle(null, null, 0, 0, 0, 0, 0.0f, 0, 255, null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean hide = true;
    private SaveChromeCaptionStyle state;

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(Context context) {
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* compiled from: ChromecastSubtitlesFragment.kt */
    @Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u00020\u0012*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/subtitles/ChromecastSubtitlesFragment$Companion;", "", "()V", "applyStyleEvent", "Lcom/lagradost/cloudstream3/utils/Event;", "Lcom/lagradost/cloudstream3/ui/subtitles/SaveChromeCaptionStyle;", "getApplyStyleEvent", "()Lcom/lagradost/cloudstream3/utils/Event;", "defaultState", "getCurrentSavedStyle", "getDefColor", "", "id", "getPixels", "unit", "size", "", "push", "", "activity", "Landroid/app/Activity;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "saveStyle", "Landroid/content/Context;", "style", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.subtitles.ChromecastSubtitlesFragment$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getDefColor(int i) {
            if (i != 0) {
                return i != 1 ? i != 2 ? 0 : 0 : ViewCompat.MEASURED_STATE_MASK;
            }
            return -1;
        }

        private Companion() {
        }

        public final Event<SaveChromeCaptionStyle> getApplyStyleEvent() {
            return ChromecastSubtitlesFragment.applyStyleEvent;
        }

        public static /* synthetic */ void push$default(Companion companion, Activity activity, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = true;
            }
            companion.push(activity, z);
        }

        public final void push(Activity activity, boolean z) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE, z);
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_chrome_subtitles, bundle);
        }

        public final void saveStyle(Context context, SaveChromeCaptionStyle style) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter(style, "style");
            DataStore.INSTANCE.setKey(context, ChromecastSubtitlesFragmentKt.CHROME_SUBTITLE_KEY, style);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getPixels(int i, float f) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "getSystem().displayMetrics");
            return (int) TypedValue.applyDimension(i, f, displayMetrics);
        }

        public final SaveChromeCaptionStyle getCurrentSavedStyle() {
            Context context = AcraApplication.Companion.getContext();
            Object obj = null;
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(ChromecastSubtitlesFragmentKt.CHROME_SUBTITLE_KEY, null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, SaveChromeCaptionStyle.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj = readValue;
                    }
                } catch (Exception unused) {
                }
            }
            SaveChromeCaptionStyle saveChromeCaptionStyle = (SaveChromeCaptionStyle) obj;
            return saveChromeCaptionStyle == null ? ChromecastSubtitlesFragment.defaultState : saveChromeCaptionStyle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onColorSelected(Tuples<Integer, Integer> tuples) {
        FragmentActivity activity;
        Context context = getContext();
        if (context != null) {
            setColor(context, tuples.getFirst().intValue(), tuples.getSecond());
        }
        if (!this.hide || (activity = getActivity()) == null) {
            return;
        }
        UIHelper.INSTANCE.hideSystemUI(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDialogDismissed(int i) {
        FragmentActivity activity;
        if (!this.hide || (activity = getActivity()) == null) {
            return;
        }
        UIHelper.INSTANCE.hideSystemUI(activity);
    }

    private final int getColor(int i) {
        int foregroundColor;
        SaveChromeCaptionStyle saveChromeCaptionStyle = null;
        if (i == 0) {
            SaveChromeCaptionStyle saveChromeCaptionStyle2 = this.state;
            if (saveChromeCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle2;
            }
            foregroundColor = saveChromeCaptionStyle.getForegroundColor();
        } else if (i == 1) {
            SaveChromeCaptionStyle saveChromeCaptionStyle3 = this.state;
            if (saveChromeCaptionStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle3;
            }
            foregroundColor = saveChromeCaptionStyle.getEdgeColor();
        } else if (i == 2) {
            SaveChromeCaptionStyle saveChromeCaptionStyle4 = this.state;
            if (saveChromeCaptionStyle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle4;
            }
            foregroundColor = saveChromeCaptionStyle.getBackgroundColor();
        } else if (i != 3) {
            foregroundColor = 0;
        } else {
            SaveChromeCaptionStyle saveChromeCaptionStyle5 = this.state;
            if (saveChromeCaptionStyle5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle5;
            }
            foregroundColor = saveChromeCaptionStyle.getWindowColor();
        }
        return foregroundColor == 0 ? ViewCompat.MEASURED_STATE_MASK : foregroundColor;
    }

    private final void setColor(Context context, int i, Integer num) {
        int defColor;
        if (num == null) {
            defColor = Companion.getDefColor(i);
        } else {
            defColor = num.intValue();
        }
        SaveChromeCaptionStyle saveChromeCaptionStyle = null;
        if (i == 0) {
            SaveChromeCaptionStyle saveChromeCaptionStyle2 = this.state;
            if (saveChromeCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle2;
            }
            saveChromeCaptionStyle.setForegroundColor(defColor);
        } else if (i == 1) {
            SaveChromeCaptionStyle saveChromeCaptionStyle3 = this.state;
            if (saveChromeCaptionStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle3;
            }
            saveChromeCaptionStyle.setEdgeColor(defColor);
        } else if (i == 2) {
            SaveChromeCaptionStyle saveChromeCaptionStyle4 = this.state;
            if (saveChromeCaptionStyle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle4;
            }
            saveChromeCaptionStyle.setBackgroundColor(defColor);
        } else if (i == 3) {
            SaveChromeCaptionStyle saveChromeCaptionStyle5 = this.state;
            if (saveChromeCaptionStyle5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle5;
            }
            saveChromeCaptionStyle.setWindowColor(defColor);
        }
        updateState(context);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.chromecast_subtitle_settings, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CommonActivity.INSTANCE.getOnColorSelectedEvent().minusAssign(new ChromecastSubtitlesFragment$onDestroy$1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.hide = arguments != null ? arguments.getBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE) : true;
        CommonActivity.INSTANCE.getOnColorSelectedEvent().plusAssign(new ChromecastSubtitlesFragment$onViewCreated$1(this));
        CommonActivity.INSTANCE.getOnDialogDismissedEvent().plusAssign(new ChromecastSubtitlesFragment$onViewCreated$2(this));
        Context context = getContext();
        if (context != null) {
            UIHelper.INSTANCE.fixPaddingStatusbar(context, (ScrollView) _$_findCachedViewById(C4761R.C4764id.subs_root));
        }
        Companion companion = Companion;
        this.state = companion.getCurrentSavedStyle();
        Context context2 = getContext();
        if (context2 != null) {
            updateState(context2);
        }
        Context context3 = getContext();
        boolean z = context3 != null && SettingsFragment.Companion.isTvSettings(context3);
        TextView subs_text_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_text_color);
        Intrinsics.checkNotNullExpressionValue(subs_text_color, "subs_text_color");
        onViewCreated$setup(subs_text_color, z, this, 0);
        TextView subs_outline_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_outline_color);
        Intrinsics.checkNotNullExpressionValue(subs_outline_color, "subs_outline_color");
        onViewCreated$setup(subs_outline_color, z, this, 1);
        TextView subs_background_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_background_color);
        Intrinsics.checkNotNullExpressionValue(subs_background_color, "subs_background_color");
        onViewCreated$setup(subs_background_color, z, this, 2);
        final ChromecastSubtitlesFragment$onViewCreated$dismissCallback$1 chromecastSubtitlesFragment$onViewCreated$dismissCallback$1 = new ChromecastSubtitlesFragment$onViewCreated$dismissCallback$1(this);
        TextView subs_edge_type = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_edge_type);
        Intrinsics.checkNotNullExpressionValue(subs_edge_type, "subs_edge_type");
        subs_edge_type.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_edge_type)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$Pn-xqUQwET3SwyzRzqdqaxi-1Vw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChromecastSubtitlesFragment.m8963onViewCreated$lambda5(ChromecastSubtitlesFragment.this, chromecastSubtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_edge_type)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$DgQXryQUNZpzZMlw1_caVGHEXsU
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8964onViewCreated$lambda6;
                m8964onViewCreated$lambda6 = ChromecastSubtitlesFragment.m8964onViewCreated$lambda6(ChromecastSubtitlesFragment.this, view2);
                return m8964onViewCreated$lambda6;
            }
        });
        TextView subs_font_size = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_font_size);
        Intrinsics.checkNotNullExpressionValue(subs_font_size, "subs_font_size");
        subs_font_size.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font_size)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$PqmEZYupLjFwWOUxSH3dh9lDroM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChromecastSubtitlesFragment.m8965onViewCreated$lambda9(ChromecastSubtitlesFragment.this, chromecastSubtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font_size)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$B7qZyEINCoi8pBIP27sRHbAZjjA
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8958onViewCreated$lambda10;
                m8958onViewCreated$lambda10 = ChromecastSubtitlesFragment.m8958onViewCreated$lambda10(ChromecastSubtitlesFragment.this, view2);
                return m8958onViewCreated$lambda10;
            }
        });
        TextView subs_font = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_font);
        Intrinsics.checkNotNullExpressionValue(subs_font, "subs_font");
        subs_font.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$G16oD7Q5yL1ehV6sz0cr_pvt-Ww
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChromecastSubtitlesFragment.m8959onViewCreated$lambda13(ChromecastSubtitlesFragment.this, chromecastSubtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$Ym1cbYRwn5t_sM8_dMO_zZMUJEs
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8960onViewCreated$lambda14;
                m8960onViewCreated$lambda14 = ChromecastSubtitlesFragment.m8960onViewCreated$lambda14(ChromecastSubtitlesFragment.this, view2);
                return m8960onViewCreated$lambda14;
            }
        });
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.cancel_btt)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$a92eWdHHs-1fEWR0bh8EvyJp4KA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChromecastSubtitlesFragment.m8961onViewCreated$lambda15(ChromecastSubtitlesFragment.this, view2);
            }
        });
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.apply_btt)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$nAjj28LRVO4QeY-AR4KEgcAvNr4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChromecastSubtitlesFragment.m8962onViewCreated$lambda16(ChromecastSubtitlesFragment.this, view2);
            }
        });
        ((SubtitleView) _$_findCachedViewById(C4761R.C4764id.subtitle_text)).setCues(CollectionsKt.listOf(new Cue.Builder().setTextSize(companion.getPixels(2, 25.0f), 2).setText(((SubtitleView) _$_findCachedViewById(C4761R.C4764id.subtitle_text)).getContext().getString(R.string.subtitles_example_text)).build()));
    }

    private static final void onViewCreated$setup(View view, boolean z, final ChromecastSubtitlesFragment chromecastSubtitlesFragment, final int i) {
        view.setFocusableInTouchMode(z);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$wAKXdNf0Aa3LcQNE6WAiDodMt1s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ChromecastSubtitlesFragment.m8966onViewCreated$setup$lambda1(ChromecastSubtitlesFragment.this, i, view2);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$ChromecastSubtitlesFragment$MFBl9GwAaPssMU7Hp1OBw32KFPs
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8967onViewCreated$setup$lambda2;
                m8967onViewCreated$setup$lambda2 = ChromecastSubtitlesFragment.m8967onViewCreated$setup$lambda2(ChromecastSubtitlesFragment.this, i, view2);
                return m8967onViewCreated$setup$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$setup$lambda-1  reason: not valid java name */
    public static final void m8966onViewCreated$setup$lambda1(ChromecastSubtitlesFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            ColorPickerDialog.newBuilder().setDialogId(i).setShowAlphaSlider(true).setColor(this$0.getColor(i)).show(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$setup$lambda-2  reason: not valid java name */
    public static final boolean m8967onViewCreated$setup$lambda2(ChromecastSubtitlesFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.setColor(context, i, null);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m8963onViewCreated$lambda5(ChromecastSubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(0, view.getContext().getString(R.string.subtitles_none)), new Tuples(1, view.getContext().getString(R.string.subtitles_outline)), new Tuples(4, view.getContext().getString(R.string.subtitles_depressed)), new Tuples(2, view.getContext().getString(R.string.subtitles_shadow)), new Tuples(3, view.getContext().getString(R.string.subtitles_raised))});
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<Tuples> list = listOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Tuples tuples : list) {
                Object second = tuples.getSecond();
                Intrinsics.checkNotNullExpressionValue(second, "it.second");
                arrayList.add((String) second);
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Tuples tuples2 : list) {
                arrayList3.add(Integer.valueOf(((Number) tuples2.getFirst()).intValue()));
            }
            ArrayList arrayList4 = arrayList3;
            SaveChromeCaptionStyle saveChromeCaptionStyle = this$0.state;
            if (saveChromeCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveChromeCaptionStyle = null;
            }
            int indexOf = arrayList4.indexOf(Integer.valueOf(saveChromeCaptionStyle.getEdgeType()));
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList2, indexOf, ((TextView) view).getText().toString(), false, dismissCallback, new ChromecastSubtitlesFragment$onViewCreated$3$3(this$0, listOf, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final boolean m8964onViewCreated$lambda6(ChromecastSubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveChromeCaptionStyle saveChromeCaptionStyle = this$0.state;
        if (saveChromeCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveChromeCaptionStyle = null;
        }
        saveChromeCaptionStyle.setEdgeType(defaultState.getEdgeType());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.updateState(context);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    public static final void m8965onViewCreated$lambda9(ChromecastSubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(Float.valueOf(0.75f), "75%"), new Tuples(Float.valueOf(0.8f), "80%"), new Tuples(Float.valueOf(0.85f), "85%"), new Tuples(Float.valueOf(0.9f), "90%"), new Tuples(Float.valueOf(0.95f), "95%"), new Tuples(Float.valueOf(1.0f), "100%"), new Tuples(Float.valueOf(1.05f), view.getContext().getString(R.string.normal)), new Tuples(Float.valueOf(1.1f), "110%"), new Tuples(Float.valueOf(1.15f), "115%"), new Tuples(Float.valueOf(1.2f), "120%"), new Tuples(Float.valueOf(1.25f), "125%"), new Tuples(Float.valueOf(1.3f), "130%"), new Tuples(Float.valueOf(1.35f), "135%"), new Tuples(Float.valueOf(1.4f), "140%"), new Tuples(Float.valueOf(1.45f), "145%"), new Tuples(Float.valueOf(1.5f), "150%")});
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<Tuples> list = listOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Tuples tuples : list) {
                arrayList.add((String) tuples.getSecond());
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Tuples tuples2 : list) {
                arrayList3.add(Float.valueOf(((Number) tuples2.getFirst()).floatValue()));
            }
            ArrayList arrayList4 = arrayList3;
            SaveChromeCaptionStyle saveChromeCaptionStyle = this$0.state;
            if (saveChromeCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveChromeCaptionStyle = null;
            }
            int indexOf = arrayList4.indexOf(Float.valueOf(saveChromeCaptionStyle.getFontScale()));
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList2, indexOf, ((TextView) view).getText().toString(), false, dismissCallback, new ChromecastSubtitlesFragment$onViewCreated$5$3(this$0, listOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10  reason: not valid java name */
    public static final boolean m8958onViewCreated$lambda10(ChromecastSubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveChromeCaptionStyle saveChromeCaptionStyle = this$0.state;
        if (saveChromeCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveChromeCaptionStyle = null;
        }
        saveChromeCaptionStyle.setFontScale(defaultState.getFontScale());
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-13  reason: not valid java name */
    public static final void m8959onViewCreated$lambda13(ChromecastSubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        SaveChromeCaptionStyle saveChromeCaptionStyle = null;
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(null, view.getContext().getString(R.string.normal)), new Tuples("Droid Sans", "Droid Sans"), new Tuples("Droid Sans Mono", "Droid Sans Mono"), new Tuples("Droid Serif Regular", "Droid Serif Regular"), new Tuples("Cutive Mono", "Cutive Mono"), new Tuples("Short Stack", "Short Stack"), new Tuples("Quintessential", "Quintessential"), new Tuples("Alegreya Sans SC", "Alegreya Sans SC")});
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            List<Tuples> list = listOf;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Tuples tuples : list) {
                Object second = tuples.getSecond();
                Intrinsics.checkNotNullExpressionValue(second, "it.second");
                arrayList.add((String) second);
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Tuples tuples2 : list) {
                arrayList3.add((String) tuples2.getFirst());
            }
            ArrayList arrayList4 = arrayList3;
            SaveChromeCaptionStyle saveChromeCaptionStyle2 = this$0.state;
            if (saveChromeCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveChromeCaptionStyle = saveChromeCaptionStyle2;
            }
            int indexOf = arrayList4.indexOf(saveChromeCaptionStyle.getFontFamily());
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList2, indexOf, ((TextView) view).getText().toString(), false, dismissCallback, new ChromecastSubtitlesFragment$onViewCreated$7$3(this$0, listOf, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14  reason: not valid java name */
    public static final boolean m8960onViewCreated$lambda14(ChromecastSubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveChromeCaptionStyle saveChromeCaptionStyle = this$0.state;
        if (saveChromeCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveChromeCaptionStyle = null;
        }
        saveChromeCaptionStyle.setFontFamily(defaultState.getFontFamily());
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        this$0.updateState(context);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15  reason: not valid java name */
    public static final void m8961onViewCreated$lambda15(ChromecastSubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-16  reason: not valid java name */
    public static final void m8962onViewCreated$lambda16(ChromecastSubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion companion = Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        SaveChromeCaptionStyle saveChromeCaptionStyle = this$0.state;
        SaveChromeCaptionStyle saveChromeCaptionStyle2 = null;
        if (saveChromeCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveChromeCaptionStyle = null;
        }
        companion.saveStyle(context, saveChromeCaptionStyle);
        Event<SaveChromeCaptionStyle> event = applyStyleEvent;
        SaveChromeCaptionStyle saveChromeCaptionStyle3 = this$0.state;
        if (saveChromeCaptionStyle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
        } else {
            saveChromeCaptionStyle2 = saveChromeCaptionStyle3;
        }
        event.invoke(saveChromeCaptionStyle2);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }
}
