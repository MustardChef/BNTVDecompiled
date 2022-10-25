package com.lagradost.cloudstream3.p041ui.subtitles;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.room.RoomMasterTable;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.exoplayer2.p036ui.CaptionStyleCompat;
import com.google.android.exoplayer2.p036ui.SubtitleView;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.Event;
import com.lagradost.cloudstream3.utils.SingleSelectionHelper;
import com.lagradost.cloudstream3.utils.SubtitleHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
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
import kotlin.text.StringsKt;

/* compiled from: SubtitlesFragment.kt */
@Metadata(m108d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\rH\u0002J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J#\u0010\u001a\u001a\u00020\u000b*\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\u00020\u000b*\u00020\u001bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/subtitles/SubtitlesFragment;", "Landroidx/fragment/app/Fragment;", "()V", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", ServerProtocol.DIALOG_PARAM_STATE, "Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "getColor", "", "id", "onColorSelected", "", "stuff", "Lkotlin/Pair;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismissed", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setColor", "Landroid/content/Context;", "color", "(Landroid/content/Context;ILjava/lang/Integer;)V", "updateState", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment */
/* loaded from: classes4.dex */
public final class SubtitlesFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private static final Event<SaveCaptionStyle> applyStyleEvent = new Event<>();
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean hide = true;
    private SaveCaptionStyle state;

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

    /* compiled from: SubtitlesFragment.kt */
    @Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fJ\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0005J\f\u0010\u001e\u001a\u00020\u001b*\u00020\u001cH\u0002J\u0012\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000f*\u00020\u001cH\u0002J\u0012\u0010!\u001a\u00020\u0015*\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006#"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/subtitles/SubtitlesFragment$Companion;", "", "()V", "applyStyleEvent", "Lcom/lagradost/cloudstream3/utils/Event;", "Lcom/lagradost/cloudstream3/ui/subtitles/SaveCaptionStyle;", "getApplyStyleEvent", "()Lcom/lagradost/cloudstream3/utils/Event;", "getAutoSelectLanguageISO639_1", "", "getCurrentSavedStyle", "getDefColor", "", "id", "getDownloadSubsLanguageISO639_1", "", "getPixels", "unit", "size", "", "push", "", "activity", "Landroid/app/Activity;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "fromSaveToStyle", "Lcom/google/android/exoplayer2/ui/CaptionStyleCompat;", "Landroid/content/Context;", "data", "getCurrentStyle", "getSavedFonts", "Ljava/io/File;", "saveStyle", "style", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment$Companion */
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

        public final Event<SaveCaptionStyle> getApplyStyleEvent() {
            return SubtitlesFragment.applyStyleEvent;
        }

        public final CaptionStyleCompat fromSaveToStyle(Context context, SaveCaptionStyle data) {
            Typeface typeface;
            Typeface typeface2;
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter(data, "data");
            int foregroundColor = data.getForegroundColor();
            int backgroundColor = data.getBackgroundColor();
            int windowColor = data.getWindowColor();
            int edgeType = data.getEdgeType();
            int edgeColor = data.getEdgeColor();
            String typefaceFilePath = data.getTypefaceFilePath();
            if (typefaceFilePath != null) {
                try {
                    typeface = Typeface.createFromFile(new File(typefaceFilePath));
                } catch (Exception unused) {
                    typeface = null;
                }
                if (typeface != null) {
                    typeface2 = typeface;
                    return new CaptionStyleCompat(foregroundColor, backgroundColor, windowColor, edgeType, edgeColor, typeface2);
                }
            }
            Integer typeface3 = data.getTypeface();
            Typeface font = typeface3 != null ? ResourcesCompat.getFont(context, typeface3.intValue()) : null;
            typeface2 = font == null ? Typeface.SANS_SERIF : font;
            return new CaptionStyleCompat(foregroundColor, backgroundColor, windowColor, edgeType, edgeColor, typeface2);
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
            uIHelper.navigate(activity, R.id.global_to_navigation_subtitles, bundle);
        }

        public final void saveStyle(Context context, SaveCaptionStyle style) {
            Intrinsics.checkNotNullParameter(context, "<this>");
            Intrinsics.checkNotNullParameter(style, "style");
            DataStore.INSTANCE.setKey(context, SubtitlesFragmentKt.SUBTITLE_KEY, style);
        }

        public final SaveCaptionStyle getCurrentSavedStyle() {
            Context context = AcraApplication.Companion.getContext();
            Object obj = null;
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(SubtitlesFragmentKt.SUBTITLE_KEY, null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, SaveCaptionStyle.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj = readValue;
                    }
                } catch (Exception unused) {
                }
            }
            SaveCaptionStyle saveCaptionStyle = (SaveCaptionStyle) obj;
            return saveCaptionStyle == null ? new SaveCaptionStyle(getDefColor(0), getDefColor(2), getDefColor(3), 1, getDefColor(1), null, null, 20, null, false, false, 1536, null) : saveCaptionStyle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<File> getSavedFonts(Context context) {
            File externalFilesDir;
            if (context.getExternalFilesDir(null) == null) {
                return CollectionsKt.emptyList();
            }
            File file = new File(externalFilesDir.getAbsolutePath() + "/Fonts");
            file.mkdir();
            String[] list = file.list();
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                File file2 = StringsKt.endsWith$default(it, ".ttf", false, 2, (Object) null) ? new File(file.getAbsolutePath() + JsonPointer.SEPARATOR + it) : null;
                if (file2 != null) {
                    arrayList.add(file2);
                }
            }
            return arrayList;
        }

        private final CaptionStyleCompat getCurrentStyle(Context context) {
            return fromSaveToStyle(context, getCurrentSavedStyle());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getPixels(int i, float f) {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "getSystem().displayMetrics");
            return (int) TypedValue.applyDimension(i, f, displayMetrics);
        }

        public final List<String> getDownloadSubsLanguageISO639_1() {
            Context context = AcraApplication.Companion.getContext();
            Object obj = null;
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(SubtitlesFragmentKt.SUBTITLE_DOWNLOAD_KEY, null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, List.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj = readValue;
                    }
                } catch (Exception unused) {
                }
            }
            List<String> list = (List) obj;
            return list == null ? CollectionsKt.listOf("vi") : list;
        }

        public final String getAutoSelectLanguageISO639_1() {
            Context context = AcraApplication.Companion.getContext();
            Object obj = null;
            if (context != null) {
                DataStore dataStore = DataStore.INSTANCE;
                try {
                    String string = dataStore.getSharedPrefs(context).getString(SubtitlesFragmentKt.SUBTITLE_AUTO_SELECT_KEY, null);
                    if (string != null) {
                        Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                        Object readValue = dataStore.getMapper().readValue(string, String.class);
                        Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                        obj = readValue;
                    }
                } catch (Exception unused) {
                }
            }
            String str = (String) obj;
            return str == null ? "vi" : str;
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

    private final void setColor(Context context, int i, Integer num) {
        int defColor;
        if (num == null) {
            defColor = Companion.getDefColor(i);
        } else {
            defColor = num.intValue();
        }
        SaveCaptionStyle saveCaptionStyle = null;
        if (i == 0) {
            SaveCaptionStyle saveCaptionStyle2 = this.state;
            if (saveCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle2;
            }
            saveCaptionStyle.setForegroundColor(defColor);
        } else if (i == 1) {
            SaveCaptionStyle saveCaptionStyle3 = this.state;
            if (saveCaptionStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle3;
            }
            saveCaptionStyle.setEdgeColor(defColor);
        } else if (i == 2) {
            SaveCaptionStyle saveCaptionStyle4 = this.state;
            if (saveCaptionStyle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle4;
            }
            saveCaptionStyle.setBackgroundColor(defColor);
        } else if (i == 3) {
            SaveCaptionStyle saveCaptionStyle5 = this.state;
            if (saveCaptionStyle5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle5;
            }
            saveCaptionStyle.setWindowColor(defColor);
        }
        updateState(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateState(Context context) {
        SubtitleView subtitleView = (SubtitleView) _$_findCachedViewById(C4761R.C4764id.subtitle_text);
        if (subtitleView != null) {
            Companion companion = Companion;
            SaveCaptionStyle saveCaptionStyle = this.state;
            if (saveCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle = null;
            }
            subtitleView.setStyle(companion.fromSaveToStyle(context, saveCaptionStyle));
        }
    }

    private final int getColor(int i) {
        int foregroundColor;
        SaveCaptionStyle saveCaptionStyle = null;
        if (i == 0) {
            SaveCaptionStyle saveCaptionStyle2 = this.state;
            if (saveCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle2;
            }
            foregroundColor = saveCaptionStyle.getForegroundColor();
        } else if (i == 1) {
            SaveCaptionStyle saveCaptionStyle3 = this.state;
            if (saveCaptionStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle3;
            }
            foregroundColor = saveCaptionStyle.getEdgeColor();
        } else if (i == 2) {
            SaveCaptionStyle saveCaptionStyle4 = this.state;
            if (saveCaptionStyle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle4;
            }
            foregroundColor = saveCaptionStyle.getBackgroundColor();
        } else if (i != 3) {
            foregroundColor = 0;
        } else {
            SaveCaptionStyle saveCaptionStyle5 = this.state;
            if (saveCaptionStyle5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle5;
            }
            foregroundColor = saveCaptionStyle.getWindowColor();
        }
        return foregroundColor == 0 ? ViewCompat.MEASURED_STATE_MASK : foregroundColor;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.subtitle_settings, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CommonActivity.INSTANCE.getOnColorSelectedEvent().minusAssign(new SubtitlesFragment$onDestroy$1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Companion companion;
        File externalFilesDir;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.hide = arguments != null ? arguments.getBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE) : true;
        CommonActivity.INSTANCE.getOnColorSelectedEvent().plusAssign(new SubtitlesFragment$onViewCreated$1(this));
        CommonActivity.INSTANCE.getOnDialogDismissedEvent().plusAssign(new SubtitlesFragment$onViewCreated$2(this));
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_import_text);
        SaveCaptionStyle saveCaptionStyle = null;
        if (textView != null) {
            String string = getString(R.string.subs_import_text);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.subs_import_text)");
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            Context context = getContext();
            sb.append((context == null || (externalFilesDir = context.getExternalFilesDir(null)) == null) ? null : externalFilesDir.getAbsolutePath());
            sb.append("/Fonts");
            objArr[0] = sb.toString();
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            textView.setText(format);
        }
        Context context2 = getContext();
        if (context2 != null) {
            UIHelper.INSTANCE.fixPaddingStatusbar(context2, (ScrollView) _$_findCachedViewById(C4761R.C4764id.subs_root));
        }
        this.state = Companion.getCurrentSavedStyle();
        Context context3 = getContext();
        if (context3 != null) {
            updateState(context3);
        }
        Context context4 = getContext();
        boolean z = context4 != null && SettingsFragment.Companion.isTrueTvSettings(context4);
        TextView subs_text_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_text_color);
        Intrinsics.checkNotNullExpressionValue(subs_text_color, "subs_text_color");
        onViewCreated$setup(subs_text_color, z, this, 0);
        TextView subs_outline_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_outline_color);
        Intrinsics.checkNotNullExpressionValue(subs_outline_color, "subs_outline_color");
        onViewCreated$setup(subs_outline_color, z, this, 1);
        TextView subs_background_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_background_color);
        Intrinsics.checkNotNullExpressionValue(subs_background_color, "subs_background_color");
        onViewCreated$setup(subs_background_color, z, this, 2);
        TextView subs_window_color = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_window_color);
        Intrinsics.checkNotNullExpressionValue(subs_window_color, "subs_window_color");
        onViewCreated$setup(subs_window_color, z, this, 3);
        final SubtitlesFragment$onViewCreated$dismissCallback$1 subtitlesFragment$onViewCreated$dismissCallback$1 = new SubtitlesFragment$onViewCreated$dismissCallback$1(this);
        TextView subs_subtitle_elevation = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_subtitle_elevation);
        Intrinsics.checkNotNullExpressionValue(subs_subtitle_elevation, "subs_subtitle_elevation");
        subs_subtitle_elevation.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_subtitle_elevation)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$4YChNb__jwYn8HkbfB41LpW4EH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8985onViewCreated$lambda5(SubtitlesFragment.this, subtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_subtitle_elevation)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$BgJ0TE45-ZRsfeEL556eXoxqVaI
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8986onViewCreated$lambda6;
                m8986onViewCreated$lambda6 = SubtitlesFragment.m8986onViewCreated$lambda6(SubtitlesFragment.this, view2);
                return m8986onViewCreated$lambda6;
            }
        });
        TextView subs_edge_type = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_edge_type);
        Intrinsics.checkNotNullExpressionValue(subs_edge_type, "subs_edge_type");
        subs_edge_type.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_edge_type)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$_etdu8jjx86p1kipoIzfv9Rwiz0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8987onViewCreated$lambda9(SubtitlesFragment.this, subtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_edge_type)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$faXLcZdrYNIE_CG0kEv1_wHHVbI
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8972onViewCreated$lambda10;
                m8972onViewCreated$lambda10 = SubtitlesFragment.m8972onViewCreated$lambda10(SubtitlesFragment.this, view2);
                return m8972onViewCreated$lambda10;
            }
        });
        TextView subs_font_size = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_font_size);
        Intrinsics.checkNotNullExpressionValue(subs_font_size, "subs_font_size");
        subs_font_size.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font_size)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$vXst-0QHQwbZX2h0Zys1TdQeWJE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8973onViewCreated$lambda13(SubtitlesFragment.this, subtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        SwitchMaterial switchMaterial = (SwitchMaterial) _$_findCachedViewById(C4761R.C4764id.subtitles_remove_bloat);
        if (switchMaterial != null) {
            SaveCaptionStyle saveCaptionStyle2 = this.state;
            if (saveCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle2 = null;
            }
            switchMaterial.setChecked(saveCaptionStyle2.getRemoveBloat());
        }
        SwitchMaterial switchMaterial2 = (SwitchMaterial) _$_findCachedViewById(C4761R.C4764id.subtitles_remove_bloat);
        if (switchMaterial2 != null) {
            switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$dDsFHRXBgYnd6rwhlfan9qIXqg8
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    SubtitlesFragment.m8974onViewCreated$lambda14(SubtitlesFragment.this, compoundButton, z2);
                }
            });
        }
        SwitchMaterial switchMaterial3 = (SwitchMaterial) _$_findCachedViewById(C4761R.C4764id.subtitles_remove_captions);
        if (switchMaterial3 != null) {
            SaveCaptionStyle saveCaptionStyle3 = this.state;
            if (saveCaptionStyle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle3;
            }
            switchMaterial3.setChecked(saveCaptionStyle.getRemoveCaptions());
        }
        SwitchMaterial switchMaterial4 = (SwitchMaterial) _$_findCachedViewById(C4761R.C4764id.subtitles_remove_captions);
        if (switchMaterial4 != null) {
            switchMaterial4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$rXhtkHUwRnOgPfCwCUtAKwW8ID0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    SubtitlesFragment.m8975onViewCreated$lambda15(SubtitlesFragment.this, compoundButton, z2);
                }
            });
        }
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font_size)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$lxBbwc4UTZTrx6ZrMyn0Zy11b6s
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8976onViewCreated$lambda16;
                m8976onViewCreated$lambda16 = SubtitlesFragment.m8976onViewCreated$lambda16(SubtitlesFragment.this, view2);
                return m8976onViewCreated$lambda16;
            }
        });
        TextView subs_font = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_font);
        Intrinsics.checkNotNullExpressionValue(subs_font, "subs_font");
        subs_font.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$oeicXb_Io4vVlv-xWIZIyEHhdyk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8977onViewCreated$lambda22(SubtitlesFragment.this, subtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_font)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$6b5qO8ioC7QuSNb1uV44ak3msvE
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8978onViewCreated$lambda23;
                m8978onViewCreated$lambda23 = SubtitlesFragment.m8978onViewCreated$lambda23(SubtitlesFragment.this, view2);
                return m8978onViewCreated$lambda23;
            }
        });
        TextView subs_auto_select_language = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_auto_select_language);
        Intrinsics.checkNotNullExpressionValue(subs_auto_select_language, "subs_auto_select_language");
        subs_auto_select_language.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_auto_select_language)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$DpNJzBG8dgARaHhlXN3DBdJpoRI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8979onViewCreated$lambda26(SubtitlesFragment.this, subtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_auto_select_language)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$EpXhWf1SeIXjGUjaXC6ywFS79Ew
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8980onViewCreated$lambda27;
                m8980onViewCreated$lambda27 = SubtitlesFragment.m8980onViewCreated$lambda27(SubtitlesFragment.this, view2);
                return m8980onViewCreated$lambda27;
            }
        });
        TextView subs_download_languages = (TextView) _$_findCachedViewById(C4761R.C4764id.subs_download_languages);
        Intrinsics.checkNotNullExpressionValue(subs_download_languages, "subs_download_languages");
        subs_download_languages.setFocusableInTouchMode(z);
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_download_languages)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$uPk8cRhfjYIhBLDcM0lEDqe0HLI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8981onViewCreated$lambda32(SubtitlesFragment.this, subtitlesFragment$onViewCreated$dismissCallback$1, view2);
            }
        });
        ((TextView) _$_findCachedViewById(C4761R.C4764id.subs_download_languages)).setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$ZVvC7PhycwROe6Hr11NDh1XaAzY
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8982onViewCreated$lambda33;
                m8982onViewCreated$lambda33 = SubtitlesFragment.m8982onViewCreated$lambda33(SubtitlesFragment.this, view2);
                return m8982onViewCreated$lambda33;
            }
        });
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.cancel_btt)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$nTXOHT4Ge303EklqcbFL_R6PIiY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8983onViewCreated$lambda34(SubtitlesFragment.this, view2);
            }
        });
        ((MaterialButton) _$_findCachedViewById(C4761R.C4764id.apply_btt)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$3aksB42Tb9sBAEGO-GviAF8DbhM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8984onViewCreated$lambda35(SubtitlesFragment.this, view2);
            }
        });
        ((SubtitleView) _$_findCachedViewById(C4761R.C4764id.subtitle_text)).setCues(CollectionsKt.listOf(new Cue.Builder().setTextSize(companion.getPixels(2, 25.0f), 2).setText(((SubtitleView) _$_findCachedViewById(C4761R.C4764id.subtitle_text)).getContext().getString(R.string.subtitles_example_text)).build()));
    }

    private static final void onViewCreated$setup(View view, boolean z, final SubtitlesFragment subtitlesFragment, final int i) {
        view.setFocusableInTouchMode(z);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$VLGIvBNKJlqalLSxtOE7hMQ93l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SubtitlesFragment.m8988onViewCreated$setup$lambda1(SubtitlesFragment.this, i, view2);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.subtitles.-$$Lambda$SubtitlesFragment$x67PIN9gEoOS1edDSgxDClXe0DA
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean m8989onViewCreated$setup$lambda2;
                m8989onViewCreated$setup$lambda2 = SubtitlesFragment.m8989onViewCreated$setup$lambda2(SubtitlesFragment.this, i, view2);
                return m8989onViewCreated$setup$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$setup$lambda-1  reason: not valid java name */
    public static final void m8988onViewCreated$setup$lambda1(SubtitlesFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            ColorPickerDialog.newBuilder().setDialogId(i).setShowAlphaSlider(true).setColor(this$0.getColor(i)).show(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$setup$lambda-2  reason: not valid java name */
    public static final boolean m8989onViewCreated$setup$lambda2(SubtitlesFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.setColor(context, i, null);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m8985onViewCreated$lambda5(SubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(0, view.getContext().getString(R.string.none)), new Tuples(10, "10dp"), new Tuples(20, "20dp"), new Tuples(30, "30dp"), new Tuples(40, "40dp"), new Tuples(50, "50dp"), new Tuples(60, "60dp"), new Tuples(70, "70dp"), new Tuples(80, "80dp"), new Tuples(90, "90dp"), new Tuples(100, "100dp")});
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
            SaveCaptionStyle saveCaptionStyle = this$0.state;
            if (saveCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle = null;
            }
            int indexOf = arrayList4.indexOf(Integer.valueOf(saveCaptionStyle.getElevation()));
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList2, indexOf, ((TextView) view).getText().toString(), false, dismissCallback, new SubtitlesFragment$onViewCreated$3$3(this$0, listOf, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final boolean m8986onViewCreated$lambda6(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        saveCaptionStyle.setElevation(20);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.updateState(context);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-9  reason: not valid java name */
    public static final void m8987onViewCreated$lambda9(SubtitlesFragment this$0, Functions dismissCallback, View view) {
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
            SaveCaptionStyle saveCaptionStyle = this$0.state;
            if (saveCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle = null;
            }
            int indexOf = arrayList4.indexOf(Integer.valueOf(saveCaptionStyle.getEdgeType()));
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList2, indexOf, ((TextView) view).getText().toString(), false, dismissCallback, new SubtitlesFragment$onViewCreated$5$3(this$0, listOf, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10  reason: not valid java name */
    public static final boolean m8972onViewCreated$lambda10(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        saveCaptionStyle.setEdgeType(1);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.updateState(context);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-13  reason: not valid java name */
    public static final void m8973onViewCreated$lambda13(SubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        SaveCaptionStyle saveCaptionStyle = null;
        Float valueOf = Float.valueOf(6.0f);
        Float valueOf2 = Float.valueOf(7.0f);
        Float valueOf3 = Float.valueOf(8.0f);
        Float valueOf4 = Float.valueOf(9.0f);
        Float valueOf5 = Float.valueOf(10.0f);
        Float valueOf6 = Float.valueOf(11.0f);
        Float valueOf7 = Float.valueOf(12.0f);
        Float valueOf8 = Float.valueOf(13.0f);
        Float valueOf9 = Float.valueOf(14.0f);
        Float valueOf10 = Float.valueOf(15.0f);
        Float valueOf11 = Float.valueOf(16.0f);
        Float valueOf12 = Float.valueOf(17.0f);
        Float valueOf13 = Float.valueOf(18.0f);
        Float valueOf14 = Float.valueOf(19.0f);
        Float valueOf15 = Float.valueOf(20.0f);
        Float valueOf16 = Float.valueOf(21.0f);
        Float valueOf17 = Float.valueOf(22.0f);
        Float valueOf18 = Float.valueOf(23.0f);
        Float valueOf19 = Float.valueOf(24.0f);
        Float valueOf20 = Float.valueOf(25.0f);
        Float valueOf21 = Float.valueOf(26.0f);
        Float valueOf22 = Float.valueOf(28.0f);
        Float valueOf23 = Float.valueOf(30.0f);
        Float valueOf24 = Float.valueOf(32.0f);
        Float valueOf25 = Float.valueOf(34.0f);
        Float valueOf26 = Float.valueOf(36.0f);
        Float valueOf27 = Float.valueOf(38.0f);
        Float valueOf28 = Float.valueOf(40.0f);
        Float valueOf29 = Float.valueOf(42.0f);
        Float valueOf30 = Float.valueOf(44.0f);
        Float valueOf31 = Float.valueOf(48.0f);
        Float valueOf32 = Float.valueOf(60.0f);
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(null, view.getContext().getString(R.string.normal)), new Tuples(valueOf, "6sp"), new Tuples(valueOf2, "7sp"), new Tuples(valueOf3, "8sp"), new Tuples(valueOf4, "9sp"), new Tuples(valueOf5, "10sp"), new Tuples(valueOf6, "11sp"), new Tuples(valueOf7, "12sp"), new Tuples(valueOf8, "13sp"), new Tuples(valueOf9, "14sp"), new Tuples(valueOf10, "15sp"), new Tuples(valueOf11, "16sp"), new Tuples(valueOf12, "17sp"), new Tuples(valueOf13, "18sp"), new Tuples(valueOf14, "19sp"), new Tuples(valueOf15, "20sp"), new Tuples(valueOf16, "21sp"), new Tuples(valueOf17, "22sp"), new Tuples(valueOf18, "23sp"), new Tuples(valueOf19, "24sp"), new Tuples(valueOf20, "25sp"), new Tuples(valueOf21, "26sp"), new Tuples(valueOf22, "28sp"), new Tuples(valueOf23, "30sp"), new Tuples(valueOf24, "32sp"), new Tuples(valueOf25, "34sp"), new Tuples(valueOf26, "36sp"), new Tuples(valueOf27, "38sp"), new Tuples(valueOf28, "40sp"), new Tuples(valueOf29, RoomMasterTable.DEFAULT_ID + "sp"), new Tuples(valueOf30, "44sp"), new Tuples(valueOf31, "48sp"), new Tuples(valueOf32, "60sp")});
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
                arrayList3.add((Float) tuples2.getFirst());
            }
            ArrayList arrayList4 = arrayList3;
            SaveCaptionStyle saveCaptionStyle2 = this$0.state;
            if (saveCaptionStyle2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            } else {
                saveCaptionStyle = saveCaptionStyle2;
            }
            int indexOf = arrayList4.indexOf(saveCaptionStyle.getFixedTextSize());
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList2, indexOf, ((TextView) view).getText().toString(), false, dismissCallback, new SubtitlesFragment$onViewCreated$7$3(this$0, listOf));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14  reason: not valid java name */
    public static final void m8974onViewCreated$lambda14(SubtitlesFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        saveCaptionStyle.setRemoveBloat(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-15  reason: not valid java name */
    public static final void m8975onViewCreated$lambda15(SubtitlesFragment this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        saveCaptionStyle.setRemoveCaptions(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-16  reason: not valid java name */
    public static final boolean m8976onViewCreated$lambda16(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        saveCaptionStyle.setFixedTextSize(null);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-22  reason: not valid java name */
    public static final void m8977onViewCreated$lambda22(SubtitlesFragment this$0, Functions dismissCallback, View view) {
        int size;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        int i = 0;
        List listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(null, view.getContext().getString(R.string.normal)), new Tuples(Integer.valueOf((int) R.font.trebuchet_ms), "Trebuchet MS"), new Tuples(Integer.valueOf((int) R.font.netflix_sans), "Netflix Sans"), new Tuples(Integer.valueOf((int) R.font.google_sans), "Google Sans"), new Tuples(Integer.valueOf((int) R.font.open_sans), "Open Sans"), new Tuples(Integer.valueOf((int) R.font.futura), "Futura"), new Tuples(Integer.valueOf((int) R.font.consola), "Consola"), new Tuples(Integer.valueOf((int) R.font.gotham), "Gotham"), new Tuples(Integer.valueOf((int) R.font.lucida_grande), "Lucida Grande"), new Tuples(Integer.valueOf((int) R.font.stix_general), "STIX General"), new Tuples(Integer.valueOf((int) R.font.times_new_roman), "Times New Roman"), new Tuples(Integer.valueOf((int) R.font.verdana), "Verdana"), new Tuples(Integer.valueOf((int) R.font.ubuntu_regular), "Ubuntu"), new Tuples(Integer.valueOf((int) R.font.comic_sans), "Comic Sans"), new Tuples(Integer.valueOf((int) R.font.poppins_regular), "Poppins")});
        Companion companion = Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        List savedFonts = companion.getSavedFonts(context);
        Iterator it = savedFonts.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            }
            String absolutePath = ((File) it.next()).getAbsolutePath();
            SaveCaptionStyle saveCaptionStyle = this$0.state;
            if (saveCaptionStyle == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                saveCaptionStyle = null;
            }
            if (Intrinsics.areEqual(absolutePath, saveCaptionStyle.getTypefaceFilePath())) {
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            Iterator it2 = listOf.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    size = -1;
                    break;
                }
                Object first = ((Tuples) it2.next()).getFirst();
                SaveCaptionStyle saveCaptionStyle2 = this$0.state;
                if (saveCaptionStyle2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                    saveCaptionStyle2 = null;
                }
                if (Intrinsics.areEqual(first, saveCaptionStyle2.getTypeface())) {
                    size = i;
                    break;
                }
                i++;
            }
        } else {
            size = i2 + listOf.size();
        }
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
            List<File> list2 = savedFonts;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (File file : list2) {
                arrayList3.add(file.getName());
            }
            List<String> plus = CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, plus, size, ((TextView) view).getText().toString(), false, dismissCallback, new SubtitlesFragment$onViewCreated$11$3(listOf, this$0, savedFonts, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-23  reason: not valid java name */
    public static final boolean m8978onViewCreated$lambda23(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        saveCaptionStyle.setTypeface(null);
        SaveCaptionStyle saveCaptionStyle2 = this$0.state;
        if (saveCaptionStyle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle2 = null;
        }
        saveCaptionStyle2.setTypefaceFilePath(null);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "textView.context");
        this$0.updateState(context);
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-26  reason: not valid java name */
    public static final void m8979onViewCreated$lambda26(SubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        String string = view.getContext().getString(R.string.none);
        Intrinsics.checkNotNullExpressionValue(string, "textView.context.getString(R.string.none)");
        String string2 = view.getContext().getString(R.string.none);
        Intrinsics.checkNotNullExpressionValue(string2, "textView.context.getString(R.string.none)");
        ArrayList arrayListOf = CollectionsKt.arrayListOf(new SubtitleHelper.Language639(string, string2, "", "", "", "", ""));
        arrayListOf.addAll(SubtitleHelper.INSTANCE.getLanguages());
        ArrayList<SubtitleHelper.Language639> arrayList = arrayListOf;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (SubtitleHelper.Language639 language639 : arrayList) {
            arrayList2.add(language639.getISO_639_1());
        }
        ArrayList arrayList3 = arrayList2;
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (SubtitleHelper.Language639 language6392 : arrayList) {
                arrayList4.add(language6392.getLanguageName());
            }
            int indexOf = arrayList3.indexOf(Companion.getAutoSelectLanguageISO639_1());
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showDialog(fragmentActivity, arrayList4, indexOf, ((TextView) view).getText().toString(), true, dismissCallback, new SubtitlesFragment$onViewCreated$13$2(arrayList3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27  reason: not valid java name */
    public static final boolean m8980onViewCreated$lambda27(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AcraApplication.Companion.setKey(SubtitlesFragmentKt.SUBTITLE_AUTO_SELECT_KEY, "vi");
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-32  reason: not valid java name */
    public static final void m8981onViewCreated$lambda32(SubtitlesFragment this$0, Functions dismissCallback, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        List<SubtitleHelper.Language639> languages = SubtitleHelper.INSTANCE.getLanguages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(languages, 10));
        for (SubtitleHelper.Language639 language639 : languages) {
            arrayList.add(language639.getISO_639_1());
        }
        ArrayList arrayList2 = arrayList;
        List<String> downloadSubsLanguageISO639_1 = Companion.getDownloadSubsLanguageISO639_1();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(downloadSubsLanguageISO639_1, 10));
        for (String str : downloadSubsLanguageISO639_1) {
            arrayList3.add(Integer.valueOf(arrayList2.indexOf(str)));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (((Number) obj).intValue() >= 0) {
                arrayList4.add(obj);
            }
        }
        ArrayList arrayList5 = arrayList4;
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            SingleSelectionHelper singleSelectionHelper = SingleSelectionHelper.INSTANCE;
            FragmentActivity fragmentActivity = activity;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(languages, 10));
            for (SubtitleHelper.Language639 language6392 : languages) {
                arrayList6.add(language6392.getLanguageName());
            }
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            singleSelectionHelper.showMultiDialog(fragmentActivity, arrayList6, arrayList5, ((TextView) view).getText().toString(), dismissCallback, new SubtitlesFragment$onViewCreated$15$2(arrayList2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-33  reason: not valid java name */
    public static final boolean m8982onViewCreated$lambda33(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AcraApplication.Companion.setKey(SubtitlesFragmentKt.SUBTITLE_DOWNLOAD_KEY, CollectionsKt.listOf("vi"));
        CommonActivity.INSTANCE.showToast(this$0.getActivity(), R.string.subs_default_reset_toast, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-34  reason: not valid java name */
    public static final void m8983onViewCreated$lambda34(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-35  reason: not valid java name */
    public static final void m8984onViewCreated$lambda35(SubtitlesFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion companion = Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        SaveCaptionStyle saveCaptionStyle = this$0.state;
        SaveCaptionStyle saveCaptionStyle2 = null;
        if (saveCaptionStyle == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle = null;
        }
        companion.saveStyle(context, saveCaptionStyle);
        Event<SaveCaptionStyle> event = applyStyleEvent;
        SaveCaptionStyle saveCaptionStyle3 = this$0.state;
        if (saveCaptionStyle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
            saveCaptionStyle3 = null;
        }
        event.invoke(saveCaptionStyle3);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "it.context");
        SaveCaptionStyle saveCaptionStyle4 = this$0.state;
        if (saveCaptionStyle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
        } else {
            saveCaptionStyle2 = saveCaptionStyle4;
        }
        companion.fromSaveToStyle(context2, saveCaptionStyle2);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }
}
