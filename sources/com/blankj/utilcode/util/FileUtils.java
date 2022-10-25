package com.blankj.utilcode.util;

import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class FileUtils {
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static String byte2FitMemorySize(long j) {
        if (j < 0) {
            return "shouldn't be less than zero!";
        }
        if (j < 1024) {
            return String.format("%.3fB", Double.valueOf(j + 5.0E-4d));
        }
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return String.format("%.3fKB", Double.valueOf((j / 1024.0d) + 5.0E-4d));
        }
        int i = (j > 1073741824L ? 1 : (j == 1073741824L ? 0 : -1));
        Object[] objArr = new Object[1];
        double d = j;
        if (i < 0) {
            objArr[0] = Double.valueOf((d / 1048576.0d) + 5.0E-4d);
            return String.format("%.3fMB", objArr);
        }
        objArr[0] = Double.valueOf((d / 1.073741824E9d) + 5.0E-4d);
        return String.format("%.3fGB", objArr);
    }

    private static String bytes2HexString(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            char[] cArr = new char[length << 1];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                char[] cArr2 = hexDigits;
                cArr[i] = cArr2[(bArr[i2] >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = cArr2[bArr[i2] & Ascii.f9766SI];
            }
            return new String(cArr);
        }
        return null;
    }

    public static boolean copyDir(File file, File file2) {
        return copyOrMoveDir(file, file2, false);
    }

    public static boolean copyDir(String str, String str2) {
        return copyDir(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean copyFile(File file, File file2) {
        return copyOrMoveFile(file, file2, false);
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(getFileByPath(str), getFileByPath(str2));
    }

    private static boolean copyOrMoveDir(File file, File file2, boolean z) {
        File[] listFiles;
        if (file == null || file2 == null) {
            return false;
        }
        String str = file2.getPath() + File.separator;
        if (!str.contains(file.getPath() + File.separator) && file.exists() && file.isDirectory() && createOrExistsDir(file2)) {
            for (File file3 : file.listFiles()) {
                File file4 = new File(str + file3.getName());
                if (file3.isFile()) {
                    if (!copyOrMoveFile(file3, file4, z)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, z)) {
                    return false;
                }
            }
            return !z || deleteDir(file);
        }
        return false;
    }

    private static boolean copyOrMoveDir(String str, String str2, boolean z) {
        return copyOrMoveDir(getFileByPath(str), getFileByPath(str2), z);
    }

    private static boolean copyOrMoveFile(File file, File file2, boolean z) {
        if (file != null && file2 != null && file.exists() && file.isFile()) {
            if ((file2.exists() && file2.isFile()) || !createOrExistsDir(file2.getParentFile())) {
                return false;
            }
            try {
                if (writeFileFromIS(file2, (InputStream) new FileInputStream(file), false)) {
                    if (z) {
                        if (!deleteFile(file)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static boolean copyOrMoveFile(String str, String str2, boolean z) {
        return copyOrMoveFile(getFileByPath(str), getFileByPath(str2), z);
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if (!(file.exists() && file.isFile() && !file.delete()) && createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!deleteFile(file2)) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !deleteDir(file2)) {
                            return false;
                        }
                    }
                }
                return file.delete();
            }
            return false;
        }
        return true;
    }

    public static boolean deleteDir(String str) {
        return deleteDir(getFileByPath(str));
    }

    public static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteFile(String str) {
        return deleteFile(getFileByPath(str));
    }

    public static boolean deleteFilesInDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!deleteFile(file2)) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !deleteDir(file2)) {
                            return false;
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static long getDirLength(File file) {
        if (isDir(file)) {
            long j = 0;
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    j += file2.isDirectory() ? getDirLength(file2) : file2.length();
                }
            }
            return j;
        }
        return -1L;
    }

    public static long getDirLength(String str) {
        return getDirLength(getFileByPath(str));
    }

    public static String getDirName(File file) {
        if (file == null) {
            return null;
        }
        return getDirName(file.getPath());
    }

    public static String getDirName(String str) {
        if (isSpace(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf + 1);
    }

    public static String getDirSize(File file) {
        long dirLength = getDirLength(file);
        return dirLength == -1 ? "" : byte2FitMemorySize(dirLength);
    }

    public static String getDirSize(String str) {
        return getDirSize(getFileByPath(str));
    }

    public static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileCharsetSimple(java.io.File r5) {
        /*
            r0 = 1
            r1 = 0
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L27 java.io.IOException -> L29
            int r5 = r3.read()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L24
            int r5 = r5 << 8
            int r2 = r3.read()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L24
            int r5 = r5 + r2
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r0[r1] = r3
            com.blankj.utilcode.util.CloseUtils.closeIO(r0)
            r1 = r5
            goto L34
        L21:
            r5 = move-exception
            r2 = r3
            goto L4f
        L24:
            r5 = move-exception
            r2 = r3
            goto L2a
        L27:
            r5 = move-exception
            goto L4f
        L29:
            r5 = move-exception
        L2a:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L27
            java.io.Closeable[] r5 = new java.io.Closeable[r0]
            r5[r1] = r2
            com.blankj.utilcode.util.CloseUtils.closeIO(r5)
        L34:
            r5 = 61371(0xefbb, float:8.5999E-41)
            if (r1 == r5) goto L4c
            r5 = 65279(0xfeff, float:9.1475E-41)
            if (r1 == r5) goto L49
            r5 = 65534(0xfffe, float:9.1833E-41)
            if (r1 == r5) goto L46
            java.lang.String r5 = "GBK"
            return r5
        L46:
            java.lang.String r5 = "Unicode"
            return r5
        L49:
            java.lang.String r5 = "UTF-16BE"
            return r5
        L4c:
            java.lang.String r5 = "UTF-8"
            return r5
        L4f:
            java.io.Closeable[] r0 = new java.io.Closeable[r0]
            r0[r1] = r2
            com.blankj.utilcode.util.CloseUtils.closeIO(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.getFileCharsetSimple(java.io.File):java.lang.String");
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    public static String getFileExtension(File file) {
        if (file == null) {
            return null;
        }
        return getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (isSpace(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf(File.separator) >= lastIndexOf) ? "" : str.substring(lastIndexOf + 1);
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1L;
        }
        return file.lastModified();
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    public static long getFileLength(File file) {
        if (isFile(file)) {
            return file.length();
        }
        return -1L;
    }

    public static long getFileLength(String str) {
        return getFileLength(getFileByPath(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0027 A[EDGE_INSN: B:39:0x0027->B:16:0x0027 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getFileLines(java.io.File r9) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r9]     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L35
            r4 = 1
        L12:
            int r5 = r3.read(r2, r0, r9)     // Catch: java.io.IOException -> L2f java.lang.Throwable -> L32
            r6 = -1
            if (r5 == r6) goto L27
            r6 = 0
        L1a:
            if (r6 >= r5) goto L12
            r7 = r2[r6]     // Catch: java.io.IOException -> L2f java.lang.Throwable -> L32
            r8 = 10
            if (r7 != r8) goto L24
            int r4 = r4 + 1
        L24:
            int r6 = r6 + 1
            goto L1a
        L27:
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r0] = r3
            com.blankj.utilcode.util.CloseUtils.closeIO(r9)
            goto L46
        L2f:
            r9 = move-exception
            r2 = r3
            goto L3c
        L32:
            r9 = move-exception
            r2 = r3
            goto L47
        L35:
            r9 = move-exception
            r2 = r3
            goto L3b
        L38:
            r9 = move-exception
            goto L47
        L3a:
            r9 = move-exception
        L3b:
            r4 = 1
        L3c:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L38
            java.io.Closeable[] r9 = new java.io.Closeable[r1]
            r9[r0] = r2
            com.blankj.utilcode.util.CloseUtils.closeIO(r9)
        L46:
            return r4
        L47:
            java.io.Closeable[] r1 = new java.io.Closeable[r1]
            r1[r0] = r2
            com.blankj.utilcode.util.CloseUtils.closeIO(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.getFileLines(java.io.File):int");
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0046: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:28:0x0046 */
    public static byte[] getFileMD5(File file) {
        DigestInputStream digestInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        if (file == null) {
            return null;
        }
        try {
            try {
                digestInputStream = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
            } catch (IOException e) {
                e = e;
                digestInputStream = null;
                e.printStackTrace();
                CloseUtils.closeIO(digestInputStream);
                return null;
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                digestInputStream = null;
                e.printStackTrace();
                CloseUtils.closeIO(digestInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                CloseUtils.closeIO(closeable2);
                throw th;
            }
            try {
                do {
                } while (digestInputStream.read(new byte[262144]) > 0);
                byte[] digest = digestInputStream.getMessageDigest().digest();
                CloseUtils.closeIO(digestInputStream);
                return digest;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                CloseUtils.closeIO(digestInputStream);
                return null;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                e.printStackTrace();
                CloseUtils.closeIO(digestInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            CloseUtils.closeIO(closeable2);
            throw th;
        }
    }

    public static byte[] getFileMD5(String str) {
        return getFileMD5(isSpace(str) ? null : new File(str));
    }

    public static String getFileMD5ToString(File file) {
        return bytes2HexString(getFileMD5(file));
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(isSpace(str) ? null : new File(str));
    }

    public static String getFileName(File file) {
        if (file == null) {
            return null;
        }
        return getFileName(file.getPath());
    }

    public static String getFileName(String str) {
        int lastIndexOf;
        return (isSpace(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFileNameNoExtension(File file) {
        if (file == null) {
            return null;
        }
        return getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (isSpace(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        return lastIndexOf2 == -1 ? lastIndexOf == -1 ? str : str.substring(0, lastIndexOf) : (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) ? str.substring(lastIndexOf2 + 1) : str.substring(lastIndexOf2 + 1, lastIndexOf);
    }

    public static String getFileSize(File file) {
        long fileLength = getFileLength(file);
        return fileLength == -1 ? "" : byte2FitMemorySize(fileLength);
    }

    public static String getFileSize(String str) {
        return getFileSize(getFileByPath(str));
    }

    private static ByteArrayOutputStream input2OutputStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        CloseUtils.closeIO(inputStream);
                        return byteArrayOutputStream;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
                CloseUtils.closeIO(inputStream);
                return null;
            }
        } catch (Throwable th) {
            CloseUtils.closeIO(inputStream);
            throw th;
        }
    }

    private static byte[] inputStream2Bytes(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return input2OutputStream(inputStream).toByteArray();
    }

    public static boolean isDir(File file) {
        return isFileExists(file) && file.isDirectory();
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return isFileExists(file) && file.isFile();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFileExists(File file) {
        return file != null && file.exists();
    }

    public static boolean isFileExists(String str) {
        return isFileExists(getFileByPath(str));
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

    public static List<File> listFilesInDir(File file) {
        List<File> listFilesInDir;
        if (isDir(file)) {
            ArrayList arrayList = new ArrayList();
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    arrayList.add(file2);
                    if (file2.isDirectory() && (listFilesInDir = listFilesInDir(file2)) != null) {
                        arrayList.addAll(listFilesInDir);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public static List<File> listFilesInDir(File file, boolean z) {
        if (isDir(file)) {
            if (z) {
                return listFilesInDir(file);
            }
            ArrayList arrayList = new ArrayList();
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Collections.addAll(arrayList, listFiles);
            }
            return arrayList;
        }
        return null;
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(getFileByPath(str));
    }

    public static List<File> listFilesInDir(String str, boolean z) {
        return listFilesInDir(getFileByPath(str), z);
    }

    public static List<File> listFilesInDirWithFilter(File file, FilenameFilter filenameFilter) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (filenameFilter.accept(file2.getParentFile(), file2.getName())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilter(file2, filenameFilter));
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, FilenameFilter filenameFilter, boolean z) {
        if (z) {
            return listFilesInDirWithFilter(file, filenameFilter);
        }
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (filenameFilter.accept(file2.getParentFile(), file2.getName())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, String str) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().endsWith(str.toUpperCase())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilter(file2, str));
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(File file, String str, boolean z) {
        if (z) {
            return listFilesInDirWithFilter(file, str);
        }
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().endsWith(str.toUpperCase())) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    public static List<File> listFilesInDirWithFilter(String str, FilenameFilter filenameFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), filenameFilter);
    }

    public static List<File> listFilesInDirWithFilter(String str, FilenameFilter filenameFilter, boolean z) {
        return listFilesInDirWithFilter(getFileByPath(str), filenameFilter, z);
    }

    public static List<File> listFilesInDirWithFilter(String str, String str2) {
        return listFilesInDirWithFilter(getFileByPath(str), str2);
    }

    public static List<File> listFilesInDirWithFilter(String str, String str2, boolean z) {
        return listFilesInDirWithFilter(getFileByPath(str), str2, z);
    }

    public static boolean moveDir(File file, File file2) {
        return copyOrMoveDir(file, file2, true);
    }

    public static boolean moveDir(String str, String str2) {
        return moveDir(getFileByPath(str), getFileByPath(str2));
    }

    public static boolean moveFile(File file, File file2) {
        return copyOrMoveFile(file, file2, true);
    }

    public static boolean moveFile(String str, String str2) {
        return moveFile(getFileByPath(str), getFileByPath(str2));
    }

    public static byte[] readFile2Bytes(File file) {
        if (file == null) {
            return null;
        }
        try {
            return inputStream2Bytes(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] readFile2Bytes(String str) {
        return readFile2Bytes(getFileByPath(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List<String> readFile2List(File file, int i, int i2, String str) {
        BufferedReader bufferedReader;
        String str2 = null;
        if (file == null || i > i2) {
            return null;
        }
        try {
            try {
                ArrayList arrayList = new ArrayList();
                bufferedReader = isSpace(str) ? new BufferedReader(new FileReader(file)) : new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
                int i3 = 1;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null || i3 > i2) {
                            break;
                        }
                        if (i <= i3 && i3 <= i2) {
                            arrayList.add(readLine);
                        }
                        i3++;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        CloseUtils.closeIO(bufferedReader);
                        return null;
                    }
                }
                CloseUtils.closeIO(bufferedReader);
                return arrayList;
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                CloseUtils.closeIO(str2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = str;
            CloseUtils.closeIO(str2);
            throw th;
        }
    }

    public static List<String> readFile2List(File file, String str) {
        return readFile2List(file, 0, Integer.MAX_VALUE, str);
    }

    public static List<String> readFile2List(String str, int i, int i2, String str2) {
        return readFile2List(getFileByPath(str), i, i2, str2);
    }

    public static List<String> readFile2List(String str, String str2) {
        return readFile2List(getFileByPath(str), str2);
    }

    public static String readFile2String(File file, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = isSpace(str) ? new BufferedReader(new InputStreamReader(new FileInputStream(file))) : new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            String sb2 = sb.delete(sb.length() - 2, sb.length()).toString();
                            CloseUtils.closeIO(bufferedReader);
                            return sb2;
                        }
                        sb.append(readLine);
                        sb.append("\r\n");
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader2 = bufferedReader;
                        CloseUtils.closeIO(bufferedReader2);
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    CloseUtils.closeIO(bufferedReader);
                    return null;
                }
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            CloseUtils.closeIO(bufferedReader2);
            throw th;
        }
    }

    public static String readFile2String(String str, String str2) {
        return readFile2String(getFileByPath(str), str2);
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static List<File> searchFileInDir(File file, String str) {
        if (file == null || !isDir(file)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.getName().toUpperCase().equals(str.toUpperCase())) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(searchFileInDir(file2, str));
                }
            }
        }
        return arrayList;
    }

    public static List<File> searchFileInDir(String str, String str2) {
        return searchFileInDir(getFileByPath(str), str2);
    }

    public static boolean writeFileFromIS(File file, InputStream inputStream, boolean z) {
        if (file == null || inputStream == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            CloseUtils.closeIO(inputStream, bufferedOutputStream2);
                            return true;
                        }
                        bufferedOutputStream2.write(bArr, 0, read);
                    }
                } catch (IOException e) {
                    e = e;
                    bufferedOutputStream = bufferedOutputStream2;
                    e.printStackTrace();
                    CloseUtils.closeIO(inputStream, bufferedOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    CloseUtils.closeIO(inputStream, bufferedOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeFileFromIS(String str, InputStream inputStream, boolean z) {
        return writeFileFromIS(getFileByPath(str), inputStream, z);
    }

    public static boolean writeFileFromString(File file, String str, boolean z) {
        if (file == null || str == null || !createOrExistsFile(file)) {
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
                try {
                    bufferedWriter2.write(str);
                    CloseUtils.closeIO(bufferedWriter2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    CloseUtils.closeIO(bufferedWriter);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CloseUtils.closeIO(bufferedWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeFileFromString(String str, String str2, boolean z) {
        return writeFileFromString(getFileByPath(str), str2, z);
    }
}
