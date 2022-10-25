package com.github.se_bastiaan.torrentstream;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.FileStorage;
import com.frostwire.jlibtorrent.Priority;
import com.frostwire.jlibtorrent.TorrentFlags;
import com.frostwire.jlibtorrent.TorrentHandle;
import com.frostwire.jlibtorrent.TorrentStatus;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import com.frostwire.jlibtorrent.alerts.BlockFinishedAlert;
import com.frostwire.jlibtorrent.alerts.PieceFinishedAlert;
import com.github.se_bastiaan.torrentstream.listeners.TorrentListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class Torrent implements AlertListener {
    private Integer firstPieceIndex;
    private Boolean[] hasPieces;
    private Integer lastPieceIndex;
    private final TorrentListener listener;
    private Integer piecesToPrepare;
    private List<Integer> preparePieces;
    private Double prepareProgress;
    private final Long prepareSize;
    private Double progressStep;
    private State state;
    private final TorrentHandle torrentHandle;
    private List<WeakReference<TorrentInputStream>> torrentStreamReferences;
    private static final Integer MAX_PREPARE_COUNT = 20;
    private static final Integer MIN_PREPARE_COUNT = 2;
    private static final Integer DEFAULT_PREPARE_COUNT = 5;
    private static final Integer SEQUENTIAL_CONCURRENT_PIECES_COUNT = 5;
    private Integer selectedFileIndex = -1;
    private Integer interestedPieceIndex = 0;

    /* loaded from: classes2.dex */
    public enum State {
        UNKNOWN,
        RETRIEVING_META,
        STARTING,
        STREAMING
    }

    public Torrent(TorrentHandle torrentHandle, TorrentListener torrentListener, Long l) {
        Double valueOf = Double.valueOf(0.0d);
        this.prepareProgress = valueOf;
        this.progressStep = valueOf;
        this.state = State.RETRIEVING_META;
        this.torrentHandle = torrentHandle;
        this.listener = torrentListener;
        this.prepareSize = l;
        this.torrentStreamReferences = new ArrayList();
        if (this.selectedFileIndex.intValue() == -1) {
            setLargestFile();
        }
        if (torrentListener != null) {
            torrentListener.onStreamPrepared(this);
        }
    }

    private void resetPriorities() {
        Priority[] piecePriorities = this.torrentHandle.piecePriorities();
        for (int i = 0; i < piecePriorities.length; i++) {
            if (i >= this.firstPieceIndex.intValue() && i <= this.lastPieceIndex.intValue()) {
                this.torrentHandle.piecePriority(i, Priority.NORMAL);
            } else {
                this.torrentHandle.piecePriority(i, Priority.IGNORE);
            }
        }
    }

    public TorrentHandle getTorrentHandle() {
        return this.torrentHandle;
    }

    public File getVideoFile() {
        return new File(this.torrentHandle.savePath() + "/" + this.torrentHandle.torrentFile().files().filePath(this.selectedFileIndex.intValue()));
    }

    public InputStream getVideoStream() throws FileNotFoundException {
        TorrentInputStream torrentInputStream = new TorrentInputStream(this, new FileInputStream(getVideoFile()));
        this.torrentStreamReferences.add(new WeakReference<>(torrentInputStream));
        return torrentInputStream;
    }

    public File getSaveLocation() {
        return new File(this.torrentHandle.savePath() + "/" + this.torrentHandle.name());
    }

    public void resume() {
        this.torrentHandle.resume();
    }

    public void pause() {
        this.torrentHandle.pause();
    }

    public void setLargestFile() {
        setSelectedFileIndex(-1);
    }

    public void setSelectedFileIndex(Integer num) {
        int intValue;
        FileStorage files = this.torrentHandle.torrentFile().files();
        if (num.intValue() == -1) {
            long j = 0;
            int i = -1;
            for (int i2 = 0; i2 < files.numFiles(); i2++) {
                long fileSize = files.fileSize(i2);
                if (j < fileSize) {
                    this.torrentHandle.filePriority(i, Priority.IGNORE);
                    this.torrentHandle.filePriority(i2, Priority.NORMAL);
                    i = i2;
                    j = fileSize;
                } else {
                    this.torrentHandle.filePriority(i2, Priority.IGNORE);
                }
            }
            num = Integer.valueOf(i);
        } else {
            for (int i3 = 0; i3 < files.numFiles(); i3++) {
                if (i3 == num.intValue()) {
                    this.torrentHandle.filePriority(i3, Priority.NORMAL);
                } else {
                    this.torrentHandle.filePriority(i3, Priority.IGNORE);
                }
            }
        }
        this.selectedFileIndex = num;
        Priority[] piecePriorities = this.torrentHandle.piecePriorities();
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < piecePriorities.length; i6++) {
            if (piecePriorities[i6] != Priority.IGNORE) {
                if (i5 == -1) {
                    i5 = i6;
                }
                piecePriorities[i6] = Priority.IGNORE;
            } else if (i5 != -1 && i4 == -1) {
                i4 = i6 - 1;
            }
        }
        if (i4 == -1) {
            i4 = piecePriorities.length - 1;
        }
        int i7 = (i4 - i5) + 1;
        int pieceLength = this.torrentHandle.torrentFile().pieceLength();
        if (pieceLength > 0) {
            intValue = (int) (this.prepareSize.longValue() / pieceLength);
            Integer num2 = MIN_PREPARE_COUNT;
            if (intValue < num2.intValue()) {
                intValue = num2.intValue();
            } else {
                Integer num3 = MAX_PREPARE_COUNT;
                if (intValue > num3.intValue()) {
                    intValue = num3.intValue();
                }
            }
        } else {
            intValue = DEFAULT_PREPARE_COUNT.intValue();
        }
        if (i7 < intValue) {
            intValue = i7 / 2;
        }
        Integer valueOf = Integer.valueOf(i5);
        this.firstPieceIndex = valueOf;
        this.interestedPieceIndex = valueOf;
        this.lastPieceIndex = Integer.valueOf(i4);
        this.piecesToPrepare = Integer.valueOf(intValue);
    }

    public String[] getFileNames() {
        FileStorage files = this.torrentHandle.torrentFile().files();
        String[] strArr = new String[files.numFiles()];
        for (int i = 0; i < files.numFiles(); i++) {
            strArr[i] = files.fileName(i);
        }
        return strArr;
    }

    public void startDownload() {
        if (this.state == State.STREAMING || this.state == State.STARTING) {
            return;
        }
        this.state = State.STARTING;
        ArrayList arrayList = new ArrayList();
        Priority[] piecePriorities = this.torrentHandle.piecePriorities();
        for (int i = 0; i < piecePriorities.length; i++) {
            if (piecePriorities[i] != Priority.IGNORE) {
                this.torrentHandle.piecePriority(i, Priority.NORMAL);
            }
        }
        for (int i2 = 0; i2 < this.piecesToPrepare.intValue(); i2++) {
            arrayList.add(Integer.valueOf(this.lastPieceIndex.intValue() - i2));
            this.torrentHandle.piecePriority(this.lastPieceIndex.intValue() - i2, Priority.SEVEN);
            this.torrentHandle.setPieceDeadline(this.lastPieceIndex.intValue() - i2, 1000);
        }
        for (int i3 = 0; i3 < this.piecesToPrepare.intValue(); i3++) {
            arrayList.add(Integer.valueOf(this.firstPieceIndex.intValue() + i3));
            this.torrentHandle.piecePriority(this.firstPieceIndex.intValue() + i3, Priority.SEVEN);
            this.torrentHandle.setPieceDeadline(this.firstPieceIndex.intValue() + i3, 1000);
        }
        this.preparePieces = arrayList;
        Boolean[] boolArr = new Boolean[(this.lastPieceIndex.intValue() - this.firstPieceIndex.intValue()) + 1];
        this.hasPieces = boolArr;
        Arrays.fill((Object[]) boolArr, (Object) false);
        this.progressStep = Double.valueOf(100.0d / ((arrayList.size() * this.torrentHandle.torrentFile().pieceLength()) / this.torrentHandle.status().blockSize()));
        this.torrentStreamReferences.clear();
        this.torrentHandle.resume();
        this.listener.onStreamStarted(this);
    }

    public boolean hasBytes(long j) {
        if (this.hasPieces == null) {
            return false;
        }
        return this.hasPieces[(int) (j / this.torrentHandle.torrentFile().pieceLength())].booleanValue();
    }

    public void setInterestedBytes(long j) {
        if (this.hasPieces == null && j >= 0) {
            return;
        }
        int pieceLength = (int) (j / this.torrentHandle.torrentFile().pieceLength());
        this.interestedPieceIndex = Integer.valueOf(pieceLength);
        if (this.hasPieces[pieceLength].booleanValue() || this.torrentHandle.piecePriority(this.firstPieceIndex.intValue() + pieceLength) == Priority.SEVEN) {
            return;
        }
        this.interestedPieceIndex = Integer.valueOf(pieceLength);
        int i = 5;
        while (true) {
            Boolean[] boolArr = this.hasPieces;
            if (pieceLength >= boolArr.length) {
                return;
            }
            if (!boolArr[pieceLength].booleanValue()) {
                this.torrentHandle.piecePriority(this.firstPieceIndex.intValue() + pieceLength, Priority.SEVEN);
                this.torrentHandle.setPieceDeadline(this.firstPieceIndex.intValue() + pieceLength, 1000);
                i--;
                if (i == 0) {
                    return;
                }
            }
            pieceLength++;
        }
    }

    public boolean hasInterestedBytes(int i) {
        for (int i2 = 0; i2 < i + 5; i2++) {
            int intValue = this.interestedPieceIndex.intValue() + i2;
            Boolean[] boolArr = this.hasPieces;
            if (boolArr.length > intValue && intValue >= 0 && !boolArr[this.interestedPieceIndex.intValue() + i2].booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean hasInterestedBytes() {
        return hasInterestedBytes(5);
    }

    public int getInterestedPieceIndex() {
        return this.interestedPieceIndex.intValue();
    }

    public Integer getPiecesToPrepare() {
        return this.piecesToPrepare;
    }

    private void startSequentialMode() {
        resetPriorities();
        if (this.hasPieces == null) {
            TorrentHandle torrentHandle = this.torrentHandle;
            torrentHandle.setFlags(torrentHandle.flags().and_(TorrentFlags.SEQUENTIAL_DOWNLOAD));
            return;
        }
        for (int intValue = this.firstPieceIndex.intValue() + this.piecesToPrepare.intValue(); intValue < this.firstPieceIndex.intValue() + this.piecesToPrepare.intValue() + SEQUENTIAL_CONCURRENT_PIECES_COUNT.intValue(); intValue++) {
            this.torrentHandle.piecePriority(intValue, Priority.SEVEN);
            this.torrentHandle.setPieceDeadline(intValue, 1000);
        }
    }

    public State getState() {
        return this.state;
    }

    private void pieceFinished(PieceFinishedAlert pieceFinishedAlert) {
        if (this.state == State.STREAMING && this.hasPieces != null) {
            int pieceIndex = pieceFinishedAlert.pieceIndex() - this.firstPieceIndex.intValue();
            this.hasPieces[pieceIndex] = true;
            if (pieceIndex < this.interestedPieceIndex.intValue()) {
                return;
            }
            while (true) {
                Boolean[] boolArr = this.hasPieces;
                if (pieceIndex >= boolArr.length) {
                    return;
                }
                if (!boolArr[pieceIndex].booleanValue()) {
                    this.torrentHandle.piecePriority(this.firstPieceIndex.intValue() + pieceIndex, Priority.SEVEN);
                    this.torrentHandle.setPieceDeadline(pieceIndex + this.firstPieceIndex.intValue(), 1000);
                    return;
                }
                pieceIndex++;
            }
        } else {
            Iterator<Integer> it = this.preparePieces.iterator();
            while (it.hasNext()) {
                if (it.next().intValue() == pieceFinishedAlert.pieceIndex()) {
                    it.remove();
                }
            }
            Boolean[] boolArr2 = this.hasPieces;
            if (boolArr2 != null) {
                boolArr2[pieceFinishedAlert.pieceIndex() - this.firstPieceIndex.intValue()] = true;
            }
            if (this.preparePieces.size() == 0) {
                startSequentialMode();
                this.prepareProgress = Double.valueOf(100.0d);
                sendStreamProgress();
                this.state = State.STREAMING;
                TorrentListener torrentListener = this.listener;
                if (torrentListener != null) {
                    torrentListener.onStreamReady(this);
                }
            }
        }
    }

    private void blockFinished(BlockFinishedAlert blockFinishedAlert) {
        Iterator<Integer> it = this.preparePieces.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().intValue() == blockFinishedAlert.pieceIndex()) {
                this.prepareProgress = Double.valueOf(this.prepareProgress.doubleValue() + this.progressStep.doubleValue());
                break;
            }
        }
        sendStreamProgress();
    }

    private void sendStreamProgress() {
        TorrentStatus status = this.torrentHandle.status();
        float progress = status.progress() * 100.0f;
        int numSeeds = status.numSeeds();
        int downloadPayloadRate = status.downloadPayloadRate();
        if (this.listener == null || this.prepareProgress.doubleValue() < 1.0d) {
            return;
        }
        this.listener.onStreamProgress(this, new StreamStatus(progress, this.prepareProgress.intValue(), numSeeds, downloadPayloadRate));
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public int[] types() {
        return new int[]{AlertType.PIECE_FINISHED.swig(), AlertType.BLOCK_FINISHED.swig()};
    }

    /* renamed from: com.github.se_bastiaan.torrentstream.Torrent$1 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C24331 {
        static final /* synthetic */ int[] $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType;

        static {
            int[] iArr = new int[AlertType.values().length];
            $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType = iArr;
            try {
                iArr[AlertType.PIECE_FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[AlertType.BLOCK_FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public void alert(Alert<?> alert) {
        int i = C24331.$SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[alert.type().ordinal()];
        if (i == 1) {
            pieceFinished((PieceFinishedAlert) alert);
        } else if (i == 2) {
            blockFinished((BlockFinishedAlert) alert);
        }
        Iterator<WeakReference<TorrentInputStream>> it = this.torrentStreamReferences.iterator();
        while (it.hasNext()) {
            TorrentInputStream torrentInputStream = it.next().get();
            if (torrentInputStream == null) {
                it.remove();
            } else {
                torrentInputStream.alert(alert);
            }
        }
    }
}
