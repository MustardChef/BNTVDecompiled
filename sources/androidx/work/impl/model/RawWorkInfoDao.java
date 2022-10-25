package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.sqlite.p008db.SupportSQLiteQuery;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

/* loaded from: classes.dex */
public interface RawWorkInfoDao {
    List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery query);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery query);
}
