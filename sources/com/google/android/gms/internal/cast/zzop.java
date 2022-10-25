package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzop;
import com.google.android.gms.internal.cast.zzos;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public class zzop<MessageType extends zzos<MessageType, BuilderType>, BuilderType extends zzop<MessageType, BuilderType>> extends zznl<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzop(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (MessageType) messagetype.zzb(4, null, null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzqg.zza().zzb(messagetype.getClass()).zzc(messagetype, messagetype2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zznl
    protected final /* bridge */ /* synthetic */ zznl zzk(zznm zznmVar) {
        zzq((zzos) zznmVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzm() {
        MessageType messagetype = (MessageType) this.zza.zzb(4, null, null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.cast.zznl
    /* renamed from: zzn */
    public final BuilderType zzj() {
        BuilderType buildertype = (BuilderType) this.zzc.zzb(5, null, null);
        buildertype.zzq(zzr());
        return buildertype;
    }

    @Override // com.google.android.gms.internal.cast.zzpx
    /* renamed from: zzo */
    public MessageType zzr() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzqg.zza().zzb(messagetype.getClass()).zze(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final MessageType zzp() {
        MessageType zzr = zzr();
        Boolean bool = Boolean.TRUE;
        boolean z = true;
        byte byteValue = ((Byte) zzr.zzb(1, null, null)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z = false;
            } else {
                boolean zzf = zzqg.zza().zzb(zzr.getClass()).zzf(zzr);
                zzr.zzb(2, true != zzf ? null : zzr, null);
                z = zzf;
            }
        }
        if (z) {
            return zzr;
        }
        throw new zzqw(zzr);
    }

    public final BuilderType zzq(MessageType messagetype) {
        if (this.zzb) {
            zzm();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    @Override // com.google.android.gms.internal.cast.zzpz
    public final /* bridge */ /* synthetic */ zzpy zzs() {
        return this.zzc;
    }
}
