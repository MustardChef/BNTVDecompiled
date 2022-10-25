package abhishekti7.unicorn.filepicker.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Utils {
    public static Map<Integer, String> mapOfMonths = new HashMap<Integer, String>() { // from class: abhishekti7.unicorn.filepicker.utils.Utils.1
        {
            put(1, "Jan");
            put(2, "Feb");
            put(3, "Mar");
            put(4, "Apr");
            put(5, "May");
            put(6, "Jun");
            put(7, "Jul");
            put(8, "Aug");
            put(9, "Sep");
            put(10, "Oct");
            put(11, "Nov");
            put(12, "Dec");
        }
    };

    public static String longToReadableDate(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return mapOfMonths.get(Integer.valueOf(calendar.get(2) + 1)) + " " + calendar.get(5) + ", " + calendar.get(1);
    }
}
