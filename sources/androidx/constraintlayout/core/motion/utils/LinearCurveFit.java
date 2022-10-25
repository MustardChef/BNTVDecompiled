package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate = true;
    double[] mSlopeTemp;

    /* renamed from: mT */
    private double[] f57mT;
    private double mTotalLength;

    /* renamed from: mY */
    private double[][] f58mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.mTotalLength = Double.NaN;
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mSlopeTemp = new double[length2];
        this.f57mT = dArr;
        this.f58mY = dArr2;
        if (length2 > 2) {
            double d = 0.0d;
            double d2 = 0.0d;
            int i = 0;
            while (i < dArr.length) {
                double d3 = dArr2[i][0];
                double d4 = dArr2[i][0];
                if (i > 0) {
                    Math.hypot(d3 - d, d4 - d2);
                }
                i++;
                d = d3;
                d2 = d4;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double d) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.f57mT;
        int length = dArr.length;
        if (d <= dArr[0]) {
            return 0.0d;
        }
        int i = length - 1;
        if (d >= dArr[i]) {
            return this.mTotalLength;
        }
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        while (i2 < i) {
            double[][] dArr2 = this.f58mY;
            double d5 = dArr2[i2][0];
            double d6 = dArr2[i2][1];
            if (i2 > 0) {
                d2 += Math.hypot(d5 - d3, d6 - d4);
            }
            double[] dArr3 = this.f57mT;
            if (d == dArr3[i2]) {
                return d2;
            }
            int i3 = i2 + 1;
            if (d < dArr3[i3]) {
                double d7 = (d - dArr3[i2]) / (dArr3[i3] - dArr3[i2]);
                double[][] dArr4 = this.f58mY;
                double d8 = 1.0d - d7;
                return d2 + Math.hypot(d6 - ((dArr4[i2][1] * d8) + (dArr4[i3][1] * d7)), d5 - ((dArr4[i2][0] * d8) + (dArr4[i3][0] * d7)));
            }
            i2 = i3;
            d3 = d5;
            d4 = d6;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        double[] dArr2 = this.f57mT;
        int length = dArr2.length;
        int i = 0;
        int length2 = this.f58mY[0].length;
        if (this.mExtrapolate) {
            if (d <= dArr2[0]) {
                getSlope(dArr2[0], this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    dArr[i2] = this.f58mY[0][i2] + ((d - this.f57mT[0]) * this.mSlopeTemp[i2]);
                }
                return;
            }
            int i3 = length - 1;
            if (d >= dArr2[i3]) {
                getSlope(dArr2[i3], this.mSlopeTemp);
                while (i < length2) {
                    dArr[i] = this.f58mY[i3][i] + ((d - this.f57mT[i3]) * this.mSlopeTemp[i]);
                    i++;
                }
                return;
            }
        } else if (d <= dArr2[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                dArr[i4] = this.f58mY[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr2[i5]) {
                while (i < length2) {
                    dArr[i] = this.f58mY[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.f57mT[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    dArr[i7] = this.f58mY[i6][i7];
                }
            }
            double[] dArr3 = this.f57mT;
            int i8 = i6 + 1;
            if (d < dArr3[i8]) {
                double d2 = (d - dArr3[i6]) / (dArr3[i8] - dArr3[i6]);
                while (i < length2) {
                    double[][] dArr4 = this.f58mY;
                    dArr[i] = (dArr4[i6][i] * (1.0d - d2)) + (dArr4[i8][i] * d2);
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        double[] dArr = this.f57mT;
        int length = dArr.length;
        int i = 0;
        int length2 = this.f58mY[0].length;
        if (this.mExtrapolate) {
            if (d <= dArr[0]) {
                getSlope(dArr[0], this.mSlopeTemp);
                for (int i2 = 0; i2 < length2; i2++) {
                    fArr[i2] = (float) (this.f58mY[0][i2] + ((d - this.f57mT[0]) * this.mSlopeTemp[i2]));
                }
                return;
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                getSlope(dArr[i3], this.mSlopeTemp);
                while (i < length2) {
                    fArr[i] = (float) (this.f58mY[i3][i] + ((d - this.f57mT[i3]) * this.mSlopeTemp[i]));
                    i++;
                }
                return;
            }
        } else if (d <= dArr[0]) {
            for (int i4 = 0; i4 < length2; i4++) {
                fArr[i4] = (float) this.f58mY[0][i4];
            }
            return;
        } else {
            int i5 = length - 1;
            if (d >= dArr[i5]) {
                while (i < length2) {
                    fArr[i] = (float) this.f58mY[i5][i];
                    i++;
                }
                return;
            }
        }
        int i6 = 0;
        while (i6 < length - 1) {
            if (d == this.f57mT[i6]) {
                for (int i7 = 0; i7 < length2; i7++) {
                    fArr[i7] = (float) this.f58mY[i6][i7];
                }
            }
            double[] dArr2 = this.f57mT;
            int i8 = i6 + 1;
            if (d < dArr2[i8]) {
                double d2 = (d - dArr2[i6]) / (dArr2[i8] - dArr2[i6]);
                while (i < length2) {
                    double[][] dArr3 = this.f58mY;
                    fArr[i] = (float) ((dArr3[i6][i] * (1.0d - d2)) + (dArr3[i8][i] * d2));
                    i++;
                }
                return;
            }
            i6 = i8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        double[] dArr = this.f57mT;
        int length = dArr.length;
        int i2 = 0;
        if (this.mExtrapolate) {
            if (d <= dArr[0]) {
                return this.f58mY[0][i] + ((d - dArr[0]) * getSlope(dArr[0], i));
            }
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                return this.f58mY[i3][i] + ((d - dArr[i3]) * getSlope(dArr[i3], i));
            }
        } else if (d <= dArr[0]) {
            return this.f58mY[0][i];
        } else {
            int i4 = length - 1;
            if (d >= dArr[i4]) {
                return this.f58mY[i4][i];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f57mT;
            if (d == dArr2[i2]) {
                return this.f58mY[i2][i];
            }
            int i5 = i2 + 1;
            if (d < dArr2[i5]) {
                double d2 = (d - dArr2[i2]) / (dArr2[i5] - dArr2[i2]);
                double[][] dArr3 = this.f58mY;
                return (dArr3[i2][i] * (1.0d - d2)) + (dArr3[i5][i] * d2);
            }
            i2 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        double[] dArr2 = this.f57mT;
        int length = dArr2.length;
        int length2 = this.f58mY[0].length;
        if (d <= dArr2[0]) {
            d = dArr2[0];
        } else {
            int i = length - 1;
            if (d >= dArr2[i]) {
                d = dArr2[i];
            }
        }
        int i2 = 0;
        while (i2 < length - 1) {
            double[] dArr3 = this.f57mT;
            int i3 = i2 + 1;
            if (d <= dArr3[i3]) {
                double d2 = dArr3[i3] - dArr3[i2];
                double d3 = dArr3[i2];
                for (int i4 = 0; i4 < length2; i4++) {
                    double[][] dArr4 = this.f58mY;
                    dArr[i4] = (dArr4[i3][i4] - dArr4[i2][i4]) / d2;
                }
                return;
            }
            i2 = i3;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        double[] dArr = this.f57mT;
        int length = dArr.length;
        int i2 = 0;
        if (d < dArr[0]) {
            d = dArr[0];
        } else {
            int i3 = length - 1;
            if (d >= dArr[i3]) {
                d = dArr[i3];
            }
        }
        while (i2 < length - 1) {
            double[] dArr2 = this.f57mT;
            int i4 = i2 + 1;
            if (d <= dArr2[i4]) {
                double d2 = dArr2[i4] - dArr2[i2];
                double d3 = dArr2[i2];
                double[][] dArr3 = this.f58mY;
                return (dArr3[i4][i] - dArr3[i2][i]) / d2;
            }
            i2 = i4;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f57mT;
    }
}
