package com.facebook.internal.instrument.crashshield;

import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class CrashShieldHandler {
    private static final Set<Object> sCrashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled = false;

    public static void methodFinished(Object obj) {
    }

    private static void scheduleCrashInDebug(Throwable th) {
    }

    public static void enable() {
        enabled = true;
    }

    public static void handleThrowable(Throwable th, Object obj) {
        if (enabled) {
            sCrashingObjects.add(obj);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(th);
                InstrumentData.Builder.build(th, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(th);
        }
    }

    public static boolean isObjectCrashing(Object obj) {
        return sCrashingObjects.contains(obj);
    }

    public static void reset() {
        resetCrashingObjects();
    }

    public static void resetCrashingObjects() {
        sCrashingObjects.clear();
    }
}
