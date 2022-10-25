package abhishekti7.unicorn.filepicker;

import abhishekti7.unicorn.filepicker.models.Config;
import abhishekti7.unicorn.filepicker.p001ui.FilePickerActivity;
import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class UnicornFilePicker {
    private final WeakReference<Activity> mActivity;
    private final WeakReference<Fragment> mContext;

    private UnicornFilePicker(Activity activity) {
        this(activity, null);
    }

    private UnicornFilePicker(Fragment fragment) {
        this(fragment.getActivity(), fragment);
    }

    public UnicornFilePicker(Activity activity, Fragment fragment) {
        this.mActivity = new WeakReference<>(activity);
        this.mContext = new WeakReference<>(fragment);
    }

    public static UnicornFilePicker from(Activity activity) {
        return new UnicornFilePicker(activity);
    }

    public static UnicornFilePicker from(Fragment fragment) {
        return new UnicornFilePicker(fragment);
    }

    public void forResult(int i) {
        Config.getInstance().setReqCode(i);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, FilePickerActivity.class);
        Fragment fragment = getFragment();
        if (fragment == null) {
            activity.startActivityForResult(intent, i);
        } else {
            fragment.startActivityForResult(intent, i);
        }
    }

    public ConfigBuilder addConfigBuilder() {
        return new ConfigBuilder(this);
    }

    Activity getActivity() {
        return this.mActivity.get();
    }

    Fragment getFragment() {
        return this.mContext.get();
    }
}
