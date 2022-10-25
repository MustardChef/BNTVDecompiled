package androidx.room;

import androidx.sqlite.p008db.SupportSQLiteOpenHelper;
import java.io.File;

/* loaded from: classes.dex */
class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteCopyOpenHelperFactory(String str, File file, SupportSQLiteOpenHelper.Factory factory) {
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mDelegate = factory;
    }

    @Override // androidx.sqlite.p008db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return new SQLiteCopyOpenHelper(configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, configuration.callback.version, this.mDelegate.create(configuration));
    }
}
