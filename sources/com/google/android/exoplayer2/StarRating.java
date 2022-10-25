package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.base.Objects;

/* loaded from: classes2.dex */
public final class StarRating extends Rating {
    public static final Bundleable.Creator<StarRating> CREATOR = $$Lambda$StarRating$PFFEnOFJiYnmZMUGPr8Imzm26I8.INSTANCE;
    private static final int FIELD_MAX_STARS = 1;
    private static final int FIELD_STAR_RATING = 2;
    private static final int MAX_STARS_DEFAULT = 5;
    private static final int TYPE = 2;
    private final int maxStars;
    private final float starRating;

    public StarRating(int i) {
        Assertions.checkArgument(i > 0, "maxStars must be a positive integer");
        this.maxStars = i;
        this.starRating = -1.0f;
    }

    public StarRating(int i, float f) {
        boolean z = true;
        Assertions.checkArgument(i > 0, "maxStars must be a positive integer");
        Assertions.checkArgument((f < 0.0f || f > ((float) i)) ? false : false, "starRating is out of range [0, maxStars]");
        this.maxStars = i;
        this.starRating = f;
    }

    @Override // com.google.android.exoplayer2.Rating
    public boolean isRated() {
        return this.starRating != -1.0f;
    }

    public int getMaxStars() {
        return this.maxStars;
    }

    public float getStarRating() {
        return this.starRating;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.maxStars), Float.valueOf(this.starRating));
    }

    public boolean equals(Object obj) {
        if (obj instanceof StarRating) {
            StarRating starRating = (StarRating) obj;
            return this.maxStars == starRating.maxStars && this.starRating == starRating.starRating;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(keyForField(0), 2);
        bundle.putInt(keyForField(1), this.maxStars);
        bundle.putFloat(keyForField(2), this.starRating);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StarRating fromBundle(Bundle bundle) {
        Assertions.checkArgument(bundle.getInt(keyForField(0), -1) == 2);
        int i = bundle.getInt(keyForField(1), 5);
        float f = bundle.getFloat(keyForField(2), -1.0f);
        if (f == -1.0f) {
            return new StarRating(i);
        }
        return new StarRating(i, f);
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
