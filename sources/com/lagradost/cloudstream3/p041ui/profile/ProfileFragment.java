package com.lagradost.cloudstream3.p041ui.profile;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blankj.utilcode.util.LogUtils;
import com.bongngotv2.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.p041ui.download.DownloadFragment;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.phimhd.AppController;
import com.phimhd.BaseActivity;
import com.phimhd.Constants;
import com.phimhd.Key;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.concurrent.Thread;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ProfileFragment.kt */
@Metadata(m108d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001a\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u001aH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "callbackManager", "Lcom/facebook/CallbackManager;", "getCallbackManager", "()Lcom/facebook/CallbackManager;", "setCallbackManager", "(Lcom/facebook/CallbackManager;)V", "receiver", "Landroid/content/BroadcastReceiver;", "shareDialog", "Lcom/facebook/share/widget/ShareDialog;", "getShareDialog", "()Lcom/facebook/share/widget/ShareDialog;", "setShareDialog", "(Lcom/facebook/share/widget/ShareDialog;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "parseKeyString", "", SDKConstants.PARAM_KEY, "Lcom/phimhd/Key;", "setOnClickView", "updateKey", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.profile.ProfileFragment */
/* loaded from: classes3.dex */
public final class ProfileFragment extends Fragment {
    private CallbackManager callbackManager;
    private ShareDialog shareDialog;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.lagradost.cloudstream3.ui.profile.ProfileFragment$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            ProfileFragment.this.updateKey();
        }
    };

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final CallbackManager getCallbackManager() {
        return this.callbackManager;
    }

    public final void setCallbackManager(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public final ShareDialog getShareDialog() {
        return this.shareDialog;
    }

    public final void setShareDialog(ShareDialog shareDialog) {
        this.shareDialog = shareDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(4);
        }
        return inflater.inflate(R.layout.profile_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.callbackManager = CallbackManager.Factory.create();
        ShareDialog shareDialog = new ShareDialog(this);
        this.shareDialog = shareDialog;
        shareDialog.registerCallback(this.callbackManager, new FacebookCallback<Sharer.Result>() { // from class: com.lagradost.cloudstream3.ui.profile.ProfileFragment$onViewCreated$1
            @Override // com.facebook.FacebookCallback
            public void onCancel() {
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException facebookException) {
            }

            @Override // com.facebook.FacebookCallback
            public void onSuccess(Sharer.Result result) {
                StringBuilder sb = new StringBuilder();
                sb.append("onSuccess = ");
                sb.append(result != null ? result.getPostId() : null);
                LogUtils.m6080d(sb.toString(), new Object[0]);
            }
        });
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(11) <= 12) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("Chào buổi sáng %s, Chúc bạn một ngày tốt lành!", Arrays.copyOf(new Object[]{""}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvGreeting)).setText(format);
        } else if (calendar.get(11) <= 19 && calendar.get(11) > 12) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("Xin chào %s, Chúc bạn một ngày tốt lành!", Arrays.copyOf(new Object[]{""}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvGreeting)).setText(format2);
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("Xin chào %s, Ngày hôm nay của bạn thế nào?", Arrays.copyOf(new Object[]{""}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvGreeting)).setText(format3);
        }
        ((TextView) _$_findCachedViewById(C4761R.C4764id.textView18)).setText("Phiên bản 5.6.84(84)");
        setOnClickView();
        updateKey();
    }

    private final void setOnClickView() {
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.tvAdvance);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$AcWv8bUrYnKFzR7uvIc8rE6lk3Q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8741setOnClickView$lambda0(ProfileFragment.this, view);
                }
            });
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvPrivacy);
        if (textView2 != null) {
            textView2.setOnClickListener($$Lambda$ProfileFragment$BACrI_ca3DrrqUPQpABFxnZKjGo.INSTANCE);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvShare);
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$IEcH__-lFLbVBZfKc2JieKqdLqo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8743setOnClickView$lambda2(ProfileFragment.this, view);
                }
            });
        }
        TextView textView4 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvFAQ);
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$tKMIlF_8pEc2w3BxQfmasW3eoHo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8744setOnClickView$lambda3(ProfileFragment.this, view);
                }
            });
        }
        TextView textView5 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvContact);
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$Tc1WaE-C1RQi3rosumMID7W3sOw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8745setOnClickView$lambda4(ProfileFragment.this, view);
                }
            });
        }
        TextView textView6 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvWebsite);
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$5VVsE3qHokg7j4U8jpSCqLtUJ1U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8746setOnClickView$lambda5(ProfileFragment.this, view);
                }
            });
        }
        TextView textView7 = (TextView) _$_findCachedViewById(C4761R.C4764id.textView14);
        if (textView7 != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$aoKB4YDtIVcdYQgsSTAJExWVUnk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8747setOnClickView$lambda6(ProfileFragment.this, view);
                }
            });
        }
        TextView textView8 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvLevel);
        if (textView8 != null) {
            textView8.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$41QrrXk_D3W-4vYiAfkJcLyTBiY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8748setOnClickView$lambda7(ProfileFragment.this, view);
                }
            });
        }
        TextView textView9 = (TextView) _$_findCachedViewById(C4761R.C4764id.tvDownload);
        if (textView9 != null) {
            textView9.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.profile.-$$Lambda$ProfileFragment$6iWAygcAumq-PEpEO8vEsrm4y-E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.m8749setOnClickView$lambda8(ProfileFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-0  reason: not valid java name */
    public static final void m8741setOnClickView$lambda0(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsFragment.Companion.push(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-1  reason: not valid java name */
    public static final void m8742setOnClickView$lambda1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle(R.string.legal_notice);
        builder.setMessage(R.string.legal_notice_text);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-2  reason: not valid java name */
    public static final void m8743setOnClickView$lambda2(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ShareDialog.canShow((Class<? extends ShareContent>) ShareLinkContent.class)) {
            ShareLinkContent build = new ShareLinkContent.Builder().setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.bongngotv2")).setShareHashtag(new ShareHashtag.Builder().setHashtag("#phimhd").build()).setQuote("BongNgoTV - Ở đây toàn phim hay").build();
            ShareDialog shareDialog = this$0.shareDialog;
            Intrinsics.checkNotNull(shareDialog);
            shareDialog.show(build);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-3  reason: not valid java name */
    public static final void m8744setOnClickView$lambda3(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this$0.requireContext().getPackageName()));
        intent.addFlags(1208483840);
        try {
            this$0.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + this$0.requireContext().getPackageName())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-4  reason: not valid java name */
    public static final void m8745setOnClickView$lambda4(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(Constants.URL_PAGE));
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-5  reason: not valid java name */
    public static final void m8746setOnClickView$lambda5(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Thread.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new ProfileFragment$setOnClickView$6$1(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-6  reason: not valid java name */
    public static final void m8747setOnClickView$lambda6(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseActivity baseActivity = (BaseActivity) this$0.getActivity();
        if (baseActivity != null) {
            baseActivity.showDialogUpgrade();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-7  reason: not valid java name */
    public static final void m8748setOnClickView$lambda7(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseActivity baseActivity = (BaseActivity) this$0.getActivity();
        if (baseActivity != null) {
            baseActivity.showDialogKeyUpgrade();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickView$lambda-8  reason: not valid java name */
    public static final void m8749setOnClickView$lambda8(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DownloadFragment.Companion.push(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateKey() {
        AppController companion = AppController.Companion.getInstance();
        Key key = companion != null ? companion.getKey() : null;
        if (key != null) {
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvUsername)).setText(parseKeyString(key));
            ((TextView) _$_findCachedViewById(C4761R.C4764id.textView14)).setText("Gia hạn");
            if (key.isExpired()) {
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView13)).setVisibility(0);
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView14)).setVisibility(0);
            } else {
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView13)).setVisibility(4);
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView14)).setVisibility(4);
            }
            if (key.getExpiredTime() != -1) {
                Date date = new Date(key.getExpiredTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Ngày hết hạn: %s", Arrays.copyOf(new Object[]{simpleDateFormat.format(date)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView13)).setText(format);
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView14)).setText("Nâng cấp");
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView13)).setVisibility(0);
                ((TextView) _$_findCachedViewById(C4761R.C4764id.textView14)).setVisibility(0);
            } else {
                ((TextView) _$_findCachedViewById(C4761R.C4764id.tvLevel)).setText("Unlimited");
            }
        } else {
            ((TextView) _$_findCachedViewById(C4761R.C4764id.tvLevel)).setText("Chuẩn");
            ((TextView) _$_findCachedViewById(C4761R.C4764id.textView14)).setText("Nâng cấp");
            ((TextView) _$_findCachedViewById(C4761R.C4764id.textView13)).setText("Miễn phí");
        }
        ((SwipeRefreshLayout) _$_findCachedViewById(C4761R.C4764id.swipe)).setRefreshing(false);
    }

    private final String parseKeyString(Key key) {
        if (key.getKey().length() > 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Mã kích hoạt: ****");
            String key2 = key.getKey();
            Intrinsics.checkNotNullExpressionValue(key2, "key.key");
            String substring = key2.substring(4);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }
        return "Mã kích hoạt: " + key.getKey();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Context context = getContext();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.receiver);
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Constants.INTENT_UPDATE_KEY);
        Context context = getContext();
        if (context != null) {
            LocalBroadcastManager.getInstance(context).registerReceiver(this.receiver, intentFilter);
        }
    }
}
