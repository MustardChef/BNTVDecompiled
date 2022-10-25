package com.fasterxml.jackson.core.sym;

/* loaded from: classes2.dex */
public final class Name2 extends Name {

    /* renamed from: q1 */
    private final int f2784q1;

    /* renamed from: q2 */
    private final int f2785q2;

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    Name2(String str, int i, int i2, int i3) {
        super(str, i);
        this.f2784q1 = i2;
        this.f2785q2 = i3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.f2784q1 && i2 == this.f2785q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.f2784q1 && iArr[1] == this.f2785q2;
    }
}
