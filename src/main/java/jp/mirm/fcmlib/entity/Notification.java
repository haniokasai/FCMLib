package jp.mirm.fcmlib.entity;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Notification {

    private String token;

    private String title;
    private String message;
    private String sound = "default";

    private String priority= "high";

    private Map<String, Object> advancedData;

    @Deprecated
    public Notification() {
        this("/topics/user");
    }

    /**
     * @param token Device token or Topic name (like "/topics/user")
     */
    public Notification(String token) {
        this.token = token;
    }

    public Notification setTitle(String title) {
        this.title = title;
        return this;
    }

    public Notification setMessage(String message) {
        this.message = message;
        return this;
    }

    public Notification setSound(String sound) {
        this.sound = sound;
        return this;
    }

    public Notification setAdvancedData(Map<String, Object> advancedData) {
        this.advancedData = advancedData;
        return this;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getSound() {
        return sound;
    }

    public String getPriority() {
        return priority;
    }

    public Map<String, Object> getAdvancedData() {
        return advancedData;
    }

    public String encode() {
        Map<String, Object> bodyData = new HashMap<>();
        bodyData.put("title", title);
        bodyData.put("body", message);
        bodyData.put("sound", sound);

        if (advancedData != null) {
            advancedData.entrySet().forEach(entry -> {
                bodyData.put(entry.getKey(), entry.getValue());
            });
        }

        Map<String, Object> sendData = new HashMap<>();
        sendData.put("to", token);
        sendData.put("data", bodyData);
        sendData.put("priority", priority);

        return new Gson().toJson(sendData);
    }

}
