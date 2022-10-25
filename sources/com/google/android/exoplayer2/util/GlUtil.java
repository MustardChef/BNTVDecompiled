package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import androidx.work.Data;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* loaded from: classes2.dex */
public final class GlUtil {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "GlUtil";
    public static final int TEXTURE_ID_UNSET = -1;
    public static boolean glAssertionsEnabled = false;

    /* loaded from: classes2.dex */
    public static final class UnsupportedEglVersionException extends Exception {
    }

    /* loaded from: classes2.dex */
    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Program {
        private final int programId;

        public Program(String str, String str2) {
            this.programId = GLES20.glCreateProgram();
            GlUtil.checkGlError();
            addShader(35633, str);
            addShader(35632, str2);
        }

        public Program(Context context, String str, String str2) throws IOException {
            this(GlUtil.loadAsset(context, str), GlUtil.loadAsset(context, str2));
        }

        public Program(String[] strArr, String[] strArr2) {
            this(TextUtils.join("\n", strArr), TextUtils.join("\n", strArr2));
        }

        public void use() {
            GLES20.glLinkProgram(this.programId);
            int[] iArr = {0};
            GLES20.glGetProgramiv(this.programId, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String valueOf = String.valueOf(GLES20.glGetProgramInfoLog(this.programId));
                GlUtil.throwGlException(valueOf.length() != 0 ? "Unable to link shader program: \n".concat(valueOf) : new String("Unable to link shader program: \n"));
            }
            GlUtil.checkGlError();
            GLES20.glUseProgram(this.programId);
        }

        public void delete() {
            GLES20.glDeleteProgram(this.programId);
        }

        public int getAttribLocation(String str) {
            return GLES20.glGetAttribLocation(this.programId, str);
        }

        public int getUniformLocation(String str) {
            return GLES20.glGetUniformLocation(this.programId, str);
        }

        public Attribute[] getAttributes() {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.programId, 35721, iArr, 0);
            if (iArr[0] != 2) {
                throw new IllegalStateException("Expected two attributes.");
            }
            Attribute[] attributeArr = new Attribute[iArr[0]];
            for (int i = 0; i < iArr[0]; i++) {
                attributeArr[i] = createAttribute(i);
            }
            return attributeArr;
        }

