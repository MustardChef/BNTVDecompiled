package com.facebook.share;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.CollectionMapper;
import com.facebook.internal.Mutable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ShareApi {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String DEFAULT_GRAPH_NODE = "me";
    private static final String GRAPH_PATH_FORMAT = "%s/%s";
    private static final String PHOTOS_EDGE = "photos";
    private static final String TAG = "ShareApi";
    private String graphNode = DEFAULT_GRAPH_NODE;
    private String message;
    private final ShareContent shareContent;

    static /* synthetic */ void access$000(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            handleImagesOnAction(bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    static /* synthetic */ String access$100(ShareApi shareApi, String str) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return null;
        }
        try {
            return shareApi.getGraphPath(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
            return null;
        }
    }

    static /* synthetic */ void access$200(ShareApi shareApi, ArrayList arrayList, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            shareApi.stageArrayList(arrayList, onMapValueCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    static /* synthetic */ void access$300(ShareApi shareApi, ShareOpenGraphObject shareOpenGraphObject, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            shareApi.stageOpenGraphObject(shareOpenGraphObject, onMapValueCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    static /* synthetic */ void access$400(ShareApi shareApi, SharePhoto sharePhoto, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            shareApi.stagePhoto(sharePhoto, onMapValueCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    public static void share(ShareContent shareContent, FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            new ShareApi(shareContent).share(facebookCallback);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    public ShareApi(ShareContent shareContent) {
        this.shareContent = shareContent;
    }

    public String getMessage() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.message;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setMessage(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.message = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public String getGraphNode() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.graphNode;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setGraphNode(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.graphNode = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public ShareContent getShareContent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.shareContent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public boolean canShare() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (getShareContent() == null) {
                return false;
            }
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (AccessToken.isCurrentAccessTokenActive()) {
                Set<String> permissions = currentAccessToken.getPermissions();
                if (permissions == null || !permissions.contains("publish_actions")) {
                    Log.w(TAG, "The publish_actions permissions are missing, the share will fail unless this app was authorized to publish in another installation.");
                    return true;
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public void share(FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (!canShare()) {
                ShareInternalUtility.invokeCallbackWithError(facebookCallback, "Insufficient permissions for sharing content via Api.");
                return;
            }
            ShareContent shareContent = getShareContent();
            try {
                ShareContentValidation.validateForApiShare(shareContent);
                if (shareContent instanceof ShareLinkContent) {
                    shareLinkContent((ShareLinkContent) shareContent, facebookCallback);
                } else if (shareContent instanceof SharePhotoContent) {
                    sharePhotoContent((SharePhotoContent) shareContent, facebookCallback);
                } else if (shareContent instanceof ShareVideoContent) {
                    shareVideoContent((ShareVideoContent) shareContent, facebookCallback);
                } else if (shareContent instanceof ShareOpenGraphContent) {
                    shareOpenGraphContent((ShareOpenGraphContent) shareContent, facebookCallback);
                }
            } catch (FacebookException e) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private String getGraphPath(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return String.format(Locale.ROOT, GRAPH_PATH_FORMAT, URLEncoder.encode(getGraphNode(), "UTF-8"), str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private void addCommonParameters(Bundle bundle, ShareContent shareContent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            List<String> peopleIds = shareContent.getPeopleIds();
            if (!Utility.isNullOrEmpty(peopleIds)) {
                bundle.putString("tags", TextUtils.join(", ", peopleIds));
            }
            if (!Utility.isNullOrEmpty(shareContent.getPlaceId())) {
                bundle.putString("place", shareContent.getPlaceId());
            }
            if (!Utility.isNullOrEmpty(shareContent.getPageId())) {
                bundle.putString("page", shareContent.getPageId());
            }
            if (Utility.isNullOrEmpty(shareContent.getRef())) {
                return;
            }
            bundle.putString("ref", shareContent.getRef());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void shareOpenGraphContent(ShareOpenGraphContent shareOpenGraphContent, final FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.1
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback, jSONObject == null ? null : jSONObject.optString("id"), graphResponse);
                }
            };
            final ShareOpenGraphAction action = shareOpenGraphContent.getAction();
            final Bundle bundle = action.getBundle();
            addCommonParameters(bundle, shareOpenGraphContent);
            if (!Utility.isNullOrEmpty(getMessage())) {
                bundle.putString("message", getMessage());
            }
            stageOpenGraphAction(bundle, new CollectionMapper.OnMapperCompleteListener() { // from class: com.facebook.share.ShareApi.2
                @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
                public void onComplete() {
                    try {
                        ShareApi.access$000(bundle);
                        new GraphRequest(AccessToken.getCurrentAccessToken(), ShareApi.access$100(ShareApi.this, URLEncoder.encode(action.getActionType(), "UTF-8")), bundle, HttpMethod.POST, callback).executeAsync();
                    } catch (UnsupportedEncodingException e) {
                        ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
                    }
                }

                @Override // com.facebook.internal.CollectionMapper.OnErrorListener
                public void onError(FacebookException facebookException) {
                    ShareInternalUtility.invokeCallbackWithException(facebookCallback, facebookException);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private static void handleImagesOnAction(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            String string = bundle.getString("image");
            if (string != null) {
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null) {
                                putImageInBundleWithArrayFormat(bundle, i, optJSONObject);
                            } else {
                                bundle.putString(String.format(Locale.ROOT, "image[%d][url]", Integer.valueOf(i)), jSONArray.getString(i));
                            }
                        }
                        bundle.remove("image");
                    } catch (JSONException unused) {
                        putImageInBundleWithArrayFormat(bundle, 0, new JSONObject(string));
                        bundle.remove("image");
                    }
                } catch (JSONException unused2) {
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    private static void putImageInBundleWithArrayFormat(Bundle bundle, int i, JSONObject jSONObject) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(ShareApi.class)) {
            return;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(String.format(Locale.ROOT, "image[%d][%s]", Integer.valueOf(i), next), jSONObject.get(next).toString());
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ShareApi.class);
        }
    }

    /* JADX WARN: Type inference failed for: r12v7, types: [T, java.lang.Integer] */
    private void sharePhotoContent(SharePhotoContent sharePhotoContent, final FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final Mutable mutable = new Mutable(0);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            ArrayList arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            final ArrayList arrayList3 = new ArrayList();
            GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.3
                /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.Integer] */
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject != null) {
                        arrayList2.add(jSONObject);
                    }
                    if (graphResponse.getError() != null) {
                        arrayList3.add(graphResponse);
                    }
                    Mutable mutable2 = mutable;
                    mutable2.value = Integer.valueOf(((Integer) mutable2.value).intValue() - 1);
                    if (((Integer) mutable.value).intValue() == 0) {
                        if (!arrayList3.isEmpty()) {
                            ShareInternalUtility.invokeCallbackWithResults(facebookCallback, null, (GraphResponse) arrayList3.get(0));
                        } else if (arrayList2.isEmpty()) {
                        } else {
                            ShareInternalUtility.invokeCallbackWithResults(facebookCallback, ((JSONObject) arrayList2.get(0)).optString("id"), graphResponse);
                        }
                    }
                }
            };
            try {
                for (SharePhoto sharePhoto : sharePhotoContent.getPhotos()) {
                    try {
                        Bundle sharePhotoCommonParameters = getSharePhotoCommonParameters(sharePhoto, sharePhotoContent);
                        Bitmap bitmap = sharePhoto.getBitmap();
                        Uri imageUrl = sharePhoto.getImageUrl();
                        String caption = sharePhoto.getCaption();
                        if (caption == null) {
                            caption = getMessage();
                        }
                        String str = caption;
                        if (bitmap != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), bitmap, str, sharePhotoCommonParameters, callback));
                        } else if (imageUrl != null) {
                            arrayList.add(GraphRequest.newUploadPhotoRequest(currentAccessToken, getGraphPath(PHOTOS_EDGE), imageUrl, str, sharePhotoCommonParameters, callback));
                        }
                    } catch (JSONException e) {
                        ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
                        return;
                    }
                }
                mutable.value = Integer.valueOf(((Integer) mutable.value).intValue() + arrayList.size());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((GraphRequest) it.next()).executeAsync();
                }
            } catch (FileNotFoundException e2) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback, e2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void shareLinkContent(ShareLinkContent shareLinkContent, final FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.4
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    ShareInternalUtility.invokeCallbackWithResults(facebookCallback, jSONObject == null ? null : jSONObject.optString("id"), graphResponse);
                }
            };
            Bundle bundle = new Bundle();
            addCommonParameters(bundle, shareLinkContent);
            bundle.putString("message", getMessage());
            bundle.putString("link", Utility.getUriString(shareLinkContent.getContentUrl()));
            bundle.putString("picture", Utility.getUriString(shareLinkContent.getImageUrl()));
            bundle.putString("name", shareLinkContent.getContentTitle());
            bundle.putString("description", shareLinkContent.getContentDescription());
            bundle.putString("ref", shareLinkContent.getRef());
            new GraphRequest(AccessToken.getCurrentAccessToken(), getGraphPath("feed"), bundle, HttpMethod.POST, callback).executeAsync();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void shareVideoContent(ShareVideoContent shareVideoContent, FacebookCallback<Sharer.Result> facebookCallback) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            try {
                VideoUploader.uploadAsync(shareVideoContent, getGraphNode(), facebookCallback);
            } catch (FileNotFoundException e) {
                ShareInternalUtility.invokeCallbackWithException(facebookCallback, e);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private Bundle getSharePhotoCommonParameters(SharePhoto sharePhoto, SharePhotoContent sharePhotoContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Bundle parameters = sharePhoto.getParameters();
            if (!parameters.containsKey("place") && !Utility.isNullOrEmpty(sharePhotoContent.getPlaceId())) {
                parameters.putString("place", sharePhotoContent.getPlaceId());
            }
            if (!parameters.containsKey("tags") && !Utility.isNullOrEmpty(sharePhotoContent.getPeopleIds())) {
                List<String> peopleIds = sharePhotoContent.getPeopleIds();
                if (!Utility.isNullOrEmpty(peopleIds)) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str : peopleIds) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tag_uid", str);
                        jSONArray.put(jSONObject);
                    }
                    parameters.putString("tags", jSONArray.toString());
                }
            }
            if (!parameters.containsKey("ref") && !Utility.isNullOrEmpty(sharePhotoContent.getRef())) {
                parameters.putString("ref", sharePhotoContent.getRef());
            }
            return parameters;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private void stageArrayList(final ArrayList arrayList, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final JSONArray jSONArray = new JSONArray();
            stageCollectionValues(new CollectionMapper.Collection<Integer>() { // from class: com.facebook.share.ShareApi.5
                @Override // com.facebook.internal.CollectionMapper.Collection
                public Iterator<Integer> keyIterator() {
                    final int size = arrayList.size();
                    final Mutable mutable = new Mutable(0);
                    return new Iterator<Integer>() { // from class: com.facebook.share.ShareApi.5.1
                        @Override // java.util.Iterator
                        public void remove() {
                        }

                        @Override // java.util.Iterator
                        public boolean hasNext() {
                            return ((Integer) mutable.value).intValue() < size;
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.lang.Integer] */
                        @Override // java.util.Iterator
                        public Integer next() {
                            Integer num = (Integer) mutable.value;
                            Mutable mutable2 = mutable;
                            mutable2.value = Integer.valueOf(((Integer) mutable2.value).intValue() + 1);
                            return num;
                        }
                    };
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public Object get(Integer num) {
                    return arrayList.get(num.intValue());
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public void set(Integer num, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                    try {
                        jSONArray.put(num.intValue(), obj);
                    } catch (JSONException e) {
                        String localizedMessage = e.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "Error staging object.";
                        }
                        onErrorListener.onError(new FacebookException(localizedMessage));
                    }
                }
            }, new CollectionMapper.OnMapperCompleteListener() { // from class: com.facebook.share.ShareApi.6
                @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
                public void onComplete() {
                    onMapValueCompleteListener.onComplete(jSONArray);
                }

                @Override // com.facebook.internal.CollectionMapper.OnErrorListener
                public void onError(FacebookException facebookException) {
                    onMapValueCompleteListener.onError(facebookException);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private <T> void stageCollectionValues(CollectionMapper.Collection<T> collection, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            CollectionMapper.iterate(collection, new CollectionMapper.ValueMapper() { // from class: com.facebook.share.ShareApi.7
                @Override // com.facebook.internal.CollectionMapper.ValueMapper
                public void mapValue(Object obj, CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
                    if (obj instanceof ArrayList) {
                        ShareApi.access$200(ShareApi.this, (ArrayList) obj, onMapValueCompleteListener);
                    } else if (obj instanceof ShareOpenGraphObject) {
                        ShareApi.access$300(ShareApi.this, (ShareOpenGraphObject) obj, onMapValueCompleteListener);
                    } else if (obj instanceof SharePhoto) {
                        ShareApi.access$400(ShareApi.this, (SharePhoto) obj, onMapValueCompleteListener);
                    } else {
                        onMapValueCompleteListener.onComplete(obj);
                    }
                }
            }, onMapperCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void stageOpenGraphAction(final Bundle bundle, CollectionMapper.OnMapperCompleteListener onMapperCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            stageCollectionValues(new CollectionMapper.Collection<String>() { // from class: com.facebook.share.ShareApi.8
                @Override // com.facebook.internal.CollectionMapper.Collection
                public Iterator<String> keyIterator() {
                    return bundle.keySet().iterator();
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public Object get(String str) {
                    return bundle.get(str);
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public void set(String str, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                    if (Utility.putJSONValueInBundle(bundle, str, obj)) {
                        return;
                    }
                    onErrorListener.onError(new FacebookException("Unexpected value: " + obj.toString()));
                }
            }, onMapperCompleteListener);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void stageOpenGraphObject(final ShareOpenGraphObject shareOpenGraphObject, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            String string = shareOpenGraphObject.getString("type");
            if (string == null) {
                string = shareOpenGraphObject.getString("og:type");
            }
            final String str = string;
            if (str == null) {
                onMapValueCompleteListener.onError(new FacebookException("Open Graph objects must contain a type value."));
                return;
            }
            final JSONObject jSONObject = new JSONObject();
            CollectionMapper.Collection<String> collection = new CollectionMapper.Collection<String>() { // from class: com.facebook.share.ShareApi.9
                @Override // com.facebook.internal.CollectionMapper.Collection
                public Iterator<String> keyIterator() {
                    return shareOpenGraphObject.keySet().iterator();
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public Object get(String str2) {
                    return shareOpenGraphObject.get(str2);
                }

                @Override // com.facebook.internal.CollectionMapper.Collection
                public void set(String str2, Object obj, CollectionMapper.OnErrorListener onErrorListener) {
                    try {
                        jSONObject.put(str2, obj);
                    } catch (JSONException e) {
                        String localizedMessage = e.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "Error staging object.";
                        }
                        onErrorListener.onError(new FacebookException(localizedMessage));
                    }
                }
            };
            final GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.10
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    FacebookRequestError error = graphResponse.getError();
                    if (error != null) {
                        String errorMessage = error.getErrorMessage();
                        onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage != null ? errorMessage : "Error staging Open Graph object."));
                        return;
                    }
                    JSONObject jSONObject2 = graphResponse.getJSONObject();
                    if (jSONObject2 == null) {
                        onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
                        return;
                    }
                    String optString = jSONObject2.optString("id");
                    if (optString == null) {
                        onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, "Error staging Open Graph object."));
                    } else {
                        onMapValueCompleteListener.onComplete(optString);
                    }
                }
            };
            stageCollectionValues(collection, new CollectionMapper.OnMapperCompleteListener() { // from class: com.facebook.share.ShareApi.11
                @Override // com.facebook.internal.CollectionMapper.OnMapperCompleteListener
                public void onComplete() {
                    String jSONObject2 = jSONObject.toString();
                    Bundle bundle = new Bundle();
                    bundle.putString("object", jSONObject2);
                    try {
                        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
                        ShareApi shareApi = ShareApi.this;
                        new GraphRequest(currentAccessToken, ShareApi.access$100(shareApi, "objects/" + URLEncoder.encode(str, "UTF-8")), bundle, HttpMethod.POST, callback).executeAsync();
                    } catch (UnsupportedEncodingException e) {
                        String localizedMessage = e.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "Error staging Open Graph object.";
                        }
                        onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
                    }
                }

                @Override // com.facebook.internal.CollectionMapper.OnErrorListener
                public void onError(FacebookException facebookException) {
                    onMapValueCompleteListener.onError(facebookException);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void stagePhoto(final SharePhoto sharePhoto, final CollectionMapper.OnMapValueCompleteListener onMapValueCompleteListener) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bitmap bitmap = sharePhoto.getBitmap();
            Uri imageUrl = sharePhoto.getImageUrl();
            if (bitmap == null && imageUrl == null) {
                onMapValueCompleteListener.onError(new FacebookException("Photos must have an imageURL or bitmap."));
                return;
            }
            GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.share.ShareApi.12
                @Override // com.facebook.GraphRequest.Callback
                public void onCompleted(GraphResponse graphResponse) {
                    FacebookRequestError error = graphResponse.getError();
                    if (error != null) {
                        String errorMessage = error.getErrorMessage();
                        onMapValueCompleteListener.onError(new FacebookGraphResponseException(graphResponse, errorMessage != null ? errorMessage : "Error staging photo."));
                        return;
                    }
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        onMapValueCompleteListener.onError(new FacebookException("Error staging photo."));
                        return;
                    }
                    String optString = jSONObject.optString(ShareConstants.MEDIA_URI);
                    if (optString == null) {
                        onMapValueCompleteListener.onError(new FacebookException("Error staging photo."));
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", optString);
                        jSONObject2.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, sharePhoto.getUserGenerated());
                        onMapValueCompleteListener.onComplete(jSONObject2);
                    } catch (JSONException e) {
                        String localizedMessage = e.getLocalizedMessage();
                        onMapValueCompleteListener.onError(new FacebookException(localizedMessage != null ? localizedMessage : "Error staging photo."));
                    }
                }
            };
            if (bitmap != null) {
                ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), bitmap, callback).executeAsync();
                return;
            }
            try {
                ShareInternalUtility.newUploadStagingResourceWithImageRequest(AccessToken.getCurrentAccessToken(), imageUrl, callback).executeAsync();
            } catch (FileNotFoundException e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "Error staging photo.";
                }
                onMapValueCompleteListener.onError(new FacebookException(localizedMessage));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
