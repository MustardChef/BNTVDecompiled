package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.mediarouter.media.MediaRouteSelector;

/* loaded from: classes.dex */
public class MediaRouteChooserDialogFragment extends DialogFragment {
    private static final String ARGUMENT_SELECTOR = "selector";
    private Dialog mDialog;
    private MediaRouteSelector mSelector;
    private boolean mUseDynamicGroup = false;

    public MediaRouteChooserDialogFragment() {
        setCancelable(true);
    }

    public MediaRouteSelector getRouteSelector() {
        ensureRouteSelector();
        return this.mSelector;
    }

    private void ensureRouteSelector() {
        if (this.mSelector == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.mSelector = MediaRouteSelector.fromBundle(arguments.getBundle(ARGUMENT_SELECTOR));
            }
            if (this.mSelector == null) {
                this.mSelector = MediaRouteSelector.EMPTY;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseDynamicGroup(boolean z) {
        if (this.mDialog != null) {
            throw new IllegalStateException("This must be called before creating dialog");
        }
        this.mUseDynamicGroup = z;
    }

    public void setRouteSelector(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        ensureRouteSelector();
        if (this.mSelector.equals(mediaRouteSelector)) {
            return;
        }
        this.mSelector = mediaRouteSelector;
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putBundle(ARGUMENT_SELECTOR, mediaRouteSelector.asBundle());
        setArguments(arguments);
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            if (this.mUseDynamicGroup) {
                ((MediaRouteDynamicChooserDialog) dialog).setRouteSelector(mediaRouteSelector);
            } else {
                ((MediaRouteChooserDialog) dialog).setRouteSelector(mediaRouteSelector);
            }
        }
    }

    public MediaRouteDynamicChooserDialog onCreateDynamicChooserDialog(Context context) {
        return new MediaRouteDynamicChooserDialog(context);
    }

    public MediaRouteChooserDialog onCreateChooserDialog(Context context, Bundle bundle) {
        return new MediaRouteChooserDialog(context);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.mUseDynamicGroup) {
            MediaRouteDynamicChooserDialog onCreateDynamicChooserDialog = onCreateDynamicChooserDialog(getContext());
            this.mDialog = onCreateDynamicChooserDialog;
            onCreateDynamicChooserDialog.setRouteSelector(getRouteSelector());
        } else {
            MediaRouteChooserDialog onCreateChooserDialog = onCreateChooserDialog(getContext(), bundle);
            this.mDialog = onCreateChooserDialog;
            onCreateChooserDialog.setRouteSelector(getRouteSelector());
        }
        return this.mDialog;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.mDialog;
        if (dialog == null) {
            return;
        }
        if (this.mUseDynamicGroup) {
            ((MediaRouteDynamicChooserDialog) dialog).updateLayout();
        } else {
            ((MediaRouteChooserDialog) dialog).updateLayout();
        }
    }
}
