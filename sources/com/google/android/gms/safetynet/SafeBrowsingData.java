package com.google.android.gms.safetynet;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzj();
    private static final String TAG = "SafeBrowsingData";
    private String zzm;
    private DataHolder zzn;
    private ParcelFileDescriptor zzo;
    private long zzp;
    private byte[] zzq;
    private byte[] zzr;
    private File zzs;

    public SafeBrowsingData() {
        this(null, null, null, 0L, null);
    }

    public SafeBrowsingData(long j, byte[] bArr) {
        this(null, null, null, j, bArr);
    }

    public SafeBrowsingData(String str) {
        this(str, null, null, 0L, null);
    }

    public SafeBrowsingData(String str, DataHolder dataHolder) {
        this(str, dataHolder, null, 0L, null);
    }

    public SafeBrowsingData(String str, DataHolder dataHolder, ParcelFileDescriptor parcelFileDescriptor, long j, byte[] bArr) {
        this.zzm = str;
        this.zzn = dataHolder;
        this.zzo = parcelFileDescriptor;
        this.zzp = j;
        this.zzq = bArr;
    }

    private final FileOutputStream zza() {
        Throwable th;
        File file;
        File file2 = this.zzs;
        if (file2 == null) {
            return null;
        }
        try {
            file = File.createTempFile("xlb", ".tmp", file2);
        } catch (IOException unused) {
            file = null;
        } catch (Throwable th2) {
            th = th2;
            file = null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.zzo = ParcelFileDescriptor.open(file, 268435456);
            if (file != null) {
                file.delete();
            }
            return fileOutputStream;
        } catch (IOException unused2) {
            if (file != null) {
                file.delete();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (file != null) {
                file.delete();
            }
            throw th;
        }
    }

    private static void zza(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public byte[] getBlacklists() {
        if (this.zzo == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzo));
        try {
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.read(bArr);
            return bArr;
        } catch (IOException unused) {
            return null;
        } finally {
            zza(dataInputStream);
            this.zzo = null;
        }
    }

    public DataHolder getBlacklistsDataHolder() {
        return this.zzn;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.zzo;
    }

    public long getLastUpdateTimeMs() {
        return this.zzp;
    }

    public String getMetadata() {
        return this.zzm;
    }

    public byte[] getState() {
        return this.zzq;
    }

    public void setBlacklists(byte[] bArr) {
        this.zzr = bArr;
    }

    public void setTempDir(File file) {
        if (file != null) {
            this.zzs = file;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeToParcel(android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            android.os.ParcelFileDescriptor r0 = r3.zzo
            r1 = 1
            if (r0 != 0) goto L31
            byte[] r0 = r3.zzr
            if (r0 == 0) goto L31
            java.io.FileOutputStream r0 = r3.zza()
            if (r0 == 0) goto L31
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream
            r2.<init>(r0)
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            r0.<init>(r2)
            byte[] r2 = r3.zzr     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            int r2 = r2.length     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            r0.writeInt(r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            byte[] r2 = r3.zzr     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            r0.write(r2)     // Catch: java.lang.Throwable -> L29 java.io.IOException -> L2e
            zza(r0)
            r0 = 1
            goto L32
        L29:
            r4 = move-exception
            zza(r0)
            throw r4
        L2e:
            zza(r0)
        L31:
            r0 = 0
        L32:
            if (r0 != 0) goto L35
            goto L36
        L35:
            r5 = r5 | r1
        L36:
            com.google.android.gms.safetynet.zzj.zza(r3, r4, r5)
            r4 = 0
            r3.zzo = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.safetynet.SafeBrowsingData.writeToParcel(android.os.Parcel, int):void");
    }
}
