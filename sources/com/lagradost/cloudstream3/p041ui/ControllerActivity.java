package com.lagradost.cloudstream3.p041ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.bongngotv2.R;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ControllerActivity.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/ControllerActivity;", "Lcom/google/android/gms/cast/framework/media/widget/ExpandedControllerActivity;", "()V", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.ControllerActivity */
/* loaded from: classes.dex */
public final class ControllerActivity extends ExpandedControllerActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.cast_expanded_controller_menu, menu);
        CastButtonFactory.setUpMediaRouteButton(this, menu, R.id.media_route_menu_item);
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View currentFocus = getCurrentFocus();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(event);
        if (currentFocus instanceof EditText) {
            View currentFocus2 = getCurrentFocus();
            int[] iArr = new int[2];
            Intrinsics.checkNotNull(currentFocus2);
            currentFocus2.getLocationOnScreen(iArr);
            float rawX = (event.getRawX() + currentFocus2.getLeft()) - iArr[0];
            float rawY = (event.getRawY() + currentFocus2.getTop()) - iArr[1];
            if (event.getAction() == 1 && (rawX < currentFocus2.getLeft() || rawX >= currentFocus2.getRight() || rawY < currentFocus2.getTop() || rawY > currentFocus2.getBottom())) {
                Object systemService = getSystemService("input_method");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                View currentFocus3 = getWindow().getCurrentFocus();
                Intrinsics.checkNotNull(currentFocus3);
                ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus3.getWindowToken(), 0);
            }
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImageView buttonImageViewAt = getButtonImageViewAt(0);
        Intrinsics.checkNotNullExpressionValue(buttonImageViewAt, "getButtonImageViewAt(0)");
        ImageView buttonImageViewAt2 = getButtonImageViewAt(1);
        Intrinsics.checkNotNullExpressionValue(buttonImageViewAt2, "getButtonImageViewAt(1)");
        ImageView buttonImageViewAt3 = getButtonImageViewAt(2);
        Intrinsics.checkNotNullExpressionValue(buttonImageViewAt3, "getButtonImageViewAt(2)");
        ImageView buttonImageViewAt4 = getButtonImageViewAt(3);
        Intrinsics.checkNotNullExpressionValue(buttonImageViewAt4, "getButtonImageViewAt(3)");
        getUIMediaController().bindViewToUIController(buttonImageViewAt, new SelectSourceController(buttonImageViewAt, this));
        getUIMediaController().bindViewToUIController(buttonImageViewAt2, new SkipTimeController(buttonImageViewAt2, false));
        getUIMediaController().bindViewToUIController(buttonImageViewAt3, new SkipTimeController(buttonImageViewAt3, true));
        getUIMediaController().bindViewToUIController(buttonImageViewAt4, new SkipNextEpisodeController(buttonImageViewAt4));
    }
}
