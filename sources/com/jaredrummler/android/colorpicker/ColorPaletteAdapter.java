package com.jaredrummler.android.colorpicker;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ColorPaletteAdapter extends BaseAdapter {
    int colorShape;
    final int[] colors;
    final OnColorSelectedListener listener;
    int selectedPosition;

    /* loaded from: classes3.dex */
    interface OnColorSelectedListener {
        void onColorSelected(int i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorPaletteAdapter(OnColorSelectedListener onColorSelectedListener, int[] iArr, int i, int i2) {
        this.listener = onColorSelectedListener;
        this.colors = iArr;
        this.selectedPosition = i;
        this.colorShape = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.colors.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(this.colors[i]);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder(viewGroup.getContext());
            view2 = viewHolder.view;
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.setup(i);
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void selectNone() {
        this.selectedPosition = -1;
        notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    private final class ViewHolder {
        ColorPanelView colorPanelView;
        ImageView imageView;
        int originalBorderColor;
        View view;

        ViewHolder(Context context) {
            int i;
            if (ColorPaletteAdapter.this.colorShape == 0) {
                i = C4694R.C4698layout.cpv_color_item_square;
            } else {
                i = C4694R.C4698layout.cpv_color_item_circle;
            }
            View inflate = View.inflate(context, i, null);
            this.view = inflate;
            this.colorPanelView = (ColorPanelView) inflate.findViewById(C4694R.C4697id.cpv_color_panel_view);
            this.imageView = (ImageView) this.view.findViewById(C4694R.C4697id.cpv_color_image_view);
            this.originalBorderColor = this.colorPanelView.getBorderColor();
            this.view.setTag(this);
        }

        void setup(int i) {
            int i2 = ColorPaletteAdapter.this.colors[i];
            int alpha = Color.alpha(i2);
            this.colorPanelView.setColor(i2);
            this.imageView.setImageResource(ColorPaletteAdapter.this.selectedPosition == i ? C4694R.C4696drawable.cpv_preset_checked : 0);
            if (alpha == 255) {
                setColorFilter(i);
            } else if (alpha <= 165) {
                this.colorPanelView.setBorderColor(i2 | ViewCompat.MEASURED_STATE_MASK);
                this.imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
            } else {
                this.colorPanelView.setBorderColor(this.originalBorderColor);
                this.imageView.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            }
            setOnClickListener(i);
        }

        private void setOnClickListener(final int i) {
            this.colorPanelView.setOnClickListener(new View.OnClickListener() { // from class: com.jaredrummler.android.colorpicker.ColorPaletteAdapter.ViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ColorPaletteAdapter.this.selectedPosition != i) {
                        ColorPaletteAdapter.this.selectedPosition = i;
                        ColorPaletteAdapter.this.notifyDataSetChanged();
                    }
                    ColorPaletteAdapter.this.listener.onColorSelected(ColorPaletteAdapter.this.colors[i]);
                }
            });
            this.colorPanelView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.jaredrummler.android.colorpicker.ColorPaletteAdapter.ViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    ViewHolder.this.colorPanelView.showHint();
                    return true;
                }
            });
        }

        private void setColorFilter(int i) {
            if (i == ColorPaletteAdapter.this.selectedPosition && ColorUtils.calculateLuminance(ColorPaletteAdapter.this.colors[i]) >= 0.65d) {
                this.imageView.setColorFilter(ViewCompat.MEASURED_STATE_MASK, PorterDuff.Mode.SRC_IN);
            } else {
                this.imageView.setColorFilter((ColorFilter) null);
            }
        }
    }
}
