package com.github.se_bastiaan.torrentstream.utils;

import java.io.File;

/* loaded from: classes2.dex */
public final class FileUtils {
    private FileUtils() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    public static boolean recursiveDelete(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null) {
                return false;
            }
            for (String str : list) {
                recursiveDelete(new File(file, str));
            }
        }
        return file.delete();
    }
}
