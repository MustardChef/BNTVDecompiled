package com.facebook.core.internal.logging.dumpsys;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class AndroidRootResolver {
    private static final String GET_DEFAULT_IMPL = "getDefault";
    private static final String GET_GLOBAL_INSTANCE = "getInstance";
    private static final String TAG = "AndroidRootResolver";
    private static final String VIEWS_FIELD = "mViews";
    private static final String WINDOW_MANAGER_GLOBAL_CLAZZ = "android.view.WindowManagerGlobal";
    private static final String WINDOW_MANAGER_IMPL_CLAZZ = "android.view.WindowManagerImpl";
    private static final String WINDOW_PARAMS_FIELD = "mParams";
    private boolean initialized;
    private Field paramsField;
    private Field viewsField;
    private Object windowManagerObj;

    /* loaded from: classes.dex */
    public interface Listener {
        void onRootAdded(View view);

        void onRootRemoved(View view);

        void onRootsChanged(List<View> list);
    }

    /* loaded from: classes.dex */
    public static class Root {
        public final WindowManager.LayoutParams param;
        public final View view;

        private Root(View view, WindowManager.LayoutParams layoutParams) {
            this.view = view;
            this.param = layoutParams;
        }
    }

    /* loaded from: classes.dex */
    public static class ListenableArrayList extends ArrayList<View> {
        private Listener listener;

        public void setListener(Listener listener) {
            this.listener = listener;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(View view) {
            Listener listener;
            boolean add = super.add((ListenableArrayList) view);
            if (add && (listener = this.listener) != null) {
                listener.onRootAdded(view);
                this.listener.onRootsChanged(this);
            }
            return add;
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            Listener listener;
            boolean remove = super.remove(obj);
            if (remove && (listener = this.listener) != null && (obj instanceof View)) {
                listener.onRootRemoved((View) obj);
                this.listener.onRootsChanged(this);
            }
            return remove;
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
        public View remove(int i) {
            View view = (View) super.remove(i);
            Listener listener = this.listener;
            if (listener != null) {
                listener.onRootRemoved(view);
                this.listener.onRootsChanged(this);
            }
            return view;
        }
    }

    public void attachActiveRootListener(Listener listener) {
        if (Build.VERSION.SDK_INT < 19 || listener == null) {
            return;
        }
        if (!this.initialized) {
            initialize();
        }
        try {
            Field declaredField = Field.class.getDeclaredField("accessFlags");
            declaredField.setAccessible(true);
            Field field = this.viewsField;
            declaredField.setInt(field, field.getModifiers() & (-17));
            ListenableArrayList listenableArrayList = new ListenableArrayList();
            listenableArrayList.setListener(listener);
            listenableArrayList.addAll((ArrayList) this.viewsField.get(this.windowManagerObj));
            this.viewsField.set(this.windowManagerObj, listenableArrayList);
        } catch (Throwable th) {
            Log.d(TAG, "Couldn't attach root listener.", th);
        }
    }

    public List<Root> listActiveRoots() {
        List list;
        List list2;
        if (!this.initialized) {
            initialize();
        }
        if (this.windowManagerObj == null) {
            Log.d(TAG, "No reflective access to windowmanager object.");
            return null;
        } else if (this.viewsField == null) {
            Log.d(TAG, "No reflective access to mViews");
            return null;
        } else if (this.paramsField == null) {
            Log.d(TAG, "No reflective access to mPArams");
            return null;
        } else {
            try {
                if (Build.VERSION.SDK_INT < 19) {
                    list = Arrays.asList((View[]) this.viewsField.get(this.windowManagerObj));
                    list2 = Arrays.asList((WindowManager.LayoutParams[]) this.paramsField.get(this.windowManagerObj));
                } else {
                    list = (List) this.viewsField.get(this.windowManagerObj);
                    list2 = (List) this.paramsField.get(this.windowManagerObj);
                }
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(new Root((View) list.get(i), (WindowManager.LayoutParams) list2.get(i)));
                }
                return arrayList;
            } catch (IllegalAccessException e) {
                Log.d(TAG, String.format("Reflective access to %s or %s on %s failed.", this.viewsField, this.paramsField, this.windowManagerObj), e);
                return null;
            } catch (RuntimeException e2) {
                Log.d(TAG, String.format("Reflective access to %s or %s on %s failed.", this.viewsField, this.paramsField, this.windowManagerObj), e2);
                return null;
            }
        }
    }

    private void initialize() {
        this.initialized = true;
        String str = Build.VERSION.SDK_INT > 16 ? WINDOW_MANAGER_GLOBAL_CLAZZ : WINDOW_MANAGER_IMPL_CLAZZ;
        String str2 = Build.VERSION.SDK_INT > 16 ? GET_GLOBAL_INSTANCE : GET_DEFAULT_IMPL;
        try {
            Class<?> cls = Class.forName(str);
            this.windowManagerObj = cls.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField(VIEWS_FIELD);
            this.viewsField = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField(WINDOW_PARAMS_FIELD);
            this.paramsField = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e) {
            Log.d(TAG, String.format("could not find class: %s", str), e);
        } catch (IllegalAccessException e2) {
            Log.d(TAG, String.format("reflective setup failed using obj: %s method: %s field: %s", str, str2, VIEWS_FIELD), e2);
        } catch (NoSuchFieldException e3) {
            Log.d(TAG, String.format("could not find field: %s or %s on %s", WINDOW_PARAMS_FIELD, VIEWS_FIELD, str), e3);
        } catch (NoSuchMethodException e4) {
            Log.d(TAG, String.format("could not find method: %s on %s", str2, str), e4);
        } catch (RuntimeException e5) {
            Log.d(TAG, String.format("reflective setup failed using obj: %s method: %s field: %s", str, str2, VIEWS_FIELD), e5);
        } catch (InvocationTargetException e6) {
            Log.d(TAG, String.format("could not invoke: %s on %s", str2, str), e6.getCause());
        }
    }
}
