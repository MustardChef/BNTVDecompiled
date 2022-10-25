package com.jaredrummler.android.colorpicker;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
class AlphaPatternDrawable extends Drawable {
    private Bitmap bitmap;
    private int numRectanglesHorizontal;
    private int numRectanglesVertical;
    private int rectangleSize;
    private Paint paint = new Paint();
    private Paint paintWhite = new Paint();
    private Paint paintGray = new Paint();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlphaPatternDrawable(int i) {
        this.rectangleSize = 10;
        this.rectangleSize = i;
        this.paintWhite.setColor(-1);
        this.paintGray.setColor(-3421237);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.bitmap, (Rect) null, getBounds(), this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        throw new UnsupportedOperationException("Alpha is not supported by this drawable.");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("ColorFilter is not supported by this drawable.");
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        this.numRectanglesHorizontal = (int) Math.ceil(rect.width() / this.rectangleSize);
        this.numRectanglesVertical = (int) Math.ceil(height / this.rectangleSize);
        generatePatternBitmap();
    }

    private void generatePatternBitmap() {
        if (getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        this.bitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.bitmap);
        Rect rect = new Rect();
        boolean z = true;
        for (int i = 0; i <= this.numRectanglesVertical; i++) {
            boolean z2 = z;
            for (int i2 = 0; i2 <= this.numRectanglesHorizontal; i2++) {
                rect.top = this.rectangleSize * i;
                rect.left = this.rectangleSize * i2;
                rect.bottom = rect.top + this.rectangleSize;
                rect.right = rect.left + this.rectangleSize;
                canvas.drawRect(rect, z2 ? this.paintWhite : this.paintGray);
                z2 = !z2;
            }
            z = !z;
        }
    }
}
