package abhishekti7.unicorn.filepicker.databinding;

import abhishekti7.unicorn.filepicker.C0000R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class UnicornItemLayoutDirectoryStackBinding implements ViewBinding {
    public final ImageView icArrow;
    private final RelativeLayout rootView;
    public final TextView tvDirName;

    private UnicornItemLayoutDirectoryStackBinding(RelativeLayout relativeLayout, ImageView imageView, TextView textView) {
        this.rootView = relativeLayout;
        this.icArrow = imageView;
        this.tvDirName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UnicornItemLayoutDirectoryStackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UnicornItemLayoutDirectoryStackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0000R.C0005layout.unicorn_item_layout_directory_stack, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UnicornItemLayoutDirectoryStackBinding bind(View view) {
        int i = C0000R.C0003id.ic_arrow;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C0000R.C0003id.tv_dir_name;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                return new UnicornItemLayoutDirectoryStackBinding((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
