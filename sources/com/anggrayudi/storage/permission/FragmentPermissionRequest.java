package com.anggrayudi.storage.permission;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FragmentPermissionRequest.kt */
@Metadata(m108d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\f\u001a.\u0012*\u0012(\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006 \u000e*\u0014\u0012\u000e\b\u0001\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u0018"}, m107d2 = {"Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "fragment", "Landroidx/fragment/app/Fragment;", "permissions", "", "", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroidx/core/app/ActivityOptionsCompat;", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;Landroidx/core/app/ActivityOptionsCompat;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "check", "", "continueToPermissionRequest", "onRequestPermissionsResult", "result", "", "", "Builder", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class FragmentPermissionRequest implements PermissionRequest {
    private final PermissionCallback callback;
    private final Fragment fragment;
    private final ActivityResultLauncher<String[]> launcher;
    private final ActivityOptionsCompat options;
    private final String[] permissions;

    public /* synthetic */ FragmentPermissionRequest(Fragment fragment, String[] strArr, ActivityOptionsCompat activityOptionsCompat, PermissionCallback permissionCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, strArr, activityOptionsCompat, permissionCallback);
    }

    private FragmentPermissionRequest(Fragment fragment, String[] strArr, ActivityOptionsCompat activityOptionsCompat, PermissionCallback permissionCallback) {
        this.fragment = fragment;
        this.permissions = strArr;
        this.options = activityOptionsCompat;
        this.callback = permissionCallback;
        ActivityResultLauncher<String[]> registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.permission.-$$Lambda$FragmentPermissionRequest$hiczkigeDbREgRsSn3QdBqfa3n4
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FragmentPermissionRequest.m8554launcher$lambda0(FragmentPermissionRequest.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "fragment.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {\n        onRequestPermissionsResult(it)\n    }");
        this.launcher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: launcher$lambda-0  reason: not valid java name */
    public static final void m8554launcher$lambda0(FragmentPermissionRequest this$0, Map it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.onRequestPermissionsResult(it);
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public void check() {
        Context requireContext = this.fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "fragment.requireContext()");
        for (String str : this.permissions) {
            if (ContextCompat.checkSelfPermission(requireContext, str) != 0) {
                this.callback.onDisplayConsentDialog(this);
                return;
            }
        }
        PermissionCallback permissionCallback = this.callback;
        String[] strArr = this.permissions;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
    }

    private final void onRequestPermissionsResult(Map<String, Boolean> map) {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, Boolean>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Boolean> next = it.next();
            String key = next.getKey();
            boolean booleanValue = next.getValue().booleanValue();
            if (next.getValue().booleanValue() || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity, next.getKey())) {
                z = false;
            }
            arrayList.add(new PermissionReport(key, booleanValue, z));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((PermissionReport) obj).getDeniedPermanently()) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            this.callback.onPermissionsChecked(new PermissionResult(arrayList2), true);
        } else {
            this.callback.onShouldRedirectToSystemSettings(arrayList4);
        }
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public void continueToPermissionRequest() {
        FragmentActivity requireActivity = this.fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        for (String str : this.permissions) {
            if (ContextCompat.checkSelfPermission(requireActivity, str) != 0) {
                this.launcher.launch(this.permissions, this.options);
                return;
            }
        }
        PermissionCallback permissionCallback = this.callback;
        String[] strArr = this.permissions;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
    }

    /* compiled from: FragmentPermissionRequest.kt */
    @Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u001f\u0010\u0012\u001a\u00020\u00002\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0013\"\u00020\u000b¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m107d2 = {"Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroidx/core/app/ActivityOptionsCompat;", "permissions", "", "", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "check", "", "withActivityOptions", "withCallback", "withPermissions", "", "([Ljava/lang/String;)Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private PermissionCallback callback;
        private final Fragment fragment;
        private ActivityOptionsCompat options;
        private Set<String> permissions;

        public Builder(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.fragment = fragment;
            this.permissions = SetsKt.emptySet();
        }

        public final Builder withPermissions(String... permissions) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Builder builder = this;
            builder.permissions = ArraysKt.toSet(permissions);
            return builder;
        }

        public final Builder withCallback(PermissionCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            Builder builder = this;
            builder.callback = callback;
            return builder;
        }

        public final Builder withActivityOptions(ActivityOptionsCompat activityOptionsCompat) {
            Builder builder = this;
            builder.options = activityOptionsCompat;
            return builder;
        }

        public final FragmentPermissionRequest build() {
            Fragment fragment = this.fragment;
            Object[] array = this.permissions.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ActivityOptionsCompat activityOptionsCompat = this.options;
            PermissionCallback permissionCallback = this.callback;
            Intrinsics.checkNotNull(permissionCallback);
            return new FragmentPermissionRequest(fragment, (String[]) array, activityOptionsCompat, permissionCallback, null);
        }

        public final void check() {
            build().check();
        }
    }
}
