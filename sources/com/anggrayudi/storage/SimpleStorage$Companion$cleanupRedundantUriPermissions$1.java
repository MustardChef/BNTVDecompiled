package com.anggrayudi.storage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriPermission;
import android.net.Uri;
import com.anggrayudi.storage.extension.UriExt;
import com.anggrayudi.storage.file.DocumentFileCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SimpleStorage.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class SimpleStorage$Companion$cleanupRedundantUriPermissions$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleStorage$Companion$cleanupRedundantUriPermissions$1(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ContentResolver contentResolver = this.$context.getContentResolver();
        List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
        Intrinsics.checkNotNullExpressionValue(persistedUriPermissions, "resolver.persistedUriPermissions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = persistedUriPermissions.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            UriPermission uriPermission = (UriPermission) next;
            if (uriPermission.isReadPermission() && uriPermission.isWritePermission()) {
                Uri uri = uriPermission.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "it.uri");
                if (UriExt.isExternalStorageDocument(uri)) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(next);
            }
        }
        ArrayList<UriPermission> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (UriPermission uriPermission2 : arrayList2) {
            arrayList3.add(uriPermission2.getUri());
        }
        Context context = this.$context;
        ArrayList<Uri> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList();
        Iterator it2 = arrayList4.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            String path = ((Uri) it2.next()).getPath();
            String substringAfter$default = path != null ? StringsKt.substringAfter$default(path, "/tree/", (String) null, 2, (Object) null) : null;
            if (substringAfter$default != null) {
                arrayList5.add(substringAfter$default);
            }
        }
        List<String> findUniqueParents = DocumentFileCompat.findUniqueParents(context, arrayList5);
        Context context2 = this.$context;
        for (Uri uri2 : arrayList4) {
            String path2 = uri2.getPath();
            if (path2 == null) {
                path2 = "";
            }
            if (!findUniqueParents.contains(DocumentFileCompat.buildAbsolutePath(context2, StringsKt.substringAfter$default(path2, "/tree/", (String) null, 2, (Object) null)))) {
                contentResolver.releasePersistableUriPermission(uri2, 3);
                Timber.m29d(Intrinsics.stringPlus("Removed redundant URI permission => ", uri2), new Object[0]);
            }
        }
    }
}
