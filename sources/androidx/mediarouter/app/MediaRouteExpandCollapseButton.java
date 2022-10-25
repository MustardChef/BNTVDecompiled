package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.content.ContextCompat;
import androidx.mediarouter.C0554R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MediaRouteExpandCollapseButton extends AppCompatImageButton {
    final AnimationDrawable mCollapseAnimationDrawable;
    final String mCollapseGroupDescription;
    final AnimationDrawable mExpandAnimationDrawable;
    final String mExpandGroupDescription;
    boolean mIsGroupExpanded;
    View.OnClickListener mListener;

    public MediaRouteExpandCollapseButton(Context context) {
        this(context, null);
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AnimationDrawable animationDrawable = (AnimationDrawable) ContextCompat.getDrawable(context, C0554R.C0556drawable.mr_group_expand);
        this.mExpandAnimationDrawable = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) ContextCompat.getDrawable(context, C0554R.C0556drawable.mr_group_collapse);
        this.mCollapseAnimationDrawable = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(MediaRouterThemeHelper.getControllerColor(context, i), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(C0554R.string.mr_controller_expand_group);
        this.mExpandGroupDescription = string;
        this.mCollapseGroupDescription = context.getString(C0554R.string.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new View.OnClickListener() { // from class: androidx.mediarouter.app.MediaRouteExpandCollapseButton.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = MediaRouteExpandCollapseButton.this;
                mediaRouteExpandCollapseButton.mIsGroupExpanded = !mediaRouteExpandCollapseButton.mIsGroupExpanded;
                if (MediaRouteExpandCollapseButton.this.mIsGroupExpanded) {
                    MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton2 = MediaRouteExpandCollapseButton.this;
                    mediaRouteExpandCollapseButton2.setImageDrawable(mediaRouteExpandCollapseButton2.mExpandAnimationDrawable);
                    MediaRouteExpandCollapseButton.this.mExpandAnimationDrawable.start();
                    MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton3 = MediaRouteExpandCollapseButton.this;
                    mediaRouteExpandCollapseButton3.setContentDescription(mediaRouteExpandCollapseButton3.mCollapseGroupDescription);
                } else {
                    MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton4 = MediaRouteExpandCollapseButton.this;
                    mediaRouteExpandCollapseButton4.setImageDrawable(mediaRouteExpandCollapseButton4.mCollapseAnimationDrawable);
                    MediaRouteExpandCollapseButton.this.mCollapseAnimationDrawable.start();
                    MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton5 = MediaRouteExpandCollapseButton.this;
                    mediaRouteExpandCollapseButton5.setContentDescription(mediaRouteExpandCollapseButton5.mExpandGroupDescription);
                }
                if (MediaRouteExpandCollapseButton.this.mListener != null) {
                    MediaRouteExpandCollapseButton.this.mListener.onClick(view);
                }
            }
        });
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }
}
