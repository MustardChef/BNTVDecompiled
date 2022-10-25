package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.mediarouter.C0554R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
final class MediaRouteDialogHelper {
    public static int getDialogWidth(Context context) {
        float fraction;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean z = displayMetrics.widthPixels < displayMetrics.heightPixels;
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(z ? C0554R.dimen.mr_dialog_fixed_width_minor : C0554R.dimen.mr_dialog_fixed_width_major, typedValue, true);
        if (typedValue.type == 5) {
            fraction = typedValue.getDimension(displayMetrics);
        } else if (typedValue.type != 6) {
            return -2;
        } else {
            fraction = typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
        }
        return (int) fraction;
    }

    public static int getDialogWidthForDynamicGroup(Context context) {
        if (context.getResources().getBoolean(C0554R.bool.is_tablet)) {
            return getDialogWidth(context);
        }
        return -1;
    }

    public static int getDialogHeight(Context context) {
        return !context.getResources().getBoolean(C0554R.bool.is_tablet) ? -1 : -2;
    }

    public static <E> boolean listUnorderedEquals(List<E> list, List<E> list2) {
        return new HashSet(list).equals(new HashSet(list2));
    }

    public static <E> Set<E> getItemsAdded(List<E> list, List<E> list2) {
        HashSet hashSet = new HashSet(list2);
        hashSet.removeAll(list);
        return hashSet;
    }

    public static <E> Set<E> getItemsRemoved(List<E> list, List<E> list2) {
        HashSet hashSet = new HashSet(list);
        hashSet.removeAll(list2);
        return hashSet;
    }

    public static <E> HashMap<E, Rect> getItemBoundMap(ListView listView, ArrayAdapter<E> arrayAdapter) {
        HashMap<E, Rect> hashMap = new HashMap<>();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i = 0; i < listView.getChildCount(); i++) {
            E item = arrayAdapter.getItem(firstVisiblePosition + i);
            View childAt = listView.getChildAt(i);
            hashMap.put(item, new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
        }
        return hashMap;
    }

    public static <E> HashMap<E, BitmapDrawable> getItemBitmapMap(Context context, ListView listView, ArrayAdapter<E> arrayAdapter) {
        HashMap<E, BitmapDrawable> hashMap = new HashMap<>();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        for (int i = 0; i < listView.getChildCount(); i++) {
            hashMap.put(arrayAdapter.getItem(firstVisiblePosition + i), getViewBitmap(context, listView.getChildAt(i)));
        }
        return hashMap;
    }

    private static BitmapDrawable getViewBitmap(Context context, View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return new BitmapDrawable(context.getResources(), createBitmap);
    }

    private MediaRouteDialogHelper() {
    }
}
