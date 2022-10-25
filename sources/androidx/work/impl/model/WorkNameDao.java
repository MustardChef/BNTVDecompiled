package androidx.work.impl.model;

import java.util.List;

/* loaded from: classes.dex */
public interface WorkNameDao {
    List<String> getNamesForWorkSpecId(String workSpecId);

    List<String> getWorkSpecIdsWithName(String name);

    void insert(WorkName workName);
}
