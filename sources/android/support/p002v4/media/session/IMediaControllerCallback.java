package android.support.p002v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p002v4.media.MediaMetadataCompat;
import android.support.p002v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import java.util.List;

/* renamed from: android.support.v4.media.session.IMediaControllerCallback */
/* loaded from: classes.dex */
public interface IMediaControllerCallback extends IInterface {

    /* renamed from: android.support.v4.media.session.IMediaControllerCallback$Default */
    /* loaded from: classes.dex */
    public static class Default implements IMediaControllerCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onCaptioningEnabledChanged(boolean enabled) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onEvent(String event, Bundle extras) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onExtrasChanged(Bundle extras) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onPlaybackStateChanged(PlaybackStateCompat state) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onQueueTitleChanged(CharSequence title) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onRepeatModeChanged(int repeatMode) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onSessionDestroyed() throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onSessionReady() throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onShuffleModeChanged(int shuffleMode) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onShuffleModeChangedRemoved(boolean enabled) throws RemoteException {
        }

        @Override // android.support.p002v4.media.session.IMediaControllerCallback
        public void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException {
        }
    }

    void onCaptioningEnabledChanged(boolean enabled) throws RemoteException;

    void onEvent(String event, Bundle extras) throws RemoteException;

    void onExtrasChanged(Bundle extras) throws RemoteException;

    void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException;

    void onPlaybackStateChanged(PlaybackStateCompat state) throws RemoteException;

    void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException;

    void onQueueTitleChanged(CharSequence title) throws RemoteException;

    void onRepeatModeChanged(int repeatMode) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int shuffleMode) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean enabled) throws RemoteException;

    void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException;

    /* renamed from: android.support.v4.media.session.IMediaControllerCallback$Stub */
    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onSessionReady = 13;
        static final int TRANSACTION_onShuffleModeChanged = 12;
        static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaControllerCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface queryLocalInterface = obj.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IMediaControllerCallback)) {
                return (IMediaControllerCallback) queryLocalInterface;
            }
            return new Proxy(obj);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code == 1598968902) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    onEvent(data.readString(), data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    onSessionDestroyed();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    onPlaybackStateChanged(data.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(data) : null);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    onMetadataChanged(data.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(data) : null);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    onQueueChanged(data.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    onQueueTitleChanged(data.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(data) : null);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    onExtrasChanged(data.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(data) : null);
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    onVolumeInfoChanged(data.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(data) : null);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    onRepeatModeChanged(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    onShuffleModeChangedRemoved(data.readInt() != 0);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    onCaptioningEnabledChanged(data.readInt() != 0);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    onShuffleModeChanged(data.readInt());
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    onSessionReady();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.IMediaControllerCallback$Stub$Proxy */
        /* loaded from: classes.dex */
        public static class Proxy implements IMediaControllerCallback {
            public static IMediaControllerCallback sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onEvent(String event, Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(event);
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onEvent(event, extras);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSessionDestroyed();
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat state) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (state != null) {
                        obtain.writeInt(1);
                        state.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(3, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onPlaybackStateChanged(state);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat metadata) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (metadata != null) {
                        obtain.writeInt(1);
                        metadata.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(4, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onMetadataChanged(metadata);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> queue) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedList(queue);
                    if (this.mRemote.transact(5, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onQueueChanged(queue);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence title) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (title != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(title, obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(6, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onQueueTitleChanged(title);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle extras) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (extras != null) {
                        obtain.writeInt(1);
                        extras.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(7, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onExtrasChanged(extras);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo info) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (info != null) {
                        obtain.writeInt(1);
                        info.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(8, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onVolumeInfoChanged(info);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int repeatMode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(repeatMode);
                    if (this.mRemote.transact(9, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onRepeatModeChanged(repeatMode);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean enabled) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(enabled ? 1 : 0);
                    if (this.mRemote.transact(10, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onShuffleModeChangedRemoved(enabled);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean enabled) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(enabled ? 1 : 0);
                    if (this.mRemote.transact(11, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onCaptioningEnabledChanged(enabled);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int shuffleMode) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(shuffleMode);
                    if (this.mRemote.transact(12, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onShuffleModeChanged(shuffleMode);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.p002v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, obtain, null, 1) || Stub.getDefaultImpl() == null) {
                        return;
                    }
                    Stub.getDefaultImpl().onSessionReady();
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IMediaControllerCallback impl) {
            if (Proxy.sDefaultImpl == null) {
                if (impl != null) {
                    Proxy.sDefaultImpl = impl;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        public static IMediaControllerCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
