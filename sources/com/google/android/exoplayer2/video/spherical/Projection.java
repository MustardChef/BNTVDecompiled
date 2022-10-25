package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
final class Projection {
    public static final int DRAW_MODE_TRIANGLES = 0;
    public static final int DRAW_MODE_TRIANGLES_FAN = 2;
    public static final int DRAW_MODE_TRIANGLES_STRIP = 1;
    public static final int POSITION_COORDS_PER_VERTEX = 3;
    public static final int TEXTURE_COORDS_PER_VERTEX = 2;
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface DrawMode {
    }

    public static Projection createEquirectangular(int i) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public static Projection createEquirectangular(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        float f4;
        int i5;
        int i6;
        int i7;
        float[] fArr;
        int i8 = i;
        int i9 = i2;
        Assertions.checkArgument(f > 0.0f);
        Assertions.checkArgument(i8 >= 1);
        Assertions.checkArgument(i9 >= 1);
        Assertions.checkArgument(f2 > 0.0f && f2 <= 180.0f);
        Assertions.checkArgument(f3 > 0.0f && f3 <= 360.0f);
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f3);
        float f5 = radians / i8;
        float f6 = radians2 / i9;
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[i11 * 3];
        float[] fArr3 = new float[i11 * 2];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f7 = radians / 2.0f;
            float f8 = (i12 * f5) - f7;
            int i15 = i12 + 1;
            float f9 = (i15 * f5) - f7;
            int i16 = 0;
            while (i16 < i10) {
                float f10 = f8;
                int i17 = i15;
                int i18 = 0;
                while (i18 < 2) {
                    if (i18 == 0) {
                        f4 = f10;
                        i4 = i10;
                    } else {
                        i4 = i10;
                        f4 = f9;
                    }
                    float f11 = i16 * f6;
                    float f12 = f6;
                    int i19 = i13 + 1;
                    int i20 = i16;
                    double d = f;
                    float f13 = f5;
                    int i21 = i18;
                    double d2 = (f11 + 3.1415927f) - (radians2 / 2.0f);
                    double d3 = f4;
                    float[] fArr4 = fArr3;
                    float f14 = f9;
                    fArr2[i13] = -((float) (Math.sin(d2) * d * Math.cos(d3)));
                    int i22 = i19 + 1;
                    int i23 = i12;
                    fArr2[i19] = (float) (d * Math.sin(d3));
                    int i24 = i22 + 1;
                    fArr2[i22] = (float) (d * Math.cos(d2) * Math.cos(d3));
                    int i25 = i14 + 1;
                    fArr4[i14] = f11 / radians2;
                    int i26 = i25 + 1;
                    fArr4[i25] = ((i23 + i21) * f13) / radians;
                    if (i20 == 0 && i21 == 0) {
                        i5 = i2;
                        i6 = i20;
                        i7 = i21;
                    } else {
                        i5 = i2;
                        i6 = i20;
                        i7 = i21;
                        if (i6 != i5 || i7 != 1) {
                            fArr = fArr4;
                            i14 = i26;
                            i13 = i24;
                            i18 = i7 + 1;
                            i9 = i5;
                            i16 = i6;
                            fArr3 = fArr;
                            i12 = i23;
                            i10 = i4;
                            f6 = f12;
                            f5 = f13;
                            f9 = f14;
                        }
                    }
                    System.arraycopy(fArr2, i24 - 3, fArr2, i24, 3);
                    i24 += 3;
                    fArr = fArr4;
                    System.arraycopy(fArr, i26 - 2, fArr, i26, 2);
                    i26 += 2;
                    i14 = i26;
                    i13 = i24;
                    i18 = i7 + 1;
                    i9 = i5;
                    i16 = i6;
                    fArr3 = fArr;
                    i12 = i23;
                    i10 = i4;
                    f6 = f12;
                    f5 = f13;
                    f9 = f14;
                }
                float f15 = f5;
                int i27 = i16;
                int i28 = i9;
                int i29 = i27 + 1;
                f8 = f10;
                i15 = i17;
                i10 = i10;
                f6 = f6;
                f5 = f15;
                f9 = f9;
                i9 = i28;
                i16 = i29;
            }
            i8 = i;
            i12 = i15;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr2, fArr3, 1)), i3);
    }

    public Projection(Mesh mesh, int i) {
        this(mesh, mesh, i);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i;
        this.singleMesh = mesh == mesh2;
    }

    /* loaded from: classes2.dex */
    public static final class SubMesh {
        public static final int VIDEO_TEXTURE_ID = 0;
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public int getSubMeshCount() {
            return this.subMeshes.length;
        }

        public SubMesh getSubMesh(int i) {
            return this.subMeshes[i];
        }
    }
}
