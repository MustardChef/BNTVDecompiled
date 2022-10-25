package abhishekti7.unicorn.filepicker.databinding;

import abhishekti7.unicorn.filepicker.C0000R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class UnicornActivityFilePickerBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final FloatingActionButton fabSelect;
    public final RelativeLayout rlNoFiles;
    public final RelativeLayout rlProgress;
    private final CoordinatorLayout rootView;
    public final RecyclerView rvDirPath;
    public final RecyclerView rvFiles;
    public final Toolbar toolbar;

    private UnicornActivityFilePickerBinding(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, Toolbar toolbar) {
        this.rootView = coordinatorLayout;
        this.appBar = appBarLayout;
        this.fabSelect = floatingActionButton;
        this.rlNoFiles = relativeLayout;
        this.rlProgress = relativeLayout2;
        this.rvDirPath = recyclerView;
        this.rvFiles = recyclerView2;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }

    public static UnicornActivityFilePickerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UnicornActivityFilePickerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0000R.C0005layout.unicorn_activity_file_picker, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static UnicornActivityFilePickerBinding bind(View view) {
        int i = C0000R.C0003id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(i);
        if (appBarLayout != null) {
            i = C0000R.C0003id.fab_select;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(i);
            if (floatingActionButton != null) {
                i = C0000R.C0003id.rl_no_files;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                if (relativeLayout != null) {
                    i = C0000R.C0003id.rl_progress;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                    if (relativeLayout2 != null) {
                        i = C0000R.C0003id.rv_dir_path;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(i);
                        if (recyclerView != null) {
                            i = C0000R.C0003id.rv_files;
                            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(i);
                            if (recyclerView2 != null) {
                                i = C0000R.C0003id.toolbar;
                                Toolbar toolbar = (Toolbar) view.findViewById(i);
                                if (toolbar != null) {
                                    return new UnicornActivityFilePickerBinding((CoordinatorLayout) view, appBarLayout, floatingActionButton, relativeLayout, relativeLayout2, recyclerView, recyclerView2, toolbar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
