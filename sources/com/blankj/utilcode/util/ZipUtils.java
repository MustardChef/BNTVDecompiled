package com.blankj.utilcode.util;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public final class ZipUtils {

    /* renamed from: KB */
    private static final int f2724KB = 1024;

    private ZipUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static List<String> getComments(File file) {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Enumeration<?> entries = getEntries(file);
        while (entries.hasMoreElements()) {
            arrayList.add(((ZipEntry) entries.nextElement()).getComment());
        }
        return arrayList;
    }

    public static List<String> getComments(String str) {
        return getComments(FileUtils.getFileByPath(str));
    }

    public static Enumeration<?> getEntries(File file) {
        if (file == null) {
            return null;
        }
        return new ZipFile(file).entries();
    }

    public static Enumeration<?> getEntries(String str) {
        return getEntries(FileUtils.getFileByPath(str));
    }

    public static List<String> getFilesPath(File file) {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Enumeration<?> entries = getEntries(file);
        while (entries.hasMoreElements()) {
            arrayList.add(((ZipEntry) entries.nextElement()).getName());
        }
        return arrayList;
    }

    public static List<String> getFilesPath(String str) {
        return getFilesPath(FileUtils.getFileByPath(str));
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean unzipFile(File file, File file2) {
        return unzipFileByKeyword(file, file2, (String) null) != null;
    }

    public static boolean unzipFile(String str, String str2) {
        return unzipFile(FileUtils.getFileByPath(str), FileUtils.getFileByPath(str2));
    }

    public static List<File> unzipFileByKeyword(File file, File file2, String str) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            String name = nextElement.getName();
            if (StringUtils.isEmpty(str) || FileUtils.getFileName(name).toLowerCase().contains(str.toLowerCase())) {
                File file3 = new File(file2 + File.separator + name);
                arrayList.add(file3);
                if (nextElement.isDirectory()) {
                    if (!FileUtils.createOrExistsDir(file3)) {
                        return null;
                    }
                } else if (!FileUtils.createOrExistsFile(file3)) {
                    return null;
                } else {
                    try {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                        try {
                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = null;
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = bufferedInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                bufferedOutputStream.write(bArr, 0, read);
                            }
                            CloseUtils.closeIO(bufferedInputStream2, bufferedOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream = bufferedInputStream2;
                            CloseUtils.closeIO(bufferedInputStream, bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<File> unzipFileByKeyword(String str, String str2, String str3) {
        return unzipFileByKeyword(FileUtils.getFileByPath(str), FileUtils.getFileByPath(str2), str3);
    }

    public static boolean unzipFiles(Collection<File> collection, File file) {
        if (collection == null || file == null) {
            return false;
        }
        for (File file2 : collection) {
            if (!unzipFile(file2, file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean unzipFiles(Collection<File> collection, String str) {
        return unzipFiles(collection, FileUtils.getFileByPath(str));
    }

    public static boolean zipFile(File file, File file2) {
        return zipFile(file, file2, (String) null);
    }

    public static boolean zipFile(File file, File file2, String str) {
        ZipOutputStream zipOutputStream;
        if (file == null || file2 == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zipFile = zipFile(file, "", zipOutputStream, str);
            CloseUtils.closeIO(zipOutputStream);
            return zipFile;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                CloseUtils.closeIO(zipOutputStream2);
            }
            throw th;
        }
    }

    private static boolean zipFile(File file, String str, ZipOutputStream zipOutputStream, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(isSpace(str) ? "" : File.separator);
        sb.append(file.getName());
        String sb2 = sb.toString();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                ZipEntry zipEntry = new ZipEntry(sb2 + JsonPointer.SEPARATOR);
                if (!StringUtils.isEmpty(str2)) {
                    zipEntry.setComment(str2);
                }
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.closeEntry();
            } else {
                for (File file2 : listFiles) {
                    if (!zipFile(file2, sb2, zipOutputStream, str2)) {
                        return false;
                    }
                }
            }
        } else {
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    ZipEntry zipEntry2 = new ZipEntry(sb2);
                    if (!StringUtils.isEmpty(str2)) {
                        zipEntry2.setComment(str2);
                    }
                    zipOutputStream.putNextEntry(zipEntry2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        zipOutputStream.write(bArr, 0, read);
                    }
                    zipOutputStream.closeEntry();
                    CloseUtils.closeIO(bufferedInputStream2);
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    CloseUtils.closeIO(bufferedInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return true;
    }

    public static boolean zipFile(String str, String str2) {
        return zipFile(str, str2, (String) null);
    }

    public static boolean zipFile(String str, String str2, String str3) {
        return zipFile(FileUtils.getFileByPath(str), FileUtils.getFileByPath(str2), str3);
    }

    public static boolean zipFiles(Collection<File> collection, File file) {
        return zipFiles(collection, file, (String) null);
    }

    public static boolean zipFiles(Collection<File> collection, File file, String str) {
        ZipOutputStream zipOutputStream;
        if (collection == null || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (File file2 : collection) {
                if (!zipFile(file2, "", zipOutputStream, str)) {
                    zipOutputStream.finish();
                    CloseUtils.closeIO(zipOutputStream);
                    return false;
                }
            }
            zipOutputStream.finish();
            CloseUtils.closeIO(zipOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.finish();
                CloseUtils.closeIO(zipOutputStream2);
            }
            throw th;
        }
    }

    public static boolean zipFiles(Collection<File> collection, String str) {
        return zipFiles(collection, str, (String) null);
    }

    public static boolean zipFiles(Collection<File> collection, String str, String str2) {
        return zipFiles(collection, FileUtils.getFileByPath(str), str2);
    }
}
