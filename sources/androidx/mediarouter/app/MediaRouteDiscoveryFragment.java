package androidx.mediarouter.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.mediarouter.media.MediaRouteSelector;
import androidx.mediarouter.media.MediaRouter;

/* loaded from: classes.dex */
public class MediaRouteDiscoveryFragment extends Fragment {
    private static final String ARGUMENT_SELECTOR = "selector";
    private MediaRouter.Callback mCallback;
    private MediaRouter mRouter;
    private MediaRouteSelector mSelector;

    public int onPrepareCallbackFlags() {
        return 4;
    }

    public MediaRouter getMediaRouter() {
        ensureRouter();
        return this.mRouter;
    }

    private void ensureRouter() {
        if (this.mRouter == null) {
            this.mRouter = MediaRouter.getInstance(getContext());
        }
    }

    public MediaRouteSelector getRouteSelector() {
        ensureRouteSelector();
        return this.mSelector;
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
        MediaRouter.Callback callback = this.mCallback;
        if (callback != null) {
            this.mRouter.removeCallback(callback);
            this.mRouter.addCallback(this.mSelector, this.mCallback, onPrepareCallbackFlags());
        }
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

    public MediaRouter.Callback onCreateCallback() {
        return new MediaRouter.Callback() { // from class: androidx.mediarouter.app.MediaRouteDiscoveryFragment.1
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ensureRouteSelector();
        ensureRouter();
        MediaRouter.Callback onCreateCallback = onCreateCallback();
        this.mCallback = onCreateCallback;
        if (onCreateCallback != null) {
            this.mRouter.addCallback(this.mSelector, onCreateCallback, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        MediaRouter.Callback callback = this.mCallback;
        if (callback != null) {
            this.mRouter.addCallback(this.mSelector, callback, onPrepareCallbackFlags());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        MediaRouter.Callback callback = this.mCallback;
        if (callback != null) {
            this.mRouter.addCallback(this.mSelector, callback, 0);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MediaRouter.Callback callback = this.mCallback;
        if (callback != null) {
            this.mRouter.removeCallback(callback);
        }
        super.onDestroy();
    }
}
