package com.anggrayudi.storage.permission;

import android.app.Activity;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityPermissionRequest.kt */
@Metadata(m108d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J)\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0014\u001a\u00020\u00122\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R<\u0010\f\u001a0\u0012*\u0012(\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006 \u000e*\u0014\u0012\u000e\b\u0001\u0012\n \u000e*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006 "}, m107d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestCode", "", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/Integer;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "Ljava/lang/Integer;", "check", "", "continueToPermissionRequest", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "result", "", "", "reportResult", "reports", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "Builder", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class ActivityPermissionRequest implements PermissionRequest {
    private final Activity activity;
    private final PermissionCallback callback;
    private final ActivityResultLauncher<String[]> launcher;
    private final String[] permissions;
    private final Integer requestCode;

    public /* synthetic */ ActivityPermissionRequest(Activity activity, String[] strArr, Integer num, PermissionCallback permissionCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, strArr, num, permissionCallback);
    }

    private ActivityPermissionRequest(Activity activity, String[] strArr, Integer num, PermissionCallback permissionCallback) {
        this.activity = activity;
        this.permissions = strArr;
        this.requestCode = num;
        this.callback = permissionCallback;
        this.launcher = activity instanceof ComponentActivity ? ((ComponentActivity) activity).registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.permission.-$$Lambda$ActivityPermissionRequest$3tAxuHlBYWCrKg1BFwQIysjA0Ug
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityPermissionRequest.m8553launcher$lambda0(ActivityPermissionRequest.this, (Map) obj);
            }
        }) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: launcher$lambda-0  reason: not valid java name */
    public static final void m8553launcher$lambda0(ActivityPermissionRequest this$0, Map it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.onRequestPermissionsResult(it);
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public void check() {
        for (String str : this.permissions) {
            if (ContextCompat.checkSelfPermission(this.activity, str) != 0) {
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

    public final void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Integer num = this.requestCode;
        if (num != null && i == num.intValue()) {
            if (this.launcher != null) {
                throw new IllegalAccessException("Do not call onRequestPermissionsResult() in ComponentActivity");
            }
            ArrayList arrayList = new ArrayList(permissions.length);
            int length = permissions.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = permissions[i2];
                int i4 = i3 + 1;
                boolean z = true;
                boolean z2 = grantResults[i3] == 0;
                if (z2 || ActivityCompat.shouldShowRequestPermissionRationale(this.activity, str)) {
                    z = false;
                }
                arrayList.add(new PermissionReport(str, z2, z));
                i2++;
                i3 = i4;
            }
            reportResult(arrayList);
        }
    }

    private final void reportResult(List<PermissionReport> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((PermissionReport) obj).getDeniedPermanently()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            this.callback.onPermissionsChecked(new PermissionResult(list), true);
        } else {
            this.callback.onShouldRedirectToSystemSettings(arrayList2);
        }
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public void continueToPermissionRequest() {
        for (String str : this.permissions) {
            if (ContextCompat.checkSelfPermission(this.activity, str) != 0) {
                ActivityResultLauncher<String[]> activityResultLauncher = this.launcher;
                if (activityResultLauncher != null) {
                    activityResultLauncher.launch(this.permissions);
                    return;
                }
                Activity activity = this.activity;
                String[] strArr = this.permissions;
                Integer num = this.requestCode;
                if (num == null) {
                    throw new IllegalStateException("Request code hasn't been set yet");
                }
                ActivityCompat.requestPermissions(activity, strArr, num.intValue());
                return;
            }
        }
        PermissionCallback permissionCallback = this.callback;
        String[] strArr2 = this.permissions;
        ArrayList arrayList = new ArrayList(strArr2.length);
        for (String str2 : strArr2) {
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
    }

    /* compiled from: ActivityPermissionRequest.kt */
    @Metadata(m108d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u001f\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0015\"\u00020\r¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0017"}, m107d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest$Builder;", "", "activity", "Landroid/app/Activity;", "requestCode", "", "(Landroid/app/Activity;I)V", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "permissions", "", "", "Ljava/lang/Integer;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "check", "", "withCallback", "withPermissions", "", "([Ljava/lang/String;)Lcom/anggrayudi/storage/permission/ActivityPermissionRequest$Builder;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final Activity activity;
        private PermissionCallback callback;
        private Set<String> permissions;
        private final Integer requestCode;

        public Builder(Activity activity, int i) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.permissions = SetsKt.emptySet();
            this.activity = activity;
            this.requestCode = Integer.valueOf(i);
        }

        public Builder(ComponentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.permissions = SetsKt.emptySet();
            this.activity = activity;
            this.requestCode = null;
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

        public final ActivityPermissionRequest build() {
            Activity activity = this.activity;
            Object[] array = this.permissions.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Integer num = this.requestCode;
            PermissionCallback permissionCallback = this.callback;
            Intrinsics.checkNotNull(permissionCallback);
            return new ActivityPermissionRequest(activity, (String[]) array, num, permissionCallback, null);
        }

        public final void check() {
            build().check();
        }
    }

    private final void onRequestPermissionsResult(Map<String, Boolean> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            arrayList.add(new PermissionReport(entry.getKey(), entry.getValue().booleanValue(), (entry.getValue().booleanValue() || ActivityCompat.shouldShowRequestPermissionRationale(this.activity, entry.getKey())) ? false : true));
        }
        reportResult(arrayList);
    }
}
