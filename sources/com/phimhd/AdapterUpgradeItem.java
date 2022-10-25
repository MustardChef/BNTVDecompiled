package com.phimhd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.bongngotv2.R;

/* loaded from: classes4.dex */
public class AdapterUpgradeItem extends PagerAdapter {
    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public float getPageWidth(int i) {
        return 0.95f;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Config config;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_upgrade_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tvPricing);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tvUnit);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tvExpire);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imgBackground);
        String string = inflate.getContext().getString(R.string.default_premium_price);
        String string2 = inflate.getContext().getString(R.string.default_unlimited_price);
        String string3 = inflate.getContext().getString(R.string.unlimited);
        String string4 = inflate.getContext().getString(R.string.peryear);
        if (AppController.Companion.getInstance().getConfig() != null && (config = AppController.Companion.getInstance().getConfig()) != null && config.getPremium() != null && config.getUnlimited() != null) {
            String[] split = config.getPremium().split(",");
            String[] split2 = config.getUnlimited().split(",");
            if (split.length > 1) {
                string = split[0];
                string4 = split[1];
            }
            if (split2.length > 1) {
                string2 = split2[0];
                string3 = split2[1];
            }
        }
        if (i == 0) {
            textView.setText(inflate.getContext().getString(R.string.free_text));
            textView2.setVisibility(8);
            textView3.setVisibility(8);
            imageView.setImageResource(R.drawable.bg_standart);
        } else if (i == 1) {
            textView.setText(string);
            textView2.setVisibility(0);
            textView3.setVisibility(0);
            textView3.setText(string4);
            imageView.setImageResource(R.drawable.bg_standart);
        } else if (i == 2) {
            textView.setText(string2);
            textView2.setVisibility(0);
            textView3.setVisibility(0);
            textView3.setText(string3);
            imageView.setImageResource(R.drawable.bg_unlimited);
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
