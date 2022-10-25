package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.internal.p038firebaseauthapi.zzzk;
import com.google.android.gms.internal.p038firebaseauthapi.zzzo;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzk */
/* loaded from: classes3.dex */
public class zzzk<MessageType extends zzzo<MessageType, BuilderType>, BuilderType extends zzzk<MessageType, BuilderType>> extends zzxt<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzzk(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (MessageType) messagetype.zzj(4, null, null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzaaz.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxt
    protected final /* bridge */ /* synthetic */ zzxt zzg(zzxu zzxuVar) {
        zzm((zzzo) zzxuVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzi() {
        MessageType messagetype = (MessageType) this.zza.zzj(4, null, null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzxt
    /* renamed from: zzj */
    public final BuilderType zzf() {
        BuilderType buildertype = (BuilderType) this.zzc.zzj(5, null, null);
        buildertype.zzm(zzn());
        return buildertype;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaaq
    /* renamed from: zzk */
    public MessageType zzn() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzaaz.zza().zzb(messagetype.getClass()).zzj(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzl() {
        MessageType zzn = zzn();
        if (zzn.zzt()) {
            return zzn;
        }
        throw new zzabq(zzn);
    }

    public final BuilderType zzm(MessageType messagetype) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzaas
    public final /* bridge */ /* synthetic */ zzaar zzo() {
        return this.zzc;
    }
}
