package com.facebook;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ShareGraphRequest {
    public static GraphRequest createOpenGraphObject(ShareOpenGraphObject shareOpenGraphObject) throws FacebookException {
        String string = shareOpenGraphObject.getString("type");
        if (string == null) {
            string = shareOpenGraphObject.getString("og:type");
        }
        if (string == null) {
            throw new FacebookException("Open graph object type cannot be null");
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("object", ((JSONObject) OpenGraphJSONUtility.toJSONValue(shareOpenGraphObject, new OpenGraphJSONUtility.PhotoJSONProcessor() { // from class: com.facebook.ShareGraphRequest.1
                @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
                public JSONObject toJSONObject(SharePhoto sharePhoto) {
                    Uri imageUrl = sharePhoto.getImageUrl();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("url", imageUrl.toString());
                        return jSONObject;
                    } catch (Exception e) {
                        throw new FacebookException("Unable to attach images", e);
                    }
                }
            })).toString());
            Locale locale = Locale.ROOT;
            return new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(locale, "%s/%s", "me", "objects/" + string), bundle, HttpMethod.POST);
        } catch (JSONException e) {
            throw new FacebookException(e.getMessage());
        }
    }
}
