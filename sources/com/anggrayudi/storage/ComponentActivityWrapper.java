package com.anggrayudi.storage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComponentActivityWrapper.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, m107d2 = {"Lcom/anggrayudi/storage/ComponentActivityWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "_activity", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V", "activity", "getActivity", "()Landroidx/activity/ComponentActivity;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "requestCode", "", "getRequestCode", "()Ljava/lang/Integer;", "setRequestCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "storage", "Lcom/anggrayudi/storage/SimpleStorage;", "getStorage", "()Lcom/anggrayudi/storage/SimpleStorage;", "setStorage", "(Lcom/anggrayudi/storage/SimpleStorage;)V", "startActivityForResult", "", SDKConstants.PARAM_INTENT, "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class ComponentActivityWrapper implements ComponentWrapper {
    private final ComponentActivity _activity;
    private final ActivityResultLauncher<Intent> activityResultLauncher;
    private Integer requestCode;
    public SimpleStorage storage;

    public ComponentActivityWrapper(ComponentActivity _activity) {
        Intrinsics.checkNotNullParameter(_activity, "_activity");
        this._activity = _activity;
        ActivityResultLauncher<Intent> registerForActivityResult = _activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.-$$Lambda$ComponentActivityWrapper$kYa6O8GMnbUWm-4EwxsZwFahXH0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ComponentActivityWrapper.m8541activityResultLauncher$lambda1(ComponentActivityWrapper.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "_activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n        requestCode?.run { storage.onActivityResult(this, it.resultCode, it.data) }\n        requestCode = null\n    }");
        this.activityResultLauncher = registerForActivityResult;
    }

    public final SimpleStorage getStorage() {
        SimpleStorage simpleStorage = this.storage;
        if (simpleStorage != null) {
            return simpleStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("storage");
        throw null;
    }

    public final void setStorage(SimpleStorage simpleStorage) {
        Intrinsics.checkNotNullParameter(simpleStorage, "<set-?>");
        this.storage = simpleStorage;
    }

    public final Integer getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(Integer num) {
        this.requestCode = num;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: activityResultLauncher$lambda-1  reason: not valid java name */
    public static final void m8541activityResultLauncher$lambda1(ComponentActivityWrapper this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer requestCode = this$0.getRequestCode();
        if (requestCode != null) {
            this$0.getStorage().onActivityResult(requestCode.intValue(), activityResult.getResultCode(), activityResult.getData());
        }
        this$0.setRequestCode(null);
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public Context getContext() {
        return this._activity;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public ComponentActivity getActivity() {
        return this._activity;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public boolean startActivityForResult(Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            this.activityResultLauncher.launch(intent);
            this.requestCode = Integer.valueOf(i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
