package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class FragmentUtils {
    private static final String ARGS_ID = "args_id";
    private static final String ARGS_IS_ADD_STACK = "args_is_add_stack";
    private static final String ARGS_IS_HIDE = "args_is_hide";
    private static final int TYPE_ADD_FRAGMENT = 1;
    private static final int TYPE_HIDE_FRAGMENT = 32;
    private static final int TYPE_HIDE_SHOW_FRAGMENT = 128;
    private static final int TYPE_POP_ADD_FRAGMENT = 16;
    private static final int TYPE_REMOVE_FRAGMENT = 2;
    private static final int TYPE_REMOVE_TO_FRAGMENT = 4;
    private static final int TYPE_REPLACE_FRAGMENT = 8;
    private static final int TYPE_SHOW_FRAGMENT = 64;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Args {

        /* renamed from: id */
        int f2716id;
        boolean isAddStack;
        boolean isHide;

        Args(int i, boolean z, boolean z2) {
            this.f2716id = i;
            this.isHide = z;
            this.isAddStack = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FragmentNode {
        Fragment fragment;
        List<FragmentNode> next;

        public FragmentNode(Fragment fragment, List<FragmentNode> list) {
            this.fragment = fragment;
            this.next = list;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.fragment.getClass().getSimpleName());
            sb.append("->");
            List<FragmentNode> list = this.next;
            sb.append((list == null || list.isEmpty()) ? "no child" : this.next.toString());
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public interface OnBackClickListener {
        boolean onBackClick();
    }

    /* loaded from: classes.dex */
    public static class SharedElement {
        String name;
        View sharedElement;

        public SharedElement(View view, String str) {
            this.sharedElement = view;
            this.name = str;
        }
    }

    private FragmentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Fragment addFragment(FragmentManager fragmentManager, Fragment fragment, int i) {
        return addFragment(fragmentManager, fragment, i, false);
    }

    public static Fragment addFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z) {
        return addFragment(fragmentManager, fragment, i, z, false);
    }

    public static Fragment addFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, boolean z2) {
        putArgs(fragment, new Args(i, z, z2));
        return operateFragment(fragmentManager, null, fragment, 1, new SharedElement[0]);
    }

    public static Fragment addFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, boolean z2, SharedElement... sharedElementArr) {
        putArgs(fragment, new Args(i, z, z2));
        return operateFragment(fragmentManager, null, fragment, 1, sharedElementArr);
    }

    public static Fragment addFragments(FragmentManager fragmentManager, List<Fragment> list, int i, int i2) {
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            Fragment fragment = list.get(i3);
            if (fragment != null) {
                addFragment(fragmentManager, fragment, i, i2 != i3, false);
            }
            i3++;
        }
        return list.get(i2);
    }

    public static Fragment addFragments(FragmentManager fragmentManager, List<Fragment> list, int i, int i2, List<SharedElement>... listArr) {
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            Fragment fragment = list.get(i3);
            List<SharedElement> list2 = listArr[i3];
            if (fragment != null && list2 != null) {
                putArgs(fragment, new Args(i, i2 != i3, false));
                return operateFragment(fragmentManager, null, fragment, 1, (SharedElement[]) list2.toArray(new SharedElement[0]));
            }
            i3++;
        }
        return list.get(i2);
    }

    public static boolean dispatchBackPress(Fragment fragment) {
        return dispatchBackPress(fragment.getFragmentManager());
    }

    public static boolean dispatchBackPress(FragmentManager fragmentManager) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments != null && !fragments.isEmpty()) {
            for (int size = fragments.size() - 1; size >= 0; size--) {
                Fragment fragment = fragments.get(size);
                if (fragment != null && fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).onBackClick()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Fragment findFragment(FragmentManager fragmentManager, Class<? extends Fragment> cls) {
        if (getFragments(fragmentManager).isEmpty()) {
            return null;
        }
        return fragmentManager.findFragmentByTag(cls.getName());
    }

    public static List<FragmentNode> getAllFragments(FragmentManager fragmentManager) {
        return getAllFragmentsIsInStack(fragmentManager, new ArrayList(), false);
    }

    public static List<FragmentNode> getAllFragmentsInStack(FragmentManager fragmentManager) {
        return getAllFragmentsIsInStack(fragmentManager, new ArrayList(), true);
    }

    private static List<FragmentNode> getAllFragmentsIsInStack(FragmentManager fragmentManager, List<FragmentNode> list, boolean z) {
        FragmentNode fragmentNode;
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null || fragments.isEmpty()) {
            return Collections.emptyList();
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                if (!z) {
                    fragmentNode = new FragmentNode(fragment, getAllFragmentsIsInStack(fragment.getChildFragmentManager(), new ArrayList(), false));
                } else if (fragment.getArguments().getBoolean(ARGS_IS_ADD_STACK)) {
                    fragmentNode = new FragmentNode(fragment, getAllFragmentsIsInStack(fragment.getChildFragmentManager(), new ArrayList(), true));
                }
                list.add(fragmentNode);
            }
        }
        return list;
    }

    private static Args getArgs(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null || arguments.getInt(ARGS_ID) == 0) {
            return null;
        }
        return new Args(arguments.getInt(ARGS_ID), arguments.getBoolean(ARGS_IS_HIDE), arguments.getBoolean(ARGS_IS_ADD_STACK));
    }

    public static List<Fragment> getFragments(FragmentManager fragmentManager) {
        return getFragmentsIsInStack(fragmentManager, false);
    }

    public static List<Fragment> getFragmentsInStack(FragmentManager fragmentManager) {
        return getFragmentsIsInStack(fragmentManager, true);
    }

    private static List<Fragment> getFragmentsIsInStack(FragmentManager fragmentManager, boolean z) {
        List<Fragment> fragments = fragmentManager.getFragments();
        if (fragments == null || fragments.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null && (!z || fragment.getArguments().getBoolean(ARGS_IS_ADD_STACK))) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }

    public static Fragment getLastAddFragment(FragmentManager fragmentManager) {
        return getLastAddFragmentIsInStack(fragmentManager, false);
    }

    public static Fragment getLastAddFragmentInStack(FragmentManager fragmentManager) {
        return getLastAddFragmentIsInStack(fragmentManager, true);
    }

    private static Fragment getLastAddFragmentIsInStack(FragmentManager fragmentManager, boolean z) {
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments.isEmpty()) {
            return null;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null && (!z || fragment.getArguments().getBoolean(ARGS_IS_ADD_STACK))) {
                return fragment;
            }
        }
        return null;
    }

    public static Fragment getPreFragment(Fragment fragment) {
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return null;
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        boolean z = false;
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment2 = fragments.get(size);
            if (z && fragment2 != null) {
                return fragment2;
            }
            if (fragment2 == fragment) {
                z = true;
            }
        }
        return null;
    }

    public static Fragment getTopShowFragment(FragmentManager fragmentManager) {
        return getTopShowFragmentIsInStack(fragmentManager, null, false);
    }

    public static Fragment getTopShowFragmentInStack(FragmentManager fragmentManager) {
        return getTopShowFragmentIsInStack(fragmentManager, null, true);
    }

    private static Fragment getTopShowFragmentIsInStack(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments.isEmpty()) {
            return fragment;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment2 = fragments.get(size);
            if (fragment2 != null && fragment2.isResumed() && fragment2.isVisible() && fragment2.getUserVisibleHint()) {
                if (!z) {
                    return getTopShowFragmentIsInStack(fragment2.getChildFragmentManager(), fragment2, false);
                }
                if (fragment2.getArguments().getBoolean(ARGS_IS_ADD_STACK)) {
                    return getTopShowFragmentIsInStack(fragment2.getChildFragmentManager(), fragment2, true);
                }
            }
        }
        return fragment;
    }

    public static Fragment hideAddFragment(FragmentManager fragmentManager, Fragment fragment, Fragment fragment2, int i, boolean z, boolean z2, SharedElement... sharedElementArr) {
        putArgs(fragment2, new Args(i, z, z2));
        return operateFragment(fragmentManager, fragment, fragment2, 1, sharedElementArr);
    }

    public static Fragment hideAllShowFragment(Fragment fragment) {
        hideFragments(fragment.getFragmentManager());
        return operateFragment(fragment.getFragmentManager(), null, fragment, 64, new SharedElement[0]);
    }

    public static Fragment hideFragment(Fragment fragment) {
        Args args = getArgs(fragment);
        if (args != null) {
            putArgs(fragment, new Args(args.f2716id, true, args.isAddStack));
        }
        return operateFragment(fragment.getFragmentManager(), null, fragment, 32, new SharedElement[0]);
    }

    public static void hideFragments(FragmentManager fragmentManager) {
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments.isEmpty()) {
            return;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                hideFragment(fragment);
            }
        }
    }

    public static Fragment hideShowFragment(Fragment fragment, Fragment fragment2) {
        Args args = getArgs(fragment);
        if (args != null) {
            putArgs(fragment, new Args(args.f2716id, true, args.isAddStack));
        }
        Args args2 = getArgs(fragment2);
        if (args2 != null) {
            putArgs(fragment2, new Args(args2.f2716id, false, args2.isAddStack));
        }
        return operateFragment(fragment2.getFragmentManager(), fragment, fragment2, 128, new SharedElement[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
        if (r1.getBoolean(com.blankj.utilcode.util.FragmentUtils.ARGS_IS_ADD_STACK) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a5, code lost:
        if (r1.getBoolean(com.blankj.utilcode.util.FragmentUtils.ARGS_IS_ADD_STACK) != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a7, code lost:
        r2.addToBackStack(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00e9, code lost:
        if (r1.getBoolean(com.blankj.utilcode.util.FragmentUtils.ARGS_IS_ADD_STACK) != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.fragment.app.Fragment operateFragment(androidx.fragment.app.FragmentManager r7, androidx.fragment.app.Fragment r8, androidx.fragment.app.Fragment r9, int r10, com.blankj.utilcode.util.FragmentUtils.SharedElement... r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FragmentUtils.operateFragment(androidx.fragment.app.FragmentManager, androidx.fragment.app.Fragment, androidx.fragment.app.Fragment, int, com.blankj.utilcode.util.FragmentUtils$SharedElement[]):androidx.fragment.app.Fragment");
    }

    public static Fragment popAddFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z) {
        putArgs(fragment, new Args(i, false, z));
        return operateFragment(fragmentManager, null, fragment, 16, new SharedElement[0]);
    }

    public static Fragment popAddFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, SharedElement... sharedElementArr) {
        putArgs(fragment, new Args(i, false, z));
        return operateFragment(fragmentManager, null, fragment, 16, sharedElementArr);
    }

    public static void popAllFragments(FragmentManager fragmentManager) {
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments.isEmpty()) {
            return;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                popAllFragments(fragment.getChildFragmentManager());
            }
        }
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    public static boolean popFragment(FragmentManager fragmentManager) {
        return fragmentManager.popBackStackImmediate();
    }

    public static void popFragments(FragmentManager fragmentManager) {
        while (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    public static boolean popToFragment(FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z) {
        return fragmentManager.popBackStackImmediate(cls.getName(), z ? 1 : 0);
    }

    private static void putArgs(Fragment fragment, Args args) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putInt(ARGS_ID, args.f2716id);
        arguments.putBoolean(ARGS_IS_HIDE, args.isHide);
        arguments.putBoolean(ARGS_IS_ADD_STACK, args.isAddStack);
    }

    public static void removeAllFragments(FragmentManager fragmentManager) {
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments.isEmpty()) {
            return;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                removeAllFragments(fragment.getChildFragmentManager());
                removeFragment(fragment);
            }
        }
    }

    public static void removeFragment(Fragment fragment) {
        operateFragment(fragment.getFragmentManager(), null, fragment, 2, new SharedElement[0]);
    }

    public static void removeFragments(FragmentManager fragmentManager) {
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments.isEmpty()) {
            return;
        }
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                removeFragment(fragment);
            }
        }
    }

    public static void removeToFragment(Fragment fragment, boolean z) {
        operateFragment(fragment.getFragmentManager(), z ? fragment : null, fragment, 4, new SharedElement[0]);
    }

    public static Fragment replaceFragment(Fragment fragment, Fragment fragment2, boolean z) {
        int i;
        if (fragment.getArguments() == null || (i = fragment.getArguments().getInt(ARGS_ID)) == 0) {
            return null;
        }
        return replaceFragment(fragment.getFragmentManager(), fragment2, i, z);
    }

    public static Fragment replaceFragment(Fragment fragment, Fragment fragment2, boolean z, SharedElement... sharedElementArr) {
        int i;
        if (fragment.getArguments() == null || (i = fragment.getArguments().getInt(ARGS_ID)) == 0) {
            return null;
        }
        return replaceFragment(fragment.getFragmentManager(), fragment2, i, z, sharedElementArr);
    }

    public static Fragment replaceFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z) {
        putArgs(fragment, new Args(i, false, z));
        return operateFragment(fragmentManager, null, fragment, 8, new SharedElement[0]);
    }

    public static Fragment replaceFragment(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, SharedElement... sharedElementArr) {
        putArgs(fragment, new Args(i, false, z));
        return operateFragment(fragmentManager, null, fragment, 8, sharedElementArr);
    }

    public static void setBackground(Fragment fragment, Drawable drawable) {
        View view = fragment.getView();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        }
    }

    public static void setBackgroundColor(Fragment fragment, int i) {
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public static void setBackgroundResource(Fragment fragment, int i) {
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }

    public static Fragment showFragment(Fragment fragment) {
        Args args = getArgs(fragment);
        if (args != null) {
            putArgs(fragment, new Args(args.f2716id, false, args.isAddStack));
        }
        return operateFragment(fragment.getFragmentManager(), null, fragment, 64, new SharedElement[0]);
    }
}
