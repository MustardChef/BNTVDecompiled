package com.hippo.unifile;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes3.dex */
final class ResourcesContract {

    /* loaded from: classes3.dex */
    public static class OpenResourceResult {

        /* renamed from: id */
        public int f9888id;
        public String name;

        /* renamed from: p */
        public String f9889p;

        /* renamed from: r */
        public Resources f9890r;
    }

    private ResourcesContract() {
    }

    public static OpenResourceResult openResource(Context context, Uri uri) {
        int parseInt;
        String resourceEntryName;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                return null;
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                    resourceEntryName = resourcesForApplication.getResourceEntryName(parseInt);
                } catch (Resources.NotFoundException | NumberFormatException unused) {
                    return null;
                }
            } else if (size != 2) {
                return null;
            } else {
                resourceEntryName = pathSegments.get(1);
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt == 0 || resourceEntryName == null) {
                return null;
            }
            OpenResourceResult openResourceResult = new OpenResourceResult();
            openResourceResult.f9890r = resourcesForApplication;
            openResourceResult.f9889p = authority;
            openResourceResult.f9888id = parseInt;
            openResourceResult.name = resourceEntryName;
            return openResourceResult;
        } catch (PackageManager.NameNotFoundException unused2) {
            return null;
        }
    }
}
