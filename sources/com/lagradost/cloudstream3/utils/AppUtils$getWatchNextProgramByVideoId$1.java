package com.lagradost.cloudstream3.utils;

import android.database.Cursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AppUtils.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m107d2 = {"<anonymous>", "", "cursor", "Landroid/database/Cursor;", "invoke", "(Landroid/database/Cursor;)Ljava/lang/Boolean;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
final class AppUtils$getWatchNextProgramByVideoId$1 extends Lambda implements Function1<Cursor, Boolean> {
    final /* synthetic */ String $id;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUtils$getWatchNextProgramByVideoId$1(String str) {
        super(1);
        this.$id = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        return Boolean.valueOf(Intrinsics.areEqual(cursor.getString(cursor.getColumnIndex("internal_provider_id")), this.$id));
    }
}
