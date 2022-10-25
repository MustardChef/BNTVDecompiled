package com.google.android.gms.cast.framework.media;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.cast.framework.C3616R;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public class TracksChooserDialogFragment extends DialogFragment {
    boolean zza;
    List<MediaTrack> zzb;
    List<MediaTrack> zzc;
    private long[] zzd;
    private Dialog zze;
    private RemoteMediaClient zzf;
    private MediaInfo zzg;
    private long[] zzh;

    @Deprecated
    public TracksChooserDialogFragment() {
    }

    public static TracksChooserDialogFragment newInstance() {
        return new TracksChooserDialogFragment();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(TracksChooserDialogFragment tracksChooserDialogFragment, zzbv zzbvVar, zzbv zzbvVar2) {
        if (!tracksChooserDialogFragment.zza) {
            tracksChooserDialogFragment.zzd();
            return;
        }
        RemoteMediaClient remoteMediaClient = (RemoteMediaClient) Preconditions.checkNotNull(tracksChooserDialogFragment.zzf);
        if (!remoteMediaClient.hasMediaSession()) {
            tracksChooserDialogFragment.zzd();
            return;
        }
        ArrayList arrayList = new ArrayList();
        MediaTrack zza = zzbvVar.zza();
        if (zza != null && zza.getId() != -1) {
            arrayList.add(Long.valueOf(zza.getId()));
        }
        MediaTrack zza2 = zzbvVar2.zza();
        if (zza2 != null) {
            arrayList.add(Long.valueOf(zza2.getId()));
        }
        long[] jArr = tracksChooserDialogFragment.zzd;
        if (jArr != null && jArr.length > 0) {
            HashSet hashSet = new HashSet();
            for (MediaTrack mediaTrack : tracksChooserDialogFragment.zzc) {
                hashSet.add(Long.valueOf(mediaTrack.getId()));
            }
            for (MediaTrack mediaTrack2 : tracksChooserDialogFragment.zzb) {
                hashSet.add(Long.valueOf(mediaTrack2.getId()));
            }
            for (long j : jArr) {
                Long valueOf = Long.valueOf(j);
                if (!hashSet.contains(valueOf)) {
                    arrayList.add(valueOf);
                }
            }
        }
        long[] jArr2 = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr2[i] = ((Long) arrayList.get(i)).longValue();
        }
        Arrays.sort(jArr2);
        remoteMediaClient.setActiveMediaTracks(jArr2);
        tracksChooserDialogFragment.zzd();
    }

    private final void zzd() {
        Dialog dialog = this.zze;
        if (dialog != null) {
            dialog.cancel();
            this.zze = null;
        }
    }

    private static ArrayList<MediaTrack> zze(List<MediaTrack> list, int i) {
        ArrayList<MediaTrack> arrayList = new ArrayList<>();
        for (MediaTrack mediaTrack : list) {
            if (mediaTrack.getType() == i) {
                arrayList.add(mediaTrack);
            }
        }
        return arrayList;
    }

    private static int zzf(List<MediaTrack> list, long[] jArr, int i) {
        if (jArr != null && list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                for (long j : jArr) {
                    if (j == list.get(i2).getId()) {
                        return i2;
                    }
                }
            }
        }
        return i;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zza = true;
        this.zzc = new ArrayList();
        this.zzb = new ArrayList();
        this.zzd = new long[0];
        CastSession currentCastSession = CastContext.getSharedInstance(getContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            this.zza = false;
            return;
        }
        RemoteMediaClient remoteMediaClient = currentCastSession.getRemoteMediaClient();
        this.zzf = remoteMediaClient;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || this.zzf.getMediaInfo() == null) {
            this.zza = false;
            return;
        }
        RemoteMediaClient remoteMediaClient2 = this.zzf;
        long[] jArr = this.zzh;
        if (jArr != null) {
            this.zzd = jArr;
        } else {
            MediaStatus mediaStatus = remoteMediaClient2.getMediaStatus();
            if (mediaStatus != null) {
                this.zzd = mediaStatus.getActiveTrackIds();
            }
        }
        MediaInfo mediaInfo = this.zzg;
        if (mediaInfo == null) {
            mediaInfo = remoteMediaClient2.getMediaInfo();
        }
        if (mediaInfo == null) {
            this.zza = false;
            return;
        }
        List<MediaTrack> mediaTracks = mediaInfo.getMediaTracks();
        if (mediaTracks == null) {
            this.zza = false;
            return;
        }
        this.zzc = zze(mediaTracks, 2);
        ArrayList<MediaTrack> zze = zze(mediaTracks, 1);
        this.zzb = zze;
        if (zze.isEmpty()) {
            return;
        }
        List<MediaTrack> list = this.zzb;
        MediaTrack.Builder builder = new MediaTrack.Builder(-1L, 1);
        builder.setName(getActivity().getString(C3616R.string.cast_tracks_chooser_dialog_none));
        builder.setSubtype(2);
        builder.setContentId("");
        list.add(0, builder.build());
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int zzf = zzf(this.zzb, this.zzd, 0);
        int zzf2 = zzf(this.zzc, this.zzd, -1);
        zzbv zzbvVar = new zzbv(getActivity(), this.zzb, zzf);
        zzbv zzbvVar2 = new zzbv(getActivity(), this.zzc, zzf2);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C3616R.C3620layout.cast_tracks_chooser_dialog_layout, (ViewGroup) null);
        ListView listView = (ListView) inflate.findViewById(C3616R.C3619id.text_list_view);
        ListView listView2 = (ListView) inflate.findViewById(C3616R.C3619id.audio_list_view);
        TabHost tabHost = (TabHost) inflate.findViewById(C3616R.C3619id.tab_host);
        tabHost.setup();
        if (zzbvVar.getCount() == 0) {
            listView.setVisibility(4);
        } else {
            listView.setAdapter((ListAdapter) zzbvVar);
            TabHost.TabSpec newTabSpec = tabHost.newTabSpec("textTab");
            newTabSpec.setContent(C3616R.C3619id.text_list_view);
            newTabSpec.setIndicator(getActivity().getString(C3616R.string.cast_tracks_chooser_dialog_subtitles));
            tabHost.addTab(newTabSpec);
        }
        if (zzbvVar2.getCount() <= 1) {
            listView2.setVisibility(4);
        } else {
            listView2.setAdapter((ListAdapter) zzbvVar2);
            TabHost.TabSpec newTabSpec2 = tabHost.newTabSpec("audioTab");
            newTabSpec2.setContent(C3616R.C3619id.audio_list_view);
            newTabSpec2.setIndicator(getActivity().getString(C3616R.string.cast_tracks_chooser_dialog_audio));
            tabHost.addTab(newTabSpec2);
        }
        builder.setView(inflate).setPositiveButton(getActivity().getString(C3616R.string.cast_tracks_chooser_dialog_ok), new zzbs(this, zzbvVar, zzbvVar2)).setNegativeButton(C3616R.string.cast_tracks_chooser_dialog_cancel, new zzbr(this));
        Dialog dialog = this.zze;
        if (dialog != null) {
            dialog.cancel();
            this.zze = null;
        }
        AlertDialog create = builder.create();
        this.zze = create;
        return create;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    private TracksChooserDialogFragment(MediaInfo mediaInfo, long[] jArr) {
        this.zzg = mediaInfo;
        this.zzh = jArr;
    }

    @Deprecated
    public static TracksChooserDialogFragment newInstance(MediaInfo mediaInfo, long[] jArr) {
        return new TracksChooserDialogFragment(mediaInfo, jArr);
    }
}
