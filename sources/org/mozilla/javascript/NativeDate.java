package org.mozilla.javascript;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class NativeDate extends IdScriptableObject {
    private static final int ConstructorId_UTC = -1;
    private static final int ConstructorId_now = -3;
    private static final int ConstructorId_parse = -2;
    private static final Object DATE_TAG = "Date";
    private static final double HalfTimeDomain = 8.64E15d;
    private static final double HoursPerDay = 24.0d;
    private static final int Id_constructor = 1;
    private static final int Id_getDate = 17;
    private static final int Id_getDay = 19;
    private static final int Id_getFullYear = 13;
    private static final int Id_getHours = 21;
    private static final int Id_getMilliseconds = 27;
    private static final int Id_getMinutes = 23;
    private static final int Id_getMonth = 15;
    private static final int Id_getSeconds = 25;
    private static final int Id_getTime = 11;
    private static final int Id_getTimezoneOffset = 29;
    private static final int Id_getUTCDate = 18;
    private static final int Id_getUTCDay = 20;
    private static final int Id_getUTCFullYear = 14;
    private static final int Id_getUTCHours = 22;
    private static final int Id_getUTCMilliseconds = 28;
    private static final int Id_getUTCMinutes = 24;
    private static final int Id_getUTCMonth = 16;
    private static final int Id_getUTCSeconds = 26;
    private static final int Id_getYear = 12;
    private static final int Id_setDate = 39;
    private static final int Id_setFullYear = 43;
    private static final int Id_setHours = 37;
    private static final int Id_setMilliseconds = 31;
    private static final int Id_setMinutes = 35;
    private static final int Id_setMonth = 41;
    private static final int Id_setSeconds = 33;
    private static final int Id_setTime = 30;
    private static final int Id_setUTCDate = 40;
    private static final int Id_setUTCFullYear = 44;
    private static final int Id_setUTCHours = 38;
    private static final int Id_setUTCMilliseconds = 32;
    private static final int Id_setUTCMinutes = 36;
    private static final int Id_setUTCMonth = 42;
    private static final int Id_setUTCSeconds = 34;
    private static final int Id_setYear = 45;
    private static final int Id_toDateString = 4;
    private static final int Id_toGMTString = 8;
    private static final int Id_toISOString = 46;
    private static final int Id_toJSON = 47;
    private static final int Id_toLocaleDateString = 7;
    private static final int Id_toLocaleString = 5;
    private static final int Id_toLocaleTimeString = 6;
    private static final int Id_toSource = 9;
    private static final int Id_toString = 2;
    private static final int Id_toTimeString = 3;
    private static final int Id_toUTCString = 8;
    private static final int Id_valueOf = 10;
    private static double LocalTZA = 0.0d;
    private static final int MAXARGS = 7;
    private static final int MAX_PROTOTYPE_ID = 47;
    private static final double MinutesPerDay = 1440.0d;
    private static final double MinutesPerHour = 60.0d;
    private static final double SecondsPerDay = 86400.0d;
    private static final double SecondsPerHour = 3600.0d;
    private static final double SecondsPerMinute = 60.0d;
    private static final DateFormat isoFormat;
    private static final String js_NaN_date_str = "Invalid Date";
    private static DateFormat localeDateFormatter = null;
    private static DateFormat localeDateTimeFormatter = null;
    private static DateFormat localeTimeFormatter = null;
    private static final double msPerDay = 8.64E7d;
    private static final double msPerHour = 3600000.0d;
    private static final double msPerMinute = 60000.0d;
    private static final double msPerSecond = 1000.0d;
    static final long serialVersionUID = -8307438915861678966L;
    private static TimeZone thisTimeZone;
    private static DateFormat timeZoneFormatter;
    private double date;

    private static double MakeDate(double d, double d2) {
        return (d * msPerDay) + d2;
    }

    private static double MakeTime(double d, double d2, double d3, double d4) {
        return (((((d * 60.0d) + d2) * 60.0d) + d3) * msPerSecond) + d4;
    }

    private static double TimeWithinDay(double d) {
        double d2 = d % msPerDay;
        return d2 < 0.0d ? d2 + msPerDay : d2;
    }

    private static int msFromTime(double d) {
        double d2 = d % msPerSecond;
        if (d2 < 0.0d) {
            d2 += msPerSecond;
        }
        return (int) d2;
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Date";
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        isoFormat = simpleDateFormat;
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
        simpleDateFormat.setLenient(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Scriptable scriptable, boolean z) {
        NativeDate nativeDate = new NativeDate();
        nativeDate.date = ScriptRuntime.NaN;
        nativeDate.exportAsJSClass(47, scriptable, z);
    }

    private NativeDate() {
        if (thisTimeZone == null) {
            TimeZone timeZone = TimeZone.getDefault();
            thisTimeZone = timeZone;
            LocalTZA = timeZone.getRawOffset();
        }
    }

    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null) {
            cls = ScriptRuntime.StringClass;
        }
        return super.getDefaultValue(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getJSTimeValue() {
        return this.date;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = DATE_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -3, "now", 0);
        addIdFunctionProperty(idFunctionObject, obj, -2, "parse", 1);
        addIdFunctionProperty(idFunctionObject, obj, -1, "UTC", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // org.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 0;
        switch (i) {
            case 1:
                str = "constructor";
                i2 = 1;
                break;
            case 2:
                str = "toString";
                break;
            case 3:
                str = "toTimeString";
                break;
            case 4:
                str = "toDateString";
                break;
            case 5:
                str = "toLocaleString";
                break;
            case 6:
                str = "toLocaleTimeString";
                break;
            case 7:
                str = "toLocaleDateString";
                break;
            case 8:
                str = "toUTCString";
                break;
            case 9:
                str = "toSource";
                break;
            case 10:
                str = "valueOf";
                break;
            case 11:
                str = "getTime";
                break;
            case 12:
                str = "getYear";
                break;
            case 13:
                str = "getFullYear";
                break;
            case 14:
                str = "getUTCFullYear";
                break;
            case 15:
                str = "getMonth";
                break;
            case 16:
                str = "getUTCMonth";
                break;
            case 17:
                str = "getDate";
                break;
            case 18:
                str = "getUTCDate";
                break;
            case 19:
                str = "getDay";
                break;
            case 20:
                str = "getUTCDay";
                break;
            case 21:
                str = "getHours";
                break;
            case 22:
                str = "getUTCHours";
                break;
            case 23:
                str = "getMinutes";
                break;
            case 24:
                str = "getUTCMinutes";
                break;
            case 25:
                str = "getSeconds";
                break;
            case 26:
                str = "getUTCSeconds";
                break;
            case 27:
                str = "getMilliseconds";
                break;
            case 28:
                str = "getUTCMilliseconds";
                break;
            case 29:
                str = "getTimezoneOffset";
                break;
            case 30:
                str = "setTime";
                i2 = 1;
                break;
            case 31:
                str = "setMilliseconds";
                i2 = 1;
                break;
            case 32:
                str = "setUTCMilliseconds";
                i2 = 1;
                break;
            case 33:
                str = "setSeconds";
                i2 = 2;
                break;
            case 34:
                str = "setUTCSeconds";
                i2 = 2;
                break;
            case 35:
                str = "setMinutes";
                i2 = 3;
                break;
            case 36:
                str = "setUTCMinutes";
                i2 = 3;
                break;
            case 37:
                str2 = "setHours";
                str = str2;
                i2 = 4;
                break;
            case 38:
                str2 = "setUTCHours";
                str = str2;
                i2 = 4;
                break;
            case 39:
                str = "setDate";
                i2 = 1;
                break;
            case 40:
                str = "setUTCDate";
                i2 = 1;
                break;
            case 41:
                str = "setMonth";
                i2 = 2;
                break;
            case 42:
                str = "setUTCMonth";
                i2 = 2;
                break;
            case 43:
                str = "setFullYear";
                i2 = 3;
                break;
            case 44:
                str = "setUTCFullYear";
                i2 = 3;
                break;
            case 45:
                str = "setYear";
                i2 = 1;
                break;
            case 46:
                str = "toISOString";
                break;
            case 47:
                str = "toJSON";
                i2 = 1;
                break;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
        initPrototypeMethod(DATE_TAG, i, str, i2);
    }

    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d;
        if (!idFunctionObject.hasTag(DATE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId != -3) {
            if (methodId != -2) {
                if (methodId != -1) {
                    if (methodId == 1) {
                        if (scriptable2 != null) {
                            return date_format(now(), 2);
                        }
                        return jsConstructor(objArr);
                    } else if (methodId == 47) {
                        if (scriptable2 instanceof NativeDate) {
                            return ((NativeDate) scriptable2).toISOString();
                        }
                        Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
                        Object primitive = ScriptRuntime.toPrimitive(object, ScriptRuntime.NumberClass);
                        if (primitive instanceof Number) {
                            double doubleValue = ((Number) primitive).doubleValue();
                            if (doubleValue != doubleValue || Double.isInfinite(doubleValue)) {
                                return null;
                            }
                        }
                        Object obj = object.get("toISOString", object);
                        if (obj == NOT_FOUND) {
                            throw ScriptRuntime.typeError2("msg.function.not.found.in", "toISOString", ScriptRuntime.toString(object));
                        }
                        if (!(obj instanceof Callable)) {
                            throw ScriptRuntime.typeError3("msg.isnt.function.in", "toISOString", ScriptRuntime.toString(object), ScriptRuntime.toString(obj));
                        }
                        Object call = ((Callable) obj).call(context, scriptable, object, ScriptRuntime.emptyArgs);
                        if (ScriptRuntime.isPrimitive(call)) {
                            return call;
                        }
                        throw ScriptRuntime.typeError1("msg.toisostring.must.return.primitive", ScriptRuntime.toString(call));
                    } else if (!(scriptable2 instanceof NativeDate)) {
                        throw incompatibleCallError(idFunctionObject);
                    } else {
                        NativeDate nativeDate = (NativeDate) scriptable2;
                        double d2 = nativeDate.date;
                        switch (methodId) {
                            case 2:
                            case 3:
                            case 4:
                                return d2 == d2 ? date_format(d2, methodId) : js_NaN_date_str;
                            case 5:
                            case 6:
                            case 7:
                                return d2 == d2 ? toLocale_helper(d2, methodId) : js_NaN_date_str;
                            case 8:
                                return d2 == d2 ? js_toUTCString(d2) : js_NaN_date_str;
                            case 9:
                                return "(new Date(" + ScriptRuntime.toString(d2) + "))";
                            case 10:
                            case 11:
                                return ScriptRuntime.wrapNumber(d2);
                            case 12:
                            case 13:
                            case 14:
                                if (d2 == d2) {
                                    if (methodId != 14) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = YearFromTime(d2);
                                    if (methodId == 12 && (!context.hasFeature(1) || (1900.0d <= d2 && d2 < 2000.0d))) {
                                        d2 -= 1900.0d;
                                    }
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 15:
                            case 16:
                                if (d2 == d2) {
                                    if (methodId == 15) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = MonthFromTime(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 17:
                            case 18:
                                if (d2 == d2) {
                                    if (methodId == 17) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = DateFromTime(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 19:
                            case 20:
                                if (d2 == d2) {
                                    if (methodId == 19) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = WeekDay(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 21:
                            case 22:
                                if (d2 == d2) {
                                    if (methodId == 21) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = HourFromTime(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 23:
                            case 24:
                                if (d2 == d2) {
                                    if (methodId == 23) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = MinFromTime(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 25:
                            case 26:
                                if (d2 == d2) {
                                    if (methodId == 25) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = SecFromTime(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 27:
                            case 28:
                                if (d2 == d2) {
                                    if (methodId == 27) {
                                        d2 = LocalTime(d2);
                                    }
                                    d2 = msFromTime(d2);
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 29:
                                if (d2 == d2) {
                                    d2 = (d2 - LocalTime(d2)) / msPerMinute;
                                }
                                return ScriptRuntime.wrapNumber(d2);
                            case 30:
                                double TimeClip = TimeClip(ScriptRuntime.toNumber(objArr, 0));
                                nativeDate.date = TimeClip;
                                return ScriptRuntime.wrapNumber(TimeClip);
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                                double makeTime = makeTime(d2, objArr, methodId);
                                nativeDate.date = makeTime;
                                return ScriptRuntime.wrapNumber(makeTime);
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                                double makeDate = makeDate(d2, objArr, methodId);
                                nativeDate.date = makeDate;
                                return ScriptRuntime.wrapNumber(makeDate);
                            case 45:
                                double number = ScriptRuntime.toNumber(objArr, 0);
                                if (number != number || Double.isInfinite(number)) {
                                    d = ScriptRuntime.NaN;
                                } else {
                                    double LocalTime = d2 != d2 ? 0.0d : LocalTime(d2);
                                    if (number >= 0.0d && number <= 99.0d) {
                                        number += 1900.0d;
                                    }
                                    d = TimeClip(internalUTC(MakeDate(MakeDay(number, MonthFromTime(LocalTime), DateFromTime(LocalTime)), TimeWithinDay(LocalTime))));
                                }
                                nativeDate.date = d;
                                return ScriptRuntime.wrapNumber(d);
                            case 46:
                                return nativeDate.toISOString();
                            default:
                                throw new IllegalArgumentException(String.valueOf(methodId));
                        }
                    }
                }
                return ScriptRuntime.wrapNumber(jsStaticFunction_UTC(objArr));
            }
            return ScriptRuntime.wrapNumber(date_parseString(ScriptRuntime.toString(objArr, 0)));
        }
        return ScriptRuntime.wrapNumber(now());
    }

    private String toISOString() {
        String format;
        double d = this.date;
        if (d == d) {
            DateFormat dateFormat = isoFormat;
            synchronized (dateFormat) {
                format = dateFormat.format(new Date((long) this.date));
            }
            return format;
        }
        throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.invalid.date"));
    }

    private static double Day(double d) {
        return Math.floor(d / msPerDay);
    }

    private static boolean IsLeapYear(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    private static double DayFromYear(double d) {
        return ((((d - 1970.0d) * 365.0d) + Math.floor((d - 1969.0d) / 4.0d)) - Math.floor((d - 1901.0d) / 100.0d)) + Math.floor((d - 1601.0d) / 400.0d);
    }

    private static double TimeFromYear(double d) {
        return DayFromYear(d) * msPerDay;
    }

    private static int YearFromTime(double d) {
        double d2 = d / msPerDay;
        int floor = ((int) Math.floor(d2 / 366.0d)) + 1970;
        int floor2 = ((int) Math.floor(d2 / 365.0d)) + 1970;
        if (floor2 >= floor) {
            floor = floor2;
            floor2 = floor;
        }
        while (floor > floor2) {
            int i = (floor + floor2) / 2;
            if (TimeFromYear(i) > d) {
                floor = i - 1;
            } else {
                floor2 = i + 1;
                if (TimeFromYear(floor2) > d) {
                    return i;
                }
            }
        }
        return floor2;
    }

    private static double DayFromMonth(int i, int i2) {
        int i3;
        int i4;
        int i5 = i * 30;
        if (i >= 7) {
            i4 = i / 2;
        } else if (i >= 2) {
            i4 = (i - 1) / 2;
        } else {
            i3 = i5 + i;
            if (i >= 2 && IsLeapYear(i2)) {
                i3++;
            }
            return i3;
        }
        i3 = i5 + (i4 - 1);
        if (i >= 2) {
            i3++;
        }
        return i3;
    }

    private static int MonthFromTime(double d) {
        int i;
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear(YearFromTime))) - 59;
        if (Day < 0) {
            return Day < -28 ? 0 : 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 1;
            }
            Day--;
        }
        int i2 = Day / 30;
        switch (i2) {
            case 0:
                return 2;
            case 1:
                i = 31;
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                break;
            case 6:
                i = 184;
                break;
            case 7:
                i = bqk.f6553bM;
                break;
            case 8:
                i = 245;
                break;
            case 9:
                i = bqk.f6535av;
                break;
            case 10:
                return 11;
            default:
                throw Kit.codeBug();
        }
        return Day >= i ? i2 + 2 : i2 + 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int DateFromTime(double d) {
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear(YearFromTime))) - 59;
        int i = 31;
        if (Day < 0) {
            if (Day < -28) {
                Day += 31;
            }
            return Day + 28 + 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 29;
            }
            Day--;
        }
        int i2 = 30;
        switch (Day / 30) {
            case 0:
                return Day + 1;
            case 1:
                i2 = 31;
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                i2 = 31;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                i2 = 31;
                break;
            case 6:
                i = 184;
                i2 = 31;
                break;
            case 7:
                i = bqk.f6553bM;
                break;
            case 8:
                i = 245;
                i2 = 31;
                break;
            case 9:
                i = bqk.f6535av;
                break;
            case 10:
                return (Day - bqk.f6535av) + 1;
            default:
                throw Kit.codeBug();
        }
        int i3 = Day - i;
        if (i3 < 0) {
            i3 += i2;
        }
        return i3 + 1;
    }

    private static int WeekDay(double d) {
        double Day = (Day(d) + 4.0d) % 7.0d;
        if (Day < 0.0d) {
            Day += 7.0d;
        }
        return (int) Day;
    }

    private static double now() {
        return System.currentTimeMillis();
    }

    private static double DaylightSavingTA(double d) {
        if (d < 0.0d) {
            d = MakeDate(MakeDay(EquivalentYear(YearFromTime(d)), MonthFromTime(d), DateFromTime(d)), TimeWithinDay(d));
        }
        if (thisTimeZone.inDaylightTime(new Date((long) d))) {
            return msPerHour;
        }
        return 0.0d;
    }

    private static int EquivalentYear(int i) {
        int DayFromYear = (((int) DayFromYear(i)) + 4) % 7;
        if (DayFromYear < 0) {
            DayFromYear += 7;
        }
        if (IsLeapYear(i)) {
            switch (DayFromYear) {
                case 0:
                    return 1984;
                case 1:
                    return 1996;
                case 2:
                    return 1980;
                case 3:
                    return 1992;
                case 4:
                    return 1976;
                case 5:
                    return 1988;
                case 6:
                    return 1972;
            }
        }
        switch (DayFromYear) {
            case 0:
                return 1978;
            case 1:
                return 1973;
            case 2:
                return 1985;
            case 3:
                return 1986;
            case 4:
                return 1981;
            case 5:
                return 1971;
            case 6:
                return 1977;
        }
        throw Kit.codeBug();
    }

    private static double LocalTime(double d) {
        return LocalTZA + d + DaylightSavingTA(d);
    }

    private static double internalUTC(double d) {
        double d2 = LocalTZA;
        return (d - d2) - DaylightSavingTA(d - d2);
    }

    private static int HourFromTime(double d) {
        double floor = Math.floor(d / msPerHour) % HoursPerDay;
        if (floor < 0.0d) {
            floor += HoursPerDay;
        }
        return (int) floor;
    }

    private static int MinFromTime(double d) {
        double floor = Math.floor(d / msPerMinute) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    private static int SecFromTime(double d) {
        double floor = Math.floor(d / msPerSecond) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    private static double MakeDay(double d, double d2, double d3) {
        double floor = d + Math.floor(d2 / 12.0d);
        double d4 = d2 % 12.0d;
        if (d4 < 0.0d) {
            d4 += 12.0d;
        }
        return ((Math.floor(TimeFromYear(floor) / msPerDay) + DayFromMonth((int) d4, (int) floor)) + d3) - 1.0d;
    }

    private static double TimeClip(double d) {
        if (d != d || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Math.abs(d) > HalfTimeDomain) {
            return ScriptRuntime.NaN;
        }
        if (d > 0.0d) {
            return Math.floor(d + 0.0d);
        }
        return Math.ceil(d + 0.0d);
    }

    private static double date_msecFromDate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return MakeDate(MakeDay(d, d2, d3), MakeTime(d4, d5, d6, d7));
    }

    private static double date_msecFromArgs(Object[] objArr) {
        double[] dArr = new double[7];
        for (int i = 0; i < 7; i++) {
            if (i < objArr.length) {
                double number = ScriptRuntime.toNumber(objArr[i]);
                if (number != number || Double.isInfinite(number)) {
                    return ScriptRuntime.NaN;
                }
                dArr[i] = ScriptRuntime.toInteger(objArr[i]);
            } else if (i == 2) {
                dArr[i] = 1.0d;
            } else {
                dArr[i] = 0.0d;
            }
        }
        if (dArr[0] >= 0.0d && dArr[0] <= 99.0d) {
            dArr[0] = dArr[0] + 1900.0d;
        }
        return date_msecFromDate(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6]);
    }

    private static double jsStaticFunction_UTC(Object[] objArr) {
        return TimeClip(date_msecFromArgs(objArr));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0208, code lost:
        if (r6 <= '9') goto L209;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x015e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double date_parseString(java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.date_parseString(java.lang.String):double");
    }

    private static String date_format(double d, int i) {
        StringBuffer stringBuffer = new StringBuffer(60);
        double LocalTime = LocalTime(d);
        if (i != 3) {
            appendWeekDayName(stringBuffer, WeekDay(LocalTime));
            stringBuffer.append(' ');
            appendMonthName(stringBuffer, MonthFromTime(LocalTime));
            stringBuffer.append(' ');
            append0PaddedUint(stringBuffer, DateFromTime(LocalTime), 2);
            stringBuffer.append(' ');
            int YearFromTime = YearFromTime(LocalTime);
            if (YearFromTime < 0) {
                stringBuffer.append('-');
                YearFromTime = -YearFromTime;
            }
            append0PaddedUint(stringBuffer, YearFromTime, 4);
            if (i != 4) {
                stringBuffer.append(' ');
            }
        }
        if (i != 4) {
            append0PaddedUint(stringBuffer, HourFromTime(LocalTime), 2);
            stringBuffer.append(':');
            append0PaddedUint(stringBuffer, MinFromTime(LocalTime), 2);
            stringBuffer.append(':');
            append0PaddedUint(stringBuffer, SecFromTime(LocalTime), 2);
            int floor = (int) Math.floor((LocalTZA + DaylightSavingTA(d)) / msPerMinute);
            int i2 = ((floor / 60) * 100) + (floor % 60);
            if (i2 > 0) {
                stringBuffer.append(" GMT+");
            } else {
                stringBuffer.append(" GMT-");
                i2 = -i2;
            }
            append0PaddedUint(stringBuffer, i2, 4);
            if (timeZoneFormatter == null) {
                timeZoneFormatter = new SimpleDateFormat("zzz");
            }
            if (d < 0.0d) {
                d = MakeDate(MakeDay(EquivalentYear(YearFromTime(LocalTime)), MonthFromTime(d), DateFromTime(d)), TimeWithinDay(d));
            }
            stringBuffer.append(" (");
            Date date = new Date((long) d);
            synchronized (timeZoneFormatter) {
                stringBuffer.append(timeZoneFormatter.format(date));
            }
            stringBuffer.append(')');
        }
        return stringBuffer.toString();
    }

    private static Object jsConstructor(Object[] objArr) {
        double number;
        NativeDate nativeDate = new NativeDate();
        if (objArr.length == 0) {
            nativeDate.date = now();
            return nativeDate;
        } else if (objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof Scriptable) {
                obj = ((Scriptable) obj).getDefaultValue(null);
            }
            if (obj instanceof CharSequence) {
                number = date_parseString(obj.toString());
            } else {
                number = ScriptRuntime.toNumber(obj);
            }
            nativeDate.date = TimeClip(number);
            return nativeDate;
        } else {
            double date_msecFromArgs = date_msecFromArgs(objArr);
            if (!Double.isNaN(date_msecFromArgs) && !Double.isInfinite(date_msecFromArgs)) {
                date_msecFromArgs = TimeClip(internalUTC(date_msecFromArgs));
            }
            nativeDate.date = date_msecFromArgs;
            return nativeDate;
        }
    }

    private static String toLocale_helper(double d, int i) {
        DateFormat dateFormat;
        String format;
        if (i == 5) {
            if (localeDateTimeFormatter == null) {
                localeDateTimeFormatter = DateFormat.getDateTimeInstance(1, 1);
            }
            dateFormat = localeDateTimeFormatter;
        } else if (i == 6) {
            if (localeTimeFormatter == null) {
                localeTimeFormatter = DateFormat.getTimeInstance(1);
            }
            dateFormat = localeTimeFormatter;
        } else if (i == 7) {
            if (localeDateFormatter == null) {
                localeDateFormatter = DateFormat.getDateInstance(1);
            }
            dateFormat = localeDateFormatter;
        } else {
            throw new AssertionError();
        }
        synchronized (dateFormat) {
            format = dateFormat.format(new Date((long) d));
        }
        return format;
    }

    private static String js_toUTCString(double d) {
        StringBuffer stringBuffer = new StringBuffer(60);
        appendWeekDayName(stringBuffer, WeekDay(d));
        stringBuffer.append(", ");
        append0PaddedUint(stringBuffer, DateFromTime(d), 2);
        stringBuffer.append(' ');
        appendMonthName(stringBuffer, MonthFromTime(d));
        stringBuffer.append(' ');
        int YearFromTime = YearFromTime(d);
        if (YearFromTime < 0) {
            stringBuffer.append('-');
            YearFromTime = -YearFromTime;
        }
        append0PaddedUint(stringBuffer, YearFromTime, 4);
        stringBuffer.append(' ');
        append0PaddedUint(stringBuffer, HourFromTime(d), 2);
        stringBuffer.append(':');
        append0PaddedUint(stringBuffer, MinFromTime(d), 2);
        stringBuffer.append(':');
        append0PaddedUint(stringBuffer, SecFromTime(d), 2);
        stringBuffer.append(" GMT");
        return stringBuffer.toString();
    }

    private static void append0PaddedUint(StringBuffer stringBuffer, int i, int i2) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i3 = i2 - 1;
        int i4 = 1000000000;
        if (i < 10) {
            i4 = 1;
        } else if (i < 1000000000) {
            i4 = 1;
            while (true) {
                int i5 = i4 * 10;
                if (i < i5) {
                    break;
                }
                i3--;
                i4 = i5;
            }
        } else {
            i3 -= 9;
        }
        while (i3 > 0) {
            stringBuffer.append('0');
            i3--;
        }
        while (i4 != 1) {
            stringBuffer.append((char) ((i / i4) + 48));
            i %= i4;
            i4 /= 10;
        }
        stringBuffer.append((char) (i + 48));
    }

    private static void appendMonthName(StringBuffer stringBuffer, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            stringBuffer.append("JanFebMarAprMayJunJulAugSepOctNovDec".charAt(i2 + i3));
        }
    }

    private static void appendWeekDayName(StringBuffer stringBuffer, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            stringBuffer.append("SunMonTueWedThuFriSat".charAt(i2 + i3));
        }
    }

    private static double makeTime(double d, Object[] objArr, int i) {
        boolean z;
        int i2;
        double HourFromTime;
        double MinFromTime;
        double SecFromTime;
        double msFromTime;
        Object[] objArr2 = objArr;
        int i3 = 0;
        switch (i) {
            case 31:
                z = true;
                i2 = 1;
                break;
            case 32:
                z = false;
                i2 = 1;
                break;
            case 33:
                z = true;
                i2 = 2;
                break;
            case 34:
                z = false;
                i2 = 2;
                break;
            case 35:
                z = true;
                i2 = 3;
                break;
            case 36:
                z = false;
                i2 = 3;
                break;
            case 37:
                z = true;
                i2 = 4;
                break;
            case 38:
                z = false;
                i2 = 4;
                break;
            default:
                Kit.codeBug();
                z = true;
                i2 = 0;
                break;
        }
        double[] dArr = new double[4];
        if (d != d) {
            return d;
        }
        if (objArr2.length == 0) {
            objArr2 = ScriptRuntime.padArguments(objArr2, 1);
        }
        for (int i4 = 0; i4 < objArr2.length && i4 < i2; i4++) {
            dArr[i4] = ScriptRuntime.toNumber(objArr2[i4]);
            if (dArr[i4] != dArr[i4] || Double.isInfinite(dArr[i4])) {
                return ScriptRuntime.NaN;
            }
            dArr[i4] = ScriptRuntime.toInteger(dArr[i4]);
        }
        double LocalTime = z ? LocalTime(d) : d;
        int length = objArr2.length;
        if (i2 >= 4 && length > 0) {
            HourFromTime = dArr[0];
            i3 = 1;
        } else {
            HourFromTime = HourFromTime(LocalTime);
        }
        if (i2 >= 3 && i3 < length) {
            MinFromTime = dArr[i3];
            i3++;
        } else {
            MinFromTime = MinFromTime(LocalTime);
        }
        if (i2 >= 2 && i3 < length) {
            double d2 = dArr[i3];
            i3++;
            SecFromTime = d2;
        } else {
            SecFromTime = SecFromTime(LocalTime);
        }
        if (i2 >= 1 && i3 < length) {
            msFromTime = dArr[i3];
        } else {
            msFromTime = msFromTime(LocalTime);
        }
        double MakeDate = MakeDate(Day(LocalTime), MakeTime(HourFromTime, MinFromTime, SecFromTime, msFromTime));
        if (z) {
            MakeDate = internalUTC(MakeDate);
        }
        return TimeClip(MakeDate);
    }

    private static double makeDate(double d, Object[] objArr, int i) {
        boolean z;
        int i2;
        double LocalTime;
        double YearFromTime;
        double MonthFromTime;
        double DateFromTime;
        Object[] objArr2 = objArr;
        int i3 = 0;
        switch (i) {
            case 39:
                z = true;
                i2 = 1;
                break;
            case 40:
                z = false;
                i2 = 1;
                break;
            case 41:
                z = true;
                i2 = 2;
                break;
            case 42:
                z = false;
                i2 = 2;
                break;
            case 43:
                z = true;
                i2 = 3;
                break;
            case 44:
                z = false;
                i2 = 3;
                break;
            default:
                Kit.codeBug();
                z = true;
                i2 = 0;
                break;
        }
        double[] dArr = new double[3];
        if (objArr2.length == 0) {
            objArr2 = ScriptRuntime.padArguments(objArr2, 1);
        }
        for (int i4 = 0; i4 < objArr2.length && i4 < i2; i4++) {
            dArr[i4] = ScriptRuntime.toNumber(objArr2[i4]);
            if (dArr[i4] != dArr[i4] || Double.isInfinite(dArr[i4])) {
                return ScriptRuntime.NaN;
            }
            dArr[i4] = ScriptRuntime.toInteger(dArr[i4]);
        }
        if (d != d) {
            if (objArr2.length < 3) {
                return ScriptRuntime.NaN;
            }
            LocalTime = 0.0d;
        } else {
            LocalTime = z ? LocalTime(d) : d;
        }
        int length = objArr2.length;
        if (i2 >= 3 && length > 0) {
            YearFromTime = dArr[0];
            i3 = 1;
        } else {
            YearFromTime = YearFromTime(LocalTime);
        }
        if (i2 >= 2 && i3 < length) {
            MonthFromTime = dArr[i3];
            i3++;
        } else {
            MonthFromTime = MonthFromTime(LocalTime);
        }
        if (i2 >= 1 && i3 < length) {
            DateFromTime = dArr[i3];
        } else {
            DateFromTime = DateFromTime(LocalTime);
        }
        double MakeDate = MakeDate(MakeDay(YearFromTime, MonthFromTime, DateFromTime), TimeWithinDay(LocalTime));
        if (z) {
            MakeDate = internalUTC(MakeDate);
        }
        return TimeClip(MakeDate);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0219 A[FALL_THROUGH] */
    @Override // org.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int findPrototypeId(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeDate.findPrototypeId(java.lang.String):int");
    }
}
