package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.move_flags_t;

/* loaded from: classes2.dex */
public enum MoveFlags {
    ALWAYS_REPLACE_FILES(move_flags_t.always_replace_files),
    FAIL_IF_EXIST(move_flags_t.fail_if_exist),
    DONT_REPLACE(move_flags_t.dont_replace);
    
    private final move_flags_t swigValue;

    MoveFlags(move_flags_t move_flags_tVar) {
        this.swigValue = move_flags_tVar;
    }

    public move_flags_t swig() {
        return this.swigValue;
    }

    public static MoveFlags fromSwig(move_flags_t move_flags_tVar) {
        MoveFlags[] moveFlagsArr;
        for (MoveFlags moveFlags : (MoveFlags[]) MoveFlags.class.getEnumConstants()) {
            if (moveFlags.swig() == move_flags_tVar) {
                return moveFlags;
            }
        }
        throw new IllegalArgumentException("Enum value not supported");
    }
}
