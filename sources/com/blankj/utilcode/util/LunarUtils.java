package com.blankj.utilcode.util;

import com.google.android.gms.auth.api.phone.SmsRetrieverStatusCodes;

/* loaded from: classes.dex */
public final class LunarUtils {
    private static int[] lunar_month_days = {1887, 5780, 5802, 19157, 2742, 50359, 1198, 2646, 46378, 7466, 3412, 30122, 5482, 67949, 2396, 5294, 43597, 6732, 6954, 36181, 2772, 4954, 18781, 2396, 54427, 5274, 6730, 47781, 5800, 6868, 21210, 4790, 59703, 2350, 5270, 46667, 3402, 3496, 38325, 1388, 4782, 18735, 2350, 52374, 6804, 7498, 44457, 2906, 1388, 29294, 4700, 63789, 6442, 6804, 56138, 5802, 2772, 38235, 1210, 4698, 22827, 5418, 63125, 3476, 5802, 43701, 2484, 5302, 27223, 2646, 70954, 7466, 3412, 54698, 5482, 2412, 38062, 5294, 2636, 32038, 6954, 60245, 2772, 4826, 43357, 2394, 5274, 39501, 6730, 72357, 5800, 5844, 53978, 4790, 2358, 38039, 5270, 87627, 3402, 3496, 54708, 5484, 4782, 43311, 2350, 3222, 27978, 7498, 68965, 2904, 5484, 45677, 4700, 6444, 39573, 6804, 6986, 19285, 2772, 62811, 1210, 4698, 47403, 5418, 5780, 38570, 5546, 76469, 2420, 5302, 51799, 2646, 5414, SmsRetrieverStatusCodes.API_NOT_AVAILABLE, 3412, 5546, 18869, 2412, 54446, 5276, 6732, 48422, 6822, 2900, 28010, 4826, 92509, 2394, 5274, 55883, 6730, 6820, 47956, 5812, 2778, 18779, 2358, 62615, 5270, 5450, 46757, 3492, 5556, 27318, 4718, 67887, 2350, 3222, 52554, 7498, 3428, 38252, 5468, 4700, 31022, 6444, 64149, 6804, 6986, 43861, 2772, 5338, 35421, 2650, 70955, 5418, 5780, 54954, 5546, 2740, 38074, 5302, 2646, 29991, 3366, 61011, 3412, 5546, 43445, 2412, 5294, 35406, 6732, 72998, 6820, 6996, 52586, 2778, 2396, 38045, 5274, 6698, 23333, 6820, 64338, 5812, 2746, 43355, 2358, 5270, 39499, 5450, 79525, 3492, 5548};
    private static int[] solar_1_1 = {1887, 966732, 967231, 967733, 968265, 968766, 969297, 969798, 970298, 970829, 971330, 971830, 972362, 972863, 973395, 973896, 974397, 974928, 975428, 975929, 976461, 976962, 977462, 977994, 978494, 979026, 979526, 980026, 980558, 981059, 981559, 982091, 982593, 983124, 983624, 984124, 984656, 985157, 985656, 986189, 986690, 987191, 987722, 988222, 988753, 989254, 989754, 990286, 990788, 991288, 991819, 992319, 992851, 993352, 993851, 994383, 994885, 995385, 995917, 996418, 996918, 997450, 997949, 998481, 998982, 999483, 1000014, 1000515, 1001016, 1001548, 1002047, 1002578, 1003080, 1003580, 1004111, 1004613, 1005113, 1005645, 1006146, 1006645, 1007177, 1007678, 1008209, 1008710, 1009211, 1009743, 1010243, 1010743, 1011275, 1011775, 1012306, 1012807, 1013308, 1013840, 1014341, 1014841, 1015373, 1015874, 1016404, 1016905, 1017405, 1017937, 1018438, 1018939, 1019471, 1019972, 1020471, 1021002, 1021503, 1022035, 1022535, 1023036, 1023568, 1024069, 1024568, 1025100, 1025601, 1026102, 1026633, 1027133, 1027666, 1028167, 1028666, 1029198, 1029699, 1030199, 1030730, 1031231, 1031763, 1032264, 1032764, 1033296, 1033797, 1034297, 1034828, 1035329, 1035830, 1036362, 1036861, 1037393, 1037894, 1038394, 1038925, 1039427, 1039927, 1040459, 1040959, 1041491, 1041992, 1042492, 1043023, 1043524, 1044024, 1044556, 1045057, 1045558, 1046090, 1046590, 1047121, 1047622, 1048122, 1048654, 1049154, 1049655, 1050187, 1050689, 1051219, 1051720, 1052220, 1052751, 1053252, 1053752, 1054284, 1054786, 1055285, 1055817, 1056317, 1056849, 1057349, 1057850, 1058382, 1058883, 1059383, 1059915, 1060415, 1060947, 1061447, 1061947, 1062479, 1062981, 1063480, 1064012, 1064514, 1065014, 1065545, 1066045, 1066577, 1067078, 1067578, 1068110, 1068611, 1069112, 1069642, 1070142, 1070674, 1071175, 1071675, 1072207, 1072709, 1073209, 1073740, 1074241, 1074741, 1075273, 1075773, 1076305, 1076807, 1077308, 1077839, 1078340, 1078840, 1079372, 1079871, 1080403, 1080904};

