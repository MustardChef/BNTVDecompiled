package org.acra.file;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Directory.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, m107d2 = {"Lorg/acra/file/Directory;", "", "(Ljava/lang/String;I)V", "getFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "fileName", "", "FILES_LEGACY", "FILES", "EXTERNAL_FILES", "CACHE", "EXTERNAL_CACHE", "NO_BACKUP_FILES", "EXTERNAL_STORAGE", "ROOT", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public enum Directory {
    FILES_LEGACY { // from class: org.acra.file.Directory.FILES_LEGACY
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return (StringsKt.startsWith$default(fileName, "/", false, 2, (Object) null) ? Directory.ROOT : Directory.FILES).getFile(context, fileName);
        }
    },
    FILES { // from class: org.acra.file.Directory.FILES
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getFilesDir(), fileName);
        }
    },
    EXTERNAL_FILES { // from class: org.acra.file.Directory.EXTERNAL_FILES
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getExternalFilesDir(null), fileName);
        }
    },
    CACHE { // from class: org.acra.file.Directory.CACHE
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getCacheDir(), fileName);
        }
    },
    EXTERNAL_CACHE { // from class: org.acra.file.Directory.EXTERNAL_CACHE
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(context.getExternalCacheDir(), fileName);
        }
    },
    NO_BACKUP_FILES { // from class: org.acra.file.Directory.NO_BACKUP_FILES
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            File file;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            if (Build.VERSION.SDK_INT >= 21) {
                file = context.getNoBackupFilesDir();
                Intrinsics.checkNotNullExpressionValue(file, "{\n                context.noBackupFilesDir\n            }");
            } else {
                file = new File(context.getApplicationInfo().dataDir, "no_backup");
            }
            return new File(file, fileName);
        }
    },
    EXTERNAL_STORAGE { // from class: org.acra.file.Directory.EXTERNAL_STORAGE
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return new File(Environment.getExternalStorageDirectory(), fileName);
        }
    },
    ROOT { // from class: org.acra.file.Directory.ROOT
        @Override // org.acra.file.Directory
        public File getFile(Context context, String fileName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue(separator, "separator");
            List split$default = StringsKt.split$default((CharSequence) fileName, new String[]{separator}, false, 2, 2, (Object) null);
            if (split$default.size() == 1) {
                return new File(fileName);
            }
            File[] roots = File.listRoots();
            Intrinsics.checkNotNullExpressionValue(roots, "roots");
            int length = roots.length;
            int i = 0;
            while (i < length) {
                File file = roots[i];
                i++;
                Object obj = split$default.get(0);
                String path = file.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "root.path");
                String separator2 = File.separator;
                Intrinsics.checkNotNullExpressionValue(separator2, "separator");
                if (Intrinsics.areEqual(obj, StringsKt.replace$default(path, separator2, "", false, 4, (Object) null))) {
                    return new File(file, (String) split$default.get(1));
                }
            }
            return new File(roots[0], fileName);
        }
    };

    /* synthetic */ Directory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract File getFile(Context context, String str);

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static Directory[] valuesCustom() {
        Directory[] valuesCustom = values();
        return (Directory[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
    }
}
