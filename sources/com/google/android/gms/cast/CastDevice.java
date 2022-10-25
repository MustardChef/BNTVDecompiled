package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_MULTIZONE_GROUP = 32;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzr();
    String zza;
    private String zzb;
    private InetAddress zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private int zzg;
    private List<WebImage> zzh;
    private int zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private int zzm;
    private final String zzn;
    private byte[] zzo;
    private final String zzp;
    private final boolean zzq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CastDevice(String str, String str2, String str3, String str4, String str5, int i, List<WebImage> list, int i2, int i3, String str6, String str7, int i4, String str8, byte[] bArr, String str9, boolean z) {
        this.zzb = zzc(str);
        String zzc = zzc(str2);
        this.zza = zzc;
        if (!TextUtils.isEmpty(zzc)) {
            try {
                this.zzc = InetAddress.getByName(this.zza);
            } catch (UnknownHostException e) {
                String str10 = this.zza;
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(str10).length() + 48 + String.valueOf(message).length());
                sb.append("Unable to convert host address (");
                sb.append(str10);
                sb.append(") to ipaddress: ");
                sb.append(message);
                Log.i("CastDevice", sb.toString());
            }
        }
        this.zzd = zzc(str3);
        this.zze = zzc(str4);
        this.zzf = zzc(str5);
        this.zzg = i;
        this.zzh = list != null ? list : new ArrayList<>();
        this.zzi = i2;
        this.zzj = i3;
        this.zzk = zzc(str6);
        this.zzl = str7;
        this.zzm = i4;
        this.zzn = str8;
        this.zzo = bArr;
        this.zzp = str9;
        this.zzq = z;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    private static String zzc(String str) {
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CastDevice) {
            CastDevice castDevice = (CastDevice) obj;
            String str = this.zzb;
            return str == null ? castDevice.zzb == null : CastUtils.zza(str, castDevice.zzb) && CastUtils.zza(this.zzc, castDevice.zzc) && CastUtils.zza(this.zze, castDevice.zze) && CastUtils.zza(this.zzd, castDevice.zzd) && CastUtils.zza(this.zzf, castDevice.zzf) && this.zzg == castDevice.zzg && CastUtils.zza(this.zzh, castDevice.zzh) && this.zzi == castDevice.zzi && this.zzj == castDevice.zzj && CastUtils.zza(this.zzk, castDevice.zzk) && CastUtils.zza(Integer.valueOf(this.zzm), Integer.valueOf(castDevice.zzm)) && CastUtils.zza(this.zzn, castDevice.zzn) && CastUtils.zza(this.zzl, castDevice.zzl) && CastUtils.zza(this.zzf, castDevice.getDeviceVersion()) && this.zzg == castDevice.getServicePort() && (((bArr = this.zzo) == null && castDevice.zzo == null) || Arrays.equals(bArr, castDevice.zzo)) && CastUtils.zza(this.zzp, castDevice.zzp) && this.zzq == castDevice.zzq;
        }
        return false;
    }

    public String getDeviceId() {
        return this.zzb.startsWith("__cast_nearby__") ? this.zzb.substring(16) : this.zzb;
    }

    public String getDeviceVersion() {
        return this.zzf;
    }

    public String getFriendlyName() {
        return this.zzd;
    }

    public WebImage getIcon(int i, int i2) {
        WebImage webImage = null;
        if (this.zzh.isEmpty()) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return this.zzh.get(0);
        }
        WebImage webImage2 = null;
        for (WebImage webImage3 : this.zzh) {
            int width = webImage3.getWidth();
            int height = webImage3.getHeight();
            if (width < i || height < i2) {
                if (width < i && height < i2 && (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height))) {
                    webImage2 = webImage3;
                }
            } else if (webImage == null || (webImage.getWidth() > width && webImage.getHeight() > height)) {
                webImage = webImage3;
            }
        }
        return webImage != null ? webImage : webImage2 != null ? webImage2 : this.zzh.get(0);
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzh);
    }

    public InetAddress getInetAddress() {
        return this.zzc;
    }

    @Deprecated
    public Inet4Address getIpAddress() {
        if (hasIPv4Address()) {
            return (Inet4Address) this.zzc;
        }
        return null;
    }

    public String getModelName() {
        return this.zze;
    }

    public int getServicePort() {
        return this.zzg;
    }

    public boolean hasCapabilities(int[] iArr) {
        if (iArr == null) {
            return false;
        }
        for (int i : iArr) {
            if (!hasCapability(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int i) {
        return (this.zzi & i) == i;
    }

    public boolean hasIPv4Address() {
        return getInetAddress() != null && (getInetAddress() instanceof Inet4Address);
    }

    public boolean hasIPv6Address() {
        return getInetAddress() != null && (getInetAddress() instanceof Inet6Address);
    }

    public boolean hasIcons() {
        return !this.zzh.isEmpty();
    }

    public int hashCode() {
        String str = this.zzb;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return (this.zzb.startsWith("__cast_nearby__") || this.zzq) ? false : true;
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (TextUtils.isEmpty(getDeviceId()) || getDeviceId().startsWith("__cast_ble__") || TextUtils.isEmpty(castDevice.getDeviceId()) || castDevice.getDeviceId().startsWith("__cast_ble__")) {
            if (TextUtils.isEmpty(this.zzn) || TextUtils.isEmpty(castDevice.zzn)) {
                return false;
            }
            return CastUtils.zza(this.zzn, castDevice.zzn);
        }
        return CastUtils.zza(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public String toString() {
        return String.format("\"%s\" (%s)", this.zzd, this.zzb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zza, false);
        SafeParcelWriter.writeString(parcel, 4, getFriendlyName(), false);
        SafeParcelWriter.writeString(parcel, 5, getModelName(), false);
        SafeParcelWriter.writeString(parcel, 6, getDeviceVersion(), false);
        SafeParcelWriter.writeInt(parcel, 7, getServicePort());
        SafeParcelWriter.writeTypedList(parcel, 8, getIcons(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeInt(parcel, 10, this.zzj);
        SafeParcelWriter.writeString(parcel, 11, this.zzk, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeByteArray(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzp, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zzl;
    }

    public final int zzb() {
        return this.zzi;
    }
}
