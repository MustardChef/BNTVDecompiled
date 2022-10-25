package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.media.ExifInterface;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.ads.interactivemedia.p034v3.internal.bqk;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class ImageUtils {
    private ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap addFrame(Bitmap bitmap, int i, int i2) {
        return addFrame(bitmap, i, i2, false);
    }

    public static Bitmap addFrame(Bitmap bitmap, int i, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int i3 = i << 1;
        int width = bitmap.getWidth() + i3;
        int height = bitmap.getHeight() + i3;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, width, height);
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i3);
        canvas.drawRect(rect, paint);
        float f = i;
        canvas.drawBitmap(bitmap, f, f, (Paint) null);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3) {
        return addImageWatermark(bitmap, bitmap2, i, i2, i3, false);
    }

    public static Bitmap addImageWatermark(Bitmap bitmap, Bitmap bitmap2, int i, int i2, int i3, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (!isEmptyBitmap(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(copy);
            paint.setAlpha(i3);
            canvas.drawBitmap(bitmap2, i, i2, paint);
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addReflection(Bitmap bitmap, int i) {
        return addReflection(bitmap, i, false);
    }

    public static Bitmap addReflection(Bitmap bitmap, int i, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, height - i, width, i, matrix, false);
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height + i, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f = height + 0;
        canvas.drawBitmap(createBitmap, 0.0f, f, (Paint) null);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new LinearGradient(0.0f, height, 0.0f, createBitmap2.getHeight() + 0, 1895825407, (int) ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f, width, createBitmap2.getHeight(), paint);
        if (!createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap2;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, float f, int i, float f2, float f3, boolean z) {
        if (isEmptyBitmap(bitmap) || str == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(copy);
        paint.setColor(i);
        paint.setTextSize(f);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f2, f3 + f, paint);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return copy;
    }

    public static Bitmap addTextWatermark(Bitmap bitmap, String str, int i, int i2, float f, float f2) {
        return addTextWatermark(bitmap, str, i, i2, f, f2, false);
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Drawable bitmap2Drawable(Resources resources, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(resources, bitmap);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    public static Drawable bytes2Drawable(Resources resources, byte[] bArr) {
        if (resources == null) {
            return null;
        }
        return bitmap2Drawable(resources, bytes2Bitmap(bArr));
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        while (true) {
            i3 >>= 1;
            if (i3 < i2 || (i4 = i4 >> 1) < i) {
                break;
            }
            i5 <<= 1;
        }
        return i5;
    }

    public static Bitmap clip(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return clip(bitmap, i, i2, i3, i4, false);
    }

    public static Bitmap clip(Bitmap bitmap, int i, int i2, int i3, int i4, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, i2, i3, i4);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i) {
        return compressByQuality(bitmap, i, false);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, int i, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j) {
        return compressByQuality(bitmap, j, false);
    }

    public static Bitmap compressByQuality(Bitmap bitmap, long j, boolean z) {
        if (isEmptyBitmap(bitmap) || j <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 100;
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        while (true) {
            bitmap.compress(compressFormat, i, byteArrayOutputStream);
            if (byteArrayOutputStream.toByteArray().length <= j || i <= 0) {
                break;
            }
            byteArrayOutputStream.reset();
            compressFormat = Bitmap.CompressFormat.JPEG;
            i -= 5;
        }
        if (i < 0) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i) {
        return compressBySampleSize(bitmap, i, false);
    }

    public static Bitmap compressBySampleSize(Bitmap bitmap, int i, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f, float f2) {
        return scale(bitmap, f, f2, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, float f, float f2, boolean z) {
        return scale(bitmap, f, f2, z);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i, int i2) {
        return scale(bitmap, i, i2, false);
    }

    public static Bitmap compressByScale(Bitmap bitmap, int i, int i2, boolean z) {
        return scale(bitmap, i, i2, z);
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof NinePatchDrawable) {
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return null;
    }

    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat) {
        if (drawable == null) {
            return null;
        }
        return bitmap2Bytes(drawable2Bitmap(drawable), compressFormat);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f, float f2) {
        return fastBlur(bitmap, f, f2, false);
    }

    public static Bitmap fastBlur(Bitmap bitmap, float f, float f2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (int) ((width * f) + 0.5f);
        int i2 = (int) ((height * f) + 0.5f);
        if (i == 0 || i2 == 0) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f, f);
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, paint);
        Bitmap renderScriptBlur = Build.VERSION.SDK_INT >= 17 ? renderScriptBlur(createScaledBitmap, f2) : stackBlur(createScaledBitmap, (int) f2, z);
        if (f == 1.0f) {
            return renderScriptBlur;
        }
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(renderScriptBlur, width, height, true);
        if (renderScriptBlur != null && !renderScriptBlur.isRecycled()) {
            renderScriptBlur.recycle();
        }
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createScaledBitmap2;
    }

    public static Bitmap getBitmap(Resources resources, int i) {
        if (resources == null) {
            return null;
        }
        return BitmapFactory.decodeResource(resources, i);
    }

    public static Bitmap getBitmap(Resources resources, int i, int i2, int i3) {
        if (resources == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap getBitmap(File file) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e = e;
            bufferedInputStream = null;
        } catch (Throwable th) {
            th = th;
            CloseUtils.closeIO(bufferedInputStream2);
            throw th;
        }
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                CloseUtils.closeIO(bufferedInputStream);
                return decodeStream;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                CloseUtils.closeIO(bufferedInputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            CloseUtils.closeIO(bufferedInputStream);
            return null;
        }
    }

    public static Bitmap getBitmap(File file, int i, int i2) {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options;
        BufferedInputStream bufferedInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e = e;
            bufferedInputStream = null;
        } catch (Throwable th) {
            th = th;
            CloseUtils.closeIO(bufferedInputStream2);
            throw th;
        }
        try {
            try {
                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                options.inSampleSize = calculateInSampleSize(options, i, i2);
                options.inJustDecodeBounds = false;
                Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                CloseUtils.closeIO(bufferedInputStream);
                return decodeStream;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                CloseUtils.closeIO(bufferedInputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            CloseUtils.closeIO(bufferedInputStream);
            return null;
        }
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap getBitmap(FileDescriptor fileDescriptor, int i, int i2) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap getBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap getBitmap(InputStream inputStream, int i, int i2) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap getBitmap(String str) {
        if (isSpace(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap getBitmap(String str, int i, int i2) {
        if (isSpace(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmap(byte[] bArr, int i) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i, bArr.length);
    }

    public static Bitmap getBitmap(byte[] bArr, int i, int i2, int i3) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i, bArr.length, options);
        options.inSampleSize = calculateInSampleSize(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i, bArr.length, options);
    }

    public static String getImageType(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            CloseUtils.closeIO(fileInputStream2);
            throw th;
        }
        try {
            try {
                String imageType = getImageType(fileInputStream);
                CloseUtils.closeIO(fileInputStream);
                return imageType;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                CloseUtils.closeIO(fileInputStream2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            CloseUtils.closeIO(fileInputStream);
            return null;
        }
    }

    public static String getImageType(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[8];
            if (inputStream.read(bArr, 0, 8) != -1) {
                return getImageType(bArr);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getImageType(String str) {
        return getImageType(FileUtils.getFileByPath(str));
    }

    public static String getImageType(byte[] bArr) {
        if (isJPEG(bArr)) {
            return "JPEG";
        }
        if (isGIF(bArr)) {
            return "GIF";
        }
        if (isPNG(bArr)) {
            return "PNG";
        }
        if (isBMP(bArr)) {
            return "BMP";
        }
        return null;
    }

    public static int getRotateDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 8) {
                    return 90;
                }
                return bqk.f6530aq;
            }
            return 180;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static boolean isBMP(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    private static boolean isEmptyBitmap(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    private static boolean isGIF(byte[] bArr) {
        return bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97;
    }

    public static boolean isImage(File file) {
        return file != null && isImage(file.getPath());
    }

    public static boolean isImage(String str) {
        String upperCase = str.toUpperCase();
        return upperCase.endsWith(".PNG") || upperCase.endsWith(".JPG") || upperCase.endsWith(".JPEG") || upperCase.endsWith(".BMP") || upperCase.endsWith(".GIF");
    }

    private static boolean isJPEG(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    private static boolean isPNG(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Bitmap renderScriptBlur(Bitmap bitmap, float f) {
        RenderScript renderScript = null;
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        try {
            renderScript = RenderScript.create(Utils.getContext());
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation createTyped = Allocation.createTyped(renderScript, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            create.setInput(createFromBitmap);
            create.setRadius(f);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
        }
    }

    public static Bitmap rotate(Bitmap bitmap, int i, float f, float f2) {
        return rotate(bitmap, i, f, f2, false);
    }

    public static Bitmap rotate(Bitmap bitmap, int i, float f, float f2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        if (i == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, f, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, file, compressFormat, false);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) {
        boolean z2;
        BufferedOutputStream bufferedOutputStream;
        if (isEmptyBitmap(bitmap) || !FileUtils.createOrExistsFile(file)) {
            return false;
        }
        PrintStream printStream = System.out;
        printStream.println(bitmap.getWidth() + ", " + bitmap.getHeight());
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            try {
                z2 = bitmap.compress(compressFormat, 100, bufferedOutputStream);
                if (z) {
                    try {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        e.printStackTrace();
                        CloseUtils.closeIO(bufferedOutputStream2);
                        return z2;
                    }
                }
                CloseUtils.closeIO(bufferedOutputStream);
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream2 = bufferedOutputStream;
                z2 = false;
                e.printStackTrace();
                CloseUtils.closeIO(bufferedOutputStream2);
                return z2;
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            CloseUtils.closeIO(bufferedOutputStream2);
            throw th;
        }
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, FileUtils.getFileByPath(str), compressFormat, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, FileUtils.getFileByPath(str), compressFormat, z);
    }

    public static Bitmap scale(Bitmap bitmap, float f, float f2) {
        return scale(bitmap, f, f2, false);
    }

    public static Bitmap scale(Bitmap bitmap, float f, float f2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2) {
        return scale(bitmap, i, i2, false);
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2) {
        return skew(bitmap, f, f2, 0.0f, 0.0f, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2, float f3, float f4) {
        return skew(bitmap, f, f2, f3, f4, false);
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2, float f3, float f4, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f, f2, f3, f4);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap skew(Bitmap bitmap, float f, float f2, boolean z) {
        return skew(bitmap, f, f2, 0.0f, 0.0f, z);
    }

    public static Bitmap stackBlur(Bitmap bitmap, int i, boolean z) {
        Bitmap bitmap2;
        int i2;
        int i3;
        int[] iArr;
        int[] iArr2;
        int i4 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i4 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i5 = width * height;
        int[] iArr3 = new int[i5];
        copy.getPixels(iArr3, 0, width, 0, 0, width, height);
        int i6 = width - 1;
        int i7 = height - 1;
        int i8 = i4 + i4 + 1;
        int[] iArr4 = new int[i5];
        int[] iArr5 = new int[i5];
        int[] iArr6 = new int[i5];
        int[] iArr7 = new int[Math.max(width, height)];
        int i9 = (i8 + 1) >> 1;
        int i10 = i9 * i9;
        int i11 = i10 * 256;
        int[] iArr8 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr8[i12] = i12 / i10;
        }
        int[][] iArr9 = (int[][]) Array.newInstance(int.class, i8, 3);
        int i13 = i4 + 1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            bitmap2 = copy;
            if (i14 >= height) {
                break;
            }
            int i17 = height;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = -i4;
            int i27 = 0;
            while (true) {
                i3 = i7;
                iArr = iArr7;
                if (i26 > i4) {
                    break;
                }
                int i28 = iArr3[i15 + Math.min(i6, Math.max(i26, 0))];
                int[] iArr10 = iArr9[i26 + i4];
                iArr10[0] = (i28 & 16711680) >> 16;
                iArr10[1] = (i28 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i28 & 255;
                int abs = i13 - Math.abs(i26);
                i27 += iArr10[0] * abs;
                i18 += iArr10[1] * abs;
                i19 += iArr10[2] * abs;
                if (i26 > 0) {
                    i23 += iArr10[0];
                    i24 += iArr10[1];
                    i25 += iArr10[2];
                } else {
                    i20 += iArr10[0];
                    i21 += iArr10[1];
                    i22 += iArr10[2];
                }
                i26++;
                i7 = i3;
                iArr7 = iArr;
            }
            int i29 = i4;
            int i30 = i27;
            int i31 = 0;
            while (i31 < width) {
                iArr4[i15] = iArr8[i30];
                iArr5[i15] = iArr8[i18];
                iArr6[i15] = iArr8[i19];
                int i32 = i30 - i20;
                int i33 = i18 - i21;
                int i34 = i19 - i22;
                int[] iArr11 = iArr9[((i29 - i4) + i8) % i8];
                int i35 = i20 - iArr11[0];
                int i36 = i21 - iArr11[1];
                int i37 = i22 - iArr11[2];
                if (i14 == 0) {
                    iArr2 = iArr8;
                    iArr[i31] = Math.min(i31 + i4 + 1, i6);
                } else {
                    iArr2 = iArr8;
                }
                int i38 = iArr3[i16 + iArr[i31]];
                iArr11[0] = (i38 & 16711680) >> 16;
                iArr11[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i38 & 255;
                int i39 = i23 + iArr11[0];
                int i40 = i24 + iArr11[1];
                int i41 = i25 + iArr11[2];
                i30 = i32 + i39;
                i18 = i33 + i40;
                i19 = i34 + i41;
                i29 = (i29 + 1) % i8;
                int[] iArr12 = iArr9[i29 % i8];
                i20 = i35 + iArr12[0];
                i21 = i36 + iArr12[1];
                i22 = i37 + iArr12[2];
                i23 = i39 - iArr12[0];
                i24 = i40 - iArr12[1];
                i25 = i41 - iArr12[2];
                i15++;
                i31++;
                iArr8 = iArr2;
            }
            i16 += width;
            i14++;
            copy = bitmap2;
            height = i17;
            i7 = i3;
            iArr7 = iArr;
        }
        int i42 = i7;
        int[] iArr13 = iArr7;
        int i43 = height;
        int[] iArr14 = iArr8;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i4;
            int i46 = i8;
            int[] iArr15 = iArr3;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = i45;
            int i55 = i45 * width;
            int i56 = 0;
            int i57 = 0;
            while (true) {
                i2 = width;
                if (i54 > i4) {
                    break;
                }
                int max = Math.max(0, i55) + i44;
                int[] iArr16 = iArr9[i54 + i4];
                iArr16[0] = iArr4[max];
                iArr16[1] = iArr5[max];
                iArr16[2] = iArr6[max];
                int abs2 = i13 - Math.abs(i54);
                i56 += iArr4[max] * abs2;
                i57 += iArr5[max] * abs2;
                i47 += iArr6[max] * abs2;
                if (i54 > 0) {
                    i51 += iArr16[0];
                    i52 += iArr16[1];
                    i53 += iArr16[2];
                } else {
                    i48 += iArr16[0];
                    i49 += iArr16[1];
                    i50 += iArr16[2];
                }
                int i58 = i42;
                if (i54 < i58) {
                    i55 += i2;
                }
                i54++;
                i42 = i58;
                width = i2;
            }
            int i59 = i42;
            int i60 = i4;
            int i61 = i44;
            int i62 = i57;
            int i63 = i43;
            int i64 = i56;
            int i65 = 0;
            while (i65 < i63) {
                iArr15[i61] = (iArr15[i61] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i64] << 16) | (iArr14[i62] << 8) | iArr14[i47];
                int i66 = i64 - i48;
                int i67 = i62 - i49;
                int i68 = i47 - i50;
                int[] iArr17 = iArr9[((i60 - i4) + i46) % i46];
                int i69 = i48 - iArr17[0];
                int i70 = i49 - iArr17[1];
                int i71 = i50 - iArr17[2];
                if (i44 == 0) {
                    iArr13[i65] = Math.min(i65 + i13, i59) * i2;
                }
                int i72 = iArr13[i65] + i44;
                iArr17[0] = iArr4[i72];
                iArr17[1] = iArr5[i72];
                iArr17[2] = iArr6[i72];
                int i73 = i51 + iArr17[0];
                int i74 = i52 + iArr17[1];
                int i75 = i53 + iArr17[2];
                i64 = i66 + i73;
                i62 = i67 + i74;
                i47 = i68 + i75;
                i60 = (i60 + 1) % i46;
                int[] iArr18 = iArr9[i60];
                i48 = i69 + iArr18[0];
                i49 = i70 + iArr18[1];
                i50 = i71 + iArr18[2];
                i51 = i73 - iArr18[0];
                i52 = i74 - iArr18[1];
                i53 = i75 - iArr18[2];
                i61 += i2;
                i65++;
                i4 = i;
            }
            i44++;
            i4 = i;
            i42 = i59;
            i43 = i63;
            i8 = i46;
            iArr3 = iArr15;
            width = i2;
        }
        int i76 = width;
        bitmap2.setPixels(iArr3, 0, i76, 0, 0, i76, i43);
        return bitmap2;
    }

    public static Bitmap toAlpha(Bitmap bitmap) {
        return toAlpha(bitmap, false);
    }

    public static Bitmap toAlpha(Bitmap bitmap, Boolean bool) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap extractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return extractAlpha;
    }

    public static Bitmap toGray(Bitmap bitmap) {
        return toGray(bitmap, false);
    }

    public static Bitmap toGray(Bitmap bitmap, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRound(Bitmap bitmap) {
        return toRound(bitmap, false);
    }

    public static Bitmap toRound(Bitmap bitmap, boolean z) {
        if (isEmptyBitmap(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(width >> 1, height >> 1, Math.min(width, height) >> 1, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f) {
        return toRoundCorner(bitmap, f, false);
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, float f, boolean z) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(rect), f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap view2Bitmap(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }
}
