package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmy */
/* loaded from: classes2.dex */
public abstract class bmy {

    /* renamed from: a */
    private static final Logger f6247a = Logger.getLogger(bma.class.getName());

    /* renamed from: b */
    private static final String f6248b = "com.google.ads.interactivemedia.v3.internal.bli";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static bmr m3313b(Class cls) {
        String format;
        ClassLoader classLoader = bmy.class.getClassLoader();
        if (cls.equals(bmr.class)) {
            format = f6248b;
        } else if (!cls.getPackage().equals(bmy.class.getPackage())) {
            throw new IllegalArgumentException(cls.getName());
        } else {
            format = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return (bmr) cls.cast(((bmy) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).mo2767a());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException(e);
                    } catch (NoSuchMethodException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (InvocationTargetException e3) {
                    throw new IllegalStateException(e3);
                }
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(bmy.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((bmy) it.next()).mo2767a()));
                } catch (ServiceConfigurationError e5) {
                    Logger logger = f6247a;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? "Unable to load ".concat(valueOf) : new String("Unable to load "), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (bmr) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (bmr) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    /* renamed from: a */
    protected abstract bmr mo2767a();
}
