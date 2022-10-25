package com.frostwire.jlibtorrent;

import java.util.logging.Level;

/* loaded from: classes2.dex */
final class Logger {
    private final java.util.logging.Logger jul;
    private final String name;

    Logger(java.util.logging.Logger logger) {
        this.jul = logger;
        this.name = logger.getName();
    }

    public static Logger getLogger(Class<?> cls) {
        return new Logger(java.util.logging.Logger.getLogger(cls.getName()));
    }

    public void info(String str) {
        this.jul.logp(Level.INFO, this.name, "", str);
    }

    public void info(String str, Throwable th) {
        this.jul.logp(Level.INFO, this.name, "", str, th);
    }

    public void warn(String str) {
        this.jul.logp(Level.INFO, this.name, "", str);
    }

    public void warn(String str, Throwable th) {
        this.jul.logp(Level.INFO, this.name, "", str, th);
    }

    public void error(String str) {
        this.jul.logp(Level.INFO, this.name, "", str);
    }

    public void error(String str, Throwable th) {
        this.jul.logp(Level.INFO, this.name, "", str, th);
    }

    public void debug(String str) {
        this.jul.logp(Level.INFO, this.name, "", str);
    }

    public void debug(String str, Throwable th) {
        this.jul.logp(Level.INFO, this.name, "", str, th);
    }
}
