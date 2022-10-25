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
public final class UnicornItemLayoutDirectoryBinding implements ViewBinding {
    public final ImageView icOpen;
    public final ImageView itemIcon;
    public final RelativeLayout rlFolderDetails;
    private final RelativeLayout rootView;
    public final TextView tvDate;
    public final TextView tvFolderName;
    public final TextView tvNumFiles;

    private UnicornItemLayoutDirectoryBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.icOpen = imageView;
        this.itemIcon = imageView2;
        this.rlFolderDetails = relativeLayout2;
        this.tvDate = textView;
        this.tvFolderName = textView2;
        this.tvNumFiles = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UnicornItemLayoutDirectoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UnicornItemLayoutDirectoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0000R.C0005layout.unicorn_item_layout_directory, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UnicornItemLayoutDirectoryBinding bind(View view) {
        int i = C0000R.C0003id.ic_open;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C0000R.C0003id.item_icon;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C0000R.C0003id.rl_folder_details;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                if (relativeLayout != null) {
                    i = C0000R.C0003id.tv_date;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C0000R.C0003id.tv_folder_name;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            i = C0000R.C0003id.tv_num_files;
                            TextView textView3 = (TextView) view.findViewById(i);
                            if (textView3 != null) {
                                return new UnicornItemLayoutDirectoryBinding((RelativeLayout) view, imageView, imageView2, relativeLayout, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
