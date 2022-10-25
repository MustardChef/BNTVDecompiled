package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.file_flags_t;
import com.frostwire.jlibtorrent.swig.file_slice_vector;
import com.frostwire.jlibtorrent.swig.file_storage;
import com.frostwire.jlibtorrent.swig.string_vector;
import com.frostwire.jlibtorrent.swig.torrent_info;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class FileStorage {

    /* renamed from: fs */
    private final file_storage f2817fs;

    /* renamed from: ti */
    private final torrent_info f2818ti;
    public static final file_flags_t FLAG_PAD_FILE = file_storage.flag_pad_file;
    public static final file_flags_t FLAG_HIDDEN = file_storage.flag_hidden;
    public static final file_flags_t FLAG_EXECUTABLE = file_storage.flag_executable;
    public static final file_flags_t FLAG_SYMLINK = file_storage.flag_symlink;

    public FileStorage(file_storage file_storageVar) {
        this(file_storageVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileStorage(file_storage file_storageVar, torrent_info torrent_infoVar) {
        this.f2817fs = file_storageVar;
        this.f2818ti = torrent_infoVar;
    }

    public file_storage swig() {
        return this.f2817fs;
    }

    /* renamed from: ti */
    public torrent_info m6061ti() {
        return this.f2818ti;
    }

    public boolean isValid() {
        return this.f2817fs.is_valid();
    }

    public void reserve(int i) {
        this.f2817fs.reserve(i);
    }

    public void addFile(String str, long j, file_flags_t file_flags_tVar, int i, String str2) {
        this.f2817fs.add_file(str, j, file_flags_tVar, i, str2);
    }

    public void addFile(String str, long j, file_flags_t file_flags_tVar, int i) {
        this.f2817fs.add_file(str, j, file_flags_tVar, i);
    }

    public void addFile(String str, long j, file_flags_t file_flags_tVar) {
        this.f2817fs.add_file(str, j, file_flags_tVar);
    }

    public void addFile(String str, long j) {
        this.f2817fs.add_file(str, j);
    }

    public void renameFile(int i, String str) {
        this.f2817fs.rename_file(i, str);
    }

    public ArrayList<FileSlice> mapBlock(int i, long j, int i2) {
        return mapBlock(this.f2817fs.map_block(i, j, i2));
    }

    public PeerRequest mapFile(int i, long j, int i2) {
        return new PeerRequest(this.f2817fs.map_file(i, j, i2));
    }

    public int numFiles() {
        return this.f2817fs.num_files();
    }

    public long totalSize() {
        return this.f2817fs.total_size();
    }

    public int numPieces() {
        return this.f2817fs.num_pieces();
    }

    public void numPieces(int i) {
        this.f2817fs.set_num_pieces(i);
    }

    public int pieceLength() {
        return this.f2817fs.piece_length();
    }

    public void pieceLength(int i) {
        this.f2817fs.set_piece_length(i);
    }

    public int pieceSize(int i) {
        return this.f2817fs.piece_size(i);
    }

    public String name() {
        return this.f2817fs.name();
    }

    public void name(String str) {
        this.f2817fs.set_name(str);
    }

    public Sha1Hash hash(int i) {
        return new Sha1Hash(this.f2817fs.hash(i));
    }

    public String filePath(int i, String str) {
        return str + File.separator + this.f2817fs.file_path(i);
    }

    public String filePath(int i) {
        return this.f2817fs.file_path(i);
    }

    public String fileName(int i) {
        return Vectors.byte_vector2utf8(this.f2817fs.file_name(i).to_bytes());
    }

    public long fileSize(int i) {
        return this.f2817fs.file_size(i);
    }

    public boolean padFileAt(int i) {
        return this.f2817fs.pad_file_at(i);
    }

    public long fileOffset(int i) {
        return this.f2817fs.file_offset(i);
    }

    public ArrayList<String> paths() {
        string_vector paths = this.f2817fs.paths();
        int size = (int) paths.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(paths.get(i));
        }
        return arrayList;
    }

    public file_flags_t fileFlags(int i) {
        return this.f2817fs.file_flags(i);
    }

    public boolean fileAbsolutePath(int i) {
        return this.f2817fs.file_absolute_path(i);
    }

    public int fileIndexAtOffset(long j) {
        return this.f2817fs.file_index_at_offset(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<FileSlice> mapBlock(file_slice_vector file_slice_vectorVar) {
        int size = (int) file_slice_vectorVar.size();
        ArrayList<FileSlice> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new FileSlice(file_slice_vectorVar.get(i)));
        }
        return arrayList;
    }
}
