package timber.log;

import android.os.Build;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class Timber {
    private static final Tree[] TREE_ARRAY_EMPTY;
    static volatile Tree[] forestAsArray;
    private static final List<Tree> FOREST = new ArrayList();
    private static final Tree TREE_OF_SOULS = new Tree() { // from class: timber.log.Timber.1
        @Override // timber.log.Timber.Tree
        /* renamed from: v */
        public void mo5v(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo5v(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: v */
        public void mo3v(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo3v(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: v */
        public void mo4v(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo4v(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: d */
        public void mo14d(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo14d(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: d */
        public void mo12d(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo12d(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: d */
        public void mo13d(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo13d(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: i */
        public void mo8i(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo8i(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: i */
        public void mo6i(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo6i(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: i */
        public void mo7i(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo7i(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: w */
        public void mo2w(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo2w(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: w */
        public void mo0w(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo0w(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: w */
        public void mo1w(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo1w(th);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: e */
        public void mo11e(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo11e(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: e */
        public void mo9e(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo9e(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        /* renamed from: e */
        public void mo10e(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.mo10e(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void wtf(Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.wtf(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public void log(int i, Throwable th) {
            for (Tree tree : Timber.forestAsArray) {
                tree.log(i, th);
            }
        }

        @Override // timber.log.Timber.Tree
        protected void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }
    };

    /* renamed from: v */
    public static void m20v(String str, Object... objArr) {
        TREE_OF_SOULS.mo5v(str, objArr);
    }

    /* renamed from: v */
    public static void m18v(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo3v(th, str, objArr);
    }

    /* renamed from: v */
    public static void m19v(Throwable th) {
        TREE_OF_SOULS.mo4v(th);
    }

    /* renamed from: d */
    public static void m29d(String str, Object... objArr) {
        TREE_OF_SOULS.mo14d(str, objArr);
    }

    /* renamed from: d */
    public static void m27d(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo12d(th, str, objArr);
    }

    /* renamed from: d */
    public static void m28d(Throwable th) {
        TREE_OF_SOULS.mo13d(th);
    }

    /* renamed from: i */
    public static void m23i(String str, Object... objArr) {
        TREE_OF_SOULS.mo8i(str, objArr);
    }

    /* renamed from: i */
    public static void m21i(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo6i(th, str, objArr);
    }

    /* renamed from: i */
    public static void m22i(Throwable th) {
        TREE_OF_SOULS.mo7i(th);
    }

    /* renamed from: w */
    public static void m17w(String str, Object... objArr) {
        TREE_OF_SOULS.mo2w(str, objArr);
    }

    /* renamed from: w */
    public static void m15w(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo0w(th, str, objArr);
    }

    /* renamed from: w */
    public static void m16w(Throwable th) {
        TREE_OF_SOULS.mo1w(th);
    }

    /* renamed from: e */
    public static void m26e(String str, Object... objArr) {
        TREE_OF_SOULS.mo11e(str, objArr);
    }

    /* renamed from: e */
    public static void m24e(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.mo9e(th, str, objArr);
    }

    /* renamed from: e */
    public static void m25e(Throwable th) {
        TREE_OF_SOULS.mo10e(th);
    }

    public static void wtf(String str, Object... objArr) {
        TREE_OF_SOULS.wtf(str, objArr);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.wtf(th, str, objArr);
    }

    public static void wtf(Throwable th) {
        TREE_OF_SOULS.wtf(th);
    }

    public static void log(int i, String str, Object... objArr) {
        TREE_OF_SOULS.log(i, str, objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.log(i, th, str, objArr);
    }

    public static void log(int i, Throwable th) {
        TREE_OF_SOULS.log(i, th);
    }

    public static Tree asTree() {
        return TREE_OF_SOULS;
    }

    public static Tree tag(String str) {
        for (Tree tree : forestAsArray) {
            tree.explicitTag.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static void plant(Tree tree) {
        Objects.requireNonNull(tree, "tree == null");
        if (tree == TREE_OF_SOULS) {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
        List<Tree> list = FOREST;
        synchronized (list) {
            list.add(tree);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void plant(Tree... treeArr) {
        Objects.requireNonNull(treeArr, "trees == null");
        for (Tree tree : treeArr) {
            Objects.requireNonNull(tree, "trees contains null");
            if (tree == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.");
            }
        }
        List<Tree> list = FOREST;
        synchronized (list) {
            Collections.addAll(list, treeArr);
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void uproot(Tree tree) {
        List<Tree> list = FOREST;
        synchronized (list) {
            if (!list.remove(tree)) {
                throw new IllegalArgumentException("Cannot uproot tree which is not planted: " + tree);
            }
            forestAsArray = (Tree[]) list.toArray(new Tree[list.size()]);
        }
    }

    public static void uprootAll() {
        List<Tree> list = FOREST;
        synchronized (list) {
            list.clear();
            forestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    public static List<Tree> forest() {
        List<Tree> unmodifiableList;
        List<Tree> list = FOREST;
        synchronized (list) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return unmodifiableList;
    }

    public static int treeCount() {
        int size;
        List<Tree> list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    static {
        Tree[] treeArr = new Tree[0];
        TREE_ARRAY_EMPTY = treeArr;
        forestAsArray = treeArr;
    }

    private Timber() {
        throw new AssertionError("No instances.");
    }

    /* loaded from: classes5.dex */
    public static abstract class Tree {
        final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        @Deprecated
        protected boolean isLoggable(int i) {
            return true;
        }

        protected abstract void log(int i, String str, String str2, Throwable th);

        String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* renamed from: v */
        public void mo5v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        /* renamed from: v */
        public void mo3v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* renamed from: v */
        public void mo4v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        /* renamed from: d */
        public void mo14d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        /* renamed from: d */
        public void mo12d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* renamed from: d */
        public void mo13d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        /* renamed from: i */
        public void mo8i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        /* renamed from: i */
        public void mo6i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        /* renamed from: i */
        public void mo7i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        /* renamed from: w */
        public void mo2w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        /* renamed from: w */
        public void mo0w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        /* renamed from: w */
        public void mo1w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        /* renamed from: e */
        public void mo11e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        /* renamed from: e */
        public void mo9e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        /* renamed from: e */
        public void mo10e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, null, str, objArr);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, null, new Object[0]);
        }

        protected boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        str = str + "\n" + getStackTraceString(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = getStackTraceString(th);
                }
                log(i, tag, str, th);
            }
        }

        protected String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static class DebugTree extends Tree {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        protected String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
        }

        @Override // timber.log.Timber.Tree
        final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length <= 5) {
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
            return createStackElementTag(stackTrace[5]);
        }

        @Override // timber.log.Timber.Tree
        protected void log(int i, String str, String str2, Throwable th) {
            int min;
            if (str2.length() < MAX_LOG_LENGTH) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int i2 = 0;
            int length = str2.length();
            while (i2 < length) {
                int indexOf = str2.indexOf(10, i2);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i2 + MAX_LOG_LENGTH);
                    String substring = str2.substring(i2, min);
                    if (i == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    }
                    i2 = min;
                }
                i2 = min + 1;
            }
        }
    }
}
