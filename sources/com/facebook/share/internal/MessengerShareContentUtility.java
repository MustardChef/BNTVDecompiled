package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.model.ShareMessengerActionButton;
import com.facebook.share.model.ShareMessengerGenericTemplateContent;
import com.facebook.share.model.ShareMessengerGenericTemplateElement;
import com.facebook.share.model.ShareMessengerMediaTemplateContent;
import com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent;
import com.facebook.share.model.ShareMessengerURLActionButton;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MessengerShareContentUtility {
    public static final String ATTACHMENT = "attachment";
    public static final String ATTACHMENT_ID = "attachment_id";
    public static final String ATTACHMENT_PAYLOAD = "payload";
    public static final String ATTACHMENT_TEMPLATE_TYPE = "template";
    public static final String ATTACHMENT_TYPE = "type";
    public static final String BUTTONS = "buttons";
    public static final String BUTTON_TYPE = "type";
    public static final String BUTTON_URL_TYPE = "web_url";
    public static final String DEFAULT_ACTION = "default_action";
    public static final String ELEMENTS = "elements";
    public static final Pattern FACEBOOK_DOMAIN = Pattern.compile("^(.+)\\.(facebook\\.com)$");
    public static final String FALLBACK_URL = "fallback_url";
    public static final String IMAGE_ASPECT_RATIO = "image_aspect_ratio";
    public static final String IMAGE_RATIO_HORIZONTAL = "horizontal";
    public static final String IMAGE_RATIO_SQUARE = "square";
    public static final String IMAGE_URL = "image_url";
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_TYPE = "media_type";
    public static final String MEDIA_VIDEO = "video";
    public static final String MESSENGER_EXTENSIONS = "messenger_extensions";
    public static final String PREVIEW_DEFAULT = "DEFAULT";
    public static final String PREVIEW_OPEN_GRAPH = "OPEN_GRAPH";
    public static final String SHARABLE = "sharable";
    public static final String SHARE_BUTTON_HIDE = "hide";
    public static final String SUBTITLE = "subtitle";
    public static final String TEMPLATE_GENERIC_TYPE = "generic";
    public static final String TEMPLATE_MEDIA_TYPE = "media";
    public static final String TEMPLATE_OPEN_GRAPH_TYPE = "open_graph";
    public static final String TEMPLATE_TYPE = "template_type";
    public static final String TITLE = "title";
    public static final String URL = "url";
    public static final String WEBVIEW_RATIO = "webview_height_ratio";
    public static final String WEBVIEW_RATIO_COMPACT = "compact";
    public static final String WEBVIEW_RATIO_FULL = "full";
    public static final String WEBVIEW_RATIO_TALL = "tall";
    public static final String WEBVIEW_SHARE_BUTTON = "webview_share_button";

    public static void addGenericTemplateContent(Bundle bundle, ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            addGenericTemplateElementForPreview(bundle, shareMessengerGenericTemplateContent.getGenericTemplateElement());
            Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeGenericTemplateContent(shareMessengerGenericTemplateContent));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    public static void addOpenGraphMusicTemplateContent(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            addOpenGraphMusicTemplateContentForPreview(bundle, shareMessengerOpenGraphMusicTemplateContent);
            Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeOpenGraphMusicTemplateContent(shareMessengerOpenGraphMusicTemplateContent));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    public static void addMediaTemplateContent(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            addMediaTemplateContentForPreview(bundle, shareMessengerMediaTemplateContent);
            Utility.putJSONValueInBundle(bundle, ShareConstants.MESSENGER_PLATFORM_CONTENT, serializeMediaTemplateContent(shareMessengerMediaTemplateContent));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    private static void addGenericTemplateElementForPreview(Bundle bundle, ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            if (shareMessengerGenericTemplateElement.getButton() != null) {
                addActionButton(bundle, shareMessengerGenericTemplateElement.getButton(), false);
            } else if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
                addActionButton(bundle, shareMessengerGenericTemplateElement.getDefaultAction(), true);
            }
            Utility.putUri(bundle, ShareConstants.IMAGE_URL, shareMessengerGenericTemplateElement.getImageUrl());
            Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_DEFAULT);
            Utility.putNonEmptyString(bundle, ShareConstants.TITLE, shareMessengerGenericTemplateElement.getTitle());
            Utility.putNonEmptyString(bundle, ShareConstants.SUBTITLE, shareMessengerGenericTemplateElement.getSubtitle());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    private static void addOpenGraphMusicTemplateContentForPreview(Bundle bundle, ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            addActionButton(bundle, shareMessengerOpenGraphMusicTemplateContent.getButton(), false);
            Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_OPEN_GRAPH);
            Utility.putUri(bundle, ShareConstants.OPEN_GRAPH_URL, shareMessengerOpenGraphMusicTemplateContent.getUrl());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    private static void addMediaTemplateContentForPreview(Bundle bundle, ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            addActionButton(bundle, shareMessengerMediaTemplateContent.getButton(), false);
            Utility.putNonEmptyString(bundle, ShareConstants.PREVIEW_TYPE, PREVIEW_DEFAULT);
            Utility.putNonEmptyString(bundle, ShareConstants.ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId());
            if (shareMessengerMediaTemplateContent.getMediaUrl() != null) {
                Utility.putUri(bundle, getMediaUrlKey(shareMessengerMediaTemplateContent.getMediaUrl()), shareMessengerMediaTemplateContent.getMediaUrl());
            }
            Utility.putNonEmptyString(bundle, "type", getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    private static void addActionButton(Bundle bundle, ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class) || shareMessengerActionButton == null) {
            return;
        }
        try {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                addURLActionButton(bundle, (ShareMessengerURLActionButton) shareMessengerActionButton, z);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    private static void addURLActionButton(Bundle bundle, ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        String str;
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return;
        }
        try {
            if (z) {
                str = Utility.getUriString(shareMessengerURLActionButton.getUrl());
            } else {
                str = shareMessengerURLActionButton.getTitle() + " - " + Utility.getUriString(shareMessengerURLActionButton.getUrl());
            }
            Utility.putNonEmptyString(bundle, ShareConstants.TARGET_DISPLAY, str);
            Utility.putUri(bundle, ShareConstants.ITEM_URL, shareMessengerURLActionButton.getUrl());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
        }
    }

    private static JSONObject serializeGenericTemplateContent(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            return new JSONObject().put(ATTACHMENT, new JSONObject().put("type", "template").put("payload", new JSONObject().put(TEMPLATE_TYPE, TEMPLATE_GENERIC_TYPE).put(SHARABLE, shareMessengerGenericTemplateContent.getIsSharable()).put(IMAGE_ASPECT_RATIO, getImageRatioString(shareMessengerGenericTemplateContent.getImageAspectRatio())).put(ELEMENTS, new JSONArray().put(serializeGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement())))));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeOpenGraphMusicTemplateContent(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            return new JSONObject().put(ATTACHMENT, new JSONObject().put("type", "template").put("payload", new JSONObject().put(TEMPLATE_TYPE, "open_graph").put(ELEMENTS, new JSONArray().put(serializeOpenGraphMusicTemplateElement(shareMessengerOpenGraphMusicTemplateContent)))));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeMediaTemplateContent(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            return new JSONObject().put(ATTACHMENT, new JSONObject().put("type", "template").put("payload", new JSONObject().put(TEMPLATE_TYPE, "media").put(ELEMENTS, new JSONArray().put(serializeMediaTemplateElement(shareMessengerMediaTemplateContent)))));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("title", shareMessengerGenericTemplateElement.getTitle()).put("subtitle", shareMessengerGenericTemplateElement.getSubtitle()).put(IMAGE_URL, Utility.getUriString(shareMessengerGenericTemplateElement.getImageUrl()));
            if (shareMessengerGenericTemplateElement.getButton() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(serializeActionButton(shareMessengerGenericTemplateElement.getButton()));
                put.put(BUTTONS, jSONArray);
            }
            if (shareMessengerGenericTemplateElement.getDefaultAction() != null) {
                put.put(DEFAULT_ACTION, serializeActionButton(shareMessengerGenericTemplateElement.getDefaultAction(), true));
            }
            return put;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeOpenGraphMusicTemplateElement(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put("url", Utility.getUriString(shareMessengerOpenGraphMusicTemplateContent.getUrl()));
            if (shareMessengerOpenGraphMusicTemplateContent.getButton() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(serializeActionButton(shareMessengerOpenGraphMusicTemplateContent.getButton()));
                put.put(BUTTONS, jSONArray);
            }
            return put;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeMediaTemplateElement(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            JSONObject put = new JSONObject().put(ATTACHMENT_ID, shareMessengerMediaTemplateContent.getAttachmentId()).put("url", Utility.getUriString(shareMessengerMediaTemplateContent.getMediaUrl())).put(MEDIA_TYPE, getMediaType(shareMessengerMediaTemplateContent.getMediaType()));
            if (shareMessengerMediaTemplateContent.getButton() != null) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(serializeActionButton(shareMessengerMediaTemplateContent.getButton()));
                put.put(BUTTONS, jSONArray);
            }
            return put;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            return serializeActionButton(shareMessengerActionButton, false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeActionButton(ShareMessengerActionButton shareMessengerActionButton, boolean z) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            if (shareMessengerActionButton instanceof ShareMessengerURLActionButton) {
                return serializeURLActionButton((ShareMessengerURLActionButton) shareMessengerActionButton, z);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static JSONObject serializeURLActionButton(ShareMessengerURLActionButton shareMessengerURLActionButton, boolean z) throws JSONException {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            return new JSONObject().put("type", BUTTON_URL_TYPE).put("title", z ? null : shareMessengerURLActionButton.getTitle()).put("url", Utility.getUriString(shareMessengerURLActionButton.getUrl())).put(WEBVIEW_RATIO, getWebviewHeightRatioString(shareMessengerURLActionButton.getWebviewHeightRatio())).put(MESSENGER_EXTENSIONS, shareMessengerURLActionButton.getIsMessengerExtensionURL()).put(FALLBACK_URL, Utility.getUriString(shareMessengerURLActionButton.getFallbackUrl())).put(WEBVIEW_SHARE_BUTTON, getShouldHideShareButton(shareMessengerURLActionButton));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static String getMediaUrlKey(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            String host = uri.getHost();
            if (!Utility.isNullOrEmpty(host)) {
                if (FACEBOOK_DOMAIN.matcher(host).matches()) {
                    return ShareConstants.MEDIA_URI;
                }
            }
            return ShareConstants.IMAGE_URL;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static String getWebviewHeightRatioString(ShareMessengerURLActionButton.WebviewHeightRatio webviewHeightRatio) {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        if (webviewHeightRatio == null) {
            return WEBVIEW_RATIO_FULL;
        }
        try {
            int i = C22061.f2770x92e77847[webviewHeightRatio.ordinal()];
            return i != 1 ? i != 2 ? WEBVIEW_RATIO_FULL : WEBVIEW_RATIO_TALL : WEBVIEW_RATIO_COMPACT;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static String getImageRatioString(ShareMessengerGenericTemplateContent.ImageAspectRatio imageAspectRatio) {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        if (imageAspectRatio == null) {
            return IMAGE_RATIO_HORIZONTAL;
        }
        try {
            return C22061.f2768xb7309c05[imageAspectRatio.ordinal()] != 1 ? IMAGE_RATIO_HORIZONTAL : IMAGE_RATIO_SQUARE;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.share.internal.MessengerShareContentUtility$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C22061 {

        /* renamed from: $SwitchMap$com$facebook$share$model$ShareMessengerGenericTemplateContent$ImageAspectRatio */
        static final /* synthetic */ int[] f2768xb7309c05;

        /* renamed from: $SwitchMap$com$facebook$share$model$ShareMessengerMediaTemplateContent$MediaType */
        static final /* synthetic */ int[] f2769x2a75e664;

        /* renamed from: $SwitchMap$com$facebook$share$model$ShareMessengerURLActionButton$WebviewHeightRatio */
        static final /* synthetic */ int[] f2770x92e77847;

        static {
            int[] iArr = new int[ShareMessengerMediaTemplateContent.MediaType.values().length];
            f2769x2a75e664 = iArr;
            try {
                iArr[ShareMessengerMediaTemplateContent.MediaType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[ShareMessengerGenericTemplateContent.ImageAspectRatio.values().length];
            f2768xb7309c05 = iArr2;
            try {
                iArr2[ShareMessengerGenericTemplateContent.ImageAspectRatio.SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr3 = new int[ShareMessengerURLActionButton.WebviewHeightRatio.values().length];
            f2770x92e77847 = iArr3;
            try {
                iArr3[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioCompact.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2770x92e77847[ShareMessengerURLActionButton.WebviewHeightRatio.WebviewHeightRatioTall.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static String getMediaType(ShareMessengerMediaTemplateContent.MediaType mediaType) {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        if (mediaType == null) {
            return "image";
        }
        try {
            return C22061.f2769x2a75e664[mediaType.ordinal()] != 1 ? "image" : "video";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }

    private static String getShouldHideShareButton(ShareMessengerURLActionButton shareMessengerURLActionButton) {
        if (CrashShieldHandler.isObjectCrashing(MessengerShareContentUtility.class)) {
            return null;
        }
        try {
            if (shareMessengerURLActionButton.getShouldHideWebviewShareButton()) {
                return SHARE_BUTTON_HIDE;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MessengerShareContentUtility.class);
            return null;
        }
    }
}
