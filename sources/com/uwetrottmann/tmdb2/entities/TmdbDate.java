package com.uwetrottmann.tmdb2.entities;

import com.uwetrottmann.tmdb2.TmdbHelper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes4.dex */
public class TmdbDate {
    private static final ThreadLocal<DateFormat> TMDB_DATE_FORMAT = new ThreadLocal<DateFormat>() { // from class: com.uwetrottmann.tmdb2.entities.TmdbDate.1
        @Override // java.lang.ThreadLocal
        public DateFormat initialValue() {
            return new SimpleDateFormat(TmdbHelper.TMDB_DATE_PATTERN);
        }
    };
    private final Date date;

    public TmdbDate(Date date) {
        this.date = date;
    }

    public TmdbDate(String str) {
        Date date;
        try {
            date = TMDB_DATE_FORMAT.get().parse(str);
        } catch (ParseException unused) {
            date = null;
        }
        this.date = date;
    }

    public String toString() {
        return TMDB_DATE_FORMAT.get().format(this.date);
    }
}