    /* loaded from: classes.dex */
    public static class Lunar {
        public boolean isLeap;
        public int lunarDay;
        public int lunarMonth;
        public int lunarYear;
    }

    /* loaded from: classes.dex */
    public static class Solar {
        public int solarDay;
        public int solarMonth;
        public int solarYear;
    }

    private LunarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static int GetBitInt(int i, int i2, int i3) {
        return (i & (((1 << i2) - 1) << i3)) >> i3;
    }

    public static Solar LunarToSolar(Lunar lunar) {
        int i = lunar_month_days[lunar.lunarYear - lunar_month_days[0]];
        int GetBitInt = GetBitInt(i, 4, 13);
        if (!lunar.isLeap) {
            GetBitInt = (lunar.lunarMonth <= GetBitInt || GetBitInt == 0) ? lunar.lunarMonth - 1 : lunar.lunarMonth;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < GetBitInt; i3++) {
            i2 += GetBitInt(i, 1, 12 - i3) == 1 ? 30 : 29;
        }
        int i4 = i2 + lunar.lunarDay;
        int i5 = solar_1_1[lunar.lunarYear - solar_1_1[0]];
        return SolarFromInt((SolarToInt(GetBitInt(i5, 12, 9), GetBitInt(i5, 4, 5), GetBitInt(i5, 5, 0)) + i4) - 1);
    }

    private static Solar SolarFromInt(long j) {
        long j2 = ((10000 * j) + 14780) / 3652425;
        long j3 = j - ((((j2 * 365) + (j2 / 4)) - (j2 / 100)) + (j2 / 400));
        if (j3 < 0) {
            j2--;
            j3 = j - ((((365 * j2) + (j2 / 4)) - (j2 / 100)) + (j2 / 400));
        }
        long j4 = ((100 * j3) + 52) / 3060;
        long j5 = 2 + j4;
        long j6 = j2 + (j5 / 12);
        Solar solar = new Solar();
        solar.solarYear = (int) j6;
        solar.solarMonth = (int) ((j5 % 12) + 1);
        solar.solarDay = (int) ((j3 - (((j4 * 306) + 5) / 10)) + 1);
        return solar;
    }

    private static long SolarToInt(int i, int i2, int i3) {
        int i4 = (i2 + 9) % 12;
        int i5 = i - (i4 / 10);
        return (((i5 * 365) + (i5 / 4)) - (i5 / 100)) + (i5 / 400) + (((i4 * 306) + 5) / 10) + (i3 - 1);
    }

    public static Lunar SolarToLunar(Solar solar) {
        Lunar lunar = new Lunar();
        int i = solar.solarYear - solar_1_1[0];
        int i2 = (solar.solarYear << 9) | (solar.solarMonth << 5) | solar.solarDay;
        int[] iArr = solar_1_1;
        if (iArr[i] > i2) {
            i--;
        }
        int i3 = iArr[i];
        int GetBitInt = GetBitInt(i3, 12, 9);
        int GetBitInt2 = GetBitInt(i3, 4, 5);
        int GetBitInt3 = GetBitInt(i3, 5, 0);
        int i4 = lunar_month_days[i];
        int GetBitInt4 = GetBitInt(i4, 4, 13);
        int i5 = i + solar_1_1[0];
        long SolarToInt = (SolarToInt(solar.solarYear, solar.solarMonth, solar.solarDay) - SolarToInt(GetBitInt, GetBitInt2, GetBitInt3)) + 1;
        int i6 = 1;
        for (int i7 = 0; i7 < 13; i7++) {
            long j = GetBitInt(i4, 1, 12 - i7) == 1 ? 30 : 29;
            if (SolarToInt <= j) {
                break;
            }
            i6++;
            SolarToInt -= j;
        }
        int i8 = (int) SolarToInt;
        lunar.lunarYear = i5;
        lunar.lunarMonth = i6;
        lunar.isLeap = false;
        if (GetBitInt4 != 0 && i6 > GetBitInt4) {
            lunar.lunarMonth = i6 - 1;
            if (i6 == GetBitInt4 + 1) {
                lunar.isLeap = true;
            }
        }
        lunar.lunarDay = i8;
        return lunar;
    }

    public static String lunarYearToGanZhi(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i - 4;
        sb.append(new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"}[i2 % 10]);
        sb.append(new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"}[i2 % 12]);
        sb.append("年");
        return sb.toString();
    }
}
