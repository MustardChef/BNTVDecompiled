package androidx.sqlite.p008db;

/* renamed from: androidx.sqlite.db.SupportSQLiteStatement */
/* loaded from: classes.dex */
public interface SupportSQLiteStatement extends SupportSQLiteProgram {
    void execute();

    long executeInsert();

    int executeUpdateDelete();

    long simpleQueryForLong();

    String simpleQueryForString();
}
