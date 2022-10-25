package abhishekti7.unicorn.filepicker.databinding;

import abhishekti7.unicorn.filepicker.C0000R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class UnicornItemLayoutFilesBinding implements ViewBinding {
    public final ImageView itemIcon;
    public final RadioButton rgSelected;
    public final RelativeLayout rlFileRoot;
    public final RelativeLayout rlFolderDetails;
    private final RelativeLayout rootView;
    public final TextView tvDate;
    public final TextView tvFileName;

    private UnicornItemLayoutFilesBinding(RelativeLayout relativeLayout, ImageView imageView, RadioButton radioButton, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.itemIcon = imageView;
        this.rgSelected = radioButton;
        this.rlFileRoot = relativeLayout2;
        this.rlFolderDetails = relativeLayout3;
        this.tvDate = textView;
        this.tvFileName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UnicornItemLayoutFilesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UnicornItemLayoutFilesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0000R.C0005layout.unicorn_item_layout_files, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UnicornItemLayoutFilesBinding bind(View view) {
        int i = C0000R.C0003id.item_icon;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C0000R.C0003id.rg_selected;
            RadioButton radioButton = (RadioButton) view.findViewById(i);
            if (radioButton != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i = C0000R.C0003id.rl_folder_details;
                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                if (relativeLayout2 != null) {
                    i = C0000R.C0003id.tv_date;
                    TextView textView = (TextView) view.findViewById(i);
                    if (textView != null) {
                        i = C0000R.C0003id.tv_file_name;
                        TextView textView2 = (TextView) view.findViewById(i);
                        if (textView2 != null) {
                            return new UnicornItemLayoutFilesBinding(relativeLayout, imageView, radioButton, relativeLayout, relativeLayout2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
