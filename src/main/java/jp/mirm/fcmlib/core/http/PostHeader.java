package jp.mirm.fcmlib.core.http;

public class PostHeader {

    private String contentType;
    private String authorization;
    private String requestMethod;
    private boolean doOutput;

    public PostHeader() {
        requestMethod = "POST";
        doOutput = true;
    }

    public PostHeader setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public PostHeader setAuthorization(String authorization) {
        this.authorization = authorization;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public boolean isDoOutput() {
        return doOutput;
    }

}