        public Uniform[] getUniforms() {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.programId, 35718, iArr, 0);
            Uniform[] uniformArr = new Uniform[iArr[0]];
            for (int i = 0; i < iArr[0]; i++) {
                uniformArr[i] = createUniform(i);
            }
            return uniformArr;
        }

        private Attribute createAttribute(int i) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.programId, 35722, iArr, 0);
            byte[] bArr = new byte[iArr[0]];
            int[] iArr2 = new int[1];
            int i2 = this.programId;
            int i3 = iArr[0];
            GLES20.glGetActiveAttrib(i2, i, i3, iArr2, 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, GlUtil.strlen(bArr));
            return new Attribute(str, i, getAttribLocation(str));
        }

        private Uniform createUniform(int i) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(this.programId, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            byte[] bArr = new byte[iArr[0]];
            int i2 = this.programId;
            int i3 = iArr[0];
            GLES20.glGetActiveUniform(i2, i, i3, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, GlUtil.strlen(bArr));
            return new Uniform(str, getUniformLocation(str), iArr2[0]);
        }

        private void addShader(int i, String str) {
            int glCreateShader = GLES20.glCreateShader(i);
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = {0};
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] != 1) {
                String glGetShaderInfoLog = GLES20.glGetShaderInfoLog(glCreateShader);
                StringBuilder sb = new StringBuilder(String.valueOf(glGetShaderInfoLog).length() + 10 + String.valueOf(str).length());
                sb.append(glGetShaderInfoLog);
                sb.append(", source: ");
                sb.append(str);
                GlUtil.throwGlException(sb.toString());
            }
            GLES20.glAttachShader(this.programId, glCreateShader);
            GLES20.glDeleteShader(glCreateShader);
            GlUtil.checkGlError();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Attribute {
        private Buffer buffer;
        private final int index;
        private final int location;
        public final String name;
        private int size;

        public Attribute(String str, int i, int i2) {
            this.name = str;
            this.index = i;
            this.location = i2;
        }

        public void setBuffer(float[] fArr, int i) {
            this.buffer = GlUtil.createBuffer(fArr);
            this.size = i;
        }

        public void bind() {
            GLES20.glBindBuffer(34962, 0);
            GLES20.glVertexAttribPointer(this.location, this.size, 5126, false, 0, (Buffer) Assertions.checkNotNull(this.buffer, "call setBuffer before bind"));
            GLES20.glEnableVertexAttribArray(this.index);
            GlUtil.checkGlError();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Uniform {
        private final int location;
        public final String name;
        private int texId;
        private final int type;
        private int unit;
        private final float[] value = new float[16];

        public Uniform(String str, int i, int i2) {
            this.name = str;
            this.location = i;
            this.type = i2;
        }

        public void setSamplerTexId(int i, int i2) {
            this.texId = i;
            this.unit = i2;
        }

        public void setFloat(float f) {
            this.value[0] = f;
        }

        public void setFloats(float[] fArr) {
            System.arraycopy(fArr, 0, this.value, 0, fArr.length);
        }

        public void bind() {
            int i = this.type;
            if (i == 5126) {
                GLES20.glUniform1fv(this.location, 1, this.value, 0);
                GlUtil.checkGlError();
            } else if (i == 35676) {
                GLES20.glUniformMatrix4fv(this.location, 1, false, this.value, 0);
                GlUtil.checkGlError();
            } else if (this.texId == 0) {
                throw new IllegalStateException("Call setSamplerTexId before bind.");
            } else {
                GLES20.glActiveTexture(this.unit + 33984);
                int i2 = this.type;
                if (i2 == 36198) {
                    GLES20.glBindTexture(36197, this.texId);
                } else if (i2 == 35678) {
                    GLES20.glBindTexture(3553, this.texId);
                } else {
                    int i3 = this.type;
                    StringBuilder sb = new StringBuilder(36);
                    sb.append("Unexpected uniform type: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                GLES20.glUniform1i(this.location, this.unit);
                GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10242, 33071);
                GLES20.glTexParameteri(3553, 10243, 33071);
                GlUtil.checkGlError();
            }
        }
    }

    private GlUtil() {
    }

    public static boolean isProtectedContentExtensionSupported(Context context) {
        String eglQueryString;
        if (Util.SDK_INT < 24) {
            return false;
        }
        if (Util.SDK_INT >= 26 || !("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return (Util.SDK_INT >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_PROTECTED_CONTENT);
        }
        return false;
    }

    public static boolean isSurfacelessContextExtensionSupported() {
        String eglQueryString;
        return Util.SDK_INT >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT);
    }

    public static EGLDisplay createEglDisplay() {
        return Api17.createEglDisplay();
    }

    public static EGLContext createEglContext(EGLDisplay eGLDisplay) throws UnsupportedEglVersionException {
        return Api17.createEglContext(eGLDisplay);
    }

    public static EGLSurface getEglSurface(EGLDisplay eGLDisplay, Object obj) {
        return Api17.getEglSurface(eGLDisplay, obj);
    }

    public static void checkGlError() {
        int i = 0;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
            Log.m383e(TAG, valueOf.length() != 0 ? "glError ".concat(valueOf) : new String("glError "));
            i = glGetError;
        }
        if (i != 0) {
            String valueOf2 = String.valueOf(GLU.gluErrorString(i));
            throwGlException(valueOf2.length() != 0 ? "glError ".concat(valueOf2) : new String("glError "));
        }
    }

    public static void focusSurface(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2) {
        Api17.focusSurface(eGLDisplay, eGLContext, eGLSurface, i, i2);
    }

    public static void deleteTexture(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        checkGlError();
    }

    public static void destroyEglContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
        Api17.destroyEglContext(eGLDisplay, eGLContext);
    }

    public static FloatBuffer createBuffer(float[] fArr) {
        return (FloatBuffer) createBuffer(fArr.length).put(fArr).flip();
    }

    public static FloatBuffer createBuffer(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static String loadAsset(Context context, String str) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            return Util.fromUtf8Bytes(Util.toByteArray(inputStream));
        } finally {
            Util.closeQuietly(inputStream);
        }
    }

    public static int createExternalTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError();
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void throwGlException(String str) {
        Log.m383e(TAG, str);
        if (glAssertionsEnabled) {
            throw new GlException(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkEglException(boolean z, String str) {
        if (z) {
            return;
        }
        throwGlException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int strlen(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] == 0) {
                return i;
            }
        }
        return bArr.length;
    }

    /* loaded from: classes2.dex */
    private static final class Api17 {
        private Api17() {
        }

        public static EGLDisplay createEglDisplay() {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            GlUtil.checkEglException(!eglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
            if (!EGL14.eglInitialize(eglGetDisplay, new int[1], 0, new int[1], 0)) {
                GlUtil.throwGlException("Error in eglInitialize.");
            }
            GlUtil.checkGlError();
            return eglGetDisplay;
        }

        public static EGLContext createEglContext(EGLDisplay eGLDisplay) throws UnsupportedEglVersionException {
            EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, getEglConfig(eGLDisplay), EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
            if (eglCreateContext == null) {
                EGL14.eglTerminate(eGLDisplay);
                throw new UnsupportedEglVersionException();
            }
            GlUtil.checkGlError();
            return eglCreateContext;
        }

        public static EGLSurface getEglSurface(EGLDisplay eGLDisplay, Object obj) {
            return EGL14.eglCreateWindowSurface(eGLDisplay, getEglConfig(eGLDisplay), obj, new int[]{12344}, 0);
        }

        public static void focusSurface(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i, int i2) {
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(36006, iArr, 0);
            if (iArr[0] != 0) {
                GLES20.glBindFramebuffer(36160, 0);
            }
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            GLES20.glViewport(0, 0, i, i2);
        }

        public static void destroyEglContext(EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (eGLDisplay == null) {
                return;
            }
            EGL14.eglMakeCurrent(eGLDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            int eglGetError = EGL14.eglGetError();
            boolean z = eglGetError == 12288;
            StringBuilder sb = new StringBuilder(36);
            sb.append("Error releasing context: ");
            sb.append(eglGetError);
            GlUtil.checkEglException(z, sb.toString());
            if (eGLContext != null) {
                EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                int eglGetError2 = EGL14.eglGetError();
                boolean z2 = eglGetError2 == 12288;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Error destroying context: ");
                sb2.append(eglGetError2);
                GlUtil.checkEglException(z2, sb2.toString());
            }
            EGL14.eglReleaseThread();
            int eglGetError3 = EGL14.eglGetError();
            boolean z3 = eglGetError3 == 12288;
            StringBuilder sb3 = new StringBuilder(35);
            sb3.append("Error releasing thread: ");
            sb3.append(eglGetError3);
            GlUtil.checkEglException(z3, sb3.toString());
            EGL14.eglTerminate(eGLDisplay);
            int eglGetError4 = EGL14.eglGetError();
            boolean z4 = eglGetError4 == 12288;
            StringBuilder sb4 = new StringBuilder(38);
            sb4.append("Error terminating display: ");
            sb4.append(eglGetError4);
            GlUtil.checkEglException(z4, sb4.toString());
        }

        private static EGLConfig getEglConfig(EGLDisplay eGLDisplay) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(eGLDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                GlUtil.throwGlException("eglChooseConfig failed.");
            }
            return eGLConfigArr[0];
        }
    }
}
