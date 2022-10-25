package com.lagradost.cloudstream3.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SingleSelectionHelper.kt */
@Metadata(m108d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0011Jp\u0010\u0012\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fJT\u0010\u0012\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0011JW\u0010\u0016\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002¢\u0006\u0002\u0010\u0019JX\u0010\u001a\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0004\u0012\u00020\u00040\u0011JK\u0010\u001b\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\u0010\u001cJ^\u0010\u001d\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0#\u0012\u0004\u0012\u00020\u00040\u0011H\u0002J^\u0010$\u001a\u00020\u0004*\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0#\u0012\u0004\u0012\u00020\u00040\u0011¨\u0006%"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/SingleSelectionHelper;", "", "()V", "showBottomDialog", "", "Landroid/app/Activity;", FirebaseAnalytics.Param.ITEMS, "", "", "selectedIndex", "", "name", "showApply", "", "dismissCallback", "Lkotlin/Function0;", "callback", "Lkotlin/Function1;", "showDialog", "dialog", "Landroid/app/Dialog;", "isMultiSelect", "showInputDialog", "value", "textInputType", "(Landroid/app/Activity;Landroid/app/Dialog;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "showMultiDialog", "showNginxTextInputDialog", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "showOptionSelect", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "poster", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "tvOptions", "Lkotlin/Pair;", "showOptionSelectStringRes", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SingleSelectionHelper {
    public static final SingleSelectionHelper INSTANCE = new SingleSelectionHelper();

    private SingleSelectionHelper() {
    }

    public static /* synthetic */ void showOptionSelectStringRes$default(SingleSelectionHelper singleSelectionHelper, Activity activity, View view, String str, List list, List list2, Function1 function1, int i, Object obj) {
        List list3 = list2;
        if ((i & 8) != 0) {
            list3 = CollectionsKt.emptyList();
        }
        singleSelectionHelper.showOptionSelectStringRes(activity, view, str, list, list3, function1);
    }

    public final void showOptionSelectStringRes(Activity activity, View view, String str, List<Integer> options, List<Integer> tvOptions, Function1<? super Tuples<Boolean, Integer>, Unit> callback) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(tvOptions, "tvOptions");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity == null) {
            return;
        }
        List<Integer> list = options;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Number number : list) {
            String string = activity.getString(number.intValue());
            Intrinsics.checkNotNullExpressionValue(string, "this.getString(it)");
            arrayList.add(string);
        }
        ArrayList arrayList2 = arrayList;
        List<Integer> list2 = tvOptions;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Number number2 : list2) {
            String string2 = activity.getString(number2.intValue());
            Intrinsics.checkNotNullExpressionValue(string2, "this.getString(it)");
            arrayList3.add(string2);
        }
        showOptionSelect(activity, view, str, arrayList2, arrayList3, callback);
    }

    private final void showOptionSelect(final Activity activity, View view, String str, List<String> list, List<String> list2, final Function1<? super Tuples<Boolean, Integer>, Unit> function1) {
        if (activity == null) {
            return;
        }
        Activity activity2 = activity;
        if (!SettingsFragment.Companion.isTvSettings(activity2)) {
            if (view != null) {
                UIHelper uIHelper = UIHelper.INSTANCE;
                List<String> list3 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (Object obj : list3) {
                    int i = r5 + 1;
                    if (r5 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(new Tuples(Integer.valueOf(r5), (String) obj));
                    r5 = i;
                }
                uIHelper.popupMenuNoIconsAndNoStringRes(view, arrayList, new SingleSelectionHelper$showOptionSelect$4(function1));
                return;
            }
            return;
        }
        final AlertDialog create = new AlertDialog.Builder(activity2, R.style.AlertDialogCustom).setView(R.layout.options_popup_tv).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        ListView listView = (ListView) create.findViewById(R.id.listview1);
        boolean z = true;
        if (listView != null) {
            listView.setChoiceMode(1);
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity2, R.layout.sort_bottom_single_choice_color);
            arrayAdapter.addAll(list2);
            listView.setAdapter((ListAdapter) arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$1E9-F5o2dKfKMb5j9C1SRdYOXbM
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                    SingleSelectionHelper.m9017showOptionSelect$lambda4$lambda3(Function1.this, create, activity, adapterView, view2, i2, j);
                }
            });
        }
        ImageView imageView = (ImageView) create.findViewById(R.id.imageView);
        if (imageView != null) {
            ImageView imageView2 = imageView;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            imageView2.setVisibility(z ? 8 : 0);
            UIHelper.setImage$default(UIHelper.INSTANCE, imageView, str, null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showOptionSelect$lambda-4$lambda-3  reason: not valid java name */
    public static final void m9017showOptionSelect$lambda4$lambda3(Function1 callback, AlertDialog dialog, Activity activity, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        callback.invoke(new Tuples(true, Integer.valueOf(i)));
        UIHelper.INSTANCE.dismissSafe(dialog, activity);
    }

    public final void showDialog(final Activity activity, final Dialog dialog, List<String> items, List<Integer> selectedIndex, String name, boolean z, final boolean z2, final Function1<? super List<Integer>, Unit> callback, final Functions<Unit> dismissCallback) {
        TextView textView;
        boolean z3;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(selectedIndex, "selectedIndex");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        if (activity == null) {
            return;
        }
        boolean z4 = z || z2;
        View findViewById = dialog.findViewById(R.id.listview1);
        Intrinsics.checkNotNull(findViewById);
        final ListView listView = (ListView) findViewById;
        View findViewById2 = dialog.findViewById(R.id.text1);
        Intrinsics.checkNotNull(findViewById2);
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = dialog.findViewById(R.id.apply_btt);
        Intrinsics.checkNotNull(findViewById3);
        TextView textView3 = (TextView) findViewById3;
        View findViewById4 = dialog.findViewById(R.id.cancel_btt);
        Intrinsics.checkNotNull(findViewById4);
        TextView textView4 = (TextView) findViewById4;
        View findViewById5 = dialog.findViewById(R.id.apply_btt_holder);
        Intrinsics.checkNotNull(findViewById5);
        ((LinearLayout) findViewById5).setVisibility(z4 ? 0 : 8);
        if (z4) {
            textView = textView4;
        } else {
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            ListView listView2 = listView;
            ViewGroup.LayoutParams layoutParams3 = listView2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
            int i = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
            ViewGroup.LayoutParams layoutParams4 = listView2.getLayoutParams();
            textView = textView4;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
            int i2 = marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0;
            ViewGroup.LayoutParams layoutParams5 = listView2.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams5 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams5 : null;
            layoutParams2.setMargins(i, i2, marginLayoutParams3 != null ? marginLayoutParams3.rightMargin : 0, 0);
            listView.setLayoutParams(layoutParams2);
        }
        textView2.setText(name);
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, R.layout.sort_bottom_single_choice);
        arrayAdapter.addAll(items);
        listView.setAdapter((ListAdapter) arrayAdapter);
        if (z2) {
            listView.setChoiceMode(2);
            z3 = true;
        } else {
            z3 = true;
            listView.setChoiceMode(1);
        }
        for (Integer num : selectedIndex) {
            listView.setItemChecked(num.intValue(), z3);
        }
        Integer num2 = (Integer) CollectionsKt.minOrNull((Iterable<? extends Comparable>) selectedIndex);
        if (num2 != null) {
            listView.setSelection(num2.intValue());
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$_quW3Lgn-ouB9XXLDnvd4yUm2jw
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SingleSelectionHelper.m9012showDialog$lambda8(Functions.this, dialogInterface);
            }
        });
        final boolean z5 = z4;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$UeWPO4w7u9UenpGGA_-RJpRqfUM
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j) {
                SingleSelectionHelper.m9013showDialog$lambda9(z5, z2, listView, callback, dialog, activity, adapterView, view, i3, j);
            }
        });
        if (z4) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$NI6cKmni_VGbmG278Kfh03vWEmQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SingleSelectionHelper.m9010showDialog$lambda10(listView, callback, dialog, activity, view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$0OvOCfYBoH8KA_sMrwTjbicQxjk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SingleSelectionHelper.m9011showDialog$lambda11(dialog, activity, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialog$lambda-8  reason: not valid java name */
    public static final void m9012showDialog$lambda8(Functions dismissCallback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        dismissCallback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialog$lambda-9  reason: not valid java name */
    public static final void m9013showDialog$lambda9(boolean z, boolean z2, ListView listView, Function1 callback, Dialog dialog, Activity activity, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(listView, "$listView");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        if (!z) {
            callback.invoke(CollectionsKt.listOf(Integer.valueOf(i)));
            UIHelper.INSTANCE.dismissSafe(dialog, activity);
        } else if (z2) {
        } else {
            listView.setItemChecked(i, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialog$lambda-10  reason: not valid java name */
    public static final void m9010showDialog$lambda10(ListView listView, Function1 callback, Dialog dialog, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(listView, "$listView");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        ArrayList arrayList = new ArrayList();
        int count = listView.getCount();
        for (int i = 0; i < count; i++) {
            if (listView.getCheckedItemPositions().get(i)) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        callback.invoke(arrayList);
        UIHelper.INSTANCE.dismissSafe(dialog, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showDialog$lambda-11  reason: not valid java name */
    public static final void m9011showDialog$lambda11(Dialog dialog, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        UIHelper.INSTANCE.dismissSafe(dialog, activity);
    }

    private final void showInputDialog(final Activity activity, final Dialog dialog, String str, String str2, Integer num, final Function1<? super String, Unit> function1, final Functions<Unit> functions) {
        if (activity == null) {
            return;
        }
        View findViewById = dialog.findViewById(R.id.nginx_text_input);
        Intrinsics.checkNotNull(findViewById);
        final EditText editText = (EditText) findViewById;
        View findViewById2 = dialog.findViewById(R.id.text1);
        Intrinsics.checkNotNull(findViewById2);
        View findViewById3 = dialog.findViewById(R.id.apply_btt);
        Intrinsics.checkNotNull(findViewById3);
        TextView textView = (TextView) findViewById3;
        View findViewById4 = dialog.findViewById(R.id.cancel_btt);
        Intrinsics.checkNotNull(findViewById4);
        TextView textView2 = (TextView) findViewById4;
        View findViewById5 = dialog.findViewById(R.id.apply_btt_holder);
        Intrinsics.checkNotNull(findViewById5);
        ((LinearLayout) findViewById5).setVisibility(0);
        ((TextView) findViewById2).setText(str2);
        if (num != null) {
            editText.setInputType(num.intValue());
        }
        editText.setText(str, TextView.BufferType.EDITABLE);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$Gq3sYU26dhrElQxEsriGH0o4jUw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleSelectionHelper.m9014showInputDialog$lambda12(Function1.this, editText, dialog, activity, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$M4JwaAlaKvQK_AaSnd_Pb8dmHqk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleSelectionHelper.m9015showInputDialog$lambda13(dialog, activity, view);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.lagradost.cloudstream3.utils.-$$Lambda$SingleSelectionHelper$zU-KbuFLRpByvF-o1CiGhPZLHP8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                SingleSelectionHelper.m9016showInputDialog$lambda14(Functions.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showInputDialog$lambda-12  reason: not valid java name */
    public static final void m9014showInputDialog$lambda12(Function1 callback, EditText inputView, Dialog dialog, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(inputView, "$inputView");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        callback.invoke(inputView.getText().toString());
        UIHelper.INSTANCE.dismissSafe(dialog, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showInputDialog$lambda-13  reason: not valid java name */
    public static final void m9015showInputDialog$lambda13(Dialog dialog, Activity activity, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        UIHelper.INSTANCE.dismissSafe(dialog, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showInputDialog$lambda-14  reason: not valid java name */
    public static final void m9016showInputDialog$lambda14(Functions dismissCallback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dismissCallback, "$dismissCallback");
        dismissCallback.invoke();
    }

    public final void showMultiDialog(Activity activity, List<String> items, List<Integer> selectedIndex, String name, Functions<Unit> dismissCallback, Function1<? super List<Integer>, Unit> callback) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(selectedIndex, "selectedIndex");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity == null) {
            return;
        }
        AlertDialog create = new AlertDialog.Builder(activity, R.style.AlertDialogCustom).setView(R.layout.bottom_selection_dialog).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        showDialog(activity, create, items, selectedIndex, name, true, true, callback, dismissCallback);
    }

    public final void showDialog(Activity activity, List<String> items, int i, String name, boolean z, Functions<Unit> dismissCallback, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity == null) {
            return;
        }
        AlertDialog create = new AlertDialog.Builder(activity, R.style.AlertDialogCustom).setView(R.layout.bottom_selection_dialog).create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        showDialog(activity, create, items, CollectionsKt.listOf(Integer.valueOf(i)), name, z, false, new SingleSelectionHelper$showDialog$6(callback), dismissCallback);
    }

    public final void showBottomDialog(Activity activity, List<String> items, int i, String name, boolean z, Functions<Unit> dismissCallback, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity == null) {
            return;
        }
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.bottom_selection_dialog);
        bottomSheetDialog.show();
        showDialog(activity, bottomSheetDialog, items, CollectionsKt.listOf(Integer.valueOf(i)), name, z, false, new SingleSelectionHelper$showBottomDialog$1(callback), dismissCallback);
    }

    public final void showNginxTextInputDialog(Activity activity, String name, String value, Integer num, Functions<Unit> dismissCallback, Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(R.layout.bottom_input_dialog);
        bottomSheetDialog.show();
        showInputDialog(activity, bottomSheetDialog, value, name, num, callback, dismissCallback);
    }
}
