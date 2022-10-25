package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.block_info;

/* loaded from: classes2.dex */
public final class BlockInfo {

    /* renamed from: b */
    private final block_info f2808b;

    public BlockInfo(block_info block_infoVar) {
        this.f2808b = block_infoVar;
    }

    public block_info swig() {
        return this.f2808b;
    }

    public TcpEndpoint peer() {
        return new TcpEndpoint(this.f2808b.peer());
    }

    public int bytesProgress() {
        return (int) this.f2808b.getBytes_progress();
    }

    public int blockSize() {
        return (int) this.f2808b.getBlock_size();
    }

    public BlockState state() {
        return BlockState.fromSwig((int) this.f2808b.getState());
    }

    public int numPeers() {
        return (int) this.f2808b.getNum_peers();
    }

    /* loaded from: classes2.dex */
    public enum BlockState {
        NONE(block_info.block_state_t.none.swigValue()),
        REQUESTED(block_info.block_state_t.requested.swigValue()),
        WRITING(block_info.block_state_t.writing.swigValue()),
        FINISHED(block_info.block_state_t.finished.swigValue()),
        UNKNOWN(-1);
        
        private final int swigValue;

        BlockState(int i) {
            this.swigValue = i;
        }

        public int swig() {
            return this.swigValue;
        }

        public static BlockState fromSwig(int i) {
            BlockState[] blockStateArr;
            for (BlockState blockState : (BlockState[]) BlockState.class.getEnumConstants()) {
                if (blockState.swig() == i) {
                    return blockState;
                }
            }
            return UNKNOWN;
        }
    }
}
