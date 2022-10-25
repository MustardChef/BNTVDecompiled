package com.anggrayudi.storage.file;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: StorageType.kt */
@Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, m107d2 = {"Lcom/anggrayudi/storage/file/StorageType;", "", "(Ljava/lang/String;I)V", "isExpected", "", "actualStorageType", "EXTERNAL", "DATA", "SD_CARD", "UNKNOWN", "Companion", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public enum StorageType {
    EXTERNAL,
    DATA,
    SD_CARD,
    UNKNOWN;
    
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final StorageType fromStorageId(String str) {
        return Companion.fromStorageId(str);
    }

    public final boolean isExpected(StorageType actualStorageType) {
        Intrinsics.checkNotNullParameter(actualStorageType, "actualStorageType");
        return this == UNKNOWN || this == actualStorageType;
    }

    /* compiled from: StorageType.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, m107d2 = {"Lcom/anggrayudi/storage/file/StorageType$Companion;", "", "()V", "fromStorageId", "Lcom/anggrayudi/storage/file/StorageType;", "storageId", "", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final StorageType fromStorageId(String storageId) {
            Intrinsics.checkNotNullParameter(storageId, "storageId");
            if (Intrinsics.areEqual(storageId, StorageId.PRIMARY)) {
                return StorageType.EXTERNAL;
            }
            if (Intrinsics.areEqual(storageId, "data")) {
                return StorageType.DATA;
            }
            return new Regex("[A-Z0-9]{4}-[A-Z0-9]{4}").matches(storageId) ? StorageType.SD_CARD : StorageType.UNKNOWN;
        }
    }
}
