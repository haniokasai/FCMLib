package jp.mirm.fcmlib.entity;

import java.net.MalformedURLException;
import java.net.URL;

public class URLHolder {

    public static URL FCM_SEND_URL;

    static {
        try {
            FCM_SEND_URL = new URL("https://fcm.googleapis.com/fcm/send");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
