package com.google.android.mediahome.video;

import android.media.tv.TvContentRating;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* compiled from: com.google.android.mediahome:video@@1.0.0 */
/* loaded from: classes3.dex */
final class VideoContractUtils {
    static final TvContentRating[] EMPTY = new TvContentRating[0];

    private VideoContractUtils() {
    }

    public static String contentRatingsToString(TvContentRating[] tvContentRatingArr) {
        if (tvContentRatingArr == null || tvContentRatingArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(tvContentRatingArr[0].flattenToString());
        for (int i = 1; i < tvContentRatingArr.length; i++) {
            sb.append(",");
            sb.append(tvContentRatingArr[i].flattenToString());
        }
        return sb.toString();
    }

    public static TvContentRating[] stringToContentRatings(String str) {
        if (TextUtils.isEmpty(str)) {
            return EMPTY;
        }
        String[] split = str.split("\\s*,\\s*", -1);
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            try {
                arrayList.add(TvContentRating.unflattenFromString(str2));
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 44);
                sb.append("Can't parse the content rating: '");
                sb.append(str2);
                sb.append("', skipping");
                Log.w("VideoContractUtils", sb.toString(), e);
            }
        }
        return arrayList.isEmpty() ? EMPTY : (TvContentRating[]) arrayList.toArray(new TvContentRating[0]);
    }
}
