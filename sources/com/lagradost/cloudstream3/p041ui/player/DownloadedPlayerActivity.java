package com.lagradost.cloudstream3.p041ui.player;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.bongngotv2.R;
import com.hippo.unifile.UniFile;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.p041ui.player.GeneratorPlayer;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadedPlayerActivity.kt */
@Metadata(m108d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0014¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/DownloadedPlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", "keyCode", "", "onUserLeaveHint", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.DownloadedPlayerActivity */
/* loaded from: classes3.dex */
public final class DownloadedPlayerActivity extends AppCompatActivity {
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean dispatchKeyEvent = CommonActivity.INSTANCE.dispatchKeyEvent(this, keyEvent);
        return dispatchKeyEvent != null ? dispatchKeyEvent.booleanValue() : super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        CommonActivity.INSTANCE.onKeyDown(this, i, keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        CommonActivity.INSTANCE.onUserLeaveHint(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Log.i(DownloadedPlayerActivityKt.DTAG, "onCreate");
        DownloadedPlayerActivity downloadedPlayerActivity = this;
        CommonActivity.INSTANCE.loadThemes(downloadedPlayerActivity);
        super.onCreate(bundle);
        CommonActivity.INSTANCE.init(downloadedPlayerActivity);
        setContentView(R.layout.empty_layout);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
        } else if (Intrinsics.areEqual(data.getScheme(), "content")) {
            String name = UniFile.fromUri(this, data).getName();
            UIHelper uIHelper = UIHelper.INSTANCE;
            GeneratorPlayer.Companion companion = GeneratorPlayer.Companion;
            if (name == null) {
                name = getString(R.string.downloaded_file);
                Intrinsics.checkNotNullExpressionValue(name, "getString(R.string.downloaded_file)");
            }
            uIHelper.navigate(downloadedPlayerActivity, R.id.global_to_navigation_player, GeneratorPlayer.Companion.newInstance$default(companion, new DownloadFileGenerator(CollectionsKt.listOf(new ExtractorUri(data, name, null, null, null, null, null, null, null, null, null, 2044, null)), 0, 2, null), null, 2, null));
        }
    }
}
