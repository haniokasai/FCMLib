package jp.mirm.fcmlib;

import jp.mirm.fcmlib.core.http.Http;
import jp.mirm.fcmlib.core.http.PostHeader;
import jp.mirm.fcmlib.entity.Notification;
import jp.mirm.fcmlib.entity.URLHolder;

import java.io.IOException;

public class NotificationSender {

    private static String authKey;

    public static void init(String authKey) {
        NotificationSender.authKey = authKey;
    }

    public static String sendNotification(Notification notification) {
        try {
            PostHeader header = new PostHeader()
                    .setContentType("application/json")
                    .setAuthorization("key=" + authKey);

            return Http.post(URLHolder.FCM_SEND_URL, header, notification.encode());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sendNotificationToAll(Notification notification) {
        try {
            PostHeader header = new PostHeader()
                    .setContentType("application/json")
                    .setAuthorization("key=" + authKey);

            return Http.post(URLHolder.FCM_SEND_URL, header, notification.encode());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
