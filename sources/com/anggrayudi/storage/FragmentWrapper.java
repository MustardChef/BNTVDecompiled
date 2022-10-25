package com.anggrayudi.storage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentWrapper.kt */
@Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, m107d2 = {"Lcom/anggrayudi/storage/FragmentWrapper;", "Lcom/anggrayudi/storage/ComponentWrapper;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "requestCode", "", "getRequestCode", "()Ljava/lang/Integer;", "setRequestCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "storage", "Lcom/anggrayudi/storage/SimpleStorage;", "getStorage", "()Lcom/anggrayudi/storage/SimpleStorage;", "setStorage", "(Lcom/anggrayudi/storage/SimpleStorage;)V", "startActivityForResult", "", SDKConstants.PARAM_INTENT, "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class FragmentWrapper implements ComponentWrapper {
    private final ActivityResultLauncher<Intent> activityResultLauncher;
    private final Fragment fragment;
    private Integer requestCode;
    public SimpleStorage storage;

    public FragmentWrapper(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        ActivityResultLauncher<Intent> registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.-$$Lambda$FragmentWrapper$X3ZY0z-iJsWOWiAt6ZcQoLUo7Eo
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FragmentWrapper.m8543activityResultLauncher$lambda1(FragmentWrapper.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {\n        requestCode?.run { storage.onActivityResult(this, it.resultCode, it.data) }\n        requestCode = null\n    }");
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
    public static final void m8543activityResultLauncher$lambda1(FragmentWrapper this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer requestCode = this$0.getRequestCode();
        if (requestCode != null) {
            this$0.getStorage().onActivityResult(requestCode.intValue(), activityResult.getResultCode(), activityResult.getData());
        }
        this$0.setRequestCode(null);
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public Context getContext() {
        Context requireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        return requireContext;
    }

    @Override // com.anggrayudi.storage.ComponentWrapper
    public FragmentActivity getActivity() {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        return requireActivity;
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
