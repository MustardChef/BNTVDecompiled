package com.applovin.impl.mediation;

import com.applovin.mediation.MaxReward;

/* loaded from: classes.dex */
public class MaxRewardImpl implements MaxReward {

    /* renamed from: a */
    private final String f799a;

    /* renamed from: b */
    private final int f800b;

    private MaxRewardImpl(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
        }
        this.f799a = str;
        this.f800b = i;
    }

    public static MaxReward create(int i, String str) {
        return new MaxRewardImpl(i, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    @Override // com.applovin.mediation.MaxReward
    public final int getAmount() {
        return this.f800b;
    }

    @Override // com.applovin.mediation.MaxReward
    public final String getLabel() {
        return this.f799a;
    }

    public String toString() {
        return "MaxReward{}";
    }
}
