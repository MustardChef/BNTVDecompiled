package com.google.zxing.pdf417.encoder;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.google.android.gms.cast.MediaError;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Common;
import okhttp3.internal.http.HttpStatusCodes;

/* loaded from: classes3.dex */
final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, 308, 436, 284, 646, 653, HttpStatusCodes.HTTP_PRECONDITION_REQUIRED, 379}, new int[]{bqk.f6534au, 562, bqk.f6526am, 755, 599, 524, 801, 132, 295, 116, 442, HttpStatusCodes.HTTP_PRECONDITION_REQUIRED, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, 640, MediaError.DetailedErrorCode.DASH_NETWORK, 536, 742, 677, 742, 687, 284, 193, 517, bqk.f6533at, 494, 263, 147, 593, 800, 571, 320, 803, 133, bqk.f6597cd, 390, 685, 330, 63, HttpStatusCodes.HTTP_GONE}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 287, 107, 505, 733, 877, 381, TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, 723, 476, 462, 172, 430, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 858, 822, 543, 376, 511, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, bqk.f6560bT, 535, 517, 352, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 158, 651, 201, 488, 502, 648, 733, 717, 83, HttpStatusCodes.HTTP_NOT_FOUND, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, HttpStatusCodes.HTTP_UNSUPPORTED_MEDIA_TYPE, 822, 93, bqk.f6556bP, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 244, 583, 620, 246, 148, 447, 631, 292, 908, 490, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 516, 258, 457, 907, 594, 723, 674, 292, bqk.f6532as, 96, 684, 432, 686, TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO, 860, 569, 193, bqk.f6557bQ, 129, 186, bqk.f6567ba, 287, 192, 775, bqk.f6536aw, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, bqk.f6530aq, 447, 90, 507, 48, bqk.f6562bV, 821, 808, 898, 784, 663, 627, 378, 382, 262, 380, TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, bqk.f6541bA, 726, 600, bqk.f6616cw, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, bqk.f6550bJ, 330, 539, 297, 827, 865, 37, 517, 834, 315, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, 194, 311, 913, bqk.f6535av, 190, 375, 850, 438, 733, 194, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 540, 913, 801, TypedValues.TransitionType.TYPE_DURATION, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, bqk.f6555bO, 257, 284, 549, bqk.f6548bH, 884, 315, 70, 329, 793, 490, bqk.f6534au, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, bqk.f6560bT, 289, 470, 637, 731, 66, 255, 917, bqk.f6616cw, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 374, 601, 192, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 142, 673, 687, 234, 722, 384, 177, 752, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 640, 455, 193, 689, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 805, 641, 48, 60, 732, 621, 895, 544, 261, 852, 655, 309, 697, 755, 756, 60, bqk.f6597cd, 773, 434, 421, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, 319, 9, 647, 550, 73, 914, 342, 126, 32, 681, MediaError.DetailedErrorCode.SMOOTH_NETWORK, 792, 620, 60, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 441, 180, 791, 893, 754, TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 383, bqk.f6562bV, 749, 760, bqk.f6552bL, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, TypedValues.MotionType.TYPE_POLAR_RELATIVETO, 829, 189, 20, 167, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, HttpStatusCodes.HTTP_NOT_FOUND, bqk.f6602ci, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, HttpStatusCodes.HTTP_PRECONDITION_REQUIRED, 207, HttpStatusCodes.HTTP_CONFLICT, 574, 118, 498, 285, 380, 350, 492, 197, bqk.f6615cv, 920, 155, 914, 299, bqk.f6565bY, 643, 294, 871, 306, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, 640, bqk.f6546bF, 794, 534, 539, 781, HttpStatusCodes.HTTP_CLIENT_TIMEOUT, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, bqk.f6532as, 383, 800, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, HttpStatusCodes.HTTP_PROXY_AUTH, 855, 85, 99, 62, 482, 180, 20, 297, HttpStatusCodes.HTTP_UNAVAILABLE_FOR_LEGAL_REASONS, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 384, 168, 190, 826, 328, 596, 786, 303, 570, 381, HttpStatusCodes.HTTP_UNSUPPORTED_MEDIA_TYPE, 641, 156, 237, 151, HttpStatusCodes.HTTP_TOO_MANY_REQUESTS, 531, 207, 676, 710, 89, 168, 304, 402, 40, 708, 575, 162, 864, bqk.f6565bY, 65, 861, 841, 512, 164, 477, bqk.f6559bS, 92, 358, 785, 288, 357, 850, 836, 827, 736, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, bqk.f6595cb, 361, 578, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, 167, 342, 244, 173, 35, 463, 651, 51, 699, 591, 452, 578, 37, 124, 298, MediaError.DetailedErrorCode.SMOOTH_NO_MEDIA_DATA, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, 578, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, HttpStatusCodes.HTTP_CLIENT_TIMEOUT, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, HttpStatusCodes.HTTP_EXPECTATION_FAILED, 158, bqk.f6548bH, 563, 564, 343, 693, 109, TypedValues.MotionType.TYPE_DRAW_PATH, 563, 365, 181, 772, 677, 310, bqk.f6595cb, 353, 708, HttpStatusCodes.HTTP_GONE, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, bqk.f6616cw, 757, 632, 695, 751, MediaError.DetailedErrorCode.SMOOTH_NETWORK, bqk.f6594ca, 184, 45, 787, 680, 18, 66, HttpStatusCodes.HTTP_PROXY_AUTH, 369, 54, 492, bqk.f6562bV, 613, 830, 922, 437, 519, 644, 905, 789, 420, 305, 441, 207, 300, 892, 827, 141, 537, 381, 662, 513, 56, bqk.f6603cj, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, bqk.f6541bA, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, 309, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, bqk.f6555bO, 548, 249, MediaError.DetailedErrorCode.DASH_NETWORK, 881, 699, 535, 673, 782, bqk.f6549bI, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, 308, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, bqk.f6533at, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, bqk.f6541bA, 749, MediaError.DetailedErrorCode.DASH_NETWORK, 54, 669, 316, 342, 299, 534, 105, 667, 488, 640, 672, 576, 540, 316, 486, 721, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 46, 656, 447, 171, 616, 464, 190, 531, 297, MediaError.DetailedErrorCode.DASH_NETWORK, 762, 752, 533, 175, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, 141, 919, 45, 780, HttpStatusCodes.HTTP_PROXY_AUTH, 164, MediaError.DetailedErrorCode.SMOOTH_NO_MEDIA_DATA, 899, 165, 726, 600, 325, 498, 655, 357, 752, 768, bqk.f6587bu, 849, 647, 63, 310, 863, bqk.f6602ci, 366, 304, 282, 738, 675, HttpStatusCodes.HTTP_GONE, 389, 244, 31, 121, 303, 263}};

    private PDF417ErrorCorrection() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getErrorCorrectionCodewordCount(int i) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
        }
        return 1 << (i + 1);
    }

    static int getRecommendedMinimumErrorCorrectionLevel(int i) throws WriterException {
        if (i > 0) {
            if (i <= 40) {
                return 2;
            }
            if (i <= 160) {
                return 3;
            }
            if (i <= 320) {
                return 4;
            }
            if (i <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
        throw new IllegalArgumentException("n must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String generateErrorCorrection(CharSequence charSequence, int i) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i2) + cArr[i3]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i3 > 0) {
                cArr[i3] = (char) ((cArr[i3 - 1] + (929 - ((EC_COEFFICIENTS[i][i3] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i3--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb = new StringBuilder(errorCorrectionCodewordCount);
        for (int i4 = errorCorrectionCodewordCount - 1; i4 >= 0; i4--) {
            if (cArr[i4] != 0) {
                cArr[i4] = (char) (929 - cArr[i4]);
            }
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }
}
