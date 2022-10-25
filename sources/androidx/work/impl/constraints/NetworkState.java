package androidx.work.impl.constraints;

/* loaded from: classes.dex */
public class NetworkState {
    private boolean mIsConnected;
    private boolean mIsMetered;
    private boolean mIsNotRoaming;
    private boolean mIsValidated;

    public NetworkState(boolean isConnected, boolean isValidated, boolean isMetered, boolean isNotRoaming) {
        this.mIsConnected = isConnected;
        this.mIsValidated = isValidated;
        this.mIsMetered = isMetered;
        this.mIsNotRoaming = isNotRoaming;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    public boolean isMetered() {
        return this.mIsMetered;
    }

    public boolean isNotRoaming() {
        return this.mIsNotRoaming;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof NetworkState) {
            NetworkState networkState = (NetworkState) o;
            return this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming;
        }
        return false;
    }

    public int hashCode() {
        int i = this.mIsConnected ? 1 : 0;
        if (this.mIsValidated) {
            i += 16;
        }
        if (this.mIsMetered) {
            i += 256;
        }
        return this.mIsNotRoaming ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.mIsConnected), Boolean.valueOf(this.mIsValidated), Boolean.valueOf(this.mIsMetered), Boolean.valueOf(this.mIsNotRoaming));
    }
}
