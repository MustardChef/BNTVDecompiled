package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzaf extends zzki {
    private static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    private static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzag zzj;
    private final zzke zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(zzkl zzklVar) {
        super(zzklVar);
        this.zzk = new zzke(zzl());
        this.zzj = new zzag(this, zzm(), "google_app_measurement.db");
    }

    @Override // com.google.android.gms.measurement.internal.zzki
    protected final boolean zzd() {
        return false;
    }

    public final void zze() {
        zzaj();
        m334c_().beginTransaction();
    }

    /* renamed from: b_ */
    public final void m335b_() {
        zzaj();
        m334c_().setTransactionSuccessful();
    }

    public final void zzg() {
        zzaj();
        m334c_().endTransaction();
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = m334c_().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzq().zze().zza("Database error", str, e);
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = m334c_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzq().zze().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            try {
                cursor = m334c_().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getString(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return str2;
            } catch (SQLiteException e) {
                zzq().zze().zza("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c_ */
    public final SQLiteDatabase m334c_() {
        zzc();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzq().zzh().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x014c: MOVE  (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:66:0x014c */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0147  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzam zza(java.lang.String r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzam");
    }

    public final void zza(zzam zzamVar) {
        Preconditions.checkNotNull(zzamVar);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzamVar.zza);
        contentValues.put("name", zzamVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzamVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzamVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzamVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzamVar.zzg));
        contentValues.put("last_bundled_day", zzamVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzamVar.zzi);
        contentValues.put("last_sampling_rate", zzamVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzamVar.zze));
        contentValues.put("last_exempt_from_sampling", (zzamVar.zzk == null || !zzamVar.zzk.booleanValue()) ? null : 1L);
        try {
            if (m334c_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update event aggregates (got -1). appId", zzeq.zza(zzamVar.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event aggregates. appId", zzeq.zza(zzamVar.zza), e);
        }
    }

    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            m334c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting user property. appId", zzeq.zza(str), zzn().zzc(str2), e);
        }
    }

    public final boolean zza(zzkw zzkwVar) {
        Preconditions.checkNotNull(zzkwVar);
        zzc();
        zzaj();
        if (zzc(zzkwVar.zza, zzkwVar.zzc) == null) {
            if (zzkv.zza(zzkwVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzkwVar.zza}) >= zzs().zzd(zzkwVar.zza)) {
                    return false;
                }
            } else if (!"_npa".equals(zzkwVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzkwVar.zza, zzkwVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzkwVar.zza);
        contentValues.put("origin", zzkwVar.zzb);
        contentValues.put("name", zzkwVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzkwVar.zzd));
        zza(contentValues, "value", zzkwVar.zze);
        try {
            if (m334c_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update user property (got -1). appId", zzeq.zza(zzkwVar.zza));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing user property. appId", zzeq.zza(zzkwVar.zza), e);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzkw zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzc()
            r18.zzaj()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.m334c_()     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L7e android.database.sqlite.SQLiteException -> L82
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            if (r3 != 0) goto L3f
            if (r10 == 0) goto L3e
            r10.close()
        L3e:
            return r9
        L3f:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L76 android.database.sqlite.SQLiteException -> L7a
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            if (r1 == 0) goto L6e
            com.google.android.gms.measurement.internal.zzeq r1 = r18.zzq()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L74 java.lang.Throwable -> La5
        L6e:
            if (r10 == 0) goto L73
            r10.close()
        L73:
            return r0
        L74:
            r0 = move-exception
            goto L86
        L76:
            r0 = move-exception
            r11 = r18
            goto La6
        L7a:
            r0 = move-exception
            r11 = r18
            goto L86
        L7e:
            r0 = move-exception
            r11 = r18
            goto La7
        L82:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L86:
            com.google.android.gms.measurement.internal.zzeq r1 = r18.zzq()     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: java.lang.Throwable -> La5
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza(r19)     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.measurement.internal.zzeo r4 = r18.zzn()     // Catch: java.lang.Throwable -> La5
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> La5
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La5
            if (r10 == 0) goto La4
            r10.close()
        La4:
            return r9
        La5:
            r0 = move-exception
        La6:
            r9 = r10
        La7:
            if (r9 == 0) goto Lac
            r9.close()
        Lac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzkw");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkw> zza(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzc()
            r13.zzaj()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.m334c_()     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            r12 = 0
            r6[r12] = r14     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L82 android.database.sqlite.SQLiteException -> L84
            boolean r3 = r2.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            if (r3 != 0) goto L3f
            if (r2 == 0) goto L3e
            r2.close()
        L3e:
            return r0
        L3f:
            java.lang.String r7 = r2.getString(r12)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            java.lang.String r3 = r2.getString(r11)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            if (r3 != 0) goto L4b
            java.lang.String r3 = ""
        L4b:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            r3 = 3
            java.lang.Object r10 = r13.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            if (r10 != 0) goto L6a
            com.google.android.gms.measurement.internal.zzeq r3 = r13.zzq()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza(r14)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            goto L74
        L6a:
            com.google.android.gms.measurement.internal.zzkw r3 = new com.google.android.gms.measurement.internal.zzkw     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            r0.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
        L74:
            boolean r3 = r2.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L80 java.lang.Throwable -> Lb9
            if (r3 != 0) goto L3f
            if (r2 == 0) goto L7f
            r2.close()
        L7f:
            return r0
        L80:
            r0 = move-exception
            goto L86
        L82:
            r14 = move-exception
            goto Lbb
        L84:
            r0 = move-exception
            r2 = r1
        L86:
            com.google.android.gms.measurement.internal.zzeq r3 = r13.zzq()     // Catch: java.lang.Throwable -> Lb9
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza(r14)     // Catch: java.lang.Throwable -> Lb9
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> Lb9
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: java.lang.Throwable -> Lb9
            if (r0 == 0) goto Lb3
            com.google.android.gms.measurement.internal.zzab r0 = r13.zzs()     // Catch: java.lang.Throwable -> Lb9
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: java.lang.Throwable -> Lb9
            boolean r14 = r0.zze(r14, r3)     // Catch: java.lang.Throwable -> Lb9
            if (r14 == 0) goto Lb3
            java.util.List r14 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto Lb2
            r2.close()
        Lb2:
            return r14
        Lb3:
            if (r2 == 0) goto Lb8
            r2.close()
        Lb8:
            return r1
        Lb9:
            r14 = move-exception
            r1 = r2
        Lbb:
            if (r1 == 0) goto Lc0
            r1.close()
        Lc0:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
        zzq().zze().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzkw> zza(java.lang.String r21, java.lang.String r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean zza(zzz zzzVar) {
        Preconditions.checkNotNull(zzzVar);
        zzc();
        zzaj();
        if (zzc(zzzVar.zza, zzzVar.zzc.zza) != null || zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzzVar.zza}) < 1000) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzzVar.zza);
            contentValues.put("origin", zzzVar.zzb);
            contentValues.put("name", zzzVar.zzc.zza);
            zza(contentValues, "value", zzzVar.zzc.zza());
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzzVar.zze));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzzVar.zzf);
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzzVar.zzh));
            zzo();
            contentValues.put("timed_out_event", zzkv.zza((Parcelable) zzzVar.zzg));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzzVar.zzd));
            zzo();
            contentValues.put("triggered_event", zzkv.zza((Parcelable) zzzVar.zzi));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzzVar.zzc.zzb));
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzzVar.zzj));
            zzo();
            contentValues.put("expired_event", zzkv.zza((Parcelable) zzzVar.zzk));
            try {
                if (m334c_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                    zzq().zze().zza("Failed to insert/update conditional user property (got -1)", zzeq.zza(zzzVar.zza));
                }
            } catch (SQLiteException e) {
                zzq().zze().zza("Error storing conditional user property", zzeq.zza(zzzVar.zza), e);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzz zzd(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzz");
    }

    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        try {
            return m334c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting conditional property", zzeq.zza(str), zzn().zzc(str2), e);
            return 0;
        }
    }

    public final List<zzz> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
        zzq().zze().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzz> zza(java.lang.String r25, java.lang.String[] r26) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x011f A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0159 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0187 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a4 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b3 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01cb A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e9 A[Catch: SQLiteException -> 0x0200, all -> 0x0229, TRY_LEAVE, TryCatch #2 {SQLiteException -> 0x0200, blocks: (B:11:0x006f, B:13:0x00d0, B:18:0x00da, B:22:0x0124, B:24:0x0159, B:28:0x0167, B:27:0x0163, B:29:0x016a, B:31:0x0172, B:36:0x017c, B:38:0x0187, B:42:0x018f, B:46:0x01a8, B:48:0x01b3, B:49:0x01c5, B:51:0x01cb, B:53:0x01d7, B:54:0x01e0, B:56:0x01e9, B:45:0x01a4, B:21:0x011f), top: B:79:0x006f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x022d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 561
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    public final void zza(zzf zzfVar) {
        Preconditions.checkNotNull(zzfVar);
        zzc();
        zzaj();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzfVar.zzc());
        contentValues.put("app_instance_id", zzfVar.zzd());
        contentValues.put("gmp_app_id", zzfVar.zze());
        contentValues.put("resettable_device_id_hash", zzfVar.zzh());
        contentValues.put("last_bundle_index", Long.valueOf(zzfVar.zzs()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzfVar.zzj()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzfVar.zzk()));
        contentValues.put("app_version", zzfVar.zzl());
        contentValues.put("app_store", zzfVar.zzn());
        contentValues.put("gmp_version", Long.valueOf(zzfVar.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzfVar.zzp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzfVar.zzr()));
        contentValues.put("day", Long.valueOf(zzfVar.zzw()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzfVar.zzx()));
        contentValues.put("daily_events_count", Long.valueOf(zzfVar.zzy()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzfVar.zzz()));
        contentValues.put("config_fetched_time", Long.valueOf(zzfVar.zzt()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzfVar.zzu()));
        contentValues.put("app_version_int", Long.valueOf(zzfVar.zzm()));
        contentValues.put("firebase_instance_id", zzfVar.zzi());
        contentValues.put("daily_error_events_count", Long.valueOf(zzfVar.zzab()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzfVar.zzaa()));
        contentValues.put("health_monitor_sample", zzfVar.zzac());
        contentValues.put("android_id", Long.valueOf(zzfVar.zzae()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzfVar.zzaf()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzfVar.zzag()));
        contentValues.put("admob_app_id", zzfVar.zzf());
        contentValues.put("dynamite_version", Long.valueOf(zzfVar.zzq()));
        if (zzfVar.zzai() != null) {
            if (zzfVar.zzai().size() == 0) {
                zzq().zzh().zza("Safelisted events should not be an empty list. appId", zzfVar.zzc());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzfVar.zzai()));
            }
        }
        if (zznv.zzb() && zzs().zze(zzfVar.zzc(), zzas.zzbi)) {
            contentValues.put("ga_app_id", zzfVar.zzg());
        }
        try {
            SQLiteDatabase m334c_ = m334c_();
            if (m334c_.update("apps", contentValues, "app_id = ?", new String[]{zzfVar.zzc()}) == 0 && m334c_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert/update app (got -1). appId", zzeq.zza(zzfVar.zzc()));
            }
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing app. appId", zzeq.zza(zzfVar.zzc()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        try {
            return m334c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzs().zzb(str, zzas.zzo))))});
        } catch (SQLiteException e) {
            zzq().zze().zza("Error deleting over the limit events. appId", zzeq.zza(str), e);
            return 0L;
        }
    }

    public final zzae zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1L, false, false, z3, false, z5);
    }

    public final zzae zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzc();
        zzaj();
        String[] strArr = {str};
        zzae zzaeVar = new zzae();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase m334c_ = m334c_();
                Cursor query = m334c_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    zzq().zzh().zza("Not updating daily counts, app is not known. appId", zzeq.zza(str));
                    if (query != null) {
                        query.close();
                    }
                    return zzaeVar;
                }
                if (query.getLong(0) == j) {
                    zzaeVar.zzb = query.getLong(1);
                    zzaeVar.zza = query.getLong(2);
                    zzaeVar.zzc = query.getLong(3);
                    zzaeVar.zzd = query.getLong(4);
                    zzaeVar.zze = query.getLong(5);
                }
                if (z) {
                    zzaeVar.zzb += j2;
                }
                if (z2) {
                    zzaeVar.zza += j2;
                }
                if (z3) {
                    zzaeVar.zzc += j2;
                }
                if (z4) {
                    zzaeVar.zzd += j2;
                }
                if (z5) {
                    zzaeVar.zze += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaeVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzaeVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaeVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaeVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaeVar.zze));
                m334c_.update("apps", contentValues, "app_id=?", strArr);
                if (query != null) {
                    query.close();
                }
                return zzaeVar;
            } catch (SQLiteException e) {
                zzq().zze().zza("Error updating daily counts. appId", zzeq.zza(str), e);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaeVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] zzd(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r10.zzc()
            r10.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.m334c_()     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r9 = 0
            r5[r9] = r11     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L54 android.database.sqlite.SQLiteException -> L56
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            if (r2 != 0) goto L31
            if (r1 == 0) goto L30
            r1.close()
        L30:
            return r0
        L31:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            if (r3 == 0) goto L4c
            com.google.android.gms.measurement.internal.zzeq r3 = r10.zzq()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza(r11)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L52 java.lang.Throwable -> L6f
        L4c:
            if (r1 == 0) goto L51
            r1.close()
        L51:
            return r2
        L52:
            r2 = move-exception
            goto L58
        L54:
            r11 = move-exception
            goto L71
        L56:
            r2 = move-exception
            r1 = r0
        L58:
            com.google.android.gms.measurement.internal.zzeq r3 = r10.zzq()     // Catch: java.lang.Throwable -> L6f
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: java.lang.Throwable -> L6f
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeq.zza(r11)     // Catch: java.lang.Throwable -> L6f
            r3.zza(r4, r11, r2)     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto L6e
            r1.close()
        L6e:
            return r0
        L6f:
            r11 = move-exception
            r0 = r1
        L71:
            if (r0 == 0) goto L76
            r0.close()
        L76:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzd(java.lang.String):byte[]");
    }

    public final boolean zza(zzcd.zzg zzgVar, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        Preconditions.checkState(zzgVar.zzk());
        zzu();
        long currentTimeMillis = zzl().currentTimeMillis();
        if (zzgVar.zzl() < currentTimeMillis - zzab.zzu() || zzgVar.zzl() > zzab.zzu() + currentTimeMillis) {
            zzq().zzh().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeq.zza(zzgVar.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzgVar.zzl()));
        }
        try {
            byte[] zzc2 = mo331f_().zzc(zzgVar.zzbk());
            zzq().zzw().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzba()));
            }
            try {
                if (m334c_().insert("queue", null, contentValues) == -1) {
                    zzq().zze().zza("Failed to insert bundle (got -1). appId", zzeq.zza(zzgVar.zzx()));
                    return false;
                }
                return true;
            } catch (SQLiteException e) {
                zzq().zze().zza("Error storing bundle. appId", zzeq.zza(zzgVar.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzq().zze().zza("Data loss. Failed to serialize bundle. appId", zzeq.zza(zzgVar.zzx()), e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* renamed from: d_ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m333d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.m334c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzeq r3 = r6.zzq()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.m333d_():java.lang.String");
    }

    /* renamed from: e_ */
    public final boolean m332e_() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final List<Pair<zzcd.zzg, Long>> zza(String str, int i, int i2) {
        byte[] zzb2;
        zzc();
        zzaj();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = m334c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i));
                if (!query.moveToFirst()) {
                    List<Pair<zzcd.zzg, Long>> emptyList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                do {
                    long j = query.getLong(0);
                    try {
                        zzb2 = mo331f_().zzb(query.getBlob(1));
                    } catch (IOException e) {
                        zzq().zze().zza("Failed to unzip queued bundle. appId", zzeq.zza(str), e);
                    }
                    if (!arrayList.isEmpty() && zzb2.length + i3 > i2) {
                        break;
                    }
                    try {
                        zzcd.zzg.zza zzaVar = (zzcd.zzg.zza) zzkr.zza(zzcd.zzg.zzbh(), zzb2);
                        if (!query.isNull(2)) {
                            zzaVar.zzi(query.getInt(2));
                        }
                        i3 += zzb2.length;
                        arrayList.add(Pair.create((zzcd.zzg) ((com.google.android.gms.internal.measurement.zzhy) zzaVar.zzy()), Long.valueOf(j)));
                    } catch (IOException e2) {
                        zzq().zze().zza("Failed to merge queued bundle. appId", zzeq.zza(str), e2);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i3 <= i2);
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                zzq().zze().zza("Error querying bundles. appId", zzeq.zza(str), e3);
                List<Pair<zzcd.zzg, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzu() {
        int delete;
        zzc();
        zzaj();
        if (zzal()) {
            long zza = zzr().zzf.zza();
            long elapsedRealtime = zzl().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzas.zzx.zza(null).longValue()) {
                zzr().zzf.zza(elapsedRealtime);
                zzc();
                zzaj();
                if (!zzal() || (delete = m334c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzl().currentTimeMillis()), String.valueOf(zzab.zzu())})) <= 0) {
                    return;
                }
                zzq().zzw().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzal()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzq().zzh().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase m334c_ = m334c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                m334c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzq().zze().zza("Error incrementing retry count. error", e);
            }
        }
    }

    private final boolean zza(String str, int i, zzbv.zzb zzbVar) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (TextUtils.isEmpty(zzbVar.zzc())) {
            zzq().zzh().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzeq.zza(str), Integer.valueOf(i), String.valueOf(zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] zzbk = zzbVar.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzbVar.zza() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzc());
        contentValues.put("session_scoped", zzbVar.zzj() ? Boolean.valueOf(zzbVar.zzk()) : null);
        contentValues.put("data", zzbk);
        try {
            if (m334c_().insertWithOnConflict("event_filters", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert event filter (got -1). appId", zzeq.zza(str));
                return true;
            }
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing event filter. appId", zzeq.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzbv.zze zzeVar) {
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (TextUtils.isEmpty(zzeVar.zzc())) {
            zzq().zzh().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzeq.zza(str), Integer.valueOf(i), String.valueOf(zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null));
            return false;
        }
        byte[] zzbk = zzeVar.zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzeVar.zza() ? Integer.valueOf(zzeVar.zzb()) : null);
        contentValues.put("property_name", zzeVar.zzc());
        contentValues.put("session_scoped", zzeVar.zzg() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", zzbk);
        try {
            if (m334c_().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert property filter (got -1). appId", zzeq.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing property filter. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzaj()
            r12.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.m334c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzbv$zzb$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzb.zzl()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzji r1 = com.google.android.gms.measurement.internal.zzkr.zza(r2, r1)     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzbv$zzb$zza r1 = (com.google.android.gms.internal.measurement.zzbv.zzb.zza) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzy()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzbv$zzb r1 = (com.google.android.gms.internal.measurement.zzbv.zzb) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r3 != 0) goto L74
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
        L74:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            goto L8a
        L78:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeq r2 = r12.zzq()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
        L8a:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r1 != 0) goto L42
            if (r14 == 0) goto L95
            r14.close()
        L95:
            return r0
        L96:
            r0 = move-exception
            goto L9c
        L98:
            r13 = move-exception
            goto Ld1
        L9a:
            r0 = move-exception
            r14 = r9
        L9c:
            com.google.android.gms.measurement.internal.zzeq r1 = r12.zzq()     // Catch: java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza(r13)     // Catch: java.lang.Throwable -> Lcf
            r1.zza(r2, r3, r0)     // Catch: java.lang.Throwable -> Lcf
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: java.lang.Throwable -> Lcf
            if (r0 == 0) goto Lc9
            com.google.android.gms.measurement.internal.zzab r0 = r12.zzs()     // Catch: java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: java.lang.Throwable -> Lcf
            boolean r13 = r0.zze(r13, r1)     // Catch: java.lang.Throwable -> Lcf
            if (r13 == 0) goto Lc9
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> Lcf
            if (r14 == 0) goto Lc8
            r14.close()
        Lc8:
            return r13
        Lc9:
            if (r14 == 0) goto Lce
            r14.close()
        Lce:
            return r9
        Lcf:
            r13 = move-exception
            r9 = r14
        Ld1:
            if (r9 == 0) goto Ld6
            r9.close()
        Ld6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<Integer, List<zzbv.zzb>> zze(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor query = m334c_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    Map<Integer, List<zzbv.zzb>> emptyMap = Collections.emptyMap();
                    if (query != null) {
                        query.close();
                    }
                    return emptyMap;
                }
                do {
                    try {
                        zzbv.zzb zzbVar = (zzbv.zzb) ((com.google.android.gms.internal.measurement.zzhy) ((zzbv.zzb.zza) zzkr.zza(zzbv.zzb.zzl(), query.getBlob(1))).zzy());
                        if (zzbVar.zzf()) {
                            int i = query.getInt(0);
                            List list = (List) arrayMap.get(Integer.valueOf(i));
                            if (list == null) {
                                list = new ArrayList();
                                arrayMap.put(Integer.valueOf(i), list);
                            }
                            list.add(zzbVar);
                        }
                    } catch (IOException e) {
                        zzq().zze().zza("Failed to merge filter. appId", zzeq.zza(str), e);
                    }
                } while (query.moveToNext());
                if (query != null) {
                    query.close();
                }
                return arrayMap;
            } catch (SQLiteException e2) {
                zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e2);
                Map<Integer, List<zzbv.zzb>> emptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbv.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzaj()
            r12.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.m334c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r10 = 0
            r5[r10] = r13     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r11 = 1
            r5[r11] = r14     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteException -> L9a
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r1 != 0) goto L42
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r14 == 0) goto L41
            r14.close()
        L41:
            return r13
        L42:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzbv$zze$zza r2 = com.google.android.gms.internal.measurement.zzbv.zze.zzi()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzji r1 = com.google.android.gms.measurement.internal.zzkr.zza(r2, r1)     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzbv$zze$zza r1 = (com.google.android.gms.internal.measurement.zzbv.zze.zza) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzjj r1 = r1.zzy()     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzhy r1 = (com.google.android.gms.internal.measurement.zzhy) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.internal.measurement.zzbv$zze r1 = (com.google.android.gms.internal.measurement.zzbv.zze) r1     // Catch: java.io.IOException -> L78 android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r3 != 0) goto L74
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
        L74:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            goto L8a
        L78:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzeq r2 = r12.zzq()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza(r13)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
        L8a:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L96 java.lang.Throwable -> Lcf
            if (r1 != 0) goto L42
            if (r14 == 0) goto L95
            r14.close()
        L95:
            return r0
        L96:
            r0 = move-exception
            goto L9c
        L98:
            r13 = move-exception
            goto Ld1
        L9a:
            r0 = move-exception
            r14 = r9
        L9c:
            com.google.android.gms.measurement.internal.zzeq r1 = r12.zzq()     // Catch: java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeq.zza(r13)     // Catch: java.lang.Throwable -> Lcf
            r1.zza(r2, r3, r0)     // Catch: java.lang.Throwable -> Lcf
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: java.lang.Throwable -> Lcf
            if (r0 == 0) goto Lc9
            com.google.android.gms.measurement.internal.zzab r0 = r12.zzs()     // Catch: java.lang.Throwable -> Lcf
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: java.lang.Throwable -> Lcf
            boolean r13 = r0.zze(r13, r1)     // Catch: java.lang.Throwable -> Lcf
            if (r13 == 0) goto Lc9
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> Lcf
            if (r14 == 0) goto Lc8
            r14.close()
        Lc8:
            return r13
        Lc9:
            if (r14 == 0) goto Lce
            r14.close()
        Lce:
            return r9
        Lcf:
            r13 = move-exception
            r9 = r14
        Ld1:
            if (r9 == 0) goto Ld6
            r9.close()
        Ld6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zzf(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzaj()
            r7.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.m334c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L69
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L9e
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6b
        L67:
            r8 = move-exception
            goto La0
        L69:
            r0 = move-exception
            r1 = r2
        L6b:
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch: java.lang.Throwable -> L9e
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeq.zza(r8)     // Catch: java.lang.Throwable -> L9e
            r3.zza(r4, r5, r0)     // Catch: java.lang.Throwable -> L9e
            boolean r0 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto L98
            com.google.android.gms.measurement.internal.zzab r0 = r7.zzs()     // Catch: java.lang.Throwable -> L9e
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: java.lang.Throwable -> L9e
            boolean r8 = r0.zze(r8, r3)     // Catch: java.lang.Throwable -> L9e
            if (r8 == 0) goto L98
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> L9e
            if (r1 == 0) goto L97
            r1.close()
        L97:
            return r8
        L98:
            if (r1 == 0) goto L9d
            r1.close()
        L9d:
            return r2
        L9e:
            r8 = move-exception
            r2 = r1
        La0:
            if (r2 == 0) goto La5
            r2.close()
        La5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzf(java.lang.String):java.util.Map");
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzaj();
        zzc();
        SQLiteDatabase m334c_ = m334c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzs().zzb(str, zzas.zzae)));
            if (zzb2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return m334c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzq().zze().zza("Database error querying filters. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d5  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzcd.zzi> zzg(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzaj()
            r11.zzc()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.m334c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteException -> L9c
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteException -> L9c
            r10 = 0
            r4[r10] = r12     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteException -> L9c
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9a android.database.sqlite.SQLiteException -> L9c
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            if (r1 != 0) goto L4f
            boolean r1 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            if (r1 == 0) goto L49
            com.google.android.gms.measurement.internal.zzab r1 = r11.zzs()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            boolean r1 = r1.zze(r12, r2)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            if (r1 == 0) goto L49
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            if (r0 == 0) goto L48
            r0.close()
        L48:
            return r12
        L49:
            if (r0 == 0) goto L4e
            r0.close()
        L4e:
            return r8
        L4f:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
        L54:
            int r2 = r0.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            byte[] r3 = r0.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzi.zzi()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.internal.measurement.zzji r3 = com.google.android.gms.measurement.internal.zzkr.zza(r4, r3)     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.internal.measurement.zzcd$zzi$zza r3 = (com.google.android.gms.internal.measurement.zzcd.zzi.zza) r3     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.internal.measurement.zzjj r3 = r3.zzy()     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.internal.measurement.zzhy r3 = (com.google.android.gms.internal.measurement.zzhy) r3     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.internal.measurement.zzcd$zzi r3 = (com.google.android.gms.internal.measurement.zzcd.zzi) r3     // Catch: java.io.IOException -> L76 android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            goto L8c
        L76:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzeq r4 = r11.zzq()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            com.google.android.gms.measurement.internal.zzes r4 = r4.zze()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeq.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            r4.zza(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
        L8c:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L98 java.lang.Throwable -> Ld1
            if (r2 != 0) goto L54
            if (r0 == 0) goto L97
            r0.close()
        L97:
            return r1
        L98:
            r1 = move-exception
            goto L9e
        L9a:
            r12 = move-exception
            goto Ld3
        L9c:
            r1 = move-exception
            r0 = r8
        L9e:
            com.google.android.gms.measurement.internal.zzeq r2 = r11.zzq()     // Catch: java.lang.Throwable -> Ld1
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeq.zza(r12)     // Catch: java.lang.Throwable -> Ld1
            r2.zza(r3, r4, r1)     // Catch: java.lang.Throwable -> Ld1
            boolean r1 = com.google.android.gms.internal.measurement.zznd.zzb()     // Catch: java.lang.Throwable -> Ld1
            if (r1 == 0) goto Lcb
            com.google.android.gms.measurement.internal.zzab r1 = r11.zzs()     // Catch: java.lang.Throwable -> Ld1
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzas.zzce     // Catch: java.lang.Throwable -> Ld1
            boolean r12 = r1.zze(r12, r2)     // Catch: java.lang.Throwable -> Ld1
            if (r12 == 0) goto Lcb
            java.util.Map r12 = java.util.Collections.emptyMap()     // Catch: java.lang.Throwable -> Ld1
            if (r0 == 0) goto Lca
            r0.close()
        Lca:
            return r12
        Lcb:
            if (r0 == 0) goto Ld0
            r0.close()
        Ld0:
            return r8
        Ld1:
            r12 = move-exception
            r8 = r0
        Ld3:
            if (r8 == 0) goto Ld8
            r8.close()
        Ld8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzg(java.lang.String):java.util.Map");
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzq().zze().zza("Loaded invalid null value from database");
            return null;
        } else if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type == 4) {
                        zzq().zze().zza("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    zzq().zze().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                    return null;
                }
                return cursor.getString(i);
            }
            return Double.valueOf(cursor.getDouble(i));
        } else {
            return Long.valueOf(cursor.getLong(i));
        }
    }

    public final long zzv() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzaj();
        SQLiteDatabase m334c_ = m334c_();
        m334c_.beginTransaction();
        long j = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    long zza = zza(sb.toString(), new String[]{str}, -1L);
                    if (zza == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (m334c_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            zzq().zze().zza("Failed to insert column (got -1). appId", zzeq.zza(str), str2);
                            m334c_.endTransaction();
                            return -1L;
                        }
                        zza = 0;
                    }
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", str);
                        contentValues2.put(str2, Long.valueOf(1 + zza));
                        if (m334c_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                            zzq().zze().zza("Failed to update column (got 0). appId", zzeq.zza(str), str2);
                            m334c_.endTransaction();
                            return -1L;
                        }
                        m334c_.setTransactionSuccessful();
                        m334c_.endTransaction();
                        return zza;
                    } catch (SQLiteException e) {
                        e = e;
                        j = zza;
                        zzq().zze().zza("Error inserting column. appId", zzeq.zza(str), str2, e);
                        m334c_.endTransaction();
                        return j;
                    }
                } catch (Throwable th) {
                    th = th;
                    m334c_.endTransaction();
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final long zzw() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long zza(zzcd.zzg zzgVar) throws IOException {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzx());
        byte[] zzbk = zzgVar.zzbk();
        long zza = mo331f_().zza(zzbk);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put(TtmlNode.TAG_METADATA, zzbk);
        try {
            m334c_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event metadata. appId", zzeq.zza(zzgVar.zzx()), e);
            throw e;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzc()
            r4.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.m334c_()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L42
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzeq r6 = r4.zzq()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzw()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L57
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L44
        L40:
            r6 = move-exception
            goto L59
        L42:
            r6 = move-exception
            r5 = r0
        L44:
            com.google.android.gms.measurement.internal.zzeq r1 = r4.zzq()     // Catch: java.lang.Throwable -> L57
            com.google.android.gms.measurement.internal.zzes r1 = r1.zze()     // Catch: java.lang.Throwable -> L57
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L57
            if (r5 == 0) goto L56
            r5.close()
        L56:
            return r0
        L57:
            r6 = move-exception
            r0 = r5
        L59:
            if (r0 == 0) goto L5e
            r0.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(long):java.lang.String");
    }

    public final long zzz() {
        Cursor cursor = null;
        try {
            try {
                cursor = m334c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e) {
                zzq().zze().zza("Error querying raw events", e);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0091: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:32:0x0091 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzcd.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.m334c_()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteException -> L7b
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzw()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r4 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzji r2 = com.google.android.gms.measurement.internal.zzkr.zza(r4, r2)     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch: java.io.IOException -> L5f android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L5e
            r1.close()
        L5e:
            return r8
        L5f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeq.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L77 java.lang.Throwable -> L90
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r0
        L77:
            r8 = move-exception
            goto L7d
        L79:
            r8 = move-exception
            goto L92
        L7b:
            r8 = move-exception
            r1 = r0
        L7d:
            com.google.android.gms.measurement.internal.zzeq r9 = r7.zzq()     // Catch: java.lang.Throwable -> L90
            com.google.android.gms.measurement.internal.zzes r9 = r9.zze()     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            r1.close()
        L8f:
            return r0
        L90:
            r8 = move-exception
            r0 = r1
        L92:
            if (r0 == 0) goto L97
            r0.close()
        L97:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzcd.zzc zzcVar) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbk = zzcVar.zzbk();
        zzq().zzw().zza("Saving complex main event, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbk);
        try {
            if (m334c_().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert complex main event (got -1). appId", zzeq.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing complex main event. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzc();
        zzaj();
        byte[] zzbk = mo331f_().zza(new zzan(this.zzy, "", str, "dep", 0L, 0L, bundle)).zzbk();
        zzq().zzw().zza("Saving default event parameters, appId, data size", zzn().zza(str), Integer.valueOf(zzbk.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbk);
        try {
            if (m334c_().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                zzq().zze().zza("Failed to insert default event parameters (got -1). appId", zzeq.zza(str));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing default event parameters. appId", zzeq.zza(str), e);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00d6: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:47:0x00d6 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzi(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzc()
            r7.zzaj()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.m334c_()     // Catch: java.lang.Throwable -> Lbe android.database.sqlite.SQLiteException -> Lc0
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lbe android.database.sqlite.SQLiteException -> Lc0
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> Lbe android.database.sqlite.SQLiteException -> Lc0
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> Lbe android.database.sqlite.SQLiteException -> Lc0
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r2 != 0) goto L30
            com.google.android.gms.measurement.internal.zzeq r8 = r7.zzq()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzes r8 = r8.zzw()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r1 == 0) goto L2f
            r1.close()
        L2f:
            return r0
        L30:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r3 = com.google.android.gms.internal.measurement.zzcd.zzc.zzj()     // Catch: java.io.IOException -> La4 android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzji r2 = com.google.android.gms.measurement.internal.zzkr.zza(r3, r2)     // Catch: java.io.IOException -> La4 android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzcd$zzc$zza r2 = (com.google.android.gms.internal.measurement.zzcd.zzc.zza) r2     // Catch: java.io.IOException -> La4 android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzjj r2 = r2.zzy()     // Catch: java.io.IOException -> La4 android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzhy r2 = (com.google.android.gms.internal.measurement.zzhy) r2     // Catch: java.io.IOException -> La4 android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzcd$zzc r2 = (com.google.android.gms.internal.measurement.zzcd.zzc) r2     // Catch: java.io.IOException -> La4 android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r7.mo331f_()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            java.util.List r8 = r2.zza()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            android.os.Bundle r2 = new android.os.Bundle     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r2.<init>()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            java.util.Iterator r8 = r8.iterator()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
        L56:
            boolean r3 = r8.hasNext()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r3 == 0) goto L9e
            java.lang.Object r3 = r8.next()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.internal.measurement.zzcd$zze r3 = (com.google.android.gms.internal.measurement.zzcd.zze) r3     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            java.lang.String r4 = r3.zzb()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            boolean r5 = r3.zzi()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r5 == 0) goto L74
            double r5 = r3.zzj()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r2.putDouble(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            goto L56
        L74:
            boolean r5 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r5 == 0) goto L82
            float r3 = r3.zzh()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r2.putFloat(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            goto L56
        L82:
            boolean r5 = r3.zzc()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r5 == 0) goto L90
            java.lang.String r3 = r3.zzd()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r2.putString(r4, r3)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            goto L56
        L90:
            boolean r5 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r5 == 0) goto L56
            long r5 = r3.zzf()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r2.putLong(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            goto L56
        L9e:
            if (r1 == 0) goto La3
            r1.close()
        La3:
            return r2
        La4:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzeq r3 = r7.zzq()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzes r3 = r3.zze()     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeq.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            r3.zza(r4, r8, r2)     // Catch: android.database.sqlite.SQLiteException -> Lbc java.lang.Throwable -> Ld5
            if (r1 == 0) goto Lbb
            r1.close()
        Lbb:
            return r0
        Lbc:
            r8 = move-exception
            goto Lc2
        Lbe:
            r8 = move-exception
            goto Ld7
        Lc0:
            r8 = move-exception
            r1 = r0
        Lc2:
            com.google.android.gms.measurement.internal.zzeq r2 = r7.zzq()     // Catch: java.lang.Throwable -> Ld5
            com.google.android.gms.measurement.internal.zzes r2 = r2.zze()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r8)     // Catch: java.lang.Throwable -> Ld5
            if (r1 == 0) goto Ld4
            r1.close()
        Ld4:
            return r0
        Ld5:
            r8 = move-exception
            r0 = r1
        Ld7:
            if (r0 == 0) goto Ldc
            r0.close()
        Ldc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzi(java.lang.String):android.os.Bundle");
    }

    public final zzac zzj(String str) {
        Preconditions.checkNotNull(str);
        zzc();
        zzaj();
        return zzac.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
    }

    public final boolean zza(zzan zzanVar, long j, boolean z) {
        zzc();
        zzaj();
        Preconditions.checkNotNull(zzanVar);
        Preconditions.checkNotEmpty(zzanVar.zza);
        byte[] zzbk = mo331f_().zza(zzanVar).zzbk();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzanVar.zza);
        contentValues.put("name", zzanVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzanVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbk);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (m334c_().insert("raw_events", null, contentValues) == -1) {
                zzq().zze().zza("Failed to insert raw event (got -1). appId", zzeq.zza(zzanVar.zza));
                return false;
            }
            return true;
        } catch (SQLiteException e) {
            zzq().zze().zza("Error storing raw event. appId", zzeq.zza(zzanVar.zza), e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, List<zzbv.zza> list) {
        boolean z;
        boolean z2;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzbv.zza.C5583zza zzbo = list.get(i).zzbo();
            if (zzbo.zzb() != 0) {
                for (int i2 = 0; i2 < zzbo.zzb(); i2++) {
                    zzbv.zzb.zza zzbo2 = zzbo.zzb(i2).zzbo();
                    zzbv.zzb.zza zzaVar = (zzbv.zzb.zza) ((zzhy.zzb) zzbo2.clone());
                    String zzb2 = zzgv.zzb(zzbo2.zza());
                    if (zzb2 != null) {
                        zzaVar.zza(zzb2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zzbo2.zzb(); i3++) {
                        zzbv.zzc zza = zzbo2.zza(i3);
                        String zza2 = zzgu.zza(zza.zzh());
                        if (zza2 != null) {
                            zzaVar.zza(i3, (zzbv.zzc) ((com.google.android.gms.internal.measurement.zzhy) zza.zzbo().zza(zza2).zzy()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zzbo = zzbo.zza(i2, zzaVar);
                        list.set(i, (zzbv.zza) ((com.google.android.gms.internal.measurement.zzhy) zzbo.zzy()));
                    }
                }
            }
            if (zzbo.zza() != 0) {
                for (int i4 = 0; i4 < zzbo.zza(); i4++) {
                    zzbv.zze zza3 = zzbo.zza(i4);
                    String zza4 = zzgx.zza(zza3.zzc());
                    if (zza4 != null) {
                        zzbo = zzbo.zza(i4, zza3.zzbo().zza(zza4));
                        list.set(i, (zzbv.zza) ((com.google.android.gms.internal.measurement.zzhy) zzbo.zzy()));
                    }
                }
            }
        }
        zzaj();
        zzc();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase m334c_ = m334c_();
        m334c_.beginTransaction();
        try {
            zzaj();
            zzc();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase m334c_2 = m334c_();
            m334c_2.delete("property_filters", "app_id=?", new String[]{str});
            m334c_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbv.zza zzaVar2 : list) {
                zzaj();
                zzc();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zza()) {
                    zzq().zzh().zza("Audience with no ID. appId", zzeq.zza(str));
                } else {
                    int zzb3 = zzaVar2.zzb();
                    Iterator<zzbv.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzq().zzh().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(zzb3));
                                break;
                            }
                        } else {
                            Iterator<zzbv.zze> it2 = zzaVar2.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzq().zzh().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzeq.zza(str), Integer.valueOf(zzb3));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbv.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zzb3, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbv.zze> it4 = zzaVar2.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zzb3, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzaj();
                                        zzc();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase m334c_3 = m334c_();
                                        m334c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                        m334c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb3)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zza() ? Integer.valueOf(zzaVar3.zzb()) : null);
            }
            zzb(str, arrayList);
            m334c_.setTransactionSuccessful();
        } finally {
            m334c_.endTransaction();
        }
    }

    private final boolean zzal() {
        return zzm().getDatabasePath("google_app_measurement.db").exists();
    }
}
