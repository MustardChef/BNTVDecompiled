package com.facebook;

/* loaded from: classes.dex */
public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        GraphResponse graphResponse = this.graphResponse;
        FacebookRequestError error = graphResponse != null ? graphResponse.getError() : null;
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (error != null) {
            sb.append("httpResponseCode: ");
            sb.append(error.getRequestStatusCode());
            sb.append(", facebookErrorCode: ");
            sb.append(error.getErrorCode());
            sb.append(", facebookErrorType: ");
            sb.append(error.getErrorType());
            sb.append(", message: ");
            sb.append(error.getErrorMessage());
            sb.append("}");
        }
        return sb.toString();
    }
}
