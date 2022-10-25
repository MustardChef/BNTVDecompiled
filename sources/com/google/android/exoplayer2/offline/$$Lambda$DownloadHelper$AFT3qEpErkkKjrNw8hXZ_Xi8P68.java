package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;

/* compiled from: lambda */
/* renamed from: com.google.android.exoplayer2.offline.-$$Lambda$DownloadHelper$AFT3qEpErkkKjrNw8hXZ_Xi8P68  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$DownloadHelper$AFT3qEpErkkKjrNw8hXZ_Xi8P68 implements MetadataOutput {
    public static final /* synthetic */ $$Lambda$DownloadHelper$AFT3qEpErkkKjrNw8hXZ_Xi8P68 INSTANCE = new $$Lambda$DownloadHelper$AFT3qEpErkkKjrNw8hXZ_Xi8P68();

    private /* synthetic */ $$Lambda$DownloadHelper$AFT3qEpErkkKjrNw8hXZ_Xi8P68() {
    }

    @Override // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata) {
        DownloadHelper.lambda$getRendererCapabilities$1(metadata);
    }
}
