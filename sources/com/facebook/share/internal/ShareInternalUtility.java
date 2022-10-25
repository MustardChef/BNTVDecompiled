package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ShareInternalUtility {
    public static final String MY_PHOTOS = "me/photos";
    private static final String MY_STAGING_RESOURCES = "me/staging_resources";
    private static final String STAGING_PARAM = "file";

    static /* synthetic */ NativeAppCallAttachmentStore.Attachment access$000(UUID uuid, ShareMedia shareMedia) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            return getAttachment(uuid, shareMedia);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> facebookCallback, Exception exc) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            if (exc instanceof FacebookException) {
                invokeOnErrorCallback(facebookCallback, (FacebookException) exc);
                return;
            }
            invokeCallbackWithError(facebookCallback, "Error preparing share content: " + exc.getLocalizedMessage());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            invokeOnErrorCallback(facebookCallback, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> facebookCallback, String str, GraphResponse graphResponse) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            FacebookRequestError error = graphResponse.getError();
            if (error != null) {
                String errorMessage = error.getErrorMessage();
                if (Utility.isNullOrEmpty(errorMessage)) {
                    errorMessage = "Unexpected error sharing.";
                }
                invokeOnErrorCallback(facebookCallback, graphResponse, errorMessage);
                return;
            }
            invokeOnSuccessCallback(facebookCallback, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    public static String getNativeDialogCompletionGesture(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            if (bundle.containsKey(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY)) {
                return bundle.getString(NativeProtocol.RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY);
            }
            return bundle.getString(NativeProtocol.EXTRA_DIALOG_COMPLETION_GESTURE_KEY);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static String getShareDialogPostId(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            if (bundle.containsKey(ShareConstants.RESULT_POST_ID)) {
                return bundle.getString(ShareConstants.RESULT_POST_ID);
            }
            if (bundle.containsKey(ShareConstants.EXTRA_RESULT_POST_ID)) {
                return bundle.getString(ShareConstants.EXTRA_RESULT_POST_ID);
            }
            return bundle.getString(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static boolean handleActivityResult(int i, int i2, Intent intent, ResultProcessor resultProcessor) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return false;
        }
        try {
            AppCall appCallFromActivityResult = getAppCallFromActivityResult(i, i2, intent);
            if (appCallFromActivityResult == null) {
                return false;
            }
            NativeAppCallAttachmentStore.cleanupAttachmentsForCall(appCallFromActivityResult.getCallId());
            if (resultProcessor == null) {
                return true;
            }
            FacebookException exceptionFromErrorData = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(intent));
            if (exceptionFromErrorData != null) {
                if (exceptionFromErrorData instanceof FacebookOperationCanceledException) {
                    resultProcessor.onCancel(appCallFromActivityResult);
                } else {
                    resultProcessor.onError(appCallFromActivityResult, exceptionFromErrorData);
                }
            } else {
                resultProcessor.onSuccess(appCallFromActivityResult, NativeProtocol.getSuccessResultsFromIntent(intent));
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return false;
        }
    }

    public static ResultProcessor getShareResultProcessor(final FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            return new ResultProcessor(facebookCallback) { // from class: com.facebook.share.internal.ShareInternalUtility.1
                @Override // com.facebook.share.internal.ResultProcessor
                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if (bundle != null) {
                        String nativeDialogCompletionGesture = ShareInternalUtility.getNativeDialogCompletionGesture(bundle);
                        if (nativeDialogCompletionGesture == null || "post".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                            ShareInternalUtility.invokeOnSuccessCallback(facebookCallback, ShareInternalUtility.getShareDialogPostId(bundle));
                        } else if ("cancel".equalsIgnoreCase(nativeDialogCompletionGesture)) {
                            ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                        } else {
                            ShareInternalUtility.invokeOnErrorCallback(facebookCallback, new FacebookException(NativeProtocol.ERROR_UNKNOWN_ERROR));
                        }
                    }
                }

                @Override // com.facebook.share.internal.ResultProcessor
                public void onCancel(AppCall appCall) {
                    ShareInternalUtility.invokeOnCancelCallback(facebookCallback);
                }

                @Override // com.facebook.share.internal.ResultProcessor
                public void onError(AppCall appCall, FacebookException facebookException) {
                    ShareInternalUtility.invokeOnErrorCallback(facebookCallback, facebookException);
                }
            };
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    private static AppCall getAppCallFromActivityResult(int i, int i2, Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            UUID callIdFromIntent = NativeProtocol.getCallIdFromIntent(intent);
            if (callIdFromIntent == null) {
                return null;
            }
            return AppCall.finishPendingCall(callIdFromIntent, i);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static void registerStaticShareCallback(final int i) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            CallbackManagerImpl.registerStaticCallback(i, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.ShareInternalUtility.2
                @Override // com.facebook.internal.CallbackManagerImpl.Callback
                public boolean onActivityResult(int i2, Intent intent) {
                    return ShareInternalUtility.handleActivityResult(i, i2, intent, ShareInternalUtility.getShareResultProcessor(null));
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    public static void registerSharerCallback(final int i, CallbackManager callbackManager, final FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            if (!(callbackManager instanceof CallbackManagerImpl)) {
                throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
            }
            ((CallbackManagerImpl) callbackManager).registerCallback(i, new CallbackManagerImpl.Callback() { // from class: com.facebook.share.internal.ShareInternalUtility.3
                @Override // com.facebook.internal.CallbackManagerImpl.Callback
                public boolean onActivityResult(int i2, Intent intent) {
                    return ShareInternalUtility.handleActivityResult(i, i2, intent, ShareInternalUtility.getShareResultProcessor(facebookCallback));
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    public static List<String> getPhotoUrls(SharePhotoContent sharePhotoContent, final UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) && sharePhotoContent != null) {
            try {
                List<SharePhoto> photos = sharePhotoContent.getPhotos();
                if (photos != null) {
                    List map = Utility.map(photos, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>() { // from class: com.facebook.share.internal.ShareInternalUtility.4
                        @Override // com.facebook.internal.Utility.Mapper
                        public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                            return ShareInternalUtility.access$000(uuid, sharePhoto);
                        }
                    });
                    List<String> map2 = Utility.map(map, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String>() { // from class: com.facebook.share.internal.ShareInternalUtility.5
                        @Override // com.facebook.internal.Utility.Mapper
                        public String apply(NativeAppCallAttachmentStore.Attachment attachment) {
                            return attachment.getAttachmentUrl();
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(map);
                    return map2;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            }
        }
        return null;
    }

    public static String getVideoUrl(ShareVideoContent shareVideoContent, UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) && shareVideoContent != null) {
            try {
                if (shareVideoContent.getVideo() != null) {
                    NativeAppCallAttachmentStore.Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, shareVideoContent.getVideo().getLocalUrl());
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(createAttachment);
                    NativeAppCallAttachmentStore.addAttachments(arrayList);
                    return createAttachment.getAttachmentUrl();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            }
        }
        return null;
    }

    public static List<Bundle> getMediaInfos(ShareMediaContent shareMediaContent, final UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) && shareMediaContent != null) {
            try {
                List<ShareMedia> media = shareMediaContent.getMedia();
                if (media != null) {
                    final ArrayList arrayList = new ArrayList();
                    List<Bundle> map = Utility.map(media, new Utility.Mapper<ShareMedia, Bundle>() { // from class: com.facebook.share.internal.ShareInternalUtility.6
                        @Override // com.facebook.internal.Utility.Mapper
                        public Bundle apply(ShareMedia shareMedia) {
                            NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                            arrayList.add(access$000);
                            Bundle bundle = new Bundle();
                            bundle.putString("type", shareMedia.getMediaType().name());
                            bundle.putString(ShareConstants.MEDIA_URI, access$000.getAttachmentUrl());
                            return bundle;
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(arrayList);
                    return map;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            }
        }
        return null;
    }

    public static Bundle getTextureUrlBundle(ShareCameraEffectContent shareCameraEffectContent, UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) && shareCameraEffectContent != null) {
            try {
                CameraEffectTextures textures = shareCameraEffectContent.getTextures();
                if (textures != null) {
                    Bundle bundle = new Bundle();
                    ArrayList arrayList = new ArrayList();
                    for (String str : textures.keySet()) {
                        NativeAppCallAttachmentStore.Attachment attachment = getAttachment(uuid, textures.getTextureUri(str), textures.getTextureBitmap(str));
                        arrayList.add(attachment);
                        bundle.putString(str, attachment.getAttachmentUrl());
                    }
                    NativeAppCallAttachmentStore.addAttachments(arrayList);
                    return bundle;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            }
        }
        return null;
    }

    public static JSONObject toJSONObjectForCall(final UUID uuid, ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        Set jsonArrayToSet;
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            ShareOpenGraphAction action = shareOpenGraphContent.getAction();
            final ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = OpenGraphJSONUtility.toJSONObject(action, new OpenGraphJSONUtility.PhotoJSONProcessor() { // from class: com.facebook.share.internal.ShareInternalUtility.7
                @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
                public JSONObject toJSONObject(SharePhoto sharePhoto) {
                    NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, sharePhoto);
                    if (access$000 == null) {
                        return null;
                    }
                    arrayList.add(access$000);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", access$000.getAttachmentUrl());
                        if (sharePhoto.getUserGenerated()) {
                            jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                        }
                        return jSONObject2;
                    } catch (JSONException e) {
                        throw new FacebookException("Unable to attach images", e);
                    }
                }
            });
            NativeAppCallAttachmentStore.addAttachments(arrayList);
            if (shareOpenGraphContent.getPlaceId() != null && Utility.isNullOrEmpty(jSONObject.optString("place"))) {
                jSONObject.put("place", shareOpenGraphContent.getPlaceId());
            }
            if (shareOpenGraphContent.getPeopleIds() != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("tags");
                if (optJSONArray == null) {
                    jsonArrayToSet = new HashSet();
                } else {
                    jsonArrayToSet = Utility.jsonArrayToSet(optJSONArray);
                }
                for (String str : shareOpenGraphContent.getPeopleIds()) {
                    jsonArrayToSet.add(str);
                }
                jSONObject.put("tags", new JSONArray((Collection) jsonArrayToSet));
            }
            return jSONObject;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent shareOpenGraphContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            return OpenGraphJSONUtility.toJSONObject(shareOpenGraphContent.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor() { // from class: com.facebook.share.internal.ShareInternalUtility.8
                @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
                public JSONObject toJSONObject(SharePhoto sharePhoto) {
                    Uri imageUrl = sharePhoto.getImageUrl();
                    if (!Utility.isWebUri(imageUrl)) {
                        throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", imageUrl.toString());
                        return jSONObject;
                    } catch (JSONException e) {
                        throw new FacebookException("Unable to attach images", e);
                    }
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static JSONArray removeNamespacesFromOGJsonArray(JSONArray jSONArray, boolean z) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj instanceof JSONArray) {
                    obj = removeNamespacesFromOGJsonArray((JSONArray) obj, z);
                } else if (obj instanceof JSONObject) {
                    obj = removeNamespacesFromOGJsonObject((JSONObject) obj, z);
                }
                jSONArray2.put(obj);
            }
            return jSONArray2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static JSONObject removeNamespacesFromOGJsonObject(JSONObject jSONObject, boolean z) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) || jSONObject == null) {
            return null;
        }
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONArray names = jSONObject.names();
                for (int i = 0; i < names.length(); i++) {
                    String string = names.getString(i);
                    Object obj = jSONObject.get(string);
                    if (obj instanceof JSONObject) {
                        obj = removeNamespacesFromOGJsonObject((JSONObject) obj, true);
                    } else if (obj instanceof JSONArray) {
                        obj = removeNamespacesFromOGJsonArray((JSONArray) obj, true);
                    }
                    Pair<String, String> fieldNameAndNamespaceFromFullName = getFieldNameAndNamespaceFromFullName(string);
                    String str = (String) fieldNameAndNamespaceFromFullName.first;
                    String str2 = (String) fieldNameAndNamespaceFromFullName.second;
                    if (z) {
                        if (str != null && str.equals("fbsdk")) {
                            jSONObject2.put(string, obj);
                        } else {
                            if (str != null && !str.equals("og")) {
                                jSONObject3.put(str2, obj);
                            }
                            jSONObject2.put(str2, obj);
                        }
                    } else if (str != null && str.equals("fb")) {
                        jSONObject2.put(string, obj);
                    } else {
                        jSONObject2.put(str2, obj);
                    }
                }
                if (jSONObject3.length() > 0) {
                    jSONObject2.put("data", jSONObject3);
                }
                return jSONObject2;
            } catch (JSONException unused) {
                throw new FacebookException("Failed to create json object from share content");
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String str) {
        String str2;
        int i;
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            int indexOf = str.indexOf(58);
            if (indexOf == -1 || str.length() <= (i = indexOf + 1)) {
                str2 = null;
            } else {
                str2 = str.substring(0, indexOf);
                str = str.substring(i);
            }
            return new Pair<>(str2, str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, ShareMedia shareMedia) {
        Uri uri;
        Bitmap bitmap;
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            if (shareMedia instanceof SharePhoto) {
                SharePhoto sharePhoto = (SharePhoto) shareMedia;
                bitmap = sharePhoto.getBitmap();
                uri = sharePhoto.getImageUrl();
            } else if (shareMedia instanceof ShareVideo) {
                uri = ((ShareVideo) shareMedia).getLocalUrl();
                bitmap = null;
            } else {
                uri = null;
                bitmap = null;
            }
            return getAttachment(uuid, uri, bitmap);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID uuid, Uri uri, Bitmap bitmap) {
        NativeAppCallAttachmentStore.Attachment attachment = null;
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
        if (bitmap == null) {
            if (uri != null) {
                attachment = NativeAppCallAttachmentStore.createAttachment(uuid, uri);
            }
            return attachment;
        }
        attachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
        return attachment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, null);
            if (facebookCallback != null) {
                facebookCallback.onCancel();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            logShareResult(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED, null);
            if (facebookCallback != null) {
                facebookCallback.onSuccess(new Sharer.Result(str));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, GraphResponse graphResponse, String str) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            logShareResult("error", str);
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookGraphResponseException(graphResponse, str));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, String str) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            logShareResult("error", str);
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException(str));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> facebookCallback, FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            logShareResult("error", facebookException.getMessage());
            if (facebookCallback != null) {
                facebookCallback.onError(facebookException);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    private static void logShareResult(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return;
        }
        try {
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());
            Bundle bundle = new Bundle();
            bundle.putString(AnalyticsEvents.PARAMETER_SHARE_OUTCOME, str);
            if (str2 != null) {
                bundle.putString("error_message", str2);
            }
            internalAppEventsLogger.logEventImplicitly(AnalyticsEvents.EVENT_SHARE_RESULT, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Bitmap bitmap, GraphRequest.Callback callback) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, bitmap);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, File file, GraphRequest.Callback callback) throws FileNotFoundException {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken accessToken, Uri uri, GraphRequest.Callback callback) throws FileNotFoundException {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        try {
            if (Utility.isFileUri(uri)) {
                return newUploadStagingResourceWithImageRequest(accessToken, new File(uri.getPath()), callback);
            }
            if (!Utility.isContentUri(uri)) {
                throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
            }
            GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
            Bundle bundle = new Bundle(1);
            bundle.putParcelable(STAGING_PARAM, parcelableResourceWithMimeType);
            return new GraphRequest(accessToken, MY_STAGING_RESOURCES, bundle, HttpMethod.POST, callback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType objectType, LikeView.ObjectType objectType2) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class)) {
            return null;
        }
        if (objectType == objectType2) {
            return objectType;
        }
        try {
            if (objectType == LikeView.ObjectType.UNKNOWN) {
                return objectType2;
            }
            if (objectType2 == LikeView.ObjectType.UNKNOWN) {
                return objectType;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }

    public static Bundle getStickerUrl(ShareStoryContent shareStoryContent, final UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) && shareStoryContent != null) {
            try {
                if (shareStoryContent.getStickerAsset() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.getStickerAsset());
                    List map = Utility.map(arrayList, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>() { // from class: com.facebook.share.internal.ShareInternalUtility.9
                        @Override // com.facebook.internal.Utility.Mapper
                        public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
                            return ShareInternalUtility.access$000(uuid, sharePhoto);
                        }
                    });
                    List map2 = Utility.map(map, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, Bundle>() { // from class: com.facebook.share.internal.ShareInternalUtility.10
                        @Override // com.facebook.internal.Utility.Mapper
                        public Bundle apply(NativeAppCallAttachmentStore.Attachment attachment) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
                            String uriExtension = ShareInternalUtility.getUriExtension(attachment.getOriginalUri());
                            if (uriExtension != null) {
                                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                            }
                            return bundle;
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(map);
                    return (Bundle) map2.get(0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            }
        }
        return null;
    }

    public static Bundle getBackgroundAssetMediaInfo(ShareStoryContent shareStoryContent, final UUID uuid) {
        if (!CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) && shareStoryContent != null) {
            try {
                if (shareStoryContent.getBackgroundAsset() != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(shareStoryContent.getBackgroundAsset());
                    final ArrayList arrayList2 = new ArrayList();
                    List map = Utility.map(arrayList, new Utility.Mapper<ShareMedia, Bundle>() { // from class: com.facebook.share.internal.ShareInternalUtility.11
                        @Override // com.facebook.internal.Utility.Mapper
                        public Bundle apply(ShareMedia shareMedia) {
                            NativeAppCallAttachmentStore.Attachment access$000 = ShareInternalUtility.access$000(uuid, shareMedia);
                            arrayList2.add(access$000);
                            Bundle bundle = new Bundle();
                            bundle.putString("type", shareMedia.getMediaType().name());
                            bundle.putString(ShareConstants.MEDIA_URI, access$000.getAttachmentUrl());
                            String uriExtension = ShareInternalUtility.getUriExtension(access$000.getOriginalUri());
                            if (uriExtension != null) {
                                Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
                            }
                            return bundle;
                        }
                    });
                    NativeAppCallAttachmentStore.addAttachments(arrayList2);
                    return (Bundle) map.get(0);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            }
        }
        return null;
    }

    public static String getUriExtension(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(ShareInternalUtility.class) || uri == null) {
            return null;
        }
        try {
            String uri2 = uri.toString();
            int lastIndexOf = uri2.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return null;
            }
            return uri2.substring(lastIndexOf);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareInternalUtility.class);
            return null;
        }
    }
}
